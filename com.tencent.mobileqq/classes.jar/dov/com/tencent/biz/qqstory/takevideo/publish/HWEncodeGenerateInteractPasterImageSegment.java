package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditInteractExport;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateInteractPasterImageSegment
  extends MeasureJobSegment
{
  public WeakReference a;
  
  public HWEncodeGenerateInteractPasterImageSegment(EditInteractExport paramEditInteractExport)
  {
    this.a = new WeakReference(paramEditInteractExport);
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    paramJobContext = (EditInteractExport)this.a.get();
    if (paramJobContext == null)
    {
      SLog.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(paramGenerateContext);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      SLog.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(paramGenerateContext);
      return;
    }
    int i = HWEncodeGenerateDoodleImageSegment.a(paramGenerateContext);
    Object localObject;
    if (i != 0)
    {
      localObject = UIUtils.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
      try
      {
        if (!BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(paramGenerateContext);
        return;
      }
      catch (Exception paramJobContext)
      {
        SLog.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      SLog.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    SLog.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateInteractPasterImageSegment
 * JD-Core Version:    0.7.0.1
 */