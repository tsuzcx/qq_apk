package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ImageData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import org.json.JSONObject;

class WebFastImageViewCreator$ImageViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private boolean jdField_a_of_type_Boolean = true;
  private int e;
  private int f = 0;
  
  public WebFastImageViewCreator$ImageViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369181));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private static int a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a(paramInt1)) {
      return a(paramContext) - paramInt2 - paramInt3;
    }
    return AIOUtils.b(paramInt1, paramContext.getResources());
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    int i = AIOUtils.b(this.d, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    int j = AIOUtils.b(this.c, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1))
    {
      int k = paramURLDrawable.getCurrDrawable().getIntrinsicWidth();
      int m = paramURLDrawable.getCurrDrawable().getIntrinsicHeight();
      if ((k != 0) && (m != 0))
      {
        int n = a(this.jdField_a_of_type_AndroidViewView.getContext(), k, i, i);
        paramURLDrawable = new LinearLayout.LayoutParams(n, m * n / k);
        paramURLDrawable.leftMargin = i;
        paramURLDrawable.rightMargin = i;
        paramURLDrawable.topMargin = j;
        paramURLDrawable.bottomMargin = j;
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramURLDrawable);
      }
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append(" refrshImageViewFromDrawable: ");
      paramURLDrawable.append(k);
      paramURLDrawable.append(" :: ");
      paramURLDrawable.append(m);
      QLog.d("Q.readinjoy.fast_web", 2, paramURLDrawable.toString());
      return;
    }
    paramURLDrawable = new LinearLayout.LayoutParams(a(this.jdField_a_of_type_AndroidViewView.getContext()) - i - i, AIOUtils.b(190.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources()));
    paramURLDrawable.leftMargin = i;
    paramURLDrawable.rightMargin = i;
    paramURLDrawable.topMargin = j;
    paramURLDrawable.bottomMargin = j;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramURLDrawable);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 100;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.u != 3) {
      return;
    }
    paramBaseData2 = (ImageData)paramBaseData2;
    Object localObject = (ImageData)paramBaseData1;
    int j = AIOUtils.b(this.d, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    int k = AIOUtils.b(this.c, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData1 = URLDrawable.URLDrawableOptions.obtain();
    int m = paramBaseData2.jdField_a_of_type_Int;
    int i = 0;
    if ((m != 0) && (paramBaseData2.b != 0))
    {
      m = a(this.jdField_a_of_type_AndroidViewView.getContext(), paramBaseData2.jdField_a_of_type_Int, j, j);
      int n = paramBaseData2.b * m / paramBaseData2.jdField_a_of_type_Int;
      if ((!((ImageData)localObject).jdField_a_of_type_JavaLangString.equals(paramBaseData2.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean))
      {
        localObject = new LinearLayout.LayoutParams(m, n);
        ((LinearLayout.LayoutParams)localObject).leftMargin = j;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        ((LinearLayout.LayoutParams)localObject).topMargin = k;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = k;
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_Boolean = false;
        this.f = 0;
        this.e = 0;
      }
      if ((this.e > 0) && (paramBaseData2.b * paramBaseData2.jdField_a_of_type_Int > 2000000))
      {
        j = this.f;
        paramBaseData1.mRequestWidth = (m >> j);
        paramBaseData1.mRequestHeight = (n >> j);
      }
      else
      {
        paramBaseData1.mRequestWidth = m;
        paramBaseData1.mRequestHeight = n;
      }
    }
    else
    {
      i = 1;
    }
    paramBaseData1.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData1.mPlayGifImage = true;
    paramBaseData1.mUseSharpPImage = QQSharpPUtil.a(this.jdField_a_of_type_AndroidViewView.getContext());
    paramBaseData1.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData2 = WebFastImageViewCreator.a(paramBaseData2.jdField_a_of_type_JavaLangString, paramBaseData2);
    paramBaseData1 = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseData2, 4), paramBaseData1);
    if (i != 0) {
      a(paramBaseData1);
    }
    if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
      paramBaseData1.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new WebFastImageViewCreator.ImageViewHolder.1(this));
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebOnItemClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData);
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.b;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.a()) {
      paramView = "2";
    } else {
      paramView = "1";
    }
    paramView = RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, 0, paramView);
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.b, "0X8008996", paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastImageViewCreator.ImageViewHolder
 * JD-Core Version:    0.7.0.1
 */