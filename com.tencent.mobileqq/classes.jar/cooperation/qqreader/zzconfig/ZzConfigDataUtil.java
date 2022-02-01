package cooperation.qqreader.zzconfig;

import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;
import cooperation.qqreader.net.ReaderCgiListener;

public final class ZzConfigDataUtil
{
  public static final Pair<Integer, Integer> a = new Pair(Integer.valueOf(1154), Integer.valueOf(1));
  public static final Pair<Integer, Integer> b = new Pair(Integer.valueOf(1529), Integer.valueOf(2));
  public static final Pair<Integer, Integer> c = new Pair(Integer.valueOf(1201), Integer.valueOf(1));
  
  public static void a(@NonNull Pair<Integer, Integer> paramPair, @NonNull ReaderCgiListener paramReaderCgiListener)
  {
    a(paramPair, paramReaderCgiListener, false);
  }
  
  public static void a(@NonNull Pair<Integer, Integer> paramPair, @NonNull ReaderCgiListener paramReaderCgiListener, boolean paramBoolean)
  {
    paramPair = new BusinessTask("ZzConfigDataTask", paramPair);
    paramPair.a(paramReaderCgiListener, paramBoolean);
    paramPair.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.zzconfig.ZzConfigDataUtil
 * JD-Core Version:    0.7.0.1
 */