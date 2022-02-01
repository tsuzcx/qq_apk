package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneBannerJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  public static final int UNIT_DP = 2;
  public static final int UNIT_PX = 1;
  public static final int UNIT_RATION = 3;
  private String TAG = QzoneBannerJsPlugin.class.getSimpleName();
  
  private JSONObject toJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, paramString, new Object[0]);
    }
    return null;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("Qzone".equals(paramString2)) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null)) {
        paramJsBridgeListener = this.parentPlugin.mRuntime.a();
      } else {
        paramJsBridgeListener = null;
      }
      if (paramJsBridgeListener != null)
      {
        paramString1 = paramJsBridgeListener.getTag(2131368394);
        if ((paramString1 != null) && ((paramString1 instanceof WebViewBannerInterface)))
        {
          paramString1 = (WebViewBannerInterface)paramString1;
          int i;
          if (("setBannerHeight".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
          {
            paramJsBridgeListener = toJson(paramVarArgs[0]);
            if (paramJsBridgeListener == null)
            {
              QLog.e(this.TAG, 1, "setBannerHeight 方法参数错误！！！！");
              return false;
            }
            double d1 = paramJsBridgeListener.optDouble("height");
            if (d1 <= 0.0D)
            {
              QLog.e(this.TAG, 1, "setBannerHeight 方法参数错误 height<=0 ！！！！  )");
              return true;
            }
            i = paramJsBridgeListener.optInt("unit");
            paramJsBridgeListener = this.TAG;
            paramString2 = new StringBuilder();
            paramString2.append("setBannerHeight height:");
            paramString2.append(d1);
            paramString2.append(",unit:");
            paramString2.append(i);
            QLog.i(paramJsBridgeListener, 1, paramString2.toString());
            if (i == 1)
            {
              paramString1.setBannerHeight((int)d1);
              return true;
            }
            if (i == 2)
            {
              paramString1.setBannerHeight((int)ViewUtils.a((float)d1));
              return true;
            }
            if (i == 3)
            {
              double d2 = ViewUtils.a();
              Double.isNaN(d2);
              paramString1.setBannerHeight((int)(d1 * d2));
              return true;
            }
            paramJsBridgeListener = this.TAG;
            paramString1 = new StringBuilder();
            paramString1.append("setBannerHeight 方法参数错误 :unit= ");
            paramString1.append(i);
            QLog.e(paramJsBridgeListener, 1, paramString1.toString());
            return true;
          }
          if ("closeBanner".equals(paramString3))
          {
            QLog.i(this.TAG, 1, "closeBanner:");
            paramString1.close();
            return true;
          }
          if (("enableGesture".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
          {
            paramJsBridgeListener = toJson(paramVarArgs[0]);
            if (paramJsBridgeListener == null)
            {
              QLog.e(this.TAG, 1, "enableGesture 方法参数错误！！！！");
              return true;
            }
            boolean bool = paramJsBridgeListener.optBoolean("enable");
            paramJsBridgeListener = this.TAG;
            paramString2 = new StringBuilder();
            paramString2.append("enableGesture enable:");
            paramString2.append(bool);
            QLog.i(paramJsBridgeListener, 1, paramString2.toString());
            paramString1.enableGesture(bool);
            return true;
          }
          if (("getBannerData".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
          {
            paramString2 = toJson(paramVarArgs[0]);
            if (paramString2 == null)
            {
              QLog.e(this.TAG, 1, "getBannerData 方法参数错误！！！！");
              return true;
            }
            paramString2 = paramString2.optString("callback");
            if (TextUtils.isEmpty(paramString2)) {
              QLog.e(this.TAG, 1, "getBannerData 方法参数错误！！！！");
            }
            paramString1 = paramString1.getBannerData();
            paramJsBridgeListener.callJs(paramString2, new String[] { paramString1 });
            paramJsBridgeListener = this.TAG;
            paramString2 = new StringBuilder();
            paramString2.append("getBannerData ");
            paramString2.append(paramString1);
            QLog.i(paramJsBridgeListener, 1, paramString2.toString());
            return true;
          }
          if (("qbossReport".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
          {
            paramString2 = toJson(paramVarArgs[0]);
            if (paramString2 == null)
            {
              QLog.e(this.TAG, 1, "qbossReport 方法参数错误！！！！");
              return true;
            }
            paramJsBridgeListener = paramString2.optString("sQBosstrace");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              QLog.e(this.TAG, 1, "qbossReport 方法参数错误！！！！");
            }
            i = paramString2.optInt("type");
            paramString2 = paramString2.optString("reportInfo");
            paramString1.qbossReport(i, paramJsBridgeListener, paramString2);
            paramString1 = this.TAG;
            paramString3 = new StringBuilder();
            paramString3.append("qbossReport type:");
            paramString3.append(i);
            paramString3.append(",qBosstrace:");
            paramString3.append(paramJsBridgeListener);
            paramString3.append(" ,reportInfo:");
            paramString3.append(paramString2);
            QLog.i(paramString1, 1, paramString3.toString());
            return true;
          }
          return false;
        }
        paramJsBridgeListener = this.TAG;
        paramString2 = new StringBuilder();
        paramString2.append("webViewBannerInterface error o=");
        paramString2.append(paramString1);
        QLog.e(paramJsBridgeListener, 1, paramString2.toString());
        return false;
      }
      QLog.e(this.TAG, 1, "handleJsRequest webView==null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneBannerJsPlugin
 * JD-Core Version:    0.7.0.1
 */