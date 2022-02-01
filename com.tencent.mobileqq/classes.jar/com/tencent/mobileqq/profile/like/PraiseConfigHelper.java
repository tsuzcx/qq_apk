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
  public static int a;
  public static Vector<String> a;
  private static AtomicBoolean a;
  public static int b;
  public static Vector<PraiseConfigHelper.EntryBannerInfo> b;
  public static int c = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = 10;
    jdField_b_of_type_Int = 2000;
  }
  
  public static List<TPraiseInfo> a(List<TPraiseInfo> paramList)
  {
    Object localObject = paramList;
    if (c == 0)
    {
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (!paramList.isEmpty())
        {
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TPraiseInfo localTPraiseInfo = (TPraiseInfo)paramList.next();
            if (localTPraiseInfo.uCustomId > 0L) {
              ((List)localObject).add(localTPraiseInfo);
            } else {
              localArrayList.add(localTPraiseInfo);
            }
          }
          ((List)localObject).addAll(localArrayList);
        }
      }
    }
    return localObject;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    JSONObject localJSONObject;
    Object localObject2;
    label86:
    int i;
    Object localObject1;
    for (;;)
    {
      try
      {
        QLog.e("PraiseConfigHelper", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        localJSONObject = VasUpdateUtil.a(paramAppRuntime, "praise.config.json", true, null);
        if (localJSONObject == null) {
          break label415;
        }
        localObject2 = localJSONObject.optJSONArray("colorEntries");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
          if (jdField_a_of_type_JavaUtilVector == null)
          {
            jdField_a_of_type_JavaUtilVector = new Vector();
            break label425;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject1 = ((JSONArray)localObject2).optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label430;
              }
              paramAppRuntime = (AppRuntime)localObject1;
              if (!((String)localObject1).startsWith("http:")) {
                paramAppRuntime = "http:" + (String)localObject1;
              }
              jdField_a_of_type_JavaUtilVector.add(paramAppRuntime);
              break label430;
            }
          }
          else
          {
            jdField_a_of_type_JavaUtilVector.clear();
            break label425;
          }
        }
      }
    }
    paramAppRuntime = localJSONObject.optJSONArray("newEntries");
    if ((paramAppRuntime != null) && (paramAppRuntime.length() > 0)) {
      if (jdField_b_of_type_JavaUtilVector == null)
      {
        jdField_b_of_type_JavaUtilVector = new Vector();
        break label437;
      }
    }
    for (;;)
    {
      label204:
      int j;
      if (i < paramAppRuntime.length())
      {
        localObject2 = paramAppRuntime.optJSONObject(i);
        if (localObject2 == null) {
          break label449;
        }
        localObject1 = new PraiseConfigHelper.EntryBannerInfo();
        ((PraiseConfigHelper.EntryBannerInfo)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("title");
        ((PraiseConfigHelper.EntryBannerInfo)localObject1).b = ((JSONObject)localObject2).optString("subtitle");
        ((PraiseConfigHelper.EntryBannerInfo)localObject1).c = ((JSONObject)localObject2).optString("bannerLink");
        ((PraiseConfigHelper.EntryBannerInfo)localObject1).d = ((JSONObject)localObject2).optString("reportName");
        ((PraiseConfigHelper.EntryBannerInfo)localObject1).jdField_a_of_type_JavaUtilVector = new Vector();
        localObject2 = ((JSONObject)localObject2).optJSONArray("entrys");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
          j = 0;
        }
      }
      for (;;)
      {
        if (j < ((JSONArray)localObject2).length())
        {
          String str = ((JSONArray)localObject2).optJSONObject(j).optString("icon");
          if (TextUtils.isEmpty(str)) {
            break label442;
          }
          ((PraiseConfigHelper.EntryBannerInfo)localObject1).jdField_a_of_type_JavaUtilVector.add(str);
          break label442;
          jdField_b_of_type_JavaUtilVector.clear();
        }
        else
        {
          jdField_b_of_type_JavaUtilVector.add(localObject1);
          break label449;
          jdField_a_of_type_Int = localJSONObject.optInt("playNum", 10);
          jdField_b_of_type_Int = (int)(localJSONObject.optDouble("downloadTimeLimit", 2.0D) * 1000.0D);
          c = localJSONObject.optInt("praiseFlyOrder", 0);
          label415:
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          break;
          label425:
          i = 0;
          break label86;
          label430:
          i += 1;
          break label86;
        }
        label437:
        i = 0;
        break label204;
        label442:
        j += 1;
      }
      label449:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseConfigHelper
 * JD-Core Version:    0.7.0.1
 */