import android.view.View;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class obs
  implements AdapterView.OnItemClickListener
{
  public obs(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (obr)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.a.jdField_a_of_type_Obv == null) {
      return;
    }
    this.a.jdField_a_of_type_Obv.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */