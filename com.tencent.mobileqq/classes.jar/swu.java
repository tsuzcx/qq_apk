import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class swu
  extends swk
  implements slx
{
  public static ConcurrentHashMap<String, Long> a;
  public List<String> a;
  public uje a;
  private final boolean a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public swu(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public swu(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new swu(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).a();
      i += 1;
    }
  }
  
  private void b(List<srj> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      srj localsrj = (srj)paramList.next();
      FeedItem localFeedItem = this.jdField_a_of_type_Uje.a(localsrj.a);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localsrj.a });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localsrj);
        localArrayList.add(localFeedItem);
      }
    }
    this.jdField_a_of_type_Uje.a(localArrayList);
  }
  
  public void a()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public void a(@NonNull slz paramslz, @Nullable slu paramslu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramslz instanceof szp)) && ((paramslu instanceof tbm)))
    {
      paramslz = (tbm)paramslu;
      paramslu = new swv();
      paramslu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramslz.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((srj)paramslz.jdField_a_of_type_JavaUtilList.get(0)).a });
        }
        b(paramslz.jdField_a_of_type_JavaUtilList);
        paramslu.jdField_a_of_type_JavaUtilList = paramslz.jdField_a_of_type_JavaUtilList;
        sgi.a().dispatch(paramslu);
        b();
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, "save feedFeature failed.", paramErrorMessage);
        }
        sgi.a().dispatch(paramslu);
        c();
        return;
      } while ((!(paramslz instanceof szd)) || (!(paramslu instanceof sze)));
      paramslz = (sze)paramslu;
      if (paramErrorMessage.isSuccess())
      {
        paramslu = new ArrayList(paramslz.jdField_a_of_type_JavaUtilList.size());
        paramslz = paramslz.jdField_a_of_type_JavaUtilList.iterator();
        while (paramslz.hasNext()) {
          paramslu.add(((ukt)paramslz.next()).a());
        }
        if (!paramslu.isEmpty())
        {
          this.jdField_a_of_type_Uje.a(paramslu);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramslu.get(0)).feedId, ". request FeedFeature." });
          }
          paramslz = new szp();
          paramslz.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          slv.a().a(paramslz, this);
          return;
        }
      }
    } while (this.b.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.b.get(0) });
    }
    paramslz = new szp();
    paramslz.jdField_a_of_type_JavaUtilList = this.b;
    slv.a().a(paramslz, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swu
 * JD-Core Version:    0.7.0.1
 */