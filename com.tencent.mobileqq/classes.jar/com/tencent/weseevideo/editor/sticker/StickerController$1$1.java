package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class StickerController$1$1
  implements WsStickerEditView.OnStickerEditButtonClickListener
{
  StickerController$1$1(StickerController.1 param1, TAVStickerContext paramTAVStickerContext) {}
  
  public void onAdjustTimeClick(@NotNull TAVSticker paramTAVSticker) {}
  
  public void onDeleteClick(@NotNull TAVSticker paramTAVSticker)
  {
    StickerController.access$200(this.this$1.this$0, this.val$stickerContext, paramTAVSticker);
    if (StickerController.access$300(this.this$1.this$0) != null) {
      StickerController.access$300(this.this$1.this$0).onDeleteButtonClick(paramTAVSticker.getStickerId());
    }
  }
  
  public void onEditClick(@NotNull TAVSticker paramTAVSticker, @Nullable List<TAVStickerLayerItem> paramList)
  {
    if ((StickerController.access$300(this.this$1.this$0) != null) && (paramTAVSticker.getStickerTextItems() != null) && (!paramTAVSticker.getStickerTextItems().isEmpty()))
    {
      paramList = (TAVStickerTextItem)paramTAVSticker.getStickerTextItems().get(0);
      StickerController.access$300(this.this$1.this$0).onTextEditButtonClick(new TextEditorData(paramTAVSticker.getStickerId(), paramList.getTextColor(), paramList.getText()));
    }
  }
  
  public void onStickerClick(@NotNull TAVSticker paramTAVSticker)
  {
    if ((StickerController.access$300(this.this$1.this$0) != null) && (paramTAVSticker.getStickerTextItems() != null) && (!paramTAVSticker.getStickerTextItems().isEmpty()))
    {
      TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)paramTAVSticker.getStickerTextItems().get(0);
      StickerController.access$300(this.this$1.this$0).onStickerClick(new TextEditorData(paramTAVSticker.getStickerId(), localTAVStickerTextItem.getTextColor(), localTAVStickerTextItem.getText()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.1.1
 * JD-Core Version:    0.7.0.1
 */