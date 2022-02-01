package com.tencent.upload.uinterface.data;

import FileUpload.UploadVideoInfoReq;
import FileUpload.UploadVideoInfoRsp;
import android.util.Log;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.util.Map;

public class VideoUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "VideoUploadTask";
  public Map<String, String> extend_info;
  public int iBusiNessType = 0;
  public int iFlag = 0;
  public int iIsFormatF20 = 0;
  public int iIsNew;
  public int iIsOriginalVideo = 0;
  public int iPlayTime = 0;
  private int iVideoH;
  private int iVideoW;
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  
  public VideoUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "video_qzone";
  }
  
  /* Error */
  private void initVideoSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/upload/uinterface/data/VideoUploadTask:uploadFilePath	Ljava/lang/String;
    //   4: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: new 72	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: getfield 64	com/tencent/upload/uinterface/data/VideoUploadTask:uploadFilePath	Ljava/lang/String;
    //   19: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 77	java/io/File:exists	()Z
    //   25: ifne +4 -> 29
    //   28: return
    //   29: new 79	android/media/MediaMetadataRetriever
    //   32: dup
    //   33: invokespecial 81	android/media/MediaMetadataRetriever:<init>	()V
    //   36: astore_3
    //   37: iconst_0
    //   38: istore_1
    //   39: aload_3
    //   40: aload_0
    //   41: getfield 64	com/tencent/upload/uinterface/data/VideoUploadTask:uploadFilePath	Ljava/lang/String;
    //   44: invokevirtual 84	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: bipush 18
    //   50: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: astore 4
    //   55: aload_3
    //   56: bipush 19
    //   58: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   61: astore 5
    //   63: aload_3
    //   64: bipush 24
    //   66: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   69: astore 6
    //   71: aload_0
    //   72: aload 4
    //   74: invokestatic 94	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   77: putfield 96	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoW	I
    //   80: aload_0
    //   81: aload 5
    //   83: invokestatic 94	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: putfield 98	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoH	I
    //   89: aload 6
    //   91: invokestatic 102	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   94: invokevirtual 106	java/lang/Integer:intValue	()I
    //   97: istore_2
    //   98: iload_2
    //   99: istore_1
    //   100: goto +43 -> 143
    //   103: astore 4
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 96	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoW	I
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 98	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoH	I
    //   115: ldc 8
    //   117: ldc 108
    //   119: aload 4
    //   121: invokestatic 114	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: goto +19 -> 143
    //   127: astore 4
    //   129: goto +45 -> 174
    //   132: astore 4
    //   134: ldc 8
    //   136: ldc 116
    //   138: aload 4
    //   140: invokestatic 114	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_3
    //   144: invokevirtual 119	android/media/MediaMetadataRetriever:release	()V
    //   147: iload_1
    //   148: sipush 180
    //   151: irem
    //   152: ifeq +21 -> 173
    //   155: aload_0
    //   156: getfield 98	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoH	I
    //   159: istore_1
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 96	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoW	I
    //   165: putfield 98	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoH	I
    //   168: aload_0
    //   169: iload_1
    //   170: putfield 96	com/tencent/upload/uinterface/data/VideoUploadTask:iVideoW	I
    //   173: return
    //   174: aload_3
    //   175: invokevirtual 119	android/media/MediaMetadataRetriever:release	()V
    //   178: aload 4
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	VideoUploadTask
    //   38	132	1	i	int
    //   97	2	2	j	int
    //   36	139	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   53	20	4	str1	String
    //   103	17	4	localNumberFormatException	java.lang.NumberFormatException
    //   127	1	4	localObject	Object
    //   132	47	4	localException	Exception
    //   61	21	5	str2	String
    //   69	21	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   71	98	103	java/lang/NumberFormatException
    //   39	71	127	finally
    //   71	98	127	finally
    //   105	124	127	finally
    //   134	143	127	finally
    //   39	71	132	java/lang/Exception
    //   71	98	132	java/lang/Exception
    //   105	124	132	java/lang/Exception
  }
  
  public byte[] buildExtra()
  {
    initVideoSize();
    UploadVideoInfoReq localUploadVideoInfoReq = new UploadVideoInfoReq();
    localUploadVideoInfoReq.sTitle = this.sTitle;
    localUploadVideoInfoReq.sDesc = this.sDesc;
    localUploadVideoInfoReq.iFlag = this.iFlag;
    localUploadVideoInfoReq.iIsNew = this.iIsNew;
    localUploadVideoInfoReq.iUploadTime = this.iUploadTime;
    localUploadVideoInfoReq.sCoverUrl = this.sCoverUrl;
    localUploadVideoInfoReq.iPlayTime = this.iPlayTime;
    byte[] arrayOfByte2 = this.vBusiNessData;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[0];
    }
    localUploadVideoInfoReq.vBusiNessData = arrayOfByte1;
    localUploadVideoInfoReq.iBusiNessType = this.iBusiNessType;
    localUploadVideoInfoReq.iIsOriginalVideo = this.iIsOriginalVideo;
    localUploadVideoInfoReq.iIsFormatF20 = this.iIsFormatF20;
    localUploadVideoInfoReq.extend_info = this.extend_info;
    localUploadVideoInfoReq.width = this.iVideoW;
    localUploadVideoInfoReq.height = this.iVideoH;
    try
    {
      arrayOfByte1 = JceEncoder.encode(localUploadVideoInfoReq);
      return arrayOfByte1;
    }
    catch (Exception localException)
    {
      UploadLog.e("VideoUploadTask", localException.toString());
    }
    return null;
  }
  
  public Const.FileType getFileType()
  {
    return Const.FileType.Video;
  }
  
  protected int getMaxNetworkRetryTimes()
  {
    return 24;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.VideoUploadTaskType;
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      UploadVideoInfoRsp localUploadVideoInfoRsp = (UploadVideoInfoRsp)JceEncoder.decode(UploadVideoInfoRsp.class, paramArrayOfByte);
      localObject1 = null;
      localObject2 = localUploadVideoInfoRsp;
    }
    catch (Exception localException)
    {
      localObject1 = Log.getStackTraceString(localException);
      UploadLog.w("VideoUploadTask", "process finish", localException);
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unpack UploadVideoInfoRsp == null. ");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("processFileUploadFinishRsp... ");
      paramArrayOfByte.append((String)localObject2);
      UploadLog.w("VideoUploadTask", paramArrayOfByte.toString());
      int i = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("(");
      paramArrayOfByte.append(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode());
      paramArrayOfByte.append(")");
      paramArrayOfByte.append(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getDesc());
      onError(i, paramArrayOfByte.toString());
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onUploadSucceed flowid = ");
    ((StringBuilder)localObject1).append(this.flowId);
    ((StringBuilder)localObject1).append(" filepath = ");
    ((StringBuilder)localObject1).append(this.mFilePath);
    UploadLog.d("VideoUploadTask", ((StringBuilder)localObject1).toString());
    localObject1 = new VideoUploadResult();
    ((VideoUploadResult)localObject1).flowId = this.flowId;
    ((VideoUploadResult)localObject1).sVid = ((UploadVideoInfoRsp)localObject2).sVid;
    ((VideoUploadResult)localObject1).iBusiNessType = ((UploadVideoInfoRsp)localObject2).iBusiNessType;
    ((VideoUploadResult)localObject1).vBusiNessData = ((UploadVideoInfoRsp)localObject2).vBusiNessData;
    onUploadSucceed(localObject1);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
  
  protected void report(int paramInt, String paramString)
  {
    super.report(paramInt, paramString);
    paramString = this.mReportObj;
    if (this.iIsNew == 1) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    paramString.source = paramInt;
    if (!this.mReported)
    {
      ReportManager.report(getReportObj());
      this.mReported = true;
    }
  }
  
  public void setIsNew(int paramInt)
  {
    this.iIsNew = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */