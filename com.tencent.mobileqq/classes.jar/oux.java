import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.io.File;

public class oux
  implements OnCompositionLoadedListener
{
  public oux(ReadInJoyLottieDrawable.4 param4) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      out.a().put(this.a.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramLottieComposition);
      out.a(this.a.this$0).post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oux
 * JD-Core Version:    0.7.0.1
 */