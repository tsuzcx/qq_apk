import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.widget.AbsListView;

public class rlm
  implements rkk, rkm
{
  private static boolean a;
  
  public static void f()
  {
    a = false;
    SharedPreferences.Editor localEditor = bhvh.a(onk.a(), true, false).edit();
    localEditor.putBoolean("key_read_injoy_fast_web_share_guide", false);
    localEditor.commit();
  }
  
  public int a(BaseData paramBaseData)
  {
    return 17;
  }
  
  public rkj a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559924, null);
    ((TextView)paramContext.findViewById(2131378206)).setTextSize(0, Utils.dp2px(15.0D));
    return new rln(paramContext, paramBaseData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.p == 19;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if (a) {
      f();
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlm
 * JD-Core Version:    0.7.0.1
 */