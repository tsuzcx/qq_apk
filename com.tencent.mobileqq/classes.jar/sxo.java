import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.activity.QZoneEntryReporterInLeba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.StatisticCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

public class sxo
  implements Runnable
{
  public sxo(Leba paramLeba, LebaViewItem paramLebaViewItem) {}
  
  public void run()
  {
    if ((Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba) != null) && (Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba).getVisibility() == 0)) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a(null, -1, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem);
    ThreadRegulator.a().a(4);
    ThreadRegulator.a().a(4, 2000L);
    Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba, true);
    Object localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getManager(9);
    if (localObject != null)
    {
      if ((((QZoneManagerImp)localObject).a(1) > 0) || (((QZoneManagerImp)localObject).a(2) > 0)) {
        break label241;
      }
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).c = "1";
      ((QZoneClickReport.ReportInfo)localObject).d = "0";
      ((QZoneClickReport.ReportInfo)localObject).b = 4;
      ((QZoneClickReport.ReportInfo)localObject).k = "3";
      ((QZoneClickReport.ReportInfo)localObject).l = "mainEntrance";
      ((QZoneClickReport.ReportInfo)localObject).m = "activefeed";
      QZoneClickReport.report(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("source_type", "3");
      ((HashMap)localObject).put("source_from", "mainEntrance");
      ((HashMap)localObject).put("source_to", "activefeed");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
      QZoneEntryReporterInLeba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a);
    }
    for (;;)
    {
      LinkReport.reportClickQZoneEntry(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.c());
      return;
      label241:
      if (((QZoneManagerImp)localObject).a(1) > 0) {
        QZoneEntryReporterInLeba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a, ((QZoneManagerImp)localObject).a(1));
      } else if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba) != null) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba).a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxo
 * JD-Core Version:    0.7.0.1
 */