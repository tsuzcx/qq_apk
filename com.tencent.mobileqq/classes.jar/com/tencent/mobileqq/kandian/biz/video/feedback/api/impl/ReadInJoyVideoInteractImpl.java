package com.tencent.mobileqq.kandian.biz.video.feedback.api.impl;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoInteract;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IReadInJoyVideoInteract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/impl/ReadInJoyVideoInteractImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/IReadInJoyVideoInteract;", "()V", "handleReadinjoyVideoIntent", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "intent", "Landroid/content/Intent;", "pendingIntent", "Landroid/app/PendingIntent;", "businessCategory", "", "wording", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyVideoInteractImpl
  implements IReadInJoyVideoInteract
{
  public void handleReadinjoyVideoIntent(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Intent paramIntent, @Nullable PendingIntent paramPendingIntent, @Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      ReadInJoyVideoInteract.a((QQAppInterface)paramBaseQQAppInterface, paramIntent, paramPendingIntent, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.feedback.api.impl.ReadInJoyVideoInteractImpl
 * JD-Core Version:    0.7.0.1
 */