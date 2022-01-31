package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import bdss;
import becq;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.qphone.base.util.QLog;
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
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="type", method="paySuccess")
  public void paySuccess(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (int i = Integer.parseInt((String)paramObject);; i = ((Number)paramObject).intValue())
    {
      QLog.e("VipClubJsPlugin", 1, "paySuccess: " + paramObject);
      paramObject = new Bundle();
      paramObject.putInt("type", i);
      QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "paySuccess", paramObject, null);
      return;
      if (!(paramObject instanceof Number)) {
        break;
      }
    }
    if (paramObject == null)
    {
      QLog.e("VipClubJsPlugin", 1, "paySuccess type is null");
      return;
    }
    QLog.e("VipClubJsPlugin", 1, "paySuccess wrong type: " + paramObject.getClass());
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="wallpaperGetChatBg")
  public void wallpaperGetChatBg(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      bdss localbdss = VipWallpaperService.a(this.mRuntime.a(), true);
      localJSONObject.put("result", "0");
      localJSONObject.put("id", localbdss.a);
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
    for (;;)
    {
      try
      {
        paramString3 = new JSONObject();
        if ("0".equals(paramString2))
        {
          VipWallpaperService.a(this.mRuntime.a(), new bdss(), null);
          paramString3.put("result", "0");
          paramString3.put("msg", "恢复系统壁纸");
          super.callJs(paramString1, new String[] { paramString3.toString() });
          return;
        }
        String str = ChatBackgroundManager.a(true, paramString2);
        if (new File(str).exists())
        {
          AtomicBoolean localAtomicBoolean = new AtomicBoolean();
          paramString2 = new bdss(paramString2, str, "");
          VipWallpaperService.a(this.mRuntime.a(), paramString2, localAtomicBoolean);
          paramString3.put("result", "0");
          paramString3.put("msg", "设置成功");
          if (!localAtomicBoolean.get()) {
            continue;
          }
          paramString3.put("isGoOut", true);
          continue;
        }
        paramString3.put("result", "1");
      }
      catch (Exception paramString2)
      {
        super.callJsOnError(paramString1, paramString2.getMessage());
        return;
      }
      paramString3.put("msg", "素材不存在");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin
 * JD-Core Version:    0.7.0.1
 */