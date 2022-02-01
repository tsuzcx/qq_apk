package com.tencent.mobileqq.profilecard.bussiness.guide.handler;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideObserver;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "()V", "onGetProfileGuide", "", "success", "", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "onReportProfileGuideRead", "onUpdate", "type", "", "data", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (paramObject != null) {}
      for (paramObject = (ProfileGuide)paramObject;; paramObject = null)
      {
        onGetProfileGuide(paramBoolean, paramObject);
        return;
      }
    }
    onReportProfileGuideRead(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideObserver
 * JD-Core Version:    0.7.0.1
 */