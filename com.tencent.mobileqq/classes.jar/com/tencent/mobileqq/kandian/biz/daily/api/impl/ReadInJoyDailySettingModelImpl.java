package com.tencent.mobileqq.kandian.biz.daily.api.impl;

import com.tencent.mobileqq.kandian.biz.daily.api.IReadInJoyDailySettingModel;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/impl/ReadInJoyDailySettingModelImpl;", "Lcom/tencent/mobileqq/kandian/biz/daily/api/IReadInJoyDailySettingModel;", "()V", "getKvResult", "", "channelID", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyDailySettingModelImpl
  implements IReadInJoyDailySettingModel
{
  @Nullable
  public String getKvResult(int paramInt)
  {
    return ReadInJoyDailySettingModel.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.impl.ReadInJoyDailySettingModelImpl
 * JD-Core Version:    0.7.0.1
 */