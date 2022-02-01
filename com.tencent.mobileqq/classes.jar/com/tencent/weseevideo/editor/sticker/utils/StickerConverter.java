package com.tencent.weseevideo.editor.sticker.utils;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.weseevideo.model.effect.SubtitleModel;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.utils.StickerConverter
 * JD-Core Version:    0.7.0.1
 */