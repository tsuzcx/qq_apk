package dov.com.qq.im.ae.util;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbTask;
import dov.com.tencent.biz.qqstory.takevideo.publish.MeasureJobSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;

public class AEGenerateThumbnailSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  /* Error */
  private static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 18	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 19	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: invokevirtual 23	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc2_w 24
    //   17: invokevirtual 29	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: ldc 34
    //   30: ldc 36
    //   32: aload_0
    //   33: invokestatic 41	dov/com/qq/im/ae/util/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_1
    //   37: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_0
    //   43: aconst_null
    //   44: areturn
    //   45: astore_0
    //   46: ldc 34
    //   48: ldc 36
    //   50: aload_0
    //   51: invokestatic 41	dov/com/qq/im/ae/util/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: aload_1
    //   55: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   68: aload_0
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: areturn
    //   73: astore_1
    //   74: goto -6 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramString	String
    //   7	58	1	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   70	1	1	localRuntimeException1	java.lang.RuntimeException
    //   73	1	1	localRuntimeException2	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   8	21	27	java/lang/IllegalArgumentException
    //   36	40	42	java/lang/RuntimeException
    //   8	21	45	java/lang/RuntimeException
    //   54	58	60	java/lang/RuntimeException
    //   8	21	63	finally
    //   28	36	63	finally
    //   46	54	63	finally
    //   21	25	70	java/lang/RuntimeException
    //   64	68	73	java/lang/RuntimeException
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    AEQLog.a("AEGenerateThumbnailSegment", "start generate thumb ...");
    paramJobContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs;
    int i = paramJobContext.c;
    Bitmap localBitmap = a(paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    if (localBitmap != null)
    {
      String str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
      if (new GenerateThumbTask(localBitmap, str, paramJobContext.jdField_a_of_type_Int, paramJobContext.jdField_b_of_type_Int, i, paramJobContext.jdField_a_of_type_Float, paramJobContext.jdField_a_of_type_Double, paramJobContext.jdField_b_of_type_Double, paramGenerateContext.jdField_a_of_type_Int).a(new Void[0]).intValue() == 0)
      {
        paramGenerateContext.jdField_a_of_type_JavaLangString = str;
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str;
        AEQLog.c("AEGenerateThumbnailSegment", "generate %d thumb success ...");
        super.notifyResult(paramGenerateContext);
        return;
      }
      AEQLog.c("AEGenerateThumbnailSegment", "generate %d thumb failed ...");
      super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705709)));
      return;
    }
    AEQLog.c("AEGenerateThumbnailSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null");
    super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705710)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.util.AEGenerateThumbnailSegment
 * JD-Core Version:    0.7.0.1
 */