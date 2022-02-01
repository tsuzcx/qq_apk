import android.content.Context;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class mol
{
  public void a(long paramLong, Context paramContext, String paramString, moo parammoo)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new mom(this, paramContext, paramLong, parammoo));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      bjda.a().post(new GuideHelper.LottieDrawableHelper.2(this, parammoo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mol
 * JD-Core Version:    0.7.0.1
 */