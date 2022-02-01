package com.tencent.mobileqq.leba.controller;

import com.tencent.mobileqq.leba.controller.list.LebaListController;
import com.tencent.mobileqq.leba.entity.InitViewParam;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaController
{
  private ILebaController a;
  private InitViewParam b;
  private AppRuntime c;
  private List<LebaViewItem> d;
  
  public int a()
  {
    ILebaController localILebaController = this.a;
    if (localILebaController != null) {
      return localILebaController.d();
    }
    return 0;
  }
  
  public void a(InitViewParam paramInitViewParam)
  {
    this.b = paramInitViewParam;
    this.c = paramInitViewParam.a;
    this.d = paramInitViewParam.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLebaView");
    localStringBuilder.append(LebaViewItem.a(this.d));
    QLog.i("Q.lebatab.LebaController", 1, localStringBuilder.toString());
    if (this.a == null) {
      this.a = new LebaListController();
    }
    this.a.a(paramInitViewParam);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    ILebaController localILebaController = this.a;
    if (localILebaController != null) {
      localILebaController.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPause");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("Q.lebatab.LebaController", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((ILebaController)localObject).a(paramAppRuntime, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    ILebaController localILebaController = this.a;
    if (localILebaController != null) {
      localILebaController.a();
    }
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyDataSetChanged");
    ((StringBuilder)localObject).append(LebaViewItem.a(this.d));
    QLog.i("Q.lebatab.LebaController", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((ILebaController)localObject).c();
    }
  }
  
  public void d()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    ILebaController localILebaController = this.a;
    if (localILebaController != null) {
      localILebaController.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.LebaController
 * JD-Core Version:    0.7.0.1
 */