import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.widget.QQToast;

public class nfr
  extends Handler
{
  public nfr(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
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
      localStringBuilder.append(this.a.getString(2131696460));
      localStringBuilder.append(this.a.getString(2131696458));
      localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.a.jdField_a_of_type_Byte = 1;
    LebaSearchPluginManagerActivity.a(this.a);
    localStringBuilder.append(this.a.getString(2131696460));
    localStringBuilder.append(this.a.getString(2131696454));
    localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
    QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nfr
 * JD-Core Version:    0.7.0.1
 */