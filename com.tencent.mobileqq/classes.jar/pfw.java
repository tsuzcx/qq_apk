import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;

public class pfw
  extends pgd
{
  public pfw(NewGifDrawable paramNewGifDrawable1, NewGifDrawable paramNewGifDrawable2, int paramInt)
  {
    super(paramNewGifDrawable2);
  }
  
  public void doWork()
  {
    synchronized (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.mLock4Bmp)
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.seekToTime(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer);
      if (!this.b.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) {
        this.b.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfw
 * JD-Core Version:    0.7.0.1
 */