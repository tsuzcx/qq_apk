package com.tencent.mobileqq.kandian.biz.pts;

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
import com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.LogUtils.LogHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusDrawableHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusMethod;
import com.tencent.mobileqq.kandian.glue.pts.RIJProteusDtFactory;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInjoyContext
  extends VafContext
{
  private static void a()
  {
    ProteusConfig localProteusConfig = new ProteusConfig.ProteusConfigBuilder().withDrawableHelper(new RIJProteusDrawableHelper()).withCustomMethodInterface(new RIJProteusMethod()).withLogger(new LogUtils.LogHelper()).withDtReporter(RIJProteusDtFactory.a()).build();
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
    ((IOfflineUtils)QRoute.api(IOfflineUtils.class)).init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext
 * JD-Core Version:    0.7.0.1
 */