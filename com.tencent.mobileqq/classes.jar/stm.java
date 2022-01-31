import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.util.List;

public class stm
  implements IphonePickerView.IphonePickListener, IphonePickerView.PickerViewAdapter, ActionSheet.OnDismissListener
{
  int jdField_a_of_type_Int;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  final List jdField_a_of_type_JavaUtilList;
  sto jdField_a_of_type_Sto;
  int b;
  
  public stm(ActionSheet paramActionSheet, List paramList, String paramString, sto paramsto)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = 0;
    this.b = paramList.indexOf(paramString);
    if (this.b < 0) {
      this.b = 0;
    }
    this.jdField_a_of_type_Sto = paramsto;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramInt1 == 0)
    {
      str1 = str2;
      if (paramInt2 >= 0)
      {
        str1 = str2;
        if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()) {
          str1 = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
        }
      }
    }
    return str1;
  }
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_Sto != null) && (this.b >= 0) && (this.b < this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_Sto.a(1, (String)this.jdField_a_of_type_JavaUtilList.get(this.b));
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onDismiss()
  {
    if ((this.jdField_a_of_type_Sto != null) && (this.b >= 0) && (this.b < this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_Sto.a(2, (String)this.jdField_a_of_type_JavaUtilList.get(this.b));
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 != 0) {
      i = 0;
    }
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      this.b = paramInt1;
      if ((this.jdField_a_of_type_Sto != null) && (this.b >= 0) && (this.b < this.jdField_a_of_type_JavaUtilList.size())) {
        this.jdField_a_of_type_Sto.a(0, (String)this.jdField_a_of_type_JavaUtilList.get(this.b));
      }
      return;
      paramInt1 = paramInt2;
      if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
        paramInt1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stm
 * JD-Core Version:    0.7.0.1
 */