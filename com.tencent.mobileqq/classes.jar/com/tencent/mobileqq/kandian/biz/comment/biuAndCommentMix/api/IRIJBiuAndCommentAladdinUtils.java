package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentAladdinUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "configBtnJump", "", "configGrayRegionJump", "configWhiteRegionJump", "getBiuAndCommentSwitch", "getBiuEditorCheckBoxHidden", "getBiuEditorCheckBoxWording", "", "getBiuEditorConfirmBtnWording", "getBiuEditorDefaultStatus", "getBiuEditorGuideWording", "getCommentGuideWording", "getEditorDefaultEnableRemember", "getOperationBarAladdinKey", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJBiuAndCommentAladdinUtils
  extends QRouteApi
{
  public abstract boolean configBtnJump();
  
  public abstract boolean configGrayRegionJump();
  
  public abstract boolean configWhiteRegionJump();
  
  public abstract boolean getBiuAndCommentSwitch();
  
  public abstract boolean getBiuEditorCheckBoxHidden();
  
  @Nullable
  public abstract String getBiuEditorCheckBoxWording();
  
  @Nullable
  public abstract String getBiuEditorConfirmBtnWording();
  
  public abstract boolean getBiuEditorDefaultStatus();
  
  @Nullable
  public abstract String getBiuEditorGuideWording();
  
  @Nullable
  public abstract String getCommentGuideWording();
  
  public abstract boolean getEditorDefaultEnableRemember();
  
  @Nullable
  public abstract String getOperationBarAladdinKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentAladdinUtils
 * JD-Core Version:    0.7.0.1
 */