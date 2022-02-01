package cooperation.qzone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper.IOnCompressFinish;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin;
import cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin;
import eipc.EIPCClient;

public class RecordAndChangeVoiceService
  implements IVoiceChangeHelper.IOnCompressFinish, IVoiceChangeListener
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
  private String sVCSoPath = TraeHelper.b(BaseApplicationImpl.getContext());
  public VoiceChangeBasicParams voiceChangeParams;
  
  private RecordAndChangeVoiceService()
  {
    if (TextUtils.isEmpty(this.sVCSoPath)) {
      QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
    }
  }
  
  public static RecordAndChangeVoiceService getInstance()
  {
    if (sRecordAndChangeVoiceService == null) {
      try
      {
        if (sRecordAndChangeVoiceService == null) {
          sRecordAndChangeVoiceService = new RecordAndChangeVoiceService();
        }
      }
      finally {}
    }
    return sRecordAndChangeVoiceService;
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
    //   0: new 134	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aconst_null
    //   11: astore_1
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: new 137	java/io/FileInputStream
    //   20: dup
    //   21: aload 5
    //   23: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload 4
    //   29: astore_1
    //   30: aload 5
    //   32: invokevirtual 144	java/io/File:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore_3
    //   39: aload_3
    //   40: astore_1
    //   41: aload_2
    //   42: aload_3
    //   43: invokevirtual 148	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload_2
    //   48: invokevirtual 151	java/io/FileInputStream:close	()V
    //   51: aload_3
    //   52: astore_2
    //   53: goto +84 -> 137
    //   56: astore_1
    //   57: ldc 23
    //   59: iconst_1
    //   60: aload_1
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 157	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   68: aload_3
    //   69: astore_2
    //   70: goto +67 -> 137
    //   73: astore_1
    //   74: aload_2
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: goto +70 -> 150
    //   83: astore 4
    //   85: aload_2
    //   86: astore_3
    //   87: aload_1
    //   88: astore_2
    //   89: goto +11 -> 100
    //   92: astore_2
    //   93: goto +57 -> 150
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_3
    //   101: astore_1
    //   102: ldc 23
    //   104: iconst_1
    //   105: aload 4
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 157	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   114: aload_3
    //   115: ifnull +22 -> 137
    //   118: aload_3
    //   119: invokevirtual 151	java/io/FileInputStream:close	()V
    //   122: goto +15 -> 137
    //   125: astore_1
    //   126: ldc 23
    //   128: iconst_1
    //   129: aload_1
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 157	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: ifnull +9 -> 147
    //   141: aload_2
    //   142: iconst_0
    //   143: invokestatic 163	com/tencent/smtt/utils/Base64:encodeToString	([BI)Ljava/lang/String;
    //   146: areturn
    //   147: ldc 165
    //   149: areturn
    //   150: aload_1
    //   151: ifnull +22 -> 173
    //   154: aload_1
    //   155: invokevirtual 151	java/io/FileInputStream:close	()V
    //   158: goto +15 -> 173
    //   161: astore_1
    //   162: ldc 23
    //   164: iconst_1
    //   165: aload_1
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 157	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   173: aload_2
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	RecordAndChangeVoiceService
    //   0	175	1	paramString	String
    //   26	63	2	localObject1	Object
    //   92	1	2	localObject2	Object
    //   99	75	2	arrayOfByte	byte[]
    //   13	106	3	localObject3	Object
    //   15	13	4	localObject4	Object
    //   83	1	4	localThrowable1	java.lang.Throwable
    //   96	10	4	localThrowable2	java.lang.Throwable
    //   8	23	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   47	51	56	java/lang/Exception
    //   30	39	73	finally
    //   41	47	73	finally
    //   30	39	83	java/lang/Throwable
    //   41	47	83	java/lang/Throwable
    //   17	27	92	finally
    //   102	114	92	finally
    //   17	27	96	java/lang/Throwable
    //   118	122	125	java/lang/Exception
    //   154	158	161	java/lang/Exception
  }
  
  public void getMoodVoiceData(String paramString, int paramInt, QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin)
  {
    if (TextUtils.isEmpty(this.sVCSoPath))
    {
      this.sVCSoPath = TraeHelper.b(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.sVCSoPath))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131910758), 1);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMoodVoiceData callback");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" voiceID ");
    localStringBuilder.append(paramInt);
    QZLog.d("RecordAndChangeVoiceService", 2, localStringBuilder.toString());
    this.base64Callback = paramString;
    this.mQZonePublishSecretShuoShuoH5Plugin = paramQZonePublishSecretShuoShuoH5Plugin;
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToSend(BaseApplicationImpl.getContext(), this.voiceChangeParams, this.sVCSoPath, this);
    try
    {
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).queryStateByPath(this.recordPath, this);
      return;
    }
    finally {}
  }
  
  public void getMoodVoiceRecordTime(String paramString, QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceRecordTime");
    if (this.voiceChangeParams == null) {
      return;
    }
    int i = this.currentVoiceID;
    if ((i != 0) && ((i == 0) || (this.changedVoiceTime != 0L)))
    {
      l = (this.changedVoiceTime + 500L) / 1000L;
      paramQZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceRecordTime(paramString, l);
      paramString = new StringBuilder();
      paramString.append("onReplyGetMoodVoiceRecordTime: ");
      paramString.append(l);
      QZLog.d("RecordAndChangeVoiceService", 2, paramString.toString());
      return;
    }
    long l = (this.recordTime + 500L) / 1000L;
    paramQZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceRecordTime(paramString, l);
    paramString = new StringBuilder();
    paramString.append("onReplyGetMoodVoiceRecordTime: ");
    paramString.append(l);
    QZLog.d("RecordAndChangeVoiceService", 2, paramString.toString());
  }
  
  public void onCompressFinished(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("data:audio/amr;base64,");
      localStringBuilder.append(encodeBase64File(paramString));
      paramString = new StringBuilder();
      paramString.append("base64=");
      paramString.append(localStringBuilder.toString());
      QZLog.d("RecordAndChangeVoiceService", 2, paramString.toString());
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
      this.voiceChangeParams = new VoiceChangeBasicParams(this.recordPath, i, j, k, 0);
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        QZonePublishVoiceShuoShuoH5Plugin.onNotifyH5RecordOk();
        return;
      }
      sendBroadcastSecretShuoshuoMsg(BaseApplicationImpl.getContext(), 1);
      return;
    }
    sendBroadcastSecretShuoshuoMsg(BaseApplicationImpl.getContext(), 6);
  }
  
  public void onSlicePlayed(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void playChangeVoiceAudio(int paramInt)
  {
    if (TextUtils.isEmpty(this.sVCSoPath))
    {
      this.sVCSoPath = TraeHelper.b(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.sVCSoPath))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131910757), 1);
      }
      return;
    }
    VoiceChangeBasicParams localVoiceChangeBasicParams = this.voiceChangeParams;
    if (localVoiceChangeBasicParams != null)
    {
      this.currentVoiceID = paramInt;
      localVoiceChangeBasicParams.g = paramInt;
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToStart(BaseApplicationImpl.getContext(), this.voiceChangeParams, this.sVCSoPath, this);
    }
  }
  
  public void playMoodVoice(String paramString, int paramInt, QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playMoodVoice voiceID: ");
    localStringBuilder.append(paramInt);
    QZLog.d("RecordAndChangeVoiceService", 2, localStringBuilder.toString());
    if (paramInt == 3) {
      this.changedVoiceTime = (((float)this.recordTime / 0.6F));
    } else if (paramInt == 4) {
      this.changedVoiceTime = (((float)this.recordTime * 0.5833333F));
    } else {
      this.changedVoiceTime = this.recordTime;
    }
    long l = (this.changedVoiceTime + 500L) / 1000L;
    paramQZonePublishSecretShuoShuoH5Plugin.onReplyPlayMoodVoice(paramString, l);
    paramString = new StringBuilder();
    paramString.append("onReplyPlayMoodVoice changeVoiceTime=");
    paramString.append(this.changedVoiceTime);
    paramString.append(", time = ");
    paramString.append(l);
    QZLog.d("RecordAndChangeVoiceService", 2, paramString.toString());
    playChangeVoiceAudio(paramInt);
  }
  
  public void stopPlayingMoodVoice()
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "stopPlayingMoodVoice");
    if (this.voiceChangeParams != null) {
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.voiceChangeParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.RecordAndChangeVoiceService
 * JD-Core Version:    0.7.0.1
 */