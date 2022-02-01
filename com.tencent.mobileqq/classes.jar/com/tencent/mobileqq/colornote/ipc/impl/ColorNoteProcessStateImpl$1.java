package com.tencent.mobileqq.colornote.ipc.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ColorNoteProcessStateImpl$1
  extends BroadcastReceiver
{
  ColorNoteProcessStateImpl$1(ColorNoteProcessStateImpl paramColorNoteProcessStateImpl) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ??? = paramIntent.getAction();
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action receive: ");
      localStringBuilder.append(???);
      QLog.d("ColorNoteQIPCModule", 1, localStringBuilder.toString());
    }
    int i;
    int j;
    if (???.equals("key_float_window_position"))
    {
      i = paramIntent.getIntExtra("key_float_window_position_x", 0);
      j = paramIntent.getIntExtra("key_float_window_position_y", 0);
      synchronized (ColorNoteProcessStateImpl.access$000())
      {
        ColorNoteProcessStateImpl.access$100(this.a).set(i, j);
        if (!QLog.isColorLevel()) {
          return;
        }
        ??? = new StringBuilder();
        ???.append("KEY_FLOAT_WINDOW_POSITION receive: ");
        ???.append(i);
        ???.append(", ");
        ???.append(j);
        QLog.d("ColorNoteQIPCModule", 1, ???.toString());
        return;
      }
    }
    if (???.equals("key_delete_item_call"))
    {
      ColorNoteProcessStateImpl.access$202(this.a, paramIntent.getBooleanExtra("extra_can_add_colornote", true));
      ??? = paramIntent.getStringArrayExtra("key_color_note_servicetype_list");
      paramIntent = paramIntent.getStringArrayExtra("key_color_note_suptype_list");
      if ((ColorNoteProcessStateImpl.access$300(this.a) != null) && (??? != null) && (paramIntent != null) && (???.length == paramIntent.length))
      {
        i = 0;
        while ((paramIntent != null) && (i < paramIntent.length))
        {
          try
          {
            j = Integer.valueOf(???[i]).intValue();
          }
          catch (Exception localException)
          {
            QLog.e("ColorNoteQIPCModule", 2, "integer cast error", localException);
            j = -1;
          }
          if (j != -1)
          {
            OnColorNoteCurdListener localOnColorNoteCurdListener = (OnColorNoteCurdListener)ColorNoteProcessStateImpl.access$300(this.a).get();
            if (localOnColorNoteCurdListener != null) {
              localOnColorNoteCurdListener.onDeleteColorNote(j, paramIntent[i], false);
            }
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("[onReceive->ACTION_DELETE_ITEM_CALL]\n[mCanAddColorNote]: ");
        ???.append(ColorNoteProcessStateImpl.access$200(this.a));
        ???.append("\n");
        ColorNoteUtils.b("ColorNoteQIPCModule", ???.toString());
      }
    }
    else if ((???.equals("key_after_sync_msg")) && (ColorNoteProcessStateImpl.access$400(this.a) != null))
    {
      ??? = (IServiceSyncListener)ColorNoteProcessStateImpl.access$400(this.a).get();
      if (??? != null)
      {
        boolean bool = paramIntent.getBooleanExtra("extra_after_sync_msg", true);
        ???.onServiceSyncSucc(bool);
        this.a.setSyncState(bool);
        ??? = new StringBuilder();
        ???.append("invoke listener: ");
        ???.append(bool);
        QLog.d("ColorNoteQIPCModule", 1, ???.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ipc.impl.ColorNoteProcessStateImpl.1
 * JD-Core Version:    0.7.0.1
 */