package com.tencent.mtt.hippy.modules.nativemodules.uimanager;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.annotation.HippyNativeModule.Thread;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;

@HippyNativeModule(name="UIManagerModule", thread=HippyNativeModule.Thread.DOM)
public class UIManagerModule
  extends HippyNativeModuleBase
{
  public static final String CLASS_NAME = "UIManagerModule";
  final String a = "optionType";
  final String b = "createNode";
  final String c = "updateNode";
  final String d = "deleteNode";
  final String e = "param";
  final String f = "id";
  final String g = "pId";
  final String h = "index";
  final String i = "name";
  final String j = "props";
  
  public UIManagerModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="callUIFunction")
  public void callUIFunction(HippyArray paramHippyArray, Promise paramPromise)
  {
    DomManager localDomManager = this.mContext.getDomManager();
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0) && (localDomManager != null)) {
      localDomManager.a(paramHippyArray.getInt(0), paramHippyArray.getString(1), paramHippyArray.getArray(2), paramPromise);
    }
  }
  
  @HippyMethod(name="createNode")
  public void createNode(int paramInt, HippyArray paramHippyArray)
  {
    HippyRootView localHippyRootView = this.mContext.getInstance(paramInt);
    DomManager localDomManager = this.mContext.getDomManager();
    if ((paramHippyArray != null) && (localHippyRootView != null) && (localDomManager != null))
    {
      int k = paramHippyArray.size();
      paramInt = 0;
      while (paramInt < k)
      {
        HippyMap localHippyMap = paramHippyArray.getMap(paramInt);
        localDomManager.a(localHippyRootView, ((Integer)localHippyMap.get("id")).intValue(), ((Integer)localHippyMap.get("pId")).intValue(), ((Integer)localHippyMap.get("index")).intValue(), (String)localHippyMap.get("name"), (HippyMap)localHippyMap.get("props"));
        paramInt += 1;
      }
    }
  }
  
  @HippyMethod(name="deleteNode")
  public void deleteNode(int paramInt, HippyArray paramHippyArray)
  {
    DomManager localDomManager = this.mContext.getDomManager();
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0) && (localDomManager != null))
    {
      int k = paramHippyArray.size();
      paramInt = 0;
      while (paramInt < k)
      {
        localDomManager.c(((Integer)paramHippyArray.getMap(paramInt).get("id")).intValue());
        paramInt += 1;
      }
    }
  }
  
  @HippyMethod(name="endBatch")
  public void endBatch(String paramString)
  {
    DomManager localDomManager = this.mContext.getDomManager();
    if (localDomManager != null) {
      localDomManager.b(paramString);
    }
  }
  
  @HippyMethod(name="flushBatch")
  public void flushBatch(int paramInt, HippyArray paramHippyArray)
  {
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0))
    {
      int n = paramHippyArray.size();
      int m = 0;
      while (m < n)
      {
        HippyMap localHippyMap = paramHippyArray.getMap(m);
        String str = (String)localHippyMap.get("optionType");
        int k = -1;
        int i1 = str.hashCode();
        if (i1 != -296104341)
        {
          if (i1 != 1369040158)
          {
            if ((i1 == 1764416077) && (str.equals("deleteNode"))) {
              k = 2;
            }
          }
          else if (str.equals("createNode")) {
            k = 0;
          }
        }
        else if (str.equals("updateNode")) {
          k = 1;
        }
        if (k != 0)
        {
          if (k != 1)
          {
            if (k == 2) {
              deleteNode(paramInt, (HippyArray)localHippyMap.get("param"));
            }
          }
          else {
            updateNode(paramInt, (HippyArray)localHippyMap.get("param"));
          }
        }
        else {
          createNode(paramInt, (HippyArray)localHippyMap.get("param"));
        }
        m += 1;
      }
    }
  }
  
  @HippyMethod(name="measureInWindow")
  public void measureInWindow(int paramInt, Promise paramPromise)
  {
    Object localObject = this.mContext.getDomManager();
    if (localObject != null) {
      ((DomManager)localObject).a(paramInt, paramPromise);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramPromise);
    LogUtils.d("UIManagerModule", ((StringBuilder)localObject).toString());
  }
  
  @HippyMethod(name="startBatch")
  public void startBatch(String paramString)
  {
    DomManager localDomManager = this.mContext.getDomManager();
    if (localDomManager != null) {
      localDomManager.a(paramString);
    }
  }
  
  @HippyMethod(name="updateNode")
  public void updateNode(int paramInt, HippyArray paramHippyArray)
  {
    HippyRootView localHippyRootView = this.mContext.getInstance(paramInt);
    DomManager localDomManager = this.mContext.getDomManager();
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0) && (localHippyRootView != null) && (localDomManager != null))
    {
      int k = paramHippyArray.size();
      paramInt = 0;
      while (paramInt < k)
      {
        HippyMap localHippyMap = paramHippyArray.getMap(paramInt);
        localDomManager.a(((Integer)localHippyMap.get("id")).intValue(), (HippyMap)localHippyMap.get("props"), localHippyRootView);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.uimanager.UIManagerModule
 * JD-Core Version:    0.7.0.1
 */