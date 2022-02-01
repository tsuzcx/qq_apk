package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.biz.share.TopicShareHelper;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IHandlerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyVideoSubChannelActivity
  extends BaseActivity
  implements View.OnClickListener, ReadInJoyBaseListView.RefreshCallback, OnLastReadRefreshListener, VideoUIManager.OnScreenChangeListener, OnPlayStateListener, OnUIChangeListener, VideoFullPlayController.OnFullPlayListener, AbsListView.OnScrollListener
{
  public int a;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected IFaceDecoder a;
  protected ReadInJoyPageItemCache a;
  ReadInJoyXListView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  RIJInvokeHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
  private TopicShareHelper jdField_a_of_type_ComTencentMobileqqKandianBizShareTopicShareHelper;
  private VideoAutoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  private VideoUIManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  protected ReadInJoyObserver a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  public Map<Integer, Boolean> a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Map<Integer, Set<Long>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = -1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Map<Integer, Map<Long, BaseReportData>> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private TextView g;
  
  public ReadInJoyVideoSubChannelActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyVideoSubChannelActivity.VideoSubChannelObserver(this, null);
  }
  
  private int a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      return i;
    }
    return getIntent().getIntExtra("channel_id", 0);
  }
  
  private Context a()
  {
    return this;
  }
  
  private Intent a(ChannelInfo paramChannelInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", TopicShareHelper.a(paramChannelInfo, 0));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("「");
    localStringBuilder.append(paramChannelInfo.mChannelName);
    localStringBuilder.append(HardCodeUtil.a(2131712973));
    localIntent.putExtra("title", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramChannelInfo.mFollowNum);
    localStringBuilder.append(HardCodeUtil.a(2131713029));
    localIntent.putExtra("desc", localStringBuilder.toString());
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = StructMsgFactory.a(localIntent.getExtras());
    paramChannelInfo.mMsgServiceID = 83;
    localIntent.putExtra("stuctmsg_bytes", paramChannelInfo.getBytes());
    return localIntent;
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return getIntent().getStringExtra("channel_name");
  }
  
  private Map<Long, BaseReportData> a(Integer paramInteger)
  {
    Map localMap = (Map)this.jdField_c_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.jdField_c_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  private void a(ChannelInfo paramChannelInfo)
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131712771), 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131712690));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyVideoSubChannelActivity.7(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doFollowUnFollow(): isFollow =");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, localStringBuilder.toString());
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    d(paramChannelInfo.mIsFollowed);
    ReadInJoyLogicEngine.a().a(paramChannelInfo);
    ReadInJoyLogicEngine.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.8(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2131560382, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368126));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368123));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368117));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368124));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368116));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131373730).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131371772)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376052));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376051));
    }
    this.g.setText(paramString);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).d(paramBoolean);
    }
    if (c() == 5)
    {
      localObject = (SerializableMap)getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((SerializableMap)localObject).getMap() != null))
      {
        Map localMap = ((SerializableMap)localObject).getMap();
        Long localLong = (Long)localMap.get("param_key_insert_article_id");
        if (localLong != null)
        {
          localObject = new ArrayList();
          ((List)localObject).add(localLong);
          localMap.remove("param_key_insert_article_id");
          i = 5;
          break label150;
        }
      }
    }
    localObject = null;
    int i = -1;
    label150:
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, (List)localObject, i, true, false, this.jdField_d_of_type_Int, null, -1L, null, b(), 0L, 0L, null, paramInt, false, null, 0);
    this.jdField_d_of_type_Int += 1;
    ReadinjoyReportUtils.a(paramInt, this.jdField_b_of_type_Int, this, -this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (paramBoolean2)
        {
          VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      if (paramBoolean2)
      {
        VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, 4, 300);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localObject != null) && (((VideoPlayManager)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
      if ((localObject != null) && (!((VideoUIManager)localObject).a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.c(paramInt);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.getCount() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((!bool1) && (!paramBoolean)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    QLog.d("Q.readinjoy.video.SubChannelActivity", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isFristLoadFromDB=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) }));
    if (bool2) {
      a(false, 1);
    }
    return bool2;
  }
  
  private int b()
  {
    return 3;
  }
  
  private void b(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    if (paramChannelInfo == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateHeaderUI(): fromServer = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", channelInfo = ");
      ((StringBuilder)localObject).append(paramChannelInfo.toString());
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      if (paramChannelInfo.mFollowNum <= 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = this.jdField_f_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramChannelInfo.mFollowNum);
        localStringBuilder.append(HardCodeUtil.a(2131712743));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      if (paramChannelInfo.mIsTopic) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    d(paramChannelInfo.mIsFollowed);
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.9(this, paramChannelInfo));
    }
  }
  
  private void b(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if ((paramMap != null) && (paramMap.values() != null))
    {
      if (!paramBoolean) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (BaseReportData)paramMap.next();
        if (!((BaseReportData)localObject1).jdField_a_of_type_Boolean)
        {
          ((BaseReportData)localObject1).jdField_a_of_type_Boolean = true;
          if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(((BaseReportData)localObject1).jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(((BaseReportData)localObject1).jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).jdField_a_of_type_Long, ((BaseReportData)localObject1).jdField_c_of_type_Int, this.jdField_b_of_type_Int, ((BaseReportData)localObject1).jdField_d_of_type_Int), false);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FC", "", "", Long.toString(((BaseReportData)localObject1).jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(((BaseReportData)localObject1).jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).jdField_a_of_type_Long, ((BaseReportData)localObject1).jdField_c_of_type_Int, this.jdField_b_of_type_Int, ((BaseReportData)localObject1).jdField_d_of_type_Int));
            Object localObject3;
            Object localObject5;
            Object localObject6;
            if (RIJItemViewTypeUtils.t(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
            {
              int i = 0;
              while (i < ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
              {
                localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
                localObject3 = ((BaseReportData)localObject1).jdField_d_of_type_JavaLangString;
                localObject5 = Long.toString(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append(((TopicRecommendFeedsInfo.TopicRecommendInfo)((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int);
                ((StringBuilder)localObject6).append("");
                ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, (String)localObject3, "0X8007626", "0X8007626", 0, 0, (String)localObject5, ((StringBuilder)localObject6).toString(), Integer.toString(((BaseReportData)localObject1).jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).jdField_a_of_type_Long, ((BaseReportData)localObject1).jdField_c_of_type_Int, this.jdField_b_of_type_Int, ((BaseReportData)localObject1).jdField_d_of_type_Int, ((BaseReportData)localObject1).jdField_e_of_type_Int, NetworkUtil.isWifiConnected(a()), ((BaseReportData)localObject1).jdField_a_of_type_JavaLangString, ((BaseReportData)localObject1).jdField_c_of_type_JavaLangString, ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString, RIJFeedsType.e(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0L, -1, ((BaseReportData)localObject1).jdField_f_of_type_Int, ((BaseReportData)localObject1).g, ((BaseReportData)localObject1).h, ((BaseReportData)localObject1).jdField_f_of_type_Boolean, ((BaseReportData)localObject1).j, ((BaseReportData)localObject1).i, ((BaseReportData)localObject1).m), false);
                i += 1;
              }
            }
            Object localObject2 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).jdField_a_of_type_Long, ((BaseReportData)localObject1).jdField_c_of_type_Int, this.jdField_b_of_type_Int, ((BaseReportData)localObject1).jdField_d_of_type_Int, ((BaseReportData)localObject1).jdField_e_of_type_Int, NetworkUtil.isWifiConnected(a()), ((BaseReportData)localObject1).jdField_a_of_type_JavaLangString, ((BaseReportData)localObject1).jdField_c_of_type_JavaLangString, ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString, RIJFeedsType.e(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0L, -1, ((BaseReportData)localObject1).jdField_f_of_type_Int, ((BaseReportData)localObject1).g, ((BaseReportData)localObject1).h, ((BaseReportData)localObject1).jdField_f_of_type_Boolean, ((BaseReportData)localObject1).j, ((BaseReportData)localObject1).i, ((BaseReportData)localObject1).m)).a(((BaseReportData)localObject1).jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).N(c()).b(((BaseReportData)localObject1).jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).f(((BaseReportData)localObject1).jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).a().a();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", ((BaseReportData)localObject1).jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), Long.toString(((BaseReportData)localObject1).jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(((BaseReportData)localObject1).jdField_b_of_type_Int), (String)localObject2, false);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007626", ((BaseReportData)localObject1).jdField_d_of_type_JavaLangString, Long.toString(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), Long.toString(((BaseReportData)localObject1).jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(((BaseReportData)localObject1).jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).jdField_a_of_type_Long, ((BaseReportData)localObject1).jdField_c_of_type_Int, this.jdField_b_of_type_Int, ((BaseReportData)localObject1).jdField_d_of_type_Int, ((BaseReportData)localObject1).jdField_e_of_type_Int, NetworkUtil.isWifiConnected(a()), ((BaseReportData)localObject1).jdField_a_of_type_JavaLangString, ((BaseReportData)localObject1).jdField_c_of_type_JavaLangString, ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString, RIJFeedsType.e(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0L, -1, ((BaseReportData)localObject1).jdField_f_of_type_Int, ((BaseReportData)localObject1).g, ((BaseReportData)localObject1).h, ((BaseReportData)localObject1).jdField_f_of_type_Boolean, ((BaseReportData)localObject1).j, ((BaseReportData)localObject1).i, ((BaseReportData)localObject1).m));
            localObject2 = new ReportInfo();
            ((ReportInfo)localObject2).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
            ((ReportInfo)localObject2).mSource = 0;
            ((ReportInfo)localObject2).mSourceArticleId = ((BaseReportData)localObject1).jdField_a_of_type_JavaLangLong.longValue();
            ((ReportInfo)localObject2).mChannelId = this.jdField_b_of_type_Int;
            ((ReportInfo)localObject2).mAlgorithmId = ((int)((BaseReportData)localObject1).jdField_a_of_type_Long);
            ((ReportInfo)localObject2).mStrategyId = ((BaseReportData)localObject1).jdField_b_of_type_Int;
            ((ReportInfo)localObject2).mOperation = 7;
            ((ReportInfo)localObject2).mServerContext = ((BaseReportData)localObject1).jdField_a_of_type_ArrayOfByte;
            ((ReportInfo)localObject2).mReadTimeLength = -1;
            ((ReportInfo)localObject2).mInnerId = ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString;
            if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo != null) {
              ((ReportInfo)localObject2).mColumnID = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
            }
            if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null)
            {
              localObject3 = new FeedsReportData();
              ((FeedsReportData)localObject3).jdField_a_of_type_Long = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
              if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
                ((FeedsReportData)localObject3).jdField_b_of_type_Long = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
              }
              ((FeedsReportData)localObject3).jdField_a_of_type_Int = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
              ((FeedsReportData)localObject3).jdField_b_of_type_Int = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
              localObject5 = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
              if ((localObject5 != null) && (!((List)localObject5).isEmpty()))
              {
                ((FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
                localObject5 = ((List)localObject5).iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (FeedsInfoUser)((Iterator)localObject5).next();
                  if (localObject6 != null) {
                    ((FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject6).jdField_a_of_type_Long));
                  }
                }
              }
              ((ReportInfo)localObject2).mFeedsReportData = ((FeedsReportData)localObject3);
            }
            localArrayList.add(localObject2);
            if (((BaseReportData)localObject1).jdField_c_of_type_Boolean) {
              try
              {
                if (((BaseReportData)localObject1).jdField_d_of_type_Boolean)
                {
                  localObject3 = RIJTransMergeKanDianReport.a();
                  ((JSONObject)localObject3).put("feeds_source", ((BaseReportData)localObject1).jdField_a_of_type_JavaLangString);
                  ((JSONObject)localObject3).put("kandian_mode", RIJAppSetting.a());
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, RIJFeedsType.d(((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "", "", ((JSONObject)localObject3).toString(), false);
                }
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              ((ReportInfo)localObject2).mOpSource = 11;
              Object localObject4 = new ReportInfo.VideoExtraRepoerData();
              ((ReportInfo.VideoExtraRepoerData)localObject4).jdField_c_of_type_Int = 1;
              localObject4 = ((ReportInfo.VideoExtraRepoerData)localObject4).toString();
              ((ReportInfo)localObject2).mInnerId = ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("reportVideoUserOperationByOidbOfFeed subchannel--mUin:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mUin);
                ((StringBuilder)localObject1).append("; mSource:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mSource);
                ((StringBuilder)localObject1).append("; mOpSource:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mOpSource);
                ((StringBuilder)localObject1).append("; mInnerId:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mInnerId);
                ((StringBuilder)localObject1).append("; mChannelId:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mChannelId);
                ((StringBuilder)localObject1).append("; mAlgorithmId:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mAlgorithmId);
                ((StringBuilder)localObject1).append("; mStrategyId:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mStrategyId);
                ((StringBuilder)localObject1).append("; mOperation:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mOperation);
                ((StringBuilder)localObject1).append("; mPlayTimeLength:");
                ((StringBuilder)localObject1).append(((ReportInfo)localObject2).mPlayTimeLength);
                ((StringBuilder)localObject1).append("; videoExtraRepoerData:");
                ((StringBuilder)localObject1).append((String)localObject4);
                QLog.d("VideoReporter", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ReadInJoyLogicEngine.a().a(localArrayList);
      }
    }
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.g();
    String str;
    if ((paramBoolean) && (paramInt > 0)) {
      str = String.format(getResources().getString(2131717753), new Object[] { Integer.valueOf(paramInt) });
    } else {
      str = getResources().getString(2131717752);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(true, str);
  }
  
  private int c()
  {
    return getIntent().getIntExtra("channel_from", -1);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager != null))
    {
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
      if ((localReadInJoyBaseAdapter != null) && (localReadInJoyBaseAdapter.b() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b().size() > 0)) {
        RIJStatisticCollectorReport.a(a(), (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(), (AbsBaseArticleInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b().get(0), paramBoolean);
      }
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = new VideoPlayManager(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long = ReadInJoyHelper.a(a(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController = VideoAutoPlayController.getInstance();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    SerializableMap localSerializableMap = (SerializableMap)getIntent().getSerializableExtra("channel_map_data");
    if ((localSerializableMap != null) && (localSerializableMap.getMap() != null)) {
      this.jdField_a_of_type_Int = ((Integer)localSerializableMap.getMap().get("param_key_channel_column_type")).intValue();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setText(HardCodeUtil.a(2131712900));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-9211021);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130843114);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        return;
      }
      localTextView.setText(HardCodeUtil.a(2131712980));
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130843107);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
  }
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = ReadInJoyLogicEngine.a().a(a());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager = new VideoUIManager((FrameLayout)findViewById(2131380736), (ReadInJoyBaseListView)findViewById(2131370164), this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.c(c());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager);
  }
  
  private void f()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131373730);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378891));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378822));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378867));
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131370164));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = new ReadInJoyArticleAdapter(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.c(b());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.d();
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(localListenerBuilder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(findViewById(16908290), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, c());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        return;
      }
      ((TextView)localObject).getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      localObject = this.jdField_b_of_type_ArrayOfInt;
      boolean bool = true;
      int i = localObject[1] + this.jdField_d_of_type_AndroidWidgetTextView.getHeight();
      int j = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
      if (i != 0)
      {
        if (j == 0) {
          return;
        }
        if (i > j) {
          bool = false;
        }
        if (bool != this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = bool;
          a(this.jdField_a_of_type_Boolean);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkIsTopFixed(): mFixed=");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
            QLog.i("Q.readinjoy.video.SubChannelActivity", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private void j()
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(11);
    }
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_b_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a() {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    a(true, 3);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.2(this));
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNextVideoPlay:  enterVideoPlayParam:");
      localStringBuilder.append(paramBaseVideoPlayParam1);
      localStringBuilder.append("  nextVideoPlayParam:");
      localStringBuilder.append(paramBaseVideoPlayParam2);
      localStringBuilder.append("\n nextScrollByDistance:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isPlayFirstNext:");
      localStringBuilder.append(paramBoolean);
      QLog.i("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
    }
    if ((paramBaseVideoPlayParam1 != null) && ((paramBaseVideoPlayParam1 instanceof VideoPlayParam)) && (paramBaseVideoPlayParam2 != null) && ((paramBaseVideoPlayParam2 instanceof VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = ((VideoPlayParam)paramBaseVideoPlayParam1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      paramBaseVideoPlayParam2 = ((VideoPlayParam)paramBaseVideoPlayParam2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((paramBaseVideoPlayParam1 != null) && (paramBaseVideoPlayParam2 != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(paramBaseVideoPlayParam1, paramBaseVideoPlayParam2, paramBoolean ^ true);
      }
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    b(false);
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {
      return;
    }
    PreloadManager.a().e();
    int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
    if ((paramList != null) && (paramList.size() >= 5))
    {
      int i = 0;
      while (i < 5)
      {
        long l = ((Long)paramList.get(i)).longValue();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(j, l);
        if ((localObject != null) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(j, ((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().a((String)localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(List<Long> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    ReadInJoyDisplayUtils.a();
    ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_b_of_type_Int);
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    ReadInJoyLogicEngine.a().b(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramBoolean, true);
  }
  
  public void ay_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a().j();
    }
  }
  
  public void b()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.app))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-1);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0, 1);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.3(this));
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setVisibility(0);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult(): requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 103)
    {
      if (paramInt2 == -1)
      {
        boolean bool = paramIntent.getBooleanExtra("bFailed", false);
        localObject = new QQToast(this);
        ((QQToast)localObject).d(2000);
        if ((bool ^ true))
        {
          ((QQToast)localObject).a(QQToast.a(2));
          ((QQToast)localObject).c(2131692185);
          ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        }
        else
        {
          ((QQToast)localObject).a(QQToast.a(1));
          ((QQToast)localObject).c(2131692186);
          ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        }
      }
    }
    else if (paramInt1 == 9091) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(0, paramIntent);
    } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
      ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), this, getApplicationContext(), paramIntent, null);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    RIJDtReportHelper.a.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler = new RIJInvokeHandler();
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(0, ((IHandlerFactory)QRoute.api(IHandlerFactory.class)).createHandler(0));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(localSparseArray);
    VideoVolumeControl.getInstance().inKandianModule(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131560381);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378893));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.doOnCreate(paramBundle);
    d();
    e();
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Long = 0L;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    VideoVolumeControl.getInstance().outKandianModule(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null) {
      ((VideoPlayManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localObject != null)
    {
      ((ReadInJoyBaseAdapter)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b();
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ReadInJoyScreenShotReporter.a(this).b();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 25) {
      bool1 = a(-1);
    } else if (paramInt == 24) {
      bool1 = a(1);
    } else {
      bool1 = false;
    }
    if (!bool1)
    {
      if (super.doOnKeyDown(paramInt, paramKeyEvent)) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.e();
    ReadInJoyScreenShotReporter.a(this).a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d(a());
    ReadInJoyScreenShotReporter.a(this).a(b(), a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ReadInJoyVideoSubChannelActivity.1(this));
    }
  }
  
  protected void doOnStop()
  {
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void l()
  {
    b(true);
  }
  
  public void m()
  {
    ReadInJoyXListView localReadInJoyXListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
    if (localReadInJoyXListView == null) {
      return;
    }
    localReadInJoyXListView.f();
    j();
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
    {
      localObject = ((VideoPlayManager)localObject).a();
      if (((VideoUIManager)localObject).a())
      {
        ((VideoUIManager)localObject).j();
        return true;
      }
    }
    c(false);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131378891: 
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.f();
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
      return;
    case 2131378878: 
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.f();
        ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
        return;
      }
      break;
    case 2131378867: 
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
        this.jdField_f_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareTopicShareHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizShareTopicShareHelper = new TopicShareHelper(this);
      }
      paramView = ReadInJoyLogicEngine.a().a(a());
      if (paramView != null)
      {
        paramView = paramView.clone();
        if (paramView != null)
        {
          if (TextUtils.isEmpty(paramView.mChannelName)) {
            paramView.mChannelName = a();
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizShareTopicShareHelper.a(paramView, a(paramView), new ReadInJoyVideoSubChannelActivity.6(this));
          return;
        }
      }
      break;
    case 2131378822: 
      finish();
      return;
    case 2131371770: 
      f();
      a(true, 3);
      ReadInJoyLogicEngine.a().b(56, 3, a());
      return;
    case 2131368117: 
      if (!HttpUtil.isConnect(this))
      {
        QQToast.a(this, HardCodeUtil.a(2131712717), 0).a();
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      paramView = ReadInJoyLogicEngine.a().a(a());
      if (paramView != null)
      {
        if (paramView.mIsFollowed)
        {
          a(paramView);
          return;
        }
        a(paramView, true);
      }
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0) {
      i();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != 0) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */