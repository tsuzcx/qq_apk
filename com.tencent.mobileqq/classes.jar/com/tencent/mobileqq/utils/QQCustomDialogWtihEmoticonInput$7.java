package com.tencent.mobileqq.utils;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import asjb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;

class QQCustomDialogWtihEmoticonInput$7
  implements EmoticonCallback
{
  QQCustomDialogWtihEmoticonInput$7(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public void delete()
  {
    if (this.this$0.inputView.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.this$0.inputView.getText();
        int i = this.this$0.inputView.getSelectionStart();
        int j = android.text.TextUtils.getOffsetBefore(this.this$0.inputView.getText(), i);
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
    int i;
    int j;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i = this.this$0.inputView.getSelectionStart();
      j = this.this$0.inputView.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo;
    int k;
    int m;
    do
    {
      this.this$0.inputView.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo));
      localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = this.this$0.inputView.getSelectionStart();
      j = this.this$0.inputView.getSelectionEnd();
      k = localSystemAndEmojiEmoticonInfo.emotionType;
      m = localSystemAndEmojiEmoticonInfo.code;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(m);; paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(m))
    {
      this.this$0.inputView.getEditableText().replace(i, j, paramEmoticonInfo);
      this.this$0.inputView.requestFocus();
      if (this.this$0.useAIOStyle) {
        localSystemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      asjb.a().a(k).a(m, 5);
      return;
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.7
 * JD-Core Version:    0.7.0.1
 */