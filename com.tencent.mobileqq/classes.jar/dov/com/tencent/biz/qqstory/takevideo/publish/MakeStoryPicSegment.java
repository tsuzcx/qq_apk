package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class MakeStoryPicSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    int i = UIUtils.b(BaseApplication.getContext());
    int j = UIUtils.c(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.a;
    paramJobContext = (JobContext)localObject;
    if (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c)
    {
      paramJobContext = (JobContext)localObject;
      if (paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) {
        paramJobContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
      }
    }
    try
    {
      localObject = ImageUtil.a(paramJobContext, new BitmapFactory.Options());
      if (localObject == null)
      {
        SLog.d("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
        return;
      }
    }
    catch (OutOfMemoryError paramJobContext)
    {
      SLog.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
      return;
    }
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e != ((Bitmap)localObject).getHeight()) || (paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d != ((Bitmap)localObject).getWidth())) {}
    for (j = 1;; j = 0)
    {
      if (((Bitmap)localObject).getWidth() <= 720)
      {
        paramJobContext = (JobContext)localObject;
        if (((Bitmap)localObject).getHeight() <= i) {
          break;
        }
      }
      float f = Math.min(720 / ((Bitmap)localObject).getWidth(), i / ((Bitmap)localObject).getHeight());
      localObject = BitmapUtils.a((Bitmap)localObject, f, true);
      SLog.a("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(f), localObject);
      paramJobContext = (JobContext)localObject;
      if (localObject != null) {
        break;
      }
      notifyError(new BitmapError("resizeBitmapByScale failed", -1));
      return;
    }
    SLog.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "current bitmap size " + paramJobContext.getWidth() + ", " + paramJobContext.getHeight());
    if (j != 0) {
      paramJobContext = BitmapUtils.c(paramJobContext, 720, i, false, true);
    }
    for (;;)
    {
      if (paramJobContext == null)
      {
        notifyError(new BitmapError("fillBitmapEdge failed", -1));
        return;
      }
      if (paramJobContext.getHeight() % 2 == 0)
      {
        localObject = paramJobContext;
        if (paramJobContext.getWidth() % 2 == 0) {}
      }
      else
      {
        localObject = Bitmap.createScaledBitmap(paramJobContext, paramJobContext.getWidth() >> 1 << 1, paramJobContext.getHeight() >> 1 << 1, false);
      }
      paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.jdField_b_of_type_JavaLangString, ".jpg");
      BitmapUtils.a((Bitmap)localObject, paramJobContext);
      ((Bitmap)localObject).recycle();
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramJobContext;
      super.notifyResult(paramGenerateContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.MakeStoryPicSegment
 * JD-Core Version:    0.7.0.1
 */