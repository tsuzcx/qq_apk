package com.tencent.mobileqq.troop.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopRankConfig
{
  private static TroopRankConfig a;
  public int a;
  protected SparseArray a;
  
  private TroopRankConfig()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131493739);
  }
  
  public static TroopRankConfig a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankConfig == null) {
        jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankConfig = b();
      }
      TroopRankConfig localTroopRankConfig = jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankConfig;
      return localTroopRankConfig;
    }
    finally {}
  }
  
  protected static TroopRankConfig a(String paramString)
  {
    try
    {
      TroopRankConfig localTroopRankConfig = new TroopRankConfig();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localTroopRankConfig;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        TroopRankConfig.TroopRankItem localTroopRankItem = new TroopRankConfig.TroopRankItem();
        localTroopRankItem.jdField_a_of_type_Int = paramString.getInt("id");
        localTroopRankItem.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localTroopRankItem.b = Color.parseColor(paramString.getString("bg"));
        localTroopRankConfig.jdField_a_of_type_AndroidUtilSparseArray.put(localTroopRankItem.jdField_a_of_type_Int, localTroopRankItem);
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "parseConfig exp:", paramString);
      }
      paramString = null;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setBackgroundDrawable(TroopUtils.a(BaseApplication.getContext().getResources(), paramInt));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ReportController.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "report,  opType=" + paramString1 + ", opName=" + paramString2);
    }
  }
  
  public static boolean a(String paramString)
  {
    bool2 = false;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "refreshConfig:" + paramString);
      }
      TroopRankConfig localTroopRankConfig = a(paramString);
      bool1 = bool2;
      if (localTroopRankConfig != null)
      {
        jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankConfig = localTroopRankConfig;
        BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).edit().putString("rank_map_key", paramString).commit();
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("TroopRankConfig", 2, "TroopRankTitleConfig.refreshConfig exp, jsonStr=" + paramString, localException);
          bool1 = bool2;
        }
      }
    }
    finally {}
    return bool1;
  }
  
  protected static TroopRankConfig b()
  {
    try
    {
      Object localObject1 = a(BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).getString("rank_map_key", ""));
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRankConfig", 2, "getConfigFromLocal exp, localConfig==null");
        }
        localObject3 = new TroopRankConfig();
        localObject1 = new TroopRankConfig.TroopRankItem();
        ((TroopRankConfig.TroopRankItem)localObject1).jdField_a_of_type_Int = 300;
        ((TroopRankConfig.TroopRankItem)localObject1).jdField_a_of_type_JavaLangString = "群主";
        ((TroopRankConfig.TroopRankItem)localObject1).b = Color.parseColor("#F4BF20");
        TroopRankConfig.TroopRankItem localTroopRankItem1 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem1.jdField_a_of_type_Int = 301;
        localTroopRankItem1.jdField_a_of_type_JavaLangString = "管理员";
        localTroopRankItem1.b = Color.parseColor("#6CD9A3");
        TroopRankConfig.TroopRankItem localTroopRankItem2 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem2.jdField_a_of_type_Int = 302;
        localTroopRankItem2.jdField_a_of_type_JavaLangString = "";
        localTroopRankItem2.b = Color.parseColor("#B395EF");
        TroopRankConfig.TroopRankItem localTroopRankItem3 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem3.jdField_a_of_type_Int = 303;
        localTroopRankItem3.jdField_a_of_type_JavaLangString = "江湖传说";
        localTroopRankItem3.b = Color.parseColor("#F4BF20");
        TroopRankConfig.TroopRankItem localTroopRankItem4 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem4.jdField_a_of_type_Int = 304;
        localTroopRankItem4.jdField_a_of_type_JavaLangString = "大演说家";
        localTroopRankItem4.b = Color.parseColor("#6CD9A3");
        TroopRankConfig.TroopRankItem localTroopRankItem5 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem5.jdField_a_of_type_Int = 305;
        localTroopRankItem5.jdField_a_of_type_JavaLangString = "相声演员";
        localTroopRankItem5.b = Color.parseColor("#FF988A");
        TroopRankConfig.TroopRankItem localTroopRankItem6 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem6.jdField_a_of_type_Int = 306;
        localTroopRankItem6.jdField_a_of_type_JavaLangString = "翰林学士";
        localTroopRankItem6.b = Color.parseColor("#F4BF20");
        TroopRankConfig.TroopRankItem localTroopRankItem7 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem7.jdField_a_of_type_Int = 307;
        localTroopRankItem7.jdField_a_of_type_JavaLangString = "三好学生";
        localTroopRankItem7.b = Color.parseColor("#72CCE6");
        TroopRankConfig.TroopRankItem localTroopRankItem8 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem8.jdField_a_of_type_Int = 308;
        localTroopRankItem8.jdField_a_of_type_JavaLangString = "一介布衣";
        localTroopRankItem8.b = Color.parseColor("#FF988A");
        TroopRankConfig.TroopRankItem localTroopRankItem9 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem9.jdField_a_of_type_Int = 315;
        localTroopRankItem9.jdField_a_of_type_JavaLangString = "";
        localTroopRankItem9.b = Color.parseColor("#8EBDF9");
        TroopRankConfig.TroopRankItem localTroopRankItem10 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem10.jdField_a_of_type_Int = 311;
        localTroopRankItem10.jdField_a_of_type_JavaLangString = "大土豪";
        localTroopRankItem10.b = Color.parseColor("#F25D5D");
        TroopRankConfig.TroopRankItem localTroopRankItem11 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem11.jdField_a_of_type_Int = 312;
        localTroopRankItem11.jdField_a_of_type_JavaLangString = "小土豪";
        localTroopRankItem11.b = Color.parseColor("#F25D5D");
        TroopRankConfig.TroopRankItem localTroopRankItem12 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem12.jdField_a_of_type_Int = 313;
        localTroopRankItem12.jdField_a_of_type_JavaLangString = "爱神助力";
        localTroopRankItem12.b = Color.parseColor("#FFA5BD");
        TroopRankConfig.TroopRankItem localTroopRankItem13 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem13.jdField_a_of_type_Int = 314;
        localTroopRankItem13.jdField_a_of_type_JavaLangString = "大众情人";
        localTroopRankItem13.b = Color.parseColor("#FFA5BD");
        TroopRankConfig.TroopRankItem localTroopRankItem14 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem14.jdField_a_of_type_Int = 332;
        localTroopRankItem14.jdField_a_of_type_JavaLangString = "班主任";
        localTroopRankItem14.b = Color.parseColor("#F4C020");
        TroopRankConfig.TroopRankItem localTroopRankItem15 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem15.jdField_a_of_type_Int = 333;
        localTroopRankItem15.jdField_a_of_type_JavaLangString = "老师";
        localTroopRankItem15.b = Color.parseColor("#F4C020");
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localTroopRankItem1);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localTroopRankItem2);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localTroopRankItem3);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localTroopRankItem4);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localTroopRankItem5);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localTroopRankItem6);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localTroopRankItem7);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localTroopRankItem8);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localTroopRankItem10);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localTroopRankItem11);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localTroopRankItem12);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localTroopRankItem13);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localTroopRankItem9);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localTroopRankItem14);
        ((TroopRankConfig)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localTroopRankItem15);
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopRankConfig", 2, "getConfigFromLocal exp:", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public TroopRankConfig.TroopRankItem a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  public TroopRankConfig.TroopRankItem a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    TroopRankConfig.TroopRankItem localTroopRankItem1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localTroopRankItem1 = (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localTroopRankItem1 == null)) {
        break;
      }
      paramTroopInfo = new TroopRankConfig.TroopRankItem();
      paramTroopInfo.jdField_a_of_type_Int = localTroopRankItem1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localTroopRankItem1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    TroopRankConfig.TroopRankItem localTroopRankItem2;
    if (i == 315)
    {
      localTroopRankItem2 = new TroopRankConfig.TroopRankItem();
      if (localTroopRankItem1 != null) {}
      for (localTroopRankItem2.b = localTroopRankItem1.b;; localTroopRankItem2.b = Color.parseColor("#8EBDF9"))
      {
        localTroopRankItem2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localTroopRankItem2.jdField_a_of_type_Int = i;
        return a(localTroopRankItem2, bool2, bool1, false);
      }
    }
    return a(localTroopRankItem1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localTroopRankItem1 = new TroopRankConfig.TroopRankItem();
        localTroopRankItem1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localTroopRankItem1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localTroopRankItem1.b = paramTroopInfo.b;
        return a(localTroopRankItem1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localTroopRankItem1 = (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localTroopRankItem2 = new TroopRankConfig.TroopRankItem();
      if (localTroopRankItem1 != null) {}
      for (localTroopRankItem2.b = localTroopRankItem1.b;; localTroopRankItem2.b = Color.parseColor("#8EBDF9"))
      {
        localTroopRankItem2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localTroopRankItem2.jdField_a_of_type_Int = 315;
        return localTroopRankItem2;
      }
    }
    return (TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  protected TroopRankConfig.TroopRankItem a(TroopRankConfig.TroopRankItem paramTroopRankItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramTroopRankItem == null) || (paramTroopRankItem.jdField_a_of_type_Int == 300) || (paramTroopRankItem.jdField_a_of_type_Int == 301)) {}
    TroopRankConfig.TroopRankItem localTroopRankItem;
    do
    {
      return paramTroopRankItem;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localTroopRankItem = new TroopRankConfig.TroopRankItem();
          localTroopRankItem.jdField_a_of_type_Int = paramTroopRankItem.jdField_a_of_type_Int;
          localTroopRankItem.jdField_a_of_type_JavaLangString = paramTroopRankItem.jdField_a_of_type_JavaLangString;
          localTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localTroopRankItem;
        }
        paramTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return paramTroopRankItem;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localTroopRankItem = new TroopRankConfig.TroopRankItem();
      localTroopRankItem.jdField_a_of_type_Int = paramTroopRankItem.jdField_a_of_type_Int;
      localTroopRankItem.jdField_a_of_type_JavaLangString = paramTroopRankItem.jdField_a_of_type_JavaLangString;
      localTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localTroopRankItem;
    }
    paramTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return paramTroopRankItem;
  }
  
  public TroopRankConfig.TroopRankItem a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return a(300, false, true, false);
    }
    if (paramBoolean2) {
      return a(301, false, false, true);
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "setHasNewRankRedDot, troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", hasRedDot=" + paramBoolean);
    }
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("troop_rank_cfg", 4).edit().putBoolean("new_rank_flag" + paramString1 + "_" + paramString2, paramBoolean).commit();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopRankConfig", 2, "setHasNewRankRedDot exp:", paramString1);
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("troop_rank_cfg", 4).getBoolean("new_rank_flag" + paramString1 + "_" + paramString2, false);
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "hasNewRankRedDot: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", ret=" + bool);
      }
      return bool;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "hasNewRankRedDot exp:", paramString1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopRankConfig
 * JD-Core Version:    0.7.0.1
 */