package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

final class StickyNotePublishFragment$5
  implements EmoticonCallback
{
  StickyNotePublishFragment$5(EditText paramEditText, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.5
 * JD-Core Version:    0.7.0.1
 */