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
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onLyricModuleSwitchChange, newUserClosed:" + paramBoolean1 + " type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(paramInt, paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean != paramBoolean1))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean = paramBoolean1;
        LyricsController.a(this.a);
        if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!paramBoolean1) && (paramBoolean2))
        {
          LyricsController.a(this.a, this.a.jdField_b_of_type_JavaLangString);
          if (this.a.jdField_a_of_type_JavaLangBoolean != null) {
            LyricsController.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.c, this.a.jdField_a_of_type_JavaLangBoolean.booleanValue());
          }
          LyricsController.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.i);
        }
      }
      if (paramBoolean2) {
        this.a.b(paramInt, paramString, paramBoolean1);
      }
      return;
    }
  }
  
  public void a(ListenTogetherSession paramListenTogetherSession)
  {
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramListenTogetherSession.i == 2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onUIModuleNeedRefresh sessionJoined:" + bool);
      }
      if (!bool) {
        break;
      }
      Object localObject2 = null;
      Object localObject1 = localObject2;
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
      return;
    }
  }
  
  public void a(ISong paramISong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPlayMusicChange song.id:" + paramISong.a());
    }
    LyricsController.a(this.a, paramISong.a());
    this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a = paramISong.d();
    LyricsController.a(this.a);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPlayStateChange state:" + paramInt);
    }
    if (paramInt == 2) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
      }
    }
    for (;;)
    {
      LyricsController.b(this.a, paramString, paramInt);
      FloatViewSkin.a().a();
      return;
      if (paramInt == 3)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(false);
        }
      }
      else if ((paramInt == 4) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(false);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    LyricsController.a(this.a, paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a.a(paramString1, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onFloatNeedShowOrDismiss show:" + paramBoolean + " session:" + paramListenTogetherSession);
    }
    if (paramListenTogetherSession == null) {
      return;
    }
    int i = paramListenTogetherSession.f;
    String str2 = paramListenTogetherSession.e;
    if (paramBoolean)
    {
      String str1 = null;
      MusicInfo localMusicInfo = paramListenTogetherSession.a();
      if (localMusicInfo != null) {
        str1 = localMusicInfo.e;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a = str1;
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.g = paramListenTogetherSession.d;
      this.a.l();
      this.a.a(i, str2);
      return;
    }
    this.a.b(i, str2);
  }
  
  public void d()
  {
    if ((this.a.jdField_b_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.3
 * JD-Core Version:    0.7.0.1
 */