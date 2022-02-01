package com.tencent.mobileqq.troop.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopRankConfig
{
  private static TroopRankConfig c;
  public int a = BaseApplication.getContext().getResources().getColor(2131167001);
  protected SparseArray<TroopRankConfig.TroopRankItem> b = new SparseArray();
  
  public static TroopRankConfig a()
  {
    try
    {
      if (c == null) {
        c = b();
      }
      TroopRankConfig localTroopRankConfig = c;
      return localTroopRankConfig;
    }
    finally {}
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setBackgroundDrawable(BizTroopUtil.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +34 -> 40
    //   9: new 74	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 77
    //   20: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: aload_0
    //   26: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 83
    //   32: iconst_2
    //   33: aload_1
    //   34: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: invokestatic 94	com/tencent/mobileqq/troop/data/TroopRankConfig:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopRankConfig;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +83 -> 129
    //   49: aload_1
    //   50: putstatic 43	com/tencent/mobileqq/troop/data/TroopRankConfig:c	Lcom/tencent/mobileqq/troop/data/TroopRankConfig;
    //   53: invokestatic 26	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: ldc 96
    //   58: iconst_0
    //   59: invokevirtual 100	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: invokeinterface 106 1 0
    //   67: ldc 108
    //   69: aload_0
    //   70: invokeinterface 114 3 0
    //   75: invokeinterface 117 1 0
    //   80: pop
    //   81: ldc 2
    //   83: monitorexit
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_0
    //   87: goto +47 -> 134
    //   90: astore_1
    //   91: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +35 -> 129
    //   97: new 74	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: ldc 119
    //   108: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_2
    //   113: aload_0
    //   114: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 83
    //   120: iconst_2
    //   121: aload_2
    //   122: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_1
    //   126: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: ldc 2
    //   131: monitorexit
    //   132: iconst_0
    //   133: ireturn
    //   134: ldc 2
    //   136: monitorexit
    //   137: aload_0
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   16	34	1	localObject	Object
    //   90	36	1	localException	Exception
    //   104	18	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	40	86	finally
    //   40	45	86	finally
    //   49	81	86	finally
    //   91	129	86	finally
    //   3	40	90	java/lang/Exception
    //   40	45	90	java/lang/Exception
    //   49	81	90	java/lang/Exception
  }
  
  protected static TroopRankConfig b()
  {
    TroopRankConfig.TroopRankItem localTroopRankItem1;
    try
    {
      TroopRankConfig localTroopRankConfig = b(BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).getString("rank_map_key", ""));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "getConfigFromLocal exp:", localException);
      }
      localTroopRankItem1 = null;
    }
    Object localObject = localTroopRankItem1;
    if (localTroopRankItem1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "getConfigFromLocal exp, localConfig==null");
      }
      localObject = new TroopRankConfig();
      localTroopRankItem1 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem1.a = 300;
      localTroopRankItem1.c = HardCodeUtil.a(2131912986);
      localTroopRankItem1.b = Color.parseColor("#F4BF20");
      TroopRankConfig.TroopRankItem localTroopRankItem2 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem2.a = 301;
      localTroopRankItem2.c = HardCodeUtil.a(2131912975);
      localTroopRankItem2.b = Color.parseColor("#6CD9A3");
      TroopRankConfig.TroopRankItem localTroopRankItem3 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem3.a = 302;
      localTroopRankItem3.c = "";
      localTroopRankItem3.b = Color.parseColor("#B395EF");
      TroopRankConfig.TroopRankItem localTroopRankItem4 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem4.a = 303;
      localTroopRankItem4.c = HardCodeUtil.a(2131912976);
      localTroopRankItem4.b = Color.parseColor("#F4BF20");
      TroopRankConfig.TroopRankItem localTroopRankItem5 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem5.a = 304;
      localTroopRankItem5.c = HardCodeUtil.a(2131912983);
      localTroopRankItem5.b = Color.parseColor("#6CD9A3");
      TroopRankConfig.TroopRankItem localTroopRankItem6 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem6.a = 305;
      localTroopRankItem6.c = HardCodeUtil.a(2131912978);
      localTroopRankItem6.b = Color.parseColor("#FF988A");
      TroopRankConfig.TroopRankItem localTroopRankItem7 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem7.a = 306;
      localTroopRankItem7.c = HardCodeUtil.a(2131912985);
      localTroopRankItem7.b = Color.parseColor("#F4BF20");
      TroopRankConfig.TroopRankItem localTroopRankItem8 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem8.a = 307;
      localTroopRankItem8.c = HardCodeUtil.a(2131912980);
      localTroopRankItem8.b = Color.parseColor("#72CCE6");
      TroopRankConfig.TroopRankItem localTroopRankItem9 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem9.a = 308;
      localTroopRankItem9.c = HardCodeUtil.a(2131912984);
      localTroopRankItem9.b = Color.parseColor("#FF988A");
      TroopRankConfig.TroopRankItem localTroopRankItem10 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem10.a = 315;
      localTroopRankItem10.c = "";
      localTroopRankItem10.b = Color.parseColor("#8EBDF9");
      TroopRankConfig.TroopRankItem localTroopRankItem11 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem11.a = 311;
      localTroopRankItem11.c = HardCodeUtil.a(2131912979);
      localTroopRankItem11.b = Color.parseColor("#F25D5D");
      TroopRankConfig.TroopRankItem localTroopRankItem12 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem12.a = 312;
      localTroopRankItem12.c = HardCodeUtil.a(2131912981);
      localTroopRankItem12.b = Color.parseColor("#F25D5D");
      TroopRankConfig.TroopRankItem localTroopRankItem13 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem13.a = 313;
      localTroopRankItem13.c = HardCodeUtil.a(2131912988);
      localTroopRankItem13.b = Color.parseColor("#FFA5BD");
      TroopRankConfig.TroopRankItem localTroopRankItem14 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem14.a = 314;
      localTroopRankItem14.c = HardCodeUtil.a(2131912977);
      localTroopRankItem14.b = Color.parseColor("#FFA5BD");
      TroopRankConfig.TroopRankItem localTroopRankItem15 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem15.a = 332;
      localTroopRankItem15.c = HardCodeUtil.a(2131912982);
      localTroopRankItem15.b = Color.parseColor("#F4C020");
      TroopRankConfig.TroopRankItem localTroopRankItem16 = new TroopRankConfig.TroopRankItem();
      localTroopRankItem16.a = 333;
      localTroopRankItem16.c = HardCodeUtil.a(2131912987);
      localTroopRankItem16.b = Color.parseColor("#F4C020");
      ((TroopRankConfig)localObject).b.put(300, localTroopRankItem1);
      ((TroopRankConfig)localObject).b.put(301, localTroopRankItem2);
      ((TroopRankConfig)localObject).b.put(302, localTroopRankItem3);
      ((TroopRankConfig)localObject).b.put(303, localTroopRankItem4);
      ((TroopRankConfig)localObject).b.put(304, localTroopRankItem5);
      ((TroopRankConfig)localObject).b.put(305, localTroopRankItem6);
      ((TroopRankConfig)localObject).b.put(306, localTroopRankItem7);
      ((TroopRankConfig)localObject).b.put(307, localTroopRankItem8);
      ((TroopRankConfig)localObject).b.put(308, localTroopRankItem9);
      ((TroopRankConfig)localObject).b.put(311, localTroopRankItem11);
      ((TroopRankConfig)localObject).b.put(312, localTroopRankItem12);
      ((TroopRankConfig)localObject).b.put(313, localTroopRankItem13);
      ((TroopRankConfig)localObject).b.put(314, localTroopRankItem14);
      ((TroopRankConfig)localObject).b.put(315, localTroopRankItem10);
      ((TroopRankConfig)localObject).b.put(332, localTroopRankItem15);
      ((TroopRankConfig)localObject).b.put(333, localTroopRankItem16);
    }
    return localObject;
  }
  
  protected static TroopRankConfig b(String paramString)
  {
    try
    {
      TroopRankConfig localTroopRankConfig = new TroopRankConfig();
      paramString = new JSONObject(paramString).getJSONArray("rankMap");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        TroopRankConfig.TroopRankItem localTroopRankItem = new TroopRankConfig.TroopRankItem();
        localTroopRankItem.a = localJSONObject.getInt("id");
        localTroopRankItem.c = localJSONObject.getString("rank");
        localTroopRankItem.b = Color.parseColor(localJSONObject.getString("bg"));
        localTroopRankConfig.b.put(localTroopRankItem.a, localTroopRankItem);
        i += 1;
      }
      return localTroopRankConfig;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "parseConfig exp:", paramString);
      }
    }
    return null;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    ReportController.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report,  opType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", opName=");
      localStringBuilder.append(paramString2);
      QLog.d("TroopRankConfig", 2, localStringBuilder.toString());
    }
  }
  
  public TroopRankConfig.TroopRankItem a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((TroopRankConfig.TroopRankItem)this.b.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((TroopRankConfig.TroopRankItem)this.b.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (TroopRankConfig.TroopRankItem)this.b.get(300);
    }
    if (paramBoolean3) {
      return (TroopRankConfig.TroopRankItem)this.b.get(301);
    }
    return (TroopRankConfig.TroopRankItem)this.b.get(paramInt - 10000);
  }
  
  public TroopRankConfig.TroopRankItem a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if (paramTroopMemberInfo != null)
    {
      if (paramTroopInfo == null) {
        return null;
      }
      boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      boolean bool1;
      if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i = paramTroopMemberInfo.level;
      TroopRankConfig.TroopRankItem localTroopRankItem1;
      TroopRankConfig.TroopRankItem localTroopRankItem2;
      if ((i < 10000) && (i > 0))
      {
        localTroopRankItem1 = (TroopRankConfig.TroopRankItem)this.b.get(i);
        if ((i == 302) && (localTroopRankItem1 != null))
        {
          paramTroopInfo = new TroopRankConfig.TroopRankItem();
          paramTroopInfo.a = localTroopRankItem1.a;
          paramTroopInfo.c = paramTroopMemberInfo.mUniqueTitle;
          paramTroopInfo.b = localTroopRankItem1.b;
          return a(paramTroopInfo, bool2, bool1, false);
        }
        if (i == 315)
        {
          localTroopRankItem2 = new TroopRankConfig.TroopRankItem();
          if (localTroopRankItem1 != null) {
            localTroopRankItem2.b = localTroopRankItem1.b;
          } else {
            localTroopRankItem2.b = Color.parseColor("#8EBDF9");
          }
          localTroopRankItem2.c = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
          localTroopRankItem2.a = i;
          return a(localTroopRankItem2, bool2, bool1, false);
        }
        return a(localTroopRankItem1, bool2, bool1, true);
      }
      if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
      {
        paramTroopInfo = (TroopRankConfig.TroopRankItem)this.b.get(302);
        if (paramTroopInfo != null)
        {
          localTroopRankItem1 = new TroopRankConfig.TroopRankItem();
          localTroopRankItem1.a = paramTroopInfo.a;
          localTroopRankItem1.c = paramTroopMemberInfo.mUniqueTitle;
          localTroopRankItem1.b = paramTroopInfo.b;
          return a(localTroopRankItem1, bool2, bool1, false);
        }
        return null;
      }
      if (bool2) {
        return (TroopRankConfig.TroopRankItem)this.b.get(300);
      }
      if (bool1) {
        return (TroopRankConfig.TroopRankItem)this.b.get(301);
      }
      if (i == 10315)
      {
        localTroopRankItem1 = (TroopRankConfig.TroopRankItem)this.b.get(315);
        localTroopRankItem2 = new TroopRankConfig.TroopRankItem();
        if (localTroopRankItem1 != null) {
          localTroopRankItem2.b = localTroopRankItem1.b;
        } else {
          localTroopRankItem2.b = Color.parseColor("#8EBDF9");
        }
        localTroopRankItem2.c = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localTroopRankItem2.a = 315;
        return localTroopRankItem2;
      }
      return (TroopRankConfig.TroopRankItem)this.b.get(i - 10000);
    }
    return null;
  }
  
  protected TroopRankConfig.TroopRankItem a(TroopRankConfig.TroopRankItem paramTroopRankItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramTroopRankItem != null) && (paramTroopRankItem.a != 300))
    {
      if (paramTroopRankItem.a == 301) {
        return paramTroopRankItem;
      }
      TroopRankConfig.TroopRankItem localTroopRankItem;
      if ((paramBoolean1) && (this.b.get(300) != null))
      {
        if (paramBoolean3)
        {
          localTroopRankItem = new TroopRankConfig.TroopRankItem();
          localTroopRankItem.a = paramTroopRankItem.a;
          localTroopRankItem.c = paramTroopRankItem.c;
          localTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.b.get(300)).b;
          return localTroopRankItem;
        }
        paramTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.b.get(300)).b;
        return paramTroopRankItem;
      }
      if ((paramBoolean2) && (this.b.get(301) != null))
      {
        if (paramBoolean3)
        {
          localTroopRankItem = new TroopRankConfig.TroopRankItem();
          localTroopRankItem.a = paramTroopRankItem.a;
          localTroopRankItem.c = paramTroopRankItem.c;
          localTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.b.get(301)).b;
          return localTroopRankItem;
        }
        paramTroopRankItem.b = ((TroopRankConfig.TroopRankItem)this.b.get(301)).b;
      }
    }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setHasNewRankRedDot, troopUin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", memberUin=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", hasRedDot=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopRankConfig", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_rank_flag");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "setHasNewRankRedDot exp:", paramString1);
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_rank_flag");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasNewRankRedDot: troopUin=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", memberUin=");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", ret=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("TroopRankConfig", 2, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopRankConfig
 * JD-Core Version:    0.7.0.1
 */