import android.view.View;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import java.lang.ref.WeakReference;

public class qfu
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public WeakReference b;
  
  public qfu(DevSingleStructMsgProcessor paramDevSingleStructMsgProcessor, View paramView, MessageForDeviceSingleStruct.DeviceSingleStructItemCallback paramDeviceSingleStructItemCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceSingleStructItemCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public MessageForDeviceSingleStruct.DeviceSingleStructItemCallback a()
  {
    return (MessageForDeviceSingleStruct.DeviceSingleStructItemCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qfu
 * JD-Core Version:    0.7.0.1
 */