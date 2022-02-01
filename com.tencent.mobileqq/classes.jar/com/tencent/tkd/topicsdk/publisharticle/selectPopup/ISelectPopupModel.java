package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/ISelectPopupModel;", "T", "", "getObjectFromInput", "", "wording", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "getObjectFromLocal", "(Ljava/lang/String;)Ljava/lang/Object;", "getPopupTitle", "context", "Landroid/content/Context;", "getTag", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface ISelectPopupModel<T>
{
  public abstract char a();
  
  public abstract T a(@NotNull String paramString);
  
  @NotNull
  public abstract String a(@NotNull Context paramContext, int paramInt);
  
  public abstract void a(@NotNull String paramString, @NotNull Function1<? super Integer, Unit> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.ISelectPopupModel
 * JD-Core Version:    0.7.0.1
 */