import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mqb
  implements Runnable
{
  public mqb(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySearchReadInJoyNewSearchActivity.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    ReadInJoySearchHistoryEntity localReadInJoySearchHistoryEntity;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localReadInJoySearchHistoryEntity = (ReadInJoySearchHistoryEntity)localIterator.next();
        if (localReadInJoySearchHistoryEntity.keyWord.equals(this.jdField_a_of_type_JavaLangString)) {
          localEntityManager.b(localReadInJoySearchHistoryEntity);
        }
      }
    }
    for (;;)
    {
      if (localReadInJoySearchHistoryEntity != null) {
        localList.remove(localReadInJoySearchHistoryEntity);
      }
      if (localList.size() == 20)
      {
        localEntityManager.b((Entity)localList.get(localList.size() - 1));
        localList.remove(localList.size() - 1);
      }
      for (;;)
      {
        localReadInJoySearchHistoryEntity = new ReadInJoySearchHistoryEntity();
        localReadInJoySearchHistoryEntity.keyWord = this.jdField_a_of_type_JavaLangString;
        localReadInJoySearchHistoryEntity.timestamp = System.currentTimeMillis();
        localEntityManager.a(localReadInJoySearchHistoryEntity);
        localEntityManager.a();
        return;
        new ArrayList();
      }
      localReadInJoySearchHistoryEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqb
 * JD-Core Version:    0.7.0.1
 */