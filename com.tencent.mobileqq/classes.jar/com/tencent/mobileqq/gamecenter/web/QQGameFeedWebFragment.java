package com.tencent.mobileqq.gamecenter.web;

import aceh;
import afur;
import akmf;
import aksh;
import akwh;
import ampj;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
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
import anll;
import anni;
import aprd;
import autb;
import auuc;
import auud;
import auue;
import auuq;
import auvb;
import auvc;
import auvl;
import auvm;
import auvn;
import auvo;
import auvp;
import auvq;
import auvr;
import auvs;
import auvt;
import auvu;
import auvv;
import auvw;
import auvy;
import auwb;
import auwc;
import auwe;
import auwi;
import bcnj;
import bhmg;
import bmxe;
import bmxh;
import bmxi;
import bmxq;
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
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView;
import com.tencent.mobileqq.gamecenter.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
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
import zlx;

public class QQGameFeedWebFragment
  extends PublicBaseFragment
  implements auvb, auwb, auwe, auwi, bmxe, BusinessObserver
{
  public static final byte[] a;
  public int a;
  public long a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new auvm(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private auuq jdField_a_of_type_Auuq;
  private auvv jdField_a_of_type_Auvv;
  private auvw jdField_a_of_type_Auvw;
  private auwc jdField_a_of_type_Auwc;
  public NavBarQQGamePub a;
  private QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private GameContentView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout;
  private QQGamePubWebView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView;
  public List<auuq> a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
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
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  public long d;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int jdField_e_of_type_Int;
  public long e;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  
  static
  {
    aprd.a(true);
    aprd.a();
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
      f1 = anll.a.density;
      return paramFloat / f1 + 0.5F;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        float f1 = zlx.a(paramContext);
      }
    }
  }
  
  private int a()
  {
    int i1 = 392;
    int n = 0;
    int m = n;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
      {
        m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.getVisibility() == 0) {
          m = this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "gameContentHeight=" + m);
      }
      n = i1;
      if (isAdded())
      {
        n = i1;
        if (getActivity() != null)
        {
          n = i1;
          if (!getActivity().isFinishing())
          {
            float f1 = a(getActivity(), m + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight());
            n = (int)f1;
          }
        }
      }
      return n;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("GameWebPage", 1, "getWebPading faile:" + localThrowable.getMessage());
    }
    return 392;
  }
  
  private QQGameMsgInfo a()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (m < this.jdField_b_of_type_JavaUtilList.size())) {
      return (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(m);
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
    aceh.a(ampj.a(), "769", "206471", "", "76916", "1", "160", localHashMap);
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
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.14(this, paramGmpEnterInfoRsp));
      return;
    }
    GmpEnterInfoRsp localGmpEnterInfoRsp = auue.a();
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(localGmpEnterInfoRsp.bubble_id))
    {
      localHashMap.put(Integer.valueOf(2), localGmpEnterInfoRsp.bubble_id);
      localHashMap.put(Integer.valueOf(3), "1");
    }
    for (;;)
    {
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      aceh.a(ampj.a(), "770", "207021", "", "77002", "1", "160", localHashMap);
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.15(this, localGmpEnterInfoRsp));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GameWebPage", 1, "rec game enter is null,stat=" + paramGmpEnterInfoRsp.state + " code=" + paramGmpEnterInfoRsp.ret_code);
      return;
      localHashMap.put(Integer.valueOf(3), "2");
    }
  }
  
  private void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      if ((this.jdField_a_of_type_Auvv == null) || (this.jdField_a_of_type_Auvv.getCount() != 1)) {
        break label436;
      }
    }
    label436:
    for (int m = 1;; m = 0)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        return;
      }
      this.jdField_b_of_type_Int += paramArrayList.size();
      this.jdField_c_of_type_Int += paramArrayList.size();
      int n = 0;
      if (n < paramArrayList.size())
      {
        this.jdField_b_of_type_JavaUtilList.add(0, paramArrayList.get(n));
        localObject = auvc.a((QQGameMsgInfo)paramArrayList.get(n), getActivity());
        this.jdField_a_of_type_JavaUtilList.add(0, localObject);
        if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(n)).arkAppName)) {
          this.jdField_c_of_type_JavaUtilList.add(((QQGameMsgInfo)paramArrayList.get(n)).arkAppName);
        }
        if (n == paramArrayList.size() - 1)
        {
          if (m == 0) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(((QQGameMsgInfo)paramArrayList.get(n)).paMsgid);
        }
        c(-1);
        int i1;
        label220:
        HashMap localHashMap;
        if (m != 0)
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i1);
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)paramArrayList.get(n)).paMsgid);
          localHashMap.put(Integer.valueOf(4), "8");
          localHashMap.put(Integer.valueOf(24), "1");
          if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(n)).gameAppId)) {
            break label359;
          }
        }
        label359:
        for (localObject = "";; localObject = ((QQGameMsgInfo)paramArrayList.get(n)).gameAppId)
        {
          aceh.a(ampj.a(), "769", "205030", (String)localObject, "76901", "1", "160", localHashMap);
          n += 1;
          break;
          i1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() + 1;
          break label220;
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
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      if (!auuc.b()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (!this.jdField_c_of_type_Boolean) {
        if (!paramBoolean) {
          break label120;
        }
      }
    }
    label120:
    for (String str = "1";; str = "2")
    {
      if ((!auuc.b()) || (!str.equals("1"))) {
        break label127;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "");
      break;
    }
    label127:
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(24), "1");
    localHashMap.put(Integer.valueOf(3), str);
    localHashMap.put(Integer.valueOf(4), "8");
    aceh.a(ampj.a(), "769", "207028", "", "76901", "1", "160", localHashMap);
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label124;
        }
        if (m == paramInt)
        {
          this.jdField_a_of_type_Auuq = ((auuq)this.jdField_a_of_type_JavaUtilList.get(m));
          if ((this.jdField_a_of_type_Auuq instanceof GameArkView)) {
            autb.a().a((GameArkView)this.jdField_a_of_type_Auuq);
          } else {
            autb.a().a(null);
          }
        }
      }
      finally {}
      auuq localauuq = (auuq)this.jdField_a_of_type_JavaUtilList.get(m);
      if ((localauuq != null) && (auue.a(localauuq)))
      {
        localauuq.b();
        break label153;
        label124:
        if ((this.jdField_a_of_type_Auuq != null) && (auue.a(this.jdField_a_of_type_Auuq))) {
          this.jdField_a_of_type_Auuq.a();
        }
        return;
      }
      label153:
      m += 1;
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131374372));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)paramView.findViewById(2131374373));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.attachToRootView();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView = ((GameContentView)paramView.findViewById(2131369596));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369652));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131366534));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131372127));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369867));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369872));
    this.jdField_a_of_type_Auvv = new auvv(this, null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Auvv);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376669));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(auud.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new auvl(this));
    if (auuc.b()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    Object localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202003/upload_94d568a4fd9ea21aacf5204a5078a60c.png");
    ImageView localImageView = (ImageView)paramView.findViewById(2131367838);
    localImageView.setVisibility(0);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379992));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369688));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368490));
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramView = URLDrawable.URLDrawableOptions.obtain();
      localObject = new ColorDrawable(-15090945);
      paramView.mLoadingDrawable = ((Drawable)localObject);
      paramView.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202006/upload_32b6df772edd7f4dd2bf13382f80d356.png", paramView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable((Drawable)localObject);
      paramView = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202004/upload_5dea58e62564d53805d39c48742c5f0a.png", paramView);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Int - 1 + "");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new auvn(this));
      return;
    }
    a(false, 0);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Auvv.notifyDataSetChanged();
    a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
    if (paramInt > 0) {
      this.jdField_d_of_type_Int -= 1;
    }
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(paramInt);
    }
  }
  
  private void c(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int m = ((DisplayMetrics)localObject).heightPixels;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370188));
    int n = afur.a(418.0F, getActivity().getResources());
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = afur.a(m - n, getActivity().getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = aksh.a();
    if (TextUtils.isEmpty(PreloadManager.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      i();
      ((aksh)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new auvo(this));
      return;
    }
    ((aksh)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new auvp(this, paramView));
  }
  
  private void d(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371649));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371648));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new auvr(this));
  }
  
  private void e()
  {
    auvy.a().a();
    auvy.a().a("task_qgame_task_all_complete", this);
    auvy.a().a("task_get_qgame_msg", this);
    auvy.a().a("task_get_qgame_msg", true);
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
    bmxh.a();
    bmxh.a(this);
  }
  
  private void h()
  {
    if ((auuc.b()) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      bmxh.a().b();
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = afur.a(7.0F, getActivity().getResources());
    localTextView.setText(anni.a(2131709066));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130847160);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130847160);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(afur.a(15.0F, getActivity().getResources()), afur.a(15.0F, getActivity().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.f = (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long);
      this.h = (this.g - this.jdField_e_of_type_Long);
      long l1 = this.g - this.jdField_a_of_type_Long;
      long l2 = this.f + this.h;
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "showWebViewTime=" + l1 + " initWebViewTime=" + this.jdField_c_of_type_Long + " webViewLoadTime=" + l2 + " initUiTime=" + this.jdField_b_of_type_Long + " loadUrlTime=" + this.f + " parsePageTime=" + this.h + " inflateLatyoutTime=" + this.i + " enterQQGamePubTime=" + this.j + " QIPCGetMsgTime=" + this.k);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(24), "1");
      localHashMap.put(Integer.valueOf(41), l1 + "");
      localHashMap.put(Integer.valueOf(42), this.jdField_c_of_type_Long + "");
      localHashMap.put(Integer.valueOf(43), l2 + "");
      localHashMap.put(Integer.valueOf(44), this.jdField_b_of_type_Long + "");
      localHashMap.put(Integer.valueOf(45), this.f + "");
      localHashMap.put(Integer.valueOf(46), this.h + "");
      localHashMap.put(Integer.valueOf(47), this.i + "");
      localHashMap.put(Integer.valueOf(48), this.j + "");
      localHashMap.put(Integer.valueOf(49), this.k + "");
      aceh.a(ampj.a(), "769", "206612", "", "76918", "1", "160", localHashMap);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Auvw = new auvw(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    localIntentFilter.addAction("action_qgame_jaspi_webloaded");
    localIntentFilter.addAction("action_qgame_h5_video_pause");
    localIntentFilter.addAction("action_qgame_h5_video_play");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Auvw, localIntentFilter);
  }
  
  private void l()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = a();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.jdField_a_of_type_Auvv != null) && (this.jdField_d_of_type_Int > 0))
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
    long l = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = new QQGamePubWebView(getActivity());
    }
    autb.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    this.jdField_a_of_type_Auwc = new auvq(this, getActivity(), getActivity(), ampj.a(), this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView);
    this.jdField_a_of_type_Auwc.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new bhmg(this.jdField_a_of_type_Auwc).a(null, ampj.a(), null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView = ((QQGamePubWebView)this.jdField_a_of_type_Auwc.getWebView());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setViewVisibleListener(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.setDrawingCacheEnabled(true);
    return SystemClock.elapsedRealtime() - l;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559201, null, false);
    ((ImageView)localView.findViewById(2131365984)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    Object localObject;
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
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.10(this), 400L);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Int > 0) {
      if ((paramInt >= this.jdField_b_of_type_Int) && (this.jdField_b_of_type_Int <= this.jdField_c_of_type_Int) && (paramInt <= this.jdField_c_of_type_Int))
      {
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Int = (this.jdField_c_of_type_Int - this.jdField_b_of_type_Int + 1);
        if (this.jdField_a_of_type_Int <= 0) {
          break label404;
        }
        a(true, this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      localObject = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      a(ampj.a(), ((QQGameMsgInfo)localObject).paMsgid);
      HashMap localHashMap = new HashMap();
      aceh.a(localHashMap, ((QQGameMsgInfo)localObject).paMsgid);
      localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)localObject).paMsgid);
      localHashMap.put(Integer.valueOf(3), paramInt + "");
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      aceh.a(ampj.a(), "769", "205017", ((QQGameMsgInfo)localObject).gameAppId, "76901", "1", "160", localHashMap);
      bmxq.a(2, ((QQGameMsgInfo)localObject).paMsgid, "");
      try
      {
        auue.a(117, (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt), paramInt);
        this.jdField_d_of_type_Int += 1;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).arg1 = paramInt;
        ((Message)localObject).arg2 = -1;
        ((Message)localObject).obj = "";
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        return;
        label404:
        a(false, 0);
        continue;
        a(false, 0);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
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
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131376599));
    try
    {
      paramView = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131298998));
      int m = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication().getApplicationContext());
      paramView.setMargins(0, m, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setLayoutParams(paramView);
      QLog.d("GameWebPage", 4, "statusBarHeight = " + m);
      paramView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.findViewById(2131369362);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130850128));
      paramView.setImageResource(2130850653);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setBackgroundColor(Color.parseColor("#64a4fe"));
      this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694625);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setOnItemSelectListener(new auvs(this));
      b();
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
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    int m = 0;
    label299:
    label578:
    label611:
    label616:
    for (;;)
    {
      int n;
      try
      {
        if (!"task_get_qgame_msg".equals(paramString)) {
          break label578;
        }
        this.k = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
        if (paramEIPCResult.code == 0)
        {
          paramString = paramEIPCResult.data;
          if (paramString != null) {
            this.jdField_b_of_type_JavaUtilList = ((List)paramString.getSerializable("key_get_msg"));
          }
        }
        if (this.jdField_b_of_type_JavaUtilList == null) {
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
        }
        n = this.jdField_b_of_type_JavaUtilList.size();
        if (n > 0)
        {
          this.jdField_e_of_type_Int = 0;
          if (this.jdField_a_of_type_Int > 0)
          {
            this.jdField_b_of_type_Int = 1;
            this.jdField_a_of_type_Int -= 1;
            this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
            paramString = this.jdField_b_of_type_JavaUtilList.iterator();
            if (!paramString.hasNext()) {
              break label299;
            }
            paramEIPCResult = (QQGameMsgInfo)paramString.next();
            auuq localauuq = auvc.a(paramEIPCResult, getActivity());
            this.jdField_a_of_type_JavaUtilList.add(localauuq);
            if (TextUtils.isEmpty(paramEIPCResult.arkAppName)) {
              continue;
            }
            akwh.a().a(paramEIPCResult.arkAppName);
            this.jdField_c_of_type_JavaUtilList.add(paramEIPCResult.arkAppName);
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.d("GameWebPage", 1, "handleIpcResult fail:" + paramString.getMessage());
        paramString.printStackTrace();
      }
      label245:
      paramString = a(ampj.a());
      for (;;)
      {
        for (;;)
        {
          if (m >= n) {
            break label616;
          }
          paramEIPCResult = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(m);
          if ((paramEIPCResult.paMsgid == null) || (!paramEIPCResult.paMsgid.equals(paramString))) {
            break label611;
          }
          this.jdField_e_of_type_Int = m;
          break;
          if ((isAdded()) && (getActivity() != null) && (!getActivity().isFinishing())) {
            this.jdField_a_of_type_JavaUtilList.add(new MoreMsgHeaderView(getActivity()));
          }
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_Auvv);
          c(this.jdField_e_of_type_Int);
          if (this.jdField_e_of_type_Int == 0)
          {
            paramString = (QQGameMsgInfo)this.jdField_b_of_type_JavaUtilList.get(this.jdField_e_of_type_Int);
            paramEIPCResult = new HashMap();
            paramEIPCResult.put(Integer.valueOf(2), paramString.paMsgid);
            paramEIPCResult.put(Integer.valueOf(3), this.jdField_e_of_type_Int + "");
            paramEIPCResult.put(Integer.valueOf(4), "8");
            paramEIPCResult.put(Integer.valueOf(24), "1");
            aceh.a(paramEIPCResult, paramString.paMsgid);
            aceh.a(ampj.a(), "769", "205017", paramString.gameAppId, "76901", "1", "160", paramEIPCResult);
            bmxq.a(2, paramString.paMsgid, "");
          }
          try
          {
            auue.a(117, paramString, this.jdField_e_of_type_Int);
            if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_e_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())) {
              break label245;
            }
            this.jdField_a_of_type_Auuq = ((auuq)this.jdField_a_of_type_JavaUtilList.get(this.jdField_e_of_type_Int));
            return;
          }
          catch (Throwable paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
        if (!"task_qgame_task_all_complete".equals(paramString)) {
          break label245;
        }
        m = this.jdField_e_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.13(this, m));
        return;
        m += 1;
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void b()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new auvt(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new auvu(this));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < afur.a(a(), BaseApplicationImpl.getApplication().getResources())) {
      if (auue.a(this.jdField_a_of_type_Auuq)) {
        this.jdField_a_of_type_Auuq.a();
      }
    }
    while (!auue.a(this.jdField_a_of_type_Auuq)) {
      return;
    }
    this.jdField_a_of_type_Auuq.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.12(this));
    }
  }
  
  public void d()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = afur.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131694625));
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
    auud.jdField_a_of_type_Boolean = true;
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(24), "1");
    paramBundle.put(Integer.valueOf(4), "8");
    aceh.a(ampj.a(), "769", "205838", "", "76902", "1", "160", paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (getActivity().getIntent() != null)
    {
      if (getActivity().getIntent().hasExtra("startTime"))
      {
        long l = getActivity().getIntent().getLongExtra("startTime", 0L);
        if (l > 0L) {
          this.j = (SystemClock.elapsedRealtime() - l);
        }
      }
      if (getActivity().getIntent().hasExtra("unreadNum")) {
        this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("unreadNum", 0);
      }
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559207, paramViewGroup, false);
    if (!bcnj.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    e();
    g();
    b(this.jdField_a_of_type_AndroidViewView);
    f();
    k();
    autb.a().a(2);
    this.jdField_b_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    this.jdField_c_of_type_Long = a();
    d(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView);
    c(this.jdField_a_of_type_AndroidViewView);
    h();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
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
          ((GameArkView)this.jdField_a_of_type_JavaUtilList.get(m)).c();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("GameWebPage", 2, "header destroy i=" + m);
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
            this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.a();
          }
          QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnDestory", null, null);
          akwh.a().a(new String[0]);
          auvy.a().b();
          bmxh.b(this);
          return;
          localThrowable1 = localThrowable1;
          QLog.e("GameWebPage", 1, "header destroy error=" + localThrowable1.toString());
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          continue;
        }
        m += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGamePubWebView.b();
      }
      if (this.jdField_a_of_type_Auwc != null) {
        this.jdField_a_of_type_Auwc.onDestroy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.c();
      }
      autb.a().e();
      if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Auvw != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Auvw);
    }
    if (this.jdField_c_of_type_JavaUtilList != null) {
      akwh.a().b(this.jdField_c_of_type_JavaUtilList);
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
    if (this.jdField_a_of_type_Auwc != null) {
      this.jdField_a_of_type_Auwc.onPause();
    }
    if (auue.a(this.jdField_a_of_type_Auuq)) {
      this.jdField_a_of_type_Auuq.b();
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameWebPage", 1, "---->onQueryCallback isGetGameEnter=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        if (auuc.b())
        {
          long l = auue.a(paramArrayList);
          if (QLog.isColorLevel()) {
            QLog.d("GameWebPage", 1, "---> get lastGameAppID=" + l);
          }
          this.jdField_b_of_type_Boolean = true;
          akmf.a(new GmpEnterInfoReq(l, 1), this);
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        QLog.d("GameWebPage", 1, "---->onQueryCallback getLastGameAppID fail:" + paramArrayList.getMessage());
      }
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
        break label126;
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
    label126:
    a(null, false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Auwc != null) {
      this.jdField_a_of_type_Auwc.onResume();
    }
    if (this.jdField_a_of_type_Auuq != null) {
      this.jdField_a_of_type_Auuq.a();
    }
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilList != null) {
          continue;
        }
        m = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (m > 0) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() == m)) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(m - 1);
        }
      }
      catch (Throwable localThrowable)
      {
        int m;
        localThrowable.printStackTrace();
        continue;
      }
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
      return;
      m = this.jdField_b_of_type_JavaUtilList.size();
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