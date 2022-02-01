package com.tencent.mobileqq.kandian.biz.pts.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.VideoPackSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  Pair<Integer, Integer> jdField_a_of_type_AndroidUtilPair;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  TextView d;
  TextView e;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    float f = DisplayUtil.a(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  @SuppressLint({"Range"})
  private void c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mVideoArticleSubsText))
    {
      String str;
      if (TextUtils.isEmpty(localAbsBaseArticleInfo.mVideoArticleSubsColor)) {
        str = "#FE6c6c";
      } else {
        str = localAbsBaseArticleInfo.mVideoArticleSubsColor;
      }
      try
      {
        this.e.setTextColor(Color.parseColor("#ffffff"));
        ApiCompatibilityUtils.a(this.e, a(Color.parseColor(str), getContext()));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 2, "configDefaultItem: ", localException);
        }
        this.e.setTextColor(Color.parseColor("#ffffff"));
        ApiCompatibilityUtils.a(this.e, a(Color.parseColor("#FE6c6c"), getContext()));
      }
      this.e.setText(localAbsBaseArticleInfo.mVideoArticleSubsText);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560138, this, true);
  }
  
  public URL a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl == null) {
      if (!TextUtils.isEmpty(paramString)) {
        paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl = RIJConvertString2URL.a(RIJSmartCropUtils.a(paramString, paramInt1, paramInt2));
      } else {
        return null;
      }
    }
    return paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl;
  }
  
  public URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject2 = paramIReadInJoyModel.a();
    boolean bool = ComponentPolymericView.a(paramIReadInJoyModel);
    paramIReadInJoyModel = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder;
    if (bool)
    {
      paramIReadInJoyModel = ((NewPolymericInfo.PackArticleInfo)((AbsBaseArticleInfo)localObject2).mNewPolymericInfo.a.get(0)).c;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUrl new polymeric video cover rawUrl = ");
        localStringBuilder.append(paramIReadInJoyModel);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, localStringBuilder.toString());
      }
      localObject2 = a((AbsBaseArticleInfo)localObject2, ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramIReadInJoyModel);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUrl new polymeric video cover after smartcut url = ");
        paramIReadInJoyModel = (IReadInJoyModel)localObject1;
        if (localObject2 != null) {
          paramIReadInJoyModel = ((URL)localObject2).getFile();
        }
        localStringBuilder.append(paramIReadInJoyModel);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, localStringBuilder.toString());
      }
      return localObject2;
    }
    localObject1 = ((AbsBaseArticleInfo)localObject2).getVideoCoverURL();
    if (localObject1 != null)
    {
      localObject1 = ((URL)localObject1).getFile();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUrl old polymeric video cover rawUrl = ");
        localStringBuilder.append((String)localObject1);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, localStringBuilder.toString());
      }
      localObject1 = a((AbsBaseArticleInfo)localObject2, ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getUrl old polymeric video cover after smartcut url = ");
        if (localObject1 != null) {
          paramIReadInJoyModel = ((URL)localObject1).getFile();
        }
        ((StringBuilder)localObject2).append(paramIReadInJoyModel);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return ((AbsBaseArticleInfo)localObject2).getVideoCoverURL();
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368532));
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368531));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364344));
    this.d = ((TextView)paramView.findViewById(2131364944));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380693));
    this.e = ((TextView)paramView.findViewById(2131378109));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368533);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376828));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372835));
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
      boolean bool;
      if (localIReadInJoyModel.f() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      paramObject = localIReadInJoyModel.a();
      if (paramObject == null) {
        return;
      }
      if (RIJFeedsType.h(paramObject))
      {
        this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(AIOUtils.b(165.0F, getResources())), Integer.valueOf(AIOUtils.b(293.0F, getResources())));
        findViewById(2131365529).setVisibility(8);
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidUtilPair = RIJComponentConfigImage.a(3, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
      }
      else
      {
        this.jdField_a_of_type_AndroidUtilPair = RIJComponentConfigImage.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.f(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
      }
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c() == 56) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(getResources().getDrawable(2130843305));
      } else {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
      }
      Object localObject2;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = RIJComponentConfigImage.a(1, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
        localObject2 = URLDrawable.getDrawable(a(localIReadInJoyModel), ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.s);
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable((Drawable)localObject2);
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImagePlaceHolder(new ColorDrawable(-1447447));
      try
      {
        this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(a(localIReadInJoyModel));
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bindData setVideoCover failed. Exception e = ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, ((StringBuilder)localObject2).toString());
      }
      if (RIJFeedsType.h(paramObject))
      {
        this.d.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else
      {
        Object localObject1 = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime());
        if ((localObject1 != null) && (((ReadInJoyHelper.VideoPackSetting)localObject1).jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, getResources()));
          this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130849637, 0, 0, 0);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if ((localObject1 != null) && (!((ReadInJoyHelper.VideoPackSetting)localObject1).b))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          if ((localObject1 != null) && (((ReadInJoyHelper.VideoPackSetting)localObject1).jdField_a_of_type_Int > 0)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(((ReadInJoyHelper.VideoPackSetting)localObject1).jdField_a_of_type_Int);
          }
          if (RIJItemViewTypeUtils.x(paramObject)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mTitle);
          } else {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((UGCVideoInfo)paramObject.mSocialFeedInfo.a.b.get(0)).e);
          }
        }
        if ((localObject1 != null) && (!((ReadInJoyHelper.VideoPackSetting)localObject1).c))
        {
          this.d.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          localObject1 = this.d;
          localObject2 = getResources();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramObject.getCommentCount());
          localStringBuilder.append("");
          ((TextView)localObject1).setText(((Resources)localObject2).getString(2131717798, new Object[] { localStringBuilder.toString() }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(paramObject.mVideoPlayCount));
          }
        }
      }
      c();
    }
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue();
    localLayoutParams.height = ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue();
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */