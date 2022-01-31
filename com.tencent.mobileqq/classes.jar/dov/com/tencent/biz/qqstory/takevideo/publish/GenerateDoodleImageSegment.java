package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditFilterExport;
import java.lang.ref.WeakReference;

public class GenerateDoodleImageSegment
  extends MeasureJobSegment
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference a;
  public final WeakReference b;
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport)
  {
    this(paramEditDoodleExport, null, 0);
  }
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
  {
    if (paramEditDoodleExport == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditDoodleExport);
    this.b = new WeakReference(paramEditFilterExport);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + paramBitmap);
        }
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: invokestatic 130	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 7
    //   5: aload_2
    //   6: getfield 133	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +31 -> 45
    //   17: aload_0
    //   18: new 141	com/tencent/biz/qqstory/base/ErrorMessage
    //   21: dup
    //   22: iconst_m1
    //   23: ldc 143
    //   25: invokespecial 146	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   28: invokespecial 150	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   31: ldc 152
    //   33: ldc 154
    //   35: iconst_0
    //   36: iconst_m1
    //   37: iconst_0
    //   38: anewarray 156	java/lang/String
    //   41: invokestatic 161	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 37	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   49: invokevirtual 165	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   52: checkcast 167	dov/com/tencent/biz/qqstory/takevideo/EditDoodleExport
    //   55: astore 14
    //   57: aload_0
    //   58: getfield 39	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:b	Ljava/lang/ref/WeakReference;
    //   61: invokevirtual 165	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   64: checkcast 169	dov/com/tencent/biz/qqstory/takevideo/EditFilterExport
    //   67: astore 15
    //   69: aload 14
    //   71: ifnull +836 -> 907
    //   74: aload 14
    //   76: aload_0
    //   77: getfield 43	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   80: invokeinterface 172 2 0
    //   85: ifeq +22 -> 107
    //   88: aload 15
    //   90: ifnull +817 -> 907
    //   93: aload 15
    //   95: aload_0
    //   96: getfield 43	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   99: invokeinterface 173 2 0
    //   104: ifeq +803 -> 907
    //   107: aload 14
    //   109: invokeinterface 176 1 0
    //   114: aload_0
    //   115: getfield 43	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   118: invokevirtual 181	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(I)Landroid/graphics/Bitmap;
    //   121: astore 12
    //   123: aload 12
    //   125: ifnull +44 -> 169
    //   128: aload_2
    //   129: getfield 182	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   132: aload_2
    //   133: getfield 184	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   136: ldc 186
    //   138: invokestatic 191	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 13
    //   143: aload 12
    //   145: aload 13
    //   147: aconst_null
    //   148: invokestatic 196	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)V
    //   151: aload_2
    //   152: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 13
    //   157: putfield 204	com/tencent/biz/qqstory/database/PublishVideoEntry:mosaicPath	Ljava/lang/String;
    //   160: ldc 48
    //   162: ldc 206
    //   164: aload 13
    //   166: invokestatic 209	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   169: new 211	android/graphics/BitmapFactory$Options
    //   172: dup
    //   173: invokespecial 212	android/graphics/BitmapFactory$Options:<init>	()V
    //   176: astore 16
    //   178: aload 16
    //   180: iconst_1
    //   181: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   184: aload_1
    //   185: aload 16
    //   187: invokestatic 221	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   190: pop
    //   191: aload 16
    //   193: getfield 224	android/graphics/BitmapFactory$Options:outWidth	I
    //   196: istore 5
    //   198: aload 16
    //   200: getfield 227	android/graphics/BitmapFactory$Options:outHeight	I
    //   203: istore 6
    //   205: aload 14
    //   207: invokeinterface 176 1 0
    //   212: invokevirtual 230	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer;
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +27 -> 244
    //   220: aload_1
    //   221: iload 5
    //   223: iload 6
    //   225: invokevirtual 235	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer:a	(II)Ljava/lang/String;
    //   228: astore_1
    //   229: aload_1
    //   230: ifnull +14 -> 244
    //   233: aload_2
    //   234: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   237: ldc 237
    //   239: aload_1
    //   240: invokevirtual 241	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   243: pop
    //   244: aload 14
    //   246: invokeinterface 176 1 0
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +27 -> 280
    //   256: aload_1
    //   257: aload_2
    //   258: getfield 184	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   261: invokevirtual 244	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(Ljava/lang/String;)Ljava/lang/String;
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +14 -> 280
    //   269: aload_2
    //   270: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   273: ldc 246
    //   275: aload_1
    //   276: invokevirtual 241	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   279: pop
    //   280: aload 14
    //   282: aload_0
    //   283: getfield 43	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   286: iconst_0
    //   287: invokeinterface 249 3 0
    //   292: astore 13
    //   294: aload_0
    //   295: getfield 41	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: astore 12
    //   300: aload 12
    //   302: astore_1
    //   303: aload 12
    //   305: ifnonnull +17 -> 322
    //   308: aload_2
    //   309: getfield 182	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   312: aload_2
    //   313: getfield 184	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   316: ldc 251
    //   318: invokestatic 191	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   321: astore_1
    //   322: aload 13
    //   324: ifnull +537 -> 861
    //   327: aload 15
    //   329: ifnull +48 -> 377
    //   332: aload 15
    //   334: aload_0
    //   335: getfield 43	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   338: invokeinterface 173 2 0
    //   343: ifeq +34 -> 377
    //   346: aload 15
    //   348: aload_0
    //   349: getfield 43	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   352: new 253	android/graphics/Canvas
    //   355: dup
    //   356: aload 13
    //   358: invokespecial 256	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   361: aload 13
    //   363: invokevirtual 68	android/graphics/Bitmap:getWidth	()I
    //   366: aload 13
    //   368: invokevirtual 71	android/graphics/Bitmap:getHeight	()I
    //   371: invokeinterface 259 5 0
    //   376: pop
    //   377: iload 6
    //   379: istore 4
    //   381: iload 5
    //   383: istore_3
    //   384: aload_2
    //   385: getfield 262	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   388: instanceof 264
    //   391: ifeq +37 -> 428
    //   394: iload 6
    //   396: istore 4
    //   398: iload 5
    //   400: istore_3
    //   401: aload_2
    //   402: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   405: ldc_w 266
    //   408: iconst_0
    //   409: invokevirtual 270	com/tencent/biz/qqstory/database/PublishVideoEntry:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   412: ifeq +16 -> 428
    //   415: aload 16
    //   417: getfield 227	android/graphics/BitmapFactory$Options:outHeight	I
    //   420: istore_3
    //   421: aload 16
    //   423: getfield 224	android/graphics/BitmapFactory$Options:outWidth	I
    //   426: istore 4
    //   428: aload_2
    //   429: getfield 273	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs	Ldov/com/tencent/biz/qqstory/takevideo/publish/GenerateThumbArgs;
    //   432: getfield 278	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateThumbArgs:c	I
    //   435: istore 5
    //   437: aload_2
    //   438: getfield 182	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   441: istore 6
    //   443: iload 6
    //   445: iconst_2
    //   446: if_icmpeq +36 -> 482
    //   449: iload 6
    //   451: iconst_3
    //   452: if_icmpeq +30 -> 482
    //   455: iload 6
    //   457: iconst_5
    //   458: if_icmpeq +24 -> 482
    //   461: iload 6
    //   463: bipush 101
    //   465: if_icmpeq +17 -> 482
    //   468: iload 6
    //   470: bipush 6
    //   472: if_icmpeq +10 -> 482
    //   475: iload 6
    //   477: bipush 102
    //   479: if_icmpne +456 -> 935
    //   482: aload_2
    //   483: getfield 262	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   486: instanceof 264
    //   489: ifeq +31 -> 520
    //   492: iconst_0
    //   493: istore 5
    //   495: ldc 48
    //   497: new 87	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 280
    //   507: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: iconst_0
    //   511: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   514: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 56	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload 13
    //   522: iload 5
    //   524: invokestatic 285	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateDoodleImageSegment:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   527: astore 12
    //   529: aload 12
    //   531: ifnull +404 -> 935
    //   534: aload 12
    //   536: iload_3
    //   537: iload 4
    //   539: iconst_1
    //   540: iconst_0
    //   541: invokestatic 288	com/tencent/biz/qqstory/utils/BitmapUtils:b	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
    //   544: astore 12
    //   546: aload 12
    //   548: ifnull +381 -> 929
    //   551: aload_2
    //   552: getfield 182	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   555: iconst_1
    //   556: if_icmpne +231 -> 787
    //   559: aload_2
    //   560: getfield 182	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   563: aload_2
    //   564: getfield 184	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   567: ldc 251
    //   569: invokestatic 191	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   572: astore 15
    //   574: aload 12
    //   576: aload 15
    //   578: aconst_null
    //   579: invokestatic 196	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)V
    //   582: aload_2
    //   583: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   586: aload 15
    //   588: putfield 291	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   591: iconst_1
    //   592: istore 11
    //   594: aconst_null
    //   595: astore_1
    //   596: aload 14
    //   598: aload 13
    //   600: invokeinterface 293 2 0
    //   605: aload 12
    //   607: aload 13
    //   609: if_acmpeq +8 -> 617
    //   612: aload 12
    //   614: invokestatic 294	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;)V
    //   617: aload 12
    //   619: ifnull +196 -> 815
    //   622: iload 11
    //   624: ifeq +191 -> 815
    //   627: ldc 48
    //   629: ldc_w 296
    //   632: invokestatic 298	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: invokestatic 130	android/os/SystemClock:uptimeMillis	()J
    //   638: lstore 9
    //   640: ldc 152
    //   642: ldc_w 300
    //   645: iconst_0
    //   646: iconst_0
    //   647: iconst_1
    //   648: anewarray 156	java/lang/String
    //   651: dup
    //   652: iconst_0
    //   653: new 87	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 302
    //   663: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: lload 9
    //   668: lload 7
    //   670: lsub
    //   671: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: aastore
    //   678: invokestatic 161	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   681: ldc 152
    //   683: ldc 154
    //   685: iconst_0
    //   686: iconst_0
    //   687: iconst_0
    //   688: anewarray 156	java/lang/String
    //   691: invokestatic 161	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   694: aload_2
    //   695: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   698: aload_1
    //   699: putfield 308	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   702: aload_0
    //   703: aload_2
    //   704: invokespecial 311	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   707: return
    //   708: astore_1
    //   709: ldc 48
    //   711: ldc_w 313
    //   714: aload_1
    //   715: invokestatic 316	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   718: aload_0
    //   719: new 141	com/tencent/biz/qqstory/base/ErrorMessage
    //   722: dup
    //   723: iconst_m1
    //   724: ldc 143
    //   726: invokespecial 146	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   729: invokespecial 150	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   732: return
    //   733: astore_1
    //   734: ldc 48
    //   736: ldc_w 318
    //   739: aload_1
    //   740: invokestatic 320	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   743: aload_0
    //   744: new 322	com/tencent/biz/qqstory/base/BitmapError
    //   747: dup
    //   748: ldc 48
    //   750: bipush 6
    //   752: invokespecial 325	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   755: invokespecial 150	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   758: return
    //   759: astore 15
    //   761: ldc 48
    //   763: ldc_w 313
    //   766: aload 15
    //   768: invokestatic 316	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   771: aload 12
    //   773: getstatic 331	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   776: bipush 60
    //   778: aload_1
    //   779: invokestatic 334	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   782: istore 11
    //   784: goto -188 -> 596
    //   787: aload 12
    //   789: getstatic 331	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   792: bipush 60
    //   794: aload_1
    //   795: invokestatic 334	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   798: istore 11
    //   800: goto -204 -> 596
    //   803: astore_1
    //   804: aload 14
    //   806: aload 13
    //   808: invokeinterface 293 2 0
    //   813: aload_1
    //   814: athrow
    //   815: ldc 48
    //   817: ldc_w 336
    //   820: invokestatic 56	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: ldc 152
    //   825: ldc 154
    //   827: iconst_0
    //   828: bipush 254
    //   830: iconst_0
    //   831: anewarray 156	java/lang/String
    //   834: invokestatic 161	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   837: aload_2
    //   838: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   841: aconst_null
    //   842: putfield 308	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   845: aload_0
    //   846: new 141	com/tencent/biz/qqstory/base/ErrorMessage
    //   849: dup
    //   850: iconst_m1
    //   851: ldc_w 338
    //   854: invokespecial 146	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   857: invokespecial 150	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   860: return
    //   861: ldc 48
    //   863: ldc_w 340
    //   866: invokestatic 56	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   869: ldc 152
    //   871: ldc 154
    //   873: iconst_0
    //   874: bipush 254
    //   876: iconst_0
    //   877: anewarray 156	java/lang/String
    //   880: invokestatic 161	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   883: aload_2
    //   884: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   887: aconst_null
    //   888: putfield 308	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   891: aload_0
    //   892: new 141	com/tencent/biz/qqstory/base/ErrorMessage
    //   895: dup
    //   896: iconst_m1
    //   897: ldc_w 342
    //   900: invokespecial 146	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   903: invokespecial 150	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   906: return
    //   907: ldc 48
    //   909: ldc_w 344
    //   912: invokestatic 56	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: aload_2
    //   916: getfield 199	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   919: aconst_null
    //   920: putfield 308	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   923: aload_0
    //   924: aload_2
    //   925: invokespecial 311	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   928: return
    //   929: iconst_0
    //   930: istore 11
    //   932: goto -336 -> 596
    //   935: aload 13
    //   937: astore 12
    //   939: goto -405 -> 534
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	942	0	this	GenerateDoodleImageSegment
    //   0	942	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	942	2	paramGenerateContext	GenerateContext
    //   383	154	3	i	int
    //   379	159	4	j	int
    //   196	327	5	k	int
    //   203	277	6	m	int
    //   3	666	7	l1	long
    //   638	29	9	l2	long
    //   592	339	11	bool	boolean
    //   121	817	12	localObject1	java.lang.Object
    //   141	795	13	localObject2	java.lang.Object
    //   55	750	14	localEditDoodleExport	EditDoodleExport
    //   67	520	15	localObject3	java.lang.Object
    //   759	8	15	localThrowable	java.lang.Throwable
    //   176	246	16	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   143	169	708	java/io/IOException
    //   184	191	733	java/lang/OutOfMemoryError
    //   574	591	759	java/lang/Throwable
    //   332	377	803	finally
    //   384	394	803	finally
    //   401	428	803	finally
    //   428	443	803	finally
    //   482	492	803	finally
    //   495	520	803	finally
    //   520	529	803	finally
    //   534	546	803	finally
    //   551	574	803	finally
    //   574	591	803	finally
    //   761	784	803	finally
    //   787	800	803	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */