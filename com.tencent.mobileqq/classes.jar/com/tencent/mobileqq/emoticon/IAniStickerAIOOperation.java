package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.HashMap;

public abstract interface IAniStickerAIOOperation
{
  public abstract int aniStickerType();
  
  public abstract void getCustomMenuItem(QQCustomMenu paramQQCustomMenu, MessageForAniSticker paramMessageForAniSticker);
  
  public abstract HashMap<Integer, Bundle> getDefaultMenuItem(MessageForAniSticker paramMessageForAniSticker);
  
  public abstract void onClick(View paramView, MessageForAniSticker paramMessageForAniSticker);
  
  public abstract boolean onMenuItemClicked(int paramInt, Context paramContext, MessageForAniSticker paramMessageForAniSticker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.IAniStickerAIOOperation
 * JD-Core Version:    0.7.0.1
 */