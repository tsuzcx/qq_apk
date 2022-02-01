package com.tencent.tkd.topicsdk.adapter.entryview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.controller.BaseEntryViewController;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/entryview/BizEntryViewController;", "Lcom/tencent/tkd/topicsdk/entry/controller/BaseEntryViewController;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "floatViewManager", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;)V", "getBizView", "Landroid/view/View;", "style", "", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class BizEntryViewController
  extends BaseEntryViewController
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final IEntryViewBridge jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge;
  
  public BizEntryViewController(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @NotNull IFloatViewManager paramIFloatViewManager)
  {
    super(paramContext, paramIEntryViewBridge, paramIFloatViewManager);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge = paramIEntryViewBridge;
  }
  
  @NotNull
  public View a(int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    return (View)new BizCircleEntryView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge, paramBundle1, paramBundle2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController
 * JD-Core Version:    0.7.0.1
 */