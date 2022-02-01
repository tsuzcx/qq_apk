package com.tencent.mobileqq.vas.adv.qzone.callback;

import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "", "onGetAdInfoResponse", "", "retCode", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "retMsg", "", "albumBasicData", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdMetaCallback
{
  public abstract void onGetAdInfoResponse(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @Nullable String paramString, @Nullable AlumBasicData paramAlumBasicData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback
 * JD-Core Version:    0.7.0.1
 */