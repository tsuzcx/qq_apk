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
    int j;
    if ((localFriends != null) && (VipUtils.VipIconUtils.a(localFriends.nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (VipUtils.VipIconUtils.b(localFriends.grayNameplateFlag)) {
          break label255;
        }
        String str = VipUtils.VipIconUtils.a(localQQAppInterface, localFriends.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(localFriends.nameplateVipType), false);
        SingleLineTextView localSingleLineTextView = paramRecentEfficientItemBuilderHolder.a;
        j = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(localFriends.nameplateVipType));
        if (!VipUtils.a(localFriends.nameplateVipType)) {
          break label249;
        }
        localObject = localFriends;
        label125:
        VipUtils.a(localSingleLineTextView, paramContext, str, j, (Friends)localObject);
      }
      label137:
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label344;
      }
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label286;
      }
      if (!bool) {
        break label267;
      }
      paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167177));
      label226:
      if (i == 0) {
        VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847431, localFriends);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label249:
      localObject = null;
      break label125;
      label255:
      paramRecentEfficientItemBuilderHolder.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label137;
      label267:
      paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
      break label226;
      label286:
      if (bool) {
        paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167177));
      }
      while (i == 0)
      {
        VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847429, localFriends);
        return;
        paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
      }
      continue;
      label344:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167177));
        }
        for (;;)
        {
          paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847430);
          return;
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
        }
      }
      if (j >> 8 != 2) {
        break label559;
      }
      paramString = VipUtils.VipIconUtils.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167177));
        }
        while (i == 0)
        {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847431);
          return;
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
        }
      }
      else
      {
        if (bool) {
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167177));
        }
        while (i == 0)
        {
          VipUtils.a(paramRecentEfficientItemBuilderHolder.a, paramContext, paramString, 2130847429);
          return;
          paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
        }
      }
    }
    label559:
    paramRecentEfficientItemBuilderHolder.a.setTextColor(paramContext.getResources().getColor(2131167040));
    paramRecentEfficientItemBuilderHolder.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    VipUtils.UpdateRecentEfficientVipIconTask.Manager.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)this.c.get();
      if ((localContext != null) && (localRecentEfficientItemBuilderHolder != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localRecentEfficientItemBuilderHolder);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */