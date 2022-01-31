import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import java.util.List;

public class em
  extends BaseAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new en(this);
  
  public em(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b != null) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size() > 0)) {
      return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b != null) && (paramInt < this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size())) {
      return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.get(paramInt);
    }
    return new el(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity, 1, 0L, this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaLangString);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b != null) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size() > 0)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = ((el)getItem(paramInt)).jdField_a_of_type_JavaLangString;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = (el)getItem(paramInt);
      if (paramViewGroup.jdField_a_of_type_Int == 1)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559400, null);
        paramViewGroup = (TextView)paramView.findViewById(2131377045);
      }
    }
    for (;;)
    {
      if (paramViewGroup != null)
      {
        paramViewGroup.setText(str);
        paramViewGroup.setTag(Integer.valueOf(paramInt));
      }
      return paramView;
      if (paramViewGroup.jdField_a_of_type_Int == 2)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559401, null);
        View localView = paramView.findViewById(2131363962);
        paramViewGroup = (TextView)paramView.findViewById(2131363963);
        localView.setClickable(true);
        localView.setEnabled(true);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        continue;
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558962, null);
        paramView.findViewById(2131369329).setVisibility(8);
        paramViewGroup = (TextView)paramView.findViewById(2131369330);
        paramViewGroup.setTextSize(19.0F);
        paramViewGroup.setTextColor(-16777216);
      }
      else
      {
        paramViewGroup = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     em
 * JD-Core Version:    0.7.0.1
 */