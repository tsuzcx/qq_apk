import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;
import java.util.List;

public class qgm
  extends osp
{
  public qgm(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoTagSelectionFragment.a(this.a).addAll(paramList);
    osm.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgm
 * JD-Core Version:    0.7.0.1
 */