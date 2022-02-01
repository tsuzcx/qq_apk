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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.listener.IDragListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.ThemeChangedReceiver.Listener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;

public class FloatingWatchTogetherWrapper
  extends FloatingBaseProxyWrapper
  implements IDragListener, IVideoOuterStatusListener, ThemeChangedReceiver.Listener
{
  public static final String CLASS_NAME = "com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper";
  public static final int WAIT_ACTIVITY_ANIM_END_MILLIS = 500;
  private ImageView a;
  private IVideoInnerStatusListener b;
  
  public FloatingWatchTogetherWrapper(Context paramContext)
  {
    super(paramContext);
    a(this);
  }
  
  private void d()
  {
    View localView = d(2131442576);
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
    if (paramFloatingScreenParams == null) {
      if (m() != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
      } else {
        return 2;
      }
    }
    paramFloatingScreenParams = new FloatingWatchTogetherWrapper.2(this, paramView, localFloatingScreenParams);
    ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
    return 0;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.b = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingWatchTogetherWrapper" });
    }
    d();
  }
  
  public void a(int paramInt)
  {
    FloatingWatchTogetherWrapper.3 local3 = new FloatingWatchTogetherWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    a("关闭一起看悬浮窗");
    this.a = ((ImageView)d(2131442573));
    this.a.setContentDescription(HardCodeUtil.a(2131902642));
    a(this, new View[] { this.a });
    a(false, new View[] { this.a });
    d();
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
  
  public void c()
  {
    if (!n())
    {
      boolean bool = o();
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
      int i = q();
      int j = r();
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
  
  public void j()
  {
    a(2, new FloatingWatchTogetherWrapper.1(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442573)
    {
      IVideoInnerStatusListener localIVideoInnerStatusListener = this.b;
      if (localIVideoInnerStatusListener != null) {
        localIVideoInnerStatusListener.notifyVideoStart();
      }
    }
    else
    {
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    a(false, new View[] { this.a });
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper
 * JD-Core Version:    0.7.0.1
 */