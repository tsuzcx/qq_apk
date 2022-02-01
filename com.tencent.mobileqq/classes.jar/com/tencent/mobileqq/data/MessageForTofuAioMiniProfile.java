package com.tencent.mobileqq.data;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.BaseProfile;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.NicePicInfo;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.QZoneInfo;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.Sign;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageForTofuAioMiniProfile
  extends ChatMessage
{
  public static final String TAG = "MessageForTofuAioMiniProfile";
  public MiniCard miniCard;
  
  public MessageForTofuAioMiniProfile()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private AnonymousQuestion getAskAnonymously(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("key_ask_anonymously");
    }
    if (paramJSONObject == null) {
      return null;
    }
    AnonymousQuestion localAnonymousQuestion = new AnonymousQuestion();
    localAnonymousQuestion.mId = paramJSONObject.optString("key_question_id", "");
    localAnonymousQuestion.mQuest = paramJSONObject.optString("key_question_str", "");
    localAnonymousQuestion.mQuestTime = paramJSONObject.optLong("key_question_time", 0L);
    localAnonymousQuestion.mQuestUin = paramJSONObject.optLong("key_question_uin", 0L);
    localAnonymousQuestion.mAnswer = paramJSONObject.optString("key_answer_str", "");
    return localAnonymousQuestion;
  }
  
  private MiniCard.BaseProfile getBaseProfile(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("field_baseprofile");
    }
    if (paramJSONObject == null) {
      return null;
    }
    MiniCard.BaseProfile localBaseProfile = new MiniCard.BaseProfile();
    localBaseProfile.a = paramJSONObject.optInt("age", -1);
    localBaseProfile.b = paramJSONObject.optInt("gender", -1);
    localBaseProfile.c = paramJSONObject.optString("place", "");
    localBaseProfile.d = paramJSONObject.optString("addfrd_src", "");
    localBaseProfile.e = paramJSONObject.optInt("commfrd_num", -1);
    return localBaseProfile;
  }
  
  private List<MiniCard.NicePicInfo> getNicePics(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONArray("field_nicepics");
    }
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MiniCard.NicePicInfo localNicePicInfo = new MiniCard.NicePicInfo();
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        localNicePicInfo.a = localJSONObject.optString("ori", "");
        localNicePicInfo.b = localJSONObject.optString("medium", "");
        localArrayList.add(localNicePicInfo);
        i += 1;
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  private List<String> getPersonalLabels(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONArray("field_personal_labels");
    }
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i, ""));
        i += 1;
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  private MiniCard.QZoneInfo getQZoneInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("field_qzone");
    }
    if (paramJSONObject == null) {
      return null;
    }
    MiniCard.QZoneInfo localQZoneInfo = new MiniCard.QZoneInfo();
    localQZoneInfo.a = paramJSONObject.optString("space_name", "");
    localQZoneInfo.b = paramJSONObject.optString("update_content", "");
    paramJSONObject = paramJSONObject.optJSONArray("img_urls");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      localQZoneInfo.c.addAll(localArrayList);
    }
    return localQZoneInfo;
  }
  
  private MiniCard.Sign getSign(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("sign");
    }
    if (paramJSONObject == null) {
      return null;
    }
    MiniCard.Sign localSign = new MiniCard.Sign();
    localSign.a = paramJSONObject.optInt("actionId", 0);
    localSign.b = paramJSONObject.optString("actionAndData", "");
    localSign.c = paramJSONObject.optString("plainText", "");
    return localSign;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.miniCard = new MiniCard();
      this.miniCard.a = getBaseProfile(localJSONObject);
      this.miniCard.b.addAll(getPersonalLabels(localJSONObject));
      this.miniCard.c = getQZoneInfo(localJSONObject);
      this.miniCard.d.addAll(getNicePics(localJSONObject));
      this.miniCard.e = getSign(localJSONObject);
      this.miniCard.f = getAskAnonymously(localJSONObject);
    }
    catch (Exception localException)
    {
      QLog.d("MessageForTofuAioMiniProfile", 1, "doParse", localException);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForTofuAioMiniProfile", 4, String.format("doParse %s", new Object[] { this.miniCard }));
    }
    this.isread = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuAioMiniProfile
 * JD-Core Version:    0.7.0.1
 */