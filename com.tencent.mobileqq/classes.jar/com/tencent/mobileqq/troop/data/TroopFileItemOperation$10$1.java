package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopFileItemOperation$10$1
  implements Runnable
{
  TroopFileItemOperation$10$1(TroopFileItemOperation.10 param10) {}
  
  public void run()
  {
    Object localObject = this.a.a.i(this.a.b.b);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.c.a(this.a.b, this.a.c.a.getString(2131895545), this.a.c.a.getString(2131895546));
      return;
    }
    int i = TroopFileItemOperation.a(this.a.c, false);
    TroopFileItemOperation.10.1.1 local1 = new TroopFileItemOperation.10.1.1(this);
    if (i == 1) {
      localObject = TroopFileItemOperation.a(2131895175, new Object[] { TroopFileUtils.a(this.a.b.d), this.a.b.a() });
    } else {
      localObject = TroopFileItemOperation.a(2131895478, new Object[] { TroopFileUtils.a(this.a.b.d) });
    }
    DialogUtil.a(this.a.c.a, 230, TroopFileItemOperation.a(2131895480), (String)localObject, 2131887648, 2131895479, local1, local1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */