package com.tencent.qcircle.weseevideo.editor.sticker.music;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qcircle.oscar.app.GlobalContext;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.FrameModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerConfigModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.effect.TAVStickerExKt;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.ttpic.baseutils.io.FileUtils;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/WSLyricSticker;", "Lcom/tencent/tavsticker/model/TAVSticker;", "()V", "mLyricAnimation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "mLyricWrapper", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/WSLyricSticker$LyricWrapper;", "computeLyricSentence", "", "presentationTimeMs", "", "computeProgress", "init", "loadLyricConfig", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerConfigModel;", "path", "", "reloadFromSubtitleModel", "", "model", "Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "updateLyricConfig", "effectId", "effectPath", "configPath", "updateMusicData", "musicData", "Lcom/tencent/qcircle/weseevideo/model/data/MusicMaterialMetaDataBean;", "updateMusicStartTime", "startTime", "", "updateStickerText", "text", "Companion", "LyricWrapper", "libtavcut_debug"}, k=1, mv={1, 1, 16})
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
    if (localObject1 != null) {
      localObject1 = ((WSLyricSticker.LyricWrapper)localObject1).getCurrentSentence(paramLong);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.mLyricWrapper;
    int i;
    if (localObject2 != null) {
      i = ((WSLyricSticker.LyricWrapper)localObject2).getStartTime();
    } else {
      i = 0;
    }
    paramLong += i;
    double d = 0.0D;
    if (localObject1 == null) {
      return 0.0D;
    }
    if ((((Sentence)localObject1).mStartTime <= paramLong) && (((Sentence)localObject1).mStartTime + ((Sentence)localObject1).mDuration >= paramLong))
    {
      localObject2 = ((Sentence)localObject1).mText;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "sentence.mText");
      updateStickerText((String)localObject2);
      localObject2 = this.mLyricAnimation;
      if (localObject2 != null)
      {
        long l = ((Sentence)localObject1).mStartTime;
        d = LyricPlayStrategy.INSTANCE.calculateProgress(paramLong - l, ((Sentence)localObject1).mDuration, (LyricPlayStrategy.LyricAnimation)localObject2);
      }
      return d;
    }
    localObject1 = ((Sentence)localObject1).mText;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "sentence.mText");
    updateStickerText((String)localObject1);
    return 0.0D;
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
        if (Intrinsics.areEqual(localTAVStickerTextItem.getLayerName(), "lyrics")) {
          break label66;
        }
      }
      localObject = null;
      label66:
      localObject = (TAVStickerTextItem)localObject;
      if (localObject != null) {}
    }
    else
    {
      localObject = getStickerTextItems();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "stickerTextItems");
      localObject = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)localObject);
    }
    if ((localObject != null) && ((Intrinsics.areEqual(((TAVStickerTextItem)localObject).getText(), paramString) ^ true)))
    {
      ((TAVStickerTextItem)localObject).setText(paramString);
      updateTextData();
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
    }
    catch (Exception localException)
    {
      Logger.e("WSLyricSticker", "reloadFromSubtitleModel: ", (Throwable)localException);
    }
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
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((WSLyricSticker.LyricWrapper)localObject1).getCurrentSentence(0L);
    } else {
      localObject1 = null;
    }
    Object localObject2 = getStickerTextItems();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "stickerTextItems");
    localObject2 = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)localObject2);
    if (localObject2 != null)
    {
      if (localObject1 != null) {
        str = ((Sentence)localObject1).mText;
      }
      ((TAVStickerTextItem)localObject2).setText(str);
    }
    localObject1 = getStickerTextItems();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "stickerTextItems");
    localObject1 = (TAVStickerTextItem)CollectionsKt.firstOrNull((List)localObject1);
    if (localObject1 != null) {
      ((TAVStickerTextItem)localObject1).setFontPath(paramSubtitleModel.getFontPath());
    }
  }
  
  public final void updateLyricConfig(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "effectId");
    Intrinsics.checkParameterIsNotNull(paramString2, "effectPath");
    Intrinsics.checkParameterIsNotNull(paramString3, "configPath");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateLyricConfig() called with: effectId = [");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], ");
    ((StringBuilder)localObject).append("effectPath = [");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("], configPath = [");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(']');
    Logger.i("WSLyricSticker", ((StringBuilder)localObject).toString());
    paramString3 = loadLyricConfig(paramString3);
    float f2 = 0.5F;
    if (paramString3 != null)
    {
      localObject = paramString3.getFrame();
      if (localObject != null)
      {
        f1 = ((FrameModel)localObject).getCenterX();
        break label146;
      }
    }
    float f1 = 0.5F;
    label146:
    setCenterX(f1);
    if (paramString3 != null)
    {
      localObject = paramString3.getFrame();
      if (localObject != null)
      {
        f1 = ((FrameModel)localObject).getCenterY();
        break label183;
      }
    }
    f1 = 0.5F;
    label183:
    setCenterY(f1);
    f1 = f2;
    if (paramString3 != null)
    {
      localObject = paramString3.getFrame();
      f1 = f2;
      if (localObject != null) {
        f1 = ((FrameModel)localObject).getScale();
      }
    }
    setScale(f1);
    try
    {
      init();
    }
    catch (Exception localException)
    {
      Logger.e("WSLyricSticker", "sticker initial failed, please check path && pagFile", (Throwable)localException);
    }
    TAVStickerExKt.setExtraStickerType(this, "sticker_lyric");
    long l1;
    if (paramString3 != null) {
      l1 = paramString3.getLoopStart();
    } else {
      l1 = 0L;
    }
    long l2;
    if (paramString3 != null) {
      l2 = paramString3.getLoopEnd();
    } else {
      l2 = 0L;
    }
    int j = 0;
    if (paramString3 != null) {
      i = paramString3.getLoopType();
    } else {
      i = 0;
    }
    this.mLyricAnimation = new LyricPlayStrategy.LyricAnimation(l1, l2, durationTime() / 1000, i).format();
    Bundle localBundle = getExtraBundle();
    if (paramString3 != null) {
      l1 = paramString3.getLoopStart();
    } else {
      l1 = 0L;
    }
    localBundle.putLong("extra_loop_start", l1);
    localBundle = getExtraBundle();
    if (paramString3 != null) {
      l1 = paramString3.getLoopEnd();
    } else {
      l1 = 0L;
    }
    localBundle.putLong("extra_loop_end", l1);
    localBundle = getExtraBundle();
    int i = j;
    if (paramString3 != null) {
      i = paramString3.getLoopType();
    }
    localBundle.putInt("extra_loop_type", i);
    getExtraBundle().putString("extra_lyric_effect_id", paramString1);
    getExtraBundle().putString("extra_lyric_effect_path", paramString2);
  }
  
  public final void updateMusicData(@Nullable MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    Object localObject2 = null;
    if ((paramMusicMaterialMetaDataBean != null) && (!TextUtils.isEmpty((CharSequence)paramMusicMaterialMetaDataBean.lyric))) {
      this.mLyricWrapper = new WSLyricSticker.LyricWrapper(Companion.parseLyric(paramMusicMaterialMetaDataBean), paramMusicMaterialMetaDataBean.startTime);
    } else {
      this.mLyricWrapper = ((WSLyricSticker.LyricWrapper)null);
    }
    if (paramMusicMaterialMetaDataBean != null)
    {
      localObject1 = paramMusicMaterialMetaDataBean.lyricFormat;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    boolean bool = StringsKt.equals((String)localObject1, "QRC", true);
    Object localObject1 = getExtraBundle();
    int i;
    if (paramMusicMaterialMetaDataBean != null) {
      i = paramMusicMaterialMetaDataBean.startTime;
    } else {
      i = 0;
    }
    ((Bundle)localObject1).putInt("extra_music_start", i);
    getExtraBundle().putBoolean("extra_lyric_format_is_qrc", bool);
    Bundle localBundle = getExtraBundle();
    localObject1 = localObject2;
    if (paramMusicMaterialMetaDataBean != null) {
      localObject1 = paramMusicMaterialMetaDataBean.lyric;
    }
    localBundle.putString("extra_lyric", (String)localObject1);
  }
  
  public final void updateMusicStartTime(int paramInt)
  {
    WSLyricSticker.LyricWrapper localLyricWrapper = this.mLyricWrapper;
    if (localLyricWrapper != null) {
      localLyricWrapper.setStartTime(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker
 * JD-Core Version:    0.7.0.1
 */