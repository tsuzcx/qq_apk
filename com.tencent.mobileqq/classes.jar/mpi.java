import android.content.Context;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class mpi
{
  public void a(long paramLong, Context paramContext, String paramString, mpl parammpl)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new mpj(this, paramContext, paramLong, parammpl));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      bkdz.a().post(new GuideHelper.LottieDrawableHelper.2(this, parammpl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpi
 * JD-Core Version:    0.7.0.1
 */