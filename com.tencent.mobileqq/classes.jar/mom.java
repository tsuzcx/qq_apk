import android.content.Context;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class mom
{
  public void a(long paramLong, Context paramContext, String paramString, mop parammop)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new mon(this, paramContext, paramLong, parammop));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      bdst.a().post(new GuideHelper.LottieDrawableHelper.2(this, parammop));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mom
 * JD-Core Version:    0.7.0.1
 */