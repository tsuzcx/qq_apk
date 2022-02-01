package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReportConditionParam;

public class SPEventReportSwitch
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = -1L;
  private static SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static HashMap<Integer, SPEventReportSwitch.SPEventReportCondition> jdField_a_of_type_JavaUtilHashMap;
  private static int b = -2;
  private static int c = -1;
  private static int d = -2;
  private static int e = -1;
  private static int f = -2;
  private static int g = -1;
  private static int h = -2;
  private static int i = -1;
  private static int j = 30;
  private static int k = -1;
  private static int l = 30;
  private static int m = -1;
  private static int n;
  
  public SPEventReportSwitch()
  {
    jdField_a_of_type_JavaUtilHashMap = (HashMap)RIJSPUtils.a(ReadInJoyUtils.a(), "idle_high_frequency_report_condition", true);
  }
  
  public static int a()
  {
    int i2 = e;
    int i1 = i2;
    if (i2 == -1)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        e = f;
      } else {
        e = localSharedPreferences.getInt("kd_tab_click_push_algo_id", f);
      }
      i1 = e;
    }
    return i1;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == a()) {
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public static void a(List<oidb_cmd0x80a.ReportConditionParam> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1;
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    int i3 = 0;
    while (i3 < paramList.size())
    {
      oidb_cmd0x80a.ReportConditionParam localReportConditionParam = (oidb_cmd0x80a.ReportConditionParam)paramList.get(i3);
      int i2 = i1;
      if (localReportConditionParam.uint32_event_id.has())
      {
        Object localObject2 = (SPEventReportSwitch.SPEventReportCondition)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localReportConditionParam.uint32_event_id.get()));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new SPEventReportSwitch.SPEventReportCondition();
          SPEventReportSwitch.SPEventReportCondition.access$102((SPEventReportSwitch.SPEventReportCondition)localObject1, new ArrayList());
          jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localReportConditionParam.uint32_event_id.get()), localObject1);
          i1 = 1;
        }
        boolean bool;
        if ((localReportConditionParam.uint32_report_next_time.has()) && (localReportConditionParam.uint32_report_next_time.get() != 0)) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool != SPEventReportSwitch.SPEventReportCondition.access$000((SPEventReportSwitch.SPEventReportCondition)localObject1))
        {
          SPEventReportSwitch.SPEventReportCondition.access$002((SPEventReportSwitch.SPEventReportCondition)localObject1, bool);
          i1 = 1;
        }
        i2 = i1;
        if (localReportConditionParam.report_time_seg.has())
        {
          localObject2 = localReportConditionParam.report_time_seg.get();
          TreeSet localTreeSet = new TreeSet();
          i2 = 0;
          while (i2 < ((List)localObject2).size())
          {
            localTreeSet.add(Integer.valueOf(((Long)((List)localObject2).get(i2)).intValue()));
            i2 += 1;
          }
          i2 = 0;
          while (i2 < SPEventReportSwitch.SPEventReportCondition.access$100((SPEventReportSwitch.SPEventReportCondition)localObject1).size())
          {
            if (((TreeSet)SPEventReportSwitch.SPEventReportCondition.access$100((SPEventReportSwitch.SPEventReportCondition)localObject1).get(i2)).equals(localTreeSet))
            {
              i4 = 1;
              break label316;
            }
            i2 += 1;
          }
          int i4 = 0;
          label316:
          i2 = i1;
          if (i4 == 0)
          {
            SPEventReportSwitch.SPEventReportCondition.access$100((SPEventReportSwitch.SPEventReportCondition)localObject1).add(localTreeSet);
            i2 = 1;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("update eventID : ");
        ((StringBuilder)localObject2).append(localReportConditionParam.uint32_event_id.get());
        ((StringBuilder)localObject2).append(", condition : ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject2).toString());
      }
      i3 += 1;
      i1 = i2;
    }
    if (i1 != 0) {
      RIJSPUtils.a("idle_high_frequency_report_condition", jdField_a_of_type_JavaUtilHashMap, true);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickGapInSeconds");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_gap_in_seconds", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      b = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    int i1 = m;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 == -1)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        m = n;
      } else {
        m = localSharedPreferences.getInt("kd_user_idle_report", n);
      }
      if (m == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (i1 == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(int paramInt)
  {
    if (b(paramInt)) {
      return true;
    }
    Object localObject = jdField_a_of_type_JavaUtilHashMap;
    int i1 = 0;
    if (localObject != null)
    {
      if (((HashMap)localObject).isEmpty()) {
        return false;
      }
      SPEventReportSwitch.SPEventReportCondition localSPEventReportCondition = (SPEventReportSwitch.SPEventReportCondition)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      boolean bool1;
      if ((localSPEventReportCondition != null) && ((SPEventReportSwitch.SPEventReportCondition.access$000(localSPEventReportCondition)) || (SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition) != null)))
      {
        boolean bool2 = SPEventReportSwitch.SPEventReportCondition.access$000(localSPEventReportCondition);
        int i2 = Calendar.getInstance().get(11) * 3600 + Calendar.getInstance().get(12) * 60 + Calendar.getInstance().get(13);
        bool1 = bool2;
        if (SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition) != null)
        {
          bool1 = bool2;
          if (!SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).isEmpty())
          {
            paramInt = i1;
            for (;;)
            {
              bool1 = bool2;
              if (paramInt >= SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).size()) {
                break;
              }
              TreeSet localTreeSet = (TreeSet)SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).get(paramInt);
              localObject = (Integer)localTreeSet.floor(Integer.valueOf(i2));
              if (localObject != null)
              {
                Integer localInteger;
                do
                {
                  localTreeSet.remove(localObject);
                  localInteger = (Integer)localTreeSet.floor(Integer.valueOf(i2));
                  localObject = localInteger;
                } while (localInteger != null);
                if (localTreeSet.size() == 1)
                {
                  localTreeSet.clear();
                  SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).remove(localTreeSet);
                }
                bool2 = true;
              }
              paramInt += 1;
            }
          }
        }
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        RIJSPUtils.a("idle_high_frequency_report_condition", jdField_a_of_type_JavaUtilHashMap, true);
      }
      return bool1;
    }
    return false;
  }
  
  public static int b()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == -1)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        i = j;
      } else {
        i = localSharedPreferences.getInt("kd_fore_ground_gap_in_seconds", j);
      }
      i1 = i;
    }
    return i1;
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_count_limit", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      c = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  private static boolean b(int paramInt)
  {
    try
    {
      if ((Boolean)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Boolean.valueOf(true));
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int c()
  {
    int i2 = k;
    int i1 = i2;
    if (i2 == -1)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        k = l;
      } else {
        k = localSharedPreferences.getInt("kd_screen_switch_in_seconds", l);
      }
      i1 = k;
    }
    return i1;
  }
  
  public static void c(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_push_algo_id", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      e = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void d(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_forbid_report_time_in_seconds", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      g = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void e(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_fore_ground_gap_in_seconds", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      i = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void f(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_screen_switch_in_seconds", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      k = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void g(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_user_idle_report", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      m = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.SPEventReportSwitch
 * JD-Core Version:    0.7.0.1
 */