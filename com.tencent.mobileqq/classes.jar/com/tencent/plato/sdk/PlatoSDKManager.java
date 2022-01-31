package com.tencent.plato.sdk;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import com.tencent.plato.ModuleManager.Arr;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.module.StorageModule;
import com.tencent.plato.module.TimerModule;
import com.tencent.plato.module.ToolsModule;
import com.tencent.plato.sdk.dom.CanvasModule;
import com.tencent.plato.sdk.dom.DocumentModule;
import com.tencent.plato.sdk.element.IElement.IProvider;
import com.tencent.plato.sdk.element.PCanvasElement;
import com.tencent.plato.sdk.element.PCanvasElement.Provider;
import com.tencent.plato.sdk.element.PDivElement;
import com.tencent.plato.sdk.element.PDivElement.Provider;
import com.tencent.plato.sdk.element.PImgElement;
import com.tencent.plato.sdk.element.PImgElement.Provider;
import com.tencent.plato.sdk.element.PItemElement;
import com.tencent.plato.sdk.element.PItemElement.Provider;
import com.tencent.plato.sdk.element.PListElement;
import com.tencent.plato.sdk.element.PListElement.Provider;
import com.tencent.plato.sdk.element.PRefreshElement;
import com.tencent.plato.sdk.element.PRefreshElement.Provider;
import com.tencent.plato.sdk.element.PScrollElement;
import com.tencent.plato.sdk.element.PScrollElement.Provider;
import com.tencent.plato.sdk.element.PSwiperElement;
import com.tencent.plato.sdk.element.PSwiperElement.Provider;
import com.tencent.plato.sdk.element.PTextElement;
import com.tencent.plato.sdk.element.PTextElement.Provider;
import com.tencent.plato.sdk.element.PropertyImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PlatoSDKManager
{
  private static IImageLoader imageLoader;
  private static Map<String, IElement.IProvider> mElementProviders = new HashMap();
  
  public static void addElementProviders(List<IElement.IProvider> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IElement.IProvider localIProvider = (IElement.IProvider)paramList.next();
      mElementProviders.put(localIProvider.getName(), localIProvider);
    }
  }
  
  public static void addMoudes(List<IExportedModule> paramList)
  {
    ModuleManager.Arr.addModules(paramList);
  }
  
  public static Map<String, IElement.IProvider> getElementProviders()
  {
    return mElementProviders;
  }
  
  public static IImageLoader getImageLoader()
  {
    return imageLoader;
  }
  
  public static void init(Context paramContext)
  {
    SoLoader.init(paramContext, false);
    ModuleManager.Arr.addModules(Arrays.asList(new IExportedModule[] { new DocumentModule(), new CanvasModule(), new TimerModule(), new StorageModule(), new ToolsModule() }));
    addElementProviders(Arrays.asList(new IElement.IProvider[] { new PTextElement.Provider(), new PDivElement.Provider(), new PImgElement.Provider(), new PListElement.Provider(), new PItemElement.Provider(), new PScrollElement.Provider(), new PSwiperElement.Provider(), new PCanvasElement.Provider(), new PRefreshElement.Provider() }));
    PropertyImpl.init(PTextElement.class);
    PropertyImpl.init(PDivElement.class);
    PropertyImpl.init(PImgElement.class);
    PropertyImpl.init(PListElement.class);
    PropertyImpl.init(PItemElement.class);
    PropertyImpl.init(PScrollElement.class);
    PropertyImpl.init(PSwiperElement.class);
    PropertyImpl.init(PCanvasElement.class);
    PropertyImpl.init(PRefreshElement.class);
  }
  
  public static void setImageLoader(IImageLoader paramIImageLoader)
  {
    imageLoader = paramIImageLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.PlatoSDKManager
 * JD-Core Version:    0.7.0.1
 */