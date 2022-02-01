package com.tencent.mobileqq.colornote;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.ipc.ColorNoteQIPCModule;

public class ColorNoteCurd$OnColorNoteCurdListener
{
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("param_service_type");
      String str = paramBundle.getString("param_sub_type");
      if (paramBundle.getInt("param_extra", 1) != 2) {
        ColorNoteQIPCModule.a().a(i, str, paramBoolean);
      }
      ColorNoteQIPCModule.a().a(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    ColorNoteQIPCModule.a().a(paramInt, paramString, paramBoolean);
  }
  
  public void onUpdateColorNote(ColorNote paramColorNote, boolean paramBoolean) {}
  
  public void onUpdateColorNoteState(int paramInt, String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      ColorNoteQIPCModule.a().a(paramInt, paramString, paramBundle.getBoolean("extra_is_colornote_exists"));
      ColorNoteQIPCModule.a().c(paramBundle.getBoolean("extra_can_add_colornote"));
      ColorNoteQIPCModule.a().a(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
      boolean bool = paramBundle.getBoolean("extra_after_sync_msg");
      ColorNoteQIPCModule.a().b(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener
 * JD-Core Version:    0.7.0.1
 */