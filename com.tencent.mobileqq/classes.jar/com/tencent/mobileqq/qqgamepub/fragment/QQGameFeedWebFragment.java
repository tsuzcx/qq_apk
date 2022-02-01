package com.tencent.mobileqq.qqgamepub.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
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
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIpcHandle;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIpcHandle.QGameIpcCallBack;
import com.tencent.mobileqq.qqgamepub.listener.IPageListener;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewBuilder;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView.HeadViewVisibleListener;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameFeedWebFragment
  extends QPublicBaseFragment
  implements WadlProxyServiceCallBackInterface, QQGameIpcHandle.QGameIpcCallBack, IPageListener, GameContentView.UiRefresh, QQGamePubWebView.HeadViewVisibleListener, BusinessObserver
{
  public static final byte[] a;
  public int a;
  public long a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new QQGameFeedWebFragment.13(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private QQGameFeedWebFragment.HeadPageAdapter jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter;
  private QQGameFeedWebFragment.MessageQGameReceiver jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$MessageQGameReceiver;
  private GameSessionView jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
  private IHeaderView jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
  public NavBarQQGamePub a;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
  private QQGameWebViewBuilder jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder;
  private GameContentView jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout;
  private QQGameIndicator2 jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2;
  private QQGamePubWebView jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView;
  private UnreadTipLayout jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout;
  public String a;
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
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  public long e;
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
    }
    catch (Throwable localThrowable)
    {
      float f1;
      label10:
      break label10;
    }
    f1 = UIUtils.a(paramContext);
    return paramFloat / f1 + 0.5F;
  }
  
  private int a()
  {
    int i2 = 0;
    int i1 = i2;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.getVisibility() == 0) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.a();
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("gameContentHeight=");
        localStringBuilder1.append(i1);
        QLog.d("GameWebPage", 1, localStringBuilder1.toString());
      }
      if ((isAdded()) && (a() != null) && (!a().isFinishing()))
      {
        float f1 = a(a(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight() + i1);
        return (int)f1;
      }
      return 417;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getWebPading faile:");
      localStringBuilder2.append(localThrowable.getMessage());
      QLog.d("GameWebPage", 1, localStringBuilder2.toString());
    }
    return 417;
  }
  
  private int a(String paramString)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList == null) || (localList.isEmpty())) {
      QLog.e("GameWebPage", 1, "handleAdReverseFeedBack, msgInfoList is null");
    }
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (paramString.equals(String.valueOf(((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(i1)).uniseq))) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private QBaseActivity a()
  {
    return getQBaseActivity();
  }
  
  private QQGameMsgInfo a()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem();
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0) && (i1 < this.jdField_b_of_type_JavaUtilList.size())) {
      return (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
    }
    return null;
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgPos_web");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  private String a(String paramString, List<QQGameMsgInfo> paramList, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (paramList.size() > 0))
    {
      if (paramString.indexOf("?") == -1) {}
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("?gameData=");
        localStringBuilder.append(URLEncoder.encode(a(paramList), "utf-8"));
        localStringBuilder.append("&index=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("&height=");
        localStringBuilder.append(a());
        localStringBuilder.append("&_bid=4235");
        return localStringBuilder.toString();
      }
      catch (Throwable paramList)
      {
        StringBuilder localStringBuilder;
        paramList.printStackTrace();
        return paramString;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&gameData=");
      localStringBuilder.append(URLEncoder.encode(a(paramList), "utf-8"));
      localStringBuilder.append("&index=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("&height=");
      localStringBuilder.append(a());
      localStringBuilder.append("&_bid=4235");
      paramList = localStringBuilder.toString();
      return paramList;
    }
    if (paramString.indexOf("?") == -1)
    {
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("?height=");
      paramList.append(a());
      paramList.append("&_bid=4235");
      return paramList.toString();
    }
    paramList = new StringBuilder();
    paramList.append(paramString);
    paramList.append("&height=");
    paramList.append(a());
    paramList.append("&_bid=4235");
    return paramList.toString();
  }
  
  private String a(List<QQGameMsgInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        JSONArray localJSONArray = new JSONArray();
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
        }
        paramList = localJSONArray.toString();
        return paramList;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgPos_web");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localStringBuilder.toString();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).apply();
  }
  
  private void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    if ((paramGmpEnterInfoRsp != null) && (paramGmpEnterInfoRsp.ret_code == 0) && (paramGmpEnterInfoRsp.state == 1) && (paramBoolean))
    {
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.17(this, paramGmpEnterInfoRsp));
      return;
    }
    paramGmpEnterInfoRsp = GamePubAccountHelper.a();
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramGmpEnterInfoRsp.bubble_id))
    {
      localHashMap.put(Integer.valueOf(2), paramGmpEnterInfoRsp.bubble_id);
      localHashMap.put(Integer.valueOf(3), "1");
    }
    else
    {
      localHashMap.put(Integer.valueOf(3), "2");
    }
    localHashMap.put(Integer.valueOf(4), "8");
    localHashMap.put(Integer.valueOf(24), "1");
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "770", "207021", "", "77002", "1", "160", localHashMap);
    ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.18(this, paramGmpEnterInfoRsp));
    if (QLog.isColorLevel()) {
      QLog.d("GameWebPage", 1, "rec game enter is null");
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("GameWebPage", 1, "handleAdReverseFeedBack, arkViewId is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("h5,call handleAdReverseFeedBack arkViewId:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("GameWebPage", 1, ((StringBuilder)localObject).toString());
    a(false, 0);
    int i3 = a(paramString);
    if ((i3 > -1) && (i3 < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramString = (IHeaderView)this.jdField_a_of_type_JavaUtilList.get(i3);
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
      if (localObject != null)
      {
        int i2 = ((QQGamePubViewpager)localObject).getCurrentItem();
        int i1 = i2;
        if (i2 == this.jdField_b_of_type_JavaUtilList.size() - 1) {
          i1 = i2 - 1;
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        this.jdField_b_of_type_JavaUtilList.remove(i3);
        d(i1);
        a(2, i1, -1, GamePubAccountHelper.a(this.jdField_b_of_type_JavaUtilList).toString());
        a(1, i1, -1, "");
      }
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("frienduin", paramString);
    localBundle.putInt("istroop", paramInt);
    localBundle.putLong("uniseq", paramLong);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "deleteMessage", localBundle);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteMsg arkViewId:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("GameWebPage", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = null;
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (QQGameMsgInfo)localIterator.next();
        } while (!paramString.equals(String.valueOf(((QQGameMsgInfo)localObject1).uniseq)));
        if (localObject1 != null)
        {
          if (!paramBoolean)
          {
            a(((QQGameMsgInfo)localObject1).frienduin, ((QQGameMsgInfo)localObject1).istroop, ((QQGameMsgInfo)localObject1).uniseq);
            QQToast.a(getQBaseActivity(), 2131700862, 1).a();
          }
          a(paramString);
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setVisibility(0);
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setUnreadNum(paramInt);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      int i1 = this.jdField_b_of_type_Int;
      if (paramInt >= i1)
      {
        int i2 = this.jdField_c_of_type_Int;
        if ((i1 <= i2) && (paramInt <= i2))
        {
          this.jdField_b_of_type_Int = (i1 + 1);
          this.jdField_a_of_type_Int = (i2 - this.jdField_b_of_type_Int + 1);
          paramInt = this.jdField_a_of_type_Int;
          if ((paramInt > 0) && (paramInt <= 3))
          {
            a(true, paramInt);
            return;
          }
          a(false, 0);
        }
      }
    }
    else
    {
      a(false, 0);
    }
  }
  
  private void b(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    paramLong = (SystemClock.elapsedRealtime() - paramLong) / 1000L;
    if (paramLong > 0L)
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      localHashMap.put(Integer.valueOf(17), localStringBuilder.toString());
      localHashMap.put(Integer.valueOf(24), "1");
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "206471", "", "76916", "1", "160", localHashMap);
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131374420));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView = ((QQGamePubWebView)paramView.findViewById(2131374423));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView = ((GameContentView)paramView.findViewById(2131369795));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369845));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout.findViewById(2131366759));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2 = ((QQGameIndicator2)this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout.findViewById(2131372285));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379961));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369878));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368701));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout = ((UnreadTipLayout)this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameHeadLayout.findViewById(2131369750));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter = new QQGameFeedWebFragment.HeadPageAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setViewPager(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.a();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setPageListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376695));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(GamePubAccountConstant.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new QQGameFeedWebFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView = (ImageView)paramView.findViewById(2131368046);
    paramView.setVisibility(0);
    paramView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramView.setImageResource(2130846481);
    h();
  }
  
  private void c()
  {
    Intent localIntent = a().getIntent();
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
      if (localIntent.hasExtra("arkResPath")) {
        this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("arkResPath");
      }
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject1 = jdField_a_of_type_ArrayOfByte;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (i1 == paramInt)
          {
            this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView = ((IHeaderView)this.jdField_a_of_type_JavaUtilList.get(i1));
            if ((this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView instanceof GameArkView))
            {
              GameVideoManager.a().a((GameArkView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView);
              ((GameArkView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView).e();
            }
            else
            {
              GameVideoManager.a().a(null);
            }
          }
          else
          {
            IHeaderView localIHeaderView = (IHeaderView)this.jdField_a_of_type_JavaUtilList.get(i1);
            if (localIHeaderView != null) {
              localIHeaderView.b();
            }
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
          if (localObject1 != null) {
            ((IHeaderView)localObject1).a();
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i1 += 1;
      }
    }
  }
  
  private void c(View paramView)
  {
    Object localObject = new DisplayMetrics();
    a().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).heightPixels;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370350));
    int i2 = UIUtils.a(418.0F, a().getResources());
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = UIUtils.a(i1 - i2, a().getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (IPreloadServiceProxy)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, "multi");
    if (TextUtils.isEmpty(PreloadStaticApi.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      i();
      ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new QQGameFeedWebFragment.4(this));
      return;
    }
    ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new QQGameFeedWebFragment.5(this, paramView));
  }
  
  private void c(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter;
      int i1;
      if ((??? != null) && (((QQGameFeedWebFragment.HeadPageAdapter)???).getCount() == 1)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (this.jdField_b_of_type_JavaUtilList == null) {
        return;
      }
      this.jdField_b_of_type_Int += paramArrayList.size();
      this.jdField_c_of_type_Int += paramArrayList.size();
      int i2 = 0;
      while (i2 < paramArrayList.size())
      {
        this.jdField_b_of_type_JavaUtilList.add(0, paramArrayList.get(i2));
        synchronized (jdField_a_of_type_ArrayOfByte)
        {
          Object localObject2 = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)paramArrayList.get(i2), a());
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
          int i3;
          if (i1 != 0) {
            i3 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem();
          } else {
            i3 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem() + 1;
          }
          d(-1);
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(i3);
          localObject2 = new HashMap();
          ((Map)localObject2).put(Integer.valueOf(2), ((QQGameMsgInfo)paramArrayList.get(i2)).paMsgid);
          ((Map)localObject2).put(Integer.valueOf(4), "8");
          ((Map)localObject2).put(Integer.valueOf(24), "1");
          if (TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(i2)).gameAppId)) {
            ??? = "";
          } else {
            ??? = ((QQGameMsgInfo)paramArrayList.get(i2)).gameAppId;
          }
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205030", (String)???, "76901", "1", "160", (Map)localObject2);
          i2 += 1;
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
    }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter;
    if (localObject != null)
    {
      ((QQGameFeedWebFragment.HeadPageAdapter)localObject).notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.a();
      if (paramInt > 0) {
        this.jdField_d_of_type_Int -= 1;
      }
      if ((a() != null) && (!a().isFinishing()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
        if ((localObject != null) && (paramInt > 0)) {
          ((QQGamePubViewpager)localObject).setCurrentItem(paramInt);
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371800));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371799));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new QQGameFeedWebFragment.8(this));
  }
  
  private void e()
  {
    GameContentView localGameContentView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
    if (localGameContentView != null)
    {
      localGameContentView.setUiRefresh(this);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.b();
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = false;
    WadlProxyServiceUtil.a().a(this);
  }
  
  private void g()
  {
    NavBarQQGamePub localNavBarQQGamePub = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub;
    if (localNavBarQQGamePub != null)
    {
      localNavBarQQGamePub.a();
      WadlProxyServiceUtil.a().a();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setUnreadNum(this.jdField_a_of_type_Int - 1);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setOnClickListener(new QQGameFeedWebFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.post(new QQGameFeedWebFragment.3(this));
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "207552", "", "76925", "1", "160", localHashMap);
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    TextView localTextView = new TextView(a());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = UIUtils.a(7.0F, a().getResources());
    localTextView.setText(HardCodeUtil.a(2131695209));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(a());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = a().getResources().getDrawable(2130847408);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a().getResources().getDrawable(2130847408);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(UIUtils.a(15.0F, a().getResources()), UIUtils.a(15.0F, a().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private void j()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      long l1 = this.g;
      this.h = (l1 - this.f);
      long l2 = this.i;
      this.j = (l2 - l1);
      l1 = l2 - this.jdField_a_of_type_Long + this.m;
      l2 = this.h + this.j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("GamePub H5 pref data=");
        ((StringBuffer)localObject).append("{");
        ((StringBuffer)localObject).append("isColdBoot");
        ((StringBuffer)localObject).append(String.valueOf(this.jdField_a_of_type_Boolean));
        ((StringBuffer)localObject).append("showWebViewTime=");
        ((StringBuffer)localObject).append(l1);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("initWebViewTime=");
        ((StringBuffer)localObject).append(this.jdField_c_of_type_Long);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("webViewLoadTime=");
        ((StringBuffer)localObject).append(l2);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("initUiTime=");
        ((StringBuffer)localObject).append(this.jdField_b_of_type_Long);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("loadUrlTime=");
        ((StringBuffer)localObject).append(this.h);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("parsePageTime=");
        ((StringBuffer)localObject).append(this.j);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("inflateLatyoutTime=");
        ((StringBuffer)localObject).append(this.k);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("enterQQGamePubTime=");
        ((StringBuffer)localObject).append(this.m);
        ((StringBuffer)localObject).append("|");
        ((StringBuffer)localObject).append("}");
        QLog.d("GameWebPage", 1, new Object[] { localObject });
      }
      Object localObject = GamePubAccountHelper.a("1");
      ((WadlReportBuilder)localObject).d("76918").c("206612").a(29, String.valueOf(this.jdField_a_of_type_Boolean)).a(30, String.valueOf(l1)).a(31, String.valueOf(this.jdField_c_of_type_Long)).a(32, String.valueOf(l2)).a(33, String.valueOf(this.jdField_b_of_type_Long)).a(34, String.valueOf(this.j)).a(35, String.valueOf(this.k)).a(36, String.valueOf(this.m)).a(37, String.valueOf(this.n));
      ((WadlReportBuilder)localObject).a();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.7(this, l2), 2000L);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$MessageQGameReceiver = new QQGameFeedWebFragment.MessageQGameReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    localIntentFilter.addAction("action_qgame_jaspi_webloaded");
    localIntentFilter.addAction("action_qgame_h5_video_pause");
    localIntentFilter.addAction("action_qgame_h5_video_play");
    localIntentFilter.addAction("action_qgame_delete_ad");
    MobileQQ.sMobileQQ.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$MessageQGameReceiver, localIntentFilter);
  }
  
  private void l()
  {
    Object localObject = Message.obtain();
    ((Message)localObject).what = 3;
    ((Message)localObject).arg1 = -1;
    ((Message)localObject).arg2 = a();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    if ((this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager != null) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter != null) && (this.jdField_d_of_type_Int > 0))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem();
      ((Message)localObject).arg2 = -1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 3))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = -1;
      ((Message)localObject).arg2 = -1;
      ((Message)localObject).obj = a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  public long a()
  {
    long l1 = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView == null) {
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView = new QQGamePubWebView(a());
    }
    GameVideoManager.a().a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder = new QQGameFeedWebFragment.6(this, a(), a(), ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder).a(null, ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), null);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView = ((QQGamePubWebView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.setViewVisibleListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.setDrawingCacheEnabled(true);
    return SystemClock.elapsedRealtime() - l1;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(a()).inflate(2131559147, null, false);
    ((ImageView)localView.findViewById(2131366220)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new QQGameFeedWebFragment.10(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new QQGameFeedWebFragment.11(this));
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 102;
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (paramInt >= this.jdField_b_of_type_JavaUtilList.size())
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.12(this), 400L);
        return;
      }
      b(paramInt);
      localObject = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), ((QQGameMsgInfo)localObject).paMsgid);
      HashMap localHashMap = new HashMap();
      GameCenterUtils.a(localHashMap, ((QQGameMsgInfo)localObject).paMsgid);
      localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)localObject).paMsgid);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localHashMap.put(Integer.valueOf(3), localStringBuilder.toString());
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205017", ((QQGameMsgInfo)localObject).gameAppId, "76901", "1", "160", localHashMap);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, ((QQGameMsgInfo)localObject).paMsgid, "");
      try
      {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(117, (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt), paramInt);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.jdField_d_of_type_Int += 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = paramInt;
      localMessage.arg2 = -1;
      localMessage.obj = "";
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    IHeaderView localIHeaderView;
    if (paramInt1 < UIUtils.a(a(), MobileQQ.sMobileQQ.getResources()))
    {
      localIHeaderView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
      if (localIHeaderView != null) {
        localIHeaderView.a();
      }
    }
    else
    {
      localIHeaderView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
      if (localIHeaderView != null) {
        localIHeaderView.b();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView != null)
      {
        WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("action", Integer.valueOf(paramInt1));
          if (paramInt1 == 4)
          {
            if (!TextUtils.isEmpty(paramString)) {
              localHashMap.put("perfData", paramString);
            }
          }
          else
          {
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
          localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.getUrl(), 8589934621L, localHashMap);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(long paramLong)
  {
    GameSessionView localGameSessionView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
    if (localGameSessionView != null) {
      localGameSessionView.postDelayed(new QQGameFeedWebFragment.15(this), paramLong);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131376636));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setGamePubType("1");
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.a();
    try
    {
      paramView = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299168));
      int i1 = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext());
      paramView.setMargins(0, i1, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setLayoutParams(paramView);
      paramView = new StringBuilder();
      paramView.append("statusBarHeight = ");
      paramView.append(i1);
      QLog.d("GameWebPage", 4, paramView.toString());
    }
    catch (Throwable paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set statusBarHeight faile:");
      localStringBuilder.append(paramView.getMessage());
      QLog.d("GameWebPage", 4, localStringBuilder.toString());
    }
    paramView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.findViewById(2131369563);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130848559), getResources().getDrawable(2130848392));
    paramView.setImageResource(2130851067);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setBackgroundResource(2130846485);
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695226);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setOnItemSelectListener(new QQGameFeedWebFragment.9(this));
    a();
  }
  
  public void a(WadlResult paramWadlResult) {}
  
  public void a(String arg1, EIPCResult paramEIPCResult)
  {
    for (;;)
    {
      int i1;
      try
      {
        if ("task_get_qgame_msg".equals(???))
        {
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
          int i2 = this.jdField_b_of_type_JavaUtilList.size();
          if (i2 > 0)
          {
            i1 = 0;
            this.e = 0;
            if (this.jdField_a_of_type_Int > 0)
            {
              this.jdField_b_of_type_Int = 1;
              this.jdField_a_of_type_Int -= 1;
              this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
            }
            else
            {
              ??? = a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
              if (i1 < i2)
              {
                paramEIPCResult = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
                if ((paramEIPCResult.paMsgid == null) || (!paramEIPCResult.paMsgid.equals(???))) {
                  break label761;
                }
                this.e = i1;
              }
            }
            synchronized (jdField_a_of_type_ArrayOfByte)
            {
              paramEIPCResult = this.jdField_b_of_type_JavaUtilList.iterator();
              Object localObject;
              if (paramEIPCResult.hasNext())
              {
                localObject = (QQGameMsgInfo)paramEIPCResult.next();
                IHeaderView localIHeaderView = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)localObject, a());
                this.jdField_a_of_type_JavaUtilList.add(localIHeaderView);
                if (TextUtils.isEmpty(((QQGameMsgInfo)localObject).arkAppName)) {
                  continue;
                }
                ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(((QQGameMsgInfo)localObject).arkAppName);
                this.jdField_c_of_type_JavaUtilList.add(((QQGameMsgInfo)localObject).arkAppName);
                continue;
              }
              if ((isAdded()) && (a() != null) && (!a().isFinishing())) {
                this.jdField_a_of_type_JavaUtilList.add(new MoreMsgHeaderView(a()));
              }
              this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter);
              this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.a();
              d(this.e);
              if (this.e == 0)
              {
                ??? = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(this.e);
                paramEIPCResult = new HashMap();
                paramEIPCResult.put(Integer.valueOf(2), ???.paMsgid);
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.e);
                ((StringBuilder)localObject).append("");
                paramEIPCResult.put(Integer.valueOf(3), ((StringBuilder)localObject).toString());
                paramEIPCResult.put(Integer.valueOf(4), "8");
                paramEIPCResult.put(Integer.valueOf(24), "1");
                GameCenterUtils.a(paramEIPCResult, ???.paMsgid);
                GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205017", ???.gameAppId, "76901", "1", "160", paramEIPCResult);
                ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, ???.paMsgid, "");
                try
                {
                  ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(117, ???, this.e);
                }
                catch (Throwable ???)
                {
                  ???.printStackTrace();
                }
              }
              if ((this.jdField_a_of_type_JavaUtilList == null) || (this.e >= this.jdField_a_of_type_JavaUtilList.size())) {
                break label760;
              }
              this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView = ((IHeaderView)this.jdField_a_of_type_JavaUtilList.get(this.e));
              if (!(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView instanceof GameArkView)) {
                break label760;
              }
              ((GameArkView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView).e();
              return;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$HeadPageAdapter);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          return;
        }
        if ("task_qgame_task_all_complete".equals(???))
        {
          i1 = this.e;
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.post(new QQGameFeedWebFragment.16(this, i1));
          return;
        }
      }
      catch (Throwable ???)
      {
        paramEIPCResult = new StringBuilder();
        paramEIPCResult.append("handleIpcResult fail:");
        paramEIPCResult.append(???.getMessage());
        QLog.d("GameWebPage", 1, paramEIPCResult.toString());
        ???.printStackTrace();
      }
      label760:
      return;
      label761:
      i1 += 1;
    }
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("---->onQueryCallback isGetGameEnter=");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("GameWebPage", 1, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    try
    {
      long l1 = GamePubAccountHelper.a(paramArrayList);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("---> get lastGameAppID=");
        paramArrayList.append(l1);
        QLog.d("GameWebPage", 1, paramArrayList.toString());
      }
      this.jdField_c_of_type_Boolean = true;
      paramArrayList = new GmpEnterInfoReq(l1, 1, 0);
      ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(paramArrayList, this);
      return;
    }
    catch (Throwable paramArrayList)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("---->onQueryCallback getLastGameAppID fail:");
      localStringBuilder.append(paramArrayList.getMessage());
      QLog.d("GameWebPage", 1, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    GameContentView localGameContentView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
    if (localGameContentView != null) {
      localGameContentView.post(new QQGameFeedWebFragment.14(this));
    }
  }
  
  public void b(ArrayList<WadlResult> paramArrayList) {}
  
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
    b(this.jdField_a_of_type_Long);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GamePubAccountConstant.jdField_a_of_type_Boolean = true;
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(24), "1");
    paramBundle.put(Integer.valueOf(4), "8");
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205838", "", "76902", "1", "160", paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    c();
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559143, paramViewGroup, false);
    if (!SimpleUIUtil.a())
    {
      a().setSystemBarComp(null);
      a().setImmersiveStatus(0);
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
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i1;
    GameContentView localGameContentView;
    label298:
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (localObject2 != null)
      {
        i1 = 0;
        try
        {
          if (i1 < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (!(this.jdField_a_of_type_JavaUtilList.get(i1) instanceof GameArkView)) {
              break label298;
            }
            ((GameArkView)this.jdField_a_of_type_JavaUtilList.get(i1)).d();
            if (!QLog.isColorLevel()) {
              break label298;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("header destroy i=");
            ((StringBuilder)localObject2).append(i1);
            QLog.d("GameWebPage", 2, ((StringBuilder)localObject2).toString());
            break label298;
          }
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        catch (Throwable localThrowable2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("header destroy error=");
          localStringBuilder.append(localThrowable2.toString());
          QLog.e("GameWebPage", 1, localStringBuilder.toString());
        }
      }
      else
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView;
        if (??? != null) {
          ((QQGamePubWebView)???).b();
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder;
        if (??? != null) {
          ((QQGameWebViewBuilder)???).onDestroy();
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
        if (??? != null) {
          ((GameContentView)???).c();
        }
        GameVideoManager.a().f();
        ??? = this.jdField_a_of_type_AndroidOsHandler;
        if (??? != null) {
          try
          {
            ((Handler)???).removeCallbacksAndMessages(null);
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
          }
        }
        localGameContentView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
        if (localGameContentView != null) {
          localGameContentView.a();
        }
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnDestory", null, null);
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(new String[0]);
        QQGameIpcHandle.a().b();
        WadlProxyServiceUtil.a().b(this);
        return;
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$MessageQGameReceiver != null) {
      MobileQQ.sMobileQQ.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$MessageQGameReceiver);
    }
    if (this.jdField_c_of_type_JavaUtilList != null) {
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.jdField_c_of_type_JavaUtilList);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder;
    if (localObject != null) {
      ((QQGameWebViewBuilder)localObject).onPause();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
    if (localObject != null) {
      ((IHeaderView)localObject).b();
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 31)
    {
      if ((paramBoolean) && (paramBundle != null))
      {
        Object localObject = (GmpEnterInfoRsp)paramBundle.getSerializable("rsp");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GmpEnterInfoRsp|");
          if (localObject != null) {
            paramBundle = Integer.valueOf(((GmpEnterInfoRsp)localObject).ret_code);
          } else {
            paramBundle = "";
          }
          localStringBuilder.append(paramBundle);
          QLog.d("GameWebPage", 2, localStringBuilder.toString());
        }
        if (localObject == null) {
          return;
        }
        try
        {
          a((GmpEnterInfoRsp)localObject, paramBoolean);
          return;
        }
        catch (Throwable paramBundle)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("-->onReceive showGiftIcon fail:");
          ((StringBuilder)localObject).append(paramBundle.getMessage());
          QLog.d("GameWebPage", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      a(null, false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebQQGameWebViewBuilder;
    if (localObject != null) {
      ((QQGameWebViewBuilder)localObject).onResume();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
    if (localObject != null) {
      ((IHeaderView)localObject).a();
    }
    try
    {
      int i1;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        i1 = 0;
      } else {
        i1 = this.jdField_b_of_type_JavaUtilList.size();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager != null) && (i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem() == i1)) {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(i1 - 1);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */