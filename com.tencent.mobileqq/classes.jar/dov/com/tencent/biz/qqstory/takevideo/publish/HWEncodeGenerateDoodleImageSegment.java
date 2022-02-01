package dov.com.tencent.biz.qqstory.takevideo.publish;

import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditFilterExport;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateDoodleImageSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference<EditDoodleExport> a;
  public final WeakReference<EditFilterExport> b;
  
  public HWEncodeGenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport)
  {
    this(paramEditDoodleExport, null, 0);
  }
  
  public HWEncodeGenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public HWEncodeGenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
  {
    if (paramEditDoodleExport == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditDoodleExport);
    this.b = new WeakReference(paramEditFilterExport);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static int a(GenerateContext paramGenerateContext)
  {
    int j = 0;
    int i = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      i = j;
      if (!paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false))
      {
        i = j;
        if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false)) {
          i = 270;
        }
      }
      return i;
    }
    return i;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: invokestatic 88	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: aload_2
    //   6: getfield 89	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: astore 10
    //   11: aload 10
    //   13: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +31 -> 47
    //   19: aload_0
    //   20: new 97	com/tencent/biz/qqstory/base/ErrorMessage
    //   23: dup
    //   24: iconst_m1
    //   25: ldc 99
    //   27: invokespecial 102	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   30: invokespecial 106	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   33: ldc 108
    //   35: ldc 110
    //   37: iconst_0
    //   38: iconst_m1
    //   39: iconst_0
    //   40: anewarray 112	java/lang/String
    //   43: invokestatic 117	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   46: return
    //   47: aload_0
    //   48: getfield 40	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   51: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   54: checkcast 123	dov/com/tencent/biz/qqstory/takevideo/EditDoodleExport
    //   57: astore 11
    //   59: aload_0
    //   60: getfield 42	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:b	Ljava/lang/ref/WeakReference;
    //   63: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   66: checkcast 125	dov/com/tencent/biz/qqstory/takevideo/EditFilterExport
    //   69: astore_1
    //   70: aload 11
    //   72: ifnull +750 -> 822
    //   75: aload 11
    //   77: aload_0
    //   78: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   81: invokeinterface 128 2 0
    //   86: ifeq +20 -> 106
    //   89: aload_1
    //   90: ifnull +732 -> 822
    //   93: aload_1
    //   94: aload_0
    //   95: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   98: invokeinterface 129 2 0
    //   103: ifeq +719 -> 822
    //   106: aload 11
    //   108: invokeinterface 132 1 0
    //   113: aload_0
    //   114: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   117: invokevirtual 137	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(I)Landroid/graphics/Bitmap;
    //   120: astore 12
    //   122: aload 12
    //   124: ifnull +44 -> 168
    //   127: aload_2
    //   128: getfield 138	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   131: aload_2
    //   132: getfield 140	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   135: ldc 142
    //   137: invokestatic 147	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 13
    //   142: aload 12
    //   144: aload 13
    //   146: aconst_null
    //   147: invokestatic 152	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)V
    //   150: aload_2
    //   151: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   154: aload 13
    //   156: putfield 155	com/tencent/biz/qqstory/database/PublishVideoEntry:mosaicPath	Ljava/lang/String;
    //   159: ldc 157
    //   161: ldc 159
    //   163: aload 13
    //   165: invokestatic 164	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   168: new 166	android/graphics/BitmapFactory$Options
    //   171: dup
    //   172: invokespecial 167	android/graphics/BitmapFactory$Options:<init>	()V
    //   175: astore 13
    //   177: aload 13
    //   179: iconst_1
    //   180: putfield 171	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   183: aload 10
    //   185: aload 13
    //   187: invokestatic 176	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   190: pop
    //   191: aload 13
    //   193: getfield 179	android/graphics/BitmapFactory$Options:outWidth	I
    //   196: istore 4
    //   198: aload 13
    //   200: getfield 182	android/graphics/BitmapFactory$Options:outHeight	I
    //   203: istore_3
    //   204: aload_2
    //   205: getfield 185	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   208: getfield 188	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_Int	I
    //   211: bipush 14
    //   213: if_icmpne +40 -> 253
    //   216: aload_2
    //   217: getfield 185	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   220: invokevirtual 192	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:d	()Z
    //   223: ifeq +30 -> 253
    //   226: aload_2
    //   227: getfield 185	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   230: getfield 193	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   233: invokeinterface 198 1 0
    //   238: aload_2
    //   239: getfield 185	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   242: getfield 193	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   245: invokeinterface 200 1 0
    //   250: if_icmplt +15 -> 265
    //   253: aload_2
    //   254: getfield 185	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   257: getfield 188	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_Int	I
    //   260: bipush 14
    //   262: if_icmpeq +408 -> 670
    //   265: iconst_1
    //   266: istore 9
    //   268: aload 11
    //   270: invokeinterface 132 1 0
    //   275: invokevirtual 203	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer;
    //   278: astore 10
    //   280: aload 10
    //   282: ifnull +32 -> 314
    //   285: aload 10
    //   287: iload 4
    //   289: iload_3
    //   290: iload 9
    //   292: invokevirtual 208	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer:a	(IIZ)Ljava/lang/String;
    //   295: astore 10
    //   297: aload 10
    //   299: ifnull +15 -> 314
    //   302: aload_2
    //   303: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   306: ldc 210
    //   308: aload 10
    //   310: invokevirtual 214	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   313: pop
    //   314: aload 11
    //   316: aload_0
    //   317: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   320: iconst_0
    //   321: invokeinterface 217 3 0
    //   326: astore 12
    //   328: aload_0
    //   329: getfield 44	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   332: astore 10
    //   334: aload 10
    //   336: ifnonnull +520 -> 856
    //   339: aload_2
    //   340: getfield 138	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   343: aload_2
    //   344: getfield 140	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   347: ldc 219
    //   349: invokestatic 147	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 10
    //   354: aload 12
    //   356: ifnull +420 -> 776
    //   359: aload_1
    //   360: ifnull +46 -> 406
    //   363: aload_1
    //   364: aload_0
    //   365: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   368: invokeinterface 129 2 0
    //   373: ifeq +33 -> 406
    //   376: aload_1
    //   377: aload_0
    //   378: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:jdField_a_of_type_Int	I
    //   381: new 221	android/graphics/Canvas
    //   384: dup
    //   385: aload 12
    //   387: invokespecial 224	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   390: aload 12
    //   392: invokevirtual 229	android/graphics/Bitmap:getWidth	()I
    //   395: aload 12
    //   397: invokevirtual 232	android/graphics/Bitmap:getHeight	()I
    //   400: invokeinterface 235 5 0
    //   405: pop
    //   406: iload 4
    //   408: iload_3
    //   409: if_icmple +444 -> 853
    //   412: iload 9
    //   414: ifeq +439 -> 853
    //   417: aload 13
    //   419: getfield 182	android/graphics/BitmapFactory$Options:outHeight	I
    //   422: istore 4
    //   424: aload 13
    //   426: getfield 179	android/graphics/BitmapFactory$Options:outWidth	I
    //   429: istore_3
    //   430: aload 12
    //   432: iload 4
    //   434: iload_3
    //   435: iconst_1
    //   436: iconst_0
    //   437: invokestatic 238	com/tencent/biz/qqstory/utils/BitmapUtils:c	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
    //   440: astore_1
    //   441: aload_2
    //   442: invokestatic 240	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeGenerateDoodleImageSegment:a	(Ldov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext;)I
    //   445: istore_3
    //   446: iload_3
    //   447: ifeq +229 -> 676
    //   450: aload_1
    //   451: iload_3
    //   452: i2f
    //   453: invokestatic 245	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   456: astore_1
    //   457: aload_1
    //   458: ifnull +386 -> 844
    //   461: aload_1
    //   462: getstatic 251	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   465: bipush 60
    //   467: aload 10
    //   469: invokestatic 254	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   472: istore 9
    //   474: aload_2
    //   475: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   478: aload 10
    //   480: putfield 257	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   483: aload 11
    //   485: aload 12
    //   487: invokeinterface 259 2 0
    //   492: aload_1
    //   493: aload 12
    //   495: if_acmpeq +7 -> 502
    //   498: aload_1
    //   499: invokestatic 260	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;)V
    //   502: aload_1
    //   503: ifnull +227 -> 730
    //   506: iload 9
    //   508: ifeq +222 -> 730
    //   511: ldc 157
    //   513: ldc_w 262
    //   516: invokestatic 265	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: invokestatic 88	android/os/SystemClock:uptimeMillis	()J
    //   522: lstore 7
    //   524: ldc 108
    //   526: ldc_w 267
    //   529: iconst_0
    //   530: iconst_0
    //   531: iconst_1
    //   532: anewarray 112	java/lang/String
    //   535: dup
    //   536: iconst_0
    //   537: new 269	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 272
    //   547: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: lload 7
    //   552: lload 5
    //   554: lsub
    //   555: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   558: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: aastore
    //   562: invokestatic 117	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   565: ldc 108
    //   567: ldc 110
    //   569: iconst_0
    //   570: iconst_0
    //   571: iconst_0
    //   572: anewarray 112	java/lang/String
    //   575: invokestatic 117	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   578: aload_2
    //   579: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   582: aload 10
    //   584: putfield 286	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   587: aload_0
    //   588: aload_2
    //   589: invokespecial 289	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   592: return
    //   593: astore_1
    //   594: ldc 157
    //   596: ldc_w 291
    //   599: aload_1
    //   600: invokestatic 294	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   603: aload_0
    //   604: new 97	com/tencent/biz/qqstory/base/ErrorMessage
    //   607: dup
    //   608: iconst_m1
    //   609: ldc 99
    //   611: invokespecial 102	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   614: invokespecial 106	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   617: return
    //   618: astore_1
    //   619: ldc 157
    //   621: ldc_w 296
    //   624: aload_1
    //   625: invokestatic 294	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   628: aload_0
    //   629: new 97	com/tencent/biz/qqstory/base/ErrorMessage
    //   632: dup
    //   633: iconst_m1
    //   634: ldc_w 298
    //   637: invokespecial 102	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   640: invokespecial 106	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   643: return
    //   644: astore_1
    //   645: ldc 157
    //   647: ldc_w 300
    //   650: aload_1
    //   651: invokestatic 302	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   654: aload_0
    //   655: new 304	com/tencent/biz/qqstory/base/BitmapError
    //   658: dup
    //   659: ldc 157
    //   661: bipush 6
    //   663: invokespecial 307	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   666: invokespecial 106	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   669: return
    //   670: iconst_0
    //   671: istore 9
    //   673: goto -405 -> 268
    //   676: aload 13
    //   678: getfield 179	android/graphics/BitmapFactory$Options:outWidth	I
    //   681: aload 13
    //   683: getfield 182	android/graphics/BitmapFactory$Options:outHeight	I
    //   686: if_icmple +164 -> 850
    //   689: aload_2
    //   690: getfield 138	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   693: bipush 12
    //   695: if_icmpeq +12 -> 707
    //   698: aload_2
    //   699: getfield 138	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   702: bipush 11
    //   704: if_icmpne +146 -> 850
    //   707: aload_1
    //   708: ldc_w 308
    //   711: invokestatic 245	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   714: astore_1
    //   715: goto -258 -> 457
    //   718: astore_1
    //   719: aload 11
    //   721: aload 12
    //   723: invokeinterface 259 2 0
    //   728: aload_1
    //   729: athrow
    //   730: ldc 157
    //   732: ldc_w 310
    //   735: invokestatic 312	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: ldc 108
    //   740: ldc 110
    //   742: iconst_0
    //   743: bipush 254
    //   745: iconst_0
    //   746: anewarray 112	java/lang/String
    //   749: invokestatic 117	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   752: aload_2
    //   753: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   756: aconst_null
    //   757: putfield 286	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   760: aload_0
    //   761: new 97	com/tencent/biz/qqstory/base/ErrorMessage
    //   764: dup
    //   765: iconst_m1
    //   766: ldc_w 314
    //   769: invokespecial 102	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   772: invokespecial 106	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   775: return
    //   776: ldc 157
    //   778: ldc_w 316
    //   781: invokestatic 312	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: ldc 108
    //   786: ldc 110
    //   788: iconst_0
    //   789: bipush 254
    //   791: iconst_0
    //   792: anewarray 112	java/lang/String
    //   795: invokestatic 117	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   798: aload_2
    //   799: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   802: aconst_null
    //   803: putfield 286	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   806: aload_0
    //   807: new 97	com/tencent/biz/qqstory/base/ErrorMessage
    //   810: dup
    //   811: iconst_m1
    //   812: ldc_w 318
    //   815: invokespecial 102	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   818: invokespecial 106	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   821: return
    //   822: ldc 157
    //   824: ldc_w 320
    //   827: invokestatic 312	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload_2
    //   831: getfield 65	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   834: aconst_null
    //   835: putfield 286	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   838: aload_0
    //   839: aload_2
    //   840: invokespecial 289	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   843: return
    //   844: iconst_0
    //   845: istore 9
    //   847: goto -364 -> 483
    //   850: goto -393 -> 457
    //   853: goto -423 -> 430
    //   856: goto -502 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	this	HWEncodeGenerateDoodleImageSegment
    //   0	859	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	859	2	paramGenerateContext	GenerateContext
    //   203	249	3	i	int
    //   196	237	4	j	int
    //   3	550	5	l1	long
    //   522	29	7	l2	long
    //   266	580	9	bool	boolean
    //   9	574	10	localObject1	java.lang.Object
    //   57	663	11	localEditDoodleExport	EditDoodleExport
    //   120	602	12	localBitmap	android.graphics.Bitmap
    //   140	542	13	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   142	168	593	java/io/IOException
    //   142	168	618	java/lang/UnsupportedOperationException
    //   183	191	644	java/lang/OutOfMemoryError
    //   363	406	718	finally
    //   417	430	718	finally
    //   430	446	718	finally
    //   450	457	718	finally
    //   461	483	718	finally
    //   676	707	718	finally
    //   707	715	718	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */