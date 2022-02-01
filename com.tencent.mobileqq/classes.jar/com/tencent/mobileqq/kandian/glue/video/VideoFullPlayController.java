package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendObserver;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFullPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlay;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.view.VideoCountDownView;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFullPlayController
  implements Handler.Callback, View.OnClickListener, IVideoFullPlayController
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler;
  private VideoPlayRecommendObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
  private IVideoPlay jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlay;
  private BaseVideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
  private VideoCountDownView jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView;
  private VideoFullPlayController.OnFullPlayListener jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController$OnFullPlayListener;
  private VideoFullPlayController.RecommendDataAdapter jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController$RecommendDataAdapter;
  private String jdField_a_of_type_JavaLangString;
  private List<VideoFullPlayController.FullPlayInfo> jdField_a_of_type_JavaUtilList;
  private Queue<BaseVideoPlayParam> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private BaseVideoPlayParam jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private BaseVideoPlayParam jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public VideoFullPlayController(Activity paramActivity, FrameLayout paramFrameLayout, VideoFullPlayController.RecommendDataAdapter paramRecommendDataAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController$RecommendDataAdapter = paramRecommendDataAdapter;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = ReadInJoyUtils.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)paramActivity.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver = new VideoFullPlayController.VideoRecommendObserver(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.getCurrentUin();
    }
  }
  
  private void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2)
  {
    if (((paramBaseVideoPlayParam1 instanceof VideoPlayParam)) && ((paramBaseVideoPlayParam2 instanceof VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = (VideoPlayParam)paramBaseVideoPlayParam1;
      paramBaseVideoPlayParam2 = (VideoPlayParam)paramBaseVideoPlayParam2;
      try
      {
        paramBaseVideoPlayParam2 = paramBaseVideoPlayParam2.a;
        if (paramBaseVideoPlayParam2 != null)
        {
          paramBaseVideoPlayParam2.mChannelID = paramBaseVideoPlayParam1.a.mChannelID;
          paramBaseVideoPlayParam2.mRecommendTime = paramBaseVideoPlayParam1.a.mRecommendTime;
          return;
        }
      }
      catch (Throwable paramBaseVideoPlayParam1)
      {
        if (QLog.isColorLevel())
        {
          paramBaseVideoPlayParam2 = new StringBuilder();
          paramBaseVideoPlayParam2.append("fixNextPlayVideoPlayParam error:");
          paramBaseVideoPlayParam2.append(paramBaseVideoPlayParam1.getMessage());
          QLog.e("VideoFullPlayController", 2, paramBaseVideoPlayParam2.toString());
        }
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler != null)
    {
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
      if (localObject != null)
      {
        localObject = ((BaseVideoPlayParam)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver, Long.parseLong(this.jdField_a_of_type_JavaLangString), (VideoInfo)localObject, 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null, 0);
      }
    }
  }
  
  private void h()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if ((localContext instanceof BaseActivity))
    {
      VideoPlayRecommendObserver localVideoPlayRecommendObserver = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
      if (localVideoPlayRecommendObserver != null) {
        ((BaseActivity)localContext).removeObserver(localVideoPlayRecommendObserver);
      }
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.jdField_a_of_type_Int = (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam, this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam);
  }
  
  private void j()
  {
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlay != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController$OnFullPlayListener;
      if (localObject != null) {
        ((VideoFullPlayController.OnFullPlayListener)localObject).a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam, this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlay.a(this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam = null;
    this.e = false;
  }
  
  public BaseVideoPlayParam a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_c_of_type_Int);
  }
  
  public String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoFullPlayController.FullPlayInfo localFullPlayInfo = (VideoFullPlayController.FullPlayInfo)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localFullPlayInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.a());
        localJSONObject2.put("playCount", localFullPlayInfo.jdField_a_of_type_Int);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
      localJSONObject1.put("first_rowKey", paramString);
      paramString = localJSONObject1.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public List<VideoFullPlayController.FullPlayInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!b()) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.a(paramInt);
      a(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam != null)
    {
      c();
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.a();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  public void a(IVideoPlay paramIVideoPlay)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlay = paramIVideoPlay;
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = (true ^ NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterCountDownMode videoPlayParam:");
      ((StringBuilder)localObject).append(paramBaseVideoPlayParam);
      ((StringBuilder)localObject).append(" mVideoRootFrameLayout:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      QLog.i("VideoFullPlayController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject instanceof BaseActivity))
    {
      VideoPlayRecommendObserver localVideoPlayRecommendObserver = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
      if (localVideoPlayRecommendObserver != null) {
        ((BaseActivity)localObject).addObserver(localVideoPlayRecommendObserver);
      }
    }
    if ((paramBaseVideoPlayParam != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam = paramBaseVideoPlayParam;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.setOnClickListener(null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.setOnCustomClickListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.c();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.setTitle(paramBaseVideoPlayParam.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseVideoPlayParam.jdField_b_of_type_JavaLangString, 0));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView);
      f();
      paramBaseVideoPlayParam = new VideoR5.Builder(null, null, paramBaseVideoPlayParam.c, paramBaseVideoPlayParam.a()).a((int)paramBaseVideoPlayParam.jdField_b_of_type_Long).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramBaseVideoPlayParam, false);
    }
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterFullMode videoPlayParam:");
      localStringBuilder.append(paramBaseVideoPlayParam);
      QLog.i("VideoFullPlayController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam = paramBaseVideoPlayParam;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam != null)
    {
      if (paramBaseVideoPlayParam.jdField_b_of_type_Long == 409409L)
      {
        this.jdField_c_of_type_Int = 0;
        return;
      }
      if (paramBaseVideoPlayParam.jdField_b_of_type_Long == 56L)
      {
        this.jdField_c_of_type_Int = 1;
        return;
      }
      this.jdField_c_of_type_Int = 2;
    }
  }
  
  public void a(VideoFullPlayController.OnFullPlayListener paramOnFullPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController$OnFullPlayListener = paramOnFullPlayListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    BaseVideoPlayParam localBaseVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
    if (localBaseVideoPlayParam != null) {
      this.jdField_a_of_type_JavaUtilList.add(new VideoFullPlayController.FullPlayInfo(localBaseVideoPlayParam, this.jdField_d_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public void b(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFetch nextVideoPlayParam:");
      localStringBuilder.append(paramBaseVideoPlayParam);
      QLog.d("VideoFullPlayController", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam = paramBaseVideoPlayParam;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView.setNextVideoInfo(paramBaseVideoPlayParam);
    if (!this.jdField_c_of_type_Boolean) {
      a(3);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewVideoCountDownView);
    h();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void e()
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = null;
  }
  
  public void f()
  {
    BaseVideoPlayParam localBaseVideoPlayParam = (BaseVideoPlayParam)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localBaseVideoPlayParam == null)
    {
      g();
      return;
    }
    b(localBaseVideoPlayParam);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l / 1000L));
        a(paramMessage.arg1);
        return true;
      }
      a(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131367410: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController$OnFullPlayListener;
      if (paramView != null)
      {
        paramView.ay_();
        return;
      }
      break;
    case 2131364034: 
      c();
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlay;
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
      if (paramView == null) {
        return;
      }
      paramView = new VideoR5.Builder(null, null, paramView.c, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.a()).a((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.jdField_b_of_type_Long).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
      return;
    case 2131364000: 
    case 2131379926: 
      paramView = this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam;
      if (paramView == null) {
        return;
      }
      paramView = new VideoR5.Builder(null, null, paramView.c, this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.a()).a((int)this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.jdField_b_of_type_Long).j(this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.a()).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
      c();
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController
 * JD-Core Version:    0.7.0.1
 */