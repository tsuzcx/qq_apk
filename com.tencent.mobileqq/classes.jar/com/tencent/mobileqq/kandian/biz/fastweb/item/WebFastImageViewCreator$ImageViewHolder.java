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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ImageData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import org.json.JSONObject;

class WebFastImageViewCreator$ImageViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private URLImageView a;
  private int b;
  private boolean c = true;
  private int d = 0;
  
  public WebFastImageViewCreator$ImageViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.a = ((URLImageView)paramView.findViewById(2131436155));
    this.a.setOnClickListener(this);
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
    int i = AIOUtils.b(this.m, this.f.getContext().getResources());
    int j = AIOUtils.b(this.l, this.f.getContext().getResources());
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1))
    {
      int k = paramURLDrawable.getCurrDrawable().getIntrinsicWidth();
      int m = paramURLDrawable.getCurrDrawable().getIntrinsicHeight();
      if ((k != 0) && (m != 0))
      {
        int n = a(this.f.getContext(), k, i, i);
        paramURLDrawable = new LinearLayout.LayoutParams(n, m * n / k);
        paramURLDrawable.leftMargin = i;
        paramURLDrawable.rightMargin = i;
        paramURLDrawable.topMargin = j;
        paramURLDrawable.bottomMargin = j;
        this.a.setLayoutParams(paramURLDrawable);
      }
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append(" refrshImageViewFromDrawable: ");
      paramURLDrawable.append(k);
      paramURLDrawable.append(" :: ");
      paramURLDrawable.append(m);
      QLog.d("Q.readinjoy.fast_web", 2, paramURLDrawable.toString());
      return;
    }
    paramURLDrawable = new LinearLayout.LayoutParams(a(this.f.getContext()) - i - i, AIOUtils.b(190.0F, this.f.getContext().getResources()));
    paramURLDrawable.leftMargin = i;
    paramURLDrawable.rightMargin = i;
    paramURLDrawable.topMargin = j;
    paramURLDrawable.bottomMargin = j;
    this.a.setLayoutParams(paramURLDrawable);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 100;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP != 3) {
      return;
    }
    paramBaseData2 = (ImageData)paramBaseData2;
    Object localObject = (ImageData)paramBaseData1;
    int j = AIOUtils.b(this.m, this.f.getContext().getResources());
    int k = AIOUtils.b(this.l, this.f.getContext().getResources());
    paramBaseData1 = URLDrawable.URLDrawableOptions.obtain();
    int m = paramBaseData2.b;
    int i = 0;
    if ((m != 0) && (paramBaseData2.c != 0))
    {
      m = a(this.f.getContext(), paramBaseData2.b, j, j);
      int n = paramBaseData2.c * m / paramBaseData2.b;
      if ((!((ImageData)localObject).a.equals(paramBaseData2.a)) || (this.c))
      {
        localObject = new LinearLayout.LayoutParams(m, n);
        ((LinearLayout.LayoutParams)localObject).leftMargin = j;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        ((LinearLayout.LayoutParams)localObject).topMargin = k;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = k;
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.c = false;
        this.d = 0;
        this.b = 0;
      }
      if ((this.b > 0) && (paramBaseData2.c * paramBaseData2.b > 2000000))
      {
        j = this.d;
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
    paramBaseData1.mUseSharpPImage = QQSharpPUtil.a(this.f.getContext());
    paramBaseData1.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData2 = WebFastImageViewCreator.a(paramBaseData2.a, paramBaseData2);
    paramBaseData1 = URLDrawable.getDrawable(new PublicAccountHttpDownloaderImpl().makeURL(paramBaseData2, 4), paramBaseData1);
    if (i != 0) {
      a(paramBaseData1);
    }
    if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
      paramBaseData1.restartDownload();
    }
    this.a.setImageDrawable(paramBaseData1);
    this.a.setURLDrawableDownListener(new WebFastImageViewCreator.ImageViewHolder.1(this));
  }
  
  public void onClick(View paramView)
  {
    this.h.a(this.g);
    Context localContext = this.f.getContext();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.g.aQ;
    if (this.g.aR.a()) {
      paramView = "2";
    } else {
      paramView = "1";
    }
    paramView = RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, 0, paramView);
    ReportUtil.a(this.g.aQ, "0X8008996", paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastImageViewCreator.ImageViewHolder
 * JD-Core Version:    0.7.0.1
 */