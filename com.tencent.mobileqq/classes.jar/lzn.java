import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;

public class lzn
  implements UserOperationModule.Ox978RespCallBack
{
  public lzn(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend, AppRuntime paramAppRuntime) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      ReadInJoyHelper.d(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.getContext(), ComponentHeaderTopicRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend));
      ThreadManager.post(new lzo(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzn
 * JD-Core Version:    0.7.0.1
 */