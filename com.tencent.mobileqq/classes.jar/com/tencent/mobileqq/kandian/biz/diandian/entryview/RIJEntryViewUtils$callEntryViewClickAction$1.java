package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJEntryViewUtils$callEntryViewClickAction$1
  extends Lambda
  implements Function0<Unit>
{
  RIJEntryViewUtils$callEntryViewClickAction$1(Activity paramActivity, ColumnInfo paramColumnInfo, CommunityInfo paramCommunityInfo, int paramInt1, String paramString, int paramInt2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    RIJUgcUtils.a(this.$activity, this.$columnInfo, this.$kdCommunityInfo, this.$from, this.$callback, this.$requestCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils.callEntryViewClickAction.1
 * JD-Core Version:    0.7.0.1
 */