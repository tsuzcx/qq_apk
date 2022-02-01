package com.tencent.mobileqq.mini.entry.desktop.viewholder;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;

class ChessRoomModuleViewHolder$2
  implements View.OnClickListener
{
  ChessRoomModuleViewHolder$2(ChessRoomModuleViewHolder paramChessRoomModuleViewHolder, MiniAppInfo paramMiniAppInfo, INTERFACE.StUserAppInfo paramStUserAppInfo, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.this$0.jumpEnterChessRoom(this.val$miniAppInfo, this.val$chessTab.appInfo.tabIndex.get());
    ChessRoomModuleViewHolder.access$000(this.this$0, this.val$miniAppInfo, "click", this.val$reserves2, this.val$pos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.viewholder.ChessRoomModuleViewHolder.2
 * JD-Core Version:    0.7.0.1
 */