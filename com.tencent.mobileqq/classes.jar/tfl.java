import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class tfl
  extends JobSegment<List<tsr>, List<tsr>>
{
  tfi a;
  
  public tfl(tfi paramtfi)
  {
    this.a = paramtfi;
  }
  
  protected void a(JobContext paramJobContext, List<tsr> paramList)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.a.jdField_a_of_type_Int == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobLocalVideo", 2, "self node, check local video");
      }
      paramJobContext = (tcz)tdc.a(5);
      localObject1 = ((tgb)QQStoryContext.a().getManager(251)).a().a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString);
      if ((localObject1 == null) || (((tfi)localObject1).b == null) || (((tfi)localObject1).b.isEmpty())) {
        break label410;
      }
      localObject1 = ((tfi)localObject1).b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (tsr)((Iterator)localObject1).next();
        localObject3 = paramJobContext.a(((tsr)localObject2).jdField_b_of_type_JavaLangString);
        if (localObject3 != null)
        {
          ((tsr)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject3);
          paramList.add(localObject2);
        }
      }
    }
    label410:
    for (int i = 1;; i = 0)
    {
      localObject1 = paramJobContext.a(false);
      int j = i;
      if (localObject1 != null)
      {
        j = i;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
            localObject3 = new tsr();
            ((tsr)localObject3).jdField_a_of_type_Boolean = false;
            ((tsr)localObject3).jdField_a_of_type_JavaLangString = ((StoryVideoItem)localObject2).mAttachedFeedId;
            ((tsr)localObject3).jdField_b_of_type_JavaLangString = ((StoryVideoItem)localObject2).mVid;
            ((tsr)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject2);
            ((tsr)localObject3).jdField_b_of_type_Boolean = true;
            paramList.add(localObject3);
          }
          j = 1;
        }
      }
      if (j != 0)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (tsr)((Iterator)localObject1).next();
          if (((tsr)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
            ((tsr)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramJobContext.a(((tsr)localObject2).jdField_b_of_type_JavaLangString);
          }
          if (((tsr)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            notifyError(new ErrorMessage(940001, "should not be null"));
            return;
          }
        }
        Collections.sort(paramList, new tfm(this));
      }
      if (paramList.isEmpty())
      {
        notifyError(new ErrorMessage(103, "nodeInfo not valid"));
        return;
      }
      notifyResult(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfl
 * JD-Core Version:    0.7.0.1
 */