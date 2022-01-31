import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class mui
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private mui(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter));
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter));
            }
          } while (ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter) != 2);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter.a();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter.c();
          return;
        } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter));
        }
      } while ((ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramContext == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mui
 * JD-Core Version:    0.7.0.1
 */