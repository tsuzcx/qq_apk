package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;

class ReadInJoyBaseDeliverActivity$6
  implements EmoticonCallback
{
  ReadInJoyBaseDeliverActivity$6(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void delete()
  {
    if (this.a.a.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.a.a.getText();
      int i = this.a.a.getSelectionStart();
      int j = TextUtils.getOffsetBefore(this.a.a.getText(), i);
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
    if ((paramEmoticonInfo instanceof IPicEmoticonInfo))
    {
      paramEmoticonInfo = (IPicEmoticonInfo)paramEmoticonInfo;
      ReadInJoyBaseDeliverActivity localReadInJoyBaseDeliverActivity = this.a;
      if ((localReadInJoyBaseDeliverActivity instanceof ReadInJoyDeliverUGCActivity)) {
        ((ReadInJoyDeliverUGCActivity)localReadInJoyBaseDeliverActivity).a(paramEmoticonInfo);
      }
    }
    else
    {
      ReadInJoyBaseDeliverActivity.a(this.a.app, paramEmoticonInfo, this.a.a);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.6
 * JD-Core Version:    0.7.0.1
 */