import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;

public class tcy
  implements Runnable
{
  public tcy(Leba paramLeba, long paramLong) {}
  
  public void run()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getManager(11);
    if ((localGameCenterManagerImp != null) && ((localGameCenterManagerImp.a(601L)) || ((this.jdField_a_of_type_Long > 0L) && (localGameCenterManagerImp.a(this.jdField_a_of_type_Long))))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcy
 * JD-Core Version:    0.7.0.1
 */