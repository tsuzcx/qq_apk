package com.tencent.mobileqq.gamecenter.web;

import aciy;
import aing;
import alhf;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apyn;
import apyr;
import apyv;
import apzf;
import apzp;
import apzq;
import apzr;
import apzs;
import apzt;
import apzu;
import apzv;
import apzw;
import apzx;
import apzy;
import aqaa;
import babp;
import baym;
import bgtf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
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
import yez;

public class QQGameFeedWebFragment
  extends PublicBaseFragment
  implements apzf
{
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new apzq(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apyn jdField_a_of_type_Apyn;
  private apzx jdField_a_of_type_Apzx;
  private apzy jdField_a_of_type_Apzy;
  private aqaa jdField_a_of_type_Aqaa;
  private QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout;
  private QQGamePubWebView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView;
  public List<apyv> a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private List<QQGameMsgInfo> jdField_b_of_type_JavaUtilList;
  private ImageView c;
  
  static
  {
    alhf.a(true);
    alhf.a();
  }
  
  public QQGameFeedWebFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private QQGameMsgInfo a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
      return (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(i);
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
        return paramString + "?gameData=" + URLEncoder.encode(a(paramList), "utf-8") + "&index=" + paramInt + "&height=" + 418;
      }
      catch (Throwable paramList)
      {
        return paramString;
      }
      paramList = paramString + "&gameData=" + URLEncoder.encode(a(paramList), "utf-8") + "&index=" + paramInt + "&height=" + 418;
      return paramList;
    }
    if (paramString.indexOf("?") == -1) {
      return paramString + "?height=" + 418;
    }
    return paramString + "height=" + 418;
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
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramAppInterface = "msgPos_web" + paramAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).commit();
  }
  
  private void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      if ((this.jdField_a_of_type_Apzx == null) || (this.jdField_a_of_type_Apzx.getCount() != 1)) {
        break label328;
      }
    }
    label328:
    for (int i = 1;; i = 0)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        return;
      }
      int j = 0;
      if (j < paramArrayList.size())
      {
        this.jdField_b_of_type_JavaUtilList.add(0, paramArrayList.get(j));
        if (j == paramArrayList.size() - 1)
        {
          if (i == 0)
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(((QQGameMsgInfo)paramArrayList.get(j)).paMsgid);
        }
        b(-1);
        if (i != 0) {}
        for (int k = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();; k = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() + 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(k);
          localObject = new HashMap();
          ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)paramArrayList.get(j)).paMsgid);
          ((Map)localObject).put(Integer.valueOf(2), "");
          ((Map)localObject).put(Integer.valueOf(3), "8");
          ((Map)localObject).put(Integer.valueOf(24), "1");
          yez.a(aing.a(), "769", "205030", "", "76901", "1", "160", (Map)localObject);
          j += 1;
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
    if (this.jdField_a_of_type_Apzx != null)
    {
      this.jdField_a_of_type_Apzx.notifyDataSetChanged();
      a();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
      if (paramInt != -1) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(paramInt);
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131307456));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)paramView.findViewById(2131307457));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131303347));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131300588));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131305530));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303551));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303556));
    this.jdField_a_of_type_Apzx = new apzx(this, null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Apzx);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(this);
    Object localObject = (ImageView)paramView.findViewById(2131309638);
    ((ImageView)localObject).setImageDrawable(apyr.a(null, null, "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_normal@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gamecenter_enter_click@2x.png"));
    ((ImageView)localObject).setOnClickListener(new apzr(this));
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenterBackground.png");
    paramView = (ImageView)paramView.findViewById(2131301778);
    paramView.setVisibility(0);
    paramView.setImageDrawable((Drawable)localObject);
    a();
  }
  
  private void c(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131305091));
    this.c = ((ImageView)paramView.findViewById(2131305090));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.c.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new apzt(this));
  }
  
  private void d()
  {
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "findMessage", null, new apzp(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aqaa = new apzs(this, getActivity(), getActivity(), aing.a(), this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    this.jdField_a_of_type_Aqaa.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new baym(this.jdField_a_of_type_Aqaa).a(null, aing.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)this.jdField_a_of_type_Aqaa.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setDrawingCacheEnabled(true);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Apzy = new apzy(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Apzy, localIntentFilter);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131493520, null, false);
    ((ImageView)localView.findViewById(2131300061)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    int i = (int)((float)(babp.k() / 2L) - this.jdField_b_of_type_JavaUtilList.size() * 10 * babp.a / 2.0F - 8.0F * babp.a);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
    this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      if (paramInt >= this.jdField_b_of_type_JavaUtilList.size())
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.8(this), 200L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.9(this), 1200L);
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Apyn != null) && (paramInt > 0)) {
      this.jdField_a_of_type_Apyn.c = false;
    }
    a(aing.a(), ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).paMsgid);
    Object localObject = new HashMap();
    ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).paMsgid);
    ((Map)localObject).put(Integer.valueOf(2), paramInt + "");
    ((Map)localObject).put(Integer.valueOf(3), "8");
    ((Map)localObject).put(Integer.valueOf(24), "1");
    yez.a(aing.a(), "769", "205017", ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).gameAppId, "76901", "1", "160", (Map)localObject);
    bgtf.a(2, ((QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).paMsgid, "");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    localObject = new Message();
    ((Message)localObject).what = 1;
    ((Message)localObject).arg1 = paramInt;
    ((Message)localObject).arg2 = -1;
    ((Message)localObject).obj = "";
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
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
    paramView = (NavBarCommon)paramView.findViewById(2131309578);
    ImageView localImageView = (ImageView)paramView.findViewById(2131303102);
    paramView.setRightImage(getResources().getDrawable(2130848842));
    localImageView.setImageResource(2130849304);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131629895);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramView.setOnItemSelectListener(new apzu(this));
    b();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void b()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new apzv(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new apzw(this));
  }
  
  public void c()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = aciy.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131629895));
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    apyr.a = true;
    new HashMap().put(Integer.valueOf(24), "1");
    yez.a(aing.a(), "769", "205838", "", "76902", "160", "1", null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493523, paramViewGroup, false);
    d();
    a(this.jdField_a_of_type_AndroidViewView);
    c(this.jdField_a_of_type_AndroidViewView);
    b(this.jdField_a_of_type_AndroidViewView);
    e();
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (!(this.jdField_a_of_type_JavaUtilList.get(i) instanceof GameArkView)) {
            continue;
          }
          ((GameArkView)this.jdField_a_of_type_JavaUtilList.get(i)).a();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("GameWebPage", 2, "header destroy i=" + i);
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameWebPage", 1, "header destroy error=" + localThrowable.toString());
        continue;
        i += 1;
      }
      if (this.jdField_a_of_type_Aqaa != null) {
        this.jdField_a_of_type_Aqaa.c();
      }
      return;
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Apzy != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Apzy);
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aqaa != null) {
      this.jdField_a_of_type_Aqaa.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aqaa != null) {
      this.jdField_a_of_type_Aqaa.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */