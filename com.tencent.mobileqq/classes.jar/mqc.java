import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mqc
  implements Runnable
{
  public mqc(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.a.a.obtainMessage(1);
    localMessage.obj = localList;
    this.a.a.sendMessage(localMessage);
    localEntityManager.a();
    if (localList != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewSearchActivity", 2, "lookupHistory size: " + localList.size());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyNewSearchActivity", 2, "history is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqc
 * JD-Core Version:    0.7.0.1
 */