package com.tencent.mobileqq.profile.like;

import SummaryCard.TPraiseInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class PraiseConfigHelper
{
  public static Vector<String> a;
  public static Vector<PraiseConfigHelper.EntryBannerInfo> b;
  public static int c = 10;
  public static int d = 2000;
  public static int e = 0;
  private static AtomicBoolean f = new AtomicBoolean(false);
  
  public static List<TPraiseInfo> a(List<TPraiseInfo> paramList)
  {
    if ((e == 0) && (paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TPraiseInfo localTPraiseInfo = (TPraiseInfo)paramList.next();
        if (localTPraiseInfo.uCustomId > 0L) {
          localArrayList1.add(localTPraiseInfo);
        } else {
          localArrayList2.add(localTPraiseInfo);
        }
      }
      localArrayList1.addAll(localArrayList2);
      return localArrayList1;
    }
    return paramList;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    try
    {
      QLog.e("PraiseConfigHelper", 1, "parseJson, app null");
      return;
    }
    finally
    {
      for (;;)
      {
        boolean bool;
        JSONObject localJSONObject;
        Object localObject2;
        Object localObject1;
        int j;
        String str;
        for (;;)
        {
          throw paramAppRuntime;
        }
        int i = 0;
        continue;
        i += 1;
        continue;
        i = 0;
        continue;
        j += 1;
        continue;
        i += 1;
      }
    }
    bool = f.compareAndSet(false, true);
    if (!bool) {
      return;
    }
    localJSONObject = VasUpdateUtil.a(paramAppRuntime, "praise.config.json", true, null);
    if (localJSONObject != null)
    {
      localObject2 = localJSONObject.optJSONArray("colorEntries");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        if (a == null)
        {
          a = new Vector();
          break label457;
        }
        a.clear();
        break label457;
        if (i < ((JSONArray)localObject2).length())
        {
          localObject1 = ((JSONArray)localObject2).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label462;
          }
          paramAppRuntime = (AppRuntime)localObject1;
          if (!((String)localObject1).startsWith("http:"))
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("http:");
            paramAppRuntime.append((String)localObject1);
            paramAppRuntime = paramAppRuntime.toString();
          }
          a.add(paramAppRuntime);
          break label462;
        }
      }
      paramAppRuntime = localJSONObject.optJSONArray("newEntries");
      if ((paramAppRuntime != null) && (paramAppRuntime.length() > 0))
      {
        if (b == null)
        {
          b = new Vector();
          break label469;
        }
        b.clear();
        break label469;
        if (i < paramAppRuntime.length())
        {
          localObject2 = paramAppRuntime.optJSONObject(i);
          if (localObject2 == null) {
            break label481;
          }
          localObject1 = new PraiseConfigHelper.EntryBannerInfo();
          ((PraiseConfigHelper.EntryBannerInfo)localObject1).a = ((JSONObject)localObject2).optString("title");
          ((PraiseConfigHelper.EntryBannerInfo)localObject1).b = ((JSONObject)localObject2).optString("subtitle");
          ((PraiseConfigHelper.EntryBannerInfo)localObject1).d = ((JSONObject)localObject2).optString("bannerLink");
          ((PraiseConfigHelper.EntryBannerInfo)localObject1).e = ((JSONObject)localObject2).optString("reportName");
          ((PraiseConfigHelper.EntryBannerInfo)localObject1).c = new Vector();
          localObject2 = ((JSONObject)localObject2).optJSONArray("entrys");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              str = ((JSONArray)localObject2).optJSONObject(j).optString("icon");
              if (TextUtils.isEmpty(str)) {
                break label474;
              }
              ((PraiseConfigHelper.EntryBannerInfo)localObject1).c.add(str);
              break label474;
            }
          }
          b.add(localObject1);
          break label481;
        }
      }
      c = localJSONObject.optInt("playNum", 10);
      d = (int)(localJSONObject.optDouble("downloadTimeLimit", 2.0D) * 1000.0D);
      e = localJSONObject.optInt("praiseFlyOrder", 0);
    }
    else
    {
      f.set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseConfigHelper
 * JD-Core Version:    0.7.0.1
 */