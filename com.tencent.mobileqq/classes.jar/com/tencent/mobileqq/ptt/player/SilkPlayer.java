package com.tencent.mobileqq.ptt.player;

import android.app.Application;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import bamg;
import bamh;
import bami;
import bdmc;
import blhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class SilkPlayer
  implements Handler.Callback, bamh
{
  private byte jdField_a_of_type_Byte = -1;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = -1L;
  private Application jdField_a_of_type_AndroidAppApplication = BaseApplicationImpl.sApplication;
  private bamg jdField_a_of_type_Bamg;
  private bami jdField_a_of_type_Bami;
  private blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  private SilkPlayer.SilkPlayerThread jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread;
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  
  public int a()
  {
    return this.e * 20;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = new SilkPlayer.SilkPlayerThread(this, this.jdField_a_of_type_AndroidAppApplication);
      if ((this.c == -1) && (this.e > 0)) {
        b(a());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread.start();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "setPlaySpeed=" + paramFloat);
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
  
  public void a(bamg parambamg)
  {
    this.jdField_a_of_type_Bamg = parambamg;
  }
  
  public void a(bami parambami)
  {
    this.jdField_a_of_type_Bami = parambami;
  }
  
  void a(Exception paramException, AudioTrack paramAudioTrack, int paramInt1, int paramInt2)
  {
    HashMap localHashMap;
    try
    {
      if ((paramException instanceof IllegalStateException))
      {
        localHashMap = new HashMap();
        if (paramAudioTrack != null)
        {
          int i = paramAudioTrack.getState();
          int j = paramAudioTrack.getPlayState();
          localHashMap.put("param_state", i + "");
          localHashMap.put("param_play_state", j + "");
        }
        if (this.jdField_a_of_type_JavaLangString != null) {
          localHashMap.put("param_filePath", this.jdField_a_of_type_JavaLangString);
        }
        localHashMap.put("param_streamType", this.jdField_a_of_type_Int + "");
        localHashMap.put("param_sampleRate", paramInt1 + "");
        localHashMap.put("param_playBufferSize", paramInt2 + "");
        localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
        localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        localHashMap.put("param_exception_detail", paramException.toString());
        paramException = new StringBuilder();
        paramAudioTrack = localHashMap.keySet().iterator();
        while (paramAudioTrack.hasNext())
        {
          String str = (String)paramAudioTrack.next();
          paramException.append(str).append(" = ").append((String)localHashMap.get(str)).append("; ");
        }
      }
      return;
    }
    catch (Throwable paramException)
    {
      QLog.e("SilkPlayer", 1, "reportIllegalStateException error.", paramException);
    }
    QLog.e("SilkPlayer", 1, "reportIllegalStateException, " + paramException.toString());
    bdmc.a(BaseApplication.getContext()).a(null, "PttSilkPlayerStateError", true, 0L, 0L, localHashMap, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread != null) && (SilkPlayer.SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    if (this.jdField_a_of_type_Bami != null) {
      this.jdField_a_of_type_Blhq.sendEmptyMessage(2);
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "seekTo=" + paramInt);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread.isAlive()))
    {
      SilkPlayer.SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    }
    this.b = -1;
    this.jdField_a_of_type_Byte = -1;
    this.d = 0;
    this.e = 0;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    if (this.jdField_a_of_type_Bami != null) {
      this.jdField_a_of_type_Blhq.sendEmptyMessage(1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_succ_flag", "0");
    localHashMap.put("errCode", paramInt + "");
    localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
    localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    bdmc.a(BaseApplication.getContext()).a(null, "PttSilkPlaryerError", true, 0L, 0L, localHashMap, null);
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Bami != null)
    {
      if (this.jdField_a_of_type_Long >= 0L) {
        break label46;
      }
      localMessage = this.jdField_a_of_type_Blhq.obtainMessage(3, Integer.valueOf(paramInt));
      this.jdField_a_of_type_Blhq.sendMessage(localMessage);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label46:
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 100L) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage(3, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Blhq.sendMessage(localMessage);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void e() {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread.isAlive()))
    {
      SilkPlayer.SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/ptt/player/SilkPlayer:b	I
    //   4: iconst_m1
    //   5: if_icmpeq +11 -> 16
    //   8: aload_0
    //   9: getfield 35	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   12: iconst_m1
    //   13: if_icmpne +67 -> 80
    //   16: new 292	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 76	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: invokespecial 294	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 35	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   34: iconst_m1
    //   35: if_icmpne +46 -> 81
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: aload_2
    //   42: invokestatic 299	bhrp:a	(Ljava/io/InputStream;)B
    //   45: putfield 35	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 31	com/tencent/mobileqq/ptt/player/SilkPlayer:b	I
    //   54: iconst_m1
    //   55: if_icmpne +17 -> 72
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 35	com/tencent/mobileqq/ptt/player/SilkPlayer:jdField_a_of_type_Byte	B
    //   65: aload_2
    //   66: invokestatic 304	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: putfield 31	com/tencent/mobileqq/ptt/player/SilkPlayer:b	I
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 307	java/io/FileInputStream:close	()V
    //   80: return
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ldc2_w 308
    //   87: invokevirtual 313	java/io/FileInputStream:skip	(J)J
    //   90: pop2
    //   91: goto -43 -> 48
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +34 -> 134
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 105
    //   107: iconst_2
    //   108: new 107	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 315
    //   118: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: ifnull -55 -> 80
    //   138: aload_2
    //   139: invokevirtual 307	java/io/FileInputStream:close	()V
    //   142: return
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 307	java/io/FileInputStream:close	()V
    //   156: aload_2
    //   157: athrow
    //   158: astore_1
    //   159: return
    //   160: astore_1
    //   161: goto -5 -> 156
    //   164: astore_2
    //   165: goto -17 -> 148
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -76 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	SilkPlayer
    //   29	76	1	localFileInputStream1	java.io.FileInputStream
    //   143	1	1	localException1	Exception
    //   147	6	1	localObject1	Object
    //   158	1	1	localException2	Exception
    //   160	1	1	localException3	Exception
    //   27	112	2	localFileInputStream2	java.io.FileInputStream
    //   145	12	2	localObject2	Object
    //   164	1	2	localObject3	Object
    //   170	1	2	localObject4	Object
    //   94	28	3	localException4	Exception
    //   168	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	94	java/lang/Exception
    //   40	48	94	java/lang/Exception
    //   50	58	94	java/lang/Exception
    //   60	72	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   138	142	143	java/lang/Exception
    //   16	28	145	finally
    //   76	80	158	java/lang/Exception
    //   152	156	160	java/lang/Exception
    //   30	38	164	finally
    //   40	48	164	finally
    //   50	58	164	finally
    //   60	72	164	finally
    //   83	91	164	finally
    //   97	103	164	finally
    //   105	134	164	finally
    //   16	28	168	java/lang/Exception
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_Bami != null) {
        this.jdField_a_of_type_Bami.a(this, 0, 0);
      }
    }
    do
    {
      do
      {
        return true;
        if (paramMessage.what != 2) {
          break;
        }
      } while (this.jdField_a_of_type_Bami == null);
      this.jdField_a_of_type_Bami.a();
      return true;
    } while ((paramMessage.what != 3) || (this.jdField_a_of_type_Bami == null));
    this.jdField_a_of_type_Bami.a(((Integer)paramMessage.obj).intValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.SilkPlayer
 * JD-Core Version:    0.7.0.1
 */