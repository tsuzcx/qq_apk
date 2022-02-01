package com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.OnDragListener;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingBaseWrapper;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.ThemeChangedReceiver.Listener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;

public class FloatingWatchTogetherWrapper
  extends FloatingBaseWrapper
  implements FloatingScreenContainer.OnDragListener, IVideoOuterStatusListener, ThemeChangedReceiver.Listener
{
  public static final String CLASS_NAME = FloatingWatchTogetherWrapper.class.getName();
  public static final int WAIT_ACTIVITY_ANIM_END_MILLIS = 500;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private IVideoInnerStatusListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener;
  
  public FloatingWatchTogetherWrapper(Context paramContext)
  {
    super(paramContext);
    this.mFloatingContainer.setOnDragListener(this);
  }
  
  private void f()
  {
    View localView = this.mRootLayout.findViewById(2131374874);
    localView.setContentDescription("一起看悬浮窗");
    if (ThemeImageWrapper.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#4D000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
      }
    }
    else
    {
      paramFloatingScreenParams = new FloatingWatchTogetherWrapper.2(this, paramView, localFloatingScreenParams);
      ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
      return 0;
    }
    return 2;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingWatchTogetherWrapper" });
    }
    f();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.mFloatingCloseBtn.setContentDescription("关闭一起看悬浮窗");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mRootLayout.findViewById(2131374871));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704659));
    a(new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
    f();
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", -2147483648);
    int j = localSharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j) });
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    FloatingWatchTogetherWrapper.3 local3 = new FloatingWatchTogetherWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public void d()
  {
    if (this.mStatusReceiver == null)
    {
      this.mStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
      this.mStatusReceiver.a(2, new FloatingWatchTogetherWrapper.1(this));
    }
  }
  
  public void e()
  {
    if (this.mFloatingContainer != null)
    {
      boolean bool = this.mFloatingContainer.b();
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
      int i = this.mFloatingContainer.a();
      int j = this.mFloatingContainer.b();
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374871) {
      if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoInnerStatusListener.notifyVideoStart();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public void onOrientationChange(boolean paramBoolean) {}
  
  public void onSetVideoCover(Bitmap paramBitmap) {}
  
  public void onSetVideoCover(Drawable paramDrawable) {}
  
  public void onVideoBuffering() {}
  
  public void onVideoComplete(boolean paramBoolean) {}
  
  public void onVideoError(int paramInt) {}
  
  public void onVideoProgressUpdate(int paramInt) {}
  
  public void onVideoSize(int paramInt1, int paramInt2) {}
  
  public void onVideoStart(int paramInt)
  {
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper
 * JD-Core Version:    0.7.0.1
 */