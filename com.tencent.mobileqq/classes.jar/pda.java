import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

public class pda
  implements TextWatcher
{
  public pda(MoveFileActivity paramMoveFileActivity, EditText paramEditText, InputDialog paramInputDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    TextView localTextView = this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.getBtnight();
    if (TroopFileUtils.b(paramEditable))
    {
      localTextView.setEnabled(false);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getResources().getColor(2131493063));
      return;
    }
    localTextView.setEnabled(true);
    localTextView.setTextColor(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getResources().getColor(2131493062));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      paramCharSequence = paramCharSequence.toString();
      String str = TroopFileUtils.b(paramCharSequence);
      if ((paramCharSequence == null) || (paramCharSequence.equals(str))) {
        break label57;
      }
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
    }
    label57:
    while (!this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pda
 * JD-Core Version:    0.7.0.1
 */