import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import java.util.List;

public class sih
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public sih(DiscussionMemberActivity paramDiscussionMemberActivity, List paramList)
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
    sie localsie;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2130968944, paramViewGroup, false);
      paramViewGroup = new sij(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131364316));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363531));
      paramView.setTag(paramViewGroup);
      localsie = (sie)getItem(paramInt);
      if (localsie != null)
      {
        if ((localsie.b != null) && (!"".equals(localsie.b.trim()))) {
          break label149;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localsie.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localsie.jdField_a_of_type_JavaLangString;
      paramViewGroup.c.setImageBitmap(a(1, localsie.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (sij)paramView.getTag();
      break;
      label149:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localsie.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sih
 * JD-Core Version:    0.7.0.1
 */