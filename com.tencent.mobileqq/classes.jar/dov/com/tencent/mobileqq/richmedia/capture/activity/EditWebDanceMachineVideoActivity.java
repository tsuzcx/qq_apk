package dov.com.tencent.mobileqq.richmedia.capture.activity;

import ajpx;
import alud;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azqo;
import azua;
import bavz;
import bawb;
import bawc;
import bawe;
import bdhb;
import bfah;
import bhsl;
import bhuf;
import bmnj;
import bmor;
import bnko;
import bnkp;
import bnnf;
import bnnj;
import bnsm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class EditWebDanceMachineVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, bawb, bawe
{
  public static int a;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bavz jdField_a_of_type_Bavz;
  private bfah jdField_a_of_type_Bfah;
  private bhsl jdField_a_of_type_Bhsl;
  public bnnf a;
  private String jdField_a_of_type_JavaLangString = "http://qvq.qq.com/dancing/share.html";
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
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
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_camera");
        localIntent.setPackage(((ApplicationInfo)localObject).packageName);
        FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getApplication(), localIntent);
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
      return alud.a(2131704344);
    }
    return alud.a(2131704333);
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
    for (String str = "#DOV高能舞蹈教室#【" + paramString1 + alud.a(2131704343); "S".equals(paramString1); str = "[DOV高能舞室]") {
      return str + paramString2 + " " + paramInt1 + alud.a(2131704349) + alud.a(2131704342);
    }
    if ("A".equals(paramString1)) {
      return str + paramString2 + " " + paramInt1 + alud.a(2131704340) + alud.a(2131704353);
    }
    if ("B".equals(paramString1)) {
      return str + paramString2 + " " + paramInt1 + alud.a(2131704331) + alud.a(2131704335);
    }
    if ("C".equals(paramString1)) {
      return str + paramString2 + " " + paramInt1 + alud.a(2131704350) + alud.a(2131704336);
    }
    return str + alud.a(2131704345);
  }
  
  private void a(int paramInt)
  {
    String str = "";
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
      str = ((EditTakeVideoSource)this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_b_of_type_JavaLangString;
    }
    new bnkp(this, this, str, this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), paramInt, getAppInterface(), this).execute(new Void[0]);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        g();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131755801);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894));
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
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131690192);
    localActionSheetItem.icon = 2130849157;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696893);
    localActionSheetItem.icon = 2130838921;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696876);
    localActionSheetItem.icon = 2130838915;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    paramContext = new ShareActionSheetBuilder.ActionSheetItem();
    paramContext.label = alud.a(2131704354);
    paramContext.iconNeedBg = true;
    paramContext.icon = 2130838920;
    paramContext.action = 12;
    paramContext.argus = "";
    localArrayList.add(paramContext);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private String b()
  {
    return "我在DOV集到了" + this.jdField_c_of_type_Int + alud.a(2131704347);
  }
  
  private String c()
  {
    return alud.a(2131704351) + getAppInterface().getCurrentNickname() + alud.a(2131704346);
  }
  
  private void c(int paramInt)
  {
    if ((TextUtils.isEmpty(this.q)) || (TextUtils.isEmpty(this.p))) {
      return;
    }
    azua localazua = new azua();
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      localazua.jdField_d_of_type_JavaLangString = "0X800903E";
      if (paramInt != 0) {
        break label90;
      }
      localazua.h = String.valueOf(4);
    }
    for (;;)
    {
      azqo.a(null, localazua);
      ThreadManager.executeOnSubThread(new EditWebDanceMachineVideoActivity.2(this, paramInt));
      return;
      localazua.jdField_d_of_type_JavaLangString = "0X8008FB3";
      break;
      label90:
      if (paramInt == 1) {
        localazua.h = String.valueOf(2);
      } else if (paramInt == 2) {
        localazua.h = String.valueOf(3);
      }
    }
  }
  
  private void c(int paramInt, String paramString)
  {
    g();
    this.jdField_a_of_type_Bhsl.removeMessages(-1);
    runOnUiThread(new EditWebDanceMachineVideoActivity.1(this));
    if (QLog.isColorLevel()) {
      QLog.e("DANCE_MACHINE_SHARE_TAG", 2, "upload failed, error code is " + paramInt + " error description : " + paramString);
    }
  }
  
  private String d()
  {
    return alud.a(2131704352);
  }
  
  private void f()
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
  
  private void g()
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
    g();
    this.jdField_a_of_type_Bhsl.removeMessages(-1);
    if (this.jdField_b_of_type_Long != -1L) {
      this.jdField_b_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
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
          c(this.jdField_d_of_type_Int);
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
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "video upload success, uuid : " + paramString);
    }
    this.n = paramString;
    new bawc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.p, this.jdField_a_of_type_ArrayOfByte, ajpx.jdField_b_of_type_Int, paramString).a();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "pic upload fail");
    }
    c(paramInt, paramString);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bmnj == null) {
      this.jdField_a_of_type_Bmnj = new bnko(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bhsl = new bhsl(this);
    this.jdField_a_of_type_Bmnj.c(0);
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor == null)
    {
      finish();
      return true;
    }
    f();
    paramBundle = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.a().findViewById(2131373314);
    ((ViewGroup)paramBundle.getParent()).removeView(paramBundle);
    paramBundle = (RelativeLayout)findViewById(2131363824);
    Object localObject = paramBundle.getLayoutParams();
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    ((ViewGroup.LayoutParams)localObject).height = bnsm.a(73.0F);
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
      int i1 = bnsm.a(15.0F);
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
      localLayoutParams.leftMargin = i1;
      localLayoutParams.rightMargin = i1;
      ((FadedButton)localObject).setLayoutParams(localLayoutParams);
      ((FadedButton)localObject).setBackgroundDrawable(paramBundle);
      ((FadedButton)localObject).setTextSize(1, 18.0F);
      ((FadedButton)localObject).setTextColor(-1);
      if (!this.jdField_b_of_type_Boolean) {
        break label373;
      }
    }
    label373:
    for (paramBundle = alud.a(2131704355);; paramBundle = alud.a(2131704337))
    {
      ((FadedButton)localObject).setText(paramBundle);
      ((FadedButton)localObject).setGravity(17);
      ((FadedButton)localObject).setOnClickListener(this);
      localRelativeLayout.addView((View)localObject);
      this.jdField_a_of_type_Bnnf = new bnnf(this);
      this.jdField_a_of_type_Bnnf.a(a(this));
      this.jdField_a_of_type_Bnnf.a(this);
      this.jdField_a_of_type_Bnnf.a(getString(2131720052));
      return true;
      paramBundle.setColor(Color.parseColor("#12B7F5"));
      break;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.p)) {
      bdhb.a(new File(this.p).getParent());
    }
    if (this.jdField_a_of_type_Bfah != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_Bfah);
    }
    if ((jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null))
    {
      String str = new File(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()).getParent();
      if (str != null) {
        bdhb.a(str);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((RelativeLayout)findViewById(2131363824)).setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      DoodleLayout localDoodleLayout = (DoodleLayout)findViewById(2131365398);
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
    this.jdField_a_of_type_Bavz.a();
    g();
    QQToast.a(this, 1, alud.a(2131704338), 0).a();
    return false;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bnnf.a();
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      paramView = new azua();
      paramView.jdField_d_of_type_JavaLangString = "0X800903C";
      azqo.a(null, paramView);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Bnnf.a().isShowing()) {
      this.jdField_a_of_type_Bnnf.a().dismiss();
    }
    paramInt = ((bnnj)paramView.getTag()).a.action;
    if ((paramInt == 9) || (paramInt == 10)) {
      if (!WXShareHelper.a().a()) {
        paramAdapterView = alud.a(2131704329);
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
          paramAdapterView = alud.a(2131704341);
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
            paramAdapterView = new azua();
            paramAdapterView.jdField_d_of_type_JavaLangString = "0X800903E";
            paramAdapterView.h = String.valueOf(1);
            azqo.a(null, paramAdapterView);
          }
          for (;;)
          {
            this.jdField_a_of_type_Bmnj.d();
            return;
            paramAdapterView = new azua();
            paramAdapterView.jdField_d_of_type_JavaLangString = "0X8008FB3";
            paramAdapterView.h = String.valueOf(1);
            azqo.a(null, paramAdapterView);
          }
        case 9: 
          this.e = 1;
          if (a())
          {
            c(1);
            return;
          }
          a(1);
          return;
        case 10: 
          this.e = 2;
          if (a())
          {
            c(2);
            return;
          }
          a(2);
          return;
        }
        this.e = 0;
        if (a())
        {
          c(0);
          return;
        }
        a(0);
        return;
      }
      paramAdapterView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity
 * JD-Core Version:    0.7.0.1
 */