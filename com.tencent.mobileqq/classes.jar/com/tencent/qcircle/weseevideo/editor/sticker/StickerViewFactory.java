package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;

public class StickerViewFactory
{
  public static WsStickerEditView createStickerEditView(Context paramContext, TAVSticker paramTAVSticker, StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    if ((paramTAVSticker != null) && (paramTAVSticker.getExtraBundle() != null))
    {
      if ("blur".equals(TAVStickerExKt.getExtraStickerType(paramTAVSticker))) {
        return new BlurStickerEditView(paramContext, paramTAVSticker, paramStickerEditViewIconConfig);
      }
      return new WsStickerEditView(paramContext, paramTAVSticker, paramStickerEditViewIconConfig);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerViewFactory
 * JD-Core Version:    0.7.0.1
 */