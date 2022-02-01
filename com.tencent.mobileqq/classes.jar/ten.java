import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ten
  implements rgw
{
  public ten(BridgeModule paramBridgeModule, long paramLong, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    if (!paramList.isEmpty()) {
      BridgeModule.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_Long, paramList, this.jdField_a_of_type_JavaLangString, 0, "");
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(BridgeModule.TAG, 2, "getUploadingVideoList,ugcVideoList.isEmpty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ten
 * JD-Core Version:    0.7.0.1
 */