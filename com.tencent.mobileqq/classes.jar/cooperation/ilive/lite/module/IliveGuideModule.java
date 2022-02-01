package cooperation.ilive.lite.module;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

public class IliveGuideModule
  extends RoomBizModule
{
  private static float a = 0.09745128F;
  private IliveLiteEventCenter.Observer b = new IliveGuideModule.1(this);
  
  private boolean a()
  {
    int j = b();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i;
    if (localIAudienceRoomPager != null) {
      i = getAudienceRoomPager().getCurrentIndex();
    } else {
      i = 0;
    }
    if (j == i) {
      bool = true;
    }
    return bool;
  }
  
  private int b()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private void c()
  {
    if ((a()) && (getAudienceRoomPager() != null))
    {
      cooperation.ilive.lite.report.IliveLiteDataReport.d = true;
      IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
      int i = (int)(ViewUtils.getScreenHeight() * a);
      int j = localIAudienceRoomPager.getScrollY();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ValueAnimator localValueAnimator1 = new ValueAnimator();
      localValueAnimator1.setIntValues(new int[] { i, 0 });
      localValueAnimator1.addUpdateListener(new IliveGuideModule.2(this, i, localIAudienceRoomPager, j));
      localValueAnimator1.setInterpolator(new AccelerateInterpolator());
      localValueAnimator1.setDuration(600L);
      ValueAnimator localValueAnimator2 = new ValueAnimator();
      localValueAnimator2.setIntValues(new int[] { 0, i });
      localValueAnimator2.addUpdateListener(new IliveGuideModule.3(this, i, localIAudienceRoomPager, j));
      localValueAnimator2.setInterpolator(new DecelerateInterpolator());
      localValueAnimator2.setDuration(300L);
      localAnimatorSet.play(localValueAnimator2).after(localValueAnimator1);
      localAnimatorSet.start();
      return;
    }
    QLog.e("IliveGuideModule", 1, "show Guide is not current item");
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    IliveLiteEventCenter.a().a(this.b);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.b);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    cooperation.ilive.lite.report.IliveLiteDataReport.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveGuideModule
 * JD-Core Version:    0.7.0.1
 */