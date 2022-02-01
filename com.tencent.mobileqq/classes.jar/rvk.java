import android.widget.ArrayAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class rvk
  extends pvq
{
  public rvk(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(false);
    ReadInJoyVideoSearchTagFragment.a(this.a).clear();
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(true);
    ReadInJoyVideoSearchTagFragment.a(this.a).addAll(paramList);
    if (paramList.isEmpty()) {
      QQToast.a(this.a.getActivity(), 2131717900, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvk
 * JD-Core Version:    0.7.0.1
 */