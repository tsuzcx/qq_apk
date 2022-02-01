package com.tencent.mobileqq.wink.editor;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.Size;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate;", "", "getContainerSize", "Lcom/tencent/videocut/model/Size;", "getDuration", "", "getEditDatas", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "getMediaModels", "", "Lcom/tencent/videocut/model/MediaModel;", "getPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "getRenderLayer", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "getRenderSize", "getSession", "Lcom/tencent/tavcut/session/ICutSession;", "getStickers", "", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "getTemplatePath", "init", "", "hostFragment", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "params", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate$WinkTavCutParams;", "isMediaChanged", "", "onHiddenChanged", "hidden", "release", "removeSticker", "stickerModel", "updateAudio", "audioModel", "Lcom/tencent/videocut/model/AudioModel;", "updateAudioVolume", "volume", "", "updateDuration", "durationUs", "updateFilter", "filterModel", "Lcom/tencent/videocut/model/FilterModel;", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "updateSticker", "updateVideoOriginalSoundVolume", "WinkTavCutParams", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WinkTavCutDelegate
{
  @Nullable
  public abstract IPlayer a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(long paramLong);
  
  public abstract void a(@NotNull BasePartFragment paramBasePartFragment, @NotNull WinkTavCutDelegate.WinkTavCutParams paramWinkTavCutParams);
  
  public abstract void a(@NotNull WinkStickerModel paramWinkStickerModel);
  
  public abstract void a(@Nullable AudioModel paramAudioModel);
  
  public abstract void a(@Nullable FilterModel paramFilterModel, @Nullable MetaMaterial paramMetaMaterial);
  
  public abstract void a(boolean paramBoolean);
  
  @Nullable
  public abstract ICutSession b();
  
  public abstract void b(float paramFloat);
  
  public abstract void b(@NotNull WinkStickerModel paramWinkStickerModel);
  
  public abstract void c();
  
  @NotNull
  public abstract List<MediaModel> d();
  
  public abstract long e();
  
  @Nullable
  public abstract Map<String, WinkStickerModel> f();
  
  @NotNull
  public abstract Size g();
  
  @NotNull
  public abstract Size h();
  
  @Nullable
  public abstract String i();
  
  @NotNull
  public abstract List<WinkEditData> j();
  
  public abstract boolean k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkTavCutDelegate
 * JD-Core Version:    0.7.0.1
 */