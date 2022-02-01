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
  private BroadcastReceiver a = null;
  private HashMap<String, ArrayList<EventHelper.Event>> b = new HashMap();
  private String c;
  private boolean d = false;
  private String e;
  private WeakReference<BridgeModule> f = null;
  
  public EventHelper(BridgeModule paramBridgeModule)
  {
    this.f = new WeakReference(paramBridgeModule);
  }
  
  private void a(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = this.f;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((BridgeModule)this.f.get()).invokeErrorCallJS(paramString1, paramString2);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (this.b.containsKey(paramString1))
      {
        localArrayList = (ArrayList)this.b.get(paramString1);
        localArrayList.add(new EventHelper.Event(this, paramString2, paramString3));
        this.b.put(paramString1, localArrayList);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new EventHelper.Event(this, paramString2, paramString3));
      this.b.put(paramString1, localArrayList);
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
        ((Intent)localObject).putExtra("unique", e());
        ((Intent)localObject).putExtra("event", paramString4);
        if (paramJSONObject2 != null) {
          ((Intent)localObject).putExtra("data", paramJSONObject2.toString());
        }
        ((Intent)localObject).putStringArrayListExtra("domains", paramString2);
        ((Intent)localObject).putExtra("source", paramJSONObject1.toString());
        if (QLog.isColorLevel())
        {
          String str = this.f.toString();
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
    Object localObject = this.f;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (BridgeModule)this.f.get();
      if ((((BridgeModule)localObject).getViolaInstance() != null) && (((BridgeModule)localObject).getViolaInstance().getFragment() != null) && ((((BridgeModule)localObject).getViolaInstance().getFragment() instanceof ViolaFragment))) {
        return ((ViolaFragment)((BridgeModule)localObject).getViolaInstance().getFragment()).getUrl();
      }
    }
    return "https://qq.com";
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (this.b.containsKey(paramString1))
      {
        ArrayList localArrayList = (ArrayList)this.b.remove(paramString1);
        int i = 0;
        while (i < localArrayList.size())
        {
          EventHelper.Event localEvent = (EventHelper.Event)localArrayList.get(i);
          if ((localEvent.a.equals(paramString2)) && (localEvent.b.equals(paramString3))) {
            localArrayList.remove(localEvent);
          }
          i += 1;
        }
        if (localArrayList.size() > 0) {
          this.b.put(paramString1, localArrayList);
        }
      }
    }
  }
  
  private void b(String paramString, JSONObject paramJSONObject)
  {
    WeakReference localWeakReference = this.f;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((BridgeModule)this.f.get()).invokeCallJS(paramString, paramJSONObject);
    }
  }
  
  private void c()
  {
    if (this.d) {
      return;
    }
    if (this.a == null) {
      d();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    this.d = true;
    this.b = new HashMap();
  }
  
  private void d()
  {
    this.a = new EventHelper.1(this);
  }
  
  private String e()
  {
    if (this.e == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
      localStringBuilder.append((int)(Math.random() * 1000000.0D));
      this.e = localStringBuilder.toString();
    }
    return this.e;
  }
  
  private String f()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return Uri.parse(this.c).getHost();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.d) && (this.a != null))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.a);
      this.a = null;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      ((WeakReference)localObject).clear();
      this.f = null;
    }
    localObject = this.b;
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
      this.b.clear();
      this.b = null;
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
    //   6: ldc 121
    //   8: iconst_1
    //   9: invokevirtual 360	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_2
    //   17: ldc 169
    //   19: invokevirtual 364	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +15 -> 39
    //   27: aload_1
    //   28: aload_0
    //   29: invokespecial 171	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:e	()Ljava/lang/String;
    //   32: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +4 -> 39
    //   38: return
    //   39: aload_2
    //   40: ldc 176
    //   42: invokevirtual 364	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 8
    //   47: aload 8
    //   49: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +4 -> 56
    //   55: return
    //   56: aload_2
    //   57: ldc 178
    //   59: invokevirtual 364	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aconst_null
    //   64: astore 6
    //   66: aload_1
    //   67: ifnull +15 -> 82
    //   70: new 109	org/json/JSONObject
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 365	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: astore_1
    //   79: goto +5 -> 84
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_2
    //   85: ldc 123
    //   87: invokevirtual 369	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   90: astore 9
    //   92: aload 9
    //   94: ifnonnull +4 -> 98
    //   97: return
    //   98: aload_2
    //   99: ldc 187
    //   101: invokevirtual 364	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 7
    //   106: aload 6
    //   108: astore_2
    //   109: aload 7
    //   111: ifnull +16 -> 127
    //   114: new 109	org/json/JSONObject
    //   117: dup
    //   118: aload 7
    //   120: invokespecial 365	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   123: astore_2
    //   124: goto +3 -> 127
    //   127: aload_0
    //   128: invokespecial 371	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:f	()Ljava/lang/String;
    //   131: astore 10
    //   133: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: istore 5
    //   138: iconst_0
    //   139: istore_3
    //   140: iload 5
    //   142: ifeq +87 -> 229
    //   145: aload_0
    //   146: getfield 33	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:f	Ljava/lang/ref/WeakReference;
    //   149: astore 6
    //   151: ldc 224
    //   153: astore 7
    //   155: aload 6
    //   157: ifnull +13 -> 170
    //   160: aload 6
    //   162: invokevirtual 188	java/lang/Object:toString	()Ljava/lang/String;
    //   165: astore 6
    //   167: goto +7 -> 174
    //   170: ldc 224
    //   172: astore 6
    //   174: aload_1
    //   175: ifnull +9 -> 184
    //   178: aload_1
    //   179: invokevirtual 181	org/json/JSONObject:toString	()Ljava/lang/String;
    //   182: astore 7
    //   184: ldc 97
    //   186: iconst_2
    //   187: ldc_w 373
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
    //   211: ldc 192
    //   213: aload 9
    //   215: invokestatic 196	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   218: aastore
    //   219: dup
    //   220: iconst_4
    //   221: aload_2
    //   222: aastore
    //   223: invokestatic 200	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   226: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload 9
    //   231: invokevirtual 143	java/util/ArrayList:size	()I
    //   234: istore 4
    //   236: iload_3
    //   237: iload 4
    //   239: if_icmpge +36 -> 275
    //   242: aload 9
    //   244: iload_3
    //   245: invokevirtual 262	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   248: checkcast 83	java/lang/String
    //   251: aload 10
    //   253: invokestatic 378	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: ifeq +12 -> 268
    //   259: aload_0
    //   260: aload 8
    //   262: aload_1
    //   263: aload_2
    //   264: invokevirtual 219	com/tencent/mobileqq/kandian/glue/viola/modules/EventHelper:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
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
    Object localObject = this.b;
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
    this.c = b();
    if (TextUtils.isEmpty(this.c))
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
    c();
    WeakReference localWeakReference = this.f;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      a(str, paramJSONObject.optString("identifier", ((BridgeModule)this.f.get()).getViolaInstance().getInstanceId()), paramString);
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
    if (this.b != null)
    {
      WeakReference localWeakReference = this.f;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        b(str, paramJSONObject.optString("identifier", ((BridgeModule)this.f.get()).getViolaInstance().getInstanceId()), paramString);
      }
    }
    b(paramString, new JSONObject());
  }
  
  public void c(JSONObject paramJSONObject, String paramString)
  {
    String str2 = "";
    String str3 = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    String str4 = b();
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
      if (this.b.containsKey(str3)) {
        str1 = ((EventHelper.Event)((ArrayList)this.b.get(str3)).get(0)).b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.EventHelper
 * JD-Core Version:    0.7.0.1
 */