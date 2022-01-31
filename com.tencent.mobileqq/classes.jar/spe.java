import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public class spe
  extends ampn
{
  public spe(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      BridgeModule.access$1100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, paramSosoLbsInfo, this.jdField_a_of_type_JavaLangString);
      return;
    }
    BridgeModule.access$1200(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_JavaLangString, "errorCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spe
 * JD-Core Version:    0.7.0.1
 */