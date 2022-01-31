package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditInteractExport;
import java.lang.ref.WeakReference;

public class GenerateInteractPasterImageSegment
  extends MeasureJobSegment
{
  public WeakReference a;
  
  public GenerateInteractPasterImageSegment(EditInteractExport paramEditInteractExport)
  {
    this.a = new WeakReference(paramEditInteractExport);
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    paramJobContext = (EditInteractExport)this.a.get();
    if (paramJobContext == null)
    {
      SLog.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(paramGenerateContext);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      SLog.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(paramGenerateContext);
      return;
    }
    String str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
    try
    {
      if (BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(paramGenerateContext);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      SLog.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    SLog.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateInteractPasterImageSegment
 * JD-Core Version:    0.7.0.1
 */