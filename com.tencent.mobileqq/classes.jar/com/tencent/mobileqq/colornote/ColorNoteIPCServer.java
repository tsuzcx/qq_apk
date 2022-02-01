package com.tencent.mobileqq.colornote;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class ColorNoteIPCServer
  extends QIPCModule
  implements Handler.Callback
{
  private static ColorNoteIPCServer a;
  
  private ColorNoteIPCServer()
  {
    super("ColorNoteIPCServer");
  }
  
  public static ColorNoteIPCServer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ColorNoteIPCServer();
        }
      }
      finally {}
    }
    return a;
  }
  
  private IColorNoteHelper b()
  {
    return (IColorNoteHelper)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all");
  }
  
  EIPCResult a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("extra_unikey");
    boolean bool = b().isColorNoteExit(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_is_colornote_exists", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult b(Bundle paramBundle)
  {
    boolean bool = b().addColorNote(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_add_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult c(Bundle paramBundle)
  {
    String str = paramBundle.getString("extra_unikey");
    int i = paramBundle.getInt("color_note_extra_type");
    boolean bool = b().deleteColorNote(str, i);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_delete_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult d(Bundle paramBundle)
  {
    boolean bool = b().canAddColorNote();
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_can_add_colornote", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult e(Bundle paramBundle)
  {
    String str = paramBundle.getString("extra_unikey");
    boolean bool = paramBundle.getBoolean("extra_update_colornote_state");
    return EIPCResult.createResult(0, b().updateColorNoteState(str, bool));
  }
  
  EIPCResult f(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("extra_unikey");
    String str2 = paramBundle.getString("extra_field_name");
    String str3 = paramBundle.getString("extra_field_value");
    int i = paramBundle.getInt("extra_field_type");
    boolean bool = b().updateColorNote(str1, str2, str3, i);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_update_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult g(Bundle paramBundle)
  {
    paramBundle = (ColorNote)paramBundle.getSerializable("color_note_recently_viewed_comparator");
    boolean bool = b().updateRecentNote(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("color_note_clear_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult h(Bundle paramBundle)
  {
    int i = paramBundle.getInt("color_note_service_type");
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = ((IColorNoteController)QRoute.api(IColorNoteController.class)).detectCacheFull(paramBundle, i);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_clear_history_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equalsIgnoreCase("cmd_query_isexists")) {
        return a(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_add_colornote")) {
        return b(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_delete_colornote")) {
        return c(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_can_add_colornote")) {
        return d(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_update_colornote_state")) {
        return e(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_update_colornote")) {
        return f(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_clear_color_note")) {
        return g(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_clear_history_color_notes")) {
        return h(paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteIPCServer
 * JD-Core Version:    0.7.0.1
 */