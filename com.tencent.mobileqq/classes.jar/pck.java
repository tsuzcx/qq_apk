import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class pck
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<pcm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public pck(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pcn parampcn)
  {
    String str;
    if (((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    }
    for (;;)
    {
      parampcn.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
      if (((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
        str = ((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
    }
  }
  
  public void a(List<pcm> paramList)
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
    if ((paramView != null) && (((pcn)paramView.getTag()).jdField_a_of_type_Int == ((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      paramViewGroup = (pcn)paramView.getTag();
      a(paramInt, paramViewGroup);
      return paramView;
    }
    pcn localpcn = new pcn(this, null);
    localpcn.jdField_a_of_type_Int = ((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    if (((pcm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560010, paramViewGroup, false);
    }
    for (localpcn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364217));; localpcn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368068)))
    {
      paramView.setTag(localpcn);
      paramViewGroup = localpcn;
      break;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560013, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pck
 * JD-Core Version:    0.7.0.1
 */