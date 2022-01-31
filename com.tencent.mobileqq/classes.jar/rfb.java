import com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class rfb
  implements Runnable
{
  public rfb(DoraemonAPIReporterMain paramDoraemonAPIReporterMain, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(APIQuotaEntity.class, false, "type=? and appid=?", new String[] { String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0)) {
      DoraemonAPIReporterMain.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporterMain, this.b, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rfb
 * JD-Core Version:    0.7.0.1
 */