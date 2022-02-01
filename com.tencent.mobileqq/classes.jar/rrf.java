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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rrf
  extends BaseAdapter
  implements rnp<ObservableArrayList<ResultRecord>>
{
  private PorterDuffColorFilter jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = new PorterDuffColorFilter(-1711276033, PorterDuff.Mode.SRC_ATOP);
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = new ObservableArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public rrf(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
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
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = (ReadInJoyHeadImageView)paramView.getTag();
      Object localObject2 = getItem(paramInt);
      if ((localObject2 != null) && ((localObject2 instanceof ResultRecord))) {
        ((ReadInJoyHeadImageView)localObject1).setHeadImgByUin(((ResultRecord)localObject2).a());
      }
      int i = getCount();
      localObject1 = paramView.findViewById(2131368368);
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != i - 1)) {
        break label132;
      }
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560256, paramViewGroup, false);
      localObject1 = (ReadInJoyHeadImageView)paramView.findViewById(2131368367);
      paramView.setTag(localObject1);
      break;
      label132:
      ((View)localObject1).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrf
 * JD-Core Version:    0.7.0.1
 */