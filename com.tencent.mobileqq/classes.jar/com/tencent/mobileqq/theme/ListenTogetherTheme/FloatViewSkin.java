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
    if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin == null)
        {
          jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin = new FloatViewSkin();
          ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
          ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeFloatViewSkin;
  }
  
  private void c()
  {
    SkinDrawable.IVasSkinChangeCallback localIVasSkinChangeCallback;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      localIVasSkinChangeCallback = null;
    } else {
      localIVasSkinChangeCallback = (SkinDrawable.IVasSkinChangeCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localIVasSkinChangeCallback != null) {
      localIVasSkinChangeCallback.l();
    }
  }
  
  public void a()
  {
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.c();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_b_of_type_Int = paramInt;
      a(true);
      MusicPlayerCallback.sInstance.download(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQuickUpdateListener, false);
      return;
    }
    this.jdField_b_of_type_Int = 0;
    a(false);
    a(null);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.5(this));
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, String paramString, int paramInt)
  {
    if (paramView != null)
    {
      if (SimpleUIUtil.a()) {
        return;
      }
      a();
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_b_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Boolean) {
        b(paramView);
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("enter uin:");
        paramView.append(this.jdField_b_of_type_JavaLangString);
        paramView.append("  type:");
        paramView.append(this.jdField_a_of_type_Int);
        paramView.append(" mIsUserSkin:");
        paramView.append(this.jdField_a_of_type_Boolean);
        QLog.i("FloatViewSkin", 2, paramView.toString());
      }
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).post(new FloatViewSkin.4(this));
    }
    this.jdField_a_of_type_AndroidViewView = null;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leave uin:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("  type:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.i("FloatViewSkin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMusicBarSkin uin:");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("  type:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" mIsUserSkin:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("FloatViewSkin", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMusicBarSkin mIsShowSkin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  mIsUserSkin:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.i("FloatViewSkin", 1, localStringBuilder.toString());
    if (paramView != null)
    {
      if (!this.c) {
        return;
      }
      if (SimpleUIUtil.a()) {
        a(false);
      } else {
        a(true);
      }
      paramView = paramView.getRootView();
      a(paramView, 2131371645, 2130844792, "qq_aio_listentogether_lyrics_music_point@3x.png");
      b(paramView, 2131371617, 2130844786, "qq_aio_listentogether_lyrics_music_bg@3x.png");
      b(paramView, 2131371651, 2130844791, "qq_aio_listentogether_lyrics_music_dot@3x.png");
      b(paramView, 2131364719, 2130844790, "qq_aio_listentogether_lyrics_music_close@3x.png");
    }
  }
  
  public boolean n_()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin
 * JD-Core Version:    0.7.0.1
 */