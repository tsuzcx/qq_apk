import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class nqi
  extends ArrayAdapter<nqh>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<nqh> jdField_a_of_type_JavaUtilList;
  
  public nqi(Context paramContext, int paramInt, List<nqh> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public nqh a(int paramInt)
  {
    return (nqh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559082, null);
      paramViewGroup = new nqj();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372418));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372419));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      nqh localnqh = a(paramInt);
      paramViewGroup.jdField_a_of_type_Nqh = localnqh;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localnqh.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localnqh.jdField_a_of_type_Int);
      return paramView;
      paramViewGroup = (nqj)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqi
 * JD-Core Version:    0.7.0.1
 */