import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class ofq
  extends SimpleJob
{
  public ofq(EditVideoPartManager paramEditVideoPartManager) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    VideoEditReport.a("0X80076BC");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofq
 * JD-Core Version:    0.7.0.1
 */