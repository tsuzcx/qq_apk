import android.text.TextUtils;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class jhc
  implements Runnable
{
  public jhc(VideoNodeReporter paramVideoNodeReporter, long paramLong) {}
  
  public void run()
  {
    Object localObject = VideoNodeReporter.a(this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter, this.jdField_a_of_type_Long);
    QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + this.jdField_a_of_type_Long + ", detail = " + (String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_Long != 0L)) {
      DcReportUtil.a(null, "dc02402", (String)localObject);
    }
    VideoNodeReporter.a(this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter, this.jdField_a_of_type_Long);
    localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      jhd localjhd = (jhd)((Iterator)localObject).next();
      if (this.jdField_a_of_type_Long == localjhd.jdField_a_of_type_Long) {
        ((Iterator)localObject).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhc
 * JD-Core Version:    0.7.0.1
 */