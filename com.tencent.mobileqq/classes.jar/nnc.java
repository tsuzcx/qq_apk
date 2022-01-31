import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper;

public class nnc
  implements Runnable
{
  public nnc(SendVideoToFriendHelper paramSendVideoToFriendHelper, long paramLong, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: ldc 36
    //   6: ldc 38
    //   8: iconst_1
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: lload_1
    //   15: aload_0
    //   16: getfield 17	nnc:jdField_a_of_type_Long	J
    //   19: lsub
    //   20: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: aastore
    //   24: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   31: getfield 55	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoLocalThumbnailPath	Ljava/lang/String;
    //   34: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +79 -> 116
    //   40: ldc 36
    //   42: ldc 63
    //   44: invokestatic 67	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   51: getfield 55	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoLocalThumbnailPath	Ljava/lang/String;
    //   54: invokestatic 73	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   57: astore_3
    //   58: ldc 36
    //   60: ldc 75
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   71: lload_1
    //   72: lsub
    //   73: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_3
    //   81: ifnonnull +73 -> 154
    //   84: new 77	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent
    //   87: dup
    //   88: new 79	com/tencent/biz/qqstory/base/ErrorMessage
    //   91: dup
    //   92: iconst_m1
    //   93: ldc 81
    //   95: invokespecial 84	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   98: aload_0
    //   99: getfield 21	nnc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokespecial 87	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent:<init>	(Lcom/tencent/biz/qqstory/base/ErrorMessage;Ljava/lang/String;)V
    //   105: astore_3
    //   106: invokestatic 93	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   109: aload_3
    //   110: invokeinterface 99 2 0
    //   115: return
    //   116: aload_0
    //   117: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   120: getfield 102	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalVideoPath	Ljava/lang/String;
    //   123: invokestatic 108	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   126: invokevirtual 114	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   129: invokevirtual 120	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   132: getfield 126	android/util/DisplayMetrics:widthPixels	I
    //   135: invokestatic 108	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   138: invokevirtual 114	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   141: invokevirtual 120	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   144: getfield 129	android/util/DisplayMetrics:heightPixels	I
    //   147: invokestatic 134	com/tencent/biz/qqstory/utils/UIUtils:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   150: astore_3
    //   151: goto -93 -> 58
    //   154: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   157: lstore_1
    //   158: aload_3
    //   159: astore 4
    //   161: aload_0
    //   162: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   165: getfield 137	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalMaskPath	Ljava/lang/String;
    //   168: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne +19 -> 190
    //   174: aload_3
    //   175: aload_0
    //   176: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   179: getfield 137	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalMaskPath	Ljava/lang/String;
    //   182: invokestatic 73	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   185: invokestatic 142	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   188: astore 4
    //   190: ldc 36
    //   192: ldc 144
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   203: lload_1
    //   204: lsub
    //   205: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   208: aastore
    //   209: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   215: lstore_1
    //   216: aload_0
    //   217: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   220: invokevirtual 148	com/tencent/biz/qqstory/model/item/StoryVideoItem:getPollLayout	()Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout;
    //   223: aload_0
    //   224: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   227: getfield 151	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoWidth	I
    //   230: aload_0
    //   231: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   234: getfield 154	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoHeight	I
    //   237: invokestatic 157	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$PollLayout;II)Landroid/graphics/Bitmap;
    //   240: astore 5
    //   242: aload 4
    //   244: astore_3
    //   245: aload 5
    //   247: ifnull +11 -> 258
    //   250: aload 4
    //   252: aload 5
    //   254: invokestatic 142	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   257: astore_3
    //   258: ldc 36
    //   260: ldc 159
    //   262: iconst_1
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   271: lload_1
    //   272: lsub
    //   273: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: aastore
    //   277: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   283: lstore_1
    //   284: aload_0
    //   285: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   288: invokevirtual 163	com/tencent/biz/qqstory/model/item/StoryVideoItem:getInteractLayout	()Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout;
    //   291: aload_0
    //   292: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   295: getfield 151	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoWidth	I
    //   298: aload_0
    //   299: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   302: getfield 154	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoHeight	I
    //   305: invokestatic 166	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$InteractPasterLayout;II)Landroid/graphics/Bitmap;
    //   308: astore 5
    //   310: aload_3
    //   311: astore 4
    //   313: aload 5
    //   315: ifnull +11 -> 326
    //   318: aload_3
    //   319: aload 5
    //   321: invokestatic 142	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   324: astore 4
    //   326: ldc 36
    //   328: ldc 168
    //   330: iconst_1
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   339: lload_1
    //   340: lsub
    //   341: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   344: aastore
    //   345: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   351: lstore_1
    //   352: ldc 36
    //   354: ldc 170
    //   356: iconst_1
    //   357: anewarray 4	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   365: lload_1
    //   366: lsub
    //   367: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   370: aastore
    //   371: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   377: lstore_1
    //   378: aload_0
    //   379: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   382: getfield 173	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVid	Ljava/lang/String;
    //   385: iconst_1
    //   386: invokestatic 178	com/tencent/biz/qqstory/playmode/util/PlayModeUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   389: astore_3
    //   390: new 180	java/io/File
    //   393: dup
    //   394: aload_3
    //   395: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   398: astore 5
    //   400: aload 4
    //   402: aload 5
    //   404: invokestatic 188	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   407: aload 4
    //   409: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   412: ldc 36
    //   414: ldc 195
    //   416: aload_3
    //   417: invokestatic 198	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   420: ldc 36
    //   422: ldc 200
    //   424: iconst_1
    //   425: anewarray 4	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   433: lload_1
    //   434: lsub
    //   435: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: invokestatic 50	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: new 77	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent
    //   445: dup
    //   446: new 79	com/tencent/biz/qqstory/base/ErrorMessage
    //   449: dup
    //   450: invokespecial 201	com/tencent/biz/qqstory/base/ErrorMessage:<init>	()V
    //   453: aload_0
    //   454: getfield 21	nnc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   457: invokespecial 87	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent:<init>	(Lcom/tencent/biz/qqstory/base/ErrorMessage;Ljava/lang/String;)V
    //   460: astore 4
    //   462: aload 4
    //   464: aload_0
    //   465: getfield 19	nnc:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   468: putfield 202	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent:jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem	Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   471: aload 4
    //   473: aload_3
    //   474: putfield 203	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   477: invokestatic 93	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   480: aload 4
    //   482: invokeinterface 99 2 0
    //   487: return
    //   488: astore 4
    //   490: aconst_null
    //   491: astore_3
    //   492: ldc 36
    //   494: ldc 205
    //   496: aload 4
    //   498: invokestatic 209	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   501: new 77	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent
    //   504: dup
    //   505: new 79	com/tencent/biz/qqstory/base/ErrorMessage
    //   508: dup
    //   509: iconst_m1
    //   510: new 211	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   517: ldc 81
    //   519: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 4
    //   524: invokevirtual 220	java/io/IOException:getMessage	()Ljava/lang/String;
    //   527: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokespecial 84	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   536: aload_0
    //   537: getfield 21	nnc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   540: invokespecial 87	com/tencent/biz/qqstory/playmode/util/SendVideoToFriendHelper$GenShareThumbEvent:<init>	(Lcom/tencent/biz/qqstory/base/ErrorMessage;Ljava/lang/String;)V
    //   543: astore 4
    //   545: invokestatic 93	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   548: aload 4
    //   550: invokeinterface 99 2 0
    //   555: goto -135 -> 420
    //   558: astore 4
    //   560: goto -68 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	nnc
    //   3	431	1	l	long
    //   57	435	3	localObject1	Object
    //   159	322	4	localObject2	Object
    //   488	35	4	localIOException1	java.io.IOException
    //   543	6	4	localGenShareThumbEvent	com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.GenShareThumbEvent
    //   558	1	4	localIOException2	java.io.IOException
    //   240	163	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   400	412	488	java/io/IOException
    //   412	420	558	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnc
 * JD-Core Version:    0.7.0.1
 */