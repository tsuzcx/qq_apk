package com.tencent.mobileqq.colornote;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorNoteRecentView
{
  private ColorNoteCurd a;
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = d(paramAppRuntime);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.edit().putBoolean("color_note_recently_viewed_switch", paramBoolean).apply();
      if (!paramBoolean) {
        ColorNoteSmallScreenUtil.a(MobileQQ.getContext(), 5, false);
      }
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("setRecentColorNoteSwitch: ");
        paramAppRuntime.append(paramBoolean);
        QLog.d("ColorNoteRecentView", 2, paramAppRuntime.toString());
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = d(MobileQQ.getMobileQQ().waitAppRuntime(null));
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((SharedPreferences)localObject).getBoolean("color_note_recent_first_visit", false))
      {
        localObject = ((SharedPreferences)localObject).edit();
        bool1 = true;
        ((SharedPreferences.Editor)localObject).putBoolean("color_note_recent_first_visit", true).apply();
      }
    }
    return bool1;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = d(paramAppRuntime);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getBoolean("color_note_recently_viewed_switch", true);
    }
    return true;
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = d(paramAppRuntime);
    if (paramAppRuntime != null) {
      paramAppRuntime.edit().putBoolean("color_note_recent_first_visit", false).apply();
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = d(paramAppRuntime);
    if (paramAppRuntime != null) {
      paramAppRuntime.edit().putBoolean("color_recent_permission_shown", paramBoolean).apply();
    }
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = d(paramAppRuntime);
    boolean bool = false;
    if (paramAppRuntime != null) {
      bool = paramAppRuntime.getBoolean("color_recent_permission_shown", false);
    }
    return bool;
  }
  
  private static SharedPreferences d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("color_note_recent_view_switch");
    localStringBuilder.append(paramAppRuntime);
    paramAppRuntime = localStringBuilder.toString();
    return MobileQQ.getContext().getSharedPreferences(paramAppRuntime, 4);
  }
  
  public void a(ColorNoteCurd paramColorNoteCurd)
  {
    this.a = paramColorNoteCurd;
  }
  
  public void a(ColorNote paramColorNote)
  {
    Object localObject = ColorNoteRecentConfigProcessor.a();
    int i;
    if ((localObject != null) && (((ColorNoteRecentConfBean)localObject).a())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramColorNote != null) && (this.a != null) && (((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(MobileQQ.getMobileQQ().waitAppRuntime(null))))
    {
      localObject = ColorNoteUtils.c(paramColorNote);
      this.a.c((ColorNote)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRecentNote: ");
        ((StringBuilder)localObject).append(paramColorNote.toString());
        QLog.d("ColorNoteRecentView", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteRecentView
 * JD-Core Version:    0.7.0.1
 */