package com.tencent.tbs.one.impl.c.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
import android.view.ViewStub;
import com.tencent.tbs.one.impl.a.f;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public final class a
  extends LayoutInflater
{
  private static final StackTraceElement[] b = new StackTraceElement[0];
  private static final Class<?>[] c = { Context.class, AttributeSet.class };
  public ClassLoader a;
  private final Object[] d = new Object[2];
  private final HashMap<String, Constructor<? extends View>> e = new HashMap();
  private HashMap<String, Boolean> f;
  
  protected a(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private a(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
    a();
  }
  
  private Class<? extends View> a(String paramString)
  {
    Object localObject = this.a;
    if (localObject != null) {}
    try
    {
      localObject = ((ClassLoader)localObject).loadClass(paramString).asSubclass(View.class);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label22:
      break label22;
    }
    return getClass().getClassLoader().loadClass(paramString).asSubclass(View.class);
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      setFactory2(new a.1(this));
      return;
    }
    catch (Exception localException)
    {
      label21:
      break label21;
    }
    setFactory(new a.2(this));
  }
  
  private View b(String paramString, AttributeSet paramAttributeSet)
  {
    synchronized (this.d)
    {
      localObject1 = this.d;
      localObject2 = getContext();
      boolean bool2 = false;
      localObject1[0] = localObject2;
      Constructor localConstructor = (Constructor)this.e.get(paramString);
      Object localObject5 = null;
      Object localObject4 = null;
      localObject1 = localObject5;
      try
      {
        LayoutInflater.Filter localFilter = getFilter();
        if (localConstructor == null)
        {
          localObject1 = localObject5;
          localObject2 = a(paramString);
          if ((localFilter != null) && (localObject2 != null))
          {
            localObject1 = localObject2;
            if (!localFilter.onLoadClass((Class)localObject2))
            {
              localObject1 = localObject2;
              c(paramString, paramAttributeSet);
            }
          }
          localObject1 = localObject2;
          localObject3 = ((Class)localObject2).getConstructor(c);
          localObject1 = localObject2;
          ((Constructor)localObject3).setAccessible(true);
          localObject1 = localObject2;
          this.e.put(paramString, localObject3);
        }
        else
        {
          localObject3 = localConstructor;
          localObject2 = localObject4;
          if (localFilter != null)
          {
            localObject1 = localObject5;
            Boolean localBoolean = (Boolean)this.f.get(paramString);
            if (localBoolean == null)
            {
              localObject1 = localObject5;
              localObject4 = a(paramString);
              boolean bool1 = bool2;
              if (localObject4 != null)
              {
                bool1 = bool2;
                localObject1 = localObject4;
                if (localFilter.onLoadClass((Class)localObject4)) {
                  bool1 = true;
                }
              }
              localObject1 = localObject4;
              this.f.put(paramString, Boolean.valueOf(bool1));
              localObject3 = localConstructor;
              localObject2 = localObject4;
              if (!bool1)
              {
                localObject1 = localObject4;
                c(paramString, paramAttributeSet);
                localObject3 = localConstructor;
                localObject2 = localObject4;
              }
            }
            else
            {
              localObject3 = localConstructor;
              localObject2 = localObject4;
              localObject1 = localObject5;
              if (localBoolean.equals(Boolean.FALSE))
              {
                localObject1 = localObject5;
                c(paramString, paramAttributeSet);
                localObject2 = localObject4;
                localObject3 = localConstructor;
              }
            }
          }
        }
        localObject1 = localObject2;
        localObject4 = this.d;
        localObject4[1] = paramAttributeSet;
        localObject1 = localObject2;
        Object localObject3 = (View)((Constructor)localObject3).newInstance((Object[])localObject4);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof ViewStub))
          {
            localObject1 = localObject2;
            ((ViewStub)localObject3).setLayoutInflater(this);
          }
        }
        return localObject3;
      }
      catch (ClassNotFoundException paramString)
      {
        throw paramString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject1).append(": Class is not a View ");
        ((StringBuilder)localObject1).append(paramString);
        paramString = new InflateException(((StringBuilder)localObject1).toString());
        paramString.setStackTrace(b);
        throw paramString;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject2).append(": Error inflating class ");
        ((StringBuilder)localObject2).append(paramString);
        paramString = new InflateException(((StringBuilder)localObject2).toString(), localNoSuchMethodException);
        paramString.setStackTrace(b);
        throw paramString;
        paramString = finally;
        throw paramString;
      }
      catch (ClassCastException localClassCastException)
      {
        break label468;
      }
      catch (Exception paramString)
      {
        label390:
        break label390;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
      ((StringBuilder)localObject2).append(": Error inflating class ");
      if (localObject1 == null) {
        paramString = "<unknown>";
      } else {
        paramString = ((Class)localObject1).getName();
      }
      ((StringBuilder)localObject2).append(paramString);
      paramString = new InflateException(((StringBuilder)localObject2).toString());
      paramString.setStackTrace(b);
      throw paramString;
    }
  }
  
  private static void c(String paramString, AttributeSet paramAttributeSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAttributeSet.getPositionDescription());
    localStringBuilder.append(": Class not allowed to be inflated ");
    localStringBuilder.append(paramString);
    throw new InflateException(localStringBuilder.toString());
  }
  
  public final View a(String paramString, AttributeSet paramAttributeSet)
  {
    View localView2;
    if (-1 != paramString.indexOf('.')) {
      try
      {
        View localView1 = b(paramString, paramAttributeSet);
      }
      catch (Throwable localThrowable)
      {
        f.b("Failed to create view %s", new Object[] { paramString, localThrowable });
      }
    } else {
      localView2 = null;
    }
    if (localView2 == null) {
      try
      {
        if (-1 == paramString.indexOf('.'))
        {
          paramAttributeSet = onCreateView(paramString, paramAttributeSet);
          paramString = paramAttributeSet;
        }
        else
        {
          paramAttributeSet = createView(paramString, null, paramAttributeSet);
          paramString = paramAttributeSet;
        }
        return paramString;
      }
      catch (Throwable paramAttributeSet)
      {
        f.b("Failed to create view %s", new Object[] { paramString, paramAttributeSet });
      }
    }
    return localView2;
  }
  
  public final LayoutInflater cloneInContext(Context paramContext)
  {
    return new a(this, paramContext);
  }
  
  public final void setFilter(LayoutInflater.Filter paramFilter)
  {
    super.setFilter(paramFilter);
    if (paramFilter != null) {
      this.f = new HashMap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.a
 * JD-Core Version:    0.7.0.1
 */