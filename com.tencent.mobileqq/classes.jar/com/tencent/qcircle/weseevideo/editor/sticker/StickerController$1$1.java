package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class StickerController$1$1
  implements WsStickerEditView.OnStickerEditButtonClickListener
{
  StickerController$1$1(StickerController.1 param1, TAVStickerContext paramTAVStickerContext, String paramString) {}
  
  public void onAdjustTimeClick(@NotNull TAVSticker paramTAVSticker) {}
  
  public void onDeleteClick(@NotNull TAVSticker paramTAVSticker)
  {
    StickerController.access$200(this.this$1.this$0, this.val$stickerContext, paramTAVSticker);
    if (StickerController.access$300(this.this$1.this$0) != null) {
      StickerController.access$300(this.this$1.this$0).onDeleteButtonClick(paramTAVSticker.getStickerId());
    }
    if (("sticker_lyric".equals(this.val$extraType)) && (StickerController.access$400(this.this$1.this$0) != null)) {
      StickerController.access$400(this.this$1.this$0).onDeleteSticker();
    }
  }
  
  public void onEditClick(@NotNull TAVSticker paramTAVSticker, @Nullable List<TAVStickerLayerItem> paramList)
  {
    if ("sticker_lyric".equals(this.val$extraType)) {
      return;
    }
    if ((StickerController.access$300(this.this$1.this$0) != null) && (paramTAVSticker.getStickerTextItems() != null) && (!paramTAVSticker.getStickerTextItems().isEmpty())) {
      StickerController.access$300(this.this$1.this$0).onTextEditButtonClick(StickerUtil.stickerModel2EditorData(paramTAVSticker));
    }
  }
  
  public void onStickerClick(@NotNull TAVSticker paramTAVSticker)
  {
    if ("sticker_lyric".equals(this.val$extraType)) {
      return;
    }
    if ((StickerController.access$300(this.this$1.this$0) != null) && (paramTAVSticker.getStickerTextItems() != null)) {
      StickerController.access$300(this.this$1.this$0).onStickerClick(StickerUtil.stickerModel2EditorData(paramTAVSticker));
    }
  }
  
  public void onStickerSelected(TAVSticker paramTAVSticker)
  {
    if ("sticker_lyric".equals(this.val$extraType))
    {
      paramTAVSticker = StickerUtil.stickerModel2EditorData(paramTAVSticker);
      paramTAVSticker.setStickerType("sticker_lyric");
      StickerController.access$300(this.this$1.this$0).onStickerSelect(paramTAVSticker);
      return;
    }
    if (StickerController.access$300(this.this$1.this$0) != null) {
      StickerController.access$300(this.this$1.this$0).onStickerSelect(StickerUtil.stickerModel2EditorData(paramTAVSticker));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.1.1
 * JD-Core Version:    0.7.0.1
 */