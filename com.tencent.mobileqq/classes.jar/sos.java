import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class sos
  implements quv
{
  public sos(BridgeModule paramBridgeModule, long paramLong, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    if (!paramList.isEmpty()) {
      BridgeModule.access$800(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_Long, paramList, this.jdField_a_of_type_JavaLangString, 0, "");
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(BridgeModule.TAG, 2, "getUploadingVideoList,ugcVideoList.isEmpty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sos
 * JD-Core Version:    0.7.0.1
 */