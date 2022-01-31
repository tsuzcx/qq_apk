import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class luv
  implements Runnable
{
  public luv(ReadInJoyUserInfoRepository paramReadInJoyUserInfoRepository, int paramInt) {}
  
  public void run()
  {
    Object localObject = ReadInJoyUserInfoRepository.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository).a(ReadInJoyUserInfo.class, true, null, null, null, null, null, String.valueOf(this.jdField_a_of_type_Int));
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)((Iterator)localObject).next();
        QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadReadInJoyUserInfoFromDB, userInfo = ", localReadInJoyUserInfo, Character.valueOf('\n') });
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a("", localReadInJoyUserInfo.md5Uin, localReadInJoyUserInfo, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     luv
 * JD-Core Version:    0.7.0.1
 */