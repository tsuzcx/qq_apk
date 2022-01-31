import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.UICallbackTask;

public class pfv
  implements Runnable
{
  public pfv(UICallbackTask paramUICallbackTask, ImageKey paramImageKey) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.listener.onImageFailed(UICallbackTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey), this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfv
 * JD-Core Version:    0.7.0.1
 */