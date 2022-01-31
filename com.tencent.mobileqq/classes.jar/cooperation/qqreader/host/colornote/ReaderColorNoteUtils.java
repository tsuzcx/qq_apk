package cooperation.qqreader.host.colornote;

import alss;
import aluq;
import android.content.Context;

public class ReaderColorNoteUtils
{
  public static boolean getSyncState()
  {
    return alss.a().b();
  }
  
  public static void sendUpdateSmallScreenStateBroadcast(Context paramContext, boolean paramBoolean)
  {
    aluq.a(paramContext, 2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteUtils
 * JD-Core Version:    0.7.0.1
 */