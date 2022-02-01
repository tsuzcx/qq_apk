package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class AniStickerLottieProcessor$LottieEmoSwitchData
{
  public String content = "";
  public String lottieEmoSwitch = "";
  public int taskId = -1;
  
  public AniStickerLottieProcessor$LottieEmoSwitchData() {}
  
  public AniStickerLottieProcessor$LottieEmoSwitchData(int paramInt, String paramString)
  {
    this.taskId = paramInt;
    this.content = paramString;
  }
  
  public boolean isLottieAvailable()
  {
    return TextUtils.equals(this.lottieEmoSwitch, "1");
  }
  
  public void parse()
  {
    try
    {
      if (TextUtils.isEmpty(this.content)) {
        return;
      }
      JSONObject localJSONObject = new JSONObject(this.content);
      if (localJSONObject.has("lottieEmoSwitch"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lottieEmoSwitch=");
        localStringBuilder.append(localJSONObject.optString("lottieEmoSwitch"));
        ABTestUtil.a("AniStickerLottieProcessor", localStringBuilder.toString());
        this.lottieEmoSwitch = localJSONObject.optString("lottieEmoSwitch");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public String toStr()
  {
    return String.format("[taskId:%s, content:%s, switch:%s]", new Object[] { Integer.valueOf(this.taskId), this.content, this.lottieEmoSwitch });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AniStickerLottieProcessor.LottieEmoSwitchData
 * JD-Core Version:    0.7.0.1
 */