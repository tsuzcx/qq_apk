package com.tencent.mobileqq.profilecard.bussiness.guide.handler;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideObserver;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "()V", "onGetProfileGuide", "", "success", "", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "onReportProfileGuideRead", "onUpdate", "type", "", "data", "", "Companion", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public class ProfileGuideObserver
  implements BusinessObserver
{
  public static final ProfileGuideObserver.Companion Companion = new ProfileGuideObserver.Companion(null);
  public static final int ON_GET_PROFILE_GUIDE = 1;
  public static final int ON_REPORT_PROFILE_GUIDE_READ = 2;
  
  public void onGetProfileGuide(boolean paramBoolean, @Nullable ProfileGuide paramProfileGuide) {}
  
  public void onReportProfileGuideRead(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, @Nullable Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      onReportProfileGuideRead(paramBoolean);
      return;
    }
    if (paramObject != null) {
      paramObject = (ProfileGuide)paramObject;
    } else {
      paramObject = null;
    }
    onGetProfileGuide(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideObserver
 * JD-Core Version:    0.7.0.1
 */