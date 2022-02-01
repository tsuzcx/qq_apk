package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl;

import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="biu和评论融合已经干掉了")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/impl/RIJBiuAndCommentAladdinUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentAladdinUtils;", "()V", "configBtnJump", "", "configGrayRegionJump", "configWhiteRegionJump", "getBiuAndCommentSwitch", "getBiuEditorCheckBoxHidden", "getBiuEditorCheckBoxWording", "", "getBiuEditorConfirmBtnWording", "getBiuEditorDefaultStatus", "getBiuEditorGuideWording", "getCommentGuideWording", "getEditorDefaultEnableRemember", "getOperationBarAladdinKey", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBiuAndCommentAladdinUtilsImpl
  implements IRIJBiuAndCommentAladdinUtils
{
  public boolean configBtnJump()
  {
    return RIJBiuAndCommentAladdinUtils.l();
  }
  
  public boolean configGrayRegionJump()
  {
    return RIJBiuAndCommentAladdinUtils.k();
  }
  
  public boolean configWhiteRegionJump()
  {
    return RIJBiuAndCommentAladdinUtils.j();
  }
  
  public boolean getBiuAndCommentSwitch()
  {
    return RIJBiuAndCommentAladdinUtils.a();
  }
  
  public boolean getBiuEditorCheckBoxHidden()
  {
    return RIJBiuAndCommentAladdinUtils.h();
  }
  
  @Nullable
  public String getBiuEditorCheckBoxWording()
  {
    return RIJBiuAndCommentAladdinUtils.e();
  }
  
  @Nullable
  public String getBiuEditorConfirmBtnWording()
  {
    return RIJBiuAndCommentAladdinUtils.d();
  }
  
  public boolean getBiuEditorDefaultStatus()
  {
    return RIJBiuAndCommentAladdinUtils.f();
  }
  
  @Nullable
  public String getBiuEditorGuideWording()
  {
    return RIJBiuAndCommentAladdinUtils.c();
  }
  
  @Nullable
  public String getCommentGuideWording()
  {
    return RIJBiuAndCommentAladdinUtils.b();
  }
  
  public boolean getEditorDefaultEnableRemember()
  {
    return RIJBiuAndCommentAladdinUtils.g();
  }
  
  @Nullable
  public String getOperationBarAladdinKey()
  {
    return RIJBiuAndCommentAladdinUtils.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl.RIJBiuAndCommentAladdinUtilsImpl
 * JD-Core Version:    0.7.0.1
 */