import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ncc
  extends ArrayAdapter<ncb>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<ncb> jdField_a_of_type_JavaUtilList;
  
  public ncc(Context paramContext, int paramInt, List<ncb> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public ncb a(int paramInt)
  {
    return (ncb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493479, null);
      paramViewGroup = new ncd();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306383));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306384));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ncb localncb = a(paramInt);
      paramViewGroup.jdField_a_of_type_Ncb = localncb;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localncb.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localncb.jdField_a_of_type_Int);
      return paramView;
      paramViewGroup = (ncd)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncc
 * JD-Core Version:    0.7.0.1
 */