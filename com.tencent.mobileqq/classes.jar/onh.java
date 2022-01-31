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

public class onh
  extends AsyncTask
{
  public final long a;
  public Context a;
  public final FFmpegExecuteResponseCallback a;
  public Boolean a;
  public Process a;
  public StringBuilder a;
  public final onn a;
  public boolean a;
  public final String[] a;
  public long b;
  public boolean b;
  
  public onh(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    this.jdField_a_of_type_Onn = new onn();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private onb a()
  {
    onb localonb = onb.a();
    if (this.jdField_b_of_type_Boolean)
    {
      b(localonb);
      localonb.jdField_b_of_type_Boolean = true;
    }
    return localonb;
  }
  
  private onb a(Process paramProcess)
  {
    paramProcess = onb.a(paramProcess);
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramProcess);
      paramProcess.jdField_b_of_type_Boolean = true;
    }
    return paramProcess;
  }
  
  private void a()
  {
    if (!ono.a(this.jdField_a_of_type_JavaLangProcess))
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
  
  private void b(onb paramonb)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramonb.jdField_a_of_type_JavaLangString);
      if (!paramonb.jdField_a_of_type_Boolean) {
        break label92;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(paramonb.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected onb a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = ono.a(new File(onm.a(this.jdField_a_of_type_AndroidContentContext)));
      }
      SLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Onn.a(this.jdField_a_of_type_ArrayOfJavaLangString);
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
      paramVarArgs = new onb(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      SLog.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return a();
    }
    finally
    {
      ono.a(this.jdField_a_of_type_JavaLangProcess);
      SLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    }
  }
  
  protected void a(onb paramonb)
  {
    if (!paramonb.jdField_b_of_type_Boolean) {
      b(paramonb);
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
    return ono.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected void onPreExecute()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        ThreadManager.post(new oni(this), 5, null, true);
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
 * Qualified Name:     onh
 * JD-Core Version:    0.7.0.1
 */