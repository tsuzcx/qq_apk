package com.tencent.qcircle.weseevideo.editor.sticker.utils;

import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tavsticker.model.TAVSticker;

public class StickerConverter
{
  public static TAVSticker subtitleModel2TavSticker(SubtitleModel paramSubtitleModel)
  {
    if (paramSubtitleModel == null) {
      return null;
    }
    if (paramSubtitleModel.getEffectId() == "no_lyric_id") {
      return null;
    }
    WSLyricSticker localWSLyricSticker = new WSLyricSticker();
    ((WSLyricSticker)localWSLyricSticker).reloadFromSubtitleModel(paramSubtitleModel);
    return localWSLyricSticker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.utils.StickerConverter
 * JD-Core Version:    0.7.0.1
 */