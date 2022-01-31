import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspAddGroupVideo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tbb
  extends slu
{
  private final qqstory_group.RspAddGroupVideo a;
  
  public tbb(qqstory_group.RspAddGroupVideo paramRspAddGroupVideo)
  {
    super(paramRspAddGroupVideo.result);
    this.a = paramRspAddGroupVideo;
  }
  
  public List<tbc> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.group_feed_list.get().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new tbc((qqstory_group.GroupFeed)localIterator.next()));
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "AddGroupVideoResponse{mRspAddGroupVideo=" + a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbb
 * JD-Core Version:    0.7.0.1
 */