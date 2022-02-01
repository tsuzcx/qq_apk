package dov.com.qq.im.capture.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import anvx;
import bivb;
import bkys;
import bmvb;
import bogd;
import bogk;
import bohj;
import bohm;
import bohz;
import boia;
import boic;
import boij;
import boiu;
import boiw;
import boiz;
import bojc;
import boje;
import boki;
import booe;
import boof;
import boog;
import booh;
import boop;
import boov;
import bope;
import boph;
import bops;
import bpju;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import yzz;
import zfn;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, bivb, bohm, boph, AdapterView.OnItemClickListener
{
  public static boolean a;
  int jdField_a_of_type_Int = 0;
  public long a;
  public bkys a;
  public boiu a;
  boiw jdField_a_of_type_Boiw = new boof(this);
  boiz jdField_a_of_type_Boiz = new boog(this);
  bojc jdField_a_of_type_Bojc = new booh(this);
  private boje jdField_a_of_type_Boje;
  public MusicItemInfo a;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  MusicProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter;
  List<boia> jdField_a_of_type_JavaUtilList;
  public int b;
  public MusicItemInfo b;
  public boolean b;
  public int c;
  private MusicItemInfo c;
  public int d = -1;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h;
  
  public MusicProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boiu = new booe(this);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3) {
      return 5;
    }
    if ((paramInt == 4) || (paramInt == 12) || (paramInt == 8)) {
      return 3;
    }
    if (paramInt == 10) {
      return 4;
    }
    return 2;
  }
  
  public static MusicItemInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = ((QIMMusicConfigManager)bogd.a(2)).a();
    if (localArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        if (i >= localArrayList.size()) {
          break label129;
        }
        boia localboia = (boia)localArrayList.get(i);
        if ((localboia != null) && (localboia.jdField_a_of_type_JavaUtilList != null))
        {
          int j = 0;
          for (;;)
          {
            if (j >= localboia.jdField_a_of_type_JavaUtilList.size()) {
              break label122;
            }
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localboia.jdField_a_of_type_JavaUtilList.get(j);
            if (localMusicItemInfo != null)
            {
              localObject = localMusicItemInfo;
              if (paramString.equals(localMusicItemInfo.getLocalPath())) {
                break;
              }
            }
            j += 1;
          }
        }
        label122:
        i += 1;
      }
    }
    label129:
    return null;
  }
  
  private List<boia> a(List<boia> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      boia localboia = (boia)paramList.next();
      if (localboia.jdField_b_of_type_Boolean)
      {
        localArrayList.add(localboia);
        localStringBuilder.append(localboia.jdField_a_of_type_JavaLangString).append(",");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "filterMusicList, ", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_Boop != null) {
      this.jdField_a_of_type_Boop.a(107, new Object[] { paramMusicItemInfo });
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject = ((QIMMusicConfigManager)bogd.a(2)).a();
    if (localObject != null) {
      localObject = a((List)localObject);
    }
    for (;;)
    {
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getBundle(MusicProviderView.class.getSimpleName());; paramBundle = null)
      {
        if ((paramBundle != null) && (localObject != null))
        {
          this.jdField_b_of_type_Int = paramBundle.getInt("capture_mode", 0);
          MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramBundle.getParcelable("select_music");
          paramBundle = paramBundle.getString("select_music_local_path");
          if ((localMusicItemInfo != null) && (!TextUtils.isEmpty(paramBundle))) {
            localMusicItemInfo.setPath(paramBundle);
          }
          this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
          paramBundle = localMusicItemInfo;
          if (localMusicItemInfo != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("MusicProviderView", 2, "restore music" + localMusicItemInfo.mMusicName);
            }
            int i = 0;
            for (;;)
            {
              paramBundle = localMusicItemInfo;
              if (i >= ((List)localObject).size()) {
                break;
              }
              boia localboia = (boia)((List)localObject).get(i);
              if (localboia.jdField_a_of_type_JavaLangString.equals(localMusicItemInfo.mTagName))
              {
                int j = 0;
                for (;;)
                {
                  paramBundle = localMusicItemInfo;
                  if (j >= localboia.jdField_a_of_type_JavaUtilList.size()) {
                    break;
                  }
                  if (localMusicItemInfo.equals((MusicItemInfo)localboia.jdField_a_of_type_JavaUtilList.get(j)))
                  {
                    this.jdField_c_of_type_Int = i;
                    this.d = j;
                  }
                  j += 1;
                }
              }
              i += 1;
            }
          }
        }
        else
        {
          paramBundle = null;
        }
        if (paramBundle == null) {
          new MusicItemInfo().mType = 2;
        }
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter == null) {}
    long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
      int k = this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a();
      int i = 0;
      if (i < k)
      {
        GridView localGridView = this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(i);
        if (localGridView == null) {}
        for (;;)
        {
          i += 1;
          break;
          int m = localGridView.getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView = localGridView.getChildAt(j);
            ((bogk)localGridView.getAdapter()).a(localView);
            j += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - l));
  }
  
  protected int a()
  {
    return 2131560922;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Boiu);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    ((QIMMusicConfigManager)bogd.a(2)).b(this.jdField_a_of_type_Bojc);
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Boje != null)) {
      this.jdField_a_of_type_Boje.c();
    }
    if (this.jdField_a_of_type_Boje != null)
    {
      this.jdField_a_of_type_Boje.b(this.jdField_a_of_type_Boiz);
      this.jdField_a_of_type_Boje = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    super.a(paramInt1, paramInt2, paramIntent);
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getBooleanExtra("story_video_publishing", false)) {
        bool1 = true;
      }
    }
    this.jdField_h_of_type_Boolean = bool1;
    if (paramInt1 == 1001) {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "doOnActivityResult qqMusic resultCode = " + paramInt2 + ", data = " + paramIntent);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != 0) || (this.jdField_g_of_type_Int != 0) || (this.jdField_a_of_type_Boje == null));
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
      {
        this.jdField_a_of_type_Boje.a(this.jdField_g_of_type_Int);
        return;
      }
    } while (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null);
    if ((this.f) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_Boje.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_g_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boje.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "selectCategoryAndItem category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramInt != -1) && (((boia)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      a().onTabChecked(paramInt);
      boia localboia = (boia)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
      try
      {
        i = Integer.valueOf(paramString2).intValue();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          label216:
          i = -1;
          label362:
          paramString1.printStackTrace();
          int j = i;
          continue;
          label373:
          i += 1;
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicProviderView", 2, "selectCategoryAndItem itemID= " + i);
        }
        j = i;
        i = 0;
        if (i >= localboia.jdField_a_of_type_JavaUtilList.size()) {
          break label386;
        }
        paramString1 = (MusicItemInfo)localboia.jdField_a_of_type_JavaUtilList.get(i);
        if (paramString1.mItemId != j) {
          break label373;
        }
      }
      catch (Exception paramString1)
      {
        break label362;
        label386:
        i = 0;
        paramString1 = null;
        break label216;
      }
      if ((paramString1 != null) && (QLog.isColorLevel())) {
        QLog.d("MusicProviderView", 2, hashCode() + "selectCategoryAndItem itemInfo= " + paramString1.mMusicName + ",index=" + paramInt + ",pos=" + i);
      }
      if (paramString1 != null)
      {
        postDelayed(new MusicProviderView.5(this, i), 500L);
        a(paramString1);
        i();
      }
      return;
      if ((paramString1 != null) && (paramString1.equals(((boia)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        paramInt = i;
      }
      else
      {
        i += 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131166307));
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560922, this, false));
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      new bops(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
      a(false);
      h();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Boiu);
      paramBundle = (QIMMusicConfigManager)bogd.a(2);
      paramBundle.a(this.jdField_a_of_type_Bojc);
      paramBundle.a();
      ((bohj)bogd.a(5)).a(this);
      if (this.jdField_a_of_type_Boje == null) {
        this.jdField_a_of_type_Boje = ((boje)bogd.a().c(8));
      }
      this.jdField_a_of_type_Boje.a(this.jdField_a_of_type_Boiz);
      paramBundle = this.jdField_a_of_type_Boje;
      if (this.jdField_g_of_type_Int != 0) {
        break label265;
      }
    }
    label265:
    for (int i = bmvb.jdField_b_of_type_Int;; i = bmvb.jdField_c_of_type_Int)
    {
      paramBundle.c(i);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView);
      break;
    }
  }
  
  public void a(bohz parambohz) {}
  
  public void a(bohz parambohz, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Boje != null)) {
      this.jdField_a_of_type_Boje.d();
    }
  }
  
  public void a(boic paramboic, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(boij paramboij, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpju parambpju) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    a(paramMusicItemInfo, false);
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    if (paramMusicItemInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "startMusic itemInfo=null");
      }
    }
    label77:
    do
    {
      return;
      if (this.jdField_a_of_type_Boje == null) {
        this.jdField_a_of_type_Boje = ((boje)bogd.a().c(8));
      }
      if (this.jdField_a_of_type_Boje.b(paramMusicItemInfo))
      {
        if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean)) {
          this.jdField_a_of_type_Boje.a(paramMusicItemInfo, this.jdField_g_of_type_Int);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.jdField_g_of_type_Int);
          return;
          this.jdField_a_of_type_Boje.a(paramMusicItemInfo);
          if (this.jdField_a_of_type_Boop != null)
          {
            paramMusicItemInfo = this.jdField_a_of_type_Boop;
            if (paramBoolean) {
              break label150;
            }
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramMusicItemInfo.c(paramBoolean);
          break label77;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
      this.jdField_a_of_type_Boje.a(paramMusicItemInfo, this.jdField_a_of_type_Boiw);
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_a_of_type_Bkys, 6, paramMusicItemInfo);
      this.jdField_a_of_type_Bkys.sendMessageDelayed(localMessage, 60000L);
      boov.a(paramMusicItemInfo).a();
    } while (!QLog.isColorLevel());
    label150:
    QLog.d("MusicProviderView", 2, "startMusic requestDownLoadMusicInfo" + this.jdField_g_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "updateData MusicProviderView not init");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "updateData");
    }
    Object localObject = (QIMMusicConfigManager)bogd.a(2);
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem();
    this.jdField_a_of_type_JavaUtilList = ((QIMMusicConfigManager)localObject).a(paramBoolean);
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList);
    localObject = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bope localbope = new bope();
      localbope.jdField_a_of_type_JavaLangString = ((boia)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      if (((boia)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 999) {
        localbope.jdField_a_of_type_Int = 2130844522;
      }
      for (localbope.jdField_b_of_type_Int = 2130844523;; localbope.jdField_b_of_type_Int = 0)
      {
        ((ArrayList)localObject).add(localbope);
        i += 1;
        break;
        localbope.jdField_a_of_type_Int = 0;
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithIconString((ArrayList)localObject);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(j);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(j);
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boje != null) {
      this.jdField_a_of_type_Boje.a(this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    ((bohj)bogd.a(5)).a(this);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boje == null) {
      return false;
    }
    return this.jdField_a_of_type_Boje.b();
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("MusicProviderView", 2, "onProviderShow isAccountChange=" + this.e + " isInit=" + d());
    }
    if ((this.e) && (d())) {
      a(false);
    }
    for (;;)
    {
      this.e = false;
      return;
      i();
    }
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "music tab onResume");
    }
    ((bohj)bogd.a(5)).a(this);
    Object localObject;
    if (this.jdField_a_of_type_Boje != null)
    {
      this.jdField_a_of_type_Boje.a(this.jdField_a_of_type_Boiz);
      localObject = this.jdField_a_of_type_Boje;
      if (this.jdField_g_of_type_Int != 0) {
        break label154;
      }
    }
    label154:
    for (int i = bmvb.jdField_b_of_type_Int;; i = bmvb.jdField_c_of_type_Int)
    {
      ((boje)localObject).c(i);
      if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Boje != null) && (this.f) && (!this.jdField_h_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Boje.a();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.jdField_g_of_type_Boolean)) {
          this.jdField_a_of_type_Boje.a();
        }
      }
      if ((this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null)) {
        a(true);
      }
      return;
    }
  }
  
  public void f()
  {
    if (bogd.a().a(5)) {
      ((bohj)bogd.a().c(5)).b(this);
    }
    StringBuilder localStringBuilder;
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Boje != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Boje.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onStop  mSaveMusicInfo=");
        if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
          break label107;
        }
      }
    }
    label107:
    for (Object localObject = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;; localObject = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName)
    {
      QLog.d("MusicProviderView", 2, localObject);
      this.jdField_a_of_type_Boje.b(this.jdField_g_of_type_Int);
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boje == null) {
      this.jdField_a_of_type_Boje = ((boje)bogd.a().c(8));
    }
    this.jdField_a_of_type_Boje.a(this.jdField_a_of_type_Boiz);
  }
  
  public void h()
  {
    if (this.jdField_c_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_c_of_type_Int);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if ((getContext() instanceof AppActivity))
      {
        if (((AppActivity)getContext()).isResume()) {
          break label264;
        }
        bool = true;
      }
      break;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, bool);
      i();
      return false;
      if (((getContext() instanceof BaseActivity)) && (!((BaseActivity)getContext()).isResume()))
      {
        bool = true;
        continue;
        i();
        return false;
        a(false);
        return false;
        if (paramMessage.obj == null) {
          break;
        }
        b((MusicItemInfo)paramMessage.obj);
        return false;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131706509), 0).a();
        i();
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (!paramMessage.isFileExist())
        {
          if (!paramMessage.isDownloading()) {
            break;
          }
          if (this.jdField_a_of_type_Boje != null) {
            this.jdField_a_of_type_Boje.a(paramMessage);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName, paramMessage.mMusicName))) {
            QQToast.a(BaseApplicationImpl.sApplication, anvx.a(2131706510), 0).a();
          }
          i();
          return false;
        }
        boov.a(paramMessage).b();
        return false;
      }
      label264:
      bool = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      paramAdapterView = (boia)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    } while (paramInt >= paramAdapterView.jdField_a_of_type_JavaUtilList.size());
    ((QIMMusicConfigManager)bogd.a(2)).a = paramAdapterView;
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramAdapterView.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.jdField_a_of_type_Boje != null) {
      this.jdField_a_of_type_Boje.a();
    }
    ((boki)bogd.a(14)).a(String.valueOf(localMusicItemInfo.mItemId), 2);
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "onItemClick,  type:" + localMusicItemInfo.mType + "  " + localMusicItemInfo);
    }
    if (localMusicItemInfo.mType == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramInt = a(this.jdField_h_of_type_Int);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.getIMEI(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (yzz.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 3);
      }
      paramView.putExtra("finish_animation_up_down", true);
      paramAdapterView.startActivityForResult(paramView, 1001);
      paramAdapterView.overridePendingTransition(2130771979, 0);
      return;
    }
    if (localMusicItemInfo.isWsBanner())
    {
      zfn.a(this.jdField_a_of_type_AndroidContentContext, localMusicItemInfo);
      return;
    }
    if (localMusicItemInfo.mType == 3) {
      if (yzz.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 2);
      }
    }
    for (;;)
    {
      paramAdapterView = null;
      if (this.jdField_a_of_type_Boje != null) {
        paramAdapterView = this.jdField_a_of_type_Boje.b();
      }
      if ((localMusicItemInfo.mType != 5) || ((!localMusicItemInfo.equals(paramAdapterView)) && (localMusicItemInfo.isFileExist()))) {
        break;
      }
      b(localMusicItemInfo);
      return;
      if ((localMusicItemInfo.mType == 1) && (yzz.a().b() == 22)) {
        LpReportInfo_pf00064.allReport(680, 3, 4);
      }
    }
    paramView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    i();
    ((bohj)bogd.a(5)).a(this.jdField_g_of_type_Int, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onTabChecked(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
  }
  
  public void setChangeMusicEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setPreSelectTagIndex(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicProviderView
 * JD-Core Version:    0.7.0.1
 */