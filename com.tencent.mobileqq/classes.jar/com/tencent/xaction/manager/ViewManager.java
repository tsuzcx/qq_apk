package com.tencent.xaction.manager;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.IViewManager;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/ViewManager;", "Lcom/tencent/xaction/api/IViewManager;", "()V", "viewMap", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/xaction/api/IView;", "Lkotlin/collections/HashMap;", "buildFactory", "context", "Landroid/content/Context;", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "isSingleTag", "", "register", "key", "clazzName", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ViewManager
  implements IViewManager
{
  public static final ViewManager.Companion a;
  @NotNull
  private static final HashMap<String, IView> b = new HashMap();
  private final HashMap<String, Class<? extends IView>> a;
  
  static
  {
    jdField_a_of_type_ComTencentXactionManagerViewManager$Companion = new ViewManager.Companion(null);
  }
  
  public ViewManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private final boolean a(ViewData paramViewData)
  {
    return TextUtils.isEmpty((CharSequence)paramViewData.getSingleTag()) ^ true;
  }
  
  @Nullable
  public IView a(@NotNull Context paramContext, @NotNull ViewData paramViewData, @Nullable ViewGroup paramViewGroup, @NotNull XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    int i;
    if (a(paramViewData))
    {
      localObject = b;
      String str = paramViewData.getSingleTag();
      if (str == null) {
        Intrinsics.throwNpe();
      }
      localObject = (IView)((HashMap)localObject).get(str);
      if (localObject != null) {
        return localObject;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    Object localObject = (Class)this.jdField_a_of_type_JavaUtilHashMap.get(paramViewData.getType());
    if (localObject != null)
    {
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { Context.class });
      Intrinsics.checkExpressionValueIsNotNull(localObject, "clazz.getDeclaredConstru…a\n            )\n        )");
      paramContext = paramContext.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.applicationContext");
      paramContext = ((Constructor)localObject).newInstance(new Object[] { paramContext });
      if (paramContext != null)
      {
        paramContext = (IView)paramContext;
        if (i != 0)
        {
          paramViewGroup = (Map)b;
          paramViewData = paramViewData.getSingleTag();
          if (paramViewData == null) {
            Intrinsics.throwNpe();
          }
          paramViewGroup.put(paramViewData, paramContext);
          return paramContext;
        }
        paramContext.getDecor().init((IXAEngine)paramXAEngine, paramViewGroup);
        return paramContext;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IView");
    }
    return null;
  }
  
  public boolean a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "clazzName");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      return false;
    }
    try
    {
      Map localMap = (Map)this.jdField_a_of_type_JavaUtilHashMap;
      paramString2 = getClass().getClassLoader().loadClass(paramString2);
      if (paramString2 != null) {
        localMap.put(paramString1, paramString2);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out com.tencent.xaction.api.IView>");
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.manager.ViewManager
 * JD-Core Version:    0.7.0.1
 */