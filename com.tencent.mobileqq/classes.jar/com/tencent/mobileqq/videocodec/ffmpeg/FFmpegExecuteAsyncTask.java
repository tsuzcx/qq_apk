package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;

class FFmpegExecuteAsyncTask
  extends AsyncTask<Void, String, CommandResult>
{
  public static final String TAG = "Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask";
  public final String[] cmd;
  public final FFmpegExecuteResponseCallback ffmpegExecuteResponseHandler;
  public boolean isFFmpegExecutable = false;
  public boolean isWorkThread = false;
  public Context mContext;
  public Boolean mIsDebug = Boolean.valueOf(false);
  public Process mProcess;
  public StringBuilder output;
  public final ShellCommand shellCommand;
  public long startTime;
  public final long timeout;
  
  FFmpegExecuteAsyncTask(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.mContext = paramContext;
    this.cmd = paramArrayOfString;
    this.timeout = paramLong;
    this.isWorkThread = paramBoolean;
    this.ffmpegExecuteResponseHandler = paramFFmpegExecuteResponseCallback;
    this.shellCommand = new ShellCommand();
    this.output = new StringBuilder();
  }
  
  private void checkAndUpdateProcess()
  {
    for (;;)
    {
      if (!Util.isProcessCompleted(this.mProcess))
      {
        if ((this.timeout != 9223372036854775807L) && (SystemClock.uptimeMillis() > this.startTime + this.timeout))
        {
          QLog.i("FFmpegCmd", 1, "timeout");
          throw new TimeoutException("FFmpeg timed out");
        }
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.mProcess.getInputStream()));
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            if (isCancelled()) {
              return;
            }
            StringBuilder localStringBuilder = this.output;
            localStringBuilder.append(str);
            localStringBuilder.append("\n");
            if (this.isWorkThread)
            {
              if ((!TextUtils.isEmpty(str)) && (this.ffmpegExecuteResponseHandler != null)) {
                this.ffmpegExecuteResponseHandler.onProgress(str);
              }
            }
            else {
              publishProgress(new String[] { str });
            }
          }
        }
        catch (IOException localIOException)
        {
          QLog.i("FFmpegCmd", 1, "IOException");
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  private CommandResult getFailCommandResult()
  {
    CommandResult localCommandResult = CommandResult.getDummyFailureResponse();
    if (this.isWorkThread)
    {
      handleResult(localCommandResult);
      localCommandResult.isDone = true;
    }
    return localCommandResult;
  }
  
  private CommandResult getOutputCommandResult(Process paramProcess)
  {
    paramProcess = CommandResult.getOutputFromProcess(paramProcess);
    if (this.isWorkThread)
    {
      handleResult(paramProcess);
      paramProcess.isDone = true;
    }
    return paramProcess;
  }
  
  private void handleResult(CommandResult paramCommandResult)
  {
    if (this.ffmpegExecuteResponseHandler != null)
    {
      this.output.append(paramCommandResult.output);
      if (paramCommandResult.success) {
        this.ffmpegExecuteResponseHandler.onSuccess(this.output.toString());
      } else {
        this.ffmpegExecuteResponseHandler.onFailure(this.output.toString());
      }
      this.ffmpegExecuteResponseHandler.onFinish(paramCommandResult.success);
      if (QLog.isColorLevel())
      {
        paramCommandResult = new StringBuilder();
        paramCommandResult.append("ThreadName:");
        paramCommandResult.append(Thread.currentThread().getName());
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, paramCommandResult.toString());
      }
    }
  }
  
  /* Error */
  protected CommandResult doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:isFFmpegExecutable	Z
    //   4: ifne +24 -> 28
    //   7: aload_0
    //   8: new 214	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield 48	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mContext	Landroid/content/Context;
    //   16: invokestatic 220	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegFileUtils:getFFmpeg	(Landroid/content/Context;)Ljava/lang/String;
    //   19: invokespecial 221	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 225	com/tencent/mobileqq/videocodec/ffmpeg/Util:setFileExecutable	(Ljava/io/File;)Z
    //   25: putfield 44	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:isFFmpegExecutable	Z
    //   28: new 61	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 227
    //   39: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   48: invokestatic 232	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 9
    //   57: aload_1
    //   58: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 59	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:shellCommand	Lcom/tencent/mobileqq/videocodec/ffmpeg/ShellCommand;
    //   69: aload_0
    //   70: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   73: invokevirtual 241	com/tencent/mobileqq/videocodec/ffmpeg/ShellCommand:run	([Ljava/lang/String;)Ljava/lang/Process;
    //   76: putfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   79: aload_0
    //   80: getfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnonnull +61 -> 146
    //   88: aload_0
    //   89: invokespecial 243	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:getFailCommandResult	()Lcom/tencent/mobileqq/videocodec/ffmpeg/CommandResult;
    //   92: astore_1
    //   93: aload_0
    //   94: getfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   97: invokestatic 247	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   100: new 61	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   107: astore 4
    //   109: aload 4
    //   111: ldc 249
    //   113: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_0
    //   118: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   121: invokestatic 232	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   124: astore 5
    //   126: aload 4
    //   128: aload 5
    //   130: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: ldc 9
    //   136: aload 4
    //   138: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_1
    //   145: areturn
    //   146: aload_0
    //   147: getfield 42	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mIsDebug	Ljava/lang/Boolean;
    //   150: invokevirtual 252	java/lang/Boolean:booleanValue	()Z
    //   153: ifeq +70 -> 223
    //   156: new 61	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   163: astore 4
    //   165: aload_0
    //   166: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   169: astore 5
    //   171: aload 5
    //   173: arraylength
    //   174: istore_3
    //   175: iconst_0
    //   176: istore_2
    //   177: iload_2
    //   178: iload_3
    //   179: if_icmpge +28 -> 207
    //   182: aload 4
    //   184: aload 5
    //   186: iload_2
    //   187: aaload
    //   188: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 4
    //   194: bipush 32
    //   196: invokevirtual 255	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: iload_2
    //   201: iconst_1
    //   202: iadd
    //   203: istore_2
    //   204: goto -27 -> 177
    //   207: aload_0
    //   208: iconst_1
    //   209: anewarray 145	java/lang/String
    //   212: dup
    //   213: iconst_0
    //   214: aload 4
    //   216: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: aastore
    //   220: invokevirtual 149	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:publishProgress	([Ljava/lang/Object;)V
    //   223: aload_0
    //   224: invokespecial 257	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:checkAndUpdateProcess	()V
    //   227: aload_0
    //   228: aload_1
    //   229: invokespecial 259	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:getOutputCommandResult	(Ljava/lang/Process;)Lcom/tencent/mobileqq/videocodec/ffmpeg/CommandResult;
    //   232: astore_1
    //   233: aload_0
    //   234: getfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   237: invokestatic 247	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   240: new 61	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   247: astore 4
    //   249: aload 4
    //   251: ldc 249
    //   253: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_0
    //   258: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   261: invokestatic 232	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   264: astore 5
    //   266: goto -140 -> 126
    //   269: astore_1
    //   270: goto +132 -> 402
    //   273: astore_1
    //   274: ldc 9
    //   276: ldc_w 261
    //   279: aload_1
    //   280: invokestatic 265	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_0
    //   284: getfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   287: invokestatic 247	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   290: new 61	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   297: astore_1
    //   298: aload_1
    //   299: ldc 249
    //   301: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: aload_0
    //   307: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   310: invokestatic 232	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   313: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc 9
    //   319: aload_1
    //   320: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload_0
    //   327: invokespecial 243	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:getFailCommandResult	()Lcom/tencent/mobileqq/videocodec/ffmpeg/CommandResult;
    //   330: areturn
    //   331: astore_1
    //   332: ldc 9
    //   334: ldc 99
    //   336: aload_1
    //   337: invokestatic 265	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: new 158	com/tencent/mobileqq/videocodec/ffmpeg/CommandResult
    //   343: dup
    //   344: iconst_0
    //   345: aload_1
    //   346: invokevirtual 268	java/util/concurrent/TimeoutException:getMessage	()Ljava/lang/String;
    //   349: invokespecial 271	com/tencent/mobileqq/videocodec/ffmpeg/CommandResult:<init>	(ZLjava/lang/String;)V
    //   352: astore_1
    //   353: aload_0
    //   354: getfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   357: invokestatic 247	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   360: new 61	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   367: astore 4
    //   369: aload 4
    //   371: ldc 249
    //   373: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 4
    //   379: aload_0
    //   380: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   383: invokestatic 232	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: ldc 9
    //   392: aload 4
    //   394: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_1
    //   401: areturn
    //   402: aload_0
    //   403: getfield 70	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:mProcess	Ljava/lang/Process;
    //   406: invokestatic 247	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   409: new 61	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   416: astore 4
    //   418: aload 4
    //   420: ldc 249
    //   422: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 4
    //   428: aload_0
    //   429: getfield 50	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteAsyncTask:cmd	[Ljava/lang/String;
    //   432: invokestatic 232	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   435: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: ldc 9
    //   441: aload 4
    //   443: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 237	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: goto +5 -> 454
    //   452: aload_1
    //   453: athrow
    //   454: goto -2 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	FFmpegExecuteAsyncTask
    //   0	457	1	paramVarArgs	Void[]
    //   176	28	2	i	int
    //   174	6	3	j	int
    //   107	335	4	localStringBuilder	StringBuilder
    //   124	141	5	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	28	269	finally
    //   28	84	269	finally
    //   88	93	269	finally
    //   146	175	269	finally
    //   182	200	269	finally
    //   207	223	269	finally
    //   223	233	269	finally
    //   274	283	269	finally
    //   332	353	269	finally
    //   0	28	273	java/lang/Exception
    //   28	84	273	java/lang/Exception
    //   88	93	273	java/lang/Exception
    //   146	175	273	java/lang/Exception
    //   182	200	273	java/lang/Exception
    //   207	223	273	java/lang/Exception
    //   223	233	273	java/lang/Exception
    //   0	28	331	java/util/concurrent/TimeoutException
    //   28	84	331	java/util/concurrent/TimeoutException
    //   88	93	331	java/util/concurrent/TimeoutException
    //   146	175	331	java/util/concurrent/TimeoutException
    //   182	200	331	java/util/concurrent/TimeoutException
    //   207	223	331	java/util/concurrent/TimeoutException
    //   223	233	331	java/util/concurrent/TimeoutException
  }
  
  boolean isProcessCompleted()
  {
    return Util.isProcessCompleted(this.mProcess);
  }
  
  protected void onPostExecute(CommandResult paramCommandResult)
  {
    if (!paramCommandResult.isDone) {
      handleResult(paramCommandResult);
    }
  }
  
  protected void onPreExecute()
  {
    this.startTime = SystemClock.uptimeMillis();
    if (this.ffmpegExecuteResponseHandler != null)
    {
      if (this.isWorkThread)
      {
        ThreadManager.post(new FFmpegExecuteAsyncTask.1(this), 5, null, true);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ThreadName:");
        localStringBuilder.append(Thread.currentThread().getName());
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, localStringBuilder.toString());
      }
      this.ffmpegExecuteResponseHandler.onStart();
    }
  }
  
  protected void onProgressUpdate(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null))
    {
      FFmpegExecuteResponseCallback localFFmpegExecuteResponseCallback = this.ffmpegExecuteResponseHandler;
      if (localFFmpegExecuteResponseCallback != null) {
        localFFmpegExecuteResponseCallback.onProgress(paramVarArgs[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteAsyncTask
 * JD-Core Version:    0.7.0.1
 */