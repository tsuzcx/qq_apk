package com.tencent.tkd.topicsdk.debug;

import android.content.Context;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/debug/DebugViewController;", "", "context", "Landroid/content/Context;", "floatViewManager", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;)V", "debugView", "Lcom/tencent/tkd/topicsdk/debug/DebugView;", "addDebugView", "", "removeDebugView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DebugViewController
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private DebugView jdField_a_of_type_ComTencentTkdTopicsdkDebugDebugView;
  private final IFloatViewManager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager;
  
  public DebugViewController(@NotNull Context paramContext, @NotNull IFloatViewManager paramIFloatViewManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager = paramIFloatViewManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugViewController
 * JD-Core Version:    0.7.0.1
 */