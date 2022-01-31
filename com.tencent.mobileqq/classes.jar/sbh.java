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

public class sbh
  implements sai, sak
{
  private static boolean a;
  
  public static void f()
  {
    a = false;
    SharedPreferences.Editor localEditor = bjxj.a(ors.a(), true, false).edit();
    localEditor.putBoolean("key_read_injoy_fast_web_share_guide", false);
    localEditor.commit();
  }
  
  public int a(BaseData paramBaseData)
  {
    return 17;
  }
  
  public sah a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560023, null);
    ((TextView)paramContext.findViewById(2131378776)).setTextSize(0, Utils.dp2px(15.0D));
    return new sbi(paramContext, paramBaseData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.s == 19;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbh
 * JD-Core Version:    0.7.0.1
 */