import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sym
  extends swk
  implements slx<taw, tcf>
{
  protected String a;
  protected List<syn> a;
  
  public sym(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    taw localtaw = new taw();
    localtaw.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localtaw.b = this.jdField_a_of_type_JavaLangString;
    slv.a().a(localtaw, this);
  }
  
  public void a(List<syn> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull taw paramtaw, @Nullable tcf paramtcf, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramtcf != null))
    {
      paramtaw = new swt(1);
      paramErrorMessage = (spt)sqg.a(19);
      paramtcf = paramtcf.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramtcf.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new sws(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramtaw.a.add(localObject2);
      }
      paramErrorMessage = (uje)sqg.a(11);
      localObject1 = new ArrayList(paramtcf.size());
      paramtcf = paramtcf.iterator();
      while (paramtcf.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramtcf.next();
        if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
        {
          VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)paramErrorMessage.a(((VideoCollectionItem)localObject2).feedId);
          if (localVideoListFeedItem != null)
          {
            localVideoListFeedItem.mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
            ((ArrayList)localObject1).add(localVideoListFeedItem);
          }
        }
      }
      paramErrorMessage.a((List)localObject1);
      sgi.a().dispatch(paramtaw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sym
 * JD-Core Version:    0.7.0.1
 */