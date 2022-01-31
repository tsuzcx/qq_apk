package dov.com.tencent.mobileqq.richmedia.capture.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anux;
import anuy;
import anvc;
import anvd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.mobileqq.transfile.QIMWebVideoUploader;
import com.tencent.mobileqq.transfile.QIMWebVideoUploader.IQIMWebVideoUpCallback;
import com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame;
import com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;
import dov.com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet.ActionSheetItemViewHolder;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class EditWebDanceMachineVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, QIMWebVideoUploader.IQIMWebVideoUpCallback, QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback
{
  public static int a;
  private long jdField_a_of_type_Long = -1L;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QIMWebVideoUploader jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  public ShareActionSheet a;
  private String jdField_a_of_type_JavaLangString = "http://qvq.qq.com/dancing/share.html";
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "?_wv=16777217&_wwv=12&firsttab=102&secondtab=%s&itemid=%s&uuid=%s&md5=%s&uin=%s&nick=%s&score=%s&percent=%s&_wv=16778243&_bid=2932";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "https://dov.qq.com/activity/shake-head/share.html?_wv=1&_wwv=4";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "&firsttab=102&secondtab=%s&itemid=%s&uuid=%s&md5=%s&shareType=%s";
  private boolean jdField_d_of_type_Boolean;
  private int e = -1;
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString = "http://dov.qq.com/activity/daily-fortune/share.html?_wv=1&_wwv=4";
  private String g = "&md5=%s&uuid=%s&shareType=%s";
  private String h = "http://dov.qq.com/activity/fools-day/share.html?_wv=1&_wwv=4";
  private String i = "&md5=%s&uuid=%s&shareType=%s";
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  private int a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "shareMsgToSina installSinaWeibo:true");
      }
      if ((paramString3 == null) || (!new File(paramString3).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "shareMsgToSina Thumb Path Invalid");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "shareMsgToSina path:" + paramString3);
        }
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", paramString1 + paramString2);
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString3)));
        localIntent.setPackage(((ApplicationInfo)localObject).packageName);
        BaseApplicationImpl.getApplication().startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "shareMsgToSina start weibo!");
        }
        return 0;
      }
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "shareMsgToSina installSinaWeibo:false");
      }
      return -2;
    }
    return -1;
  }
  
  private String a()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return "无乐不作，尽在DOV";
    }
    return "今天，我们都是灵魂舞者！";
  }
  
  private String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean) {
      return b();
    }
    if (this.jdField_c_of_type_Boolean) {
      return c();
    }
    if (this.jdField_d_of_type_Boolean) {
      return d();
    }
    if (paramInt2 == 0) {}
    for (String str = "#DOV高能舞蹈教室#【" + paramString1 + "级】"; "S".equals(paramString1); str = "[DOV高能舞室]") {
      return str + paramString2 + " " + paramInt1 + "分! 炸翻全场，你们能看清我的舞步吗？";
    }
    if ("A".equals(paramString1)) {
      return str + paramString2 + " " + paramInt1 + "分! 可以说是世间尬舞奇才了。";
    }
    if ("B".equals(paramString1)) {
      return str + paramString2 + " " + paramInt1 + "分! 用这段视频证明我是真正的灵魂舞者。";
    }
    if ("C".equals(paramString1)) {
      return str + paramString2 + " " + paramInt1 + "分! 老师慢点，这舞我快跟不上了。";
    }
    return str + "老师慢点，这舞我快跟不上了。";
  }
  
  private void a(int paramInt)
  {
    String str = "";
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
      str = ((EditTakeVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_b_of_type_JavaLangString;
    }
    new anvd(this, this, str, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), paramInt, getAppInterface(), this).execute(new Void[0]);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        d();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624515);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381));
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = true;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.q))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.n))
        {
          this.q = (this.jdField_c_of_type_JavaLangString + String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.r, this.s, this.n, this.o, String.valueOf(this.e) }));
          bool1 = true;
        }
      }
    }
    do
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "hasShare : " + bool1 + " shareUrl : " + this.q + " uuid : " + this.n);
        }
        return bool1;
        if (this.jdField_c_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.q))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.n))
            {
              this.q = (this.jdField_f_of_type_JavaLangString + String.format(this.g, new Object[] { this.o, this.n, String.valueOf(this.e) }));
              bool1 = true;
            }
          }
        }
        else
        {
          if (!this.jdField_d_of_type_Boolean) {
            break;
          }
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.q))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.n))
            {
              this.q = (this.h + String.format(this.i, new Object[] { this.o, this.n, String.valueOf(this.e) }));
              bool1 = true;
            }
          }
        }
      }
    } while ((!TextUtils.isEmpty(this.q)) && (!TextUtils.isEmpty(this.n)));
    for (;;)
    {
      bool1 = false;
    }
  }
  
  private List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131432987);
    localActionSheetItem.jdField_b_of_type_Int = 2130845415;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430109);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_c_of_type_Int = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430110);
    localActionSheetItem.jdField_b_of_type_Int = 2130838330;
    localActionSheetItem.jdField_c_of_type_Int = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    paramContext = new ShareActionSheetBuilder.ActionSheetItem();
    paramContext.jdField_a_of_type_JavaLangString = "新浪微博";
    paramContext.jdField_a_of_type_Boolean = true;
    paramContext.jdField_b_of_type_Int = 2130838335;
    paramContext.jdField_c_of_type_Int = 12;
    paramContext.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(paramContext);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private String b()
  {
    return "我在DOV集到了" + this.jdField_c_of_type_Int + "个福气。新春新玩法，快来挑战我吧!";
  }
  
  private void b(int paramInt)
  {
    if ((TextUtils.isEmpty(this.q)) || (TextUtils.isEmpty(this.p))) {
      return;
    }
    QIMReadWriteReportItem localQIMReadWriteReportItem = new QIMReadWriteReportItem();
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      localQIMReadWriteReportItem.jdField_d_of_type_JavaLangString = "0X800903E";
      if (paramInt != 0) {
        break label90;
      }
      localQIMReadWriteReportItem.h = String.valueOf(4);
    }
    for (;;)
    {
      QIMReportController.b(null, localQIMReadWriteReportItem);
      ThreadManager.executeOnSubThread(new anuy(this, paramInt));
      return;
      localQIMReadWriteReportItem.jdField_d_of_type_JavaLangString = "0X8008FB3";
      break;
      label90:
      if (paramInt == 1) {
        localQIMReadWriteReportItem.h = String.valueOf(2);
      } else if (paramInt == 2) {
        localQIMReadWriteReportItem.h = String.valueOf(3);
      }
    }
  }
  
  private String c()
  {
    return "【DOV神预测】快来看看" + getAppInterface().getCurrentNickname() + "的今日运势！";
  }
  
  private void c()
  {
    Object localObject = getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if (localObject != null)
    {
      localObject = ((EditVideoParams)localObject).jdField_a_of_type_AndroidOsBundle;
      if (localObject != null)
      {
        this.j = ((Bundle)localObject).getString("dance_machine_score_rate");
        this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("dance_machine_score", 0);
        this.k = ((Bundle)localObject).getString("dance_machine_ptv_category");
        this.l = ((Bundle)localObject).getString("dance_machine_ptv_id");
        this.m = ((Bundle)localObject).getString("over_percent");
        String str = ((Bundle)localObject).getString("web_share_url");
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaLangString = str;
        }
        this.jdField_b_of_type_Boolean = ((Bundle)localObject).getBoolean("shook_head_count");
        this.jdField_c_of_type_Int = ((Bundle)localObject).getInt("shook_head_count_value");
        this.jdField_c_of_type_Boolean = ((Bundle)localObject).getBoolean("random_fortune");
        this.jdField_d_of_type_Boolean = ((Bundle)localObject).getBoolean("fools_day");
        if (QLog.isColorLevel()) {
          QLog.i("DANCE_MACHINE_SHARE_TAG", 2, "shookHead count:" + this.jdField_c_of_type_Int + ", shookheadCount:" + this.jdField_c_of_type_Int);
        }
      }
    }
  }
  
  private void c(int paramInt, String paramString)
  {
    d();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(-1);
    runOnUiThread(new anux(this));
    if (QLog.isColorLevel()) {
      QLog.e("DANCE_MACHINE_SHARE_TAG", 2, "upload failed, error code is " + paramInt + " error description : " + paramString);
    }
  }
  
  private String d()
  {
    return "2018年最囧新闻新鲜出炉，笑点低的请尽快撤离……";
  }
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a()
  {
    d();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(-1);
    if (this.jdField_a_of_type_Long != -1L) {
      this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[DanceMachine Share] new  uuid : " + this.n + "  md5 : " + this.o + "  thumbPath : " + this.p);
    }
    String str1 = "";
    String str3 = "";
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.k)) {
          str1 = URLEncoder.encode(this.k, "UTF-8");
        }
        if (!TextUtils.isEmpty(this.l)) {
          str3 = URLEncoder.encode(this.l, "UTF-8");
        }
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[DanceMachine Share] encodedCategory : " + str1 + "  encodedPtvId : " + str3);
        }
        this.r = str1;
        this.s = str3;
        if (this.jdField_b_of_type_Boolean)
        {
          str3 = this.jdField_c_of_type_JavaLangString + String.format(this.jdField_d_of_type_JavaLangString, new Object[] { str1, str3, this.n, this.o, String.valueOf(this.e) });
          str1 = b();
          this.q = str3;
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[DanceMachine Share] share  uuid : " + this.n + "  md5 : " + this.o + "  thumbPath : " + this.p + "  shareUrl : " + str3 + "  shareStr : " + str1);
          }
          b(this.jdField_d_of_type_Int);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str2;
      if (this.jdField_c_of_type_Boolean)
      {
        str3 = this.jdField_f_of_type_JavaLangString + String.format(this.g, new Object[] { this.o, this.n, String.valueOf(this.e) });
        str2 = c();
      }
      else if (this.jdField_d_of_type_Boolean)
      {
        str3 = this.h + String.format(this.i, new Object[] { this.o, this.n, String.valueOf(this.e) });
        str2 = d();
      }
      else
      {
        str3 = this.jdField_a_of_type_JavaLangString + String.format(this.jdField_b_of_type_JavaLangString, new Object[] { str2, str3, this.n, this.o, getAppInterface().getCurrentAccountUin(), getAppInterface().getCurrentNickname(), this.jdField_b_of_type_Int + "", this.m });
        str2 = a(this.jdField_b_of_type_Int, this.j, getAppInterface().getCurrentNickname(), this.jdField_d_of_type_Int);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "video upload fail");
    }
    c(paramInt, paramString);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = new anvc(this);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "pic upload fail");
    }
    c(paramInt, paramString);
  }
  
  public void c_(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "video upload success, uuid : " + paramString);
    }
    this.n = paramString;
    new QIMWebVideoUploaderFirstFrame(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.p, this.jdField_a_of_type_ArrayOfByte, FlowCameraConstant.jdField_b_of_type_Int, paramString).a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c(0);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null)
    {
      finish();
      return true;
    }
    c();
    paramBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().findViewById(2131364326);
    ((ViewGroup)paramBundle.getParent()).removeView(paramBundle);
    paramBundle = (RelativeLayout)findViewById(2131364435);
    Object localObject = paramBundle.getLayoutParams();
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    ((ViewGroup.LayoutParams)localObject).height = ScreenUtil.a(73.0F);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((ViewGroup)paramBundle.getParent()).addView(localRelativeLayout);
    paramBundle = new GradientDrawable();
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      paramBundle.setColor(Color.parseColor("#ffc426"));
      paramBundle.setCornerRadius(8.0F);
      paramBundle.setStroke(0, Color.parseColor("#12B7F5"));
      localObject = new FadedButton(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      int i1 = ScreenUtil.a(15.0F);
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
      localLayoutParams.leftMargin = i1;
      localLayoutParams.rightMargin = i1;
      ((FadedButton)localObject).setLayoutParams(localLayoutParams);
      ((FadedButton)localObject).setBackgroundDrawable(paramBundle);
      ((FadedButton)localObject).setTextSize(1, 18.0F);
      ((FadedButton)localObject).setTextColor(-1);
      if (!this.jdField_b_of_type_Boolean) {
        break label370;
      }
    }
    label370:
    for (paramBundle = "立即分享";; paramBundle = "分享给好友")
    {
      ((FadedButton)localObject).setText(paramBundle);
      ((FadedButton)localObject).setGravity(17);
      ((FadedButton)localObject).setOnClickListener(this);
      localRelativeLayout.addView((View)localObject);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet = new ShareActionSheet(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet.a(a(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet.a(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet.a(getString(2131433083));
      return true;
      paramBundle.setColor(Color.parseColor("#12B7F5"));
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.p)) {
      FileUtils.a(new File(this.p).getParent());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    if ((jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null))
    {
      String str = new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()).getParent();
      if (str != null) {
        FileUtils.a(str);
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((RelativeLayout)findViewById(2131364435)).setVisibility(8);
    ((Button)findViewById(2131364436)).setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      DoodleLayout localDoodleLayout = (DoodleLayout)findViewById(2131362953);
      if ((localDoodleLayout != null) && (localDoodleLayout.a != null)) {
        localDoodleLayout.a.setPreventTouch(true);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader.a();
    d();
    QQToast.a(this, 1, "上传失败", 0).a();
    return false;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet.a();
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      paramView = new QIMReadWriteReportItem();
      paramView.jdField_d_of_type_JavaLangString = "0X800903C";
      QIMReportController.b(null, paramView);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet.a().isShowing()) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewShareActionSheet.a().dismiss();
    }
    paramInt = ((ShareActionSheet.ActionSheetItemViewHolder)paramView.getTag()).a.jdField_c_of_type_Int;
    if ((paramInt == 9) || (paramInt == 10)) {
      if (!WXShareHelper.a().a()) {
        paramAdapterView = "你未安装微信客户端，无法分享。";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAdapterView))
      {
        jdField_a_of_type_Int = -1;
        QQToast.a(this, 1, paramAdapterView, 0).a();
        return;
        if (!WXShareHelper.a().b()) {
          paramAdapterView = "微信版本过低,无法分享";
        }
      }
      else
      {
        jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          return;
        case 2: 
          if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
          {
            paramAdapterView = new QIMReadWriteReportItem();
            paramAdapterView.jdField_d_of_type_JavaLangString = "0X800903E";
            paramAdapterView.h = String.valueOf(1);
            QIMReportController.b(null, paramAdapterView);
          }
          for (;;)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d();
            return;
            paramAdapterView = new QIMReadWriteReportItem();
            paramAdapterView.jdField_d_of_type_JavaLangString = "0X8008FB3";
            paramAdapterView.h = String.valueOf(1);
            QIMReportController.b(null, paramAdapterView);
          }
        case 9: 
          this.e = 1;
          if (a())
          {
            b(1);
            return;
          }
          a(1);
          return;
        case 10: 
          this.e = 2;
          if (a())
          {
            b(2);
            return;
          }
          a(2);
          return;
        }
        this.e = 0;
        if (a())
        {
          b(0);
          return;
        }
        a(0);
        return;
      }
      paramAdapterView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity
 * JD-Core Version:    0.7.0.1
 */