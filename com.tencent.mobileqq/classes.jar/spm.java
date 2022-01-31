import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class spm
{
  public static final String a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private WeakReference<BridgeModule> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, ArrayList<spo>> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = BridgeModule.TAG + ".event";
  }
  
  public spm(BridgeModule paramBridgeModule)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBridgeModule);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      BridgeModule localBridgeModule = (BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localBridgeModule.getViolaInstance() != null) && (localBridgeModule.getViolaInstance().getFragment() != null) && ((localBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
        return ((ViolaFragment)localBridgeModule.getViolaInstance().getFragment()).a();
      }
    }
    return "https://qq.com";
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).invokeErrorCallJS(paramString1, paramString2);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      localArrayList.add(new spo(this, paramString2, paramString3));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new spo(this, paramString2, paramString3));
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).invokeCallJS(paramString, paramJSONObject);
    }
  }
  
  private String b()
  {
    if (this.c == null) {
      this.c = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)));
    }
    return this.c;
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
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1));
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
      int i = 0;
      while (i < localArrayList.size())
      {
        spo localspo = (spo)localArrayList.get(i);
        if ((localspo.jdField_a_of_type_JavaLangString.equals(paramString2)) && (localspo.b.equals(paramString3))) {
          localArrayList.remove(localspo);
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
  }
  
  private String c()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return Uri.parse(this.b).getHost();
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new spn(this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)localIterator.next();
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
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_2
    //   11: ldc 229
    //   13: iconst_1
    //   14: invokevirtual 235	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   17: ifeq -8 -> 9
    //   20: aload_2
    //   21: ldc 237
    //   23: invokevirtual 241	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +14 -> 42
    //   31: aload_1
    //   32: aload_0
    //   33: invokespecial 243	spm:b	()Ljava/lang/String;
    //   36: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne -30 -> 9
    //   42: aload_2
    //   43: ldc 245
    //   45: invokevirtual 241	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne -46 -> 9
    //   58: aload_2
    //   59: ldc 247
    //   61: invokevirtual 241	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +207 -> 273
    //   69: new 249	org/json/JSONObject
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 251	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 253
    //   81: invokevirtual 257	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   84: astore 8
    //   86: aload 8
    //   88: ifnull -79 -> 9
    //   91: aload_2
    //   92: ldc_w 259
    //   95: invokevirtual 241	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 6
    //   100: aload 5
    //   102: astore_2
    //   103: aload 6
    //   105: ifnull +13 -> 118
    //   108: new 249	org/json/JSONObject
    //   111: dup
    //   112: aload 6
    //   114: invokespecial 251	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: astore_2
    //   118: aload_0
    //   119: invokespecial 261	spm:c	()Ljava/lang/String;
    //   122: astore 9
    //   124: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +80 -> 207
    //   130: getstatic 38	spm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: astore 10
    //   135: aload_0
    //   136: getfield 48	spm:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   139: ifnull +107 -> 246
    //   142: aload_0
    //   143: getfield 48	spm:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   146: invokevirtual 267	java/lang/Object:toString	()Ljava/lang/String;
    //   149: astore 5
    //   151: aload_1
    //   152: ifnull +102 -> 254
    //   155: aload_1
    //   156: invokevirtual 268	org/json/JSONObject:toString	()Ljava/lang/String;
    //   159: astore 6
    //   161: aload 10
    //   163: iconst_2
    //   164: ldc_w 270
    //   167: iconst_5
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload 5
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload 7
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload 6
    //   185: aastore
    //   186: dup
    //   187: iconst_3
    //   188: ldc_w 272
    //   191: aload 8
    //   193: invokestatic 276	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   196: aastore
    //   197: dup
    //   198: iconst_4
    //   199: aload_2
    //   200: aastore
    //   201: invokestatic 280	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 8
    //   209: invokevirtual 170	java/util/ArrayList:size	()I
    //   212: istore 4
    //   214: iload_3
    //   215: iload 4
    //   217: if_icmpge -208 -> 9
    //   220: aload 8
    //   222: iload_3
    //   223: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   226: checkcast 120	java/lang/String
    //   229: aload 9
    //   231: invokestatic 289	myl:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   234: ifeq +28 -> 262
    //   237: aload_0
    //   238: aload 7
    //   240: aload_1
    //   241: aload_2
    //   242: invokevirtual 292	spm:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   245: return
    //   246: ldc_w 294
    //   249: astore 5
    //   251: goto -100 -> 151
    //   254: ldc_w 294
    //   257: astore 6
    //   259: goto -98 -> 161
    //   262: iload_3
    //   263: iconst_1
    //   264: iadd
    //   265: istore_3
    //   266: goto -52 -> 214
    //   269: astore_1
    //   270: return
    //   271: astore_1
    //   272: return
    //   273: aconst_null
    //   274: astore_1
    //   275: goto -197 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	spm
    //   0	278	1	paramContext	android.content.Context
    //   0	278	2	paramIntent	Intent
    //   4	262	3	i	int
    //   212	6	4	j	int
    //   1	249	5	str1	String
    //   98	160	6	str2	String
    //   48	191	7	str3	String
    //   84	137	8	localArrayList	ArrayList
    //   122	108	9	str4	String
    //   133	29	10	str5	String
    // Exception table:
    //   from	to	target	type
    //   108	118	269	org/json/JSONException
    //   69	78	271	org/json/JSONException
  }
  
  protected void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      localArrayList = null;
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        int i = 0;
        label26:
        if (i < localArrayList.size())
        {
          String str = ((spo)localArrayList.get(i)).b;
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("event", paramString);
            localJSONObject.put("data", paramJSONObject1);
            localJSONObject.put("source", paramJSONObject2);
            a(str, localJSONObject);
            i += 1;
            break label26;
            localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e(jdField_a_of_type_JavaLangString, 1, localJSONException.getMessage(), localJSONException);
            }
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    this.b = a();
    if (TextUtils.isEmpty(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "source url is null");
      }
      a(paramString, "source url is null");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "event name is null");
        }
        a(paramString, "event name is null");
        return;
      }
      b();
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    a(str, paramJSONObject.optString("identifier", ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getInstanceId()), paramString);
  }
  
  public void b(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      b(str, paramJSONObject.optString("identifier", ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getInstanceId()), paramString);
    }
    a(paramString, new JSONObject());
  }
  
  public void c(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    int k = 1;
    String str1 = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    Object localObject2 = a();
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if (localJSONObject != null) {}
    for (Object localObject1 = localJSONObject.toString(); (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() >= 460800L); localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "param data is over size");
      }
      a(paramString, "param data is over size");
      return;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("options");
        localObject1 = new ArrayList();
        if (paramJSONObject == null) {
          break label515;
        }
        boolean bool2 = paramJSONObject.optBoolean("echo", true);
        boolean bool3 = paramJSONObject.optBoolean("broadcast", true);
        paramJSONObject = paramJSONObject.optJSONArray("domains");
        bool1 = bool3;
        k = bool2;
        if (paramJSONObject != null)
        {
          int j = paramJSONObject.length();
          bool1 = bool3;
          k = bool2;
          if (i < j)
          {
            localObject3 = paramJSONObject.optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label508;
            }
            ((ArrayList)localObject1).add(localObject3);
            break label508;
          }
        }
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("url", localObject2);
        if ((((ArrayList)localObject1).size() == 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          paramJSONObject = Uri.parse((String)localObject2);
          if (paramJSONObject.isHierarchical()) {
            ((ArrayList)localObject1).add(paramJSONObject.getHost());
          }
        }
        localObject2 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject2).putExtra("broadcast", bool1);
        ((Intent)localObject2).putExtra("unique", b());
        ((Intent)localObject2).putExtra("event", str1);
        if (localJSONObject != null) {
          ((Intent)localObject2).putExtra("data", localJSONObject.toString());
        }
        ((Intent)localObject2).putStringArrayListExtra("domains", (ArrayList)localObject1);
        ((Intent)localObject2).putExtra("source", ((JSONObject)localObject3).toString());
        if (QLog.isColorLevel())
        {
          String str2 = jdField_a_of_type_JavaLangString;
          String str3 = this.jdField_a_of_type_JavaLangRefWeakReference.toString();
          if (localJSONObject != null)
          {
            paramJSONObject = localJSONObject.toString();
            QLog.d(str2, 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str3, str1, paramJSONObject, TextUtils.join(",", (Iterable)localObject1), localObject3 }));
          }
        }
        else
        {
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
          if (k != 0) {}
          a(paramString, new JSONObject());
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        a(paramString, paramJSONObject.getMessage());
        return;
      }
      paramJSONObject = "NULL";
      continue;
      label508:
      i += 1;
      continue;
      label515:
      boolean bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spm
 * JD-Core Version:    0.7.0.1
 */