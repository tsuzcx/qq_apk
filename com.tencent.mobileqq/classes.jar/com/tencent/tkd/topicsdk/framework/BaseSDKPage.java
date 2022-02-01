package com.tencent.tkd.topicsdk.framework;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "Lcom/tencent/tkd/topicsdk/framework/BasePage;", "()V", "isNightMode", "", "()Z", "afterActivityFinish", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BaseSDKPage
  extends BasePage
{
  public void d()
  {
    super.d();
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null)
        {
          localObject = ((View)localObject).getWindowToken();
          if (localObject != null)
          {
            Activity localActivity = a();
            if (localActivity != null)
            {
              InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
              Intrinsics.checkExpressionValueIsNotNull(localActivity, "it");
              localInputMethodUtils.a((Context)localActivity, (IBinder)localObject);
            }
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    return TopicSDK.a.a().a().a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BaseSDKPage
 * JD-Core Version:    0.7.0.1
 */