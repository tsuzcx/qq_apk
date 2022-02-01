package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
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
    catch (Throwable paramRenderNode1) {}
    return localArrayList;
  }
  
  private static HippyArray diffArray(HippyArray paramHippyArray1, HippyArray paramHippyArray2, int paramInt)
  {
    if (paramHippyArray1.size() != paramHippyArray2.size()) {}
    int j;
    Object localObject1;
    Object localObject2;
    do
    {
      return paramHippyArray2;
      int k = paramHippyArray1.size();
      j = 0;
      if (j >= k) {
        break label231;
      }
      localObject1 = paramHippyArray1.getObject(j);
      localObject2 = paramHippyArray2.getObject(j);
      if (!(localObject1 instanceof Boolean)) {
        break;
      }
    } while (((Boolean)localObject1).booleanValue() != ((Boolean)localObject2).booleanValue());
    label231:
    label233:
    label237:
    for (;;)
    {
      j += 1;
      break;
      int i;
      if ((localObject1 instanceof Number))
      {
        double d = ((Number)localObject1).doubleValue();
        if (!(localObject2 instanceof Number)) {
          break label233;
        }
        if (d == ((Number)localObject2).doubleValue()) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label237;
        }
        return paramHippyArray2;
        i = 0;
        continue;
        if ((localObject1 instanceof String))
        {
          if (TextUtils.equals((String)localObject1, (String)localObject2)) {
            break;
          }
          return paramHippyArray2;
        }
        if ((localObject1 instanceof HippyArray))
        {
          if ((!(localObject2 instanceof HippyArray)) || (diffArray((HippyArray)localObject1, (HippyArray)localObject2, paramInt) == null)) {
            break;
          }
          return paramHippyArray2;
        }
        if ((!(localObject1 instanceof HippyMap)) || (!(localObject2 instanceof HippyMap)) || (diffProps((HippyMap)localObject1, (HippyMap)localObject2, paramInt) == null)) {
          break;
        }
        return paramHippyArray2;
        return null;
        i = 0;
      }
    }
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
    RenderNode localRenderNode;
    if (i < paramRenderNode1.getChildCount())
    {
      localRenderNode = paramRenderNode1.getChildAt(i);
      if (i >= paramRenderNode2.getChildCount()) {
        break label400;
      }
    }
    label400:
    for (Object localObject = paramRenderNode2.getChildAt(i);; localObject = null)
    {
      if ((localObject != null) && (TextUtils.equals(localRenderNode.getClassName(), ((RenderNode)localObject).getClassName()))) {
        diffFromNode(localRenderNode, (RenderNode)localObject, paramArrayList);
      }
      for (;;)
      {
        i += 1;
        break;
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
      return;
    }
  }
  
  private static DiffUtils.LayoutPatch diffLayout(RenderNode paramRenderNode1, RenderNode paramRenderNode2)
  {
    if ((paramRenderNode1 == null) || (paramRenderNode1.getX() != paramRenderNode2.getX()) || (paramRenderNode1.getY() != paramRenderNode2.getY()) || (paramRenderNode1.getWidth() != paramRenderNode2.getWidth()) || (paramRenderNode1.getHeight() != paramRenderNode2.getHeight())) {
      return new DiffUtils.LayoutPatch(paramRenderNode2.getX(), paramRenderNode2.getY(), paramRenderNode2.getHeight(), paramRenderNode2.getWidth(), paramRenderNode2.getId(), paramRenderNode2.mParent.getId(), paramRenderNode2.getClassName());
    }
    return null;
  }
  
  public static HippyMap diffProps(HippyMap paramHippyMap1, HippyMap paramHippyMap2, int paramInt)
  {
    if (paramHippyMap1 == null) {
      return paramHippyMap2;
    }
    HippyMap localHippyMap = new HippyMap();
    Object localObject2 = paramHippyMap1.keySet().iterator();
    label517:
    label521:
    for (;;)
    {
      String str;
      Object localObject1;
      Object localObject3;
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        localObject1 = paramHippyMap1.get(str);
        localObject3 = paramHippyMap2.get(str);
        if ((localObject1 instanceof Boolean))
        {
          boolean bool = ((Boolean)localObject1).booleanValue();
          if ((localObject3 != null) && (bool == ((Boolean)localObject3).booleanValue())) {
            continue;
          }
          localHippyMap.pushObject(str, localObject3);
          continue;
        }
        if ((localObject1 instanceof Number))
        {
          double d = ((Number)localObject1).doubleValue();
          if (!(localObject3 instanceof Number)) {
            break label517;
          }
          if (d == ((Number)localObject3).doubleValue()) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label521;
        }
        localHippyMap.pushObject(str, localObject3);
        break;
        i = 0;
        continue;
        if ((localObject1 instanceof String))
        {
          if ((localObject3 != null) && (TextUtils.equals(localObject1.toString(), localObject3.toString()))) {
            break;
          }
          localHippyMap.pushObject(str, localObject3);
          break;
        }
        if ((localObject1 instanceof HippyArray))
        {
          if ((localObject3 != null) && ((localObject3 instanceof HippyArray)))
          {
            localObject1 = diffArray((HippyArray)localObject1, (HippyArray)localObject3, paramInt + 1);
            if ((str.equals("tintColors")) || (str.equals("tintColor"))) {
              localObject1 = (HippyArray)localObject3;
            }
            if (localObject1 == null) {
              break;
            }
            localHippyMap.pushObject(str, localObject3);
            break;
          }
          localHippyMap.pushObject(str, null);
          break;
        }
        if (!(localObject1 instanceof HippyMap)) {
          break;
        }
        if ((localObject3 != null) && ((localObject3 instanceof HippyMap)))
        {
          localObject1 = diffProps((HippyMap)localObject1, (HippyMap)localObject3, paramInt + 1);
          if ((localObject1 == null) || (((HippyMap)localObject1).size() <= 0)) {
            break;
          }
          if ((paramInt == 0) && (str.equals("style")))
          {
            localHippyMap.pushObject(str, localObject1);
            break;
          }
          localHippyMap.pushObject(str, localObject3);
          break;
        }
        if ((paramInt == 0) && (str.equals("style")))
        {
          localHippyMap.pushMap(str, diffProps((HippyMap)localObject1, new HippyMap(), paramInt + 1));
          break;
        }
        localHippyMap.pushObject(str, null);
        break;
        localObject1 = paramHippyMap2.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramHippyMap1.get((String)localObject2) == null) {
            localHippyMap.pushObject((String)localObject2, paramHippyMap2.get((String)localObject2));
          }
        }
        return localHippyMap;
        i = 0;
      }
    }
  }
  
  private static void diffToNode(RenderNode paramRenderNode1, RenderNode paramRenderNode2, ArrayList<DiffUtils.PatchType> paramArrayList)
  {
    if ((paramRenderNode1 == null) || (paramRenderNode2 == null)) {
      return;
    }
    int i = 0;
    label11:
    if (i < paramRenderNode2.getChildCount())
    {
      if (i < paramRenderNode1.getChildCount()) {
        break label169;
      }
      RenderNode localRenderNode = paramRenderNode2.getChildAt(i);
      paramArrayList.add(new DiffUtils.PatchType(5, new DiffUtils.CreatePatch(localRenderNode)));
      if (TextUtils.equals(localRenderNode.getClassName(), "Text")) {
        paramArrayList.add(new DiffUtils.PatchType(3, new DiffUtils.ExtraPatch(localRenderNode.mId, localRenderNode.mTextExtra, localRenderNode.getClassName())));
      }
      paramArrayList.add(new DiffUtils.PatchType(2, new DiffUtils.LayoutPatch(localRenderNode.mX, localRenderNode.mY, localRenderNode.mHeight, localRenderNode.getWidth(), localRenderNode.mId, localRenderNode.mParent.mId, localRenderNode.mClassName)));
    }
    for (;;)
    {
      i += 1;
      break label11;
      break;
      label169:
      diffToNode(paramRenderNode1.getChildAt(i), paramRenderNode2.getChildAt(i), paramArrayList);
    }
  }
  
  public static void doPatch(ControllerManager paramControllerManager, List<DiffUtils.PatchType> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DiffUtils.PatchType)paramList.next();
      if (((DiffUtils.PatchType)localObject).mType == 1)
      {
        localObject = (DiffUtils.PropsPatch)((DiffUtils.PatchType)localObject).mPatch;
        paramControllerManager.a(((DiffUtils.PropsPatch)localObject).mId, ((DiffUtils.PropsPatch)localObject).mClassName, ((DiffUtils.PropsPatch)localObject).mPropsToUpdate);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils
 * JD-Core Version:    0.7.0.1
 */