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
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[showGrayTip], content:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",start:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",end:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",url:");
    ((StringBuilder)localObject).append(paramString3);
    QLog.i("GameMsgGrayTipsHandler", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentUin(), paramString2, 10007, -5020, 656397, MessageCache.a());
    paramString2 = new MessageForUniteGrayTip();
    if (!TextUtils.isEmpty(paramString3))
    {
      int j = 0;
      int i;
      if (paramInt2 > paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramInt1 >= 0) {
        j = 1;
      }
      if ((j & i) != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_action", 1);
        ((Bundle)localObject).putString("textColor", "#40A0FF");
        ((Bundle)localObject).putString("key_action_DATA", paramString3);
        paramString1.a(paramInt1, paramInt2, (Bundle)localObject);
      }
    }
    paramString2.msgUid = paramLong;
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString2);
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
      Object localObject2 = paramArrayList;
      int k = 0;
      int j = 0;
      int i = 0;
      while (localIterator.hasNext())
      {
        GameMsgGrayTipsHandler.GrayTipsChildInfo localGrayTipsChildInfo = (GameMsgGrayTipsHandler.GrayTipsChildInfo)localIterator.next();
        if (i == 0) {
          j = paramArrayList.length();
        }
        int n = k;
        int m = i;
        Object localObject1 = localObject2;
        if (2 == localGrayTipsChildInfo.jdField_a_of_type_Int)
        {
          n = k;
          m = i;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(localGrayTipsChildInfo.b))
          {
            n = k;
            m = i;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localGrayTipsChildInfo.jdField_a_of_type_JavaLangString))
            {
              n = k;
              m = i;
              localObject1 = localObject2;
              if (k == 0)
              {
                localObject1 = localGrayTipsChildInfo.b;
                i = localGrayTipsChildInfo.jdField_a_of_type_JavaLangString.length();
                m = i + j;
                n = 1;
              }
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramArrayList);
        ((StringBuilder)localObject2).append(localGrayTipsChildInfo.jdField_a_of_type_JavaLangString);
        paramArrayList = ((StringBuilder)localObject2).toString();
        k = n;
        i = m;
        localObject2 = localObject1;
      }
      a(paramQQAppInterface, paramString1, paramArrayList, j, i, (String)localObject2, paramLong);
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.e, "1", "145", "920", "92005", "207652", paramArrayList, "", "8", "");
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
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.e, "1", "145", "920", "92005", "207652", paramArrayList, "", "8", paramQQAppInterface, "", paramString1);
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
          localGrayTipsChildInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("title");
          localGrayTipsChildInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
          localGrayTipsChildInfo.b = localJSONObject.optString("url");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler
 * JD-Core Version:    0.7.0.1
 */