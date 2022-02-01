package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFeedsShuntBarManager
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  private VideoFeedsShuntBarConfigure jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarConfigure;
  private VideofeedsUserGuideController jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video");
    localStringBuilder.append(VideoFeedsShuntBarManager.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public VideoFeedsShuntBarManager(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter, VideofeedsUserGuideController paramVideofeedsUserGuideController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarConfigure = new VideoFeedsShuntBarConfigure(paramQQAppInterface);
    this.jdField_a_of_type_Int = VideoFeedsHelper.a();
    this.jdField_b_of_type_Int = VideoFeedsHelper.b();
    this.jdField_c_of_type_Int = VideoFeedsHelper.c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController = paramVideofeedsUserGuideController;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    int i = 1;
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramVideoItemHolder.q == null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder)))
      {
        paramVideoItemHolder.q = ((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131380637)).inflate());
        paramVideoItemHolder.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramVideoItemHolder.q.findViewById(2131377518));
        paramVideoItemHolder.z = ((TextView)paramVideoItemHolder.q.findViewById(2131377519));
        paramVideoItemHolder.r = paramVideoItemHolder.q.findViewById(2131377517);
      }
      if (paramVideoItemHolder.q == null) {
        break label768;
      }
      paramVideoItemHolder.q.setVisibility(0);
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
    }
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.a(this.jdField_c_of_type_Int);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.a(this.jdField_c_of_type_Int);
      localObject = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int });
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.j);
      paramVideoItemHolder.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    catch (Exception localException)
    {
      Object localObject;
      label223:
      StringBuilder localStringBuilder;
      int j;
      int k;
      float f;
      break label223;
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("后台下发的url格式有问题：");
      localStringBuilder.append(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramVideoItemHolder.z.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    VideoFeedsHelper.a(paramVideoItemHolder.q, 200);
    paramVideoItemHolder.q.setTag(paramVideoItemHolder);
    paramVideoItemHolder.q.setOnClickListener(this);
    if (paramVideoItemHolder.r != null)
    {
      paramVideoItemHolder.r.setTag(paramVideoItemHolder);
      paramVideoItemHolder.r.setOnClickListener(this);
      break label768;
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if ((paramVideoItemHolder.u == null) && (paramVideoItemHolder.jdField_a_of_type_AndroidViewViewStub != null))
        {
          paramVideoItemHolder.jdField_a_of_type_AndroidViewViewStub.inflate();
          paramVideoItemHolder.u = ((ViewGroup)paramVideoItemHolder.C.findViewById(2131373741));
          paramVideoItemHolder.f = ((URLImageView)paramVideoItemHolder.C.findViewById(2131377950));
          paramVideoItemHolder.E = ((TextView)paramVideoItemHolder.C.findViewById(2131377949));
          paramVideoItemHolder.s = paramVideoItemHolder.C.findViewById(2131377947);
          paramVideoItemHolder.F = ((TextView)paramVideoItemHolder.C.findViewById(2131377951));
          paramVideoItemHolder.G = ((TextView)paramVideoItemHolder.C.findViewById(2131377948));
          paramVideoItemHolder.s.setTag(paramVideoItemHolder);
          paramVideoItemHolder.s.setOnClickListener(this);
          paramVideoItemHolder.E.setTag(paramVideoItemHolder);
          paramVideoItemHolder.E.setOnClickListener(this);
        }
        VideoFeedsHelper.a(paramVideoItemHolder.u, 0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        j = ViewUtils.a(60.0F);
        k = ViewUtils.a(10.0F);
        f = j;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.a(f);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.a(f);
        localObject = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.j);
        ((URLDrawable)localObject).setTag(new int[] { 0, 0, k, 0 });
        paramVideoItemHolder.f.setImageDrawable((Drawable)localObject);
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo == null) || (!PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString))) {
          i = 0;
        }
        if (i != 0) {
          paramVideoItemHolder.E.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        } else {
          paramVideoItemHolder.E.setText(paramECommerceEntranceInfo.g);
        }
        paramVideoItemHolder.F.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        paramVideoItemHolder.G.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
        paramVideoItemHolder.v.setVisibility(8);
        paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.e(false);
        paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.h(false);
        paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.i(false);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.g(false);
      }
      else if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2)
      {
        b(paramECommerceEntranceInfo, paramVideoItemHolder, paramVideoInfo);
      }
    }
    label768:
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, paramVideoInfo.g).Q(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).j(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    int i = paramECommerceEntranceInfo.jdField_h_of_type_Int;
    boolean bool = true;
    if (i == 2) {
      return TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString) ^ true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarConfigure.a(paramECommerceEntranceInfo))
    {
      if (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {
        return bool;
      }
      if (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString)) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, int paramInt1, int paramInt2)
  {
    if ((paramECommerceEntranceInfo.jdField_b_of_type_Int >= 0) && (paramInt1 >= paramECommerceEntranceInfo.jdField_b_of_type_Int)) {
      return true;
    }
    return (paramECommerceEntranceInfo.jdField_c_of_type_Int >= 0) && (paramInt1 / paramInt2 * 100.0F >= paramECommerceEntranceInfo.jdField_c_of_type_Int);
  }
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController.a(paramVideoInfo, paramECommerceEntranceInfo, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarConfigure.a();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo == null) && (paramECommerceEntranceInfo != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play by positions, position to play is: ");
        localStringBuilder.append(Arrays.toString(paramECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt));
        localStringBuilder.append(", play time is:");
        localStringBuilder.append(paramECommerceEntranceInfo.jdField_b_of_type_Int);
        localStringBuilder.append(", play percent :");
        localStringBuilder.append(paramECommerceEntranceInfo.jdField_c_of_type_Int);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt)));
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, int paramInt1, int paramInt2)
  {
    if (paramVideoItemHolder.jdField_a_of_type_Int != 2) {
      return;
    }
    if (paramVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo != null))
    {
      if ((a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo)))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo, paramVideoItemHolder, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
        }
      }
    }
    else if ((paramVideoItemHolder.q != null) && (paramVideoItemHolder.q.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
      }
      paramVideoItemHolder.q.setVisibility(8);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramVideoItemHolder);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      Iterator localIterator = new ArrayList((Collection)localObject).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        int i = localInteger.intValue() - 1;
        if ((i > 0) && (i < paramList.size()))
        {
          VideoInfo localVideoInfo = (VideoInfo)paramList.get(i);
          localObject = localVideoInfo;
          if (localVideoInfo.r)
          {
            i += 1;
            if (i < paramList.size()) {
              localObject = (VideoInfo)paramList.get(i);
            }
          }
          else
          {
            if (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo == null) {
              ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(localInteger);
          }
        }
      }
    }
  }
  
  public void b(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo == null) {
        return;
      }
      if (paramVideoItemHolder.jdField_a_of_type_Int != 2) {
        return;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 0)
      {
        if (paramVideoItemHolder.q != null) {
          paramVideoItemHolder.q.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
        {
          if (paramVideoItemHolder.u != null) {
            paramVideoItemHolder.u.setVisibility(8);
          }
          paramVideoItemHolder.v.setVisibility(0);
          paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.e(true);
          paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.h(true);
          paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.i(true);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.g(true);
          return;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsUserGuideController.a();
        }
      }
    }
  }
  
  public void c(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo;
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (((VideoInfo.ECommerceEntranceInfo)localObject1).jdField_h_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.e)) {
        ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).jumpTo(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.e);
      } else if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1) {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    }
    b(paramVideoItemHolder);
    Object localObject2 = null;
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)) {
      paramVideoItemHolder = paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a;
    } else {
      paramVideoItemHolder = null;
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (paramVideoItemHolder != null) {
      localObject1 = paramVideoItemHolder.g;
    } else {
      localObject1 = null;
    }
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, (String)localObject1).Q(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.f);
    if (paramVideoItemHolder != null) {
      localObject1 = paramVideoItemHolder.g;
    } else {
      localObject1 = null;
    }
    localBuilder = localBuilder.j((String)localObject1);
    localObject1 = localObject2;
    if (paramVideoItemHolder != null) {
      localObject1 = Long.valueOf(paramVideoItemHolder.f);
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", localBuilder.e(((Long)localObject1).longValue()).a().a(), false);
  }
  
  public void onClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377517: 
    case 2131377947: 
      b((VideoItemHolder)localBaseItemHolder);
      return;
    }
    c((VideoItemHolder)localBaseItemHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShuntBarManager
 * JD-Core Version:    0.7.0.1
 */