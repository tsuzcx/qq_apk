package com.tencent.weseevideo.camera.mvauto.redo;

import com.tencent.weseevideo.model.effect.VideoTransitionModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/camera/mvauto/redo/ResourceModel;", "", "selectUuid", "", "flashing", "", "data", "", "Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "backupData", "transitionData", "Ljava/util/ArrayList;", "Lcom/tencent/weseevideo/model/effect/VideoTransitionModel;", "transitionPosition", "", "smartCutType", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/ArrayList;II)V", "getBackupData", "()Ljava/util/List;", "getData", "getFlashing", "()Z", "getSelectUuid", "()Ljava/lang/String;", "getSmartCutType", "()I", "getTransitionData", "()Ljava/util/ArrayList;", "getTransitionPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "getAllVideoDuration", "", "getClipBackupData", "Lcom/tencent/weseevideo/model/resource/MediaClipModel;", "getMediaClipModel", "getSelectedClip", "hashCode", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class ResourceModel
{
  @Nullable
  private final List<CutModelKt> backupData;
  @NotNull
  private final List<CutModelKt> data;
  private final boolean flashing;
  @Nullable
  private final String selectUuid;
  private final int smartCutType;
  @NotNull
  private final ArrayList<VideoTransitionModel> transitionData;
  private final int transitionPosition;
  
  public ResourceModel()
  {
    this(null, false, null, null, null, 0, 0, 127, null);
  }
  
  public ResourceModel(@Nullable String paramString, boolean paramBoolean, @NotNull List<CutModelKt> paramList1, @Nullable List<CutModelKt> paramList2, @NotNull ArrayList<VideoTransitionModel> paramArrayList, int paramInt1, int paramInt2)
  {
    this.selectUuid = paramString;
    this.flashing = paramBoolean;
    this.data = paramList1;
    this.backupData = paramList2;
    this.transitionData = paramArrayList;
    this.transitionPosition = paramInt1;
    this.smartCutType = paramInt2;
  }
  
  @Nullable
  public final String component1()
  {
    return this.selectUuid;
  }
  
  public final boolean component2()
  {
    return this.flashing;
  }
  
  @NotNull
  public final List<CutModelKt> component3()
  {
    return this.data;
  }
  
  @Nullable
  public final List<CutModelKt> component4()
  {
    return this.backupData;
  }
  
  @NotNull
  public final ArrayList<VideoTransitionModel> component5()
  {
    return this.transitionData;
  }
  
  public final int component6()
  {
    return this.transitionPosition;
  }
  
  public final int component7()
  {
    return this.smartCutType;
  }
  
  @NotNull
  public final ResourceModel copy(@Nullable String paramString, boolean paramBoolean, @NotNull List<CutModelKt> paramList1, @Nullable List<CutModelKt> paramList2, @NotNull ArrayList<VideoTransitionModel> paramArrayList, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "data");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "transitionData");
    return new ResourceModel(paramString, paramBoolean, paramList1, paramList2, paramArrayList, paramInt1, paramInt2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ResourceModel))
      {
        paramObject = (ResourceModel)paramObject;
        if ((!Intrinsics.areEqual(this.selectUuid, paramObject.selectUuid)) || (this.flashing != paramObject.flashing) || (!Intrinsics.areEqual(this.data, paramObject.data)) || (!Intrinsics.areEqual(this.backupData, paramObject.backupData)) || (!Intrinsics.areEqual(this.transitionData, paramObject.transitionData)) || (this.transitionPosition != paramObject.transitionPosition) || (this.smartCutType != paramObject.smartCutType)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final long getAllVideoDuration()
  {
    Object localObject = (Iterable)this.data;
    long l = 0L;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      l = ((CutModelKt)((Iterator)localObject).next()).getResource().getScaleDuration() + l;
    }
    return l;
  }
  
  @Nullable
  public final List<CutModelKt> getBackupData()
  {
    return this.backupData;
  }
  
  @Nullable
  public final List<MediaClipModel> getClipBackupData()
  {
    Object localObject1 = this.backupData;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((CutModelKt)((Iterator)localObject2).next()).convert());
      }
      return (List)localObject1;
    }
    return null;
  }
  
  @NotNull
  public final List<CutModelKt> getData()
  {
    return this.data;
  }
  
  public final boolean getFlashing()
  {
    return this.flashing;
  }
  
  @NotNull
  public final List<MediaClipModel> getMediaClipModel()
  {
    Object localObject = (Iterable)this.data;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((CutModelKt)((Iterator)localObject).next()).convert());
    }
    return (List)localCollection;
  }
  
  @Nullable
  public final String getSelectUuid()
  {
    return this.selectUuid;
  }
  
  @Nullable
  public final CutModelKt getSelectedClip()
  {
    Iterator localIterator = ((Iterable)this.data).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Intrinsics.areEqual(((CutModelKt)localObject).getUuid(), this.selectUuid));
    for (;;)
    {
      return (CutModelKt)localObject;
      localObject = null;
    }
  }
  
  public final int getSmartCutType()
  {
    return this.smartCutType;
  }
  
  @NotNull
  public final ArrayList<VideoTransitionModel> getTransitionData()
  {
    return this.transitionData;
  }
  
  public final int getTransitionPosition()
  {
    return this.transitionPosition;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "ResourceModel(selectUuid=" + this.selectUuid + ", flashing=" + this.flashing + ", data=" + this.data + ", backupData=" + this.backupData + ", transitionData=" + this.transitionData + ", transitionPosition=" + this.transitionPosition + ", smartCutType=" + this.smartCutType + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.ResourceModel
 * JD-Core Version:    0.7.0.1
 */