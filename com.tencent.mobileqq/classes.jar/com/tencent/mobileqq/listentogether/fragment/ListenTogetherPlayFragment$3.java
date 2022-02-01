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
      if (this.a.y.n.equals(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onListenTogetherJoinedCountChange msg=%s", new Object[] { paramString2 }));
        }
        this.a.y.c = paramString2;
        if (paramInt == 1)
        {
          this.a.u.a(paramString1);
          return;
        }
        paramString1 = this.a;
        ListenTogetherPlayFragment.a(paramString1, ListenTogetherPlayFragment.a(paramString1), this.a.y.c);
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
      if (this.a.y.n.equals(paramListenTogetherSession.n))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onUIModuleNeedRefresh session=%s", new Object[] { paramListenTogetherSession }));
        }
        this.a.y = paramListenTogetherSession;
        MusicInfo localMusicInfo = paramListenTogetherSession.e();
        if ((paramListenTogetherSession.q == 2) && (paramListenTogetherSession.p != 3) && (paramListenTogetherSession.p != 4) && (localMusicInfo != null))
        {
          a(localMusicInfo);
          localObject = this.a;
          ListenTogetherPlayFragment.a((ListenTogetherPlayFragment)localObject, ((ListenTogetherPlayFragment)localObject).x.a(), paramListenTogetherSession.p, this.a.B);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, "onExit");
        }
        QQToast.makeText((Context)localObject, 2131891234, 1).show();
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
      if (!this.a.x.equals(paramISong))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onPlayMusicChange %s", new Object[] { paramISong }));
        }
        localObject = this.a;
        ((ListenTogetherPlayFragment)localObject).x = paramISong;
        ((ListenTogetherPlayFragment)localObject).B = null;
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
      if (this.a.x.a().equals(paramString1))
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
        ((ListenTogetherPlayFragment)localObject).B = paramString2;
        ListenTogetherPlayFragment.a((ListenTogetherPlayFragment)localObject, paramString1, ((ListenTogetherPlayFragment)localObject).y.p, paramString2);
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
      if (this.a.y.n.equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetGroupJoinedUsers uin=%s num=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        paramString = this.a;
        ListenTogetherPlayFragment.a(paramString, paramList, paramString.y.c);
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
      if (this.a.y.n.equals(this.a.y.n))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onPauseListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.makeText(localBaseActivity, 2131891242, 1).show();
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
      if (this.a.y.n.equals(this.a.y.n))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onResumeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.makeText(localBaseActivity, 2131891244, 1).show();
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
      if (this.a.y.n.equals(this.a.y.n))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onCutListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.makeText(localBaseActivity, 2131891222, 1).show();
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
      if (this.a.y.n.equals(this.a.y.n))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogetherPlayFragment", 2, String.format("onChangePlayModeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
        }
        QQToast.makeText(localBaseActivity, 2131891243, 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.3
 * JD-Core Version:    0.7.0.1
 */