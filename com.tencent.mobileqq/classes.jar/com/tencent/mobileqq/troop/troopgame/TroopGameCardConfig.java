package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopGameCardConfig
{
  private String a = "";
  private String b = "";
  private String c = "";
  private int d = 0;
  private List<Integer> e = new ArrayList();
  
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
      ((TroopGameCardConfig)localObject1).b(((JSONObject)localObject2).optString("resUrl", ""));
      ((TroopGameCardConfig)localObject1).c(((JSONObject)localObject2).optString("resMd5", ""));
      ((TroopGameCardConfig)localObject1).c = ((JSONObject)localObject2).optString("troopCardTipsContent", "");
      ((TroopGameCardConfig)localObject1).d = ((JSONObject)localObject2).getInt("numOfMsgToCheck");
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
      ((TroopGameCardConfig)localObject1).e = paramString;
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
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  void b(String paramString)
  {
    this.a = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  void c(String paramString)
  {
    this.b = paramString;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public boolean d(String paramString)
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
    if ((!bool3) && (this.e != null))
    {
      paramString = paramString.substring(paramString.length() - 1);
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= this.e.size()) {
          break;
        }
        if (String.valueOf(this.e.get(i)).equals(paramString))
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
        paramString.append(this.e.size());
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
      if (this.e != null) {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.d("TroopGameCardConfig", 2, paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig
 * JD-Core Version:    0.7.0.1
 */