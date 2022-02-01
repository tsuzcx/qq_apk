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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;

public class szn
  implements tax
{
  private float jdField_a_of_type_Float;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
  
  private ImageView a(ListView paramListView)
  {
    if ((paramListView != null) && (paramListView.getOverScrollFooterView() != null)) {
      return (ImageView)paramListView.getOverScrollFooterView().findViewById(2131369485);
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    return (String)bmhv.a("kandian_daily_wrapper_default_text", paramContext.getResources().getString(2131717676));
  }
  
  public static void a(int paramInt)
  {
    pqg localpqg = pqf.a();
    localpqg.b("jump_src", plm.b());
    localpqg.b("entrance", "" + paramInt);
    localpqg.b("cmd", bmhv.h());
    olh.a(null, "", "0X8009883", "0X8009883", 0, 0, "", "", "", localpqg.a(), false);
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    List localList = pvj.a().a(Integer.valueOf(plm.b()));
    if ((localList != null) && (!localList.isEmpty()))
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      puz localpuz = new puz();
      localpuz.jdField_a_of_type_Long = ((Long)localList.get(localList.size() - 1)).longValue();
      localpuz.jdField_a_of_type_Int = 13;
      localKandianMergeManager.a(localpuz);
    }
    paramActivity.finish();
    paramActivity.overridePendingTransition(2130771990, 2130772342);
    localBundle.putString("folder_status", pin.a());
    localBundle.putBoolean("force_refresh", true);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    osg.a((QQAppInterface)pkh.a(), paramActivity, 13, 0, localBundle);
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
    if (orj.a() == 1)
    {
      a((Activity)paramListView.getContext());
      a(1);
    }
    String str;
    do
    {
      return;
      str = plm.a();
    } while (TextUtils.isEmpty(str));
    pkh.a(paramListView.getContext(), str);
    a(1);
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
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt);
    if (paramInt == 1) {
      a(paramListView);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisable] ");
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] " + paramInt);
    if (paramInt == 1) {
      b(paramListView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewNotCompleteVisableAndReleased] " + paramInt);
    if (paramInt != 1) {}
    do
    {
      return;
      a(paramListView);
    } while (this.jdField_a_of_type_Float <= plm.a());
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] ");
    b(paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szn
 * JD-Core Version:    0.7.0.1
 */