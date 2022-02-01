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
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  private static String jdField_a_of_type_JavaLangString = "BannerAdapter";
  public static int b = 1;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private TopBannerInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private int c;
  
  public BannerAdapter(Activity paramActivity, RollViewPager paramRollViewPager, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramRollViewPager.setOnUserFling(this);
    this.jdField_c_of_type_Int = paramInt;
  }
  
  private View a(Activity paramActivity, TopBannerInfo.BaseItem paramBaseItem, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramActivity).inflate(2131559971, null);
    }
    paramView = (KanDianUrlRoundCornerImageView)localView.findViewById(2131369186);
    int i = UIUtils.a(paramActivity, 3.0F);
    paramView.setCorner(i);
    TextView localTextView1 = (TextView)localView.findViewById(2131379918);
    TextView localTextView2 = (TextView)localView.findViewById(2131379930);
    localTextView2.setText(paramBaseItem.d);
    if (TextUtils.isEmpty(paramBaseItem.d)) {
      localTextView2.setVisibility(8);
    } else {
      localTextView2.setVisibility(0);
    }
    if ((!TextUtils.isEmpty(paramBaseItem.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBaseItem.jdField_a_of_type_JavaLangString)))
    {
      localTextView1.setText(paramBaseItem.jdField_b_of_type_JavaLangString);
      int j = Utils.parseColor(paramBaseItem.jdField_a_of_type_JavaLangString);
      float f = i;
      localTextView1.setBackgroundDrawable(GradientDrawableUtils.a(j, f, 0.0F, f, 0.0F));
    }
    if (this.jdField_c_of_type_Int == jdField_b_of_type_Int) {
      try
      {
        ReadInJoyDisplayUtils.a(paramView, new URL(paramBaseItem.c), paramActivity);
      }
      catch (MalformedURLException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    } else {
      ReadInJoyDisplayUtils.a(paramView, ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(a(paramBaseItem.c), 3), paramActivity);
    }
    localView.setTag(paramBaseItem);
    return localView;
  }
  
  public int a()
  {
    TopBannerInfo localTopBannerInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo;
    if (localTopBannerInfo == null) {
      return 0;
    }
    return localTopBannerInfo.items.size();
  }
  
  public int a(int paramInt)
  {
    int j = a();
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
  
  public View a(int paramInt)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (paramInt < arrayOfView.length) {
      return arrayOfView[paramInt];
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = localResources.getDisplayMetrics().widthPixels - AIOUtils.b(30.0F, localResources);
    double d = i;
    Double.isNaN(d);
    return RIJSmartCropUtils.a(paramString, i, (int)(d * 0.424242D));
  }
  
  public void a()
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
      a(this.jdField_a_of_type_AndroidAppActivity, localBaseItem, localView);
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onItemClick : ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.items.get(paramInt));
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = (TopBannerInfo.BaseItem)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.items.get(paramInt);
    if (((TopBannerInfo.BaseItem)localObject1).jdField_a_of_type_Int != 2)
    {
      localObject2 = (TopBannerInfo.ImgItem)localObject1;
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, ((TopBannerInfo.ImgItem)localObject2).f);
    }
    else
    {
      localObject2 = (TopBannerInfo.VideoItem)localObject1;
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      String str1 = ((TopBannerInfo.VideoItem)localObject2).jdField_e_of_type_JavaLangString;
      i = ((TopBannerInfo.VideoItem)localObject2).jdField_e_of_type_Int;
      String str2 = ((TopBannerInfo.VideoItem)localObject2).jdField_g_of_type_JavaLangString;
      int j = ((TopBannerInfo.VideoItem)localObject2).jdField_c_of_type_Int;
      int k = ((TopBannerInfo.VideoItem)localObject2).d;
      int m = ((TopBannerInfo.VideoItem)localObject2).jdField_b_of_type_Int;
      String str3 = ((TopBannerInfo.VideoItem)localObject2).i;
      String str4 = ((TopBannerInfo.VideoItem)localObject2).f;
      String str5 = ((TopBannerInfo.VideoItem)localObject2).h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((TopBannerInfo.VideoItem)localObject2).jdField_b_of_type_Long);
      VideoFeedsHelper.a(localActivity, null, 19, str1, i, str2, j, k, m, str3, "", str4, str5, localStringBuilder.toString(), 0L, ((TopBannerInfo.VideoItem)localObject2).a(), ((TopBannerInfo.VideoItem)localObject2).jdField_c_of_type_Long, ((TopBannerInfo.VideoItem)localObject2).jdField_g_of_type_Int, null, null, null, null, null);
    }
    int i = this.jdField_c_of_type_Int;
    if (i == jdField_a_of_type_Int) {
      BannerReportHelper.a("0X8009556", paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.mChannelId, a(), (TopBannerInfo.BaseItem)localObject1);
    } else if (i == jdField_b_of_type_Int) {
      BannerReportHelper.a("0X8009B91", a(), (TopBannerInfo.BaseItem)localObject1);
    }
    if ((((TopBannerInfo.BaseItem)localObject1).jdField_a_of_type_Boolean) && (((TopBannerInfo.BaseItem)localObject1).jdField_a_of_type_JavaUtilList != null) && (((TopBannerInfo.BaseItem)localObject1).jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.trace_info.aid.set(((TopBannerInfo.BaseItem)localObject1).jdField_a_of_type_Long);
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(((TopBannerInfo.BaseItem)localObject1).a(((TopBannerInfo.BaseItem)localObject1).jdField_a_of_type_JavaUtilList));
      GdtC2SReporter.a(1, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo == paramTopBannerInfo) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo = paramTopBannerInfo;
    if (this.jdField_c_of_type_Int == jdField_a_of_type_Int)
    {
      boolean bool2 = false;
      paramTopBannerInfo = paramTopBannerInfo.items.iterator();
      do
      {
        bool1 = bool2;
        if (!paramTopBannerInfo.hasNext()) {
          break;
        }
      } while (!((TopBannerInfo.BaseItem)paramTopBannerInfo.next()).jdField_a_of_type_Boolean);
      boolean bool1 = true;
      BannerReportHelper.a("0X8009553", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.mChannelId, a(), bool1);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[getCount()];
    b();
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt));
      TopBannerInfo.BaseItem localBaseItem = (TopBannerInfo.BaseItem)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.items.get(paramInt);
      int i = this.jdField_c_of_type_Int;
      if (i == jdField_a_of_type_Int) {
        BannerReportHelper.a("0X8009554", paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.mChannelId, a(), localBaseItem);
      } else if (i == jdField_b_of_type_Int) {
        BannerReportHelper.a("0X8009B90", a(), localBaseItem);
      }
      if ((localBaseItem.jdField_a_of_type_Boolean) && (localBaseItem.jdField_b_of_type_JavaUtilList != null) && (localBaseItem.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        localAdInfo.report_info.trace_info.aid.set(localBaseItem.jdField_a_of_type_Long);
        localAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(localBaseItem.a(localBaseItem.jdField_b_of_type_JavaUtilList));
        GdtC2SReporter.a(0, 1, localAdInfo);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_Int == jdField_a_of_type_Int) {
      BannerReportHelper.a("0X8009555", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.mChannelId, a(), false);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyItem position : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" object: ");
    localStringBuilder.append(paramObject);
    QLog.d(str, 2, localStringBuilder.toString());
    paramViewGroup.removeView((View)paramObject);
    paramViewGroup = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (paramInt < paramViewGroup.length) {
      paramViewGroup[paramInt] = null;
    }
  }
  
  public int getCount()
  {
    int i = a();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (TopBannerInfo.BaseItem)((View)paramObject).getTag();
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.items.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("instantiateItem ");
    ((StringBuilder)localObject2).append(paramViewGroup);
    ((StringBuilder)localObject2).append("  ");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    int i = a();
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (i != 0))
    {
      if ((i > 1) && ((paramInt == 1) || (paramInt == i))) {
        if (paramViewGroup == null)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
          if (localObject1[paramInt] != null) {
            return localObject1[paramInt];
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
          if ((localObject1[paramInt] == null) || (localObject1[paramInt].getParent() != null)) {
            this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt]);
          return this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
        }
      }
      i = a(paramInt);
      localObject1 = (TopBannerInfo.BaseItem)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopBannerInfo.items.get(i);
      localObject1 = a(this.jdField_a_of_type_AndroidAppActivity, (TopBannerInfo.BaseItem)localObject1, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = localObject1;
      localObject2 = jdField_a_of_type_JavaLangString;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "instantiateItem activity is null or data list count is 0");
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */