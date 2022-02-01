package com.tencent.mobileqq.gamecenter.hippy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.hippy.view.GamePubAccountHeadAdapter;
import com.tencent.mobileqq.gamecenter.hippy.view.GamePubAccountHeadView;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.util.QQGameUIHelper;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.IHeaderView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.view.QQGamePubHeaderFactory;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2;
import com.tencent.mobileqq.gamecenter.web.view.QQGameIndicator2.IPageListener;
import com.tencent.mobileqq.gamecenter.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GamePubAccountHippyFragment
  extends GamePAHippyBaseFragment
  implements View.OnClickListener, GameContentView.UiRefresh, QQGameIndicator2.IPageListener
{
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new GamePubAccountHippyFragment.11(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private GamePubAccountHeadAdapter jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter;
  private GamePubAccountHeadView jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadView;
  private IHeaderView jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView;
  private NavBarQQGamePub jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager;
  private GameContentView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView;
  private QQGameIndicator2 jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2;
  private UnreadTipLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private List<IHeaderView> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private int d;
  
  public GamePubAccountHippyFragment()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  private View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559291, null, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131368438));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub = ((NavBarQQGamePub)paramLayoutInflater.findViewById(2131377159));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131370129));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131370713));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadView = ((GamePubAccountHeadView)paramLayoutInflater.findViewById(2131370146));
    a(paramLayoutInflater, this.jdField_b_of_type_AndroidWidgetLinearLayout, getActivity());
    l();
    return paramLayoutInflater;
  }
  
  private QQGameMsgInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
        return (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      }
    }
    return null;
  }
  
  private List<View> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        localArrayList.add(localView);
        localArrayList.addAll(a(localView));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(View paramView, LinearLayout paramLinearLayout, Context paramContext)
  {
    QQGameUIHelper.a(paramView, paramLinearLayout, paramContext);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_d_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(8);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setUnreadNum(paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
  }
  
  private void b(int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.10(this, paramInt));
  }
  
  private void b(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    if ((paramGmpEnterInfoRsp != null) && (paramGmpEnterInfoRsp.ret_code == 0) && (paramGmpEnterInfoRsp.state == 1) && (paramBoolean))
    {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.8(this, paramGmpEnterInfoRsp));
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
      localHashMap.put(Integer.valueOf(24), a());
      GameCenterUtils.a(CmGameUtil.a(), "770", "207021", "", "77002", "1", "160", localHashMap);
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.9(this, paramGmpEnterInfoRsp));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GamePubAccountHippyFragment", 1, "rec game enter is null");
      return;
      localHashMap.put(Integer.valueOf(3), "2");
    }
  }
  
  private void c(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_c_of_type_JavaUtilList.size())
    {
      if (i == paramInt)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView = ((IHeaderView)this.jdField_c_of_type_JavaUtilList.get(i));
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView instanceof GameArkView)) {
          GameVideoManager.a().a((GameArkView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        GameVideoManager.a().a(null);
        continue;
        IHeaderView localIHeaderView = (IHeaderView)this.jdField_c_of_type_JavaUtilList.get(i);
        if (localIHeaderView != null) {
          localIHeaderView.b();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.a();
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if ((paramInt >= this.jdField_c_of_type_Int) && (this.jdField_c_of_type_Int <= this.jdField_d_of_type_Int) && (paramInt <= this.jdField_d_of_type_Int))
      {
        this.jdField_c_of_type_Int += 1;
        this.jdField_a_of_type_Int = (this.jdField_d_of_type_Int - this.jdField_c_of_type_Int + 1);
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
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_b_of_type_AndroidViewView.findViewById(2131381674));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2 = ((QQGameIndicator2)this.jdField_b_of_type_AndroidViewView.findViewById(2131372707));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout = ((UnreadTipLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370072));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370209));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380687));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377237));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView = ((GameContentView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370118));
    GameVideoManager.a().a(2);
  }
  
  @SuppressLint({"SetTextI18n"})
  private void j()
  {
    this.jdField_b_of_type_Boolean = QQGameConfigUtil.c();
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_Int -= 1;
      this.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setUnreadNum(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.post(new GamePubAccountHippyFragment.1(this));
        localObject = new HashMap();
        ((Map)localObject).put(Integer.valueOf(4), "8");
        ((Map)localObject).put(Integer.valueOf(24), a());
        GameCenterUtils.a(CmGameUtil.a(), "769", "207552", "", "76925", "1", "160", (Map)localObject);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-15090945);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202006/upload_32b6df772edd7f4dd2bf13382f80d356.png", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    localObject = new HashMap();
    ((Map)localObject).put(Integer.valueOf(24), a());
    ((Map)localObject).put(Integer.valueOf(3), "2");
    ((Map)localObject).put(Integer.valueOf(4), "8");
    GameCenterUtils.a(CmGameUtil.a(), "769", "207028", "", "76901", "1", "160", (Map)localObject);
  }
  
  private void k()
  {
    int k = 0;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter = new GamePubAccountHeadAdapter(this.jdField_c_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList, getActivity(), this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setPageListener(this);
    Object localObject1 = null;
    Object localObject2 = null;
    int j = k;
    String str;
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      str = QQGameHelper.a(CmGameUtil.a());
      i = 0;
      localObject1 = localObject2;
    }
    for (;;)
    {
      j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject1 = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject1 != null) && (((QQGameMsgInfo)localObject1).paMsgid != null) && (((QQGameMsgInfo)localObject1).paMsgid.equals(str))) {
          j = i;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(j);
        if ((j != 0) || (localObject1 == null)) {}
      }
      try
      {
        QQGameHelper.a(a()).c("205017").d("76901").a(2, ((QQGameMsgInfo)localObject1).paMsgid).a(3, "0").a(4, "8").b(((QQGameMsgInfo)localObject1).gameAppId).a();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      i += 1;
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setGamePubType(a());
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
    try
    {
      Object localObject = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299166));
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication().getApplicationContext());
      ((LinearLayout.LayoutParams)localObject).setMargins(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setLayoutParams((ViewGroup.LayoutParams)localObject);
      QLog.d("GamePubAccountHippyFragment", 4, "statusBarHeight = " + i);
      localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.findViewById(2131369878);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130848680), getResources().getDrawable(2130848513));
      ((ImageView)localObject).setImageResource(2130851151);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setBackgroundResource(2130846605);
      this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695230);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setOnItemSelectListener(new GamePubAccountHippyFragment.2(this));
      h();
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("GamePubAccountHippyFragment", 4, "set statusBarHeight faile:" + localThrowable.getMessage());
      }
    }
  }
  
  private void m()
  {
    QLog.d("GamePubAccountHippyFragment", 1, "isSetHeadScrollWithHippy=" + this.jdField_c_of_type_Boolean);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    View localView;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = a(this.jdField_a_of_type_AndroidViewViewGroup).iterator();
      }
      localView = (View)localIterator.next();
    } while (!(localView instanceof HippyListView));
    this.jdField_c_of_type_Boolean = true;
    QLog.d("GamePubAccountHippyFragment", 1, "set Head Scrol lWith Hippy");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
    ((HippyListView)localView).setMomentumScrollBeginEventEnable(false);
    ((HippyListView)localView).addOnListScrollListener(new GamePubAccountHippyFragment.6(this, localView));
  }
  
  private void n()
  {
    if (((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new GamePubAccountHippyFragment.14(this));
    }
  }
  
  public String a()
  {
    return "2";
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 102;
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new GamePubAccountHippyFragment.12(this), 0L);
      }
    }
    else {
      return;
    }
    d(paramInt);
    Object localObject = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QQGameHelper.a(CmGameUtil.a(), ((QQGameMsgInfo)localObject).paMsgid);
    HashMap localHashMap = new HashMap();
    GameCenterUtils.a(localHashMap, ((QQGameMsgInfo)localObject).paMsgid);
    localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)localObject).paMsgid);
    localHashMap.put(Integer.valueOf(3), paramInt + "");
    localHashMap.put(Integer.valueOf(4), "8");
    localHashMap.put(Integer.valueOf(24), a());
    GameCenterUtils.a(CmGameUtil.a(), "769", "205017", ((QQGameMsgInfo)localObject).gameAppId, "76901", "1", "160", localHashMap);
    ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, ((QQGameMsgInfo)localObject).paMsgid, "");
    try
    {
      QQGameHelper.a(117, (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
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
  
  public void a(int paramInt, IHeaderView paramIHeaderView)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem())
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView = paramIHeaderView;
      if ((paramIHeaderView instanceof GameArkView))
      {
        ((GameArkView)paramIHeaderView).setPrePause(false);
        GameVideoManager.a().a((GameArkView)paramIHeaderView);
      }
    }
    else
    {
      return;
    }
    GameVideoManager.a().a(null);
  }
  
  void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    b(paramGmpEnterInfoRsp, paramBoolean);
  }
  
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter.getCount() != 1)) {
        break label407;
      }
    }
    label407:
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      this.jdField_c_of_type_Int += paramArrayList.size();
      this.jdField_d_of_type_Int += paramArrayList.size();
      int j = 0;
      if (j < paramArrayList.size())
      {
        this.jdField_a_of_type_JavaUtilList.add(0, paramArrayList.get(j));
        localObject = QQGamePubHeaderFactory.a((QQGameMsgInfo)paramArrayList.get(j), getActivity());
        this.jdField_c_of_type_JavaUtilList.add(0, localObject);
        if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(j)).arkAppName)) {
          this.jdField_b_of_type_JavaUtilList.add(((QQGameMsgInfo)paramArrayList.get(j)).arkAppName);
        }
        int k;
        label170:
        HashMap localHashMap;
        if (i != 0)
        {
          k = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
          b(k);
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)paramArrayList.get(j)).paMsgid);
          localHashMap.put(Integer.valueOf(4), "8");
          localHashMap.put(Integer.valueOf(24), a());
          if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(j)).gameAppId)) {
            break label308;
          }
        }
        label308:
        for (localObject = "";; localObject = ((QQGameMsgInfo)paramArrayList.get(j)).gameAppId)
        {
          GameCenterUtils.a(CmGameUtil.a(), "769", "205030", (String)localObject, "76901", "1", "160", localHashMap);
          j += 1;
          break;
          k = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() + 1;
          break label170;
        }
      }
      paramArrayList = QQGameHelper.a(this.jdField_a_of_type_JavaUtilList).toString();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      Object localObject = new Message();
      ((Message)localObject).what = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) {}
      for (i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();; i = -1)
      {
        ((Message)localObject).arg1 = i;
        ((Message)localObject).arg2 = -1;
        ((Message)localObject).obj = paramArrayList;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        return;
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Int = 3;
    refreshGameContentView();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onHippyFirstScreen");
    QLog.d("GamePubAccountHippyFragment", 1, "--->on HippyFirstScreen");
    if ((paramLong > 0L) && (paramLong > this.jdField_b_of_type_Long)) {
      this.f = (paramLong - this.jdField_b_of_type_Long);
    }
    if (!this.jdField_c_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.17(this));
    }
  }
  
  protected void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)localIterator.next();
      IHeaderView localIHeaderView = QQGamePubHeaderFactory.a(localQQGameMsgInfo, getActivity());
      this.jdField_c_of_type_JavaUtilList.add(localIHeaderView);
      if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
      {
        ArkPubicEventWrap.a().a(localQQGameMsgInfo.arkAppName);
        this.jdField_b_of_type_JavaUtilList.add(localQQGameMsgInfo.arkAppName);
      }
    }
    if ((isAdded()) && (getActivity() != null) && (!getActivity().isFinishing())) {
      this.jdField_c_of_type_JavaUtilList.add(new MoreMsgHeaderView(getActivity()));
    }
  }
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onHippShow");
    QLog.d("GamePubAccountHippyFragment", 1, "--->on hippy show");
    this.g = (paramLong - this.jdField_b_of_type_Long);
    if (!this.jdField_c_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.15(this));
    }
    refreshGameContentView();
    ThreadManagerV2.executeOnSubThread(new GamePubAccountHippyFragment.16(this));
    ((IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
  }
  
  public JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gameData", QQGameHelper.a(this.jdField_a_of_type_JavaUtilList));
        localJSONObject.put("headerHeight", 417);
        if (this.jdField_a_of_type_Int == 0)
        {
          String str = QQGameHelper.a(CmGameUtil.a());
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localQQGameMsgInfo.paMsgid != null) && (localQQGameMsgInfo.paMsgid.equals(str)))
            {
              localJSONObject.put("index", i);
              paramJSONObject.put("GpInitData", localJSONObject);
              if (QLog.isColorLevel()) {
                QLog.d("GamePubAccountHippyFragment", 1, "feedEventJson=" + localJSONObject.toString());
              }
              return paramJSONObject;
            }
            i += 1;
            continue;
          }
        }
        int i = 0;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return paramJSONObject;
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.setUiRefresh(this);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.b();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void h()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), new GamePubAccountHippyFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new GamePubAccountHippyFragment.4(this));
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (paramView.getId() == 2131370072) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) {
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          if (this.jdField_a_of_type_Int < 3) {
            break label71;
          }
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter.getCount());
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label71:
      int j = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if (j + 1 < i) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(j + 1);
      }
      Object localObject1;
      for (;;)
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewUnreadTipLayout.setVisibility(4);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameIndicator2.b();
        }
        localObject1 = new HashMap();
        ((Map)localObject1).put(Integer.valueOf(4), "20");
        ((Map)localObject1).put(Integer.valueOf(24), a());
        GameCenterUtils.a(CmGameUtil.a(), "769", "207553", "", "76925", "1", "160", (Map)localObject1);
        break;
        if (j == i - 1) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i);
        }
      }
      if (paramView.getId() == 2131370209)
      {
        String str = "";
        localObject1 = "";
        Object localObject2 = a();
        if (localObject2 != null)
        {
          str = ((QQGameMsgInfo)localObject2).gameAppId;
          if (TextUtils.isEmpty(((QQGameMsgInfo)localObject2).paMsgid)) {
            localObject1 = "";
          }
        }
        else
        {
          label268:
          localObject2 = new HashMap();
          ((Map)localObject2).put(Integer.valueOf(2), localObject1);
          ((Map)localObject2).put(Integer.valueOf(3), "2");
          ((Map)localObject2).put(Integer.valueOf(4), "20");
          ((Map)localObject2).put(Integer.valueOf(24), a());
          GameCenterUtils.a(CmGameUtil.a(), "769", "205037", str, "76901", "1", "160", (Map)localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager == null) {
            continue;
          }
          if (this.jdField_a_of_type_JavaUtilList != null) {
            break label412;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Int < 3) {
            break label425;
          }
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyViewGamePubAccountHeadAdapter.getCount());
          break;
          localObject1 = ((QQGameMsgInfo)localObject2).paMsgid;
          break label268;
          label412:
          i = this.jdField_a_of_type_JavaUtilList.size();
        }
        label425:
        j = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
        if (j + 1 < i) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(j + 1);
        } else if (j == i - 1) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger = new QQGameTimingLogger("GamePubAccountHippyFragment", "onCreateView");
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    a(getActivity());
    a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("preGetIntentData");
    d();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("setStatusBarImmersive");
    a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initDownload");
    this.jdField_b_of_type_AndroidViewView = a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initView");
    b();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initMessage");
    i();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initHeadView");
    loadHippy(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("loadHippy");
    g();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initGameContentView");
    k();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initViewPager");
    j();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initTipLayout");
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("initViewEnd");
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.c();
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          IHeaderView localIHeaderView = (IHeaderView)localIterator.next();
          if (localIHeaderView != null) {
            localIHeaderView.c();
          }
        }
      }
      GameVideoManager.a().f();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
  }
  
  public void onLoadHippyError(int paramInt, String paramString)
  {
    QLog.d("GamePubAccountHippyFragment", 1, "onLoadHippyError statusCode:" + paramInt + " msg:" + paramString);
    this.jdField_b_of_type_Int = 6;
    super.onLoadHippyError(paramInt, paramString);
    this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    this.g = -1L;
    QLog.d("GamePubAccountHippyFragment", 1, "cilke GamePubAccount to onLoadError:" + this.jdField_d_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onLoadHippyEnd");
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    ThreadManagerV2.executeOnSubThread(new GamePubAccountHippyFragment.7(this, paramInt, paramString));
  }
  
  public void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterHippyQQGameTimingLogger.a("onLoadHippyEnd");
    this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    QLog.d("GamePubAccountHippyFragment", 1, "click GamePubAccount to onLoadSucc:" + this.jdField_d_of_type_Long);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    if (!this.jdField_c_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new GamePubAccountHippyFragment.5(this), 500L);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onResume()
  {
    int i = 0;
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewIHeaderView.a();
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {}
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (i > 0) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem() == i)) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i - 1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a("2747277822", 1008, true, true);
        return;
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void refreshGameContentView()
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.13(this));
  }
  
  public void shrinkGameContentView(long paramLong)
  {
    QQGameUIHelper.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView, this.jdField_c_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment
 * JD-Core Version:    0.7.0.1
 */