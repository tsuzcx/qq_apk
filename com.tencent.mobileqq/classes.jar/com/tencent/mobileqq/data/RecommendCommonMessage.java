package com.tencent.mobileqq.data;

import acdc;
import acdd;
import acde;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByActionCallback;
import com.tencent.mobileqq.service.message.MessageConstants;
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
  private ArrayList atIndex = new ArrayList();
  public boolean atInfoParsed;
  private ArrayList atLength = new ArrayList();
  public boolean isFromArkServer;
  public ArrayList mContextList = new ArrayList();
  public int mContextMatchType;
  public int mEchoType;
  public boolean mHasReportShowIcon;
  public boolean mHasReportShowIconEach;
  public boolean mHasReportShowUnderline;
  public boolean mHasReportShowUnderlineEach;
  public String mIconAppPath;
  public boolean mIsMsgParsedByAi;
  public boolean mIsShow;
  public RecommendCommonMessage.ArkMsgAppInfo mOldAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
  
  public static boolean getAppInfosByContext(RecommendCommonMessage.ArkContextInfo paramArkContextInfo, RecommendCommonMessage.IGetAppInfosByContextCallback paramIGetAppInfosByContextCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    Object localObject1 = paramArkContextInfo.context;
    String[] arrayOfString = ((String)localObject1).split("\\.");
    if (arrayOfString.length != 2)
    {
      ArkAppCenter.b("Ark", String.format("RecommendCommonMessage getAppInfosByContext split contextName failed. contextName: %s", new Object[] { localObject1 }));
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = paramArkContextInfo.semantic.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      localArrayList.add((String)((Iterator)localObject1).next());
    }
    Object localObject3;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject();
      localObject3 = new JSONObject();
      Iterator localIterator = paramArkContextInfo.semantic.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((JSONObject)localObject3).put(str, paramArkContextInfo.semantic.get(str));
        continue;
        localObject3 = paramArkContextInfo.keyword;
      }
    }
    catch (JSONException localJSONException)
    {
      localObject2 = "";
    }
    for (;;)
    {
      boolean bool = paramArkContextInfo.equalInputText;
      paramArkContextInfo = (ArkAppCenter)localQQAppInterface.getManager(120);
      localObject2 = new acdc((String)localObject3, bool, (String)localObject2);
      paramArkContextInfo.a().a(arrayOfString[0], arrayOfString[1], 1, localArrayList, null, paramIGetAppInfosByContextCallback, (ArkLocalAppMgr.IGetAppPathByActionCallback)localObject2);
      return true;
      ((JSONObject)localObject2).put(paramArkContextInfo.context, localObject3);
      localObject2 = ((JSONObject)localObject2).toString();
    }
  }
  
  public static boolean getAppInfosByContextList(ArrayList paramArrayList, RecommendCommonMessage.IGetAppInfosByContextListCallback paramIGetAppInfosByContextListCallback)
  {
    boolean bool2 = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    boolean bool1;
    if (localQQAppInterface == null) {
      bool1 = false;
    }
    Iterator localIterator1;
    do
    {
      return bool1;
      if (paramIGetAppInfosByContextListCallback == null) {
        return false;
      }
      paramIGetAppInfosByContextListCallback.mCount = paramArrayList.size();
      paramIGetAppInfosByContextListCallback.mAppList = new ArrayList();
      localIterator1 = paramArrayList.iterator();
      bool1 = bool2;
    } while (!localIterator1.hasNext());
    Object localObject1 = (RecommendCommonMessage.ArkContextInfo)localIterator1.next();
    paramArrayList = ((RecommendCommonMessage.ArkContextInfo)localObject1).context;
    String[] arrayOfString = paramArrayList.split("\\.");
    if (arrayOfString.length != 2)
    {
      ArkAppCenter.b("Ark", String.format("RecommendCommonMessage getAppInfosByContext split contextName failed. contextName: %s", new Object[] { paramArrayList }));
      paramIGetAppInfosByContextListCallback.mCount -= 1;
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = ((RecommendCommonMessage.ArkContextInfo)localObject1).semantic.keySet().iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add((String)paramArrayList.next());
    }
    Object localObject2;
    try
    {
      paramArrayList = new JSONObject();
      localObject2 = new JSONObject();
      Iterator localIterator2 = ((RecommendCommonMessage.ArkContextInfo)localObject1).semantic.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        ((JSONObject)localObject2).put(str, ((RecommendCommonMessage.ArkContextInfo)localObject1).semantic.get(str));
        continue;
        localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject1).keyword;
      }
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList = "";
    }
    for (;;)
    {
      bool1 = ((RecommendCommonMessage.ArkContextInfo)localObject1).equalInputText;
      localObject1 = (ArkAppCenter)localQQAppInterface.getManager(120);
      paramArrayList = new acdd((String)localObject2, bool1, paramArrayList);
      ((ArkAppCenter)localObject1).a().a(arrayOfString[0], arrayOfString[1], 1, localArrayList, null, paramIGetAppInfosByContextListCallback, paramArrayList);
      break;
      paramArrayList.put(((RecommendCommonMessage.ArkContextInfo)localObject1).context, localObject2);
      paramArrayList = paramArrayList.toString();
    }
  }
  
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
    boolean bool2 = true;
    if (this.mIsMsgParsedByAi) {}
    for (;;)
    {
      return;
      boolean bool1;
      if (isArkAtBabyQMsg())
      {
        localObject1 = getExtInfoFromExtStr("ark_ai_message_parsed");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("1"))) {}
        for (bool1 = true;; bool1 = false)
        {
          this.mIsMsgParsedByAi = bool1;
          return;
        }
      }
      this.mOldAppInfo.appName = getExtInfoFromExtStr("ark_ai_message_name");
      this.mOldAppInfo.appView = getExtInfoFromExtStr("ark_ai_message_view");
      this.mOldAppInfo.appVer = getExtInfoFromExtStr("ark_ai_message_ver");
      this.mOldAppInfo.meta = getExtInfoFromExtStr("ark_ai_message_meta");
      this.mOldAppInfo.keyword = getExtInfoFromExtStr("ark_ai_message_keyword");
      Object localObject1 = getExtInfoFromExtStr("ark_ai_message_data");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("data");
        i = 0;
        label159:
        if (i < localJSONArray.length())
        {
          localArkContextInfo = new RecommendCommonMessage.ArkContextInfo();
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          localArkContextInfo.context = localJSONObject.optString("context");
          localArkContextInfo.keyword = localJSONObject.optString("keyword");
          Object localObject2 = localJSONObject.optString("equalInputText");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1")))
          {
            bool1 = true;
            label244:
            localArkContextInfo.equalInputText = bool1;
            localArkContextInfo.contextMatchType = localJSONObject.optInt("contextMatchType");
            localJSONObject = (JSONObject)localJSONObject.get("sematic");
            localObject2 = localJSONObject.keys();
            while (((Iterator)localObject2).hasNext())
            {
              String str2 = (String)((Iterator)localObject2).next();
              String str3 = localJSONObject.optString(str2);
              if (!TextUtils.isEmpty(str3)) {
                localArkContextInfo.semantic.put(str2, str3);
              }
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        RecommendCommonMessage.ArkContextInfo localArkContextInfo;
        if (QLog.isColorLevel()) {
          QLog.d("Ark", 2, "RecommendCommonMessage doParse json parse exception=" + localJSONException);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(this.mOldAppInfo.appName)) {
            break label596;
          }
          bool1 = true;
          this.mIsMsgParsedByAi = bool1;
          if (!this.mIsMsgParsedByAi)
          {
            if (this.mContextList.size() <= 0) {
              break label601;
            }
            bool1 = true;
            this.mIsMsgParsedByAi = bool1;
          }
          if (this.mIsMsgParsedByAi) {
            break;
          }
          String str1 = getExtInfoFromExtStr("ark_ai_message_parsed");
          if ((TextUtils.isEmpty(str1)) || (!str1.equals("1"))) {
            break label606;
          }
          bool1 = bool2;
          this.mIsMsgParsedByAi = bool1;
          return;
          bool1 = false;
          break label244;
          this.mContextList.add(localArkContextInfo);
          i += 1;
          break label159;
          this.mIsShow = str1.optBoolean("show");
          this.mHasReportShowIcon = str1.optBoolean("reportIcon");
          this.mHasReportShowUnderline = str1.optBoolean("reportUnderline");
          this.isFromArkServer = str1.optBoolean("fromArkServer", false);
          this.arkServerMsgId = str1.optString("msgId", null);
          this.arkServerExtraInfo = str1.optString("extraInfo", null);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Ark", 2, "RecommendCommonMessage doParse exception=" + localException);
            continue;
            label596:
            bool1 = false;
            continue;
            label601:
            bool1 = false;
            continue;
            label606:
            bool1 = false;
          }
        }
      }
    }
  }
  
  public int getAtLength(int paramInt)
  {
    int j = 0;
    int i = this.atIndex.size() - 1;
    if (j <= i)
    {
      int k = j + (i - j) / 2;
      int m = ((Integer)this.atIndex.get(k)).intValue();
      if ((m <= paramInt) && (((Integer)this.atLength.get(k)).intValue() + m >= paramInt)) {
        return ((Integer)this.atLength.get(k)).intValue();
      }
      if (m > paramInt) {
        i = k - 1;
      }
      for (;;)
      {
        break;
        j = k + 1;
      }
    }
    return -1;
  }
  
  public boolean hasAiData()
  {
    return (this.mContextList.size() > 0) || (!TextUtils.isEmpty(this.mOldAppInfo.appName));
  }
  
  public boolean isArkAtBabyQMsg()
  {
    return "1".equals(getExtInfoFromExtStr(MessageConstants.d));
  }
  
  public int isIncludedByAt(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = this.atIndex.size() - 1;
    if (j <= i)
    {
      int k = j + (i - j) / 2;
      int m = ((Integer)this.atIndex.get(k)).intValue();
      if ((m <= paramInt1) && (((Integer)this.atLength.get(k)).intValue() + m >= paramInt1 + paramInt2)) {
        return m;
      }
      if (m > paramInt1) {
        i = k - 1;
      }
      for (;;)
      {
        break;
        j = k + 1;
      }
    }
    return -1;
  }
  
  public void saveRecommendMsg(WeakReference paramWeakReference, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      if (this.mIsMsgParsedByAi)
      {
        localObject = "1";
        saveExtInfoToExtStr("ark_ai_message_parsed", (String)localObject);
      }
    }
    for (;;)
    {
      if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
        break label455;
      }
      return;
      localObject = "0";
      break;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONArray = new JSONArray();
        paramInt = 0;
        if (paramInt < this.mContextList.size())
        {
          localJSONObject2 = new JSONObject();
          RecommendCommonMessage.ArkContextInfo localArkContextInfo = (RecommendCommonMessage.ArkContextInfo)this.mContextList.get(paramInt);
          localJSONObject2.put("context", localArkContextInfo.context);
          localJSONObject2.put("keyword", localArkContextInfo.keyword);
          if (localArkContextInfo.equalInputText)
          {
            localObject = "1";
            localJSONObject2.put("equalInputText", localObject);
            localJSONObject2.put("contextMatchType", localArkContextInfo.contextMatchType);
            localObject = new JSONObject();
            Iterator localIterator = localArkContextInfo.semantic.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str2 = (String)localIterator.next();
              String str3 = (String)localArkContextInfo.semantic.get(str2);
              if (!TextUtils.isEmpty(str3)) {
                ((JSONObject)localObject).put(str2, str3);
              }
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        JSONObject localJSONObject2;
        while (QLog.isColorLevel())
        {
          QLog.d("Ark", 2, "RecommendCommonMessage saveRecommendMsg json parse exception=" + localJSONException);
          break;
          String str1 = "0";
          continue;
          localJSONObject2.put("sematic", str1);
          localJSONArray.put(localJSONObject2);
          paramInt += 1;
        }
        localJSONObject1.put("data", localJSONArray);
        localJSONObject1.put("show", this.mIsShow);
        localJSONObject1.put("reportIcon", this.mHasReportShowIcon);
        localJSONObject1.put("reportUnderline", this.mHasReportShowUnderline);
        localJSONObject1.put("fromArkServer", this.isFromArkServer);
        localJSONObject1.put("msgId", this.arkServerMsgId);
        localJSONObject1.put("extraInfo", this.arkServerExtraInfo);
        saveExtInfoToExtStr("ark_ai_message_data", localJSONObject1.toString());
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.d("Ark", 2, "RecommendCommonMessage saveRecommendMsg exception=" + localException);
      }
    }
    label455:
    ThreadManager.post(new acde(this, paramWeakReference), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage
 * JD-Core Version:    0.7.0.1
 */