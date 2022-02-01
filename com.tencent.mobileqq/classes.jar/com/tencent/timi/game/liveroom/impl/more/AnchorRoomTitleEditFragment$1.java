package com.tencent.timi.game.liveroom.impl.more;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.timi.game.ui.widget.CommonButton;

class AnchorRoomTitleEditFragment$1
  implements TextWatcher
{
  AnchorRoomTitleEditFragment$1(AnchorRoomTitleEditFragment paramAnchorRoomTitleEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!TextUtils.isEmpty(paramEditable))
    {
      AnchorRoomTitleEditFragment.a(this.a).setEnabled(true);
      return;
    }
    AnchorRoomTitleEditFragment.a(this.a).setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorRoomTitleEditFragment.1
 * JD-Core Version:    0.7.0.1
 */