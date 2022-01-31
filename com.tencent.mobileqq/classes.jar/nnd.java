import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class nnd
  extends ArrayAdapter<nnc>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<nnc> jdField_a_of_type_JavaUtilList;
  
  public nnd(Context paramContext, int paramInt, List<nnc> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public nnc a(int paramInt)
  {
    return (nnc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      paramViewGroup = new nne();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372080));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372081));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      nnc localnnc = a(paramInt);
      paramViewGroup.jdField_a_of_type_Nnc = localnnc;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localnnc.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localnnc.jdField_a_of_type_Int);
      return paramView;
      paramViewGroup = (nne)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnd
 * JD-Core Version:    0.7.0.1
 */