package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJAppSetting;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/RIJAppSettingImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJAppSetting;", "()V", "getKanDianMode", "", "getVideoAutoPlaySetting", "", "isAppOnForeground", "", "context", "Landroid/content/Context;", "isInReadInJoyTabFrame", "updateNewKandianDeleteFlag", "", "isDelete", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAppSettingImpl
  implements IRIJAppSetting
{
  public int getKanDianMode()
  {
    return RIJAppSetting.b();
  }
  
  @Nullable
  public String getVideoAutoPlaySetting()
  {
    return RIJAppSetting.a();
  }
  
  public boolean isAppOnForeground(@Nullable Context paramContext)
  {
    return RIJAppSetting.a(paramContext);
  }
  
  public boolean isInReadInJoyTabFrame()
  {
    return RIJAppSetting.e();
  }
  
  public void updateNewKandianDeleteFlag(boolean paramBoolean)
  {
    RIJAppSetting.a(RIJQQAppInterfaceUtil.b(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.RIJAppSettingImpl
 * JD-Core Version:    0.7.0.1
 */