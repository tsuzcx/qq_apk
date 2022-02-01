import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.authorize.FlatBuffersConfig.1;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class nlx
  extends nlw
{
  public static HashMap<String, Integer> a;
  public volatile long a;
  public FlatBuffersParser a;
  public nly a;
  public noq a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skey", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilHashMap.put("pskey", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilHashMap.put("a1", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put("a2", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilHashMap.put("ptlogin2", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put("pt4_token", Integer.valueOf(11));
  }
  
  public nlx(SharedPreferences paramSharedPreferences)
  {
    super(paramSharedPreferences, null);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentBizFlatbuffersFlatBuffersParser = new FlatBuffersParser();
  }
  
  public static int a(nop paramnop, int paramInt1, int paramInt2, String paramString)
  {
    int k = 1;
    int m = 0;
    int n = paramString.length();
    int i = 0;
    while ((i < n) && (paramInt1 < paramInt2))
    {
      int i1 = paramnop.a(paramInt1);
      int j;
      if (i1 < 0) {
        j = -1;
      }
      do
      {
        return j;
        j = k;
      } while (i1 != paramString.charAt(i));
      i += 1;
      paramInt1 += 1;
    }
    if (paramInt1 == paramInt2) {}
    for (paramInt1 = m;; paramInt1 = 1) {
      return paramInt1;
    }
  }
  
  public static void a(OutputStream paramOutputStream, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      paramOutputStream.write(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.capacity() - paramByteBuffer.position());
      return;
    }
    paramByteBuffer = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[paramByteBuffer.capacity() - paramByteBuffer.position()];
    paramByteBuffer.get(arrayOfByte);
    paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if (c <= '\037') {
          paramStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append('\\').append(c);
        continue;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\b");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append(c);
      }
    }
    paramStringBuilder.append("\"");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, null);
    if (paramString1 != null)
    {
      paramStringBuilder.append(",");
      paramStringBuilder.append(paramString2);
      paramStringBuilder.append(":");
      if (!paramBoolean) {
        paramStringBuilder.append(paramString1);
      }
    }
    else
    {
      return;
    }
    a(paramString1, paramStringBuilder);
  }
  
  public static boolean a(nop paramnop, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramnop.a() == 0) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return bool1;
          i = paramnop.a();
          if (i != 1) {
            break;
          }
          bool1 = bool2;
        } while (paramnop.a(0) == 42);
        if ((i != 3) || (a(paramnop, 0, i, "*.*") != 0)) {
          break;
        }
        bool1 = bool2;
      } while (paramString.indexOf('.') != -1);
      return false;
      if (paramnop.a(0) == 42) {
        i = b(paramnop, 1, i, paramString);
      }
      while (i < 0)
      {
        return niz.b(paramnop.a(), paramString);
        if (paramnop.a(i - 1) == 42) {
          i = a(paramnop, 0, i - 1, paramString);
        } else {
          i = a(paramnop, 0, i, paramString);
        }
      }
      bool1 = bool2;
    } while (i == 0);
    return false;
  }
  
  public static int b(nop paramnop, int paramInt1, int paramInt2, String paramString)
  {
    int k = 1;
    int i = paramString.length() - 1;
    int m;
    int j;
    if ((i >= 0) && (paramInt1 < paramInt2))
    {
      m = paramnop.a(paramInt2 - 1);
      if (m < 0) {
        j = -1;
      }
    }
    do
    {
      do
      {
        return j;
        j = k;
      } while (m != paramString.charAt(i));
      i -= 1;
      paramInt2 -= 1;
      break;
      j = k;
    } while (paramInt1 != paramInt2);
    return 0;
  }
  
  public int a(String paramString1, String paramString2)
  {
    Object localObject = a();
    if (localObject == null) {
      return a(false, true);
    }
    localObject = ((noq)localObject).a(0);
    if ((localObject == null) || (((nop)localObject).a() == 0)) {
      return a(false, true);
    }
    noq localnoq = new noq();
    nop localnop1 = new nop();
    nop localnop2 = new nop();
    nop localnop3 = new nop();
    int m = ((nop)localObject).a();
    int i = 0;
    while (i < m)
    {
      ((nop)localObject).a(i, localnoq);
      localnoq.a(0, localnop1);
      int n = localnop1.a();
      int j = 0;
      if (j < n)
      {
        localnop1.a(j, localnop3);
        if (!a(localnop3, paramString1)) {}
        for (;;)
        {
          j += 1;
          break;
          localnoq.a(1, localnop2);
          int k = 0;
          int i1 = localnop2.a();
          while (k < i1)
          {
            localnop2.a(k, localnop3);
            if (a(localnop3, paramString2)) {
              return a(true, false);
            }
            k += 1;
          }
        }
      }
      i += 1;
    }
    return a(false, false);
  }
  
  public File a()
  {
    File localFile = new File(FlatBuffersParser.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "flatbuffers_authorize.bin");
  }
  
  public String a()
  {
    noq localnoq = a();
    if (localnoq == null) {
      return null;
    }
    return localnoq.a(1);
  }
  
  /* Error */
  public String a(android.content.SharedPreferences.Editor paramEditor, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 56	nlx:jdField_a_of_type_ComTencentBizFlatbuffersFlatBuffersParser	Lcom/tencent/biz/flatbuffers/FlatBuffersParser;
    //   7: aload_2
    //   8: ldc 237
    //   10: invokevirtual 240	com/tencent/biz/flatbuffers/FlatBuffersParser:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/nio/ByteBuffer;
    //   13: iconst_1
    //   14: invokevirtual 243	nlx:a	(Ljava/nio/ByteBuffer;Z)Ljava/lang/String;
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 245	nlx:jdField_a_of_type_Noq	Lnoq;
    //   23: ifnonnull +33 -> 56
    //   26: ldc 247
    //   28: iconst_1
    //   29: ldc 249
    //   31: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: invokevirtual 257	nlx:a	()Ljava/io/File;
    //   38: invokevirtual 260	java/io/File:delete	()Z
    //   41: pop
    //   42: aload_0
    //   43: getfield 262	nlx:jdField_a_of_type_Nly	Lnly;
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 266	nly:a	(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: aload_0
    //   57: getfield 245	nlx:jdField_a_of_type_Noq	Lnoq;
    //   60: iconst_5
    //   61: ldc2_w 48
    //   64: invokevirtual 269	noq:a	(IJ)J
    //   67: lstore_3
    //   68: ldc 247
    //   70: iconst_1
    //   71: new 121	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 272
    //   81: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: lload_3
    //   85: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_1
    //   95: ldc_w 280
    //   98: lload_3
    //   99: invokeinterface 286 4 0
    //   104: pop
    //   105: aload_0
    //   106: getfield 262	nlx:jdField_a_of_type_Nly	Lnly;
    //   109: invokevirtual 288	nly:a	()V
    //   112: aload 5
    //   114: astore_1
    //   115: goto -63 -> 52
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	nlx
    //   0	123	1	paramEditor	android.content.SharedPreferences.Editor
    //   0	123	2	paramString	String
    //   67	32	3	l	long
    //   17	96	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	52	118	finally
    //   56	112	118	finally
  }
  
  /* Error */
  public String a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +11 -> 14
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: monitorexit
    //   11: aload 7
    //   13: areturn
    //   14: ldc_w 292
    //   17: astore 7
    //   19: aload 7
    //   21: astore 5
    //   23: aload_1
    //   24: invokestatic 295	noq:a	(Ljava/nio/ByteBuffer;)Lnoq;
    //   27: astore 9
    //   29: aload 9
    //   31: ifnonnull +167 -> 198
    //   34: aload 7
    //   36: astore 5
    //   38: new 121	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 292
    //   48: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 297
    //   54: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload 6
    //   64: astore 5
    //   66: aload 5
    //   68: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifeq +10 -> 81
    //   74: aload_0
    //   75: getfield 245	nlx:jdField_a_of_type_Noq	Lnoq;
    //   78: ifnonnull +878 -> 956
    //   81: ldc 247
    //   83: iconst_1
    //   84: new 121	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 299
    //   94: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 5
    //   99: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iconst_1
    //   109: invokestatic 305	com/tencent/biz/flatbuffers/FlatBuffersParser:b	(Z)V
    //   112: aload_0
    //   113: invokevirtual 307	nlx:b	()Ljava/io/File;
    //   116: astore 6
    //   118: iload_2
    //   119: ifne +860 -> 979
    //   122: aload_0
    //   123: invokevirtual 257	nlx:a	()Ljava/io/File;
    //   126: invokevirtual 260	java/io/File:delete	()Z
    //   129: istore_2
    //   130: ldc 247
    //   132: iconst_1
    //   133: new 121	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 309
    //   143: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_2
    //   147: invokevirtual 312	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   150: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: iconst_0
    //   157: istore_2
    //   158: aload 5
    //   160: astore 7
    //   162: aload 6
    //   164: ifnull -155 -> 9
    //   167: new 314	com/tencent/biz/authorize/FlatBuffersConfig$2
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: aload 6
    //   175: iload_2
    //   176: invokespecial 317	com/tencent/biz/authorize/FlatBuffersConfig$2:<init>	(Lnlx;Ljava/nio/ByteBuffer;Ljava/io/File;Z)V
    //   179: bipush 8
    //   181: aconst_null
    //   182: iconst_1
    //   183: invokestatic 323	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   186: aload 5
    //   188: astore 7
    //   190: goto -181 -> 9
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    //   198: aload 7
    //   200: astore 5
    //   202: new 65	nop
    //   205: dup
    //   206: invokespecial 204	nop:<init>	()V
    //   209: astore 10
    //   211: aload 7
    //   213: astore 5
    //   215: aload 9
    //   217: iconst_0
    //   218: aload 10
    //   220: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   223: ifnonnull +608 -> 831
    //   226: aload 7
    //   228: astore 5
    //   230: new 121	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 292
    //   240: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 325
    //   246: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore 6
    //   254: aload 6
    //   256: astore 7
    //   258: aload 6
    //   260: astore 5
    //   262: aload 9
    //   264: iconst_1
    //   265: invokevirtual 234	noq:a	(I)Ljava/lang/String;
    //   268: ifnonnull +30 -> 298
    //   271: aload 6
    //   273: astore 5
    //   275: new 121	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   282: aload 6
    //   284: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 327
    //   290: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore 7
    //   298: aload 7
    //   300: astore 6
    //   302: aload 7
    //   304: astore 5
    //   306: aload 9
    //   308: iconst_2
    //   309: invokevirtual 234	noq:a	(I)Ljava/lang/String;
    //   312: ifnonnull +30 -> 342
    //   315: aload 7
    //   317: astore 5
    //   319: new 121	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   326: aload 7
    //   328: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc_w 329
    //   334: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: astore 6
    //   342: aload 6
    //   344: astore 7
    //   346: aload 6
    //   348: astore 5
    //   350: aload 9
    //   352: iconst_3
    //   353: invokevirtual 234	noq:a	(I)Ljava/lang/String;
    //   356: ifnonnull +30 -> 386
    //   359: aload 6
    //   361: astore 5
    //   363: new 121	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   370: aload 6
    //   372: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 331
    //   378: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore 7
    //   386: aload 7
    //   388: astore 6
    //   390: aload 7
    //   392: astore 5
    //   394: aload 9
    //   396: iconst_4
    //   397: aload 10
    //   399: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   402: ifnonnull +48 -> 450
    //   405: aload 7
    //   407: astore 6
    //   409: aload 7
    //   411: astore 5
    //   413: aload 9
    //   415: bipush 12
    //   417: invokevirtual 234	noq:a	(I)Ljava/lang/String;
    //   420: ifnonnull +30 -> 450
    //   423: aload 7
    //   425: astore 5
    //   427: new 121	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   434: aload 7
    //   436: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 333
    //   442: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: astore 6
    //   450: aload 6
    //   452: astore 7
    //   454: aload 6
    //   456: astore 5
    //   458: aload 9
    //   460: bipush 6
    //   462: aload 10
    //   464: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   467: ifnonnull +30 -> 497
    //   470: aload 6
    //   472: astore 5
    //   474: new 121	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   481: aload 6
    //   483: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 335
    //   489: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: astore 7
    //   497: aload 7
    //   499: astore 6
    //   501: aload 7
    //   503: astore 5
    //   505: aload 9
    //   507: bipush 7
    //   509: aload 10
    //   511: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   514: ifnonnull +30 -> 544
    //   517: aload 7
    //   519: astore 5
    //   521: new 121	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   528: aload 7
    //   530: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 337
    //   536: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: astore 6
    //   544: aload 6
    //   546: astore 7
    //   548: aload 6
    //   550: astore 5
    //   552: aload 9
    //   554: bipush 8
    //   556: aload 10
    //   558: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   561: ifnonnull +30 -> 591
    //   564: aload 6
    //   566: astore 5
    //   568: new 121	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   575: aload 6
    //   577: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 339
    //   583: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: astore 7
    //   591: aload 7
    //   593: astore 6
    //   595: aload 7
    //   597: astore 5
    //   599: aload 9
    //   601: bipush 9
    //   603: aload 10
    //   605: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   608: ifnonnull +30 -> 638
    //   611: aload 7
    //   613: astore 5
    //   615: new 121	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   622: aload 7
    //   624: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc_w 341
    //   630: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: astore 6
    //   638: aload 6
    //   640: astore 7
    //   642: aload 6
    //   644: astore 5
    //   646: aload 9
    //   648: bipush 10
    //   650: aload 10
    //   652: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   655: ifnonnull +30 -> 685
    //   658: aload 6
    //   660: astore 5
    //   662: new 121	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   669: aload 6
    //   671: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: ldc_w 343
    //   677: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: astore 7
    //   685: aload 7
    //   687: astore 5
    //   689: aload 9
    //   691: bipush 11
    //   693: aload 10
    //   695: invokevirtual 210	noq:a	(ILnop;)Lnop;
    //   698: ifnonnull +286 -> 984
    //   701: aload 7
    //   703: astore 5
    //   705: new 121	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   712: aload 7
    //   714: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: ldc_w 345
    //   720: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: astore 6
    //   728: aload 6
    //   730: astore 5
    //   732: aload_0
    //   733: aload 9
    //   735: putfield 245	nlx:jdField_a_of_type_Noq	Lnoq;
    //   738: aload 9
    //   740: iconst_5
    //   741: ldc2_w 48
    //   744: invokevirtual 269	noq:a	(IJ)J
    //   747: lstore_3
    //   748: ldc 247
    //   750: iconst_1
    //   751: new 121	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 347
    //   761: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_1
    //   765: invokevirtual 92	java/nio/ByteBuffer:capacity	()I
    //   768: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: ldc_w 352
    //   774: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: lload_3
    //   778: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   781: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: goto -721 -> 66
    //   790: astore 6
    //   792: ldc 247
    //   794: iconst_1
    //   795: ldc_w 354
    //   798: aload 6
    //   800: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   803: new 121	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   810: aload 5
    //   812: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 6
    //   817: invokevirtual 360	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   820: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: astore 5
    //   828: goto -762 -> 66
    //   831: aload 7
    //   833: astore 5
    //   835: aload 10
    //   837: invokevirtual 165	nop:a	()I
    //   840: ifle +104 -> 944
    //   843: aload 7
    //   845: astore 5
    //   847: aload 10
    //   849: iconst_0
    //   850: invokevirtual 363	nop:a	(I)Lnoq;
    //   853: astore 6
    //   855: aload 6
    //   857: ifnull +93 -> 950
    //   860: aload 7
    //   862: astore 5
    //   864: aload 6
    //   866: iconst_0
    //   867: invokevirtual 202	noq:a	(I)Lnop;
    //   870: astore 8
    //   872: aload 7
    //   874: astore 6
    //   876: aload 8
    //   878: ifnull -624 -> 254
    //   881: aload 7
    //   883: astore 6
    //   885: aload 7
    //   887: astore 5
    //   889: aload 8
    //   891: invokevirtual 165	nop:a	()I
    //   894: ifle -640 -> 254
    //   897: aload 7
    //   899: astore 5
    //   901: ldc 247
    //   903: iconst_1
    //   904: new 121	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   911: ldc_w 365
    //   914: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload 8
    //   919: iconst_0
    //   920: invokevirtual 366	nop:a	(I)Ljava/lang/String;
    //   923: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   932: aload 7
    //   934: astore 6
    //   936: goto -682 -> 254
    //   939: astore 6
    //   941: goto -149 -> 792
    //   944: aconst_null
    //   945: astore 6
    //   947: goto -92 -> 855
    //   950: aconst_null
    //   951: astore 8
    //   953: goto -81 -> 872
    //   956: iload_2
    //   957: ifeq +14 -> 971
    //   960: aload_0
    //   961: invokevirtual 257	nlx:a	()Ljava/io/File;
    //   964: astore 6
    //   966: iconst_1
    //   967: istore_2
    //   968: goto -810 -> 158
    //   971: aconst_null
    //   972: astore 6
    //   974: iconst_0
    //   975: istore_2
    //   976: goto -818 -> 158
    //   979: iconst_0
    //   980: istore_2
    //   981: goto -823 -> 158
    //   984: aload 7
    //   986: astore 5
    //   988: goto -256 -> 732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	991	0	this	nlx
    //   0	991	1	paramByteBuffer	ByteBuffer
    //   0	991	2	paramBoolean	boolean
    //   747	31	3	l	long
    //   21	966	5	localObject1	Object
    //   60	669	6	localObject2	Object
    //   790	26	6	localThrowable1	Throwable
    //   853	82	6	localObject3	Object
    //   939	1	6	localThrowable2	Throwable
    //   945	28	6	localFile	File
    //   7	978	7	localObject4	Object
    //   870	82	8	localnop1	nop
    //   27	712	9	localnoq	noq
    //   209	639	10	localnop2	nop
    // Exception table:
    //   from	to	target	type
    //   23	29	193	finally
    //   38	62	193	finally
    //   66	81	193	finally
    //   81	118	193	finally
    //   122	156	193	finally
    //   167	186	193	finally
    //   202	211	193	finally
    //   215	226	193	finally
    //   230	254	193	finally
    //   262	271	193	finally
    //   275	298	193	finally
    //   306	315	193	finally
    //   319	342	193	finally
    //   350	359	193	finally
    //   363	386	193	finally
    //   394	405	193	finally
    //   413	423	193	finally
    //   427	450	193	finally
    //   458	470	193	finally
    //   474	497	193	finally
    //   505	517	193	finally
    //   521	544	193	finally
    //   552	564	193	finally
    //   568	591	193	finally
    //   599	611	193	finally
    //   615	638	193	finally
    //   646	658	193	finally
    //   662	685	193	finally
    //   689	701	193	finally
    //   705	728	193	finally
    //   732	787	193	finally
    //   792	828	193	finally
    //   835	843	193	finally
    //   847	855	193	finally
    //   864	872	193	finally
    //   889	897	193	finally
    //   901	932	193	finally
    //   960	966	193	finally
    //   732	787	790	java/lang/Throwable
    //   23	29	939	java/lang/Throwable
    //   38	62	939	java/lang/Throwable
    //   202	211	939	java/lang/Throwable
    //   215	226	939	java/lang/Throwable
    //   230	254	939	java/lang/Throwable
    //   262	271	939	java/lang/Throwable
    //   275	298	939	java/lang/Throwable
    //   306	315	939	java/lang/Throwable
    //   319	342	939	java/lang/Throwable
    //   350	359	939	java/lang/Throwable
    //   363	386	939	java/lang/Throwable
    //   394	405	939	java/lang/Throwable
    //   413	423	939	java/lang/Throwable
    //   427	450	939	java/lang/Throwable
    //   458	470	939	java/lang/Throwable
    //   474	497	939	java/lang/Throwable
    //   505	517	939	java/lang/Throwable
    //   521	544	939	java/lang/Throwable
    //   552	564	939	java/lang/Throwable
    //   568	591	939	java/lang/Throwable
    //   599	611	939	java/lang/Throwable
    //   615	638	939	java/lang/Throwable
    //   646	658	939	java/lang/Throwable
    //   662	685	939	java/lang/Throwable
    //   689	701	939	java/lang/Throwable
    //   705	728	939	java/lang/Throwable
    //   835	843	939	java/lang/Throwable
    //   847	855	939	java/lang/Throwable
    //   864	872	939	java/lang/Throwable
    //   889	897	939	java/lang/Throwable
    //   901	932	939	java/lang/Throwable
  }
  
  public noq a()
  {
    if (!FlatBuffersParser.a()) {
      return null;
    }
    return this.jdField_a_of_type_Noq;
  }
  
  public JSONArray a(String paramString)
  {
    Object localObject = a();
    if (localObject == null)
    {
      paramString = null;
      return paramString;
    }
    nop localnop = ((noq)localObject).a(((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue());
    if (localnop == null) {
      return null;
    }
    localObject = new JSONArray();
    int i = 0;
    int j = localnop.a();
    for (;;)
    {
      paramString = (String)localObject;
      if (i >= j) {
        break;
      }
      paramString = localnop.a(i);
      if (paramString != null) {
        ((JSONArray)localObject).put(paramString);
      }
      i += 1;
    }
  }
  
  public JSONObject a()
  {
    Object localObject1 = null;
    Object localObject2 = a();
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = ((noq)localObject2).a(12);
      if (localObject3 != null) {
        return new JSONObject((String)localObject3);
      }
      localObject3 = ((noq)localObject2).a(4);
    } while (localObject3 == null);
    localObject2 = new JSONObject();
    noq localnoq = new noq();
    nop localnop1 = new nop();
    nop localnop2 = new nop();
    int k = ((nop)localObject3).a();
    int i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= k) {
        break;
      }
      ((nop)localObject3).a(i, localnoq);
      localnoq.a(0, localnop1);
      localnoq.a(1, localnop2);
      localObject1 = new JSONArray();
      int m = localnop2.a();
      int j = 0;
      String str;
      while (j < m)
      {
        str = localnop2.a(j);
        if (str != null) {
          ((JSONArray)localObject1).put(str);
        }
        j += 1;
      }
      m = localnop1.a();
      j = 0;
      while (j < m)
      {
        str = localnop1.a(j);
        if (str != null) {
          ((JSONObject)localObject2).put(str, localObject1);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 368	com/tencent/biz/flatbuffers/FlatBuffersParser:a	()Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 257	nlx:a	()Ljava/io/File;
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 223	java/io/File:exists	()Z
    //   24: ifeq -14 -> 10
    //   27: aload 5
    //   29: invokevirtual 394	java/io/File:length	()J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifeq -24 -> 10
    //   37: aload 5
    //   39: invokevirtual 397	java/io/File:lastModified	()J
    //   42: lstore_3
    //   43: ldc 247
    //   45: iconst_1
    //   46: new 121	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 399
    //   56: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 51	nlx:jdField_a_of_type_Long	J
    //   63: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: ldc_w 401
    //   69: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_3
    //   73: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 245	nlx:jdField_a_of_type_Noq	Lnoq;
    //   86: ifnull +12 -> 98
    //   89: aload_0
    //   90: getfield 51	nlx:jdField_a_of_type_Long	J
    //   93: lload_3
    //   94: lcmp
    //   95: ifeq -85 -> 10
    //   98: aload_0
    //   99: lload_3
    //   100: putfield 51	nlx:jdField_a_of_type_Long	J
    //   103: aload 5
    //   105: invokevirtual 394	java/io/File:length	()J
    //   108: l2i
    //   109: newarray byte
    //   111: astore 7
    //   113: new 403	java/io/FileInputStream
    //   116: dup
    //   117: aload 5
    //   119: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore 6
    //   124: aload 6
    //   126: astore 5
    //   128: aload 6
    //   130: aload 7
    //   132: invokevirtual 410	java/io/FileInputStream:read	([B)I
    //   135: istore_1
    //   136: aload 6
    //   138: astore 5
    //   140: iload_1
    //   141: aload 7
    //   143: arraylength
    //   144: if_icmpeq +81 -> 225
    //   147: aload 6
    //   149: astore 5
    //   151: ldc 247
    //   153: iconst_1
    //   154: new 121	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 412
    //   164: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: iload_1
    //   168: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc_w 414
    //   174: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 7
    //   179: arraylength
    //   180: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 6
    //   191: ifnull -181 -> 10
    //   194: aload 6
    //   196: invokevirtual 417	java/io/FileInputStream:close	()V
    //   199: goto -189 -> 10
    //   202: astore 5
    //   204: ldc 247
    //   206: iconst_1
    //   207: ldc_w 354
    //   210: aload 5
    //   212: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -205 -> 10
    //   218: astore 5
    //   220: aload_0
    //   221: monitorexit
    //   222: aload 5
    //   224: athrow
    //   225: aload 6
    //   227: ifnull +8 -> 235
    //   230: aload 6
    //   232: invokevirtual 417	java/io/FileInputStream:close	()V
    //   235: aload_0
    //   236: aload 7
    //   238: invokestatic 420	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   241: iconst_0
    //   242: invokevirtual 243	nlx:a	(Ljava/nio/ByteBuffer;Z)Ljava/lang/String;
    //   245: pop
    //   246: ldc 247
    //   248: iconst_1
    //   249: ldc_w 422
    //   252: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: goto -245 -> 10
    //   258: astore 5
    //   260: ldc 247
    //   262: iconst_1
    //   263: ldc_w 354
    //   266: aload 5
    //   268: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -36 -> 235
    //   274: astore 7
    //   276: aconst_null
    //   277: astore 6
    //   279: aload 6
    //   281: astore 5
    //   283: ldc 247
    //   285: iconst_1
    //   286: ldc_w 354
    //   289: aload 7
    //   291: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload 6
    //   296: ifnull -286 -> 10
    //   299: aload 6
    //   301: invokevirtual 417	java/io/FileInputStream:close	()V
    //   304: goto -294 -> 10
    //   307: astore 5
    //   309: ldc 247
    //   311: iconst_1
    //   312: ldc_w 354
    //   315: aload 5
    //   317: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: goto -310 -> 10
    //   323: astore 6
    //   325: aconst_null
    //   326: astore 5
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 417	java/io/FileInputStream:close	()V
    //   338: aload 6
    //   340: athrow
    //   341: astore 5
    //   343: ldc 247
    //   345: iconst_1
    //   346: ldc_w 354
    //   349: aload 5
    //   351: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: goto -16 -> 338
    //   357: astore 6
    //   359: goto -31 -> 328
    //   362: astore 7
    //   364: goto -85 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	nlx
    //   135	33	1	i	int
    //   5	2	2	bool	boolean
    //   42	58	3	l	long
    //   17	133	5	localObject1	Object
    //   202	9	5	localIOException1	java.io.IOException
    //   218	5	5	localObject2	Object
    //   258	9	5	localIOException2	java.io.IOException
    //   281	1	5	localObject3	Object
    //   307	9	5	localIOException3	java.io.IOException
    //   326	8	5	localObject4	Object
    //   341	9	5	localIOException4	java.io.IOException
    //   122	178	6	localFileInputStream	java.io.FileInputStream
    //   323	16	6	localObject5	Object
    //   357	1	6	localObject6	Object
    //   111	126	7	arrayOfByte	byte[]
    //   274	16	7	localThrowable1	Throwable
    //   362	1	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   194	199	202	java/io/IOException
    //   2	6	218	finally
    //   13	98	218	finally
    //   98	103	218	finally
    //   194	199	218	finally
    //   204	215	218	finally
    //   230	235	218	finally
    //   235	255	218	finally
    //   260	271	218	finally
    //   299	304	218	finally
    //   309	320	218	finally
    //   333	338	218	finally
    //   338	341	218	finally
    //   343	354	218	finally
    //   230	235	258	java/io/IOException
    //   103	124	274	java/lang/Throwable
    //   299	304	307	java/io/IOException
    //   103	124	323	finally
    //   333	338	341	java/io/IOException
    //   128	136	357	finally
    //   140	147	357	finally
    //   151	189	357	finally
    //   283	294	357	finally
    //   128	136	362	java/lang/Throwable
    //   140	147	362	java/lang/Throwable
    //   151	189	362	java/lang/Throwable
  }
  
  public void a(nly paramnly)
  {
    this.jdField_a_of_type_Nly = paramnly;
  }
  
  public boolean a()
  {
    return (FlatBuffersParser.a()) && (this.jdField_a_of_type_Noq != null);
  }
  
  /* Error */
  public boolean a(ByteBuffer paramByteBuffer, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 216	java/io/File
    //   6: dup
    //   7: new 121	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   14: aload_2
    //   15: invokevirtual 427	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 432	java/lang/System:nanoTime	()J
    //   24: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 9
    //   35: aconst_null
    //   36: astore 7
    //   38: aconst_null
    //   39: astore 8
    //   41: aload 7
    //   43: astore 6
    //   45: aload 9
    //   47: invokevirtual 435	java/io/File:createNewFile	()Z
    //   50: ifne +71 -> 121
    //   53: aload 7
    //   55: astore 6
    //   57: ldc 247
    //   59: iconst_1
    //   60: new 121	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 437
    //   70: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 427	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 439
    //   84: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iconst_0
    //   94: ifeq +11 -> 105
    //   97: new 441	java/lang/NullPointerException
    //   100: dup
    //   101: invokespecial 442	java/lang/NullPointerException:<init>	()V
    //   104: athrow
    //   105: iload 4
    //   107: ireturn
    //   108: astore_1
    //   109: ldc 247
    //   111: iconst_1
    //   112: ldc_w 444
    //   115: aload_1
    //   116: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload 7
    //   123: astore 6
    //   125: ldc 247
    //   127: iconst_1
    //   128: new 121	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 446
    //   138: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: invokevirtual 449	java/io/File:getName	()Ljava/lang/String;
    //   145: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 7
    //   156: astore 6
    //   158: new 451	java/io/FileOutputStream
    //   161: dup
    //   162: aload 9
    //   164: invokespecial 452	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore 7
    //   169: aload 7
    //   171: aload_1
    //   172: invokestatic 454	nlx:a	(Ljava/io/OutputStream;Ljava/nio/ByteBuffer;)V
    //   175: ldc 247
    //   177: iconst_1
    //   178: ldc_w 456
    //   181: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 7
    //   186: ifnull +8 -> 194
    //   189: aload 7
    //   191: invokevirtual 457	java/io/FileOutputStream:close	()V
    //   194: aload_2
    //   195: invokevirtual 223	java/io/File:exists	()Z
    //   198: ifeq +287 -> 485
    //   201: aload_2
    //   202: invokevirtual 260	java/io/File:delete	()Z
    //   205: istore 4
    //   207: ldc 247
    //   209: iconst_1
    //   210: new 121	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 459
    //   220: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 4
    //   225: invokevirtual 312	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   228: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload 4
    //   236: ifeq +226 -> 462
    //   239: aload 9
    //   241: aload_2
    //   242: invokevirtual 463	java/io/File:renameTo	(Ljava/io/File;)Z
    //   245: istore 5
    //   247: ldc 247
    //   249: iconst_1
    //   250: new 121	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 465
    //   260: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 5
    //   265: invokevirtual 312	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   268: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: iload 5
    //   276: istore 4
    //   278: iload 5
    //   280: ifeq -175 -> 105
    //   283: iload 5
    //   285: istore 4
    //   287: iload_3
    //   288: ifeq -183 -> 105
    //   291: aload_0
    //   292: aload_2
    //   293: invokevirtual 397	java/io/File:lastModified	()J
    //   296: putfield 51	nlx:jdField_a_of_type_Long	J
    //   299: ldc 247
    //   301: iconst_1
    //   302: new 121	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 399
    //   312: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 51	nlx:jdField_a_of_type_Long	J
    //   319: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: aload_0
    //   329: getfield 150	nlx:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   332: invokeinterface 469 1 0
    //   337: astore_1
    //   338: aload_1
    //   339: ldc_w 471
    //   342: ldc_w 292
    //   345: invokeinterface 475 3 0
    //   350: pop
    //   351: aload_1
    //   352: ldc_w 477
    //   355: ldc_w 292
    //   358: invokeinterface 475 3 0
    //   363: pop
    //   364: aload_1
    //   365: invokeinterface 480 1 0
    //   370: pop
    //   371: iload 5
    //   373: ireturn
    //   374: astore_1
    //   375: ldc 247
    //   377: iconst_1
    //   378: ldc_w 444
    //   381: aload_1
    //   382: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   385: goto -191 -> 194
    //   388: astore_2
    //   389: aload 8
    //   391: astore_1
    //   392: aload_1
    //   393: astore 6
    //   395: ldc 247
    //   397: iconst_1
    //   398: ldc_w 482
    //   401: aload_2
    //   402: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 457	java/io/FileOutputStream:close	()V
    //   413: aload 9
    //   415: invokevirtual 260	java/io/File:delete	()Z
    //   418: pop
    //   419: iconst_0
    //   420: ireturn
    //   421: astore_1
    //   422: ldc 247
    //   424: iconst_1
    //   425: ldc_w 444
    //   428: aload_1
    //   429: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: goto -19 -> 413
    //   435: astore_1
    //   436: aload 6
    //   438: ifnull +8 -> 446
    //   441: aload 6
    //   443: invokevirtual 457	java/io/FileOutputStream:close	()V
    //   446: aload_1
    //   447: athrow
    //   448: astore_2
    //   449: ldc 247
    //   451: iconst_1
    //   452: ldc_w 444
    //   455: aload_2
    //   456: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: goto -13 -> 446
    //   462: aload 9
    //   464: invokevirtual 260	java/io/File:delete	()Z
    //   467: pop
    //   468: iconst_0
    //   469: ireturn
    //   470: astore_1
    //   471: aload 7
    //   473: astore 6
    //   475: goto -39 -> 436
    //   478: astore_2
    //   479: aload 7
    //   481: astore_1
    //   482: goto -90 -> 392
    //   485: iconst_1
    //   486: istore 4
    //   488: goto -254 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	nlx
    //   0	491	1	paramByteBuffer	ByteBuffer
    //   0	491	2	paramFile	File
    //   0	491	3	paramBoolean	boolean
    //   1	486	4	bool1	boolean
    //   245	127	5	bool2	boolean
    //   43	431	6	localObject1	Object
    //   36	444	7	localFileOutputStream	java.io.FileOutputStream
    //   39	351	8	localObject2	Object
    //   33	430	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   97	105	108	java/io/IOException
    //   189	194	374	java/io/IOException
    //   45	53	388	java/io/IOException
    //   57	93	388	java/io/IOException
    //   125	154	388	java/io/IOException
    //   158	169	388	java/io/IOException
    //   409	413	421	java/io/IOException
    //   45	53	435	finally
    //   57	93	435	finally
    //   125	154	435	finally
    //   158	169	435	finally
    //   395	405	435	finally
    //   441	446	448	java/io/IOException
    //   169	184	470	finally
    //   169	184	478	java/io/IOException
  }
  
  public File b()
  {
    File localFile = new File(FlatBuffersParser.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "err_authorize.bin");
  }
  
  public String b()
  {
    noq localnoq = a();
    if (localnoq == null) {
      return null;
    }
    return localnoq.a(2);
  }
  
  public void b()
  {
    if ((!FlatBuffersParser.a()) || (this.jdField_a_of_type_Noq != null)) {
      return;
    }
    ThreadManager.post(new FlatBuffersConfig.1(this), 8, null, true);
  }
  
  public String c()
  {
    noq localnoq = a();
    if (localnoq == null) {
      return null;
    }
    return localnoq.a(3);
  }
  
  public void c()
  {
    int i = 0;
    label303:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_Noq;
        if (localObject1 != null) {
          return;
        }
        Object localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmd_config_new", null);
        if (localObject3 != null)
        {
          try
          {
            localObject1 = new StringBuilder(((String)localObject3).length() + 10240);
            ((StringBuilder)localObject1).append("{");
            ((StringBuilder)localObject1).append("allow:");
            ((StringBuilder)localObject1).append((String)localObject3);
            a((StringBuilder)localObject1, "offlineHtml", "offline", false);
            a((StringBuilder)localObject1, "extra", "ext", false);
            a((StringBuilder)localObject1, "jump", "jump", false);
            a((StringBuilder)localObject1, "schemes", "schemes_map", true);
            localObject3 = niz.a;
            int j = localObject3.length;
            if (i < j)
            {
              String str = localObject3[i];
              a((StringBuilder)localObject1, str, str, false);
              i += 1;
              continue;
            }
            ((StringBuilder)localObject1).append(",publishSeq:" + this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", -1L));
            ((StringBuilder)localObject1).append("}");
            a(this.jdField_a_of_type_ComTencentBizFlatbuffersFlatBuffersParser.a(((StringBuilder)localObject1).toString(), "namespace com.tencent.biz.flatbuffers;\n\nattribute \"qq_map\";\n\ntable JsApi {\n\tmatch:[string];\n\tapi:[string];\n}\n\ntable Extra (qq_map) {\n}\n\ntable Schema {\n\tmatch:[string];\n\tscheme:[string];\n}\n\ntable AuthorizeTable {\n  allow:[JsApi];\n  offline:Extra;\n  ext:Extra;\n  jump:Extra;\n  schemes:[Schema];\n  publishSeq:long;\n  \n  skey:[string];\n  pskey:[string];\n  a1:[string];\n  a2:[string];\n  ptlogin2:[string];\n  pt4_token:[string];\n  schemes_map:string;\n}\n\nroot_type AuthorizeTable;\n"), true);
            if (this.jdField_a_of_type_Noq == null) {
              break label303;
            }
            QLog.i("AuthorizeConfig", 1, "flatbuffers convertJson2FlatBuffers success with publishSeq: " + this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", -1L));
            this.jdField_a_of_type_Nly.a();
          }
          catch (Throwable localThrowable)
          {
            QLog.e("AuthorizeConfig", 1, "convertJson2FlatBuffers error!", localThrowable);
          }
          continue;
          QLog.i("AuthorizeConfig", 1, "flatbuffers convertJson2FlatBuffers failed");
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlx
 * JD-Core Version:    0.7.0.1
 */