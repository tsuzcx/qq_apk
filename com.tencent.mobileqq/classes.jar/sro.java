import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;
import com.tencent.viola.vinstance.VInstanceManager;
import com.tencent.viola.vinstance.VInstanceManager.Builder;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class sro
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ArrayMap();
  
  public static void a()
  {
    if (a()) {}
    while (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    Object localObject = qzi.a;
    localObject = new VInstanceManager.Builder().application(BaseApplicationImpl.getApplication()).param(new JSONObject()).preconditionAdapter(new srn((String)localObject)).serviceJsUrl((String)localObject).isBlockingMode(false);
    VInstanceManager.getInstance().init((VInstanceManager.Builder)localObject);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    VInstanceManager.getInstance().onScroll(paramViewGroup, paramView, 0, 0);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!paramBaseArticleInfo.isWormhole())) {}
    while (a()) {
      return;
    }
    a();
    b(paramBaseArticleInfo);
  }
  
  private static boolean a()
  {
    return !ouj.a();
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (a()) {
      return;
    }
    VInstanceManager.getInstance().createVInstance(paramBaseArticleInfo.getWormholeId(), paramBaseArticleInfo.getWormholeData());
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
    if (a()) {}
    for (;;)
    {
      return;
      if (paramAbsListView != null)
      {
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
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, int paramInt, View paramView)
  {
    if (a()) {}
    while (paramBaseArticleInfo == null) {
      return false;
    }
    String str = paramBaseArticleInfo.getWormholeId();
    this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(paramInt));
    return VInstanceManager.getInstance().bindData(str, paramBaseArticleInfo.getWormholeData(), paramView);
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
      VInstanceManager.getInstance().release(new ArrayList(this.jdField_a_of_type_JavaUtilMap.keySet()), localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sro
 * JD-Core Version:    0.7.0.1
 */