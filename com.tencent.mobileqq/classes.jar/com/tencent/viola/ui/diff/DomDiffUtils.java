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
    if ((paramVComponent == null) || (paramDomObject1 == null) || (paramDomObject2 == null)) {
      ViolaLogUtils.d("DomDiffUtils", "dfsWalk: invalid param");
    }
    label422:
    do
    {
      for (;;)
      {
        return;
        if ((!paramDomObject1.getType().equals(paramDomObject2.getType())) || (isIgnoreChildren(paramDomObject2)) || (!paramVComponent.isReuse())) {
          break;
        }
        if ((paramVComponent instanceof VComponentContainer))
        {
          VComponentContainer localVComponentContainer = (VComponentContainer)paramVComponent;
          if (localVComponentContainer.getChildCount() != paramDomObject1.getDomChildCount()) {
            ViolaLogUtils.d("DomDiffUtils", "componentSize != domSize, cSize: " + localVComponentContainer.getChildCount() + ", dSize: " + paramDomObject1.getDomChildCount() + "newDomSize:" + paramDomObject2.getDomChildCount());
          }
          if ((!(localVComponentContainer instanceof VRecyclerList)) && (!(localVComponentContainer instanceof VPageSlider)))
          {
            int i = 0;
            int j = 0;
            int k = i;
            if (j < localVComponentContainer.getChildCount())
            {
              VComponent localVComponent = localVComponentContainer.getChild(j);
              if (localVComponent == null) {
                continue;
              }
              if (i < paramDomObject2.getDomChildCount())
              {
                DomObject localDomObject = paramDomObject2.getChild(i);
                dfsWalk(localVComponent, localVComponent.mDomObj, localDomObject, paramList, paramDOMActionContext, paramBoolean);
                i += 1;
              }
              for (;;)
              {
                j += 1;
                break;
                paramList.add(new PatchDelete(localVComponentContainer, localVComponent));
                if ((!(paramVComponent instanceof VRecyclerList)) && (!paramBoolean)) {
                  unregisterComponent(localVComponent, paramDOMActionContext);
                }
              }
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
        paramVComponent.tryCompatVR(paramDomObject2);
        if ((paramVComponent instanceof VPageSlider))
        {
          reusePagerSlider(paramDomObject2, (VPageSlider)paramVComponent, paramDOMActionContext);
          ViolaLogUtils.d("DomDiffUtils", "reuse VPageSlider");
        }
        for (;;)
        {
          if (paramDOMActionContext == null) {
            break label422;
          }
          paramDOMActionContext.registerComponent(paramDomObject2.getRef(), paramVComponent);
          paramDOMActionContext.registerDOMObject(paramDomObject2.getRef(), paramDomObject2);
          if (paramBoolean) {
            break;
          }
          paramDOMActionContext.unregisterComponent(paramDomObject1.getRef());
          return;
          if ((paramVComponent instanceof VRecyclerList))
          {
            ((VRecyclerList)paramVComponent).setNeedNotify(true);
            ViolaLogUtils.d("DomDiffUtils", "reuse recyclerList");
          }
        }
      }
      paramList.add(new PatchReplace(paramDomObject2, paramVComponent));
    } while (((paramVComponent instanceof VRecyclerList)) || (paramBoolean));
    unregisterComponent(paramVComponent, paramDOMActionContext);
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
    if ((paramVComponent == null) || (paramDomObject == null) || (paramVComponent.mDomObj == null)) {}
    do
    {
      return;
      paramDomObject = diffRemove(paramVComponent.mDomObj.getAttributes(), paramDomObject.getAttributes());
    } while (paramDomObject.isEmpty());
    paramVComponent.resetAttrs(paramDomObject);
  }
  
  public static void diffComponent(VComponent paramVComponent, DomObject paramDomObject, DOMActionContext paramDOMActionContext, DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, boolean paramBoolean)
  {
    if ((paramVComponent == null) || (paramVComponent.mDomObj == null))
    {
      ViolaLogUtils.d("DomDiffUtils", "component or its dom is null");
      return;
    }
    diffComponent(paramVComponent, paramVComponent.mDomObj, paramDomObject, paramDOMActionContext, paramOnComponentDiffListener, paramBoolean);
  }
  
  public static void diffComponent(VComponent paramVComponent, DomObject paramDomObject1, DomObject paramDomObject2, DOMActionContext paramDOMActionContext, DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, boolean paramBoolean)
  {
    diff(paramVComponent, paramDomObject1, paramDomObject2, paramDOMActionContext, paramOnComponentDiffListener, paramBoolean);
  }
  
  private static void diffEvent(VComponent paramVComponent, DomObject paramDomObject)
  {
    if ((paramVComponent == null) || (paramVComponent.mDomObj == null) || (paramDomObject == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      Object localObject = paramVComponent.mDomObj.getEvents();
      paramDomObject = paramDomObject.getEvents();
      localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramDomObject.contains(str)) {
          localArrayList.add(str);
        }
      }
    } while (localArrayList.isEmpty());
    paramVComponent.resetEvents(localArrayList);
  }
  
  private static List<String> diffRemove(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if ((paramMap1 == null) || (paramMap2 == null)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      if (!paramMap2.containsKey(localEntry.getKey())) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  private static void diffStyles(VComponent paramVComponent, DomObject paramDomObject)
  {
    if ((paramVComponent == null) || (paramDomObject == null) || (paramVComponent.mDomObj == null)) {}
    do
    {
      return;
      paramDomObject = diffRemove(paramVComponent.mDomObj.getStyle(), paramDomObject.getStyle());
    } while (paramDomObject.isEmpty());
    paramVComponent.resetStyles(paramDomObject);
  }
  
  private static boolean isIgnoreChildren(DomObject paramDomObject)
  {
    return false;
  }
  
  private static void reusePagerSlider(DomObject paramDomObject, VPageSlider paramVPageSlider, DOMActionContext paramDOMActionContext)
  {
    if ((paramVPageSlider == null) || (paramDomObject == null)) {}
    int i;
    do
    {
      do
      {
        return;
        unregisterComponent(paramVPageSlider, paramDOMActionContext);
        paramVPageSlider.mDomObj = paramDomObject;
        paramDomObject = createComponentAndView(paramVPageSlider.mDomObj.mDomChildren, paramDOMActionContext, paramVPageSlider);
      } while (paramDomObject == null);
      paramVPageSlider.mChildren.clear();
      paramVPageSlider.mChildren.addAll(paramDomObject);
      paramVPageSlider.notifyChange();
      paramDomObject = paramVPageSlider.mDomObj.getState("index");
      if (!(paramDomObject instanceof Integer)) {
        break;
      }
      i = ((Integer)paramDomObject).intValue();
    } while (i > paramVPageSlider.mDomObj.mDomChildren.size() - 1);
    paramVPageSlider.setStartIndex(Boolean.valueOf(false), i);
    return;
    paramVPageSlider.setStartIndex(Boolean.valueOf(false), 0);
  }
  
  public static void unregisterComponent(VComponent paramVComponent, DOMActionContext paramDOMActionContext)
  {
    if ((paramVComponent == null) || (paramDOMActionContext == null)) {}
    for (;;)
    {
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.diff.DomDiffUtils
 * JD-Core Version:    0.7.0.1
 */