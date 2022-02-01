package com.tencent.mobileqq.troop.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;

class EditTroopNameService$1
  implements OnItemSelectListener
{
  EditTroopNameService$1(EditTroopNameService paramEditTroopNameService) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(EditTroopNameService.a(), 2, new Object[] { "onItemSelect: item + ", Integer.valueOf(paramInt) });
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      Object localObject = new QQText(EditTroopNameService.a(this.a).getText(), 3);
      paramView = ((QQText)localObject).toString();
      localObject = ((QQText)localObject).trim();
      if (((String)localObject).equals(EditTroopNameService.b(this.a)))
      {
        EditTroopNameService.a(this.a).onFinish();
        return;
      }
      if ((!TextUtils.isEmpty(paramView)) && (TextUtils.isEmpty((CharSequence)localObject)))
      {
        QQToast.makeText(EditTroopNameService.a(this.a).getContext(), EditTroopNameService.c(this.a).getString(2131890942), 0).show();
        return;
      }
      paramView = new Intent();
      paramView.putExtra("result", (String)localObject);
      EditTroopNameService.a(this.a).onFinishForResult(-1, paramView);
      return;
    }
    EditTroopNameService.a(this.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopNameService.1
 * JD-Core Version:    0.7.0.1
 */