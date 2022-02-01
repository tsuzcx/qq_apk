package com.tencent.viola.ui.diff;

import com.tencent.viola.ui.action.MethodAbsAdd;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VPageSlider;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DomDiffUtils
{
  public static final String TAG = "DomDiffUtils";
  
  private static List<VComponent> createComponentAndView(List<DomObject> paramList, DOMActionContext paramDOMActionContext, VComponentContainer paramVComponentContainer)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VComponent localVComponent = MethodAbsAdd.generateComponentTree(paramDOMActionContext, (DomObject)paramList.next(), paramVComponentContainer);
      if (localVComponent != null)
      {
        localArrayList.add(localVComponent);
        if (localVComponent.getHostView() == null) {
          localVComponent.createView();
        }
      }
    }
    return localArrayList;
  }
  
  private static void dfsWalk(VComponent paramVComponent, DomObject paramDomObject1, DomObject paramDomObject2, List<Patch> paramList, DOMActionContext paramDOMActionContext, boolean paramBoolean)
  {
    if ((paramVComponent != null) && (paramDomObject1 != null) && (paramDomObject2 != null))
    {
      if ((paramDomObject1.getType().equals(paramDomObject2.getType())) && (!isIgnoreChildren(paramDomObject2)) && (paramVComponent.isReuse()))
      {
        if ((paramVComponent instanceof VComponentContainer))
        {
          VComponentContainer localVComponentContainer = (VComponentContainer)paramVComponent;
          Object localObject;
          if (localVComponentContainer.getChildCount() != paramDomObject1.getDomChildCount())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("componentSize != domSize, cSize: ");
            ((StringBuilder)localObject).append(localVComponentContainer.getChildCount());
            ((StringBuilder)localObject).append(", dSize: ");
            ((StringBuilder)localObject).append(paramDomObject1.getDomChildCount());
            ((StringBuilder)localObject).append("newDomSize:");
            ((StringBuilder)localObject).append(paramDomObject2.getDomChildCount());
            ViolaLogUtils.d("DomDiffUtils", ((StringBuilder)localObject).toString());
          }
          if ((!(localVComponentContainer instanceof VRecyclerList)) && (!(localVComponentContainer instanceof VPageSlider)))
          {
            int j = 0;
            int k;
            for (int i = 0;; i = k)
            {
              k = i;
              if (j >= localVComponentContainer.getChildCount()) {
                break;
              }
              localObject = localVComponentContainer.getChild(j);
              if (localObject == null) {
                return;
              }
              if (i < paramDomObject2.getDomChildCount())
              {
                DomObject localDomObject = paramDomObject2.getChild(i);
                dfsWalk((VComponent)localObject, ((VComponent)localObject).mDomObj, localDomObject, paramList, paramDOMActionContext, paramBoolean);
                k = i + 1;
              }
              else
              {
                paramList.add(new PatchDelete(localVComponentContainer, (VComponent)localObject));
                k = i;
                if (!(paramVComponent instanceof VRecyclerList))
                {
                  k = i;
                  if (!paramBoolean)
                  {
                    unregisterComponent((VComponent)localObject, paramDOMActionContext);
                    k = i;
                  }
                }
              }
              j += 1;
            }
            while (k < paramDomObject2.getDomChildCount())
            {
              paramList.add(new PatchCreate(paramDomObject2.getChild(k), localVComponentContainer));
              k += 1;
            }
          }
        }
        diffEvent(paramVComponent, paramDomObject2);
        diffAttr(paramVComponent, paramDomObject2);
        diffStyles(paramVComponent, paramDomObject2);
        paramVComponent.resetComponent();
        paramVComponent.resetComponent(paramDomObject2);
        paramVComponent.tryCompatVR(paramDomObject2);
        if ((paramVComponent instanceof VPageSlider))
        {
          reusePagerSlider(paramDomObject2, (VPageSlider)paramVComponent, paramDOMActionContext);
          ViolaLogUtils.d("DomDiffUtils", "reuse VPageSlider");
        }
        else if ((paramVComponent instanceof VRecyclerList))
        {
          ((VRecyclerList)paramVComponent).setNeedNotify(true);
          ViolaLogUtils.d("DomDiffUtils", "reuse recyclerList");
        }
        if (paramDOMActionContext != null)
        {
          paramDOMActionContext.registerComponent(paramDomObject2.getRef(), paramVComponent);
          paramDOMActionContext.registerDOMObject(paramDomObject2.getRef(), paramDomObject2);
          if (!paramBoolean) {
            paramDOMActionContext.unregisterComponent(paramDomObject1.getRef());
          }
        }
      }
      else
      {
        paramList.add(new PatchReplace(paramDomObject2, paramVComponent));
        if ((!(paramVComponent instanceof VRecyclerList)) && (!paramBoolean)) {
          unregisterComponent(paramVComponent, paramDOMActionContext);
        }
      }
      return;
    }
    ViolaLogUtils.d("DomDiffUtils", "dfsWalk: invalid param");
  }
  
  public static void diff(VComponent paramVComponent, DomObject paramDomObject1, DomObject paramDomObject2, DOMActionContext paramDOMActionContext, DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    dfsWalk(paramVComponent, paramDomObject1, paramDomObject2, localArrayList, paramDOMActionContext, paramBoolean);
    paramVComponent = localArrayList.iterator();
    while (paramVComponent.hasNext()) {
      ((Patch)paramVComponent.next()).applyPatch(paramOnComponentDiffListener, paramDOMActionContext);
    }
  }
  
  private static void diffAttr(VComponent paramVComponent, DomObject paramDomObject)
  {
    if ((paramVComponent != null) && (paramDomObject != null))
    {
      if (paramVComponent.mDomObj == null) {
        return;
      }
      paramDomObject = diffRemove(paramVComponent.mDomObj.getAttributes(), paramDomObject.getAttributes());
      if (!paramDomObject.isEmpty()) {
        paramVComponent.resetAttrs(paramDomObject);
      }
    }
  }
  
  public static void diffComponent(VComponent paramVComponent, DomObject paramDomObject, DOMActionContext paramDOMActionContext, DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, boolean paramBoolean)
  {
    if ((paramVComponent != null) && (paramVComponent.mDomObj != null))
    {
      diffComponent(paramVComponent, paramVComponent.mDomObj, paramDomObject, paramDOMActionContext, paramOnComponentDiffListener, paramBoolean);
      return;
    }
    ViolaLogUtils.d("DomDiffUtils", "component or its dom is null");
  }
  
  public static void diffComponent(VComponent paramVComponent, DomObject paramDomObject1, DomObject paramDomObject2, DOMActionContext paramDOMActionContext, DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, boolean paramBoolean)
  {
    diff(paramVComponent, paramDomObject1, paramDomObject2, paramDOMActionContext, paramOnComponentDiffListener, paramBoolean);
  }
  
  private static void diffEvent(VComponent paramVComponent, DomObject paramDomObject)
  {
    if ((paramVComponent != null) && (paramVComponent.mDomObj != null))
    {
      if (paramDomObject == null) {
        return;
      }
      Object localObject = paramVComponent.mDomObj.getEvents();
      paramDomObject = paramDomObject.getEvents();
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramDomObject.contains(str)) {
          localArrayList.add(str);
        }
      }
      if (!localArrayList.isEmpty()) {
        paramVComponent.resetEvents(localArrayList);
      }
    }
  }
  
  private static List<String> diffRemove(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if ((paramMap1 != null) && (paramMap2 != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        if (!paramMap2.containsKey(localEntry.getKey())) {
          localArrayList.add((String)localEntry.getKey());
        }
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  private static void diffStyles(VComponent paramVComponent, DomObject paramDomObject)
  {
    if ((paramVComponent != null) && (paramDomObject != null))
    {
      if (paramVComponent.mDomObj == null) {
        return;
      }
      paramDomObject = diffRemove(paramVComponent.mDomObj.getStyle(), paramDomObject.getStyle());
      if (!paramDomObject.isEmpty()) {
        paramVComponent.resetStyles(paramDomObject);
      }
    }
  }
  
  private static boolean isIgnoreChildren(DomObject paramDomObject)
  {
    return false;
  }
  
  private static void reusePagerSlider(DomObject paramDomObject, VPageSlider paramVPageSlider, DOMActionContext paramDOMActionContext)
  {
    if (paramVPageSlider != null)
    {
      if (paramDomObject == null) {
        return;
      }
      unregisterComponent(paramVPageSlider, paramDOMActionContext);
      paramVPageSlider.mDomObj = paramDomObject;
      paramDomObject = createComponentAndView(paramVPageSlider.mDomObj.mDomChildren, paramDOMActionContext, paramVPageSlider);
      if (paramDomObject != null)
      {
        paramVPageSlider.mChildren.clear();
        paramVPageSlider.mChildren.addAll(paramDomObject);
        paramVPageSlider.notifyChange();
        paramDomObject = paramVPageSlider.mDomObj.getState("index");
        if ((paramDomObject instanceof Integer))
        {
          int i = ((Integer)paramDomObject).intValue();
          if (i <= paramVPageSlider.mDomObj.mDomChildren.size() - 1) {
            paramVPageSlider.setStartIndex(Boolean.valueOf(false), i);
          }
        }
        else
        {
          paramVPageSlider.setStartIndex(Boolean.valueOf(false), 0);
        }
      }
    }
  }
  
  public static void unregisterComponent(VComponent paramVComponent, DOMActionContext paramDOMActionContext)
  {
    if (paramVComponent != null)
    {
      if (paramDOMActionContext == null) {
        return;
      }
      paramDOMActionContext.unregisterComponent(paramVComponent.getRef());
      if ((paramVComponent instanceof VComponentContainer))
      {
        paramVComponent = (VComponentContainer)paramVComponent;
        int j = paramVComponent.getChildCount();
        int i = 0;
        while (i < j)
        {
          unregisterComponent(paramVComponent.getChild(i), paramDOMActionContext);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.diff.DomDiffUtils
 * JD-Core Version:    0.7.0.1
 */