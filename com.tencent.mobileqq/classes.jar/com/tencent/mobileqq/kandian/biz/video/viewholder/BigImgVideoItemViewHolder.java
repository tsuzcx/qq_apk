package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class BigImgVideoItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, PlayableItem
{
  View a;
  public ImageView a;
  public TextView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public VideoPlayParam a;
  public View b;
  public ImageView b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public TextView c;
  public KandianUrlImageView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public BigImgVideoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560383, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376809);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378784));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372829));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365996));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368461));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380660));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372165));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372166));
    this.e = ((TextView)paramViewGroup.findViewById(2131369688));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131378837);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131378866);
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363714);
    this.f = ((TextView)paramViewGroup.findViewById(2131366767));
    this.g = ((TextView)paramViewGroup.findViewById(2131366752));
    this.h = ((TextView)paramViewGroup.findViewById(2131364944));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380181));
    this.i = ((TextView)paramViewGroup.findViewById(2131366765));
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366768));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131369354));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setTag(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  }
  
  public boolean a(View paramView)
  {
    boolean bool1 = VideoFeedsHelper.a(a(paramView));
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int j = VideoFeedsHelper.f();
    if (j == 0) {
      return false;
    }
    float f1 = ReadInJoyDisplayUtils.a(paramView);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("BigImgVideoItemViewHolder() canAutoPlay percent:");
      paramView.append(f1);
      QLog.d("Q.readinjoy.video", 2, paramView.toString());
    }
    if (j == 1)
    {
      bool1 = bool2;
      if (VideoAutoPlayController.getInstance().isWifi())
      {
        bool1 = bool2;
        if (f1 >= 70.0F) {
          bool1 = true;
        }
      }
      return bool1;
    }
    bool1 = bool3;
    if (j == 2)
    {
      bool1 = bool3;
      if (f1 >= 70.0F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    VideoHandler.a(paramView);
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131369354: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(this.jdField_a_of_type_Int);
      if ((paramView != null) && (paramView.familyCommentInfo != null))
      {
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramView.familyCommentInfo.b);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("familyJumpUrl ");
        ((StringBuilder)localObject1).append(paramView.familyCommentInfo.b);
        QLog.d("ReadInJoyBaseAdapter", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      break;
    case 2131368461: 
    case 2131380660: 
      localObject1 = a(paramView);
      if (localObject1 == null) {
        return;
      }
      if ((VideoFeedsHelper.g() == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a() != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a();
        if ((localObject2 != null) && (((VideoPlayManager)localObject2).a() != null))
        {
          ((VideoPlayManager)localObject2).a().c(paramView);
          return;
        }
      }
      localObject2 = a(paramView);
      if (localObject2 == null) {
        return;
      }
      if (RIJTransMergeKanDianReport.a(paramView.getContext(), (AbsBaseArticleInfo)localObject1))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(((PlayableItem)localObject2).a(), (AbsBaseArticleInfo)localObject1);
        RIJJumpUtils.a(paramView.getContext(), (AbsBaseArticleInfo)localObject1, RIJJumpUtils.b(((AbsBaseArticleInfo)localObject1).getInnerUniqueID()));
        return;
      }
      if (VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), (AbsBaseArticleInfo)localObject1).intValue() != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(((PlayableItem)localObject2).a(), (AbsBaseArticleInfo)localObject1);
        return;
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(((PlayableItem)localObject2).a(), (AbsBaseArticleInfo)localObject1, false, true);
        return;
      }
      break;
    case 2131363714: 
      localObject1 = a(paramView);
      if (localObject1 == null) {
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(this.jdField_a_of_type_Int);
      if (RIJTransMergeKanDianReport.a(paramView.getContext(), (AbsBaseArticleInfo)localObject2))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(((PlayableItem)localObject1).a(), (AbsBaseArticleInfo)localObject2);
        RIJJumpUtils.a(paramView.getContext(), (AbsBaseArticleInfo)localObject2, RIJJumpUtils.b(((AbsBaseArticleInfo)localObject2).getInnerUniqueID()));
        return;
      }
      if (VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), (AbsBaseArticleInfo)localObject2).intValue() != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(((PlayableItem)localObject1).a(), (AbsBaseArticleInfo)localObject2);
        return;
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(((PlayableItem)localObject1).a(), (AbsBaseArticleInfo)localObject2, false, true);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */