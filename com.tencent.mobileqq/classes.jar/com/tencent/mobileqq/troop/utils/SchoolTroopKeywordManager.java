package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SchoolTroopKeywordManager
  implements Manager
{
  public static final String a;
  private static final String[] a;
  private static final String[] b = { "", "将“{0}”发布为公告，可以更好地通知到群成员。", "将“{0}”发布为作业，可以更方便查看作业情况。" };
  protected SparseArray a;
  protected final QQAppInterface a;
  protected LinkedHashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ".troop.school_troop." + SchoolTroopKeywordManager.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "", "转为群公告", "发布作业" };
  }
  
  public SchoolTroopKeywordManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    if (paramString1.length() <= 0) {
      return "";
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = new StringBuilder();
    int k = paramString1.length();
    int i = 0;
    if (i < k)
    {
      int m = paramString1.codePointAt(i);
      if (EmotcationConstants.a.get(m, -1) != -1)
      {
        int j = i;
        if (m > 65535) {
          j = i + 1;
        }
        paramString2.append(str);
        i = j;
      }
      for (;;)
      {
        i += 1;
        break;
        if (m == 20)
        {
          i += 1;
          paramString2.append(str);
        }
        else
        {
          paramString2.append(paramString1.charAt(i));
        }
      }
    }
    return paramString2.toString();
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("troop_school_keyword_config", "");
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "The configString is empty, new user or no config");
      }
      return;
    }
    a(str);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "loadConfig cost time: " + (System.currentTimeMillis() - l));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 1) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.dwGroupClassExt == 32L;
  }
  
  public int a(SessionInfo paramSessionInfo)
  {
    int j = 1;
    if (paramSessionInfo.jdField_a_of_type_Int != 1)
    {
      j = -1;
      return j;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      return -4;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "it must be wrong. The troopUin '" + paramSessionInfo.jdField_a_of_type_JavaLangString + "' has not troopInfo");
      return -2;
    }
    if (localTroopInfo.dwGroupClassExt != 32L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "Not school troop. The troopUin '" + paramSessionInfo.jdField_a_of_type_JavaLangString + "', dwGroupClassExt = " + localTroopInfo.dwGroupClassExt);
      }
      return -3;
    }
    if (localTroopInfo.isTroopOwner(str)) {}
    for (;;)
    {
      label176:
      paramSessionInfo = localTroopManager.b(localTroopInfo.troopuin, str);
      int i = j;
      if (paramSessionInfo != null)
      {
        if (paramSessionInfo.level != 332) {
          break label270;
        }
        i = j | 0x4;
      }
      for (;;)
      {
        j = i;
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "detect role. The currentUin '" + str + "', role = " + i);
        return i;
        if (!localTroopInfo.isTroopAdmin(str)) {
          break label290;
        }
        j = 2;
        break label176;
        label270:
        i = j;
        if (paramSessionInfo.level == 333) {
          i = j | 0x8;
        }
      }
      label290:
      j = 0;
    }
  }
  
  public SchoolTroopKeywordManager.KeywordResult a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.msg))) {
      paramSessionInfo = null;
    }
    long l2;
    String str1;
    do
    {
      return paramSessionInfo;
      i = a(paramSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "detectKeyword.detectRole time cost: " + (System.currentTimeMillis() - l1));
      }
      if (i <= 0) {
        return null;
      }
      if (((i & 0x2) != 2) && ((i & 0x1) != 1)) {
        return null;
      }
      if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "Keywords is empty, the config is error?");
        }
        return null;
      }
      l2 = paramMessageRecord.uniseq;
      str1 = l2 + "_" + i;
      localKeywordResult = (SchoolTroopKeywordManager.KeywordResult)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str1);
      if (localKeywordResult == null) {
        break;
      }
      paramSessionInfo = localKeywordResult;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "detectKeyword.useCache time cost: " + (System.currentTimeMillis() - l1));
    return localKeywordResult;
    paramMessageRecord = paramMessageRecord.msg;
    SchoolTroopKeywordManager.KeywordResult localKeywordResult = new SchoolTroopKeywordManager.KeywordResult();
    localKeywordResult.jdField_a_of_type_Long = l2;
    localKeywordResult.jdField_a_of_type_Int = i;
    localKeywordResult.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    localKeywordResult.a(paramMessageRecord);
    int k = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < k)
    {
      int m = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      paramSessionInfo = (String[])this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
      int n = paramSessionInfo.length;
      int j = 0;
      while (j < n)
      {
        String str2 = paramSessionInfo[j];
        int i1 = paramMessageRecord.indexOf(str2);
        if (i1 != -1)
        {
          localKeywordResult.jdField_b_of_type_Int = m;
          localKeywordResult.jdField_b_of_type_JavaLangString = str2;
          localKeywordResult.c = i1;
          localKeywordResult.d = (str2.length() + i1);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str1, localKeywordResult);
          return localKeywordResult;
        }
        j += 1;
      }
      i += 1;
    }
    localKeywordResult.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str1, localKeywordResult);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "detectKeyword time cost: " + (System.currentTimeMillis() - l1) + ", result = " + localKeywordResult.jdField_b_of_type_Int);
    }
    return localKeywordResult;
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "update config, config=" + paramString);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int k = localJSONArray.length();
        i = 0;
        if (i < k)
        {
          Object localObject = localJSONArray.optJSONObject(i);
          int m = ((JSONObject)localObject).getInt("action");
          if (m >= jdField_a_of_type_ArrayOfJavaLangString.length) {
            break label308;
          }
          ArrayList localArrayList = new ArrayList();
          localObject = ((JSONObject)localObject).getJSONArray("words");
          int n = ((JSONArray)localObject).length();
          int j = 0;
          if (j < n)
          {
            localArrayList.add(((JSONArray)localObject).getString(j));
            j += 1;
            continue;
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.put(m, localArrayList.toArray(new String[localArrayList.size()]));
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "parse config error, config = " + paramString);
        return;
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
        return;
      }
      finally
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "updateConfig cost time: " + (System.currentTimeMillis() - l));
      }
      label308:
      i += 1;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager
 * JD-Core Version:    0.7.0.1
 */