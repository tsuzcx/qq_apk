package com.tencent.timi.game.test.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ReflectionUtils;

public class TimiGameTestServiceImpl
  implements ITimiGameTestService
{
  public void a()
  {
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openTimiGameTestPage - ");
    localStringBuilder.append(localQBaseActivity);
    Logger.a("TimiGameTestServiceImpl", localStringBuilder.toString());
    if (localQBaseActivity == null)
    {
      CustomToastView.a("Context为空！");
      return;
    }
    QPublicFragmentActivity.Launcher.a(localQBaseActivity, QPublicFragmentActivity.class, TimiGameMainTestFragment.class);
  }
  
  public void a(Context paramContext) {}
  
  public void a(View paramView)
  {
    try
    {
      Class localClass = Class.forName("hexin.androidbitmapcanary.ActivityDrawableWatcher");
      if (localClass == null) {
        break label42;
      }
      ReflectionUtils.a(localClass, "watchDrawable", new Class[] { View.class }, new Object[] { paramView });
      return;
    }
    catch (Exception paramView)
    {
      label35:
      label42:
      break label35;
    }
    Logger.d("TimiGameTestServiceImpl", "watchDrawable reflect error");
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameTestServiceImpl
 * JD-Core Version:    0.7.0.1
 */