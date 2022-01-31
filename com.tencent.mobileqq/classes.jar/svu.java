import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class svu
  extends SimpleJob<Object>
{
  svu(svo paramsvo, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramVarArgs = ((tcz)tdc.a(5)).a();
    paramJobContext = new ArrayList(paramVarArgs.size());
    paramVarArgs = paramVarArgs.iterator();
    while (paramVarArgs.hasNext()) {
      paramJobContext.add(new sxh((StoryVideoItem)paramVarArgs.next()));
    }
    this.a.a(paramJobContext);
    veg.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "had load local task size " + paramJobContext.size());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svu
 * JD-Core Version:    0.7.0.1
 */