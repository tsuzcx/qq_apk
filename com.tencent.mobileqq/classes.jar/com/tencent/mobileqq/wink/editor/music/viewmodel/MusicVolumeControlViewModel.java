package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_bgmLiveData", "Landroidx/lifecycle/MediatorLiveData;", "", "_bgmSliderLiveData", "Landroidx/lifecycle/MutableLiveData;", "_curOperateBgmType", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "_originEnabledLiveData", "", "_originLiveData", "_originSliderLiveData", "bgmLiveData", "Landroidx/lifecycle/LiveData;", "getBgmLiveData", "()Landroidx/lifecycle/LiveData;", "curOperateBgmType", "getCurOperateBgmType", "isOriginalVolumeChangedManually", "()Z", "setOriginalVolumeChangedManually", "(Z)V", "originEnabledLiveData", "getOriginEnabledLiveData", "originLiveData", "getOriginLiveData", "changeVolume", "", "value", "sliderType", "deselectAllBgm", "getOperateBgmType", "setBgmEnabled", "enable", "setOriginEnabled", "setTemplateEnabled", "Companion", "VolumeType", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicVolumeControlViewModel
  extends ViewModel
{
  public static final MusicVolumeControlViewModel.Companion a = new MusicVolumeControlViewModel.Companion(null);
  private final MutableLiveData<MusicVolumeControlViewModel.VolumeType> b = new MutableLiveData(MusicVolumeControlViewModel.VolumeType.NONE);
  @NotNull
  private final LiveData<MusicVolumeControlViewModel.VolumeType> c;
  private final MediatorLiveData<Float> d;
  @NotNull
  private final LiveData<Float> e;
  private final MutableLiveData<Float> f;
  private final MutableLiveData<Boolean> g;
  @NotNull
  private final LiveData<Boolean> h;
  private final MediatorLiveData<Float> i;
  @NotNull
  private final LiveData<Float> j;
  private final MutableLiveData<Float> k;
  private boolean l;
  
  public MusicVolumeControlViewModel()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      this.c = ((LiveData)localObject);
      this.d = new MediatorLiveData();
      localObject = this.d;
      if (localObject != null)
      {
        this.e = ((LiveData)localObject);
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        localObject = this.g;
        if (localObject != null)
        {
          this.h = ((LiveData)localObject);
          this.i = new MediatorLiveData();
          localObject = this.i;
          if (localObject != null)
          {
            this.j = ((LiveData)localObject);
            this.k = new MutableLiveData();
            localObject = this.d;
            ((MediatorLiveData)localObject).addSource((LiveData)this.g, (Observer)new MusicVolumeControlViewModel..special..inlined.apply.lambda.1((MediatorLiveData)localObject, this));
            localObject = this.i;
            ((MediatorLiveData)localObject).addSource((LiveData)this.b, (Observer)new MusicVolumeControlViewModel..special..inlined.apply.lambda.2((MediatorLiveData)localObject, this));
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
      }
      throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType>");
  }
  
  @NotNull
  public final LiveData<MusicVolumeControlViewModel.VolumeType> a()
  {
    return this.c;
  }
  
  public final void a(float paramFloat, @NotNull MusicVolumeControlViewModel.VolumeType paramVolumeType)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeType, "sliderType");
    if (paramVolumeType == MusicVolumeControlViewModel.VolumeType.ORIGIN)
    {
      this.f.postValue(Float.valueOf(paramFloat));
      return;
    }
    this.k.postValue(Float.valueOf(paramFloat));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  @NotNull
  public final LiveData<Float> b()
  {
    return this.e;
  }
  
  public final void b(boolean paramBoolean)
  {
    if ((paramBoolean) && ((MusicVolumeControlViewModel.VolumeType)this.b.getValue() != MusicVolumeControlViewModel.VolumeType.BGM))
    {
      this.b.postValue(MusicVolumeControlViewModel.VolumeType.BGM);
      return;
    }
    if ((!paramBoolean) && ((MusicVolumeControlViewModel.VolumeType)this.b.getValue() != MusicVolumeControlViewModel.VolumeType.TEMPLATE)) {
      this.b.postValue(MusicVolumeControlViewModel.VolumeType.NONE);
    }
  }
  
  @NotNull
  public final LiveData<Boolean> c()
  {
    return this.h;
  }
  
  public final void c(boolean paramBoolean)
  {
    if ((paramBoolean) && ((MusicVolumeControlViewModel.VolumeType)this.b.getValue() != MusicVolumeControlViewModel.VolumeType.TEMPLATE)) {
      this.b.postValue(MusicVolumeControlViewModel.VolumeType.TEMPLATE);
    }
    if ((!paramBoolean) && ((MusicVolumeControlViewModel.VolumeType)this.b.getValue() == MusicVolumeControlViewModel.VolumeType.TEMPLATE)) {
      this.b.postValue(MusicVolumeControlViewModel.VolumeType.NONE);
    }
  }
  
  @NotNull
  public final LiveData<Float> d()
  {
    return this.j;
  }
  
  public final void d(boolean paramBoolean)
  {
    if ((Intrinsics.areEqual(Boolean.valueOf(paramBoolean), (Boolean)this.g.getValue()) ^ true)) {
      this.g.postValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  public final boolean e()
  {
    return this.l;
  }
  
  @NotNull
  public final MusicVolumeControlViewModel.VolumeType f()
  {
    MusicVolumeControlViewModel.VolumeType localVolumeType = (MusicVolumeControlViewModel.VolumeType)this.b.getValue();
    if (localVolumeType != null) {
      return localVolumeType;
    }
    return MusicVolumeControlViewModel.VolumeType.NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel
 * JD-Core Version:    0.7.0.1
 */