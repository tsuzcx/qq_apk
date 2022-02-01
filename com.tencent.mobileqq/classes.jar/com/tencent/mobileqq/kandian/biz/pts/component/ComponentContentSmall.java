package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;

public class ComponentContentSmall
  extends RelativeLayout
  implements ComponentInheritView
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  
  public ComponentContentSmall(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560132, this, true);
  }
  
  public KandianUrlImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368531));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365260));
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
    if (paramView != null) {
      paramView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(localIReadInJoyModel);
      b();
      AbsBaseArticleInfo localAbsBaseArticleInfo = localIReadInJoyModel.a();
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      URL localURL = localAbsBaseArticleInfo.mSinglePicture;
      if (localIReadInJoyModel.d() == 94)
      {
        paramObject = RIJConvertString2URL.a(localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.c);
      }
      else if (localIReadInJoyModel.d() != 74)
      {
        paramObject = localURL;
        if (localIReadInJoyModel.d() != 75) {}
      }
      else
      {
        Pair localPair = QuestionCardProteusItem.a(localAbsBaseArticleInfo);
        paramObject = localURL;
        if (localPair != null) {
          paramObject = RIJConvertString2URL.a((String)localPair.second);
        }
      }
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramObject, getContext());
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView != null) {
        if ((localIReadInJoyModel.d() != 10) && (localIReadInJoyModel.d() != 16) && (localIReadInJoyModel.d() != 83))
        {
          if ((localIReadInJoyModel.d() != 74) && (localIReadInJoyModel.d() != 75))
          {
            if (localIReadInJoyModel.d() == 132)
            {
              if ((localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.b != null) && (!localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.b.isEmpty()))
              {
                paramObject = (PGCVideoInfo)localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.b.get(0);
                this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(VideoFeedsHelper.a(paramObject.a * 1000L));
                this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
              }
              this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(8);
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(8);
            return;
          }
          paramObject = QuestionCardProteusItem.a(localIReadInJoyModel.a());
          if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(8);
            return;
          }
          if ((paramObject != null) && (!((Boolean)paramObject.first).booleanValue()))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702445));
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(2131717749);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842831);
            paramObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            paramObject.setBounds(new Rect(0, 0, paramObject.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
        }
      }
    }
  }
  
  public void b()
  {
    UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */