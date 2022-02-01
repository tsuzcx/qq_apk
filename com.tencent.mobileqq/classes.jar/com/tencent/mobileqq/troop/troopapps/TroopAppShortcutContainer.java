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
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import aoep;
import aofu;
import bdla;
import bgbf;
import bgbg;
import bgbj;
import bgew;
import bgex;
import bgez;
import bgfa;
import bgfe;
import bgfg;
import bgfi;
import bgfk;
import bgfl;
import bgfm;
import bgfn;
import bgfo;
import bgfp;
import bgfr;
import bgil;
import bgxc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  private long jdField_a_of_type_Long;
  public Context a;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  protected aoep a;
  protected aofu a;
  private bgbj jdField_a_of_type_Bgbj = new bgfm(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  private bgfi jdField_a_of_type_Bgfi;
  public bgfn a;
  private bgfo jdField_a_of_type_Bgfo = new bgfo();
  public SessionInfo a;
  public QQAppInterface a;
  protected ListView a;
  private Long jdField_a_of_type_JavaLangLong;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private long b;
  protected int c;
  private long c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int e;
  
  public TroopAppShortcutContainer(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    this.jdField_e_of_type_Int = 2147483647;
    this.jdField_a_of_type_Aofu = new bgfk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramString).longValue();
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559907, null);
      paramSessionInfo = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376967);
      paramString = this.jdField_a_of_type_AndroidViewView.findViewById(2131379104);
      Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363329);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380218);
      ((TextView)localObject).setOnClickListener(this);
      bgil.a((View)localObject);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370928);
      localImageView.setOnClickListener(this);
      bgil.a(localImageView);
      if (AppSetting.c)
      {
        localTextView.setFocusableInTouchMode(true);
        localTextView.setContentDescription(paramContext.getString(2131719481));
        ((TextView)localObject).setClickable(true);
        ((TextView)localObject).setContentDescription(anvx.a(2131706469));
        localImageView.setClickable(true);
        localImageView.setContentDescription(paramContext.getString(2131699091));
      }
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout.LayoutParams)paramString.getLayoutParams();
        int i = ImmersiveUtils.getStatusBarHeight(paramContext);
        paramInt = i;
        if (c()) {
          paramInt = i - AIOUtils.dp2px(10.0F, paramString.getResources());
        }
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, paramInt, 0, 0);
        paramString.setLayoutParams((ViewGroup.LayoutParams)localObject);
        ImmersiveUtils.a(paramFragmentActivity.getWindow(), true);
      }
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
      {
        paramSessionInfo.setBackgroundDrawable(paramFragmentActivity.getResources().getDrawable(2130840516));
        localImageView.setColorFilter(2013265919, PorterDuff.Mode.SRC_ATOP);
        localTextView.setTextColor(Color.parseColor("#ffffff"));
        this.jdField_a_of_type_Aoep = ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
        this.jdField_a_of_type_Bgfo.a();
        m();
        l();
        n();
        return;
      }
    }
    catch (Exception paramSessionInfo)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
        QLog.e("TroopAppShortcutContainer", 2, "TroopAppShortcutContainer troopuinerror:" + paramString);
        continue;
        paramFragmentActivity = URLDrawable.URLDrawableOptions.obtain();
        paramContext = new ColorDrawable();
        paramContext.setColor(Color.parseColor("#EBEDF5"));
        paramFragmentActivity.mRequestWidth = ViewUtils.getScreenWidth();
        paramFragmentActivity.mRequestHeight = ViewUtils.getScreenHeight();
        paramFragmentActivity.mFailedDrawable = paramContext;
        paramFragmentActivity.mLoadingDrawable = paramContext;
        paramFragmentActivity = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200324170329_vqFCVSqE3E.png", paramFragmentActivity);
        if (paramFragmentActivity.getStatus() == 2) {
          paramFragmentActivity.restartDownload();
        }
        paramFragmentActivity.setDecodeHandler(bgxc.z);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramFragmentActivity);
      }
    }
  }
  
  private TroopAppShortcutContainer a()
  {
    return this;
  }
  
  private ArrayList<bgfp> a(ArrayList<oidb_0xe2e.App> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramArrayList.size())
      {
        oidb_0xe2e.App localApp = (oidb_0xe2e.App)paramArrayList.get(i);
        if ((localApp.appid.has()) && (localApp.icon.has()) && (localApp.name.has()) && (localApp.url.has()))
        {
          bgfp localbgfp = new bgfp();
          localbgfp.jdField_b_of_type_Long = localApp.appid.get();
          localbgfp.jdField_a_of_type_JavaLangString = localApp.name.get();
          localbgfp.jdField_c_of_type_JavaLangString = localApp.url.get();
          localbgfp.jdField_b_of_type_JavaLangString = localApp.icon.get();
          if (localApp.type.has()) {
            localbgfp.jdField_a_of_type_Long = localApp.type.get();
          }
          if (localApp.removable.has()) {
            localbgfp.jdField_b_of_type_Int = localApp.removable.get();
          }
          if (localApp.source.has()) {
            localbgfp.jdField_c_of_type_Int = localApp.source.get();
          }
          if (localApp.desc.has()) {
            localbgfp.jdField_d_of_type_JavaLangString = localApp.desc.get();
          }
          boolean bool;
          int j;
          label444:
          Object localObject;
          if (localApp.added.has())
          {
            if (localApp.added.get() == 1)
            {
              bool = true;
              localbgfp.jdField_a_of_type_Boolean = bool;
            }
          }
          else
          {
            if (localApp.redpoint.has()) {
              localbgfp.jdField_d_of_type_Int = localApp.redpoint.get();
            }
            if (localApp.cmd_trace.has()) {
              localbgfp.jdField_e_of_type_JavaLangString = localApp.cmd_trace.get();
            }
            if (localApp.show_frame.has()) {
              localbgfp.jdField_e_of_type_Int = localApp.show_frame.get();
            }
            if (localApp.playing_num.has()) {
              localbgfp.f = localApp.playing_num.get();
            }
            if (localApp.qq_friend_playing_num.has()) {
              localbgfp.g = localApp.qq_friend_playing_num.get();
            }
            if (localApp.total_playing_num.has()) {
              localbgfp.h = localApp.total_playing_num.get();
            }
            if (!localApp.playing_users.has()) {
              break label519;
            }
            if (localbgfp.jdField_a_of_type_JavaUtilList == null) {
              localbgfp.jdField_a_of_type_JavaUtilList = new ArrayList();
            }
            j = 0;
            if (j >= localApp.playing_users.size()) {
              break label519;
            }
            localObject = (oidb_0xe2e.PlayingUser)localApp.playing_users.get(j);
            if (((oidb_0xe2e.PlayingUser)localObject).uin.has()) {
              break label494;
            }
          }
          for (;;)
          {
            j += 1;
            break label444;
            bool = false;
            break;
            label494:
            localbgfp.jdField_a_of_type_JavaUtilList.add(String.valueOf(((oidb_0xe2e.PlayingUser)localObject).uin.get()));
          }
          label519:
          if (localApp.tags.has())
          {
            if (localbgfp.jdField_b_of_type_JavaUtilList == null) {
              localbgfp.jdField_b_of_type_JavaUtilList = new ArrayList();
            }
            j = 0;
            if (j < localApp.tags.size())
            {
              localObject = (oidb_0xe2e.Tag)localApp.tags.get(j);
              if ((!((oidb_0xe2e.Tag)localObject).name.has()) || (((oidb_0xe2e.Tag)localObject).name.get().isEmpty())) {}
              for (;;)
              {
                j += 1;
                break;
                localbgfp.jdField_b_of_type_JavaUtilList.add(((oidb_0xe2e.Tag)localObject).name.get());
              }
            }
          }
          localbgfp.jdField_a_of_type_Int = 0;
          localArrayList.add(localbgfp);
          if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutContainer", 2, "info:" + localbgfp.toString());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          QLog.e("TroopAppShortcutContainer", 2, "get appinfo error:" + localApp.toString());
        }
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
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps troopuin:" + this.jdField_a_of_type_Long + " dwGroupClassExt" + ((TroopInfo)localObject).dwGroupClassExt + " page:" + paramInt3 + " from:" + paramInt3);
        }
        this.jdField_a_of_type_Aoep.a(this.jdField_a_of_type_Long, (int)((TroopInfo)localObject).dwGroupClassExt, paramInt1, paramInt2, paramInt3);
        this.jdField_a_of_type_Bgfo.a();
      }
    }
    else
    {
      return;
    }
    QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
  }
  
  private void a(ArrayList<bgfp> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = 0;
    label7:
    long l1;
    long l2;
    long l3;
    int j;
    if (i < paramArrayList.size())
    {
      l1 = this.jdField_a_of_type_Long;
      l2 = this.jdField_b_of_type_Long;
      l3 = ((bgfp)paramArrayList.get(i)).jdField_b_of_type_Long;
      j = this.jdField_a_of_type_Int;
      if (((bgfp)paramArrayList.get(i)).jdField_a_of_type_Long != 0L) {
        break label112;
      }
    }
    label112:
    for (String str = "1";; str = "2")
    {
      bdla.b(null, "dc00898", "", String.valueOf(l1), "0X800AFBA", "0X800AFBA", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(j), str);
      i += 1;
      break label7;
      break;
    }
  }
  
  private void a(oidb_0xe2e.RspBody paramRspBody)
  {
    Object localObject = a((ArrayList)paramRspBody.get_apps.get());
    if (localObject != null)
    {
      bgfr localbgfr = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localbgfr != null) {
        localbgfr.a(this.jdField_a_of_type_Long, (ArrayList)localObject);
      }
      e();
      a((ArrayList)localObject);
    }
    if (paramRspBody.max_app_num.has()) {
      this.jdField_d_of_type_Int = paramRspBody.max_app_num.get();
    }
    boolean bool;
    if (paramRspBody.reach_tail.has())
    {
      localObject = this.jdField_a_of_type_Bgfo.a(1);
      if (paramRspBody.reach_tail.get() == 1)
      {
        bool = true;
        ((bgfo)localObject).a(bool).b();
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps_home reach_tail:" + paramRspBody.reach_tail.get());
        }
      }
    }
    for (;;)
    {
      paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
      if (paramRspBody != null)
      {
        localObject = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (localObject != null) {
          ((bgfr)localObject).b(this.jdField_a_of_type_Long, paramRspBody);
        }
        f();
        if (paramRspBody.size() > 0)
        {
          bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBB", "0X800AFBB", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
          this.jdField_e_of_type_Int = 0;
        }
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Bgfo.a(1).a(true).b();
    }
  }
  
  private void a(oidb_0xe2e.RspBody paramRspBody, int paramInt)
  {
    boolean bool = true;
    label82:
    ArrayList localArrayList;
    if (paramRspBody.reach_tail.has())
    {
      Object localObject = this.jdField_a_of_type_Bgfo.a(paramInt);
      if (paramRspBody.reach_tail.get() == 1)
      {
        ((bgfo)localObject).a(bool).b();
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps_moreRecommend reach_tail:" + paramRspBody.reach_tail.get());
        }
        paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
        if (paramRspBody != null)
        {
          localObject = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
          if (localObject != null)
          {
            localArrayList = ((bgfr)localObject).b(this.jdField_a_of_type_Long);
            if (localArrayList != null) {
              break label176;
            }
            ((bgfr)localObject).b(this.jdField_a_of_type_Long, paramRspBody);
          }
        }
      }
    }
    for (;;)
    {
      f();
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Bgfo.a(paramInt).a(true).b();
      break label82;
      label176:
      localArrayList.addAll(paramRspBody);
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt)
  {
    if (paramObject1 == null) {}
    oidb_0xe2e.RspBody localRspBody;
    int i;
    do
    {
      do
      {
        return;
      } while (!(paramObject1 instanceof Bundle));
      paramObject1 = (Bundle)paramObject1;
      localRspBody = (oidb_0xe2e.RspBody)paramObject2;
      long l = paramObject1.getLong("troopuin", 0L);
      i = paramObject1.getInt("from", -1);
      int j = paramObject1.getInt("page", -1);
      if (l != this.jdField_a_of_type_Long)
      {
        QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps troopUin note same mTroopUin:" + this.jdField_a_of_type_Long + " troopUin:" + l);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps troopuin:" + this.jdField_a_of_type_Long + " page:" + i + " from:" + i);
      }
      if ((paramObject2 == null) || (!(paramObject2 instanceof oidb_0xe2e.RspBody)))
      {
        QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps infos not instanceof oidb_0xe2e.RspBody");
        paramBoolean = false;
      }
      if (!paramBoolean) {
        break;
      }
      if (i == 1)
      {
        a(localRspBody);
        return;
      }
      if (i == 2)
      {
        a(localRspBody, j);
        return;
      }
    } while (i != 3);
    b(localRspBody);
    return;
    this.jdField_a_of_type_Bgfo.b();
    QLog.e("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps faild troopUin:" + this.jdField_a_of_type_Long + " errCode:" + paramInt + " from:" + i);
    if (paramInt == 1002)
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699092), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131699094), 0).a();
  }
  
  private void b(oidb_0xe2e.RspBody paramRspBody)
  {
    this.jdField_a_of_type_Bgfo.b();
    paramRspBody = a((ArrayList)paramRspBody.get_apps.get());
    if (paramRspBody != null)
    {
      Object localObject = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject != null)
      {
        ((bgfr)localObject).a(this.jdField_a_of_type_Long, paramRspBody);
        localObject = ((bgfr)localObject).b(this.jdField_a_of_type_Long);
        int k;
        if (localObject != null)
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            bgfp localbgfp = (bgfp)((ArrayList)localObject).get(j);
            if (paramRspBody.contains(localbgfp)) {
              if (!localbgfp.jdField_a_of_type_Boolean)
              {
                localbgfp.jdField_a_of_type_Boolean = true;
                i = 1;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              if (localbgfp.jdField_a_of_type_Boolean)
              {
                localbgfp.jdField_a_of_type_Boolean = false;
                i = 1;
              }
            }
          }
        }
        else
        {
          k = 0;
        }
        e();
        a(paramRspBody);
        if (k != 0) {
          f();
        }
      }
    }
  }
  
  private boolean b()
  {
    bgfr localbgfr = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localbgfr != null) {
      return localbgfr.a();
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (paramInt <= this.jdField_e_of_type_Int) {
      break label8;
    }
    label8:
    while (this.jdField_a_of_type_Bgfn == null) {
      return;
    }
    int i = this.jdField_e_of_type_Int;
    label21:
    if (i < paramInt)
    {
      Object localObject = this.jdField_a_of_type_Bgfn.a(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break label21;
        if ((localObject instanceof bgfe))
        {
          localObject = ((bgez)localObject).a();
          if ((localObject == null) || (!(localObject instanceof bgfp))) {
            break;
          }
          localObject = (bgfp)localObject;
          bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBC", "0X800AFBC", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(((bgfp)localObject).jdField_b_of_type_Long), "", ((bgfp)localObject).jdField_e_of_type_JavaLangString);
        }
      }
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bgbj);
    p();
    d();
  }
  
  private void k()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    bgfr localbgfr = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localbgfr != null)
    {
      ArrayList localArrayList1 = localbgfr.b(this.jdField_a_of_type_Long);
      if ((localArrayList1 != null) && (localArrayList1.size() > 10))
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.addAll(localArrayList1.subList(0, 10));
        localbgfr.b(this.jdField_a_of_type_Long, localArrayList2);
      }
    }
    i();
    q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bgbj);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    r();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362882));
    this.jdField_a_of_type_Bgfn = new bgfn(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bgfn);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new bgfl(this));
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
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isAdminOrOwner", bgil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void n()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370928);
      if (!bgil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) {
        break label48;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      e();
      f();
      return;
      label48:
      localImageView.setVisibility(8);
    }
  }
  
  private void o()
  {
    a(true);
    Object localObject = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((bgfr)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      if (localObject != null)
      {
        int j = ((ArrayList)localObject).size();
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(((bgfp)((ArrayList)localObject).get(i)).jdField_b_of_type_Long).append("-").append(i + 1);
          if (i != j - 1) {
            localStringBuilder.append(";");
          }
          i += 1;
        }
      }
      bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC9", "0X800AFC9", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", localStringBuilder.toString(), "");
      return;
    }
  }
  
  private void p()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TroopAppShortcutContainer", 1, "registerMiniAppAdd exception.");
    }
  }
  
  private void q()
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TroopAppShortcutContainer", 1, "unregisterMiniAppAdd exception.");
    }
  }
  
  private void r()
  {
    if ((this.jdField_d_of_type_Long != 0L) && (this.jdField_c_of_type_Long != 0L) && (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)) {
      bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B23B", "0X800B23B", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_c_of_type_Int), String.valueOf(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long));
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
    bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_b_of_type_Int), "");
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
    bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_b_of_type_Int), "");
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bgfn != null)
    {
      localObject = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject == null) {
        break label453;
      }
    }
    label453:
    for (Object localObject = ((bgfr)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = new bgew(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidOsBundle);
        bgex localbgex = new bgex();
        bgbf localbgbf = ((bgbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.jdField_a_of_type_Long));
        boolean bool;
        if (localbgbf != null)
        {
          localbgex.jdField_a_of_type_Bgbf = localbgbf;
          localbgex.b = bgil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
          if (localbgex.b) {
            if (localbgbf.b() == 0)
            {
              bool = true;
              localbgex.jdField_a_of_type_Boolean = bool;
              bgil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbgex, this.jdField_a_of_type_Long);
              if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutContainer", 2, new Object[] { "updateUI_aioShortCut", "info.bAdmin :" + localbgex.b + "info.bSwith :" + localbgex.jdField_a_of_type_Boolean + "info.bAdminShowSwitch :" + localbgex.c + "info.bMemberShowSwitch :" + localbgex.d + "TroopUin: " + String.valueOf(this.jdField_a_of_type_Long) });
              }
            }
          }
        }
        for (;;)
        {
          ((bgez)localObject).a_(localbgex);
          this.jdField_a_of_type_Bgfn.a(0, (bgez)localObject);
          if ((paramInt == 1) && (!localbgex.b) && (localbgex.d) && (localbgex.jdField_a_of_type_Bgbf.b() == 0)) {
            bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC0", "0X800AFC0", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
          }
          return;
          bool = false;
          break;
          if (localbgbf.a() == 0) {}
          for (bool = true;; bool = false)
          {
            localbgex.jdField_a_of_type_Boolean = bool;
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("TroopAppShortcutContainer", 2, "updateUI_aioShortCut. troopShortcutBarInfo is null, TroopUin: " + String.valueOf(this.jdField_a_of_type_Long));
          }
        }
      }
      this.jdField_a_of_type_Bgfn.a(0, new ArrayList());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Int = 2147483647;
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentWidgetListView != null)) {
      this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollToPosition(0);
    }
    k();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bgfo.a();
    m();
    if (b())
    {
      a(1, 30, 1);
      return;
    }
    a(1, 0, 1);
  }
  
  public void e()
  {
    b(2);
    Object localObject = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((bgfr)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      if (this.jdField_a_of_type_Bgfn != null)
      {
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll((Collection)localObject);
          localObject = new bgfa(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle);
          ((bgez)localObject).a_(localArrayList);
          this.jdField_a_of_type_Bgfn.a(1, (bgez)localObject);
        }
      }
      else {
        return;
      }
      this.jdField_a_of_type_Bgfn.a(1, new ArrayList());
      return;
    }
  }
  
  public void f()
  {
    if (!b()) {
      if (this.jdField_a_of_type_Bgfn != null)
      {
        this.jdField_a_of_type_Bgfn.a(2, new ArrayList());
        this.jdField_a_of_type_Bgfn.a(3, new ArrayList());
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
      if (localObject1 != null) {}
      for (localObject1 = ((bgfr)localObject1).b(this.jdField_a_of_type_Long); this.jdField_a_of_type_Bgfn != null; localObject1 = null)
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          Object localObject2 = new bgfg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Bgfn.a(2, (bgez)localObject2);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            bgfe localbgfe = new bgfe(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidOsBundle);
            localbgfe.a_(((ArrayList)localObject1).get(i));
            ((List)localObject2).add(localbgfe);
            i += 1;
          }
          this.jdField_a_of_type_Bgfn.a(3, (List)localObject2);
          return;
        }
        this.jdField_a_of_type_Bgfn.a(2, new ArrayList());
        this.jdField_a_of_type_Bgfn.a(3, new ArrayList());
        return;
      }
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "onDestroy");
    }
    bgfr localbgfr = (bgfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
    if (localbgfr != null) {
      localbgfr.a();
    }
    k();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bgfi == null) {
      this.jdField_a_of_type_Bgfi = new bgfi(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Bgfi.show();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bgfi != null)
    {
      this.jdField_a_of_type_Bgfi.dismiss();
      this.jdField_a_of_type_Bgfi = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363329: 
        o();
        break;
      case 2131370928: 
        bgil.a(1, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.addgroupapplication".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("groupUin");
      paramIntent = paramIntent.getStringExtra("appId");
      if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramIntent))) {
        break label44;
      }
    }
    label44:
    while (!paramContext.equals(String.valueOf(this.jdField_a_of_type_Long))) {
      return;
    }
    a(1, 0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer
 * JD-Core Version:    0.7.0.1
 */