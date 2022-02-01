package com.tencent.timi.game.liveroom.impl.share;

import android.view.View;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.concurrent.ConcurrentHashMap;

final class TgLiveShareUtil$1
  implements ShareActionSheet.OnItemClickListener
{
  TgLiveShareUtil$1(View paramView, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    if (i != 2) {
      if (i != 3)
      {
        if (i != 9)
        {
          if (i != 10)
          {
            if ((i != 26) && (i != 72) && (i != 73))
            {
              paramActionSheetItem = "";
              break label72;
            }
          }
          else
          {
            paramActionSheetItem = "3";
            break label72;
          }
        }
        else
        {
          paramActionSheetItem = "2";
          break label72;
        }
      }
      else
      {
        paramActionSheetItem = "1";
        break label72;
      }
    }
    paramActionSheetItem = "0";
    label72:
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("imp_end", this.a, this.b);
    this.b.put("qqlive_share_channel", paramActionSheetItem);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b(this.a, false, null, "em_qqlive_share_panel", this.b);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("clck", this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.TgLiveShareUtil.1
 * JD-Core Version:    0.7.0.1
 */