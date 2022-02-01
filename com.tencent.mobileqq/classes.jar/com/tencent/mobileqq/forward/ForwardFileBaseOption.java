package com.tencent.mobileqq.forward;

import aara;
import ahff;
import amtj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import atky;
import atlv;
import atlw;
import atlx;
import aucz;
import bkxa;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import ocw;

public abstract class ForwardFileBaseOption
  extends atky
{
  protected static String h;
  aucz a;
  public ForwardFileInfo a;
  protected long b;
  ArrayList<ForwardFileInfo> b;
  protected String i = "";
  protected String j = "";
  
  public ForwardFileBaseOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(paramContext, paramUri);
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject;
    if (paramLong < 1024L) {
      localObject = paramLong + " bytes";
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692275) + paramString + "\n" + this.jdField_a_of_type_AndroidContentContext.getString(2131692292) + (String)localObject;
      if (paramLong < 1048576L)
      {
        localObject = paramLong / 1024L + " KB";
      }
      else
      {
        localObject = new DecimalFormat("##0.00");
        localObject = ((DecimalFormat)localObject).format(paramLong / 1048576.0D) + " MB";
      }
    }
  }
  
  private boolean a(Uri paramUri)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("path_for_file_scheme");
    QLog.d("ForwardOption.ForwardFileBaseOption", 1, "getFileInfo fileScheme = " + (String)localObject2);
    Object localObject1 = paramUri;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramUri;
      if (!((String)localObject2).equals(paramUri.getPath())) {
        localObject1 = Uri.parse("file://" + (String)localObject2);
      }
    }
    paramUri = a((Uri)localObject1);
    if (TextUtils.isEmpty(paramUri))
    {
      if (this.jdField_a_of_type_Aucz != null)
      {
        paramUri = this.jdField_a_of_type_Aucz;
        h = aucz.jdField_a_of_type_JavaLangString;
      }
      f(e());
      return false;
    }
    localObject2 = new File(paramUri);
    long l = ((File)localObject2).length();
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Aucz != null)
    {
      bool1 = this.jdField_a_of_type_Aucz.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Aucz == null) {
        break label228;
      }
      bool2 = this.jdField_a_of_type_Aucz.b;
    }
    for (;;)
    {
      if ((!bool1) && (!bool2) && (l == 0L))
      {
        if (((Uri)localObject1).toString().contains("mms/part"))
        {
          f(this.jdField_a_of_type_AndroidContentContext.getString(2131692279));
          return false;
          bool1 = false;
          break;
          label228:
          bool2 = false;
          continue;
        }
        f(this.jdField_a_of_type_AndroidContentContext.getString(2131692254));
        return false;
      }
    }
    if ((true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_from_jump")) && (true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromShare")) && (b(paramUri)))
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755826);
      paramUri.setContentView(2131559016);
      paramUri.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131718947));
      paramUri.setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692256));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690599), new atlw(this));
      paramUri.show();
      return false;
    }
    localObject1 = ((File)localObject2).getName();
    boolean bool3 = ((File)localObject2).canRead();
    if ((!bool1) && (!bool2) && (!bool3))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", paramUri);
    e(paramUri);
    this.jdField_a_of_type_JavaLangString = a((String)localObject1, l);
    this.j = ((String)localObject1);
    this.i = paramUri;
    this.jdField_b_of_type_Long = l;
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("/data/data/com.tencent.mobileqq/")) {
      return false;
    }
    return true;
  }
  
  private void f(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755826);
    localQQCustomDialog.setContentView(2131559016);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131718947));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690599), new atlv(this));
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  protected String a(Uri paramUri)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileBaseOption", 2, "uri= " + paramUri);
    }
    if (this.jdField_a_of_type_Aucz == null) {
      this.jdField_a_of_type_Aucz = new aucz(this.jdField_a_of_type_AndroidAppActivity, true, new atlx(this));
    }
    return this.jdField_a_of_type_Aucz.a(paramUri);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 102)
    {
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(50)).a(Long.parseLong(str)))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, amtj.a(2131703874), 2000).a();
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
    else
    {
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
      ahff.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localArrayList, paramIntent);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = ((aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(paramString2));
      Object localObject = new FileInfo(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramString1);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", paramString2);
      ((Intent)localObject).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", paramString3);
      bkxa.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
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
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextColor(2131165695);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(14.0F);
  }
  
  public boolean c()
  {
    Intent localIntent;
    boolean bool;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", ocw.a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", amtj.a(2131703880));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (!this.f) {
          break label181;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label181:
      if (!bool) {
        ForwardUtils.handleForwardData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
  }
  
  protected String e()
  {
    if (h == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718384);
    }
    return h;
  }
  
  protected void e(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileBaseOption
 * JD-Core Version:    0.7.0.1
 */