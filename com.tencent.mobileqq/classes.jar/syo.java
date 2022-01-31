import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class syo
  extends swk
  implements slx<tan, tby>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public syo(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public syo(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(List<String> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!StoryVideoItem.isFakeVid(str)) {
          this.jdField_a_of_type_JavaUtilList.add(str);
        }
      }
    }
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new VidToBasicInfoHandler.1(this), 0);
  }
  
  public void a(@NonNull tan paramtan, @Nullable tby paramtby, @NonNull ErrorMessage paramErrorMessage)
  {
    syp localsyp = new syp();
    if ((paramtby == null) || (paramErrorMessage.isFail()))
    {
      c();
      localsyp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      sgi.a().dispatch(localsyp);
      paramtan = paramtan.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramtan.hasNext())
    {
      paramtby = (String)paramtan.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramtby);
      continue;
      paramtan = (sqd)sqg.a(5);
      if (paramtby.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramtby.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramtby.jdField_a_of_type_JavaUtilList = paramtan.a(paramtby.jdField_a_of_type_JavaUtilList);
      localsyp.jdField_a_of_type_JavaUtilList = paramtby.jdField_a_of_type_JavaUtilList;
      ((sgs)sqg.a(28)).a(paramtby.b);
      sgi.a().dispatch(localsyp);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syo
 * JD-Core Version:    0.7.0.1
 */