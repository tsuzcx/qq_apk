package dov.com.tencent.mobileqq.richmedia.capture.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DanceGameReporter
{
  private static DanceGameReporter jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilDanceGameReporter;
  private int jdField_a_of_type_Int = -1;
  
  public static DanceGameReporter a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilDanceGameReporter == null) {
      jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilDanceGameReporter = new DanceGameReporter();
    }
    return jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilDanceGameReporter;
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences("QmcfConfig", 0).getInt("entranceReportAlready", 0);
    }
    Object localObject;
    int i;
    int j;
    StatisticCollector localStatisticCollector;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("QmcfConfig", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("entranceReportAlready", this.jdField_a_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
      i = QmcfManager.a().a().a();
      j = QmcfManager.a().b();
      localObject = new HashMap();
      ((HashMap)localObject).put("param_hasPoseEntrance", String.valueOf(paramBoolean1));
      ((HashMap)localObject).put("param_hasFaceEntrance", String.valueOf(paramBoolean2));
      ((HashMap)localObject).put("param_entanceState", String.valueOf(j));
      ((HashMap)localObject).put("param_frameType", String.valueOf(i));
      ((HashMap)localObject).put("param_manufacture", Build.MANUFACTURER);
      ((HashMap)localObject).put("param_model", Build.MODEL);
      ((HashMap)localObject).put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
      localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(null, "dg_entrance_state", bool, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGEntranceState, hasPose[%s], hasFace[%s], state[%s], frameTpye[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(j), Integer.valueOf(i) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter
 * JD-Core Version:    0.7.0.1
 */