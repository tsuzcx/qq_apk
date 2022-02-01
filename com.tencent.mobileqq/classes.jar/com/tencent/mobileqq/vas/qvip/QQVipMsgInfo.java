package com.tencent.mobileqq.vas.qvip;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQVipMsgInfo
  implements Serializable
{
  public static final int MSG_TYPE_ARK = 1;
  public static final int MSG_TYPE_IMGHEADER = 2;
  public static final int MSG_TYPE_TEXTHEADER = 3;
  public String mActionUrl;
  public String mAdvId;
  public String mAmsMessageClickUrl;
  public String mAmsMessageExposeUrl;
  public String mAmsRPClickUrl;
  public String mAmsRPExposeUrl;
  public String mArkAppConfig;
  public String mArkAppMinVersion;
  public String mArkAppName;
  public String mArkAppView;
  public String mArkMetaList;
  public String mContentText;
  public String mCoverUrl;
  public String mDateTitle;
  public String mExtJson;
  public String mFrienduin;
  public String mGameAppId;
  public boolean mIsAmsAdv = false;
  public boolean mIsGameArk = false;
  public String mLimitText;
  public long mMsgTime;
  public int mMsgType;
  public String mPaMsgid;
  public String mSortedConfigs;
  public String mTaskId;
  public String mTitle;
  public String mTriggerInfo;
  public long mUniseq;
  public String mUrl;
  
  @Nullable
  private static QQVipMsgInfo a(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    try
    {
      localObject = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
      if (localObject == null) {
        return null;
      }
      if (a(paramMessageRecord, paramQQVipMsgInfo, (ArrayList)localObject)) {
        return paramQQVipMsgInfo;
      }
      if (((ArrayList)localObject).size() == 2)
      {
        b(paramMessageRecord, paramQQVipMsgInfo);
        return paramQQVipMsgInfo;
      }
    }
    catch (Throwable paramMessageRecord)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createHeader failed structMsg error=");
      ((StringBuilder)localObject).append(paramMessageRecord.toString());
      QLog.e("QQVipMsgInfo", 1, ((StringBuilder)localObject).toString());
    }
    return paramQQVipMsgInfo;
  }
  
  private static void a(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      try
      {
        paramQQVipMsgInfo.mGameAppId = paramMessageRecord.ark_app_message.mSourceName;
        paramQQVipMsgInfo.mArkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
        paramQQVipMsgInfo.mArkAppName = paramMessageRecord.ark_app_message.appName;
        paramQQVipMsgInfo.mArkAppView = paramMessageRecord.ark_app_message.appView;
        paramQQVipMsgInfo.mArkMetaList = paramMessageRecord.ark_app_message.metaList;
        paramQQVipMsgInfo.mArkAppConfig = paramMessageRecord.ark_app_message.config;
        parseArkAdvInfo(paramMessageRecord, paramQQVipMsgInfo);
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        paramQQVipMsgInfo = new StringBuilder();
        paramQQVipMsgInfo.append("MessageForArkApp error =");
        paramQQVipMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQVipMsgInfo", 1, paramQQVipMsgInfo.toString());
        return;
      }
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {
      try
      {
        paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        ArrayList localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
        if (localArrayList == null) {
          return;
        }
        if (a(paramQQVipMsgInfo, localArrayList)) {
          return;
        }
        if (localArrayList.size() == 2)
        {
          paramQQVipMsgInfo.mGameAppId = GamePubAccountConstant.a(paramMessageRecord.mMsgUrl);
          return;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        paramQQVipMsgInfo = new StringBuilder();
        paramQQVipMsgInfo.append("createHeader failed structMsg error=");
        paramQQVipMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQVipMsgInfo", 1, paramQQVipMsgInfo.toString());
      }
    }
  }
  
  private static void a(QQVipMsgInfo paramQQVipMsgInfo, ArrayList<AbsStructMsgElement> paramArrayList, int paramInt)
  {
    if (((paramArrayList.get(paramInt) instanceof StructMsgItemButton)) && (TextUtils.isEmpty(paramQQVipMsgInfo.mUrl)))
    {
      paramArrayList = ((StructMsgItemButton)paramArrayList.get(paramInt)).b;
      if (!TextUtils.isEmpty(paramArrayList)) {
        paramQQVipMsgInfo.mUrl = paramArrayList;
      }
    }
  }
  
  private static boolean a(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo, ArrayList<AbsStructMsgElement> paramArrayList)
  {
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < paramArrayList.size(); j = m)
    {
      int n = i;
      m = j;
      if ((paramArrayList.get(k) instanceof AbsStructMsgItem))
      {
        ArrayList localArrayList = ((AbsStructMsgItem)paramArrayList.get(k)).a;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        while (m < localArrayList.size())
        {
          if ((localArrayList.get(m) instanceof StructMsgItemTitle))
          {
            n = 1;
          }
          else
          {
            n = j;
            if ((localArrayList.get(m) instanceof StructMsgItemCover))
            {
              i = 1;
              n = j;
            }
          }
          if ((n != 0) && (i != 0))
          {
            c(paramMessageRecord, paramQQVipMsgInfo);
            return true;
          }
          m += 1;
          j = n;
        }
        m = i;
        n = j;
      }
      k += 1;
      i = n;
    }
    if (i != 0)
    {
      b(paramMessageRecord, paramQQVipMsgInfo);
      return true;
    }
    return false;
  }
  
  private static boolean a(QQVipMsgInfo paramQQVipMsgInfo, StringBuilder paramStringBuilder, boolean paramBoolean, ArrayList<AbsStructMsgElement> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      boolean bool = paramBoolean;
      String str;
      if ((paramArrayList.get(i) instanceof StructMsgItemSummary))
      {
        str = ((StructMsgItemSummary)paramArrayList.get(i)).ai;
        bool = paramBoolean;
        if (!TextUtils.isEmpty(str))
        {
          paramStringBuilder.append(str);
          bool = true;
        }
      }
      if ((paramArrayList.get(i) instanceof StructMsgItemButton))
      {
        str = ((StructMsgItemButton)paramArrayList.get(i)).b;
        if ((TextUtils.isEmpty(paramQQVipMsgInfo.mUrl)) && (!TextUtils.isEmpty(str))) {
          paramQQVipMsgInfo.mUrl = str;
        }
      }
      i += 1;
      paramBoolean = bool;
    }
    return paramBoolean;
  }
  
  private static boolean a(QQVipMsgInfo paramQQVipMsgInfo, ArrayList<AbsStructMsgElement> paramArrayList)
  {
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < paramArrayList.size(); j = m)
    {
      int n = i;
      m = j;
      if ((paramArrayList.get(k) instanceof AbsStructMsgItem))
      {
        ArrayList localArrayList = ((AbsStructMsgItem)paramArrayList.get(k)).a;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        while (m < localArrayList.size())
        {
          if ((localArrayList.get(m) instanceof StructMsgItemTitle))
          {
            n = 1;
          }
          else
          {
            n = j;
            if ((localArrayList.get(m) instanceof StructMsgItemCover))
            {
              i = 1;
              n = j;
            }
          }
          if ((n != 0) && (i != 0))
          {
            paramQQVipMsgInfo.mGameAppId = GamePubAccountConstant.a(((AbsStructMsgElement)paramArrayList.get(k)).b);
            return true;
          }
          m += 1;
          j = n;
        }
        m = i;
        n = j;
      }
      k += 1;
      i = n;
    }
    return false;
  }
  
  private static boolean a(QQVipMsgInfo paramQQVipMsgInfo, ArrayList<AbsStructMsgElement> paramArrayList1, int paramInt, ArrayList<AbsStructMsgElement> paramArrayList2)
  {
    int i = 0;
    boolean bool2 = false;
    boolean bool4;
    boolean bool3;
    for (boolean bool1 = false;; bool1 = bool3)
    {
      bool4 = bool2;
      bool3 = bool1;
      if (i >= paramArrayList2.size()) {
        break;
      }
      if (((paramArrayList2.get(i) instanceof StructMsgItemTitle)) && (!bool2))
      {
        paramQQVipMsgInfo.mTitle = ((StructMsgItemTitle)paramArrayList2.get(i)).ai;
        bool4 = true;
        bool3 = bool1;
      }
      else
      {
        bool4 = bool2;
        bool3 = bool1;
        if ((paramArrayList2.get(i) instanceof StructMsgItemCover))
        {
          bool4 = bool2;
          bool3 = bool1;
          if (!bool1)
          {
            paramQQVipMsgInfo.mCoverUrl = ((StructMsgItemCover)paramArrayList2.get(i)).ac;
            bool3 = true;
            bool4 = bool2;
          }
        }
      }
      a(paramQQVipMsgInfo, paramArrayList2, i);
      if ((a(bool4, bool3)) && (!TextUtils.isEmpty(paramQQVipMsgInfo.mUrl))) {
        break;
      }
      i += 1;
      bool2 = bool4;
    }
    paramQQVipMsgInfo.mUrl = ((AbsStructMsgElement)paramArrayList1.get(paramInt)).b;
    return a(bool4, bool3);
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramBoolean1) && (paramBoolean2);
  }
  
  private static void b(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramQQVipMsgInfo.mMsgType = 3;
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return;
    }
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if (!(paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare)) {
      return;
    }
    paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
    ArrayList localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
    paramQQVipMsgInfo.mTitle = ((StructMsgItemTitle)((AbsStructMsgItem)localArrayList.get(0)).a.get(0)).ai;
    StringBuilder localStringBuilder = new StringBuilder();
    paramQQVipMsgInfo.mUrl = paramMessageRecord.mMsgUrl;
    int i = 1;
    boolean bool1 = false;
    while (i < localArrayList.size())
    {
      boolean bool2 = a(paramQQVipMsgInfo, localStringBuilder, bool1, ((AbsStructMsgItem)localArrayList.get(i)).a);
      bool1 = bool2;
      if (bool2)
      {
        localStringBuilder.append("\n");
        bool1 = false;
      }
      i += 1;
    }
    paramQQVipMsgInfo.mContentText = localStringBuilder.toString();
  }
  
  private static void c(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramQQVipMsgInfo.mMsgType = 2;
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    if (!bool) {
      return;
    }
    int i = 0;
    if (bool)
    {
      paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
      ArrayList localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
      paramQQVipMsgInfo.mUrl = paramMessageRecord.mMsgUrl;
      while (i < localArrayList.size())
      {
        if (((localArrayList.get(i) instanceof AbsStructMsgItem)) && (a(paramQQVipMsgInfo, localArrayList, i, ((AbsStructMsgItem)localArrayList.get(i)).a))) {
          return;
        }
        i += 1;
      }
    }
    if ((paramMessageRecord instanceof MessageForPubAccount))
    {
      paramMessageRecord = (MessageForPubAccount)paramMessageRecord;
      paramMessageRecord.mPAMessage = ((PAMessage)((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(paramMessageRecord.msgData));
      paramQQVipMsgInfo.mCoverUrl = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).cover;
      paramQQVipMsgInfo.mTitle = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).title;
      paramQQVipMsgInfo.mUrl = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).url;
    }
  }
  
  private static void d(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramQQVipMsgInfo.mMsgType = 1;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      try
      {
        paramQQVipMsgInfo.mArkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
        paramQQVipMsgInfo.mArkAppName = paramMessageRecord.ark_app_message.appName;
        paramQQVipMsgInfo.mArkAppView = paramMessageRecord.ark_app_message.appView;
        paramQQVipMsgInfo.mArkMetaList = paramMessageRecord.ark_app_message.metaList;
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        paramQQVipMsgInfo = new StringBuilder();
        paramQQVipMsgInfo.append("MessageForArkApp error =");
        paramQQVipMsgInfo.append(paramMessageRecord.toString());
        QLog.e("QQVipMsgInfo", 1, paramQQVipMsgInfo.toString());
      }
    }
  }
  
  private static void e(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramQQVipMsgInfo.mIsGameArk = ((MessageForArkApp)paramMessageRecord).ark_app_message.metaList.contains("posId=237");
    }
  }
  
  public static void parseArkAdvInfo(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      try
      {
        paramMessageRecord = new JSONObject(((MessageForArkApp)paramMessageRecord).ark_app_message.metaList);
        boolean bool2 = paramMessageRecord.keys().hasNext();
        boolean bool1 = false;
        if (!bool2)
        {
          QLog.e("QQVipMsgInfo", 1, new Object[] { "parseArkAdvInfo fail, metaObj err, metaObj=", paramMessageRecord });
          return;
        }
        paramMessageRecord = paramMessageRecord.getJSONObject((String)paramMessageRecord.keys().next());
        if (paramMessageRecord == null)
        {
          QLog.e("QQVipMsgInfo", 1, "parseArkAdvInfo fail, arkDataObj is null");
          return;
        }
        if (paramMessageRecord.optInt("is_ams", 0) == 1) {
          bool1 = true;
        }
        paramQQVipMsgInfo.mIsAmsAdv = bool1;
        if (paramQQVipMsgInfo.mIsAmsAdv)
        {
          paramQQVipMsgInfo.mAmsRPExposeUrl = paramMessageRecord.optString("redpoint_expose");
          paramQQVipMsgInfo.mAmsRPClickUrl = paramMessageRecord.optString("redpoint_click");
          paramQQVipMsgInfo.mAmsMessageExposeUrl = paramMessageRecord.optString("message_expose");
          paramQQVipMsgInfo.mAmsMessageClickUrl = paramMessageRecord.optString("message_click");
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("QQVipMsgInfo", 1, "parseArkAdvInfo fail, metaList, err=", paramMessageRecord);
      }
    }
  }
  
  public static QQVipMsgInfo parseMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQVipMsgInfo", 1, "parseMessageRecord-->record is null");
      }
      return null;
    }
    QQVipMsgInfo localQQVipMsgInfo = new QQVipMsgInfo();
    localQQVipMsgInfo.mUniseq = paramMessageRecord.uniseq;
    localQQVipMsgInfo.mFrienduin = paramMessageRecord.frienduin;
    localQQVipMsgInfo.mMsgTime = paramMessageRecord.time;
    parseQGameInfo(paramMessageRecord, localQQVipMsgInfo);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      d(paramMessageRecord, localQQVipMsgInfo);
      e(paramMessageRecord, localQQVipMsgInfo);
      parseArkAdvInfo(paramMessageRecord, localQQVipMsgInfo);
      return localQQVipMsgInfo;
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {
      return a(paramMessageRecord, localQQVipMsgInfo);
    }
    if ((paramMessageRecord instanceof MessageForPubAccount))
    {
      c(paramMessageRecord, localQQVipMsgInfo);
      return localQQVipMsgInfo;
    }
    return null;
  }
  
  public static void parseQGameInfo(MessageRecord paramMessageRecord, QQVipMsgInfo paramQQVipMsgInfo)
  {
    Object localObject2 = paramMessageRecord.extStr;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramMessageRecord.mExJsonObject.toString();
    }
    paramQQVipMsgInfo.mPaMsgid = QQVipConstant.a(paramMessageRecord);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQVipMsgInfo.mTriggerInfo = ((String)localObject1);
          paramQQVipMsgInfo.mAdvId = PublicAccountEventReport.a((String)localObject1);
          localObject1 = new JSONObject((String)localObject1).optString("game_extra", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).optJSONArray("sorted_configs");
            if (localObject2 != null)
            {
              paramQQVipMsgInfo.mSortedConfigs = ((JSONArray)localObject2).toString();
              paramQQVipMsgInfo.mGameAppId = ((JSONArray)localObject2).optJSONObject(0).optString("app_id", "");
              paramQQVipMsgInfo.mTaskId = ((JSONArray)localObject2).optJSONObject(1).optString("task_id", "");
            }
            paramQQVipMsgInfo.mExtJson = ((JSONObject)localObject1).optString("ext_json", "");
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get getGameMsgInfoByMsg  msg err= ");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.d("QQVipMsgInfo", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    a(paramMessageRecord, paramQQVipMsgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.QQVipMsgInfo
 * JD-Core Version:    0.7.0.1
 */