package cooperation.qqreader.helper;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import cooperation.qqreader.utils.Log;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public final class LoadingAnimationManager
{
  private static LoadingAnimationManager jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = new LottieDrawable();
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private boolean jdField_a_of_type_Boolean = false;
  
  public static LoadingAnimationManager a()
  {
    if (jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager == null) {
        jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager = new LoadingAnimationManager();
      }
      return jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      Message localMessage = Message.obtain(null, new LoadingAnimationManager.3(this));
      localMessage.what = 30002;
      ThreadManager.getUIHandler().sendMessageDelayed(localMessage, paramLong);
      return;
    }
    b();
  }
  
  private void b()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {
      return;
    }
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    localImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
  }
  
  @UiThread
  public void a()
  {
    ThreadManager.getUIHandler().removeMessages(30002);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
      localImageView.setVisibility(8);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  @UiThread
  public void a(@NonNull Context paramContext, @NonNull ImageView paramImageView)
  {
    a(paramContext, paramImageView, 0L);
  }
  
  @UiThread
  public void a(@NonNull Context paramContext, @NonNull ImageView paramImageView, long paramLong)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localImageView != paramImageView) && (localImageView != null)) {
      a();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition() == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new LoadingAnimationManager.1(this, paramLong);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
      try
      {
        ThreadManager.getSubThreadHandler().post(new LoadingAnimationManager.2(this, paramContext));
        return;
      }
      catch (Exception paramContext)
      {
        Log.b("LoadingAnimationManager", "loadLottieAnimation  fail :", paramContext);
        return;
      }
    }
    a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.LoadingAnimationManager
 * JD-Core Version:    0.7.0.1
 */