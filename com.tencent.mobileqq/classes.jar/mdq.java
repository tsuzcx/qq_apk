import android.content.Context;
import android.os.Handler;
import com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class mdq
{
  public void a(long paramLong, Context paramContext, String paramString, mdt parammdt)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new mdr(this, paramContext, paramLong, parammdt));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      bcod.a().post(new GuideHelper.LottieDrawableHelper.2(this, parammdt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdq
 * JD-Core Version:    0.7.0.1
 */