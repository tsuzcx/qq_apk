package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.share.GameShareNetHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

final class GameShareUtilImpl$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (Math.abs(l - GameShareUtilImpl.access$000()) >= 1000L)
    {
      GameShareUtilImpl.access$002(l);
      if ((paramView != null) && (paramView.getContext() != null))
      {
        localObject1 = paramView.getContext();
        if ((localObject1 instanceof Activity))
        {
          localObject1 = (Activity)localObject1;
          if (!((Activity)localObject1).isFinishing())
          {
            localObject3 = paramView.getTag(-1);
            if ((localObject3 instanceof String))
            {
              localObject3 = (String)localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject4 = ((String)localObject3).substring(0, 6).toLowerCase();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      int k;
      try
      {
        if ((!((String)localObject4).startsWith("http")) && (!((String)localObject4).startsWith("https")))
        {
          if (((String)localObject4).startsWith("mqqapi"))
          {
            localObject4 = new Intent((Context)localObject1, JumpActivity.class);
            ((Intent)localObject4).setData(Uri.parse((String)localObject3));
            ((Activity)localObject1).startActivityForResult((Intent)localObject4, -1);
          }
        }
        else
        {
          localObject4 = new Intent((Context)localObject1, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Activity)localObject1).startActivityForResult((Intent)localObject4, -1);
        }
        localObject5 = paramView.getTag(-4);
        if (!(localObject5 instanceof String)) {
          break label471;
        }
        localObject1 = paramView.getTag(-2);
        localObject3 = paramView.getTag(-3);
        localObject4 = paramView.getTag(-5);
        if ((!(localObject1 instanceof Integer)) || (!(localObject3 instanceof Integer)) || (!(localObject4 instanceof Integer))) {
          break label471;
        }
        int i = ((Integer)localObject1).intValue();
        j = ((Integer)localObject3).intValue();
        k = ((Integer)localObject4).intValue();
        if ((i == 0) || (j == 0)) {
          break label479;
        }
        GameShareNetHelper.a().a((String)localObject5, ((Integer)localObject1).intValue(), ((Integer)localObject3).intValue());
      }
      catch (Throwable localThrowable)
      {
        Object localObject5;
        int j;
        StringBuilder localStringBuilder;
        if (!QLog.isDevelopLevel()) {
          break label471;
        }
        localThrowable.printStackTrace();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new HashMap();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("");
        ((Map)localObject4).put(Integer.valueOf(2), localStringBuilder.toString());
        ((Map)localObject4).put(Integer.valueOf(4), "20");
        GameCenterUtils.a(null, "870", (String)localObject1, (String)localObject5, (String)localObject3, "1", "145", (Map)localObject4);
      }
      label471:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label479:
      if ((k != 1) && (k != 0))
      {
        if (k == 2)
        {
          localObject2 = "87007";
          localObject3 = "206676";
        }
        else
        {
          localObject2 = null;
          localObject3 = localObject2;
        }
      }
      else
      {
        localObject2 = "87006";
        localObject3 = "206675";
      }
      localObject4 = localObject2;
      Object localObject2 = localObject3;
      localObject3 = localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.2
 * JD-Core Version:    0.7.0.1
 */