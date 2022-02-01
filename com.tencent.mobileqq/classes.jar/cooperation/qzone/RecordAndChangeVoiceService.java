package cooperation.qzone;

import amtj;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bgrj;
import bgrk;
import bgrn;
import bgrs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin;
import cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin;
import eipc.EIPCClient;
import mua;

public class RecordAndChangeVoiceService
  implements bgrj, bgrs
{
  public static final String ACTION_TYPE = "com.tencent.qq.syncSecretShuoshuoMsgType";
  public static final String BROADCAST_SYNC_SECRET_SHUOSHUO_MESSAGE = "com.tencent.qq.syncSecretShuoshuoMsg";
  public static final int FROM_SECRET = 0;
  public static final int FROM_VOICE_MOOD = 1;
  private static final String TAG = "RecordAndChangeVoiceService";
  private static RecordAndChangeVoiceService sRecordAndChangeVoiceService;
  private String base64Callback;
  private long changedVoiceTime;
  private int currentVoiceID;
  private QZonePublishSecretShuoShuoH5Plugin mQZonePublishSecretShuoShuoH5Plugin;
  private String recordPath;
  private long recordTime;
  private String sVCSoPath = mua.a(BaseApplicationImpl.getContext());
  public bgrk voiceChangeParams;
  
  private RecordAndChangeVoiceService()
  {
    if (TextUtils.isEmpty(this.sVCSoPath)) {
      QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
    }
  }
  
  public static RecordAndChangeVoiceService getInstance()
  {
    if (sRecordAndChangeVoiceService == null) {}
    try
    {
      if (sRecordAndChangeVoiceService == null) {
        sRecordAndChangeVoiceService = new RecordAndChangeVoiceService();
      }
      return sRecordAndChangeVoiceService;
    }
    finally {}
  }
  
  public static void sendBroadcastSecretShuoshuoMsg(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncSecretShuoshuoMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.syncSecretShuoshuoMsgType", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void cleanData()
  {
    this.recordPath = null;
    this.base64Callback = null;
    this.voiceChangeParams = null;
    this.recordTime = -1L;
    this.changedVoiceTime = -1L;
    this.currentVoiceID = -1;
    this.mQZonePublishSecretShuoShuoH5Plugin = null;
  }
  
  /* Error */
  public String encodeBase64File(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 134	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: new 137	java/io/FileInputStream
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: aload 4
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 144	java/io/File:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_1
    //   42: aload 4
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 148	java/io/FileInputStream:read	([B)I
    //   51: pop
    //   52: aload 4
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull +10 -> 66
    //   59: aload_3
    //   60: invokevirtual 151	java/io/FileInputStream:close	()V
    //   63: aload 4
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +105 -> 172
    //   70: aload_1
    //   71: iconst_0
    //   72: invokestatic 157	com/tencent/smtt/utils/Base64:encodeToString	([BI)Ljava/lang/String;
    //   75: areturn
    //   76: astore_1
    //   77: ldc 23
    //   79: iconst_1
    //   80: aload_1
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokestatic 163	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   88: aload 4
    //   90: astore_1
    //   91: goto -25 -> 66
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: ldc 23
    //   102: iconst_1
    //   103: aload 4
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 163	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull -49 -> 66
    //   118: aload_3
    //   119: invokevirtual 151	java/io/FileInputStream:close	()V
    //   122: aload_2
    //   123: astore_1
    //   124: goto -58 -> 66
    //   127: astore_1
    //   128: ldc 23
    //   130: iconst_1
    //   131: aload_1
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 163	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   139: aload_2
    //   140: astore_1
    //   141: goto -75 -> 66
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 151	java/io/FileInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: ldc 23
    //   160: iconst_1
    //   161: aload_1
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 163	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   169: goto -14 -> 155
    //   172: ldc 165
    //   174: areturn
    //   175: astore_2
    //   176: goto -29 -> 147
    //   179: astore 4
    //   181: goto -83 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	RecordAndChangeVoiceService
    //   0	184	1	paramString	String
    //   4	136	2	arrayOfByte1	byte[]
    //   144	12	2	localObject1	Object
    //   175	1	2	localObject2	Object
    //   24	95	3	localFileInputStream	java.io.FileInputStream
    //   1	88	4	arrayOfByte2	byte[]
    //   94	10	4	localThrowable1	java.lang.Throwable
    //   179	1	4	localThrowable2	java.lang.Throwable
    //   13	18	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   59	63	76	java/lang/Exception
    //   15	25	94	java/lang/Throwable
    //   118	122	127	java/lang/Exception
    //   15	25	144	finally
    //   151	155	157	java/lang/Exception
    //   30	40	175	finally
    //   45	52	175	finally
    //   100	112	175	finally
    //   30	40	179	java/lang/Throwable
    //   45	52	179	java/lang/Throwable
  }
  
  public void getMoodVoiceData(String paramString, int paramInt, QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin)
  {
    if (TextUtils.isEmpty(this.sVCSoPath))
    {
      this.sVCSoPath = mua.a(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.sVCSoPath))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131712393), 1);
      }
      return;
    }
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceData callback" + paramString + " voiceID " + paramInt);
    this.base64Callback = paramString;
    this.mQZonePublishSecretShuoShuoH5Plugin = paramQZonePublishSecretShuoShuoH5Plugin;
    bgrn.a(BaseApplicationImpl.getContext(), this.voiceChangeParams, this.sVCSoPath, this);
    bgrn.a(this.recordPath, this);
  }
  
  public void getMoodVoiceRecordTime(String paramString, QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceRecordTime");
    if (this.voiceChangeParams == null) {
      return;
    }
    if ((this.currentVoiceID == 0) || ((this.currentVoiceID != 0) && (this.changedVoiceTime == 0L)))
    {
      l = (this.recordTime + 500L) / 1000L;
      paramQZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceRecordTime(paramString, l);
      QZLog.d("RecordAndChangeVoiceService", 2, "onReplyGetMoodVoiceRecordTime: " + l);
      return;
    }
    long l = (this.changedVoiceTime + 500L) / 1000L;
    paramQZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceRecordTime(paramString, l);
    QZLog.d("RecordAndChangeVoiceService", 2, "onReplyGetMoodVoiceRecordTime: " + l);
  }
  
  public void onCompressFinished(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("data:audio/amr;base64,");
      localStringBuilder.append(encodeBase64File(paramString));
      QZLog.d("RecordAndChangeVoiceService", 2, "base64=" + localStringBuilder.toString());
      this.mQZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceData(this.base64Callback, localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onError() {}
  
  public void onPlayEnd() {}
  
  public void onPlayStop() {}
  
  public void onReceiveRecordData(Intent paramIntent, int paramInt)
  {
    this.currentVoiceID = 0;
    this.changedVoiceTime = 0L;
    this.recordPath = paramIntent.getStringExtra("key_record_path");
    this.recordTime = paramIntent.getLongExtra("key_record_time", 0L);
    int i = paramIntent.getIntExtra("key_record_param_sample_rate", 0);
    int j = paramIntent.getIntExtra("key_record_param_bit_rate", 0);
    int k = paramIntent.getIntExtra("key_record_param_audio_type", 0);
    if ((!TextUtils.isEmpty(this.recordPath)) && (this.recordTime > 0L))
    {
      this.voiceChangeParams = new bgrk(this.recordPath, i, j, k, 0);
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        sendBroadcastSecretShuoshuoMsg(BaseApplicationImpl.getContext(), 1);
        return;
      }
      QZonePublishVoiceShuoShuoH5Plugin.onNotifyH5RecordOk();
      return;
    }
    sendBroadcastSecretShuoshuoMsg(BaseApplicationImpl.getContext(), 6);
  }
  
  public void onSlicePlayed(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void playChangeVoiceAudio(int paramInt)
  {
    if (TextUtils.isEmpty(this.sVCSoPath))
    {
      this.sVCSoPath = mua.a(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.sVCSoPath))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131712392), 1);
      }
    }
    while (this.voiceChangeParams == null) {
      return;
    }
    this.currentVoiceID = paramInt;
    this.voiceChangeParams.f = paramInt;
    bgrn.b(BaseApplicationImpl.getContext(), this.voiceChangeParams, this.sVCSoPath, this);
  }
  
  public void playMoodVoice(String paramString, int paramInt, QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "playMoodVoice voiceID: " + paramInt);
    if (paramInt == 3) {
      this.changedVoiceTime = (((float)this.recordTime / 0.6F));
    }
    for (;;)
    {
      long l = (this.changedVoiceTime + 500L) / 1000L;
      paramQZonePublishSecretShuoShuoH5Plugin.onReplyPlayMoodVoice(paramString, l);
      QZLog.d("RecordAndChangeVoiceService", 2, "onReplyPlayMoodVoice changeVoiceTime=" + this.changedVoiceTime + ", time = " + l);
      playChangeVoiceAudio(paramInt);
      return;
      if (paramInt == 4) {
        this.changedVoiceTime = (((float)this.recordTime * 0.5833333F));
      } else {
        this.changedVoiceTime = this.recordTime;
      }
    }
  }
  
  public void stopPlayingMoodVoice()
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "stopPlayingMoodVoice");
    if (this.voiceChangeParams != null) {
      bgrn.b(this.voiceChangeParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.RecordAndChangeVoiceService
 * JD-Core Version:    0.7.0.1
 */