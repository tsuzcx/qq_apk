package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

public class EmojiStickerManager$StickerInfo
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public float height;
  public long hostMsgSeq;
  public long hostMsgTime;
  public long hostMsgUid;
  public boolean isDisplayed;
  public boolean isShown;
  public String msg = "";
  public int originMsgType;
  public int rotate;
  public float width;
  public float x;
  public float y;
  
  public static StickerInfo transformFromJson(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        StickerInfo localStickerInfo = new StickerInfo();
        paramString = new JSONObject(paramString);
        localStickerInfo.originMsgType = paramString.optInt("originMsgType");
        localStickerInfo.x = ((float)paramString.optDouble("x"));
        localStickerInfo.y = ((float)paramString.optDouble("y"));
        localStickerInfo.width = ((float)paramString.optDouble("width"));
        localStickerInfo.height = ((float)paramString.optDouble("height"));
        localStickerInfo.rotate = paramString.optInt("rotate");
        localStickerInfo.hostMsgSeq = paramString.optLong("hostMsgSeq");
        localStickerInfo.hostMsgUid = paramString.optLong("hostMsgUid");
        localStickerInfo.hostMsgTime = paramString.optLong("hostMsgTime");
        localStickerInfo.isDisplayed = paramString.optBoolean("isDisplayed");
        localStickerInfo.isShown = paramString.optBoolean("isShown");
        localStickerInfo.msg = paramString.optString("msg");
        return localStickerInfo;
      }
      catch (Exception paramString)
      {
        QLog.e("EmojiStickerManager", 1, "StickerInfo.transformFromJson error + e = " + paramString);
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
      QLog.e("EmojiStickerManager", 1, "StickerInfo.toJsonString error + e = " + localException);
    }
    return "";
  }
  
  public String toString()
  {
    return String.format("EmojiStickerInfo, originMsgType: %d,  x: %f, y: %f, width: %f, height: %f, rotate: %d, msgseq: %d, msgUid: %d", new Object[] { Integer.valueOf(this.originMsgType), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.rotate), Long.valueOf(this.hostMsgSeq), Long.valueOf(this.hostMsgUid) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo
 * JD-Core Version:    0.7.0.1
 */