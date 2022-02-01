package com.tencent.mobileqq.gamecenter.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.IHeaderView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.view.QQGamePubHeaderFactory;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.gamecenter.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2;
import com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2.IPageListener;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView.HeadViewVisibleListener;
import com.tencent.mobileqq.gamecenter.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import eipc.EIPCResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameFeedWebFragment
  extends PublicBaseFragment
  implements WadlProxyServiceCallBackInterface, QQGameIpcHandle.QGameIpcCallBack, GameContentView.UiRefresh, QQGameIndicator2.IPageListener, QQGamePubWebView.HeadViewVisibleListener, BusinessObserver
{
  public static final byte[] a;
  public int a;
  public long a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new QQGameFeedWebFragment.14(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private GameSessionView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  private IHeaderView jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView;
  public NavBarQQGamePub a;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private QQGameFeedWebFragment.HeadPageAdapter jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter;
  private QQGameFeedWebFragment.MessageQGameReceiver jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$MessageQGameReceiver;
  private QQGameWebViewBuilder jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder;
  private GameContentView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout;
  private QQGameIndicator2 jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2;
  private QQGamePubWebView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView;
  private UnreadTipLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout;
  List<IHeaderView> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public int b;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<QQGameMsgInfo> jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  public long d;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  public long e;
  private boolean jdField_e_of_type_Boolean = false;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public QQGameFeedWebFragment()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private float a(Context paramContext, float paramFloat)
  {
    try
    {
      f1 = FontSettingManager.systemMetrics.density;
      return paramFloat / f1 + 0.5F;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        float f1 = UIUtils.a(paramContext);
      }
    }
  }
  
  private int a()
  {
    int i3 = 417;
    int i2 = 0;
    int i1 = i2;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.getVisibility() == 0) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "gameContentHeight=" + i1);
      }
      i2 = i3;
      if (isAdded())
      {
        i2 = i3;
        if (getActivity() != null)
        {
          i2 = i3;
          if (!getActivity().isFinishing())
          {
            float f1 = a(getActivity(), i1 + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight());
            i2 = (int)f1;
          }
        }
      }
      return i2;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("GameWebPage", 1, "getWebPading faile:" + localThrowable.getMessage());
    }
    return 417;
  }
  
  private QQGameMsgInfo a()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (i1 < this.jdField_b_of_type_JavaUtilList.size())) {
      return (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
    }
    return null;
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getString("msgPos_web" + paramAppInterface.getCurrentAccountUin(), "");
  }
  
  private String a(String paramString, List<QQGameMsgInfo> paramList, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (paramList.size() > 0))
    {
      if (paramString.indexOf("?") == -1) {}
      try
      {
        return paramString + "?gameData=" + URLEncoder.encode(a(paramList), "utf-8") + "&index=" + paramInt + "&height=" + a() + "&_bid=4235";
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return paramString;
      }
      paramList = paramString + "&gameData=" + URLEncoder.encode(a(paramList), "utf-8") + "&index=" + paramInt + "&height=" + a() + "&_bid=4235";
      return paramList;
    }
    if (paramString.indexOf("?") == -1) {
      return paramString + "?height=" + a() + "&_bid=4235";
    }
    return paramString + "&height=" + a() + "&_bid=4235";
  }
  
  private String a(List<QQGameMsgInfo> paramList)
  {
    JSONArray localJSONArray;
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
          if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
            localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
          }
          localJSONArray.put(localJSONObject);
          continue;
          return "";
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
    paramList = localJSONArray.toString();
    return paramList;
  }
  
  private void a(long paramLong)
  {
    if (paramLong < 0L) {}
    do
    {
      return;
      paramLong = (SystemClock.elapsedRealtime() - paramLong) / 1000L;
    } while (paramLong <= 0L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(17), paramLong + "");
    localHashMap.put(Integer.valueOf(24), "1");
    GameCenterUtils.a(CmGameUtil.a(), "769", "206471", "", "76916", "1", "160", localHashMap);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof ViewGroup)); paramView = paramView.getParent()) {
      ((ViewGroup)paramView).setClipChildren(paramBoolean);
    }
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramAppInterface = "msgPos_web" + paramAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).apply();
  }
  
  private void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    if ((paramGmpEnterInfoRsp != null) && (paramGmpEnterInfoRsp.ret_code == 0) && (paramGmpEnterInfoRsp.state == 1) && (paramBoolean))
    {
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.18(this, paramGmpEnterInfoRsp));
      return;
    }
    paramGmpEnterInfoRsp = QQGameHelper.a();
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramGmpEnterInfoRsp.bubble_id))
    {
      localHashMap.put(Integer.valueOf(2), paramGmpEnterInfoRsp.bubble_id);
      localHashMap.put(Integer.valueOf(3), "1");
    }
    for (;;)
    {
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      GameCenterUtils.a(CmGameUtil.a(), "770", "207021", "", "77002", "1", "160", localHashMap);
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.19(this, paramGmpEnterInfoRsp));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GameWebPage", 1, "rec game enter is null");
      return;
      localHashMap.put(Integer.valueOf(3), "2");
    }
  }
  
  private void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter.getCount() != 1)) {
        break label454;
      }
    }
    label454:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        return;
      }
      this.jdField_b_of_type_Int += paramArrayList.size();
      this.jdField_c_of_type_Int += paramArrayList.size();
      int i2 = 0;
      if (i2 < paramArrayList.size())
      {
        this.jdField_b_of_type_JavaUtilList.add(0, paramArrayList.get(i2));
        for (;;)
        {
          synchronized (jdField_a_of_type_ArrayOfByte)
          {
            Object localObject2 = QQGamePubHeaderFactory.a((QQGameMsgInfo)paramArrayList.get(i2), getActivity());
            this.jdField_a_of_type_JavaUtilList.add(0, localObject2);
            if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(i2)).arkAppName)) {
              this.jdField_c_of_type_JavaUtilList.add(((QQGameMsgInfo)paramArrayList.get(i2)).arkAppName);
            }
            if (i2 == paramArrayList.size() - 1)
            {
              if (i1 == 0) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
              }
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(((QQGameMsgInfo)paramArrayList.get(i2)).paMsgid);
            }
            if (i1 != 0)
            {
              i3 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
              d(-1);
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i3);
              localObject2 = new HashMap();
              ((Map)localObject2).put(Integer.valueOf(2), ((QQGameMsgInfo)paramArrayList.get(i2)).paMsgid);
              ((Map)localObject2).put(Integer.valueOf(4), "8");
              ((Map)localObject2).put(Integer.valueOf(24), "1");
              if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(i2)).gameAppId)) {
                break label377;
              }
              ??? = "";
              GameCenterUtils.a(CmGameUtil.a(), "769", "205030", (String)???, "76901", "1", "160", (Map)localObject2);
              i2 += 1;
            }
          }
          int i3 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() + 1;
          continue;
          label377:
          ??? = ((QQGameMsgInfo)paramArrayList.get(i2)).gameAppId;
        }
      }
      paramArrayList = a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      ??? = new Message();
      ((Message)???).what = 2;
      ((Message)???).arg1 = -1;
      ((Message)???).arg2 = -1;
      ((Message)???).obj = paramArrayList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(8);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setUnreadNum(paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "");
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if ((paramInt >= this.jdField_b_of_type_Int) && (this.jdField_b_of_type_Int <= this.jdField_c_of_type_Int) && (paramInt <= this.jdField_c_of_type_Int))
      {
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Int = (this.jdField_c_of_type_Int - this.jdField_b_of_type_Int + 1);
        if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int <= 3)) {
          a(true, this.jdField_a_of_type_Int);
        }
      }
      else
      {
        return;
      }
      a(false, 0);
      return;
    }
    a(false, 0);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131374885));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)paramView.findViewById(2131374886));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView = ((GameContentView)paramView.findViewById(2131370118));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370174));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131366897));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2 = ((QQGameIndicator2)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131372707));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380687));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370209));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368979));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout = ((UnreadTipLayout)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131370072));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter = new QQGameFeedWebFragment.HeadPageAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setPageListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377237));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(QQGameConstant.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new QQGameFeedWebFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView = (ImageView)paramView.findViewById(2131368294);
    paramView.setVisibility(0);
    paramView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramView.setImageResource(2130846601);
    h();
  }
  
  private void c()
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      if (localIntent.hasExtra("startTime"))
      {
        long l1 = localIntent.getLongExtra("startTime", 0L);
        if (l1 > 0L) {
          this.m = (SystemClock.elapsedRealtime() - l1);
        }
      }
      if (localIntent.hasExtra("clickTime")) {
        this.l = localIntent.getLongExtra("clickTime", 0L);
      }
      if (localIntent.hasExtra("unreadNum")) {
        this.jdField_a_of_type_Int = localIntent.getIntExtra("unreadNum", 0);
      }
      if (localIntent.hasExtra("unreadNum")) {
        this.jdField_a_of_type_Int = localIntent.getIntExtra("unreadNum", 0);
      }
      if (localIntent.hasExtra("isColdBoot")) {
        this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("isColdBoot", false);
      }
    }
  }
  
  private void c(int paramInt)
  {
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label116;
        }
        if (i1 == paramInt)
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView = ((IHeaderView)this.jdField_a_of_type_JavaUtilList.get(i1));
          if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView instanceof GameArkView)) {
            GameVideoManager.a().a((GameArkView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView);
          } else {
            GameVideoManager.a().a(null);
          }
        }
      }
      finally {}
      IHeaderView localIHeaderView = (IHeaderView)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (localIHeaderView != null)
      {
        localIHeaderView.b();
        break label135;
        label116:
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.a();
        }
        return;
      }
      label135:
      i1 += 1;
    }
  }
  
  private void c(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).heightPixels;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370713));
    int i2 = AIOUtils.a(418.0F, getActivity().getResources());
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.a(i1 - i2, getActivity().getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (IPreloadServiceProxy)BaseApplicationImpl.getApplication().peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, "multi");
    if (TextUtils.isEmpty(PreloadStaticApi.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      i();
      ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new QQGameFeedWebFragment.5(this));
      return;
    }
    ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new QQGameFeedWebFragment.6(this, paramView));
  }
  
  private void d()
  {
    QQGameIpcHandle.a().a();
    QQGameIpcHandle.a().a("task_qgame_task_all_complete", this);
    QQGameIpcHandle.a().a("task_get_qgame_msg", this);
    QQGameIpcHandle.a().a("task_get_qgame_msg", true);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
      if (paramInt > 0) {
        this.jdField_d_of_type_Int -= 1;
      }
      if ((getActivity() != null) && (!getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (paramInt > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(paramInt);
      }
    }
  }
  
  private void d(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372216));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372215));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new QQGameFeedWebFragment.9(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.setUiRefresh(this);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.b();
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = false;
    WadlProxyServiceUtil.a().a(this);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      WadlProxyServiceUtil.a().a();
    }
  }
  
  private void h()
  {
    this.jdField_d_of_type_Boolean = QQGameConfigUtil.c();
    if (this.jdField_a_of_type_Int > 1)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setUnreadNum(this.jdField_a_of_type_Int - 1);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setOnClickListener(new QQGameFeedWebFragment.2(this));
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.post(new QQGameFeedWebFragment.3(this));
        localObject1 = new HashMap();
        ((Map)localObject1).put(Integer.valueOf(4), "8");
        ((Map)localObject1).put(Integer.valueOf(24), "1");
        GameCenterUtils.a(CmGameUtil.a(), "769", "207552", "", "76925", "1", "160", (Map)localObject1);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = new ColorDrawable(-15090945);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    localObject2 = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202006/upload_32b6df772edd7f4dd2bf13382f80d356.png", (URLDrawable.URLDrawableOptions)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202004/upload_5dea58e62564d53805d39c48742c5f0a.png", (URLDrawable.URLDrawableOptions)localObject1);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Int - 1 + "");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new QQGameFeedWebFragment.4(this));
    localObject1 = new HashMap();
    ((Map)localObject1).put(Integer.valueOf(24), "1");
    ((Map)localObject1).put(Integer.valueOf(3), "2");
    ((Map)localObject1).put(Integer.valueOf(4), "8");
    GameCenterUtils.a(CmGameUtil.a(), "769", "207028", "", "76901", "1", "160", (Map)localObject1);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.a(7.0F, getActivity().getResources());
    localTextView.setText(HardCodeUtil.a(2131710270));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130847540);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130847540);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(AIOUtils.a(15.0F, getActivity().getResources()), AIOUtils.a(15.0F, getActivity().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private void j()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.h = (this.g - this.f);
      this.j = (this.i - this.g);
      long l1 = this.i - this.jdField_a_of_type_Long + this.m;
      long l2 = this.h + this.j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("GamePub H5 pref data=").append("{").append("isColdBoot").append(String.valueOf(this.jdField_a_of_type_Boolean)).append("showWebViewTime=").append(l1).append("|").append("initWebViewTime=").append(this.jdField_c_of_type_Long).append("|").append("webViewLoadTime=").append(l2).append("|").append("initUiTime=").append(this.jdField_b_of_type_Long).append("|").append("loadUrlTime=").append(this.h).append("|").append("parsePageTime=").append(this.j).append("|").append("inflateLatyoutTime=").append(this.k).append("|").append("enterQQGamePubTime=").append(this.m).append("|").append("}");
        QLog.d("GameWebPage", 1, new Object[] { localObject });
      }
      Object localObject = QQGameHelper.a("1");
      ((WadlReportBuilder)localObject).d("76918").c("206612").a(29, String.valueOf(this.jdField_a_of_type_Boolean)).a(30, String.valueOf(l1)).a(31, String.valueOf(this.jdField_c_of_type_Long)).a(32, String.valueOf(l2)).a(33, String.valueOf(this.jdField_b_of_type_Long)).a(34, String.valueOf(this.j)).a(35, String.valueOf(this.k)).a(36, String.valueOf(this.m)).a(37, String.valueOf(this.n));
      ((WadlReportBuilder)localObject).a();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.8(this, l2), 2000L);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$MessageQGameReceiver = new QQGameFeedWebFragment.MessageQGameReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    localIntentFilter.addAction("action_qgame_jaspi_webloaded");
    localIntentFilter.addAction("action_qgame_h5_video_pause");
    localIntentFilter.addAction("action_qgame_h5_video_play");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$MessageQGameReceiver, localIntentFilter);
  }
  
  private void l()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = a();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter != null) && (this.jdField_d_of_type_Int > 0))
    {
      localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      localMessage.arg2 = -1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 3))
    {
      localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = -1;
      localMessage.arg2 = -1;
      localMessage.obj = a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public long a()
  {
    long l1 = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = new QQGamePubWebView(getActivity());
    }
    GameVideoManager.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder = new QQGameFeedWebFragment.7(this, getActivity(), getActivity(), CmGameUtil.a(), this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder).a(null, CmGameUtil.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setViewVisibleListener(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setDrawingCacheEnabled(true);
    return SystemClock.elapsedRealtime() - l1;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559275, null, false);
    ((ImageView)localView.findViewById(2131366332)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new QQGameFeedWebFragment.11(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new QQGameFeedWebFragment.12(this));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (paramInt < this.jdField_b_of_type_JavaUtilList.size()))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 102;
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      if (paramInt >= this.jdField_b_of_type_JavaUtilList.size()) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.13(this), 400L);
      }
    }
    else {
      return;
    }
    b(paramInt);
    Object localObject = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    a(CmGameUtil.a(), ((QQGameMsgInfo)localObject).paMsgid);
    HashMap localHashMap = new HashMap();
    GameCenterUtils.a(localHashMap, ((QQGameMsgInfo)localObject).paMsgid);
    localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)localObject).paMsgid);
    localHashMap.put(Integer.valueOf(3), paramInt + "");
    localHashMap.put(Integer.valueOf(4), "8");
    localHashMap.put(Integer.valueOf(24), "1");
    GameCenterUtils.a(CmGameUtil.a(), "769", "205017", ((QQGameMsgInfo)localObject).gameAppId, "76901", "1", "160", localHashMap);
    ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, ((QQGameMsgInfo)localObject).paMsgid, "");
    try
    {
      QQGameHelper.a(117, (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt), paramInt);
      this.jdField_d_of_type_Int += 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).arg2 = -1;
      ((Message)localObject).obj = "";
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < AIOUtils.a(a(), BaseApplicationImpl.getApplication().getResources())) {
      if (QQGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView)) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.a();
      }
    }
    while (!QQGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView != null)
      {
        WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("action", Integer.valueOf(paramInt1));
          if (paramInt1 == 4) {
            if (!TextUtils.isEmpty(paramString)) {
              localHashMap.put("perfData", paramString);
            }
          }
          for (;;)
          {
            localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.getUrl(), 8589934621L, localHashMap);
            return;
            if (paramInt2 != -1) {
              localHashMap.put("index", Integer.valueOf(paramInt2));
            }
            if (paramInt3 != -1) {
              localHashMap.put("height", Integer.valueOf(paramInt3));
            }
            if (!TextUtils.isEmpty(paramString)) {
              localHashMap.put("gameData", paramString);
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131377159));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setGamePubType("1");
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
    try
    {
      paramView = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299166));
      int i1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication().getApplicationContext());
      paramView.setMargins(0, i1, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setLayoutParams(paramView);
      QLog.d("GameWebPage", 4, "statusBarHeight = " + i1);
      paramView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.findViewById(2131369878);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130848680), getResources().getDrawable(2130848513));
      paramView.setImageResource(2130851151);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setBackgroundResource(2130846605);
      this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695230);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setOnItemSelectListener(new QQGameFeedWebFragment.10(this));
      a();
      return;
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        QLog.d("GameWebPage", 4, "set statusBarHeight faile:" + paramView.getMessage());
      }
    }
  }
  
  public void a(String arg1, EIPCResult paramEIPCResult)
  {
    int i1 = 0;
    label320:
    label322:
    label623:
    do
    {
      int i2;
      for (;;)
      {
        try
        {
          if (!"task_get_qgame_msg".equals(???)) {
            break label644;
          }
          this.n = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
          if (paramEIPCResult.code == 0)
          {
            ??? = paramEIPCResult.data;
            if (??? != null) {
              this.jdField_b_of_type_JavaUtilList = ((List)???.getSerializable("key_get_msg"));
            }
          }
          if (this.jdField_b_of_type_JavaUtilList == null) {
            this.jdField_b_of_type_JavaUtilList = new ArrayList();
          }
          i2 = this.jdField_b_of_type_JavaUtilList.size();
          if (i2 <= 0) {
            break label623;
          }
          this.jdField_e_of_type_Int = 0;
          if (this.jdField_a_of_type_Int > 0)
          {
            this.jdField_b_of_type_Int = 1;
            this.jdField_a_of_type_Int -= 1;
            this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
            synchronized (jdField_a_of_type_ArrayOfByte)
            {
              paramEIPCResult = this.jdField_b_of_type_JavaUtilList.iterator();
              if (!paramEIPCResult.hasNext()) {
                break label322;
              }
              QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramEIPCResult.next();
              IHeaderView localIHeaderView = QQGamePubHeaderFactory.a(localQQGameMsgInfo, getActivity());
              this.jdField_a_of_type_JavaUtilList.add(localIHeaderView);
              if (TextUtils.isEmpty(localQQGameMsgInfo.arkAppName)) {
                continue;
              }
              ArkPubicEventWrap.a().a(localQQGameMsgInfo.arkAppName);
              this.jdField_c_of_type_JavaUtilList.add(localQQGameMsgInfo.arkAppName);
            }
          }
          ??? = a(CmGameUtil.a());
        }
        catch (Throwable ???)
        {
          QLog.d("GameWebPage", 1, "handleIpcResult fail:" + ???.getMessage());
          ???.printStackTrace();
          return;
        }
        for (;;)
        {
          if (i1 >= i2) {
            break label320;
          }
          paramEIPCResult = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((paramEIPCResult.paMsgid != null) && (paramEIPCResult.paMsgid.equals(???)))
          {
            this.jdField_e_of_type_Int = i1;
            break;
          }
          i1 += 1;
        }
        continue;
        if ((isAdded()) && (getActivity() != null) && (!getActivity().isFinishing())) {
          this.jdField_a_of_type_JavaUtilList.add(new MoreMsgHeaderView(getActivity()));
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
        d(this.jdField_e_of_type_Int);
        if (this.jdField_e_of_type_Int == 0)
        {
          ??? = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(this.jdField_e_of_type_Int);
          paramEIPCResult = new HashMap();
          paramEIPCResult.put(Integer.valueOf(2), ???.paMsgid);
          paramEIPCResult.put(Integer.valueOf(3), this.jdField_e_of_type_Int + "");
          paramEIPCResult.put(Integer.valueOf(4), "8");
          paramEIPCResult.put(Integer.valueOf(24), "1");
          GameCenterUtils.a(paramEIPCResult, ???.paMsgid);
          GameCenterUtils.a(CmGameUtil.a(), "769", "205017", ???.gameAppId, "76901", "1", "160", paramEIPCResult);
          ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, ???.paMsgid, "");
        }
        try
        {
          QQGameHelper.a(117, ???, this.jdField_e_of_type_Int);
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_e_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
          {
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView = ((IHeaderView)this.jdField_a_of_type_JavaUtilList.get(this.jdField_e_of_type_Int));
            return;
          }
        }
        catch (Throwable ???)
        {
          for (;;)
          {
            ???.printStackTrace();
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$HeadPageAdapter);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    } while (!"task_qgame_task_all_complete".equals(???));
    label644:
    i1 = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.17(this, i1));
  }
  
  public void b()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131695230));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    a(this.jdField_a_of_type_Long);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QQGameConstant.jdField_a_of_type_Boolean = true;
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(24), "1");
    paramBundle.put(Integer.valueOf(4), "8");
    GameCenterUtils.a(CmGameUtil.a(), "769", "205838", "", "76902", "1", "160", paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    c();
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559288, paramViewGroup, false);
    if (!SimpleUIUtil.a())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    f();
    b(this.jdField_b_of_type_AndroidViewView);
    d();
    e();
    k();
    GameVideoManager.a().a(2);
    this.jdField_b_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    this.jdField_c_of_type_Long = a();
    d(this.jdField_b_of_type_AndroidViewView);
    a(this.jdField_b_of_type_AndroidViewView);
    c(this.jdField_b_of_type_AndroidViewView);
    g();
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1493	com/tencent/mobileqq/fragment/PublicBaseFragment:onDestroy	()V
    //   4: getstatic 71	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ArrayOfByte	[B
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +94 -> 110
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: aload_0
    //   23: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: invokeinterface 234 1 0
    //   31: if_icmpge +70 -> 101
    //   34: aload_0
    //   35: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   38: iload_1
    //   39: invokeinterface 238 2 0
    //   44: instanceof 750
    //   47: ifeq +226 -> 273
    //   50: aload_0
    //   51: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   54: iload_1
    //   55: invokeinterface 238 2 0
    //   60: checkcast 750	com/tencent/mobileqq/gamecenter/view/GameArkView
    //   63: invokevirtual 1494	com/tencent/mobileqq/gamecenter/view/GameArkView:d	()V
    //   66: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +204 -> 273
    //   72: ldc 146
    //   74: iconst_2
    //   75: new 148	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 1496
    //   85: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: goto +175 -> 273
    //   101: aload_0
    //   102: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: invokeinterface 1499 1 0
    //   110: aload_2
    //   111: monitorexit
    //   112: aload_0
    //   113: getfield 253	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView	Lcom/tencent/mobileqq/gamecenter/web/view/QQGamePubWebView;
    //   116: ifnull +10 -> 126
    //   119: aload_0
    //   120: getfield 253	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView	Lcom/tencent/mobileqq/gamecenter/web/view/QQGamePubWebView;
    //   123: invokevirtual 1500	com/tencent/mobileqq/gamecenter/web/view/QQGamePubWebView:b	()V
    //   126: aload_0
    //   127: getfield 246	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder	Lcom/tencent/mobileqq/gamecenter/web/QQGameWebViewBuilder;
    //   130: ifnull +10 -> 140
    //   133: aload_0
    //   134: getfield 246	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder	Lcom/tencent/mobileqq/gamecenter/web/QQGameWebViewBuilder;
    //   137: invokevirtual 1501	com/tencent/mobileqq/gamecenter/web/QQGameWebViewBuilder:onDestroy	()V
    //   140: aload_0
    //   141: getfield 131	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   144: ifnull +10 -> 154
    //   147: aload_0
    //   148: getfield 131	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   151: invokevirtual 1502	com/tencent/mobileqq/gamecenter/web/view/GameContentView:c	()V
    //   154: invokestatic 755	com/tencent/mobileqq/gamecenter/media/GameVideoManager:a	()Lcom/tencent/mobileqq/gamecenter/media/GameVideoManager;
    //   157: invokevirtual 1503	com/tencent/mobileqq/gamecenter/media/GameVideoManager:f	()V
    //   160: aload_0
    //   161: getfield 107	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   164: ifnull +11 -> 175
    //   167: aload_0
    //   168: getfield 107	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   171: aconst_null
    //   172: invokevirtual 1506	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   175: aload_0
    //   176: getfield 131	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   179: ifnull +10 -> 189
    //   182: aload_0
    //   183: getfield 131	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   186: invokevirtual 1507	com/tencent/mobileqq/gamecenter/web/view/GameContentView:a	()V
    //   189: invokestatic 1513	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   192: ldc_w 1515
    //   195: ldc_w 1517
    //   198: aconst_null
    //   199: aconst_null
    //   200: invokevirtual 1521	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   203: invokestatic 1354	com/tencent/mobileqq/activity/qwallet/utils/ArkPubicEventWrap:a	()Lcom/tencent/mobileqq/activity/qwallet/utils/ArkPubicEventWrap;
    //   206: iconst_0
    //   207: anewarray 298	java/lang/String
    //   210: invokevirtual 1524	com/tencent/mobileqq/activity/qwallet/utils/ArkPubicEventWrap:a	([Ljava/lang/String;)V
    //   213: invokestatic 856	com/tencent/mobileqq/gamecenter/web/QQGameIpcHandle:a	()Lcom/tencent/mobileqq/gamecenter/web/QQGameIpcHandle;
    //   216: invokevirtual 1525	com/tencent/mobileqq/gamecenter/web/QQGameIpcHandle:b	()V
    //   219: invokestatic 897	cooperation/wadl/ipc/WadlProxyServiceUtil:a	()Lcooperation/wadl/ipc/WadlProxyServiceWrap;
    //   222: aload_0
    //   223: invokevirtual 1527	cooperation/wadl/ipc/WadlProxyServiceWrap:b	(Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;)V
    //   226: return
    //   227: astore_3
    //   228: ldc 146
    //   230: iconst_1
    //   231: new 148	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 1529
    //   241: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_3
    //   245: invokevirtual 1530	java/lang/Throwable:toString	()Ljava/lang/String;
    //   248: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 1532	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -147 -> 110
    //   260: astore_3
    //   261: aload_2
    //   262: monitorexit
    //   263: aload_3
    //   264: athrow
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 325	java/lang/Throwable:printStackTrace	()V
    //   270: goto -95 -> 175
    //   273: iload_1
    //   274: iconst_1
    //   275: iadd
    //   276: istore_1
    //   277: goto -256 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	QQGameFeedWebFragment
    //   20	257	1	i1	int
    //   7	255	2	arrayOfByte	byte[]
    //   265	2	2	localThrowable1	Throwable
    //   14	2	3	localList	List
    //   227	18	3	localThrowable2	Throwable
    //   260	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	98	227	java/lang/Throwable
    //   101	110	227	java/lang/Throwable
    //   10	15	260	finally
    //   21	98	260	finally
    //   101	110	260	finally
    //   110	112	260	finally
    //   228	257	260	finally
    //   261	263	260	finally
    //   167	175	265	java/lang/Throwable
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$MessageQGameReceiver != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$MessageQGameReceiver);
    }
    if (this.jdField_c_of_type_JavaUtilList != null) {
      ArkPubicEventWrap.a().b(this.jdField_c_of_type_JavaUtilList);
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder.onPause();
    }
    if (QQGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.b();
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameWebPage", 1, "---->onQueryCallback isGetGameEnter=" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    try
    {
      long l1 = QQGameHelper.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "---> get lastGameAppID=" + l1);
      }
      this.jdField_c_of_type_Boolean = true;
      QWalletCommonServlet.a(new GmpEnterInfoReq(l1, 1, 0), this);
      return;
    }
    catch (Throwable paramArrayList)
    {
      QLog.d("GameWebPage", 1, "---->onQueryCallback getLastGameAppID fail:" + paramArrayList.getMessage());
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    GmpEnterInfoRsp localGmpEnterInfoRsp;
    StringBuilder localStringBuilder;
    if (paramInt == 31)
    {
      if ((!paramBoolean) || (paramBundle == null)) {
        break label127;
      }
      localGmpEnterInfoRsp = (GmpEnterInfoRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("GmpEnterInfoRsp|");
        if (localGmpEnterInfoRsp == null) {
          break label89;
        }
      }
    }
    for (paramBundle = Integer.valueOf(localGmpEnterInfoRsp.ret_code);; paramBundle = "")
    {
      QLog.d("GameWebPage", 2, paramBundle);
      if (localGmpEnterInfoRsp != null) {}
      try
      {
        a(localGmpEnterInfoRsp, paramBoolean);
        return;
      }
      catch (Throwable paramBundle)
      {
        label89:
        QLog.d("GameWebPage", 1, "-->onReceive showGiftIcon fail:" + paramBundle.getMessage());
        return;
      }
    }
    label127:
    a(null, false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameWebViewBuilder.onResume();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.a();
    }
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilList != null) {
          continue;
        }
        i1 = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() == i1)) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i1 - 1);
        }
      }
      catch (Throwable localThrowable)
      {
        int i1;
        localThrowable.printStackTrace();
        continue;
      }
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
      return;
      i1 = this.jdField_b_of_type_JavaUtilList.size();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult) {}
  
  public void refreshGameContentView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.15(this));
    }
  }
  
  public void shrinkGameContentView(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.postDelayed(new QQGameFeedWebFragment.16(this), paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */