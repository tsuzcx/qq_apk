package com.tencent.mobileqq.forward;

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
import com.tencent.qphone.base.util.QLog;

class ForwardNewVersionDialog$6
  implements EmoticonCallback
{
  ForwardNewVersionDialog$6(ForwardNewVersionDialog paramForwardNewVersionDialog) {}
  
  public void delete()
  {
    if (ForwardNewVersionDialog.a(this.a).getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = ForwardNewVersionDialog.a(this.a).getText();
      int i = ForwardNewVersionDialog.a(this.a).getSelectionStart();
      int j = android.text.TextUtils.getOffsetBefore(ForwardNewVersionDialog.a(this.a).getText(), i);
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
      i = ForwardNewVersionDialog.a(this.a).getSelectionStart();
      j = ForwardNewVersionDialog.a(this.a).getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        ForwardNewVersionDialog.a(this.a).getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      }
    }
    else if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = ForwardNewVersionDialog.a(this.a).getSelectionStart();
      j = ForwardNewVersionDialog.a(this.a).getSelectionEnd();
      int k = localSystemAndEmojiEmoticonInfo.emotionType;
      int m = localSystemAndEmojiEmoticonInfo.code;
      if ((i >= 0) && (j >= 0) && (j >= i))
      {
        if ((k == 2) && (m == -1)) {
          return;
        }
        if (k == 1) {}
        try
        {
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(m);
        }
        catch (Exception paramEmoticonInfo)
        {
          if (!QLog.isColorLevel()) {
            break label187;
          }
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(paramEmoticonInfo));
          label187:
          paramEmoticonInfo = "";
        }
        paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(m);
        ForwardNewVersionDialog.a(this.a).getEditableText().replace(i, j, paramEmoticonInfo);
        ForwardNewVersionDialog.a(this.a).requestFocus();
      }
      localSystemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      QQSysAndEmojiResMgr.getInstance().getResImpl(k).reportEmoClick(m, 4);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.6
 * JD-Core Version:    0.7.0.1
 */