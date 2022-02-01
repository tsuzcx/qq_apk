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
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  public LottieViewModel(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  protected LottieLoader a(Context paramContext)
  {
    paramContext = new DIYLottieLoader(paramContext);
    paramContext.setMemoryCacheSize((int)(MemoryManager.a() / 2L));
    return paramContext;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView)) {
      return;
    }
    if ("content".equals(paramString1))
    {
      this.jdField_a_of_type_JavaLangString = paramString2;
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
      this.jdField_a_of_type_Boolean = bool1;
      return;
    }
    if ("auto_play".equals(paramString1))
    {
      bool1 = bool2;
      if (Integer.parseInt(paramString2) == 1) {
        bool1 = true;
      }
      this.b = bool1;
    }
  }
  
  protected void b()
  {
    super.b();
    if (!(this.jdField_a_of_type_AndroidViewView instanceof DiniFlyAnimationView)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasWidgetLottieLottieLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasWidgetLottieLottieLoader = a(this.jdField_a_of_type_AndroidViewView.getContext());
    }
    ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).loop(this.jdField_a_of_type_Boolean);
    ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" lottie url = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("JsonInflateViewModel", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasWidgetLottieLottieLoader;
    DiniFlyAnimationView localDiniFlyAnimationView = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView;
    String str = this.jdField_a_of_type_JavaLangString;
    LottieLoader localLottieLoader = this.jdField_a_of_type_ComTencentMobileqqVasWidgetLottieLottieLoader;
    ((LottieLoader)localObject).fromNetworkWithCacheBitmap(localDiniFlyAnimationView, str, LottieLoader.makeApolloZipPath(str), this.b);
  }
  
  public void c()
  {
    super.c();
    LottieLoader localLottieLoader = this.jdField_a_of_type_ComTencentMobileqqVasWidgetLottieLottieLoader;
    if (localLottieLoader != null) {
      localLottieLoader.destroy();
    }
  }
  
  public void e()
  {
    super.e();
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).pauseAnimation();
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.LottieViewModel
 * JD-Core Version:    0.7.0.1
 */