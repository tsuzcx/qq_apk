package com.tencent.mobileqq.flashshow.api.instance;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.fragment.FSFolderFragment;
import com.tencent.mobileqq.flashshow.report.FSNativeSessionManager;
import com.tencent.mobileqq.flashshow.report.datong.FSDaTongLoginReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class FSFolderFragmentManager
{
  private static volatile FSFolderFragmentManager a;
  private FSFolderFragment b;
  private boolean c;
  private int d;
  
  public static FSFolderFragmentManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSFolderFragmentManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public Fragment b()
  {
    if (this.b == null)
    {
      this.b = new FSFolderFragment();
      QLog.i("FSFolderFragmentManager", 1, "getMainFragment  init fragment");
    }
    return this.b;
  }
  
  public View c()
  {
    Fragment localFragment = b();
    if (b().getView() == null) {
      QLog.e("FSFolderFragmentManager", 1, "getMainFragmentView view == null");
    }
    return localFragment.getView();
  }
  
  public void d()
  {
    if (this.b == null) {
      return;
    }
    QLog.i("FSFolderFragmentManager", 1, "fs_lifecycle onBottomPageSelected-> to onResume");
    this.c = true;
    ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).onBottomRedPointClick();
    b().onResume();
    FSDaTongLoginReporter.a();
  }
  
  public void e()
  {
    if (this.b == null) {
      return;
    }
    QLog.i("FSFolderFragmentManager", 1, "fs_lifecycle onBottomPageUnSelected-> to pause");
    this.c = false;
    b().onStop();
  }
  
  public boolean f()
  {
    return this.c;
  }
  
  public void g()
  {
    if (this.b == null) {
      return;
    }
    QLog.i("FSFolderFragmentManager", 1, "fs_lifecycle onBottomPageUnSelected-> to destroy");
    b().onDestroy();
    this.b = null;
    FSNativeSessionManager.a().c();
  }
  
  public boolean h()
  {
    if (this.b == null) {
      return false;
    }
    return ((FSFolderFragment)b()).onBackEvent();
  }
  
  public int i()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.instance.FSFolderFragmentManager
 * JD-Core Version:    0.7.0.1
 */