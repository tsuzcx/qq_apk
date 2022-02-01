package com.tencent.mobileqq.qwallet.utils.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.utils.IPayInterceptApi;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;

public class PayInterceptApiImpl
  implements IPayInterceptApi
{
  private static final String KEY_INTERCEPT_CONFIG = "InterceptAppOpenConfig";
  private static final String PREF_NAME_INTERCEPT = "qwallet_intercept";
  public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDsE3WI7sDFUi6QWV/oK8qozDvS\nTlxmu1a3NSFxeOrjlVEVtOx8yIMVFYIixq/Fv1XgUlyvL7bGJbaLLKaqlYruGd2z\nNbaIz90Zm4H0pMFHx4vCYhsRP1HXbVMo2ZDiHEDbnSm/99uzFPPiXqLi8jE9t4if\n0GuYdSZfe5o+SIKT5QIDAQAB";
  private static final String TAG = "PayInterceptApi";
  private static volatile IPayInterceptApi sInstance;
  private List<PayInterceptApiImpl.InterceptConfig> mConfigs = null;
  
  public PayInterceptApiImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QWalletHelperImpl.getAppRuntime().getLongAccountUin());
    localStringBuilder.append("");
    loadConfigFromSP(localStringBuilder.toString());
  }
  
  public static String RSADecrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        paramString2 = new X509EncodedKeySpec(Base64.decode(paramString2, 0));
        paramString2 = KeyFactory.getInstance("RSA").generatePublic(paramString2);
        paramString1 = Base64.decode(paramString1, 0);
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(2, paramString2);
        paramString1 = new String(localCipher.doFinal(paramString1));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  private String getConfigFromSp(String paramString)
  {
    Object localObject3 = MobileQQ.sMobileQQ;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplication)localObject3).getSharedPreferences("qwallet_intercept", 4);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InterceptAppOpenConfig");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((SharedPreferences)localObject3).getString(((StringBuilder)localObject1).toString(), null);
      }
    }
    return localObject1;
  }
  
  private void saveConfigToSP(String paramString1, String paramString2)
  {
    Object localObject = MobileQQ.sMobileQQ;
    if (localObject != null)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("qwallet_intercept", 4);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("InterceptAppOpenConfig");
        localStringBuilder.append(paramString2);
        ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString1).commit();
      }
    }
  }
  
  public void loadConfigFromSP(String paramString)
  {
    paramString = getConfigFromSp(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      this.mConfigs = PayInterceptApiImpl.InterceptConfig.a(paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("loadConfigFromSP|");
      paramString.append(this.mConfigs);
      QLog.d("PayInterceptApi", 2, paramString.toString());
    }
  }
  
  public void saveConfig(JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray != null) {
      saveConfigToSP(paramJSONArray.toString(), paramString);
    }
    loadConfigFromSP(paramString);
  }
  
  public boolean tryIntercept(String paramString, Object paramObject)
  {
    paramObject = (WebViewProvider)paramObject;
    if ((this.mConfigs != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramObject == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleIntercept:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("PayInterceptApi", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramObject.getWebView();
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((WebView)localObject1).copyBackForwardList();
      if (localObject2 != null)
      {
        if (((WebBackForwardList)localObject2).getCurrentIndex() != ((WebBackForwardList)localObject2).getSize() - 1) {
          return false;
        }
        Object localObject3 = this.mConfigs.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (PayInterceptApiImpl.InterceptConfig)((Iterator)localObject3).next();
          if (!TextUtils.isEmpty(((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_b_of_type_JavaLangString))
          {
            if (((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_a_of_type_JavaUtilRegexPattern == null) {
              ((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_b_of_type_JavaLangString);
            }
            if (((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches())
            {
              paramObject = (SwiftBrowserStatistics)paramObject.getComponentProvider().a(-2);
              if (paramObject != null)
              {
                paramObject = paramObject.a;
                if ((paramObject != null) && (paramObject.size() > 0))
                {
                  paramObject = (String)paramObject.get(0);
                  break label244;
                }
              }
              paramObject = "";
              label244:
              boolean bool;
              if (TextUtils.isEmpty(((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_a_of_type_JavaLangString))
              {
                bool = true;
              }
              else
              {
                if (((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_b_of_type_JavaUtilRegexPattern == null) {
                  ((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile(((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_a_of_type_JavaLangString);
                }
                bool = ((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_b_of_type_JavaUtilRegexPattern.matcher(paramObject).matches();
              }
              if (bool)
              {
                if (((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_a_of_type_Boolean)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("originURL=");
                  ((StringBuilder)localObject3).append(paramObject);
                  ((StringBuilder)localObject3).append("|interceptURL=");
                  ((StringBuilder)localObject3).append(paramString);
                  VACDReportUtil.a(((StringBuilder)localObject3).toString(), "qqwallet", "InterceptOpenOtherApp", null, null, 0, null);
                }
                if (!((PayInterceptApiImpl.InterceptConfig)localObject2).jdField_b_of_type_Boolean) {
                  return false;
                }
                if (!TextUtils.isEmpty(((PayInterceptApiImpl.InterceptConfig)localObject2).c))
                {
                  if (TextUtils.isEmpty(((PayInterceptApiImpl.InterceptConfig)localObject2).d)) {
                    ((PayInterceptApiImpl.InterceptConfig)localObject2).d = RSADecrypt(((PayInterceptApiImpl.InterceptConfig)localObject2).c, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDsE3WI7sDFUi6QWV/oK8qozDvS\nTlxmu1a3NSFxeOrjlVEVtOx8yIMVFYIixq/Fv1XgUlyvL7bGJbaLLKaqlYruGd2z\nNbaIz90Zm4H0pMFHx4vCYhsRP1HXbVMo2ZDiHEDbnSm/99uzFPPiXqLi8jE9t4if\n0GuYdSZfe5o+SIKT5QIDAQAB");
                  }
                  paramObject = ((PayInterceptApiImpl.InterceptConfig)localObject2).d;
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("jumpUrl:");
                    ((StringBuilder)localObject2).append(paramObject);
                    QLog.d("PayInterceptApi", 2, ((StringBuilder)localObject2).toString());
                  }
                  if (TextUtils.isEmpty(paramObject)) {
                    return false;
                  }
                  if (paramObject.contains("?"))
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(paramObject);
                    ((StringBuilder)localObject2).append("&j=");
                    paramObject = ((StringBuilder)localObject2).toString();
                  }
                  else
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(paramObject);
                    ((StringBuilder)localObject2).append("?j=");
                    paramObject = ((StringBuilder)localObject2).toString();
                  }
                  try
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(paramObject);
                    ((StringBuilder)localObject2).append(URLEncoder.encode(paramString, "UTF-8"));
                    paramString = ((StringBuilder)localObject2).toString();
                    paramObject = paramString;
                  }
                  catch (UnsupportedEncodingException paramString)
                  {
                    paramString.printStackTrace();
                  }
                  if (QLog.isColorLevel())
                  {
                    paramString = new StringBuilder();
                    paramString.append("jumpUrl with params:");
                    paramString.append(paramObject);
                    QLog.d("PayInterceptApi", 2, paramString.toString());
                  }
                  ((WebView)localObject1).loadUrl(paramObject);
                }
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.PayInterceptApiImpl
 * JD-Core Version:    0.7.0.1
 */