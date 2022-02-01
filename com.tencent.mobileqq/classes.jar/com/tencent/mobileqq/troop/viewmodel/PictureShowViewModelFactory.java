package com.tencent.mobileqq.troop.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/viewmodel/PictureShowViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "data", "Lcom/tencent/mobileqq/troop/viewmodel/SocialBottomBarData;", "pictureShowActionNotifier", "Lcom/tencent/mobileqq/troop/viewmodel/IPictureShowActionNotifier;", "(Lcom/tencent/mobileqq/troop/viewmodel/SocialBottomBarData;Lcom/tencent/mobileqq/troop/viewmodel/IPictureShowActionNotifier;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PictureShowViewModelFactory
  implements ViewModelProvider.Factory
{
  private final SocialBottomBarData a;
  private final IPictureShowActionNotifier b;
  
  public PictureShowViewModelFactory(@NotNull SocialBottomBarData paramSocialBottomBarData, @NotNull IPictureShowActionNotifier paramIPictureShowActionNotifier)
  {
    this.a = paramSocialBottomBarData;
    this.b = paramIPictureShowActionNotifier;
  }
  
  @NotNull
  public <T extends ViewModel> T create(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "modelClass");
    return (ViewModel)new PictureShowViewModel(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.PictureShowViewModelFactory
 * JD-Core Version:    0.7.0.1
 */