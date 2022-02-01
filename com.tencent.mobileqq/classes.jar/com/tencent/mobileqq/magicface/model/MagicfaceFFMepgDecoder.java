package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceFFMepgDecoder
  extends MagicfaceDecoder
{
  protected DecoderUtil a;
  protected byte[] a;
  protected int[] a;
  protected byte[] b;
  protected int c;
  protected byte[] c;
  protected int d;
  protected byte[] d;
  protected int e;
  protected byte[] e;
  protected int f;
  protected byte[] f;
  protected int g;
  protected int h = 0;
  protected int i = -1;
  protected int j = -1;
  
  public MagicfaceFFMepgDecoder()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = new byte[51200];
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_d_of_type_ArrayOfByte = null;
    this.jdField_e_of_type_ArrayOfByte = new byte[51200];
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder begins");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends");
    }
  }
  
  protected int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == paramArrayOfByte.length) {
      return -1;
    }
    int m = paramInt + 1;
    int n = 0;
    int i1 = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
    paramInt = m;
    int k = n;
    if (i1 != 7)
    {
      paramInt = m;
      k = n;
      if (i1 != 8)
      {
        paramInt = m;
        k = 1;
      }
    }
    for (;;)
    {
      if (paramInt >= paramArrayOfByte.length - 4) {
        break label149;
      }
      if (paramArrayOfByte[paramInt] == 0)
      {
        m = paramInt + 1;
        if ((paramArrayOfByte[m] == 0) && (paramArrayOfByte[(paramInt + 2)] == 0) && (paramArrayOfByte[(paramInt + 3)] == 1))
        {
          n = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
          if ((n != 7) && (n != 8))
          {
            if (k != 0) {
              break label149;
            }
            paramInt = m;
            break;
          }
          paramInt = m;
          continue;
        }
      }
      paramInt += 1;
    }
    label149:
    k = paramInt;
    if (paramInt == paramArrayOfByte.length - 4) {
      k = paramArrayOfByte.length;
    }
    return k;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: new 70	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   13: astore 9
    //   15: aload 9
    //   17: ldc 73
    //   19: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 9
    //   25: aload_0
    //   26: getfield 80	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_Boolean	Z
    //   29: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 53
    //   35: iconst_2
    //   36: aload 9
    //   38: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: new 89	com/tencent/mobileqq/magicface/DecoderUtil
    //   48: dup
    //   49: invokespecial 90	com/tencent/mobileqq/magicface/DecoderUtil:<init>	()V
    //   52: putfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   55: aload_0
    //   56: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   59: invokevirtual 96	com/tencent/mobileqq/magicface/DecoderUtil:createVideoDecoder	()I
    //   62: pop
    //   63: aload_0
    //   64: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   67: invokevirtual 99	com/tencent/mobileqq/magicface/DecoderUtil:createAlphaDecoder	()I
    //   70: pop
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 102	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData	Lcom/tencent/mobileqq/magicface/model/MagicfaceData;
    //   76: getfield 105	com/tencent/mobileqq/magicface/model/MagicfaceData:jdField_b_of_type_ArrayOfByte	[B
    //   79: putfield 24	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ArrayOfByte	[B
    //   82: aload_0
    //   83: getfield 24	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ArrayOfByte	[B
    //   86: astore 9
    //   88: aload 9
    //   90: ifnonnull +49 -> 139
    //   93: aload_0
    //   94: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   97: astore 9
    //   99: aload 9
    //   101: ifnull +37 -> 138
    //   104: aload 9
    //   106: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   109: pop
    //   110: aload_0
    //   111: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   114: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   117: pop
    //   118: return
    //   119: astore 9
    //   121: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +14 -> 138
    //   127: ldc 53
    //   129: iconst_2
    //   130: aload 9
    //   132: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   135: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 102	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData	Lcom/tencent/mobileqq/magicface/model/MagicfaceData;
    //   144: getfield 117	com/tencent/mobileqq/magicface/model/MagicfaceData:jdField_a_of_type_ArrayOfByte	[B
    //   147: putfield 37	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_ArrayOfByte	[B
    //   150: aload_0
    //   151: getfield 37	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_ArrayOfByte	[B
    //   154: astore 9
    //   156: aload 9
    //   158: ifnonnull +49 -> 207
    //   161: aload_0
    //   162: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   165: astore 9
    //   167: aload 9
    //   169: ifnull +37 -> 206
    //   172: aload 9
    //   174: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   177: pop
    //   178: aload_0
    //   179: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   182: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   185: pop
    //   186: return
    //   187: astore 9
    //   189: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +14 -> 206
    //   195: ldc 53
    //   197: iconst_2
    //   198: aload 9
    //   200: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   203: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: return
    //   207: aload_0
    //   208: ldc 118
    //   210: newarray byte
    //   212: putfield 29	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_ArrayOfByte	[B
    //   215: aload_0
    //   216: ldc 118
    //   218: newarray byte
    //   220: putfield 120	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_ArrayOfByte	[B
    //   223: goto +24 -> 247
    //   226: astore 9
    //   228: aload 9
    //   230: invokevirtual 123	java/lang/OutOfMemoryError:printStackTrace	()V
    //   233: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +11 -> 247
    //   239: ldc 53
    //   241: iconst_2
    //   242: ldc 125
    //   244: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: getfield 29	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_ArrayOfByte	[B
    //   251: astore 9
    //   253: aload 9
    //   255: ifnonnull +49 -> 304
    //   258: aload_0
    //   259: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   262: astore 9
    //   264: aload 9
    //   266: ifnull +37 -> 303
    //   269: aload 9
    //   271: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   274: pop
    //   275: aload_0
    //   276: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   279: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   282: pop
    //   283: return
    //   284: astore 9
    //   286: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +14 -> 303
    //   292: ldc 53
    //   294: iconst_2
    //   295: aload 9
    //   297: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   300: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: return
    //   304: iconst_1
    //   305: istore_1
    //   306: lconst_0
    //   307: lstore 5
    //   309: aload_0
    //   310: getfield 80	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_Boolean	Z
    //   313: ifeq +699 -> 1012
    //   316: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   319: lstore_3
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 24	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ArrayOfByte	[B
    //   325: aload_0
    //   326: getfield 31	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_Int	I
    //   329: invokevirtual 133	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:a	([BI)I
    //   332: istore_2
    //   333: aload_0
    //   334: iload_2
    //   335: aload_0
    //   336: getfield 31	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_Int	I
    //   339: isub
    //   340: putfield 135	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_Int	I
    //   343: aload_0
    //   344: getfield 135	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_Int	I
    //   347: ifgt +6 -> 353
    //   350: goto +662 -> 1012
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 135	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_Int	I
    //   358: aload_0
    //   359: getfield 31	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_Int	I
    //   362: aload_0
    //   363: getfield 24	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ArrayOfByte	[B
    //   366: invokevirtual 138	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:a	(II[B)V
    //   369: aload_0
    //   370: iload_2
    //   371: putfield 31	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_Int	I
    //   374: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   377: lstore 7
    //   379: aload_0
    //   380: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   383: aload_0
    //   384: getfield 27	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_b_of_type_ArrayOfByte	[B
    //   387: aload_0
    //   388: getfield 135	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_Int	I
    //   391: aload_0
    //   392: getfield 29	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_ArrayOfByte	[B
    //   395: invokevirtual 142	com/tencent/mobileqq/magicface/DecoderUtil:decodeVideoDecoder	([BI[B)I
    //   398: pop
    //   399: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +61 -> 463
    //   405: new 70	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   412: astore 9
    //   414: aload 9
    //   416: ldc 144
    //   418: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 9
    //   424: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   427: lload 7
    //   429: lsub
    //   430: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 9
    //   436: ldc 149
    //   438: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 9
    //   444: aload_0
    //   445: getfield 135	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_Int	I
    //   448: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc 53
    //   454: iconst_2
    //   455: aload 9
    //   457: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload_0
    //   464: getfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   467: iconst_m1
    //   468: if_icmpne +117 -> 585
    //   471: aload_0
    //   472: aload_0
    //   473: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   476: invokevirtual 155	com/tencent/mobileqq/magicface/DecoderUtil:getWidthVideoDecoder	()I
    //   479: putfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   482: aload_0
    //   483: aload_0
    //   484: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   487: invokevirtual 158	com/tencent/mobileqq/magicface/DecoderUtil:getHeightVideoDecoder	()I
    //   490: putfield 35	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_Int	I
    //   493: aload_0
    //   494: getfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   497: sipush 500
    //   500: if_icmpgt +34 -> 534
    //   503: aload_0
    //   504: getfield 35	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_Int	I
    //   507: sipush 500
    //   510: if_icmple +6 -> 516
    //   513: goto +21 -> 534
    //   516: aload_0
    //   517: aload_0
    //   518: getfield 35	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_Int	I
    //   521: aload_0
    //   522: getfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   525: imul
    //   526: newarray int
    //   528: putfield 160	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ArrayOfInt	[I
    //   531: goto +54 -> 585
    //   534: aload_0
    //   535: iconst_m1
    //   536: putfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   539: aload_0
    //   540: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   543: astore 9
    //   545: aload 9
    //   547: ifnull +37 -> 584
    //   550: aload 9
    //   552: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   555: pop
    //   556: aload_0
    //   557: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   560: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   563: pop
    //   564: return
    //   565: astore 9
    //   567: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +14 -> 584
    //   573: ldc 53
    //   575: iconst_2
    //   576: aload 9
    //   578: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   581: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: return
    //   585: aload_0
    //   586: aload_0
    //   587: getfield 37	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_ArrayOfByte	[B
    //   590: aload_0
    //   591: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:h	I
    //   594: invokevirtual 133	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:a	([BI)I
    //   597: istore_2
    //   598: aload_0
    //   599: iload_2
    //   600: aload_0
    //   601: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:h	I
    //   604: isub
    //   605: putfield 162	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:g	I
    //   608: aload_0
    //   609: aload_0
    //   610: getfield 162	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:g	I
    //   613: aload_0
    //   614: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:h	I
    //   617: aload_0
    //   618: getfield 37	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_d_of_type_ArrayOfByte	[B
    //   621: invokevirtual 164	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:b	(II[B)V
    //   624: aload_0
    //   625: iload_2
    //   626: putfield 41	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:h	I
    //   629: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   632: lstore 7
    //   634: aload_0
    //   635: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   638: aload_0
    //   639: getfield 39	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_ArrayOfByte	[B
    //   642: aload_0
    //   643: getfield 162	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:g	I
    //   646: aload_0
    //   647: getfield 120	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_ArrayOfByte	[B
    //   650: invokevirtual 167	com/tencent/mobileqq/magicface/DecoderUtil:decodeAlphaDecoder	([BI[B)I
    //   653: pop
    //   654: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq +61 -> 718
    //   660: new 70	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   667: astore 9
    //   669: aload 9
    //   671: ldc 169
    //   673: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 9
    //   679: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   682: lload 7
    //   684: lsub
    //   685: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 9
    //   691: ldc 171
    //   693: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 9
    //   699: aload_0
    //   700: getfield 162	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:g	I
    //   703: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: ldc 53
    //   709: iconst_2
    //   710: aload 9
    //   712: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   721: lstore 7
    //   723: aload_0
    //   724: aload_0
    //   725: getfield 29	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_c_of_type_ArrayOfByte	[B
    //   728: aload_0
    //   729: getfield 120	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_ArrayOfByte	[B
    //   732: invokevirtual 174	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:a	([B[B)[I
    //   735: astore 9
    //   737: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq +43 -> 783
    //   743: new 70	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   750: astore 10
    //   752: aload 10
    //   754: ldc 176
    //   756: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload 10
    //   762: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   765: lload 7
    //   767: lsub
    //   768: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: ldc 53
    //   774: iconst_2
    //   775: aload 10
    //   777: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_0
    //   784: getfield 179	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener	Lcom/tencent/mobileqq/magicface/model/MagicfaceDecoder$MagicfaceRenderListener;
    //   787: ifnull +22 -> 809
    //   790: aload_0
    //   791: getfield 179	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener	Lcom/tencent/mobileqq/magicface/model/MagicfaceDecoder$MagicfaceRenderListener;
    //   794: aload 9
    //   796: aload_0
    //   797: getfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   800: aload_0
    //   801: getfield 35	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_f_of_type_Int	I
    //   804: invokeinterface 184 4 0
    //   809: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   812: lload_3
    //   813: lsub
    //   814: lstore 7
    //   816: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   819: ifeq +39 -> 858
    //   822: new 70	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   829: astore 9
    //   831: aload 9
    //   833: ldc 186
    //   835: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 9
    //   841: lload 7
    //   843: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: ldc 53
    //   849: iconst_2
    //   850: aload 9
    //   852: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: lload 7
    //   860: aload_0
    //   861: getfield 188	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_b_of_type_Int	I
    //   864: i2l
    //   865: lcmp
    //   866: ifge +56 -> 922
    //   869: lload 5
    //   871: lconst_0
    //   872: lcmp
    //   873: ifle +32 -> 905
    //   876: aload_0
    //   877: getfield 188	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_b_of_type_Int	I
    //   880: i2l
    //   881: lload 7
    //   883: lsub
    //   884: lstore_3
    //   885: lload_3
    //   886: lload 5
    //   888: lcmp
    //   889: ifle +364 -> 1253
    //   892: lload_3
    //   893: lload 5
    //   895: lsub
    //   896: invokestatic 194	java/lang/Thread:sleep	(J)V
    //   899: lload 5
    //   901: lstore_3
    //   902: goto +356 -> 1258
    //   905: aload_0
    //   906: getfield 188	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_b_of_type_Int	I
    //   909: i2l
    //   910: lload 7
    //   912: lsub
    //   913: invokestatic 194	java/lang/Thread:sleep	(J)V
    //   916: lload 5
    //   918: lstore_3
    //   919: goto +339 -> 1258
    //   922: lload 5
    //   924: lstore_3
    //   925: iload_1
    //   926: ifne +332 -> 1258
    //   929: lload 5
    //   931: lload 7
    //   933: aload_0
    //   934: getfield 188	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_b_of_type_Int	I
    //   937: i2l
    //   938: lsub
    //   939: ladd
    //   940: lstore_3
    //   941: goto +317 -> 1258
    //   944: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   947: ifeq +11 -> 958
    //   950: ldc 53
    //   952: iconst_2
    //   953: ldc 196
    //   955: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload_0
    //   959: iconst_m1
    //   960: putfield 33	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_e_of_type_Int	I
    //   963: invokestatic 201	java/lang/System:gc	()V
    //   966: aload_0
    //   967: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   970: astore 9
    //   972: aload 9
    //   974: ifnull +37 -> 1011
    //   977: aload 9
    //   979: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   982: pop
    //   983: aload_0
    //   984: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   987: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   990: pop
    //   991: return
    //   992: astore 9
    //   994: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   997: ifeq +14 -> 1011
    //   1000: ldc 53
    //   1002: iconst_2
    //   1003: aload 9
    //   1005: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1008: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: return
    //   1012: aload_0
    //   1013: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1016: astore 9
    //   1018: aload 9
    //   1020: ifnull +171 -> 1191
    //   1023: aload 9
    //   1025: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   1028: pop
    //   1029: aload_0
    //   1030: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1033: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   1036: pop
    //   1037: return
    //   1038: astore 9
    //   1040: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq +148 -> 1191
    //   1046: ldc 53
    //   1048: iconst_2
    //   1049: aload 9
    //   1051: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1054: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1057: return
    //   1058: astore 9
    //   1060: goto +132 -> 1192
    //   1063: astore 9
    //   1065: aload 9
    //   1067: invokevirtual 123	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1070: aload_0
    //   1071: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1074: astore 9
    //   1076: aload 9
    //   1078: ifnull +113 -> 1191
    //   1081: aload 9
    //   1083: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   1086: pop
    //   1087: aload_0
    //   1088: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1091: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   1094: pop
    //   1095: return
    //   1096: astore 9
    //   1098: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1101: ifeq +90 -> 1191
    //   1104: goto -58 -> 1046
    //   1107: astore 9
    //   1109: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq +42 -> 1154
    //   1115: new 70	java/lang/StringBuilder
    //   1118: dup
    //   1119: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   1122: astore 10
    //   1124: aload 10
    //   1126: ldc 203
    //   1128: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 10
    //   1134: aload 9
    //   1136: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1139: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: ldc 53
    //   1145: iconst_2
    //   1146: aload 10
    //   1148: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1154: aload_0
    //   1155: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1158: astore 9
    //   1160: aload 9
    //   1162: ifnull +29 -> 1191
    //   1165: aload 9
    //   1167: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   1170: pop
    //   1171: aload_0
    //   1172: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1175: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   1178: pop
    //   1179: return
    //   1180: astore 9
    //   1182: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1185: ifeq +6 -> 1191
    //   1188: goto -142 -> 1046
    //   1191: return
    //   1192: aload_0
    //   1193: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1196: astore 10
    //   1198: aload 10
    //   1200: ifnull +39 -> 1239
    //   1203: aload 10
    //   1205: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:releaseAlphaDecoder	()I
    //   1208: pop
    //   1209: aload_0
    //   1210: getfield 92	com/tencent/mobileqq/magicface/model/MagicfaceFFMepgDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   1213: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:releaseVideoDecoder	()I
    //   1216: pop
    //   1217: goto +22 -> 1239
    //   1220: astore 10
    //   1222: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +14 -> 1239
    //   1228: ldc 53
    //   1230: iconst_2
    //   1231: aload 10
    //   1233: invokevirtual 114	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1236: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: goto +6 -> 1245
    //   1242: aload 9
    //   1244: athrow
    //   1245: goto -3 -> 1242
    //   1248: astore 9
    //   1250: goto -306 -> 944
    //   1253: lload 5
    //   1255: lload_3
    //   1256: lsub
    //   1257: lstore_3
    //   1258: iconst_0
    //   1259: istore_1
    //   1260: lload_3
    //   1261: lstore 5
    //   1263: goto -954 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1266	0	this	MagicfaceFFMepgDecoder
    //   305	955	1	k	int
    //   332	294	2	m	int
    //   319	942	3	l1	long
    //   307	955	5	l2	long
    //   377	555	7	l3	long
    //   13	92	9	localObject1	java.lang.Object
    //   119	12	9	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   154	19	9	localObject2	java.lang.Object
    //   187	12	9	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   226	3	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   251	19	9	localObject3	java.lang.Object
    //   284	12	9	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    //   412	139	9	localObject4	java.lang.Object
    //   565	12	9	localUnsatisfiedLinkError4	java.lang.UnsatisfiedLinkError
    //   667	311	9	localObject5	java.lang.Object
    //   992	12	9	localUnsatisfiedLinkError5	java.lang.UnsatisfiedLinkError
    //   1016	8	9	localDecoderUtil1	DecoderUtil
    //   1038	12	9	localUnsatisfiedLinkError6	java.lang.UnsatisfiedLinkError
    //   1058	1	9	localObject6	java.lang.Object
    //   1063	3	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1074	8	9	localDecoderUtil2	DecoderUtil
    //   1096	1	9	localUnsatisfiedLinkError7	java.lang.UnsatisfiedLinkError
    //   1107	28	9	localException	java.lang.Exception
    //   1158	8	9	localDecoderUtil3	DecoderUtil
    //   1180	63	9	localUnsatisfiedLinkError8	java.lang.UnsatisfiedLinkError
    //   1248	1	9	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   750	454	10	localObject7	java.lang.Object
    //   1220	12	10	localUnsatisfiedLinkError9	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   104	118	119	java/lang/UnsatisfiedLinkError
    //   172	186	187	java/lang/UnsatisfiedLinkError
    //   207	223	226	java/lang/OutOfMemoryError
    //   269	283	284	java/lang/UnsatisfiedLinkError
    //   550	564	565	java/lang/UnsatisfiedLinkError
    //   977	991	992	java/lang/UnsatisfiedLinkError
    //   1023	1037	1038	java/lang/UnsatisfiedLinkError
    //   44	88	1058	finally
    //   139	156	1058	finally
    //   207	223	1058	finally
    //   228	247	1058	finally
    //   247	253	1058	finally
    //   309	350	1058	finally
    //   353	463	1058	finally
    //   463	513	1058	finally
    //   516	531	1058	finally
    //   534	539	1058	finally
    //   585	718	1058	finally
    //   718	783	1058	finally
    //   783	809	1058	finally
    //   809	858	1058	finally
    //   858	869	1058	finally
    //   876	885	1058	finally
    //   892	899	1058	finally
    //   905	916	1058	finally
    //   929	941	1058	finally
    //   944	958	1058	finally
    //   958	966	1058	finally
    //   1065	1070	1058	finally
    //   1109	1154	1058	finally
    //   44	88	1063	java/lang/OutOfMemoryError
    //   139	156	1063	java/lang/OutOfMemoryError
    //   228	247	1063	java/lang/OutOfMemoryError
    //   247	253	1063	java/lang/OutOfMemoryError
    //   309	350	1063	java/lang/OutOfMemoryError
    //   353	463	1063	java/lang/OutOfMemoryError
    //   585	718	1063	java/lang/OutOfMemoryError
    //   718	783	1063	java/lang/OutOfMemoryError
    //   783	809	1063	java/lang/OutOfMemoryError
    //   809	858	1063	java/lang/OutOfMemoryError
    //   858	869	1063	java/lang/OutOfMemoryError
    //   876	885	1063	java/lang/OutOfMemoryError
    //   892	899	1063	java/lang/OutOfMemoryError
    //   905	916	1063	java/lang/OutOfMemoryError
    //   929	941	1063	java/lang/OutOfMemoryError
    //   944	958	1063	java/lang/OutOfMemoryError
    //   958	966	1063	java/lang/OutOfMemoryError
    //   1081	1095	1096	java/lang/UnsatisfiedLinkError
    //   44	88	1107	java/lang/Exception
    //   139	156	1107	java/lang/Exception
    //   207	223	1107	java/lang/Exception
    //   228	247	1107	java/lang/Exception
    //   247	253	1107	java/lang/Exception
    //   309	350	1107	java/lang/Exception
    //   353	463	1107	java/lang/Exception
    //   463	513	1107	java/lang/Exception
    //   516	531	1107	java/lang/Exception
    //   534	539	1107	java/lang/Exception
    //   585	718	1107	java/lang/Exception
    //   718	783	1107	java/lang/Exception
    //   783	809	1107	java/lang/Exception
    //   809	858	1107	java/lang/Exception
    //   858	869	1107	java/lang/Exception
    //   876	885	1107	java/lang/Exception
    //   892	899	1107	java/lang/Exception
    //   905	916	1107	java/lang/Exception
    //   929	941	1107	java/lang/Exception
    //   944	958	1107	java/lang/Exception
    //   958	966	1107	java/lang/Exception
    //   1165	1179	1180	java/lang/UnsatisfiedLinkError
    //   1203	1217	1220	java/lang/UnsatisfiedLinkError
    //   463	513	1248	java/lang/OutOfMemoryError
    //   516	531	1248	java/lang/OutOfMemoryError
    //   534	539	1248	java/lang/OutOfMemoryError
  }
  
  protected void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.jdField_b_of_type_ArrayOfByte.length < paramInt1)
    {
      this.jdField_b_of_type_ArrayOfByte = new byte[paramInt1];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("videoFrame.length = ");
        localStringBuilder.append(this.jdField_b_of_type_ArrayOfByte.length);
        localStringBuilder.append("new framelength = ");
        localStringBuilder.append(paramInt1);
        QLog.d("MagicfaceFFMepgDecoder", 2, localStringBuilder.toString());
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.jdField_b_of_type_ArrayOfByte, 0, paramInt1);
  }
  
  protected int[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    int[] arrayOfInt;
    for (;;)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (m >= arrayOfInt.length) {
        break;
      }
      int i1 = m * 3;
      int n = paramArrayOfByte2[i1] & 0xFF;
      int k;
      if (n <= 50)
      {
        k = 0;
      }
      else
      {
        k = n;
        if (n >= 235) {
          k = 255;
        }
      }
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      n = paramArrayOfByte1[(i1 + 2)];
      int i2 = paramArrayOfByte1[(i1 + 1)];
      arrayOfInt[m] = (paramArrayOfByte1[i1] & 0xFF | k << 24 & 0xFF000000 | n << 16 & 0xFF0000 | i2 << 8 & 0xFF00);
      m += 1;
    }
    return arrayOfInt;
  }
  
  protected void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.jdField_e_of_type_ArrayOfByte.length < paramInt1)
    {
      this.jdField_e_of_type_ArrayOfByte = new byte[paramInt1];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("alphaFrame.length = ");
        localStringBuilder.append(this.jdField_e_of_type_ArrayOfByte.length);
        localStringBuilder.append(" new fillFrameAlpha = ");
        localStringBuilder.append(paramInt1);
        QLog.d("MagicfaceFFMepgDecoder", 2, localStringBuilder.toString());
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.jdField_e_of_type_ArrayOfByte, 0, paramInt1);
  }
  
  public void c()
  {
    super.c();
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_e_of_type_ArrayOfByte = null;
    this.jdField_f_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ArrayOfInt = null;
  }
  
  protected void f()
  {
    super.f();
    this.jdField_d_of_type_Int = 0;
    this.h = 0;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder
 * JD-Core Version:    0.7.0.1
 */