package com.tencent.mobileqq.troop.activity.editservice;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class EditTroopFingerMemoService$1
  implements OnItemSelectListener
{
  EditTroopFingerMemoService$1(EditTroopFingerMemoService paramEditTroopFingerMemoService) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      paramView = new QQText(EditTroopFingerMemoService.a(this.a).getText(), 3).trim();
      Intent localIntent = new Intent();
      localIntent.putExtra("result", paramView);
      EditTroopFingerMemoService.a(this.a).onFinishForResult(-1, localIntent);
      return;
    }
    EditTroopFingerMemoService.a(this.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopFingerMemoService.1
 * JD-Core Version:    0.7.0.1
 */