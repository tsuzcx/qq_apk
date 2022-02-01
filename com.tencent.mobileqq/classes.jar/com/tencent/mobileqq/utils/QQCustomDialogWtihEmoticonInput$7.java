package com.tencent.mobileqq.utils;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
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
    if (this.a.l.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.a.l.getText();
      int i = this.a.l.getSelectionStart();
      int j = android.text.TextUtils.getOffsetBefore(this.a.l.getText(), i);
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
      i = this.a.l.getSelectionStart();
      j = this.a.l.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.a.l.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      }
    }
    else if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = this.a.l.getSelectionStart();
      j = this.a.l.getSelectionEnd();
      int k = localSystemAndEmojiEmoticonInfo.emotionType;
      int m = localSystemAndEmojiEmoticonInfo.code;
      if ((i >= 0) && (j >= 0) && (j >= i))
      {
        if ((k == 2) && (m == -1)) {
          return;
        }
        if (k == 1) {
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(m);
        } else {
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(m);
        }
        this.a.l.getEditableText().replace(i, j, paramEmoticonInfo);
        this.a.l.requestFocus();
      }
      if (this.a.m) {
        localSystemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      QQSysAndEmojiResMgr.getInstance().getResImpl(k).reportEmoClick(m, 5);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.7
 * JD-Core Version:    0.7.0.1
 */