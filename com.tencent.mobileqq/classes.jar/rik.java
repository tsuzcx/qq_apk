import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class rik
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<Long> jdField_a_of_type_JavaUtilList;
  
  public rik(Context paramContext, List<Long> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt))
    {
      localObject = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560252, paramViewGroup, false);
      localObject = new ril();
      ((ril)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376689));
      ((ril)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131369251));
      ((ril)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131379730));
      paramView.setTag(localObject);
    }
    for (;;)
    {
      if (localObject != null)
      {
        long l = ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt)).longValue();
        ((ril)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l);
        ((ril)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l);
        ((ril)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131375967, Integer.valueOf(paramInt));
        ((ril)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
      localObject = paramView;
      break;
      if ((paramView.getTag() instanceof ril)) {
        localObject = (ril)paramView.getTag();
      } else {
        localObject = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getTag(2131375967) != null)
      {
        int i = ((Integer)paramView.getTag(2131375967)).intValue();
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > i)) {
          oto.a(String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)), this.jdField_a_of_type_AndroidContentContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rik
 * JD-Core Version:    0.7.0.1
 */