import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class teq
  implements rgw
{
  public teq(BridgeModule paramBridgeModule, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    paa localpaa = null;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    do
    {
      localObject = localpaa;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (UgcVideo)localIterator.next();
    } while (!TextUtils.equals(((UgcVideo)localObject).seqId, this.jdField_a_of_type_JavaLangString));
    if (localObject != null)
    {
      paramList.remove(localObject);
      localpaa = rab.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, ((UgcVideo)localObject).publicType).a(rab.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UgcVideo)localObject).a());
      if (((UgcVideo)localObject).reprintDisable) {}
      for (int i = 0;; i = 1)
      {
        ocd.a("0X800AC64", localpaa.a("reprint_flag", Integer.valueOf(i)).a("compress_time", Long.valueOf(((UgcVideo)localObject).compressTime)).a("upload_time", Long.valueOf(((UgcVideo)localObject).uploadTotalCostTime)).a("wait_time", Long.valueOf(((UgcVideo)localObject).userWaitingTotalCostTime)).a());
        rgo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((UgcVideo)localObject);
        BridgeModule.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
    }
    BridgeModule.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     teq
 * JD-Core Version:    0.7.0.1
 */