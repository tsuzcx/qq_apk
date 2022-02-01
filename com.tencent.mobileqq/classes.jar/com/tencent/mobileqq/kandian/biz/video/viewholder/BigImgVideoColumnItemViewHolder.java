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
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;

public class BigImgVideoColumnItemViewHolder
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
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public BigImgVideoColumnItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      if ((VideoFeedsHelper.i() == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a() != null))
      {
        VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a();
        if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
        {
          localVideoPlayManager.a().c(paramView);
          return;
        }
      }
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.b != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_a_of_type_Int != 3))
      {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mSimpleVideoColumnInfo.b);
      }
      else
      {
        paramView = a(paramView);
        if (paramView != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(paramView.a(), localAbsBaseArticleInfo, false, false);
        }
      }
      if (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.b == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mSimpleVideoColumnInfo.b.e;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
    }
  }
  
  private void b(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo != null))
    {
      if ((localAbsBaseArticleInfo.mSimpleVideoColumnInfo.a != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.a.jdField_a_of_type_Int != 3))
      {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mSimpleVideoColumnInfo.a);
      }
      else
      {
        paramView = a(paramView);
        if (paramView != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(paramView.a(), localAbsBaseArticleInfo, false, false);
        }
      }
      if (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.a == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mSimpleVideoColumnInfo.a.e;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
    }
  }
  
  private void c(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.d != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mSimpleVideoColumnInfo.d);
      if (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.d == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mSimpleVideoColumnInfo.d.e;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560384, paramViewGroup, false);
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
    this.f = ((TextView)paramViewGroup.findViewById(2131366754));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366755));
    this.g = ((TextView)paramViewGroup.findViewById(2131366756));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380181));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setTag(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setTag(this);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
    this.g.setTag(this);
    this.g.setOnClickListener(this);
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
    int i = VideoFeedsHelper.h();
    if (i == 0) {
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
    if (i == 1)
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
    if (i == 2)
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
      return;
    case 2131368461: 
    case 2131380660: 
      a(paramView);
      return;
    case 2131366755: 
    case 2131366756: 
      c(paramView);
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder
 * JD-Core Version:    0.7.0.1
 */