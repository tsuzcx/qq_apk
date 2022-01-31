package com.tencent.mobileqq.gamecenter.web;

import aact;
import aekt;
import aivz;
import akro;
import alpo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import anmp;
import asiy;
import asjc;
import asjd;
import asjl;
import asjv;
import askf;
import askg;
import askh;
import aski;
import askj;
import askk;
import askl;
import askm;
import askn;
import asko;
import askp;
import askq;
import asks;
import azib;
import beav;
import bkeu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameFeedWebFragment
  extends PublicBaseFragment
  implements asjv
{
  public long a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new askg(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asiy jdField_a_of_type_Asiy;
  private askp jdField_a_of_type_Askp;
  private askq jdField_a_of_type_Askq;
  private asks jdField_a_of_type_Asks;
  public GameSessionView a;
  private QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout;
  private QQGamePubWebView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView;
  public List<asjl> a;
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private List<QQGameMsgInfo> jdField_b_of_type_JavaUtilList;
  public long c;
  private ImageView c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  
  static
  {
    anmp.a(true);
    anmp.a();
  }
  
  public QQGameFeedWebFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private int a()
  {
    return 389;
  }
  
  private QQGameMsgInfo a()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
      return (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(m);
    }
    return null;
  }
  
  private String a(String paramString, List<QQGameMsgInfo> paramList, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (paramList.size() > 0))
    {
      if (paramString.indexOf("?") == -1) {}
      try
      {
        return paramString + "?gameData=" + URLEncoder.encode(a(paramList), "utf-8") + "&index=" + paramInt + "&height=" + a();
      }
      catch (Throwable paramList)
      {
        return paramString;
      }
      paramList = paramString + "&gameData=" + URLEncoder.encode(a(paramList), "utf-8") + "&index=" + paramInt + "&height=" + a();
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
          if (TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
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
      paramLong = (System.currentTimeMillis() - paramLong) / 1000L;
    } while (paramLong <= 0L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(17), paramLong + "");
    aact.a(akro.a(), "769", "206471", "", "76916", "1", "160", localHashMap);
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramAppInterface = "msgPos_web" + paramAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).commit();
  }
  
  private void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      if ((this.jdField_a_of_type_Askp == null) || (this.jdField_a_of_type_Askp.getCount() != 1)) {
        break label328;
      }
    }
    label328:
    for (int m = 1;; m = 0)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        return;
      }
      int n = 0;
      if (n < paramArrayList.size())
      {
        this.jdField_b_of_type_JavaUtilList.add(0, paramArrayList.get(n));
        if (n == paramArrayList.size() - 1)
        {
          if (m == 0)
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(((QQGameMsgInfo)paramArrayList.get(n)).paMsgid);
        }
        b(-1);
        if (m != 0) {}
        for (int i1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();; i1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() + 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i1);
          localObject = new HashMap();
          ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)paramArrayList.get(n)).paMsgid);
          ((Map)localObject).put(Integer.valueOf(2), "");
          ((Map)localObject).put(Integer.valueOf(3), "8");
          ((Map)localObject).put(Integer.valueOf(24), "1");
          aact.a(akro.a(), "769", "205030", "", "76901", "1", "160", (Map)localObject);
          n += 1;
          break;
        }
      }
      paramArrayList = a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      Object localObject = new Message();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = -1;
      ((Message)localObject).arg2 = -1;
      ((Message)localObject).obj = paramArrayList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getString("msgPos_web" + paramAppInterface.getCurrentAccountUin(), "");
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Askp != null)
    {
      this.jdField_a_of_type_Askp.notifyDataSetChanged();
      a();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
      if (paramInt != -1) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(paramInt);
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131373618));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)paramView.findViewById(2131373619));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369244));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131366278));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131371537));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369453));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369458));
    this.jdField_a_of_type_Askp = new askp(this, null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Askp);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(this);
    Object localObject = (ImageView)paramView.findViewById(2131375876);
    ((ImageView)localObject).setImageDrawable(asjc.a(null, null, "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_normal@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_click@2x.png"));
    ((ImageView)localObject).setOnClickListener(new askh(this));
    localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202003/upload_94d568a4fd9ea21aacf5204a5078a60c.png");
    paramView = (ImageView)paramView.findViewById(2131367518);
    paramView.setVisibility(0);
    paramView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramView.setImageDrawable((Drawable)localObject);
    a();
  }
  
  private void c(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int m = ((DisplayMetrics)localObject).heightPixels;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369738));
    int n = aekt.a(418.0F, getActivity().getResources());
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = aekt.a(m - n, getActivity().getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = aivz.a();
    if (TextUtils.isEmpty(PreloadManager.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      e();
      ((aivz)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new aski(this));
      return;
    }
    ((aivz)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new askj(this, paramView));
  }
  
  private void d()
  {
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "findMessage", null, new askf(this));
  }
  
  private void d(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371069));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371068));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new askl(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = aekt.a(7.0F, getActivity().getResources());
    localTextView.setText(alpo.a(2131710678));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130846639);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130846639);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(aekt.a(15.0F, getActivity().getResources()), aekt.a(15.0F, getActivity().getResources()));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.f = (this.e - this.d);
      this.h = (this.g - this.e);
      long l1 = this.g - this.jdField_a_of_type_Long;
      long l2 = this.f + this.h;
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "showWebViewTime=" + l1 + " initWebViewTime=" + this.jdField_c_of_type_Long + " webViewLoadTime=" + l2 + " initUiTime=" + this.jdField_b_of_type_Long + " loadUrlTime=" + this.f + " parsePageTime=" + this.h + " inflateLatyoutTime=" + this.i + " enterQQGamePubTime=" + this.j + " QIPCGetMsgTime=" + this.k + " initHeadTime=" + this.l);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(1), l1 + "");
      localHashMap.put(Integer.valueOf(2), this.jdField_c_of_type_Long + "");
      localHashMap.put(Integer.valueOf(3), l2 + "");
      localHashMap.put(Integer.valueOf(4), this.jdField_b_of_type_Long + "");
      localHashMap.put(Integer.valueOf(5), this.f + "");
      localHashMap.put(Integer.valueOf(6), this.h + "");
      localHashMap.put(Integer.valueOf(7), this.i + "");
      localHashMap.put(Integer.valueOf(8), this.j + "");
      localHashMap.put(Integer.valueOf(9), this.k + "");
      localHashMap.put(Integer.valueOf(10), this.l + "");
      aact.a(akro.a(), "769", "206612", "", "76918", "1", "160", localHashMap);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Askq = new askq(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Askq, localIntentFilter);
  }
  
  public long a()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = new QQGamePubWebView(getActivity());
    }
    this.jdField_a_of_type_Asks = new askk(this, getActivity(), getActivity(), akro.a(), this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    this.jdField_a_of_type_Asks.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new beav(this.jdField_a_of_type_Asks).a(null, akro.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)this.jdField_a_of_type_Asks.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setDrawingCacheEnabled(true);
    return System.currentTimeMillis() - l1;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559130, null, false);
    ((ImageView)localView.findViewById(2131365741)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      if (paramInt >= this.jdField_b_of_type_JavaUtilList.size())
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.10(this), 200L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.11(this), 1200L);
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Asiy != null) && (paramInt > 0)) {
      this.jdField_a_of_type_Asiy.c = false;
    }
    a(akro.a(), ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).paMsgid);
    Object localObject = new HashMap();
    ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).paMsgid);
    ((Map)localObject).put(Integer.valueOf(2), paramInt + "");
    ((Map)localObject).put(Integer.valueOf(3), "8");
    ((Map)localObject).put(Integer.valueOf(24), "1");
    aact.a(akro.a(), "769", "205017", ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).gameAppId, "76901", "1", "160", (Map)localObject);
    bkeu.a(2, ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).paMsgid, "");
    try
    {
      asjd.a(101, (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt), paramInt);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      localObject = new Message();
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
          if (paramInt2 != -1) {
            localHashMap.put("index", Integer.valueOf(paramInt2));
          }
          if (paramInt3 != -1) {
            localHashMap.put("height", Integer.valueOf(paramInt3));
          }
          if (!TextUtils.isEmpty(paramString)) {
            localHashMap.put("gameData", paramString);
          }
          localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.getUrl(), 8589934621L, localHashMap);
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
    paramView = (NavBarCommon)paramView.findViewById(2131375812);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368961);
    paramView.setRightImage(getResources().getDrawable(2130849504));
    localImageView.setImageResource(2130849988);
    paramView.setBackgroundColor(Color.parseColor("#64a4fe"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368659));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695735);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramView.setOnItemSelectListener(new askm(this));
    b();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void b()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new askn(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new asko(this));
  }
  
  public void c()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = aekt.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131695735));
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
  
  public boolean onBackEvent()
  {
    a(this.jdField_a_of_type_Long);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    asjc.jdField_a_of_type_Boolean = true;
    new HashMap().put(Integer.valueOf(24), "1");
    aact.a(akro.a(), "769", "205838", "", "76902", "160", "1", null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    d();
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("startTime")))
    {
      long l1 = getActivity().getIntent().getLongExtra("startTime", 0L);
      if (l1 > 0L) {
        this.j = (System.currentTimeMillis() - l1);
      }
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559135, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = ((GameSessionView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369644));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.a(BaseApplicationImpl.getApplication().getRuntime());
    if (!azib.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    this.jdField_c_of_type_Long = a();
    d(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView);
    c(this.jdField_a_of_type_AndroidViewView);
    g();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int m;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      m = 0;
    }
    for (;;)
    {
      try
      {
        if (m < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (!(this.jdField_a_of_type_JavaUtilList.get(m) instanceof GameArkView)) {
            continue;
          }
          ((GameArkView)this.jdField_a_of_type_JavaUtilList.get(m)).a();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("GameWebPage", 2, "header destroy i=" + m);
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameWebPage", 1, "header destroy error=" + localThrowable.toString());
        continue;
        m += 1;
      }
      if (this.jdField_a_of_type_Asks != null) {
        this.jdField_a_of_type_Asks.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.b();
      }
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnDestory", null, null);
      return;
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Askq != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Askq);
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Asks != null) {
      this.jdField_a_of_type_Asks.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Asks != null) {
      this.jdField_a_of_type_Asks.a();
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */