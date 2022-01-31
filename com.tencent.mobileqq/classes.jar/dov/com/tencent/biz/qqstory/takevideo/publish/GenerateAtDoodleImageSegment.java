package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoAtDoodleController;
import java.lang.ref.WeakReference;

public class GenerateAtDoodleImageSegment
  extends MeasureJobSegment
{
  public final String a;
  @NonNull
  public final WeakReference a;
  public final String b;
  
  public GenerateAtDoodleImageSegment(EditVideoAtDoodleController paramEditVideoAtDoodleController, String paramString1, String paramString2)
  {
    if (paramEditVideoAtDoodleController == null) {
      throw new IllegalArgumentException("atDoodleController is illegal");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditVideoAtDoodleController);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private boolean a(GenerateContext paramGenerateContext, String paramString1, String paramString2)
  {
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atDoodlePath = paramString1;
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData = paramString2;
    return true;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    int i = 0;
    int j = 0;
    String str = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (str == null)
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    EditVideoAtDoodleController localEditVideoAtDoodleController = (EditVideoAtDoodleController)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject;
    BitmapFactory.Options localOptions;
    if ((localEditVideoAtDoodleController != null) && (!localEditVideoAtDoodleController.a()))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (localObject == null) {
        paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
      }
      localObject = localEditVideoAtDoodleController.a();
      if (localObject != null)
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
      }
    }
    for (;;)
    {
      try
      {
        ImageUtil.a(str, localOptions);
        localObject = BitmapUtils.a((Bitmap)localObject, localOptions.outWidth, localOptions.outHeight, true, false);
        if (localObject == null) {
          break label388;
        }
        bool1 = BitmapUtils.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        if ((localObject != null) && (bool1))
        {
          SLog.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and crop original doodle image success");
          i = j;
          if (a(paramGenerateContext, paramJobContext, this.b)) {
            i = 1;
          }
          BitmapUtils.a((Bitmap)localObject);
          if (i == 0) {
            break label360;
          }
          super.notifyResult(paramGenerateContext);
          return;
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        SLog.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", 6));
        return;
      }
      if (localObject != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        SLog.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and save doodle image failed, resize result=%s, save result=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        bool1 = localEditVideoAtDoodleController.a(paramJobContext);
        SLog.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "generate original doodle png file : success = " + bool1 + ", path = " + paramJobContext);
        if (!bool1) {
          break label347;
        }
        SLog.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "use the original doodle image instead");
        i = j;
        if (!a(paramGenerateContext, paramJobContext, this.b)) {
          break;
        }
        i = 1;
        break;
      }
      label347:
      SLog.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "copy the original doodle image failed, we'll ignore the doodle then publish");
      i = j;
      continue;
      label360:
      super.notifyError(new ErrorMessage(-1, "DoodleLayout generate image failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "do not generate at doodle image because at doodle is empty");
      super.notifyResult(paramGenerateContext);
      return;
      label388:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateAtDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */