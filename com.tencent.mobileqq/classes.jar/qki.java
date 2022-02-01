import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class qki
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<qkk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public qki(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, qkl paramqkl)
  {
    String str;
    if (((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    }
    for (;;)
    {
      paramqkl.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
      if (((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
        str = ((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
    }
  }
  
  public void a(List<qkk> paramList)
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
    View localView;
    if ((paramView != null) && (((qkl)paramView.getTag()).jdField_a_of_type_Int == ((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      localqkl = (qkl)paramView.getTag();
      localView = paramView;
      a(paramInt, localqkl);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    qkl localqkl = new qkl(this, null);
    localqkl.jdField_a_of_type_Int = ((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    if (((qkk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560315, paramViewGroup, false);
    }
    for (localqkl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364643));; localqkl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368801)))
    {
      localView.setTag(localqkl);
      break;
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560318, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qki
 * JD-Core Version:    0.7.0.1
 */