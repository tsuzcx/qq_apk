package cooperation.qzone.video;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;
import cooperation.qzone.util.QZLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QZoneVideoCompressor
{
  private static final String FFMPEG_BIN_FILE_NAME_PIC = "trim_process_pic";
  private static final String FFMPEG_BIN_FILE_NAME_PIE = "trim_process_pie";
  private static final String LOGTAG = "QZoneVideoCompressor";
  private static ConcurrentHashMap<String, Process> processMap = new ConcurrentHashMap(8, 0.75F, 2);
  
  public static void cancel(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QZLog.w("QZoneVideoCompressor", "cancel: key is empty!");
      return;
    }
    if (!processMap.containsKey(paramString))
    {
      QZLog.w("QZoneVideoCompressor", "cancel: process not exists or finished. key=" + paramString);
      return;
    }
    Process localProcess = (Process)processMap.remove(paramString);
    if (localProcess == null)
    {
      QZLog.w("QZoneVideoCompressor", "cancel: process == null. key=" + paramString);
      return;
    }
    QZLog.i("QZoneVideoCompressor", "cancel: killProcess. key=" + paramString);
    localProcess.destroy();
  }
  
  private static String getFFmpegPath()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()) + str;
    }
  }
  
  private static String getShortVideoSoFullPath()
  {
    return ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext()) + VideoEnvironment.getShortVideoSoLibName();
  }
  
  private static boolean setFileExecutable(File paramFile)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFile == null) || (!paramFile.exists())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramFile.canExecute());
      bool1 = bool2;
    } while (paramFile.setExecutable(true));
    return false;
  }
  
  public static int trimByFFmpeg(String paramString, String[] paramArrayOfString)
  {
    label263:
    try
    {
      setFileExecutable(new File(getFFmpegPath()));
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(getFFmpegPath());
      ((ArrayList)localObject).addAll(Arrays.asList(paramArrayOfString));
      ((ArrayList)localObject).add(getShortVideoSoFullPath());
      paramArrayOfString = new ProcessBuilder((List)localObject).redirectErrorStream(true).start();
      if (!TextUtils.isEmpty(paramString)) {
        processMap.put(paramString, paramArrayOfString);
      }
      localObject = new BufferedReader(new InputStreamReader(paramArrayOfString.getInputStream()));
      while (((BufferedReader)localObject).readLine() != null) {}
      j = paramArrayOfString.waitFor();
      i = j;
      if (!TextUtils.isEmpty(paramString))
      {
        processMap.remove(paramString);
        i = j;
      }
    }
    catch (InterruptedIOException paramArrayOfString)
    {
      for (;;)
      {
        QZLog.i("QZoneVideoCompressor", "process is terminated. key=" + paramString);
        j = 0;
        i = j;
        if (!TextUtils.isEmpty(paramString))
        {
          processMap.remove(paramString);
          i = j;
        }
      }
    }
    catch (Throwable paramArrayOfString)
    {
      for (;;)
      {
        int j = -1111;
        QZLog.e("QZoneVideoCompressor", "trimByFFmpeg", paramArrayOfString);
        int i = j;
        if (!TextUtils.isEmpty(paramString))
        {
          processMap.remove(paramString);
          i = j;
        }
      }
    }
    finally
    {
      if (TextUtils.isEmpty(paramString)) {
        break label263;
      }
      processMap.remove(paramString);
    }
    QZLog.i("QZoneVideoCompressor", 1, "trimByFFmpeg ret=" + i);
    return i;
  }
  
  public static int trimByFFmpeg(String[] paramArrayOfString)
  {
    return trimByFFmpeg(null, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QZoneVideoCompressor
 * JD-Core Version:    0.7.0.1
 */