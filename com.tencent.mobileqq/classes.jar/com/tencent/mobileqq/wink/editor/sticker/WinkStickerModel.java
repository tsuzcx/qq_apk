package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.RectF;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.utils.RectUtils;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.StickerModel.ActionType;
import com.tencent.videocut.model.StickerModel.CaptionInfo;
import com.tencent.videocut.model.StickerModel.Type;
import com.tencent.videocut.model.TextItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lcom/tencent/videocut/model/StickerModel;", "id", "", "filePath", "startTime", "", "duration", "layerIndex", "", "scale", "", "rotate", "centerX", "centerY", "editable", "", "width", "height", "minScale", "maxScale", "textItems", "", "Lcom/tencent/videocut/model/TextItem;", "thumbUrl", "timelineTrackIndex", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "type", "Lcom/tencent/videocut/model/StickerModel$Type;", "materialId", "captionInfo", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "localThumbId", "editingLayerIndex", "playEndDuration", "actionType", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "bgConfig", "bgPath", "configType", "unknownFields", "Lokio/ByteString;", "initStickerScale", "downScaleRecord", "originPointInView", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "sizeInView", "centerInView", "leftTopInView", "rightBottomInView", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "(Ljava/lang/String;Ljava/lang/String;JJIFFFFZIIFFLjava/util/List;Ljava/lang/String;ILcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/StickerModel$Type;Ljava/lang/String;Lcom/tencent/videocut/model/StickerModel$CaptionInfo;IIJLcom/tencent/videocut/model/StickerModel$ActionType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;FFLcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "getCenterInView", "()Lcom/tencent/mobileqq/wink/editor/model/PointF;", "getDownScaleRecord", "()F", "setDownScaleRecord", "(F)V", "getInitStickerScale", "lastDownRotate", "getLastDownRotate", "setLastDownRotate", "lastDownScale", "getLastDownScale", "setLastDownScale", "getLeftTopInView", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getOriginPointInView", "getRightBottomInView", "getSizeInView", "copyAndUpdate", "isClickInside", "eventX", "eventY", "updatePositionInView", "", "viewWidth", "viewHeight", "wrapperContainerHeight", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class WinkStickerModel
  extends StickerModel
{
  @NotNull
  private final PointF centerInView;
  private float downScaleRecord;
  private final float initStickerScale;
  private float lastDownRotate;
  private float lastDownScale;
  @NotNull
  private final PointF leftTopInView;
  @Nullable
  private final MetaMaterial material;
  @NotNull
  private final PointF originPointInView;
  @NotNull
  private final PointF rightBottomInView;
  @NotNull
  private final PointF sizeInView;
  
  public WinkStickerModel()
  {
    this(null, null, 0L, 0L, 0, 0.0F, 0.0F, 0.0F, 0.0F, false, 0, 0, 0.0F, 0.0F, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0F, 0.0F, null, null, null, null, null, null, -1, 31, null);
  }
  
  public WinkStickerModel(@NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, int paramInt2, int paramInt3, float paramFloat5, float paramFloat6, @NotNull List<TextItem> paramList, @NotNull String paramString3, int paramInt4, @NotNull AnimationMode paramAnimationMode, @NotNull StickerModel.Type paramType, @NotNull String paramString4, @Nullable StickerModel.CaptionInfo paramCaptionInfo, int paramInt5, int paramInt6, long paramLong3, @NotNull StickerModel.ActionType paramActionType, @NotNull List<String> paramList1, @NotNull String paramString5, @NotNull String paramString6, @NotNull ByteString paramByteString, float paramFloat7, float paramFloat8, @NotNull PointF paramPointF1, @NotNull PointF paramPointF2, @NotNull PointF paramPointF3, @NotNull PointF paramPointF4, @NotNull PointF paramPointF5, @Nullable MetaMaterial paramMetaMaterial)
  {
    super(paramString1, paramString2, paramLong1, paramLong2, paramInt1, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean, paramInt2, paramInt3, paramFloat5, paramFloat6, paramList, paramString3, paramInt4, paramAnimationMode, paramType, paramString4, paramCaptionInfo, paramInt5, paramInt6, paramLong3, paramActionType, paramList1, paramString5, paramString6, paramByteString);
    this.initStickerScale = paramFloat7;
    this.downScaleRecord = paramFloat8;
    this.originPointInView = paramPointF1;
    this.sizeInView = paramPointF2;
    this.centerInView = paramPointF3;
    this.leftTopInView = paramPointF4;
    this.rightBottomInView = paramPointF5;
    this.material = paramMetaMaterial;
  }
  
  @NotNull
  public final WinkStickerModel copyAndUpdate(@NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, int paramInt2, int paramInt3, float paramFloat5, float paramFloat6, @NotNull List<TextItem> paramList, @NotNull String paramString3, int paramInt4, @NotNull AnimationMode paramAnimationMode, @NotNull StickerModel.Type paramType, @NotNull String paramString4, @Nullable StickerModel.CaptionInfo paramCaptionInfo, int paramInt5, int paramInt6, long paramLong3, @NotNull StickerModel.ActionType paramActionType, @NotNull List<String> paramList1, @NotNull String paramString5, @NotNull String paramString6, @NotNull ByteString paramByteString, float paramFloat7, float paramFloat8, @NotNull PointF paramPointF1, @NotNull PointF paramPointF2, @NotNull PointF paramPointF3, @NotNull PointF paramPointF4, @NotNull PointF paramPointF5, @Nullable MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    Intrinsics.checkParameterIsNotNull(paramList, "textItems");
    Intrinsics.checkParameterIsNotNull(paramString3, "thumbUrl");
    Intrinsics.checkParameterIsNotNull(paramAnimationMode, "animationMode");
    Intrinsics.checkParameterIsNotNull(paramType, "type");
    Intrinsics.checkParameterIsNotNull(paramString4, "materialId");
    Intrinsics.checkParameterIsNotNull(paramActionType, "actionType");
    Intrinsics.checkParameterIsNotNull(paramList1, "bgConfig");
    Intrinsics.checkParameterIsNotNull(paramString5, "bgPath");
    Intrinsics.checkParameterIsNotNull(paramString6, "configType");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    Intrinsics.checkParameterIsNotNull(paramPointF1, "originPointInView");
    Intrinsics.checkParameterIsNotNull(paramPointF2, "sizeInView");
    Intrinsics.checkParameterIsNotNull(paramPointF3, "centerInView");
    Intrinsics.checkParameterIsNotNull(paramPointF4, "leftTopInView");
    Intrinsics.checkParameterIsNotNull(paramPointF5, "rightBottomInView");
    return new WinkStickerModel(paramString1, paramString2, paramLong1, paramLong2, paramInt1, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean, paramInt2, paramInt3, paramFloat5, paramFloat6, paramList, paramString3, paramInt4, paramAnimationMode, paramType, paramString4, paramCaptionInfo, paramInt5, paramInt6, paramLong3, paramActionType, paramList1, paramString5, paramString6, paramByteString, paramFloat7, paramFloat8, paramPointF1, paramPointF2, paramPointF3, paramPointF4, paramPointF5, paramMetaMaterial);
  }
  
  @NotNull
  public final PointF getCenterInView()
  {
    return this.centerInView;
  }
  
  public final float getDownScaleRecord()
  {
    return this.downScaleRecord;
  }
  
  public final float getInitStickerScale()
  {
    return this.initStickerScale;
  }
  
  public float getLastDownRotate()
  {
    return this.lastDownRotate;
  }
  
  public float getLastDownScale()
  {
    return this.lastDownScale;
  }
  
  @NotNull
  public final PointF getLeftTopInView()
  {
    return this.leftTopInView;
  }
  
  @Nullable
  public final MetaMaterial getMaterial()
  {
    return this.material;
  }
  
  @NotNull
  public final PointF getOriginPointInView()
  {
    return this.originPointInView;
  }
  
  @NotNull
  public final PointF getRightBottomInView()
  {
    return this.rightBottomInView;
  }
  
  @NotNull
  public final PointF getSizeInView()
  {
    return this.sizeInView;
  }
  
  public final boolean isClickInside(float paramFloat1, float paramFloat2)
  {
    return RectUtils.a.a(paramFloat1, paramFloat2, new RectF(this.leftTopInView.x, this.leftTopInView.y, this.rightBottomInView.x, this.rightBottomInView.y), -this.rotate);
  }
  
  public final void setDownScaleRecord(float paramFloat)
  {
    this.downScaleRecord = paramFloat;
  }
  
  public void setLastDownRotate(float paramFloat)
  {
    this.lastDownRotate = paramFloat;
  }
  
  public void setLastDownScale(float paramFloat)
  {
    this.lastDownScale = paramFloat;
  }
  
  public final void updatePositionInView(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return;
    }
    float f3 = paramInt2;
    float f2 = f3 * 1.0F / paramInt3;
    float f4 = 1;
    float f1 = f2;
    if (f2 > f4) {
      f1 = 1.0F;
    }
    f2 = this.width * f1 * (this.scale / this.initStickerScale);
    f1 = f1 * this.height * (this.scale / this.initStickerScale);
    PointF localPointF = this.sizeInView;
    localPointF.x = f2;
    localPointF.y = f1;
    localPointF = this.centerInView;
    float f5 = this.centerX;
    float f6 = 2;
    localPointF.x = ((f5 + f4) / f6 * paramInt1 + this.originPointInView.x);
    this.centerInView.y = ((-this.centerY + f4) / f6 * f3 + this.originPointInView.y);
    this.leftTopInView.x = (this.centerInView.x - f2 / f6);
    this.leftTopInView.y = (this.centerInView.y - f1 / f6);
    this.rightBottomInView.x = (this.leftTopInView.x + f2);
    this.rightBottomInView.y = (this.leftTopInView.y + f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel
 * JD-Core Version:    0.7.0.1
 */