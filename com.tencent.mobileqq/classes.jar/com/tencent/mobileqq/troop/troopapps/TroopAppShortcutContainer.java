package com.tencent.mobileqq.troop.troopapps;

import agej;
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
import anzj;
import aoip;
import aojs;
import bdll;
import bgkr;
import bgks;
import bgku;
import bgnv;
import bgnw;
import bgny;
import bgnz;
import bgod;
import bgog;
import bgoi;
import bgok;
import bgol;
import bgom;
import bgon;
import bgoo;
import bgop;
import bgor;
import bgqr;
import bhez;
import bhtq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.App;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.RspBody;

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
  protected aoip a;
  protected aojs a;
  private bgku jdField_a_of_type_Bgku = new bgom(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  private bgoi jdField_a_of_type_Bgoi;
  public bgon a;
  private bgoo jdField_a_of_type_Bgoo = new bgoo();
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
    this.jdField_a_of_type_Aojs = new bgok(this);
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559861, null);
      paramSessionInfo = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376944);
      paramString = this.jdField_a_of_type_AndroidViewView.findViewById(2131379042);
      Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363233);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380150);
      ((TextView)localObject).setOnClickListener(this);
      bgqr.a((View)localObject);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370775);
      localImageView.setOnClickListener(this);
      bgqr.a(localImageView);
      if (AppSetting.c)
      {
        localTextView.setFocusableInTouchMode(true);
        localTextView.setContentDescription(paramContext.getString(2131718827));
        ((TextView)localObject).setClickable(true);
        ((TextView)localObject).setContentDescription(anzj.a(2131705887));
        localImageView.setClickable(true);
        localImageView.setContentDescription(paramContext.getString(2131698524));
      }
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout.LayoutParams)paramString.getLayoutParams();
        int i = ImmersiveUtils.getStatusBarHeight(paramContext);
        paramInt = i;
        if (c()) {
          paramInt = i - agej.a(10.0F, paramString.getResources());
        }
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, paramInt, 0, 0);
        paramString.setLayoutParams((ViewGroup.LayoutParams)localObject);
        ImmersiveUtils.a(paramFragmentActivity.getWindow(), true);
      }
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
      {
        paramSessionInfo.setBackgroundDrawable(paramFragmentActivity.getResources().getDrawable(2130840440));
        localImageView.setColorFilter(2013265919, PorterDuff.Mode.SRC_ATOP);
        localTextView.setTextColor(Color.parseColor("#ffffff"));
        this.jdField_a_of_type_Aoip = ((aoip)paramQQAppInterface.a(20));
        this.jdField_a_of_type_Bgoo.a();
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
        paramFragmentActivity.mRequestWidth = bhtq.a();
        paramFragmentActivity.mRequestHeight = bhtq.b();
        paramFragmentActivity.mFailedDrawable = paramContext;
        paramFragmentActivity.mLoadingDrawable = paramContext;
        paramFragmentActivity = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200324170329_vqFCVSqE3E.png", paramFragmentActivity);
        if (paramFragmentActivity.getStatus() == 2) {
          paramFragmentActivity.restartDownload();
        }
        paramFragmentActivity.setDecodeHandler(bhez.z);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramFragmentActivity);
      }
    }
  }
  
  private TroopAppShortcutContainer a()
  {
    return this;
  }
  
  private ArrayList<bgop> a(ArrayList<oidb_0xe2e.App> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramArrayList.size())
      {
        oidb_0xe2e.App localApp = (oidb_0xe2e.App)paramArrayList.get(i);
        boolean bool;
        if ((localApp.appid.has()) && (localApp.icon.has()) && (localApp.name.has()) && (localApp.url.has()))
        {
          bgop localbgop = new bgop();
          localbgop.jdField_b_of_type_Long = localApp.appid.get();
          localbgop.jdField_a_of_type_JavaLangString = localApp.name.get();
          localbgop.jdField_c_of_type_JavaLangString = localApp.url.get();
          localbgop.jdField_b_of_type_JavaLangString = localApp.icon.get();
          if (localApp.type.has()) {
            localbgop.jdField_a_of_type_Long = localApp.type.get();
          }
          if (localApp.removable.has()) {
            localbgop.jdField_b_of_type_Int = localApp.removable.get();
          }
          if (localApp.source.has()) {
            localbgop.jdField_c_of_type_Int = localApp.source.get();
          }
          if (localApp.desc.has()) {
            localbgop.jdField_d_of_type_JavaLangString = localApp.desc.get();
          }
          if (localApp.added.has())
          {
            if (localApp.added.get() == 1)
            {
              bool = true;
              label259:
              localbgop.jdField_a_of_type_Boolean = bool;
            }
          }
          else
          {
            if (localApp.redpoint.has()) {
              localbgop.jdField_d_of_type_Int = localApp.redpoint.get();
            }
            if (localApp.cmd_trace.has()) {
              localbgop.jdField_e_of_type_JavaLangString = localApp.cmd_trace.get();
            }
            if (localApp.show_frame.has()) {
              localbgop.jdField_e_of_type_Int = localApp.show_frame.get();
            }
            if (localApp.playing_num.has()) {
              localbgop.f = localApp.playing_num.get();
            }
            localbgop.jdField_a_of_type_Int = 0;
            localArrayList.add(localbgop);
            if (QLog.isColorLevel()) {
              QLog.d("TroopAppShortcutContainer", 2, "info:" + localbgop.toString());
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          bool = false;
          break label259;
          QLog.e("TroopAppShortcutContainer", 2, "get appinfo error:" + localApp.toString());
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps troopuin:" + this.jdField_a_of_type_Long + " dwGroupClassExt" + ((TroopInfo)localObject).dwGroupClassExt + " page:" + paramInt3 + " from:" + paramInt3);
        }
        this.jdField_a_of_type_Aoip.a(this.jdField_a_of_type_Long, (int)((TroopInfo)localObject).dwGroupClassExt, paramInt1, paramInt2, paramInt3);
        this.jdField_a_of_type_Bgoo.a();
      }
    }
    else
    {
      return;
    }
    QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
  }
  
  private void a(ArrayList<bgop> paramArrayList)
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
      l3 = ((bgop)paramArrayList.get(i)).jdField_b_of_type_Long;
      j = this.jdField_a_of_type_Int;
      if (((bgop)paramArrayList.get(i)).jdField_a_of_type_Long != 0L) {
        break label112;
      }
    }
    label112:
    for (String str = "1";; str = "2")
    {
      bdll.b(null, "dc00898", "", String.valueOf(l1), "0X800AFBA", "0X800AFBA", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(j), str);
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
      bgor localbgor = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
      if (localbgor != null) {
        localbgor.a(this.jdField_a_of_type_Long, (ArrayList)localObject);
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
      localObject = this.jdField_a_of_type_Bgoo.a(1);
      if (paramRspBody.reach_tail.get() == 1)
      {
        bool = true;
        ((bgoo)localObject).a(bool).b();
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
        localObject = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
        if (localObject != null) {
          ((bgor)localObject).b(this.jdField_a_of_type_Long, paramRspBody);
        }
        f();
        if (paramRspBody.size() > 0)
        {
          bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBB", "0X800AFBB", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
          this.jdField_e_of_type_Int = 0;
        }
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Bgoo.a(1).a(true).b();
    }
  }
  
  private void a(oidb_0xe2e.RspBody paramRspBody, int paramInt)
  {
    boolean bool = true;
    label82:
    ArrayList localArrayList;
    if (paramRspBody.reach_tail.has())
    {
      Object localObject = this.jdField_a_of_type_Bgoo.a(paramInt);
      if (paramRspBody.reach_tail.get() == 1)
      {
        ((bgoo)localObject).a(bool).b();
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps_moreRecommend reach_tail:" + paramRspBody.reach_tail.get());
        }
        paramRspBody = a((ArrayList)paramRspBody.recommend_apps.get());
        if (paramRspBody != null)
        {
          localObject = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
          if (localObject != null)
          {
            localArrayList = ((bgor)localObject).b(this.jdField_a_of_type_Long);
            if (localArrayList != null) {
              break label176;
            }
            ((bgor)localObject).b(this.jdField_a_of_type_Long, paramRspBody);
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
      this.jdField_a_of_type_Bgoo.a(paramInt).a(true).b();
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
    this.jdField_a_of_type_Bgoo.b();
    QLog.e("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps faild troopUin:" + this.jdField_a_of_type_Long + " errCode:" + paramInt + " from:" + i);
    if (paramInt == 1002)
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698525), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698527), 0).a();
  }
  
  private void b(oidb_0xe2e.RspBody paramRspBody)
  {
    this.jdField_a_of_type_Bgoo.b();
    paramRspBody = a((ArrayList)paramRspBody.get_apps.get());
    if (paramRspBody != null)
    {
      Object localObject = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
      if (localObject != null)
      {
        ((bgor)localObject).a(this.jdField_a_of_type_Long, paramRspBody);
        localObject = ((bgor)localObject).b(this.jdField_a_of_type_Long);
        int k;
        if (localObject != null)
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            bgop localbgop = (bgop)((ArrayList)localObject).get(j);
            if (paramRspBody.contains(localbgop)) {
              if (!localbgop.jdField_a_of_type_Boolean)
              {
                localbgop.jdField_a_of_type_Boolean = true;
                i = 1;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              if (localbgop.jdField_a_of_type_Boolean)
              {
                localbgop.jdField_a_of_type_Boolean = false;
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
    bgor localbgor = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localbgor != null) {
      return localbgor.a();
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (paramInt <= this.jdField_e_of_type_Int) {
      break label8;
    }
    label8:
    while (this.jdField_a_of_type_Bgon == null) {
      return;
    }
    int i = this.jdField_e_of_type_Int;
    label21:
    if (i < paramInt)
    {
      Object localObject = this.jdField_a_of_type_Bgon.a(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break label21;
        if ((localObject instanceof bgod))
        {
          localObject = ((bgny)localObject).a();
          if ((localObject == null) || (!(localObject instanceof bgop))) {
            break;
          }
          localObject = (bgop)localObject;
          bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBC", "0X800AFBC", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(((bgop)localObject).jdField_b_of_type_Long), "", ((bgop)localObject).jdField_e_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bgku);
    p();
    d();
  }
  
  private void k()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    bgor localbgor = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localbgor != null)
    {
      ArrayList localArrayList1 = localbgor.b(this.jdField_a_of_type_Long);
      if ((localArrayList1 != null) && (localArrayList1.size() > 10))
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.addAll(localArrayList1.subList(0, 10));
        localbgor.b(this.jdField_a_of_type_Long, localArrayList2);
      }
    }
    i();
    q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bgku);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    r();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362855));
    this.jdField_a_of_type_Bgon = new bgon(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bgon);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(new bgol(this));
  }
  
  private void m()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isAdminOrOwner", bgqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void n()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370775);
      if (!bgqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) {
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
    Object localObject = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localObject != null) {}
    for (localObject = ((bgor)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      if (localObject != null)
      {
        int j = ((ArrayList)localObject).size();
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(((bgop)((ArrayList)localObject).get(i)).jdField_b_of_type_Long).append("-").append(i + 1);
          if (i != j - 1) {
            localStringBuilder.append(";");
          }
          i += 1;
        }
      }
      bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC9", "0X800AFC9", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", localStringBuilder.toString(), "");
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
      bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B23B", "0X800B23B", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_c_of_type_Int), String.valueOf(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long));
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
    bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_b_of_type_Int), "");
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
    bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", String.valueOf(this.jdField_b_of_type_Int), "");
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bgon != null)
    {
      localObject = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
      if (localObject == null) {
        break label453;
      }
    }
    label453:
    for (Object localObject = ((bgor)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = new bgnv(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidOsBundle);
        bgnw localbgnw = new bgnw();
        bgkr localbgkr = ((bgks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355)).a(Long.valueOf(this.jdField_a_of_type_Long));
        boolean bool;
        if (localbgkr != null)
        {
          localbgnw.jdField_a_of_type_Bgkr = localbgkr;
          localbgnw.b = bgqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
          if (localbgnw.b) {
            if (localbgkr.b() == 0)
            {
              bool = true;
              localbgnw.jdField_a_of_type_Boolean = bool;
              bgqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbgnw, this.jdField_a_of_type_Long);
              if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutContainer", 2, new Object[] { "updateUI_aioShortCut", "info.bAdmin :" + localbgnw.b + "info.bSwith :" + localbgnw.jdField_a_of_type_Boolean + "info.bAdminShowSwitch :" + localbgnw.c + "info.bMemberShowSwitch :" + localbgnw.d + "TroopUin: " + String.valueOf(this.jdField_a_of_type_Long) });
              }
            }
          }
        }
        for (;;)
        {
          ((bgny)localObject).a(localbgnw);
          this.jdField_a_of_type_Bgon.a(0, (bgny)localObject);
          if ((paramInt == 1) && (!localbgnw.b) && (localbgnw.d) && (localbgnw.jdField_a_of_type_Bgkr.b() == 0)) {
            bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC0", "0X800AFC0", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
          }
          return;
          bool = false;
          break;
          if (localbgkr.a() == 0) {}
          for (bool = true;; bool = false)
          {
            localbgnw.jdField_a_of_type_Boolean = bool;
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("TroopAppShortcutContainer", 2, "updateUI_aioShortCut. troopShortcutBarInfo is null, TroopUin: " + String.valueOf(this.jdField_a_of_type_Long));
          }
        }
      }
      this.jdField_a_of_type_Bgon.a(0, new ArrayList());
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
    this.jdField_a_of_type_Bgoo.a();
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
    Object localObject = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localObject != null) {}
    for (localObject = ((bgor)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      if (this.jdField_a_of_type_Bgon != null)
      {
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll((Collection)localObject);
          localObject = new bgnz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle);
          ((bgny)localObject).a(localArrayList);
          this.jdField_a_of_type_Bgon.a(1, (bgny)localObject);
        }
      }
      else {
        return;
      }
      this.jdField_a_of_type_Bgon.a(1, new ArrayList());
      return;
    }
  }
  
  public void f()
  {
    if (!b()) {
      if (this.jdField_a_of_type_Bgon != null)
      {
        this.jdField_a_of_type_Bgon.a(2, new ArrayList());
        this.jdField_a_of_type_Bgon.a(3, new ArrayList());
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
      if (localObject1 != null) {}
      for (localObject1 = ((bgor)localObject1).b(this.jdField_a_of_type_Long); this.jdField_a_of_type_Bgon != null; localObject1 = null)
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          Object localObject2 = new bgog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Bgon.a(2, (bgny)localObject2);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            bgod localbgod = new bgod(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidOsBundle);
            localbgod.a(((ArrayList)localObject1).get(i));
            ((List)localObject2).add(localbgod);
            i += 1;
          }
          this.jdField_a_of_type_Bgon.a(3, (List)localObject2);
          return;
        }
        this.jdField_a_of_type_Bgon.a(2, new ArrayList());
        this.jdField_a_of_type_Bgon.a(3, new ArrayList());
        return;
      }
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "onDestroy");
    }
    bgor localbgor = (bgor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localbgor != null) {
      localbgor.a();
    }
    k();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bgoi == null) {
      this.jdField_a_of_type_Bgoi = new bgoi(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Bgoi.show();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bgoi != null)
    {
      this.jdField_a_of_type_Bgoi.dismiss();
      this.jdField_a_of_type_Bgoi = null;
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
      case 2131363233: 
        o();
        break;
      case 2131370775: 
        bgqr.a(1, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
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