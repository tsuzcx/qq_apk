package com.tencent.mobileqq.troop.troopapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.App;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.PlayingUser;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.RspBody;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.Tag;

public class TroopAppShortcutContainer
  extends BroadcastReceiver
  implements View.OnClickListener
{
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  public Context a;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private View jdField_a_of_type_AndroidViewView;
  public SessionInfo a;
  public BaseActivity a;
  public QQAppInterface a;
  private TroopShortcutBarObserver jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = new TroopAppShortcutContainer.3(this);
  private ShortcutBarGuideDialog jdField_a_of_type_ComTencentMobileqqTroopTroopappsShortcutBarGuideDialog = null;
  protected TroopAppShortcutContainer.AppsListViewAdapter a;
  private TroopAppShortcutContainer.LoadingInfo jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo = new TroopAppShortcutContainer.LoadingInfo();
  protected ITroopAppHandler a;
  protected TroopAppObserver a;
  protected ListView a;
  private Long jdField_a_of_type_JavaLangLong;
  private boolean jdField_a_of_type_Boolean = false;
  protected int b;
  private long b;
  protected int c;
  private long c;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private int e;
  
  public TroopAppShortcutContainer(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    this.jdField_e_of_type_Int = 2147483647;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver = new TroopAppShortcutContainer.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramString).longValue();
    }
    catch (Exception paramSessionInfo)
    {
      label128:
      Object localObject;
      TextView localTextView;
      ImageView localImageView;
      int i;
      break label128;
    }
    this.jdField_a_of_type_Long = 0L;
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("TroopAppShortcutContainer troopuinerror:");
    paramSessionInfo.append(paramString);
    QLog.e("TroopAppShortcutContainer", 2, paramSessionInfo.toString());
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559854, null);
    paramSessionInfo = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376828);
    paramString = this.jdField_a_of_type_AndroidViewView.findViewById(2131378886);
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363340);
    localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379933);
    ((TextView)localObject).setOnClickListener(this);
    TroopAppShortcutUtils.a((View)localObject);
    localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370831);
    localImageView.setOnClickListener(this);
    TroopAppShortcutUtils.a(localImageView);
    if (AppSetting.d)
    {
      localTextView.setFocusableInTouchMode(true);
      localTextView.setContentDescription(paramContext.getString(2131719777));
      ((TextView)localObject).setClickable(true);
      ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131707032));
      localImageView.setClickable(true);
      localImageView.setContentDescription(paramContext.getString(2131699565));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = (RelativeLayout.LayoutParams)paramString.getLayoutParams();
      i = ImmersiveUtils.getStatusBarHeight(paramContext);
      paramInt = i;
      if (c()) {
        paramInt = i - AIOUtils.b(10.0F, paramString.getResources());
      }
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, paramInt, 0, 0);
      paramString.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ImmersiveUtils.setStatusBarDarkMode(paramBaseActivity.getWindow(), true);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramSessionInfo.setBackgroundDrawable(paramBaseActivity.getResources().getDrawable(2130840528));
      localImageView.setColorFilter(2013265919, PorterDuff.Mode.SRC_ATOP);
      localTextView.setTextColor(Color.parseColor("#ffffff"));
    }
    else
    {
      paramBaseActivity = URLDrawable.URLDrawableOptions.obtain();
      paramContext = new ColorDrawable();
      paramContext.setColor(Color.parseColor("#EBEDF5"));
      paramBaseActivity.mRequestWidth = ViewUtils.a();
      paramBaseActivity.mRequestHeight = ViewUtils.b();
      paramBaseActivity.mFailedDrawable = paramContext;
      paramBaseActivity.mLoadingDrawable = paramContext;
      paramBaseActivity = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200324170329_vqFCVSqE3E.png", paramBaseActivity);
      if (paramBaseActivity.getStatus() == 2) {
        paramBaseActivity.restartDownload();
      }
      paramBaseActivity.setDecodeHandler(URLDrawableDecodeHandler.x);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopAppHandler = ((ITroopAppHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a();
    m();
    l();
    n();
  }
  
  private TroopAppShortcutContainer a()
  {
    return this;
  }
  
  private ArrayList<TroopAppShortcutContainer.TroopAppInfo> a(ArrayList<oidb_0xe2e.App> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject1 = (oidb_0xe2e.App)paramArrayList.get(i);
        Object localObject2;
        if ((((oidb_0xe2e.App)localObject1).appid.has()) && (((oidb_0xe2e.App)localObject1).icon.has()) && (((oidb_0xe2e.App)localObject1).name.has()) && (((oidb_0xe2e.App)localObject1).url.has()))
        {
          localObject2 = new TroopAppShortcutContainer.TroopAppInfo();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_Long = ((oidb_0xe2e.App)localObject1).appid.get();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString = ((oidb_0xe2e.App)localObject1).name.get();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_c_of_type_JavaLangString = ((oidb_0xe2e.App)localObject1).url.get();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_JavaLangString = ((oidb_0xe2e.App)localObject1).icon.get();
          if (((oidb_0xe2e.App)localObject1).type.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Long = ((oidb_0xe2e.App)localObject1).type.get();
          }
          if (((oidb_0xe2e.App)localObject1).removable.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_Int = ((oidb_0xe2e.App)localObject1).removable.get();
          }
          if (((oidb_0xe2e.App)localObject1).source.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_c_of_type_Int = ((oidb_0xe2e.App)localObject1).source.get();
          }
          if (((oidb_0xe2e.App)localObject1).desc.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_d_of_type_JavaLangString = ((oidb_0xe2e.App)localObject1).desc.get();
          }
          int j;
          if (((oidb_0xe2e.App)localObject1).added.has())
          {
            j = ((oidb_0xe2e.App)localObject1).added.get();
            boolean bool = true;
            if (j != 1) {
              bool = false;
            }
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Boolean = bool;
          }
          if (((oidb_0xe2e.App)localObject1).redpoint.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_d_of_type_Int = ((oidb_0xe2e.App)localObject1).redpoint.get();
          }
          if (((oidb_0xe2e.App)localObject1).cmd_trace.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_e_of_type_JavaLangString = ((oidb_0xe2e.App)localObject1).cmd_trace.get();
          }
          if (((oidb_0xe2e.App)localObject1).show_frame.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_e_of_type_Int = ((oidb_0xe2e.App)localObject1).show_frame.get();
          }
          if (((oidb_0xe2e.App)localObject1).playing_num.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).f = ((oidb_0xe2e.App)localObject1).playing_num.get();
          }
          if (((oidb_0xe2e.App)localObject1).qq_friend_playing_num.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).g = ((oidb_0xe2e.App)localObject1).qq_friend_playing_num.get();
          }
          if (((oidb_0xe2e.App)localObject1).total_playing_num.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).h = ((oidb_0xe2e.App)localObject1).total_playing_num.get();
          }
          Object localObject3;
          if (((oidb_0xe2e.App)localObject1).playing_users.has())
          {
            if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaUtilList == null) {
              ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
            }
            j = 0;
            while (j < ((oidb_0xe2e.App)localObject1).playing_users.size())
            {
              localObject3 = (oidb_0xe2e.PlayingUser)((oidb_0xe2e.App)localObject1).playing_users.get(j);
              if (((oidb_0xe2e.PlayingUser)localObject3).uin.has()) {
                ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaUtilList.add(String.valueOf(((oidb_0xe2e.PlayingUser)localObject3).uin.get()));
              }
              j += 1;
            }
          }
          if (((oidb_0xe2e.App)localObject1).tags.has())
          {
            if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_JavaUtilList == null) {
              ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_JavaUtilList = new ArrayList();
            }
            j = 0;
            while (j < ((oidb_0xe2e.App)localObject1).tags.size())
            {
              localObject3 = (oidb_0xe2e.Tag)((oidb_0xe2e.App)localObject1).tags.get(j);
              if ((((oidb_0xe2e.Tag)localObject3).name.has()) && (!((oidb_0xe2e.Tag)localObject3).name.get().isEmpty())) {
                ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_JavaUtilList.add(((oidb_0xe2e.Tag)localObject3).name.get());
              }
              j += 1;
            }
          }
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Int = 0;
          localArrayList.add(localObject2);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("info:");
            ((StringBuilder)localObject1).append(((TroopAppShortcutContainer.TroopAppInfo)localObject2).toString());
            QLog.d("TroopAppShortcutContainer", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get appinfo error:");
          ((StringBuilder)localObject2).append(localObject1.toString());
          QLog.e("TroopAppShortcutContainer", 2, ((StringBuilder)localObject2).toString());
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reqGetShortcutTroopApps troopuin:");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append(" dwGroupClassExt");
          localStringBuilder.append(((TroopInfo)localObject).dwGroupClassExt);
          localStringBuilder.append(" page:");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append(" from:");
          localStringBuilder.append(paramInt3);
          QLog.d("TroopAppShortcutContainer", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopAppHandler.a(this.jdField_a_of_type_Long, (int)((TroopInfo)localObject).dwGroupClassExt, paramInt1, paramInt2, paramInt3);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a();
        return;
      }
      QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
    }
  }
  
  private void a(ArrayList<TroopAppShortcutContainer.TroopAppInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      long l1 = this.jdField_a_of_type_Long;
      long l2 = this.jdField_b_of_type_Long;
      long l3 = ((TroopAppShortcutContainer.TroopAppInfo)paramArrayList.get(i)).jdField_b_of_type_Long;
      int j = this.jdField_a_of_type_Int;
      String str;
      if (((TroopAppShortcutContainer.TroopAppInfo)paramArrayList.get(i)).jdField_a_of_type_Long == 0L) {
        str = "1";
      } else {
        str = "2";
      }
      ReportController.b(null, "dc00898", "", String.valueOf(l1), "0X800AFBA", "0X800AFBA", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(j), str);
      i += 1;
    }
  }
  
  private void a(oidb_0xe2e.RspBody paramRspBody)
  {
    Object localObject = a((ArrayList)paramRspBody.get_apps.get());
    if (localObject != null)
    {
      TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localTroopAppShortcutMgr != null) {
        localTroopAppShortcutMgr.a(this.jdField_a_of_type_Long, (ArrayList)localObject);
      }
      e();
      a((ArrayList)localObject);
    }
    if (paramRspBody.max_app_num.has()) {
      this.jdField_d_of_type_Int = paramRspBody.max_app_num.get();
    }
    boolean bool2 = paramRspBody.reach_tail.has();
    boolean bool1 = true;
    if (bool2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a(1);
      if (paramRspBody.reach_tail.get() != 1) {
        bool1 = false;
      }
      ((TroopAppShortcutContainer.LoadingInfo)localObject).a(bool1).b();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlerGetShortcutTroopApps_home reach_tail:");
        ((StringBuilder)localObject).append(paramRspBody.reach_tail.get());
        QLog.d("TroopAppShortcutContainer", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a(1).a(true).b();
    }
    paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
    if (paramRspBody != null)
    {
      localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null) {
        ((TroopAppShortcutMgr)localObject).b(this.jdField_a_of_type_Long, paramRspBody);
      }
      f();
      if (paramRspBody.size() > 0)
      {
        ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBB", "0X800AFBB", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
        this.jdField_e_of_type_Int = 0;
      }
    }
  }
  
  private void a(oidb_0xe2e.RspBody paramRspBody, int paramInt)
  {
    boolean bool2 = paramRspBody.reach_tail.has();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a(paramInt);
      if (paramRspBody.reach_tail.get() != 1) {
        bool1 = false;
      }
      ((TroopAppShortcutContainer.LoadingInfo)localObject).a(bool1).b();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlerGetShortcutTroopApps_moreRecommend reach_tail:");
        ((StringBuilder)localObject).append(paramRspBody.reach_tail.get());
        QLog.d("TroopAppShortcutContainer", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a(paramInt).a(true).b();
    }
    paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
    if (paramRspBody != null)
    {
      localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ArrayList localArrayList = ((TroopAppShortcutMgr)localObject).b(this.jdField_a_of_type_Long);
        if (localArrayList == null) {
          ((TroopAppShortcutMgr)localObject).b(this.jdField_a_of_type_Long, paramRspBody);
        } else {
          localArrayList.addAll(paramRspBody);
        }
      }
      f();
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt)
  {
    if (paramObject1 == null) {
      return;
    }
    if (!(paramObject1 instanceof Bundle)) {
      return;
    }
    Object localObject = (Bundle)paramObject1;
    paramObject1 = (oidb_0xe2e.RspBody)paramObject2;
    long l = ((Bundle)localObject).getLong("troopuin", 0L);
    int i = ((Bundle)localObject).getInt("from", -1);
    int j = ((Bundle)localObject).getInt("page", -1);
    if (l != this.jdField_a_of_type_Long)
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("handlerGetShortcutTroopApps troopUin note same mTroopUin:");
      paramObject1.append(this.jdField_a_of_type_Long);
      paramObject1.append(" troopUin:");
      paramObject1.append(l);
      QLog.d("TroopAppShortcutContainer", 2, paramObject1.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerGetShortcutTroopApps troopuin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" page:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" from:");
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopAppShortcutContainer", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramObject2 == null) || (!(paramObject2 instanceof oidb_0xe2e.RspBody)))
    {
      QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps infos not instanceof oidb_0xe2e.RspBody");
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (i == 1)
      {
        a(paramObject1);
        return;
      }
      if (i == 2)
      {
        a(paramObject1, j);
        return;
      }
      if (i == 3) {
        b(paramObject1);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.b();
      paramObject1 = new StringBuilder();
      paramObject1.append("reqGetShortcutTroopApps faild troopUin:");
      paramObject1.append(this.jdField_a_of_type_Long);
      paramObject1.append(" errCode:");
      paramObject1.append(paramInt);
      paramObject1.append(" from:");
      paramObject1.append(i);
      QLog.e("TroopAppShortcutContainer", 2, paramObject1.toString());
      if (paramInt == 1002)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699566), 0).a();
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699568), 0).a();
    }
  }
  
  private void b(oidb_0xe2e.RspBody paramRspBody)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.b();
    paramRspBody = a((ArrayList)paramRspBody.get_apps.get());
    if (paramRspBody != null)
    {
      Object localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ((TroopAppShortcutMgr)localObject).a(this.jdField_a_of_type_Long, paramRspBody);
        localObject = ((TroopAppShortcutMgr)localObject).b(this.jdField_a_of_type_Long);
        int i = 0;
        if (localObject != null)
        {
          int j = 0;
          i = 0;
          while (j < ((ArrayList)localObject).size())
          {
            TroopAppShortcutContainer.TroopAppInfo localTroopAppInfo = (TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(j);
            if (paramRspBody.contains(localTroopAppInfo))
            {
              if (localTroopAppInfo.jdField_a_of_type_Boolean) {
                break label141;
              }
              localTroopAppInfo.jdField_a_of_type_Boolean = true;
            }
            else
            {
              if (!localTroopAppInfo.jdField_a_of_type_Boolean) {
                break label141;
              }
              localTroopAppInfo.jdField_a_of_type_Boolean = false;
            }
            i = 1;
            label141:
            j += 1;
          }
        }
        e();
        a(paramRspBody);
        if (i != 0) {
          f();
        }
      }
    }
  }
  
  private boolean b()
  {
    TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localTroopAppShortcutMgr != null) {
      return localTroopAppShortcutMgr.a();
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    int i = this.jdField_e_of_type_Int;
    if (paramInt <= i) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter == null) {
      return;
    }
    while (i < paramInt)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(i);
      if ((localObject != null) && ((localObject instanceof AppsRecommendViewBuilder)))
      {
        localObject = ((AppsBaseBuilder)localObject).a();
        if (localObject != null)
        {
          if (!(localObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
            return;
          }
          localObject = (TroopAppShortcutContainer.TroopAppInfo)localObject;
          ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBC", "0X800AFBC", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(((TroopAppShortcutContainer.TroopAppInfo)localObject).jdField_b_of_type_Long), "", ((TroopAppShortcutContainer.TroopAppInfo)localObject).jdField_e_of_type_JavaLangString);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      return;
    }
    this.jdField_e_of_type_Int = paramInt;
  }
  
  private boolean c()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
    p();
    d();
  }
  
  private void k()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localTroopAppShortcutMgr != null)
    {
      ArrayList localArrayList1 = localTroopAppShortcutMgr.b(this.jdField_a_of_type_Long);
      if ((localArrayList1 != null) && (localArrayList1.size() > 10))
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.addAll(localArrayList1.subList(0, 10));
        localTroopAppShortcutMgr.b(this.jdField_a_of_type_Long, localArrayList2);
      }
    }
    i();
    q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    r();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362875));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter = new TroopAppShortcutContainer.AppsListViewAdapter(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new TroopAppShortcutContainer.2(this));
  }
  
  private void m()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).c(String.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null) {
        this.jdField_b_of_type_Long = ((TroopInfo)localObject).dwGroupClassExt;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.clear();
    this.jdField_a_of_type_AndroidOsBundle.putLong("troopUin", this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidOsBundle.putLong("troopClassExt", this.jdField_b_of_type_Long);
    this.jdField_a_of_type_AndroidOsBundle.putInt("reportFrom", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isNight", ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isAdminOrOwner", TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void n()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131370831);
      if (TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) {
        ((ImageView)localObject).setVisibility(0);
      } else {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    e();
    f();
  }
  
  private void o()
  {
    a(true);
    Object localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject != null) {
      localObject = ((TroopAppShortcutMgr)localObject).a(this.jdField_a_of_type_Long);
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if (localObject != null)
    {
      int k = ((ArrayList)localObject).size();
      int j;
      for (int i = 0; i < k; i = j)
      {
        localStringBuilder.append(((TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(i)).jdField_b_of_type_Long);
        localStringBuilder.append("-");
        j = i + 1;
        localStringBuilder.append(j);
        if (i != k - 1) {
          localStringBuilder.append(";");
        }
      }
    }
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC9", "0X800AFC9", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", localStringBuilder.toString(), "");
  }
  
  private void p()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    QLog.e("TroopAppShortcutContainer", 1, "registerMiniAppAdd exception.");
  }
  
  private void q()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    QLog.e("TroopAppShortcutContainer", 1, "unregisterMiniAppAdd exception.");
  }
  
  private void r()
  {
    long l1 = this.jdField_d_of_type_Long;
    if (l1 != 0L)
    {
      long l2 = this.jdField_c_of_type_Long;
      if ((l2 != 0L) && (l1 > l2)) {
        ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B23B", "0X800B23B", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_c_of_type_Int), String.valueOf(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long));
      }
    }
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 1;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    j();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 20006) || (paramInt1 == 20007)) {
      a(1, 0, 3);
    }
    this.jdField_b_of_type_Int = 5;
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_b_of_type_Int), "");
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    a(true);
    return false;
  }
  
  public void b()
  {
    b(1);
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_b_of_type_Int), "");
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter != null)
    {
      Object localObject1 = null;
      Object localObject2 = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject2 != null) {
        localObject1 = ((TroopAppShortcutMgr)localObject2).a(this.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = new AppsAioShortCutViewBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this, this.jdField_a_of_type_AndroidOsBundle);
        localObject2 = new AppsAioShortCutViewBuilder.AioShortCutInfo();
        Object localObject3 = ((TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localObject3 != null)
        {
          ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarInfo = ((TroopShortcutBarInfo)localObject3);
          ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b = TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
          boolean bool;
          if (((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b)
          {
            if (((TroopShortcutBarInfo)localObject3).b() == 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).jdField_a_of_type_Boolean = bool;
          }
          else
          {
            if (((TroopShortcutBarInfo)localObject3).a() == 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).jdField_a_of_type_Boolean = bool;
          }
          TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2, this.jdField_a_of_type_Long);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("info.bAdmin :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b);
            ((StringBuilder)localObject3).append("info.bSwith :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).jdField_a_of_type_Boolean);
            ((StringBuilder)localObject3).append("info.bAdminShowSwitch :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).c);
            ((StringBuilder)localObject3).append("info.bMemberShowSwitch :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).d);
            ((StringBuilder)localObject3).append("TroopUin: ");
            ((StringBuilder)localObject3).append(String.valueOf(this.jdField_a_of_type_Long));
            QLog.e("TroopAppShortcutContainer", 2, new Object[] { "updateUI_aioShortCut", ((StringBuilder)localObject3).toString() });
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateUI_aioShortCut. troopShortcutBarInfo is null, TroopUin: ");
          ((StringBuilder)localObject3).append(String.valueOf(this.jdField_a_of_type_Long));
          QLog.e("TroopAppShortcutContainer", 2, ((StringBuilder)localObject3).toString());
        }
        ((AppsBaseBuilder)localObject1).a_(localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(0, (AppsBaseBuilder)localObject1);
        if ((paramInt == 1) && (!((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b) && (((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).d) && (((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarInfo.b() == 0)) {
          ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC0", "0X800AFC0", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(0, new ArrayList());
      }
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Int = 2147483647;
    if (this.jdField_a_of_type_Int == 1)
    {
      ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
      if (localListView != null) {
        localListView.smoothScrollToPosition(0);
      }
    }
    k();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$LoadingInfo.a();
    m();
    if (b())
    {
      a(1, 30, 1);
      return;
    }
    a(1, 0, 1);
  }
  
  protected void e()
  {
    b(2);
    Object localObject = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject != null) {
      localObject = ((TroopAppShortcutMgr)localObject).a(this.jdField_a_of_type_Long);
    } else {
      localObject = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter != null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject);
        localObject = new AppsGridViewBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidOsBundle);
        ((AppsBaseBuilder)localObject).a_(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(1, (AppsBaseBuilder)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(1, new ArrayList());
    }
  }
  
  protected void f()
  {
    if (!b())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter;
      if (localObject1 != null)
      {
        ((TroopAppShortcutContainer.AppsListViewAdapter)localObject1).a(2, new ArrayList());
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(3, new ArrayList());
      }
      return;
    }
    Object localObject1 = null;
    Object localObject2 = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject2 != null) {
      localObject1 = ((TroopAppShortcutMgr)localObject2).b(this.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter != null)
    {
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = new AppsSearchViewBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(2, (AppsBaseBuilder)localObject2);
        localObject2 = new ArrayList();
        int i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          AppsRecommendViewBuilder localAppsRecommendViewBuilder = new AppsRecommendViewBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this, this.jdField_a_of_type_AndroidOsBundle);
          localAppsRecommendViewBuilder.a_(((ArrayList)localObject1).get(i));
          ((List)localObject2).add(localAppsRecommendViewBuilder);
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(3, (List)localObject2);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(2, new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(3, new ArrayList());
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "onDestroy");
    }
    TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localTroopAppShortcutMgr != null) {
      localTroopAppShortcutMgr.a();
    }
    k();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsShortcutBarGuideDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsShortcutBarGuideDialog = new ShortcutBarGuideDialog(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsShortcutBarGuideDialog.show();
  }
  
  public void i()
  {
    ShortcutBarGuideDialog localShortcutBarGuideDialog = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsShortcutBarGuideDialog;
    if (localShortcutBarGuideDialog != null)
    {
      localShortcutBarGuideDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsShortcutBarGuideDialog = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if ((localLong == null) || (l - localLong.longValue() >= 500L))
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      int i = paramView.getId();
      if (i != 2131363340)
      {
        if (i == 2131370831) {
          TroopAppShortcutUtils.a(1, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
      }
      else {
        o();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.addgroupapplication".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("groupUin");
      paramIntent = paramIntent.getStringExtra("appId");
      if (!TextUtils.isEmpty(paramContext))
      {
        if (TextUtils.isEmpty(paramIntent)) {
          return;
        }
        if (!paramContext.equals(String.valueOf(this.jdField_a_of_type_Long))) {
          return;
        }
        a(1, 0, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer
 * JD-Core Version:    0.7.0.1
 */