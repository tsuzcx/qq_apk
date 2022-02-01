package com.tencent.mobileqq.newnearby.util;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.newnearby.model.AddrInfo;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetCityMapReq;
import com.tencent.widget.ActionSheet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PickLocationHelper
{
  private static HashMap<String, AddrInfo> a;
  private static HashMap<String, AddrInfo> b;
  private static HashMap<String, AddrInfo> c;
  private static ArrayList<AddrInfo> d;
  private static ArrayList<AddrInfo> e;
  private static ArrayList<AddrInfo> f;
  private static AddrInfo g;
  private static AddrInfo h;
  private static AddrInfo i;
  private static ActionSheet j;
  private static IphonePickerView k;
  private static int l;
  private static int m;
  private static int n;
  private static boolean o;
  private static String p;
  private static String q;
  private static Handler r;
  
  private static IphonePickerView.IphonePickListener a(Promise paramPromise)
  {
    return new PickLocationHelper.4(paramPromise);
  }
  
  public static void a()
  {
    Object localObject = a;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = b;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = c;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = d;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = e;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = f;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = r;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      r = null;
    }
    o = false;
    p = "0";
    QLog.d("PickLocationHelper", 2, "release");
  }
  
  public static void a(NearbyActivity paramNearbyActivity)
  {
    nearbyControl.GetCityMapReq localGetCityMapReq = new nearbyControl.GetCityMapReq();
    ProtoUtils.a(paramNearbyActivity.getAppRuntime(), new PickLocationHelper.7(), localGetCityMapReq.toByteArray(), "trpc.nearby.trpc_nearby_control.nearby_control.GetCityMap");
  }
  
  public static void a(Promise paramPromise, String paramString)
  {
    Object localObject = j;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      return;
    }
    localObject = QBaseActivity.sTopActivity;
    if (o)
    {
      String str = p;
      if ((str != null) && (str.equals(paramString)))
      {
        b((Activity)localObject, paramPromise);
        return;
      }
    }
    if (r == null) {
      r = new Handler();
    }
    r.post(new PickLocationHelper.2(paramString, (Activity)localObject, paramPromise));
  }
  
  public static void a(String paramString)
  {
    if (r == null) {
      r = new Handler();
    }
    r.post(new PickLocationHelper.6(paramString));
  }
  
  private static void b(Activity paramActivity, Promise paramPromise)
  {
    long l1 = System.currentTimeMillis();
    j = ActionSheet.createMenuSheet(paramActivity);
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)j.findViewById(2131427560);
    localDispatchActionMoveScrollView.a = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    j.setCloseAutoRead(true);
    k = (IphonePickerView)paramActivity.getLayoutInflater().inflate(2131627482, null);
    k.a(q());
    k.setPickListener(a(paramPromise));
    k.setSelection(0, l);
    k.setSelection(1, m);
    k.setSelection(2, n);
    j.setOnDismissListener(new PickLocationHelper.3());
    j.setActionContentView(k, null);
    j.show();
    long l2 = System.currentTimeMillis();
    paramActivity = new StringBuilder();
    paramActivity.append("showPickerView-initUI, time cost = ");
    paramActivity.append(l2 - l1);
    paramActivity.append("ms");
    QLog.d("PickLocationHelper", 2, paramActivity.toString());
  }
  
  private static void e(String paramString)
  {
    Object localObject1 = p;
    if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
    {
      QLog.d("PickLocationHelper", 2, "initShowMap noNeed and return");
      return;
    }
    d = new ArrayList();
    e = new ArrayList();
    f = new ArrayList();
    long l1 = System.currentTimeMillis();
    localObject1 = g(paramString);
    long l2 = System.currentTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initShowMap-checkValid, time cost = ");
    ((StringBuilder)localObject2).append(l2 - l1);
    ((StringBuilder)localObject2).append("ms");
    QLog.d("PickLocationHelper", 2, ((StringBuilder)localObject2).toString());
    l1 = System.currentTimeMillis();
    localObject2 = a.keySet().iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if (str.equals(((ArrayList)localObject1).get(0)))
      {
        l = d.size();
        g = (AddrInfo)a.get(str);
      }
      d.add(a.get(str));
    }
    localObject2 = b.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if (((AddrInfo)b.get(str)).b.equals(((ArrayList)localObject1).get(0)))
      {
        if (str.equals(((ArrayList)localObject1).get(1)))
        {
          m = e.size();
          h = (AddrInfo)b.get(str);
        }
        e.add(b.get(str));
      }
    }
    localObject2 = c.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if (((AddrInfo)c.get(str)).b.equals(((ArrayList)localObject1).get(1)))
      {
        if (str.equals(((ArrayList)localObject1).get(2)))
        {
          n = f.size();
          i = (AddrInfo)c.get(str);
        }
        f.add(c.get(str));
      }
    }
    p = paramString;
    l2 = System.currentTimeMillis();
    paramString = new StringBuilder();
    paramString.append("initShowMap-initList, time cost = ");
    paramString.append(l2 - l1);
    paramString.append("ms");
    QLog.d("PickLocationHelper", 2, paramString.toString());
  }
  
  private static ArrayList<String> f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString.substring(0, 2));
    localArrayList.add(paramString.substring(0, 4));
    localArrayList.add(paramString.substring(0, 6));
    return localArrayList;
  }
  
  private static ArrayList<String> g(String paramString)
  {
    if (!h(paramString)) {
      return new PickLocationHelper.1();
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString.substring(0, 2));
    localArrayList.add(paramString.substring(0, 4));
    localArrayList.add(paramString.substring(0, 6));
    return localArrayList;
  }
  
  private static boolean h(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() != 6) {
        return false;
      }
      try
      {
        Object localObject = new JSONArray(i(q));
        int i2 = ((JSONArray)localObject).length();
        int i1 = 0;
        while (i1 < i2)
        {
          boolean bool = ((JSONObject)((JSONArray)localObject).get(i1)).optString("code").equals(paramString);
          if (bool) {
            return true;
          }
          i1 += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkCode error=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("PickLocationHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static String i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = new InputStreamReader(new FileInputStream(paramString), "UTF-8");
      localObject = new BufferedReader(paramString);
      for (;;)
      {
        int i1 = ((BufferedReader)localObject).read();
        if (i1 == -1) {
          break;
        }
        localStringBuilder.append((char)i1);
      }
      paramString.close();
    }
    catch (IOException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readJsonFile fail, error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("PickLocationHelper", 2, ((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  private static void o()
  {
    for (;;)
    {
      int i1;
      try
      {
        if (o)
        {
          QLog.d("PickLocationHelper", 2, "loadJson noNeed and return");
          return;
        }
        long l1 = System.currentTimeMillis();
        a();
        r();
        Object localObject1 = new JSONArray(i(q));
        int i2 = ((JSONArray)localObject1).length();
        i1 = 0;
        if (i1 < i2)
        {
          Object localObject4 = (JSONObject)((JSONArray)localObject1).get(i1);
          localObject2 = f(((JSONObject)localObject4).optString("code"));
          Object localObject3 = ((JSONObject)localObject4).optString("name");
          String str = ((JSONObject)localObject4).optString("latitude");
          localObject4 = ((JSONObject)localObject4).optString("longitude");
          localObject3 = ((String)localObject3).split(",");
          if ((localObject3.length > 2) && (!a.containsKey(((ArrayList)localObject2).get(0)))) {
            a.put(((ArrayList)localObject2).get(0), new AddrInfo((String)((ArrayList)localObject2).get(0), "", localObject3[1], str, (String)localObject4));
          }
          if ((localObject3.length > 2) && (!b.containsKey(((ArrayList)localObject2).get(1))))
          {
            b.put(((ArrayList)localObject2).get(1), new AddrInfo((String)((ArrayList)localObject2).get(1), (String)((ArrayList)localObject2).get(0), localObject3[2], str, (String)localObject4));
            if ((localObject3.length <= 3) || (c.containsKey(((ArrayList)localObject2).get(2)))) {
              break label425;
            }
            c.put(((ArrayList)localObject2).get(2), new AddrInfo((String)((ArrayList)localObject2).get(2), (String)((ArrayList)localObject2).get(1), localObject3[3], str, (String)localObject4));
            break label425;
          }
        }
        else
        {
          o = true;
          long l2 = System.currentTimeMillis();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadJson, time cost = ");
          ((StringBuilder)localObject1).append(l2 - l1);
          ((StringBuilder)localObject1).append("ms");
          QLog.d("PickLocationHelper", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadJson error=");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.e("PickLocationHelper", 2, ((StringBuilder)localObject2).toString());
        return;
      }
      continue;
      label425:
      i1 += 1;
    }
  }
  
  private static void p()
  {
    Object localObject = i;
    if (localObject != null)
    {
      p = ((AddrInfo)localObject).a;
      return;
    }
    if (h != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(h.a);
      ((StringBuilder)localObject).append("00");
      p = ((StringBuilder)localObject).toString();
      return;
    }
    if (g != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(g.a);
      ((StringBuilder)localObject).append("0000");
      p = ((StringBuilder)localObject).toString();
      return;
    }
    p = "0";
  }
  
  private static IphonePickerView.PickerViewAdapter q()
  {
    return new PickLocationHelper.5();
  }
  
  private static void r()
  {
    a = new HashMap();
    b = new HashMap();
    c = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickLocationHelper
 * JD-Core Version:    0.7.0.1
 */