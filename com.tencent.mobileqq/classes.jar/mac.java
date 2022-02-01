import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.VideoController;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenWatchTogether.3;
import com.tencent.av.smallscreen.SmallScreenWatchTogether.4;
import com.tencent.av.smallscreen.SmallScreenWatchTogether.5;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.view.SmallScreenGLContentView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class mac
  extends lzk
  implements mym
{
  private static int jdField_a_of_type_Int = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bkzi jdField_a_of_type_Bkzi;
  private SmallScreenGLContentView jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView;
  private mzi jdField_a_of_type_Mzi;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  
  public mac(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SmallScreenWatchTogether";
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "SmallScreenWatchTogether construtc");
    }
    this.i = 2131559813;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297915);
    this.k = paramContext.getResources().getDimensionPixelSize(2131297914);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private bkzi a(boolean paramBoolean)
  {
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), null);
    if (paramBoolean) {
      localbkzi.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getResources().getString(2131695736), 1);
    }
    localbkzi.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getResources().getString(2131695735), 3);
    localbkzi.d(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getResources().getString(2131695734));
    localbkzi.a(new mae(this, paramBoolean));
    Window localWindow = localbkzi.getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (localWindow != null)
    {
      localLayoutParams = localWindow.getAttributes();
      if (localLayoutParams != null) {
        if (Build.VERSION.SDK_INT < 26) {
          break label126;
        }
      }
    }
    label126:
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localWindow.setAttributes(localLayoutParams);
      return localbkzi;
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Mzi != null) && (this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView != null)) {
      return;
    }
    this.jdField_a_of_type_Mzi = new mzi(true);
    this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView = ((SmallScreenGLContentView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131363132));
    this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView.setVideoRender(this.jdField_a_of_type_Mzi);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {}
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 4, "bindToVideoSink");
      }
      g();
      this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView.onResume();
      localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.c())) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (localWatchTogetherMediaPlayCtrl == null);
    localWatchTogetherMediaPlayCtrl.a(this.jdField_a_of_type_Mzi);
    localWatchTogetherMediaPlayCtrl.a(this);
    localWatchTogetherMediaPlayCtrl.e();
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 4, "unBindToVideoSink");
      }
      this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView.onPause();
      b();
      localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    } while (localWatchTogetherMediaPlayCtrl == null);
    localWatchTogetherMediaPlayCtrl.a("unBindToVideoSink", this.jdField_a_of_type_Mzi);
    localWatchTogetherMediaPlayCtrl.b(this);
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "onDestroy");
    }
    this.jdField_b_of_type_Boolean = true;
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    b();
    super.a();
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, lzl paramlzl)
  {
    super.a(paramContext, paramLayoutInflater, paramlzl);
    paramContext = (SmallScreenRelativeLayout)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131377120);
    int i = AIOUtils.dp2px(22.0F, paramContext.getResources());
    paramContext.setIntercetRect(this.j - i, 0, this.j, i, new mad(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131380936));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131380969));
  }
  
  public void a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "showActionSheet");
    }
    paramView = VideoController.a().a();
    if (paramView == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Bkzi == null) {
        this.jdField_a_of_type_Bkzi = a(paramView.i());
      }
      this.jdField_a_of_type_Bkzi.show();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showActionSheet fail");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenWatchTogether.3(this));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      h();
    }
    for (;;)
    {
      super.a(paramBoolean, jdField_a_of_type_Int);
      return;
      i();
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenWatchTogether.5(this));
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bkzi != null)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      this.jdField_a_of_type_Bkzi.cancel();
      this.jdField_a_of_type_Bkzi = null;
    }
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenWatchTogether.4(this));
  }
  
  public void setImmersiveStatus(boolean paramBoolean) {}
  
  public void setOrientationParams(int paramInt) {}
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void setWatchTogetherMediaPlayerProxy(myj parammyj) {}
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */