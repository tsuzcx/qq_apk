package com.tencent.mobileqq.jsp;

import admx;
import admy;
import admz;
import adna;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.troop.utils.TroopDeviceUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopApiPlugin
  extends WebViewPlugin
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new adna(this);
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  public String a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  TroopMemberApiClient jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient;
  String jdField_b_of_type_JavaLangString;
  String c;
  public String d;
  public String e;
  
  public TroopApiPlugin()
  {
    this.mPluginNameSpace = "troopApi";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.a() != null) {
      QQToast.a(this.mRuntime.a(), paramInt2, this.mRuntime.a().getString(paramInt1), 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131558448));
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramTroopInfo.troopuin, this.jdField_b_of_type_Int, null);
  }
  
  private void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Context localContext = a();
        if (localContext != null)
        {
          localJSONObject.put("contactsnum", TroopDeviceUtil.b(localContext));
          localJSONObject.put("appnum", TroopDeviceUtil.a(localContext));
          localJSONObject.put("medianum", TroopDeviceUtil.c(localContext) + TroopDeviceUtil.d(localContext));
          localJSONObject.put("storage", TroopDeviceUtil.c() + TroopDeviceUtil.a());
          localJSONObject.put("storagetotal", TroopDeviceUtil.d() + TroopDeviceUtil.b());
          if (Build.VERSION.SDK_INT < 23) {
            break label216;
          }
          if (!TroopDeviceUtil.a(localContext, 4))
          {
            j = 1;
            i = j;
            if (!TroopDeviceUtil.a(localContext, 59)) {
              i = j + 2;
            }
            localJSONObject.put("result", i);
            callJs(paramString, new String[] { localJSONObject.toString() });
          }
        }
        else
        {
          i = -1;
          continue;
        }
        int j = 0;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopApiPlugin", 2, "sendDeviceInfoToWeb JSONException:" + localJSONException);
        }
        callJs(paramString, new String[] { "{\"result\":-1}" });
        return;
      }
      continue;
      label216:
      int i = 0;
    }
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      Intent localIntent = AddFriendLogicActivity.a(a(), paramTroopInfo.troopuin, paramTroopInfo.getTroopName(), paramTroopInfo.cGroupOption, this.jdField_b_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.c);
      this.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
      startActivityForResult(localIntent, (byte)3);
      return;
    }
    this.jdField_a_of_type_Int = -1;
    a(2131434414);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troopApi".equals(paramString2)) {
      return false;
    }
    if ("createReward".equals(paramString3)) {}
    for (;;)
    {
      return true;
      if (!"openRewardDetail".equals(paramString3)) {
        if ("previewRewardVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            if (QLog.isColorLevel()) {
              QLog.d("TroopApiPlugin", 2, "previewRewardVideo:" + paramString2);
            }
            paramJsBridgeListener = paramString2.optString("troopUin");
            paramString1 = paramString2.optString("rewardId");
            long l1 = paramString2.optLong("videoSize");
            long l2 = paramString2.optLong("videoDuration");
            paramString2 = paramString2.optString("callback");
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramJsBridgeListener, paramString1, new admx(this, l1, l2, paramString2));
          }
          catch (Exception paramJsBridgeListener) {}
          if (QLog.isColorLevel()) {
            QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramJsBridgeListener);
          }
        }
        else if ("setRedPoint".equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            if (QLog.isColorLevel()) {
              QLog.d("TroopRankConfig", 2, "setRedPoint:" + paramString1);
            }
            paramJsBridgeListener = paramString1.optString("troopUin");
            paramString1 = paramString1.optString("memberUin");
            if (!TroopRankConfig.a().a(paramJsBridgeListener, paramString1)) {
              continue;
            }
            paramString1 = this.mRuntime.a();
            paramJsBridgeListener = this.mRuntime.a();
            if ((paramString1 == null) || (!(paramString1 instanceof AbsBaseWebViewActivity))) {
              break label428;
            }
            paramJsBridgeListener = (AbsBaseWebViewActivity)paramString1;
            paramJsBridgeListener.rightViewImg.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramJsBridgeListener);
            paramString1 = (RelativeLayout)paramJsBridgeListener.findViewById(2131362677);
            if (paramString1 == null) {
              continue;
            }
            paramString2 = new RelativeLayout.LayoutParams(-2, -2);
            paramString2.addRule(7, 2131363410);
            paramString2.setMargins(0, AIOUtils.a(5.0F, paramJsBridgeListener.getResources()), AIOUtils.a(5.0F, paramJsBridgeListener.getResources()), 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString2);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845924);
            paramString1.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
          catch (Exception paramJsBridgeListener) {}
          if (QLog.isColorLevel())
          {
            QLog.w("TroopRankConfig", 2, "setRedPoint exp", paramJsBridgeListener);
            continue;
            label428:
            if (paramJsBridgeListener != null)
            {
              paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramJsBridgeListener.getActivity());
              paramString1 = (RelativeLayout)paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.findViewById(2131362677);
              if (paramString1 != null)
              {
                paramString2 = new RelativeLayout.LayoutParams(-2, -2);
                paramString2.addRule(7, 2131363410);
                paramString2.setMargins(0, AIOUtils.a(5.0F, paramJsBridgeListener.getResources()), AIOUtils.a(5.0F, paramJsBridgeListener.getResources()), 0);
                this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString2);
                this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845924);
                paramString1.addView(this.jdField_a_of_type_AndroidWidgetImageView);
              }
            }
          }
        }
        else
        {
          int i;
          if ("openEditUniqTitle".equals(paramString3))
          {
            try
            {
              paramString2 = new JSONObject(paramVarArgs[0]);
              this.jdField_b_of_type_JavaLangString = paramString2.getString("callback");
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "openEditUniqTitle:" + paramString2);
              }
              paramJsBridgeListener = paramString2.optString("troopUin");
              paramString1 = paramString2.optString("memberUin");
              i = paramString2.optInt("memberRole");
              paramString2 = paramString2.optString("uniqueTitle");
              startActivityForResult(EditUniqueTitleActivity.a(this.mRuntime.a(), 1, paramJsBridgeListener, paramString1, i, paramString2), (byte)4);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "openEditUniqTitle exp", paramJsBridgeListener);
            }
          }
          else if ("saveTroopMemberTitle".equals(paramString3))
          {
            try
            {
              this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
              this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.a();
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "saveTroopMemberTitle:" + paramJsBridgeListener);
              }
              paramString1 = paramJsBridgeListener.optString("troopUin");
              paramString2 = paramJsBridgeListener.optString("memberUin");
              i = paramJsBridgeListener.optInt("titleId");
              this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramString2, i);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "saveTroopMemberTitle exp:", paramJsBridgeListener);
            }
          }
          else if ("clickMineButton".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "clickMineButton:" + paramString1);
              }
              paramJsBridgeListener = paramString1.optString("troopUin");
              paramString1 = paramString1.optString("memberUin");
              if (!TroopRankConfig.a().a(paramJsBridgeListener, paramString1)) {
                continue;
              }
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              TroopRankConfig.a().a(paramJsBridgeListener, paramString1, false);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "clickMineButton exp", paramJsBridgeListener);
            }
          }
          else if ("addTroop".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "AddTroop:" + paramString1);
              }
              paramJsBridgeListener = paramString1.optString("troopUin");
              this.jdField_b_of_type_Int = Integer.parseInt(paramString1.optString("sourceid"));
              this.c = paramString1.optString("sourcename");
              this.jdField_a_of_type_JavaLangString = paramString1.optString("callback");
              paramString1 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
              paramString2 = (TroopInfo)paramString1.a(TroopInfo.class, paramJsBridgeListener);
              paramString1.a();
              if (paramString2 != null) {
                a(2131434413);
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "AddTroop JSONException:" + paramJsBridgeListener);
              }
              callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
              continue;
              this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, 8390785);
            }
            catch (Exception paramJsBridgeListener)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "AddTroop Exception:" + paramJsBridgeListener);
              }
              callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-10,\"message\":\"request fail\"}" });
            }
          }
          else if ("huanjiStatus".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("pluginPackageName");
              paramString2 = paramJsBridgeListener.optString("pluginID");
              paramString3 = paramJsBridgeListener.optString("versionCode");
              this.d = paramJsBridgeListener.optString("callback");
              this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramString2, paramString3, new admy(this));
            }
            catch (JSONException paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "HuanjiStatus JSONException:" + paramJsBridgeListener);
            }
          }
          else if ("huanjiDownload".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("via");
              paramString2 = paramJsBridgeListener.optString("startParam");
              paramString3 = paramJsBridgeListener.optString("pluginId");
              i = paramJsBridgeListener.optInt("action");
              this.e = paramJsBridgeListener.optString("callback");
              this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(i, paramString1, paramString3, paramString2, new admz(this));
            }
            catch (JSONException paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "huanjiDownload JSONException:" + paramJsBridgeListener);
            }
          }
          else if ("huanjiGetInfo".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "huanjiGetInfo");
              }
              a(paramJsBridgeListener.optString("callback"));
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "huanjiGetInfo Exception:" + paramJsBridgeListener);
            }
          }
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt != -1) {
        break label94;
      }
      if (paramIntent != null) {
        break label75;
      }
      paramIntent = "";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 0);
        localJSONObject.put("uniqueTitle", paramIntent);
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
        label75:
        paramIntent = paramIntent.getStringExtra("newUniqueTitle");
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
    label94:
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {}
    do
    {
      return;
      a();
    } while (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
    if (this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin
 * JD-Core Version:    0.7.0.1
 */