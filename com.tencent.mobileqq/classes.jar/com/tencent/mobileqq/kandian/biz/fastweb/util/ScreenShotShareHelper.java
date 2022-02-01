package com.tencent.mobileqq.kandian.biz.fastweb.util;

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
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class ScreenShotShareHelper
  implements Handler.Callback, AdapterView.OnItemClickListener, IScreenShotShareHelper
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString = null;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = null;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  private String f = "";
  
  public ScreenShotShareHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    this.jdField_b_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168);
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
      QRUtils.a(0, i);
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_Boolean, paramBoolean);
        return;
      }
      QLog.e("", 1, "shareScreenShotToWeChat, mScreenshotWithQRPath is Empty");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareScreenShotToWeChat, isTimeline=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("e=");
      localStringBuilder.append(localException.toString());
      QLog.e("", 1, localStringBuilder.toString());
    }
  }
  
  @VisibleForTesting
  protected int a()
  {
    if (!WXShareHelper.a().a()) {
      return 2131720478;
    }
    if (!WXShareHelper.a().b()) {
      return 2131720479;
    }
    return -1;
  }
  
  public Bitmap a(String paramString)
  {
    paramString = ScreenShotImageUtil.a(paramString, this.jdField_d_of_type_Int, this.jdField_c_of_type_JavaLangString, "QRCode_");
    this.jdField_a_of_type_JavaLangString = ((String)paramString.first);
    paramString = (Bitmap)paramString.second;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateScreenShotImageWithQRCode->end time:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = false;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return paramString;
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotShareHelper.3(this));
            return paramString;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotShareHelper.2(this));
          return paramString;
        }
        c();
      }
    }
    return paramString;
  }
  
  public QQProgressDialog a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public String a()
  {
    String str1 = BaseApplicationImpl.getApplication().getString(2131718993);
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        int i = this.jdField_a_of_type_OrgJsonJSONArray.length();
        i = new Random().nextInt(i);
        String str2 = this.jdField_a_of_type_OrgJsonJSONArray.getString(i);
        return str2;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("", 2, localStringBuilder.toString());
      }
    }
    return str1;
  }
  
  public void a()
  {
    TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.b();
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
      WxShareHelperFromReadInjoy.getInstance().shareImageToWX(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt2, false);
    } else {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt2, false);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  protected void a(TroopMemberApiClient paramTroopMemberApiClient, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      paramTroopMemberApiClient.d(new ScreenShotShareHelper.4(this, paramBoolean2));
      return;
    }
    int i;
    if (paramBoolean2) {
      i = 3;
    } else {
      i = 2;
    }
    this.jdField_a_of_type_Int = i;
    f();
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
    if (QLog.isDevelopLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("doOnPhotoPlusActivityEditResult->mScreenshotFromType:");
      paramString1.append(this.jdField_c_of_type_Int);
      paramString1.append(", mEditScreenshotPath:");
      paramString1.append(this.jdField_b_of_type_JavaLangString);
      paramString1.append(", originImagePath:");
      paramString1.append(paramString2);
      QLog.d("", 2, paramString1.toString());
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
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696413);
    localActionSheetItem.icon = 2130839068;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131696417);
    localActionSheetItem.icon = 2130839070;
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
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showShareActionSheet->mEditScreenshotPath:");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
      }
      if ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isPublicAccountUrl(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(a()))) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(a());
      } else {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getContext().getString(2131719029));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("actionSheet.show exception=");
          localStringBuilder.append(localException);
          QLog.d("", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showShareActionSheet->post runnable generate screenshot with QRcode! time:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Int = 0;
      Object localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject2 != null)
      {
        ((Bitmap)localObject2).recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      ThreadManager.executeOnSubThread(new ScreenShotShareHelper.1(this));
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    if (str != null) {
      return str;
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
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131720416), "", -1);
      return;
    }
    this.jdField_a_of_type_Int = 1;
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695241, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
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
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareScreenShotToQQ->imgPath:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("", 2, ((StringBuilder)localObject).toString());
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    localIntent.putExtra("req_share_id", 1478164480L);
    localIntent.putExtra("image_url", paramString);
    localIntent.putExtra("forward_type", -3);
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      paramString = this.jdField_c_of_type_JavaLangString;
    } else {
      paramString = this.jdField_d_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.f)) {
      localObject = BaseApplicationImpl.getContext().getResources().getString(2131695239);
    } else {
      localObject = this.f;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScreenShotShare|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    paramString = localStringBuilder.toString();
    if (this.jdField_c_of_type_Int == 3) {
      paramString = paramString.concat("|1");
    } else {
      paramString = paramString.concat("|0");
    }
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("req_type", 5);
    localIntent.putExtra("brief_key", HardCodeUtil.a(2131713503));
    localIntent.putExtra("struct_share_key_source_icon", "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
    localIntent.putExtra("struct_share_key_source_name", "QQ看点");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("stuctmsg_bytes", StructMsgFactory.a(localIntent.getExtras()).getBytes());
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1);
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
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695241, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina start!");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "shareMsgToSina installSinaWeibo:true");
      }
      if (TextUtils.isEmpty(this.f)) {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131695239);
      } else {
        localObject = this.f;
      }
      this.e = ((String)localObject);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        localObject = this.jdField_c_of_type_JavaLangString;
      } else {
        localObject = this.jdField_d_of_type_JavaLangString;
      }
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setFlags(268435456);
      localIntent.setType("image/*");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append((String)localObject);
      localIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_b_of_type_JavaLangString)));
      }
      localIntent.setPackage(localApplicationInfo.packageName);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (!QLog.isColorLevel()) {
        break label371;
      }
      QLog.d("", 2, "shareMsgToSina start weibo!");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label307:
      break label307;
    }
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina installSinaWeibo:false");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695245, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
    label371:
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina end!");
    }
  }
  
  public void h()
  {
    ShareActionSheetBuilder localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.onConfigurationChanged();
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
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "onScreenShotItemClick->tag null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 9)
        {
          if (i != 10)
          {
            if (i == 12) {
              g();
            }
          }
          else {
            e();
          }
        }
        else {
          d();
        }
      }
      else {
        c();
      }
    }
    else {
      d(this.jdField_b_of_type_JavaLangString);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
    if (localObject != null) {
      ((AdapterView.OnItemClickListener)localObject).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper
 * JD-Core Version:    0.7.0.1
 */