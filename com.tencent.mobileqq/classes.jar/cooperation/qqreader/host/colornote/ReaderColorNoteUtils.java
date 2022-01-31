package cooperation.qqreader.host.colornote;

import amgs;
import amhk;
import amkg;
import android.content.Context;

public class ReaderColorNoteUtils
{
  public static final int SERVICE_TYPE_READER = 16908289;
  public static final int SERVICE_TYPE_RECENT_TYPE_MASK = -2147483648;
  
  public static void deleteColorNote(int paramInt, String paramString)
  {
    amgs.b(paramInt, paramString);
  }
  
  public static boolean getSyncState()
  {
    return amhk.a().b();
  }
  
  public static void sendUpdateSmallScreenStateBroadcast(Context paramContext, boolean paramBoolean)
  {
    amkg.a(paramContext, 2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteUtils
 * JD-Core Version:    0.7.0.1
 */