package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.ViewStub;
import com.tencent.qcircle.shadow.core.runtime.skin.entity.AttrFactory;
import com.tencent.qcircle.shadow.core.runtime.skin.entity.SkinAttr;
import com.tencent.qcircle.shadow.core.runtime.skin.entity.SkinItem;
import com.tencent.qcircle.shadow.core.runtime.skin.loader.SkinManager;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShadowFactory2
  implements LayoutInflater.Factory2
{
  private static final ClassLoader BOOT_CLASS_LOADER = LayoutInflater.class.getClassLoader();
  private static final String SKIN_PREFIX = "qcircle_skin_";
  private static final String TAG = "ShadowFactory2";
  private static final HashMap<String, String> sCreateSystemMap = new HashMap();
  private final Object[] mConstructorArgs = new Object[2];
  private final Class<?>[] mConstructorSignature = { Context.class, AttributeSet.class };
  private LayoutInflater mLayoutInflater;
  private String mPartKey;
  private HashMap<View, SkinItem> mSkinMap;
  private List<SkinAttr> mViewAttrs = new ArrayList();
  private final HashMap<String, Constructor<? extends View>> sConstructorMap = new HashMap();
  
  public ShadowFactory2(String paramString, LayoutInflater paramLayoutInflater, HashMap<View, SkinItem> paramHashMap)
  {
    this.mPartKey = paramString;
    this.mLayoutInflater = paramLayoutInflater;
    this.mSkinMap = paramHashMap;
  }
  
  private void applyViewAttrs(View paramView)
  {
    Iterator localIterator = this.mViewAttrs.iterator();
    while (localIterator.hasNext()) {
      ((SkinAttr)localIterator.next()).apply(paramView);
    }
  }
  
  private View createCustomView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return createCustomView(paramString, null, paramContext, paramAttributeSet);
  }
  
  private View createCustomView(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mPartKey);
    ((StringBuilder)localObject1).append(paramString1);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2 = (Constructor)this.sConstructorMap.get(str);
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!verifyClassLoader(paramContext, (Constructor)localObject2))
      {
        this.sConstructorMap.remove(str);
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = paramContext.getClassLoader();
      localObject1 = paramString1;
      if (paramString2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(paramString1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = ((ClassLoader)localObject2).loadClass((String)localObject1).asSubclass(View.class).getConstructor(this.mConstructorSignature);
      ((Constructor)localObject2).setAccessible(true);
      this.sConstructorMap.put(str, localObject2);
      paramString1 = this.mConstructorArgs[0];
      if (this.mConstructorArgs[0] == null) {
        this.mConstructorArgs[0] = paramContext;
      }
      paramString2 = this.mConstructorArgs;
      paramString2[1] = paramAttributeSet;
      paramContext = (View)((Constructor)localObject2).newInstance(paramString2);
      if (((paramContext instanceof ViewStub)) && (Build.VERSION.SDK_INT >= 16)) {
        ((ViewStub)paramContext).setLayoutInflater(this.mLayoutInflater.cloneInContext((Context)paramString2[0]));
      }
      this.mConstructorArgs[0] = paramString1;
      return paramContext;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  private boolean parseSkinAttr(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mViewAttrs.clear();
    boolean bool = parseSkinAttr(paramContext, paramAttributeSet, "TextColorAttr", "textColor");
    if (parseSkinAttr(paramContext, paramAttributeSet, "SrcAttr", "src")) {
      bool = true;
    }
    if (parseSkinAttr(paramContext, paramAttributeSet, "BackgroundAttr", "background")) {
      bool = true;
    }
    return bool;
  }
  
  private boolean parseSkinAttr(Context paramContext, AttributeSet paramAttributeSet, String paramString1, String paramString2)
  {
    int i = 0;
    while (i < paramAttributeSet.getAttributeCount())
    {
      Object localObject = paramAttributeSet.getAttributeValue(i);
      if ((paramString2.equals(paramAttributeSet.getAttributeName(i))) && (((String)localObject).startsWith("@"))) {
        try
        {
          int j = Integer.parseInt(((String)localObject).substring(1));
          localObject = paramContext.getResources().getResourceEntryName(j);
          if (((String)localObject).startsWith("qcircle_skin_"))
          {
            localObject = AttrFactory.createAttr(paramString1, j, (String)localObject);
            if (localObject != null)
            {
              this.mViewAttrs.add(localObject);
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    return false;
  }
  
  private final boolean verifyClassLoader(Context paramContext, Constructor<? extends View> paramConstructor)
  {
    ClassLoader localClassLoader = paramConstructor.getDeclaringClass().getClassLoader();
    if (localClassLoader == BOOT_CLASS_LOADER) {
      return true;
    }
    paramContext = paramContext.getClassLoader();
    do
    {
      if (localClassLoader == paramContext) {
        return true;
      }
      paramConstructor = paramContext.getParent();
      paramContext = paramConstructor;
    } while (paramConstructor != null);
    return false;
  }
  
  public void addSkinAttr(View paramView, List<SkinAttr> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = this.mSkinMap;
      if (localObject == null)
      {
        Log.e(TAG, "addSkinAttr error  skinMap is null");
        return;
      }
      localObject = (SkinItem)((HashMap)localObject).get(paramView);
      if (localObject == null)
      {
        paramList = new SkinItem(paramView, paramList);
        this.mSkinMap.put(paramView, paramList);
        paramView = paramList;
      }
      else
      {
        ((SkinItem)localObject).addItem(paramList);
        paramView = (View)localObject;
      }
      paramView.apply();
    }
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool = paramString.contains(".");
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    if (bool)
    {
      if (sCreateSystemMap.get(paramString) == null) {
        sCreateSystemMap.put(paramString, this.mPartKey);
      }
      paramView = localObject4;
      try
      {
        localObject1 = createCustomView(paramString, paramContext, paramAttributeSet);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          break label411;
        }
        paramView = (View)localObject1;
        paramString = (String)localObject1;
        if (!parseSkinAttr(paramContext, paramAttributeSet)) {
          break label411;
        }
        paramView = (View)localObject1;
        addSkinAttr((View)localObject1, this.mViewAttrs);
        paramView = (View)localObject1;
        paramString = (String)localObject1;
        if (SkinManager.getsInstance().getPackageName() == null) {
          break label411;
        }
        paramView = (View)localObject1;
        applyViewAttrs((View)localObject1);
        return localObject1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return paramView;
      }
    }
    else
    {
      if ((paramContext instanceof PluginActivity))
      {
        if (!parseSkinAttr(paramContext, paramAttributeSet)) {
          return ((PluginActivity)paramContext).onCreateView(paramView, paramString, paramContext, paramAttributeSet);
        }
      }
      else if (!parseSkinAttr(paramContext, paramAttributeSet)) {
        return null;
      }
      paramView = localObject2;
    }
    for (;;)
    {
      try
      {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28)
        {
          paramContext = (Context)localObject1;
          paramView = localObject2;
          if ("View".equals(paramString))
          {
            paramView = localObject2;
            paramContext = this.mLayoutInflater.createView(paramString, "android.mView.", paramAttributeSet);
          }
          paramView = paramContext;
          if (paramContext == null)
          {
            paramView = paramContext;
            paramContext = this.mLayoutInflater.createView(paramString, "android.widget.", paramAttributeSet);
            paramView = paramContext;
          }
          localObject1 = paramView;
          if (paramView == null)
          {
            paramString = this.mLayoutInflater.createView(paramString, "android.webkit.", paramAttributeSet);
            paramView = paramString;
            break label413;
          }
        }
        else
        {
          localObject1 = localObject3;
          paramView = localObject2;
          if ("View".equals(paramString))
          {
            paramView = localObject2;
            localObject1 = createCustomView(paramString, "android.view.", paramContext, paramAttributeSet);
          }
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            paramView = (View)localObject1;
            localObject1 = createCustomView(paramString, "android.widget.", paramContext, paramAttributeSet);
            paramView = (View)localObject1;
          }
          localObject1 = paramView;
          if (paramView == null)
          {
            paramString = createCustomView(paramString, "android.webkit.", paramContext, paramAttributeSet);
            paramView = paramString;
            break label413;
          }
        }
        paramView = (View)localObject1;
        addSkinAttr((View)localObject1, this.mViewAttrs);
        paramString = (String)localObject1;
        if (localObject1 != null)
        {
          paramView = (View)localObject1;
          paramString = (String)localObject1;
          if (SkinManager.getsInstance().getPackageName() != null)
          {
            paramView = (View)localObject1;
            applyViewAttrs((View)localObject1);
            return localObject1;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = paramView;
      }
      label411:
      return paramString;
      label413:
      localObject1 = paramView;
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowFactory2
 * JD-Core Version:    0.7.0.1
 */