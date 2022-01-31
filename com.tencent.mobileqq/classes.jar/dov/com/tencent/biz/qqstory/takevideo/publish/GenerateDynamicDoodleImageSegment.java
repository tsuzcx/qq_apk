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
import java.lang.ref.WeakReference;

public class GenerateDynamicDoodleImageSegment
  extends MeasureJobSegment
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference a;
  public final WeakReference b;
  
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
    Object localObject1 = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = (EditFilterExport)this.b.get();
    Bitmap localBitmap;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localObject2 != null) && (((EditFilterExport)localObject2).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localEditDoodleExport.a(this.jdField_a_of_type_Int, true);
      paramJobContext = this.jdField_a_of_type_JavaLangString;
      if (paramJobContext != null) {
        break label565;
      }
      paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
    }
    label556:
    label562:
    label565:
    for (;;)
    {
      if (localBitmap != null) {
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          if (((EditFilterExport)localObject2).a(this.jdField_a_of_type_Int)) {
            ((EditFilterExport)localObject2).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          try
          {
            ImageUtil.a((String)localObject1, (BitmapFactory.Options)localObject2);
            int k = ((BitmapFactory.Options)localObject2).outWidth;
            int m = ((BitmapFactory.Options)localObject2).outHeight;
            int j = m;
            int i = k;
            if (k > m)
            {
              i = ((BitmapFactory.Options)localObject2).outHeight;
              j = ((BitmapFactory.Options)localObject2).outWidth;
            }
            localObject1 = BitmapUtils.b(localBitmap, i, j, true, false);
            i = HWEncodeGenerateDoodleImageSegment.a(paramGenerateContext);
            if (i == 0) {
              break label562;
            }
            localObject1 = UIUtils.a((Bitmap)localObject1, i);
            if (localObject1 == null) {
              break label556;
            }
            bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            localEditDoodleExport.a(localBitmap);
            if (localObject1 != localBitmap) {
              BitmapUtils.a((Bitmap)localObject1);
            }
            if ((localObject1 != null) && (bool))
            {
              SLog.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
              long l2 = SystemClock.uptimeMillis();
              StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
              StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
              paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", paramJobContext);
              super.notifyResult(paramGenerateContext);
              return;
            }
          }
          catch (OutOfMemoryError paramJobContext)
          {
            SLog.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
            return;
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
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDynamicDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */