package com.tencent.mobileqq.qqalbum.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qqalbum.PicData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PicToJpgImpl
  implements IPicToJpg
{
  public static final String FILE_TYPE_HEIF = "heif";
  
  public boolean compressQuality(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2)
  {
    return ((IPicUtil)QRoute.api(IPicUtil.class)).compressQuality(paramString1, paramBitmap, paramInt, paramString2, null);
  }
  
  /* Error */
  public String fileType(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 36
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: iload_2
    //   11: ifeq +21 -> 32
    //   14: new 38	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: checkcast 36	java/lang/String
    //   22: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aconst_null
    //   27: astore 5
    //   29: goto +74 -> 103
    //   32: aload_1
    //   33: instanceof 43
    //   36: ifeq +21 -> 57
    //   39: new 38	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: checkcast 43	java/net/URL
    //   47: invokevirtual 47	java/net/URL:getFile	()Ljava/lang/String;
    //   50: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: goto -28 -> 26
    //   57: aload_1
    //   58: instanceof 49
    //   61: ifeq +18 -> 79
    //   64: new 38	java/io/File
    //   67: dup
    //   68: aload_1
    //   69: checkcast 49	java/net/URI
    //   72: invokespecial 52	java/io/File:<init>	(Ljava/net/URI;)V
    //   75: astore_1
    //   76: goto -50 -> 26
    //   79: aload_1
    //   80: instanceof 54
    //   83: ifeq +14 -> 97
    //   86: aload_1
    //   87: checkcast 54	java/io/FileDescriptor
    //   90: astore 5
    //   92: aconst_null
    //   93: astore_1
    //   94: goto +9 -> 103
    //   97: aconst_null
    //   98: astore 5
    //   100: aload 5
    //   102: astore_1
    //   103: aload_1
    //   104: ifnonnull +12 -> 116
    //   107: aload 5
    //   109: ifnonnull +7 -> 116
    //   112: getstatic 59	com/tencent/mobileqq/utils/FileUtils:unKnownFileTypeMark	Ljava/lang/String;
    //   115: areturn
    //   116: aload_1
    //   117: ifnull +15 -> 132
    //   120: new 61	java/io/FileInputStream
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: astore_1
    //   129: goto +13 -> 142
    //   132: new 61	java/io/FileInputStream
    //   135: dup
    //   136: aload 5
    //   138: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   141: astore_1
    //   142: aload_1
    //   143: astore_3
    //   144: aload_1
    //   145: astore 4
    //   147: iconst_2
    //   148: newarray byte
    //   150: astore 5
    //   152: aload_1
    //   153: astore_3
    //   154: aload_1
    //   155: astore 4
    //   157: aload_1
    //   158: aload 5
    //   160: invokevirtual 71	java/io/FileInputStream:read	([B)I
    //   163: iconst_m1
    //   164: if_icmpeq +30 -> 194
    //   167: aload_1
    //   168: astore_3
    //   169: aload_1
    //   170: astore 4
    //   172: aload 5
    //   174: invokestatic 75	com/tencent/mobileqq/utils/FileUtils:estimateFileType	([B)Ljava/lang/String;
    //   177: astore 5
    //   179: aload_1
    //   180: invokevirtual 78	java/io/FileInputStream:close	()V
    //   183: aload 5
    //   185: areturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   191: aload 5
    //   193: areturn
    //   194: aload_1
    //   195: invokevirtual 78	java/io/FileInputStream:close	()V
    //   198: goto +33 -> 231
    //   201: astore_1
    //   202: goto +33 -> 235
    //   205: astore_1
    //   206: aload 4
    //   208: astore_3
    //   209: aload_1
    //   210: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   213: aload 4
    //   215: ifnull +16 -> 231
    //   218: aload 4
    //   220: invokevirtual 78	java/io/FileInputStream:close	()V
    //   223: goto +8 -> 231
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   231: getstatic 59	com/tencent/mobileqq/utils/FileUtils:unKnownFileTypeMark	Ljava/lang/String;
    //   234: areturn
    //   235: aload_3
    //   236: ifnull +15 -> 251
    //   239: aload_3
    //   240: invokevirtual 78	java/io/FileInputStream:close	()V
    //   243: goto +8 -> 251
    //   246: astore_3
    //   247: aload_3
    //   248: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   251: goto +5 -> 256
    //   254: aload_1
    //   255: athrow
    //   256: goto -2 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	PicToJpgImpl
    //   0	259	1	paramObject	Object
    //   4	7	2	bool	boolean
    //   9	231	3	localObject1	Object
    //   246	2	3	localIOException	java.io.IOException
    //   6	213	4	localObject2	Object
    //   27	165	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   179	183	186	java/io/IOException
    //   120	129	201	finally
    //   132	142	201	finally
    //   147	152	201	finally
    //   157	167	201	finally
    //   172	179	201	finally
    //   209	213	201	finally
    //   120	129	205	java/lang/Exception
    //   132	142	205	java/lang/Exception
    //   147	152	205	java/lang/Exception
    //   157	167	205	java/lang/Exception
    //   172	179	205	java/lang/Exception
    //   194	198	226	java/io/IOException
    //   218	223	226	java/io/IOException
    //   239	243	246	java/io/IOException
  }
  
  public Matrix getMatrixByOrientation(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    switch (paramInt)
    {
    default: 
      return null;
    case 8: 
      localMatrix.setRotate(-90.0F);
      return localMatrix;
    case 7: 
      localMatrix.setRotate(-90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 6: 
      localMatrix.setRotate(90.0F);
      return localMatrix;
    case 5: 
      localMatrix.setRotate(90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 4: 
      localMatrix.setRotate(180.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 3: 
      localMatrix.setRotate(180.0F);
      return localMatrix;
    }
    localMatrix.setScale(-1.0F, 1.0F);
    return localMatrix;
  }
  
  /* Error */
  public int getOrientation(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 36
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: iload 4
    //   17: ifeq +24 -> 41
    //   20: new 38	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: checkcast 36	java/lang/String
    //   28: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aconst_null
    //   33: astore 6
    //   35: aload_1
    //   36: astore 5
    //   38: goto +76 -> 114
    //   41: aload_1
    //   42: instanceof 43
    //   45: ifeq +21 -> 66
    //   48: new 38	java/io/File
    //   51: dup
    //   52: aload_1
    //   53: checkcast 43	java/net/URL
    //   56: invokevirtual 47	java/net/URL:getFile	()Ljava/lang/String;
    //   59: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: goto -31 -> 32
    //   66: aload_1
    //   67: instanceof 49
    //   70: ifeq +18 -> 88
    //   73: new 38	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: checkcast 49	java/net/URI
    //   81: invokespecial 52	java/io/File:<init>	(Ljava/net/URI;)V
    //   84: astore_1
    //   85: goto -53 -> 32
    //   88: aload_1
    //   89: instanceof 54
    //   92: ifeq +15 -> 107
    //   95: aload_1
    //   96: checkcast 54	java/io/FileDescriptor
    //   99: astore 6
    //   101: aconst_null
    //   102: astore 5
    //   104: goto +10 -> 114
    //   107: aconst_null
    //   108: astore 6
    //   110: aload 6
    //   112: astore 5
    //   114: iconst_0
    //   115: istore_3
    //   116: iconst_0
    //   117: istore_2
    //   118: aload 5
    //   120: ifnonnull +10 -> 130
    //   123: aload 6
    //   125: ifnonnull +5 -> 130
    //   128: iconst_0
    //   129: ireturn
    //   130: aload 5
    //   132: ifnull +23 -> 155
    //   135: aload 9
    //   137: astore_1
    //   138: new 61	java/io/FileInputStream
    //   141: dup
    //   142: aload 5
    //   144: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   147: astore 5
    //   149: aload 5
    //   151: astore_1
    //   152: goto +20 -> 172
    //   155: aload 9
    //   157: astore_1
    //   158: new 61	java/io/FileInputStream
    //   161: dup
    //   162: aload 6
    //   164: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   167: astore 5
    //   169: aload 5
    //   171: astore_1
    //   172: aload 7
    //   174: astore 5
    //   176: getstatic 111	android/os/Build$VERSION:SDK_INT	I
    //   179: bipush 24
    //   181: if_icmplt +13 -> 194
    //   184: new 113	android/media/ExifInterface
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 116	android/media/ExifInterface:<init>	(Ljava/io/InputStream;)V
    //   192: astore 5
    //   194: aload 5
    //   196: ifnull +12 -> 208
    //   199: aload 5
    //   201: ldc 118
    //   203: iconst_1
    //   204: invokevirtual 122	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   207: istore_2
    //   208: iload_2
    //   209: istore_3
    //   210: aload_1
    //   211: invokevirtual 78	java/io/FileInputStream:close	()V
    //   214: iload_2
    //   215: ireturn
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   221: iload_3
    //   222: ireturn
    //   223: astore 5
    //   225: goto +42 -> 267
    //   228: astore 6
    //   230: aload_1
    //   231: astore 5
    //   233: goto +14 -> 247
    //   236: astore 5
    //   238: goto +29 -> 267
    //   241: astore 6
    //   243: aload 8
    //   245: astore 5
    //   247: aload 5
    //   249: astore_1
    //   250: aload 6
    //   252: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   255: aload 5
    //   257: ifnull +8 -> 265
    //   260: aload 5
    //   262: invokevirtual 78	java/io/FileInputStream:close	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: aload_1
    //   268: ifnull +15 -> 283
    //   271: aload_1
    //   272: invokevirtual 78	java/io/FileInputStream:close	()V
    //   275: goto +8 -> 283
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   283: goto +6 -> 289
    //   286: aload 5
    //   288: athrow
    //   289: goto -3 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	PicToJpgImpl
    //   0	292	1	paramObject	Object
    //   117	98	2	i	int
    //   115	107	3	j	int
    //   4	12	4	bool	boolean
    //   36	164	5	localObject1	Object
    //   223	1	5	localObject2	Object
    //   231	1	5	localObject3	Object
    //   236	1	5	localObject4	Object
    //   245	42	5	localObject5	Object
    //   33	130	6	localFileDescriptor	java.io.FileDescriptor
    //   228	1	6	localException1	java.lang.Exception
    //   241	10	6	localException2	java.lang.Exception
    //   13	160	7	localObject6	Object
    //   10	234	8	localObject7	Object
    //   7	149	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   210	214	216	java/io/IOException
    //   260	265	216	java/io/IOException
    //   176	194	223	finally
    //   199	208	223	finally
    //   176	194	228	java/lang/Exception
    //   199	208	228	java/lang/Exception
    //   138	149	236	finally
    //   158	169	236	finally
    //   250	255	236	finally
    //   138	149	241	java/lang/Exception
    //   158	169	241	java/lang/Exception
    //   271	275	278	java/io/IOException
  }
  
  /* Error */
  public boolean isHeif(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 36
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: iload 5
    //   14: ifeq +21 -> 35
    //   17: new 38	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: checkcast 36	java/lang/String
    //   25: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aconst_null
    //   30: astore 8
    //   32: goto +74 -> 106
    //   35: aload_1
    //   36: instanceof 43
    //   39: ifeq +21 -> 60
    //   42: new 38	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: checkcast 43	java/net/URL
    //   50: invokevirtual 47	java/net/URL:getFile	()Ljava/lang/String;
    //   53: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_1
    //   57: goto -28 -> 29
    //   60: aload_1
    //   61: instanceof 49
    //   64: ifeq +18 -> 82
    //   67: new 38	java/io/File
    //   70: dup
    //   71: aload_1
    //   72: checkcast 49	java/net/URI
    //   75: invokespecial 52	java/io/File:<init>	(Ljava/net/URI;)V
    //   78: astore_1
    //   79: goto -50 -> 29
    //   82: aload_1
    //   83: instanceof 54
    //   86: ifeq +14 -> 100
    //   89: aload_1
    //   90: checkcast 54	java/io/FileDescriptor
    //   93: astore 8
    //   95: aconst_null
    //   96: astore_1
    //   97: goto +9 -> 106
    //   100: aconst_null
    //   101: astore 8
    //   103: aload 8
    //   105: astore_1
    //   106: aload_1
    //   107: ifnonnull +10 -> 117
    //   110: aload 8
    //   112: ifnonnull +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_1
    //   118: ifnull +15 -> 133
    //   121: new 61	java/io/FileInputStream
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore_1
    //   130: goto +13 -> 143
    //   133: new 61	java/io/FileInputStream
    //   136: dup
    //   137: aload 8
    //   139: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   142: astore_1
    //   143: aload_1
    //   144: astore 6
    //   146: aload_1
    //   147: astore 7
    //   149: getstatic 130	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   152: arraylength
    //   153: newarray byte
    //   155: astore 8
    //   157: aload_1
    //   158: astore 6
    //   160: aload_1
    //   161: astore 7
    //   163: aload_1
    //   164: aload 8
    //   166: invokevirtual 71	java/io/FileInputStream:read	([B)I
    //   169: pop
    //   170: iconst_0
    //   171: istore_2
    //   172: aload_1
    //   173: astore 6
    //   175: aload_1
    //   176: astore 7
    //   178: iload_2
    //   179: getstatic 130	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   182: arraylength
    //   183: if_icmpge +47 -> 230
    //   186: aload 8
    //   188: iload_2
    //   189: baload
    //   190: istore_3
    //   191: aload_1
    //   192: astore 6
    //   194: aload_1
    //   195: astore 7
    //   197: getstatic 130	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   200: iload_2
    //   201: baload
    //   202: istore 4
    //   204: iload_3
    //   205: iload 4
    //   207: if_icmpeq +16 -> 223
    //   210: aload_1
    //   211: invokevirtual 78	java/io/FileInputStream:close	()V
    //   214: iconst_0
    //   215: ireturn
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   221: iconst_0
    //   222: ireturn
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -55 -> 172
    //   230: aload_1
    //   231: invokevirtual 78	java/io/FileInputStream:close	()V
    //   234: goto +8 -> 242
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   242: iconst_1
    //   243: ireturn
    //   244: astore_1
    //   245: goto +31 -> 276
    //   248: astore_1
    //   249: aload 7
    //   251: astore 6
    //   253: aload_1
    //   254: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   257: aload 7
    //   259: ifnull +15 -> 274
    //   262: aload 7
    //   264: invokevirtual 78	java/io/FileInputStream:close	()V
    //   267: iconst_0
    //   268: ireturn
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: aload 6
    //   278: ifnull +18 -> 296
    //   281: aload 6
    //   283: invokevirtual 78	java/io/FileInputStream:close	()V
    //   286: goto +10 -> 296
    //   289: astore 6
    //   291: aload 6
    //   293: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   296: goto +5 -> 301
    //   299: aload_1
    //   300: athrow
    //   301: goto -2 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	PicToJpgImpl
    //   0	304	1	paramObject	Object
    //   171	56	2	i	int
    //   190	18	3	j	int
    //   202	6	4	k	int
    //   4	9	5	bool	boolean
    //   10	272	6	localObject1	Object
    //   289	3	6	localException	java.lang.Exception
    //   7	256	7	localObject2	Object
    //   30	157	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   210	214	216	java/lang/Exception
    //   230	234	237	java/lang/Exception
    //   121	130	244	finally
    //   133	143	244	finally
    //   149	157	244	finally
    //   163	170	244	finally
    //   178	186	244	finally
    //   197	204	244	finally
    //   253	257	244	finally
    //   121	130	248	java/io/IOException
    //   133	143	248	java/io/IOException
    //   149	157	248	java/io/IOException
    //   163	170	248	java/io/IOException
    //   178	186	248	java/io/IOException
    //   197	204	248	java/io/IOException
    //   262	267	269	java/lang/Exception
    //   281	286	289	java/lang/Exception
  }
  
  public boolean picToJpg(PicData paramPicData)
  {
    String str;
    if (isHeif(paramPicData)) {
      str = "heif";
    } else {
      str = fileType(paramPicData);
    }
    int i = -1;
    int j = str.hashCode();
    if (j != 3198682)
    {
      if ((j == 3645340) && (str.equals("webp"))) {
        i = 0;
      }
    }
    else if (str.equals("heif")) {
      i = 1;
    }
    if ((i != 0) && (i != 1)) {
      return false;
    }
    return transToJpg(paramPicData);
  }
  
  public boolean transToJpg(PicData paramPicData)
  {
    if (paramPicData != null)
    {
      Object localObject1 = new BitmapFactory.Options();
      int i = getOrientation(paramPicData.jdField_a_of_type_JavaLangObject);
      Matrix localMatrix = getMatrixByOrientation(i);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("generate ");
      ((StringBuilder)localObject2).append("PicToJpg");
      ((StringBuilder)localObject2).append(",sourcePath:");
      ((StringBuilder)localObject2).append(paramPicData.jdField_a_of_type_JavaLangObject);
      ((StringBuilder)localObject2).append(",targetPath:");
      ((StringBuilder)localObject2).append(paramPicData.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(",orientation:");
      ((StringBuilder)localObject2).append(i);
      if (QLog.isColorLevel()) {
        QLog.d("PicToJpg", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = SafeBitmapFactory.safeDecode(paramPicData.jdField_a_of_type_JavaLangObject, (BitmapFactory.Options)localObject1);
      localObject1 = localObject2;
      if (localMatrix != null) {
        localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), localMatrix, true);
      }
      return compressQuality(paramPicData.jdField_a_of_type_JavaLangString, (Bitmap)localObject1, paramPicData.jdField_a_of_type_Int, "PicToJpg");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.impl.PicToJpgImpl
 * JD-Core Version:    0.7.0.1
 */