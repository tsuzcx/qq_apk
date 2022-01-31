import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

@TargetApi(14)
public class opi
{
  static String a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
    }
    catch (IOException paramInputStream)
    {
      SLog.c("Q.qqstory.ffmpeg.FFmpeg", "error converting input stream to string", paramInputStream);
      return null;
    }
    return paramInputStream;
  }
  
  static void a(Process paramProcess)
  {
    if (paramProcess != null) {
      paramProcess.destroy();
    }
  }
  
  public static void a(opb paramopb)
  {
    if ((paramopb != null) && (!paramopb.a()))
    {
      if (paramopb.jdField_a_of_type_JavaLangProcess != null)
      {
        paramopb.jdField_a_of_type_JavaLangProcess.destroy();
        paramopb.jdField_a_of_type_JavaLangProcess = null;
      }
      if (!paramopb.isCancelled()) {
        paramopb.cancel(true);
      }
      SLog.e("Q.qqstory.ffmpeg.FFmpeg", "kill ffmpeg task", new Object[] { Arrays.toString(paramopb.jdField_a_of_type_ArrayOfJavaLangString) });
    }
  }
  
  public static boolean a(File paramFile)
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
  
  static boolean a(Process paramProcess)
  {
    if (paramProcess == null) {}
    for (;;)
    {
      return true;
      try
      {
        paramProcess.exitValue();
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "isProcessCompleted: true  in  process.exitValue()");
          return true;
        }
      }
      catch (IllegalThreadStateException paramProcess)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "IllegalThreadStateException e, ", paramProcess);
        }
      }
    }
    return false;
  }
  
  public static Object[] a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int i = paramArrayOfObject1.length;
    int j = paramArrayOfObject2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfObject1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfObject2, 0, arrayOfObject, i, j);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opi
 * JD-Core Version:    0.7.0.1
 */