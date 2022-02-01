import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class oap
  extends ArrayAdapter<oao>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<oao> jdField_a_of_type_JavaUtilList;
  
  public oap(Context paramContext, int paramInt, List<oao> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public oao a(int paramInt)
  {
    return (oao)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559151, null);
      paramView = new oaq();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373120));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373121));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      paramView.jdField_a_of_type_Oao = ((oao)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((oao)localObject).jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((oao)localObject).jdField_a_of_type_Int);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (oaq)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oap
 * JD-Core Version:    0.7.0.1
 */