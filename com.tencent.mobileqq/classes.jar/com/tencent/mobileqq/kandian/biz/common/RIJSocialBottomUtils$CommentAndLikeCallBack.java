package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJSocialBottomUtils$CommentAndLikeCallBack;", "Lcom/tencent/mobileqq/kandian/repo/fastweb/FastWebModule$FastWebArticleRichReqCallback;", "Lcom/tencent/mobileqq/kandian/biz/comment/data/ReadInJoyCommentDataManager$OnDataChangeListener;", "articleRowkey", "", "bottomSocialView", "Lcom/tencent/mobileqq/kandian/biz/fastweb/ReadInJoyFastWebBottomSocialViewNew;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "fastWebInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "(Ljava/lang/String;Lcom/tencent/mobileqq/kandian/biz/fastweb/ReadInJoyFastWebBottomSocialViewNew;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;)V", "getArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getArticleRowkey", "()Ljava/lang/String;", "setArticleRowkey", "(Ljava/lang/String;)V", "getBottomSocialView", "()Lcom/tencent/mobileqq/kandian/biz/fastweb/ReadInJoyFastWebBottomSocialViewNew;", "setBottomSocialView", "(Lcom/tencent/mobileqq/kandian/biz/fastweb/ReadInJoyFastWebBottomSocialViewNew;)V", "getFastWebInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "setFastWebInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;)V", "handleLikeStateResp", "", "isLiked", "", "rowKey", "onCommentBlock", "commentType", "", "success", "deleteCommentsPair", "Lcom/tencent/util/Pair;", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;", "onCommentCreate", "newComment", "Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;", "recordHotHisPos", "commentViewItemList", "", "feedsType", "onCommentDelete", "deleteComment", "onCommentLikeOrDislike", "commentData", "opType", "value", "onCommentListLoad", "totalCommentDataList", "hasNextPage", "flow", "onCommentLoadMore", "onCommentReply", "replyComment", "onCommentReport", "firstCommentID", "secondCommentID", "onCommentStateError", "code", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJSocialBottomUtils$CommentAndLikeCallBack
  extends FastWebModule.FastWebArticleRichReqCallback
  implements ReadInJoyCommentDataManager.OnDataChangeListener
{
  @Nullable
  private String a;
  @Nullable
  private ReadInJoyFastWebBottomSocialViewNew b;
  @Nullable
  private final AbsBaseArticleInfo c;
  @Nullable
  private FastWebArticleInfo d;
  
  public RIJSocialBottomUtils$CommentAndLikeCallBack()
  {
    this(null, null, null, null, 15, null);
  }
  
  public RIJSocialBottomUtils$CommentAndLikeCallBack(@Nullable String paramString, @Nullable ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    this.a = paramString;
    this.b = paramReadInJoyFastWebBottomSocialViewNew;
    this.c = paramAbsBaseArticleInfo;
    this.d = paramFastWebArticleInfo;
  }
  
  public final void a(@Nullable ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew)
  {
    this.b = paramReadInJoyFastWebBottomSocialViewNew;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleLikeStateResp back! isLiked=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", rowKey=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", articleRowkey=");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("RIJSocialBottomUtils", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if ((localObject != null) && (StringsKt.equals((String)localObject, paramString, true)) && (this.b != null))
    {
      paramString = this.d;
      if (paramString != null) {
        paramString.h = paramBoolean;
      }
      RIJSocialBottomUtils.a.a(this.c, this.d);
    }
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, @Nullable Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, @NotNull CommentViewItem paramCommentViewItem, @NotNull List<? extends CommentViewItem> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "newComment");
    Intrinsics.checkParameterIsNotNull(paramList, "commentViewItemList");
  }
  
  public void onCommentCreate(boolean paramBoolean1, @NotNull CommentViewItem paramCommentViewItem, boolean paramBoolean2, @NotNull List<? extends CommentViewItem> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "newComment");
    Intrinsics.checkParameterIsNotNull(paramList, "commentViewItemList");
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, @NotNull CommentViewItem paramCommentViewItem, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "deleteComment");
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, @NotNull BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseCommentData, "commentData");
  }
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, @NotNull List<? extends CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "totalCommentDataList");
    paramList = ReadInJoyCommentDataManager.a(this.c);
    QLog.d("RIJSocialBottomUtils", 1, "onCommentListLoad back! ");
    if (paramList != null)
    {
      long l = paramList.h();
      paramList = this.d;
      if (paramList != null) {
        paramList.d = l;
      }
      RIJSocialBottomUtils.a.a(this.c, this.d);
      paramList = new StringBuilder();
      paramList.append("onCommentListLoad back!  count=");
      paramList.append(l);
      QLog.d("RIJSocialBottomUtils", 1, paramList.toString());
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, @NotNull List<? extends CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "totalCommentDataList");
  }
  
  public void onCommentReply(boolean paramBoolean, @NotNull CommentViewItem paramCommentViewItem)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "replyComment");
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "firstCommentID");
    Intrinsics.checkParameterIsNotNull(paramString2, "secondCommentID");
  }
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.CommentAndLikeCallBack
 * JD-Core Version:    0.7.0.1
 */