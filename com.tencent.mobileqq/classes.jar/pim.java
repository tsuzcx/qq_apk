import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class pim
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<pio> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public pim(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pip parampip)
  {
    String str;
    if (((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    }
    for (;;)
    {
      parampip.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
      if (((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
        str = ((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
    }
  }
  
  public void a(List<pio> paramList)
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
    if ((paramView != null) && (((pip)paramView.getTag()).jdField_a_of_type_Int == ((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      paramViewGroup = (pip)paramView.getTag();
      a(paramInt, paramViewGroup);
      return paramView;
    }
    pip localpip = new pip(this, null);
    localpip.jdField_a_of_type_Int = ((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    if (((pio)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560109, paramViewGroup, false);
    }
    for (localpip.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364280));; localpip.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368206)))
    {
      paramView.setTag(localpip);
      paramViewGroup = localpip;
      break;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560112, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pim
 * JD-Core Version:    0.7.0.1
 */