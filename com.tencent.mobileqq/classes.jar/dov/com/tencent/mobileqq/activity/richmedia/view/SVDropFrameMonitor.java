package dov.com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import dov.com.tencent.mfsdk.collector.DropFrameMonitor;
import dov.com.tencent.mfsdk.collector.DropFrameMonitor.MonitorItem;
import java.util.Arrays;
import java.util.HashMap;

@TargetApi(18)
public class SVDropFrameMonitor
  extends DropFrameMonitor
{
  private static SVDropFrameMonitor a;
  public boolean d;
  
  private SVDropFrameMonitor()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static SVDropFrameMonitor a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewSVDropFrameMonitor == null) {}
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewSVDropFrameMonitor == null) {
        jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewSVDropFrameMonitor = new SVDropFrameMonitor();
      }
      return jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewSVDropFrameMonitor;
    }
    finally {}
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    label253:
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          return;
        }
        if (this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null)
        {
          if (!paramBoolean)
          {
            l1 = a(this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.c - this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long);
            if ((this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_Long > 0L) && (l1 > a()))
            {
              long l2 = (this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.c - this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long) / this.jdField_b_of_type_Long;
              long l3 = this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_Long;
              paramString = new HashMap(10);
              paramString.put("dropCount", String.valueOf(l2 + 1L - l3));
              paramString.put("totalMs", String.valueOf(l1));
              paramString.put("scene", this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString);
              paramString.put("dropTimes", Arrays.toString(this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_ArrayOfLong));
              paramString.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
              if (jdField_a_of_type_Long <= 0L) {
                break label253;
              }
              l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
              paramString.put("intervalAfterSyncMsg", String.valueOf(l1));
              UnifiedMonitor.a().addEvent(9, null, 0, 0, paramString);
            }
          }
          this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem);
          this.jdField_a_of_type_DovComTencentMfsdkCollectorDropFrameMonitor$MonitorItem = null;
        }
        else
        {
          this.c = false;
          continue;
        }
        long l1 = -1L;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.SVDropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */