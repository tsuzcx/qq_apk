package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopGameCardConfig
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  private String c = "";
  
  public static TroopGameCardConfig a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("content : ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopGameCardConfig", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = new TroopGameCardConfig();
    try
    {
      Object localObject2 = new JSONObject(paramString);
      ((TroopGameCardConfig)localObject1).a(((JSONObject)localObject2).optString("resUrl", ""));
      ((TroopGameCardConfig)localObject1).b(((JSONObject)localObject2).optString("resMd5", ""));
      ((TroopGameCardConfig)localObject1).c = ((JSONObject)localObject2).optString("troopCardTipsContent", "");
      ((TroopGameCardConfig)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("numOfMsgToCheck");
      paramString = new ArrayList();
      localObject2 = ((JSONObject)localObject2).getJSONArray("grayTroopUins");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          paramString.add(Integer.valueOf(((JSONArray)localObject2).getInt(i)));
          i += 1;
        }
      }
      ((TroopGameCardConfig)localObject1).jdField_a_of_type_JavaUtilList = paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("resUrl : ");
      paramString.append("");
      QLog.d("TroopGameCardConfig", 2, paramString.toString());
    }
    return localObject1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGrayTroop troopUin = ");
      localStringBuilder.append(paramString);
      QLog.d("TroopGameCardConfig", 2, localStringBuilder.toString());
    }
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = true;
    if ((!bool3) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      paramString = paramString.substring(paramString.length() - 1);
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        if (String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)).equals(paramString))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isGrayTroop grayTroopUinList size = ");
        paramString.append(this.jdField_a_of_type_JavaUtilList.size());
        paramString.append(", isGrayTroop = ");
        paramString.append(bool1);
        QLog.d("TroopGameCardConfig", 2, paramString.toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("mGrayTroopUinList isNull:  ");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.d("TroopGameCardConfig", 2, paramString.toString());
    }
    return false;
  }
  
  public String b()
  {
    return this.b;
  }
  
  void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig
 * JD-Core Version:    0.7.0.1
 */