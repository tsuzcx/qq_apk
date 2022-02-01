package cooperation.qzone.share;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;

final class InputViewPanelControl$1
  implements EmoticonCallback
{
  InputViewPanelControl$1(EditText paramEditText) {}
  
  public void delete()
  {
    Object localObject = this.val$viewEdit;
    if (localObject == null) {
      return;
    }
    if (((EditText)localObject).getSelectionStart() == 0) {
      return;
    }
    try
    {
      localObject = this.val$viewEdit.getText();
      int i = this.val$viewEdit.getSelectionStart();
      int j = android.text.TextUtils.getOffsetBefore(this.val$viewEdit.getText(), i);
      if (i != j)
      {
        ((Editable)localObject).delete(Math.min(i, j), Math.max(i, j));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (paramEmoticonInfo != null)
    {
      EditText localEditText = this.val$viewEdit;
      if (localEditText == null) {
        return;
      }
      if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
      {
        int i = localEditText.getSelectionStart();
        int j = this.val$viewEdit.getSelectionEnd();
        if ((i >= 0) && (j >= 0) && (j >= i))
        {
          localEditText = this.val$viewEdit;
          if ((localEditText != null) && (localEditText.getEditableText() != null)) {
            this.val$viewEdit.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
          }
        }
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.InputViewPanelControl.1
 * JD-Core Version:    0.7.0.1
 */