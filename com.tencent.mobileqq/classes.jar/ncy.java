import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.data.LebaPluginInfo;

public class ncy
  extends Handler
{
  public ncy(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
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
      localStringBuilder.append(this.a.getString(2131696285));
      localStringBuilder.append(this.a.getString(2131696283));
      localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      bcpw.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.a.jdField_a_of_type_Byte = 1;
    LebaSearchPluginManagerActivity.a(this.a);
    localStringBuilder.append(this.a.getString(2131696285));
    localStringBuilder.append(this.a.getString(2131696279));
    localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
    bcpw.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ncy
 * JD-Core Version:    0.7.0.1
 */