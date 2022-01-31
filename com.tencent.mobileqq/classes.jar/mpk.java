import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class mpk
  implements Runnable
{
  public mpk(KandianAppInPush paramKandianAppInPush, Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo) {}
  
  public void run()
  {
    if ((KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush) != null) && (!KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush).a()))
    {
      if ((KandianAppInPush.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush) != null) && (KandianAppInPush.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush).msgSeq != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.msgSeq))
      {
        KandianAppInPush.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
        QLog.d("KandianAppInPush", 2, "app in push is showing, lazy show !");
      }
      return;
    }
    try
    {
      KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (((!ReadInJoyHelper.f()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.styleType == 1)) || ((localBaseActivity.isInMultiWindow()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.styleType == 2)) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.styleType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.isArticleAppInPush()) && (ReadInJoyHelper.g()))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo.styleType = 0;
      }
      KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush, KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush, localBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo, KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush)));
      KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush).a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush.a("0X8008458", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.bid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo$NotifyInfo);
      QLog.d("KandianAppInPush", 2, "app in push ready to show! info : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo + ", clz : " + localBaseActivity.getClass().getSimpleName());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      KandianAppInPush.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush, null);
      QLog.e("KandianAppInPush", 2, "app in push show happen error  : " + localException + ", info : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpk
 * JD-Core Version:    0.7.0.1
 */