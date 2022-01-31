import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.StreamDecodeGifTask;

public class pmf
  implements Runnable
{
  private ImageKey jdField_a_of_type_ComTencentComponentMediaImageImageKey = null;
  String jdField_a_of_type_JavaLangString = null;
  String b = null;
  
  public pmf(StreamDecodeGifTask paramStreamDecodeGifTask, ImageKey paramImageKey, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey = paramImageKey;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask.isCanceled()) {
        StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey, this.jdField_a_of_type_JavaLangString, this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { "DecodeStreamTask error : " + localThrowable.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmf
 * JD-Core Version:    0.7.0.1
 */