package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedItemCellTypeNow
  extends FeedItemCell
  implements View.OnClickListener
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public FeedItemCellTypeNow(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  private TextView a(int paramInt)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setId(2131376061);
    localTextView.setTextSize(2, 11.0F);
    localTextView.setGravity(17);
    localTextView.setText(HardCodeUtil.a(2131704561));
    localTextView.setWidth(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
    localTextView.setHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F));
    if (paramInt == 0)
    {
      localTextView.setTextColor(Color.argb(255, 255, 255, 255));
      localTextView.setBackgroundResource(2130849712);
      return localTextView;
    }
    localTextView.setTextColor(-89258);
    localTextView.setBackgroundResource(2130849713);
    return localTextView;
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public FeedItemCell d()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560253, localRelativeLayout, true);
    this.jdField_d_of_type_AndroidViewView = localView.findViewById(2131369876);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372828));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131376667);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)localView.findViewById(2131369331));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379930));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379813));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131369387));
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    localLayoutParams.gravity = 16;
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131376054);
    ((FrameLayout)localView.findViewById(2131366922)).addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131370216));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131380839);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363772));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131366927));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131366926));
    a(localRelativeLayout);
    return this;
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell o()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject;
      AbsBaseArticleInfo localAbsBaseArticleInfo = localIReadInJoyModel.a();
      if (localAbsBaseArticleInfo == null) {
        return this;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bindData articleId = ");
        ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject1).append("roomId = ");
        ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mSubscribeID);
        QLog.d("FeedItemCellTypeNow", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ScreenUtil.SCREEN_WIDTH;
      ((RelativeLayout.LayoutParams)localObject1).height = (((RelativeLayout.LayoutParams)localObject1).width * 9 / 16);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
      if (localAbsBaseArticleInfo.mVideoCoverUrl != null) {
        localObject1 = localAbsBaseArticleInfo.mVideoCoverUrl;
      } else if (localAbsBaseArticleInfo.mSinglePicture != null) {
        localObject1 = localAbsBaseArticleInfo.mSinglePicture;
      } else {
        localObject1 = RIJConvertString2URL.a(localAbsBaseArticleInfo.mFirstPagePicUrl);
      }
      ReadInJoyDisplayUtils.a((KandianUrlImageView)localObject3, (URL)localObject1, this.jdField_a_of_type_AndroidContentContext, true);
      if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.e();
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
      localObject1 = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
      try
      {
        if (TextUtils.isEmpty(localAbsBaseArticleInfo.thirdIcon)) {
          localObject1 = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
        } else {
          localObject1 = new URL(localAbsBaseArticleInfo.thirdIcon);
        }
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("configVideoItemUI() ERROR e = ");
          ((StringBuilder)localObject3).append(localMalformedURLException.getMessage());
          QLog.d("FeedItemCellTypeNow", 2, ((StringBuilder)localObject3).toString());
        }
      }
      localObject3 = localAbsBaseArticleInfo.mSubscribeName;
      Object localObject2 = localObject3;
      if (((String)localObject3).length() > 18)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mSubscribeName.substring(0, 17));
        ((StringBuilder)localObject2).append("…");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      if (localIReadInJoyModel.c() == 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mTitle);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(255, 157, 157, 157));
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        ((FrameLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(a(0), (ViewGroup.LayoutParams)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        ((LinearLayout)localObject2).setPadding(((LinearLayout)localObject2).getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 47.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        ((LinearLayout)localObject2).setBackgroundColor(((LinearLayout)localObject2).getResources().getColor(2131167394));
        return this;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mTitle);
      this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(a(56), (ViewGroup.LayoutParams)localObject2);
      if (localAbsBaseArticleInfo.mVideoPlayCount == 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    return this;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNow
 * JD-Core Version:    0.7.0.1
 */