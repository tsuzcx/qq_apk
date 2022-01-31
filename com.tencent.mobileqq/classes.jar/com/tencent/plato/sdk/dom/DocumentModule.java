package com.tencent.plato.sdk.dom;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.IPlatoManager.IRenderListener;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.annotation.Exported;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.core.utils.TimeMonitorUtils;
import com.tencent.plato.core.utils.Tracker;
import com.tencent.plato.sdk.PlatoSDKManager;
import org.json.JSONException;
import org.json.JSONObject;

public class DocumentModule
  extends ExportedModule
{
  private static final String TAG = "DocumentModule";
  private static boolean isFinish = false;
  private boolean isDirty = false;
  private final SparseArray<IDom> mDomMap = new SparseArray();
  
  public DocumentModule()
  {
    super("document");
  }
  
  @Exported("addElement")
  public void addElement(IPlatoRuntime paramIPlatoRuntime, int paramInt1, int paramInt2, IReadableMap paramIReadableMap, int paramInt3)
  {
    if (paramIReadableMap == null) {
      PLog.e("DocumentModule", "addElement error. element null");
    }
    IDom localIDom;
    do
    {
      return;
      this.isDirty = true;
      if (isFinish)
      {
        isFinish = false;
        TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
      }
      localIDom = getDom(paramInt1);
    } while (localIDom == null);
    localIDom.addElement(paramIPlatoRuntime, paramIReadableMap, paramInt2, paramInt3);
  }
  
  @Exported("addElementById")
  public void addElementById(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.addElementById(paramInt2, paramInt3, paramInt4);
    }
  }
  
  @Exported("addEvent")
  public void addEvent(int paramInt1, int paramInt2, String paramString)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.addEvent(paramInt2, paramString);
    }
  }
  
  @Exported("addKeyframe")
  public void addKeyframe(int paramInt, String paramString)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt);
    if (localIDom != null) {}
    try
    {
      addKeyframeMap(paramInt, new JSONWritableMap(new JSONObject(paramString)));
      return;
    }
    catch (JSONException localJSONException)
    {
      localIDom.addKeyFrame(paramString);
    }
  }
  
  @Exported("addKeyframeMap")
  public void addKeyframeMap(int paramInt, IReadableMap paramIReadableMap)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt);
    if (localIDom != null) {
      localIDom.addKeyFrame(paramIReadableMap);
    }
  }
  
  public void beforeRender(IPlatoRuntime paramIPlatoRuntime, int paramInt, Handler paramHandler, IPlatoManager.IRenderListener paramIRenderListener)
  {
    paramIPlatoRuntime = new Dom(paramIPlatoRuntime, paramInt, PlatoSDKManager.getElementProviders(), paramHandler, paramIRenderListener);
    this.mDomMap.put(paramInt, paramIPlatoRuntime);
  }
  
  public void bindSurface(int paramInt, IPlatoSurface paramIPlatoSurface)
  {
    IDom localIDom = getDom(paramInt);
    if (localIDom != null) {
      localIDom.bindSurface(paramIPlatoSurface);
    }
  }
  
  @Exported("createBody")
  public void createBody(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    if (paramIReadableMap == null) {
      PLog.e("DocumentModule", "createBody error. element null");
    }
    IDom localIDom;
    do
    {
      return;
      this.isDirty = true;
      if (isFinish)
      {
        isFinish = false;
        TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
      }
      localIDom = getDom(paramInt);
    } while (localIDom == null);
    localIDom.createBody(paramIPlatoRuntime, paramIReadableMap);
  }
  
  @Exported("createElement")
  public void createElement(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    if (paramIReadableMap == null) {
      PLog.e("DocumentModule", "createElement error. element null");
    }
    IDom localIDom;
    do
    {
      return;
      this.isDirty = true;
      if (isFinish)
      {
        isFinish = false;
        TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
      }
      localIDom = getDom(paramInt);
    } while (localIDom == null);
    localIDom.createElement(paramIPlatoRuntime, paramIReadableMap);
  }
  
  @Exported("createFinish")
  public void createFinish(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    Tracker.trace("KeyTime", "====----------------------------- createDom start");
    IDom localIDom = getDom(paramInt);
    if (localIDom != null)
    {
      localIDom.createBody(paramIPlatoRuntime, paramIReadableMap);
      localIDom.updateFinish();
    }
    isFinish = true;
    TimeMonitorUtils.getInstance().saveStepTime("js_end", System.currentTimeMillis());
    TimeMonitorUtils.getInstance().clearMonitorName();
    Tracker.trace("KeyTime", "====----------------------------- createDom end");
  }
  
  public IDom getDom(int paramInt)
  {
    return (IDom)this.mDomMap.get(paramInt);
  }
  
  @Exported("moveElement")
  public void moveElement(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.moveElement(paramInt2, paramInt3, paramInt4);
    }
  }
  
  @Exported("removeAttr")
  public void removeAttr(int paramInt1, int paramInt2, String paramString)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.removeAttr(paramInt2, paramString);
    }
  }
  
  @Exported("removeElement")
  public void removeElement(int paramInt1, int paramInt2)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.removeElement(paramInt2);
    }
  }
  
  @Exported("removeEvent")
  public void removeEvent(int paramInt1, int paramInt2, String paramString)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.removeEvent(paramInt2, paramString);
    }
  }
  
  @Exported("scrollTo")
  public void scrollTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    PLog.i("DocumentModule", "doc -- scrollTo docId : " + paramInt1 + "; refid : " + paramInt2 + "; x : " + paramInt3 + "; y : " + paramInt4 + "; ani : " + paramBoolean);
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.scrollTo(paramInt2, paramInt3, paramInt4, paramBoolean);
    }
  }
  
  @Exported("setAttr")
  public void setAttr(IPlatoRuntime paramIPlatoRuntime, int paramInt1, int paramInt2, IReadableMap paramIReadableMap)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.setAttr(paramIPlatoRuntime, paramInt2, paramIReadableMap);
    }
  }
  
  @Exported("setStyles")
  public void setStyles(IPlatoRuntime paramIPlatoRuntime, int paramInt1, int paramInt2, IReadableMap paramIReadableMap)
  {
    this.isDirty = true;
    if (isFinish)
    {
      isFinish = false;
      TimeMonitorUtils.getInstance().saveStepTime("js_start", System.currentTimeMillis());
    }
    IDom localIDom = getDom(paramInt1);
    if (localIDom != null) {
      localIDom.setStyles(paramIPlatoRuntime, paramInt2, paramIReadableMap);
    }
  }
  
  public void unmountPage(int paramInt)
  {
    IDom localIDom = (IDom)this.mDomMap.get(paramInt);
    if (localIDom != null)
    {
      this.mDomMap.remove(paramInt);
      localIDom.destroy();
    }
  }
  
  @Exported("updateFinish")
  public void updateFinish(int paramInt)
  {
    if (!this.isDirty)
    {
      PLog.e("DocumentModule", "updateFinish, nothing change, return");
      TimeMonitorUtils.getInstance().clearStepTime();
      return;
    }
    isFinish = true;
    TimeMonitorUtils.getInstance().saveStepTime("js_end", System.currentTimeMillis());
    IDom localIDom = getDom(paramInt);
    if (localIDom != null) {
      localIDom.updateFinish();
    }
    TimeMonitorUtils.getInstance().clearMonitorName();
    this.isDirty = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.dom.DocumentModule
 * JD-Core Version:    0.7.0.1
 */