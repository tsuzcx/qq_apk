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
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import anni;
import bgln;
import bglp;
import bgpa;
import bkgm;
import bkij;
import bncu;
import bojv;
import bokc;
import bolb;
import bole;
import bolr;
import bols;
import bolu;
import bomb;
import bomu;
import bomw;
import bomz;
import bonc;
import bone;
import bonv;
import bopp;
import botl;
import botm;
import botn;
import boto;
import botp;
import botq;
import botr;
import bots;
import boty;
import boud;
import boun;
import bouq;
import bovg;
import bpyf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import zgl;
import zmi;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, bkij, bole, bouq
{
  public static boolean a;
  int jdField_a_of_type_Int = 0;
  public long a;
  public bkgm a;
  public bomu a;
  bomw jdField_a_of_type_Bomw = new botm(this);
  bomz jdField_a_of_type_Bomz = new botn(this);
  bonc jdField_a_of_type_Bonc = new boto(this);
  private bone jdField_a_of_type_Bone;
  public MusicItemInfo a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  MusicProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter;
  List<bols> jdField_a_of_type_JavaUtilList;
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
  private int i = -1;
  
  public MusicProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bomu = new botl(this);
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
    ArrayList localArrayList = ((QIMMusicConfigManager)bojv.a(2)).a();
    if (localArrayList != null)
    {
      int j = 0;
      for (;;)
      {
        if (j >= localArrayList.size()) {
          break label129;
        }
        bols localbols = (bols)localArrayList.get(j);
        if ((localbols != null) && (localbols.jdField_a_of_type_JavaUtilList != null))
        {
          int k = 0;
          for (;;)
          {
            if (k >= localbols.jdField_a_of_type_JavaUtilList.size()) {
              break label122;
            }
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localbols.jdField_a_of_type_JavaUtilList.get(k);
            if (localMusicItemInfo != null)
            {
              localObject = localMusicItemInfo;
              if (paramString.equals(localMusicItemInfo.getLocalPath())) {
                break;
              }
            }
            k += 1;
          }
        }
        label122:
        j += 1;
      }
    }
    label129:
    return null;
  }
  
  private List<bols> a(List<bols> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bols localbols = (bols)paramList.next();
      if (localbols.jdField_b_of_type_Boolean)
      {
        localArrayList.add(localbols);
        localStringBuilder.append(localbols.jdField_a_of_type_JavaLangString).append(",");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "filterMusicList, ", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bgpa localbgpa = bglp.a((Activity)getContext(), 2131697520);
    localbgpa.setNegativeButton(2131690582, new botp(this));
    localbgpa.setPositiveButton(2131694081, new botq(this, paramAdapterView, paramView, paramInt, paramLong));
    localbgpa.show();
  }
  
  private void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject = (QIMMusicConfigManager)bojv.a(2);
    if ((bonv.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Int == 2))
    {
      ((QIMMusicConfigManager)localObject).a(true);
      localObject = ((QIMMusicConfigManager)localObject).a();
      if (localObject == null) {
        break label349;
      }
      localObject = a((List)localObject);
    }
    label150:
    label323:
    label349:
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
          int j;
          if (this.jdField_b_of_type_Int == 5)
          {
            this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
            paramBundle = localMusicItemInfo;
            if (localMusicItemInfo != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("MusicProviderView", 2, "restore music" + localMusicItemInfo.mMusicName);
              }
              j = 0;
            }
          }
          else
          {
            for (;;)
            {
              paramBundle = localMusicItemInfo;
              if (j >= ((List)localObject).size()) {
                break label323;
              }
              bols localbols = (bols)((List)localObject).get(j);
              if (localbols.jdField_a_of_type_JavaLangString.equals(localMusicItemInfo.mTagName))
              {
                int k = 0;
                for (;;)
                {
                  paramBundle = localMusicItemInfo;
                  if (k >= localbols.jdField_a_of_type_JavaUtilList.size()) {
                    break;
                  }
                  if (localMusicItemInfo.equals((MusicItemInfo)localbols.jdField_a_of_type_JavaUtilList.get(k)))
                  {
                    this.jdField_c_of_type_Int = j;
                    this.d = k;
                  }
                  k += 1;
                }
                ((QIMMusicConfigManager)localObject).a(false);
                break;
                this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
                break label150;
              }
              j += 1;
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
  
  private void c(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_Boty != null) {
      this.jdField_a_of_type_Boty.a(109, new Object[] { paramMusicItemInfo });
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bone != null) {
      this.jdField_a_of_type_Bone.e();
    }
    if (this.jdField_a_of_type_Boty != null) {
      this.jdField_a_of_type_Boty.a(110, new Object[0]);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter == null) {}
    long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
      int m = this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a();
      int j = 0;
      if (j < m)
      {
        GridView localGridView = this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(j);
        if (localGridView == null) {}
        for (;;)
        {
          j += 1;
          break;
          int n = localGridView.getChildCount();
          int k = 0;
          while (k < n)
          {
            View localView = localGridView.getChildAt(k);
            ((bokc)localGridView.a()).a(localView);
            k += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - l));
  }
  
  protected int a()
  {
    return 2131560960;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Bone != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Bone.a();
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MusicProviderView", 2, "save music" + this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        }
        localBundle.putParcelable("select_music", this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
      boolean bool = this.jdField_a_of_type_Bone.b();
      if (bool) {
        localBundle.putBoolean("select_mute", bool);
      }
    }
    return localBundle;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bomu);
    }
    ((QIMMusicConfigManager)bojv.a(2)).b(this.jdField_a_of_type_Bonc);
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bone != null)) {
      this.jdField_a_of_type_Bone.e();
    }
    if (this.jdField_a_of_type_Bone != null)
    {
      this.jdField_a_of_type_Bone.b(this.jdField_a_of_type_Bomz);
      this.jdField_a_of_type_Bone = null;
    }
  }
  
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
        if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null))
        {
          if (this.jdField_a_of_type_Boty != null) {
            this.jdField_a_of_type_Boty.a(104, Integer.valueOf(1001));
          }
          a((MusicItemInfo)paramIntent.getParcelableExtra("EXTRA_HUM_RECOGNITION_RESULT"));
        }
      } while ((paramInt2 != 0) || (this.jdField_g_of_type_Int != 0) || (this.jdField_a_of_type_Bone == null));
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
      {
        this.jdField_a_of_type_Bone.a(this.jdField_g_of_type_Int);
        return;
      }
    } while (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null);
    if ((this.f) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_Bone.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_g_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Bone.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "selectCategoryAndItem category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramInt != -1) && (((bols)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int == paramInt)) {
        paramInt = j;
      }
    }
    for (;;)
    {
      a().a(paramInt);
      bols localbols = (bols)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      try
      {
        j = Integer.valueOf(paramString2).intValue();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          label216:
          j = -1;
          label362:
          paramString1.printStackTrace();
          int k = j;
          continue;
          label373:
          j += 1;
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicProviderView", 2, "selectCategoryAndItem itemID= " + j);
        }
        k = j;
        j = 0;
        if (j >= localbols.jdField_a_of_type_JavaUtilList.size()) {
          break label386;
        }
        paramString1 = (MusicItemInfo)localbols.jdField_a_of_type_JavaUtilList.get(j);
        if (paramString1.mItemId != k) {
          break label373;
        }
      }
      catch (Exception paramString1)
      {
        break label362;
        label386:
        j = 0;
        paramString1 = null;
        break label216;
      }
      if ((paramString1 != null) && (QLog.isColorLevel())) {
        QLog.d("MusicProviderView", 2, hashCode() + "selectCategoryAndItem itemInfo= " + paramString1.mMusicName + ",index=" + paramInt + ",pos=" + j);
      }
      if (paramString1 != null)
      {
        postDelayed(new MusicProviderView.5(this, j), 500L);
        a(paramString1);
        j();
      }
      return;
      if ((paramString1 != null) && (paramString1.equals(((bols)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString)))
      {
        paramInt = j;
      }
      else
      {
        j += 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131166275));
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131560960, this, false));
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      new bovg(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      a(false);
      h();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bomu);
      paramBundle = (QIMMusicConfigManager)bojv.a(2);
      paramBundle.a(this.jdField_a_of_type_Bonc);
      paramBundle.e();
      ((bolb)bojv.a(5)).a(this);
      if (this.jdField_a_of_type_Bone == null) {
        this.jdField_a_of_type_Bone = ((bone)bojv.a().c(8));
      }
      this.jdField_a_of_type_Bone.a(this.jdField_a_of_type_Bomz);
      paramBundle = this.jdField_a_of_type_Bone;
      if (this.jdField_g_of_type_Int != 0) {
        break label265;
      }
    }
    label265:
    for (int j = bncu.jdField_b_of_type_Int;; j = bncu.jdField_c_of_type_Int)
    {
      paramBundle.d(j);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView);
      break;
    }
  }
  
  public void a(bolr parambolr) {}
  
  public void a(bolr parambolr, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Bone != null)) {
      this.jdField_a_of_type_Bone.f();
    }
  }
  
  public void a(bolu parambolu, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bomb parambomb, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpyf parambpyf) {}
  
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
      if (this.jdField_a_of_type_Bone == null) {
        this.jdField_a_of_type_Bone = ((bone)bojv.a().c(8));
      }
      if (this.jdField_a_of_type_Bone.b(paramMusicItemInfo))
      {
        if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean)) {
          this.jdField_a_of_type_Bone.a(paramMusicItemInfo, this.jdField_g_of_type_Int);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.jdField_g_of_type_Int);
          return;
          this.jdField_a_of_type_Bone.a(paramMusicItemInfo);
          if (this.jdField_a_of_type_Boty != null)
          {
            paramMusicItemInfo = this.jdField_a_of_type_Boty;
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
      this.jdField_a_of_type_Bone.a(paramMusicItemInfo, this.jdField_a_of_type_Bomw);
      this.jdField_a_of_type_Bkgm.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_a_of_type_Bkgm, 6, paramMusicItemInfo);
      this.jdField_a_of_type_Bkgm.sendMessageDelayed(localMessage, 60000L);
      boud.a(paramMusicItemInfo).a();
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
    Object localObject = (QIMMusicConfigManager)bojv.a(2);
    int k = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    int j;
    label113:
    boun localboun;
    if ((bonv.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Int == 2))
    {
      ((QIMMusicConfigManager)localObject).a(true);
      this.jdField_a_of_type_JavaUtilList = ((QIMMusicConfigManager)localObject).a(paramBoolean);
      this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList);
      localObject = new ArrayList();
      this.i = -1;
      j = 0;
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label238;
      }
      localboun = new boun();
      localboun.jdField_a_of_type_JavaLangString = ((bols)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString;
      if (((bols)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int != 999) {
        break label223;
      }
      this.i = j;
      localboun.jdField_a_of_type_Int = 2130844571;
    }
    for (localboun.jdField_b_of_type_Int = 2130844572;; localboun.jdField_b_of_type_Int = 0)
    {
      ((ArrayList)localObject).add(localboun);
      j += 1;
      break label113;
      ((QIMMusicConfigManager)localObject).a(false);
      break;
      label223:
      localboun.jdField_a_of_type_Int = 0;
    }
    label238:
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.c((ArrayList)localObject);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(k);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(k);
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bone != null) {
      this.jdField_a_of_type_Bone.a(this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    if (paramInt != 0) {
      k();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    ((bolb)bojv.a(5)).a(this);
  }
  
  public void b(MusicItemInfo paramMusicItemInfo)
  {
    bgpa localbgpa = bglp.a((Activity)getContext(), 2131697520);
    localbgpa.setNegativeButton(2131690582, new botr(this));
    localbgpa.setPositiveButton(2131694081, new bots(this, paramMusicItemInfo));
    localbgpa.show();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (!paramBoolean)) {
      this.jdField_b_of_type_Boolean = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_Bone = ((bone)bojv.a().c(8));
    } while (this.jdField_a_of_type_Bone == null);
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bone.a();
    this.jdField_a_of_type_Bone.a(localMusicItemInfo, true, this.jdField_g_of_type_Int);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bone == null) {
      return false;
    }
    return this.jdField_a_of_type_Bone.c();
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
      j();
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
    ((bolb)bojv.a(5)).a(this);
    Object localObject;
    if (this.jdField_a_of_type_Bone != null)
    {
      this.jdField_a_of_type_Bone.a(this.jdField_a_of_type_Bomz);
      localObject = this.jdField_a_of_type_Bone;
      if (this.jdField_g_of_type_Int != 0) {
        break label154;
      }
    }
    label154:
    for (int j = bncu.jdField_b_of_type_Int;; j = bncu.jdField_c_of_type_Int)
    {
      ((bone)localObject).d(j);
      if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bone != null) && (this.f) && (!this.jdField_h_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Bone.a();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.jdField_g_of_type_Boolean)) {
          this.jdField_a_of_type_Bone.c();
        }
      }
      if ((this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)) {
        a(true);
      }
      return;
    }
  }
  
  public void f()
  {
    if (bojv.a().a(5)) {
      ((bolb)bojv.a().c(5)).b(this);
    }
    StringBuilder localStringBuilder;
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bone != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Bone.a();
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
      this.jdField_a_of_type_Bone.b(this.jdField_g_of_type_Int);
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bone == null) {
      this.jdField_a_of_type_Bone = ((bone)bojv.a().c(8));
    }
    this.jdField_a_of_type_Bone.a(this.jdField_a_of_type_Bomz);
  }
  
  public void h()
  {
    if (this.jdField_c_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.jdField_c_of_type_Int);
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
      j();
      return false;
      if (((getContext() instanceof BaseActivity)) && (!((BaseActivity)getContext()).isResume()))
      {
        bool = true;
        continue;
        j();
        return false;
        a(false);
        return false;
        if (paramMessage.obj == null) {
          break;
        }
        c((MusicItemInfo)paramMessage.obj);
        return false;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, anni.a(2131705820), 0).a();
        j();
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (!paramMessage.isFileExist())
        {
          if (!paramMessage.isDownloading()) {
            break;
          }
          if (this.jdField_a_of_type_Bone != null) {
            this.jdField_a_of_type_Bone.a(paramMessage);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName, paramMessage.mMusicName))) {
            QQToast.a(BaseApplicationImpl.sApplication, anni.a(2131705821), 0).a();
          }
          j();
          return false;
        }
        boud.a(paramMessage).b();
        return false;
      }
      label264:
      bool = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      localObject = (bols)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    } while (paramInt >= ((bols)localObject).jdField_a_of_type_JavaUtilList.size());
    ((QIMMusicConfigManager)bojv.a(2)).a = ((bols)localObject);
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)((bols)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = null;
    if (this.jdField_a_of_type_Bone != null) {
      localObject = this.jdField_a_of_type_Bone.a();
    }
    if ((jdField_a_of_type_Boolean) && (localObject != null) && (((MusicItemInfo)localObject).mItemId != localMusicItemInfo.mItemId) && (((MusicItemInfo)localObject).mType == 5))
    {
      a(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    ((bopp)bojv.a(14)).a(String.valueOf(localMusicItemInfo.mItemId), 2);
    if (localMusicItemInfo.mType == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramInt = a(this.jdField_h_of_type_Int);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { bgln.a(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (zgl.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 3);
      }
      paramView.putExtra("finish_animation_up_down", true);
      paramAdapterView.startActivityForResult(paramView, 1001);
      paramAdapterView.overridePendingTransition(2130771979, 0);
      return;
    }
    if (localMusicItemInfo.mType == 6)
    {
      paramAdapterView = (Activity)getContext();
      paramAdapterView.startActivityForResult(new Intent(paramAdapterView, HummingActivity.class), 131);
      return;
    }
    if (localMusicItemInfo.mType == 8) {
      i();
    }
    for (;;)
    {
      paramAdapterView = null;
      if (this.jdField_a_of_type_Bone != null) {
        paramAdapterView = this.jdField_a_of_type_Bone.b();
      }
      if ((localMusicItemInfo.mType != 5) || ((!localMusicItemInfo.equals(paramAdapterView)) && (localMusicItemInfo.isFileExist()))) {
        break;
      }
      c(localMusicItemInfo);
      return;
      if (localMusicItemInfo.isWsBanner())
      {
        zmi.a(this.jdField_a_of_type_AndroidContentContext, localMusicItemInfo);
        return;
      }
      if (localMusicItemInfo.mType == 3)
      {
        if (zgl.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 3, 2);
        }
      }
      else if ((localMusicItemInfo.mType == 1) && (zgl.a().b() == 22)) {
        LpReportInfo_pf00064.allReport(680, 3, 4);
      }
    }
    paramView.setSelected(true);
    if ((localMusicItemInfo.mType == 2) && (this.jdField_b_of_type_Int == 5) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;; this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      j();
      ((bolb)bojv.a(5)).a(this.jdField_g_of_type_Int, (Activity)this.jdField_a_of_type_AndroidContentContext);
      k();
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
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