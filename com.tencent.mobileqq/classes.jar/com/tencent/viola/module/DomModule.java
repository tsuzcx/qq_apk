package com.tencent.viola.module;

import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.RenderAction;
import org.json.JSONArray;

public class DomModule
  extends BaseModule
{
  public static final String DOM_MODULE_NAME = "dom";
  public static final String METHOD_ADD_ELEMENT = "addElement";
  public static final String METHOD_CREATE_BODY = "createBody";
  public static final String METHOD_REMOVE_ELEMENT = "removeElement";
  public static final String METHOD_UPDATE_ELEMENT = "updateElement";
  
  public boolean invokeComponetMethod(String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray)
  {
    paramString1 = ViolaSDKManager.getInstance().getRenderManager().getComponent(paramString1, paramString2);
    if (paramString1 == null) {
      return false;
    }
    ViolaSDKManager.getInstance().postOnUiThread(new DomModule.1(this, paramString1, paramString3, paramJSONArray));
    return true;
  }
  
  /* Error */
  public boolean invokeDomMethod(String paramString, java.lang.Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 62	java/lang/String:hashCode	()I
    //   6: lookupswitch	default:+42->48, -467344936:+102->108, 245397275:+88->94, 1136179699:+116->122, 1368682686:+76->82
    //   49: istore_3
    //   50: iload_3
    //   51: tableswitch	default:+29 -> 80, 0:+85->136, 1:+152->203, 2:+231->282, 3:+285->336
    //   81: ireturn
    //   82: aload_1
    //   83: ldc 14
    //   85: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq -40 -> 48
    //   91: goto -41 -> 50
    //   94: aload_1
    //   95: ldc 11
    //   97: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq -52 -> 48
    //   103: iconst_1
    //   104: istore_3
    //   105: goto -55 -> 50
    //   108: aload_1
    //   109: ldc 17
    //   111: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifeq -66 -> 48
    //   117: iconst_2
    //   118: istore_3
    //   119: goto -69 -> 50
    //   122: aload_1
    //   123: ldc 20
    //   125: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq -80 -> 48
    //   131: iconst_3
    //   132: istore_3
    //   133: goto -83 -> 50
    //   136: aload_0
    //   137: invokevirtual 70	com/tencent/viola/module/DomModule:getViolaInstance	()Lcom/tencent/viola/core/ViolaInstance;
    //   140: ifnull +10 -> 150
    //   143: aload_0
    //   144: invokevirtual 70	com/tencent/viola/module/DomModule:getViolaInstance	()Lcom/tencent/viola/core/ViolaInstance;
    //   147: invokevirtual 75	com/tencent/viola/core/ViolaInstance:renderJsEndMonitor	()V
    //   150: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   153: putstatic 85	com/tencent/viola/core/ViolaInstance:jsCreateInstanceEnd	J
    //   156: aload_2
    //   157: instanceof 87
    //   160: ifeq -80 -> 80
    //   163: new 89	com/tencent/viola/ui/action/MethodCreateBody
    //   166: dup
    //   167: aload_2
    //   168: checkcast 87	org/json/JSONObject
    //   171: invokespecial 92	com/tencent/viola/ui/action/MethodCreateBody:<init>	(Lorg/json/JSONObject;)V
    //   174: astore_1
    //   175: aload_1
    //   176: instanceof 94
    //   179: ifeq +14 -> 193
    //   182: aload_0
    //   183: aload_1
    //   184: checkcast 94	com/tencent/viola/ui/action/DOMAction
    //   187: iconst_1
    //   188: invokevirtual 98	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/DOMAction;Z)V
    //   191: iconst_1
    //   192: ireturn
    //   193: aload_0
    //   194: aload_1
    //   195: checkcast 100	com/tencent/viola/ui/action/RenderAction
    //   198: invokevirtual 103	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/RenderAction;)V
    //   201: iconst_1
    //   202: ireturn
    //   203: aload_2
    //   204: instanceof 105
    //   207: ifeq -127 -> 80
    //   210: new 107	com/tencent/viola/ui/action/MethodAddElement
    //   213: dup
    //   214: aload_2
    //   215: checkcast 105	org/json/JSONArray
    //   218: iconst_0
    //   219: invokevirtual 111	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   222: checkcast 58	java/lang/String
    //   225: aload_2
    //   226: checkcast 105	org/json/JSONArray
    //   229: iconst_1
    //   230: invokevirtual 111	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   233: checkcast 87	org/json/JSONObject
    //   236: aload_2
    //   237: checkcast 105	org/json/JSONArray
    //   240: iconst_2
    //   241: invokevirtual 111	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   244: checkcast 113	java/lang/Integer
    //   247: invokevirtual 116	java/lang/Integer:intValue	()I
    //   250: invokespecial 119	com/tencent/viola/ui/action/MethodAddElement:<init>	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   253: astore_1
    //   254: aload_1
    //   255: instanceof 94
    //   258: ifeq +14 -> 272
    //   261: aload_0
    //   262: aload_1
    //   263: checkcast 94	com/tencent/viola/ui/action/DOMAction
    //   266: iconst_0
    //   267: invokevirtual 98	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/DOMAction;Z)V
    //   270: iconst_1
    //   271: ireturn
    //   272: aload_0
    //   273: aload_1
    //   274: checkcast 100	com/tencent/viola/ui/action/RenderAction
    //   277: invokevirtual 103	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/RenderAction;)V
    //   280: iconst_1
    //   281: ireturn
    //   282: aload_2
    //   283: instanceof 105
    //   286: ifeq -206 -> 80
    //   289: new 121	com/tencent/viola/ui/action/MethodRemoveElement
    //   292: dup
    //   293: aload_2
    //   294: checkcast 105	org/json/JSONArray
    //   297: iconst_0
    //   298: invokevirtual 111	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   301: checkcast 58	java/lang/String
    //   304: invokespecial 124	com/tencent/viola/ui/action/MethodRemoveElement:<init>	(Ljava/lang/String;)V
    //   307: astore_1
    //   308: aload_1
    //   309: instanceof 94
    //   312: ifeq +14 -> 326
    //   315: aload_0
    //   316: aload_1
    //   317: checkcast 94	com/tencent/viola/ui/action/DOMAction
    //   320: iconst_0
    //   321: invokevirtual 98	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/DOMAction;Z)V
    //   324: iconst_1
    //   325: ireturn
    //   326: aload_0
    //   327: aload_1
    //   328: checkcast 100	com/tencent/viola/ui/action/RenderAction
    //   331: invokevirtual 103	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/RenderAction;)V
    //   334: iconst_1
    //   335: ireturn
    //   336: aload_2
    //   337: instanceof 105
    //   340: ifeq -260 -> 80
    //   343: new 126	com/tencent/viola/ui/action/MethodUpdateElement
    //   346: dup
    //   347: aload_2
    //   348: checkcast 105	org/json/JSONArray
    //   351: iconst_0
    //   352: invokevirtual 111	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   355: checkcast 58	java/lang/String
    //   358: aload_2
    //   359: checkcast 105	org/json/JSONArray
    //   362: iconst_1
    //   363: invokevirtual 111	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   366: checkcast 87	org/json/JSONObject
    //   369: invokespecial 129	com/tencent/viola/ui/action/MethodUpdateElement:<init>	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   372: astore_1
    //   373: aload_1
    //   374: instanceof 94
    //   377: ifeq +14 -> 391
    //   380: aload_0
    //   381: aload_1
    //   382: checkcast 94	com/tencent/viola/ui/action/DOMAction
    //   385: iconst_0
    //   386: invokevirtual 98	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/DOMAction;Z)V
    //   389: iconst_1
    //   390: ireturn
    //   391: aload_0
    //   392: aload_1
    //   393: checkcast 100	com/tencent/viola/ui/action/RenderAction
    //   396: invokevirtual 103	com/tencent/viola/module/DomModule:postAction	(Lcom/tencent/viola/ui/action/RenderAction;)V
    //   399: iconst_1
    //   400: ireturn
    //   401: astore_1
    //   402: iconst_1
    //   403: ireturn
    //   404: astore_1
    //   405: iconst_1
    //   406: ireturn
    //   407: astore_1
    //   408: iconst_1
    //   409: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	DomModule
    //   0	410	1	paramString	String
    //   0	410	2	paramObject	java.lang.Object
    //   1	132	3	i	int
    // Exception table:
    //   from	to	target	type
    //   203	270	401	org/json/JSONException
    //   272	280	401	org/json/JSONException
    //   282	324	404	org/json/JSONException
    //   326	334	404	org/json/JSONException
    //   336	389	407	org/json/JSONException
    //   391	399	407	org/json/JSONException
  }
  
  public void postAction(DOMAction paramDOMAction, boolean paramBoolean)
  {
    ViolaSDKManager.getInstance().getDomManager().postAction(getViolaInstance().getInstanceId(), paramDOMAction, paramBoolean);
  }
  
  public void postAction(RenderAction paramRenderAction)
  {
    ViolaSDKManager.getInstance().getRenderManager().runOnThread(getViolaInstance().getInstanceId(), paramRenderAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.module.DomModule
 * JD-Core Version:    0.7.0.1
 */