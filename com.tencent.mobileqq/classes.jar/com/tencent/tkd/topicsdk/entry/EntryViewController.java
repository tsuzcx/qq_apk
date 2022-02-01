package com.tencent.tkd.topicsdk.entry;

import android.content.Context;
import android.view.View;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/EntryViewController;", "", "context", "Landroid/content/Context;", "floatViewManager", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;)V", "entryViewMap", "Ljava/util/HashMap;", "", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "addEntryView", "", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "viewId", "hideEntryView", "removeEntryView", "reportEntryViewExposure", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "showEntryView", "updateEntryViewData", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EntryViewController
{
  public static final EntryViewController.Companion a;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final IFloatViewManager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager;
  private final HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkEntryEntryViewController$Companion = new EntryViewController.Companion(null);
  }
  
  public EntryViewController(@NotNull Context paramContext, @NotNull IFloatViewManager paramIFloatViewManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager = paramIFloatViewManager;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryViewController
 * JD-Core Version:    0.7.0.1
 */