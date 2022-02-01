package com.tencent.mobileqq.config.splashlogo;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.qwallet.PayInterceptHelper;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class ConfigServlet$10
  implements Runnable
{
  ConfigServlet$10(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    HashMap localHashMap = new HashMap(8);
    int m = SharedPreUtils.G(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), ConfigServlet.a);
    int i;
    int j;
    label117:
    Object localObject4;
    JSONObject localJSONObject;
    label322:
    Object localObject2;
    label431:
    String str2;
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config != null) && (i != m))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, String.format("qwallet config update %s -> %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
        }
        if (i == m) {
          break label1717;
        }
        j = i;
        if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content_list is empty ,version: " + i);
          }
          return;
        }
        int n = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size();
        int k = 0;
        for (localObject1 = localObject3;; localObject1 = localObject4)
        {
          localObject3 = localObject1;
          if (k >= n) {
            break label1528;
          }
          localObject4 = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(k);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content: " + (String)localObject4 + ",version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break;
          }
          localObject4 = localObject1;
          k += 1;
        }
        localObject3 = localObject1;
        do
        {
          try
          {
            localJSONObject = new JSONObject((String)localObject4);
            localObject3 = localObject1;
            Iterator localIterator = localJSONObject.keys();
            for (;;)
            {
              localObject4 = localObject1;
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = localObject1;
              localObject4 = (String)localIterator.next();
              localObject3 = localObject1;
              if (!"hb_face".equals(localObject4)) {
                break label431;
              }
              localObject3 = localObject1;
              localObject4 = localJSONObject.optJSONObject((String)localObject4);
              localObject3 = localObject1;
              HbThemeConfigManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (JSONObject)localObject4);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException1)
          {
            localObject4 = localObject3;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException1);
          localObject4 = localObject3;
          break;
          localObject3 = localException1;
          if ("hb_normal".equals(localObject4))
          {
            localObject3 = localException1;
            localObject4 = localJSONObject.optJSONObject((String)localObject4);
            if (i <= j) {
              break label1714;
            }
            localObject2 = localObject4;
            break label1728;
          }
          localObject3 = localObject2;
          if (!"F2FRedpack".equals(localObject4)) {
            break label710;
          }
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
        } while (localObject4 == null);
        localObject3 = localObject2;
        str2 = ConfigServlet.a;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackEntry", 0) != 1) {
          break label1731;
        }
        bool = true;
        label530:
        localObject3 = localObject2;
        QWalletSetting.a(str2, "F2FRedpackEntry", bool);
        localObject3 = localObject2;
        str2 = ConfigServlet.a;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackQRCheck", 1) != 1) {
          break label1737;
        }
        bool = true;
        label571:
        localObject3 = localObject2;
        QWalletSetting.a(str2, "F2FRedpackQRCheck", bool);
        localObject3 = localObject2;
        str2 = ConfigServlet.a;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackGIF", 1) != 1) {
          break label1743;
        }
      }
    }
    label710:
    label1737:
    label1743:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        localObject3 = localObject2;
        QWalletSetting.a(str2, "F2FRedpackGIF", bool);
        localObject3 = localObject2;
        long l1 = QWalletTools.b(((JSONObject)localObject4).optString("EntryColorBeginTime"));
        localObject3 = localObject2;
        long l2 = QWalletTools.b(((JSONObject)localObject4).optString("EntryColorEndTime"));
        if ((l1 < 0L) || (l2 < 0L)) {
          break label322;
        }
        localObject3 = localObject2;
        QWalletSetting.a(ConfigServlet.a, "F2FRedpack_EntryColorBeginTime", l1 / 1000L);
        localObject3 = localObject2;
        QWalletSetting.a(ConfigServlet.a, "F2FRedpack_EntryColorEndTime", l2 / 1000L);
        break label322;
        localObject3 = localObject2;
        int i1;
        if ("preload_config".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label322;
          }
          localObject3 = localObject2;
          i1 = ((JSONObject)localObject4).optInt("deal_delay_interval", 0);
          localObject3 = localObject2;
          int i2 = ((JSONObject)localObject4).optInt("need_wait_size", 0);
          localObject3 = localObject2;
          ((IPreloadService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreloadService.class, "")).setPreloadHelpConfig(i1, i2);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "deal_delay_interval", i1);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "need_wait_size", i2);
          break label322;
        }
        localObject3 = localObject2;
        if ("skin_map".equals(localObject4)) {
          break label322;
        }
        localObject3 = localObject2;
        if ("skin_entry_error_tips".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.getString((String)localObject4);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "skin_entry_error_tips", (String)localObject4);
          break label322;
        }
        localObject3 = localObject2;
        if ("InterceptAppOpenConfig".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONArray((String)localObject4);
          localObject3 = localObject2;
          PayInterceptHelper.a().a((JSONArray)localObject4, ConfigServlet.a);
          break label322;
        }
        localObject3 = localObject2;
        if ("strangerchat_ext".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optString((String)localObject4, "");
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label322;
          }
          localObject3 = localObject2;
          QWalletSetting.a("", "strangerchat_ext", Base64.encodeToString(((String)localObject4).getBytes(), 0));
          break label322;
        }
        localObject3 = localObject2;
        if ("RedpackPopWnd".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label322;
          }
          localObject3 = localObject2;
          i1 = ((JSONObject)localObject4).optInt("PopWndID");
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_id", ((JSONObject)localObject4).optInt("PopWndID"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_group_type_" + i1, ((JSONObject)localObject4).optString("GroupType"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_url_" + i1, ((JSONObject)localObject4).optString("URL"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_state_" + i1, ((JSONObject)localObject4).optString("RedpackState"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_freq_" + i1, ((JSONObject)localObject4).optInt("PopWndFreq"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_total_" + i1, ((JSONObject)localObject4).optInt("PopWndTotalCount"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_network_" + i1, ((JSONObject)localObject4).optString("PopWndNetworkType"));
          localObject3 = localObject2;
          l1 = QWalletTools.b(((JSONObject)localObject4).optString("PopWndBeginTime"));
          localObject3 = localObject2;
          l2 = QWalletTools.b(((JSONObject)localObject4).optString("PopWndEndTime"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_begin_time_" + i1, l1 / 1000L);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_end_time_" + i1, l2 / 1000L);
          break label322;
        }
        localObject3 = localObject2;
        if ("image_urls".equals(localObject4)) {
          break label322;
        }
        localObject3 = localObject2;
        if ("hb_theme".equals(localObject4)) {
          break label322;
        }
        localObject3 = localObject2;
        if ("hb_theme_group".equals(localObject4)) {
          break label322;
        }
        localObject3 = localObject2;
        localHashMap.put(localObject4, localJSONObject.opt((String)localObject4));
        break label322;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG remote version: " + i + " | localVersion: " + m);
          localObject3 = localObject2;
        }
        try
        {
          label1528:
          if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config == null) || (i == m)) {
            break;
          }
          SharedPreUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), ConfigServlet.a, i);
          localObject2 = new JSONObject();
          if (localObject3 != null) {
            ((JSONObject)localObject2).put("hb_normal", localObject3);
          }
          if (localHashMap.isEmpty()) {
            break label1671;
          }
          localObject3 = localHashMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            ((JSONObject)localObject2).put((String)((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue());
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException2) {}
      }
      QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException2);
      return;
      localHashMap.clear();
      localObject3 = HbThemeConfigManager.a();
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localException2.length() > 0) {}
      for (String str1 = localException2.toString();; str1 = "")
      {
        ((HbThemeConfigManager)localObject3).a((QQAppInterface)localObject4, str1);
        return;
      }
      break label1728;
      j = m;
      break label117;
      i = 0;
      break;
      break label322;
      bool = false;
      break label530;
      bool = false;
      break label571;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.10
 * JD-Core Version:    0.7.0.1
 */