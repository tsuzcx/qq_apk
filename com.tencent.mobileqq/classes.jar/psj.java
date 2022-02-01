import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class psj
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<psl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public psj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, psm parampsm)
  {
    String str;
    if (((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    }
    for (;;)
    {
      parampsm.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
      if (((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
        str = ((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
    }
  }
  
  public void a(List<psl> paramList)
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
    if ((paramView != null) && (((psm)paramView.getTag()).jdField_a_of_type_Int == ((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      localpsm = (psm)paramView.getTag();
      localView = paramView;
      a(paramInt, localpsm);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    psm localpsm = new psm(this, null);
    localpsm.jdField_a_of_type_Int = ((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    if (((psl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560262, paramViewGroup, false);
    }
    for (localpsm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364540));; localpsm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368617)))
    {
      localView.setTag(localpsm);
      break;
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560265, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psj
 * JD-Core Version:    0.7.0.1
 */