package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ListenTogetherPlayFragment$3
  extends ListenTogetherObserver
{
  ListenTogetherPlayFragment$3(ListenTogetherPlayFragment paramListenTogetherPlayFragment) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onListenTogetherJoinedCountChange msg=%s", new Object[] { paramString2 }));
        }
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString = paramString2;
        if (paramInt == 1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHandler.a(paramString1);
          return;
        }
        paramString1 = this.a;
        ListenTogetherPlayFragment.a(paramString1, ListenTogetherPlayFragment.a(paramString1), this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    Object localObject = this.a.getBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(paramListenTogetherSession.e))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onUIModuleNeedRefresh session=%s", new Object[] { paramListenTogetherSession }));
        }
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
        MusicInfo localMusicInfo = paramListenTogetherSession.a();
        if ((paramListenTogetherSession.i == 2) && (paramListenTogetherSession.h != 3) && (paramListenTogetherSession.h != 4) && (localMusicInfo != null))
        {
          a(localMusicInfo);
          localObject = this.a;
          ListenTogetherPlayFragment.a((ListenTogetherPlayFragment)localObject, ((ListenTogetherPlayFragment)localObject).jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), paramListenTogetherSession.h, this.a.jdField_a_of_type_JavaLangString);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, "onExit");
        }
        QQToast.a((Context)localObject, 2131693659, 1).a();
        this.a.getBaseActivity().finish();
      }
    }
  }
  
  protected void a(ISong paramISong)
  {
    Object localObject = this.a.getBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (!this.a.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.equals(paramISong))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onPlayMusicChange %s", new Object[] { paramISong }));
        }
        localObject = this.a;
        ((ListenTogetherPlayFragment)localObject).jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = paramISong;
        ((ListenTogetherPlayFragment)localObject).jdField_a_of_type_JavaLangString = null;
        ListenTogetherPlayFragment.a((ListenTogetherPlayFragment)localObject, paramISong);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.a.getBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a().equals(paramString1))
      {
        if (QLog.isColorLevel())
        {
          int i = 0;
          if (paramString2 != null) {
            i = paramString2.length();
          }
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetLyric %s %d", new Object[] { paramString1, Integer.valueOf(i) }));
        }
        localObject = this.a;
        ((ListenTogetherPlayFragment)localObject).jdField_a_of_type_JavaLangString = paramString2;
        ListenTogetherPlayFragment.a((ListenTogetherPlayFragment)localObject, paramString1, ((ListenTogetherPlayFragment)localObject).jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h, paramString2);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetGroupJoinedUsers uin=%s num=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        paramString = this.a;
        ListenTogetherPlayFragment.a(paramString, paramList, paramString.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void c(int paramInt, String paramString)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onPauseListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.a(localBaseActivity, 2131693667, 1).a();
      }
    }
  }
  
  protected void d(int paramInt, String paramString)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onResumeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.a(localBaseActivity, 2131693669, 1).a();
      }
    }
  }
  
  protected void e(int paramInt, String paramString)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onCutListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.a(localBaseActivity, 2131693647, 1).a();
      }
    }
  }
  
  protected void f(int paramInt, String paramString)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (!this.a.isAdded()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e.equals(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onChangePlayModeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.a(localBaseActivity, 2131693668, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.3
 * JD-Core Version:    0.7.0.1
 */