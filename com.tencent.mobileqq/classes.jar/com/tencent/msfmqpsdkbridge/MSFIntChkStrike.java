package com.tencent.msfmqpsdkbridge;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mqpsdk.secsrv.IIntChkStrikeResultListener;
import com.tencent.mqpsdk.secsrv.MQPIntChkService.IIntChkStrike;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MSFIntChkStrike
  implements MQPIntChkService.IIntChkStrike
{
  private static final int BTN_ACTION_BROWSER = 5;
  private static final int BTN_ACTION_BROWSER_AND_LOGOUT = 6;
  private static final int BTN_ACTION_CLOSE = 1;
  private static final int BTN_ACTION_DOWNLOADMANAGER = 7;
  private static final int BTN_ACTION_DOWNLOADMANAGER_AND_LOGOUT = 8;
  private static final int BTN_ACTION_LOGOUT = 2;
  private static final int BTN_ACTION_QQDOWNLOADER = 3;
  private static final int BTN_ACTION_QQDOWNLOADER_AND_LOGOUT = 3;
  private QQAppInterface mApp = null;
  private long mDownloadReference = 0L;
  private int mNetworkFlags = 0;
  private String mPackageDownloadURL = "";
  private String mPackageName = "MQPINTCHK";
  private IIntChkStrikeResultListener mResultListener = null;
  private int mStrikeResult = 0;
  private int mStrikeType;
  private boolean mToastAlreadyShown = false;
  
  public MSFIntChkStrike(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.mStrikeType = paramInt;
  }
  
  @SuppressLint({"NewApi"})
  private void jumpToTMAssistantDownload()
  {
    Object localObject = BaseApplication.getContext();
    DownloadManager localDownloadManager = (DownloadManager)((Context)localObject).getSystemService("download");
    if (localDownloadManager == null)
    {
      this.mStrikeResult = 30;
      return;
    }
    this.mStrikeResult = 31;
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    ((Context)localObject).registerReceiver(new MSFIntChkStrike.5(this, localDownloadManager), localIntentFilter);
    try
    {
      localObject = new DownloadManager.Request(Uri.parse(this.mPackageDownloadURL));
      ((DownloadManager.Request)localObject).setTitle(this.mPackageName);
      if (this.mNetworkFlags != 0) {
        ((DownloadManager.Request)localObject).setAllowedNetworkTypes(this.mNetworkFlags);
      }
      this.mDownloadReference = localDownloadManager.enqueue((DownloadManager.Request)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void onBtnAction(DialogInterface paramDialogInterface, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {
      this.mStrikeResult = 1;
    } else if (paramInt2 == 2) {
      this.mStrikeResult = 2;
    } else if ((paramInt2 != 3) && (paramInt2 != 3)) {
      if ((paramInt2 != 5) && (paramInt2 != 6))
      {
        if ((paramInt2 != 7) && (paramInt2 != 8))
        {
          this.mStrikeResult = 65535;
          break label239;
        }
        jumpToTMAssistantDownload();
        break label239;
      }
    }
    try
    {
      if (TextUtils.isEmpty(this.mPackageDownloadURL))
      {
        this.mStrikeResult = 20;
      }
      else
      {
        localBaseApplication = BaseApplication.getContext();
        localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(this.mPackageDownloadURL));
        ((Intent)localObject2).setFlags(268435456);
        localBaseApplication.startActivity((Intent)localObject2);
        this.mStrikeResult = 22;
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException1)
    {
      BaseApplication localBaseApplication;
      Object localObject2;
      label150:
      label234:
      break label150;
    }
    this.mStrikeResult = 23;
    try
    {
      localBaseApplication = BaseApplication.getContext();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tmast://appdetails?pname=");
      ((StringBuilder)localObject2).append(localBaseApplication.getPackageName());
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject2).toString()));
      ((Intent)localObject2).setFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject2);
      this.mStrikeResult = 4;
    }
    catch (ActivityNotFoundException localActivityNotFoundException2)
    {
      Object localObject1;
      break label234;
    }
    this.mStrikeResult = 3;
    label239:
    paramDialogInterface.dismiss();
    if (this.mResultListener != null)
    {
      try
      {
        paramDialogInterface = new JSONObject();
        try
        {
          paramDialogInterface.put("strike_result", this.mStrikeResult);
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        paramDialogInterface = null;
      }
      if (paramDialogInterface != null) {
        this.mResultListener.a(paramDialogInterface.toString());
      }
    }
    if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 6) || (paramInt2 == 8))
    {
      paramDialogInterface = BaseActivity.sTopActivity;
      localObject1 = this.mApp;
      if (localObject1 != null)
      {
        ((QQAppInterface)localObject1).logout(true);
        SharedPreUtils.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), false);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).addFlags(335544320);
      RouteUtils.a(paramDialogInterface, (Intent)localObject1, "/base/login");
    }
  }
  
  public void exec(String paramString, IIntChkStrikeResultListener paramIIntChkStrikeResultListener)
  {
    if (this.mApp == null) {
      return;
    }
    int i = this.mStrikeType;
    Object localObject1 = null;
    if (i == 1)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.mToastAlreadyShown) {
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("toast_config")) {
          paramString = paramString.getString("toast_config");
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramIIntChkStrikeResultListener != null) {
        this.mResultListener = paramIIntChkStrikeResultListener;
      }
      paramIIntChkStrikeResultListener = DocumentBuilderFactory.newInstance();
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = paramIIntChkStrikeResultListener.newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes())).getDocumentElement();
        paramString = ((Element)localObject1).getElementsByTagName("title");
        if (paramString.getLength() == 0) {
          return;
        }
        String str1 = ((Element)paramString.item(0)).getAttribute("val");
        paramString = ((Element)localObject1).getElementsByTagName("wording");
        if (paramString.getLength() == 0) {
          return;
        }
        String str2 = ((Element)paramString.item(0)).getAttribute("val");
        paramString = ((Element)localObject1).getElementsByTagName("package_url");
        if (paramString.getLength() != 0) {
          this.mPackageDownloadURL = ((Element)paramString.item(0)).getAttribute("val");
        }
        paramString = ((Element)localObject1).getElementsByTagName("package_name");
        if (paramString.getLength() != 0) {
          this.mPackageName = ((Element)paramString.item(0)).getAttribute("val");
        }
        paramString = ((Element)localObject1).getElementsByTagName("network_types");
        if (paramString.getLength() != 0)
        {
          this.mNetworkFlags = Integer.parseInt(((Element)paramString.item(0)).getAttribute("val"));
          if (this.mNetworkFlags >= 3) {
            this.mNetworkFlags = 0;
          }
        }
        paramString = ((Element)localObject1).getElementsByTagName("btn_confirm");
        i = paramString.getLength();
        localObject3 = "";
        if (i <= 0) {
          break label760;
        }
        paramString = (Element)paramString.item(0);
        paramIIntChkStrikeResultListener = paramString.getAttribute("text");
        paramString = new MSFIntChkStrike.1(this, Integer.parseInt(paramString.getAttribute("action")));
        localObject1 = ((Element)localObject1).getElementsByTagName("btn_cancel");
        if (((NodeList)localObject1).getLength() <= 0) {
          break label768;
        }
        localObject1 = (Element)((NodeList)localObject1).item(0);
        localObject3 = ((Element)localObject1).getAttribute("text");
        localObject1 = new MSFIntChkStrike.2(this, Integer.parseInt(((Element)localObject1).getAttribute("action")));
        MSFIntChkStrike.3 local3 = new MSFIntChkStrike.3(this);
        new Handler(Looper.getMainLooper()).post(new MSFIntChkStrike.4(this, str1, str2, paramString, (DialogInterface.OnClickListener)localObject1, (String)localObject3, paramIIntChkStrikeResultListener, local3));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (i == 2)
      {
        if (paramIIntChkStrikeResultListener != null)
        {
          try
          {
            paramString = new JSONObject();
            try
            {
              paramString.put("strike_result", 5);
            }
            catch (Exception localException1) {}
            localException2.printStackTrace();
          }
          catch (Exception localException2)
          {
            paramString = null;
          }
          if (paramString != null) {
            paramIIntChkStrikeResultListener.a(paramString.toString());
          }
        }
        this.mApp.exit(false);
        return;
      }
      if (i == 3)
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        try
        {
          localObject3 = new JSONObject(paramString);
          paramString = localException2;
          if (((JSONObject)localObject3).has("launch_package_name")) {
            paramString = ((JSONObject)localObject3).getString("launch_package_name");
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = localException2;
        }
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        Context localContext = this.mApp.getApp().getApplicationContext();
        if (!PackageUtil.a(localContext, paramString)) {
          i = 11;
        } else if (PackageUtil.a(localContext, paramString, this.mApp.getCurrentAccountUin())) {
          i = 13;
        } else {
          i = 12;
        }
        if (paramIIntChkStrikeResultListener != null)
        {
          paramString = new JSONObject();
          try
          {
            paramString.put("strike_result", i);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          paramIIntChkStrikeResultListener.a(paramString.toString());
        }
      }
      return;
      label760:
      paramIIntChkStrikeResultListener = "";
      paramString = null;
      continue;
      label768:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike
 * JD-Core Version:    0.7.0.1
 */