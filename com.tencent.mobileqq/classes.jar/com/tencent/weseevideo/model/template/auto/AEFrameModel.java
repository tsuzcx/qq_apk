package com.tencent.weseevideo.model.template.auto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/template/auto/AEFrameModel;", "", "()V", "frameColor", "", "getFrameColor", "()I", "setFrameColor", "(I)V", "frameColorLayerName", "", "getFrameColorLayerName", "()Ljava/lang/String;", "setFrameColorLayerName", "(Ljava/lang/String;)V", "id", "getId", "setId", "imageFillMode", "getImageFillMode", "setImageFillMode", "imageLayerName", "getImageLayerName", "setImageLayerName", "pagFillMode", "getPagFillMode", "setPagFillMode", "pagItems", "Ljava/util/ArrayList;", "Lcom/tencent/weseevideo/model/template/auto/AEFramePAGItem;", "getPagItems", "()Ljava/util/ArrayList;", "setPagItems", "(Ljava/util/ArrayList;)V", "selectedPAGName", "getSelectedPAGName", "setSelectedPAGName", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class AEFrameModel
{
  @SerializedName("frameColor")
  private int frameColor;
  @SerializedName("frameColorLayerName")
  @NotNull
  private String frameColorLayerName = "";
  @SerializedName("id")
  @NotNull
  private String id = "";
  @SerializedName("imageFillMode")
  private int imageFillMode;
  @SerializedName("imageLayerName")
  @NotNull
  private String imageLayerName = "";
  @SerializedName("pagFillMode")
  private int pagFillMode;
  @SerializedName("pagItem")
  @NotNull
  private ArrayList<AEFramePAGItem> pagItems = new ArrayList();
  @NotNull
  private transient String selectedPAGName = "";
  
  public final int getFrameColor()
  {
    return this.frameColor;
  }
  
  @NotNull
  public final String getFrameColorLayerName()
  {
    return this.frameColorLayerName;
  }
  
  @NotNull
  public final String getId()
  {
    return this.id;
  }
  
  public final int getImageFillMode()
  {
    return this.imageFillMode;
  }
  
  @NotNull
  public final String getImageLayerName()
  {
    return this.imageLayerName;
  }
  
  public final int getPagFillMode()
  {
    return this.pagFillMode;
  }
  
  @NotNull
  public final ArrayList<AEFramePAGItem> getPagItems()
  {
    return this.pagItems;
  }
  
  @NotNull
  public final String getSelectedPAGName()
  {
    return this.selectedPAGName;
  }
  
  public final void setFrameColor(int paramInt)
  {
    this.frameColor = paramInt;
  }
  
  public final void setFrameColorLayerName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.frameColorLayerName = paramString;
  }
  
  public final void setId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.id = paramString;
  }
  
  public final void setImageFillMode(int paramInt)
  {
    this.imageFillMode = paramInt;
  }
  
  public final void setImageLayerName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.imageLayerName = paramString;
  }
  
  public final void setPagFillMode(int paramInt)
  {
    this.pagFillMode = paramInt;
  }
  
  public final void setPagItems(@NotNull ArrayList<AEFramePAGItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.pagItems = paramArrayList;
  }
  
  public final void setSelectedPAGName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.selectedPAGName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AEFrameModel
 * JD-Core Version:    0.7.0.1
 */