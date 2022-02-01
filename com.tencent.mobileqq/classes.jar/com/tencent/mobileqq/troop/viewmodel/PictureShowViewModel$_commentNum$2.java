package com.tencent.mobileqq.troop.viewmodel;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k=3, mv={1, 1, 16})
final class PictureShowViewModel$_commentNum$2
  extends Lambda
  implements Function0<MutableLiveData<String>>
{
  PictureShowViewModel$_commentNum$2(PictureShowViewModel paramPictureShowViewModel)
  {
    super(0);
  }
  
  @NotNull
  public final MutableLiveData<String> invoke()
  {
    MutableLiveData localMutableLiveData = new MutableLiveData();
    localMutableLiveData.setValue(PictureShowViewModel.a(this.this$0).c());
    return localMutableLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel._commentNum.2
 * JD-Core Version:    0.7.0.1
 */