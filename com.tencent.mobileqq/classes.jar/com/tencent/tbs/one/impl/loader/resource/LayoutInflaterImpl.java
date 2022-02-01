package com.tencent.tbs.one.impl.loader.resource;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
import com.tencent.tbs.one.impl.base.Logging;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class LayoutInflaterImpl
  extends LayoutInflater
{
  private static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
  private static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  private final Object[] mConstructorArgs = new Object[2];
  private final HashMap<String, Constructor<? extends View>> mConstructorMap = new HashMap();
  private HashMap<String, Boolean> mFilterMap;
  private ClassLoader mOverriddenClassLoader;
  
  protected LayoutInflaterImpl(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  protected LayoutInflaterImpl(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
    initialize();
  }
  
  private View createViewFromParent(String paramString, AttributeSet paramAttributeSet)
  {
    if (-1 == paramString.indexOf('.')) {
      return onCreateView(paramString, paramAttributeSet);
    }
    return createView(paramString, null, paramAttributeSet);
  }
  
  /* Error */
  private View createViewInternal(String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mConstructorArgs	[Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 41	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mConstructorArgs	[Ljava/lang/Object;
    //   13: iconst_0
    //   14: aload_0
    //   15: invokevirtual 81	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:getContext	()Landroid/content/Context;
    //   18: aastore
    //   19: aload_0
    //   20: getfield 47	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mConstructorMap	Ljava/util/HashMap;
    //   23: aload_1
    //   24: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 87	java/lang/reflect/Constructor
    //   30: astore 6
    //   32: aconst_null
    //   33: astore 7
    //   35: aload_0
    //   36: invokevirtual 91	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:getFilter	()Landroid/view/LayoutInflater$Filter;
    //   39: astore 9
    //   41: aload 6
    //   43: ifnonnull +119 -> 162
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 95	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:loadViewClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   51: astore 4
    //   53: aload 9
    //   55: ifnull +26 -> 81
    //   58: aload 4
    //   60: ifnull +21 -> 81
    //   63: aload 9
    //   65: aload 4
    //   67: invokeinterface 101 2 0
    //   72: ifne +9 -> 81
    //   75: aload_0
    //   76: aload_1
    //   77: aload_2
    //   78: invokespecial 105	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:failNotAllowed	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   81: aload 4
    //   83: getstatic 32	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:sConstructorSignature	[Ljava/lang/Class;
    //   86: invokevirtual 109	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   89: astore 5
    //   91: aload 5
    //   93: iconst_1
    //   94: invokevirtual 113	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   97: aload_0
    //   98: getfield 47	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mConstructorMap	Ljava/util/HashMap;
    //   101: aload_1
    //   102: aload 5
    //   104: invokevirtual 117	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_0
    //   109: getfield 41	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mConstructorArgs	[Ljava/lang/Object;
    //   112: astore 6
    //   114: aload 6
    //   116: iconst_1
    //   117: aload_2
    //   118: aastore
    //   119: aload 5
    //   121: aload 6
    //   123: invokevirtual 121	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 123	android/view/View
    //   129: astore 5
    //   131: getstatic 129	android/os/Build$VERSION:SDK_INT	I
    //   134: bipush 16
    //   136: if_icmplt +20 -> 156
    //   139: aload 5
    //   141: instanceof 131
    //   144: ifeq +12 -> 156
    //   147: aload 5
    //   149: checkcast 131	android/view/ViewStub
    //   152: aload_0
    //   153: invokevirtual 135	android/view/ViewStub:setLayoutInflater	(Landroid/view/LayoutInflater;)V
    //   156: aload 8
    //   158: monitorexit
    //   159: aload 5
    //   161: areturn
    //   162: aload 6
    //   164: astore 5
    //   166: aload 7
    //   168: astore 4
    //   170: aload 9
    //   172: ifnull -64 -> 108
    //   175: aload_0
    //   176: getfield 137	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mFilterMap	Ljava/util/HashMap;
    //   179: aload_1
    //   180: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast 139	java/lang/Boolean
    //   186: astore 10
    //   188: aload 10
    //   190: ifnonnull +64 -> 254
    //   193: aload_0
    //   194: aload_1
    //   195: invokespecial 95	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:loadViewClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   198: astore 4
    //   200: aload 4
    //   202: ifnull +47 -> 249
    //   205: aload 9
    //   207: aload 4
    //   209: invokeinterface 101 2 0
    //   214: ifeq +35 -> 249
    //   217: iconst_1
    //   218: istore_3
    //   219: aload_0
    //   220: getfield 137	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:mFilterMap	Ljava/util/HashMap;
    //   223: aload_1
    //   224: iload_3
    //   225: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   228: invokevirtual 117	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: iload_3
    //   233: ifne +9 -> 242
    //   236: aload_0
    //   237: aload_1
    //   238: aload_2
    //   239: invokespecial 105	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:failNotAllowed	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   242: aload 6
    //   244: astore 5
    //   246: goto -138 -> 108
    //   249: iconst_0
    //   250: istore_3
    //   251: goto -32 -> 219
    //   254: aload 6
    //   256: astore 5
    //   258: aload 7
    //   260: astore 4
    //   262: aload 10
    //   264: getstatic 147	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   267: invokevirtual 151	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
    //   270: ifeq -162 -> 108
    //   273: aload_0
    //   274: aload_1
    //   275: aload_2
    //   276: invokespecial 105	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:failNotAllowed	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   279: aload 6
    //   281: astore 5
    //   283: aload 7
    //   285: astore 4
    //   287: goto -179 -> 108
    //   290: astore 4
    //   292: new 153	android/view/InflateException
    //   295: dup
    //   296: new 155	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   303: aload_2
    //   304: invokeinterface 160 1 0
    //   309: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 166
    //   314: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_1
    //   318: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload 4
    //   326: invokespecial 172	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: astore_1
    //   330: aload_1
    //   331: getstatic 24	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:EMPTY_STACK_TRACE	[Ljava/lang/StackTraceElement;
    //   334: invokevirtual 176	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: aload 8
    //   342: monitorexit
    //   343: aload_1
    //   344: athrow
    //   345: astore 4
    //   347: new 153	android/view/InflateException
    //   350: dup
    //   351: new 155	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   358: aload_2
    //   359: invokeinterface 160 1 0
    //   364: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 178
    //   369: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_1
    //   373: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokespecial 181	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   382: astore_1
    //   383: aload_1
    //   384: getstatic 24	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:EMPTY_STACK_TRACE	[Ljava/lang/StackTraceElement;
    //   387: invokevirtual 176	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   390: aload_1
    //   391: athrow
    //   392: astore_1
    //   393: aload_1
    //   394: athrow
    //   395: new 155	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   402: aload_2
    //   403: invokeinterface 160 1 0
    //   408: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc 166
    //   413: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: astore_2
    //   417: aload_1
    //   418: ifnonnull +31 -> 449
    //   421: ldc 183
    //   423: astore_1
    //   424: new 153	android/view/InflateException
    //   427: dup
    //   428: aload_2
    //   429: aload_1
    //   430: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokespecial 181	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   439: astore_1
    //   440: aload_1
    //   441: getstatic 24	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:EMPTY_STACK_TRACE	[Ljava/lang/StackTraceElement;
    //   444: invokevirtual 176	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   447: aload_1
    //   448: athrow
    //   449: aload_1
    //   450: invokevirtual 186	java/lang/Class:getName	()Ljava/lang/String;
    //   453: astore_1
    //   454: goto -30 -> 424
    //   457: astore_1
    //   458: aload 4
    //   460: astore_1
    //   461: goto -66 -> 395
    //   464: astore_1
    //   465: aload 4
    //   467: astore_1
    //   468: goto -73 -> 395
    //   471: astore_1
    //   472: aload 4
    //   474: astore_1
    //   475: goto -80 -> 395
    //   478: astore_1
    //   479: aconst_null
    //   480: astore_1
    //   481: goto -86 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	LayoutInflaterImpl
    //   0	484	1	paramString	String
    //   0	484	2	paramAttributeSet	AttributeSet
    //   218	33	3	bool	boolean
    //   51	235	4	localObject1	Object
    //   290	35	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   345	128	4	localClassCastException	java.lang.ClassCastException
    //   89	193	5	localObject2	Object
    //   30	250	6	localObject3	Object
    //   33	251	7	localObject4	Object
    //   4	337	8	arrayOfObject	Object[]
    //   39	167	9	localFilter	LayoutInflater.Filter
    //   186	77	10	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   35	41	290	java/lang/NoSuchMethodException
    //   46	53	290	java/lang/NoSuchMethodException
    //   63	81	290	java/lang/NoSuchMethodException
    //   81	108	290	java/lang/NoSuchMethodException
    //   108	114	290	java/lang/NoSuchMethodException
    //   119	156	290	java/lang/NoSuchMethodException
    //   175	188	290	java/lang/NoSuchMethodException
    //   193	200	290	java/lang/NoSuchMethodException
    //   205	217	290	java/lang/NoSuchMethodException
    //   219	232	290	java/lang/NoSuchMethodException
    //   236	242	290	java/lang/NoSuchMethodException
    //   262	279	290	java/lang/NoSuchMethodException
    //   9	32	339	finally
    //   35	41	339	finally
    //   46	53	339	finally
    //   63	81	339	finally
    //   81	108	339	finally
    //   108	114	339	finally
    //   119	156	339	finally
    //   156	159	339	finally
    //   175	188	339	finally
    //   193	200	339	finally
    //   205	217	339	finally
    //   219	232	339	finally
    //   236	242	339	finally
    //   262	279	339	finally
    //   292	339	339	finally
    //   340	343	339	finally
    //   347	392	339	finally
    //   393	395	339	finally
    //   395	417	339	finally
    //   424	449	339	finally
    //   449	454	339	finally
    //   35	41	345	java/lang/ClassCastException
    //   46	53	345	java/lang/ClassCastException
    //   63	81	345	java/lang/ClassCastException
    //   81	108	345	java/lang/ClassCastException
    //   108	114	345	java/lang/ClassCastException
    //   119	156	345	java/lang/ClassCastException
    //   175	188	345	java/lang/ClassCastException
    //   193	200	345	java/lang/ClassCastException
    //   205	217	345	java/lang/ClassCastException
    //   219	232	345	java/lang/ClassCastException
    //   236	242	345	java/lang/ClassCastException
    //   262	279	345	java/lang/ClassCastException
    //   35	41	392	java/lang/ClassNotFoundException
    //   46	53	392	java/lang/ClassNotFoundException
    //   63	81	392	java/lang/ClassNotFoundException
    //   81	108	392	java/lang/ClassNotFoundException
    //   108	114	392	java/lang/ClassNotFoundException
    //   119	156	392	java/lang/ClassNotFoundException
    //   175	188	392	java/lang/ClassNotFoundException
    //   193	200	392	java/lang/ClassNotFoundException
    //   205	217	392	java/lang/ClassNotFoundException
    //   219	232	392	java/lang/ClassNotFoundException
    //   236	242	392	java/lang/ClassNotFoundException
    //   262	279	392	java/lang/ClassNotFoundException
    //   63	81	457	java/lang/Exception
    //   81	108	457	java/lang/Exception
    //   205	217	464	java/lang/Exception
    //   219	232	464	java/lang/Exception
    //   236	242	464	java/lang/Exception
    //   108	114	471	java/lang/Exception
    //   119	156	471	java/lang/Exception
    //   35	41	478	java/lang/Exception
    //   46	53	478	java/lang/Exception
    //   175	188	478	java/lang/Exception
    //   193	200	478	java/lang/Exception
    //   262	279	478	java/lang/Exception
  }
  
  private void failNotAllowed(String paramString, AttributeSet paramAttributeSet)
  {
    throw new InflateException(paramAttributeSet.getPositionDescription() + ": Class not allowed to be inflated " + paramString);
  }
  
  private void initialize()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      try
      {
        setFactory2(new LayoutInflaterImpl.1(this));
        return;
      }
      catch (Exception localException) {}
    }
    setFactory(new LayoutInflaterImpl.2(this));
  }
  
  private Class<? extends View> loadViewClass(String paramString)
  {
    if (this.mOverriddenClassLoader != null) {
      try
      {
        Class localClass = this.mOverriddenClassLoader.loadClass(paramString).asSubclass(View.class);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    return getClass().getClassLoader().loadClass(paramString).asSubclass(View.class);
  }
  
  public LayoutInflater cloneInContext(Context paramContext)
  {
    return new LayoutInflaterImpl(this, paramContext);
  }
  
  public View createViewImpl(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = null;
    paramView = paramContext;
    if (-1 != paramString.indexOf('.')) {}
    try
    {
      paramView = createViewInternal(paramString, paramAttributeSet);
      paramContext = paramView;
      if (paramView != null) {}
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        try
        {
          paramContext = createViewFromParent(paramString, paramAttributeSet);
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          Logging.w("Failed to create view %s", new Object[] { paramString, paramContext });
        }
        paramView = paramView;
        Logging.w("Failed to create view %s", new Object[] { paramString, paramView });
        paramView = paramContext;
      }
    }
    return paramView;
  }
  
  public void overrideClassLoader(ClassLoader paramClassLoader)
  {
    this.mOverriddenClassLoader = paramClassLoader;
  }
  
  public void setFilter(LayoutInflater.Filter paramFilter)
  {
    super.setFilter(paramFilter);
    if (paramFilter != null) {
      this.mFilterMap = new HashMap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.resource.LayoutInflaterImpl
 * JD-Core Version:    0.7.0.1
 */