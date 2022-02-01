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
    Object localObject1;
    if ((paramDomObject == null) || (paramDOMActionContext == null) || (paramDomObject.isLazy()))
    {
      ViolaLogUtils.d("generateComponentTree", "dom.isLazy() ");
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      if (ViolaSDKManager.getInstance().getRenderManager() == null) {
        return null;
      }
      Object localObject2 = paramDOMActionContext.getInstance();
      localObject1 = paramDOMActionContext.getComponent(paramDomObject.getRef());
      try
      {
        paramVComponentContainer = ComponentFactory.newInstance((ViolaInstance)localObject2, paramDomObject, paramVComponentContainer);
        if (paramVComponentContainer == null) {
          return null;
        }
        paramDOMActionContext.registerComponent(paramDomObject.getRef(), paramVComponentContainer);
        paramDOMActionContext.registerDOMObject(paramDomObject.getRef(), paramDomObject);
        localObject1 = paramVComponentContainer;
        if (!(paramVComponentContainer instanceof VComponentContainer)) {
          continue;
        }
        localObject2 = (VComponentContainer)paramVComponentContainer;
        int j = paramDomObject.childrenCount();
        int i = 0;
        for (;;)
        {
          localObject1 = paramVComponentContainer;
          if (i >= j) {
            break;
          }
          localObject1 = paramDomObject.getChild(i);
          if (localObject1 != null)
          {
            localObject1 = generateComponentTree(paramDOMActionContext, (DomObject)localObject1, (VComponentContainer)localObject2);
            if (localObject1 != null) {
              ((VComponentContainer)localObject2).addChild((VComponent)localObject1);
            }
          }
          i += 1;
        }
      }
      catch (Exception paramVComponentContainer)
      {
        for (;;)
        {
          paramVComponentContainer = (VComponentContainer)localObject1;
        }
      }
    }
  }
  
  protected DomObject addDomInternal(DOMActionContext paramDOMActionContext, JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramJSONObject == null) {
      localObject1 = localObject2;
    }
    ViolaInstance localViolaInstance;
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (paramDOMActionContext.isDestory());
        localViolaInstance = paramDOMActionContext.getInstance();
        localObject1 = localObject2;
      } while (localViolaInstance == null);
      localViolaInstance.mCreateDomStart = System.currentTimeMillis();
      paramJSONObject = DomObject.parse(paramJSONObject, localViolaInstance, null);
      localObject1 = paramJSONObject;
    } while (paramJSONObject == null);
    appendDomToTree(paramDOMActionContext, paramJSONObject);
    int i = paramJSONObject.traverseTree(new DomObject.Consumer[] { paramDOMActionContext.getAddDOMConsumer(), paramDOMActionContext.getApplyStyleConsumer() });
    localViolaInstance.mCreateDomEnd = System.currentTimeMillis();
    if (localViolaInstance.getMaxDomDeep() < i) {
      localViolaInstance.setMaxDomDeep(i);
    }
    localViolaInstance.mCreateComponentTreeStart = System.currentTimeMillis();
    createComponent(paramDOMActionContext, paramJSONObject);
    localViolaInstance.mCreateComponentTreeEnd = System.currentTimeMillis();
    return paramJSONObject;
  }
  
  protected abstract void appendDomToTree(DOMActionContext paramDOMActionContext, DomObject paramDomObject);
  
  protected abstract VComponent createComponent(DOMActionContext paramDOMActionContext, DomObject paramDomObject);
  
  protected void traverseTree(DomObject paramDomObject) {}
  
  protected void traverseTreeAfterLayout(DomObject paramDomObject)
  {
    if (paramDomObject == null) {}
    for (;;)
    {
      return;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodAbsAdd
 * JD-Core Version:    0.7.0.1
 */