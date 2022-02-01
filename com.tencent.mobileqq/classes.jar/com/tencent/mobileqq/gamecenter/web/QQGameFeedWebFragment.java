package com.tencent.mobileqq.gamecenter.web;

import abuf;
import akra;
import akxf;
import albi;
import amwn;
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
import anvx;
import aqbi;
import avdq;
import aveq;
import aver;
import aves;
import avfh;
import avft;
import avgd;
import avge;
import avgf;
import avgg;
import avgh;
import avgj;
import avgk;
import avgl;
import avgm;
import avgn;
import avgo;
import avgp;
import avgq;
import avgs;
import avgv;
import avgw;
import avgy;
import avhd;
import avhe;
import bdfk;
import bieb;
import bmqi;
import bmqk;
import bmql;
import bmqt;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView;
import com.tencent.mobileqq.gamecenter.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.gamecenter.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.wadl.ipc.WadlResult;
import eipc.EIPCResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameFeedWebFragment
  extends PublicBaseFragment
  implements avgv, avgy, avhd, avhe, bmqi, BusinessObserver
{
  public static final byte[] a;
  public int a;
  public long a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new avgh(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private avfh jdField_a_of_type_Avfh;
  private avgp jdField_a_of_type_Avgp;
  private avgq jdField_a_of_type_Avgq;
  private avgw jdField_a_of_type_Avgw;
  private GameSessionView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  public NavBarQQGamePub a;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private GameContentView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout;
  private QQGameIndicator2 jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2;
  private QQGamePubWebView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView;
  private UnreadTipLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout;
  public List<avfh> a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<QQGameMsgInfo> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  public long c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  public long d;
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
    aqbi.a(true);
    aqbi.a();
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public QQGameFeedWebFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
        float f1 = UIUtils.getDensity(paramContext);
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
    paramGmpEnterInfoRsp = aves.a();
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
      abuf.a(amwn.a(), "770", "207021", "", "77002", "1", "160", localHashMap);
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
      if ((this.jdField_a_of_type_Avgp == null) || (this.jdField_a_of_type_Avgp.getCount() != 1)) {
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
            Object localObject2 = avft.a((QQGameMsgInfo)paramArrayList.get(i2), getActivity());
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
              abuf.a(amwn.a(), "769", "205030", (String)???, "76901", "1", "160", (Map)localObject2);
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
      if (this.jdField_c_of_type_Boolean)
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
    if (this.jdField_c_of_type_Boolean)
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
  
  private void b(long paramLong)
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
    abuf.a(amwn.a(), "769", "206471", "", "76916", "1", "160", localHashMap);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131374515));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)paramView.findViewById(2131374516));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView = ((GameContentView)paramView.findViewById(2131369847));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369904));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131366721));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2 = ((QQGameIndicator2)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131372397));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380247));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369940));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368747));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout = ((UnreadTipLayout)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131369804));
    this.jdField_a_of_type_Avgp = new avgp(this, null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setPageListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376830));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aver.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new avgd(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView = (ImageView)paramView.findViewById(2131368075);
    paramView.setVisibility(0);
    paramView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramView.setImageResource(2130846250);
    i();
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
          break label124;
        }
        if (i1 == paramInt)
        {
          this.jdField_a_of_type_Avfh = ((avfh)this.jdField_a_of_type_JavaUtilList.get(i1));
          if ((this.jdField_a_of_type_Avfh instanceof GameArkView)) {
            avdq.a().a((GameArkView)this.jdField_a_of_type_Avfh);
          } else {
            avdq.a().a(null);
          }
        }
      }
      finally {}
      avfh localavfh = (avfh)this.jdField_a_of_type_JavaUtilList.get(i1);
      if ((localavfh != null) && (aves.a(localavfh)))
      {
        localavfh.b();
        break label153;
        label124:
        if ((this.jdField_a_of_type_Avfh != null) && (aves.a(this.jdField_a_of_type_Avfh))) {
          this.jdField_a_of_type_Avfh.a();
        }
        return;
      }
      label153:
      i1 += 1;
    }
  }
  
  private void c(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).heightPixels;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370436));
    int i2 = AIOUtils.dp2px(418.0F, getActivity().getResources());
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.dp2px(i1 - i2, getActivity().getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = akxf.a();
    if (TextUtils.isEmpty(PreloadManager.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      j();
      ((akxf)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new avgl(this));
      return;
    }
    ((akxf)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new avgm(this, paramView));
  }
  
  private void d()
  {
    if (getActivity().getIntent() != null)
    {
      if (getActivity().getIntent().hasExtra("startTime"))
      {
        long l1 = getActivity().getIntent().getLongExtra("startTime", 0L);
        if (l1 > 0L) {
          this.m = (SystemClock.elapsedRealtime() - l1);
        }
      }
      if (getActivity().getIntent().hasExtra("clickTime")) {
        this.l = getActivity().getIntent().getLongExtra("clickTime", 0L);
      }
      if (getActivity().getIntent().hasExtra("unreadNum")) {
        this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("unreadNum", 0);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_Avgp != null)
    {
      this.jdField_a_of_type_Avgp.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
      if (paramInt > 0) {
        this.d -= 1;
      }
      if ((getActivity() != null) && (!getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (paramInt > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(paramInt);
      }
    }
  }
  
  private void d(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371909));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371908));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avgo(this));
  }
  
  private void e()
  {
    avgs.a().a();
    avgs.a().a("task_qgame_task_all_complete", this);
    avgs.a().a("task_get_qgame_msg", this);
    avgs.a().a("task_get_qgame_msg", true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.setUiRefresh(this);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.b();
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_Boolean = false;
    bmqk.a();
    bmqk.a(this);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      bmqk.a().b();
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = aveq.b();
    if (this.jdField_a_of_type_Int > 1)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setUnreadNum(this.jdField_a_of_type_Int - 1);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setOnClickListener(new avgj(this));
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.post(new QQGameFeedWebFragment.3(this));
        localObject1 = new HashMap();
        ((Map)localObject1).put(Integer.valueOf(4), "8");
        ((Map)localObject1).put(Integer.valueOf(24), "1");
        abuf.a(amwn.a(), "769", "207552", "", "76925", "1", "160", (Map)localObject1);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avgk(this));
    localObject1 = new HashMap();
    ((Map)localObject1).put(Integer.valueOf(24), "1");
    ((Map)localObject1).put(Integer.valueOf(3), "2");
    ((Map)localObject1).put(Integer.valueOf(4), "8");
    abuf.a(amwn.a(), "769", "207028", "", "76901", "1", "160", (Map)localObject1);
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.dp2px(7.0F, getActivity().getResources());
    localTextView.setText(anvx.a(2131709754));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130847183);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130847183);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(AIOUtils.dp2px(15.0F, getActivity().getResources()), AIOUtils.dp2px(15.0F, getActivity().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private void k()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.h = (this.g - this.f);
      this.j = (this.i - this.g);
      long l1 = this.i - this.jdField_a_of_type_Long;
      long l2 = this.h + this.j;
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "showWebViewTime=" + l1 + " initWebViewTime=" + this.jdField_c_of_type_Long + " webViewLoadTime=" + l2 + " initUiTime=" + this.jdField_b_of_type_Long + " loadUrlTime=" + this.h + " parsePageTime=" + this.j + " inflateLatyoutTime=" + this.k + " enterQQGamePubTime=" + this.m + " QIPCGetMsgTime=" + this.n);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(24), "1");
      localHashMap.put(Integer.valueOf(41), l1 + "");
      localHashMap.put(Integer.valueOf(42), this.jdField_c_of_type_Long + "");
      localHashMap.put(Integer.valueOf(43), l2 + "");
      localHashMap.put(Integer.valueOf(44), this.jdField_b_of_type_Long + "");
      localHashMap.put(Integer.valueOf(45), this.h + "");
      localHashMap.put(Integer.valueOf(46), this.j + "");
      localHashMap.put(Integer.valueOf(47), this.k + "");
      localHashMap.put(Integer.valueOf(48), this.m + "");
      localHashMap.put(Integer.valueOf(49), this.n + "");
      abuf.a(amwn.a(), "769", "206612", "", "76918", "1", "160", localHashMap);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.8(this, l2), 2000L);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Avgq = new avgq(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    localIntentFilter.addAction("action_qgame_jaspi_webloaded");
    localIntentFilter.addAction("action_qgame_h5_video_pause");
    localIntentFilter.addAction("action_qgame_h5_video_play");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Avgq, localIntentFilter);
  }
  
  private void m()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = a();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.jdField_a_of_type_Avgp != null) && (this.d > 0))
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
    avdq.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    this.jdField_a_of_type_Avgw = new avgn(this, getActivity(), getActivity(), amwn.a(), this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    new bieb(this.jdField_a_of_type_Avgw).a(null, amwn.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)this.jdField_a_of_type_Avgw.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setViewVisibleListener(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setDrawingCacheEnabled(true);
    return SystemClock.elapsedRealtime() - l1;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559240, null, false);
    ((ImageView)localView.findViewById(2131366161)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new avgf(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new avgg(this));
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
    a(amwn.a(), ((QQGameMsgInfo)localObject).paMsgid);
    HashMap localHashMap = new HashMap();
    abuf.a(localHashMap, ((QQGameMsgInfo)localObject).paMsgid);
    localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)localObject).paMsgid);
    localHashMap.put(Integer.valueOf(3), paramInt + "");
    localHashMap.put(Integer.valueOf(4), "8");
    localHashMap.put(Integer.valueOf(24), "1");
    abuf.a(amwn.a(), "769", "205017", ((QQGameMsgInfo)localObject).gameAppId, "76901", "1", "160", localHashMap);
    bmqt.a(2, ((QQGameMsgInfo)localObject).paMsgid, "");
    try
    {
      aves.a(117, (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt), paramInt);
      this.d += 1;
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
    if (paramInt1 < AIOUtils.dp2px(a(), BaseApplicationImpl.getApplication().getResources())) {
      if (aves.a(this.jdField_a_of_type_Avfh)) {
        this.jdField_a_of_type_Avfh.a();
      }
    }
    while (!aves.a(this.jdField_a_of_type_Avfh)) {
      return;
    }
    this.jdField_a_of_type_Avfh.b();
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
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.postDelayed(new QQGameFeedWebFragment.16(this), paramLong);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131376760));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
    try
    {
      paramView = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299080));
      int i1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication().getApplicationContext());
      paramView.setMargins(0, i1, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setLayoutParams(paramView);
      QLog.d("GameWebPage", 4, "statusBarHeight = " + i1);
      paramView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.findViewById(2131369605);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130848323), getResources().getDrawable(2130848156));
      paramView.setImageResource(2130850725);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setBackgroundResource(2130846254);
      this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694991);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setOnItemSelectListener(new avge(this));
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
    label612:
    label633:
    do
    {
      int i2;
      for (;;)
      {
        try
        {
          if (!"task_get_qgame_msg".equals(???)) {
            break label633;
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
            break label612;
          }
          this.e = 0;
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
              avfh localavfh = avft.a(localQQGameMsgInfo, getActivity());
              this.jdField_a_of_type_JavaUtilList.add(localavfh);
              if (TextUtils.isEmpty(localQQGameMsgInfo.arkAppName)) {
                continue;
              }
              albi.a().a(localQQGameMsgInfo.arkAppName);
              this.jdField_c_of_type_JavaUtilList.add(localQQGameMsgInfo.arkAppName);
            }
          }
          ??? = a(amwn.a());
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
            this.e = i1;
            break;
          }
          i1 += 1;
        }
        continue;
        if ((isAdded()) && (getActivity() != null) && (!getActivity().isFinishing())) {
          this.jdField_a_of_type_JavaUtilList.add(new MoreMsgHeaderView(getActivity()));
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Avgp);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
        d(this.e);
        if (this.e == 0)
        {
          ??? = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(this.e);
          paramEIPCResult = new HashMap();
          paramEIPCResult.put(Integer.valueOf(2), ???.paMsgid);
          paramEIPCResult.put(Integer.valueOf(3), this.e + "");
          paramEIPCResult.put(Integer.valueOf(4), "8");
          paramEIPCResult.put(Integer.valueOf(24), "1");
          abuf.a(paramEIPCResult, ???.paMsgid);
          abuf.a(amwn.a(), "769", "205017", ???.gameAppId, "76901", "1", "160", paramEIPCResult);
          bmqt.a(2, ???.paMsgid, "");
        }
        try
        {
          aves.a(117, ???, this.e);
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.e < this.jdField_a_of_type_JavaUtilList.size()))
          {
            this.jdField_a_of_type_Avfh = ((avfh)this.jdField_a_of_type_JavaUtilList.get(this.e));
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
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Avgp);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    } while (!"task_qgame_task_all_complete".equals(???));
    i1 = this.e;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.17(this, i1));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.15(this));
    }
  }
  
  public void c()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = AIOUtils.setOpenAIOIntent(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131694991));
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
    b(this.jdField_a_of_type_Long);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aver.jdField_a_of_type_Boolean = true;
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(24), "1");
    paramBundle.put(Integer.valueOf(4), "8");
    abuf.a(amwn.a(), "769", "205838", "", "76902", "1", "160", paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    d();
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559251, paramViewGroup, false);
    if (!bdfk.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    g();
    b(this.jdField_b_of_type_AndroidViewView);
    e();
    f();
    l();
    avdq.a().a(2);
    this.jdField_b_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    this.jdField_c_of_type_Long = a();
    d(this.jdField_b_of_type_AndroidViewView);
    a(this.jdField_b_of_type_AndroidViewView);
    c(this.jdField_b_of_type_AndroidViewView);
    h();
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1436	com/tencent/mobileqq/fragment/PublicBaseFragment:onDestroy	()V
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
    //   26: invokeinterface 224 1 0
    //   31: if_icmpge +70 -> 101
    //   34: aload_0
    //   35: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   38: iload_1
    //   39: invokeinterface 228 2 0
    //   44: instanceof 707
    //   47: ifeq +223 -> 270
    //   50: aload_0
    //   51: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   54: iload_1
    //   55: invokeinterface 228 2 0
    //   60: checkcast 707	com/tencent/mobileqq/gamecenter/view/GameArkView
    //   63: invokevirtual 1438	com/tencent/mobileqq/gamecenter/view/GameArkView:c	()V
    //   66: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +201 -> 270
    //   72: ldc 133
    //   74: iconst_2
    //   75: new 135	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 1440
    //   85: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: goto +172 -> 270
    //   101: aload_0
    //   102: getfield 80	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: invokeinterface 1443 1 0
    //   110: aload_2
    //   111: monitorexit
    //   112: aload_0
    //   113: getfield 240	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView	Lcom/tencent/mobileqq/gamecenter/web/view/QQGamePubWebView;
    //   116: ifnull +10 -> 126
    //   119: aload_0
    //   120: getfield 240	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView	Lcom/tencent/mobileqq/gamecenter/web/view/QQGamePubWebView;
    //   123: invokevirtual 1444	com/tencent/mobileqq/gamecenter/web/view/QQGamePubWebView:b	()V
    //   126: aload_0
    //   127: getfield 205	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_Avgw	Lavgw;
    //   130: ifnull +10 -> 140
    //   133: aload_0
    //   134: getfield 205	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_Avgw	Lavgw;
    //   137: invokevirtual 1445	avgw:onDestroy	()V
    //   140: aload_0
    //   141: getfield 118	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   144: ifnull +10 -> 154
    //   147: aload_0
    //   148: getfield 118	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   151: invokevirtual 1446	com/tencent/mobileqq/gamecenter/web/view/GameContentView:c	()V
    //   154: invokestatic 712	avdq:a	()Lavdq;
    //   157: invokevirtual 1447	avdq:e	()V
    //   160: aload_0
    //   161: getfield 93	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   164: ifnull +11 -> 175
    //   167: aload_0
    //   168: getfield 93	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   171: aconst_null
    //   172: invokevirtual 1450	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   175: aload_0
    //   176: getfield 118	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   179: ifnull +10 -> 189
    //   182: aload_0
    //   183: getfield 118	com/tencent/mobileqq/gamecenter/web/QQGameFeedWebFragment:jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView	Lcom/tencent/mobileqq/gamecenter/web/view/GameContentView;
    //   186: invokevirtual 1451	com/tencent/mobileqq/gamecenter/web/view/GameContentView:a	()V
    //   189: invokestatic 1457	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   192: ldc_w 1459
    //   195: ldc_w 1461
    //   198: aconst_null
    //   199: aconst_null
    //   200: invokevirtual 1465	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   203: invokestatic 1294	albi:a	()Lalbi;
    //   206: iconst_0
    //   207: anewarray 285	java/lang/String
    //   210: invokevirtual 1468	albi:a	([Ljava/lang/String;)V
    //   213: invokestatic 851	avgs:a	()Lavgs;
    //   216: invokevirtual 1469	avgs:b	()V
    //   219: aload_0
    //   220: invokestatic 1471	bmqk:b	(Lbmqi;)V
    //   223: return
    //   224: astore_3
    //   225: ldc 133
    //   227: iconst_1
    //   228: new 135	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 1473
    //   238: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_3
    //   242: invokevirtual 1474	java/lang/Throwable:toString	()Ljava/lang/String;
    //   245: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 1476	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: goto -144 -> 110
    //   257: astore_3
    //   258: aload_2
    //   259: monitorexit
    //   260: aload_3
    //   261: athrow
    //   262: astore_2
    //   263: aload_2
    //   264: invokevirtual 312	java/lang/Throwable:printStackTrace	()V
    //   267: goto -92 -> 175
    //   270: iload_1
    //   271: iconst_1
    //   272: iadd
    //   273: istore_1
    //   274: goto -253 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	QQGameFeedWebFragment
    //   20	254	1	i1	int
    //   7	252	2	arrayOfByte	byte[]
    //   262	2	2	localThrowable1	Throwable
    //   14	2	3	localList	List
    //   224	18	3	localThrowable2	Throwable
    //   257	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	98	224	java/lang/Throwable
    //   101	110	224	java/lang/Throwable
    //   10	15	257	finally
    //   21	98	257	finally
    //   101	110	257	finally
    //   110	112	257	finally
    //   225	254	257	finally
    //   258	260	257	finally
    //   167	175	262	java/lang/Throwable
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Avgq != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Avgq);
    }
    if (this.jdField_c_of_type_JavaUtilList != null) {
      albi.a().b(this.jdField_c_of_type_JavaUtilList);
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
    if (this.jdField_a_of_type_Avgw != null) {
      this.jdField_a_of_type_Avgw.onPause();
    }
    if (aves.a(this.jdField_a_of_type_Avfh)) {
      this.jdField_a_of_type_Avfh.b();
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameWebPage", 1, "---->onQueryCallback isGetGameEnter=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    try
    {
      long l1 = aves.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "---> get lastGameAppID=" + l1);
      }
      this.jdField_b_of_type_Boolean = true;
      akra.a(new GmpEnterInfoReq(l1, 1), this);
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
    if (this.jdField_a_of_type_Avgw != null) {
      this.jdField_a_of_type_Avgw.onResume();
    }
    if (this.jdField_a_of_type_Avfh != null) {
      this.jdField_a_of_type_Avfh.a();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */