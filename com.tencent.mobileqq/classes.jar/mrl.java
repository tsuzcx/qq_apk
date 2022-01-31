import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;

class mrl
  implements Runnable
{
  mrl(mrk parammrk) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.a(ReadInJoySearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localEntityManager.b((ReadInJoySearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.a.a.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.a.a.sendMessage((Message)localObject);
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrl
 * JD-Core Version:    0.7.0.1
 */