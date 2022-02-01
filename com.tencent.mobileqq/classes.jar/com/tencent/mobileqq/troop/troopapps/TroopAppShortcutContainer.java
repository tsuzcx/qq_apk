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
  private long a = 0L;
  public QQAppInterface b;
  public BaseActivity c;
  public Context d;
  public SessionInfo e;
  protected int f;
  protected int g;
  protected int h;
  protected ITroopAppHandler i;
  protected TroopAppShortcutContainer.AppsListViewAdapter j;
  protected ListView k;
  protected TroopAppObserver l = new TroopAppShortcutContainer.1(this);
  private long m;
  private View n;
  private Long o;
  private boolean p = false;
  private TroopAppShortcutContainer.LoadingInfo q = new TroopAppShortcutContainer.LoadingInfo();
  private Bundle r = new Bundle();
  private int s = 0;
  private int t = 2147483647;
  private ShortcutBarGuideDialog u = null;
  private long v;
  private long w;
  private TroopShortcutBarObserver x = new TroopAppShortcutContainer.3(this);
  
  public TroopAppShortcutContainer(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    this.b = paramQQAppInterface;
    this.c = paramBaseActivity;
    this.d = paramContext;
    this.e = paramSessionInfo;
    this.f = paramInt;
    this.g = 1;
    this.h = 1;
    try
    {
      this.a = Long.valueOf(paramString).longValue();
    }
    catch (Exception paramSessionInfo)
    {
      label128:
      Object localObject;
      TextView localTextView;
      ImageView localImageView;
      int i1;
      break label128;
    }
    this.a = 0L;
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("TroopAppShortcutContainer troopuinerror:");
    paramSessionInfo.append(paramString);
    QLog.e("TroopAppShortcutContainer", 2, paramSessionInfo.toString());
    this.n = LayoutInflater.from(paramContext).inflate(2131625897, null);
    paramSessionInfo = (RelativeLayout)this.n.findViewById(2131445159);
    paramString = this.n.findViewById(2131447587);
    localObject = (TextView)this.n.findViewById(2131429218);
    localTextView = (TextView)this.n.findViewById(2131448819);
    ((TextView)localObject).setOnClickListener(this);
    TroopAppShortcutUtils.a((View)localObject);
    localImageView = (ImageView)this.n.findViewById(2131438161);
    localImageView.setOnClickListener(this);
    TroopAppShortcutUtils.a(localImageView);
    if (AppSetting.e)
    {
      localTextView.setFocusableInTouchMode(true);
      localTextView.setContentDescription(paramContext.getString(2131917381));
      ((TextView)localObject).setClickable(true);
      ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131901576));
      localImageView.setClickable(true);
      localImageView.setContentDescription(paramContext.getString(2131897596));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = (RelativeLayout.LayoutParams)paramString.getLayoutParams();
      i1 = ImmersiveUtils.getStatusBarHeight(paramContext);
      paramInt = i1;
      if (t()) {
        paramInt = i1 - AIOUtils.b(10.0F, paramString.getResources());
      }
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, paramInt, 0, 0);
      paramString.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ImmersiveUtils.setStatusBarDarkMode(paramBaseActivity.getWindow(), true);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramSessionInfo.setBackgroundDrawable(paramBaseActivity.getResources().getDrawable(2130841294));
      localImageView.setColorFilter(2013265919, PorterDuff.Mode.SRC_ATOP);
      localTextView.setTextColor(Color.parseColor("#ffffff"));
    }
    else
    {
      paramBaseActivity = URLDrawable.URLDrawableOptions.obtain();
      paramContext = new ColorDrawable();
      paramContext.setColor(Color.parseColor("#EBEDF5"));
      paramBaseActivity.mRequestWidth = ViewUtils.getScreenWidth();
      paramBaseActivity.mRequestHeight = ViewUtils.getScreenHeight();
      paramBaseActivity.mFailedDrawable = paramContext;
      paramBaseActivity.mLoadingDrawable = paramContext;
      paramBaseActivity = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200324170329_vqFCVSqE3E.png", paramBaseActivity);
      if (paramBaseActivity.getStatus() == 2) {
        paramBaseActivity.restartDownload();
      }
      paramBaseActivity.setDecodeHandler(URLDrawableDecodeHandler.y);
      this.n.setBackgroundDrawable(paramBaseActivity);
    }
    this.i = ((ITroopAppHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER));
    this.q.a();
    p();
    o();
    r();
  }
  
  private ArrayList<TroopAppShortcutContainer.TroopAppInfo> a(ArrayList<oidb_0xe2e.App> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        Object localObject1 = (oidb_0xe2e.App)paramArrayList.get(i1);
        Object localObject2;
        if ((((oidb_0xe2e.App)localObject1).appid.has()) && (((oidb_0xe2e.App)localObject1).icon.has()) && (((oidb_0xe2e.App)localObject1).name.has()) && (((oidb_0xe2e.App)localObject1).url.has()))
        {
          localObject2 = new TroopAppShortcutContainer.TroopAppInfo();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).c = ((oidb_0xe2e.App)localObject1).appid.get();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).d = ((oidb_0xe2e.App)localObject1).name.get();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).f = ((oidb_0xe2e.App)localObject1).url.get();
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).e = ((oidb_0xe2e.App)localObject1).icon.get();
          if (((oidb_0xe2e.App)localObject1).type.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).b = ((oidb_0xe2e.App)localObject1).type.get();
          }
          if (((oidb_0xe2e.App)localObject1).removable.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).g = ((oidb_0xe2e.App)localObject1).removable.get();
          }
          if (((oidb_0xe2e.App)localObject1).source.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).h = ((oidb_0xe2e.App)localObject1).source.get();
          }
          if (((oidb_0xe2e.App)localObject1).desc.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).i = ((oidb_0xe2e.App)localObject1).desc.get();
          }
          int i2;
          if (((oidb_0xe2e.App)localObject1).added.has())
          {
            i2 = ((oidb_0xe2e.App)localObject1).added.get();
            boolean bool = true;
            if (i2 != 1) {
              bool = false;
            }
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).j = bool;
          }
          if (((oidb_0xe2e.App)localObject1).redpoint.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).k = ((oidb_0xe2e.App)localObject1).redpoint.get();
          }
          if (((oidb_0xe2e.App)localObject1).cmd_trace.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).l = ((oidb_0xe2e.App)localObject1).cmd_trace.get();
          }
          if (((oidb_0xe2e.App)localObject1).show_frame.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).m = ((oidb_0xe2e.App)localObject1).show_frame.get();
          }
          if (((oidb_0xe2e.App)localObject1).playing_num.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).n = ((oidb_0xe2e.App)localObject1).playing_num.get();
          }
          if (((oidb_0xe2e.App)localObject1).qq_friend_playing_num.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).o = ((oidb_0xe2e.App)localObject1).qq_friend_playing_num.get();
          }
          if (((oidb_0xe2e.App)localObject1).total_playing_num.has()) {
            ((TroopAppShortcutContainer.TroopAppInfo)localObject2).p = ((oidb_0xe2e.App)localObject1).total_playing_num.get();
          }
          Object localObject3;
          if (((oidb_0xe2e.App)localObject1).playing_users.has())
          {
            if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).q == null) {
              ((TroopAppShortcutContainer.TroopAppInfo)localObject2).q = new ArrayList();
            }
            i2 = 0;
            while (i2 < ((oidb_0xe2e.App)localObject1).playing_users.size())
            {
              localObject3 = (oidb_0xe2e.PlayingUser)((oidb_0xe2e.App)localObject1).playing_users.get(i2);
              if (((oidb_0xe2e.PlayingUser)localObject3).uin.has()) {
                ((TroopAppShortcutContainer.TroopAppInfo)localObject2).q.add(String.valueOf(((oidb_0xe2e.PlayingUser)localObject3).uin.get()));
              }
              i2 += 1;
            }
          }
          if (((oidb_0xe2e.App)localObject1).tags.has())
          {
            if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).r == null) {
              ((TroopAppShortcutContainer.TroopAppInfo)localObject2).r = new ArrayList();
            }
            i2 = 0;
            while (i2 < ((oidb_0xe2e.App)localObject1).tags.size())
            {
              localObject3 = (oidb_0xe2e.Tag)((oidb_0xe2e.App)localObject1).tags.get(i2);
              if ((((oidb_0xe2e.Tag)localObject3).name.has()) && (!((oidb_0xe2e.Tag)localObject3).name.get().isEmpty())) {
                ((TroopAppShortcutContainer.TroopAppInfo)localObject2).r.add(((oidb_0xe2e.Tag)localObject3).name.get());
              }
              i2 += 1;
            }
          }
          ((TroopAppShortcutContainer.TroopAppInfo)localObject2).a = 0;
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
        i1 += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).f(String.valueOf(this.a));
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reqGetShortcutTroopApps troopuin:");
          localStringBuilder.append(this.a);
          localStringBuilder.append(" dwGroupClassExt");
          localStringBuilder.append(((TroopInfo)localObject).dwGroupClassExt);
          localStringBuilder.append(" page:");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append(" from:");
          localStringBuilder.append(paramInt3);
          QLog.d("TroopAppShortcutContainer", 2, localStringBuilder.toString());
        }
        this.i.a(this.a, (int)((TroopInfo)localObject).dwGroupClassExt, paramInt1, paramInt2, paramInt3);
        this.q.d();
        return;
      }
      QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
    }
  }
  
  private void a(oidb_0xe2e.RspBody paramRspBody)
  {
    Object localObject = a((ArrayList)paramRspBody.get_apps.get());
    if (localObject != null)
    {
      TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localTroopAppShortcutMgr != null) {
        localTroopAppShortcutMgr.a(this.a, (ArrayList)localObject);
      }
      g();
      b((ArrayList)localObject);
    }
    if (paramRspBody.max_app_num.has()) {
      this.s = paramRspBody.max_app_num.get();
    }
    boolean bool2 = paramRspBody.reach_tail.has();
    boolean bool1 = true;
    if (bool2)
    {
      localObject = this.q.a(1);
      if (paramRspBody.reach_tail.get() != 1) {
        bool1 = false;
      }
      ((TroopAppShortcutContainer.LoadingInfo)localObject).a(bool1).e();
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
      this.q.a(1).a(true).e();
    }
    paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
    if (paramRspBody != null)
    {
      localObject = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null) {
        ((TroopAppShortcutMgr)localObject).b(this.a, paramRspBody);
      }
      h();
      if (paramRspBody.size() > 0)
      {
        ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800AFBB", "0X800AFBB", 0, 0, String.valueOf(this.m), "", "", "");
        this.t = 0;
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
      localObject = this.q.a(paramInt);
      if (paramRspBody.reach_tail.get() != 1) {
        bool1 = false;
      }
      ((TroopAppShortcutContainer.LoadingInfo)localObject).a(bool1).e();
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
      this.q.a(paramInt).a(true).e();
    }
    paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
    if (paramRspBody != null)
    {
      localObject = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ArrayList localArrayList = ((TroopAppShortcutMgr)localObject).b(this.a);
        if (localArrayList == null) {
          ((TroopAppShortcutMgr)localObject).b(this.a, paramRspBody);
        } else {
          localArrayList.addAll(paramRspBody);
        }
      }
      h();
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
    long l1 = ((Bundle)localObject).getLong("troopuin", 0L);
    int i1 = ((Bundle)localObject).getInt("from", -1);
    int i2 = ((Bundle)localObject).getInt("page", -1);
    if (l1 != this.a)
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("handlerGetShortcutTroopApps troopUin note same mTroopUin:");
      paramObject1.append(this.a);
      paramObject1.append(" troopUin:");
      paramObject1.append(l1);
      QLog.d("TroopAppShortcutContainer", 2, paramObject1.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerGetShortcutTroopApps troopuin:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" page:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" from:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("TroopAppShortcutContainer", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramObject2 == null) || (!(paramObject2 instanceof oidb_0xe2e.RspBody)))
    {
      QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps infos not instanceof oidb_0xe2e.RspBody");
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (i1 == 1)
      {
        a(paramObject1);
        return;
      }
      if (i1 == 2)
      {
        a(paramObject1, i2);
        return;
      }
      if (i1 == 3) {
        b(paramObject1);
      }
    }
    else
    {
      this.q.e();
      paramObject1 = new StringBuilder();
      paramObject1.append("reqGetShortcutTroopApps faild troopUin:");
      paramObject1.append(this.a);
      paramObject1.append(" errCode:");
      paramObject1.append(paramInt);
      paramObject1.append(" from:");
      paramObject1.append(i1);
      QLog.e("TroopAppShortcutContainer", 2, paramObject1.toString());
      if (paramInt == 1002)
      {
        QQToast.makeText(this.c, 1, this.d.getString(2131897597), 0).show();
        return;
      }
      QQToast.makeText(this.c, 1, this.d.getString(2131897599), 0).show();
    }
  }
  
  private void b(ArrayList<TroopAppShortcutContainer.TroopAppInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      long l1 = this.a;
      long l2 = this.m;
      long l3 = ((TroopAppShortcutContainer.TroopAppInfo)paramArrayList.get(i1)).c;
      int i2 = this.f;
      String str;
      if (((TroopAppShortcutContainer.TroopAppInfo)paramArrayList.get(i1)).b == 0L) {
        str = "1";
      } else {
        str = "2";
      }
      ReportController.b(null, "dc00898", "", String.valueOf(l1), "0X800AFBA", "0X800AFBA", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i2), str);
      i1 += 1;
    }
  }
  
  private void b(oidb_0xe2e.RspBody paramRspBody)
  {
    this.q.e();
    paramRspBody = a((ArrayList)paramRspBody.get_apps.get());
    if (paramRspBody != null)
    {
      Object localObject = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ((TroopAppShortcutMgr)localObject).a(this.a, paramRspBody);
        localObject = ((TroopAppShortcutMgr)localObject).b(this.a);
        int i1 = 0;
        if (localObject != null)
        {
          int i2 = 0;
          i1 = 0;
          while (i2 < ((ArrayList)localObject).size())
          {
            TroopAppShortcutContainer.TroopAppInfo localTroopAppInfo = (TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(i2);
            if (paramRspBody.contains(localTroopAppInfo))
            {
              if (localTroopAppInfo.j) {
                break label141;
              }
              localTroopAppInfo.j = true;
            }
            else
            {
              if (!localTroopAppInfo.j) {
                break label141;
              }
              localTroopAppInfo.j = false;
            }
            i1 = 1;
            label141:
            i2 += 1;
          }
        }
        g();
        b(paramRspBody);
        if (i1 != 0) {
          h();
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i1 = this.t;
    if (paramInt <= i1) {
      return;
    }
    if (this.j == null) {
      return;
    }
    while (i1 < paramInt)
    {
      Object localObject = this.j.a(i1);
      if ((localObject != null) && ((localObject instanceof AppsRecommendViewBuilder)))
      {
        localObject = ((AppsBaseBuilder)localObject).b();
        if (localObject != null)
        {
          if (!(localObject instanceof TroopAppShortcutContainer.TroopAppInfo)) {
            return;
          }
          localObject = (TroopAppShortcutContainer.TroopAppInfo)localObject;
          ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800AFBC", "0X800AFBC", 0, 0, String.valueOf(this.m), String.valueOf(((TroopAppShortcutContainer.TroopAppInfo)localObject).c), "", ((TroopAppShortcutContainer.TroopAppInfo)localObject).l);
        }
      }
      else
      {
        i1 += 1;
        continue;
      }
      return;
    }
    this.t = paramInt;
  }
  
  private void m()
  {
    if (this.p) {
      return;
    }
    this.p = true;
    this.b.addObserver(this.l);
    this.b.addObserver(this.x);
    v();
    e();
  }
  
  private void n()
  {
    if (!this.p) {
      return;
    }
    this.p = false;
    TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localTroopAppShortcutMgr != null)
    {
      ArrayList localArrayList1 = localTroopAppShortcutMgr.b(this.a);
      if ((localArrayList1 != null) && (localArrayList1.size() > 10))
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.addAll(localArrayList1.subList(0, 10));
        localTroopAppShortcutMgr.b(this.a, localArrayList2);
      }
    }
    l();
    w();
    this.b.removeObserver(this.l);
    this.b.removeObserver(this.x);
    this.w = System.currentTimeMillis();
    x();
  }
  
  private void o()
  {
    this.k = ((ListView)this.n.findViewById(2131428673));
    this.j = new TroopAppShortcutContainer.AppsListViewAdapter(this.d);
    this.k.setAdapter(this.j);
    this.k.setOnScrollListener(new TroopAppShortcutContainer.2(this));
  }
  
  private void p()
  {
    Object localObject = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).g(String.valueOf(this.a));
      if (localObject != null) {
        this.m = ((TroopInfo)localObject).dwGroupClassExt;
      }
    }
    this.r.clear();
    this.r.putLong("troopUin", this.a);
    this.r.putLong("troopClassExt", this.m);
    this.r.putInt("reportFrom", this.g);
    this.r.putBoolean("isNight", ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
    this.r.putBoolean("isAdminOrOwner", TroopAppShortcutUtils.a(this.b, this.a));
    this.r.putParcelable("sessionInfo", this.e);
  }
  
  private boolean q()
  {
    TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localTroopAppShortcutMgr != null) {
      return localTroopAppShortcutMgr.b();
    }
    return false;
  }
  
  private void r()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131438161);
      if (TroopAppShortcutUtils.a(this.b, this.a)) {
        ((ImageView)localObject).setVisibility(0);
      } else {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    g();
    h();
  }
  
  private TroopAppShortcutContainer s()
  {
    return this;
  }
  
  private boolean t()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  private void u()
  {
    a(true);
    Object localObject = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject != null) {
      localObject = ((TroopAppShortcutMgr)localObject).a(this.a);
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if (localObject != null)
    {
      int i3 = ((ArrayList)localObject).size();
      int i2;
      for (int i1 = 0; i1 < i3; i1 = i2)
      {
        localStringBuilder.append(((TroopAppShortcutContainer.TroopAppInfo)((ArrayList)localObject).get(i1)).c);
        localStringBuilder.append("-");
        i2 = i1 + 1;
        localStringBuilder.append(i2);
        if (i1 != i3 - 1) {
          localStringBuilder.append(";");
        }
      }
    }
    ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800AFC9", "0X800AFC9", 0, 0, String.valueOf(this.m), "", localStringBuilder.toString(), "");
  }
  
  private void v()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
      this.c.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    QLog.e("TroopAppShortcutContainer", 1, "registerMiniAppAdd exception.");
  }
  
  private void w()
  {
    try
    {
      this.c.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    QLog.e("TroopAppShortcutContainer", 1, "unregisterMiniAppAdd exception.");
  }
  
  private void x()
  {
    long l1 = this.w;
    if (l1 != 0L)
    {
      long l2 = this.v;
      if ((l2 != 0L) && (l1 > l2)) {
        ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800B23B", "0X800B23B", 0, 0, String.valueOf(this.m), "", String.valueOf(this.h), String.valueOf(this.w - this.v));
      }
    }
    this.v = 0L;
    this.w = 0L;
    this.h = 1;
  }
  
  public View a()
  {
    return this.n;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    this.h = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 20006) || (paramInt1 == 20007)) {
      a(1, 0, 3);
    }
    this.g = 5;
    ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.m), "", String.valueOf(this.g), "");
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    m();
  }
  
  protected void b(int paramInt)
  {
    if (this.j != null)
    {
      Object localObject1 = null;
      Object localObject2 = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject2 != null) {
        localObject1 = ((TroopAppShortcutMgr)localObject2).a(this.a);
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = new AppsAioShortCutViewBuilder(this.d, this.b, this.c, this, this.r);
        localObject2 = new AppsAioShortCutViewBuilder.AioShortCutInfo();
        Object localObject3 = ((TroopShortcutBarManager)this.b.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.a));
        if (localObject3 != null)
        {
          ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).e = ((TroopShortcutBarInfo)localObject3);
          ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b = TroopAppShortcutUtils.a(this.b, this.a);
          boolean bool;
          if (((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b)
          {
            if (((TroopShortcutBarInfo)localObject3).b() == 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).a = bool;
          }
          else
          {
            if (((TroopShortcutBarInfo)localObject3).a() == 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).a = bool;
          }
          TroopAppShortcutUtils.a(this.b, (AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2, this.a);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("info.bAdmin :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b);
            ((StringBuilder)localObject3).append("info.bSwith :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).a);
            ((StringBuilder)localObject3).append("info.bAdminShowSwitch :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).c);
            ((StringBuilder)localObject3).append("info.bMemberShowSwitch :");
            ((StringBuilder)localObject3).append(((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).d);
            ((StringBuilder)localObject3).append("TroopUin: ");
            ((StringBuilder)localObject3).append(String.valueOf(this.a));
            QLog.e("TroopAppShortcutContainer", 2, new Object[] { "updateUI_aioShortCut", ((StringBuilder)localObject3).toString() });
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateUI_aioShortCut. troopShortcutBarInfo is null, TroopUin: ");
          ((StringBuilder)localObject3).append(String.valueOf(this.a));
          QLog.e("TroopAppShortcutContainer", 2, ((StringBuilder)localObject3).toString());
        }
        ((AppsBaseBuilder)localObject1).a_(localObject2);
        this.j.a(0, (AppsBaseBuilder)localObject1);
        if ((paramInt == 1) && (!((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).b) && (((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).d) && (((AppsAioShortCutViewBuilder.AioShortCutInfo)localObject2).e.b() == 0)) {
          ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800AFC0", "0X800AFC0", 0, 0, String.valueOf(this.m), "", "", "");
        }
      }
      else
      {
        this.j.a(0, new ArrayList());
      }
    }
  }
  
  public void c()
  {
    b(1);
    ReportController.b(null, "dc00898", "", String.valueOf(this.a), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.m), "", String.valueOf(this.g), "");
    this.v = System.currentTimeMillis();
  }
  
  public void d()
  {
    this.g = 1;
    this.t = 2147483647;
    if (this.f == 1)
    {
      ListView localListView = this.k;
      if (localListView != null) {
        localListView.smoothScrollToPosition(0);
      }
    }
    n();
  }
  
  public void e()
  {
    this.q.a();
    p();
    if (q())
    {
      a(1, 30, 1);
      return;
    }
    a(1, 0, 1);
  }
  
  public int f()
  {
    return this.s;
  }
  
  protected void g()
  {
    b(2);
    Object localObject = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject != null) {
      localObject = ((TroopAppShortcutMgr)localObject).a(this.a);
    } else {
      localObject = null;
    }
    if (this.j != null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject);
        localObject = new AppsGridViewBuilder(this.d, this.b, this.c, this.r);
        ((AppsBaseBuilder)localObject).a_(localArrayList);
        this.j.a(1, (AppsBaseBuilder)localObject);
        return;
      }
      this.j.a(1, new ArrayList());
    }
  }
  
  protected void h()
  {
    if (!q())
    {
      localObject1 = this.j;
      if (localObject1 != null)
      {
        ((TroopAppShortcutContainer.AppsListViewAdapter)localObject1).a(2, new ArrayList());
        this.j.a(3, new ArrayList());
      }
      return;
    }
    Object localObject1 = null;
    Object localObject2 = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject2 != null) {
      localObject1 = ((TroopAppShortcutMgr)localObject2).b(this.a);
    }
    if (this.j != null)
    {
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = new AppsSearchViewBuilder(this.d, this.b, this.c, this.r);
        this.j.a(2, (AppsBaseBuilder)localObject2);
        localObject2 = new ArrayList();
        int i1 = 0;
        while (i1 < ((ArrayList)localObject1).size())
        {
          AppsRecommendViewBuilder localAppsRecommendViewBuilder = new AppsRecommendViewBuilder(this.d, this.b, this.c, this, this.r);
          localAppsRecommendViewBuilder.a_(((ArrayList)localObject1).get(i1));
          ((List)localObject2).add(localAppsRecommendViewBuilder);
          i1 += 1;
        }
        this.j.a(3, (List)localObject2);
        return;
      }
      this.j.a(2, new ArrayList());
      this.j.a(3, new ArrayList());
    }
  }
  
  public boolean i()
  {
    a(true);
    return false;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "onDestroy");
    }
    TroopAppShortcutMgr localTroopAppShortcutMgr = (TroopAppShortcutMgr)this.b.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localTroopAppShortcutMgr != null) {
      localTroopAppShortcutMgr.a();
    }
    n();
  }
  
  public void k()
  {
    if (this.u == null) {
      this.u = new ShortcutBarGuideDialog(this.d);
    }
    this.u.show();
  }
  
  public void l()
  {
    ShortcutBarGuideDialog localShortcutBarGuideDialog = this.u;
    if (localShortcutBarGuideDialog != null)
    {
      localShortcutBarGuideDialog.dismiss();
      this.u = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.elapsedRealtime();
    Long localLong = this.o;
    if ((localLong == null) || (l1 - localLong.longValue() >= 500L))
    {
      this.o = Long.valueOf(l1);
      int i1 = paramView.getId();
      if (i1 != 2131429218)
      {
        if (i1 == 2131438161) {
          TroopAppShortcutUtils.a(1, this.a, this.b, this.d, this.c);
        }
      }
      else {
        u();
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
        if (!paramContext.equals(String.valueOf(this.a))) {
          return;
        }
        a(1, 0, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer
 * JD-Core Version:    0.7.0.1
 */