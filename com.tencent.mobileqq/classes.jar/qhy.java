import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;

public class qhy
  extends BaseAdapter
  implements qgz<ObservableArrayList<ResultRecord>>
{
  private PorterDuffColorFilter jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = new PorterDuffColorFilter(-1711276033, PorterDuff.Mode.SRC_ATOP);
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = new ObservableArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public qhy(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size();
    if (i > 0)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.remove(i - 1);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    notifyDataSetChanged();
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      paramViewGroup = (ReadInJoyHeadImageView)paramView.getTag();
    }
    for (;;)
    {
      Object localObject = getItem(paramInt);
      if ((localObject != null) && ((localObject instanceof ResultRecord))) {
        paramViewGroup.setHeadImgByUin(((ResultRecord)localObject).a());
      }
      int i = getCount();
      paramViewGroup = paramView.findViewById(2131367896);
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != i - 1)) {
        break;
      }
      paramViewGroup.setVisibility(0);
      return paramView;
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560014, paramViewGroup, false);
      paramViewGroup = (ReadInJoyHeadImageView)paramView.findViewById(2131367895);
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhy
 * JD-Core Version:    0.7.0.1
 */