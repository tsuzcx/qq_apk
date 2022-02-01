package cooperation.qqreader.host.colornote;

import android.content.Context;
import aqnv;
import aqos;
import aqrl;

public class ReaderColorNoteUtils
{
  public static final int SERVICE_TYPE_READER = 16908289;
  public static final int SERVICE_TYPE_RECENT_TYPE_MASK = -2147483648;
  
  public static void deleteColorNote(int paramInt, String paramString)
  {
    aqnv.b(paramInt, paramString);
  }
  
  public static boolean getSyncState()
  {
    return aqos.a().b();
  }
  
  public static void sendUpdateSmallScreenStateBroadcast(Context paramContext, boolean paramBoolean)
  {
    aqrl.a(paramContext, 2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteUtils
 * JD-Core Version:    0.7.0.1
 */