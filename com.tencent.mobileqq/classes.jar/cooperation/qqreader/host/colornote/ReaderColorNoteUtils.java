package cooperation.qqreader.host.colornote;

import android.content.Context;
import aoca;
import aoct;
import aofm;

public class ReaderColorNoteUtils
{
  public static final int SERVICE_TYPE_READER = 16908289;
  public static final int SERVICE_TYPE_RECENT_TYPE_MASK = -2147483648;
  
  public static void deleteColorNote(int paramInt, String paramString)
  {
    aoca.b(paramInt, paramString);
  }
  
  public static boolean getSyncState()
  {
    return aoct.a().b();
  }
  
  public static void sendUpdateSmallScreenStateBroadcast(Context paramContext, boolean paramBoolean)
  {
    aofm.a(paramContext, 2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteUtils
 * JD-Core Version:    0.7.0.1
 */