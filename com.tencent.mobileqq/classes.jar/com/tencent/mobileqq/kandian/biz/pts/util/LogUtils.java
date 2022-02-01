package com.tencent.mobileqq.kandian.biz.pts.util;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogUtils
{
  public static void a(@NonNull View paramView, String paramString)
  {
    if (a()) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        a(paramView, localJSONObject);
        paramView = new StringBuilder();
        paramView.append("logViewHierarchy: ");
        paramView.append(localJSONObject.toString());
        a(paramString, paramView.toString());
        return;
      }
      catch (Exception paramView)
      {
        QLog.e(paramString, 1, "[logViewHierarchy] ", paramView);
      }
    }
  }
  
  public static void a(@NonNull View paramView, @NonNull JSONObject paramJSONObject)
  {
    int i = paramView.getLeft();
    int j = paramView.getRight();
    int k = paramView.getTop();
    int m = paramView.getBottom();
    Object localObject1 = paramView.getClass().getSimpleName();
    Object localObject2 = new Rect(i, k, j, m);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", localObject1);
    localJSONObject.put("visibility", paramView.getVisibility());
    localJSONObject.put("bounds", localObject2);
    paramJSONObject.put("view", localJSONObject);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      j = paramView.getChildCount();
      localObject1 = new JSONArray();
      i = 0;
      while (i < j)
      {
        localObject2 = new JSONObject();
        a(paramView.getChildAt(i), (JSONObject)localObject2);
        ((JSONArray)localObject1).put(localObject2);
        i += 1;
      }
      paramJSONObject.put("children", localObject1);
    }
  }
  
  public static void a(@NonNull ViewBase paramViewBase, String paramString)
  {
    if (a()) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        a(paramViewBase, localJSONObject);
        paramViewBase = new StringBuilder();
        paramViewBase.append("logViewBaseHierarchy: ");
        paramViewBase.append(localJSONObject.toString());
        a(paramString, paramViewBase.toString());
        return;
      }
      catch (Exception paramViewBase)
      {
        QLog.e(paramString, 1, "[logViewBaseHierarchy] ", paramViewBase);
      }
    }
  }
  
  private static void a(@NonNull ViewBase paramViewBase, @NonNull JSONObject paramJSONObject)
  {
    Object localObject1 = new Rect(paramViewBase.getDrawLeft(), paramViewBase.getDrawTop(), paramViewBase.getWidth(), paramViewBase.getHeight());
    Object localObject2 = paramViewBase.getClass().getSimpleName();
    Object localObject3 = paramViewBase.getName();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", localObject2);
    localJSONObject.put("id", localObject3);
    localJSONObject.put("visibility", paramViewBase.getVisibility());
    localJSONObject.put("bounds", localObject1);
    paramJSONObject.put("view", localJSONObject);
    if ((paramViewBase instanceof Layout))
    {
      localObject1 = ((Layout)paramViewBase).getSubViews();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramViewBase = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ViewBase)((Iterator)localObject1).next();
          localObject3 = new JSONObject();
          a((ViewBase)localObject2, (JSONObject)localObject3);
          paramViewBase.put(localObject3);
        }
        paramJSONObject.put("children", paramViewBase);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public static boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.LogUtils
 * JD-Core Version:    0.7.0.1
 */