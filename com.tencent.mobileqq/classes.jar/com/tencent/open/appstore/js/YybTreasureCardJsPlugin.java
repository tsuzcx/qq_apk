package com.tencent.open.appstore.js;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class YybTreasureCardJsPlugin
  extends BaseInterface
  implements IJsCallBack
{
  private Handler a;
  private Activity b;
  private WebView c;
  private WeakReference<AppRuntime> d;
  
  public YybTreasureCardJsPlugin(Activity paramActivity, WebView paramWebView)
  {
    this.b = paramActivity;
    this.c = paramWebView;
    this.a = new Handler(Looper.getMainLooper());
    Object localObject = null;
    try
    {
      if ((paramActivity instanceof PublicFragmentActivityForTool))
      {
        paramActivity = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      }
      else if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
      {
        paramActivity = ((com.tencent.mobileqq.app.BaseActivity)paramActivity).getAppRuntime();
      }
      else
      {
        paramWebView = localObject;
        if ((paramActivity instanceof mqq.app.BaseActivity)) {
          paramActivity = ((mqq.app.BaseActivity)paramActivity).getAppRuntime();
        }
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      paramWebView = localObject;
    }
    for (;;)
    {
      this.d = new WeakReference(paramWebView);
      JsCallbackManager.a().a(this);
      return;
      paramWebView = paramActivity;
    }
  }
  
  private void a(String paramString)
  {
    this.a.post(new YybTreasureCardJsPlugin.1(this, paramString));
  }
  
  public void clearSimCache(String paramString)
  {
    try
    {
      boolean bool = VasUtil.a((AppRuntime)this.d.get()).getVasFtManager().clearCacheAndRequest();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("request", bool);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("treasureCard");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" request:");
      localStringBuilder.append(localJSONObject);
      LogUtility.b("TreasureCardJsPlugin", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(")");
      a(localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void destroy()
  {
    JsCallbackManager.a().b(this);
    super.destroy();
  }
  
  public void freeTrafficCardModel(String paramString1, String paramString2)
  {
    try
    {
      IVasFTManager localIVasFTManager = VasUtil.a((AppRuntime)this.d.get()).getVasFtManager();
      JSONObject localJSONObject = localIVasFTManager.obtainCardInfo(paramString2).toJson();
      localJSONObject.put("cardStates", localIVasFTManager.obtainCardState(paramString2));
      paramString2 = new StringBuilder();
      paramString2.append("treasureCard");
      paramString2.append(paramString1);
      paramString2.append(" jsonObject:");
      paramString2.append(localJSONObject.toString());
      LogUtility.b("TreasureCardJsPlugin", paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("javascript:");
      paramString2.append(paramString1);
      paramString2.append("(");
      paramString2.append(localJSONObject.toString());
      paramString2.append(")");
      a(paramString2.toString());
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public String getInterfaceName()
  {
    return "yyb_treasureCard";
  }
  
  public String getJsCallbackMethod()
  {
    return null;
  }
  
  public WebView getWebview()
  {
    return this.c;
  }
  
  public void tcardModel(String paramString1, String paramString2)
  {
    try
    {
      IVasFTManager localIVasFTManager = VasUtil.a((AppRuntime)this.d.get()).getVasFtManager();
      JSONObject localJSONObject = localIVasFTManager.obtainCardInfo(paramString2).toJson();
      localJSONObject.put("mobileCardStates", localIVasFTManager.treasureCardState(paramString2));
      paramString2 = new StringBuilder();
      paramString2.append("treasureCard");
      paramString2.append(paramString1);
      paramString2.append(" jsonObject:");
      paramString2.append(localJSONObject.toString());
      LogUtility.b("TreasureCardJsPlugin", paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("javascript:");
      paramString2.append(paramString1);
      paramString2.append("(");
      paramString2.append(localJSONObject.toString());
      paramString2.append(")");
      a(paramString2.toString());
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.YybTreasureCardJsPlugin
 * JD-Core Version:    0.7.0.1
 */