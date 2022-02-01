package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;

public class VideoColumnItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, PlayableItem
{
  public View a;
  public ViewGroup a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public KanDianUrlRoundCornerImageView a;
  public KandianUrlImageView a;
  public VideoViewGroup a;
  public VideoPlayParam a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public TextView b;
  public KandianUrlImageView b;
  public TextView c;
  public KandianUrlImageView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public VideoColumnItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private void a(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int != 3))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    }
    else
    {
      paramView = a(paramView);
      if (paramView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(paramView.a(), localAbsBaseArticleInfo, false, false);
      }
    }
    if (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo == null) {
      paramView = null;
    } else {
      paramView = localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.e;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 1, paramView);
  }
  
  private void b(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
      VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int, true, localAbsBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_JavaLangString);
      localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      VideoColumnInfo localVideoColumnInfo = localAbsBaseArticleInfo.mVideoColumnInfo;
      localVideoColumnInfo.jdField_c_of_type_Int += 1;
      ReadInJoyLogicEngine.a().b(localAbsBaseArticleInfo);
      paramView.setVisibility(8);
      if (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mVideoColumnInfo.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.e;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 2, paramView);
    }
  }
  
  private void c(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.b != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.b.jdField_a_of_type_Int != 3))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mVideoColumnInfo.b);
    }
    else
    {
      paramView = a(paramView);
      if (paramView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(paramView.a(), localAbsBaseArticleInfo, false, false);
      }
    }
    if (localAbsBaseArticleInfo.mVideoColumnInfo.b == null) {
      paramView = null;
    } else {
      paramView = localAbsBaseArticleInfo.mVideoColumnInfo.b.e;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 3, paramView);
  }
  
  private void d(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mVideoColumnInfo.d);
      if (localAbsBaseArticleInfo.mVideoColumnInfo.d == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mVideoColumnInfo.d.e;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 4, paramView);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560385, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131368104));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368105));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131364876));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364879));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364877));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378070));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131365178));
    this.d = ((TextView)paramViewGroup.findViewById(2131378784));
    this.e = ((TextView)paramViewGroup.findViewById(2131372829));
    this.f = ((TextView)paramViewGroup.findViewById(2131365996));
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368461));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380660));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372165));
    this.g = ((TextView)paramViewGroup.findViewById(2131372166));
    this.h = ((TextView)paramViewGroup.findViewById(2131369688));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131378837);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131378866);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131362828));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131364872));
    this.i = ((TextView)paramViewGroup.findViewById(2131364873));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380181));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setOnClickListener(this);
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
    int j = VideoFeedsHelper.d();
    if (j == 0) {
      return false;
    }
    float f1 = ReadInJoyDisplayUtils.a(paramView);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("VideoColumnItemViewHolder() canAutoPlay percent:");
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
    switch (paramView.getId())
    {
    default: 
      a(paramView);
      return;
    case 2131378070: 
      b(paramView);
      return;
    case 2131368461: 
    case 2131380660: 
      c(paramView);
      return;
    case 2131368104: 
      a(paramView);
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoColumnItemViewHolder
 * JD-Core Version:    0.7.0.1
 */