import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;

public class tai
  extends BaseAdapter
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String[] b;
  
  private tai(JobSelectionActivity paramJobSelectionActivity)
  {
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity))
    {
      paramJobSelectionActivity = ConditionSearchManager.d;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label74;
      }
      paramJobSelectionActivity = ConditionSearchManager.e;
      label42:
      this.b = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label81;
      }
    }
    label74:
    label81:
    for (paramJobSelectionActivity = ConditionSearchManager.jdField_a_of_type_ArrayOfInt;; paramJobSelectionActivity = NearbyProfileUtil.b)
    {
      this.jdField_a_of_type_ArrayOfInt = paramJobSelectionActivity;
      return;
      paramJobSelectionActivity = NearbyProfileUtil.d;
      break;
      paramJobSelectionActivity = NearbyProfileUtil.e;
      break label42;
    }
  }
  
  public int getCount()
  {
    if (JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString.length;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString.length - 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString[(paramInt + 1)];
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getLayoutInflater().inflate(2130970383, paramViewGroup, false);
      paramView = new taj(null);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131367250));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362759));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370260));
      localView.setTag(paramView);
    }
    paramView = (taj)localView.getTag();
    int i = paramInt;
    if (!JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      i = paramInt + 1;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(this.b[i]);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[i]);
    paramInt = AIOUtils.a(4.0F, JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity).getResources());
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setPadding(paramInt, 0, paramInt, 0);
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) && (i == 0)) {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity) != i) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tai
 * JD-Core Version:    0.7.0.1
 */