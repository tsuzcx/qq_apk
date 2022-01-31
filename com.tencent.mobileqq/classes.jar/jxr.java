import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;

public class jxr
  implements View.OnClickListener
{
  public jxr(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, Intent paramIntent, SessionInfo paramSessionInfo) {}
  
  public void onClick(View paramView)
  {
    QAVGroupConfig.Report.a(true);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.c(1);
    if (VideoUtils.a())
    {
      this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.sendBroadcast(new Intent("tencent.av.EXIT_QZONE_LIVE_REQ_ACTION"));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a("onClickAccept", this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentAvAppSessionInfo);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.jdField_a_of_type_Long), Integer.valueOf(3) });
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b("onClickAccept");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jxr
 * JD-Core Version:    0.7.0.1
 */