package com.tencent.mobileqq.extendfriend;

import android.content.Context;
import android.text.TextUtils;
import azqs;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.qphone.base.util.QLog;

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
      azqs.b(null, "dc00898", "", "", "0X800AD99", "0X800AD99", paramInt, 0, "", "", str, (String)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */