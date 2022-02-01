package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
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
  private static FloatViewSkin jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin;
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new FloatViewSkin.2(this);
  SimpleUIObserver jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver = new FloatViewSkin.1(this);
  private QuickUpdateListener jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQuickUpdateListener = new FloatViewSkin.3(this);
  private volatile int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean c = false;
  
  public static FloatViewSkin a()
  {
    if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin == null)
      {
        jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin = new FloatViewSkin();
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver);
      }
      return jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin;
    }
    finally {}
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (SkinDrawable.IVasSkinChangeCallback localIVasSkinChangeCallback = null;; localIVasSkinChangeCallback = (SkinDrawable.IVasSkinChangeCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (localIVasSkinChangeCallback != null) {
        localIVasSkinChangeCallback.l();
      }
      return;
    }
  }
  
  public void a()
  {
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_b_of_type_Int = paramInt;
      a(true);
      MusicPlayerCallback.sInstance.download(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQuickUpdateListener, false);
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = 0;
      a(false);
      a(null);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.5(this));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, String paramString, int paramInt)
  {
    if ((paramView == null) || (SimpleUIUtil.a())) {}
    do
    {
      return;
      a();
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_b_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Boolean) {
        b(paramView);
      }
    } while (!QLog.isColorLevel());
    QLog.i("FloatViewSkin", 2, "enter uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    GlobalImageCache.a.evictAll();
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString);
      a(false);
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidViewView);
      return;
      a(paramString);
      a(true);
      this.c = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      c();
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int > 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(new FloatViewSkin.4(this));
    }
    this.jdField_a_of_type_AndroidViewView = null;
    if (QLog.isColorLevel()) {
      QLog.i("FloatViewSkin", 2, "leave uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int);
    }
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatViewSkin", 2, "setMusicBarSkin uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean);
    }
    QLog.i("FloatViewSkin", 1, "setMusicBarSkin mIsShowSkin:" + this.c + "  mIsUserSkin:" + this.jdField_a_of_type_Boolean);
    if ((paramView == null) || (!this.c)) {
      return;
    }
    if (SimpleUIUtil.a()) {
      a(false);
    }
    for (;;)
    {
      paramView = paramView.getRootView();
      a(paramView, 2131372046, 2130844916, "qq_aio_listentogether_lyrics_music_point@3x.png");
      b(paramView, 2131372015, 2130844910, "qq_aio_listentogether_lyrics_music_bg@3x.png");
      b(paramView, 2131372054, 2130844915, "qq_aio_listentogether_lyrics_music_dot@3x.png");
      b(paramView, 2131364832, 2130844914, "qq_aio_listentogether_lyrics_music_close@3x.png");
      return;
      a(true);
    }
  }
  
  public boolean m_()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin
 * JD-Core Version:    0.7.0.1
 */