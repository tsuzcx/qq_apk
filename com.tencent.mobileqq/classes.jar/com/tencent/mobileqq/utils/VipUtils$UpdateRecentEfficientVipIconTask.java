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
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<View> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private WeakReference<Context> b;
  private WeakReference<RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramRecentEfficientItemBuilderHolder);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool = ((FriendsManager)localObject).c;
    Friends localFriends = ((FriendsManager)localObject).e(paramString);
    int i;
    if ((localFriends != null) && (VipUtils.VipIconUtils.a(localFriends.nameplateVipType))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      if (!VipUtils.VipIconUtils.b(localFriends.grayNameplateFlag))
      {
        String str = VipUtils.VipIconUtils.a(localQQAppInterface, localFriends.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(localFriends.nameplateVipType), false);
        SingleLineTextView localSingleLineTextView = paramRecentEfficientItemBuilderHolder.a;
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
        paramRecentEfficientItemBuilderHolder.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
    }
    int j = VipUtils.a(localQQAppInterface, paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindView: vip=");
      ((StringBuilder)localObject).append(j);
      QLog.d("VipUtils", 2, ((StringBuilder)localObject).toString());
    }
    int k = j >> 8;
    if (k == 3)
    {
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167202));
        } else {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167063));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847300, localFriends);
        }
      }
      else
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167202));
        } else {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167063));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847298, localFriends);
        }
      }
    }
    else if (k == 1)
    {
      if (bool) {
        paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167202));
      } else {
        paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167063));
      }
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
      if (i == 0) {
        VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847299);
      }
    }
    else if (k == 2)
    {
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167202));
        } else {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167063));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847300);
        }
      }
      else
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167202));
        } else {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167063));
        }
        if (i == 0) {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847298);
        }
      }
    }
    else
    {
      paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167063));
      paramRecentEfficientItemBuilderHolder.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
  }
  
  public void run()
  {
    VipUtils.UpdateRecentEfficientVipIconTask.Manager.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
      return;
    }
    Object localObject = (Context)this.b.get();
    RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)this.c.get();
    if ((localObject != null) && (localRecentEfficientItemBuilderHolder != null)) {
      a((Context)localObject, this.jdField_a_of_type_JavaLangString, localRecentEfficientItemBuilderHolder);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRecentEfficientVipIcon async - sucess : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.w("VipUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */