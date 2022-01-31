import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class sxe
  implements Runnable
{
  public sxe(Leba paramLeba, LebaViewItem paramLebaViewItem) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getEntityManagerFactory().createEntityManager();
    ResourcePluginInfo.persistOrReplace(localEntityManager, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a);
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxe
 * JD-Core Version:    0.7.0.1
 */