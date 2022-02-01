package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.UUID;

class TroopFileBubbleModel$2
  implements DialogInterface.OnClickListener
{
  TroopFileBubbleModel$2(TroopFileBubbleModel paramTroopFileBubbleModel, long paramLong, UUID paramUUID, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      new TroopFileItemOperation(this.a, this.e.b, this.d).a(this.b);
      return;
    }
    paramDialogInterface = TroopFileManager.a(this.e.b, this.a);
    paramDialogInterface.b(paramDialogInterface.a(this.b));
    this.e.c(this.c);
    this.e.b.getMessageFacade().g(this.e.d.b, this.e.d.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.TroopFileBubbleModel.2
 * JD-Core Version:    0.7.0.1
 */