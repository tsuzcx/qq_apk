package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import aqri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForNearbyMarketGrayTips
  extends ChatMessage
{
  public static final int ACTION_AUTO_INPUT = 3;
  public static final int ACTION_AUTO_INPUT_FACE_SCORE = 4;
  public static final int ACTION_DEFAULT = 0;
  public static final int ACTION_JUMP_NATIVE = 2;
  public static final int ACTION_JUMP_WEB = 1;
  private static final String NAME_AIO_TYPE = "aioType";
  private static final String NAME_CONTENT = "content";
  private static final String NAME_HIGHTLIGHT = "high_light";
  private static final String NAME_ID = "id";
  private static final String NAME_LINK = "link";
  private static final String NAME_SCENE = "scene";
  public static final int SCENE_AIO = 8;
  public static final int SCENE_AIO_FACE_SCORE = 16;
  public static final int SCENE_DEFAULT = 0;
  public static final int SCENE_KEYWORD = 4;
  public static final int SCENE_SAY_HI = 1;
  public static final int SCENE_SAY_HI_FREQ = 2;
  public static final String TAG = "MessageForNearbyMarketGrayTips";
  public int AioType;
  public int gender;
  private String mContent;
  private String mHighLight;
  private int mId;
  private String mLink;
  private int mScene;
  
  public static String makeGrayTipMsg(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("content", paramString1);
      localJSONObject.put("high_light", paramString2);
      localJSONObject.put("scene", paramInt2);
      localJSONObject.put("link", paramString3);
      localJSONObject.put("aioType", paramInt3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected void doParse()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "doParse: " + this.msg);
    }
    String str = this.msg;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        this.mId = localJSONObject.getInt("id");
        this.mContent = localJSONObject.getString("content");
        if (localJSONObject.has("high_light"))
        {
          this.mHighLight = localJSONObject.getString("high_light");
          if (localJSONObject.has("scene"))
          {
            this.mScene = localJSONObject.getInt("scene");
            if (!localJSONObject.has("link")) {
              break label192;
            }
            this.mLink = localJSONObject.getString("link");
            if (!localJSONObject.has("aioType")) {
              break;
            }
            this.AioType = localJSONObject.getInt("aioType");
          }
        }
        else
        {
          this.mHighLight = null;
          continue;
        }
        this.mScene = 0;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.mContent = str;
        this.mHighLight = null;
        this.mScene = 0;
        this.mLink = null;
        this.AioType = 0;
        return;
      }
      continue;
      label192:
      this.mLink = null;
    }
    this.AioType = 0;
  }
  
  public SpannableString getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((!TextUtils.isEmpty(this.mContent)) && (!TextUtils.isEmpty(this.mHighLight))) {}
    for (int j = this.mContent.indexOf(this.mHighLight);; j = -1)
    {
      if (j >= 0) {}
      for (int k = this.mHighLight.length() + j;; k = 0)
      {
        SpannableString localSpannableString = new SpannableString(this.mContent);
        int i;
        if ((j >= 0) && (k > j)) {
          switch (this.mScene)
          {
          default: 
            i = 0;
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new aqri(paramQQAppInterface, paramContext, this.mId, -12541697, i, this.mLink, this.mScene, this), j, k, 33);
          return localSpannableString;
          if (TextUtils.isEmpty(this.mLink)) {
            break;
          }
          if (this.mLink.startsWith("mqqapi://"))
          {
            i = 2;
          }
          else
          {
            i = 1;
            continue;
            i = 3;
            continue;
            i = 4;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips
 * JD-Core Version:    0.7.0.1
 */