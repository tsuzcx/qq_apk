package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.Dimensions;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationFrameModule;
import com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule;
import com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule;
import com.tencent.mtt.hippy.modules.nativemodules.clipboard.ClipboardModule;
import com.tencent.mtt.hippy.modules.nativemodules.console.ConsoleModule;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule;
import com.tencent.mtt.hippy.modules.nativemodules.exception.ExceptionModule;
import com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule;
import com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule;
import com.tencent.mtt.hippy.modules.nativemodules.network.NetworkModule;
import com.tencent.mtt.hippy.modules.nativemodules.network.WebSocketModule;
import com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule;
import com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule;
import com.tencent.mtt.hippy.modules.nativemodules.uimanager.UIManagerModule;
import com.tencent.mtt.hippy.modules.nativemodules.utils.UtilsModule;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.views.audioview.AudioViewController;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;
import com.tencent.mtt.hippy.views.list.HippyListItemViewController;
import com.tencent.mtt.hippy.views.list.HippyListViewController;
import com.tencent.mtt.hippy.views.modal.HippyModalHostManager;
import com.tencent.mtt.hippy.views.navigator.NavigatorController;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterViewController;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController;
import com.tencent.mtt.hippy.views.refresh.RefreshWrapperController;
import com.tencent.mtt.hippy.views.refresh.RefreshWrapperItemController;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewController;
import com.tencent.mtt.hippy.views.text.HippyTextViewController;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerItemController;
import com.tencent.mtt.hippy.views.webview.HippyWebViewController;
import com.tencent.mtt.tkd.views.audio.TkdAudioViewController;
import com.tencent.mtt.tkd.views.image.TkdImageViewController;
import com.tencent.mtt.tkd.views.list.TkdListItemViewController;
import com.tencent.mtt.tkd.views.list.TkdListViewController;
import com.tencent.mtt.tkd.views.modal.TkdModalHostManager;
import com.tencent.mtt.tkd.views.refresh.TkdPullFooterViewController;
import com.tencent.mtt.tkd.views.refresh.TkdPullHeaderViewController;
import com.tencent.mtt.tkd.views.scroll.TkdScrollViewController;
import com.tencent.mtt.tkd.views.text.TkdTextViewController;
import com.tencent.mtt.tkd.views.textinput.TkdTextInputController;
import com.tencent.mtt.tkd.views.view.TkdViewGroupController;
import com.tencent.mtt.tkd.views.viewpager.TkdViewPagerController;
import com.tencent.mtt.tkd.views.viewpager.TkdViewPagerItemController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HippyTextViewController.class);
    localArrayList.add(HippyViewGroupController.class);
    localArrayList.add(HippyImageViewController.class);
    localArrayList.add(HippyListViewController.class);
    localArrayList.add(HippyListItemViewController.class);
    localArrayList.add(HippyTextInputController.class);
    localArrayList.add(HippyScrollViewController.class);
    localArrayList.add(HippyViewPagerController.class);
    localArrayList.add(HippyViewPagerItemController.class);
    localArrayList.add(HippyModalHostManager.class);
    localArrayList.add(RefreshWrapperController.class);
    localArrayList.add(RefreshWrapperItemController.class);
    localArrayList.add(HippyPullHeaderViewController.class);
    localArrayList.add(HippyPullFooterViewController.class);
    localArrayList.add(NavigatorController.class);
    localArrayList.add(HippyWebViewController.class);
    localArrayList.add(AudioViewController.class);
    localArrayList.add(TkdScrollViewController.class);
    localArrayList.add(TkdListItemViewController.class);
    localArrayList.add(TkdListViewController.class);
    localArrayList.add(TkdAudioViewController.class);
    localArrayList.add(TkdImageViewController.class);
    localArrayList.add(TkdModalHostManager.class);
    localArrayList.add(TkdPullFooterViewController.class);
    localArrayList.add(TkdPullHeaderViewController.class);
    localArrayList.add(TkdTextViewController.class);
    localArrayList.add(TkdTextInputController.class);
    localArrayList.add(TkdViewGroupController.class);
    localArrayList.add(TkdViewPagerController.class);
    localArrayList.add(TkdViewPagerItemController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(EventDispatcher.class);
    localArrayList.add(Dimensions.class);
    return localArrayList;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(TimerModule.class, new d.1(this, paramHippyEngineContext));
    localHashMap.put(ConsoleModule.class, new d.8(this, paramHippyEngineContext));
    localHashMap.put(ExceptionModule.class, new d.9(this, paramHippyEngineContext));
    localHashMap.put(UIManagerModule.class, new d.10(this, paramHippyEngineContext));
    localHashMap.put(AnimationModule.class, new d.11(this, paramHippyEngineContext));
    localHashMap.put(StorageModule.class, new d.12(this, paramHippyEngineContext));
    localHashMap.put(NetInfoModule.class, new d.13(this, paramHippyEngineContext));
    localHashMap.put(AnimationFrameModule.class, new d.14(this, paramHippyEngineContext));
    localHashMap.put(ImageLoaderModule.class, new d.15(this, paramHippyEngineContext));
    localHashMap.put(NetworkModule.class, new d.2(this, paramHippyEngineContext));
    localHashMap.put(DeviceEventModule.class, new d.3(this, paramHippyEngineContext));
    localHashMap.put(WebSocketModule.class, new d.4(this, paramHippyEngineContext));
    localHashMap.put(UtilsModule.class, new d.5(this, paramHippyEngineContext));
    localHashMap.put(ClipboardModule.class, new d.6(this, paramHippyEngineContext));
    localHashMap.put(AudioPlayerModule.class, new d.7(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.d
 * JD-Core Version:    0.7.0.1
 */