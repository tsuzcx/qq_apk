import android.content.Context;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class mpo
{
  public void a(long paramLong, Context paramContext, String paramString, mpr parammpr)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new mpp(this, paramContext, paramLong, parammpr));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      bjum.a().post(new GuideHelper.LottieDrawableHelper.2(this, parammpr));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpo
 * JD-Core Version:    0.7.0.1
 */