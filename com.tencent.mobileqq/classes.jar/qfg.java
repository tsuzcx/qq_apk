import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class qfg
  extends VafContext
{
  private static void a()
  {
    DrawableUtil.setDrawableHelper(new qfh());
  }
  
  private void b()
  {
    LogUtil.setProteusLog(new qal());
  }
  
  private void c()
  {
    CustomMethodsRegister.registerCustomMethod(new qap());
  }
  
  private void d() {}
  
  public void setContext(Context paramContext)
  {
    super.setContext(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f2 = anxh.a() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramContext.density / f1;
    int i = paramContext.widthPixels;
    if (Aladdin.getConfig(353).getIntegerFromString("enable_use_min_screen_size", 1) == 1) {
      i = Math.min(paramContext.widthPixels, paramContext.heightPixels);
    }
    Utils.init(f1, i);
    a();
    b();
    d();
    svr.a();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfg
 * JD-Core Version:    0.7.0.1
 */