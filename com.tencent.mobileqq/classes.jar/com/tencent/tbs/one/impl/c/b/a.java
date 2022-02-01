package com.tencent.tbs.one.impl.c.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
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
    if (this.a != null) {
      try
      {
        Class localClass = this.a.loadClass(paramString).asSubclass(View.class);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    return getClass().getClassLoader().loadClass(paramString).asSubclass(View.class);
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      try
      {
        setFactory2(new a.1(this));
        return;
      }
      catch (Exception localException) {}
    }
    setFactory(new a.2(this));
  }
  
  /* Error */
  private View b(String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/tbs/one/impl/c/b/a:d	[Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 41	com/tencent/tbs/one/impl/c/b/a:d	[Ljava/lang/Object;
    //   13: iconst_0
    //   14: aload_0
    //   15: invokevirtual 111	com/tencent/tbs/one/impl/c/b/a:getContext	()Landroid/content/Context;
    //   18: aastore
    //   19: aload_0
    //   20: getfield 47	com/tencent/tbs/one/impl/c/b/a:e	Ljava/util/HashMap;
    //   23: aload_1
    //   24: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 117	java/lang/reflect/Constructor
    //   30: astore 6
    //   32: aconst_null
    //   33: astore 7
    //   35: aload_0
    //   36: invokevirtual 121	com/tencent/tbs/one/impl/c/b/a:getFilter	()Landroid/view/LayoutInflater$Filter;
    //   39: astore 9
    //   41: aload 6
    //   43: ifnonnull +118 -> 161
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 123	com/tencent/tbs/one/impl/c/b/a:a	(Ljava/lang/String;)Ljava/lang/Class;
    //   51: astore 4
    //   53: aload 9
    //   55: ifnull +25 -> 80
    //   58: aload 4
    //   60: ifnull +20 -> 80
    //   63: aload 9
    //   65: aload 4
    //   67: invokeinterface 129 2 0
    //   72: ifne +8 -> 80
    //   75: aload_1
    //   76: aload_2
    //   77: invokestatic 132	com/tencent/tbs/one/impl/c/b/a:c	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   80: aload 4
    //   82: getstatic 32	com/tencent/tbs/one/impl/c/b/a:c	[Ljava/lang/Class;
    //   85: invokevirtual 136	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   88: astore 5
    //   90: aload 5
    //   92: iconst_1
    //   93: invokevirtual 140	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   96: aload_0
    //   97: getfield 47	com/tencent/tbs/one/impl/c/b/a:e	Ljava/util/HashMap;
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_0
    //   108: getfield 41	com/tencent/tbs/one/impl/c/b/a:d	[Ljava/lang/Object;
    //   111: astore 6
    //   113: aload 6
    //   115: iconst_1
    //   116: aload_2
    //   117: aastore
    //   118: aload 5
    //   120: aload 6
    //   122: invokevirtual 148	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 64	android/view/View
    //   128: astore 5
    //   130: getstatic 86	android/os/Build$VERSION:SDK_INT	I
    //   133: bipush 16
    //   135: if_icmplt +20 -> 155
    //   138: aload 5
    //   140: instanceof 150
    //   143: ifeq +12 -> 155
    //   146: aload 5
    //   148: checkcast 150	android/view/ViewStub
    //   151: aload_0
    //   152: invokevirtual 154	android/view/ViewStub:setLayoutInflater	(Landroid/view/LayoutInflater;)V
    //   155: aload 8
    //   157: monitorexit
    //   158: aload 5
    //   160: areturn
    //   161: aload 6
    //   163: astore 5
    //   165: aload 7
    //   167: astore 4
    //   169: aload 9
    //   171: ifnull -64 -> 107
    //   174: aload_0
    //   175: getfield 156	com/tencent/tbs/one/impl/c/b/a:f	Ljava/util/HashMap;
    //   178: aload_1
    //   179: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: checkcast 158	java/lang/Boolean
    //   185: astore 10
    //   187: aload 10
    //   189: ifnonnull +63 -> 252
    //   192: aload_0
    //   193: aload_1
    //   194: invokespecial 123	com/tencent/tbs/one/impl/c/b/a:a	(Ljava/lang/String;)Ljava/lang/Class;
    //   197: astore 4
    //   199: aload 4
    //   201: ifnull +46 -> 247
    //   204: aload 9
    //   206: aload 4
    //   208: invokeinterface 129 2 0
    //   213: ifeq +34 -> 247
    //   216: iconst_1
    //   217: istore_3
    //   218: aload_0
    //   219: getfield 156	com/tencent/tbs/one/impl/c/b/a:f	Ljava/util/HashMap;
    //   222: aload_1
    //   223: iload_3
    //   224: invokestatic 162	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   227: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: iload_3
    //   232: ifne +8 -> 240
    //   235: aload_1
    //   236: aload_2
    //   237: invokestatic 132	com/tencent/tbs/one/impl/c/b/a:c	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   240: aload 6
    //   242: astore 5
    //   244: goto -137 -> 107
    //   247: iconst_0
    //   248: istore_3
    //   249: goto -31 -> 218
    //   252: aload 6
    //   254: astore 5
    //   256: aload 7
    //   258: astore 4
    //   260: aload 10
    //   262: getstatic 166	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   265: invokevirtual 170	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
    //   268: ifeq -161 -> 107
    //   271: aload_1
    //   272: aload_2
    //   273: invokestatic 132	com/tencent/tbs/one/impl/c/b/a:c	(Ljava/lang/String;Landroid/util/AttributeSet;)V
    //   276: aload 6
    //   278: astore 5
    //   280: aload 7
    //   282: astore 4
    //   284: goto -177 -> 107
    //   287: astore 4
    //   289: new 172	android/view/InflateException
    //   292: dup
    //   293: new 174	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   300: aload_2
    //   301: invokeinterface 179 1 0
    //   306: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 185
    //   311: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_1
    //   315: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: aload 4
    //   323: invokespecial 191	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: astore_1
    //   327: aload_1
    //   328: getstatic 24	com/tencent/tbs/one/impl/c/b/a:b	[Ljava/lang/StackTraceElement;
    //   331: invokevirtual 195	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: aload 8
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: astore 4
    //   344: new 172	android/view/InflateException
    //   347: dup
    //   348: new 174	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   355: aload_2
    //   356: invokeinterface 179 1 0
    //   361: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 197
    //   366: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_1
    //   370: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokespecial 200	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   379: astore_1
    //   380: aload_1
    //   381: getstatic 24	com/tencent/tbs/one/impl/c/b/a:b	[Ljava/lang/StackTraceElement;
    //   384: invokevirtual 195	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   387: aload_1
    //   388: athrow
    //   389: astore_1
    //   390: aload_1
    //   391: athrow
    //   392: new 174	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   399: aload_2
    //   400: invokeinterface 179 1 0
    //   405: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc 185
    //   410: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: astore_2
    //   414: aload_1
    //   415: ifnonnull +31 -> 446
    //   418: ldc 202
    //   420: astore_1
    //   421: new 172	android/view/InflateException
    //   424: dup
    //   425: aload_2
    //   426: aload_1
    //   427: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokespecial 200	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   436: astore_1
    //   437: aload_1
    //   438: getstatic 24	com/tencent/tbs/one/impl/c/b/a:b	[Ljava/lang/StackTraceElement;
    //   441: invokevirtual 195	android/view/InflateException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   444: aload_1
    //   445: athrow
    //   446: aload_1
    //   447: invokevirtual 205	java/lang/Class:getName	()Ljava/lang/String;
    //   450: astore_1
    //   451: goto -30 -> 421
    //   454: astore_1
    //   455: aload 4
    //   457: astore_1
    //   458: goto -66 -> 392
    //   461: astore_1
    //   462: aload 4
    //   464: astore_1
    //   465: goto -73 -> 392
    //   468: astore_1
    //   469: aload 4
    //   471: astore_1
    //   472: goto -80 -> 392
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -86 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	a
    //   0	481	1	paramString	String
    //   0	481	2	paramAttributeSet	AttributeSet
    //   217	32	3	bool	boolean
    //   51	232	4	localObject1	Object
    //   287	35	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   342	128	4	localClassCastException	java.lang.ClassCastException
    //   88	191	5	localObject2	Object
    //   30	247	6	localObject3	Object
    //   33	248	7	localObject4	Object
    //   4	334	8	arrayOfObject	Object[]
    //   39	166	9	localFilter	LayoutInflater.Filter
    //   185	76	10	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   35	41	287	java/lang/NoSuchMethodException
    //   46	53	287	java/lang/NoSuchMethodException
    //   63	80	287	java/lang/NoSuchMethodException
    //   80	107	287	java/lang/NoSuchMethodException
    //   107	113	287	java/lang/NoSuchMethodException
    //   118	155	287	java/lang/NoSuchMethodException
    //   174	187	287	java/lang/NoSuchMethodException
    //   192	199	287	java/lang/NoSuchMethodException
    //   204	216	287	java/lang/NoSuchMethodException
    //   218	231	287	java/lang/NoSuchMethodException
    //   235	240	287	java/lang/NoSuchMethodException
    //   260	276	287	java/lang/NoSuchMethodException
    //   9	32	336	finally
    //   35	41	336	finally
    //   46	53	336	finally
    //   63	80	336	finally
    //   80	107	336	finally
    //   107	113	336	finally
    //   118	155	336	finally
    //   155	158	336	finally
    //   174	187	336	finally
    //   192	199	336	finally
    //   204	216	336	finally
    //   218	231	336	finally
    //   235	240	336	finally
    //   260	276	336	finally
    //   289	336	336	finally
    //   337	340	336	finally
    //   344	389	336	finally
    //   390	392	336	finally
    //   392	414	336	finally
    //   421	446	336	finally
    //   446	451	336	finally
    //   35	41	342	java/lang/ClassCastException
    //   46	53	342	java/lang/ClassCastException
    //   63	80	342	java/lang/ClassCastException
    //   80	107	342	java/lang/ClassCastException
    //   107	113	342	java/lang/ClassCastException
    //   118	155	342	java/lang/ClassCastException
    //   174	187	342	java/lang/ClassCastException
    //   192	199	342	java/lang/ClassCastException
    //   204	216	342	java/lang/ClassCastException
    //   218	231	342	java/lang/ClassCastException
    //   235	240	342	java/lang/ClassCastException
    //   260	276	342	java/lang/ClassCastException
    //   35	41	389	java/lang/ClassNotFoundException
    //   46	53	389	java/lang/ClassNotFoundException
    //   63	80	389	java/lang/ClassNotFoundException
    //   80	107	389	java/lang/ClassNotFoundException
    //   107	113	389	java/lang/ClassNotFoundException
    //   118	155	389	java/lang/ClassNotFoundException
    //   174	187	389	java/lang/ClassNotFoundException
    //   192	199	389	java/lang/ClassNotFoundException
    //   204	216	389	java/lang/ClassNotFoundException
    //   218	231	389	java/lang/ClassNotFoundException
    //   235	240	389	java/lang/ClassNotFoundException
    //   260	276	389	java/lang/ClassNotFoundException
    //   63	80	454	java/lang/Exception
    //   80	107	454	java/lang/Exception
    //   204	216	461	java/lang/Exception
    //   218	231	461	java/lang/Exception
    //   235	240	461	java/lang/Exception
    //   107	113	468	java/lang/Exception
    //   118	155	468	java/lang/Exception
    //   35	41	475	java/lang/Exception
    //   46	53	475	java/lang/Exception
    //   174	187	475	java/lang/Exception
    //   192	199	475	java/lang/Exception
    //   260	276	475	java/lang/Exception
  }
  
  private static void c(String paramString, AttributeSet paramAttributeSet)
  {
    throw new InflateException(paramAttributeSet.getPositionDescription() + ": Class not allowed to be inflated " + paramString);
  }
  
  /* Error */
  public final View a(String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: iconst_m1
    //   7: aload_1
    //   8: bipush 46
    //   10: invokevirtual 215	java/lang/String:indexOf	(I)I
    //   13: if_icmpeq +10 -> 23
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokespecial 217	com/tencent/tbs/one/impl/c/b/a:b	(Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   22: astore_3
    //   23: aload_3
    //   24: astore 4
    //   26: aload_3
    //   27: ifnonnull +21 -> 48
    //   30: iconst_m1
    //   31: aload_1
    //   32: bipush 46
    //   34: invokevirtual 215	java/lang/String:indexOf	(I)I
    //   37: if_icmpne +38 -> 75
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 220	com/tencent/tbs/one/impl/c/b/a:onCreateView	(Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   46: astore 4
    //   48: aload 4
    //   50: areturn
    //   51: astore_3
    //   52: ldc 222
    //   54: iconst_2
    //   55: anewarray 39	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_3
    //   65: aastore
    //   66: invokestatic 227	com/tencent/tbs/one/impl/a/f:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload 4
    //   71: astore_3
    //   72: goto -49 -> 23
    //   75: aload_0
    //   76: aload_1
    //   77: aconst_null
    //   78: aload_2
    //   79: invokevirtual 231	com/tencent/tbs/one/impl/c/b/a:createView	(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   82: astore_2
    //   83: aload_2
    //   84: areturn
    //   85: astore_2
    //   86: ldc 222
    //   88: iconst_2
    //   89: anewarray 39	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_2
    //   99: aastore
    //   100: invokestatic 227	com/tencent/tbs/one/impl/a/f:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   0	105	1	paramString	String
    //   0	105	2	paramAttributeSet	AttributeSet
    //   5	22	3	localObject1	Object
    //   51	14	3	localThrowable	java.lang.Throwable
    //   71	33	3	localObject2	Object
    //   1	69	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	23	51	java/lang/Throwable
    //   30	48	85	java/lang/Throwable
    //   75	83	85	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.a
 * JD-Core Version:    0.7.0.1
 */