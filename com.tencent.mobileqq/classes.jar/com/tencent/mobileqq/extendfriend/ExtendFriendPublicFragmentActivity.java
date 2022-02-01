package com.tencent.mobileqq.extendfriend;

import Override;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.MotionEvent;
import bdll;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ExtendFriendPublicFragmentActivity
  extends PublicFragmentActivity
{
  private static volatile long a;
  
  private static void a(int paramInt)
  {
    String str = "";
    Object localObject = "";
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      localObject = localSosoLbsInfo.a;
      if (!TextUtils.isEmpty(((SosoInterface.SosoLocation)localObject).e)) {
        str = ((SosoInterface.SosoLocation)localObject).e;
      }
      localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoInterface.SosoLocation)localObject).a), Double.valueOf(((SosoInterface.SosoLocation)localObject).b) });
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800AD99", "0X800AD99", paramInt, 0, "", "", str, (String)localObject);
      return;
      str = "";
    }
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, 0, true);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, true);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    QLog.d("ExtendFriendPublicFragmentActivity", 2, String.format("launchExtendFriendFragment context=%s source=%s freqCtrl=%s", new Object[] { paramContext, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - a < 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendPublicFragmentActivity", 2, "launchExtendFriendFragment launch too often.");
      }
      return;
    }
    a = l;
    PublicFragmentActivity.a(paramContext, ExtendFriendFragment.class);
    a(paramInt);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */