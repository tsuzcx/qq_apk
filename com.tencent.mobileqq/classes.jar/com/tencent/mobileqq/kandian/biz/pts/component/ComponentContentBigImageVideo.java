package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ComponentContentBigImageVideo
  extends ComponentContentBig
{
  private ImageView a;
  private TextView b;
  private TextView c;
  
  public ComponentContentBigImageVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560123, this, true);
  }
  
  public URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject1 = paramIReadInJoyModel.a();
    Object localObject2;
    if (paramIReadInJoyModel.d() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      if ((RIJFeedsType.h((AbsBaseArticleInfo)localObject1)) && (((AbsBaseArticleInfo)localObject1).mSinglePicture != null) && (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo != null) && (!((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.b))
      {
        paramIReadInJoyModel = ((AbsBaseArticleInfo)localObject1).mSinglePicture.getFile();
        localObject2 = ReadInJoyDisplayUtils.f();
        paramIReadInJoyModel = RIJSmartCropUtils.a(paramIReadInJoyModel, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        ((AbsBaseArticleInfo)localObject1).mSinglePicture = RIJConvertString2URL.a(paramIReadInJoyModel);
        ((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.b = true;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" handled url = ");
          ((StringBuilder)localObject2).append(paramIReadInJoyModel);
          QLog.e("ComponentContentBigImageVideo", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return ((AbsBaseArticleInfo)localObject1).mSinglePicture;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams() != null))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
      int i = ((ViewGroup.LayoutParams)localObject2).width;
      int j = ((ViewGroup.LayoutParams)localObject2).height;
      if (i == j) {
        localObject1 = ((AbsBaseArticleInfo)localObject1).getVideoCoverWithSmartCut(i, j);
      } else if (i > j) {
        localObject1 = ((AbsBaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(false);
      } else {
        localObject1 = ((AbsBaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true);
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          paramIReadInJoyModel = new StringBuilder();
          paramIReadInJoyModel.append("cut url : ");
          paramIReadInJoyModel.append(localObject1);
          paramIReadInJoyModel.append(" width:");
          paramIReadInJoyModel.append(i);
          paramIReadInJoyModel.append("    height:");
          paramIReadInJoyModel.append(j);
          QLog.d("ComponentContentBigImageVideo", 2, paramIReadInJoyModel.toString());
        }
        return localObject1;
      }
    }
    return super.a(paramIReadInJoyModel);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(2131365996));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372835));
    this.c = ((TextView)paramView.findViewById(2131381294));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a();
      if (paramObject != null)
      {
        if (((!RIJItemViewTypeUtils.m(paramObject)) && (!RIJItemViewTypeUtils.l(paramObject)) && (!RIJItemViewTypeUtils.n(paramObject)) && (!RIJItemViewTypeUtils.p(paramObject))) || ((RIJItemViewTypeUtils.x(paramObject)) && (!RIJItemViewTypeUtils.a(paramObject)) && (!RIJItemViewTypeUtils.c(paramObject)))) {
          if (RIJFeedsType.h(paramObject))
          {
            this.b.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(8);
          }
          else
          {
            this.b.setText(ReadInJoyDisplayUtils.a(paramObject.mVideoDuration));
          }
        }
        if ((!NetworkUtil.isWifiConnected(getContext())) && (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) != 1))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.c.setVisibility(0);
          Object localObject = getContext().getResources().getDrawable(2130843291);
          this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
          this.c.setCompoundDrawablePadding(AIOUtils.b(6.0F, getContext().getResources()));
          this.c.setVisibility(0);
          if (CUKingCardUtils.a() == 1)
          {
            this.c.setText(HardCodeUtil.a(2131702446));
            return;
          }
          if (paramObject.mXGFileSize > 0L)
          {
            localObject = this.c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(VideoFeedsHelper.b(paramObject.mXGFileSize));
            localStringBuilder.append(HardCodeUtil.a(2131702499));
            ((TextView)localObject).setText(localStringBuilder.toString());
            return;
          }
          this.c.setText(HardCodeUtil.a(2131702531));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.c.setVisibility(4);
      }
    }
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentBigImageVideo
 * JD-Core Version:    0.7.0.1
 */