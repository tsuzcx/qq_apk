package com.tencent.mobileqq.onlinestatus.tempapi.impl;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;
import mqq.app.AppRuntime;

class EmojiPanelApiImpl$1
  implements EmoticonCallback
{
  EmojiPanelApiImpl$1(EmojiPanelApiImpl paramEmojiPanelApiImpl, EditText paramEditText, AppRuntime paramAppRuntime, Activity paramActivity) {}
  
  public void delete()
  {
    TextUtils.backspace(this.jdField_a_of_type_AndroidWidgetEditText);
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
      paramEmoticonInfo.send(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
      return;
    }
    catch (Throwable paramEmoticonInfo) {}
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.tempapi.impl.EmojiPanelApiImpl.1
 * JD-Core Version:    0.7.0.1
 */