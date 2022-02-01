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
  protected static String af;
  ForwardFileInfo ad;
  ArrayList<ForwardFileInfo> ae = new ArrayList();
  UriParserPathHelper ag;
  protected String ah = "";
  protected long ai = 0L;
  protected String aj = "";
  
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
    localStringBuilder.append(this.I.getString(2131889421));
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.I.getString(2131889440));
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private void a(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.s, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(this.I.getString(2131917233));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.I.getString(2131887625), new ForwardFileBaseOption.1(this));
    if (!this.s.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private boolean b(Uri paramUri)
  {
    Object localObject2 = this.r.getStringExtra("path_for_file_scheme");
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
      if (this.ag != null) {
        af = UriParserPathHelper.b;
      }
      a(o());
      return false;
    }
    localObject2 = new File(paramUri);
    long l = ((File)localObject2).length();
    UriParserPathHelper localUriParserPathHelper = this.ag;
    int i;
    if ((localUriParserPathHelper != null) && (localUriParserPathHelper.a())) {
      i = 1;
    } else {
      i = 0;
    }
    localUriParserPathHelper = this.ag;
    boolean bool1;
    if (localUriParserPathHelper != null) {
      bool1 = localUriParserPathHelper.c;
    } else {
      bool1 = false;
    }
    if ((i == 0) && (!bool1) && (l == 0L))
    {
      if (((Uri)localObject1).toString().contains("mms/part"))
      {
        a(this.I.getString(2131889425));
        return false;
      }
      a(this.I.getString(2131889400));
      return false;
    }
    if ((true == this.t.getBoolean("forward_from_jump")) && (true == this.t.getBoolean("isFromShare")) && (g(paramUri)))
    {
      paramUri = new QQCustomDialog(this.s, 2131953338);
      paramUri.setContentView(2131624611);
      paramUri.setTitle(this.I.getString(2131917233));
      paramUri.setMessage(this.I.getString(2131889402));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.I.getString(2131887625), new ForwardFileBaseOption.2(this));
      paramUri.show();
      return false;
    }
    localObject1 = ((File)localObject2).getName();
    boolean bool2 = ((File)localObject2).canRead();
    if ((i == 0) && (!bool1) && (!bool2))
    {
      this.u = this.t.getString("android.intent.extra.TEXT");
      this.t.putInt("forward_type", -1);
      return false;
    }
    this.t.putString("forward_filepath", paramUri);
    f(paramUri);
    this.u = a((String)localObject1, l);
    this.aj = ((String)localObject1);
    this.ah = paramUri;
    this.ai = l;
    return true;
  }
  
  public static boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("/data/data/com.tencent.mobileqq/");
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
    if (this.ag == null) {
      this.ag = new UriParserPathHelper(this.s, true, new ForwardFileBaseOption.3(this));
    }
    return this.ag.a(paramUri);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 102)
    {
      String str = this.t.getString("uin");
      if (!((DeviceFileHandler)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).b(Long.parseLong(str)))
      {
        QQToast.makeText(this.s, HardCodeUtil.a(2131902747), 2000).show();
        this.s.finish();
        return;
      }
      Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((FileInfo)((Iterator)localObject).next()).d());
        }
        paramIntent = paramIntent.getStringExtra("sPrintParam");
        DeviceMsgChatPie.a(this.q, str, localArrayList, paramIntent);
      }
      this.s.finish();
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = ((SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(paramString2));
      Object localObject = new FileInfo(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramString1);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", paramString2);
      ((Intent)localObject).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", paramString3);
      SmartDevicePluginLoader.a().a(this.s, this.q, this.q.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  protected void d()
  {
    super.d();
    this.A.adjustMessageBottomMargin(17.0F);
    this.A.setMessageTextColor(2131166157);
    this.A.setMessageTextSize(14.0F);
  }
  
  public boolean e()
  {
    super.e();
    af = null;
    Uri localUri = this.r.getData();
    if ((localUri != null) && (TextUtils.isEmpty(this.t.getString("forward_filepath")))) {
      b(localUri);
    }
    this.ad = ((ForwardFileInfo)this.r.getParcelableExtra("fileinfo"));
    this.ae = this.r.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  protected void f(String paramString) {}
  
  protected boolean f()
  {
    Intent localIntent;
    if (this.t.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.s, ChatActivity.class);
      localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(this.t.getString("uin"), this.q));
    }
    else
    {
      localIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
    }
    if (this.r.getBooleanExtra("sendMultiple", false))
    {
      this.t.putString("leftBackText", HardCodeUtil.a(2131902752));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.t);
      boolean bool = c(localIntent);
      if (this.K) {
        this.s.startActivity(localIntent);
      } else if (!bool) {
        ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
      }
    }
    localIntent.putExtras(this.t);
    this.s.setResult(-1, localIntent);
    this.s.finish();
    return false;
  }
  
  protected String o()
  {
    String str2 = af;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.I.getString(2131916548);
    }
    return str1;
  }
  
  public long p()
  {
    return this.ai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileBaseOption
 * JD-Core Version:    0.7.0.1
 */