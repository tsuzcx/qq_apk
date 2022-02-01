package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileCardWebviewPlugin
  extends VasWebviewJsPlugin
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ProfileCardWebviewPlugin.1(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public List<VipProfileCardDownLoadInfo> a;
  public AtomicInteger a;
  private boolean jdField_a_of_type_Boolean = false;
  private final int b;
  public AtomicInteger b;
  private final int c = 1;
  private final int d = 2;
  
  public ProfileCardWebviewPlugin()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_Int = 0;
    this.mPluginNameSpace = "card";
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.closeWeb");
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        c();
        ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "3", "", "", "");
        return;
      }
      e();
      c();
      ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "2", "", "", "");
      return;
    }
    d();
    c();
    ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "1", "", "", "");
  }
  
  private void b()
  {
    c();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.mRuntime.a().getResources().getString(2131718743));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.mRuntime.a().getResources().getString(2131718753));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.mRuntime.a().getResources().getString(2131690728));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ProfileCardWebviewPlugin.2(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066C9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +33 -> 39
    //   9: aload_1
    //   10: invokevirtual 168	com/tencent/widget/ActionSheet:isShowing	()Z
    //   13: ifeq +26 -> 39
    //   16: aload_0
    //   17: getfield 51	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   20: invokevirtual 171	com/tencent/widget/ActionSheet:dismiss	()V
    //   23: goto +11 -> 34
    //   26: astore_1
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 51	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 51	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   39: return
    //   40: astore_1
    //   41: goto -7 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ProfileCardWebviewPlugin
    //   4	6	1	localActionSheet	ActionSheet
    //   26	7	1	localObject	Object
    //   40	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	23	26	finally
    //   16	23	40	java/lang/Exception
  }
  
  private void d()
  {
    sendRemoteReq(DataFactory.a("selectPhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  private void e()
  {
    sendRemoteReq(DataFactory.a("takePhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return -1;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        return 0;
      }
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0))
    {
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      int j;
      do
      {
        j = i + 1;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
        i = j;
      } while (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(j)).g != VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger);
      return 0;
      return -1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    return -2;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      return;
    }
    try
    {
      if (a() == 0)
      {
        Object localObject = (VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        String str = ((VipProfileCardDownLoadInfo)localObject).jdField_d_of_type_JavaLangString;
        Long localLong = ((VipProfileCardDownLoadInfo)localObject).jdField_a_of_type_JavaLangLong;
        boolean bool = ((VipProfileCardDownLoadInfo)localObject).jdField_b_of_type_Boolean;
        if (bool)
        {
          ((VipProfileCardDownLoadInfo)localObject).jdField_b_of_type_Boolean = false;
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
          localObject = DataFactory.a("card_download_wzry_template", str, this.mOnRemoteResp.key, new Bundle());
          ((Bundle)localObject).putLong("bgId", localLong.longValue());
          sendRemoteReq((Bundle)localObject, false, false);
          return;
        }
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        localObject = DataFactory.a("card_download", str, this.mOnRemoteResp.key, new Bundle());
        ((Bundle)localObject).putLong("bgId", localLong.longValue());
        sendRemoteReq((Bundle)localObject, false, false);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("method:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", json:");
      localStringBuilder.append(paramString2);
      QLog.i("ProfileCardWebviewPlugin", 2, localStringBuilder.toString());
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Integer localInteger = Integer.valueOf(0);
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("card"))) {}
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        Object localObject;
        JSONObject localJSONObject;
        Context localContext;
        continue;
        continue;
        continue;
        i += 1;
        continue;
        i += 1;
        continue;
        int i = 0;
        continue;
        int j = 0;
        continue;
        int k = 0;
        continue;
        boolean bool = true;
        continue;
        continue;
        bool = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("Failed to parse json str,json=");
      paramJsBridgeListener.append(paramVarArgs[0]);
      QLog.i("ProfileCardWebviewPlugin", 2, paramJsBridgeListener.toString());
    }
    paramString2 = null;
    if (paramString2 == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("method:");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(", json:");
      paramJsBridgeListener.append(paramString2.toString());
      QLog.i("ProfileCardWebviewPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = "callback";
    localObject = new JSONObject();
    localJSONObject = new JSONObject();
    localContext = this.mRuntime.a().getApplicationContext();
    try
    {
      paramString1 = paramString2.optString("callback");
      paramJsBridgeListener = paramString1;
      bool = paramString3.equals("getInfo");
      if (bool)
      {
        try
        {
          sendRemoteReq(DataFactory.a("card_getinfo", paramString1, this.mOnRemoteResp.key, new Bundle()), false, false);
        }
        catch (Exception paramJsBridgeListener)
        {
          break label3262;
        }
      }
      else
      {
        paramJsBridgeListener = paramString1;
        bool = paramString3.equals("setSummaryCard");
        if (bool)
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("setSummaryCard :");
            paramJsBridgeListener.append(paramString2);
            QLog.d("DIYProfileTemplate.ProfileCardWebviewPlugin", 1, paramJsBridgeListener.toString());
          }
          paramJsBridgeListener = DataFactory.a("card_setSummaryCard", paramString1, this.mOnRemoteResp.key, new Bundle());
          paramJsBridgeListener.putInt("styleId", paramString2.getInt("styleId"));
          paramJsBridgeListener.putInt("bgId", paramString2.optInt("bgId", 0));
          paramJsBridgeListener.putLong("cardId", paramString2.optLong("cardId", 0L));
          paramJsBridgeListener.putString("extInfo", paramString2.optString("extInfo"));
          paramJsBridgeListener.putString("renderInfo", paramString2.optString("renderInfo"));
          sendRemoteReq(paramJsBridgeListener, false, false);
          break label3306;
        }
        paramJsBridgeListener = paramString1;
        bool = paramString3.equals("download");
        paramVarArgs = "bgId";
        long l1;
        long l2;
        if (bool)
        {
          paramJsBridgeListener = paramString2.getString("image_url");
          paramString3 = paramString2.optString("dynamicZip");
          l1 = paramString2.optInt("id");
          if (!ProfileCardManager.a(localContext, l1, "cardPreview.jpg")) {
            break label3317;
          }
          if (!QLog.isColorLevel()) {
            break label3314;
          }
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("handleJsRequest bg exists, dynamicZip = ");
          paramVarArgs.append(paramString3);
          QLog.d("ProfileCardWebviewPlugin", 2, paramVarArgs.toString());
          if (TextUtils.isEmpty(paramString3))
          {
            localJSONObject.put("result", 0);
            localJSONObject.put("message", "local has");
            a(paramString1, localJSONObject.toString());
            return true;
          }
          if (ProfileCardManager.a(localContext, l1, ".dynamic"))
          {
            localJSONObject.put("result", 0);
            localJSONObject.put("message", "local has");
            a(paramString1, localJSONObject.toString());
            return true;
          }
          if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext()))
          {
            localJSONObject.put("result", -2);
            localJSONObject.put("message", "no network");
            a(paramString1, localJSONObject.toString());
            return true;
          }
          l2 = ProfileCardUtil.a();
          if (l2 < 102400)
          {
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = new StringBuilder();
              paramJsBridgeListener.append("Insufficient SDCard space, reserved:");
              paramJsBridgeListener.append(102400);
              paramJsBridgeListener.append("|available:");
              paramJsBridgeListener.append(l2);
              QLog.d("ProfileCardWebviewPlugin", 2, paramJsBridgeListener.toString());
            }
            localJSONObject.put("result", -3);
            localJSONObject.put("message", "Insufficient SDCard space.");
            a(paramString1, localJSONObject.toString());
            return true;
          }
          if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) && (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g == VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger) && (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramJsBridgeListener)) && (paramString2.getLong("id") == ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangLong.longValue()))
          {
            ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
            ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_d_of_type_JavaLangString = paramString1;
            return true;
          }
          paramString2 = new VipProfileCardDownLoadInfo();
          paramString2.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
          paramString2.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString2.jdField_b_of_type_JavaLangString = paramString3;
          paramString2.jdField_d_of_type_JavaLangString = paramString1;
          paramString2.e = localInteger;
          paramString2.g = VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger;
          this.jdField_a_of_type_JavaUtilList.add(paramString2);
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
            break label3306;
          }
          a();
          break label3306;
        }
        paramJsBridgeListener = paramString1;
        bool = paramString3.equals("queryDownloadInfo");
        if (bool) {
          try
          {
            paramString3 = paramString2.getString("image_url");
            paramJsBridgeListener = paramString2.optString("dynamicZip");
            j = paramString2.optInt("id");
            l1 = j;
            if ((ProfileCardManager.a(localContext, l1, "cardPreview.jpg")) && ((TextUtils.isEmpty(paramJsBridgeListener)) || (ProfileCardManager.a(localContext, l1, ".dynamic"))))
            {
              ((JSONObject)localObject).put("status", 3);
              ((JSONObject)localObject).put("progress", 100);
              localJSONObject.put("result", 0);
            }
            else if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0)
            {
              ((JSONObject)localObject).put("status", 1);
              ((JSONObject)localObject).put("progress", 0);
              localJSONObject.put("result", 0);
            }
            else
            {
              i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
              paramJsBridgeListener = paramVarArgs;
              if (i < this.jdField_a_of_type_JavaUtilList.size())
              {
                if ((!((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) || (l1 != ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong.longValue()) || (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)) {
                  break label3320;
                }
                if (QLog.isColorLevel())
                {
                  paramString2 = new StringBuilder();
                  paramString2.append("mIndex:");
                  paramString2.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                  paramString2.append(",id:");
                  paramString2.append(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong);
                  paramString2.append("status:");
                  paramString2.append(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g);
                  QLog.i("ProfileCardWebviewPlugin", 2, paramString2.toString());
                }
                if ((((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g != VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger) && (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g != VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger))
                {
                  if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_c_of_type_JavaLangInteger)
                  {
                    ((JSONObject)localObject).put("status", 1);
                    ((JSONObject)localObject).put("progress", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).e);
                  }
                  else
                  {
                    ((JSONObject)localObject).put("status", 1);
                    ((JSONObject)localObject).put("progress", 0);
                  }
                  localJSONObject.put("result", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).f);
                }
                else
                {
                  paramString2 = DataFactory.a("card_query_download", paramString1, this.mOnRemoteResp.key, new Bundle());
                  paramString2.putInt(paramJsBridgeListener, j);
                  sendRemoteReq(paramString2, false, false);
                  return true;
                }
              }
              if (i >= this.jdField_a_of_type_JavaUtilList.size())
              {
                ((JSONObject)localObject).put("status", 1);
                ((JSONObject)localObject).put("progress", 0);
                localJSONObject.put("result", 0);
              }
            }
            localJSONObject.put("data", localObject);
            a(paramString1, localJSONObject.toString());
          }
          catch (Exception paramJsBridgeListener)
          {
            break label3262;
          }
        } else {
          try
          {
            if (paramString3.equals("preview"))
            {
              paramJsBridgeListener = new Intent(this.mRuntime.a(), VipProfileCardPreviewActivity.class);
              paramJsBridgeListener.putExtra("preview", paramString2.toString());
              super.startActivityForResult(paramJsBridgeListener, (byte)1);
              localJSONObject.put("result", 0);
            }
            try
            {
              localJSONObject.put("message", "ok");
              a(paramString1, localJSONObject.toString());
            }
            catch (Exception paramJsBridgeListener)
            {
              break label3262;
            }
            localObject = "message";
            if (paramString3.equals("getTime"))
            {
              localJSONObject.put("data", NetConnInfoCenter.getServerTimeMillis());
              localJSONObject.put("result", 0);
              localJSONObject.put((String)localObject, "");
              a(paramString1, localJSONObject.toString());
              break label3306;
            }
            if (paramString3.equals("cancelDownload"))
            {
              paramJsBridgeListener = paramString2.getString("image_url");
              l1 = paramString2.getLong("id");
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -1) {
                this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
              }
              i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
              if (i < this.jdField_a_of_type_JavaUtilList.size())
              {
                if ((((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong.longValue() != l1) || (!((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramJsBridgeListener)) || (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)) {
                  break label3329;
                }
                paramJsBridgeListener = DataFactory.a("card_cancel_download", paramString1, this.mOnRemoteResp.key, new Bundle());
                paramJsBridgeListener.putLong(paramVarArgs, l1);
                sendRemoteReq(paramJsBridgeListener, false, false);
                this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
                ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g = VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger;
                localJSONObject.put("result", 0);
                localJSONObject.put((String)localObject, "ok");
              }
              if (i == this.jdField_a_of_type_JavaUtilList.size())
              {
                localJSONObject.put("result", -2);
                paramJsBridgeListener = new StringBuilder();
                paramJsBridgeListener.append("cancel download fail， bgId:");
                paramJsBridgeListener.append(l1);
                localJSONObject.put((String)localObject, paramJsBridgeListener.toString());
              }
              a(paramString1, localJSONObject.toString());
              paramJsBridgeListener = new JSONObject();
              try
              {
                paramJsBridgeListener.put("result", -1);
                paramString2 = new StringBuilder();
                paramString2.append("cancel download bgUrl:");
                paramString2.append(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
                paramJsBridgeListener.put((String)localObject, paramString2.toString());
                a(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_JavaLangString, paramJsBridgeListener.toString());
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
            if (paramString3.equals("report"))
            {
              paramJsBridgeListener = DataFactory.a("card_getVipInfo", paramString1, this.mOnRemoteResp.key, new Bundle());
              paramJsBridgeListener.putString("op_name", paramString2.getString("op_name"));
              paramJsBridgeListener.putString("ext1", paramString2.getString("ext1"));
              paramJsBridgeListener.putString("ext2", paramString2.getString("ext2"));
              paramJsBridgeListener.putString("ext3", paramString2.getString("ext3"));
              sendRemoteReq(paramJsBridgeListener, false, false);
              break label3306;
            }
            if (paramString3.equals("openView"))
            {
              paramJsBridgeListener = paramString2.getString("ADTAG");
              paramString2 = this.mRuntime.a();
              if (paramString2 == null) {
                break label3306;
              }
              paramString3 = new Intent(paramString2, QQBrowserActivity.class);
              paramString3.putExtra("uin", this.mRuntime.a().getAccount());
              paramString3.putExtra("isShowAd", false);
              paramString3.putExtra("startOpenPageTime", System.currentTimeMillis());
              paramString3.putExtra("url", IndividuationUrlHelper.a(paramString2, "card", paramJsBridgeListener));
              paramString2.startActivity(paramString3);
              break label3306;
            }
            if (paramString3.equals("clickPhotoWall"))
            {
              paramJsBridgeListener = this.mRuntime.a(this.mRuntime.a());
              if ((paramJsBridgeListener != null) && ((paramJsBridgeListener instanceof WebUiUtils.WebUiMethodInterface)))
              {
                paramJsBridgeListener = ((WebUiUtils.WebUiMethodInterface)paramJsBridgeListener).getCurrentUrl();
                if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (paramJsBridgeListener.contains("entryId"))) {
                  this.jdField_a_of_type_Int = URLUtil.a(URLUtil.a(paramJsBridgeListener), "entryId", 2);
                } else {
                  this.jdField_a_of_type_Int = 2;
                }
              }
              paramJsBridgeListener = this.mRuntime.a().getAccount();
              paramString2 = QZoneHelper.UserInfo.getInstance();
              paramString2.qzone_uin = paramJsBridgeListener;
              QZoneHelper.forwardToCoverPhotoWall(this.mRuntime.a(), paramString2, null, paramJsBridgeListener, getRequestCode((byte)2));
              break label3306;
            }
            if (paramString3.equals("uploadBackground"))
            {
              b();
              localJSONObject.put("result", 0);
              localJSONObject.put((String)localObject, "ok");
              a(paramString1, localJSONObject.toString());
              break label3306;
            }
            if (paramString3.equals("setGameHonour"))
            {
              paramJsBridgeListener = DataFactory.a("card_set_custom_honor", paramString1, this.mOnRemoteResp.key, new Bundle());
              paramJsBridgeListener.putString("honor_data", paramString2.toString());
              sendRemoteReq(paramJsBridgeListener, false, false);
              break label3306;
            }
            if (paramString3.equals("downloadWzResource"))
            {
              l1 = paramString2.optLong("id");
              paramString3 = paramString2.optString("bgUrl");
              paramString2.optString("dynamicZip");
              paramJsBridgeListener = paramString2.optString("wzHeroUrl");
              if ((!VipWZRYTemplateHelper.a(paramString2.optInt("styleId"))) || (!VipWZRYTemplateHelper.a("cardWZ.zip"))) {
                break label3338;
              }
              i = 1;
              if ((TextUtils.isEmpty(paramString3)) || (!ProfileCardManager.a(localContext, l1, "wzJoinImage.png"))) {
                break label3344;
              }
              j = 1;
              if ((TextUtils.isEmpty(paramJsBridgeListener)) || (!ProfileCardManager.a(localContext, l1, "wzMainImage.png"))) {
                break label3350;
              }
              k = 1;
              if ((i != 0) && (j != 0))
              {
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  break label3356;
                }
                bool = ProfileCardManager.a(localContext, l1, "wzMainImage.png");
                if (bool)
                {
                  localJSONObject.put("result", 0);
                  localJSONObject.put("progress", 100);
                  callJs(paramString1, new String[] { localJSONObject.toString() });
                  return true;
                }
              }
              if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext()))
              {
                localJSONObject.put("result", -2);
                localJSONObject.put((String)localObject, "no network");
                a(paramString1, localJSONObject.toString());
                return true;
              }
              l2 = ProfileCardUtil.a();
              if (l2 < 102400)
              {
                if (QLog.isColorLevel())
                {
                  paramJsBridgeListener = new StringBuilder();
                  paramJsBridgeListener.append("Insufficient SDCard space, reserved:");
                  paramJsBridgeListener.append(102400);
                  paramJsBridgeListener.append("|available:");
                  paramJsBridgeListener.append(l2);
                  QLog.d("ProfileCardWebviewPlugin", 2, paramJsBridgeListener.toString());
                }
                localJSONObject.put("result", -3);
                localJSONObject.put((String)localObject, "Insufficient SDCard space.");
                a(paramString1, localJSONObject.toString());
                return true;
              }
              if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < this.jdField_a_of_type_JavaUtilList.size()))
              {
                paramString2 = (VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) && (paramString2.g.equals(VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)) && (paramString2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) && (l1 == paramString2.jdField_a_of_type_JavaLangLong.longValue()))
                {
                  paramString2.g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
                  paramString2.jdField_d_of_type_JavaLangString = paramString1;
                  return true;
                }
              }
              paramString2 = new VipProfileCardDownLoadInfo();
              paramString2.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
              paramString2.jdField_a_of_type_JavaLangString = paramString3;
              paramString2.jdField_d_of_type_JavaLangString = paramString1;
              if (k == 0) {
                break label3362;
              }
              paramJsBridgeListener = null;
              paramString2.jdField_c_of_type_JavaLangString = paramJsBridgeListener;
              if (i != 0) {
                break label3365;
              }
              bool = true;
              paramString2.jdField_b_of_type_Boolean = bool;
              paramString2.jdField_a_of_type_Boolean = true;
              paramString2.e = localInteger;
              paramString2.g = VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger;
              this.jdField_a_of_type_JavaUtilList.add(paramString2);
              if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
                break label3306;
              }
              a();
              break label3306;
            }
            if (paramString3.equals("setSwitchOfKingGlory"))
            {
              i = paramString2.optInt("status");
              paramJsBridgeListener = new Bundle();
              paramJsBridgeListener.putInt("status", i);
              sendRemoteReq(DataFactory.a("ipc_plateofking_switch", paramString1, this.mOnRemoteResp.key, paramJsBridgeListener), false, false);
              break label3306;
            }
            return false;
          }
          catch (Exception paramJsBridgeListener) {}
        }
      }
      paramJsBridgeListener.printStackTrace();
    }
    catch (Exception paramString2)
    {
      paramString1 = paramJsBridgeListener;
      paramJsBridgeListener = paramString2;
    }
    try
    {
      label3262:
      localJSONObject.put("result", -1);
      localJSONObject.put("message", "ProfileCardWebviewPlugin Exception");
      a(paramString1, localJSONObject.toString());
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
    label3306:
    return true;
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ProfileCardWebviewPlugin onActivityResult,requestCode = ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", data = ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("ProfileCardWebviewPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != -1) {
      return;
    }
    if (paramIntent != null)
    {
      if ((paramByte == 1) || (paramByte == 2)) {}
      try
      {
        if (this.jdField_a_of_type_Int != 0)
        {
          String str = paramIntent.getStringExtra("uin");
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.mRuntime.a().getCurrentAccountUin();
          }
          localObject = new AllInOne((String)localObject, 0);
          localObject = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.a(), (AllInOne)localObject);
          this.mRuntime.a().startActivity((Intent)localObject);
        }
        paramIntent.putExtra("closeSpecialLogic", true);
        this.mRuntime.a().setResult(-1, paramIntent);
        this.mRuntime.a().finish();
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregister receiver exception:");
        localStringBuilder.append(localException.toString());
        QLog.d("ProfileCardWebviewPlugin", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
        {
          Object localObject2 = new JSONObject();
          Object localObject1 = new JSONObject();
          String str2 = paramBundle.getString("cmd");
          String str1 = paramBundle.getString("callbackid");
          Bundle localBundle = paramBundle.getBundle("response");
          if (str2 != null)
          {
            boolean bool = "card_getinfo".equals(str2);
            if (bool)
            {
              long l1 = localBundle.getLong("currentId");
              long l2 = localBundle.getLong("styleId");
              int j = localBundle.getInt("result");
              paramBundle = localBundle.getString("diy_url");
              if ((l2 == ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL) || (l2 == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID)) {
                break label823;
              }
              if (l2 != ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
                break label818;
              }
              break label823;
              ((JSONObject)localObject2).put("currentId", l1);
              ((JSONObject)localObject2).put("styleId", l2);
              ((JSONObject)localObject2).put("isPhotoWall", i);
              ((JSONObject)localObject2).put("url", paramBundle);
              ((JSONObject)localObject1).put("data", localObject2);
              ((JSONObject)localObject1).put("result", j);
              a(str1, ((JSONObject)localObject1).toString());
              return;
            }
            bool = "card_setSummaryCard".equals(str2);
            if (bool)
            {
              i = localBundle.getInt("result");
              paramBundle = localBundle.getString("message");
              ((JSONObject)localObject1).put("result", i);
              ((JSONObject)localObject1).put("message", paramBundle);
              a(str1, ((JSONObject)localObject1).toString());
              return;
            }
            if ("card_getVipInfo".equals(str2))
            {
              ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", paramBundle.getString("op_name"), paramBundle.getString("op_name"), 0, 0, paramBundle.getString("ext1"), paramBundle.getString("ext2"), paramBundle.getString("ext3"), localBundle.getString("vip_info"));
              ((JSONObject)localObject1).put("result", 0);
              ((JSONObject)localObject1).put("message", "ok");
              a(str1, ((JSONObject)localObject1).toString());
              return;
            }
            if (!"selectPhoto".equals(str2))
            {
              if ("takePhoto".equals(str2)) {
                return;
              }
              bool = "card_download_wzry_template".equals(str2);
              if (bool)
              {
                i = localBundle.getInt("result");
                localObject2 = localBundle.getString("message");
                if (i != 0)
                {
                  ((JSONObject)localObject1).put("result", -1);
                  ((JSONObject)localObject1).put("message", localObject2);
                  a(str1, ((JSONObject)localObject1).toString());
                  this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
                  return;
                }
                localObject1 = DataFactory.a("card_download", str1, this.mOnRemoteResp.key, new Bundle());
                ((Bundle)localObject1).putLong("bgId", paramBundle.getLong("bgId"));
                sendRemoteReq((Bundle)localObject1, false, false);
                return;
              }
              if ("card_download".equals(str2))
              {
                ((JSONObject)localObject1).put("result", localBundle.getInt("result"));
                ((JSONObject)localObject1).put("message", "onHttpEnd");
                if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger) {
                  ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_c_of_type_JavaLangInteger;
                }
                ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(100);
                a(str1, ((JSONObject)localObject1).toString());
                this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
                a();
                return;
              }
              if ("card_query_download".equals(str2))
              {
                ((JSONObject)localObject1).put("result", 0);
                ((JSONObject)localObject2).put("status", 2);
                i = localBundle.getInt("progress");
                ((JSONObject)localObject2).put("progress", i);
                if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.jdField_c_of_type_JavaLangInteger) {
                  ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(i);
                }
                ((JSONObject)localObject1).put("data", localObject2);
                a(str1, ((JSONObject)localObject1).toString());
              }
            }
            else
            {
              return;
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      return;
      label818:
      int i = 0;
      continue;
      label823:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */