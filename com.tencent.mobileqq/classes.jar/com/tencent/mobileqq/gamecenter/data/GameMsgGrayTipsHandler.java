package com.tencent.mobileqq.gamecenter.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameMsgGrayTipsHandler
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, UniteGrayTipParam paramUniteGrayTipParam)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.msgUid = paramLong;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, paramUniteGrayTipParam);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<GameMsgGrayTipsHandler.GrayTipsChildInfo> paramArrayList, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgGrayTipsHandler", 2, "[createGrayTips]");
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = "";
      Object localObject1 = paramArrayList;
      int n = 0;
      int m = 0;
      int k = 0;
      while (localIterator.hasNext())
      {
        GameMsgGrayTipsHandler.GrayTipsChildInfo localGrayTipsChildInfo = (GameMsgGrayTipsHandler.GrayTipsChildInfo)localIterator.next();
        if (n == 0) {
          k = paramArrayList.length();
        }
        int i;
        int j;
        if ((2 == localGrayTipsChildInfo.a) && (m == 0) && (!TextUtils.isEmpty(localGrayTipsChildInfo.b)) && (!TextUtils.isEmpty(localGrayTipsChildInfo.c)))
        {
          localObject2 = localGrayTipsChildInfo.c;
          i = localGrayTipsChildInfo.b.length();
          j = localGrayTipsChildInfo.a;
          i += k;
        }
        else
        {
          i = n;
          localObject2 = localObject1;
          j = m;
          if (3 == localGrayTipsChildInfo.a)
          {
            i = n;
            localObject2 = localObject1;
            j = m;
            if (m == 0)
            {
              i = n;
              localObject2 = localObject1;
              j = m;
              if (!TextUtils.isEmpty(localGrayTipsChildInfo.b))
              {
                i = localGrayTipsChildInfo.b.length();
                j = localGrayTipsChildInfo.a;
                i += k;
                localObject2 = localObject1;
              }
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramArrayList);
        ((StringBuilder)localObject1).append(localGrayTipsChildInfo.b);
        paramArrayList = ((StringBuilder)localObject1).toString();
        n = i;
        localObject1 = localObject2;
        m = j;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[createGrayTips], content:");
      ((StringBuilder)localObject2).append(paramArrayList);
      ((StringBuilder)localObject2).append(",type:");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(",start:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",end:");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(",url:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("GameMsgGrayTipsHandler", 1, ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty(paramArrayList))
      {
        paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentUin(), paramArrayList, 10007, -5020, 656397, MessageCache.c());
        a(paramString1, m, k, n, (String)localObject1);
        a(paramQQAppInterface, paramLong, paramString1);
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.bi, "1", "145", "920", "92005", "207652", paramArrayList, "", "8", "");
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
      {
        paramQQAppInterface = paramString2;
        paramString1 = paramString3;
      }
      else if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = paramQQAppInterface.getCurrentAccountUin();
        paramQQAppInterface = paramString4;
      }
      else
      {
        paramQQAppInterface = "";
        paramString1 = paramQQAppInterface;
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.bi, "1", "145", "920", "92005", "207652", paramArrayList, "", "8", paramQQAppInterface, "", paramString1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleGrayTipsFrom0x11c],data:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      ((StringBuilder)localObject).append(",uid:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("GameMsgGrayTipsHandler", 1, ((StringBuilder)localObject).toString());
      localObject = paramJSONObject.optString("from_tinyid");
      String str1 = paramJSONObject.optString("tinyid");
      String str2 = ((IMessageFacade)paramQQAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a((String)localObject, str1);
      if (a(paramQQAppInterface, str2, paramLong)) {
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content", paramJSONObject.optJSONArray("content"));
      localJSONArray.put(localJSONObject);
      a(localJSONArray, paramQQAppInterface, str2, (String)localObject, str1, "", paramLong);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("GameMsgGrayTipsHandler", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(UniteGrayTipParam paramUniteGrayTipParam, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt3 > paramInt2)
    {
      if (paramInt2 < 0) {
        return;
      }
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        paramString = new Bundle();
        paramString.putInt("key_action", 68);
        paramString.putString("textColor", "#40A0FF");
        paramUniteGrayTipParam.a(paramInt2, paramInt3, paramString);
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 1);
        localBundle.putString("textColor", "#40A0FF");
        localBundle.putString("key_action_DATA", paramString);
        paramUniteGrayTipParam.a(paramInt2, paramInt3, localBundle);
      }
    }
  }
  
  public static void a(Object paramObject, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgGrayTipsHandler", 2, new Object[] { "[onGetGrayTips], data:", paramObject });
      }
      paramObject = (JSONArray)paramObject;
      int i = 0;
      while (i < paramObject.length())
      {
        JSONArray localJSONArray = paramObject.getJSONObject(i).getJSONArray("content");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < localJSONArray.length())
        {
          GameMsgGrayTipsHandler.GrayTipsChildInfo localGrayTipsChildInfo = new GameMsgGrayTipsHandler.GrayTipsChildInfo();
          JSONObject localJSONObject = localJSONArray.getJSONObject(j);
          localGrayTipsChildInfo.b = localJSONObject.optString("title");
          localGrayTipsChildInfo.a = localJSONObject.optInt("type");
          localGrayTipsChildInfo.c = localJSONObject.optString("url");
          localArrayList.add(localGrayTipsChildInfo);
          j += 1;
        }
        a(paramQQAppInterface, paramString1, localArrayList, paramString2, paramString3, paramString4, paramLong);
        i += 1;
      }
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("GameMsgGrayTipsHandler", 1, paramObject, new Object[0]);
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramString, 10007, 10).iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (MessageRecord)paramQQAppInterface.next();
        if ((paramString != null) && ((paramString instanceof MessageForUniteGrayTip)) && (paramString.msgUid == paramLong))
        {
          QLog.i("GameMsgGrayTipsHandler", 1, "The Same game graytips!");
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramQQAppInterface) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler
 * JD-Core Version:    0.7.0.1
 */