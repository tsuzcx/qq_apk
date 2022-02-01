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
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.lang.ref.WeakReference;

public class GenerateDynamicDoodleImageSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference<EditDoodleExport> a;
  public final WeakReference<EditFilterExport> b;
  
  public GenerateDynamicDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public GenerateDynamicDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
  {
    if (paramEditDoodleExport == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditDoodleExport);
    this.b = new WeakReference(paramEditFilterExport);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
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
    Object localObject = (EditFilterExport)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((EditFilterExport)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localEditDoodleExport.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((EditFilterExport)localObject).a(this.jdField_a_of_type_Int)) {
          ((EditFilterExport)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          ImageUtil.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
            continue;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          int m;
          int n;
          int k;
          int i;
          long l2;
          SLog.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
          return;
        }
        k = n;
        i = m;
        if (m > n)
        {
          k = n;
          i = m;
          if (j != 0)
          {
            i = ((BitmapFactory.Options)localObject).outHeight;
            k = ((BitmapFactory.Options)localObject).outWidth;
          }
        }
        paramJobContext = BitmapUtils.c(localBitmap, i, k, true, false);
        i = HWEncodeGenerateDoodleImageSegment.a(paramGenerateContext);
        if (i != 0)
        {
          paramJobContext = UIUtils.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localEditDoodleExport.a(localBitmap);
          if (paramJobContext != localBitmap) {
            BitmapUtils.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            SLog.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(paramGenerateContext);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((paramGenerateContext.jdField_a_of_type_Int != 12) && (paramGenerateContext.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = UIUtils.a(paramJobContext, 270.0F);
          continue;
        }
        SLog.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localEditDoodleExport.a(localBitmap);
      }
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(paramGenerateContext);
      return;
      label673:
      boolean bool = false;
      continue;
      label679:
      continue;
      label682:
      break;
      label685:
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDynamicDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */