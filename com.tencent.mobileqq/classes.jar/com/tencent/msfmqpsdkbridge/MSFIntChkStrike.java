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
import bbfd;
import bbjn;
import bcxb;
import bcxe;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MSFIntChkStrike
  implements bcxe
{
  private static final int BTN_ACTION_BROWSER = 5;
  private static final int BTN_ACTION_BROWSER_AND_LOGOUT = 6;
  private static final int BTN_ACTION_CLOSE = 1;
  private static final int BTN_ACTION_DOWNLOADMANAGER = 7;
  private static final int BTN_ACTION_DOWNLOADMANAGER_AND_LOGOUT = 8;
  private static final int BTN_ACTION_LOGOUT = 2;
  private static final int BTN_ACTION_QQDOWNLOADER = 3;
  private static final int BTN_ACTION_QQDOWNLOADER_AND_LOGOUT = 3;
  private QQAppInterface mApp;
  private long mDownloadReference;
  private int mNetworkFlags;
  private String mPackageDownloadURL = "";
  private String mPackageName = "MQPINTCHK";
  private bcxb mResultListener;
  private int mStrikeResult = 0;
  private int mStrikeType;
  private boolean mToastAlreadyShown;
  
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
    if (paramInt2 == 1)
    {
      this.mStrikeResult = 1;
      paramDialogInterface.dismiss();
      if (this.mResultListener == null) {}
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramDialogInterface = new JSONObject();
          }
          catch (Exception localException1)
          {
            Object localObject;
            Intent localIntent;
            BaseApplication localBaseApplication;
            paramDialogInterface = null;
          }
          try
          {
            paramDialogInterface.put("strike_result", this.mStrikeResult);
            if (paramDialogInterface != null) {
              this.mResultListener.a(paramDialogInterface.toString());
            }
            if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 6) || (paramInt2 == 8))
            {
              paramDialogInterface = BaseActivity.sTopActivity;
              if (this.mApp != null)
              {
                this.mApp.logout(true);
                bbjn.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), false);
              }
              localObject = new Intent(paramDialogInterface, LoginActivity.class);
              ((Intent)localObject).addFlags(335544320);
              paramDialogInterface.startActivity((Intent)localObject);
            }
            return;
          }
          catch (Exception localException2)
          {
            break label363;
          }
          if (paramInt2 == 2)
          {
            this.mStrikeResult = 2;
            break;
          }
          if ((paramInt2 != 3) && (paramInt2 != 3)) {
            continue;
          }
          try
          {
            localObject = BaseApplication.getContext();
            localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://appdetails?pname=" + ((Context)localObject).getPackageName()));
            localIntent.setFlags(268435456);
            ((Context)localObject).startActivity(localIntent);
            this.mStrikeResult = 4;
          }
          catch (ActivityNotFoundException localActivityNotFoundException1)
          {
            this.mStrikeResult = 3;
          }
        }
        break;
        if ((paramInt2 != 5) && (paramInt2 != 6)) {
          continue;
        }
        try
        {
          if (!TextUtils.isEmpty(this.mPackageDownloadURL)) {
            continue;
          }
          this.mStrikeResult = 20;
        }
        catch (ActivityNotFoundException localActivityNotFoundException2)
        {
          this.mStrikeResult = 23;
        }
      }
      break;
      localBaseApplication = BaseApplication.getContext();
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.mPackageDownloadURL));
      localIntent.setFlags(268435456);
      localBaseApplication.startActivity(localIntent);
      this.mStrikeResult = 22;
      break;
      if ((paramInt2 == 7) || (paramInt2 == 8))
      {
        jumpToTMAssistantDownload();
        break;
      }
      this.mStrikeResult = 65535;
      break;
      label363:
      localException1.printStackTrace();
    }
  }
  
  public void exec(String paramString, bcxb parambcxb)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    if (this.mApp == null) {}
    do
    {
      return;
      if (this.mStrikeType != 1) {
        break;
      }
    } while ((TextUtils.isEmpty(paramString)) || (this.mToastAlreadyShown));
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramString = new JSONObject(paramString);
          if (paramString.has("toast_config"))
          {
            paramString = paramString.getString("toast_config");
            if (TextUtils.isEmpty(paramString)) {
              break;
            }
            if (parambcxb != null) {
              this.mResultListener = parambcxb;
            }
            parambcxb = DocumentBuilderFactory.newInstance();
            try
            {
              localObject1 = parambcxb.newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes())).getDocumentElement();
              paramString = ((Element)localObject1).getElementsByTagName("title");
              if (paramString.getLength() == 0) {
                break;
              }
              String str1 = ((Element)paramString.item(0)).getAttribute("val");
              paramString = ((Element)localObject1).getElementsByTagName("wording");
              if (paramString.getLength() == 0) {
                break;
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
              parambcxb = "";
              paramString = ((Element)localObject1).getElementsByTagName("btn_confirm");
              if (paramString.getLength() <= 0) {
                break label762;
              }
              paramString = (Element)paramString.item(0);
              parambcxb = paramString.getAttribute("text");
              paramString = new MSFIntChkStrike.1(this, Integer.parseInt(paramString.getAttribute("action")));
              localObject3 = "";
              localObject1 = ((Element)localObject1).getElementsByTagName("btn_cancel");
              if (((NodeList)localObject1).getLength() <= 0) {
                break label756;
              }
              localObject1 = (Element)((NodeList)localObject1).item(0);
              localObject3 = ((Element)localObject1).getAttribute("text");
              localObject1 = new MSFIntChkStrike.2(this, Integer.parseInt(((Element)localObject1).getAttribute("action")));
              MSFIntChkStrike.3 local3 = new MSFIntChkStrike.3(this);
              new Handler(Looper.getMainLooper()).post(new MSFIntChkStrike.4(this, str1, str2, paramString, (DialogInterface.OnClickListener)localObject1, (String)localObject3, parambcxb, local3));
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
      }
      if (this.mStrikeType == 2)
      {
        if (parambcxb != null) {}
        label584:
        for (;;)
        {
          try
          {
            paramString = new JSONObject();
            localException1.printStackTrace();
          }
          catch (Exception localException1)
          {
            try
            {
              paramString.put("strike_result", 5);
              if (paramString != null) {
                parambcxb.a(paramString.toString());
              }
              this.mApp.b(false);
              return;
            }
            catch (Exception localException3)
            {
              Context localContext;
              int i;
              break label584;
            }
            localException1 = localException1;
            paramString = (String)localObject3;
          }
        }
      }
      if ((this.mStrikeType != 3) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      try
      {
        localObject3 = new JSONObject(paramString);
        paramString = localException1;
        if (((JSONObject)localObject3).has("launch_package_name")) {
          paramString = ((JSONObject)localObject3).getString("launch_package_name");
        }
      }
      catch (Exception paramString)
      {
        try
        {
          for (;;)
          {
            paramString.put("strike_result", i);
            parambcxb.a(paramString.toString());
            return;
            paramString = paramString;
            paramString.printStackTrace();
            paramString = localContext;
            continue;
            if (!bbfd.a(localContext, paramString, this.mApp.getCurrentAccountUin())) {
              break;
            }
            i = 13;
          }
          i = 12;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      localContext = this.mApp.getApp().getApplicationContext();
      if (!bbfd.a(localContext, paramString))
      {
        i = 11;
        if (parambcxb == null) {
          break;
        }
        paramString = new JSONObject();
      }
      label756:
      Object localObject2 = null;
      continue;
      label762:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike
 * JD-Core Version:    0.7.0.1
 */