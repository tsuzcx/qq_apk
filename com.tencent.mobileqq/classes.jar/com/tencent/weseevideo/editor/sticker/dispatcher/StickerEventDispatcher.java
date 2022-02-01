package com.tencent.weseevideo.editor.sticker.dispatcher;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class StickerEventDispatcher
{
  private static StickerEventDispatcher INSTANCE = new StickerEventDispatcher();
  private CopyOnWriteArrayList<IStickerEventListener> handlerList = new CopyOnWriteArrayList();
  
  public static StickerEventDispatcher getInstance()
  {
    return INSTANCE;
  }
  
  public void addStickerEventListener(IStickerEventListener paramIStickerEventListener)
  {
    if (!this.handlerList.contains(paramIStickerEventListener)) {
      this.handlerList.add(paramIStickerEventListener);
    }
  }
  
  public void onStickerDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Iterator localIterator = this.handlerList.iterator();
    while (localIterator.hasNext()) {
      ((IStickerEventListener)localIterator.next()).onStickerDataChanged(paramTAVSticker, paramTAVStickerOperationMode, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
  }
  
  public void onStickerStatusChanged(TAVSticker paramTAVSticker, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    Iterator localIterator = this.handlerList.iterator();
    while (localIterator.hasNext()) {
      ((IStickerEventListener)localIterator.next()).onStickerStatusChanged(paramTAVSticker, paramBoolean1.booleanValue(), paramBoolean2.booleanValue());
    }
  }
  
  public void removeStickerEventListener(IStickerEventListener paramIStickerEventListener)
  {
    this.handlerList.remove(paramIStickerEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher
 * JD-Core Version:    0.7.0.1
 */