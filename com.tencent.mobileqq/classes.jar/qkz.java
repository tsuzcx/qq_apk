import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.gdtad.jsbridge.GdtJsCallHandler;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class qkz
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if ((paramGdtAdWebPlugin == null) || (paramGdtAdWebPlugin.mRuntime == null))
    {
      GdtLog.d("GdtVideoCeilingJsCall", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject2 = new JSONObject(paramVarArgs[0]);
      GdtLog.b("GdtVideoCeilingJsCall", ((JSONObject)localObject2).toString());
      paramVarArgs = ((JSONObject)localObject2).optString("videoUrl");
      paramString = ((JSONObject)localObject2).optString("webUrl");
      Object localObject1 = ((JSONObject)localObject2).optString("urlForImpression");
      String str = ((JSONObject)localObject2).optString("urlForClick");
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).exposure_url.set((String)localObject1);
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).click_url.set(str);
      localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.set((MessageMicro)localObject2);
      localObject1 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
      localObject2 = new GdtVideoData();
      ((GdtVideoData)localObject2).setUrl(paramVarArgs);
      ((GdtVideoData)localObject2).setStartPositionMillis(0L);
      ((GdtVideoData)localObject2).setLoop(true);
      paramVarArgs = new GdtVideoCeilingData();
      paramVarArgs.setAd((GdtAd)localObject1);
      paramVarArgs.setWebUrl(paramString);
      paramVarArgs.setVideoData((GdtVideoData)localObject2);
      GdtVideoCeilingFragmentForJS.a(paramGdtAdWebPlugin.mRuntime.a(), GdtVideoCeilingFragmentForJS.class, paramVarArgs);
      return true;
    }
    catch (JSONException paramGdtAdWebPlugin)
    {
      GdtLog.d("GdtVideoCeilingJsCall", "handleJsCallRequest error", paramGdtAdWebPlugin);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qkz
 * JD-Core Version:    0.7.0.1
 */