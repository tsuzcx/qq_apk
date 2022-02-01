package com.tencent.qapmsdk.base.listener;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/ListenerManager;", "", "()V", "anrConfigListener", "Lcom/tencent/qapmsdk/base/listener/IAnrConfigListener;", "dropFrameListener", "Lcom/tencent/qapmsdk/base/listener/IDropFrameListener;", "extraDataListener", "Lcom/tencent/qapmsdk/base/listener/IExtraDataListener;", "inspectorListener", "Lcom/tencent/qapmsdk/base/listener/IInspectorListener;", "looperListener", "Lcom/tencent/qapmsdk/base/listener/ILooperListener;", "memoryCellingListener", "Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;", "resourceListener", "Lcom/tencent/qapmsdk/base/listener/IResourceListener;", "webViewBreadCrumbListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qapmsdk/base/listener/IWebViewBreadCrumbListener;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ListenerManager
{
  public static final ListenerManager INSTANCE = new ListenerManager();
  @JvmField
  @Nullable
  public static IAnrConfigListener anrConfigListener;
  @JvmField
  @Nullable
  public static IDropFrameListener dropFrameListener;
  @JvmField
  @Nullable
  public static IExtraDataListener extraDataListener;
  @JvmField
  @Nullable
  public static IInspectorListener inspectorListener;
  @JvmField
  @Nullable
  public static ILooperListener looperListener;
  @JvmField
  @Nullable
  public static IMemoryCellingListener memoryCellingListener;
  @JvmField
  @Nullable
  public static IResourceListener resourceListener;
  @JvmField
  @Nullable
  public static WeakReference<IWebViewBreadCrumbListener> webViewBreadCrumbListener;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.ListenerManager
 * JD-Core Version:    0.7.0.1
 */