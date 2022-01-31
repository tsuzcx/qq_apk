import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mki
  implements Runnable
{
  public mki(ReadinjoyTabFrame paramReadinjoyTabFrame, long paramLong) {}
  
  public void run()
  {
    PublicAccountReportUtils.a((QQAppInterface)ReadInJoyUtils.a(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.jdField_a_of_type_Long / 1000L), "", "", ReadInJoyUtils.d(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.4tab", 2, "report ReadinjoyTabFrame use time: " + Long.toString(this.jdField_a_of_type_Long / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mki
 * JD-Core Version:    0.7.0.1
 */