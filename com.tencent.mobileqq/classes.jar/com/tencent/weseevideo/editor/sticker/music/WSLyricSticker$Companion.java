package com.tencent.weseevideo.editor.sticker.music;

import android.os.Bundle;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/editor/sticker/music/WSLyricSticker$Companion;", "", "()V", "EXTRA_LOOP_END", "", "EXTRA_LOOP_START", "EXTRA_LOOP_TYPE", "EXTRA_LYRIC", "EXTRA_LYRIC_EFFECT_ID", "EXTRA_LYRIC_EFFECT_PATH", "EXTRA_LYRIC_FORMAT", "EXTRA_MUSIC_START", "LAYER_NAME", "TAG", "dumpToSubtitleModel", "Lcom/tencent/weseevideo/model/effect/SubtitleModel;", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "parseLyric", "Lcom/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric;", "data", "Lcom/tencent/weseevideo/model/data/MusicMaterialMetaDataBean;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSLyricSticker$Companion
{
  @JvmStatic
  @NotNull
  public final SubtitleModel dumpToSubtitleModel(@NotNull TAVSticker paramTAVSticker)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "sticker");
    SubtitleModel localSubtitleModel = new SubtitleModel();
    localSubtitleModel.setAssetFilePath(paramTAVSticker.getAssetFilePath());
    localSubtitleModel.setFilePath(paramTAVSticker.getFilePath());
    localSubtitleModel.setCenterX(paramTAVSticker.getCenterX());
    localSubtitleModel.setCenterY(paramTAVSticker.getCenterY());
    localSubtitleModel.setScale(paramTAVSticker.getScale());
    localSubtitleModel.setLayerIndex(paramTAVSticker.getLayerIndex());
    localSubtitleModel.setRotate(paramTAVSticker.getRotate());
    localSubtitleModel.setWidth(paramTAVSticker.getWidth());
    localSubtitleModel.setHeight(paramTAVSticker.getHeight());
    localSubtitleModel.editable = paramTAVSticker.isEditable();
    localSubtitleModel.setMinScale(paramTAVSticker.getMinScale());
    localSubtitleModel.setMaxScale(paramTAVSticker.getMaxScale());
    String str = paramTAVSticker.getExtraBundle().getString("extra_lyric_effect_id");
    if (str != null)
    {
      localSubtitleModel.setEffectId(str);
      str = paramTAVSticker.getExtraBundle().getString("extra_lyric_effect_path");
      if (str == null) {
        break label282;
      }
      label143:
      localSubtitleModel.setEffectPath(str);
      str = paramTAVSticker.getExtraBundle().getString("extra_lyric");
      if (str == null) {
        break label288;
      }
    }
    for (;;)
    {
      localSubtitleModel.setLyric(str);
      localSubtitleModel.setLyricFormatIsQRC(paramTAVSticker.getExtraBundle().getBoolean("extra_lyric_format_is_qrc"));
      localSubtitleModel.setMusicStartTime(paramTAVSticker.getExtraBundle().getInt("extra_music_start"));
      localSubtitleModel.setLoopStart(paramTAVSticker.getExtraBundle().getLong("extra_loop_start"));
      localSubtitleModel.setLoopEnd(paramTAVSticker.getExtraBundle().getLong("extra_loop_end"));
      localSubtitleModel.setLoopType(paramTAVSticker.getExtraBundle().getInt("extra_loop_type"));
      paramTAVSticker = paramTAVSticker.getStickerTextItems();
      Intrinsics.checkExpressionValueIsNotNull(paramTAVSticker, "sticker.stickerTextItems");
      paramTAVSticker = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)paramTAVSticker);
      if (paramTAVSticker != null)
      {
        paramTAVSticker = paramTAVSticker.getFontPath();
        Intrinsics.checkExpressionValueIsNotNull(paramTAVSticker, "it.fontPath");
        localSubtitleModel.setFontPath(paramTAVSticker);
      }
      return localSubtitleModel;
      str = "";
      break;
      label282:
      str = "";
      break label143;
      label288:
      str = "";
    }
  }
  
  @Nullable
  public final Lyric parseLyric(@NotNull MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    Intrinsics.checkParameterIsNotNull(paramMusicMaterialMetaDataBean, "data");
    String str = paramMusicMaterialMetaDataBean.lyricFormat;
    if (str != null) {}
    for (;;)
    {
      boolean bool = StringsKt.equals(str, "QRC", true);
      return LyricParseHelper.parseTextToLyric(paramMusicMaterialMetaDataBean.lyric, bool);
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.WSLyricSticker.Companion
 * JD-Core Version:    0.7.0.1
 */