package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$16
  extends GroupTeamWorkObserver
{
  GroupTeamWorkListActivity$16(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onDeletePanInfo success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" \nretCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" \nerrorMsg: ");
      localStringBuilder.append(paramString);
      QLog.i("GroupTeamWorkListActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.a(this.a, 5);
      QQToast.makeText(this.a.app.getApp(), 1, this.a.getString(2131888452), 0).show(this.a.getTitleBarHeight());
      return;
    }
    QQToast.makeText(this.a.app.getApp(), 1, this.a.getString(2131888445), 0).show(this.a.getTitleBarHeight());
    this.a.a(2);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List<GPadInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramList = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onGetPadTemplateList success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" \nretCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" \nerrorMsg: ");
      localStringBuilder.append(paramString);
      QLog.i(paramList, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.b(this.a, 2);
      if (GroupTeamWorkListActivity.l(this.a) != null) {
        GroupTeamWorkListActivity.l(this.a).notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramList = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onGetPadList success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" \nretCode: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" \nerrorMsg: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n next =");
      localStringBuilder.append(paramInt2);
      QLog.i(paramList, 2, localStringBuilder.toString());
    }
    paramString = this.a;
    paramString.p = paramInt2;
    boolean bool = GroupTeamWorkListActivity.f(paramString);
    int j = 0;
    int i = 0;
    if (bool)
    {
      if (paramBoolean) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      paramString = this.a.b.obtainMessage(111, paramInt2, 0);
      this.a.b.sendMessageDelayed(paramString, 500L);
      GroupTeamWorkListActivity.a(this.a, false);
    }
    if (GroupTeamWorkListActivity.g(this.a))
    {
      this.a.a(2);
      GroupTeamWorkListActivity.b(this.a, false);
    }
    paramInt2 = 3;
    if (paramInt3 != 2) {
      if (paramInt3 == 3) {
        paramInt2 = 4;
      } else {
        paramInt2 = 2;
      }
    }
    if ((paramBoolean) && (paramInt1 == 0))
    {
      GroupTeamWorkListActivity.a(this.a, paramInt2);
      paramInt1 = j;
    }
    else
    {
      if (paramInt2 == 2) {
        if ((GroupTeamWorkListActivity.c(this.a) != null) && (GroupTeamWorkListActivity.c(this.a).getCount() == 0))
        {
          GroupTeamWorkListActivity.h(this.a).setVisibility(8);
          if (GroupTeamWorkListActivity.i(this.a).getVisibility() == 0) {
            GroupTeamWorkListActivity.i(this.a).setVisibility(8);
          }
          GroupTeamWorkListActivity.j(this.a).setVisibility(0);
        }
        else
        {
          QQToast.makeText(this.a.app.getApp(), 1, this.a.getString(2131891374), 0).show(this.a.getTitleBarHeight());
        }
      }
      paramInt1 = i;
      if (paramInt2 == 4)
      {
        QQToast.makeText(this.a.app.getApp(), 1, this.a.getString(2131891374), 0).show(this.a.getTitleBarHeight());
        paramInt1 = 1;
      }
      this.a.a(2);
    }
    if (paramInt1 != 0) {
      GroupTeamWorkListActivity.k(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.16
 * JD-Core Version:    0.7.0.1
 */