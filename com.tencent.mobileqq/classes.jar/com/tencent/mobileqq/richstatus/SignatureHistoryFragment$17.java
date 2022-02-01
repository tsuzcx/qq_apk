package com.tencent.mobileqq.richstatus;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

final class SignatureHistoryFragment$17
  implements EmoticonCallback
{
  SignatureHistoryFragment$17(EditText paramEditText, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void delete()
  {
    TextUtils.backspace(this.a);
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (paramEmoticonInfo != null) {}
    try
    {
      paramEmoticonInfo.send(this.b, this.c, this.a, null);
      return;
    }
    catch (Throwable paramEmoticonInfo) {}
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.17
 * JD-Core Version:    0.7.0.1
 */