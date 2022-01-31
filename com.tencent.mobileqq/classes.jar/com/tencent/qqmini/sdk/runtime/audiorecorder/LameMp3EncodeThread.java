package com.tencent.qqmini.sdk.runtime.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bhai;
import bhaj;
import bhak;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;

public class LameMp3EncodeThread
  extends Thread
{
  public static final String a;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 60000L;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhak jdField_a_of_type_Bhak;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 2;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "mp3";
  private int jdField_d_of_type_Int = 8000;
  private String jdField_d_of_type_JavaLangString;
  private int e = 8000;
  private int f = 1;
  private int g = 32;
  private int h = 7;
  private int i;
  
  static
  {
    jdField_a_of_type_JavaLangString = LameMp3EncodeThread.class.getName();
  }
  
  public LameMp3EncodeThread(bhak parambhak, Handler paramHandler)
  {
    super(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getString(2131694397));
    this.jdField_a_of_type_Bhak = parambhak;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    start();
  }
  
  public static File a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    File localFile;
    do
    {
      return paramString;
      localFile = new File(paramString);
      paramString = localFile;
    } while (localFile.exists());
    if (localFile.isDirectory())
    {
      localFile.mkdirs();
      return localFile;
    }
    localFile.createNewFile();
    return localFile;
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Message localMessage;
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramArrayOfByte != null))
    {
      localMessage = Message.obtain();
      localMessage.obj = paramArrayOfByte;
      localMessage.what = 6;
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (int j = 1;; j = 0)
    {
      localMessage.arg1 = j;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public int a()
  {
    return this.i;
  }
  
  public int a(int paramInt, short[] paramArrayOfShort)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      long l = 0L;
      int j = 0;
      try
      {
        while (j < paramArrayOfShort.length)
        {
          l += paramArrayOfShort[j] * paramArrayOfShort[j];
          j += 1;
        }
        paramInt = (int)(Math.log10(l / paramInt) * 10.0D) / 10;
        return paramInt - 1;
      }
      catch (Exception paramArrayOfShort)
      {
        paramArrayOfShort.printStackTrace();
      }
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    ThreadManager.a().post(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QMLog.e(jdField_a_of_type_JavaLangString, "请先关闭录音");
      return false;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new bhai(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bhaj(this));
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(bhak.b(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getString(2131694394)));
      e();
    }
    return false;
  }
  
  public void b()
  {
    e();
    c();
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    int k = 1;
    int j;
    if (TextUtils.isEmpty(paramString)) {
      j = k;
    }
    for (;;)
    {
      a(j);
      return;
      paramString = paramString.toLowerCase();
      if ("auto".equals(paramString))
      {
        j = 0;
      }
      else
      {
        j = k;
        if (!"mic".equals(paramString)) {
          if ("camcorder".equals(paramString))
          {
            j = 5;
          }
          else if ("voice_communication".equals(paramString))
          {
            j = 7;
          }
          else
          {
            j = k;
            if ("voice_recognition".equals(paramString)) {
              j = 6;
            }
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public boolean c()
  {
    return a(this.jdField_d_of_type_JavaLangString);
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      return true;
    }
    return false;
  }
  
  public void e(int paramInt)
  {
    this.g = paramInt;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return true;
    }
    return false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 151	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Boolean	Z
    //   4: ifeq +13 -> 17
    //   7: getstatic 30	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: ldc_w 275
    //   13: invokestatic 278	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 164	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: getstatic 30	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: ldc_w 280
    //   33: invokestatic 186	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: return
    //   37: getstatic 283	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:jdField_a_of_type_Boolean	Z
    //   40: ifne +42 -> 82
    //   43: aload_0
    //   44: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   47: ifnull -31 -> 16
    //   50: aload_0
    //   51: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   54: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   57: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   60: invokeinterface 48 1 0
    //   65: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: ldc_w 284
    //   71: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   74: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   77: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   80: pop
    //   81: return
    //   82: bipush 237
    //   84: invokestatic 291	android/os/Process:setThreadPriority	(I)V
    //   87: aload_0
    //   88: getfield 74	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_d_of_type_Int	I
    //   91: bipush 16
    //   93: iconst_2
    //   94: invokestatic 297	android/media/AudioRecord:getMinBufferSize	(III)I
    //   97: istore 6
    //   99: iload 6
    //   101: ifge +42 -> 143
    //   104: aload_0
    //   105: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   108: ifnull -92 -> 16
    //   111: aload_0
    //   112: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   115: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   118: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   121: invokeinterface 48 1 0
    //   126: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   129: ldc_w 298
    //   132: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   135: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   138: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   141: pop
    //   142: return
    //   143: aload_0
    //   144: getfield 74	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_d_of_type_Int	I
    //   147: iconst_2
    //   148: imul
    //   149: iconst_1
    //   150: imul
    //   151: iconst_5
    //   152: imul
    //   153: newarray short
    //   155: astore 14
    //   157: ldc2_w 299
    //   160: aload 14
    //   162: arraylength
    //   163: i2d
    //   164: ldc2_w 301
    //   167: dmul
    //   168: dadd
    //   169: d2i
    //   170: newarray byte
    //   172: astore 12
    //   174: aload_0
    //   175: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   178: ifle +1067 -> 1245
    //   181: aload_0
    //   182: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   185: newarray byte
    //   187: astore 10
    //   189: new 304	java/io/FileOutputStream
    //   192: dup
    //   193: aload_0
    //   194: getfield 164	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokestatic 306	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:a	(Ljava/lang/String;)Ljava/io/File;
    //   200: invokespecial 309	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   203: astore 11
    //   205: aload 11
    //   207: ifnonnull +138 -> 345
    //   210: getstatic 30	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   213: ldc_w 311
    //   216: invokestatic 186	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   223: ifnull -207 -> 16
    //   226: aload_0
    //   227: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   230: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   233: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   236: invokeinterface 48 1 0
    //   241: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   244: ldc_w 312
    //   247: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   250: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   253: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   256: pop
    //   257: return
    //   258: astore 8
    //   260: aload_0
    //   261: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   264: ifnull -248 -> 16
    //   267: aload_0
    //   268: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   271: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   274: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   277: invokeinterface 48 1 0
    //   282: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   285: ldc_w 313
    //   288: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   291: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   294: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   297: pop
    //   298: return
    //   299: astore 8
    //   301: aload_0
    //   302: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   305: ifnull +34 -> 339
    //   308: aload_0
    //   309: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   312: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   315: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   318: invokeinterface 48 1 0
    //   323: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   326: ldc_w 314
    //   329: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   332: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   335: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   338: pop
    //   339: aconst_null
    //   340: astore 11
    //   342: goto -137 -> 205
    //   345: aload_0
    //   346: getfield 74	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_d_of_type_Int	I
    //   349: aload_0
    //   350: getfield 78	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:f	I
    //   353: aload_0
    //   354: getfield 74	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_d_of_type_Int	I
    //   357: aload_0
    //   358: getfield 80	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:g	I
    //   361: aload_0
    //   362: getfield 82	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:h	I
    //   365: invokestatic 317	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:a	(IIIII)V
    //   368: aload_0
    //   369: iconst_1
    //   370: putfield 151	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Boolean	Z
    //   373: aload_0
    //   374: iconst_0
    //   375: putfield 178	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_b_of_type_Boolean	Z
    //   378: new 293	android/media/AudioRecord
    //   381: dup
    //   382: aload_0
    //   383: getfield 66	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Int	I
    //   386: aload_0
    //   387: getfield 74	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_d_of_type_Int	I
    //   390: bipush 16
    //   392: aload_0
    //   393: getfield 68	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_b_of_type_Int	I
    //   396: iload 6
    //   398: iconst_2
    //   399: imul
    //   400: invokespecial 319	android/media/AudioRecord:<init>	(IIIII)V
    //   403: astore 13
    //   405: aload 13
    //   407: invokevirtual 322	android/media/AudioRecord:startRecording	()V
    //   410: aload_0
    //   411: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   414: ifnull +837 -> 1251
    //   417: aload_0
    //   418: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   421: iconst_1
    //   422: invokevirtual 326	android/os/Handler:sendEmptyMessage	(I)Z
    //   425: pop
    //   426: goto +825 -> 1251
    //   429: aload_0
    //   430: getfield 151	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Boolean	Z
    //   433: ifeq +799 -> 1232
    //   436: aload_0
    //   437: getfield 178	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_b_of_type_Boolean	Z
    //   440: istore 7
    //   442: iload 7
    //   444: ifeq +61 -> 505
    //   447: iload_2
    //   448: ifne -19 -> 429
    //   451: iconst_1
    //   452: istore_2
    //   453: goto -24 -> 429
    //   456: astore 8
    //   458: aload_0
    //   459: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   462: ifnull +34 -> 496
    //   465: aload_0
    //   466: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   469: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   472: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   475: invokeinterface 48 1 0
    //   480: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   483: ldc_w 327
    //   486: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   489: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   492: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   495: pop
    //   496: invokestatic 329	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:a	()V
    //   499: aload_0
    //   500: iconst_0
    //   501: putfield 151	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Boolean	Z
    //   504: return
    //   505: iload_2
    //   506: ifeq +729 -> 1235
    //   509: iconst_0
    //   510: istore_2
    //   511: aload 13
    //   513: aload 14
    //   515: iconst_0
    //   516: iload 6
    //   518: invokevirtual 333	android/media/AudioRecord:read	([SII)I
    //   521: istore_3
    //   522: aload_0
    //   523: aload_0
    //   524: iload_3
    //   525: aload 14
    //   527: invokevirtual 335	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:a	(I[S)I
    //   530: putfield 146	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:i	I
    //   533: iload_3
    //   534: ifge +191 -> 725
    //   537: aload_0
    //   538: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   541: ifnull +691 -> 1232
    //   544: aload_0
    //   545: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   548: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   551: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   554: invokeinterface 48 1 0
    //   559: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   562: ldc_w 336
    //   565: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   568: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   571: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   574: pop
    //   575: goto +686 -> 1261
    //   578: aload_0
    //   579: aload 8
    //   581: iload 7
    //   583: invokespecial 338	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:a	([BZ)V
    //   586: iload_1
    //   587: ifle +25 -> 612
    //   590: iload_1
    //   591: newarray byte
    //   593: astore 8
    //   595: aload 10
    //   597: iconst_0
    //   598: aload 8
    //   600: iconst_0
    //   601: iload_1
    //   602: invokestatic 344	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   605: aload_0
    //   606: aload 8
    //   608: iconst_1
    //   609: invokespecial 338	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:a	([BZ)V
    //   612: aload 12
    //   614: invokestatic 347	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:a	([B)I
    //   617: istore_1
    //   618: iload_1
    //   619: ifge +41 -> 660
    //   622: aload_0
    //   623: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   626: ifnull +34 -> 660
    //   629: aload_0
    //   630: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   633: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   636: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   639: invokeinterface 48 1 0
    //   644: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   647: ldc_w 348
    //   650: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   653: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   656: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   659: pop
    //   660: iload_1
    //   661: ifeq +12 -> 673
    //   664: aload 11
    //   666: aload 12
    //   668: iconst_0
    //   669: iload_1
    //   670: invokevirtual 352	java/io/FileOutputStream:write	([BII)V
    //   673: aload 11
    //   675: invokevirtual 355	java/io/FileOutputStream:close	()V
    //   678: aload 13
    //   680: invokevirtual 356	android/media/AudioRecord:stop	()V
    //   683: aload 13
    //   685: invokevirtual 357	android/media/AudioRecord:release	()V
    //   688: invokestatic 329	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:a	()V
    //   691: aload_0
    //   692: iconst_0
    //   693: putfield 151	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Boolean	Z
    //   696: aload_0
    //   697: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   700: ifnull -684 -> 16
    //   703: aload_0
    //   704: getfield 88	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Bhak	Lbhak;
    //   707: invokevirtual 360	bhak:a	()J
    //   710: lconst_1
    //   711: lcmp
    //   712: ifle +473 -> 1185
    //   715: aload_0
    //   716: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   719: iconst_5
    //   720: invokevirtual 326	android/os/Handler:sendEmptyMessage	(I)Z
    //   723: pop
    //   724: return
    //   725: iload_3
    //   726: ifne +6 -> 732
    //   729: goto -300 -> 429
    //   732: aload 14
    //   734: aload 14
    //   736: iload_3
    //   737: aload 12
    //   739: invokestatic 363	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:a	([S[SI[B)I
    //   742: istore 5
    //   744: iload 5
    //   746: ifge +44 -> 790
    //   749: aload_0
    //   750: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   753: ifnull +479 -> 1232
    //   756: aload_0
    //   757: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   760: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   763: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   766: invokeinterface 48 1 0
    //   771: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   774: ldc_w 348
    //   777: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   780: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   783: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   786: pop
    //   787: goto +474 -> 1261
    //   790: iload_1
    //   791: istore 4
    //   793: aload 8
    //   795: astore 9
    //   797: iload 5
    //   799: ifeq +205 -> 1004
    //   802: aload 11
    //   804: aload 12
    //   806: iconst_0
    //   807: iload 5
    //   809: invokevirtual 352	java/io/FileOutputStream:write	([BII)V
    //   812: iload_1
    //   813: istore 4
    //   815: aload 8
    //   817: astore 9
    //   819: aload_0
    //   820: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   823: ifle +181 -> 1004
    //   826: aload 8
    //   828: astore 9
    //   830: aload 8
    //   832: ifnull +13 -> 845
    //   835: aload_0
    //   836: aload 8
    //   838: iconst_0
    //   839: invokespecial 338	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:a	([BZ)V
    //   842: aconst_null
    //   843: astore 9
    //   845: iconst_0
    //   846: istore_3
    //   847: iload_1
    //   848: istore 4
    //   850: iload_1
    //   851: iload 5
    //   853: iadd
    //   854: istore 5
    //   856: iload 4
    //   858: istore_1
    //   859: aload 9
    //   861: astore 8
    //   863: iload 5
    //   865: istore 4
    //   867: iload 4
    //   869: aload_0
    //   870: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   873: if_icmplt +109 -> 982
    //   876: aload_0
    //   877: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   880: newarray byte
    //   882: astore 9
    //   884: iload_1
    //   885: ifle +70 -> 955
    //   888: aload 10
    //   890: iconst_0
    //   891: aload 9
    //   893: iconst_0
    //   894: iload_1
    //   895: invokestatic 344	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   898: aload_0
    //   899: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   902: iload_1
    //   903: isub
    //   904: istore 5
    //   906: aload 12
    //   908: iconst_0
    //   909: aload 9
    //   911: iload_1
    //   912: iload 5
    //   914: invokestatic 344	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   917: iconst_0
    //   918: istore_1
    //   919: iload_3
    //   920: iload 5
    //   922: iadd
    //   923: istore_3
    //   924: iload 4
    //   926: aload_0
    //   927: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   930: isub
    //   931: istore 4
    //   933: iload 4
    //   935: aload_0
    //   936: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   939: if_icmplt +299 -> 1238
    //   942: aload_0
    //   943: aload 9
    //   945: iconst_0
    //   946: invokespecial 338	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:a	([BZ)V
    //   949: aconst_null
    //   950: astore 8
    //   952: goto -85 -> 867
    //   955: aload 12
    //   957: iload_3
    //   958: aload 9
    //   960: iconst_0
    //   961: aload_0
    //   962: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   965: invokestatic 344	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   968: aload_0
    //   969: getfield 227	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_c_of_type_Int	I
    //   972: istore 5
    //   974: iload 5
    //   976: iload_3
    //   977: iadd
    //   978: istore_3
    //   979: goto -55 -> 924
    //   982: iload 4
    //   984: ifle +30 -> 1014
    //   987: aload 12
    //   989: iload_3
    //   990: aload 10
    //   992: iload_1
    //   993: iload 4
    //   995: iload_1
    //   996: isub
    //   997: invokestatic 344	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1000: aload 8
    //   1002: astore 9
    //   1004: iload 4
    //   1006: istore_1
    //   1007: aload 9
    //   1009: astore 8
    //   1011: goto -582 -> 429
    //   1014: iconst_0
    //   1015: istore 4
    //   1017: aload 8
    //   1019: astore 9
    //   1021: goto -17 -> 1004
    //   1024: astore 8
    //   1026: aload 9
    //   1028: astore 8
    //   1030: aload_0
    //   1031: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1034: ifnull +242 -> 1276
    //   1037: aload_0
    //   1038: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1041: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1044: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   1047: invokeinterface 48 1 0
    //   1052: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1055: ldc_w 364
    //   1058: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1061: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   1064: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1067: pop
    //   1068: goto +208 -> 1276
    //   1071: astore 8
    //   1073: aload_0
    //   1074: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1077: ifnull -404 -> 673
    //   1080: aload_0
    //   1081: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1084: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1087: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   1090: invokeinterface 48 1 0
    //   1095: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1098: ldc_w 364
    //   1101: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1104: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   1107: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1110: pop
    //   1111: goto -438 -> 673
    //   1114: astore 8
    //   1116: aload 13
    //   1118: invokevirtual 356	android/media/AudioRecord:stop	()V
    //   1121: aload 13
    //   1123: invokevirtual 357	android/media/AudioRecord:release	()V
    //   1126: aload 8
    //   1128: athrow
    //   1129: astore 8
    //   1131: invokestatic 329	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3Native:a	()V
    //   1134: aload_0
    //   1135: iconst_0
    //   1136: putfield 151	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_Boolean	Z
    //   1139: aload 8
    //   1141: athrow
    //   1142: astore 8
    //   1144: aload_0
    //   1145: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1148: ifnull -470 -> 678
    //   1151: aload_0
    //   1152: getfield 90	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1155: invokestatic 38	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1158: invokevirtual 42	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   1161: invokeinterface 48 1 0
    //   1166: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1169: ldc_w 365
    //   1172: invokevirtual 61	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1175: invokestatic 286	bhak:a	(Ljava/lang/String;)Landroid/os/Message;
    //   1178: invokevirtual 143	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1181: pop
    //   1182: goto -504 -> 678
    //   1185: new 106	java/io/File
    //   1188: dup
    //   1189: aload_0
    //   1190: getfield 164	com/tencent/qqmini/sdk/runtime/audiorecorder/LameMp3EncodeThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1193: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   1196: astore 8
    //   1198: aload 8
    //   1200: invokevirtual 111	java/io/File:exists	()Z
    //   1203: ifeq -1187 -> 16
    //   1206: aload 8
    //   1208: invokevirtual 368	java/io/File:delete	()Z
    //   1211: pop
    //   1212: return
    //   1213: astore 8
    //   1215: aload 9
    //   1217: astore 8
    //   1219: goto -189 -> 1030
    //   1222: astore 9
    //   1224: goto -194 -> 1030
    //   1227: astore 9
    //   1229: goto -199 -> 1030
    //   1232: goto +29 -> 1261
    //   1235: goto -724 -> 511
    //   1238: aload 9
    //   1240: astore 8
    //   1242: goto -375 -> 867
    //   1245: aconst_null
    //   1246: astore 10
    //   1248: goto -1059 -> 189
    //   1251: iconst_0
    //   1252: istore_2
    //   1253: iconst_0
    //   1254: istore_1
    //   1255: aconst_null
    //   1256: astore 8
    //   1258: goto -829 -> 429
    //   1261: aload 8
    //   1263: ifnull -677 -> 586
    //   1266: iload_1
    //   1267: ifne +12 -> 1279
    //   1270: iconst_1
    //   1271: istore 7
    //   1273: goto -695 -> 578
    //   1276: goto -15 -> 1261
    //   1279: iconst_0
    //   1280: istore 7
    //   1282: goto -704 -> 578
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1285	0	this	LameMp3EncodeThread
    //   586	681	1	j	int
    //   447	806	2	k	int
    //   521	469	3	m	int
    //   791	225	4	n	int
    //   742	236	5	i1	int
    //   97	420	6	i2	int
    //   440	841	7	bool	boolean
    //   258	1	8	localFileNotFoundException	java.io.FileNotFoundException
    //   299	1	8	localIOException	java.io.IOException
    //   456	124	8	localIllegalStateException	java.lang.IllegalStateException
    //   593	425	8	localObject1	java.lang.Object
    //   1024	1	8	localThrowable1	java.lang.Throwable
    //   1028	1	8	localObject2	java.lang.Object
    //   1071	1	8	localThrowable2	java.lang.Throwable
    //   1114	13	8	localObject3	java.lang.Object
    //   1129	11	8	localObject4	java.lang.Object
    //   1142	1	8	localThrowable3	java.lang.Throwable
    //   1196	11	8	localFile	File
    //   1213	1	8	localThrowable4	java.lang.Throwable
    //   1217	45	8	localObject5	java.lang.Object
    //   795	421	9	localObject6	java.lang.Object
    //   1222	1	9	localThrowable5	java.lang.Throwable
    //   1227	12	9	localThrowable6	java.lang.Throwable
    //   187	1060	10	arrayOfByte1	byte[]
    //   203	600	11	localFileOutputStream	java.io.FileOutputStream
    //   172	816	12	arrayOfByte2	byte[]
    //   403	719	13	localAudioRecord	android.media.AudioRecord
    //   155	580	14	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   189	205	258	java/io/FileNotFoundException
    //   189	205	299	java/io/IOException
    //   405	410	456	java/lang/IllegalStateException
    //   888	917	1024	java/lang/Throwable
    //   955	974	1024	java/lang/Throwable
    //   664	673	1071	java/lang/Throwable
    //   410	426	1114	finally
    //   429	442	1114	finally
    //   511	533	1114	finally
    //   537	575	1114	finally
    //   578	586	1114	finally
    //   590	612	1114	finally
    //   612	618	1114	finally
    //   622	660	1114	finally
    //   664	673	1114	finally
    //   673	678	1114	finally
    //   732	744	1114	finally
    //   749	787	1114	finally
    //   802	812	1114	finally
    //   819	826	1114	finally
    //   835	842	1114	finally
    //   867	884	1114	finally
    //   888	917	1114	finally
    //   924	949	1114	finally
    //   955	974	1114	finally
    //   987	1000	1114	finally
    //   1030	1068	1114	finally
    //   1073	1111	1114	finally
    //   1144	1182	1114	finally
    //   405	410	1129	finally
    //   458	496	1129	finally
    //   678	688	1129	finally
    //   1116	1129	1129	finally
    //   673	678	1142	java/lang/Throwable
    //   924	949	1213	java/lang/Throwable
    //   867	884	1222	java/lang/Throwable
    //   987	1000	1222	java/lang/Throwable
    //   802	812	1227	java/lang/Throwable
    //   819	826	1227	java/lang/Throwable
    //   835	842	1227	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */