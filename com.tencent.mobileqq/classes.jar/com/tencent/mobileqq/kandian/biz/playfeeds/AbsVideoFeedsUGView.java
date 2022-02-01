package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/AbsVideoFeedsUGView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "reset", "", "setActive", "active", "", "setInfo", "info", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/UGDownloadInfo;", "title", "", "subPos", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract class AbsVideoFeedsUGView
  extends RelativeLayout
  implements View.OnClickListener
{
  public AbsVideoFeedsUGView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a();
  
  public abstract void setActive(boolean paramBoolean);
  
  public abstract void setInfo(@NotNull UGDownloadInfo paramUGDownloadInfo, @NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.AbsVideoFeedsUGView
 * JD-Core Version:    0.7.0.1
 */