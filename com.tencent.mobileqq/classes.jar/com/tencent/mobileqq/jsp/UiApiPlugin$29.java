package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.search.util.SearchUtils.GenerateGifWithTextCallback;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import org.json.JSONObject;

class UiApiPlugin$29
  implements SearchUtils.GenerateGifWithTextCallback
{
  UiApiPlugin$29(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.b.callJs(this.a, new String[] { "{\"code\":-4}" });
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      arrayOfByte = FileUtils.readFile(paramString);
      if (arrayOfByte == null) {
        break label155;
      }
      localJSONObject.put("code", 0);
      localStringBuilder = new StringBuilder("data:");
      if (!BaseImageUtil.c(paramString)) {
        break label201;
      }
      str = "image/gif;";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        StringBuilder localStringBuilder;
        continue;
        String str = "image/jpg;";
      }
    }
    localStringBuilder.append(str);
    localStringBuilder.append("base64,");
    localStringBuilder.append(Base64Util.encodeToString(arrayOfByte, 0));
    localJSONObject.put("imgData", localStringBuilder);
    localJSONObject.put("md5", MD5.toMD5(arrayOfByte));
    localJSONObject.put("imagePath", paramString);
    this.b.callJs(this.a, new String[] { localJSONObject.toString() });
    return;
    label155:
    this.b.callJs(this.a, new String[] { "{\"code\":-3}" });
    return;
    this.b.callJs(this.a, new String[] { "{\"code\":-3}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.29
 * JD-Core Version:    0.7.0.1
 */