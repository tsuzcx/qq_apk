import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.widget.QQToast;

public class nqc
  extends Handler
{
  public nqc(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramMessage.what)
    {
    case -1: 
    default: 
      return;
    case 0: 
      this.a.a.jdField_a_of_type_Byte = 0;
      LebaSearchPluginManagerActivity.a(this.a);
      localStringBuilder.append(this.a.getString(2131695383));
      localStringBuilder.append(this.a.getString(2131695381));
      localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.a.jdField_a_of_type_Byte = 1;
    LebaSearchPluginManagerActivity.a(this.a);
    localStringBuilder.append(this.a.getString(2131695383));
    localStringBuilder.append(this.a.getString(2131695377));
    localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
    QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */