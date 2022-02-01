package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;

public class VideoFeedsViewHolder
  extends ViewHolder
  implements PlayableItem
{
  public Handler a;
  public View a;
  public ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public KandianUrlImageView a;
  public RoundAngleFrameLayout a;
  public VideoViewGroup a;
  public ReadInJoyHeadImageView a;
  public ReadInJoyNickNameTextView a;
  public VideoPlayParam a;
  public ReadInJoyVideoInfoViewGroup a;
  public boolean a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public LinearLayout b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public ImageView c;
  public TextView c;
  public View d;
  public ImageView d;
  public TextView d;
  public View e;
  public ImageView e;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public VideoFeedsViewHolder(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560375, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131366750));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131380736));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378784));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131368461));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131380652));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131361884));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131368343));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131376054));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365996));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373223));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368584));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368583));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131380576));
    if (RIJSocialBottomViewAladdinConfig.b())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380664));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372829));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131380660));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131376438);
    this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131380652);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131376014);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131369723));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372165));
    this.f = ((TextView)paramViewGroup.findViewById(2131372166));
    this.g = ((TextView)paramViewGroup.findViewById(2131369688));
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131378837);
    this.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131378866);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131369887));
    this.h = ((TextView)paramViewGroup.findViewById(2131362165));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131369746));
    this.i = ((TextView)paramViewGroup.findViewById(2131362086));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362082));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366768));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public boolean a(View paramView)
  {
    boolean bool2 = VideoFeedsHelper.a(a(paramView));
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (ReadInJoyDisplayUtils.a(paramView) >= 80.0F) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder
 * JD-Core Version:    0.7.0.1
 */