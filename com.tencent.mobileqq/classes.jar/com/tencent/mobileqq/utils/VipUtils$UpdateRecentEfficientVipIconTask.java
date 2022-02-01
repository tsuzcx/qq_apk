package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import mqq.util.WeakReference;

class VipUtils$UpdateRecentEfficientVipIconTask
  implements Runnable
{
  private WeakReference<View> a;
  private WeakReference<Context> b;
  private WeakReference<RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder> c;
  private String d;
  private boolean e = true;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramRecentEfficientItemBuilderHolder);
    this.d = paramString;
  }
  
  private View a()
  {
    return (View)this.a.get();
  }
  
  static void a(Context paramContext, String paramString, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool = ((FriendsManager)localObject).t;
    Friends localFriends = ((FriendsManager)localObject).m(paramString);
    int i;
    if ((localFriends != null) && (VipUtils.VipIconUtils.a(localFriends.nameplateVipType))) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("conversation doUpdate id = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" nameplateVipType = ");
    if (localFriends != null) {
      j = localFriends.nameplateVipType;
    } else {
      j = 0;
    }
    ((StringBuilder)localObject).append(j);
    QLog.d("VipUtils", 1, ((StringBuilder)localObject).toString());
    if (i != 0) {
      if (!VipUtils.VipIconUtils.b(localFriends.grayNameplateFlag))
      {
        String str = VipUtils.VipIconUtils.a(localQQAppInterface, localFriends.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(localFriends.nameplateVipType), false);
        SingleLineTextView localSingleLineTextView = paramRecentEfficientItemBuilderHolder.d;
        j = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(localFriends.nameplateVipType));
        if (VipUtils.a(localFriends.nameplateVipType)) {
          localObject = localFriends;
        } else {
          localObject = null;
        }
        VipUtils.a(localSingleLineTextView, paramContext, str, j, (Friends)localObject);
      }
      else
      {
        paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
    }
    int j = VipUtils.b(localQQAppInterface, paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindView: vip = ");
    ((StringBuilder)localObject).append(j);
    QLog.d("VipUtils", 1, ((StringBuilder)localObject).toString());
    int k = j >> 8;
    if (k == 3)
    {
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168187));
        } else {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.d, paramContext, paramString, 2130848951, localFriends);
        }
      }
      else
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168187));
        } else {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.d, paramContext, paramString, 2130848949, localFriends);
        }
      }
    }
    else if (k == 1)
    {
      if (bool) {
        paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168187));
      } else {
        paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
      }
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
      if (i == 0) {
        VipUtils.a(paramRecentEfficientItemBuilderHolder.d, paramContext, paramString, 2130848950);
      }
    }
    else if (k == 2)
    {
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168187));
        } else {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.d, paramContext, paramString, 2130848951);
        }
      }
      else
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168187));
        } else {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.d, paramContext, paramString, 2130848949);
        }
      }
    }
    else
    {
      paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
      paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
  }
  
  public void run()
  {
    VipUtils.UpdateRecentEfficientVipIconTask.Manager.b(this);
    if (!this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
      return;
    }
    Object localObject = (Context)this.b.get();
    RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)this.c.get();
    if ((localObject != null) && (localRecentEfficientItemBuilderHolder != null)) {
      a((Context)localObject, this.d, localRecentEfficientItemBuilderHolder);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRecentEfficientVipIcon async - sucess : ");
      ((StringBuilder)localObject).append(this.d);
      QLog.w("VipUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */