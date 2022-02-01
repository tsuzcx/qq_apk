package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventHelper
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BridgeModule> jdField_a_of_type_JavaLangRefWeakReference = null;
  private HashMap<String, ArrayList<EventHelper.Event>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  
  public EventHelper(BridgeModule paramBridgeModule)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBridgeModule);
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((((BridgeModule)localObject).getViolaInstance() != null) && (((BridgeModule)localObject).getViolaInstance().getFragment() != null) && ((((BridgeModule)localObject).getViolaInstance().getFragment() instanceof ViolaFragment))) {
        return ((ViolaFragment)((BridgeModule)localObject).getViolaInstance().getFragment()).getUrl();
      }
    }
    return "https://qq.com";
  }
  
  private void a(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).invokeErrorCallJS(paramString1, paramString2);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
        localArrayList.add(new EventHelper.Event(this, paramString2, paramString3));
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new EventHelper.Event(this, paramString2, paramString3));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, String paramString4, JSONObject paramJSONObject2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.length() >= 460800L))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "param data is over size");
      }
      a(paramString3, "param data is over size");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject1 = paramJSONObject1.optJSONObject("options");
        paramString2 = new ArrayList();
        if (paramJSONObject1 == null) {
          break label411;
        }
        boolean bool3 = paramJSONObject1.optBoolean("echo", true);
        boolean bool4 = paramJSONObject1.optBoolean("broadcast", true);
        paramJSONObject1 = paramJSONObject1.optJSONArray("domains");
        bool1 = bool3;
        bool2 = bool4;
        if (paramJSONObject1 != null)
        {
          int j = paramJSONObject1.length();
          i = 0;
          bool1 = bool3;
          bool2 = bool4;
          if (i < j)
          {
            localObject = paramJSONObject1.optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label402;
            }
            paramString2.add(localObject);
            break label402;
          }
        }
        paramJSONObject1 = new JSONObject();
        paramJSONObject1.put("url", paramString1);
        if ((paramString2.size() == 0) && (!TextUtils.isEmpty(paramString1)))
        {
          paramString1 = Uri.parse(paramString1);
          if (paramString1.isHierarchical()) {
            paramString2.add(paramString1.getHost());
          }
        }
        Object localObject = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject).putExtra("broadcast", bool2);
        ((Intent)localObject).putExtra("unique", b());
        ((Intent)localObject).putExtra("event", paramString4);
        if (paramJSONObject2 != null) {
          ((Intent)localObject).putExtra("data", paramJSONObject2.toString());
        }
        ((Intent)localObject).putStringArrayListExtra("domains", paramString2);
        ((Intent)localObject).putExtra("source", paramJSONObject1.toString());
        if (QLog.isColorLevel())
        {
          String str = this.jdField_a_of_type_JavaLangRefWeakReference.toString();
          if (paramJSONObject2 == null) {
            break label420;
          }
          paramString1 = paramJSONObject2.toString();
          QLog.d("BridgeModule.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str, paramString4, paramString1, TextUtils.join(",", paramString2), paramJSONObject1 }));
        }
        BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        if (bool1)
        {
          a(paramString4, paramJSONObject2, paramJSONObject1);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        a(paramString3, paramString1.getMessage());
      }
      return;
      label402:
      i += 1;
      continue;
      label411:
      boolean bool1 = true;
      boolean bool2 = true;
      continue;
      label420:
      paramString1 = "NULL";
    }
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    SimpleEventBus.getInstance().dispatchEvent(new ViolaEvent(paramString, paramJSONObject));
  }
  
  private String b()
  {
    if (this.b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
      localStringBuilder.append((int)(Math.random() * 1000000.0D));
      this.b = localStringBuilder.toString();
    }
    return this.b;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      c();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
      {
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        int i = 0;
        while (i < localArrayList.size())
        {
          EventHelper.Event localEvent = (EventHelper.Event)localArrayList.get(i);
          if ((localEvent.jdField_a_of_type_JavaLangString.equals(paramString2)) && (localEvent.b.equals(paramString3))) {
            localArrayList.remove(localEvent);
          }
          i += 1;
        }
        if (localArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
        }
      }
    }
  }
  
  private void b(String paramString, JSONObject paramJSONObject)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).invokeCallJS(paramString, paramJSONObject);
    }
  }
  
  private String c()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Uri.parse(this.jdField_a_of_type_JavaLangString).getHost();
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new EventHelper.1(this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      ((WeakReference)localObject).clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Iterator)localObject).next();
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          localArrayList.clear();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  /* Error */
  protected void a(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: ldc 135
    //   8: iconst_1
    //   9: invokevirtual 356	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_2
    //   17: ldc 182
    //   19: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +15 -> 39
    //   27: aload_1
    //   28: aload_0
    //   29: invokespecial 184	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:b	()Ljava/lang/String;
    //   32: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +4 -> 39
    //   38: return
    //   39: aload_2
    //   40: ldc 189
    //   42: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 8
    //   47: aload 8
    //   49: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +4 -> 56
    //   55: return
    //   56: aload_2
    //   57: ldc 191
    //   59: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aconst_null
    //   64: astore 6
    //   66: aload_1
    //   67: ifnull +15 -> 82
    //   70: new 123	org/json/JSONObject
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 361	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: astore_1
    //   79: goto +5 -> 84
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_2
    //   85: ldc 137
    //   87: invokevirtual 365	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   90: astore 9
    //   92: aload 9
    //   94: ifnonnull +4 -> 98
    //   97: return
    //   98: aload_2
    //   99: ldc 200
    //   101: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 7
    //   106: aload 6
    //   108: astore_2
    //   109: aload 7
    //   111: ifnull +16 -> 127
    //   114: new 123	org/json/JSONObject
    //   117: dup
    //   118: aload 7
    //   120: invokespecial 361	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   123: astore_2
    //   124: goto +3 -> 127
    //   127: aload_0
    //   128: invokespecial 367	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:c	()Ljava/lang/String;
    //   131: astore 10
    //   133: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: istore 5
    //   138: iconst_0
    //   139: istore_3
    //   140: iload 5
    //   142: ifeq +87 -> 229
    //   145: aload_0
    //   146: getfield 29	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   149: astore 6
    //   151: ldc 238
    //   153: astore 7
    //   155: aload 6
    //   157: ifnull +13 -> 170
    //   160: aload 6
    //   162: invokevirtual 201	java/lang/Object:toString	()Ljava/lang/String;
    //   165: astore 6
    //   167: goto +7 -> 174
    //   170: ldc 238
    //   172: astore 6
    //   174: aload_1
    //   175: ifnull +9 -> 184
    //   178: aload_1
    //   179: invokevirtual 194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   182: astore 7
    //   184: ldc 111
    //   186: iconst_2
    //   187: ldc_w 369
    //   190: iconst_5
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 6
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: aload 8
    //   203: aastore
    //   204: dup
    //   205: iconst_2
    //   206: aload 7
    //   208: aastore
    //   209: dup
    //   210: iconst_3
    //   211: ldc 205
    //   213: aload 9
    //   215: invokestatic 209	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   218: aastore
    //   219: dup
    //   220: iconst_4
    //   221: aload_2
    //   222: aastore
    //   223: invokestatic 213	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   226: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload 9
    //   231: invokevirtual 157	java/util/ArrayList:size	()I
    //   234: istore 4
    //   236: iload_3
    //   237: iload 4
    //   239: if_icmpge +36 -> 275
    //   242: aload 9
    //   244: iload_3
    //   245: invokevirtual 307	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   248: checkcast 97	java/lang/String
    //   251: aload 10
    //   253: invokestatic 374	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: ifeq +12 -> 268
    //   259: aload_0
    //   260: aload 8
    //   262: aload_1
    //   263: aload_2
    //   264: invokevirtual 233	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   267: return
    //   268: iload_3
    //   269: iconst_1
    //   270: iadd
    //   271: istore_3
    //   272: goto -36 -> 236
    //   275: return
    //   276: astore_1
    //   277: return
    //   278: astore_1
    //   279: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	EventHelper
    //   0	280	1	paramContext	android.content.Context
    //   0	280	2	paramIntent	Intent
    //   139	133	3	i	int
    //   234	6	4	j	int
    //   136	5	5	bool	boolean
    //   64	133	6	localObject	Object
    //   104	103	7	str1	String
    //   45	216	8	str2	String
    //   90	153	9	localArrayList	ArrayList
    //   131	121	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	79	276	org/json/JSONException
    //   114	124	278	org/json/JSONException
  }
  
  protected void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (ArrayList)((HashMap)localObject).get(paramString);
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        String str = ((EventHelper.Event)((ArrayList)localObject).get(i)).b;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("event", paramString);
          localJSONObject.put("data", paramJSONObject1);
          localJSONObject.put("source", paramJSONObject2);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("BridgeModule.event", 1, localJSONException.getMessage(), localJSONException);
        }
        b(str, localJSONObject);
        i += 1;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    this.jdField_a_of_type_JavaLangString = a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "source url is null");
      }
      a(paramString, "source url is null");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    b();
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      a(str, paramJSONObject.optString("identifier", ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getInstanceId()), paramString);
    }
  }
  
  public void b(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        b(str, paramJSONObject.optString("identifier", ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getInstanceId()), paramString);
      }
    }
    b(paramString, new JSONObject());
  }
  
  public void c(JSONObject paramJSONObject, String paramString)
  {
    String str2 = "";
    String str3 = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    String str4 = a();
    if (TextUtils.isEmpty(str3))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    String str1 = paramString;
    if (paramString == null)
    {
      str1 = paramString;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str3)) {
        str1 = ((EventHelper.Event)((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(str3)).get(0)).b;
      }
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    paramString = str2;
    if (localJSONObject != null) {
      paramString = localJSONObject.toString();
    }
    if (ViolaUtils.getBoolean(paramJSONObject.opt("toNative")))
    {
      a(str3, localJSONObject);
      b(str1, null);
      return;
    }
    a(str4, paramString, str1, paramJSONObject, str3, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.EventHelper
 * JD-Core Version:    0.7.0.1
 */