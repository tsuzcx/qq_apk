package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.List;

class TroopFileMultiOperate$5
  implements FMDialogUtil.FMDialogInterface
{
  TroopFileMultiOperate$5(TroopFileMultiOperate paramTroopFileMultiOperate, List paramList) {}
  
  public void a()
  {
    FMToastUtil.d(TroopFileMultiOperate.b(this.b).getString(2131889761));
    TroopFileUtils.a(TroopFileMultiOperate.a(this.b), TroopFileMultiOperate.c(this.b), this.a);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate.5
 * JD-Core Version:    0.7.0.1
 */