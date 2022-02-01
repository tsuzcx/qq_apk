package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.BaseItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.ImgItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.VideoItem;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.utils.GradientDrawableUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class BannerAdapter
  extends PagerAdapter
  implements IBannerAdapter, OnItemClick, RollViewPager.OnUserFling
{
  public static int a = 0;
  public static int b = 1;
  private static String c = "BannerAdapter";
  private TopBannerInfo d;
  private final Activity e;
  private HashSet<Integer> f = new HashSet();
  private View[] g;
  private int h;
  
  public BannerAdapter(Activity paramActivity, RollViewPager paramRollViewPager, int paramInt)
  {
    this.e = paramActivity;
    paramRollViewPager.setOnUserFling(this);
    this.h = paramInt;
  }
  
  private View a(Activity paramActivity, TopBannerInfo.BaseItem paramBaseItem, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramActivity).inflate(2131626014, null);
    }
    paramView = (KanDianUrlRoundCornerImageView)localView.findViewById(2131436161);
    int i = UIUtils.a(paramActivity, 3.0F);
    paramView.setCorner(i);
    TextView localTextView1 = (TextView)localView.findViewById(2131448793);
    TextView localTextView2 = (TextView)localView.findViewById(2131448814);
    localTextView2.setText(paramBaseItem.f);
    if (TextUtils.isEmpty(paramBaseItem.f)) {
      localTextView2.setVisibility(8);
    } else {
      localTextView2.setVisibility(0);
    }
    if ((!TextUtils.isEmpty(paramBaseItem.d)) && (!TextUtils.isEmpty(paramBaseItem.c)))
    {
      localTextView1.setText(paramBaseItem.d);
      int j = Utils.parseColor(paramBaseItem.c);
      float f1 = i;
      localTextView1.setBackgroundDrawable(GradientDrawableUtils.a(j, f1, 0.0F, f1, 0.0F));
    }
    if (this.h == b) {
      try
      {
        ReadInJoyDisplayUtils.a(paramView, new URL(paramBaseItem.e), paramActivity);
      }
      catch (MalformedURLException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    } else {
      ReadInJoyDisplayUtils.a(paramView, new PublicAccountHttpDownloaderImpl().makeURL(a(paramBaseItem.e), 3), paramActivity);
    }
    localView.setTag(paramBaseItem);
    return localView;
  }
  
  public View a(int paramInt)
  {
    View[] arrayOfView = this.g;
    if (paramInt < arrayOfView.length) {
      return arrayOfView[paramInt];
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = localResources.getDisplayMetrics().widthPixels - AIOUtils.b(30.0F, localResources);
    double d1 = i;
    Double.isNaN(d1);
    return RIJSmartCropUtils.a(paramString, i, (int)(d1 * 0.424242D));
  }
  
  public void a()
  {
    View[] arrayOfView = this.g;
    if (arrayOfView == null) {
      return;
    }
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      if (localView == null) {
        return;
      }
      TopBannerInfo.BaseItem localBaseItem = (TopBannerInfo.BaseItem)localView.getTag();
      a(this.e, localBaseItem, localView);
      i += 1;
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if (this.d == paramTopBannerInfo) {
      return;
    }
    this.d = paramTopBannerInfo;
    if (this.h == a)
    {
      boolean bool2 = false;
      paramTopBannerInfo = paramTopBannerInfo.items.iterator();
      do
      {
        bool1 = bool2;
        if (!paramTopBannerInfo.hasNext()) {
          break;
        }
      } while (!((TopBannerInfo.BaseItem)paramTopBannerInfo.next()).h);
      boolean bool1 = true;
      BannerReportHelper.a("0X8009553", this.d.mChannelId, c(), bool1);
    }
    this.g = new View[getCount()];
    b();
    notifyDataSetChanged();
  }
  
  public int b(int paramInt)
  {
    int j = c();
    int i = 0;
    if (j > 1)
    {
      if (paramInt == 0) {
        return j - 1;
      }
      if (paramInt == j + 1) {
        return 0;
      }
      i = paramInt - 1;
    }
    return i;
  }
  
  public void b()
  {
    this.f.clear();
  }
  
  public int c()
  {
    TopBannerInfo localTopBannerInfo = this.d;
    if (localTopBannerInfo == null) {
      return 0;
    }
    return localTopBannerInfo.items.size();
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onItemClick : ");
    ((StringBuilder)localObject2).append(this.d.items.get(paramInt));
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = (TopBannerInfo.BaseItem)this.d.items.get(paramInt);
    if (((TopBannerInfo.BaseItem)localObject1).a != 2)
    {
      localObject2 = (TopBannerInfo.ImgItem)localObject1;
      ReadInJoyUtils.a(this.e, ((TopBannerInfo.ImgItem)localObject2).k);
    }
    else
    {
      localObject2 = (TopBannerInfo.VideoItem)localObject1;
      Activity localActivity = this.e;
      String str1 = ((TopBannerInfo.VideoItem)localObject2).g;
      i = ((TopBannerInfo.VideoItem)localObject2).p;
      String str2 = ((TopBannerInfo.VideoItem)localObject2).o;
      int j = ((TopBannerInfo.VideoItem)localObject2).m;
      int k = ((TopBannerInfo.VideoItem)localObject2).n;
      int m = ((TopBannerInfo.VideoItem)localObject2).l;
      String str3 = ((TopBannerInfo.VideoItem)localObject2).r;
      String str4 = ((TopBannerInfo.VideoItem)localObject2).k;
      String str5 = ((TopBannerInfo.VideoItem)localObject2).q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((TopBannerInfo.VideoItem)localObject2).s);
      VideoFeedsHelper.a(localActivity, null, 19, str1, i, str2, j, k, m, str3, "", str4, str5, localStringBuilder.toString(), 0L, ((TopBannerInfo.VideoItem)localObject2).b(), ((TopBannerInfo.VideoItem)localObject2).u, ((TopBannerInfo.VideoItem)localObject2).v, null, null, null, null, null);
    }
    int i = this.h;
    if (i == a) {
      BannerReportHelper.a("0X8009556", paramInt, this.d.mChannelId, c(), (TopBannerInfo.BaseItem)localObject1);
    } else if (i == b) {
      BannerReportHelper.a("0X8009B91", c(), (TopBannerInfo.BaseItem)localObject1);
    }
    if ((((TopBannerInfo.BaseItem)localObject1).h) && (((TopBannerInfo.BaseItem)localObject1).i != null) && (((TopBannerInfo.BaseItem)localObject1).i.size() > 0))
    {
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.trace_info.aid.set(((TopBannerInfo.BaseItem)localObject1).b);
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(((TopBannerInfo.BaseItem)localObject1).a(((TopBannerInfo.BaseItem)localObject1).i));
      GdtC2SReporter.a(1, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
    }
  }
  
  public void d()
  {
    if (this.h == a) {
      BannerReportHelper.a("0X8009555", this.d.mChannelId, c(), false);
    }
  }
  
  public void d(int paramInt)
  {
    if (!this.f.contains(Integer.valueOf(paramInt)))
    {
      this.f.add(Integer.valueOf(paramInt));
      TopBannerInfo.BaseItem localBaseItem = (TopBannerInfo.BaseItem)this.d.items.get(paramInt);
      int i = this.h;
      if (i == a) {
        BannerReportHelper.a("0X8009554", paramInt, this.d.mChannelId, c(), localBaseItem);
      } else if (i == b) {
        BannerReportHelper.a("0X8009B90", c(), localBaseItem);
      }
      if ((localBaseItem.h) && (localBaseItem.j != null) && (localBaseItem.j.size() > 0))
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        localAdInfo.report_info.trace_info.aid.set(localBaseItem.b);
        localAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(localBaseItem.a(localBaseItem.j));
        GdtC2SReporter.a(0, 1, localAdInfo);
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyItem position : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" object: ");
    localStringBuilder.append(paramObject);
    QLog.d(str, 2, localStringBuilder.toString());
    paramViewGroup.removeView((View)paramObject);
    paramViewGroup = this.g;
    if (paramInt < paramViewGroup.length) {
      paramViewGroup[paramInt] = null;
    }
  }
  
  public int getCount()
  {
    int i = c();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (TopBannerInfo.BaseItem)((View)paramObject).getTag();
    int i = this.d.items.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("instantiateItem ");
    ((StringBuilder)localObject2).append(paramViewGroup);
    ((StringBuilder)localObject2).append("  ");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    int i = c();
    if ((this.e != null) && (i != 0))
    {
      if ((i > 1) && ((paramInt == 1) || (paramInt == i))) {
        if (paramViewGroup == null)
        {
          localObject1 = this.g;
          if (localObject1[paramInt] != null) {
            return localObject1[paramInt];
          }
        }
        else
        {
          localObject1 = this.g;
          if ((localObject1[paramInt] == null) || (localObject1[paramInt].getParent() != null)) {
            this.g[paramInt] = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.g[paramInt]);
          return this.g[paramInt];
        }
      }
      i = b(paramInt);
      localObject1 = (TopBannerInfo.BaseItem)this.d.items.get(i);
      localObject1 = a(this.e, (TopBannerInfo.BaseItem)localObject1, null);
      this.g[paramInt] = localObject1;
      localObject2 = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("childs ");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
      ((View)localObject1).setOnClickListener(new BannerAdapter.1(this, i));
      if (paramViewGroup != null) {
        paramViewGroup.addView((View)localObject1);
      }
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "instantiateItem activity is null or data list count is 0");
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */