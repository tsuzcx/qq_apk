package com.tencent.timi.game.liveroom.impl.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.concurrent.ConcurrentHashMap;

final class TgLiveShareUtil$4
  implements DialogInterface.OnDismissListener
{
  TgLiveShareUtil$4(View paramView, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("imp_end", this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.TgLiveShareUtil.4
 * JD-Core Version:    0.7.0.1
 */