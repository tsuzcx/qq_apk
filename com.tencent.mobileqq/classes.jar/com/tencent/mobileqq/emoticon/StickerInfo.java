package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

public class StickerInfo
  implements Serializable
{
  public static final String TAG = "StickerInfo";
  public static final long serialVersionUID = 1L;
  public float height = 0.0F;
  public long hostMsgSeq = 0L;
  public long hostMsgTime = 0L;
  public long hostMsgUid = 0L;
  public boolean isDisplayed = false;
  public boolean isShown = false;
  public String msg = "";
  public int originMsgType = 0;
  public int rotate = 0;
  public float width = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public static StickerInfo transformFromJson(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject = new StickerInfo();
        paramString = new JSONObject(paramString);
        ((StickerInfo)localObject).originMsgType = paramString.optInt("originMsgType");
        ((StickerInfo)localObject).x = ((float)paramString.optDouble("x"));
        ((StickerInfo)localObject).y = ((float)paramString.optDouble("y"));
        ((StickerInfo)localObject).width = ((float)paramString.optDouble("width"));
        ((StickerInfo)localObject).height = ((float)paramString.optDouble("height"));
        ((StickerInfo)localObject).rotate = paramString.optInt("rotate");
        ((StickerInfo)localObject).hostMsgSeq = paramString.optLong("hostMsgSeq");
        ((StickerInfo)localObject).hostMsgUid = paramString.optLong("hostMsgUid");
        ((StickerInfo)localObject).hostMsgTime = paramString.optLong("hostMsgTime");
        ((StickerInfo)localObject).isDisplayed = paramString.optBoolean("isDisplayed");
        ((StickerInfo)localObject).isShown = paramString.optBoolean("isShown");
        ((StickerInfo)localObject).msg = paramString.optString("msg");
        return localObject;
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StickerInfo.transformFromJson error + e = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("StickerInfo", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public String toJsonString()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("originMsgType", this.originMsgType);
      ((JSONObject)localObject).put("x", this.x);
      ((JSONObject)localObject).put("y", this.y);
      ((JSONObject)localObject).put("width", this.width);
      ((JSONObject)localObject).put("height", this.height);
      ((JSONObject)localObject).put("rotate", this.rotate);
      ((JSONObject)localObject).put("hostMsgSeq", this.hostMsgSeq);
      ((JSONObject)localObject).put("hostMsgUid", this.hostMsgUid);
      ((JSONObject)localObject).put("hostMsgTime", this.hostMsgTime);
      ((JSONObject)localObject).put("isDisplayed", this.isDisplayed);
      ((JSONObject)localObject).put("isShown", this.isShown);
      ((JSONObject)localObject).put("msg", this.msg);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StickerInfo.toJsonString error + e = ");
      localStringBuilder.append(localException);
      QLog.e("StickerInfo", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  public String toString()
  {
    return String.format("EmojiStickerInfo, originMsgType: %d,  x: %f, y: %f, width: %f, height: %f, rotate: %d, msgseq: %d, msgUid: %d", new Object[] { Integer.valueOf(this.originMsgType), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.rotate), Long.valueOf(this.hostMsgSeq), Long.valueOf(this.hostMsgUid) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.StickerInfo
 * JD-Core Version:    0.7.0.1
 */