package com.tencent.mobileqq.haoliyou.sso;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bigbrother.DownloadListener;
import com.tencent.mobileqq.bigbrother.JumpListener;
import com.tencent.mobileqq.bigbrother.ServerApi.ReqDownloadCheckRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi.ReqJumpCheckRecmd;
import com.tencent.mobileqq.bigbrother.TeleScreenObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.CheckShareExtensionReq;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CheckForwardManager
  implements Manager
{
  private CheckForwardObserver a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DownloadListener paramDownloadListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dl src: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", refId: ");
    ((StringBuilder)localObject).append(paramString4);
    QLog.i("TeleScreen|CheckForwardManager", 1, ((StringBuilder)localObject).toString());
    localObject = BaseApplicationImpl.getApplication();
    NewIntent localNewIntent = new NewIntent(((BaseApplicationImpl)localObject).getApplicationContext(), CheckForwardServlet.class);
    ServerApi.ReqDownloadCheckRecmd localReqDownloadCheckRecmd = new ServerApi.ReqDownloadCheckRecmd();
    localReqDownloadCheckRecmd.uin.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (paramString2 != null) {
      localReqDownloadCheckRecmd.pkg_name.set(paramString2);
    }
    if (paramString3 != null) {
      localReqDownloadCheckRecmd.url.set(paramString3);
    }
    if (paramString1 != null) {
      localReqDownloadCheckRecmd.source.set(paramString1);
    }
    if (paramString4 != null) {
      localReqDownloadCheckRecmd.ref_source.set(paramString4);
    }
    localReqDownloadCheckRecmd.platform.set("android");
    localNewIntent.putExtra("CMD", "QQApkSvc.check_download_apk");
    localNewIntent.putExtra("RequestBytes", localReqDownloadCheckRecmd.toByteArray());
    paramString1 = TeleScreenObserver.a();
    if (paramDownloadListener != null)
    {
      int i = paramString1.a(paramContext, paramDownloadListener);
      localNewIntent.putExtra("req_id", i);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("add req with id: ");
        paramContext.append(i);
        QLog.d("TeleScreen|CheckForwardManager", 2, paramContext.toString());
      }
    }
    localNewIntent.setObserver(TeleScreenObserver.a());
    ((BaseApplicationImpl)localObject).getRuntime().startServlet(localNewIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<ResolveInfo> paramList, String paramString6, JumpListener paramJumpListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jump src: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", pkg: ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(", scheme: ");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(", action: ");
    ((StringBuilder)localObject).append(paramString5);
    ((StringBuilder)localObject).append("， refId: ");
    ((StringBuilder)localObject).append(paramString6);
    QLog.i("TeleScreen|CheckForwardManager", 1, ((StringBuilder)localObject).toString());
    localObject = BaseApplicationImpl.getApplication();
    NewIntent localNewIntent = new NewIntent(((BaseApplicationImpl)localObject).getApplicationContext(), CheckForwardServlet.class);
    ServerApi.ReqJumpCheckRecmd localReqJumpCheckRecmd = new ServerApi.ReqJumpCheckRecmd();
    localReqJumpCheckRecmd.uin.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (paramString3 != null)
    {
      localReqJumpCheckRecmd.pkg_name.add(paramString3);
    }
    else if (paramList != null)
    {
      paramString3 = paramList.iterator();
      while (paramString3.hasNext())
      {
        paramList = (ResolveInfo)paramString3.next();
        if (paramList.activityInfo != null) {
          localReqJumpCheckRecmd.pkg_name.add(paramList.activityInfo.packageName);
        } else if (paramList.serviceInfo != null) {
          localReqJumpCheckRecmd.pkg_name.add(paramList.serviceInfo.packageName);
        } else if ((Build.VERSION.SDK_INT >= 19) && (paramList.providerInfo != null)) {
          localReqJumpCheckRecmd.pkg_name.add(paramList.providerInfo.packageName);
        }
      }
      if ((QLog.isColorLevel()) && (localReqJumpCheckRecmd.pkg_name.has()) && (!localReqJumpCheckRecmd.pkg_name.isEmpty()))
      {
        paramString3 = new StringBuilder();
        paramString3.append("resolve pkg: ");
        paramString3.append((String)localReqJumpCheckRecmd.pkg_name.get(0));
        QLog.d("TeleScreen|CheckForwardManager", 2, paramString3.toString());
      }
    }
    if (paramString4 != null) {
      localReqJumpCheckRecmd.scheme.set(paramString4);
    }
    if (paramString5 != null) {
      localReqJumpCheckRecmd.action.set(paramString5);
    }
    if (paramString2 != null) {
      localReqJumpCheckRecmd.url.set(paramString2);
    }
    if (paramString1 != null) {
      localReqJumpCheckRecmd.source.set(paramString1);
    }
    if (paramString6 != null) {
      localReqJumpCheckRecmd.ref_source.set(paramString6);
    }
    localReqJumpCheckRecmd.platform.set("android");
    localNewIntent.putExtra("CMD", "QQApkSvc.check_jump_apk");
    localNewIntent.putExtra("RequestBytes", localReqJumpCheckRecmd.toByteArray());
    int i = TeleScreenObserver.a().a(paramContext, paramJumpListener);
    localNewIntent.putExtra("req_id", i);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("add req with id: ");
      paramContext.append(i);
      QLog.d("TeleScreen|CheckForwardManager", 2, paramContext.toString());
    }
    localNewIntent.setObserver(TeleScreenObserver.a());
    ((BaseApplicationImpl)localObject).getRuntime().startServlet(localNewIntent);
    if ((localReqJumpCheckRecmd.pkg_name.isEmpty()) && (TextUtils.isEmpty(localReqJumpCheckRecmd.scheme.get())) && (TextUtils.isEmpty(localReqJumpCheckRecmd.action.get())) && (TextUtils.isEmpty(localReqJumpCheckRecmd.url.get())))
    {
      FightReporter.c();
      paramContext = new StringBuilder();
      paramContext.append("openthirdappnullinfo");
      paramContext.append(QLog.getStackTraceString(new Throwable()));
      QLog.e("TeleScreen|CheckForwardManager", 1, paramContext.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, oidb_cmd0xc78.CheckShareExtensionReq paramCheckShareExtensionReq, String paramString, OnCheckShareListener paramOnCheckShareListener)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), CheckForwardServlet.class);
    localNewIntent.putExtra("CMD", "OidbSvc.0xc78_1");
    localNewIntent.putExtra("ext_info", paramString);
    paramString = new oidb_cmd0xc78.ReqBody();
    paramString.check_share_extension_req.set(paramCheckShareExtensionReq);
    paramCheckShareExtensionReq = new oidb_sso.OIDBSSOPkg();
    paramCheckShareExtensionReq.uint32_command.set(3192);
    paramCheckShareExtensionReq.uint32_service_type.set(1);
    paramCheckShareExtensionReq.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
    localNewIntent.putExtra("RequestBytes", paramCheckShareExtensionReq.toByteArray());
    if (this.a == null) {
      this.a = new CheckForwardObserver();
    }
    int i = this.a.a(paramOnCheckShareListener);
    localNewIntent.setObserver(this.a);
    localNewIntent.putExtra("req_id", i);
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|CheckForwardManager", 2, "sendCheckShareReq");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.sso.CheckForwardManager
 * JD-Core Version:    0.7.0.1
 */