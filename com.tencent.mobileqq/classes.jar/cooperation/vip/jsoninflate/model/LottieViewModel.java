package cooperation.vip.jsoninflate.model;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qqperf.monitor.memory.MemoryManager;

public class LottieViewModel
  extends ViewModel
{
  protected LottieLoader a;
  private boolean b = false;
  private boolean c = true;
  private String d;
  
  public LottieViewModel(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  protected LottieLoader a(Context paramContext)
  {
    paramContext = new DIYLottieLoader(paramContext);
    paramContext.setMemoryCacheSize((int)(MemoryManager.d() / 2L));
    return paramContext;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.h instanceof ImageView)) {
      return;
    }
    if ("content".equals(paramString1))
    {
      this.d = paramString2;
      return;
    }
    boolean bool3 = "loop".equals(paramString1);
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if (Integer.parseInt(paramString2) == 1) {
        bool1 = true;
      }
      this.b = bool1;
      return;
    }
    if ("auto_play".equals(paramString1))
    {
      bool1 = bool2;
      if (Integer.parseInt(paramString2) == 1) {
        bool1 = true;
      }
      this.c = bool1;
    }
  }
  
  public void ad_()
  {
    super.ad_();
    if ((this.h != null) && ((this.h instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.h).pauseAnimation();
    }
  }
  
  protected void b()
  {
    super.b();
    if (!(this.h instanceof DiniFlyAnimationView)) {
      return;
    }
    if (this.a == null) {
      this.a = a(this.h.getContext());
    }
    ((DiniFlyAnimationView)this.h).loop(this.b);
    ((DiniFlyAnimationView)this.h).setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" lottie url = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("JsonInflateViewModel", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    DiniFlyAnimationView localDiniFlyAnimationView = (DiniFlyAnimationView)this.h;
    String str = this.d;
    LottieLoader localLottieLoader = this.a;
    ((LottieLoader)localObject).fromNetworkWithCacheBitmap(localDiniFlyAnimationView, str, LottieLoader.makeApolloZipPath(str), this.c);
  }
  
  public void c()
  {
    super.c();
    LottieLoader localLottieLoader = this.a;
    if (localLottieLoader != null) {
      localLottieLoader.destroy();
    }
  }
  
  public void g()
  {
    super.g();
    if ((this.h != null) && ((this.h instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.h).playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.LottieViewModel
 * JD-Core Version:    0.7.0.1
 */