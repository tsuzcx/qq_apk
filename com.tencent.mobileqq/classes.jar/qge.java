import android.widget.ArrayAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;
import java.util.List;

public class qge
  extends osp
{
  public qge(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(false);
    ReadInJoyVideoSearchTagFragment.a(this.a).clear();
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(true);
    ReadInJoyVideoSearchTagFragment.a(this.a).addAll(paramList);
    if (paramList.isEmpty()) {
      bcpw.a(this.a.getActivity(), 2131718576, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qge
 * JD-Core Version:    0.7.0.1
 */