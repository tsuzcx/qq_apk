package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.media.AudioTrack;
import android.text.TextUtils;
import bddl;
import bppl;
import bpqa;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AudioDecoder$AudioPlayRunnable
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public boolean a;
  private float jdField_b_of_type_Float;
  private volatile int jdField_b_of_type_Int = -1;
  public boolean b;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int e;
  
  public AudioDecoder$AudioPlayRunnable(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  /* Error */
  private AudioTrack a()
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   6: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   9: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   12: getfield 54	bddl:e	I
    //   15: iconst_1
    //   16: if_icmpne +111 -> 127
    //   19: iconst_4
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   25: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   28: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   31: getfield 55	bddl:jdField_b_of_type_Int	I
    //   34: bipush 16
    //   36: if_icmpne +5 -> 41
    //   39: iconst_2
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   45: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   48: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   51: getfield 57	bddl:jdField_d_of_type_Int	I
    //   54: iload_1
    //   55: iload_2
    //   56: invokestatic 63	android/media/AudioTrack:getMinBufferSize	(III)I
    //   59: istore_3
    //   60: new 59	android/media/AudioTrack
    //   63: dup
    //   64: iconst_3
    //   65: aload_0
    //   66: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   69: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   72: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   75: getfield 57	bddl:jdField_d_of_type_Int	I
    //   78: iload_1
    //   79: iload_2
    //   80: iload_3
    //   81: iconst_1
    //   82: invokespecial 66	android/media/AudioTrack:<init>	(IIIIII)V
    //   85: astore 4
    //   87: aload 4
    //   89: aload_0
    //   90: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   93: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   96: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   99: getfield 67	bddl:jdField_a_of_type_Float	F
    //   102: aload_0
    //   103: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   106: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   109: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   112: getfield 67	bddl:jdField_a_of_type_Float	F
    //   115: invokevirtual 71	android/media/AudioTrack:setStereoVolume	(FF)I
    //   118: pop
    //   119: aload 4
    //   121: invokevirtual 74	android/media/AudioTrack:play	()V
    //   124: aload 4
    //   126: areturn
    //   127: bipush 12
    //   129: istore_1
    //   130: goto -109 -> 21
    //   133: astore 5
    //   135: aconst_null
    //   136: astore 4
    //   138: ldc 76
    //   140: iconst_4
    //   141: ldc 78
    //   143: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload 5
    //   148: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   151: aload 4
    //   153: areturn
    //   154: astore 5
    //   156: goto -18 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	AudioPlayRunnable
    //   20	110	1	i	int
    //   1	79	2	j	int
    //   59	22	3	k	int
    //   85	67	4	localAudioTrack	AudioTrack
    //   133	14	5	localThrowable1	Throwable
    //   154	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	19	133	java/lang/Throwable
    //   21	39	133	java/lang/Throwable
    //   41	87	133	java/lang/Throwable
    //   87	124	154	java/lang/Throwable
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    QLog.d("AudioDecoder", 4, "begin playAudio");
    Object localObject2 = null;
    Object localObject1 = null;
    AudioTrack localAudioTrack;
    int i;
    try
    {
      localAudioTrack = a();
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      k = AudioTrack.getMinBufferSize(localAudioTrack.getSampleRate(), localAudioTrack.getChannelConfiguration(), localAudioTrack.getAudioFormat());
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      arrayOfByte = new byte[k * 2];
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      this.jdField_a_of_type_Boolean = false;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        int k;
        byte[] arrayOfByte;
        int m;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        int j = bpqa.a(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = bpqa.a(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2, 2);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = bpqa.b(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = bpqa.a(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2, 4);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = bpqa.c(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2);
        i = 0;
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label886;
      }
      localObject2.release();
    }
    localObject1 = localAudioTrack;
    localObject2 = localAudioTrack;
    if (this.jdField_a_of_type_Int < paramArrayOfByte.length)
    {
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.jdField_c_of_type_Float != -1.0F)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = (int)(this.jdField_c_of_type_Float * this.e / this.jdField_b_of_type_Float);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          m = j % this.this$0.a.jdField_a_of_type_Bddl.jdField_b_of_type_Int;
          i = j;
          if (m != 0)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            i = j + (this.this$0.a.jdField_a_of_type_Bddl.jdField_b_of_type_Int - m);
          }
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          this.jdField_a_of_type_Int = (i - this.jdField_c_of_type_Int);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          localAudioTrack.flush();
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          this.jdField_c_of_type_Float = -1.0F;
        }
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        switch (this.this$0.a.jdField_a_of_type_Int)
        {
        case 1: 
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = Math.min(paramArrayOfByte.length - this.jdField_a_of_type_Int, k * 2);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          if (!this.this$0.a.jdField_b_of_type_Boolean)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            localAudioTrack.write(paramArrayOfByte, this.jdField_a_of_type_Int, j);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if ((!this.this$0.a.jdField_b_of_type_Boolean) && (i == 0))
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        localAudioTrack.write(arrayOfByte, 0, k * 2);
      }
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      this.jdField_a_of_type_Int += j;
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if (this.jdField_a_of_type_Int >= paramArrayOfByte.length)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.this$0.a.jdField_a_of_type_Boolean)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          if (this.this$0.a.jdField_a_of_type_Int != 3)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
          }
        }
      }
      label886:
      do
      {
        boolean bool;
        Object localObject3;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        localAudioTrack.stop();
      } while (localAudioTrack == null);
      localAudioTrack.release();
      return;
      break;
      i = 1;
    }
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 178	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   12: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   15: getfield 181	bppl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 187	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 110	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 110	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   48: aload_0
    //   49: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   52: aload_0
    //   53: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   59: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   62: getfield 55	bddl:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +29 -> 97
    //   71: aload_0
    //   72: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   75: istore_2
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   81: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   84: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   87: getfield 55	bddl:jdField_b_of_type_Int	I
    //   90: iload_1
    //   91: isub
    //   92: iload_2
    //   93: iadd
    //   94: putfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   97: aload_0
    //   98: getfield 36	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +160 -> 263
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 110	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   111: putfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   114: ldc 76
    //   116: iconst_4
    //   117: new 190	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   124: ldc 193
    //   126: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   133: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 202
    //   138: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   145: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   158: aload_0
    //   159: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   162: isub
    //   163: newarray byte
    //   165: astore 6
    //   167: new 208	java/io/FileInputStream
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 7
    //   178: aload 7
    //   180: ifnull +41 -> 221
    //   183: aload 7
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   191: ifeq +18 -> 209
    //   194: aload 7
    //   196: astore 5
    //   198: aload 7
    //   200: aload_0
    //   201: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   204: i2l
    //   205: invokevirtual 215	java/io/FileInputStream:skip	(J)J
    //   208: pop2
    //   209: aload 7
    //   211: astore 5
    //   213: aload 7
    //   215: aload 6
    //   217: invokevirtual 219	java/io/FileInputStream:read	([B)I
    //   220: pop
    //   221: aload 7
    //   223: ifnull +8 -> 231
    //   226: aload 7
    //   228: invokevirtual 222	java/io/FileInputStream:close	()V
    //   231: ldc 76
    //   233: iconst_4
    //   234: new 190	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   241: ldc 224
    //   243: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   249: lload_3
    //   250: lsub
    //   251: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 6
    //   262: areturn
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 110	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   268: i2f
    //   269: aload_0
    //   270: getfield 36	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   273: fmul
    //   274: f2i
    //   275: putfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   278: aload_0
    //   279: getfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   282: aload_0
    //   283: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   286: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   289: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   292: getfield 55	bddl:jdField_b_of_type_Int	I
    //   295: irem
    //   296: istore_1
    //   297: iload_1
    //   298: ifeq -184 -> 114
    //   301: aload_0
    //   302: getfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   314: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   317: getfield 55	bddl:jdField_b_of_type_Int	I
    //   320: iload_1
    //   321: isub
    //   322: iload_2
    //   323: iadd
    //   324: putfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   327: goto -213 -> 114
    //   330: astore 6
    //   332: ldc 76
    //   334: iconst_4
    //   335: ldc 229
    //   337: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: getstatic 235	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   343: ifnull +9 -> 352
    //   346: getstatic 235	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   349: invokevirtual 240	android/support/v4/util/MQLruCache:evictAll	()V
    //   352: aload_0
    //   353: getfield 188	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   356: aload_0
    //   357: getfield 112	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   360: isub
    //   361: newarray byte
    //   363: astore 6
    //   365: goto -198 -> 167
    //   368: astore 5
    //   370: aload 5
    //   372: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   375: goto -144 -> 231
    //   378: astore 8
    //   380: aconst_null
    //   381: astore 6
    //   383: aload 6
    //   385: astore 5
    //   387: ldc 76
    //   389: iconst_4
    //   390: ldc 147
    //   392: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload 6
    //   397: astore 5
    //   399: aload 8
    //   401: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   404: aload 6
    //   406: ifnull +8 -> 414
    //   409: aload 6
    //   411: invokevirtual 222	java/io/FileInputStream:close	()V
    //   414: aconst_null
    //   415: areturn
    //   416: astore 5
    //   418: aload 5
    //   420: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   423: goto -9 -> 414
    //   426: astore 6
    //   428: aconst_null
    //   429: astore 5
    //   431: aload 5
    //   433: ifnull +8 -> 441
    //   436: aload 5
    //   438: invokevirtual 222	java/io/FileInputStream:close	()V
    //   441: aload 6
    //   443: athrow
    //   444: astore 5
    //   446: aload 5
    //   448: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   451: goto -10 -> 441
    //   454: astore 6
    //   456: goto -25 -> 431
    //   459: astore 8
    //   461: aload 7
    //   463: astore 6
    //   465: goto -82 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	AudioPlayRunnable
    //   66	256	1	i	int
    //   75	249	2	j	int
    //   3	247	3	l	long
    //   21	191	5	localObject1	Object
    //   368	3	5	localIOException1	java.io.IOException
    //   385	13	5	localObject2	Object
    //   416	3	5	localIOException2	java.io.IOException
    //   429	8	5	localObject3	Object
    //   444	3	5	localIOException3	java.io.IOException
    //   165	96	6	arrayOfByte1	byte[]
    //   330	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   363	47	6	arrayOfByte2	byte[]
    //   426	16	6	localObject4	Object
    //   454	1	6	localObject5	Object
    //   463	1	6	localObject6	Object
    //   176	286	7	localFileInputStream	java.io.FileInputStream
    //   378	22	8	localThrowable1	Throwable
    //   459	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   154	167	330	java/lang/OutOfMemoryError
    //   226	231	368	java/io/IOException
    //   167	178	378	java/lang/Throwable
    //   409	414	416	java/io/IOException
    //   167	178	426	finally
    //   436	441	444	java/io/IOException
    //   187	194	454	finally
    //   198	209	454	finally
    //   213	221	454	finally
    //   387	395	454	finally
    //   399	404	454	finally
    //   187	194	459	java/lang/Throwable
    //   198	209	459	java/lang/Throwable
    //   213	221	459	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 76
    //   2: iconst_4
    //   3: ldc 246
    //   5: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   11: lstore 14
    //   13: aconst_null
    //   14: astore 25
    //   16: aconst_null
    //   17: astore 20
    //   19: aconst_null
    //   20: astore 18
    //   22: new 248	android/media/MediaExtractor
    //   25: dup
    //   26: invokespecial 249	android/media/MediaExtractor:<init>	()V
    //   29: astore 26
    //   31: aconst_null
    //   32: astore 24
    //   34: aconst_null
    //   35: astore 23
    //   37: aconst_null
    //   38: astore 22
    //   40: aload 24
    //   42: astore 21
    //   44: aload 25
    //   46: astore 17
    //   48: aload 20
    //   50: astore 19
    //   52: aload 26
    //   54: aload_1
    //   55: invokevirtual 252	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   58: lconst_0
    //   59: lstore 10
    //   61: lconst_0
    //   62: lstore 8
    //   64: iconst_0
    //   65: istore_3
    //   66: aload 24
    //   68: astore 21
    //   70: aload 25
    //   72: astore 17
    //   74: aload 20
    //   76: astore 19
    //   78: iload_3
    //   79: aload 26
    //   81: invokevirtual 255	android/media/MediaExtractor:getTrackCount	()I
    //   84: if_icmpge +1860 -> 1944
    //   87: aload 24
    //   89: astore 21
    //   91: aload 25
    //   93: astore 17
    //   95: aload 20
    //   97: astore 19
    //   99: aload 26
    //   101: iload_3
    //   102: invokevirtual 259	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   105: astore 27
    //   107: aload 24
    //   109: astore 21
    //   111: aload 25
    //   113: astore 17
    //   115: aload 20
    //   117: astore 19
    //   119: aload 27
    //   121: ldc_w 261
    //   124: invokevirtual 267	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 28
    //   129: aload 24
    //   131: astore 21
    //   133: aload 25
    //   135: astore 17
    //   137: aload 20
    //   139: astore 19
    //   141: aload_0
    //   142: aload 27
    //   144: ldc_w 269
    //   147: invokevirtual 273	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   150: putfield 275	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   153: aload 24
    //   155: astore 21
    //   157: aload 25
    //   159: astore 17
    //   161: aload 20
    //   163: astore 19
    //   165: aload_0
    //   166: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Float	F
    //   169: aload_0
    //   170: getfield 275	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   173: l2f
    //   174: fmul
    //   175: f2l
    //   176: lstore 10
    //   178: aload 24
    //   180: astore 21
    //   182: aload 25
    //   184: astore 17
    //   186: aload 20
    //   188: astore 19
    //   190: aload_0
    //   191: getfield 36	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   194: aload_0
    //   195: getfield 275	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   198: l2f
    //   199: fmul
    //   200: f2l
    //   201: lstore 12
    //   203: lload 12
    //   205: lstore 8
    //   207: lload 12
    //   209: lconst_0
    //   210: lcmp
    //   211: ifne +21 -> 232
    //   214: aload 24
    //   216: astore 21
    //   218: aload 25
    //   220: astore 17
    //   222: aload 20
    //   224: astore 19
    //   226: aload_0
    //   227: getfield 275	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   230: lstore 8
    //   232: aload 24
    //   234: astore 21
    //   236: aload 25
    //   238: astore 17
    //   240: aload 20
    //   242: astore 19
    //   244: aload 28
    //   246: ldc_w 277
    //   249: invokevirtual 283	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   252: ifeq +501 -> 753
    //   255: aload 24
    //   257: astore 21
    //   259: aload 25
    //   261: astore 17
    //   263: aload 20
    //   265: astore 19
    //   267: aload 26
    //   269: iload_3
    //   270: invokevirtual 287	android/media/MediaExtractor:selectTrack	(I)V
    //   273: lload 10
    //   275: lconst_0
    //   276: lcmp
    //   277: ifle +23 -> 300
    //   280: aload 24
    //   282: astore 21
    //   284: aload 25
    //   286: astore 17
    //   288: aload 20
    //   290: astore 19
    //   292: aload 26
    //   294: lload 10
    //   296: iconst_0
    //   297: invokevirtual 291	android/media/MediaExtractor:seekTo	(JI)V
    //   300: aload 24
    //   302: astore 21
    //   304: aload 25
    //   306: astore 17
    //   308: aload 20
    //   310: astore 19
    //   312: aload 28
    //   314: invokestatic 297	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   317: astore 20
    //   319: aload 20
    //   321: astore 18
    //   323: aload 24
    //   325: astore 21
    //   327: aload 20
    //   329: astore 17
    //   331: aload 20
    //   333: astore 19
    //   335: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +101 -> 439
    //   341: aload 20
    //   343: astore 18
    //   345: aload 24
    //   347: astore 21
    //   349: aload 20
    //   351: astore 17
    //   353: aload 20
    //   355: astore 19
    //   357: ldc 76
    //   359: iconst_4
    //   360: new 190	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 299
    //   370: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_0
    //   374: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   377: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   380: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   383: getfield 300	bddl:jdField_c_of_type_Int	I
    //   386: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc_w 302
    //   392: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   399: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   402: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   405: getfield 54	bddl:e	I
    //   408: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: ldc_w 304
    //   414: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   421: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   424: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   427: getfield 57	bddl:jdField_d_of_type_Int	I
    //   430: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload 24
    //   441: astore 21
    //   443: aload 20
    //   445: astore 17
    //   447: aload 20
    //   449: astore 19
    //   451: aload_0
    //   452: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   455: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   458: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   461: aload 27
    //   463: aload_1
    //   464: invokestatic 309	zdm:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   467: putfield 54	bddl:e	I
    //   470: aload 24
    //   472: astore 21
    //   474: aload 20
    //   476: astore 17
    //   478: aload 20
    //   480: astore 19
    //   482: aload_0
    //   483: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   486: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   489: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   492: aload 27
    //   494: invokestatic 312	zdm:a	(Landroid/media/MediaFormat;)I
    //   497: putfield 57	bddl:jdField_d_of_type_Int	I
    //   500: aload 20
    //   502: astore 18
    //   504: aload 24
    //   506: astore 21
    //   508: aload 20
    //   510: astore 17
    //   512: aload 20
    //   514: astore 19
    //   516: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +101 -> 620
    //   522: aload 20
    //   524: astore 18
    //   526: aload 24
    //   528: astore 21
    //   530: aload 20
    //   532: astore 17
    //   534: aload 20
    //   536: astore 19
    //   538: ldc 76
    //   540: iconst_4
    //   541: new 190	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   548: ldc_w 314
    //   551: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload_0
    //   555: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   558: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   561: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   564: getfield 300	bddl:jdField_c_of_type_Int	I
    //   567: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   570: ldc_w 302
    //   573: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload_0
    //   577: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   580: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   583: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   586: getfield 54	bddl:e	I
    //   589: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc_w 304
    //   595: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_0
    //   599: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   602: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   605: getfield 50	bppl:jdField_a_of_type_Bddl	Lbddl;
    //   608: getfield 57	bddl:jdField_d_of_type_Int	I
    //   611: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   614: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: aload 20
    //   622: astore 18
    //   624: aload 24
    //   626: astore 21
    //   628: aload 20
    //   630: astore 17
    //   632: aload 20
    //   634: astore 19
    //   636: aload 20
    //   638: aload 27
    //   640: aconst_null
    //   641: aconst_null
    //   642: iconst_0
    //   643: invokevirtual 318	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   646: aload 20
    //   648: astore 17
    //   650: aload 17
    //   652: ifnonnull +122 -> 774
    //   655: ldc 76
    //   657: iconst_2
    //   658: ldc_w 320
    //   661: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aconst_null
    //   665: astore_1
    //   666: aload 17
    //   668: ifnull +13 -> 681
    //   671: aload 17
    //   673: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   676: aload 17
    //   678: invokevirtual 322	android/media/MediaCodec:release	()V
    //   681: aload 26
    //   683: ifnull +8 -> 691
    //   686: aload 26
    //   688: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   691: iconst_0
    //   692: ifeq +11 -> 703
    //   695: new 325	java/lang/NullPointerException
    //   698: dup
    //   699: invokespecial 326	java/lang/NullPointerException:<init>	()V
    //   702: athrow
    //   703: aload_1
    //   704: areturn
    //   705: astore_1
    //   706: aload 20
    //   708: astore 18
    //   710: aload 24
    //   712: astore 21
    //   714: aload 20
    //   716: astore 17
    //   718: aload 20
    //   720: astore 19
    //   722: aload_1
    //   723: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   726: goto -226 -> 500
    //   729: astore_1
    //   730: aload 24
    //   732: astore 21
    //   734: aload 18
    //   736: astore 17
    //   738: aload 18
    //   740: astore 19
    //   742: aload_1
    //   743: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   746: aload 18
    //   748: astore 17
    //   750: goto -100 -> 650
    //   753: iload_3
    //   754: iconst_1
    //   755: iadd
    //   756: istore_3
    //   757: goto -691 -> 66
    //   760: astore_1
    //   761: ldc 76
    //   763: iconst_1
    //   764: aload_1
    //   765: iconst_0
    //   766: anewarray 4	java/lang/Object
    //   769: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   772: aconst_null
    //   773: areturn
    //   774: aload 17
    //   776: invokevirtual 332	android/media/MediaCodec:start	()V
    //   779: aload 17
    //   781: invokevirtual 336	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   784: astore 20
    //   786: aload 17
    //   788: invokevirtual 339	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   791: astore_1
    //   792: new 341	android/media/MediaCodec$BufferInfo
    //   795: dup
    //   796: invokespecial 342	android/media/MediaCodec$BufferInfo:<init>	()V
    //   799: astore 21
    //   801: iconst_0
    //   802: istore 4
    //   804: iload_2
    //   805: ifeq +371 -> 1176
    //   808: aload_0
    //   809: invokespecial 95	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	()Landroid/media/AudioTrack;
    //   812: astore 18
    //   814: aconst_null
    //   815: astore 19
    //   817: iconst_0
    //   818: istore 7
    //   820: iconst_0
    //   821: istore_3
    //   822: iload 7
    //   824: ifne +908 -> 1732
    //   827: iload 4
    //   829: ifne +1129 -> 1958
    //   832: aload 17
    //   834: ldc2_w 343
    //   837: invokevirtual 348	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   840: istore 6
    //   842: iload 6
    //   844: iflt +1114 -> 1958
    //   847: aload 26
    //   849: aload 20
    //   851: iload 6
    //   853: aaload
    //   854: iconst_0
    //   855: invokevirtual 352	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   858: istore 5
    //   860: aload 26
    //   862: invokevirtual 355	android/media/MediaExtractor:getSampleTime	()J
    //   865: lstore 12
    //   867: iload 5
    //   869: iflt +18 -> 887
    //   872: lload 8
    //   874: lconst_0
    //   875: lcmp
    //   876: ifle +315 -> 1191
    //   879: lload 12
    //   881: lload 8
    //   883: lcmp
    //   884: iflt +307 -> 1191
    //   887: aload 17
    //   889: iload 6
    //   891: iconst_0
    //   892: iconst_0
    //   893: lconst_0
    //   894: iconst_4
    //   895: invokevirtual 359	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   898: iconst_1
    //   899: istore 4
    //   901: iload_3
    //   902: ifne +1039 -> 1941
    //   905: aload 17
    //   907: aload 21
    //   909: ldc2_w 343
    //   912: invokevirtual 363	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   915: istore 5
    //   917: iload 5
    //   919: tableswitch	default:+1031 -> 1950, -3:+294->1213, -2:+318->1237, -1:+357->1276
    //   945: iload 180
    //   947: aconst_null
    //   948: fdiv
    //   949: iconst_4
    //   950: iand
    //   951: ifeq +343 -> 1294
    //   954: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   957: ifeq +996 -> 1953
    //   960: ldc 76
    //   962: iconst_2
    //   963: ldc_w 368
    //   966: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   969: goto +984 -> 1953
    //   972: aload 17
    //   974: iload 5
    //   976: iconst_0
    //   977: invokevirtual 372	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   980: iload_3
    //   981: ifeq +659 -> 1640
    //   984: iload_2
    //   985: ifeq +747 -> 1732
    //   988: aload_0
    //   989: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   992: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Lbppl;
    //   995: getfield 116	bppl:jdField_a_of_type_Int	I
    //   998: iconst_3
    //   999: if_icmpeq +37 -> 1036
    //   1002: aload_0
    //   1003: monitorenter
    //   1004: aload_0
    //   1005: getfield 131	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   1008: ifne +26 -> 1034
    //   1011: aload_0
    //   1012: invokevirtual 134	java/lang/Object:wait	()V
    //   1015: aload_0
    //   1016: iconst_0
    //   1017: putfield 131	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   1020: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1023: ifeq +11 -> 1034
    //   1026: ldc 76
    //   1028: iconst_1
    //   1029: ldc 140
    //   1031: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: aload_0
    //   1035: monitorexit
    //   1036: aload 17
    //   1038: invokevirtual 373	android/media/MediaCodec:flush	()V
    //   1041: aload 26
    //   1043: lload 10
    //   1045: iconst_0
    //   1046: invokevirtual 291	android/media/MediaExtractor:seekTo	(JI)V
    //   1049: iconst_0
    //   1050: istore 5
    //   1052: iconst_0
    //   1053: istore 6
    //   1055: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1058: ifeq +643 -> 1701
    //   1061: ldc 76
    //   1063: iconst_1
    //   1064: ldc_w 375
    //   1067: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1070: iconst_0
    //   1071: istore_3
    //   1072: iconst_0
    //   1073: istore 4
    //   1075: aload_0
    //   1076: getfield 144	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Boolean	Z
    //   1079: istore 16
    //   1081: iload 16
    //   1083: ifeq +855 -> 1938
    //   1086: aload_0
    //   1087: getfield 29	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1090: astore 23
    //   1092: aload 23
    //   1094: monitorenter
    //   1095: aload_0
    //   1096: getfield 29	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1099: invokevirtual 134	java/lang/Object:wait	()V
    //   1102: aload 23
    //   1104: monitorexit
    //   1105: goto -283 -> 822
    //   1108: astore_1
    //   1109: aload_1
    //   1110: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   1113: ldc 76
    //   1115: iconst_2
    //   1116: ldc_w 377
    //   1119: aload_1
    //   1120: invokestatic 380	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1123: aconst_null
    //   1124: astore_1
    //   1125: aload 17
    //   1127: ifnull +13 -> 1140
    //   1130: aload 17
    //   1132: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   1135: aload 17
    //   1137: invokevirtual 322	android/media/MediaCodec:release	()V
    //   1140: aload 26
    //   1142: ifnull +8 -> 1150
    //   1145: aload 26
    //   1147: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   1150: iconst_0
    //   1151: ifeq -448 -> 703
    //   1154: new 325	java/lang/NullPointerException
    //   1157: dup
    //   1158: invokespecial 326	java/lang/NullPointerException:<init>	()V
    //   1161: athrow
    //   1162: astore_1
    //   1163: ldc 76
    //   1165: iconst_1
    //   1166: aload_1
    //   1167: iconst_0
    //   1168: anewarray 4	java/lang/Object
    //   1171: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1174: aconst_null
    //   1175: areturn
    //   1176: new 382	java/io/ByteArrayOutputStream
    //   1179: dup
    //   1180: invokespecial 383	java/io/ByteArrayOutputStream:<init>	()V
    //   1183: astore 19
    //   1185: aconst_null
    //   1186: astore 18
    //   1188: goto -371 -> 817
    //   1191: aload 17
    //   1193: iload 6
    //   1195: iconst_0
    //   1196: iload 5
    //   1198: lload 12
    //   1200: iconst_0
    //   1201: invokevirtual 359	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   1204: aload 26
    //   1206: invokevirtual 386	android/media/MediaExtractor:advance	()Z
    //   1209: pop
    //   1210: goto +748 -> 1958
    //   1213: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1216: ifeq +12 -> 1228
    //   1219: ldc 76
    //   1221: iconst_2
    //   1222: ldc_w 388
    //   1225: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1228: aload 17
    //   1230: invokevirtual 339	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1233: astore_1
    //   1234: goto -254 -> 980
    //   1237: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1240: ifeq +701 -> 1941
    //   1243: ldc 76
    //   1245: iconst_2
    //   1246: new 190	java/lang/StringBuilder
    //   1249: dup
    //   1250: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1253: ldc_w 390
    //   1256: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: aload 17
    //   1261: invokevirtual 394	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1264: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1273: goto -293 -> 980
    //   1276: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1279: ifeq +662 -> 1941
    //   1282: ldc 76
    //   1284: iconst_2
    //   1285: ldc_w 399
    //   1288: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1291: goto -311 -> 980
    //   1294: aload_1
    //   1295: iload 5
    //   1297: aaload
    //   1298: astore 22
    //   1300: aload 22
    //   1302: ifnonnull +70 -> 1372
    //   1305: ldc 76
    //   1307: iconst_1
    //   1308: ldc_w 401
    //   1311: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1314: aconst_null
    //   1315: astore_1
    //   1316: aload 17
    //   1318: ifnull +13 -> 1331
    //   1321: aload 17
    //   1323: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   1326: aload 17
    //   1328: invokevirtual 322	android/media/MediaCodec:release	()V
    //   1331: aload 26
    //   1333: ifnull +8 -> 1341
    //   1336: aload 26
    //   1338: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   1341: aload 18
    //   1343: ifnull -640 -> 703
    //   1346: aload 18
    //   1348: invokevirtual 165	android/media/AudioTrack:stop	()V
    //   1351: aload 18
    //   1353: invokevirtual 150	android/media/AudioTrack:release	()V
    //   1356: aconst_null
    //   1357: areturn
    //   1358: astore_1
    //   1359: ldc 76
    //   1361: iconst_1
    //   1362: aload_1
    //   1363: iconst_0
    //   1364: anewarray 4	java/lang/Object
    //   1367: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1370: aconst_null
    //   1371: areturn
    //   1372: aload 21
    //   1374: getfield 404	android/media/MediaCodec$BufferInfo:size	I
    //   1377: ifeq +31 -> 1408
    //   1380: aload 22
    //   1382: aload 21
    //   1384: getfield 407	android/media/MediaCodec$BufferInfo:offset	I
    //   1387: invokevirtual 413	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1390: pop
    //   1391: aload 22
    //   1393: aload 21
    //   1395: getfield 407	android/media/MediaCodec$BufferInfo:offset	I
    //   1398: aload 21
    //   1400: getfield 404	android/media/MediaCodec$BufferInfo:size	I
    //   1403: iadd
    //   1404: invokevirtual 416	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1407: pop
    //   1408: aload 22
    //   1410: invokevirtual 419	java/nio/ByteBuffer:remaining	()I
    //   1413: istore 6
    //   1415: iload 6
    //   1417: newarray byte
    //   1419: astore 23
    //   1421: aload 22
    //   1423: aload 23
    //   1425: iconst_0
    //   1426: iload 6
    //   1428: invokevirtual 423	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   1431: pop
    //   1432: iload_2
    //   1433: ifeq +19 -> 1452
    //   1436: aload_0
    //   1437: getfield 22	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   1440: aload 18
    //   1442: aload 23
    //   1444: iload 6
    //   1446: invokestatic 426	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;Landroid/media/AudioTrack;[BI)V
    //   1449: goto +512 -> 1961
    //   1452: aload 19
    //   1454: aload 23
    //   1456: iconst_0
    //   1457: iload 6
    //   1459: invokevirtual 429	java/io/ByteArrayOutputStream:write	([BII)V
    //   1462: goto +499 -> 1961
    //   1465: astore_1
    //   1466: ldc 76
    //   1468: iconst_1
    //   1469: new 190	java/lang/StringBuilder
    //   1472: dup
    //   1473: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1476: ldc_w 431
    //   1479: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: aload_1
    //   1483: invokevirtual 432	java/lang/Exception:toString	()Ljava/lang/String;
    //   1486: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1495: aconst_null
    //   1496: astore_1
    //   1497: aload 17
    //   1499: ifnull +13 -> 1512
    //   1502: aload 17
    //   1504: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   1507: aload 17
    //   1509: invokevirtual 322	android/media/MediaCodec:release	()V
    //   1512: aload 26
    //   1514: ifnull +8 -> 1522
    //   1517: aload 26
    //   1519: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   1522: aload 18
    //   1524: ifnull -821 -> 703
    //   1527: aload 18
    //   1529: invokevirtual 165	android/media/AudioTrack:stop	()V
    //   1532: aload 18
    //   1534: invokevirtual 150	android/media/AudioTrack:release	()V
    //   1537: aconst_null
    //   1538: areturn
    //   1539: astore_1
    //   1540: ldc 76
    //   1542: iconst_1
    //   1543: aload_1
    //   1544: iconst_0
    //   1545: anewarray 4	java/lang/Object
    //   1548: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1551: aconst_null
    //   1552: areturn
    //   1553: astore_1
    //   1554: aload_0
    //   1555: monitorexit
    //   1556: aload_1
    //   1557: athrow
    //   1558: astore_1
    //   1559: aload 17
    //   1561: astore 19
    //   1563: aload 18
    //   1565: astore 21
    //   1567: aload 19
    //   1569: astore 17
    //   1571: ldc 76
    //   1573: iconst_1
    //   1574: aload_1
    //   1575: iconst_0
    //   1576: anewarray 4	java/lang/Object
    //   1579: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1582: aconst_null
    //   1583: astore_1
    //   1584: aload 19
    //   1586: ifnull +13 -> 1599
    //   1589: aload 19
    //   1591: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   1594: aload 19
    //   1596: invokevirtual 322	android/media/MediaCodec:release	()V
    //   1599: aload 26
    //   1601: ifnull +8 -> 1609
    //   1604: aload 26
    //   1606: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   1609: aload 18
    //   1611: ifnull -908 -> 703
    //   1614: aload 18
    //   1616: invokevirtual 165	android/media/AudioTrack:stop	()V
    //   1619: aload 18
    //   1621: invokevirtual 150	android/media/AudioTrack:release	()V
    //   1624: aconst_null
    //   1625: areturn
    //   1626: astore_1
    //   1627: ldc 76
    //   1629: iconst_1
    //   1630: aload_1
    //   1631: iconst_0
    //   1632: anewarray 4	java/lang/Object
    //   1635: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1638: aconst_null
    //   1639: areturn
    //   1640: iload 4
    //   1642: istore 5
    //   1644: iload_3
    //   1645: istore 6
    //   1647: aload_0
    //   1648: getfield 27	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   1651: ifne +50 -> 1701
    //   1654: aload_0
    //   1655: iconst_m1
    //   1656: putfield 27	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   1659: aload 17
    //   1661: invokevirtual 373	android/media/MediaCodec:flush	()V
    //   1664: aload 26
    //   1666: lload 10
    //   1668: iconst_0
    //   1669: invokevirtual 291	android/media/MediaExtractor:seekTo	(JI)V
    //   1672: iload 4
    //   1674: istore 5
    //   1676: iload_3
    //   1677: istore 6
    //   1679: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1682: ifeq +19 -> 1701
    //   1685: ldc 76
    //   1687: iconst_1
    //   1688: ldc_w 434
    //   1691: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1694: iload_3
    //   1695: istore 6
    //   1697: iload 4
    //   1699: istore 5
    //   1701: iload 6
    //   1703: istore_3
    //   1704: iload 5
    //   1706: istore 4
    //   1708: goto -633 -> 1075
    //   1711: astore 22
    //   1713: aload 23
    //   1715: monitorexit
    //   1716: aload 22
    //   1718: athrow
    //   1719: astore 22
    //   1721: aload 22
    //   1723: invokevirtual 145	java/lang/InterruptedException:printStackTrace	()V
    //   1726: iconst_1
    //   1727: istore 7
    //   1729: goto -907 -> 822
    //   1732: ldc 76
    //   1734: iconst_1
    //   1735: new 190	java/lang/StringBuilder
    //   1738: dup
    //   1739: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1742: ldc_w 436
    //   1745: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   1751: lload 14
    //   1753: lsub
    //   1754: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1757: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1760: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1763: aload 19
    //   1765: ifnonnull +67 -> 1832
    //   1768: aconst_null
    //   1769: astore 19
    //   1771: aload 17
    //   1773: ifnull +13 -> 1786
    //   1776: aload 17
    //   1778: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   1781: aload 17
    //   1783: invokevirtual 322	android/media/MediaCodec:release	()V
    //   1786: aload 26
    //   1788: ifnull +8 -> 1796
    //   1791: aload 26
    //   1793: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   1796: aload 19
    //   1798: astore_1
    //   1799: aload 18
    //   1801: ifnull -1098 -> 703
    //   1804: aload 18
    //   1806: invokevirtual 165	android/media/AudioTrack:stop	()V
    //   1809: aload 18
    //   1811: invokevirtual 150	android/media/AudioTrack:release	()V
    //   1814: aload 19
    //   1816: areturn
    //   1817: astore_1
    //   1818: ldc 76
    //   1820: iconst_1
    //   1821: aload_1
    //   1822: iconst_0
    //   1823: anewarray 4	java/lang/Object
    //   1826: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1829: aload 19
    //   1831: areturn
    //   1832: aload 19
    //   1834: invokevirtual 439	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1837: astore 19
    //   1839: goto -68 -> 1771
    //   1842: astore_1
    //   1843: aload 17
    //   1845: ifnull +13 -> 1858
    //   1848: aload 17
    //   1850: invokevirtual 321	android/media/MediaCodec:stop	()V
    //   1853: aload 17
    //   1855: invokevirtual 322	android/media/MediaCodec:release	()V
    //   1858: aload 26
    //   1860: ifnull +8 -> 1868
    //   1863: aload 26
    //   1865: invokevirtual 323	android/media/MediaExtractor:release	()V
    //   1868: aload 21
    //   1870: ifnull +13 -> 1883
    //   1873: aload 21
    //   1875: invokevirtual 165	android/media/AudioTrack:stop	()V
    //   1878: aload 21
    //   1880: invokevirtual 150	android/media/AudioTrack:release	()V
    //   1883: aload_1
    //   1884: athrow
    //   1885: astore 17
    //   1887: ldc 76
    //   1889: iconst_1
    //   1890: aload 17
    //   1892: iconst_0
    //   1893: anewarray 4	java/lang/Object
    //   1896: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1899: goto -16 -> 1883
    //   1902: astore_1
    //   1903: aload 23
    //   1905: astore 21
    //   1907: goto -64 -> 1843
    //   1910: astore_1
    //   1911: aload 18
    //   1913: astore 21
    //   1915: goto -72 -> 1843
    //   1918: astore_1
    //   1919: aload 22
    //   1921: astore 18
    //   1923: goto -360 -> 1563
    //   1926: astore_1
    //   1927: aload 22
    //   1929: astore 18
    //   1931: aload 17
    //   1933: astore 19
    //   1935: goto -372 -> 1563
    //   1938: goto -1116 -> 822
    //   1941: goto -961 -> 980
    //   1944: aconst_null
    //   1945: astore 17
    //   1947: goto -1297 -> 650
    //   1950: goto -1006 -> 944
    //   1953: iconst_1
    //   1954: istore_3
    //   1955: goto -983 -> 972
    //   1958: goto -1057 -> 901
    //   1961: goto -989 -> 972
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1964	0	this	AudioPlayRunnable
    //   0	1964	1	paramString	String
    //   0	1964	2	paramBoolean	boolean
    //   65	1890	3	i	int
    //   802	905	4	j	int
    //   858	847	5	k	int
    //   840	862	6	m	int
    //   818	910	7	n	int
    //   62	820	8	l1	long
    //   59	1608	10	l2	long
    //   201	998	12	l3	long
    //   11	1741	14	l4	long
    //   1079	3	16	bool	boolean
    //   46	1808	17	localObject1	Object
    //   1885	47	17	localException	Exception
    //   1945	1	17	localObject2	Object
    //   20	1910	18	localObject3	Object
    //   50	1884	19	localObject4	Object
    //   17	833	20	localObject5	Object
    //   42	1872	21	localObject6	Object
    //   38	1384	22	localObject7	Object
    //   1711	6	22	localObject8	Object
    //   1719	209	22	localInterruptedException	InterruptedException
    //   32	699	24	localObject10	Object
    //   14	291	25	localObject11	Object
    //   29	1835	26	localMediaExtractor	android.media.MediaExtractor
    //   105	534	27	localMediaFormat	android.media.MediaFormat
    //   127	186	28	str	String
    // Exception table:
    //   from	to	target	type
    //   451	470	705	java/lang/Throwable
    //   482	500	705	java/lang/Throwable
    //   312	319	729	java/lang/Throwable
    //   335	341	729	java/lang/Throwable
    //   357	439	729	java/lang/Throwable
    //   516	522	729	java/lang/Throwable
    //   538	620	729	java/lang/Throwable
    //   636	646	729	java/lang/Throwable
    //   722	726	729	java/lang/Throwable
    //   671	681	760	java/lang/Exception
    //   686	691	760	java/lang/Exception
    //   695	703	760	java/lang/Exception
    //   774	779	1108	java/lang/Throwable
    //   1130	1140	1162	java/lang/Exception
    //   1145	1150	1162	java/lang/Exception
    //   1154	1162	1162	java/lang/Exception
    //   1321	1331	1358	java/lang/Exception
    //   1336	1341	1358	java/lang/Exception
    //   1346	1356	1358	java/lang/Exception
    //   1305	1314	1465	java/lang/Exception
    //   1372	1408	1465	java/lang/Exception
    //   1408	1432	1465	java/lang/Exception
    //   1436	1449	1465	java/lang/Exception
    //   1452	1462	1465	java/lang/Exception
    //   1502	1512	1539	java/lang/Exception
    //   1517	1522	1539	java/lang/Exception
    //   1527	1537	1539	java/lang/Exception
    //   1004	1034	1553	finally
    //   1034	1036	1553	finally
    //   1554	1556	1553	finally
    //   832	842	1558	java/lang/Exception
    //   847	867	1558	java/lang/Exception
    //   887	898	1558	java/lang/Exception
    //   905	917	1558	java/lang/Exception
    //   944	969	1558	java/lang/Exception
    //   972	980	1558	java/lang/Exception
    //   988	1004	1558	java/lang/Exception
    //   1036	1049	1558	java/lang/Exception
    //   1055	1070	1558	java/lang/Exception
    //   1075	1081	1558	java/lang/Exception
    //   1086	1095	1558	java/lang/Exception
    //   1191	1210	1558	java/lang/Exception
    //   1213	1228	1558	java/lang/Exception
    //   1228	1234	1558	java/lang/Exception
    //   1237	1273	1558	java/lang/Exception
    //   1276	1291	1558	java/lang/Exception
    //   1466	1495	1558	java/lang/Exception
    //   1556	1558	1558	java/lang/Exception
    //   1647	1672	1558	java/lang/Exception
    //   1679	1694	1558	java/lang/Exception
    //   1716	1719	1558	java/lang/Exception
    //   1721	1726	1558	java/lang/Exception
    //   1732	1763	1558	java/lang/Exception
    //   1832	1839	1558	java/lang/Exception
    //   1589	1599	1626	java/lang/Exception
    //   1604	1609	1626	java/lang/Exception
    //   1614	1624	1626	java/lang/Exception
    //   1095	1105	1711	finally
    //   1713	1716	1711	finally
    //   1086	1095	1719	java/lang/InterruptedException
    //   1716	1719	1719	java/lang/InterruptedException
    //   1776	1786	1817	java/lang/Exception
    //   1791	1796	1817	java/lang/Exception
    //   1804	1814	1817	java/lang/Exception
    //   52	58	1842	finally
    //   78	87	1842	finally
    //   99	107	1842	finally
    //   119	129	1842	finally
    //   141	153	1842	finally
    //   165	178	1842	finally
    //   190	203	1842	finally
    //   226	232	1842	finally
    //   244	255	1842	finally
    //   267	273	1842	finally
    //   292	300	1842	finally
    //   312	319	1842	finally
    //   335	341	1842	finally
    //   357	439	1842	finally
    //   451	470	1842	finally
    //   482	500	1842	finally
    //   516	522	1842	finally
    //   538	620	1842	finally
    //   636	646	1842	finally
    //   722	726	1842	finally
    //   742	746	1842	finally
    //   1571	1582	1842	finally
    //   1848	1858	1885	java/lang/Exception
    //   1863	1868	1885	java/lang/Exception
    //   1873	1883	1885	java/lang/Exception
    //   655	664	1902	finally
    //   774	779	1902	finally
    //   779	801	1902	finally
    //   808	814	1902	finally
    //   1109	1123	1902	finally
    //   1176	1185	1902	finally
    //   832	842	1910	finally
    //   847	867	1910	finally
    //   887	898	1910	finally
    //   905	917	1910	finally
    //   944	969	1910	finally
    //   972	980	1910	finally
    //   988	1004	1910	finally
    //   1036	1049	1910	finally
    //   1055	1070	1910	finally
    //   1075	1081	1910	finally
    //   1086	1095	1910	finally
    //   1191	1210	1910	finally
    //   1213	1228	1910	finally
    //   1228	1234	1910	finally
    //   1237	1273	1910	finally
    //   1276	1291	1910	finally
    //   1305	1314	1910	finally
    //   1372	1408	1910	finally
    //   1408	1432	1910	finally
    //   1436	1449	1910	finally
    //   1452	1462	1910	finally
    //   1466	1495	1910	finally
    //   1556	1558	1910	finally
    //   1647	1672	1910	finally
    //   1679	1694	1910	finally
    //   1716	1719	1910	finally
    //   1721	1726	1910	finally
    //   1732	1763	1910	finally
    //   1832	1839	1910	finally
    //   52	58	1918	java/lang/Exception
    //   78	87	1918	java/lang/Exception
    //   99	107	1918	java/lang/Exception
    //   119	129	1918	java/lang/Exception
    //   141	153	1918	java/lang/Exception
    //   165	178	1918	java/lang/Exception
    //   190	203	1918	java/lang/Exception
    //   226	232	1918	java/lang/Exception
    //   244	255	1918	java/lang/Exception
    //   267	273	1918	java/lang/Exception
    //   292	300	1918	java/lang/Exception
    //   312	319	1918	java/lang/Exception
    //   335	341	1918	java/lang/Exception
    //   357	439	1918	java/lang/Exception
    //   451	470	1918	java/lang/Exception
    //   482	500	1918	java/lang/Exception
    //   516	522	1918	java/lang/Exception
    //   538	620	1918	java/lang/Exception
    //   636	646	1918	java/lang/Exception
    //   722	726	1918	java/lang/Exception
    //   742	746	1918	java/lang/Exception
    //   655	664	1926	java/lang/Exception
    //   774	779	1926	java/lang/Exception
    //   779	801	1926	java/lang/Exception
    //   808	814	1926	java/lang/Exception
    //   1109	1123	1926	java/lang/Exception
    //   1176	1185	1926	java/lang/Exception
  }
  
  public void a()
  {
    if (this.this$0.a.jdField_a_of_type_Int != 3) {}
    try
    {
      Thread.sleep(500L);
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.jdField_d_of_type_Boolean = true;
          notifyAll();
          this.jdField_a_of_type_Int = 0;
          this.jdField_b_of_type_Int = 0;
          return;
          localInterruptedException = localInterruptedException;
          localInterruptedException.printStackTrace();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f;
    if (this.this$0.a != null)
    {
      f = (float)paramLong1 / (float)paramLong2;
      if ((f < this.jdField_a_of_type_Float) || (f > this.jdField_b_of_type_Float)) {
        break label103;
      }
      if (this.this$0.a.jdField_a_of_type_Int != 5) {
        break label94;
      }
    }
    label94:
    for (this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float - (f - this.jdField_a_of_type_Float));; this.jdField_c_of_type_Float = f)
    {
      QLog.d("AudioDecoder", 1, new Object[] { "seekToPercent: ", Float.valueOf(this.jdField_c_of_type_Float) });
      return;
    }
    label103:
    QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f);
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    boolean bool = true;
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.this$0.a.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = FileUtils.fileToBytes(new File(this.this$0.a.jdField_b_of_type_JavaLangString));
        if (arrayOfByte != null) {
          a(arrayOfByte);
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AudioDecoder", 1, "bgm music get error");
        localObject = null;
        continue;
      }
      if (MimeHelper.validateVideoType(MimeTypesTools.getMimeType(BaseApplication.getContext(), this.this$0.a.jdField_a_of_type_JavaLangString)))
      {
        localObject = this.this$0.a.jdField_a_of_type_JavaLangString;
        if (this.this$0.a.jdField_a_of_type_Int != 5) {}
        for (;;)
        {
          localObject = a((String)localObject, bool);
          break;
          bool = false;
        }
      }
      Object localObject = a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioPlayRunnable
 * JD-Core Version:    0.7.0.1
 */