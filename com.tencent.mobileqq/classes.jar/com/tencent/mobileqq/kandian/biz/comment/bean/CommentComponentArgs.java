package com.tencent.mobileqq.kandian.biz.comment.bean;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentComponetEventListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/bean/CommentComponentArgs;", "", "()V", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setArticleInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "bgTrans", "", "getBgTrans", "()Z", "setBgTrans", "(Z)V", "biuSrc", "", "getBiuSrc", "()I", "setBiuSrc", "(I)V", "clickSource", "getClickSource", "setClickSource", "commentInfo", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;", "getCommentInfo", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;", "setCommentInfo", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;)V", "defaultTxt", "", "getDefaultTxt", "()Ljava/lang/String;", "setDefaultTxt", "(Ljava/lang/String;)V", "firstAction", "getFirstAction", "setFirstAction", "isNeedBiu", "setNeedBiu", "listener", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CommentComponetEventListener;", "getListener", "()Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CommentComponetEventListener;", "setListener", "(Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CommentComponetEventListener;)V", "placeholder", "getPlaceholder", "setPlaceholder", "needBiu", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CommentComponentArgs
{
  @Nullable
  private AbsBaseArticleInfo a;
  @Nullable
  private BaseCommentData b;
  private int c;
  @Nullable
  private String d;
  @Nullable
  private String e;
  private boolean f;
  @Nullable
  private ReadInJoyCommentUtils.CommentComponetEventListener g;
  private int h = -1;
  private boolean i = true;
  private int j;
  
  @NotNull
  public final CommentComponentArgs a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  @NotNull
  public final CommentComponentArgs a(@Nullable ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener)
  {
    this.g = paramCommentComponetEventListener;
    return this;
  }
  
  @NotNull
  public final CommentComponentArgs a(@Nullable BaseCommentData paramBaseCommentData)
  {
    this.b = paramBaseCommentData;
    return this;
  }
  
  @NotNull
  public final CommentComponentArgs a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramAbsBaseArticleInfo;
    return this;
  }
  
  @NotNull
  public final CommentComponentArgs a(@Nullable String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  @NotNull
  public final CommentComponentArgs a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  @Nullable
  public final AbsBaseArticleInfo a()
  {
    return this.a;
  }
  
  @NotNull
  public final CommentComponentArgs b(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  @NotNull
  public final CommentComponentArgs b(@Nullable String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  @Nullable
  public final BaseCommentData b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  @Nullable
  public final String e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  @Nullable
  public final ReadInJoyCommentUtils.CommentComponetEventListener g()
  {
    return this.g;
  }
  
  public final int h()
  {
    return this.h;
  }
  
  public final boolean i()
  {
    return this.i;
  }
  
  public final int j()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs
 * JD-Core Version:    0.7.0.1
 */