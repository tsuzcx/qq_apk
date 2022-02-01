package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService.WallpaperConfig;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VipClubJsPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "vipclub";
  private static final String TAG = "VipClubJsPlugin";
  
  public VipClubJsPlugin()
  {
    super("vipclub");
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="cardSupportVideo")
  public void cardSupportVideo(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (GLDrawableDownloadHelper.c())
        {
          String str1 = "0";
          localJSONObject.put("result", str1);
          localJSONObject.put("msg", "不支持视频");
          super.callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception localException)
      {
        super.callJsOnError(paramString, localException.getMessage());
        return;
      }
      String str2 = "1";
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="type", method="paySuccess")
  public void paySuccess(Object paramObject)
  {
    int i;
    if ((paramObject instanceof String))
    {
      i = Integer.parseInt((String)paramObject);
    }
    else
    {
      if (!(paramObject instanceof Number)) {
        break label92;
      }
      i = ((Number)paramObject).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("paySuccess: ");
    localStringBuilder.append(paramObject);
    QLog.e("VipClubJsPlugin", 1, localStringBuilder.toString());
    paramObject = new Bundle();
    paramObject.putInt("type", i);
    QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "paySuccess", paramObject, null);
    return;
    label92:
    if (paramObject == null)
    {
      QLog.e("VipClubJsPlugin", 1, "paySuccess type is null");
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("paySuccess wrong type: ");
    localStringBuilder.append(paramObject.getClass());
    QLog.e("VipClubJsPlugin", 1, localStringBuilder.toString());
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|status", method="qidResult")
  public void qidResult(String paramString, Object paramObject)
  {
    for (;;)
    {
      try
      {
        QLog.d("VipClubJsPlugin", 1, "qidResult");
        if ((paramObject instanceof String))
        {
          i = Integer.parseInt((String)paramObject);
        }
        else
        {
          if (!(paramObject instanceof Number)) {
            break label114;
          }
          i = ((Number)paramObject).intValue();
        }
        paramObject = this.mRuntime.b();
        if (i != 1) {
          break label119;
        }
        bool = true;
        VipQidHelper.a(paramObject, bool);
        paramObject = new JSONObject();
        paramObject.put("result", "0");
        super.callJs(paramString, new String[] { paramObject.toString() });
        return;
      }
      catch (Exception paramObject)
      {
        super.callJsOnError(paramString, paramObject.getMessage());
        return;
      }
      label114:
      int i = 0;
      continue;
      label119:
      boolean bool = false;
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="themeSupportVideo")
  public void themeSupportVideo(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (ThemeBackground.b())
        {
          String str1 = "0";
          localJSONObject.put("result", str1);
          localJSONObject.put("msg", "不支持超级主题");
          super.callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception localException)
      {
        super.callJsOnError(paramString, localException.getMessage());
        return;
      }
      String str2 = "1";
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="updateQQValueCard")
  public void updateQQValueCard(String paramString)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("result", "0");
      ((JSONObject)localObject).put("msg", "收到刷新请求");
      super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      localObject = new VipClubJsPlugin.1(this);
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.l, null, (EIPCResultCallback)localObject);
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramString, localException.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="wallpaperGetChatBg")
  public void wallpaperGetChatBg(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      VipWallpaperService.WallpaperConfig localWallpaperConfig = VipWallpaperService.a(this.mRuntime.d(), true);
      localJSONObject.put("result", "0");
      localJSONObject.put("id", localWallpaperConfig.a);
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramString, localException.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|id|changeSystem", method="wallpaperSetChatBg")
  public void wallpaperSetChatBg(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = new JSONObject();
      boolean bool = "0".equals(paramString2);
      if (bool)
      {
        VipWallpaperService.a(this.mRuntime.d(), new VipWallpaperService.WallpaperConfig(), null);
        paramString3.put("result", "0");
        paramString3.put("msg", "恢复系统壁纸");
      }
      else
      {
        String str = ChatBackgroundUtil.a(true, paramString2);
        if (new File(str).exists())
        {
          AtomicBoolean localAtomicBoolean = new AtomicBoolean();
          paramString2 = new VipWallpaperService.WallpaperConfig(paramString2, str, "");
          VipWallpaperService.a(this.mRuntime.d(), paramString2, localAtomicBoolean);
          paramString3.put("result", "0");
          paramString3.put("msg", "设置成功");
          if (localAtomicBoolean.get()) {
            paramString3.put("isGoOut", true);
          }
        }
        else
        {
          paramString3.put("result", "1");
          paramString3.put("msg", "素材不存在");
        }
      }
      super.callJs(paramString1, new String[] { paramString3.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="wallpaperSupportList")
  public void wallpaperSupportList(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", "staic|apng");
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramString, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin
 * JD-Core Version:    0.7.0.1
 */