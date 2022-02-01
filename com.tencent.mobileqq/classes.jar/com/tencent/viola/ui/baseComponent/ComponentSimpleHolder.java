package com.tencent.viola.ui.baseComponent;

import android.util.Pair;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;
import java.util.Set;

public class ComponentSimpleHolder
  implements IFComponentHolder
{
  public static final String TAG = "ComponentSimpleHolder";
  private final Class<? extends VComponent> mClz;
  private ComponentCreator mCreator;
  private Map<String, Invoker> mMethodInvokers;
  private Map<String, Invoker> mPropertyInvokers;
  private String mRefreshRef;
  
  public ComponentSimpleHolder(Class<? extends VComponent> paramClass)
  {
    this(paramClass, new ComponentSimpleHolder.ClazzComponentCreator(paramClass));
  }
  
  public ComponentSimpleHolder(Class<? extends VComponent> paramClass, ComponentCreator paramComponentCreator)
  {
    this.mClz = paramClass;
    this.mCreator = paramComponentCreator;
  }
  
  private void generate()
  {
    try
    {
      ViolaLogUtils.d("ComponentSimpleHolder", "Generate Component:" + this.mClz.getSimpleName());
      Pair localPair = getMethods(this.mClz);
      this.mPropertyInvokers = ((Map)localPair.first);
      this.mMethodInvokers = ((Map)localPair.second);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static Pair<Map<String, Invoker>, Map<String, Invoker>> getMethods(Class paramClass)
  {
    // Byte code:
    //   0: new 92	java/util/HashMap
    //   3: dup
    //   4: invokespecial 93	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: new 92	java/util/HashMap
    //   12: dup
    //   13: invokespecial 93	java/util/HashMap:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 96	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   22: astore 8
    //   24: aload 8
    //   26: arraylength
    //   27: istore_3
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_1
    //   31: iload_3
    //   32: if_icmpge +143 -> 175
    //   35: aload 8
    //   37: iload_1
    //   38: aaload
    //   39: astore 9
    //   41: aload 9
    //   43: invokevirtual 102	java/lang/reflect/Method:getDeclaredAnnotations	()[Ljava/lang/annotation/Annotation;
    //   46: astore_0
    //   47: aload_0
    //   48: arraylength
    //   49: istore 4
    //   51: iconst_0
    //   52: istore_2
    //   53: goto +138 -> 191
    //   56: aload 5
    //   58: instanceof 104
    //   61: ifeq +34 -> 95
    //   64: aload 6
    //   66: aload 5
    //   68: checkcast 104	com/tencent/viola/annotation/VComponentProp
    //   71: invokeinterface 107 1 0
    //   76: new 109	com/tencent/viola/bridge/MethodInvoker
    //   79: dup
    //   80: aload 9
    //   82: iconst_1
    //   83: invokespecial 112	com/tencent/viola/bridge/MethodInvoker:<init>	(Ljava/lang/reflect/Method;Z)V
    //   86: invokeinterface 116 3 0
    //   91: pop
    //   92: goto +122 -> 214
    //   95: aload 5
    //   97: instanceof 118
    //   100: ifeq +107 -> 207
    //   103: aload 5
    //   105: checkcast 118	com/tencent/viola/annotation/JSMethod
    //   108: astore 10
    //   110: aload 10
    //   112: invokeinterface 121 1 0
    //   117: astore 5
    //   119: aload 5
    //   121: astore_0
    //   122: ldc 123
    //   124: aload 5
    //   126: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifeq +9 -> 138
    //   132: aload 9
    //   134: invokevirtual 132	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   137: astore_0
    //   138: aload 7
    //   140: aload_0
    //   141: new 109	com/tencent/viola/bridge/MethodInvoker
    //   144: dup
    //   145: aload 9
    //   147: aload 10
    //   149: invokeinterface 136 1 0
    //   154: invokespecial 112	com/tencent/viola/bridge/MethodInvoker:<init>	(Ljava/lang/reflect/Method;Z)V
    //   157: invokeinterface 116 3 0
    //   162: pop
    //   163: goto +51 -> 214
    //   166: astore_0
    //   167: goto +47 -> 214
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 139	java/lang/IndexOutOfBoundsException:printStackTrace	()V
    //   175: new 71	android/util/Pair
    //   178: dup
    //   179: aload 6
    //   181: aload 7
    //   183: invokespecial 142	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   186: areturn
    //   187: astore_0
    //   188: goto +26 -> 214
    //   191: iload_2
    //   192: iload 4
    //   194: if_icmpge +20 -> 214
    //   197: aload_0
    //   198: iload_2
    //   199: aaload
    //   200: astore 5
    //   202: aload 5
    //   204: ifnonnull -148 -> 56
    //   207: iload_2
    //   208: iconst_1
    //   209: iadd
    //   210: istore_2
    //   211: goto -20 -> 191
    //   214: iload_1
    //   215: iconst_1
    //   216: iadd
    //   217: istore_1
    //   218: goto -188 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramClass	Class
    //   29	189	1	i	int
    //   52	159	2	j	int
    //   27	6	3	k	int
    //   49	146	4	m	int
    //   56	147	5	str	String
    //   7	173	6	localHashMap1	java.util.HashMap
    //   16	166	7	localHashMap2	java.util.HashMap
    //   22	14	8	arrayOfMethod	java.lang.reflect.Method[]
    //   39	107	9	localMethod	java.lang.reflect.Method
    //   108	40	10	localJSMethod	com.tencent.viola.annotation.JSMethod
    // Exception table:
    //   from	to	target	type
    //   41	51	166	java/lang/ArrayIndexOutOfBoundsException
    //   56	92	166	java/lang/ArrayIndexOutOfBoundsException
    //   95	119	166	java/lang/ArrayIndexOutOfBoundsException
    //   122	138	166	java/lang/ArrayIndexOutOfBoundsException
    //   138	163	166	java/lang/ArrayIndexOutOfBoundsException
    //   18	28	170	java/lang/IndexOutOfBoundsException
    //   41	51	170	java/lang/IndexOutOfBoundsException
    //   56	92	170	java/lang/IndexOutOfBoundsException
    //   95	119	170	java/lang/IndexOutOfBoundsException
    //   122	138	170	java/lang/IndexOutOfBoundsException
    //   138	163	170	java/lang/IndexOutOfBoundsException
    //   41	51	187	java/lang/IncompatibleClassChangeError
    //   56	92	187	java/lang/IncompatibleClassChangeError
    //   95	119	187	java/lang/IncompatibleClassChangeError
    //   122	138	187	java/lang/IncompatibleClassChangeError
    //   138	163	187	java/lang/IncompatibleClassChangeError
  }
  
  public VComponent createInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    paramViolaInstance = this.mCreator.createInstance(paramViolaInstance, paramDomObject, paramVComponentContainer);
    if ((paramViolaInstance instanceof VRefresh)) {
      ViolaBridgeManager.getInstance().setRefreshRef(paramViolaInstance.getDomObject().getRef());
    }
    paramViolaInstance.bindHolder(this);
    return paramViolaInstance;
  }
  
  public Invoker getMethodInvoker(String paramString)
  {
    if (this.mMethodInvokers == null) {
      generate();
    }
    return (Invoker)this.mMethodInvokers.get(paramString);
  }
  
  public String[] getMethods()
  {
    if (this.mMethodInvokers == null) {
      generate();
    }
    Set localSet = this.mMethodInvokers.keySet();
    return (String[])localSet.toArray(new String[localSet.size()]);
  }
  
  public Invoker getPropertyInvoker(String paramString)
  {
    try
    {
      if (this.mPropertyInvokers == null) {
        generate();
      }
      paramString = (Invoker)this.mPropertyInvokers.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentSimpleHolder
 * JD-Core Version:    0.7.0.1
 */