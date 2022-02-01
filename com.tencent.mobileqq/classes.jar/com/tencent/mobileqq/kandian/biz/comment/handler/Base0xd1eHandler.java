package com.tencent.mobileqq.kandian.biz.comment.handler;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AtData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.HerfData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.LinkData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RptData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.TextData;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/handler/Base0xd1eHandler;", "", "()V", "genLinkData", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$LinkData;", "commentLinkData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentLinkData;", "genRptData", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$RptData;", "commentRptData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "genAtData", "", "genTextData", "genTopicData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class Base0xd1eHandler
{
  public static final Base0xd1eHandler a = new Base0xd1eHandler();
  
  private final void a(@NotNull oidb_0xd1e.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(0);
    paramRptData = paramRptData.text_data;
    oidb_0xd1e.TextData localTextData = new oidb_0xd1e.TextData();
    localTextData.content.set(paramCommentRptData.b);
    paramRptData.set((MessageMicro)localTextData);
  }
  
  private final void b(@NotNull oidb_0xd1e.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(3);
    paramRptData = paramRptData.herf_data;
    oidb_0xd1e.HerfData localHerfData = new oidb_0xd1e.HerfData();
    localHerfData.content.set(paramCommentRptData.b);
    paramRptData.set((MessageMicro)localHerfData);
  }
  
  private final void c(@NotNull oidb_0xd1e.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(1);
    paramRptData = paramRptData.at_data;
    oidb_0xd1e.AtData localAtData = new oidb_0xd1e.AtData();
    localAtData.content.set(paramCommentRptData.b);
    localAtData.uid.set(paramCommentRptData.c);
    paramRptData.set((MessageMicro)localAtData);
  }
  
  @NotNull
  public final oidb_0xd1e.LinkData a(@NotNull BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentLinkData, "commentLinkData");
    oidb_0xd1e.LinkData localLinkData = new oidb_0xd1e.LinkData();
    localLinkData.type.set(paramCommentLinkData.type);
    localLinkData.url.set(paramCommentLinkData.linkUrl);
    PBStringField localPBStringField = localLinkData.icon;
    String str = paramCommentLinkData.iconUrl;
    if (str == null) {
      str = "";
    }
    localPBStringField.set(str);
    localLinkData.wording.set(paramCommentLinkData.wording);
    return localLinkData;
  }
  
  @NotNull
  public final oidb_0xd1e.RptData a(@NotNull BaseCommentData.CommentRptData paramCommentRptData)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentRptData, "commentRptData");
    oidb_0xd1e.RptData localRptData = new oidb_0xd1e.RptData();
    int i = paramCommentRptData.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return localRptData;
        }
        a.b(localRptData, paramCommentRptData);
        return localRptData;
      }
      a.c(localRptData, paramCommentRptData);
      return localRptData;
    }
    a.a(localRptData, paramCommentRptData);
    return localRptData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.handler.Base0xd1eHandler
 * JD-Core Version:    0.7.0.1
 */