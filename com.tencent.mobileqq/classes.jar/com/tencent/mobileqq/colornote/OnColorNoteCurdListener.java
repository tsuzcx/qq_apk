package com.tencent.mobileqq.colornote;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.qroute.QRoute;

public class OnColorNoteCurdListener
{
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("param_service_type");
      String str = paramBundle.getString("param_sub_type");
      if (paramBundle.getInt("param_extra", 1) != 2) {
        ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(i, str, paramBoolean);
      }
      ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateFloatingWindowPosition(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(paramInt, paramString, paramBoolean);
  }
  
  public void onUpdateColorNote(ColorNote paramColorNote, boolean paramBoolean) {}
  
  public void onUpdateColorNoteState(int paramInt, String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(paramInt, paramString, paramBundle.getBoolean("extra_is_colornote_exists"));
      ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).setCanAddColorNote(paramBundle.getBoolean("extra_can_add_colornote"));
      ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateFloatingWindowPosition(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
      boolean bool = paramBundle.getBoolean("extra_after_sync_msg");
      ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).setSyncState(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.OnColorNoteCurdListener
 * JD-Core Version:    0.7.0.1
 */