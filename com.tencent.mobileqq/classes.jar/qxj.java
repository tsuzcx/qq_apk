import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.Proteus;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ProteusConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ProteusConfig.ProteusConfigBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.FontSettingManager;

public class qxj
  extends VafContext
{
  private static void a()
  {
    ProteusConfig localProteusConfig = new ProteusConfig.ProteusConfigBuilder().withDrawableHelper(new qsm()).withCustomMethodInterface(new qsq()).withLogger(new qsi()).withDtReporter(new ptk()).build();
    Proteus.getInstance().init(localProteusConfig);
  }
  
  private void b() {}
  
  public void setContext(Context paramContext)
  {
    super.setContext(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramContext.density / f1;
    int i = paramContext.widthPixels;
    if (Aladdin.getConfig(353).getIntegerFromString("enable_use_min_screen_size", 1) == 1) {
      i = Math.min(paramContext.widthPixels, paramContext.heightPixels);
    }
    a();
    Utils.init(f1, i);
    b();
    tmz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxj
 * JD-Core Version:    0.7.0.1
 */