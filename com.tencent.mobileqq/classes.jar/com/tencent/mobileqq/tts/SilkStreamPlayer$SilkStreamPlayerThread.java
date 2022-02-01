package com.tencent.mobileqq.tts;

import android.app.Application;
import android.media.AudioTrack;
import bgul;
import bhhd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import javax.net.ssl.HttpsURLConnection;

class SilkStreamPlayer$SilkStreamPlayerThread
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private bgul jdField_a_of_type_Bgul;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private HttpsURLConnection jdField_a_of_type_JavaxNetSslHttpsURLConnection;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public SilkStreamPlayer$SilkStreamPlayerThread(SilkStreamPlayer paramSilkStreamPlayer, Application paramApplication, bgul parambgul, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false);
    this.jdField_a_of_type_Bgul = parambgul;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Int = bhhd.a(paramInt);
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(BaseApplicationImpl.sApplication, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(paramInt, 0, 1);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.d("SilkStreamPlayer", 1, "SILK解码器初始化失败", localIOException);
      }
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    int i;
    if (!this.jdField_c_of_type_Boolean)
    {
      i = AudioTrack.getMinBufferSize(paramInt, 4, 2);
      if (this.jdField_a_of_type_AndroidMediaAudioTrack != null)
      {
        this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
        this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
        this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
      }
      if ((this.jdField_c_of_type_Int != 1) || (this.d == 0)) {
        break label91;
      }
    }
    label91:
    for (this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, paramInt, 1, 2, i, 1, this.d);; this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, paramInt, 1, 2, i, 1))
    {
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new byte[2];
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (paramInputStream.available() > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper != null) {
          break label35;
        }
        this.jdField_a_of_type_Boolean = false;
      }
      for (;;)
      {
        paramInputStream.close();
        return;
        label35:
        if (paramInputStream.read(paramArrayOfByte, 0, 2) > 0) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("SilkStreamPlayer", 1, "SILK帧播size解析错误");
        }
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SilkStreamPlayer", 2, paramInputStream, new Object[0]);
        return;
        i = bhhd.a(paramArrayOfByte);
        if ((i >= 0) && (i <= this.jdField_a_of_type_ArrayOfByte.length)) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("SilkStreamPlayer", 1, "SILK帧size不在正确范围内");
        }
      }
    }
    catch (Exception paramInputStream)
    {
      int i;
      while (QLog.isColorLevel())
      {
        QLog.d("SilkStreamPlayer", 2, paramInputStream, new Object[0]);
        return;
        paramInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, i);
        i = this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, i, this.jdField_b_of_type_ArrayOfByte.length);
        if (i < 0)
        {
          this.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, "SILK解码器解码错误");
          }
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          i = this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_b_of_type_ArrayOfByte, 0, i);
          this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
          if (i < 0)
          {
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.e("SilkStreamPlayer", 1, "AudioTrack播放缓冲区写入错误");
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 163	bgup:a	()Lbgup;
    //   4: aload_0
    //   5: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   8: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   11: invokestatic 174	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokevirtual 177	bgup:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: putfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   20: aload_0
    //   21: getfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +273 -> 301
    //   31: iconst_1
    //   32: istore_2
    //   33: aload_0
    //   34: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   37: ifnull +17 -> 54
    //   40: aload_0
    //   41: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   44: invokevirtual 180	com/tencent/mobileqq/utils/SilkCodecWrapper:close	()V
    //   47: aload_0
    //   48: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   51: invokevirtual 182	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   59: new 184	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 8
    //   68: new 187	bguj
    //   71: dup
    //   72: aload_0
    //   73: getfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: invokespecial 190	bguj:<init>	(Ljava/io/InputStream;)V
    //   79: astore 9
    //   81: new 192	bguk
    //   84: dup
    //   85: aload 8
    //   87: invokespecial 195	bguk:<init>	(Ljava/io/OutputStream;)V
    //   90: astore 10
    //   92: iconst_1
    //   93: istore_1
    //   94: aload_0
    //   95: getfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   98: ifeq +939 -> 1037
    //   101: getstatic 65	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   104: invokestatic 201	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   107: ifne +440 -> 547
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   115: invokestatic 207	com/tencent/mobileqq/app/ThreadManagerV2:getUIHandlerV2	()Landroid/os/Handler;
    //   118: new 209	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread$2
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 212	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread$2:<init>	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread;)V
    //   126: invokevirtual 218	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   129: pop
    //   130: iconst_0
    //   131: istore_1
    //   132: iload_2
    //   133: ifne +22 -> 155
    //   136: iload_1
    //   137: ifeq +18 -> 155
    //   140: invokestatic 163	bgup:a	()Lbgup;
    //   143: aload_0
    //   144: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   147: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   150: aload 8
    //   152: invokevirtual 221	bgup:a	(Ljava/lang/String;Ljava/io/ByteArrayOutputStream;)V
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   160: aload_0
    //   161: getfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   164: ifnull +89 -> 253
    //   167: aload_0
    //   168: getfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   171: invokevirtual 224	android/media/AudioTrack:getState	()I
    //   174: ifeq +79 -> 253
    //   177: aload_0
    //   178: getfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   181: invokevirtual 94	android/media/AudioTrack:pause	()V
    //   184: aload_0
    //   185: getfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   188: invokevirtual 97	android/media/AudioTrack:flush	()V
    //   191: aload_0
    //   192: getfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   195: invokevirtual 100	android/media/AudioTrack:stop	()V
    //   198: aload_0
    //   199: getfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   202: invokevirtual 227	android/media/AudioTrack:release	()V
    //   205: aload_0
    //   206: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   209: ifnull +10 -> 219
    //   212: aload_0
    //   213: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   216: invokevirtual 182	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   219: aload 9
    //   221: invokevirtual 228	bguj:close	()V
    //   224: aload_0
    //   225: getfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   228: invokevirtual 118	java/io/InputStream:available	()I
    //   231: ifle +10 -> 241
    //   234: aload_0
    //   235: getfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   238: invokevirtual 121	java/io/InputStream:close	()V
    //   241: aload_0
    //   242: getfield 230	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaxNetSslHttpsURLConnection	Ljavax/net/ssl/HttpsURLConnection;
    //   245: invokevirtual 235	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   248: aload_0
    //   249: aconst_null
    //   250: putfield 91	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   253: aload_0
    //   254: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   257: ifnull +10 -> 267
    //   260: aload_0
    //   261: getfield 34	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   264: invokevirtual 237	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   267: aload_0
    //   268: iconst_0
    //   269: putfield 46	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_b_of_type_Boolean	Z
    //   272: aload_0
    //   273: iconst_0
    //   274: putfield 83	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_c_of_type_Boolean	Z
    //   277: aload_0
    //   278: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   281: ifnull +19 -> 300
    //   284: aload_0
    //   285: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   288: aload_0
    //   289: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   292: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   295: invokeinterface 242 2 0
    //   300: return
    //   301: iconst_3
    //   302: istore_1
    //   303: aload_0
    //   304: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   307: ifnull +12 -> 319
    //   310: aload_0
    //   311: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   314: invokeinterface 243 1 0
    //   319: aload_0
    //   320: new 245	java/net/URL
    //   323: dup
    //   324: ldc 247
    //   326: invokespecial 249	java/net/URL:<init>	(Ljava/lang/String;)V
    //   329: invokevirtual 253	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   332: checkcast 232	javax/net/ssl/HttpsURLConnection
    //   335: putfield 230	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaxNetSslHttpsURLConnection	Ljavax/net/ssl/HttpsURLConnection;
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   343: aload_0
    //   344: getfield 230	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaxNetSslHttpsURLConnection	Ljavax/net/ssl/HttpsURLConnection;
    //   347: aload_0
    //   348: getfield 38	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_c_of_type_Int	I
    //   351: invokestatic 256	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;Ljavax/net/ssl/HttpsURLConnection;I)Ljava/io/InputStream;
    //   354: putfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   357: aload_0
    //   358: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   361: ifnull +19 -> 380
    //   364: aload_0
    //   365: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   368: aload_0
    //   369: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   372: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   375: invokeinterface 258 2 0
    //   380: aload_0
    //   381: getfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   384: astore 5
    //   386: aload 5
    //   388: ifnonnull +11 -> 399
    //   391: iload_1
    //   392: iconst_1
    //   393: isub
    //   394: istore_1
    //   395: iload_1
    //   396: ifgt +651 -> 1047
    //   399: aload_0
    //   400: getfield 230	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaxNetSslHttpsURLConnection	Ljavax/net/ssl/HttpsURLConnection;
    //   403: ifnull +10 -> 413
    //   406: aload_0
    //   407: getfield 179	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   410: ifnonnull +632 -> 1042
    //   413: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq -116 -> 300
    //   419: ldc 72
    //   421: iconst_1
    //   422: ldc_w 260
    //   425: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: invokestatic 207	com/tencent/mobileqq/app/ThreadManagerV2:getUIHandlerV2	()Landroid/os/Handler;
    //   431: new 262	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread$1
    //   434: dup
    //   435: aload_0
    //   436: invokespecial 263	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread$1:<init>	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread;)V
    //   439: invokevirtual 218	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   442: pop
    //   443: return
    //   444: astore 5
    //   446: aload_0
    //   447: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   450: ifnull +19 -> 469
    //   453: aload_0
    //   454: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   457: aload_0
    //   458: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   461: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   464: invokeinterface 258 2 0
    //   469: ldc 72
    //   471: iconst_2
    //   472: aload 5
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   481: goto -82 -> 399
    //   484: astore 5
    //   486: aload_0
    //   487: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   490: ifnull +19 -> 509
    //   493: aload_0
    //   494: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   497: aload_0
    //   498: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   501: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   504: invokeinterface 258 2 0
    //   509: ldc 72
    //   511: iconst_2
    //   512: aload 5
    //   514: iconst_0
    //   515: anewarray 4	java/lang/Object
    //   518: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   521: goto -122 -> 399
    //   524: astore 5
    //   526: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq -475 -> 54
    //   532: ldc 72
    //   534: iconst_1
    //   535: aload 5
    //   537: iconst_0
    //   538: anewarray 4	java/lang/Object
    //   541: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   544: goto -490 -> 54
    //   547: aload_0
    //   548: getfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   551: ifne +8 -> 559
    //   554: iconst_0
    //   555: istore_1
    //   556: goto -424 -> 132
    //   559: iconst_0
    //   560: newarray byte
    //   562: astore 6
    //   564: aload 6
    //   566: astore 5
    //   568: aload_0
    //   569: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   572: ifnull +16 -> 588
    //   575: aload 6
    //   577: astore 5
    //   579: aload_0
    //   580: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   583: invokeinterface 243 1 0
    //   588: aload 6
    //   590: astore 5
    //   592: aload 9
    //   594: invokevirtual 268	bguj:a	()[B
    //   597: astore 7
    //   599: iload_2
    //   600: ifne +23 -> 623
    //   603: aload 7
    //   605: ifnull +18 -> 623
    //   608: aload 7
    //   610: astore 5
    //   612: aload 10
    //   614: aload 7
    //   616: iconst_0
    //   617: aload 7
    //   619: arraylength
    //   620: invokevirtual 271	bguk:b	([BII)V
    //   623: aload 7
    //   625: astore 6
    //   627: aload 7
    //   629: astore 5
    //   631: aload_0
    //   632: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   635: ifnull +27 -> 662
    //   638: aload 7
    //   640: astore 5
    //   642: aload_0
    //   643: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   646: aload_0
    //   647: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   650: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   653: invokeinterface 258 2 0
    //   658: aload 7
    //   660: astore 6
    //   662: aload 6
    //   664: ifnull +9 -> 673
    //   667: aload 6
    //   669: arraylength
    //   670: ifne +83 -> 753
    //   673: aload_0
    //   674: iconst_0
    //   675: putfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   678: aload 10
    //   680: invokevirtual 272	bguk:close	()V
    //   683: iconst_1
    //   684: istore_1
    //   685: goto -553 -> 132
    //   688: astore 6
    //   690: ldc 72
    //   692: iconst_1
    //   693: ldc_w 274
    //   696: aload 6
    //   698: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   701: aload 5
    //   703: astore 6
    //   705: aload_0
    //   706: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   709: ifnull -47 -> 662
    //   712: aload_0
    //   713: getfield 36	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Bgul	Lbgul;
    //   716: aload_0
    //   717: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   720: invokestatic 168	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;)Ljava/lang/String;
    //   723: invokeinterface 258 2 0
    //   728: aload 5
    //   730: astore 6
    //   732: goto -70 -> 662
    //   735: astore 5
    //   737: ldc 72
    //   739: iconst_1
    //   740: ldc_w 278
    //   743: aload 5
    //   745: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   748: iconst_0
    //   749: istore_1
    //   750: goto -618 -> 132
    //   753: new 280	com/tencent/mobileqq/richmedia/TtsResBody$RspBody
    //   756: dup
    //   757: invokespecial 281	com/tencent/mobileqq/richmedia/TtsResBody$RspBody:<init>	()V
    //   760: astore 5
    //   762: aload 5
    //   764: aload 6
    //   766: invokevirtual 285	com/tencent/mobileqq/richmedia/TtsResBody$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   769: pop
    //   770: aload 5
    //   772: getfield 289	com/tencent/mobileqq/richmedia/TtsResBody$RspBody:pcm_sample_rate	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   775: invokevirtual 294	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   778: istore_3
    //   779: iload_3
    //   780: ifne +45 -> 825
    //   783: aload_0
    //   784: iconst_0
    //   785: putfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   788: iconst_0
    //   789: istore_1
    //   790: goto -658 -> 132
    //   793: astore 7
    //   795: ldc 72
    //   797: iconst_1
    //   798: new 296	java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   805: ldc_w 299
    //   808: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload 6
    //   813: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: goto -52 -> 770
    //   825: aload_0
    //   826: iload_3
    //   827: invokespecial 312	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:a	(I)V
    //   830: aload_0
    //   831: iload_3
    //   832: invokespecial 314	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:b	(I)V
    //   835: aload_0
    //   836: getfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   839: ifne +8 -> 847
    //   842: iconst_0
    //   843: istore_1
    //   844: goto -712 -> 132
    //   847: aload 5
    //   849: getfield 318	com/tencent/mobileqq/richmedia/TtsResBody$RspBody:voice_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   852: invokevirtual 323	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   855: astore 7
    //   857: aload 7
    //   859: invokeinterface 328 1 0
    //   864: ifgt +28 -> 892
    //   867: aload_0
    //   868: iconst_0
    //   869: putfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   872: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   875: ifeq +162 -> 1037
    //   878: ldc 72
    //   880: iconst_1
    //   881: ldc_w 330
    //   884: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: iconst_0
    //   888: istore_1
    //   889: goto -757 -> 132
    //   892: iconst_0
    //   893: istore_3
    //   894: iload_3
    //   895: aload 7
    //   897: invokeinterface 328 1 0
    //   902: if_icmpge +109 -> 1011
    //   905: aload_0
    //   906: getfield 70	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:jdField_a_of_type_Boolean	Z
    //   909: ifeq +102 -> 1011
    //   912: aload 7
    //   914: iload_3
    //   915: invokeinterface 333 2 0
    //   920: checkcast 335	com/tencent/mobileqq/richmedia/TtsResBody$voice_item
    //   923: getfield 339	com/tencent/mobileqq/richmedia/TtsResBody$voice_item:voice	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   926: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   929: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   932: astore 6
    //   934: aload 6
    //   936: astore 5
    //   938: iload_1
    //   939: istore 4
    //   941: iload_1
    //   942: ifeq +44 -> 986
    //   945: aload 6
    //   947: astore 5
    //   949: iload_1
    //   950: istore 4
    //   952: aload_0
    //   953: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   956: aload 6
    //   958: invokestatic 352	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;[B)Z
    //   961: ifeq +25 -> 986
    //   964: aload_0
    //   965: getfield 24	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:this$0	Lcom/tencent/mobileqq/tts/SilkStreamPlayer;
    //   968: aload 6
    //   970: bipush 10
    //   972: aload 6
    //   974: arraylength
    //   975: bipush 10
    //   977: isub
    //   978: invokestatic 355	com/tencent/mobileqq/tts/SilkStreamPlayer:a	(Lcom/tencent/mobileqq/tts/SilkStreamPlayer;[BII)[B
    //   981: astore 5
    //   983: iconst_0
    //   984: istore 4
    //   986: aload_0
    //   987: new 357	java/io/ByteArrayInputStream
    //   990: dup
    //   991: aload 5
    //   993: invokespecial 360	java/io/ByteArrayInputStream:<init>	([B)V
    //   996: aload 5
    //   998: invokevirtual 362	com/tencent/mobileqq/tts/SilkStreamPlayer$SilkStreamPlayerThread:a	(Ljava/io/InputStream;[B)V
    //   1001: iload_3
    //   1002: iconst_1
    //   1003: iadd
    //   1004: istore_3
    //   1005: iload 4
    //   1007: istore_1
    //   1008: goto -114 -> 894
    //   1011: goto -917 -> 94
    //   1014: astore 5
    //   1016: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1019: ifeq -771 -> 248
    //   1022: ldc 72
    //   1024: iconst_1
    //   1025: aload 5
    //   1027: iconst_0
    //   1028: anewarray 4	java/lang/Object
    //   1031: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1034: goto -786 -> 248
    //   1037: iconst_0
    //   1038: istore_1
    //   1039: goto -907 -> 132
    //   1042: iconst_0
    //   1043: istore_2
    //   1044: goto -1011 -> 33
    //   1047: goto -744 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1050	0	this	SilkStreamPlayerThread
    //   93	946	1	i	int
    //   32	1012	2	j	int
    //   778	227	3	k	int
    //   939	67	4	m	int
    //   24	363	5	localInputStream	InputStream
    //   444	29	5	localIOException	IOException
    //   484	29	5	localException1	Exception
    //   524	12	5	localException2	Exception
    //   566	163	5	localObject1	Object
    //   735	9	5	localException3	Exception
    //   760	237	5	localObject2	Object
    //   1014	12	5	localException4	Exception
    //   562	106	6	localObject3	Object
    //   688	9	6	localException5	Exception
    //   703	270	6	localObject4	Object
    //   597	62	7	arrayOfByte	byte[]
    //   793	1	7	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   855	58	7	localList	java.util.List
    //   66	85	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   79	514	9	localbguj	bguj
    //   90	589	10	localbguk	bguk
    // Exception table:
    //   from	to	target	type
    //   0	26	444	java/io/IOException
    //   303	319	444	java/io/IOException
    //   319	380	444	java/io/IOException
    //   380	386	444	java/io/IOException
    //   0	26	484	java/lang/Exception
    //   303	319	484	java/lang/Exception
    //   319	380	484	java/lang/Exception
    //   380	386	484	java/lang/Exception
    //   40	54	524	java/lang/Exception
    //   568	575	688	java/lang/Exception
    //   579	588	688	java/lang/Exception
    //   592	599	688	java/lang/Exception
    //   612	623	688	java/lang/Exception
    //   631	638	688	java/lang/Exception
    //   642	658	688	java/lang/Exception
    //   678	683	735	java/lang/Exception
    //   762	770	793	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   177	219	1014	java/lang/Exception
    //   219	241	1014	java/lang/Exception
    //   241	248	1014	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer.SilkStreamPlayerThread
 * JD-Core Version:    0.7.0.1
 */