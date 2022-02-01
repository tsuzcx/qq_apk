package com.tencent.mtt.hippy.uimanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.views.list.HippyRecycler;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class ControllerManager
  implements HippyInstanceLifecycleEventListener
{
  private static int e = -1;
  HippyEngineContext a;
  b b;
  c<HippyViewController, View> c;
  SparseArray<View> d = new SparseArray();
  
  public ControllerManager(HippyEngineContext paramHippyEngineContext, List<HippyAPIProvider> paramList)
  {
    this.a = paramHippyEngineContext;
    this.b = new b();
    this.c = new c();
    this.a.addInstanceLifecycleEventListener(this);
    a(paramList);
  }
  
  private void a(List<HippyAPIProvider> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = ((HippyAPIProvider)paramList.next()).getControllers();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject).next();
          HippyController localHippyController = (HippyController)localClass.getAnnotation(HippyController.class);
          String str = localHippyController.name();
          boolean bool = localHippyController.isLazyLoad();
          try
          {
            this.b.a(str, new a((HippyViewController)localClass.newInstance(), bool));
          }
          catch (InstantiationException localInstantiationException)
          {
            localInstantiationException.printStackTrace();
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
        }
      }
    }
    this.b.a("RootNode", new a(new HippyViewGroupController(), false));
  }
  
  public static int b()
  {
    if (e > 0) {
      return e;
    }
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      e = ContextHolder.getAppContext().getResources().getDimensionPixelSize(i);
      if (e < 1)
      {
        i = ContextHolder.getAppContext().getResources().getIdentifier("statebar_height", "dimen", ContextHolder.getAppContext().getPackageName());
        e = Math.round(ContextHolder.getAppContext().getResources().getDimension(i));
      }
      return e;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e = -1;
        localException.printStackTrace();
      }
    }
  }
  
  public StyleNode a(String paramString, boolean paramBoolean)
  {
    return this.b.b(paramString).createNode(paramBoolean);
  }
  
  public RenderNode a(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, boolean paramBoolean)
  {
    return this.b.b(paramString).createRenderNode(paramInt, paramHippyMap, paramString, paramHippyRootView, this, paramBoolean);
  }
  
  public void a()
  {
    this.a.removeInstanceLifecycleEventListener(this);
    UIThreadUtils.runOnUiThread(new ControllerManager.1(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView = this.b.a(paramInt1);
    this.b.d(paramInt1);
    if (localView == null)
    {
      Log.e("HippyListView", "error replaceID null oldId " + paramInt1);
      return;
    }
    if ((localView instanceof HippyRecycler)) {
      ((HippyRecycler)localView).clear();
    }
    localView.setId(paramInt2);
    this.b.a(localView);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = this.b.a(paramInt1);
    if (localView != null)
    {
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      ViewGroup localViewGroup = (ViewGroup)this.b.a(paramInt2);
      if (localViewGroup != null)
      {
        String str = HippyTag.getClassName(localViewGroup);
        this.b.b(str).addView(localViewGroup, localView, paramInt3);
      }
      LogUtils.d("ControllerManager", "move id: " + paramInt1 + " toid: " + paramInt2);
    }
  }
  
  @SuppressLint({"Range"})
  public void a(int paramInt, Promise paramPromise)
  {
    Object localObject = this.b.a(paramInt);
    if (localObject == null)
    {
      paramPromise.reject("this view is null");
      return;
    }
    int[] arrayOfInt = new int[4];
    try
    {
      ((View)localObject).getLocationOnScreen(arrayOfInt);
      paramInt = b();
      if (paramInt > 0) {
        arrayOfInt[1] -= paramInt;
      }
      arrayOfInt[2] = ((View)localObject).getWidth();
      arrayOfInt[3] = ((View)localObject).getHeight();
      float f1 = PixelUtil.px2dp(arrayOfInt[0]);
      float f2 = PixelUtil.px2dp(arrayOfInt[1]);
      float f3 = PixelUtil.px2dp(arrayOfInt[2]);
      float f4 = PixelUtil.px2dp(arrayOfInt[3]);
      float f5 = PixelUtil.px2dp(paramInt);
      localObject = new HippyMap();
      ((HippyMap)localObject).pushDouble("x", f1);
      ((HippyMap)localObject).pushDouble("y", f2);
      ((HippyMap)localObject).pushDouble("width", f3);
      ((HippyMap)localObject).pushDouble("height", f4);
      ((HippyMap)localObject).pushDouble("statusBarHeight", f5);
      paramPromise.resolve(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramPromise.reject("exception" + localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt, String paramString, HippyMap paramHippyMap)
  {
    View localView = this.b.a(paramInt);
    paramString = this.b.b(paramString);
    if ((localView != null) && (paramString != null) && (paramHippyMap != null))
    {
      this.c.a(paramString, localView, paramHippyMap);
      paramString.onAfterUpdateProps(localView);
    }
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    this.b.b(paramString).updateExtra(this.b.a(paramInt), paramObject);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, HippyArray paramHippyArray, Promise paramPromise)
  {
    paramString1 = this.b.b(paramString1);
    View localView = this.b.a(paramInt);
    if (!paramPromise.isCallback())
    {
      paramString1.dispatchFunction(localView, paramString2, paramHippyArray);
      return;
    }
    paramString1.dispatchFunction(localView, paramString2, paramHippyArray, paramPromise);
  }
  
  public void a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    if ((paramViewGroup == null) || (paramView == null)) {}
    do
    {
      return;
      ViewGroup localViewGroup = null;
      String str = HippyTag.getClassName(paramView);
      localObject = localViewGroup;
      if ((str instanceof String))
      {
        str = (String)str;
        localObject = localViewGroup;
        if (!TextUtils.isEmpty(str))
        {
          localObject = this.b.b(str);
          if (localObject != null) {
            ((HippyViewController)localObject).onViewDestroy(paramView);
          }
        }
      }
      if ((paramView instanceof ViewGroup))
      {
        localViewGroup = (ViewGroup)paramView;
        if (localObject != null)
        {
          i = ((HippyViewController)localObject).getChildCount(localViewGroup) - 1;
          while (i >= 0)
          {
            a(localViewGroup, ((HippyViewController)localObject).getChildAt(localViewGroup, i), -1);
            i -= 1;
          }
        }
        int i = localViewGroup.getChildCount() - 1;
        while (i >= 0)
        {
          a(localViewGroup, localViewGroup.getChildAt(i), -1);
          i -= 1;
        }
      }
    } while ((this.b.a(paramView.getId()) != paramView) && (this.b.a(paramViewGroup.getId()) != paramViewGroup));
    Object localObject = HippyTag.getClassName(paramViewGroup);
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      if (this.b.a((String)localObject) != null) {
        this.b.b((String)localObject).deleteChild(paramViewGroup, paramView, paramInt);
      }
    }
    for (;;)
    {
      this.b.d(paramView.getId());
      return;
      paramViewGroup.removeView(paramView);
    }
  }
  
  public void a(HippyRootView paramHippyRootView, int paramInt, String paramString, HippyMap paramHippyMap)
  {
    if (this.b.a(paramInt) == null)
    {
      paramHippyRootView = this.b.b(paramString).createView(paramHippyRootView, paramInt, this.a, paramString, paramHippyMap);
      this.d.put(paramInt, paramHippyRootView);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = this.b.b(paramString);
    View localView = this.b.a(paramInt);
    if (localView != null) {
      paramString.onBatchComplete(localView);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b.b(paramString).updateLayout(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.b);
  }
  
  public boolean a(int paramInt)
  {
    return this.b.a(paramInt) != null;
  }
  
  public boolean a(String paramString)
  {
    return this.b.a(paramString).b;
  }
  
  public View b(HippyRootView paramHippyRootView, int paramInt, String paramString, HippyMap paramHippyMap)
  {
    View localView2 = this.b.a(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = (View)this.d.get(paramInt);
      this.d.remove(paramInt);
      HippyViewController localHippyViewController = this.b.b(paramString);
      localView1 = localView2;
      if (localView2 == null) {
        localView1 = localHippyViewController.createView(paramHippyRootView, paramInt, this.a, paramString, paramHippyMap);
      }
      if (localView1 != null)
      {
        this.b.a(localView1);
        this.c.a(localHippyViewController, localView1, paramHippyMap);
        localHippyViewController.onAfterUpdateProps(localView1);
      }
    }
    return localView1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.b.c(paramInt);
    if (localObject != null)
    {
      localObject = (HippyRootView)localObject;
      int i = ((HippyRootView)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        deleteChild(paramInt, ((HippyRootView)localObject).getChildAt(i).getId());
        i -= 1;
      }
    }
    this.b.e(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView1 = this.b.a(paramInt1);
    View localView2 = this.b.a(paramInt2);
    if (((localView1 instanceof ViewGroup)) && (localView2 != null)) {
      a((ViewGroup)localView1, localView2, paramInt3);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = this.b.b(paramString);
    View localView = this.b.a(paramInt);
    if (localView != null) {
      paramString.onManageChildComplete(localView);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    String str2 = null;
    Object localObject4 = null;
    View localView = this.b.a(paramInt2);
    Object localObject2 = this.b.a(paramInt1);
    if ((localView != null) && ((localObject2 instanceof ViewGroup)))
    {
      if (localView.getParent() == null)
      {
        LogUtils.d("ControllerManager", "addChild id: " + paramInt2 + " pid: " + paramInt1);
        localObject1 = HippyTag.getClassName((View)localObject2);
        this.b.b((String)localObject1).addView((ViewGroup)localObject2, localView, paramInt3);
      }
      return;
    }
    Object localObject1 = this.a.getRenderManager().getRenderNode(paramInt1);
    if (localObject1 != null) {}
    for (String str1 = ((RenderNode)localObject1).getClassName();; str1 = "null")
    {
      if (localObject2 != null)
      {
        localObject1 = HippyTag.getClassName((View)localObject2);
        if (localObject1 != null)
        {
          localObject1 = localObject1.toString();
          localObject2 = localObject2.getClass().getName();
        }
      }
      for (Object localObject3 = localObject1;; localObject3 = null)
      {
        if (localView != null)
        {
          str2 = HippyTag.getClassName(localView);
          localObject1 = localObject4;
          if (str2 != null) {
            localObject1 = str2.toString();
          }
          str2 = localView.getClass().getName();
        }
        for (;;)
        {
          localObject1 = new RuntimeException("child null or parent not ViewGroup pid " + paramInt1 + " parentTag " + localObject3 + " parentClass " + (String)localObject2 + " renderNodeClass " + str1 + " id " + paramInt2 + " childTag " + (String)localObject1 + " childClass " + str2);
          this.a.getGlobalConfigs().getExceptionHandler().handleNativeException((Exception)localObject1, true);
          return;
          localObject1 = null;
        }
        localObject1 = null;
        break;
        localObject2 = null;
      }
    }
  }
  
  public void deleteChild(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, -1);
  }
  
  public View findView(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public void onInstanceDestroy(int paramInt) {}
  
  public void onInstanceLoad(int paramInt)
  {
    if ((this.a != null) && (this.a.getInstance(paramInt) != null)) {
      this.b.a(this.a.getInstance(paramInt));
    }
  }
  
  public void onInstancePause(int paramInt) {}
  
  public void onInstanceResume(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.ControllerManager
 * JD-Core Version:    0.7.0.1
 */