import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class nna
  extends ArrayAdapter<nmz>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<nmz> jdField_a_of_type_JavaUtilList;
  
  public nna(Context paramContext, int paramInt, List<nmz> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public nmz a(int paramInt)
  {
    return (nmz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559042, null);
      paramViewGroup = new nnb();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372080));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372081));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      nmz localnmz = a(paramInt);
      paramViewGroup.jdField_a_of_type_Nmz = localnmz;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localnmz.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localnmz.jdField_a_of_type_Int);
      return paramView;
      paramViewGroup = (nnb)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nna
 * JD-Core Version:    0.7.0.1
 */