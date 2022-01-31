package com.tencent.mobileqq.richmedia.capture.util;

import ahpj;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport.BoyItem;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DanceGameReporter
{
  private static DanceGameReporter jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDanceGameReporter;
  private int jdField_a_of_type_Int = -1;
  
  public static DanceGameReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDanceGameReporter == null) {
      jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDanceGameReporter = new DanceGameReporter();
    }
    return jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDanceGameReporter;
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_manufacture", Build.MANUFACTURER);
      localHashMap.put("param_model", Build.MODEL);
      localHashMap.put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_cost", String.valueOf(paramLong));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "dg_recognize_cost", true, paramLong, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGRecognizeCost, cost[%s]", new Object[] { Long.valueOf(paramLong) }));
      }
    }
  }
  
  public void a(BoyDataReport paramBoyDataReport)
  {
    HashMap localHashMap = new HashMap();
    paramBoyDataReport = paramBoyDataReport.a.iterator();
    Object localObject2;
    while (paramBoyDataReport.hasNext())
    {
      localObject1 = (BoyDataReport.BoyItem)paramBoyDataReport.next();
      if (localHashMap.containsKey(((BoyDataReport.BoyItem)localObject1).a))
      {
        localObject2 = (ahpj)localHashMap.get(((BoyDataReport.BoyItem)localObject1).a);
        ((ahpj)localObject2).b();
        if (((BoyDataReport.BoyItem)localObject1).b >= 1) {
          ((ahpj)localObject2).a();
        }
      }
      else
      {
        localObject2 = ((BoyDataReport.BoyItem)localObject1).a;
        if (((BoyDataReport.BoyItem)localObject1).b >= 1) {}
        for (int i = 1;; i = 0)
        {
          localObject2 = new ahpj(this, (String)localObject2, 1, i);
          localHashMap.put(((BoyDataReport.BoyItem)localObject1).a, localObject2);
          break;
        }
      }
    }
    paramBoyDataReport = new HashMap();
    paramBoyDataReport.put("param_manufacture", Build.MANUFACTURER);
    paramBoyDataReport.put("param_model", Build.MODEL);
    paramBoyDataReport.put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
    Object localObject1 = localHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramBoyDataReport.put(localObject2, String.valueOf(((ahpj)localHashMap.get(localObject2)).a()));
    }
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "dg_action_match", true, 0L, 0L, paramBoyDataReport, "");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).getInt("entranceReportAlready", 0);
    }
    Object localObject;
    int i;
    int j;
    StatisticCollector localStatisticCollector;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      localObject = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("entranceReportAlready", this.jdField_a_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
      i = QmcfManager.a().a().a();
      j = QmcfManager.a().b();
      localObject = new HashMap();
      ((HashMap)localObject).put("param_hasPoseEntrance", String.valueOf(paramBoolean1));
      ((HashMap)localObject).put("param_hasFaceEntrance", String.valueOf(paramBoolean2));
      ((HashMap)localObject).put("param_entanceState", String.valueOf(i));
      ((HashMap)localObject).put("param_frameType", String.valueOf(j));
      ((HashMap)localObject).put("param_manufacture", Build.MANUFACTURER);
      ((HashMap)localObject).put("param_model", Build.MODEL);
      ((HashMap)localObject).put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
      localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label283;
      }
    }
    label283:
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(null, "dg_entrance_state", bool, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGEntranceState, hasPose[%s], hasFace[%s], state[%s], frameTpye[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter
 * JD-Core Version:    0.7.0.1
 */