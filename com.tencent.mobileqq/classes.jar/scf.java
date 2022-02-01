import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowHelper$Companion;", "", "()V", "DEFAULT_STEENGTHEN_ENABLE", "", "DEFAULT_STRENGTHEN_COUNT_LIMIT", "DEFAULT_STRENGTHEN_INTERVAL", "", "KEY_STRESS_COUNT", "", "KEY_STRESS_TIME", "SP_STRESS_COUNT", "TAG", "nowStressCount", "getNowStressCount", "()I", "setNowStressCount", "(I)V", "showStrengthenInterval", "getShowStrengthenInterval", "()F", "setShowStrengthenInterval", "(F)V", "stressCountLimit", "getStressCountLimit", "setStressCountLimit", "stressEnable", "", "getStressEnable", "()Z", "setStressEnable", "(Z)V", "cleanLastDayStressCount", "", "readStressCount", "saveStressCount", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class scf
{
  private final void a()
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("SP_STRESS_FOLLOW_LAYOUT_COUNT", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getC…NT, Context.MODE_PRIVATE)");
    localObject = ((SharedPreferences)localObject).edit();
    scf localscf = (scf)this;
    localscf.a(localscf.a() + 1);
    ((SharedPreferences.Editor)localObject).putInt("KEY_STRESS_FOLLOW_LAYOUT_COUNT", localscf.a()).putLong("KEY_STRESS_TIME", System.currentTimeMillis()).apply();
  }
  
  private final void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("SP_STRESS_FOLLOW_LAYOUT_COUNT", 0);
    Intrinsics.checkExpressionValueIsNotNull(localSharedPreferences, "BaseApplicationImpl.getC…NT, Context.MODE_PRIVATE)");
    ((scf)this).a(localSharedPreferences.getInt("KEY_STRESS_FOLLOW_LAYOUT_COUNT", 0));
    ((scf)this).c();
  }
  
  private final void c()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("SP_STRESS_FOLLOW_LAYOUT_COUNT", 0);
    Intrinsics.checkExpressionValueIsNotNull(localSharedPreferences, "BaseApplicationImpl.getC…NT, Context.MODE_PRIVATE)");
    if (!DateUtils.isToday(localSharedPreferences.getLong("KEY_STRESS_TIME", 0L))) {
      ((scf)this).a(0);
    }
  }
  
  public final int a()
  {
    return scd.a();
  }
  
  public final void a(int paramInt)
  {
    scd.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scf
 * JD-Core Version:    0.7.0.1
 */