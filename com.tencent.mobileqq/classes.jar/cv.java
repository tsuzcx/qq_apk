import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import java.util.List;

public class cv
  extends BaseAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cw(this);
  
  public cv(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
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
    return new cu(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity, 1, 0L, this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaLangString);
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
    String str = ((cu)getItem(paramInt)).jdField_a_of_type_JavaLangString;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = (cu)getItem(paramInt);
      if (paramViewGroup.jdField_a_of_type_Int == 1)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559451, null);
        paramViewGroup = (TextView)paramView.findViewById(2131377620);
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
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559452, null);
        View localView = paramView.findViewById(2131364022);
        paramViewGroup = (TextView)paramView.findViewById(2131364023);
        localView.setClickable(true);
        localView.setEnabled(true);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        continue;
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558998, null);
        paramView.findViewById(2131369584).setVisibility(8);
        paramViewGroup = (TextView)paramView.findViewById(2131369585);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.7.0.1
 */