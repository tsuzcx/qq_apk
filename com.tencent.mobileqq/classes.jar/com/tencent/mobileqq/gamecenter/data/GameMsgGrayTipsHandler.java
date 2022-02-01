package com.tencent.mobileqq.gamecenter.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler.GrayTipsChildInfo;>;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameMsgGrayTipsHandler
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameMsgChatPie.g;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[showGrayTip], content:" + paramString2 + ",start:" + paramInt1 + ",end:" + paramInt2 + ",url:" + paramString3);
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentUin(), paramString2, 10007, -5020, 656397, MessageCache.a());
    paramString2 = new MessageForUniteGrayTip();
    int i;
    if (!TextUtils.isEmpty(paramString3))
    {
      if (paramInt2 <= paramInt1) {
        break label185;
      }
      i = 1;
      if (paramInt1 < 0) {
        break label191;
      }
    }
    label185:
    label191:
    for (int j = 1;; j = 0)
    {
      if ((j & i) != 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 1);
        localBundle.putString("textColor", "#40A0FF");
        localBundle.putString("key_action_DATA", paramString3);
        paramString1.a(paramInt1, paramInt2, localBundle);
      }
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      UniteGrayTipUtil.a(paramQQAppInterface, paramString2);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<GameMsgGrayTipsHandler.GrayTipsChildInfo> paramArrayList, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[createGrayTips]");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    String str = "";
    int k = 0;
    int i = 0;
    Object localObject = "";
    Iterator localIterator = paramArrayList.iterator();
    int j = 0;
    for (paramArrayList = (ArrayList<GameMsgGrayTipsHandler.GrayTipsChildInfo>)localObject; localIterator.hasNext(); paramArrayList = (ArrayList<GameMsgGrayTipsHandler.GrayTipsChildInfo>)localObject)
    {
      GameMsgGrayTipsHandler.GrayTipsChildInfo localGrayTipsChildInfo = (GameMsgGrayTipsHandler.GrayTipsChildInfo)localIterator.next();
      if (i == 0) {
        k = str.length();
      }
      int n = j;
      int m = i;
      localObject = paramArrayList;
      if (2 == localGrayTipsChildInfo.jdField_a_of_type_Int)
      {
        n = j;
        m = i;
        localObject = paramArrayList;
        if (!TextUtils.isEmpty(localGrayTipsChildInfo.b))
        {
          n = j;
          m = i;
          localObject = paramArrayList;
          if (!TextUtils.isEmpty(localGrayTipsChildInfo.jdField_a_of_type_JavaLangString))
          {
            n = j;
            m = i;
            localObject = paramArrayList;
            if (j == 0)
            {
              localObject = localGrayTipsChildInfo.b;
              m = k + localGrayTipsChildInfo.jdField_a_of_type_JavaLangString.length();
              n = 1;
            }
          }
        }
      }
      str = str + localGrayTipsChildInfo.jdField_a_of_type_JavaLangString;
      j = n;
      i = m;
    }
    a(paramQQAppInterface, paramString1, str, k, i, paramArrayList);
    GameMsgUtil.a(GameMsgChatPie.h, "1", "145", "920", "92005", "207652", str, "", "8", "");
    paramString1 = "";
    paramArrayList = "";
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramArrayList = paramString3;
      paramString1 = paramString2;
    }
    for (;;)
    {
      GameMsgUtil.a(GameMsgChatPie.h, "1", "145", "920", "92005", "207652", str, "", "8", paramString1, "", paramArrayList);
      return;
      if (!TextUtils.isEmpty(paramString4))
      {
        paramArrayList = paramQQAppInterface.getCurrentAccountUin();
        paramString1 = paramString4;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    try
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[handleGrayTipsFrom0x11c],data:" + paramJSONObject.toString());
      String str1 = paramJSONObject.optString("from_tinyid");
      String str2 = paramJSONObject.optString("tinyid");
      paramJSONObject = paramJSONObject.optJSONArray("content");
      String str3 = paramQQAppInterface.getTinyIdCache().a(str1, str2);
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content", paramJSONObject);
      localJSONArray.put(localJSONObject);
      a(localJSONArray, paramQQAppInterface, str3, str1, str2, "");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(Object paramObject, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onGetGrayTips], data:", paramObject });
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
        a(paramQQAppInterface, paramString1, localArrayList, paramString2, paramString3, paramString4);
        i += 1;
      }
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramObject, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler
 * JD-Core Version:    0.7.0.1
 */