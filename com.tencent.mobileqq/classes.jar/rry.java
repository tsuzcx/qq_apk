import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;

public class rry
  implements rug
{
  private float jdField_a_of_type_Float;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
  
  private ImageView a(ListView paramListView)
  {
    if ((paramListView != null) && (paramListView.getOverScrollFooterView() != null)) {
      return (ImageView)paramListView.getOverScrollFooterView().findViewById(2131368838);
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    return (String)bjxj.a("kandian_daily_wrapper_default_text", paramContext.getResources().getString(2131718804));
  }
  
  public static void a(int paramInt)
  {
    orz localorz = ors.a();
    localorz.b("jump_src", otf.b());
    localorz.b("entrance", "" + paramInt);
    localorz.b("cmd", bjxj.g());
    nrt.a(null, "", "0X8009883", "0X8009883", 0, 0, "", "", "", localorz.a(), false);
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    List localList = owy.a().a(Integer.valueOf(otf.b()));
    if ((localList != null) && (!localList.isEmpty()))
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)ors.a().getManager(162);
      owo localowo = new owo();
      localowo.jdField_a_of_type_Long = ((Long)localList.get(localList.size() - 1)).longValue();
      localowo.jdField_a_of_type_Int = 13;
      localKandianMergeManager.a(localowo);
    }
    paramActivity.finish();
    paramActivity.overridePendingTransition(2130771990, 2130772333);
    localBundle.putString("folder_status", opt.a());
    localBundle.putBoolean("force_refresh", true);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    nxu.a((QQAppInterface)ors.a(), paramActivity, 13, 0, localBundle);
  }
  
  private void a(ListView paramListView)
  {
    paramListView = a(paramListView);
    if (paramListView == null) {
      return;
    }
    paramListView.setPivotX(paramListView.getWidth() / 2);
    paramListView.setPivotY(paramListView.getHeight() / 2);
    paramListView.setRotation(0.0F);
  }
  
  private void b(ListView paramListView)
  {
    if (nww.a() == 1)
    {
      a((Activity)paramListView.getContext());
      a(1);
    }
    String str;
    do
    {
      return;
      str = otf.a();
    } while (TextUtils.isEmpty(str));
    ors.a(paramListView.getContext(), str);
    a(1);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt);
    if (paramInt == 1) {
      a(paramListView);
    }
  }
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt1);
    if (paramInt1 == 1) {
      a(paramListView);
    }
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    float f1 = paramView.getHeight();
    float f2 = (float)(paramInt * 1.0D / f1);
    f1 = f2;
    if (f2 >= 1.0D) {
      f1 = 1.0F;
    }
    this.jdField_a_of_type_Float = f1;
    f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1);
    paramView = a(paramListView);
    if (paramView == null) {
      return;
    }
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setRotation(f1 * 180.0F);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] " + paramInt);
    if (paramInt == 1) {
      b(paramListView);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisable] ");
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewNotCompleteVisableAndReleased] " + paramInt);
    if (paramInt != 1) {}
    do
    {
      return;
      a(paramListView);
    } while (this.jdField_a_of_type_Float <= otf.a());
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] ");
    b(paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rry
 * JD-Core Version:    0.7.0.1
 */