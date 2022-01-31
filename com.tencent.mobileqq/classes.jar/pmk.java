import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.UICallbackTask;

public class pmk
  implements Runnable
{
  public pmk(UICallbackTask paramUICallbackTask, ImageKey paramImageKey, float paramFloat) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.listener.onImageProgress(UICallbackTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey), this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmk
 * JD-Core Version:    0.7.0.1
 */