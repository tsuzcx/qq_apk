package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.common.EmojiUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "allowEmoji", "", "getConfig", "()Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "lowerCountLimit", "", "getLowerCountLimit", "()I", "setLowerCountLimit", "(I)V", "getPublishArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "upperCountLimit", "getValidCode", "isContentNotEmpty", "setAllowEmoji", "allowPublishEmoji", "setTextCountLimit", "upperLimit", "lowerLimit", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BasePublisherChecker
{
  public static final BasePublisherChecker.Companion a = new BasePublisherChecker.Companion(null);
  private int b;
  private int c;
  private boolean d;
  @NotNull
  private final PublishArticleInfo e;
  @Nullable
  private final GlobalPublisherConfig f;
  
  public BasePublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    this.e = paramPublishArticleInfo;
    this.f = paramGlobalPublisherConfig;
    this.b = -1;
    this.d = true;
  }
  
  protected final int a()
  {
    return this.c;
  }
  
  @NotNull
  public final BasePublisherChecker a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    return this;
  }
  
  public int b()
  {
    if (!c()) {
      return 2;
    }
    int i = this.e.getContentLength();
    int j = this.b;
    if ((i > j) && (j != -1)) {
      return 1;
    }
    if ((!this.d) && (EmojiUtils.a.a(this.e.getContent()))) {
      return 11;
    }
    return 0;
  }
  
  public boolean c()
  {
    int i = ((CharSequence)this.e.getContent()).length();
    boolean bool = false;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      ArrayList localArrayList = this.e.getImageList();
      if (((localArrayList == null) || ((((Collection)localArrayList).isEmpty() ^ true) != true)) && (this.e.getVideoInfo() == null)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  @NotNull
  public final PublishArticleInfo d()
  {
    return this.e;
  }
  
  @Nullable
  public final GlobalPublisherConfig e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.BasePublisherChecker
 * JD-Core Version:    0.7.0.1
 */