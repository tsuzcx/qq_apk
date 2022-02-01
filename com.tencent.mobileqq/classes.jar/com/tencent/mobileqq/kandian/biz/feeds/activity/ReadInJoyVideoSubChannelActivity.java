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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
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
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerFactory;
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
  private VideoAutoPlayController A;
  private ReadInJoyBaseAdapter B;
  private int C = -1;
  private int D = -1;
  private String E;
  private int F = 1;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private boolean J = false;
  private TopicShareHelper K;
  private boolean L = false;
  private ActionSheet M;
  private RIJRewardTaskVideoTimer N;
  private int[] O = new int[2];
  private int[] P = new int[2];
  public Map<Integer, Boolean> a = new HashMap();
  ReadInJoyXListView b;
  protected ReadInJoyPageItemCache c;
  protected IFaceDecoder d;
  public int e = 1;
  protected long f = 0L;
  RIJInvokeHandler g;
  protected ReadInJoyObserver h = new ReadInJoyVideoSubChannelActivity.VideoSubChannelObserver(this, null);
  private Map<Integer, Set<Long>> i = new HashMap();
  private Map<Integer, Map<Long, BaseReportData>> j = new HashMap();
  private RelativeLayout k;
  private ViewGroup l;
  private TextView m;
  private TextView n;
  private ImageView o;
  private boolean p;
  private RelativeLayout q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private View v;
  private TextView w;
  private ImageView x;
  private VideoPlayManager y;
  private VideoUIManager z;
  
  private void a(ChannelInfo paramChannelInfo)
  {
    ActionSheet localActionSheet = this.M;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    this.M = ActionSheet.create(this);
    this.M.addButton(HardCodeUtil.a(2131910344), 3);
    this.M.addCancelButton(HardCodeUtil.a(2131898212));
    this.M.show();
    this.M.setOnButtonClickListener(new ReadInJoyVideoSubChannelActivity.7(this, paramChannelInfo));
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
    e(paramChannelInfo.mIsFollowed);
    ReadInJoyLogicEngine.a().a(paramChannelInfo);
    ReadInJoyLogicEngine.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.8(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.e != 0)
    {
      View localView = LayoutInflater.from(p()).inflate(2131626428, paramListView, false);
      this.q = ((RelativeLayout)localView.findViewById(2131434981));
      this.r = ((TextView)localView.findViewById(2131434978));
      this.t = ((TextView)localView.findViewById(2131434971));
      this.s = ((TextView)localView.findViewById(2131434979));
      this.u = ((TextView)localView.findViewById(2131434970));
      this.r.getPaint().setFakeBoldText(true);
      this.s.getPaint().setFakeBoldText(true);
      this.t.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131441404).setVisibility(8);
    if (this.v == null)
    {
      this.v = ((ViewStub)findViewById(2131439207)).inflate();
      this.w = ((TextView)this.v.findViewById(2131444252));
      this.x = ((ImageView)this.v.findViewById(2131444251));
    }
    this.w.setText(paramString);
    this.b.setEmptyView(this.v);
    this.v.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.c.b = System.currentTimeMillis();
    ReadInJoyHelper.a(this.C, this.c.b, (QQAppInterface)ReadInJoyUtils.b());
    Object localObject = this.B;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).d(paramBoolean);
    }
    if (o() == 5)
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
          i1 = 5;
          break label150;
        }
      }
    }
    localObject = null;
    int i1 = -1;
    label150:
    ReadInJoyLogicEngine.a().a(this.C, (List)localObject, i1, true, false, this.F, null, -1L, null, k(), 0L, 0L, null, paramInt, false, null, 0);
    this.F += 1;
    ReadinjoyReportUtils.a(paramInt, this.C, this, -this.b.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.n.getVisibility() != 0)
      {
        if (paramBoolean2)
        {
          VideoFeedsHelper.a(this.n, 0, 300);
          return;
        }
        this.n.setVisibility(0);
      }
    }
    else if (this.n.getVisibility() == 0)
    {
      if (paramBoolean2)
      {
        VideoFeedsHelper.a(this.n, 4, 300);
        return;
      }
      this.n.setVisibility(4);
    }
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.y;
    if ((localObject != null) && (((VideoPlayManager)localObject).g()))
    {
      localObject = this.z;
      if ((localObject != null) && (!((VideoUIManager)localObject).c()))
      {
        this.z.c(paramInt);
        return true;
      }
    }
    return false;
  }
  
  private Intent b(ChannelInfo paramChannelInfo)
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
    localStringBuilder.append(HardCodeUtil.a(2131910538));
    localIntent.putExtra("title", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramChannelInfo.mFollowNum);
    localStringBuilder.append(HardCodeUtil.a(2131910591));
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
  
  private void b(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (this.e == 0) {
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
    this.s.setText(n());
    this.n.setText(n());
    if (this.u != null) {
      if (paramChannelInfo.mFollowNum <= 0)
      {
        this.u.setVisibility(8);
      }
      else
      {
        this.u.setVisibility(0);
        localObject = this.u;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramChannelInfo.mFollowNum);
        localStringBuilder.append(HardCodeUtil.a(2131910318));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    if (this.o != null) {
      if (paramChannelInfo.mIsTopic) {
        this.o.setVisibility(0);
      } else {
        this.o.setVisibility(8);
      }
    }
    e(paramChannelInfo.mIsFollowed);
    if (!this.J)
    {
      this.J = true;
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
        if (!((BaseReportData)localObject1).a)
        {
          ((BaseReportData)localObject1).a = true;
          if (((BaseReportData)localObject1).l != null)
          {
            PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(((BaseReportData)localObject1).g.longValue()), Integer.toString(((BaseReportData)localObject1).h), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).i, ((BaseReportData)localObject1).j, this.C, ((BaseReportData)localObject1).o), false);
            PublicAccountReportUtils.a("0X80066FC", "", "", Long.toString(((BaseReportData)localObject1).g.longValue()), Integer.toString(((BaseReportData)localObject1).h), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).i, ((BaseReportData)localObject1).j, this.C, ((BaseReportData)localObject1).o));
            Object localObject3;
            Object localObject5;
            if (RIJItemViewTypeUtils.t(((BaseReportData)localObject1).l))
            {
              int i1 = 0;
              while (i1 < ((BaseReportData)localObject1).l.mTopicRecommendFeedsInfo.g.size())
              {
                localObject2 = ((BaseReportData)localObject1).s;
                localObject3 = Long.toString(((BaseReportData)localObject1).l.mFeedId);
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append(((TopicRecommendFeedsInfo.TopicRecommendInfo)((BaseReportData)localObject1).l.mTopicRecommendFeedsInfo.g.get(i1)).a);
                ((StringBuilder)localObject5).append("");
                PublicAccountReportUtils.a(null, (String)localObject2, "0X8007626", "0X8007626", 0, 0, (String)localObject3, ((StringBuilder)localObject5).toString(), Integer.toString(((BaseReportData)localObject1).h), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).i, ((BaseReportData)localObject1).j, this.C, ((BaseReportData)localObject1).o, ((BaseReportData)localObject1).p, NetworkUtil.isWifiConnected(p()), ((BaseReportData)localObject1).k, ((BaseReportData)localObject1).r, ((BaseReportData)localObject1).t, RIJFeedsType.n(((BaseReportData)localObject1).l), ((BaseReportData)localObject1).l, 0L, -1, ((BaseReportData)localObject1).u, ((BaseReportData)localObject1).v, ((BaseReportData)localObject1).w, ((BaseReportData)localObject1).x, ((BaseReportData)localObject1).z, ((BaseReportData)localObject1).y, ((BaseReportData)localObject1).E), false);
                i1 += 1;
              }
            }
            Object localObject2 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).i, ((BaseReportData)localObject1).j, this.C, ((BaseReportData)localObject1).o, ((BaseReportData)localObject1).p, NetworkUtil.isWifiConnected(p()), ((BaseReportData)localObject1).k, ((BaseReportData)localObject1).r, ((BaseReportData)localObject1).t, RIJFeedsType.n(((BaseReportData)localObject1).l), ((BaseReportData)localObject1).l, 0L, -1, ((BaseReportData)localObject1).u, ((BaseReportData)localObject1).v, ((BaseReportData)localObject1).w, ((BaseReportData)localObject1).x, ((BaseReportData)localObject1).z, ((BaseReportData)localObject1).y, ((BaseReportData)localObject1).E)).a(((BaseReportData)localObject1).m).O(o()).b(((BaseReportData)localObject1).m).f(((BaseReportData)localObject1).m).b().a();
            PublicAccountReportUtils.a(null, "CliOper", "", ((BaseReportData)localObject1).s, "0X8007626", "0X8007626", 0, 0, Long.toString(((BaseReportData)localObject1).l.mFeedId), Long.toString(((BaseReportData)localObject1).g.longValue()), Integer.toString(((BaseReportData)localObject1).h), (String)localObject2, false);
            PublicAccountReportUtils.a("0X8007626", ((BaseReportData)localObject1).s, Long.toString(((BaseReportData)localObject1).l.mFeedId), Long.toString(((BaseReportData)localObject1).g.longValue()), Integer.toString(((BaseReportData)localObject1).h), RIJTransMergeKanDianReport.a(((BaseReportData)localObject1).i, ((BaseReportData)localObject1).j, this.C, ((BaseReportData)localObject1).o, ((BaseReportData)localObject1).p, NetworkUtil.isWifiConnected(p()), ((BaseReportData)localObject1).k, ((BaseReportData)localObject1).r, ((BaseReportData)localObject1).t, RIJFeedsType.n(((BaseReportData)localObject1).l), ((BaseReportData)localObject1).l, 0L, -1, ((BaseReportData)localObject1).u, ((BaseReportData)localObject1).v, ((BaseReportData)localObject1).w, ((BaseReportData)localObject1).x, ((BaseReportData)localObject1).z, ((BaseReportData)localObject1).y, ((BaseReportData)localObject1).E));
            localObject2 = new ReportInfo();
            ((ReportInfo)localObject2).mUin = RIJQQAppInterfaceUtil.c();
            ((ReportInfo)localObject2).mSource = 0;
            ((ReportInfo)localObject2).mSourceArticleId = ((BaseReportData)localObject1).g.longValue();
            ((ReportInfo)localObject2).mChannelId = this.C;
            ((ReportInfo)localObject2).mAlgorithmId = ((int)((BaseReportData)localObject1).i);
            ((ReportInfo)localObject2).mStrategyId = ((BaseReportData)localObject1).h;
            ((ReportInfo)localObject2).mOperation = 7;
            ((ReportInfo)localObject2).mServerContext = ((BaseReportData)localObject1).q;
            ((ReportInfo)localObject2).mReadTimeLength = -1;
            ((ReportInfo)localObject2).mInnerId = ((BaseReportData)localObject1).t;
            if (((BaseReportData)localObject1).l.mVideoColumnInfo != null) {
              ((ReportInfo)localObject2).mColumnID = ((BaseReportData)localObject1).l.mVideoColumnInfo.b;
            }
            if (((BaseReportData)localObject1).l.mSocialFeedInfo != null)
            {
              localObject3 = new FeedsReportData();
              ((FeedsReportData)localObject3).a = ((BaseReportData)localObject1).l.mSocialFeedInfo.a;
              if (((BaseReportData)localObject1).l.mSocialFeedInfo.c != null) {
                ((FeedsReportData)localObject3).b = ((BaseReportData)localObject1).l.mSocialFeedInfo.c.a;
              }
              ((FeedsReportData)localObject3).d = ((BaseReportData)localObject1).l.mSocialFeedInfo.h;
              ((FeedsReportData)localObject3).e = ((BaseReportData)localObject1).l.mSocialFeedInfo.j;
              localObject5 = ((BaseReportData)localObject1).l.mSocialFeedInfo.d;
              if ((localObject5 != null) && (!((List)localObject5).isEmpty()))
              {
                ((FeedsReportData)localObject3).c = new ArrayList();
                localObject5 = ((List)localObject5).iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject5).next();
                  if (localFeedsInfoUser != null) {
                    ((FeedsReportData)localObject3).c.add(Long.valueOf(localFeedsInfoUser.a));
                  }
                }
              }
              ((ReportInfo)localObject2).mFeedsReportData = ((FeedsReportData)localObject3);
            }
            localArrayList.add(localObject2);
            if (((BaseReportData)localObject1).c) {
              try
              {
                if (((BaseReportData)localObject1).d)
                {
                  localObject3 = RIJTransMergeKanDianReport.d();
                  ((JSONObject)localObject3).put("feeds_source", ((BaseReportData)localObject1).k);
                  ((JSONObject)localObject3).put("kandian_mode", RIJAppSetting.b());
                  PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, RIJFeedsType.m(((BaseReportData)localObject1).l), "", "", ((JSONObject)localObject3).toString(), false);
                }
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
            }
            if (this.C == 56)
            {
              ((ReportInfo)localObject2).mOpSource = 11;
              Object localObject4 = new ReportInfo.VideoExtraRepoerData();
              ((ReportInfo.VideoExtraRepoerData)localObject4).c = 1;
              localObject4 = ((ReportInfo.VideoExtraRepoerData)localObject4).toString();
              ((ReportInfo)localObject2).mInnerId = ((BaseReportData)localObject1).t;
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
    this.b.h();
    String str;
    if ((paramBoolean) && (paramInt > 0)) {
      str = String.format(getResources().getString(2131915228), new Object[] { Integer.valueOf(paramInt) });
    } else {
      str = getResources().getString(2131915227);
    }
    this.b.a(true, str);
  }
  
  private boolean b(Integer paramInteger)
  {
    paramInteger = (Boolean)this.a.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  private Map<Long, BaseReportData> c(Integer paramInteger)
  {
    Map localMap = (Map)this.j.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.j.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.f != 0L) && (this.y != null))
    {
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.B;
      if ((localReadInJoyBaseAdapter != null) && (localReadInJoyBaseAdapter.h() != null) && (this.B.h().size() > 0)) {
        RIJStatisticCollectorReport.a(j(), (System.currentTimeMillis() - this.f) / 1000L, this.y.a(), (AbsBaseArticleInfo)this.B.h().get(0), paramBoolean);
      }
    }
  }
  
  private void d()
  {
    this.C = j();
    this.D = k();
    this.E = n();
    this.y = new VideoPlayManager(this);
    this.c = new ReadInJoyPageItemCache();
    this.c.b = ReadInJoyHelper.a(j(), (QQAppInterface)ReadInJoyUtils.b());
    this.A = VideoAutoPlayController.getInstance();
    this.d = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    SerializableMap localSerializableMap = (SerializableMap)getIntent().getSerializableExtra("channel_map_data");
    if ((localSerializableMap != null) && (localSerializableMap.getMap() != null)) {
      this.e = ((Integer)localSerializableMap.getMap().get("param_key_channel_column_type")).intValue();
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    boolean bool1;
    if (this.B.getCount() == 0) {
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
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = ReadInJoyLogicEngine.a().j(j());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.z = new VideoUIManager((FrameLayout)findViewById(2131449704), (ReadInJoyBaseListView)findViewById(2131437330), this);
    this.z.a(this);
    this.y.a(this.z);
    this.z.a(this);
    this.B.c(o());
    this.N = new RIJRewardTaskVideoTimer();
    this.N.a(this.y);
  }
  
  private void e(boolean paramBoolean)
  {
    TextView localTextView = this.t;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setText(HardCodeUtil.a(2131910470));
        this.t.setTextColor(-9211021);
        this.t.setBackgroundResource(2130844069);
        this.t.setCompoundDrawables(null, null, null, null);
        return;
      }
      localTextView.setText(HardCodeUtil.a(2131899712));
      this.t.setBackgroundResource(2130844062);
      this.t.setTextColor(-1);
    }
  }
  
  private void f()
  {
    View localView = this.v;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131441404);
    this.b.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.l = ((ViewGroup)findViewById(2131447593));
    this.m = ((TextView)findViewById(2131447505));
    this.n = ((TextView)findViewById(2131447579));
    this.o = ((ImageView)findViewById(2131447567));
    if (this.e == 0)
    {
      this.n.setText(n());
      this.n.setVisibility(0);
    }
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
  }
  
  private void h()
  {
    this.b = ((ReadInJoyXListView)findViewById(2131437330));
    this.b.b(0);
    this.b.setChannelId(j());
    this.b.setRefreshCallback(this);
    this.b.a(this);
    a(this.b);
    this.B = new ReadInJoyArticleAdapter(this, getLayoutInflater(), j(), this.b, this.d, this.g.a());
    this.B.e(k());
    this.B.K();
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this);
    this.B.a(localListenerBuilder);
    this.b.setAdapter(this.B);
    this.g.a(findViewById(16908290), this.b, o());
    this.B.a(this.y, this.A);
  }
  
  private void i()
  {
    if (this.l != null)
    {
      Object localObject = this.s;
      if (localObject == null) {
        return;
      }
      ((TextView)localObject).getLocationOnScreen(this.P);
      this.l.getLocationOnScreen(this.O);
      localObject = this.P;
      boolean bool = true;
      int i1 = localObject[1] + this.s.getHeight();
      int i2 = this.O[1] + this.l.getHeight();
      if (i1 != 0)
      {
        if (i2 == 0) {
          return;
        }
        if (i1 > i2) {
          bool = false;
        }
        if (bool != this.p)
        {
          this.p = bool;
          a(this.p);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkIsTopFixed(): mFixed=");
            ((StringBuilder)localObject).append(this.p);
            QLog.i("Q.readinjoy.video.SubChannelActivity", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private int j()
  {
    int i1 = this.C;
    if (i1 != -1) {
      return i1;
    }
    return getIntent().getIntExtra("channel_id", 0);
  }
  
  private int k()
  {
    return 3;
  }
  
  private String n()
  {
    if (!TextUtils.isEmpty(this.E)) {
      return this.E;
    }
    return getIntent().getStringExtra("channel_name");
  }
  
  private int o()
  {
    return getIntent().getIntExtra("channel_from", -1);
  }
  
  private Context p()
  {
    return this;
  }
  
  private void q()
  {
    VideoPlayManager localVideoPlayManager = this.y;
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
    {
      this.y.a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.y.a(11);
    }
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.i.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.i.put(paramInteger, localObject);
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
      paramBaseVideoPlayParam1 = ((VideoPlayParam)paramBaseVideoPlayParam1).D;
      paramBaseVideoPlayParam2 = ((VideoPlayParam)paramBaseVideoPlayParam2).D;
      if ((paramBaseVideoPlayParam1 != null) && (paramBaseVideoPlayParam2 != null)) {
        this.B.a(paramBaseVideoPlayParam1, paramBaseVideoPlayParam2, paramBoolean ^ true);
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
    if (!PreloadManager.a().f()) {
      return;
    }
    PreloadManager.a().h();
    int i2 = this.B.c();
    if ((paramList != null) && (paramList.size() >= 5))
    {
      int i1 = 0;
      while (i1 < 5)
      {
        long l1 = ((Long)paramList.get(i1)).longValue();
        Object localObject = this.B.a(i2, l1);
        if ((localObject != null) && (!RIJFeedsType.a((AbsBaseArticleInfo)localObject)) && (!this.B.b(i2, ((AbsBaseArticleInfo)localObject).mArticleID)))
        {
          localObject = ((AbsBaseArticleInfo)localObject).mArticleContentUrl;
          if (PubAccountPreloadPlugin.a((String)localObject)) {
            PreloadManager.a().b((String)localObject);
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(List<Long> paramList, int paramInt)
  {
    this.B.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.C), paramList));
    this.B.notifyDataSetChanged();
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    ReadInJoyDisplayUtils.a();
    ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.b(), System.currentTimeMillis(), this.C);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.B;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.a(paramSet, paramMap);
    }
    this.c.c = System.currentTimeMillis();
    this.c.g = ReadInJoyHelper.b((QQAppInterface)ReadInJoyUtils.b(), this.C);
    ReadInJoyLogicEngine.a().a(this.C, 20, 9223372036854775807L, true);
    ReadInJoyLogicEngine.a().b(56, 3, j());
    this.a.put(Integer.valueOf(this.C), Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
    a(paramBoolean, true);
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
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.g())
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
    this.G = bool;
    ReadInJoyLogicEngine.a().a(this.C, k(), paramInt, 0, 1);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.3(this));
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setVisibility(8);
      this.b.setVisibility(4);
      return;
    }
    this.l.setVisibility(0);
    this.b.setVisibility(0);
  }
  
  public void cV_()
  {
    if (this.y.k() != null) {
      this.y.k().p();
    }
  }
  
  public void cW_()
  {
    b(true);
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
        ((QQToast)localObject).setDuration(2000);
        if ((bool ^ true))
        {
          ((QQToast)localObject).setToastIcon(QQToast.getIconRes(2));
          ((QQToast)localObject).setToastMsg(2131889172);
          ((QQToast)localObject).show(getApplicationContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        }
        else
        {
          ((QQToast)localObject).setToastIcon(QQToast.getIconRes(1));
          ((QQToast)localObject).setToastMsg(2131889173);
          ((QQToast)localObject).show(getApplicationContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        }
      }
    }
    else if (paramInt1 == 9091) {
      this.B.a(0, paramIntent);
    } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
      ForwardUtils.a((QQAppInterface)ReadInJoyUtils.b(), this, getApplicationContext(), paramIntent, null);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.f = System.currentTimeMillis();
    RIJDtReportHelper.a.a(getActivity());
    this.g = new RIJInvokeHandler();
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(0, HandlerFactory.a(0));
    this.g.a(localSparseArray);
    VideoVolumeControl.getInstance().inKandianModule(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.h);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131626427);
    this.k = ((RelativeLayout)findViewById(2131447595));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.k.setFitsSystemWindows(true);
      this.k.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.doOnCreate(paramBundle);
    d();
    e();
    a(a(Integer.valueOf(j())), c(Integer.valueOf(j())));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.f = 0L;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.h);
    VideoVolumeControl.getInstance().outKandianModule(this);
    a(c(Integer.valueOf(j())), b(Integer.valueOf(j())));
    Object localObject = this.y;
    if (localObject != null) {
      ((VideoPlayManager)localObject).w();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((ReadInJoyBaseAdapter)localObject).I();
      this.B.s();
    }
    this.i.clear();
    this.j.clear();
    this.a.clear();
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
    this.y.z();
    ReadInJoyScreenShotReporter.a(this).a();
    Object localObject = this.B;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).N();
    }
    localObject = this.N;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
    this.y.d(j());
    ReadInJoyScreenShotReporter.a(this).a(k(), j());
    Object localObject = this.B;
    if (localObject != null) {
      ((ReadInJoyBaseAdapter)localObject).M();
    }
    localObject = this.N;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.B.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ReadInJoyVideoSubChannelActivity.1(this));
    }
  }
  
  protected void doOnStop()
  {
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void m()
  {
    ReadInJoyXListView localReadInJoyXListView = this.b;
    if (localReadInJoyXListView == null) {
      return;
    }
    localReadInJoyXListView.g();
    q();
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.y;
    if ((localObject != null) && (((VideoPlayManager)localObject).k() != null))
    {
      localObject = ((VideoPlayManager)localObject).k();
      if (((VideoUIManager)localObject).c())
      {
        ((VideoUIManager)localObject).p();
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
    case 2131447593: 
      this.b.g();
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
      return;
    case 2131447579: 
      if ((this.p) || (this.e == 0))
      {
        this.b.g();
        ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
        return;
      }
      break;
    case 2131447567: 
      if (this.y.g())
      {
        this.y.c();
        this.L = true;
      }
      if (this.K == null) {
        this.K = new TopicShareHelper(this);
      }
      paramView = ReadInJoyLogicEngine.a().j(j());
      if (paramView != null)
      {
        paramView = paramView.clone();
        if (paramView != null)
        {
          if (TextUtils.isEmpty(paramView.mChannelName)) {
            paramView.mChannelName = n();
          }
          this.K.a(paramView, b(paramView), new ReadInJoyVideoSubChannelActivity.6(this));
          return;
        }
      }
      break;
    case 2131447505: 
      finish();
      return;
    case 2131439205: 
      f();
      a(true, 3);
      ReadInJoyLogicEngine.a().b(56, 3, j());
      return;
    case 2131434971: 
      if (!HttpUtil.isConnect(this))
      {
        QQToast.makeText(this, HardCodeUtil.a(2131910293), 0).show();
        return;
      }
      this.I = true;
      paramView = ReadInJoyLogicEngine.a().j(j());
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
    if (this.e != 0) {
      i();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.e != 0) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */