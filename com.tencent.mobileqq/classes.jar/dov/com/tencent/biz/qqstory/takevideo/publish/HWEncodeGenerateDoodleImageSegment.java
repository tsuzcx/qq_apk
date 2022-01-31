package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditFilterExport;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateDoodleImageSegment
  extends MeasureJobSegment
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference a;
  public final WeakReference b;
  
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
    int i = 0;
    int j = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false)) {
        i = 270;
      }
      return i;
    }
    return j;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject3 = (EditFilterExport)this.b.get();
    int i = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
    Object localObject1;
    Object localObject2;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localObject3 != null) && (((EditFilterExport)localObject3).a(this.jdField_a_of_type_Int)))))
    {
      localObject1 = localEditDoodleExport.a().a(this.jdField_a_of_type_Int);
      if (localObject1 != null) {
        localObject2 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, "mosaic.png");
      }
    }
    label716:
    label854:
    label860:
    label863:
    for (;;)
    {
      try
      {
        BitmapUtils.a((Bitmap)localObject1, (String)localObject2, null);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject2);
        SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject2);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        int j;
        long l2;
        bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          ImageUtil.a(paramJobContext, localOptions);
          j = localOptions.outWidth;
          i = localOptions.outHeight;
          paramJobContext = localEditDoodleExport.a().a();
          if (paramJobContext != null)
          {
            paramJobContext = paramJobContext.a(j, i);
            if (paramJobContext != null) {
              paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_data", paramJobContext);
            }
          }
          paramJobContext = localEditDoodleExport.a();
          if (paramJobContext != null)
          {
            paramJobContext = paramJobContext.a(paramGenerateContext.b);
            if (paramJobContext != null) {
              paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("tracker_Sticker_data", paramJobContext);
            }
          }
          localObject2 = localEditDoodleExport.a(this.jdField_a_of_type_Int, false);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          paramJobContext = (JobContext)localObject1;
          if (localObject1 == null) {
            paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
          }
          if (localObject2 == null) {
            break label786;
          }
          if (localObject3 == null) {}
        }
        catch (OutOfMemoryError paramJobContext)
        {
          SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
          return;
        }
        try
        {
          if (((EditFilterExport)localObject3).a(this.jdField_a_of_type_Int)) {
            ((EditFilterExport)localObject3).a(this.jdField_a_of_type_Int, new Canvas((Bitmap)localObject2), ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
          }
          if (j <= i) {
            break label863;
          }
          j = localOptions.outHeight;
          i = localOptions.outWidth;
          localObject1 = BitmapUtils.b((Bitmap)localObject2, j, i, true, false);
          i = a(paramGenerateContext);
          if (i == 0) {
            break label860;
          }
          localObject1 = UIUtils.a((Bitmap)localObject1, i);
          if (localObject1 == null) {
            break label854;
          }
          if (paramGenerateContext.jdField_a_of_type_Int != 1) {
            break label716;
          }
          localObject3 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
          try
          {
            BitmapUtils.a((Bitmap)localObject1, (String)localObject3, null);
            paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = ((String)localObject3);
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = paramJobContext;
            continue;
          }
          localEditDoodleExport.a((Bitmap)localObject2);
          if (localObject1 != localObject2) {
            BitmapUtils.a((Bitmap)localObject1);
          }
          if ((localObject1 == null) || (!bool)) {
            break label740;
          }
          SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramGenerateContext);
          return;
        }
        finally
        {
          localEditDoodleExport.a((Bitmap)localObject2);
        }
        paramJobContext = paramJobContext;
        SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = paramJobContext;
      continue;
      label740:
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramGenerateContext);
      return;
      boolean bool = false;
      continue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */