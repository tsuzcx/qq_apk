import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class opb
  extends AsyncTask
{
  public final long a;
  public Context a;
  public final FFmpegExecuteResponseCallback a;
  public Boolean a;
  public Process a;
  public StringBuilder a;
  public final oph a;
  public boolean a;
  public final String[] a;
  public long b;
  public boolean b;
  
  public opb(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    this.jdField_a_of_type_Oph = new oph();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private oov a()
  {
    oov localoov = oov.a();
    if (this.jdField_b_of_type_Boolean)
    {
      b(localoov);
      localoov.jdField_b_of_type_Boolean = true;
    }
    return localoov;
  }
  
  private oov a(Process paramProcess)
  {
    paramProcess = oov.a(paramProcess);
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramProcess);
      paramProcess.jdField_b_of_type_Boolean = true;
    }
    return paramProcess;
  }
  
  private void a()
  {
    if (!opi.a(this.jdField_a_of_type_JavaLangProcess))
    {
      if ((this.jdField_a_of_type_Long != 9223372036854775807L) && (SystemClock.uptimeMillis() > this.jdField_b_of_type_Long + this.jdField_a_of_type_Long)) {
        throw new TimeoutException("FFmpeg timed out");
      }
      for (;;)
      {
        String str;
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.jdField_a_of_type_JavaLangProcess.getInputStream()));
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (isCancelled()) {
            return;
          }
          this.jdField_a_of_type_JavaLangStringBuilder.append(str).append("\n");
          if (this.jdField_b_of_type_Boolean)
          {
            if ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.c(str);
            continue;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        publishProgress(new String[] { str });
      }
    }
  }
  
  private void b(oov paramoov)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramoov.jdField_a_of_type_JavaLangString);
      if (!paramoov.jdField_a_of_type_Boolean) {
        break label92;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(paramoov.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected oov a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = opi.a(new File(opg.a(this.jdField_a_of_type_AndroidContentContext)));
      }
      SLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Oph.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      paramVarArgs = this.jdField_a_of_type_JavaLangProcess;
      if (paramVarArgs == null)
      {
        paramVarArgs = a();
        return paramVarArgs;
      }
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        while (i < j)
        {
          localStringBuilder.append(arrayOfString[i]);
          localStringBuilder.append(' ');
          i += 1;
        }
        publishProgress(new String[] { localStringBuilder.toString() });
      }
      a();
      paramVarArgs = a(paramVarArgs);
      return paramVarArgs;
    }
    catch (TimeoutException paramVarArgs)
    {
      SLog.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new oov(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      SLog.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return a();
    }
    finally
    {
      opi.a(this.jdField_a_of_type_JavaLangProcess);
      SLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    }
  }
  
  protected void a(oov paramoov)
  {
    if (!paramoov.jdField_b_of_type_Boolean) {
      b(paramoov);
    }
  }
  
  protected void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.c(paramVarArgs[0]);
    }
  }
  
  public boolean a()
  {
    return opi.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected void onPreExecute()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        ThreadManager.post(new opc(this), 5, null, true);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opb
 * JD-Core Version:    0.7.0.1
 */