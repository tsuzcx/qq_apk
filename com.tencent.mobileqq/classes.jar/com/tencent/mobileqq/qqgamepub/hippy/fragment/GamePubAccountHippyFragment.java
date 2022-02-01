package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadAdapter;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadView;
import com.tencent.mobileqq.qqgamepub.listener.IPageListener;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameTimingLogger;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView.UiRefresh;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GamePubAccountHippyFragment
  extends GamePAHippyBaseFragment
  implements View.OnClickListener, IPageListener, GameContentView.UiRefresh
{
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new GamePubAccountHippyFragment.11(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private GamePubAccountHeadAdapter jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter;
  private GamePubAccountHeadView jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadView;
  private IHeaderView jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
  private NavBarQQGamePub jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub;
  private QQGamePubViewpager jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
  private GameContentView jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
  private QQGameIndicator2 jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2;
  private UnreadTipLayout jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private List<IHeaderView> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int d;
  
  public GamePubAccountHippyFragment()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  private View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559152, null, false);
    a(paramLayoutInflater);
    QQGameUIHelper.a(paramLayoutInflater, this.jdField_b_of_type_AndroidWidgetLinearLayout, getQBaseActivity());
    n();
    return paramLayoutInflater;
  }
  
  private QQGameMsgInfo a()
  {
    QQGamePubViewpager localQQGamePubViewpager = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
    if (localQQGamePubViewpager != null)
    {
      int i = localQQGamePubViewpager.getCurrentItem();
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
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368190));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131376636));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369800));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370350));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadView = ((GamePubAccountHeadView)paramView.findViewById(2131369817));
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setVisibility(0);
      this.jdField_a_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setUnreadNum(paramInt);
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
    localHashMap.put(Integer.valueOf(24), a());
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "770", "207021", "", "77002", "1", "160", localHashMap);
    ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.9(this, paramGmpEnterInfoRsp));
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "rec game enter is null");
    }
  }
  
  private void c(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilList.size())
    {
      if (i == paramInt)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView = ((IHeaderView)this.jdField_c_of_type_JavaUtilList.get(i));
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
        localIHeaderView = (IHeaderView)this.jdField_c_of_type_JavaUtilList.get(i);
        if (localIHeaderView != null) {
          localIHeaderView.b();
        }
      }
      i += 1;
    }
    IHeaderView localIHeaderView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
    if (localIHeaderView != null) {
      localIHeaderView.a();
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      int i = this.jdField_c_of_type_Int;
      if (paramInt >= i)
      {
        int j = this.jdField_d_of_type_Int;
        if ((i <= j) && (paramInt <= j))
        {
          this.jdField_c_of_type_Int = (i + 1);
          this.jdField_a_of_type_Int = (j - this.jdField_c_of_type_Int + 1);
          if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int <= 3))
          {
            a(true, this.jdField_a_of_type_Int);
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
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager = ((QQGamePubViewpager)this.jdField_b_of_type_AndroidViewView.findViewById(2131380909));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2 = ((QQGameIndicator2)this.jdField_b_of_type_AndroidViewView.findViewById(2131372285));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout = ((UnreadTipLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369750));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369878));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379961));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376695));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView = ((GameContentView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369795));
    GameVideoManager.a().a(2);
  }
  
  @SuppressLint({"SetTextI18n"})
  private void l()
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_Int -= 1;
      this.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setUnreadNum(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.post(new GamePubAccountHippyFragment.1(this));
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), a());
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "207552", "", "76925", "1", "160", localHashMap);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter = new GamePubAccountHeadAdapter(this.jdField_c_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList, getQBaseActivity(), this);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setViewPager(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.a();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setPageListener(this);
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      localObject = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    } else {
      localObject = null;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      String str = GamePubAccountHelper.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localQQGameMsgInfo != null) && (localQQGameMsgInfo.paMsgid != null) && (localQQGameMsgInfo.paMsgid.equals(str)))
        {
          localObject = localQQGameMsgInfo;
          break label192;
        }
        i += 1;
      }
    }
    int i = 0;
    label192:
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(i);
    if ((i == 0) && (localObject != null)) {
      try
      {
        GamePubAccountHelper.a(a()).c("205017").d("76901").a(2, ((QQGameMsgInfo)localObject).paMsgid).a(3, "0").a(4, "8").b(((QQGameMsgInfo)localObject).gameAppId).a();
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(117, (QQGameMsgInfo)localObject, 0);
        localObject = (IHeaderView)this.jdField_c_of_type_JavaUtilList.get(i);
        if ((localObject instanceof GameArkView))
        {
          ((GameArkView)localObject).e();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
      }
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setGamePubType(a());
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.a();
    try
    {
      Object localObject1 = new LinearLayout.LayoutParams(-1, (int)getResources().getDimension(2131299168));
      int i = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("statusBarHeight = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("QQGamePub_GamePubAccountHippyFragment", 4, ((StringBuilder)localObject1).toString());
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set statusBarHeight faile:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.d("QQGamePub_GamePubAccountHippyFragment", 4, localStringBuilder.toString());
    }
    Object localObject2 = (ImageView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.findViewById(2131369563);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130848559), getResources().getDrawable(2130848392));
    ((ImageView)localObject2).setImageResource(2130851067);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setBackgroundResource(2130846485);
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695226);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub.setOnItemSelectListener(new GamePubAccountHippyFragment.2(this));
    j();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewNavBarQQGamePub;
    if (localObject2 != null) {
      ((NavBarQQGamePub)localObject2).a();
    }
  }
  
  private void o()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isSetHeadScrollWithHippy=");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = a((View)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (View)((Iterator)localObject2).next();
      if ((localObject1 instanceof HippyListView))
      {
        this.jdField_b_of_type_Boolean = true;
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "set Head Scrol lWith Hippy");
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
        localObject2 = (HippyListView)localObject1;
        ((HippyListView)localObject2).setMomentumScrollBeginEventEnable(false);
        ((HippyListView)localObject2).addOnListScrollListener(new GamePubAccountHippyFragment.6(this, (View)localObject1));
      }
    }
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4))
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null) {
        localRelativeLayout.post(new GamePubAccountHippyFragment.14(this));
      }
    }
  }
  
  public String a()
  {
    return "2";
  }
  
  public void a(int paramInt)
  {
    Object localObject;
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
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new GamePubAccountHippyFragment.12(this), 0L);
        return;
      }
      d(paramInt);
      localObject = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      GamePubAccountHelper.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), ((QQGameMsgInfo)localObject).paMsgid);
      HashMap localHashMap = new HashMap();
      GameCenterUtils.a(localHashMap, ((QQGameMsgInfo)localObject).paMsgid);
      localHashMap.put(Integer.valueOf(2), ((QQGameMsgInfo)localObject).paMsgid);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localHashMap.put(Integer.valueOf(3), localStringBuilder.toString());
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), a());
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205017", ((QQGameMsgInfo)localObject).gameAppId, "76901", "1", "160", localHashMap);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(2, ((QQGameMsgInfo)localObject).paMsgid, "");
      try
      {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(117, (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
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
  
  public void a(int paramInt, IHeaderView paramIHeaderView)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView = paramIHeaderView;
      if ((paramIHeaderView instanceof GameArkView))
      {
        paramIHeaderView = (GameArkView)paramIHeaderView;
        paramIHeaderView.setPrePause(false);
        GameVideoManager.a().a(paramIHeaderView);
        return;
      }
      GameVideoManager.a().a(null);
    }
  }
  
  public void a(long paramLong)
  {
    QQGameUIHelper.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView, this.jdField_c_of_type_AndroidViewView);
  }
  
  void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean)
  {
    b(paramGmpEnterInfoRsp, paramBoolean);
  }
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippy,call handleAdReverseFeedBack arkViewId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject).toString());
      int i = 0;
      a(false, 0);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramString.equals(String.valueOf(((QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq))) {
            break label110;
          }
          i += 1;
        }
        i = -1;
        label110:
        if ((i > -1) && (i < this.jdField_c_of_type_JavaUtilList.size()))
        {
          paramString = (IHeaderView)this.jdField_c_of_type_JavaUtilList.get(i);
          if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
            if (localObject != null)
            {
              int k = ((QQGamePubViewpager)localObject).getCurrentItem();
              int j = k;
              if (k == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                j = k - 1;
              }
              this.jdField_c_of_type_JavaUtilList.remove(paramString);
              this.jdField_a_of_type_JavaUtilList.remove(i);
              b(j);
              a(2, j, -1, GamePubAccountHelper.a(this.jdField_a_of_type_JavaUtilList).toString());
              a(1, j, -1, "");
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.13(this));
  }
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Int = 3;
    b();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onHippyFirstScreen");
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "--->on HippyFirstScreen");
    if ((paramLong > 0L) && (paramLong > this.jdField_b_of_type_Long)) {
      this.f = (paramLong - this.jdField_b_of_type_Long);
    }
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.17(this));
    }
  }
  
  public void c(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter;
      int i;
      if ((localObject1 != null) && (((GamePubAccountHeadAdapter)localObject1).getCount() == 1)) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      this.jdField_c_of_type_Int += paramArrayList.size();
      this.jdField_d_of_type_Int += paramArrayList.size();
      int j = 0;
      while (j < paramArrayList.size())
      {
        this.jdField_a_of_type_JavaUtilList.add(0, paramArrayList.get(j));
        localObject1 = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)paramArrayList.get(j), getQBaseActivity());
        this.jdField_c_of_type_JavaUtilList.add(0, localObject1);
        if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(j)).arkAppName)) {
          this.jdField_b_of_type_JavaUtilList.add(((QQGameMsgInfo)paramArrayList.get(j)).arkAppName);
        }
        int k;
        if (i != 0) {
          k = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem();
        } else {
          k = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem() + 1;
        }
        b(k);
        localObject2 = new HashMap();
        ((Map)localObject2).put(Integer.valueOf(2), ((QQGameMsgInfo)paramArrayList.get(j)).paMsgid);
        ((Map)localObject2).put(Integer.valueOf(4), "8");
        ((Map)localObject2).put(Integer.valueOf(24), a());
        if (TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(j)).gameAppId)) {
          localObject1 = "";
        } else {
          localObject1 = ((QQGameMsgInfo)paramArrayList.get(j)).gameAppId;
        }
        GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205030", (String)localObject1, "76901", "1", "160", (Map)localObject2);
        j += 1;
      }
      paramArrayList = GamePubAccountHelper.a(this.jdField_a_of_type_JavaUtilList).toString();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      localObject1 = new Message();
      ((Message)localObject1).what = 2;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager;
      if (localObject2 != null) {
        i = ((QQGamePubViewpager)localObject2).getCurrentItem();
      } else {
        i = -1;
      }
      ((Message)localObject1).arg1 = i;
      ((Message)localObject1).arg2 = -1;
      ((Message)localObject1).obj = paramArrayList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    }
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onHippShow");
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "--->on hippy show");
    this.g = (paramLong - this.jdField_b_of_type_Long);
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountHippyFragment.15(this));
    }
    b();
    ThreadManagerV2.executeOnSubThread(new GamePubAccountHippyFragment.16(this));
    ((IWebProcessManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
  }
  
  protected JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gameData", GamePubAccountHelper.a(this.jdField_a_of_type_JavaUtilList));
        localJSONObject.put("headerHeight", 417);
        i = this.jdField_a_of_type_Int;
        int k = 0;
        int j = k;
        Object localObject;
        if (i == 0)
        {
          localObject = GamePubAccountHelper.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
          i = 0;
          j = k;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localQQGameMsgInfo.paMsgid == null) || (!localQQGameMsgInfo.paMsgid.equals(localObject))) {
              break label212;
            }
            j = i;
          }
        }
        localJSONObject.put("index", j);
        paramJSONObject.put("GpInitData", localJSONObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("feedEventJson=");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject).toString());
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return paramJSONObject;
      label212:
      i += 1;
    }
  }
  
  protected void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (QQGameMsgInfo)localIterator.next();
      localObject = ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader((QQGameMsgInfo)localObject, getActivity());
      this.jdField_c_of_type_JavaUtilList.add(localObject);
    }
    if ((isAdded()) && (getActivity() != null) && (!getActivity().isFinishing())) {
      this.jdField_c_of_type_JavaUtilList.add(new MoreMsgHeaderView(getActivity()));
    }
  }
  
  public void i()
  {
    GameContentView localGameContentView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView;
    if (localGameContentView != null)
    {
      localGameContentView.setUiRefresh(this);
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.b();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void j()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getQBaseActivity(), new GamePubAccountHippyFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new GamePubAccountHippyFragment.4(this));
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Integer localInteger1 = Integer.valueOf(24);
    int i = 0;
    Integer localInteger2 = Integer.valueOf(4);
    int k;
    Object localObject1;
    if (j == 2131369750)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager != null)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          i = 0;
        } else {
          i = this.jdField_a_of_type_JavaUtilList.size();
        }
        if (this.jdField_a_of_type_Int >= 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter.getCount());
          break label494;
        }
        j = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem();
        k = j + 1;
        if (k < i) {
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(k);
        } else if (j == i - 1) {
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(i);
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewUnreadTipLayout.setVisibility(4);
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGameIndicator2.b();
        }
      }
      localObject1 = new HashMap();
      ((Map)localObject1).put(localInteger2, "20");
      ((Map)localObject1).put(localInteger1, a());
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "207553", "", "76925", "1", "160", (Map)localObject1);
    }
    else if (paramView.getId() == 2131369878)
    {
      Object localObject2 = a();
      localObject1 = "";
      String str;
      if (localObject2 != null)
      {
        str = ((QQGameMsgInfo)localObject2).gameAppId;
        if (!TextUtils.isEmpty(((QQGameMsgInfo)localObject2).paMsgid)) {
          localObject1 = ((QQGameMsgInfo)localObject2).paMsgid;
        }
      }
      else
      {
        str = "";
      }
      localObject2 = new HashMap();
      ((Map)localObject2).put(Integer.valueOf(2), localObject1);
      ((Map)localObject2).put(Integer.valueOf(3), "2");
      ((Map)localObject2).put(localInteger2, "20");
      ((Map)localObject2).put(localInteger1, a());
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205037", str, "76901", "1", "160", (Map)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager != null)
      {
        if (this.jdField_a_of_type_JavaUtilList != null) {
          i = this.jdField_a_of_type_JavaUtilList.size();
        }
        if (this.jdField_a_of_type_Int >= 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyViewGamePubAccountHeadAdapter.getCount());
        }
        else
        {
          j = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem();
          k = j + 1;
          if (k < i) {
            this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(k);
          } else if (j == i - 1) {
            this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(i);
          }
        }
      }
    }
    label494:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidViewView = a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initView");
    k();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initHeadView");
    loadHippy(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("loadHippy");
    i();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initGameContentView");
    m();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initViewPager");
    l();
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initTipLayout");
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("initViewEnd");
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView != null) {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewGameContentView.c();
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
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
    }
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadHippyError statusCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_Int = 6;
    super.onLoadHippyError(paramInt, paramString);
    this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    this.g = -1L;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cilke GamePubAccount to onLoadError:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onLoadHippyEnd");
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      LinearLayout localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout != null) {
        ((RelativeLayout)localObject).removeView(localLinearLayout);
      }
    }
    ThreadManagerV2.executeOnSubThread(new GamePubAccountHippyFragment.7(this, paramInt, paramString));
  }
  
  protected void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameTimingLogger.a("onLoadHippyEnd");
    this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("click GamePubAccount to onLoadSucc:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      LinearLayout localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout != null) {
        ((RelativeLayout)localObject).removeView(localLinearLayout);
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new GamePubAccountHippyFragment.5(this), 500L);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        ((IGameMsgManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView instanceof GameArkView))
      {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView.b();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    IHeaderView localIHeaderView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewIHeaderView;
    if (localIHeaderView != null) {
      localIHeaderView.a();
    }
    try
    {
      int i;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        i = 0;
      } else {
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager != null) && (i > 0) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.getCurrentItem() == i)) {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewQQGamePubViewpager.setCurrentItem(i - 1);
      }
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment
 * JD-Core Version:    0.7.0.1
 */