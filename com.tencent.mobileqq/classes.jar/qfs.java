import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import java.util.List;

public class qfs
  extends osm
{
  public qfs(ReadInJoyTopicSelectionFragment paramReadInJoyTopicSelectionFragment) {}
  
  public void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    if (paramList.size() == 0)
    {
      ReadInJoyTopicSelectionFragment.a(this.a).clear();
      ReadInJoyTopicSelectionFragment.a(this.a).addAll(paramList1);
      this.a.a.clear();
      this.a.a.addAll(ReadInJoyTopicSelectionFragment.a(paramList1));
      ReadInJoyTopicSelectionFragment.a(this.a).notifyDataSetChanged();
      onh.a(ReadInJoyTopicSelectionFragment.a(this.a), ReadInJoyTopicSelectionFragment.a(this.a), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfs
 * JD-Core Version:    0.7.0.1
 */