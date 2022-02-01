package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditFilterExport;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class GenerateDoodleImageSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference<EditDoodleExport> a;
  public final WeakReference<EditFilterExport> b;
  
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
    Object localObject1 = (EditFilterExport)this.b.get();
    Bitmap localBitmap;
    Object localObject2;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localObject1 != null) && (((EditFilterExport)localObject1).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localEditDoodleExport.a().a(this.jdField_a_of_type_Int);
      if (localBitmap != null) {
        localObject2 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, "mosaic.png");
      }
    }
    label806:
    label812:
    label819:
    for (;;)
    {
      try
      {
        BitmapUtils.a(localBitmap, (String)localObject2, null);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject2);
        SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject2);
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        int k;
        int m;
        int j;
        int i;
        long l2;
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      }
      catch (IOException paramJobContext)
      {
        try
        {
          ImageUtil.a(paramJobContext, (BitmapFactory.Options)localObject2);
          k = ((BitmapFactory.Options)localObject2).outWidth;
          m = ((BitmapFactory.Options)localObject2).outHeight;
          paramJobContext = localEditDoodleExport.a().a();
          if (paramJobContext != null)
          {
            paramJobContext = paramJobContext.a(k, m, true);
            if (paramJobContext != null) {
              paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_data", paramJobContext);
            }
          }
          localBitmap = localEditDoodleExport.a(this.jdField_a_of_type_Int, false);
          paramJobContext = this.jdField_a_of_type_JavaLangString;
          if (paramJobContext != null) {
            break label819;
          }
          paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
          if (localBitmap == null) {
            break label738;
          }
          if (localObject1 == null) {}
        }
        catch (OutOfMemoryError paramJobContext)
        {
          SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
          return;
        }
        try
        {
          if (((EditFilterExport)localObject1).a(this.jdField_a_of_type_Int)) {
            ((EditFilterExport)localObject1).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          j = m;
          i = k;
          if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            j = m;
            i = k;
            if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false))
            {
              i = ((BitmapFactory.Options)localObject2).outHeight;
              j = ((BitmapFactory.Options)localObject2).outWidth;
            }
          }
          k = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
          m = paramGenerateContext.jdField_a_of_type_Int;
          if ((m != 2) && (m != 3) && (m != 5) && (m != 6) && (m != 102)) {
            break label812;
          }
          if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            k = 0;
            SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resizedBitmap orientation=" + 0);
          }
          localObject1 = a(localBitmap, k);
          if (localObject1 == null) {
            break label812;
          }
          localObject1 = BitmapUtils.c((Bitmap)localObject1, i, j, true, false);
          if (localObject1 == null) {
            break label806;
          }
          bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          localEditDoodleExport.a(localBitmap);
          if (localObject1 != localBitmap) {
            BitmapUtils.a((Bitmap)localObject1);
          }
          if ((localObject1 == null) || (!bool)) {
            break label692;
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
          localEditDoodleExport.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      label692:
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label738:
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
      localObject1 = localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */