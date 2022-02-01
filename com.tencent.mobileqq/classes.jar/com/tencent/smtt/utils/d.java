package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static DexClassLoader b = null;
  private static Looper c = null;
  private static d d = null;
  public String a = "";
  
  private d(Context paramContext)
  {
    this.a = (paramContext.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin");
  }
  
  public static d a(Context paramContext)
  {
    if (d == null) {
      d = new d(paramContext);
    }
    return d;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString, d.a parama)
  {
    new d.2(paramString, parama).start();
  }
  
  public void a(String paramString, WebView paramWebView, Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    TextView localTextView = new TextView(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localTextView.setText("加载中，请稍后...");
    localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    paramWebView.addView(localRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.a + File.separator + "DebugPlugin.tbs";
    FileUtil.b(new File((String)localObject));
    a((String)localObject, new d.1(this, paramWebView, paramContext, localRelativeLayout, paramString, localTextView));
  }
  
  @SuppressLint({"NewApi"})
  public void a(String paramString, WebView paramWebView, Context paramContext, Looper paramLooper)
  {
    TbsLog.i("debugtbs", "showPluginView -- url: " + paramString + "; webview: " + paramWebView + "; context: " + paramContext);
    Object localObject1 = this.a + File.separator + "DebugPlugin.tbs";
    Object localObject2 = this.a + File.separator + "DebugPlugin.apk";
    Object localObject3 = new File((String)localObject1);
    localObject1 = new File((String)localObject2);
    c = paramLooper;
    if (((File)localObject3).exists())
    {
      ((File)localObject1).delete();
      ((File)localObject3).renameTo((File)localObject1);
    }
    if (!((File)localObject1).exists())
    {
      TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
      a(paramString, paramWebView, paramContext);
      return;
    }
    try
    {
      localObject4 = b.a(paramContext, true, new File((String)localObject2));
      if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(localObject4))
      {
        TbsLog.e("debugtbs", "verifyPlugin apk: " + (String)localObject2 + " signature failed - sig: " + (String)localObject4);
        Toast.makeText(paramContext, "插件校验失败，请重试", 0).show();
        ((File)localObject3).delete();
        ((File)localObject1).delete();
        return;
      }
    }
    catch (Exception paramString)
    {
      FileUtil.b((File)localObject1);
      paramString.printStackTrace();
      return;
    }
    localObject3 = this.a + File.separator + "opt";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    if (b == null) {
      b = new DexClassLoader((String)localObject2, (String)localObject3, null, paramContext.getClassLoader());
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("url", paramString);
    ((Map)localObject2).put("tbs_version", "" + WebView.getTbsSDKVersion(paramContext));
    ((Map)localObject2).put("tbs_core_version", "" + WebView.getTbsCoreVersion(paramContext));
    if (c != null) {
      ((Map)localObject2).put("looper", paramLooper);
    }
    paramString = b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[] { Context.class, Map.class }).newInstance(new Object[] { paramContext, localObject2 });
    if ((paramString instanceof FrameLayout))
    {
      paramString = (FrameLayout)paramString;
      paramWebView.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("debugtbs", "show " + paramString + " successful in " + paramWebView);
      return;
    }
    TbsLog.e("debugtbs", "get debugview failure: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.utils.d
 * JD-Core Version:    0.7.0.1
 */