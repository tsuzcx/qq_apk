import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import java.util.HashMap;

public class kls
  implements Runnable
{
  public kls(BidDownloader paramBidDownloader) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader.a(BidDownloader.jdField_a_of_type_AndroidContentContext, this.a.c, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kls
 * JD-Core Version:    0.7.0.1
 */