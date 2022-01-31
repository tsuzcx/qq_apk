import android.view.View;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class kxq
  implements AdapterView.OnItemClickListener
{
  public kxq(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (PaConfigAttr.PaConfigInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxq
 * JD-Core Version:    0.7.0.1
 */