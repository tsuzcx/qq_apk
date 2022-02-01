package com.tencent.mobileqq.colornote;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.ipc.ColorNoteQIPCModule;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ColorNoteRecentView
{
  private ColorNoteCurd a;
  
  private static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "color_note_recent_view_switch" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 4);
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putBoolean("color_note_recently_viewed_switch", paramBoolean).apply();
      if (!paramBoolean) {
        ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 5, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteRecentView", 2, "setRecentColorNoteSwitch: " + paramBoolean);
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("color_note_recently_viewed_switch", true);
    }
    return bool;
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("color_recent_permission_shown", paramBoolean).apply();
    }
  }
  
  public static boolean b()
  {
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!localSharedPreferences.getBoolean("color_note_recent_first_visit", false)))
    {
      localSharedPreferences.edit().putBoolean("color_note_recent_first_visit", true).apply();
      return true;
    }
    return false;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("color_recent_permission_shown", false);
    }
    return bool;
  }
  
  public void a(ColorNoteCurd paramColorNoteCurd)
  {
    this.a = paramColorNoteCurd;
  }
  
  public void a(ColorNote paramColorNote)
  {
    boolean bool3 = false;
    Object localObject = ColorNoteRecentConfigProcessor.a();
    if ((localObject != null) && (((ColorNoteRecentConfBean)localObject).a())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((bool1) && (paramColorNote != null) && (this.a != null) && (ColorNoteQIPCModule.a().a()))
      {
        localObject = ColorNoteUtils.a(paramColorNote);
        this.a.c((ColorNote)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteRecentView", 2, "updateRecentNote: " + paramColorNote.toString());
        }
        return;
      }
      if (paramColorNote != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (this.a != null) {
          bool3 = true;
        }
        QLog.d("ColorNoteRecentView", 1, new Object[] { "[updateRecentNote] recentSwitch: ", Boolean.valueOf(bool1), ", note: ", Boolean.valueOf(bool2), ", curd: ", Boolean.valueOf(bool3), "recentTurnOn: ", Boolean.valueOf(ColorNoteQIPCModule.a().a()) });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteRecentView
 * JD-Core Version:    0.7.0.1
 */