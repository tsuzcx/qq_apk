package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendCommonMessage
  extends ChatMessage
{
  private static final String TAG = "Ark";
  public String arkServerExtraInfo;
  public String arkServerMsgId;
  private ArrayList<Integer> atIndex = new ArrayList();
  public boolean atInfoParsed;
  private ArrayList<Integer> atLength = new ArrayList();
  public boolean isFromArkServer;
  public ArrayList<RecommendCommonMessage.ArkContextInfo> mContextList = new ArrayList();
  public int mContextMatchType = 0;
  public int mEchoType = 0;
  public boolean mHasReportShowIcon = false;
  public boolean mHasReportShowIconEach = false;
  public boolean mHasReportShowUnderline = false;
  public boolean mHasReportShowUnderlineEach = false;
  public String mIconAppPath;
  public boolean mIsMsgParsedByAi;
  public boolean mIsShow = false;
  public RecommendCommonMessage.ArkMsgAppInfo mOldAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
  
  public void addAtInfo(int paramInt1, int paramInt2)
  {
    this.atIndex.add(Integer.valueOf(paramInt1));
    this.atLength.add(Integer.valueOf(paramInt2));
  }
  
  public void clearAtInfo()
  {
    this.atIndex.clear();
    this.atLength.clear();
  }
  
  protected void doParse()
  {
    if (this.mIsMsgParsedByAi) {
      return;
    }
    this.mOldAppInfo.appName = getExtInfoFromExtStr("ark_ai_message_name");
    this.mOldAppInfo.appView = getExtInfoFromExtStr("ark_ai_message_view");
    this.mOldAppInfo.appVer = getExtInfoFromExtStr("ark_ai_message_ver");
    this.mOldAppInfo.meta = getExtInfoFromExtStr("ark_ai_message_meta");
    this.mOldAppInfo.keyword = getExtInfoFromExtStr("ark_ai_message_keyword");
    Object localObject1 = getExtInfoFromExtStr("ark_ai_message_data");
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool2 = false;
    if (!bool1) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).getJSONArray("data");
        int i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          RecommendCommonMessage.ArkContextInfo localArkContextInfo = new RecommendCommonMessage.ArkContextInfo();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject2).get(i);
          localArkContextInfo.context = localJSONObject.optString("context");
          localArkContextInfo.keyword = localJSONObject.optString("keyword");
          Object localObject3 = localJSONObject.optString("equalInputText");
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals("1"))) {
            break label564;
          }
          bool1 = true;
          localArkContextInfo.equalInputText = bool1;
          localArkContextInfo.contextMatchType = localJSONObject.optInt("contextMatchType");
          localJSONObject = (JSONObject)localJSONObject.get("sematic");
          localObject3 = localJSONObject.keys();
          if (((Iterator)localObject3).hasNext())
          {
            String str2 = (String)((Iterator)localObject3).next();
            String str3 = localJSONObject.optString(str2);
            if (TextUtils.isEmpty(str3)) {
              continue;
            }
            localArkContextInfo.semantic.put(str2, str3);
            continue;
          }
          this.mContextList.add(localArkContextInfo);
          i += 1;
          continue;
        }
        this.mIsShow = ((JSONObject)localObject1).optBoolean("show");
        this.mHasReportShowIcon = ((JSONObject)localObject1).optBoolean("reportIcon");
        this.mHasReportShowUnderline = ((JSONObject)localObject1).optBoolean("reportUnderline");
        this.isFromArkServer = ((JSONObject)localObject1).optBoolean("fromArkServer", false);
        this.arkServerMsgId = ((JSONObject)localObject1).optString("msgId", null);
        this.arkServerExtraInfo = ((JSONObject)localObject1).optString("extraInfo", null);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecommendCommonMessage doParse exception=");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("Ark", 2, ((StringBuilder)localObject2).toString());
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecommendCommonMessage doParse json parse exception=");
          ((StringBuilder)localObject2).append(localJSONException);
          QLog.d("Ark", 2, ((StringBuilder)localObject2).toString());
        }
      }
      this.mIsMsgParsedByAi = (TextUtils.isEmpty(this.mOldAppInfo.appName) ^ true);
      if (!this.mIsMsgParsedByAi)
      {
        if (this.mContextList.size() > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.mIsMsgParsedByAi = bool1;
      }
      if (!this.mIsMsgParsedByAi)
      {
        String str1 = getExtInfoFromExtStr("ark_ai_message_parsed");
        bool1 = bool2;
        if (!TextUtils.isEmpty(str1))
        {
          bool1 = bool2;
          if (str1.equals("1")) {
            bool1 = true;
          }
        }
        this.mIsMsgParsedByAi = bool1;
      }
      return;
      label564:
      bool1 = false;
    }
  }
  
  public int getAtLength(int paramInt)
  {
    int j = this.atIndex.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = (j - i) / 2 + i;
      int m = ((Integer)this.atIndex.get(k)).intValue();
      if ((m <= paramInt) && (((Integer)this.atLength.get(k)).intValue() + m >= paramInt)) {
        return ((Integer)this.atLength.get(k)).intValue();
      }
      if (m > paramInt) {
        j = k - 1;
      } else {
        i = k + 1;
      }
    }
    return -1;
  }
  
  public boolean hasAiData()
  {
    return (this.mContextList.size() > 0) || (!TextUtils.isEmpty(this.mOldAppInfo.appName));
  }
  
  public int isIncludedByAt(int paramInt1, int paramInt2)
  {
    int j = this.atIndex.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = (j - i) / 2 + i;
      int m = ((Integer)this.atIndex.get(k)).intValue();
      if ((m <= paramInt1) && (((Integer)this.atLength.get(k)).intValue() + m >= paramInt1 + paramInt2)) {
        return m;
      }
      if (m > paramInt1) {
        j = k - 1;
      } else {
        i = k + 1;
      }
    }
    return -1;
  }
  
  public void saveRecommendMsg(WeakReference<QQAppInterface> paramWeakReference, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = "1";
    if (paramBoolean)
    {
      if (!this.mIsMsgParsedByAi) {
        localObject1 = "0";
      }
      saveExtInfoToExtStr("ark_ai_message_parsed", (String)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        paramInt = 0;
        if (paramInt < this.mContextList.size())
        {
          JSONObject localJSONObject = new JSONObject();
          RecommendCommonMessage.ArkContextInfo localArkContextInfo = (RecommendCommonMessage.ArkContextInfo)this.mContextList.get(paramInt);
          localJSONObject.put("context", localArkContextInfo.context);
          localJSONObject.put("keyword", localArkContextInfo.keyword);
          if (!localArkContextInfo.equalInputText) {
            break label477;
          }
          localObject1 = "1";
          localJSONObject.put("equalInputText", localObject1);
          localJSONObject.put("contextMatchType", localArkContextInfo.contextMatchType);
          localObject1 = new JSONObject();
          Iterator localIterator = localArkContextInfo.semantic.keySet().iterator();
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            String str3 = (String)localArkContextInfo.semantic.get(str2);
            if (TextUtils.isEmpty(str3)) {
              continue;
            }
            ((JSONObject)localObject1).put(str2, str3);
            continue;
          }
          localJSONObject.put("sematic", localObject1);
          localJSONArray.put(localJSONObject);
          paramInt += 1;
          continue;
        }
        ((JSONObject)localObject2).put("data", localJSONArray);
        ((JSONObject)localObject2).put("show", this.mIsShow);
        ((JSONObject)localObject2).put("reportIcon", this.mHasReportShowIcon);
        ((JSONObject)localObject2).put("reportUnderline", this.mHasReportShowUnderline);
        ((JSONObject)localObject2).put("fromArkServer", this.isFromArkServer);
        ((JSONObject)localObject2).put("msgId", this.arkServerMsgId);
        ((JSONObject)localObject2).put("extraInfo", this.arkServerExtraInfo);
        saveExtInfoToExtStr("ark_ai_message_data", ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecommendCommonMessage saveRecommendMsg exception=");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("Ark", 2, ((StringBuilder)localObject2).toString());
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecommendCommonMessage saveRecommendMsg json parse exception=");
          ((StringBuilder)localObject2).append(localJSONException);
          QLog.d("Ark", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if (paramWeakReference != null)
      {
        if (paramWeakReference.get() == null) {
          return;
        }
        ThreadManagerV2.excute(new RecommendCommonMessage.1(this, paramWeakReference), 32, null, false);
      }
      return;
      label477:
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage
 * JD-Core Version:    0.7.0.1
 */