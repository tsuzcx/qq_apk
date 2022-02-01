package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.WormholeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;
import com.tencent.viola.vinstance.VInstanceManager;
import com.tencent.viola.vinstance.VInstanceManager.Builder;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Wormhole
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ArrayMap();
  
  public static void a()
  {
    if (a()) {
      return;
    }
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    Object localObject = ReadInJoyWebDataManager.a;
    localObject = new VInstanceManager.Builder().application(BaseApplicationImpl.getApplication()).param(new JSONObject()).preconditionAdapter(new PreconditionAdapterImpl((String)localObject)).serviceJsUrl((String)localObject).isBlockingMode(false);
    VInstanceManager.getInstance().init((VInstanceManager.Builder)localObject);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    VInstanceManager.getInstance().onScroll(paramViewGroup, paramView, 0, 0);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!paramAbsBaseArticleInfo.isWormhole()) {
        return;
      }
      if (a()) {
        return;
      }
      a();
      b(paramAbsBaseArticleInfo);
    }
  }
  
  private static boolean a()
  {
    return WormholeConfigHandler.a() ^ true;
  }
  
  private static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().createVInstance(BaseArticleInfoKt.b(paramAbsBaseArticleInfo), BaseArticleInfoKt.a(paramAbsBaseArticleInfo));
  }
  
  public void a(View paramView)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().disappear(paramView);
  }
  
  public void a(View paramView, ViewGroup paramViewGroup)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().willAppear(paramView, paramViewGroup);
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (a()) {
      return;
    }
    if (paramAbsListView == null) {
      return;
    }
    int j = paramAbsListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramAbsListView.getChildAt(i);
      if ((localView instanceof WormholeView)) {
        a(paramAbsListView, ((WormholeView)localView).a());
      }
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().removeVInstanceEventListener(paramString);
  }
  
  public void a(String paramString, VInstanceAction.VInstanceEventListener paramVInstanceEventListener)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().addVInstanceEventListener(paramString, paramVInstanceEventListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().createVInstance(paramString1, paramString2);
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, View paramView)
  {
    if (a()) {
      return false;
    }
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    String str = BaseArticleInfoKt.b(paramAbsBaseArticleInfo);
    this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(paramInt));
    return VInstanceManager.getInstance().bindData(str, BaseArticleInfoKt.a(paramAbsBaseArticleInfo), paramView);
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pageDestroy", 1);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    VInstanceManager.getInstance().release(new ArrayList(this.jdField_a_of_type_JavaUtilMap.keySet()), localJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.Wormhole
 * JD-Core Version:    0.7.0.1
 */