import android.view.View;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class ojj
  implements AdapterView.OnItemClickListener
{
  public ojj(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (oji)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.a.jdField_a_of_type_Ojm == null) {
      return;
    }
    this.a.jdField_a_of_type_Ojm.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojj
 * JD-Core Version:    0.7.0.1
 */