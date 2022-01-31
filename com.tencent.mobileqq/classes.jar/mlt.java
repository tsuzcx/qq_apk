import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.mobileqq.app.BaseActivity;

public class mlt
  implements AppInPushNotification.OnClickListener
{
  public mlt(KandianAppInPush paramKandianAppInPush, String paramString, int paramInt, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo) {}
  
  public void a()
  {
    ReadInJoyUtils.a(BaseActivity.sTopActivity, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush.a("0X8008459", this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo);
    KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlt
 * JD-Core Version:    0.7.0.1
 */