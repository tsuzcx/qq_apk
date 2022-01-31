import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

public class ozu
  implements IphonePickerView.PickerViewAdapter
{
  public ozu(NewerGuidePlugin paramNewerGuidePlugin, String[] paramArrayOfString) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString.length;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozu
 * JD-Core Version:    0.7.0.1
 */