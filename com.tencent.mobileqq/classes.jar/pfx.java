import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;

public class pfx
  extends pgd
{
  public pfx(NewGifDrawable paramNewGifDrawable1, NewGifDrawable paramNewGifDrawable2, int paramInt)
  {
    super(paramNewGifDrawable2);
  }
  
  public void doWork()
  {
    synchronized (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.mLock4Bmp)
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.seekToFrame(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer);
      if (!this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) {
        this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfx
 * JD-Core Version:    0.7.0.1
 */