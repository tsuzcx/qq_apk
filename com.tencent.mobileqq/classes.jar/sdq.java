import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class sdq
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private bety jdField_a_of_type_Bety;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private yqz jdField_a_of_type_Yqz;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  private String f = "";
  
  public sdq(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_Yqz == null)
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
    this.jdField_b_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914);
    this.jdField_c_of_type_JavaLangString = "";
    paramActivity = new DisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramActivity);
    this.jdField_d_of_type_Int = paramActivity.widthPixels;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToWechatCircle!");
    }
    int i = a();
    if (i != -1)
    {
      ybk.a(0, i);
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        a(this.jdField_a_of_type_Yqz, this.jdField_a_of_type_Boolean, paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("", 1, "shareScreenShotToWeChat, isTimeline=" + paramBoolean + "e=" + localException.toString());
      return;
    }
    QLog.e("", 1, "shareScreenShotToWeChat, mScreenshotWithQRPath is Empty");
  }
  
  @VisibleForTesting
  protected int a()
  {
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131721491;
    }
    while (WXShareHelper.a().b()) {
      return i;
    }
    return 2131721492;
  }
  
  public Bitmap a(String paramString)
  {
    paramString = sdp.a(paramString, this.jdField_d_of_type_Int, this.jdField_c_of_type_JavaLangString, "QRCode_");
    this.jdField_a_of_type_JavaLangString = ((String)paramString.first);
    paramString = (Bitmap)paramString.second;
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_Boolean = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int > 0)) {}
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return paramString;
    case 1: 
      c();
      return paramString;
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotShareHelper.2(this));
      return paramString;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotShareHelper.3(this));
    return paramString;
  }
  
  public bety a()
  {
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bety.c(2131694219);
    }
    return this.jdField_a_of_type_Bety;
  }
  
  public ShareActionSheetBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  }
  
  public String a()
  {
    String str2 = BaseApplicationImpl.getApplication().getString(2131720015);
    String str1 = str2;
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        int i = this.jdField_a_of_type_OrgJsonJSONArray.length();
        i = new Random().nextInt(i);
        str1 = this.jdField_a_of_type_OrgJsonJSONArray.getString(i);
      }
      return str1;
    }
    catch (Exception localException)
    {
      do
      {
        str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.d("", 2, "actionSheet.show exception=" + localException);
    }
    return str2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yqz != null) {
      this.jdField_a_of_type_Yqz.b();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  @VisibleForTesting
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      WxShareHelperFromReadInjoy.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt2, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      return;
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt2, false);
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.contains("ShotCache_"))) {
      this.jdField_c_of_type_Int = 3;
    }
    if ((this.jdField_c_of_type_Int == 0) && (paramInt > 0)) {
      this.jdField_c_of_type_Int = paramInt;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "doOnPhotoPlusActivityEditResult->mScreenshotFromType:" + this.jdField_c_of_type_Int + ", mEditScreenshotPath:" + this.jdField_b_of_type_JavaLangString + ", originImagePath:" + paramString2);
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      d(this.jdField_b_of_type_JavaLangString);
      return;
    }
    b();
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
  }
  
  protected void a(yqz paramyqz, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      paramyqz.d(new sdr(this, paramBoolean2));
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      f();
      return;
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696873);
    localActionSheetItem.icon = 2130838917;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696886);
    localActionSheetItem.icon = 2130838918;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696893);
    localActionSheetItem.icon = 2130838921;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696876);
    localActionSheetItem.icon = 2130838915;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696890);
    localActionSheetItem.icon = 2130838920;
    localActionSheetItem.action = 12;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "showShareActionSheet->mEditScreenshotPath:" + this.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
    }
    if ((syb.b(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(a()))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        if (QLog.isDevelopLevel()) {
          QLog.d("", 2, "showShareActionSheet->post runnable generate screenshot with QRcode! time:" + System.currentTimeMillis());
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        ThreadManager.executeOnSubThread(new ScreenShotShareHelper.1(this));
        return;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getContext().getString(2131720052));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "actionSheet.show exception=" + localException);
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    if (this.jdField_c_of_type_JavaLangString != null) {
      return this.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQZone!");
    }
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bjea localbjea = bjea.a();
      localbjea.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      bjdt.a(this.jdField_a_of_type_AndroidAppActivity, localbjea, this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131721479), "", -1);
      return;
    }
    this.jdField_a_of_type_Int = 1;
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695751, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public void d()
  {
    a(false);
  }
  
  public void d(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQQ->imgPath:" + paramString);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    localIntent.putExtra("req_share_id", 1478164480L);
    localIntent.putExtra("image_url", paramString);
    localIntent.putExtra("forward_type", -3);
    String str;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      paramString = this.jdField_c_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.f)) {
        break label285;
      }
      str = BaseApplicationImpl.getContext().getResources().getString(2131695749);
      label115:
      paramString = "ScreenShotShare|" + paramString + "|" + str;
      if (this.jdField_c_of_type_Int != 3) {
        break label293;
      }
    }
    label285:
    label293:
    for (paramString = paramString.concat("|1");; paramString = paramString.concat("|0"))
    {
      localIntent.putExtra("struct_share_key_content_action_DATA", paramString);
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("req_type", 5);
      localIntent.putExtra("brief_key", alud.a(2131713973));
      localIntent.putExtra("struct_share_key_source_icon", "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
      localIntent.putExtra("struct_share_key_source_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localIntent.putExtra("stuctmsg_bytes", azvd.a(localIntent.getExtras()).getBytes());
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1);
      return;
      paramString = this.jdField_d_of_type_JavaLangString;
      break;
      str = this.f;
      break label115;
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public void e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  @VisibleForTesting
  protected void f()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695751, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina start!");
    }
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bety.c(2131694219);
    }
    this.jdField_a_of_type_Bety.show();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "shareMsgToSina installSinaWeibo:true");
        }
        if (!TextUtils.isEmpty(this.f)) {
          continue;
        }
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131695749);
        this.e = ((String)localObject);
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          continue;
        }
        localObject = this.jdField_c_of_type_JavaLangString;
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", this.e + (String)localObject);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_b_of_type_JavaLangString)));
        }
        localIntent.setPackage(localApplicationInfo.packageName);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
          this.jdField_a_of_type_Bety.dismiss();
        }
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "shareMsgToSina start weibo!");
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("", 2, "shareMsgToSina installSinaWeibo:false");
        if ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
          continue;
        }
        this.jdField_a_of_type_Bety.dismiss();
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695759, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "shareMsgToSina end!");
      }
      return;
      localObject = this.f;
      continue;
      localObject = this.jdField_d_of_type_JavaLangString;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject = paramView.getTag();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "onScreenShotItemClick->tag null!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((bdmy)localObject).a.action)
      {
      }
      while (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null)
      {
        this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        d(this.jdField_b_of_type_JavaLangString);
        continue;
        c();
        continue;
        d();
        continue;
        e();
        continue;
        g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sdq
 * JD-Core Version:    0.7.0.1
 */