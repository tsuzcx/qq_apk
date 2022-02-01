package com.tencent.mobileqq.profilecard.bussiness.guide;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideObserver;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/profilecard/bussiness/guide/ProfileGuideComponent$guideObserver$1", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideObserver;", "onGetProfileGuide", "", "success", "", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideComponent$guideObserver$1
  extends ProfileGuideObserver
{
  public void onGetProfileGuide(boolean paramBoolean, @Nullable ProfileGuide paramProfileGuide)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[2];
      localObject[0] = Boolean.valueOf(paramBoolean);
      localObject[1] = paramProfileGuide;
      localObject = String.format("onGetProfileGuide success=%s profileGuide=%s", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      QLog.d("ProfileGuideComponent", 0, (String)localObject);
    }
    if (paramBoolean) {
      ProfileGuideComponent.access$handleGetProfileGuide(this.this$0, paramProfileGuide);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent.guideObserver.1
 * JD-Core Version:    0.7.0.1
 */