import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class put
  extends VafContext
{
  private static void a()
  {
    DrawableUtil.setDrawableHelper(new puu());
  }
  
  private void b()
  {
    LogUtil.setProteusLog(new pqc());
  }
  
  private void c() {}
  
  public void setContext(Context paramContext)
  {
    super.setContext(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f2 = alnq.a() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    Utils.init(paramContext.density / f1, paramContext.widthPixels);
    a();
    b();
    c();
    sgi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     put
 * JD-Core Version:    0.7.0.1
 */