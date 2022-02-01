package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.common.FileUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class AbsManageTopicPage$uploadAndUpdateCover$1
  extends Lambda
  implements Function0<Unit>
{
  AbsManageTopicPage$uploadAndUpdateCover$1(String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    FileUtils.a.b(this.$pathForDelete);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.AbsManageTopicPage.uploadAndUpdateCover.1
 * JD-Core Version:    0.7.0.1
 */