package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.os.Handler;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.simpleui.SimpleUIObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.quickupdate.MusicPlayerCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FloatViewSkin
  extends SkinDrawable
{
  private static FloatViewSkin g;
  SimpleUIObserver a = new FloatViewSkin.1(this);
  BusinessObserver b = new FloatViewSkin.2(this);
  private String h = "";
  private int i = 0;
  private View j;
  private boolean k = false;
  private volatile int l = 0;
  private QuickUpdateListener m = new FloatViewSkin.3(this);
  
  public static FloatViewSkin a()
  {
    if (g == null) {
      try
      {
        if (g == null)
        {
          g = new FloatViewSkin();
          ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(g.b);
          ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(g.a);
        }
      }
      finally {}
    }
    return g;
  }
  
  private void f()
  {
    SkinDrawable.IVasSkinChangeCallback localIVasSkinChangeCallback;
    if (this.f == null) {
      localIVasSkinChangeCallback = null;
    } else {
      localIVasSkinChangeCallback = (SkinDrawable.IVasSkinChangeCallback)this.f.get();
    }
    if (localIVasSkinChangeCallback != null) {
      localIVasSkinChangeCallback.n();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.l = paramInt;
      a(true);
      MusicPlayerCallback.sInstance.download(this.l, this.m, false);
      return;
    }
    this.l = 0;
    a(false);
    b(null);
    if (this.j != null) {
      ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.5(this));
    }
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  public void a(View paramView, String paramString, int paramInt)
  {
    if (paramView != null)
    {
      if (SimpleUIUtil.e()) {
        return;
      }
      c();
      this.j = paramView;
      this.i = paramInt;
      this.h = paramString;
      if (this.d) {
        b(paramView);
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("enter uin:");
        paramView.append(this.h);
        paramView.append("  type:");
        paramView.append(this.i);
        paramView.append(" mIsUserSkin:");
        paramView.append(this.d);
        QLog.i("FloatViewSkin", 2, paramView.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d != paramBoolean)
    {
      this.d = paramBoolean;
      f();
    }
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMusicBarSkin uin:");
      localStringBuilder.append(this.h);
      localStringBuilder.append("  type:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" mIsUserSkin:");
      localStringBuilder.append(this.d);
      QLog.i("FloatViewSkin", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMusicBarSkin mIsShowSkin:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("  mIsUserSkin:");
    localStringBuilder.append(this.d);
    QLog.i("FloatViewSkin", 1, localStringBuilder.toString());
    if (paramView != null)
    {
      if (!this.k) {
        return;
      }
      if (SimpleUIUtil.e()) {
        a(false);
      } else {
        a(true);
      }
      paramView = paramView.getRootView();
      a(paramView, 2131439065, 2130846226, "qq_aio_listentogether_lyrics_music_point@3x.png");
      b(paramView, 2131439036, 2130846220, "qq_aio_listentogether_lyrics_music_bg@3x.png");
      b(paramView, 2131439072, 2130846225, "qq_aio_listentogether_lyrics_music_dot@3x.png");
      b(paramView, 2131430825, 2130846224, "qq_aio_listentogether_lyrics_music_close@3x.png");
    }
  }
  
  public boolean b()
  {
    return this.l > 0;
  }
  
  public void c()
  {
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.d();
    }
  }
  
  public void d()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((View)localObject).post(new FloatViewSkin.4(this));
    }
    this.j = null;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leave uin:");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append("  type:");
      ((StringBuilder)localObject).append(this.i);
      QLog.i("FloatViewSkin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean du_()
  {
    return (this.d) && (this.e) && (this.l != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin
 * JD-Core Version:    0.7.0.1
 */