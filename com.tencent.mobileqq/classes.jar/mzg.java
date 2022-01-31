import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mzg
  extends SimpleJob
{
  public mzg(StoryVideoUploadManager paramStoryVideoUploadManager) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramVarArgs = ((StoryManager)SuperManager.a(5)).a();
    paramJobContext = new ArrayList(paramVarArgs.size());
    paramVarArgs = paramVarArgs.iterator();
    while (paramVarArgs.hasNext()) {
      paramJobContext.add(new StoryVideoTaskInfo((StoryVideoItem)paramVarArgs.next()));
    }
    this.a.a(paramJobContext);
    SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "had load local task size " + paramJobContext.size());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzg
 * JD-Core Version:    0.7.0.1
 */