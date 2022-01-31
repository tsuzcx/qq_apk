import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import java.util.List;

public class slf
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public slf(DiscussionMemberActivity paramDiscussionMemberActivity, List paramList)
  {
    super(paramDiscussionMemberActivity, paramDiscussionMemberActivity.app, paramDiscussionMemberActivity.a, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    slc localslc;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2130968944, paramViewGroup, false);
      paramViewGroup = new slh(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131364340));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363549));
      paramView.setTag(paramViewGroup);
      localslc = (slc)getItem(paramInt);
      if (localslc != null)
      {
        if ((localslc.b != null) && (!"".equals(localslc.b.trim()))) {
          break label149;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localslc.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localslc.jdField_a_of_type_JavaLangString;
      paramViewGroup.c.setImageBitmap(a(1, localslc.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (slh)paramView.getTag();
      break;
      label149:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localslc.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slf
 * JD-Core Version:    0.7.0.1
 */