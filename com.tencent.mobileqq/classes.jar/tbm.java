import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tbm
  extends slu
{
  public List<srj> a = new ArrayList();
  
  public tbm(qqstory_service.RspGetBatchFeedFeature paramRspGetBatchFeedFeature)
  {
    if ((paramRspGetBatchFeedFeature.feed_feature_list.has()) && (!paramRspGetBatchFeedFeature.feed_feature_list.isEmpty()))
    {
      paramRspGetBatchFeedFeature = paramRspGetBatchFeedFeature.feed_feature_list.get().iterator();
      while (paramRspGetBatchFeedFeature.hasNext())
      {
        qqstory_struct.FeedFeature localFeedFeature = (qqstory_struct.FeedFeature)paramRspGetBatchFeedFeature.next();
        srj localsrj = new srj();
        localsrj.a(localFeedFeature);
        this.a.add(localsrj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbm
 * JD-Core Version:    0.7.0.1
 */