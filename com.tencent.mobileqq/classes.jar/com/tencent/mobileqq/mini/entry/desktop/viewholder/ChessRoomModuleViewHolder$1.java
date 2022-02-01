package com.tencent.mobileqq.mini.entry.desktop.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class ChessRoomModuleViewHolder$1
  implements View.OnClickListener
{
  ChessRoomModuleViewHolder$1(ChessRoomModuleViewHolder paramChessRoomModuleViewHolder) {}
  
  public void onClick(View paramView)
  {
    paramView = this.this$0;
    paramView.jumpEnterChessRoom(paramView.mMoreAppInfo, this.this$0.mChessEntranceTabIndex);
    MiniProgramLpReportDC04239.reportAsync("desktop", "chess_center", "click", "more");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.viewholder.ChessRoomModuleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */