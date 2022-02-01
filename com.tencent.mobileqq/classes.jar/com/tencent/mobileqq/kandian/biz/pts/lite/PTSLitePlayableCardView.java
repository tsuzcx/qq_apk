package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IPlayableView;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentLastRead;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.CellListener;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil.Companion;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.pts.core.itemview.PTSItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLitePlayableCardView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/utils/IPlayableView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "componentLastRead", "Lcom/tencent/mobileqq/kandian/biz/pts/component/ComponentLastRead;", "currentDividerType", "", "currentShowLastRead", "", "dividerView", "Landroid/view/View;", "hasTraversed", "ptsItemView", "Lcom/tencent/pts/core/itemview/PTSItemView;", "getPtsItemView", "()Lcom/tencent/pts/core/itemview/PTSItemView;", "videoView", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "destroy", "", "enumeratePtsItemView", "action", "getArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getFirstVideoView", "viewGroup", "Landroid/view/ViewGroup;", "hasVideoView", "initUI", "pause", "start", "stop", "updateComponentLastRead", "readInJoyModel", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "updateDividerView", "dividerType", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLitePlayableCardView
  extends LinearLayout
  implements IPlayableView
{
  public static final PTSLitePlayableCardView.Companion a;
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private VideoView jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  private ComponentLastRead jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
  @NotNull
  private final PTSItemView jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLitePlayableCardView$Companion = new PTSLitePlayableCardView.Companion(null);
  }
  
  public PTSLitePlayableCardView(@NotNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView = new PTSItemView(paramContext);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    c();
  }
  
  private final VideoView a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof VideoView)) {
        return (VideoView)localView;
      }
      if ((localView instanceof ViewGroup)) {
        return a((ViewGroup)localView);
      }
      i += 1;
    }
    return null;
  }
  
  private final boolean b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView = a((ViewGroup)this);
      this.jdField_a_of_type_Boolean = true;
    }
    VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localVideoView != null)
    {
      if (paramInt != 3) {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7)
            {
              if (paramInt != 8) {
                return false;
              }
            }
            else
            {
              localVideoView.destroy();
              return false;
            }
          }
          else
          {
            localVideoView.stop();
            return false;
          }
        }
        else
        {
          localVideoView.pause();
          return false;
        }
      }
      return localVideoView.startPlay(paramInt);
    }
    return false;
  }
  
  private final void c()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 1);
    localMarginLayoutParams.leftMargin = PTSLiteItemViewUtil.a.b();
    localMarginLayoutParams.rightMargin = PTSLiteItemViewUtil.a.b();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1710619);
    setOrientation(1);
    addView((View)this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView);
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  @Nullable
  public AbsBaseArticleInfo a()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localVideoView != null) {
      return localVideoView.getArticleInfo();
    }
    return null;
  }
  
  @NotNull
  public final PTSItemView a()
  {
    return this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView;
  }
  
  public void a()
  {
    b(6);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if ((paramInt == 3) && (localLayoutParams != null)) {
            localLayoutParams.height = 0;
          }
        }
        else
        {
          if (localLayoutParams != null) {
            localLayoutParams.height = 1;
          }
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          {
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
            localMarginLayoutParams.leftMargin = PTSLiteItemViewUtil.a.c();
            localMarginLayoutParams.rightMargin = PTSLiteItemViewUtil.a.c();
          }
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1710619);
        }
      }
      else
      {
        if (localLayoutParams != null) {
          localLayoutParams.height = PTSLiteItemViewUtil.a.a();
        }
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
          localMarginLayoutParams.leftMargin = 0;
          localMarginLayoutParams.rightMargin = 0;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-855310);
      }
    }
    else
    {
      if (localLayoutParams != null) {
        localLayoutParams.height = 1;
      }
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
        localMarginLayoutParams.leftMargin = PTSLiteItemViewUtil.a.b();
        localMarginLayoutParams.rightMargin = PTSLiteItemViewUtil.a.b();
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1710619);
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public final void a(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramIReadInJoyModel, "readInJoyModel");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    boolean bool = paramIReadInJoyModel.g();
    if (this.b == bool) {
      return;
    }
    this.b = bool;
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead = new ComponentLastRead(getContext());
        localObject = new LinearLayout.LayoutParams(-2, -2);
        addView((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead, (ViewGroup.LayoutParams)localObject);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
      if (localObject != null) {
        ((ComponentLastRead)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
      if (localObject != null) {
        ((ComponentLastRead)localObject).a(paramIReadInJoyModel);
      }
      paramIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.a((FeedItemCell.CellListener)new PTSLitePlayableCardView.updateComponentLastRead.1(paramReadInJoyBaseAdapter));
      }
    }
    else
    {
      paramIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.setVisibility(8);
      }
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView = a((ViewGroup)this);
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView != null;
  }
  
  public boolean a(int paramInt)
  {
    return b(paramInt);
  }
  
  public void b()
  {
    b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLitePlayableCardView
 * JD-Core Version:    0.7.0.1
 */