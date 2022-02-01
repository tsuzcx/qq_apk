package com.tencent.mobileqq.wink.editor.filter;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.editor.view.BorderView.Direction;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorFilterViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "_curFilterModelLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/tencent/videocut/model/FilterModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "_filterMaterialFromSwipeLiveData", "_filterMaterialLiveData", "<set-?>", "curFilterMaterial", "getCurFilterMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "curFilterModel", "curFilterModelLiveData", "Landroidx/lifecycle/LiveData;", "getCurFilterModelLiveData", "()Landroidx/lifecycle/LiveData;", "durationObserver", "Landroidx/lifecycle/Observer;", "", "durationUs", "getDurationUs", "()J", "setDurationUs", "(J)V", "filterMaterialFromSwipeLiveData", "getFilterMaterialFromSwipeLiveData", "filterMaterialLiveData", "getFilterMaterialLiveData", "filterMaterials", "", "swipeMaterialList", "Ljava/util/ArrayList;", "getLogTag", "isFilterMaterialReady", "", "material", "selectFilter", "", "setFilterMaterials", "swipeToSwitchFilter", "direction", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "updateFilterDuration", "updateFilterIntensity", "intensity", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorFilterViewModel
  extends BaseViewModel
{
  private final String a = getClass().getSimpleName();
  private final MutableLiveData<MetaMaterial> b = new MutableLiveData();
  @NotNull
  private final LiveData<MetaMaterial> c = (LiveData)this.b;
  private final MutableLiveData<MetaMaterial> d = new MutableLiveData();
  @NotNull
  private final LiveData<MetaMaterial> e = (LiveData)this.d;
  private final MutableLiveData<Pair<FilterModel, MetaMaterial>> f = new MutableLiveData();
  @NotNull
  private final LiveData<Pair<FilterModel, MetaMaterial>> g = (LiveData)this.f;
  @Nullable
  private MetaMaterial h;
  private long i;
  private FilterModel j;
  private List<MetaMaterial> k;
  private final ArrayList<MetaMaterial> l = new ArrayList();
  private final Observer<Long> m = (Observer)new WinkEditorFilterViewModel.durationObserver.1(this);
  
  private final void b(long paramLong)
  {
    FilterModel localFilterModel = this.j;
    if (localFilterModel != null)
    {
      if (localFilterModel.durationUs == paramLong) {
        return;
      }
      this.j = FilterModel.copy$default(localFilterModel, null, null, null, null, Long.valueOf(paramLong), null, null, 111, null);
      this.f.postValue(new Pair(localFilterModel, this.h));
    }
  }
  
  @NotNull
  public String a()
  {
    String str = this.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "TAG");
    return str;
  }
  
  public final void a(float paramFloat)
  {
    Object localObject = this.h;
    if (localObject != null) {
      FilterMetaMaterialKt.a((MetaMaterial)localObject, paramFloat);
    }
    localObject = this.j;
    if (localObject != null)
    {
      LutFilterModel localLutFilterModel = ((FilterModel)localObject).lut;
      if (localLutFilterModel != null)
      {
        this.j = FilterModel.copy$default((FilterModel)localObject, null, LutFilterModel.copy$default(localLutFilterModel, null, null, null, Float.valueOf(paramFloat), null, null, null, 119, null), null, null, null, null, null, 125, null);
        this.f.postValue(new Pair(localObject, this.h));
      }
    }
  }
  
  public final void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  public final void a(@Nullable MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null)
    {
      this.h = ((MetaMaterial)null);
      this.j = ((FilterModel)null);
      this.b.postValue(null);
      this.f.postValue(null);
      return;
    }
    this.h = paramMetaMaterial;
    Object localObject1 = MetaMaterialKt.b(paramMetaMaterial);
    Object localObject2 = paramMetaMaterial.id;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "material.id");
    String str = WinkEditorResourceManager.c().c(paramMetaMaterial);
    Intrinsics.checkExpressionValueIsNotNull(str, "WinkEditorResourceManage…ce().getLutPath(material)");
    paramMetaMaterial = new LutFilterModel((String)localObject1, (String)localObject2, str, FilterMetaMaterialKt.a(paramMetaMaterial), MetaMaterialKt.d(paramMetaMaterial), null, null, 96, null);
    localObject1 = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "UUID.randomUUID().toString()");
    this.j = new FilterModel((String)localObject1, paramMetaMaterial, null, 0L, this.i, null, null, 108, null);
    this.b.postValue(this.h);
    paramMetaMaterial = this.f;
    localObject1 = this.j;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = this.h;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    paramMetaMaterial.postValue(new Pair(localObject1, localObject2));
  }
  
  public final void a(@NotNull BorderView.Direction paramDirection)
  {
    Intrinsics.checkParameterIsNotNull(paramDirection, "direction");
    if (this.k == null) {
      return;
    }
    this.l.clear();
    if (this.h == null)
    {
      if (paramDirection == BorderView.Direction.Left)
      {
        paramDirection = this.l;
        localObject1 = this.k;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        paramDirection.addAll((Collection)localObject1);
      }
    }
    else
    {
      Object localObject2;
      if (paramDirection == BorderView.Direction.Right)
      {
        paramDirection = this.l;
        localObject1 = this.k;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = this.h;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramDirection.addAll((Collection)((List)localObject1).subList(0, MetaMaterialKt.a((MetaMaterial)localObject2)));
        CollectionsKt.reverse((List)this.l);
      }
      else
      {
        paramDirection = this.h;
        if (paramDirection == null) {
          Intrinsics.throwNpe();
        }
        int n = MetaMaterialKt.a(paramDirection) + 1;
        paramDirection = this.k;
        if (paramDirection == null) {
          Intrinsics.throwNpe();
        }
        if (n >= paramDirection.size() - 1) {
          return;
        }
        paramDirection = this.l;
        localObject1 = this.k;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = this.k;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramDirection.addAll((Collection)((List)localObject1).subList(n, ((List)localObject2).size()));
      }
    }
    Object localObject1 = ((Iterable)this.l).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramDirection = ((Iterator)localObject1).next();
      if (b((MetaMaterial)paramDirection)) {
        break label277;
      }
    }
    paramDirection = null;
    label277:
    paramDirection = (MetaMaterial)paramDirection;
    if (paramDirection != null) {
      this.d.postValue(paramDirection);
    }
  }
  
  public final void a(@NotNull List<MetaMaterial> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "filterMaterials");
    this.k = paramList;
  }
  
  @NotNull
  public final LiveData<MetaMaterial> b()
  {
    return this.c;
  }
  
  public final boolean b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "material");
    String str = WinkEditorResourceManager.c().d(paramMetaMaterial);
    return (ApplyMaterialTaskHelper.b(paramMetaMaterial)) && (!TextUtils.isEmpty((CharSequence)str)) && (new File(str).exists());
  }
  
  @NotNull
  public final LiveData<MetaMaterial> c()
  {
    return this.e;
  }
  
  @NotNull
  public final LiveData<Pair<FilterModel, MetaMaterial>> d()
  {
    return this.g;
  }
  
  @Nullable
  public final MetaMaterial e()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterViewModel
 * JD-Core Version:    0.7.0.1
 */