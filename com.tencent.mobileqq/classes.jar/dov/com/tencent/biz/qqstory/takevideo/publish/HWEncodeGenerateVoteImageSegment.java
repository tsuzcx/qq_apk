package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVoteExport;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateVoteImageSegment
  extends MeasureJobSegment
{
  public WeakReference a;
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    paramJobContext = (EditVoteExport)this.a.get();
    if (paramJobContext == null)
    {
      SLog.e("Q.qqstory.publish.editGenerateVoteImageSegment", "EditVoteExport is null, return directly.");
      notifyResult(paramGenerateContext);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      SLog.e("Q.qqstory.publish.editGenerateVoteImageSegment", "vote bitmap is null, return directly.");
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
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("pl_pic", localObject);
        notifyResult(paramGenerateContext);
        return;
      }
      catch (Exception paramJobContext)
      {
        SLog.c("Q.qqstory.publish.editGenerateVoteImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      SLog.e("Q.qqstory.publish.editGenerateVoteImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    SLog.e("Q.qqstory.publish.editGenerateVoteImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress vote bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateVoteImageSegment
 * JD-Core Version:    0.7.0.1
 */