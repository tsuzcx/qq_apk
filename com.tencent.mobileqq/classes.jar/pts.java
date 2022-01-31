import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import java.util.List;

public class pts
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<Long> jdField_a_of_type_JavaUtilList;
  
  public pts(Context paramContext, List<Long> paramList)
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt)) {
      return null;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494422, paramViewGroup, false);
      paramViewGroup = new ptt();
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309746));
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131302951));
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131312440));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (paramViewGroup != null)
      {
        long l = ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt)).longValue();
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l);
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131309080, Integer.valueOf(paramInt));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
      return paramView;
      if ((paramView.getTag() instanceof ptt)) {
        paramViewGroup = (ptt)paramView.getTag();
      } else {
        paramViewGroup = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i;
    do
    {
      do
      {
        return;
      } while (paramView.getTag(2131309080) == null);
      i = ((Integer)paramView.getTag(2131309080)).intValue();
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= i));
    nvx.a(String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)), this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pts
 * JD-Core Version:    0.7.0.1
 */