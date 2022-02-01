package com.tencent.weseevideo.model.effect;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/effect/StickerConfigModel;", "", "()V", "frame", "Lcom/tencent/weseevideo/model/effect/FrameModel;", "getFrame", "()Lcom/tencent/weseevideo/model/effect/FrameModel;", "id", "", "getId", "()Ljava/lang/String;", "limitArea", "Lcom/tencent/weseevideo/model/effect/StickerModel$LimitArea;", "Lcom/tencent/weseevideo/model/effect/StickerModel;", "getLimitArea", "()Lcom/tencent/weseevideo/model/effect/StickerModel$LimitArea;", "setLimitArea", "(Lcom/tencent/weseevideo/model/effect/StickerModel$LimitArea;)V", "loopEnd", "", "getLoopEnd", "()J", "loopStart", "getLoopStart", "loopType", "", "getLoopType", "()I", "minVersion", "getMinVersion", "type", "getType", "Companion", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public class StickerConfigModel
{
  public static final StickerConfigModel.Companion Companion = new StickerConfigModel.Companion(null);
  @SerializedName("frame")
  @Nullable
  private final FrameModel frame;
  @SerializedName("id")
  @NotNull
  private final String id = "";
  @SerializedName("limitArea")
  @Nullable
  private StickerModel.LimitArea limitArea;
  @SerializedName("loopEnd")
  private final long loopEnd;
  @SerializedName("loopStart")
  private final long loopStart;
  @SerializedName("loopType")
  private final int loopType;
  @SerializedName("minVersion")
  @NotNull
  private final String minVersion = "";
  @SerializedName("type")
  @NotNull
  private final String type = "";
  
  @Nullable
  public final FrameModel getFrame()
  {
    return this.frame;
  }
  
  @NotNull
  public final String getId()
  {
    return this.id;
  }
  
  @Nullable
  public final StickerModel.LimitArea getLimitArea()
  {
    return this.limitArea;
  }
  
  public final long getLoopEnd()
  {
    return this.loopEnd;
  }
  
  public final long getLoopStart()
  {
    return this.loopStart;
  }
  
  public final int getLoopType()
  {
    return this.loopType;
  }
  
  @NotNull
  public final String getMinVersion()
  {
    return this.minVersion;
  }
  
  @NotNull
  public final String getType()
  {
    return this.type;
  }
  
  public final void setLimitArea(@Nullable StickerModel.LimitArea paramLimitArea)
  {
    this.limitArea = paramLimitArea;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.StickerConfigModel
 * JD-Core Version:    0.7.0.1
 */