import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.io.File;

public class oex
  implements OnCompositionLoadedListener
{
  public oex(ReadInJoyLottieDrawable.4 param4) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      oet.a().put(this.a.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramLottieComposition);
      oet.a(this.a.this$0).post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oex
 * JD-Core Version:    0.7.0.1
 */