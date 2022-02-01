package com.tencent.viola.ui.action;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.ComponentFactory;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

public abstract class MethodAbsAdd
  implements DOMAction, RenderAction
{
  protected String mRootRef;
  
  public static VComponent generateComponentTree(DOMActionContext paramDOMActionContext, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    Object localObject2;
    Object localObject1;
    if ((paramDomObject != null) && (paramDOMActionContext != null) && (!paramDomObject.isLazy()))
    {
      if (ViolaSDKManager.getInstance().getRenderManager() == null) {
        return null;
      }
      localObject2 = paramDOMActionContext.getInstance();
      localObject1 = paramDOMActionContext.getComponent(paramDomObject.getRef());
    }
    try
    {
      paramVComponentContainer = ComponentFactory.newInstance((ViolaInstance)localObject2, paramDomObject, paramVComponentContainer);
      if (paramVComponentContainer == null) {
        return null;
      }
      paramDOMActionContext.registerComponent(paramDomObject.getRef(), paramVComponentContainer);
      paramDOMActionContext.registerDOMObject(paramDomObject.getRef(), paramDomObject);
      if ((paramVComponentContainer instanceof VComponentContainer))
      {
        localObject1 = (VComponentContainer)paramVComponentContainer;
        int j = paramDomObject.childrenCount();
        int i = 0;
        while (i < j)
        {
          localObject2 = paramDomObject.getChild(i);
          if (localObject2 != null)
          {
            localObject2 = generateComponentTree(paramDOMActionContext, (DomObject)localObject2, (VComponentContainer)localObject1);
            if (localObject2 != null) {
              ((VComponentContainer)localObject1).addChild((VComponent)localObject2);
            }
          }
          i += 1;
        }
      }
      return paramVComponentContainer;
      ViolaLogUtils.d("generateComponentTree", "dom.isLazy() ");
      return null;
    }
    catch (Exception paramVComponentContainer)
    {
      for (;;)
      {
        paramVComponentContainer = (VComponentContainer)localObject1;
      }
    }
  }
  
  protected DomObject addDomInternal(DOMActionContext paramDOMActionContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (paramDOMActionContext.isDestory()) {
      return null;
    }
    ViolaInstance localViolaInstance = paramDOMActionContext.getInstance();
    if (localViolaInstance == null) {
      return null;
    }
    localViolaInstance.mCreateDomStart = System.currentTimeMillis();
    paramJSONObject = DomObject.parse(paramJSONObject, localViolaInstance, null);
    if (paramJSONObject != null)
    {
      appendDomToTree(paramDOMActionContext, paramJSONObject);
      int i = paramJSONObject.traverseTree(new DomObject.Consumer[] { paramDOMActionContext.getAddDOMConsumer(), paramDOMActionContext.getApplyStyleConsumer() });
      localViolaInstance.mCreateDomEnd = System.currentTimeMillis();
      if (localViolaInstance.getMaxDomDeep() < i) {
        localViolaInstance.setMaxDomDeep(i);
      }
      localViolaInstance.mCreateComponentTreeStart = System.currentTimeMillis();
      createComponent(paramDOMActionContext, paramJSONObject);
      localViolaInstance.mCreateComponentTreeEnd = System.currentTimeMillis();
    }
    return paramJSONObject;
  }
  
  protected abstract void appendDomToTree(DOMActionContext paramDOMActionContext, DomObject paramDomObject);
  
  protected abstract VComponent createComponent(DOMActionContext paramDOMActionContext, DomObject paramDomObject);
  
  protected void traverseTree(DomObject paramDomObject) {}
  
  protected void traverseTreeAfterLayout(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    paramDomObject.layoutAfter();
    int j = paramDomObject.childrenCount();
    int i = 0;
    while (i < j)
    {
      traverseTreeAfterLayout(paramDomObject.getChild(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodAbsAdd
 * JD-Core Version:    0.7.0.1
 */