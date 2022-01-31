import android.content.Context;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class mrg
{
  public void a(long paramLong, Context paramContext, String paramString, mrj parammrj)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new mrh(this, paramContext, paramLong, parammrj));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      bfrq.a().post(new GuideHelper.LottieDrawableHelper.2(this, parammrj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mrg
 * JD-Core Version:    0.7.0.1
 */