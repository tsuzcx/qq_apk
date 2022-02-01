package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DiffUtils
{
  public static void createView(ControllerManager paramControllerManager, List<DiffUtils.PatchType> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      paramControllerManager = (DiffUtils.PatchType)paramList.get(i);
      if (paramControllerManager.mType == 5)
      {
        paramControllerManager = (DiffUtils.CreatePatch)paramControllerManager.mPatch;
        paramControllerManager.renderNode.createViewRecursive();
        if (paramControllerManager.renderNode.mParent != null) {
          paramControllerManager.renderNode.mParent.update();
        }
        paramControllerManager.renderNode.updateViewRecursive();
      }
      i += 1;
    }
  }
  
  public static void deleteViews(ControllerManager paramControllerManager, List<DiffUtils.PatchType> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      DiffUtils.PatchType localPatchType = (DiffUtils.PatchType)paramList.get(i);
      if (localPatchType.mType == 0)
      {
        DiffUtils.DeletePatch localDeletePatch = (DiffUtils.DeletePatch)localPatchType.mPatch;
        paramControllerManager.deleteChild(localDeletePatch.mPid, localDeletePatch.mId);
        paramList.remove(localPatchType);
      }
      i -= 1;
    }
  }
  
  public static ArrayList<DiffUtils.PatchType> diff(RenderNode paramRenderNode1, RenderNode paramRenderNode2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramRenderNode1.getId() == paramRenderNode2.getId()) {
      return localArrayList;
    }
    try
    {
      diffFromNode(paramRenderNode1, paramRenderNode2, localArrayList);
      diffToNode(paramRenderNode1, paramRenderNode2, localArrayList);
      return localArrayList;
    }
    catch (Throwable paramRenderNode1)
    {
      paramRenderNode2 = new StringBuilder();
      paramRenderNode2.append("diff: ");
      paramRenderNode2.append(paramRenderNode1.getMessage());
      LogUtils.d("DiffUtils", paramRenderNode2.toString());
    }
    return localArrayList;
  }
  
  private static HippyArray diffArray(HippyArray paramHippyArray1, HippyArray paramHippyArray2, int paramInt)
  {
    if (paramHippyArray1.size() != paramHippyArray2.size()) {
      return paramHippyArray2;
    }
    int k = paramHippyArray1.size();
    int i = 0;
    while (i < k)
    {
      Object localObject1 = paramHippyArray1.getObject(i);
      Object localObject2 = paramHippyArray2.getObject(i);
      if ((localObject1 instanceof Boolean))
      {
        if (((Boolean)localObject1).booleanValue() != ((Boolean)localObject2).booleanValue()) {
          return paramHippyArray2;
        }
      }
      else if ((localObject1 instanceof Number))
      {
        double d = ((Number)localObject1).doubleValue();
        int j;
        if (((localObject2 instanceof Number)) && (d == ((Number)localObject2).doubleValue())) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0) {
          return paramHippyArray2;
        }
      }
      else if ((localObject1 instanceof String))
      {
        if (!TextUtils.equals((String)localObject1, (String)localObject2)) {
          return paramHippyArray2;
        }
      }
      else if ((localObject1 instanceof HippyArray))
      {
        if (((localObject2 instanceof HippyArray)) && (diffArray((HippyArray)localObject1, (HippyArray)localObject2, paramInt) != null)) {
          return paramHippyArray2;
        }
      }
      else if (((localObject1 instanceof HippyMap)) && ((localObject2 instanceof HippyMap)) && (diffProps((HippyMap)localObject1, (HippyMap)localObject2, paramInt) != null))
      {
        return paramHippyArray2;
      }
      i += 1;
    }
    return null;
  }
  
  private static DiffUtils.ExtraPatch diffExtra(RenderNode paramRenderNode1, RenderNode paramRenderNode2)
  {
    if ((paramRenderNode1.mTextExtra != null) && (paramRenderNode2.mTextExtra != null) && (!TextUtils.equals(paramRenderNode1.mTextExtra.toString(), paramRenderNode2.mTextExtra.toString()))) {
      return new DiffUtils.ExtraPatch(paramRenderNode2.getId(), paramRenderNode2.mTextExtra, paramRenderNode2.getClassName());
    }
    return null;
  }
  
  private static void diffFromNode(RenderNode paramRenderNode1, RenderNode paramRenderNode2, ArrayList<DiffUtils.PatchType> paramArrayList)
  {
    Object localObject;
    if (TextUtils.equals(paramRenderNode1.getClassName(), paramRenderNode2.getClassName()))
    {
      paramArrayList.add(new DiffUtils.PatchType(4, new DiffUtils.ReplacePatch(paramRenderNode1.getId(), paramRenderNode2.getId())));
      localObject = diffProps(paramRenderNode1.getProps(), paramRenderNode2.getProps(), 0);
      if ((localObject != null) && (((HippyMap)localObject).size() >= 1)) {
        paramArrayList.add(new DiffUtils.PatchType(1, new DiffUtils.PropsPatch((HippyMap)localObject, paramRenderNode2.getId(), paramRenderNode2.getClassName())));
      }
      localObject = diffLayout(paramRenderNode1, paramRenderNode2);
      if (localObject != null) {
        paramArrayList.add(new DiffUtils.PatchType(2, (DiffUtils.Patch)localObject));
      }
      localObject = diffExtra(paramRenderNode1, paramRenderNode2);
      if (localObject != null) {
        paramArrayList.add(new DiffUtils.PatchType(3, (DiffUtils.Patch)localObject));
      }
    }
    int i = 0;
    while (i < paramRenderNode1.getChildCount())
    {
      RenderNode localRenderNode = paramRenderNode1.getChildAt(i);
      localObject = null;
      if (i < paramRenderNode2.getChildCount()) {
        localObject = paramRenderNode2.getChildAt(i);
      }
      if ((localObject != null) && (TextUtils.equals(localRenderNode.getClassName(), ((RenderNode)localObject).getClassName())))
      {
        diffFromNode(localRenderNode, (RenderNode)localObject, paramArrayList);
      }
      else
      {
        if (localObject != null)
        {
          paramArrayList.add(new DiffUtils.PatchType(5, new DiffUtils.CreatePatch((RenderNode)localObject)));
          if (TextUtils.equals(((RenderNode)localObject).getClassName(), "Text")) {
            paramArrayList.add(new DiffUtils.PatchType(3, new DiffUtils.ExtraPatch(((RenderNode)localObject).mId, ((RenderNode)localObject).mTextExtra, ((RenderNode)localObject).getClassName())));
          }
          paramArrayList.add(new DiffUtils.PatchType(2, new DiffUtils.LayoutPatch(((RenderNode)localObject).mX, ((RenderNode)localObject).mY, ((RenderNode)localObject).mHeight, ((RenderNode)localObject).getWidth(), ((RenderNode)localObject).mId, ((RenderNode)localObject).mParent.mId, ((RenderNode)localObject).mClassName)));
        }
        paramArrayList.add(new DiffUtils.PatchType(0, new DiffUtils.DeletePatch(localRenderNode.getId(), localRenderNode.getParent().getId(), localRenderNode.getParent().getClassName())));
      }
      i += 1;
    }
  }
  
  private static DiffUtils.LayoutPatch diffLayout(RenderNode paramRenderNode1, RenderNode paramRenderNode2)
  {
    if ((paramRenderNode1 != null) && (paramRenderNode1.getX() == paramRenderNode2.getX()) && (paramRenderNode1.getY() == paramRenderNode2.getY()) && (paramRenderNode1.getWidth() == paramRenderNode2.getWidth()) && (paramRenderNode1.getHeight() == paramRenderNode2.getHeight())) {
      return null;
    }
    return new DiffUtils.LayoutPatch(paramRenderNode2.getX(), paramRenderNode2.getY(), paramRenderNode2.getHeight(), paramRenderNode2.getWidth(), paramRenderNode2.getId(), paramRenderNode2.mParent.getId(), paramRenderNode2.getClassName());
  }
  
  public static HippyMap diffProps(HippyMap paramHippyMap1, HippyMap paramHippyMap2, int paramInt)
  {
    if (paramHippyMap1 == null) {
      return paramHippyMap2;
    }
    HippyMap localHippyMap = new HippyMap();
    Iterator localIterator = paramHippyMap1.keySet().iterator();
    label178:
    label190:
    Object localObject2;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.equals("dt_elementBizLeafIdentifier"))
      {
        localObject1 = paramHippyMap1.get(str);
        Object localObject3 = paramHippyMap2.get(str);
        boolean bool;
        if ((localObject1 instanceof Boolean))
        {
          bool = ((Boolean)localObject1).booleanValue();
          if ((localObject3 == null) || (bool != ((Boolean)localObject3).booleanValue())) {}
        }
        else
        {
          if (!(localObject1 instanceof Number)) {
            break label190;
          }
          double d = ((Number)localObject1).doubleValue();
          bool = localObject3 instanceof Number;
          int j = 0;
          int i = j;
          if (bool)
          {
            i = j;
            if (d == ((Number)localObject3).doubleValue()) {
              i = 1;
            }
          }
          if (i != 0) {
            continue;
          }
        }
        for (;;)
        {
          localHippyMap.pushObject(str, localObject3);
          break;
          if ((localObject1 instanceof String))
          {
            if ((localObject3 == null) || (!TextUtils.equals(localObject1.toString(), localObject3.toString()))) {
              continue;
            }
            break;
          }
          if (!(localObject1 instanceof HippyArray)) {
            break label314;
          }
          if ((localObject3 == null) || (!(localObject3 instanceof HippyArray))) {
            break label303;
          }
          localObject1 = (HippyArray)localObject1;
          localObject2 = (HippyArray)localObject3;
          localObject1 = diffArray((HippyArray)localObject1, (HippyArray)localObject2, paramInt + 1);
          if ((str.equals("tintColors")) || (str.equals("tintColor"))) {
            localObject1 = localObject2;
          }
          if (localObject1 == null) {
            break;
          }
        }
        label303:
        label314:
        do
        {
          localHippyMap.pushObject(str, null);
          break;
          if (!(localObject1 instanceof HippyMap)) {
            break;
          }
          if ((localObject3 != null) && ((localObject3 instanceof HippyMap)))
          {
            localObject1 = diffProps((HippyMap)localObject1, (HippyMap)localObject3, paramInt + 1);
            if ((localObject1 == null) || (((HippyMap)localObject1).size() <= 0)) {
              break;
            }
            if ((paramInt != 0) || (!str.equals("style"))) {
              break label178;
            }
            localHippyMap.pushObject(str, localObject1);
            break;
          }
        } while ((paramInt != 0) || (!str.equals("style")));
        localHippyMap.pushMap(str, diffProps((HippyMap)localObject1, new HippyMap(), paramInt + 1));
      }
    }
    Object localObject1 = paramHippyMap2.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((paramHippyMap1.get((String)localObject2) == null) && (!((String)localObject2).equals("dt_elementBizLeafIdentifier"))) {
        localHippyMap.pushObject((String)localObject2, paramHippyMap2.get((String)localObject2));
      }
    }
    return localHippyMap;
  }
  
  private static void diffToNode(RenderNode paramRenderNode1, RenderNode paramRenderNode2, ArrayList<DiffUtils.PatchType> paramArrayList)
  {
    if (paramRenderNode1 != null)
    {
      if (paramRenderNode2 == null) {
        return;
      }
      int i = 0;
      while (i < paramRenderNode2.getChildCount())
      {
        if (i >= paramRenderNode1.getChildCount())
        {
          RenderNode localRenderNode = paramRenderNode2.getChildAt(i);
          paramArrayList.add(new DiffUtils.PatchType(5, new DiffUtils.CreatePatch(localRenderNode)));
          if (TextUtils.equals(localRenderNode.getClassName(), "Text")) {
            paramArrayList.add(new DiffUtils.PatchType(3, new DiffUtils.ExtraPatch(localRenderNode.mId, localRenderNode.mTextExtra, localRenderNode.getClassName())));
          }
          paramArrayList.add(new DiffUtils.PatchType(2, new DiffUtils.LayoutPatch(localRenderNode.mX, localRenderNode.mY, localRenderNode.mHeight, localRenderNode.getWidth(), localRenderNode.mId, localRenderNode.mParent.mId, localRenderNode.mClassName)));
        }
        else
        {
          diffToNode(paramRenderNode1.getChildAt(i), paramRenderNode2.getChildAt(i), paramArrayList);
        }
        i += 1;
      }
    }
  }
  
  public static void doPatch(ControllerManager paramControllerManager, List<DiffUtils.PatchType> paramList)
  {
    HippyEngineContext localHippyEngineContext = paramControllerManager.a;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DiffUtils.PatchType)paramList.next();
      if (((DiffUtils.PatchType)localObject).mType == 1)
      {
        localObject = (DiffUtils.PropsPatch)((DiffUtils.PatchType)localObject).mPatch;
        HippyMap localHippyMap1 = ((DiffUtils.PropsPatch)localObject).mPropsToUpdate;
        RenderNode localRenderNode = localHippyEngineContext.getRenderManager().getRenderNode(((DiffUtils.PropsPatch)localObject).mId);
        if (localRenderNode != null)
        {
          HippyMap localHippyMap2 = localRenderNode.getProps();
          if (localRenderNode.mHasSetDteblId)
          {
            if (localHippyMap1.containsKey("dt_elementBizLeafIdentifier")) {
              localHippyMap1.remove("dt_elementBizLeafIdentifier");
            }
          }
          else if ((localHippyMap2 != null) && (localHippyMap2.containsKey("dt_elementBizLeafIdentifier"))) {
            localHippyMap1.pushString("dt_elementBizLeafIdentifier", localHippyMap2.getString("dt_elementBizLeafIdentifier"));
          }
        }
        paramControllerManager.a(((DiffUtils.PropsPatch)localObject).mId, ((DiffUtils.PropsPatch)localObject).mClassName, localHippyMap1);
      }
      else if (((DiffUtils.PatchType)localObject).mType == 2)
      {
        localObject = (DiffUtils.LayoutPatch)((DiffUtils.PatchType)localObject).mPatch;
        paramControllerManager.a(((DiffUtils.LayoutPatch)localObject).mClassName, ((DiffUtils.LayoutPatch)localObject).mId, ((DiffUtils.LayoutPatch)localObject).mX, ((DiffUtils.LayoutPatch)localObject).mY, ((DiffUtils.LayoutPatch)localObject).mWidth, ((DiffUtils.LayoutPatch)localObject).mHeight);
      }
      else if (((DiffUtils.PatchType)localObject).mType == 3)
      {
        localObject = (DiffUtils.ExtraPatch)((DiffUtils.PatchType)localObject).mPatch;
        paramControllerManager.a(((DiffUtils.ExtraPatch)localObject).mID, ((DiffUtils.ExtraPatch)localObject).mClassName, ((DiffUtils.ExtraPatch)localObject).mText);
      }
    }
  }
  
  public static void replaceIds(ControllerManager paramControllerManager, List<DiffUtils.PatchType> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      DiffUtils.PatchType localPatchType = (DiffUtils.PatchType)paramList.get(i);
      if (localPatchType.mType == 4)
      {
        DiffUtils.ReplacePatch localReplacePatch = (DiffUtils.ReplacePatch)localPatchType.mPatch;
        paramControllerManager.a(localReplacePatch.oldId, localReplacePatch.newId);
        paramList.remove(localPatchType);
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils
 * JD-Core Version:    0.7.0.1
 */