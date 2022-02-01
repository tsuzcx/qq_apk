package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class SilkPlayer
  implements Handler.Callback, IAudioFilePlayer
{
  private byte jdField_a_of_type_Byte = -1;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = -1L;
  private Application jdField_a_of_type_AndroidAppApplication = BaseApplication.getContext();
  private IAudioFileDataListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFileDataListener;
  private IAudioFilePlayerListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
  private SilkPlayer.SilkPlayerThread jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  private int c = -1;
  private int d = 0;
  private int e = 0;
  
  public int a()
  {
    return this.e * 20;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread = new SilkPlayer.SilkPlayerThread(this, this.jdField_a_of_type_AndroidAppApplication);
      if ((this.c == -1) && (this.e > 0)) {
        b(a());
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread.start();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlaySpeed=");
      localStringBuilder.append(paramFloat);
      QLog.d("SilkPlayer", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, byte paramByte)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread = null;
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramInt2;
      ((Message)localObject).obj = paramString;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
    }
    paramString = new HashMap();
    paramString.put("param_succ_flag", "0");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("");
    paramString.put("errCode", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject).append("");
    paramString.put("param_version", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    paramString.put("param_deviceName", ((StringBuilder)localObject).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSilkPlaryerError", true, 0L, 0L, paramString, null);
  }
  
  public void a(IAudioFileDataListener paramIAudioFileDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFileDataListener = paramIAudioFileDataListener;
  }
  
  public void a(IAudioFilePlayerListener paramIAudioFilePlayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener = paramIAudioFilePlayerListener;
  }
  
  void a(Exception paramException, AudioTrack paramAudioTrack, int paramInt1, int paramInt2)
  {
    try
    {
      if ((paramException instanceof IllegalStateException))
      {
        HashMap localHashMap = new HashMap();
        if (paramAudioTrack != null)
        {
          int i = paramAudioTrack.getState();
          int j = paramAudioTrack.getPlayState();
          paramAudioTrack = new StringBuilder();
          paramAudioTrack.append(i);
          paramAudioTrack.append("");
          localHashMap.put("param_state", paramAudioTrack.toString());
          paramAudioTrack = new StringBuilder();
          paramAudioTrack.append(j);
          paramAudioTrack.append("");
          localHashMap.put("param_play_state", paramAudioTrack.toString());
        }
        if (this.jdField_a_of_type_JavaLangString != null) {
          localHashMap.put("param_filePath", this.jdField_a_of_type_JavaLangString);
        }
        paramAudioTrack = new StringBuilder();
        paramAudioTrack.append(this.jdField_a_of_type_Int);
        paramAudioTrack.append("");
        localHashMap.put("param_streamType", paramAudioTrack.toString());
        paramAudioTrack = new StringBuilder();
        paramAudioTrack.append(paramInt1);
        paramAudioTrack.append("");
        localHashMap.put("param_sampleRate", paramAudioTrack.toString());
        paramAudioTrack = new StringBuilder();
        paramAudioTrack.append(paramInt2);
        paramAudioTrack.append("");
        localHashMap.put("param_playBufferSize", paramAudioTrack.toString());
        paramAudioTrack = new StringBuilder();
        paramAudioTrack.append(Build.VERSION.SDK_INT);
        paramAudioTrack.append("");
        localHashMap.put("param_version", paramAudioTrack.toString());
        paramAudioTrack = new StringBuilder();
        paramAudioTrack.append(Build.MANUFACTURER);
        paramAudioTrack.append("_");
        paramAudioTrack.append(Build.MODEL);
        localHashMap.put("param_deviceName", paramAudioTrack.toString());
        localHashMap.put("param_exception_detail", paramException.toString());
        paramException = new StringBuilder();
        paramAudioTrack = localHashMap.keySet().iterator();
        while (paramAudioTrack.hasNext())
        {
          String str = (String)paramAudioTrack.next();
          paramException.append(str);
          paramException.append(" = ");
          paramException.append((String)localHashMap.get(str));
          paramException.append("; ");
        }
        paramAudioTrack = new StringBuilder();
        paramAudioTrack.append("reportIllegalStateException, ");
        paramAudioTrack.append(paramException.toString());
        QLog.e("SilkPlayer", 1, paramAudioTrack.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSilkPlayerStateError", true, 0L, 0L, localHashMap, null);
        return;
      }
    }
    catch (Throwable paramException)
    {
      QLog.e("SilkPlayer", 1, "reportIllegalStateException error.", paramException);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    SilkPlayer.SilkPlayerThread localSilkPlayerThread = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread;
    return (localSilkPlayerThread != null) && (SilkPlayer.SilkPlayerThread.a(localSilkPlayerThread));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread = null;
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo=");
      localStringBuilder.append(paramInt);
      QLog.d("SilkPlayer", 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    SilkPlayer.SilkPlayerThread localSilkPlayerThread = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread;
    if ((localSilkPlayerThread != null) && (localSilkPlayerThread.isAlive()))
    {
      SilkPlayer.SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread = null;
    }
    this.b = -1;
    this.jdField_a_of_type_Byte = -1;
    this.d = 0;
    this.e = 0;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null)
    {
      Message localMessage;
      if (this.jdField_a_of_type_Long < 0L)
      {
        localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(3, Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 100L)
      {
        localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(3, Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    SilkPlayer.SilkPlayerThread localSilkPlayerThread = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread;
    if ((localSilkPlayerThread != null) && (localSilkPlayerThread.isAlive()))
    {
      SilkPlayer.SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerSilkPlayer$SilkPlayerThread = null;
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:b	I
    //   4: iconst_m1
    //   5: if_icmpeq +11 -> 16
    //   8: aload_0
    //   9: getfield 39	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:jdField_a_of_type_Byte	B
    //   12: iconst_m1
    //   13: if_icmpne +158 -> 171
    //   16: new 305	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 80	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 39	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:jdField_a_of_type_Byte	B
    //   34: iconst_m1
    //   35: if_icmpne +16 -> 51
    //   38: aload_1
    //   39: astore_2
    //   40: aload_0
    //   41: aload_1
    //   42: invokestatic 312	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   45: putfield 39	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:jdField_a_of_type_Byte	B
    //   48: goto +13 -> 61
    //   51: aload_1
    //   52: astore_2
    //   53: aload_1
    //   54: ldc2_w 313
    //   57: invokevirtual 318	java/io/FileInputStream:skip	(J)J
    //   60: pop2
    //   61: aload_1
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload_0
    //   66: getfield 31	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:b	I
    //   69: iconst_m1
    //   70: if_icmpne +19 -> 89
    //   73: aload_1
    //   74: astore_2
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 39	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:jdField_a_of_type_Byte	B
    //   80: aload_1
    //   81: invokestatic 321	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(BLjava/io/InputStream;)I
    //   84: putfield 31	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:b	I
    //   87: aload_1
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 324	java/io/FileInputStream:close	()V
    //   93: return
    //   94: astore_3
    //   95: goto +12 -> 107
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +72 -> 173
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +50 -> 162
    //   115: aload_1
    //   116: astore_2
    //   117: new 105	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   124: astore 4
    //   126: aload_1
    //   127: astore_2
    //   128: aload 4
    //   130: ldc_w 326
    //   133: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: aload_3
    //   142: invokevirtual 329	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: astore_2
    //   151: ldc 117
    //   153: iconst_2
    //   154: aload 4
    //   156: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_1
    //   163: ifnull +8 -> 171
    //   166: aload_1
    //   167: astore_3
    //   168: goto -79 -> 89
    //   171: return
    //   172: astore_1
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 324	java/io/FileInputStream:close	()V
    //   181: goto +5 -> 186
    //   184: aload_1
    //   185: athrow
    //   186: goto -2 -> 184
    //   189: astore_1
    //   190: return
    //   191: astore_2
    //   192: goto -11 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	SilkPlayer
    //   27	61	1	localFileInputStream1	java.io.FileInputStream
    //   98	1	1	localObject1	Object
    //   106	61	1	localObject2	Object
    //   172	13	1	localObject3	Object
    //   189	1	1	localException1	Exception
    //   29	149	2	localObject4	Object
    //   191	1	2	localException2	Exception
    //   62	28	3	localFileInputStream2	java.io.FileInputStream
    //   94	1	3	localException3	Exception
    //   104	38	3	localException4	Exception
    //   167	1	3	localObject5	Object
    //   124	31	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	38	94	java/lang/Exception
    //   40	48	94	java/lang/Exception
    //   53	61	94	java/lang/Exception
    //   65	73	94	java/lang/Exception
    //   75	87	94	java/lang/Exception
    //   16	28	98	finally
    //   16	28	104	java/lang/Exception
    //   30	38	172	finally
    //   40	48	172	finally
    //   53	61	172	finally
    //   65	73	172	finally
    //   75	87	172	finally
    //   109	115	172	finally
    //   117	126	172	finally
    //   128	137	172	finally
    //   139	149	172	finally
    //   151	162	172	finally
    //   89	93	189	java/lang/Exception
    //   177	181	191	java/lang/Exception
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    IAudioFilePlayerListener localIAudioFilePlayerListener;
    if (paramMessage.what == 1)
    {
      localIAudioFilePlayerListener = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
      if (localIAudioFilePlayerListener != null)
      {
        localIAudioFilePlayerListener.a(this, paramMessage.arg1, 0, (String)paramMessage.obj);
        return true;
      }
    }
    else if (paramMessage.what == 2)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
      if (paramMessage != null)
      {
        paramMessage.a();
        return true;
      }
    }
    else if (paramMessage.what == 3)
    {
      localIAudioFilePlayerListener = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
      if (localIAudioFilePlayerListener != null) {
        localIAudioFilePlayerListener.b(((Integer)paramMessage.obj).intValue());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.SilkPlayer
 * JD-Core Version:    0.7.0.1
 */