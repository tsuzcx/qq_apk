package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SlidingUpDialog;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/mobileqq/kandian/biz/diandian/entryview/RIJEntryViewUtils$showEntryDialog$1$3"}, k=3, mv={1, 1, 16})
final class RIJEntryViewUtils$showEntryDialog$$inlined$let$lambda$3
  extends Lambda
  implements Function0<Unit>
{
  RIJEntryViewUtils$showEntryDialog$$inlined$let$lambda$3(Activity paramActivity, ColumnInfo paramColumnInfo, CommunityInfo paramCommunityInfo, int paramInt1, String paramString, int paramInt2, SlidingUpDialog paramSlidingUpDialog)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$dialog$inlined.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.3
 * JD-Core Version:    0.7.0.1
 */