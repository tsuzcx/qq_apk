import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

public class nyu
  extends SimpleJob
{
  public nyu(FeedSegment paramFeedSegment, List paramList) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    TVKPreloader.a();
    paramJobContext = this.jdField_a_of_type_JavaUtilList.toArray();
    int j = paramJobContext.length;
    int i = 0;
    while (i < j)
    {
      TVKPreloader.a(paramJobContext[i].toString());
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyu
 * JD-Core Version:    0.7.0.1
 */