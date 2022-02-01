package com.tencent.mtt.hippy.uimanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
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
  final HippyEngineContext a;
  final b b;
  final c<HippyViewController, View> c;
  final SparseArray<View> d = new SparseArray();
  
  public ControllerManager(HippyEngineContext paramHippyEngineContext, List<HippyAPIProvider> paramList)
  {
    this.a = paramHippyEngineContext;
    this.b = new b();
    this.c = new c();
    this.a.addInstanceLifecycleEventListener(this);
    a(paramList);
    this.c.a(this.b.b("CustomProps"));
  }
  
  private void a(List<HippyAPIProvider> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = ((HippyAPIProvider)paramList.next()).getControllers();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Class)((Iterator)localObject1).next();
          HippyController localHippyController = (HippyController)((Class)localObject2).getAnnotation(HippyController.class);
          String str = localHippyController.name();
          String[] arrayOfString = localHippyController.names();
          boolean bool = localHippyController.isLazyLoad();
          try
          {
            localObject2 = new a((HippyViewController)((Class)localObject2).newInstance(), bool);
            this.b.a(str, (a)localObject2);
            if ((arrayOfString != null) && (arrayOfString.length > 0))
            {
              int i = 0;
              while (i < arrayOfString.length)
              {
                this.b.a(arrayOfString[i], (a)localObject2);
                i += 1;
              }
            }
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
          catch (InstantiationException localInstantiationException)
          {
            localInstantiationException.printStackTrace();
          }
        }
      }
    }
    this.b.a("RootNode", new a(new HippyViewGroupController(), false));
  }
  
  public static int b()
  {
    int i = e;
    if (i > 0) {
      return i;
    }
    Object localObject;
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      localObject = localClass.newInstance();
      i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      e = ContextHolder.getAppContext().getResources().getDimensionPixelSize(i);
    }
    catch (Exception localException)
    {
      e = -1;
      localException.printStackTrace();
    }
    if (e < 1) {
      try
      {
        i = ContextHolder.getAppContext().getResources().getIdentifier("statebar_height", "dimen", ContextHolder.getAppContext().getPackageName());
        e = Math.round(ContextHolder.getAppContext().getResources().getDimension(i));
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStatusBarHeightFromSystem: ");
        ((StringBuilder)localObject).append(localNotFoundException.getMessage());
        LogUtils.d("ControllerManager", ((StringBuilder)localObject).toString());
      }
    }
    return e;
  }
  
  public StyleNode a(String paramString, boolean paramBoolean, int paramInt)
  {
    StyleNode localStyleNode = this.b.b(paramString).createNode(paramBoolean, paramInt);
    if (localStyleNode != null) {
      return localStyleNode;
    }
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
    Object localObject = this.b.a(paramInt1);
    this.b.d(paramInt1);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error replaceID null oldId ");
      ((StringBuilder)localObject).append(paramInt1);
      LogUtils.d("HippyListView", ((StringBuilder)localObject).toString());
      return;
    }
    if ((localObject instanceof HippyRecycler)) {
      ((HippyRecycler)localObject).clear();
    }
    ((View)localObject).setId(paramInt2);
    this.b.a((View)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.b.a(paramInt1);
    if (localObject != null)
    {
      if (((View)localObject).getParent() != null) {
        ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
      }
      ViewGroup localViewGroup = (ViewGroup)this.b.a(paramInt2);
      if (localViewGroup != null)
      {
        String str = HippyTag.getClassName(localViewGroup);
        this.b.b(str).addView(localViewGroup, (View)localObject, paramInt3);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("move id: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" toid: ");
      ((StringBuilder)localObject).append(paramInt2);
      LogUtils.d("ControllerManager", ((StringBuilder)localObject).toString());
    }
  }
  
  @SuppressLint({"Range"})
  public void a(int paramInt, Promise paramPromise)
  {
    Object localObject1 = this.b.a(paramInt);
    if (localObject1 == null)
    {
      paramPromise.reject("this view is null");
      return;
    }
    Object localObject2 = new int[4];
    try
    {
      ((View)localObject1).getLocationOnScreen((int[])localObject2);
      paramInt = b();
      if (paramInt > 0) {
        localObject2[1] -= paramInt;
      }
      localObject2[2] = ((View)localObject1).getWidth();
      localObject2[3] = ((View)localObject1).getHeight();
      float f1 = PixelUtil.px2dp(localObject2[0]);
      float f2 = PixelUtil.px2dp(localObject2[1]);
      float f3 = PixelUtil.px2dp(localObject2[2]);
      float f4 = PixelUtil.px2dp(localObject2[3]);
      float f5 = PixelUtil.px2dp(paramInt);
      localObject1 = new HippyMap();
      ((HippyMap)localObject1).pushDouble("x", f1);
      ((HippyMap)localObject1).pushDouble("y", f2);
      ((HippyMap)localObject1).pushDouble("width", f3);
      ((HippyMap)localObject1).pushDouble("height", f4);
      ((HippyMap)localObject1).pushDouble("statusBarHeight", f5);
      paramPromise.resolve(localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exception");
      ((StringBuilder)localObject2).append(localThrowable.getMessage());
      paramPromise.reject(((StringBuilder)localObject2).toString());
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
    if (paramViewGroup != null)
    {
      if (paramView == null) {
        return;
      }
      Object localObject2 = null;
      String str = HippyTag.getClassName(paramView);
      Object localObject1 = localObject2;
      if ((str instanceof String))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = this.b.b(str);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((HippyViewController)localObject2).onViewDestroy(paramView);
            localObject1 = localObject2;
          }
        }
      }
      if ((paramView instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)paramView;
        if (localObject1 != null)
        {
          i = ((HippyViewController)localObject1).getChildCount((View)localObject2) - 1;
          while (i >= 0)
          {
            a((ViewGroup)localObject2, ((HippyViewController)localObject1).getChildAt((View)localObject2, i), -1);
            i -= 1;
          }
        }
        int i = ((ViewGroup)localObject2).getChildCount() - 1;
        while (i >= 0)
        {
          a((ViewGroup)localObject2, ((ViewGroup)localObject2).getChildAt(i), -1);
          i -= 1;
        }
      }
      if ((this.b.a(paramView.getId()) != paramView) && (this.b.a(paramViewGroup.getId()) != paramViewGroup)) {
        return;
      }
      localObject1 = HippyTag.getClassName(paramViewGroup);
      if ((localObject1 instanceof String))
      {
        if (this.b.a((String)localObject1) != null) {
          this.b.b((String)localObject1).deleteChild(paramViewGroup, paramView, paramInt);
        }
      }
      else {
        paramViewGroup.removeView(paramView);
      }
      this.b.d(paramView.getId());
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
    Object localObject1 = this.b.a(paramInt);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = (View)this.d.get(paramInt);
      this.d.remove(paramInt);
      HippyViewController localHippyViewController = this.b.b(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localHippyViewController.createView(paramHippyRootView, paramInt, this.a, paramString, paramHippyMap);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        this.b.a((View)localObject1);
        this.c.a(localHippyViewController, localObject1, paramHippyMap);
        localHippyViewController.onAfterUpdateProps((View)localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
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
    View localView = this.b.a(paramInt2);
    Object localObject2 = this.b.a(paramInt1);
    Object localObject1;
    if ((localView != null) && ((localObject2 instanceof ViewGroup)))
    {
      if (localView.getParent() == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addChild id: ");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(" pid: ");
        ((StringBuilder)localObject1).append(paramInt1);
        LogUtils.d("ControllerManager", ((StringBuilder)localObject1).toString());
        localObject1 = HippyTag.getClassName((View)localObject2);
        this.b.b((String)localObject1).addView((ViewGroup)localObject2, localView, paramInt3);
      }
    }
    else
    {
      localObject1 = this.a.getRenderManager().getRenderNode(paramInt1);
      String str1;
      if (localObject1 != null) {
        str1 = ((RenderNode)localObject1).getClassName();
      } else {
        str1 = "null";
      }
      Object localObject4 = null;
      String str2 = null;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject1 = HippyTag.getClassName((View)localObject2);
        if (localObject1 != null) {
          localObject1 = localObject1.toString();
        } else {
          localObject1 = null;
        }
        localObject2 = localObject2.getClass().getName();
        localObject3 = localObject1;
      }
      else
      {
        localObject2 = null;
        localObject3 = localObject2;
      }
      if (localView != null)
      {
        localObject4 = HippyTag.getClassName(localView);
        localObject1 = str2;
        if (localObject4 != null) {
          localObject1 = localObject4.toString();
        }
        str2 = localView.getClass().getName();
      }
      else
      {
        str2 = null;
        localObject1 = localObject4;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("child null or parent not ViewGroup pid ");
      ((StringBuilder)localObject4).append(paramInt1);
      ((StringBuilder)localObject4).append(" parentTag ");
      ((StringBuilder)localObject4).append(localObject3);
      ((StringBuilder)localObject4).append(" parentClass ");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(" renderNodeClass ");
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).append(" id ");
      ((StringBuilder)localObject4).append(paramInt2);
      ((StringBuilder)localObject4).append(" childTag ");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(" childClass ");
      ((StringBuilder)localObject4).append(str2);
      localObject1 = new RuntimeException(((StringBuilder)localObject4).toString());
      this.a.getGlobalConfigs().getExceptionHandler().handleNativeException((Exception)localObject1, true);
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
    HippyEngineContext localHippyEngineContext = this.a;
    if ((localHippyEngineContext != null) && (localHippyEngineContext.getInstance(paramInt) != null)) {
      this.b.a(this.a.getInstance(paramInt));
    }
  }
  
  public void onInstancePause(int paramInt) {}
  
  public void onInstanceResume(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.ControllerManager
 * JD-Core Version:    0.7.0.1
 */