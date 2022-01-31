import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import org.json.JSONObject;

public class ozv
  implements IphonePickerView.IphonePickListener
{
  public ozv(NewerGuidePlugin paramNewerGuidePlugin, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onConfirmBtClicked mSelectedIndex=%s", new Object[] { Integer.valueOf(NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin)) }));
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 1);
      localJSONObject.put("index", NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin));
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respSelector", new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NewerGuidePlugin", 1, "sendSelectorResp fail", localException);
      }
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozv
 * JD-Core Version:    0.7.0.1
 */