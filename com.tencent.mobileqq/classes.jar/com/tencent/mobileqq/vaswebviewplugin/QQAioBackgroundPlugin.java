package com.tencent.mobileqq.vaswebviewplugin;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.json.JSONObject;

public class QQAioBackgroundPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "background";
  
  public QQAioBackgroundPlugin()
  {
    super("background");
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|chatUin", method="getCurBackground")
  public void getCurBackground(String paramString, Object paramObject)
  {
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localJSONObject1.put("data", localJSONObject2);
      str2 = ChatBackgroundUtil.a(this.mRuntime.d(), this.mRuntime.b().getCurrentAccountUin(), String.valueOf(paramObject));
      boolean bool = "null".equals(str2);
      if (bool)
      {
        localJSONObject1.put("result", 0);
        localJSONObject2.put("imageSize", 0);
        localJSONObject2.put("bgId", 0);
      }
      else
      {
        str1 = ChatBackgroundUtil.b(str2);
        bool = new File(str2).exists();
        localByteArrayOutputStream = null;
        paramObject = localByteArrayOutputStream;
        if (bool) {
          paramObject = ImageUtil.a(new BitmapFactory.Options(), str2, 200);
        }
      }
    }
    catch (Exception paramObject)
    {
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      String str2;
      String str1;
      label152:
      StringBuilder localStringBuilder;
      super.callJsOnError(paramString, paramObject.getMessage());
      return;
    }
    try
    {
      paramObject = BitmapFactory.decodeFile(str2, paramObject);
    }
    catch (OutOfMemoryError paramObject)
    {
      paramObject = localByteArrayOutputStream;
      break label152;
    }
    if (paramObject == null)
    {
      localJSONObject1.put("result", 1002);
    }
    else
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramObject.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      str2 = Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
      localJSONObject1.put("result", 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("data:image/png;base64,");
      localStringBuilder.append(str2);
      localJSONObject2.put("image", localStringBuilder.toString());
      localJSONObject2.put("imageSize", paramObject.getWidth());
      localJSONObject2.put("bgId", str1);
      localByteArrayOutputStream.close();
    }
    super.callJs(paramString, new String[] { localJSONObject1.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQAioBackgroundPlugin
 * JD-Core Version:    0.7.0.1
 */