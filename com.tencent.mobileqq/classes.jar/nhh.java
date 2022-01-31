import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class nhh
  extends SimpleJob
{
  public nhh(VidToVideoInfoPuller paramVidToVideoInfoPuller) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((StoryManager)SuperManager.a(5)).e(QQStoryContext.a().b());
    if (paramJobContext != null)
    {
      paramVarArgs = paramJobContext.iterator();
      while (paramVarArgs.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramVarArgs.next();
        if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploadSuc())) {
          paramVarArgs.remove();
        }
      }
    }
    Collections.sort(paramJobContext, new nhi(this));
    paramVarArgs = new ArrayList();
    paramJobContext = paramJobContext.iterator();
    while (paramJobContext.hasNext()) {
      paramVarArgs.add(((StoryVideoItem)paramJobContext.next()).mVid);
    }
    this.a.a(paramVarArgs);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhh
 * JD-Core Version:    0.7.0.1
 */