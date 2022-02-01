package com.tencent.mobileqq.kandian.biz.pts.realtime;

import android.os.Environment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RealTimeStyleLoaderHelper
{
  private static String a;
  private String b;
  private String c;
  private boolean d;
  private String e;
  private boolean f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/tencent/MobileQQ/pddata/");
    localStringBuilder.append("proteus/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public RealTimeStyleLoaderHelper(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  /* Error */
  private File a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 16	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 62
    //   11: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_2
    //   17: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: ldc 64
    //   23: iconst_1
    //   24: aload_3
    //   25: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: new 16	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_3
    //   40: aload_0
    //   41: invokespecial 71	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:b	()Ljava/lang/String;
    //   44: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ldc 73
    //   51: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: aload_2
    //   57: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: new 27	java/io/File
    //   64: dup
    //   65: aload_3
    //   66: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 6
    //   74: aload 6
    //   76: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
    //   79: invokestatic 84	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/File;)Z
    //   82: pop
    //   83: aload 6
    //   85: invokevirtual 88	java/io/File:exists	()Z
    //   88: ifne +11 -> 99
    //   91: aload 6
    //   93: invokevirtual 91	java/io/File:isDirectory	()Z
    //   96: ifeq +8 -> 104
    //   99: aload 6
    //   101: invokevirtual 94	java/io/File:deleteOnExit	()V
    //   104: new 96	java/io/BufferedOutputStream
    //   107: dup
    //   108: new 98	java/io/FileOutputStream
    //   111: dup
    //   112: aload 6
    //   114: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: invokespecial 104	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   120: astore 4
    //   122: new 106	java/io/ByteArrayInputStream
    //   125: dup
    //   126: aload_1
    //   127: invokevirtual 112	java/lang/String:getBytes	()[B
    //   130: invokespecial 115	java/io/ByteArrayInputStream:<init>	([B)V
    //   133: astore_1
    //   134: aload 4
    //   136: astore_3
    //   137: aload_1
    //   138: astore 5
    //   140: aload_1
    //   141: aload 4
    //   143: invokestatic 118	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   146: pop2
    //   147: aload_1
    //   148: invokestatic 121	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/Closeable;)V
    //   151: aload 4
    //   153: invokestatic 121	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/Closeable;)V
    //   156: aload 6
    //   158: areturn
    //   159: astore 6
    //   161: goto +37 -> 198
    //   164: astore_1
    //   165: aconst_null
    //   166: astore 5
    //   168: aload 4
    //   170: astore_3
    //   171: goto +100 -> 271
    //   174: astore 6
    //   176: aconst_null
    //   177: astore_1
    //   178: goto +20 -> 198
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_3
    //   185: astore 5
    //   187: goto +84 -> 271
    //   190: astore 6
    //   192: aconst_null
    //   193: astore 4
    //   195: aload 4
    //   197: astore_1
    //   198: aload 4
    //   200: astore_3
    //   201: aload_1
    //   202: astore 5
    //   204: new 16	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   211: astore 7
    //   213: aload 4
    //   215: astore_3
    //   216: aload_1
    //   217: astore 5
    //   219: aload 7
    //   221: ldc 123
    //   223: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 4
    //   229: astore_3
    //   230: aload_1
    //   231: astore 5
    //   233: aload 7
    //   235: aload_2
    //   236: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: astore_3
    //   243: aload_1
    //   244: astore 5
    //   246: ldc 64
    //   248: iconst_1
    //   249: aload 7
    //   251: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload 6
    //   256: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_1
    //   260: invokestatic 121	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/Closeable;)V
    //   263: aload 4
    //   265: invokestatic 121	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/Closeable;)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_1
    //   271: aload 5
    //   273: invokestatic 121	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/Closeable;)V
    //   276: aload_3
    //   277: invokestatic 121	com/tencent/mobileqq/kandian/biz/pts/util/FileUtils:a	(Ljava/io/Closeable;)V
    //   280: aload_1
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	RealTimeStyleLoaderHelper
    //   0	282	1	paramString1	String
    //   0	282	2	paramString2	String
    //   7	270	3	localObject1	Object
    //   120	144	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   138	134	5	localObject2	Object
    //   72	85	6	localFile	File
    //   159	1	6	localException1	java.lang.Exception
    //   174	1	6	localException2	java.lang.Exception
    //   190	65	6	localException3	java.lang.Exception
    //   211	39	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   140	147	159	java/lang/Exception
    //   122	134	164	finally
    //   122	134	174	java/lang/Exception
    //   104	122	181	finally
    //   104	122	190	java/lang/Exception
    //   140	147	270	finally
    //   204	213	270	finally
    //   219	227	270	finally
    //   233	240	270	finally
    //   246	259	270	finally
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(RIJQQAppInterfaceUtil.d());
    localStringBuilder.append("/");
    localStringBuilder.append(this.c);
    localStringBuilder.append("/");
    localStringBuilder.append("styles");
    return localStringBuilder.toString();
  }
  
  private boolean c()
  {
    String str = this.e;
    if (str == null) {
      return true;
    }
    return str.equals(RIJQQAppInterfaceUtil.d()) ^ true;
  }
  
  public RealTimeTemplateFactory a()
  {
    return a(true);
  }
  
  /* Error */
  public RealTimeTemplateFactory a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +45 -> 46
    //   4: aload_0
    //   5: getfield 149	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:d	Z
    //   8: ifeq +38 -> 46
    //   11: aload_0
    //   12: invokespecial 151	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:c	()Z
    //   15: ifne +31 -> 46
    //   18: aload_0
    //   19: getfield 55	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:b	Ljava/lang/String;
    //   22: iconst_0
    //   23: invokestatic 156	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory:b	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory;
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +13 -> 43
    //   33: aload_0
    //   34: getfield 158	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:f	Z
    //   37: ifeq +6 -> 43
    //   40: goto +6 -> 46
    //   43: aload 4
    //   45: areturn
    //   46: aload_0
    //   47: invokestatic 131	com/tencent/mobileqq/kandian/base/utils/RIJQQAppInterfaceUtil:d	()Ljava/lang/String;
    //   50: putfield 135	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:e	Ljava/lang/String;
    //   53: new 153	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory
    //   56: dup
    //   57: invokespecial 159	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory:<init>	()V
    //   60: astore 4
    //   62: aload 4
    //   64: invokestatic 164	com/tencent/mobileqq/kandian/biz/pts/loaders/StyleLoaderHelper:b	()I
    //   67: invokevirtual 167	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory:a	(I)V
    //   70: aload 4
    //   72: aload_0
    //   73: getfield 55	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:b	Ljava/lang/String;
    //   76: invokevirtual 169	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory:b	(Ljava/lang/String;)V
    //   79: aload 4
    //   81: iconst_3
    //   82: invokevirtual 167	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory:a	(I)V
    //   85: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   88: lstore_2
    //   89: new 177	com/tencent/mobileqq/kandian/biz/pts/loaders/file/ReadSdcardFile
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 71	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:b	()Ljava/lang/String;
    //   97: invokespecial 178	com/tencent/mobileqq/kandian/biz/pts/loaders/file/ReadSdcardFile:<init>	(Ljava/lang/String;)V
    //   100: astore 6
    //   102: aload 6
    //   104: invokeinterface 183 1 0
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +312 -> 425
    //   116: aload 5
    //   118: invokeinterface 189 1 0
    //   123: astore 7
    //   125: aload 7
    //   127: invokeinterface 194 1 0
    //   132: ifeq +233 -> 365
    //   135: aload 7
    //   137: invokeinterface 198 1 0
    //   142: checkcast 108	java/lang/String
    //   145: astore 5
    //   147: new 16	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   154: astore 8
    //   156: aload 8
    //   158: ldc 200
    //   160: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 8
    //   166: aload 5
    //   168: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 64
    //   174: iconst_1
    //   175: aload 8
    //   177: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload 6
    //   185: aload 5
    //   187: invokeinterface 203 2 0
    //   192: astore 8
    //   194: aload 8
    //   196: ifnonnull +42 -> 238
    //   199: new 16	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   206: astore 8
    //   208: aload 8
    //   210: ldc 205
    //   212: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 8
    //   218: aload 5
    //   220: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 64
    //   226: iconst_2
    //   227: aload 8
    //   229: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: goto -110 -> 125
    //   238: aload 8
    //   240: invokestatic 210	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   243: astore 8
    //   245: aload_0
    //   246: aload 4
    //   248: new 212	org/json/JSONObject
    //   251: dup
    //   252: aload 8
    //   254: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   257: iconst_0
    //   258: invokevirtual 216	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:a	(Lcom/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeTemplateFactory;Lorg/json/JSONObject;Z)V
    //   261: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq -139 -> 125
    //   267: new 16	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   274: astore 9
    //   276: aload 9
    //   278: ldc 200
    //   280: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 9
    //   286: aload 5
    //   288: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 9
    //   294: ldc 221
    //   296: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 9
    //   302: aload 8
    //   304: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 64
    //   310: iconst_1
    //   311: aload 9
    //   313: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: goto -194 -> 125
    //   322: astore 4
    //   324: new 16	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   331: astore 6
    //   333: aload 6
    //   335: ldc 223
    //   337: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 6
    //   343: aload 5
    //   345: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: ldc 64
    //   351: iconst_1
    //   352: aload 6
    //   354: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload 4
    //   359: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload 4
    //   364: athrow
    //   365: new 16	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   372: astore 5
    //   374: aload 5
    //   376: ldc 225
    //   378: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 5
    //   384: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   387: lload_2
    //   388: lsub
    //   389: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: ldc 64
    //   395: iconst_2
    //   396: aload 5
    //   398: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: aload_0
    //   405: iconst_1
    //   406: putfield 149	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:d	Z
    //   409: aload_0
    //   410: iconst_1
    //   411: putfield 158	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:f	Z
    //   414: ldc 64
    //   416: iconst_1
    //   417: ldc 230
    //   419: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload 4
    //   424: areturn
    //   425: ldc 64
    //   427: iconst_1
    //   428: ldc 232
    //   430: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_0
    //   434: iconst_1
    //   435: putfield 149	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:d	Z
    //   438: aconst_null
    //   439: areturn
    //   440: astore 4
    //   442: goto +51 -> 493
    //   445: astore 4
    //   447: ldc 64
    //   449: iconst_1
    //   450: ldc 234
    //   452: aload 4
    //   454: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   457: aload_0
    //   458: iconst_0
    //   459: putfield 158	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:f	Z
    //   462: aload_0
    //   463: iconst_1
    //   464: putfield 149	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:d	Z
    //   467: aconst_null
    //   468: areturn
    //   469: astore 4
    //   471: ldc 64
    //   473: iconst_1
    //   474: ldc 236
    //   476: aload 4
    //   478: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: aload_0
    //   482: iconst_0
    //   483: putfield 158	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:f	Z
    //   486: aload_0
    //   487: iconst_1
    //   488: putfield 149	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:d	Z
    //   491: aconst_null
    //   492: areturn
    //   493: aload_0
    //   494: iconst_1
    //   495: putfield 149	com/tencent/mobileqq/kandian/biz/pts/realtime/RealTimeStyleLoaderHelper:d	Z
    //   498: goto +6 -> 504
    //   501: aload 4
    //   503: athrow
    //   504: goto -3 -> 501
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	RealTimeStyleLoaderHelper
    //   0	507	1	paramBoolean	boolean
    //   88	300	2	l	long
    //   26	221	4	localRealTimeTemplateFactory	RealTimeTemplateFactory
    //   322	101	4	localJSONException	org.json.JSONException
    //   440	1	4	localObject1	Object
    //   445	8	4	localException	java.lang.Exception
    //   469	33	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   109	288	5	localObject2	Object
    //   100	253	6	localObject3	Object
    //   123	13	7	localIterator	Iterator
    //   154	149	8	localObject4	Object
    //   274	38	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   147	194	322	org/json/JSONException
    //   199	235	322	org/json/JSONException
    //   238	319	322	org/json/JSONException
    //   89	111	440	finally
    //   116	125	440	finally
    //   125	147	440	finally
    //   147	194	440	finally
    //   199	235	440	finally
    //   238	319	440	finally
    //   324	365	440	finally
    //   365	404	440	finally
    //   425	433	440	finally
    //   447	462	440	finally
    //   471	486	440	finally
    //   89	111	445	java/lang/Exception
    //   116	125	445	java/lang/Exception
    //   125	147	445	java/lang/Exception
    //   147	194	445	java/lang/Exception
    //   199	235	445	java/lang/Exception
    //   238	319	445	java/lang/Exception
    //   324	365	445	java/lang/Exception
    //   365	404	445	java/lang/Exception
    //   425	433	445	java/lang/Exception
    //   89	111	469	java/lang/OutOfMemoryError
    //   116	125	469	java/lang/OutOfMemoryError
    //   125	147	469	java/lang/OutOfMemoryError
    //   147	194	469	java/lang/OutOfMemoryError
    //   199	235	469	java/lang/OutOfMemoryError
    //   238	319	469	java/lang/OutOfMemoryError
    //   324	365	469	java/lang/OutOfMemoryError
    //   365	404	469	java/lang/OutOfMemoryError
    //   425	433	469	java/lang/OutOfMemoryError
  }
  
  public void a(RealTimeTemplateFactory paramRealTimeTemplateFactory, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return;
    }
    ProteusParser localProteusParser = new ProteusParser();
    String str1 = paramJSONObject.getString("id");
    String str2 = paramJSONObject.getString("version");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("style");
    paramRealTimeTemplateFactory.a(str1, str2, (String)localJSONObject.keys().next());
    localProteusParser.createViewTemplate(paramRealTimeTemplateFactory, localJSONObject, null);
    if ((paramBoolean) && (str1 != null)) {
      a(paramJSONObject.toString(), str1);
    }
  }
  
  public void a(List<String> paramList)
  {
    ThreadManager.executeOnFileThread(new RealTimeStyleLoaderHelper.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeStyleLoaderHelper
 * JD-Core Version:    0.7.0.1
 */