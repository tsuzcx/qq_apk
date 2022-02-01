package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ForwardFileBaseOption
  extends ForwardBaseOption
{
  protected static String h;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  UriParserPathHelper jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper;
  protected long b = 0L;
  ArrayList<ForwardFileInfo> c = new ArrayList();
  protected String i = "";
  protected String j = "";
  
  public ForwardFileBaseOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(paramContext, paramUri);
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject;
    if (paramLong < 1024L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" bytes");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramLong < 1048576L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 1024L);
      ((StringBuilder)localObject).append(" KB");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new DecimalFormat("##0.00");
      localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 1048576.0D));
      localStringBuilder.append(" MB");
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692433));
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692452));
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private boolean a(Uri paramUri)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("path_for_file_scheme");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getFileInfo fileScheme = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    QLog.d("ForwardOption.ForwardFileBaseOption", 1, ((StringBuilder)localObject1).toString());
    localObject1 = paramUri;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramUri;
      if (!((String)localObject2).equals(paramUri.getPath()))
      {
        paramUri = new StringBuilder();
        paramUri.append("file://");
        paramUri.append((String)localObject2);
        localObject1 = Uri.parse(paramUri.toString());
      }
    }
    paramUri = a((Uri)localObject1);
    if (TextUtils.isEmpty(paramUri))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper != null) {
        h = UriParserPathHelper.jdField_a_of_type_JavaLangString;
      }
      e(e());
      return false;
    }
    localObject2 = new File(paramUri);
    long l = ((File)localObject2).length();
    UriParserPathHelper localUriParserPathHelper = this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper;
    int k;
    if ((localUriParserPathHelper != null) && (localUriParserPathHelper.a())) {
      k = 1;
    } else {
      k = 0;
    }
    localUriParserPathHelper = this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper;
    boolean bool1;
    if (localUriParserPathHelper != null) {
      bool1 = localUriParserPathHelper.jdField_a_of_type_Boolean;
    } else {
      bool1 = false;
    }
    if ((k == 0) && (!bool1) && (l == 0L))
    {
      if (((Uri)localObject1).toString().contains("mms/part"))
      {
        e(this.jdField_a_of_type_AndroidContentContext.getString(2131692437));
        return false;
      }
      e(this.jdField_a_of_type_AndroidContentContext.getString(2131692412));
      return false;
    }
    if ((true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_from_jump")) && (true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromShare")) && (b(paramUri)))
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      paramUri.setContentView(2131558978);
      paramUri.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719632));
      paramUri.setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692414));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690706), new ForwardFileBaseOption.2(this));
      paramUri.show();
      return false;
    }
    localObject1 = ((File)localObject2).getName();
    boolean bool2 = ((File)localObject2).canRead();
    if ((k == 0) && (!bool1) && (!bool2))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", paramUri);
    d(paramUri);
    this.jdField_a_of_type_JavaLangString = a((String)localObject1, l);
    this.j = ((String)localObject1);
    this.i = paramUri;
    this.b = l;
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("/data/data/com.tencent.mobileqq/");
  }
  
  private void e(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719632));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690706), new ForwardFileBaseOption.1(this));
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  public long a()
  {
    return this.b;
  }
  
  protected String a(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uri= ");
      localStringBuilder.append(paramUri);
      QLog.d("ForwardOption.ForwardFileBaseOption", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper = new UriParserPathHelper(this.jdField_a_of_type_AndroidAppActivity, true, new ForwardFileBaseOption.3(this));
    }
    return this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper.a(paramUri);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 102)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(Long.parseLong(str)))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131704849), 2000).a();
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
      }
      Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
        }
        paramIntent = paramIntent.getStringExtra("sPrintParam");
        DeviceMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localArrayList, paramIntent);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString2));
      Object localObject = new FileInfo(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramString1);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", paramString2);
      ((Intent)localObject).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", paramString3);
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  public boolean a()
  {
    super.a();
    h = null;
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    if ((localUri != null) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath")))) {
      a(localUri);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("fileinfo"));
    this.c = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextColor(2131165694);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(14.0F);
  }
  
  protected boolean c()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    else
    {
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704855));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      boolean bool = a(localIntent);
      if (this.f) {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      } else if (!bool) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected void d(String paramString) {}
  
  protected String e()
  {
    String str2 = h;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719013);
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileBaseOption
 * JD-Core Version:    0.7.0.1
 */