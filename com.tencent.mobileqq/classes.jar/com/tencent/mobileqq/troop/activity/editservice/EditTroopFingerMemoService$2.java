package com.tencent.mobileqq.troop.activity.editservice;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class EditTroopFingerMemoService$2
  implements EmoticonCallback
{
  EditTroopFingerMemoService$2(EditTroopFingerMemoService paramEditTroopFingerMemoService) {}
  
  public void delete()
  {
    TextUtils.backspace(EditTroopFingerMemoService.a(this.a));
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
    paramEmoticonInfo.send(EditTroopFingerMemoService.a(this.a), EditTroopFingerMemoService.a(this.a), EditTroopFingerMemoService.a(this.a), null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopFingerMemoService.2
 * JD-Core Version:    0.7.0.1
 */