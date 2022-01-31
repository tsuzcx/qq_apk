package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(19)
class DisplayListenerProxy
{
  private static final String TAG = "DisplayListenerProxy";
  private ArrayList<DisplayManager.DisplayListener> listenersBeforeWebView;
  
  private static ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners(DisplayManager paramDisplayManager)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new ArrayList();
    }
    try
    {
      localObject1 = DisplayManager.class.getDeclaredField("mGlobal");
      ((Field)localObject1).setAccessible(true);
      paramDisplayManager = ((Field)localObject1).get(paramDisplayManager);
      localObject1 = paramDisplayManager.getClass().getDeclaredField("mDisplayListeners");
      ((Field)localObject1).setAccessible(true);
      paramDisplayManager = (ArrayList)((Field)localObject1).get(paramDisplayManager);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramDisplayManager.iterator();
      for (paramDisplayManager = null; localIterator.hasNext(); paramDisplayManager = (DisplayManager)localObject1)
      {
        Object localObject2 = localIterator.next();
        localObject1 = paramDisplayManager;
        if (paramDisplayManager == null)
        {
          localObject1 = localObject2.getClass().getField("mListener");
          ((Field)localObject1).setAccessible(true);
        }
        localArrayList.add((DisplayManager.DisplayListener)((Field)localObject1).get(localObject2));
      }
      return localArrayList;
    }
    catch (NoSuchFieldException paramDisplayManager)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Could not extract WebView's display listeners. ");
      ((StringBuilder)localObject1).append(paramDisplayManager);
      Log.w("DisplayListenerProxy", ((StringBuilder)localObject1).toString());
      return new ArrayList();
    }
    catch (IllegalAccessException paramDisplayManager)
    {
      label135:
      break label135;
    }
  }
  
  void onPostWebViewInitialization(DisplayManager paramDisplayManager)
  {
    ArrayList localArrayList = yoinkDisplayListeners(paramDisplayManager);
    localArrayList.removeAll(this.listenersBeforeWebView);
    if (localArrayList.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramDisplayManager.unregisterDisplayListener((DisplayManager.DisplayListener)localIterator.next());
        paramDisplayManager.registerDisplayListener(new DisplayListenerProxy.1(this, localArrayList, paramDisplayManager), null);
      }
    }
  }
  
  void onPreWebViewInitialization(DisplayManager paramDisplayManager)
  {
    this.listenersBeforeWebView = yoinkDisplayListeners(paramDisplayManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.DisplayListenerProxy
 * JD-Core Version:    0.7.0.1
 */