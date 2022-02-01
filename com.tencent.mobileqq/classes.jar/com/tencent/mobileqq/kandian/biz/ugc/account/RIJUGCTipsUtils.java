package com.tencent.mobileqq.kandian.biz.ugc.account;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RIJUGCTipsUtils
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.getWindow() == null) {
        return;
      }
      Object localObject = paramActivity.getWindow().getDecorView();
      if ((localObject instanceof FrameLayout))
      {
        localObject = (FrameLayout)localObject;
        int i;
        if (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
          i = 2131560302;
        } else {
          i = 2131560301;
        }
        View localView = paramActivity.getLayoutInflater().inflate(i, (ViewGroup)localObject, false);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = AIOUtils.b(6.0F, paramActivity.getResources());
        localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(paramActivity) + paramActivity.getResources().getDimensionPixelSize(2131299168) - AIOUtils.b(12.0F, paramActivity.getResources()));
        localView.setLayoutParams(localLayoutParams);
        paramActivity = (TextView)localView.findViewById(2131379926);
        if (paramActivity != null) {
          paramActivity.setText(RIJUGCAddAccountAladdinUtils.e());
        }
        ((FrameLayout)localObject).addView(localView);
        localView.setOnClickListener(new RIJUGCTipsUtils.1(localView));
        RIJThreadHandler.b().postDelayed(new RIJUGCTipsUtils.2(localView), RIJUGCAddAccountAladdinUtils.a() * 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCTipsUtils
 * JD-Core Version:    0.7.0.1
 */