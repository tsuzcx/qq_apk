package com.tencent.mobileqq.guild.setting;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;
import mqq.app.MobileQQ;

final class QQGuildDescriptionEditFragment$8
  implements EmoticonCallback
{
  QQGuildDescriptionEditFragment$8(EditText paramEditText) {}
  
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
    paramEmoticonInfo.send(MobileQQ.sMobileQQ.peekAppRuntime(), this.a.getContext(), this.a, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.8
 * JD-Core Version:    0.7.0.1
 */