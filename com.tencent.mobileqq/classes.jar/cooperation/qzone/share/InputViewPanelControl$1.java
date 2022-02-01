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
    if (this.val$viewEdit == null) {}
    for (;;)
    {
      return;
      if (this.val$viewEdit.getSelectionStart() != 0) {
        try
        {
          Editable localEditable = this.val$viewEdit.getText();
          int i = this.val$viewEdit.getSelectionStart();
          int j = android.text.TextUtils.getOffsetBefore(this.val$viewEdit.getText(), i);
          if (i != j)
          {
            localEditable.delete(Math.min(i, j), Math.max(i, j));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
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
    if ((paramEmoticonInfo == null) || (this.val$viewEdit == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemEmoticonInfo));
      i = this.val$viewEdit.getSelectionStart();
      j = this.val$viewEdit.getSelectionEnd();
    } while ((i < 0) || (j < 0) || (j < i) || (this.val$viewEdit == null) || (this.val$viewEdit.getEditableText() == null));
    this.val$viewEdit.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.InputViewPanelControl.1
 * JD-Core Version:    0.7.0.1
 */