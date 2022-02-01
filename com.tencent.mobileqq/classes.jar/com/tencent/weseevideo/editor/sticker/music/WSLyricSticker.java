package com.tencent.weseevideo.editor.sticker.music;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.oscar.app.GlobalContext;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.weseevideo.common.utils.GsonUtils;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.FrameModel;
import com.tencent.weseevideo.model.effect.StickerConfigModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.effect.TAVStickerExKt;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/editor/sticker/music/WSLyricSticker;", "Lcom/tencent/tavsticker/model/TAVSticker;", "()V", "mLyricAnimation", "Lcom/tencent/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "mLyricWrapper", "Lcom/tencent/weseevideo/editor/sticker/music/WSLyricSticker$LyricWrapper;", "computeLyricSentence", "", "presentationTimeMs", "", "computeProgress", "init", "loadLyricConfig", "Lcom/tencent/weseevideo/model/effect/StickerConfigModel;", "path", "", "reloadFromSubtitleModel", "", "model", "Lcom/tencent/weseevideo/model/effect/SubtitleModel;", "updateLyricConfig", "effectId", "effectPath", "configPath", "updateMusicData", "musicData", "Lcom/tencent/weseevideo/model/data/MusicMaterialMetaDataBean;", "updateMusicStartTime", "startTime", "", "updateStickerText", "text", "Companion", "LyricWrapper", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSLyricSticker
  extends TAVSticker
{
  public static final WSLyricSticker.Companion Companion = new WSLyricSticker.Companion(null);
  private static final String EXTRA_LOOP_END = "extra_loop_end";
  private static final String EXTRA_LOOP_START = "extra_loop_start";
  private static final String EXTRA_LOOP_TYPE = "extra_loop_type";
  private static final String EXTRA_LYRIC = "extra_lyric";
  private static final String EXTRA_LYRIC_EFFECT_ID = "extra_lyric_effect_id";
  private static final String EXTRA_LYRIC_EFFECT_PATH = "extra_lyric_effect_path";
  private static final String EXTRA_LYRIC_FORMAT = "extra_lyric_format_is_qrc";
  private static final String EXTRA_MUSIC_START = "extra_music_start";
  @NotNull
  public static final String LAYER_NAME = "lyrics";
  private static final String TAG = "WSLyricSticker";
  private LyricPlayStrategy.LyricAnimation mLyricAnimation;
  private WSLyricSticker.LyricWrapper mLyricWrapper;
  
  public WSLyricSticker()
  {
    setAutoPlay(false);
  }
  
  private final double computeLyricSentence(long paramLong)
  {
    Object localObject1 = this.mLyricWrapper;
    if (localObject1 != null)
    {
      localObject1 = ((WSLyricSticker.LyricWrapper)localObject1).getCurrentSentence(paramLong);
      localObject2 = this.mLyricWrapper;
      if (localObject2 == null) {
        break label56;
      }
    }
    label56:
    for (int i = ((WSLyricSticker.LyricWrapper)localObject2).getStartTime();; i = 0)
    {
      paramLong = i + paramLong;
      if (localObject1 != null) {
        break label62;
      }
      return 0.0D;
      localObject1 = null;
      break;
    }
    label62:
    if ((((Sentence)localObject1).mStartTime > paramLong) || (((Sentence)localObject1).mStartTime + ((Sentence)localObject1).mDuration < paramLong))
    {
      localObject1 = ((Sentence)localObject1).mText;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "sentence.mText");
      updateStickerText((String)localObject1);
      return 0.0D;
    }
    Object localObject2 = ((Sentence)localObject1).mText;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "sentence.mText");
    updateStickerText((String)localObject2);
    localObject2 = this.mLyricAnimation;
    long l;
    if (localObject2 != null) {
      l = ((Sentence)localObject1).mStartTime;
    }
    for (double d = LyricPlayStrategy.INSTANCE.calculateProgress(paramLong - l, ((Sentence)localObject1).mDuration, (LyricPlayStrategy.LyricAnimation)localObject2);; d = 0.0D) {
      return d;
    }
  }
  
  @JvmStatic
  @NotNull
  public static final SubtitleModel dumpToSubtitleModel(@NotNull TAVSticker paramTAVSticker)
  {
    return Companion.dumpToSubtitleModel(paramTAVSticker);
  }
  
  private final StickerConfigModel loadLyricConfig(String paramString)
  {
    try
    {
      paramString = (StickerConfigModel)GsonUtils.json2Obj(FileUtils.load(GlobalContext.getContext(), paramString), (Type)StickerConfigModel.class);
      return paramString;
    }
    catch (Exception paramString)
    {
      Logger.e((Throwable)paramString);
    }
    return null;
  }
  
  private final void updateStickerText(String paramString)
  {
    Object localObject = getStickerTextItems();
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)localObject;
        Intrinsics.checkExpressionValueIsNotNull(localTAVStickerTextItem, "it");
        if (Intrinsics.areEqual(localTAVStickerTextItem.getLayerName(), "lyrics"))
        {
          localObject = (TAVStickerTextItem)localObject;
          if (localObject == null) {
            break label102;
          }
        }
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((Intrinsics.areEqual(((TAVStickerTextItem)localObject).getText(), paramString) ^ true)))
      {
        ((TAVStickerTextItem)localObject).setText(paramString);
        updateTextData();
      }
      return;
      localObject = null;
      break;
      label102:
      localObject = getStickerTextItems();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "stickerTextItems");
      localObject = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)localObject);
    }
  }
  
  public double computeProgress(long paramLong)
  {
    return computeLyricSentence(paramLong);
  }
  
  @NotNull
  public TAVSticker init()
  {
    TAVSticker localTAVSticker = super.init();
    Intrinsics.checkExpressionValueIsNotNull(localTAVSticker, "superResult");
    return localTAVSticker;
  }
  
  public final void reloadFromSubtitleModel(@NotNull SubtitleModel paramSubtitleModel)
  {
    String str = null;
    Intrinsics.checkParameterIsNotNull(paramSubtitleModel, "model");
    setFilePath(paramSubtitleModel.getFilePath());
    setAssetFilePath(paramSubtitleModel.getAssetFilePath());
    setCenterX(paramSubtitleModel.getCenterX());
    setCenterY(paramSubtitleModel.getCenterY());
    setScale(paramSubtitleModel.getScale());
    setLayerIndex(paramSubtitleModel.getLayerIndex());
    setRotate(paramSubtitleModel.getRotate());
    setMinScale(paramSubtitleModel.getMinScale());
    setMaxScale(paramSubtitleModel.getMaxScale());
    TAVStickerExKt.setExtraStickerType(this, "sticker_lyric");
    try
    {
      init();
      getExtraBundle().putLong("extra_loop_start", paramSubtitleModel.getLoopStart());
      getExtraBundle().putLong("extra_loop_end", paramSubtitleModel.getLoopEnd());
      getExtraBundle().putInt("extra_loop_type", paramSubtitleModel.getLoopType());
      getExtraBundle().putString("extra_lyric", paramSubtitleModel.getLyric());
      getExtraBundle().putInt("extra_music_start", paramSubtitleModel.getMusicStartTime());
      getExtraBundle().putBoolean("extra_lyric_format_is_qrc", paramSubtitleModel.getLyricFormatIsQRC());
      getExtraBundle().putString("extra_lyric_effect_id", paramSubtitleModel.getEffectId());
      getExtraBundle().putString("extra_lyric_effect_path", paramSubtitleModel.getEffectPath());
      long l1 = paramSubtitleModel.getLoopStart();
      long l2 = paramSubtitleModel.getLoopEnd();
      int i = paramSubtitleModel.getLoopType();
      this.mLyricAnimation = new LyricPlayStrategy.LyricAnimation(l1, l2, durationTime() / 1000, i).format();
      this.mLyricWrapper = new WSLyricSticker.LyricWrapper(LyricParseHelper.parseTextToLyric(paramSubtitleModel.getLyric(), paramSubtitleModel.getLyricFormatIsQRC()), paramSubtitleModel.getMusicStartTime());
      Object localObject1 = this.mLyricWrapper;
      if (localObject1 != null)
      {
        localObject1 = ((WSLyricSticker.LyricWrapper)localObject1).getCurrentSentence(0L);
        Object localObject3 = getStickerTextItems();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "stickerTextItems");
        localObject3 = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)localObject3);
        if (localObject3 != null)
        {
          if (localObject1 != null) {
            str = ((Sentence)localObject1).mText;
          }
          ((TAVStickerTextItem)localObject3).setText(str);
        }
        localObject1 = getStickerTextItems();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "stickerTextItems");
        localObject1 = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)localObject1);
        if (localObject1 != null) {
          ((TAVStickerTextItem)localObject1).setFontPath(paramSubtitleModel.getFontPath());
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("WSLyricSticker", "reloadFromSubtitleModel: ", (Throwable)localException);
        continue;
        Object localObject2 = null;
      }
    }
  }
  
  public final void updateLyricConfig(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "effectId");
    Intrinsics.checkParameterIsNotNull(paramString2, "effectPath");
    Intrinsics.checkParameterIsNotNull(paramString3, "configPath");
    Logger.i("WSLyricSticker", "updateLyricConfig() called with: effectId = [" + paramString1 + "], " + "effectPath = [" + paramString2 + "], configPath = [" + paramString3 + ']');
    paramString3 = loadLyricConfig(paramString3);
    Object localObject;
    float f;
    if (paramString3 != null)
    {
      localObject = paramString3.getFrame();
      if (localObject != null) {
        f = ((FrameModel)localObject).getCenterX();
      }
    }
    for (;;)
    {
      setCenterX(f);
      if (paramString3 != null)
      {
        localObject = paramString3.getFrame();
        if (localObject != null)
        {
          f = ((FrameModel)localObject).getCenterY();
          label134:
          setCenterY(f);
          if (paramString3 == null) {
            break label353;
          }
          localObject = paramString3.getFrame();
          if (localObject == null) {
            break label353;
          }
          f = ((FrameModel)localObject).getScale();
          setScale(f);
        }
      }
      try
      {
        init();
        TAVStickerExKt.setExtraStickerType(this, "sticker_lyric");
        if (paramString3 != null)
        {
          l1 = paramString3.getLoopStart();
          if (paramString3 == null) {
            break label385;
          }
          l2 = paramString3.getLoopEnd();
          if (paramString3 == null) {
            break label391;
          }
          i = paramString3.getLoopType();
          this.mLyricAnimation = new LyricPlayStrategy.LyricAnimation(l1, l2, durationTime() / 1000, i).format();
          localObject = getExtraBundle();
          if (paramString3 == null) {
            break label397;
          }
          l1 = paramString3.getLoopStart();
          ((Bundle)localObject).putLong("extra_loop_start", l1);
          localObject = getExtraBundle();
          if (paramString3 == null) {
            break label403;
          }
          l1 = paramString3.getLoopEnd();
          ((Bundle)localObject).putLong("extra_loop_end", l1);
          localObject = getExtraBundle();
          if (paramString3 == null) {
            break label409;
          }
          i = paramString3.getLoopType();
          ((Bundle)localObject).putInt("extra_loop_type", i);
          getExtraBundle().putString("extra_lyric_effect_id", paramString1);
          getExtraBundle().putString("extra_lyric_effect_path", paramString2);
          return;
          f = 0.5F;
          continue;
          f = 0.5F;
          break label134;
          label353:
          f = 0.5F;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e("WSLyricSticker", "sticker initial failed, please check path && pagFile", (Throwable)localException);
          continue;
          long l1 = 0L;
          continue;
          label385:
          long l2 = 0L;
          continue;
          label391:
          int i = 0;
          continue;
          label397:
          l1 = 0L;
          continue;
          label403:
          l1 = 0L;
          continue;
          label409:
          i = 0;
        }
      }
    }
  }
  
  public final void updateMusicData(@Nullable MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    Object localObject2 = null;
    Object localObject1;
    label43:
    boolean bool;
    if ((paramMusicMaterialMetaDataBean == null) || (TextUtils.isEmpty((CharSequence)paramMusicMaterialMetaDataBean.lyric)))
    {
      this.mLyricWrapper = ((WSLyricSticker.LyricWrapper)null);
      if (paramMusicMaterialMetaDataBean == null) {
        break label141;
      }
      localObject1 = paramMusicMaterialMetaDataBean.lyricFormat;
      if (localObject1 == null) {
        break label141;
      }
      bool = StringsKt.equals((String)localObject1, "QRC", true);
      localObject1 = getExtraBundle();
      if (paramMusicMaterialMetaDataBean == null) {
        break label149;
      }
    }
    label141:
    label149:
    for (int i = paramMusicMaterialMetaDataBean.startTime;; i = 0)
    {
      ((Bundle)localObject1).putInt("extra_music_start", i);
      getExtraBundle().putBoolean("extra_lyric_format_is_qrc", bool);
      Bundle localBundle = getExtraBundle();
      localObject1 = localObject2;
      if (paramMusicMaterialMetaDataBean != null) {
        localObject1 = paramMusicMaterialMetaDataBean.lyric;
      }
      localBundle.putString("extra_lyric", (String)localObject1);
      return;
      this.mLyricWrapper = new WSLyricSticker.LyricWrapper(Companion.parseLyric(paramMusicMaterialMetaDataBean), paramMusicMaterialMetaDataBean.startTime);
      break;
      localObject1 = "";
      break label43;
    }
  }
  
  public final void updateMusicStartTime(int paramInt)
  {
    WSLyricSticker.LyricWrapper localLyricWrapper = this.mLyricWrapper;
    if (localLyricWrapper != null) {
      localLyricWrapper.setStartTime(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.WSLyricSticker
 * JD-Core Version:    0.7.0.1
 */