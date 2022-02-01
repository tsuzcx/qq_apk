package com.tencent.mobileqq.hotchat.data;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotchat.api.IShareHotChatGrayTips;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareHotChatGrayTips
  extends ChatMessage
  implements IShareHotChatGrayTips
{
  private static final String HOT_NAME_CODE = "hotnamecode";
  private static final String JUMP_URL = "jump_url";
  private static final String MSG_CONTENT = "msg_content";
  private static final String MSG_CONTENT_HIGHLIGHT = "msg_content_highlight";
  public static final String SHARE_GRAY_TIP_CONTENT = HardCodeUtil.a(2131911360);
  private static final String TROOP_NAME = "troop_name";
  private static final String TROOP_UIN = "troop_uin";
  public String mHotnamecode;
  public String mJumpUrl;
  public String mMsgContent;
  public String mMsgContentHighlight;
  public String mTroopName;
  public String mTroopUin;
  
  public static String makeShareGrayTip(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("msg_content", paramString1);
      localJSONObject.put("msg_content_highlight", paramString2);
      localJSONObject.put("troop_uin", paramString3);
      localJSONObject.put("troop_name", paramString4);
      localJSONObject.put("jump_url", paramString5);
      localJSONObject.put("hotnamecode", paramString6);
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
    String str = this.msg;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      if (localJSONObject.has("msg_content")) {
        this.mMsgContent = localJSONObject.getString("msg_content");
      } else {
        this.mMsgContent = null;
      }
      if (localJSONObject.has("msg_content_highlight")) {
        this.mMsgContentHighlight = localJSONObject.getString("msg_content_highlight");
      } else {
        this.mMsgContentHighlight = null;
      }
      if (localJSONObject.has("troop_uin")) {
        this.mTroopUin = localJSONObject.getString("troop_uin");
      } else {
        this.mTroopUin = null;
      }
      if (localJSONObject.has("troop_name")) {
        this.mTroopName = localJSONObject.getString("troop_name");
      } else {
        this.mTroopName = null;
      }
      if (localJSONObject.has("jump_url")) {
        this.mJumpUrl = localJSONObject.getString("jump_url");
      } else {
        this.mJumpUrl = null;
      }
      if (localJSONObject.has("hotnamecode"))
      {
        this.mHotnamecode = localJSONObject.getString("hotnamecode");
        return;
      }
      this.mHotnamecode = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.mMsgContent = str;
      this.mMsgContentHighlight = null;
      this.mTroopUin = null;
      this.mTroopName = null;
      this.mJumpUrl = null;
    }
  }
  
  public SpannableString getHighlightMsgText(AppInterface paramAppInterface, Context paramContext)
  {
    int i;
    if ((!TextUtils.isEmpty(this.mMsgContent)) && (!TextUtils.isEmpty(this.mMsgContentHighlight))) {
      i = this.mMsgContent.indexOf(this.mMsgContentHighlight);
    } else {
      i = -1;
    }
    int j = 0;
    if (i >= 0) {
      j = this.mMsgContentHighlight.length() + i;
    }
    SpannableString localSpannableString = new SpannableString(this.mMsgContent);
    if ((i >= 0) && (j > i)) {
      localSpannableString.setSpan(new ShareHotChatGrayTips.HighlightClickableSpan((QQAppInterface)paramAppInterface, paramContext, this, this.mHotnamecode), i, j, 33);
    }
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.data.ShareHotChatGrayTips
 * JD-Core Version:    0.7.0.1
 */