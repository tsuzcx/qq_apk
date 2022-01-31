import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class myt
  extends myr
{
  public final Handler a;
  public final ConcurrentHashMap<String, Set<String>> a;
  
  public myt(SharedPreferences paramSharedPreferences, myr parammyr)
  {
    super(paramSharedPreferences, parammyr);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidOsHandler = new myu(this, Looper.getMainLooper());
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmdConfig", null);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          break label123;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("AuthorizeConfig", 2, "now read cmdConfig {\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
          }
          JSONObject localJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
          localObject1 = localJSONObject;
          if (localObject1 != null) {
            break label126;
          }
          QLog.e("AuthorizeConfig", 1, "cmdJsonObject is null!");
          return;
        }
        catch (JSONException localJSONException2)
        {
          if (!QLog.isColorLevel()) {
            break label123;
          }
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
        localJSONException1 = localJSONException1;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
        localObject2 = null;
        continue;
      }
      QLog.e("AuthorizeConfig", 2, "now error! old mPref have no value for cmdConfig!");
      Object localObject2 = null;
      continue;
      label123:
      continue;
      label126:
      JSONArray localJSONArray1 = localObject2.names();
      if ((localJSONArray1 == null) || (localJSONArray1.length() == 0))
      {
        QLog.e("AuthorizeConfig", 1, "domain Name are all empty!");
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      int i = 0;
      while (i < localJSONArray1.length())
      {
        HashSet localHashSet = new HashSet(20);
        String str = localJSONArray1.optString(i);
        JSONArray localJSONArray2 = localObject2.optJSONArray(str);
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          int j = 0;
          while (j < localJSONArray2.length())
          {
            localHashSet.add(localJSONArray2.optString(j));
            j += 1;
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localHashSet);
        }
        i += 1;
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmd_config_new", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      Object localObject3;
      int j;
      String str;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label221;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        int m = ((JSONArray)localObject1).length();
        i = 0;
        if (i >= m) {
          break label220;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        JSONArray localJSONArray1 = ((JSONObject)localObject3).optJSONArray("api");
        JSONArray localJSONArray2 = ((JSONObject)localObject3).optJSONArray("match");
        int n = localJSONArray2.length();
        j = 0;
        if (j >= n) {
          break label249;
        }
        str = localJSONArray2.optString(j);
        Set localSet = (Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        localObject3 = localSet;
        if (localSet == null) {
          localObject3 = new HashSet(20);
        }
        int i1 = localJSONArray1.length();
        int k = 0;
        if (k >= i1) {
          break label230;
        }
        ((Set)localObject3).add(localJSONArray1.optString(k));
        k += 1;
        continue;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "Js Api Config JSONArray error!", localException);
        }
        Object localObject2 = null;
        continue;
      }
      QLog.e("AuthorizeConfig", 1, "get Js Api Config From Pref is empty!");
      label220:
      return;
      label221:
      QLog.e("AuthorizeConfig", 1, "Js Api Config JSONArray From Pref is empty");
      return;
      label230:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject3);
      j += 1;
      continue;
      label249:
      i += 1;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a())
    {
      int i = this.jdField_a_of_type_Myr.a(paramString1, paramString2);
      if ((a(i)) || (!b(i))) {
        return i;
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)
    {
      d();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
        c();
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)
    {
      QLog.e("AuthorizeConfig", 1, "can not find any JS API, so return!");
      return a(false, true);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
    if (((Set)localObject).size() == 0) {
      return a(false, true);
    }
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString1.toLowerCase();
    }
    do
    {
      paramString1 = ((Set)localObject).iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!paramString1.hasNext()) {
              break;
            }
            localObject = (String)paramString1.next();
          } while (!mvv.b((String)localObject, str));
          localObject = (Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        } while ((localObject == null) || (((Set)localObject).size() == 0));
        localObject = ((Set)localObject).iterator();
      }
    } while (!mvv.b((String)((Iterator)localObject).next(), paramString2));
    return a(true, false);
    return a(false, false);
  }
  
  public String a()
  {
    if (!a()) {
      return this.jdField_a_of_type_Myr.a();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("offlineHtml", null);
  }
  
  /* Error */
  public String a(android.content.SharedPreferences.Editor paramEditor, String paramString)
  {
    // Byte code:
    //   0: new 56	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 10
    //   10: ldc 126
    //   12: astore 9
    //   14: aload 10
    //   16: ldc 212
    //   18: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   21: astore 12
    //   23: new 14	java/util/concurrent/ConcurrentHashMap
    //   26: dup
    //   27: bipush 50
    //   29: invokespecial 17	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   32: astore 11
    //   34: aload 12
    //   36: ifnull +165 -> 201
    //   39: aload 12
    //   41: invokevirtual 94	org/json/JSONArray:length	()I
    //   44: ifle +157 -> 201
    //   47: aload_1
    //   48: ldc 124
    //   50: aload 12
    //   52: invokevirtual 218	org/json/JSONArray:toString	()Ljava/lang/String;
    //   55: invokeinterface 224 3 0
    //   60: pop
    //   61: aload_1
    //   62: ldc 42
    //   64: ldc 126
    //   66: invokeinterface 224 3 0
    //   71: pop
    //   72: aload 12
    //   74: invokevirtual 94	org/json/JSONArray:length	()I
    //   77: istore 6
    //   79: iconst_0
    //   80: istore_3
    //   81: iload_3
    //   82: iload 6
    //   84: if_icmpge +145 -> 229
    //   87: aload 12
    //   89: iload_3
    //   90: invokevirtual 131	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   93: astore_2
    //   94: aload_2
    //   95: ldc 133
    //   97: invokevirtual 110	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   100: astore 13
    //   102: aload_2
    //   103: ldc 135
    //   105: invokevirtual 110	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   108: astore 14
    //   110: aload 14
    //   112: invokevirtual 94	org/json/JSONArray:length	()I
    //   115: istore 7
    //   117: iconst_0
    //   118: istore 4
    //   120: iload 4
    //   122: iload 7
    //   124: if_icmpge +760 -> 884
    //   127: aload 14
    //   129: iload 4
    //   131: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   134: astore 15
    //   136: aload 11
    //   138: aload 15
    //   140: invokevirtual 139	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast 112	java/util/Set
    //   146: astore_2
    //   147: aload_2
    //   148: ifnonnull +731 -> 879
    //   151: new 101	java/util/HashSet
    //   154: dup
    //   155: bipush 20
    //   157: invokespecial 102	java/util/HashSet:<init>	(I)V
    //   160: astore_2
    //   161: iconst_0
    //   162: istore 5
    //   164: aload 13
    //   166: invokevirtual 94	org/json/JSONArray:length	()I
    //   169: istore 8
    //   171: iload 5
    //   173: iload 8
    //   175: if_icmpge +36 -> 211
    //   178: aload_2
    //   179: aload 13
    //   181: iload 5
    //   183: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   186: invokeinterface 116 2 0
    //   191: pop
    //   192: iload 5
    //   194: iconst_1
    //   195: iadd
    //   196: istore 5
    //   198: goto -27 -> 171
    //   201: ldc 67
    //   203: iconst_1
    //   204: ldc 228
    //   206: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aconst_null
    //   210: areturn
    //   211: aload 11
    //   213: aload 15
    //   215: aload_2
    //   216: invokevirtual 120	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: iload 4
    //   222: iconst_1
    //   223: iadd
    //   224: istore 4
    //   226: goto -106 -> 120
    //   229: invokestatic 234	android/os/Message:obtain	()Landroid/os/Message;
    //   232: astore_2
    //   233: aload_2
    //   234: iconst_1
    //   235: putfield 238	android/os/Message:what	I
    //   238: aload_2
    //   239: aload 11
    //   241: putfield 242	android/os/Message:obj	Ljava/lang/Object;
    //   244: aload_0
    //   245: getfield 32	myt:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   248: aload_2
    //   249: invokevirtual 248	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   252: pop
    //   253: aload 9
    //   255: astore_2
    //   256: aload_1
    //   257: ldc 250
    //   259: aload 10
    //   261: ldc 250
    //   263: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   266: invokevirtual 218	org/json/JSONArray:toString	()Ljava/lang/String;
    //   269: invokeinterface 224 3 0
    //   274: pop
    //   275: aload_1
    //   276: ldc 207
    //   278: aload 10
    //   280: ldc 252
    //   282: invokevirtual 256	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   285: invokevirtual 257	org/json/JSONObject:toString	()Ljava/lang/String;
    //   288: invokeinterface 224 3 0
    //   293: pop
    //   294: aload_1
    //   295: ldc_w 259
    //   298: aload 10
    //   300: ldc_w 261
    //   303: invokevirtual 256	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   306: invokevirtual 257	org/json/JSONObject:toString	()Ljava/lang/String;
    //   309: invokeinterface 224 3 0
    //   314: pop
    //   315: aload_1
    //   316: ldc_w 263
    //   319: aload 10
    //   321: ldc_w 263
    //   324: invokevirtual 256	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   327: invokevirtual 257	org/json/JSONObject:toString	()Ljava/lang/String;
    //   330: invokeinterface 224 3 0
    //   335: pop
    //   336: new 56	org/json/JSONObject
    //   339: dup
    //   340: invokespecial 265	org/json/JSONObject:<init>	()V
    //   343: astore 9
    //   345: aload 10
    //   347: ldc_w 267
    //   350: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   353: astore 11
    //   355: aload 11
    //   357: invokevirtual 94	org/json/JSONArray:length	()I
    //   360: istore 5
    //   362: iconst_0
    //   363: istore_3
    //   364: iload_3
    //   365: iload 5
    //   367: if_icmpge +268 -> 635
    //   370: aload 11
    //   372: iload_3
    //   373: invokevirtual 269	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   376: astore 13
    //   378: aload 13
    //   380: ldc_w 271
    //   383: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   386: astore 12
    //   388: aload 13
    //   390: ldc 135
    //   392: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   395: astore 13
    //   397: iconst_0
    //   398: istore 4
    //   400: aload 13
    //   402: invokevirtual 94	org/json/JSONArray:length	()I
    //   405: istore 6
    //   407: iload 4
    //   409: iload 6
    //   411: if_icmpge +217 -> 628
    //   414: aload 9
    //   416: aload 13
    //   418: iload 4
    //   420: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   423: aload 12
    //   425: invokevirtual 274	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   428: pop
    //   429: iload 4
    //   431: iconst_1
    //   432: iadd
    //   433: istore 4
    //   435: goto -28 -> 407
    //   438: astore_2
    //   439: new 276	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   446: ldc 126
    //   448: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_2
    //   452: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: astore_2
    //   462: goto -206 -> 256
    //   465: astore_2
    //   466: new 276	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   473: ldc 126
    //   475: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_2
    //   479: invokevirtual 286	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   482: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: astore_2
    //   489: goto -233 -> 256
    //   492: astore 9
    //   494: new 276	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   501: aload_2
    //   502: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 288
    //   508: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 9
    //   513: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   516: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: astore_2
    //   523: goto -248 -> 275
    //   526: astore 9
    //   528: new 276	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   535: aload_2
    //   536: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: ldc_w 288
    //   542: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload 9
    //   547: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   550: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: astore_2
    //   557: goto -263 -> 294
    //   560: astore 9
    //   562: new 276	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   569: aload_2
    //   570: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc_w 288
    //   576: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload 9
    //   581: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   584: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: astore_2
    //   591: goto -276 -> 315
    //   594: astore 9
    //   596: new 276	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   603: aload_2
    //   604: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 288
    //   610: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 9
    //   615: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   618: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: astore_2
    //   625: goto -289 -> 336
    //   628: iload_3
    //   629: iconst_1
    //   630: iadd
    //   631: istore_3
    //   632: goto -268 -> 364
    //   635: aload_1
    //   636: ldc_w 267
    //   639: aload 9
    //   641: invokevirtual 257	org/json/JSONObject:toString	()Ljava/lang/String;
    //   644: invokeinterface 224 3 0
    //   649: pop
    //   650: aload_1
    //   651: ldc_w 291
    //   654: aload 10
    //   656: ldc_w 291
    //   659: invokevirtual 295	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   662: invokeinterface 299 4 0
    //   667: pop
    //   668: getstatic 302	mvv:a	[Ljava/lang/String;
    //   671: astore 11
    //   673: aload 11
    //   675: arraylength
    //   676: istore 4
    //   678: iconst_0
    //   679: istore_3
    //   680: iload_3
    //   681: iload 4
    //   683: if_icmpge +199 -> 882
    //   686: aload 11
    //   688: iload_3
    //   689: aaload
    //   690: astore 12
    //   692: aload 10
    //   694: aload 12
    //   696: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   699: astore 13
    //   701: aload_1
    //   702: aload 12
    //   704: aload 13
    //   706: invokevirtual 218	org/json/JSONArray:toString	()Ljava/lang/String;
    //   709: invokeinterface 224 3 0
    //   714: pop
    //   715: aload_2
    //   716: astore 9
    //   718: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +44 -> 765
    //   724: ldc 67
    //   726: iconst_2
    //   727: new 276	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 304
    //   737: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 12
    //   742: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: ldc_w 306
    //   748: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 13
    //   753: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload_2
    //   763: astore 9
    //   765: iload_3
    //   766: iconst_1
    //   767: iadd
    //   768: istore_3
    //   769: aload 9
    //   771: astore_2
    //   772: goto -92 -> 680
    //   775: astore 9
    //   777: new 276	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   784: aload_2
    //   785: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: ldc_w 288
    //   791: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload 9
    //   796: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   799: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: astore_2
    //   806: goto -156 -> 650
    //   809: astore 9
    //   811: ldc 67
    //   813: iconst_1
    //   814: new 276	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 311
    //   824: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload 9
    //   829: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   832: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   841: goto -173 -> 668
    //   844: astore 9
    //   846: new 276	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   853: aload_2
    //   854: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc_w 288
    //   860: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 9
    //   865: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   868: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: astore 9
    //   876: goto -111 -> 765
    //   879: goto -718 -> 161
    //   882: aload_2
    //   883: areturn
    //   884: iload_3
    //   885: iconst_1
    //   886: iadd
    //   887: istore_3
    //   888: goto -807 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	myt
    //   0	891	1	paramEditor	android.content.SharedPreferences.Editor
    //   0	891	2	paramString	String
    //   80	808	3	i	int
    //   118	566	4	j	int
    //   162	206	5	k	int
    //   77	335	6	m	int
    //   115	10	7	n	int
    //   169	7	8	i1	int
    //   12	403	9	localObject1	Object
    //   492	20	9	localJSONException1	JSONException
    //   526	20	9	localJSONException2	JSONException
    //   560	20	9	localJSONException3	JSONException
    //   594	46	9	localJSONException4	JSONException
    //   716	54	9	str1	String
    //   775	20	9	localException1	Exception
    //   809	19	9	localException2	Exception
    //   844	20	9	localJSONException5	JSONException
    //   874	1	9	str2	String
    //   8	685	10	localJSONObject	JSONObject
    //   32	655	11	localObject2	Object
    //   21	720	12	localJSONArray1	JSONArray
    //   100	652	13	localObject3	Object
    //   108	20	14	localJSONArray2	JSONArray
    //   134	80	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   14	34	438	java/lang/Exception
    //   39	79	438	java/lang/Exception
    //   87	117	438	java/lang/Exception
    //   127	147	438	java/lang/Exception
    //   151	161	438	java/lang/Exception
    //   164	171	438	java/lang/Exception
    //   178	192	438	java/lang/Exception
    //   201	209	438	java/lang/Exception
    //   211	220	438	java/lang/Exception
    //   229	253	438	java/lang/Exception
    //   14	34	465	java/lang/OutOfMemoryError
    //   39	79	465	java/lang/OutOfMemoryError
    //   87	117	465	java/lang/OutOfMemoryError
    //   127	147	465	java/lang/OutOfMemoryError
    //   151	161	465	java/lang/OutOfMemoryError
    //   164	171	465	java/lang/OutOfMemoryError
    //   178	192	465	java/lang/OutOfMemoryError
    //   201	209	465	java/lang/OutOfMemoryError
    //   211	220	465	java/lang/OutOfMemoryError
    //   229	253	465	java/lang/OutOfMemoryError
    //   256	275	492	org/json/JSONException
    //   275	294	526	org/json/JSONException
    //   294	315	560	org/json/JSONException
    //   315	336	594	org/json/JSONException
    //   336	362	775	java/lang/Exception
    //   370	397	775	java/lang/Exception
    //   400	407	775	java/lang/Exception
    //   414	429	775	java/lang/Exception
    //   635	650	775	java/lang/Exception
    //   650	668	809	java/lang/Exception
    //   692	715	844	org/json/JSONException
    //   718	762	844	org/json/JSONException
  }
  
  public JSONArray a(String paramString)
  {
    Object localObject1;
    if (!a()) {
      localObject1 = this.jdField_a_of_type_Myr.a(paramString);
    }
    do
    {
      for (;;)
      {
        return localObject1;
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
        if (localObject1 == null) {
          break label128;
        }
        try
        {
          localJSONArray = new JSONArray((String)localObject1);
          localObject1 = localJSONArray;
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.e("AuthorizeConfig", 2, "Load server config for " + paramString);
              return localJSONArray;
            }
          }
          catch (JSONException localJSONException1) {}
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            JSONArray localJSONArray = null;
          }
        }
      }
      localObject2 = localJSONArray;
    } while (!QLog.isColorLevel());
    QLog.w("AuthorizeConfig", 2, "Decode " + paramString + " Config error");
    return localJSONArray;
    label128:
    return null;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = null;
    if (!a()) {
      localJSONObject = this.jdField_a_of_type_Myr.a();
    }
    String str;
    do
    {
      return localJSONObject;
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("schemes", null);
    } while (str == null);
    return new JSONObject(str);
  }
  
  public void a()
  {
    b();
  }
  
  public boolean a()
  {
    ((mys)this.jdField_a_of_type_Myr).b();
    return !this.jdField_a_of_type_Myr.a();
  }
  
  public String b()
  {
    if (!a()) {
      return this.jdField_a_of_type_Myr.b();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("extra", null);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public String c()
  {
    if (!a()) {
      return this.jdField_a_of_type_Myr.c();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("jump", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myt
 * JD-Core Version:    0.7.0.1
 */