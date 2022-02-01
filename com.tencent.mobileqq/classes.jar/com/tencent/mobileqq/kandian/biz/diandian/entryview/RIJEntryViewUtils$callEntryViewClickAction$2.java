package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.os.Bundle;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJEntryViewUtils$callEntryViewClickAction$2
  extends Lambda
  implements Function0<Unit>
{
  RIJEntryViewUtils$callEntryViewClickAction$2(int paramInt, String paramString, CommunityInfo paramCommunityInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    RIJEntryViewUtils.a.a(this.$from, new Bundle(), this.$callback, this.$kdCommunityInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils.callEntryViewClickAction.2
 * JD-Core Version:    0.7.0.1
 */