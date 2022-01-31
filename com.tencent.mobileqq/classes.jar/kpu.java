import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.widget.QQToast;

public class kpu
  extends Handler
{
  public kpu(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
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
      localStringBuilder.append(this.a.getString(2131430539));
      localStringBuilder.append(this.a.getString(2131430536));
      localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
      QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.a.jdField_a_of_type_Byte = 1;
    LebaSearchPluginManagerActivity.a(this.a);
    localStringBuilder.append(this.a.getString(2131430539));
    localStringBuilder.append(this.a.getString(2131430537));
    localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
    QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpu
 * JD-Core Version:    0.7.0.1
 */