package com.tencent.mobileqq.listentogether.lyrics;

import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.qphone.base.util.QLog;

class LyricsController$3
  extends ListenTogetherObserver
{
  LyricsController$3(LyricsController paramLyricsController) {}
  
  protected void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 ^= true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLyricModuleSwitchChange, newUserClosed:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" mFloatParams:");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(paramInt, paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean != paramBoolean1))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean = paramBoolean1;
      LyricsController.a(this.a);
      if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!paramBoolean1) && (paramBoolean2))
      {
        localObject = this.a;
        LyricsController.a((LyricsController)localObject, ((LyricsController)localObject).jdField_b_of_type_JavaLangString);
        if (this.a.jdField_a_of_type_JavaLangBoolean != null)
        {
          localObject = this.a;
          LyricsController.a((LyricsController)localObject, ((LyricsController)localObject).jdField_b_of_type_JavaLangString, this.a.c, this.a.jdField_a_of_type_JavaLangBoolean.booleanValue());
        }
        localObject = this.a;
        LyricsController.a((LyricsController)localObject, ((LyricsController)localObject).jdField_b_of_type_JavaLangString, this.a.i);
      }
    }
    if (paramBoolean2) {
      this.a.b(paramInt, paramString, paramBoolean1);
    }
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    if (paramListenTogetherSession == null) {
      return;
    }
    boolean bool;
    if (paramListenTogetherSession.i == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onUIModuleNeedRefresh sessionJoined:");
      ((StringBuilder)localObject1).append(bool);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramListenTogetherSession != null)
      {
        MusicInfo localMusicInfo = paramListenTogetherSession.a();
        localObject1 = localObject2;
        if (localMusicInfo != null) {
          localObject1 = localMusicInfo.e;
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a = ((String)localObject1);
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.g = paramListenTogetherSession.d;
      this.a.l();
      LyricsController.a(this.a);
    }
  }
  
  protected void a(ISong paramISong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayMusicChange song.id:");
      localStringBuilder.append(paramISong.a());
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    LyricsController.a(this.a, paramISong.a());
    this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a = paramISong.d();
    LyricsController.a(this.a);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayStateChange state:");
      localStringBuilder.append(paramInt);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    if (paramInt == 2)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
      }
    }
    else if (paramInt == 3)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(false);
      }
    }
    else if ((paramInt == 4) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(false);
    }
    LyricsController.b(this.a, paramString, paramInt);
    FloatViewSkin.a().a();
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    LyricsController.a(this.a, paramString, paramInt1, paramInt2);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a.a(paramString1, paramString2, paramBoolean);
  }
  
  protected void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFloatNeedShowOrDismiss show:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" session:");
      ((StringBuilder)localObject).append(paramListenTogetherSession);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramListenTogetherSession == null) {
      return;
    }
    int i = paramListenTogetherSession.f;
    String str = paramListenTogetherSession.e;
    if (paramBoolean)
    {
      localObject = null;
      MusicInfo localMusicInfo = paramListenTogetherSession.a();
      if (localMusicInfo != null) {
        localObject = localMusicInfo.e;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a = ((String)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.g = paramListenTogetherSession.d;
      this.a.l();
      this.a.a(i, str);
      return;
    }
    this.a.b(i, str);
  }
  
  protected void d()
  {
    if ((this.a.jdField_b_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.3
 * JD-Core Version:    0.7.0.1
 */