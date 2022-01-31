import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class orl
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<orn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public orl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, oro paramoro)
  {
    String str;
    if (((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    }
    for (;;)
    {
      paramoro.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
      if (((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
        str = ((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
    }
  }
  
  public void a(List<orn> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (((oro)paramView.getTag()).jdField_a_of_type_Int == ((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      paramViewGroup = (oro)paramView.getTag();
      a(paramInt, paramViewGroup);
      return paramView;
    }
    oro localoro = new oro(this, null);
    localoro.jdField_a_of_type_Int = ((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    if (((orn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494444, paramViewGroup, false);
    }
    for (localoro.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298660));; localoro.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302448)))
    {
      paramView.setTag(localoro);
      paramViewGroup = localoro;
      break;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494447, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orl
 * JD-Core Version:    0.7.0.1
 */