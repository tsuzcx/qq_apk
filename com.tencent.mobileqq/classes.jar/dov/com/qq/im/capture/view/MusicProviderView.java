package dov.com.qq.im.capture.view;

import ajjy;
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
import babp;
import babr;
import bafb;
import bbmy;
import befq;
import behi;
import bhey;
import bhfm;
import bhft;
import bhgs;
import bhgv;
import bhhh;
import bhhi;
import bhhk;
import bhhr;
import bhik;
import bhim;
import bhip;
import bhis;
import bhiu;
import bhjl;
import bhlf;
import bhpc;
import bhpd;
import bhpe;
import bhpf;
import bhpg;
import bhph;
import bhpi;
import bhpj;
import bhpp;
import bhpu;
import bhqe;
import bhqh;
import bhqx;
import bjad;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
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
import vhg;
import vnd;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, behi, bhgv, bhqh
{
  public static boolean a;
  int jdField_a_of_type_Int = 0;
  public long a;
  public befq a;
  public bhik a;
  bhim jdField_a_of_type_Bhim = new bhpd(this);
  bhip jdField_a_of_type_Bhip = new bhpe(this);
  bhis jdField_a_of_type_Bhis = new bhpf(this);
  private bhiu jdField_a_of_type_Bhiu;
  public MusicItemInfo a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  MusicProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter;
  List<bhhi> jdField_a_of_type_JavaUtilList;
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
    this.jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bhik = new bhpc(this);
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
    ArrayList localArrayList = ((QIMMusicConfigManager)bhfm.a(2)).a();
    if (localArrayList != null)
    {
      int j = 0;
      for (;;)
      {
        if (j >= localArrayList.size()) {
          break label129;
        }
        bhhi localbhhi = (bhhi)localArrayList.get(j);
        if ((localbhhi != null) && (localbhhi.jdField_a_of_type_JavaUtilList != null))
        {
          int k = 0;
          for (;;)
          {
            if (k >= localbhhi.jdField_a_of_type_JavaUtilList.size()) {
              break label122;
            }
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localbhhi.jdField_a_of_type_JavaUtilList.get(k);
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
  
  private List<bhhi> a(List<bhhi> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bhhi localbhhi = (bhhi)paramList.next();
      if (localbhhi.jdField_b_of_type_Boolean)
      {
        localArrayList.add(localbhhi);
        localStringBuilder.append(localbhhi.jdField_a_of_type_JavaLangString).append(",");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "filterMusicList, ", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bafb localbafb = babr.a((Activity)getContext(), 2131632585);
    localbafb.setNegativeButton(2131625035, new bhpg(this));
    localbafb.setPositiveButton(2131629116, new bhph(this, paramAdapterView, paramView, paramInt, paramLong));
    localbafb.show();
  }
  
  private void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject = (QIMMusicConfigManager)bhfm.a(2);
    if ((bhjl.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Int == 2))
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
              bhhi localbhhi = (bhhi)((List)localObject).get(j);
              if (localbhhi.jdField_a_of_type_JavaLangString.equals(localMusicItemInfo.mTagName))
              {
                int k = 0;
                for (;;)
                {
                  paramBundle = localMusicItemInfo;
                  if (k >= localbhhi.jdField_a_of_type_JavaUtilList.size()) {
                    break;
                  }
                  if (localMusicItemInfo.equals((MusicItemInfo)localbhhi.jdField_a_of_type_JavaUtilList.get(k)))
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
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.a(109, new Object[] { paramMusicItemInfo });
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bhiu != null) {
      this.jdField_a_of_type_Bhiu.e();
    }
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.a(110, new Object[0]);
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
            ((bhft)localGridView.a()).a(localView);
            k += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - l));
  }
  
  protected int a()
  {
    return 2131494988;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Bhiu != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Bhiu.a();
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MusicProviderView", 2, "save music" + this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        }
        localBundle.putParcelable("select_music", this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
      boolean bool = this.jdField_a_of_type_Bhiu.b();
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bhik);
    }
    ((QIMMusicConfigManager)bhfm.a(2)).b(this.jdField_a_of_type_Bhis);
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bhiu != null)) {
      this.jdField_a_of_type_Bhiu.e();
    }
    if (this.jdField_a_of_type_Bhiu != null)
    {
      this.jdField_a_of_type_Bhiu.b(this.jdField_a_of_type_Bhip);
      this.jdField_a_of_type_Bhiu = null;
    }
  }
  
  public void a(int paramInt)
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
          if (this.jdField_a_of_type_Bhpp != null) {
            this.jdField_a_of_type_Bhpp.a(104, Integer.valueOf(1001));
          }
          a((MusicItemInfo)paramIntent.getParcelableExtra("EXTRA_HUM_RECOGNITION_RESULT"));
        }
      } while ((paramInt2 != 0) || (this.jdField_g_of_type_Int != 0) || (this.jdField_a_of_type_Bhiu == null));
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
      {
        this.jdField_a_of_type_Bhiu.a(this.jdField_g_of_type_Int);
        return;
      }
    } while (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null);
    if ((this.f) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_Bhiu.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_g_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Bhiu.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "selectCategoryAndItem category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramInt != -1) && (((bhhi)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int == paramInt)) {
        paramInt = j;
      }
    }
    for (;;)
    {
      a().a(paramInt);
      bhhi localbhhi = (bhhi)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
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
        if (j >= localbhhi.jdField_a_of_type_JavaUtilList.size()) {
          break label386;
        }
        paramString1 = (MusicItemInfo)localbhhi.jdField_a_of_type_JavaUtilList.get(j);
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
      if ((paramString1 != null) && (paramString1.equals(((bhhi)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString)))
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
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131100565));
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131494988, this, false));
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      new bhqx(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      a(false);
      h();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bhik);
      paramBundle = (QIMMusicConfigManager)bhfm.a(2);
      paramBundle.a(this.jdField_a_of_type_Bhis);
      paramBundle.d();
      ((bhgs)bhfm.a(5)).a(this);
      if (this.jdField_a_of_type_Bhiu == null) {
        this.jdField_a_of_type_Bhiu = ((bhiu)bhfm.a().c(8));
      }
      this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_Bhip);
      paramBundle = this.jdField_a_of_type_Bhiu;
      if (this.jdField_g_of_type_Int != 0) {
        break label265;
      }
    }
    label265:
    for (int j = bhey.jdField_b_of_type_Int;; j = bhey.jdField_c_of_type_Int)
    {
      paramBundle.d(j);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView);
      break;
    }
  }
  
  public void a(bhhh parambhhh) {}
  
  public void a(bhhh parambhhh, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Bhiu != null)) {
      this.jdField_a_of_type_Bhiu.f();
    }
  }
  
  public void a(bhhk parambhhk, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bhhr parambhhr, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjad parambjad) {}
  
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
      if (this.jdField_a_of_type_Bhiu == null) {
        this.jdField_a_of_type_Bhiu = ((bhiu)bhfm.a().c(8));
      }
      if (this.jdField_a_of_type_Bhiu.b(paramMusicItemInfo))
      {
        if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean)) {
          this.jdField_a_of_type_Bhiu.a(paramMusicItemInfo, this.jdField_g_of_type_Int);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.jdField_g_of_type_Int);
          return;
          this.jdField_a_of_type_Bhiu.a(paramMusicItemInfo);
          if (this.jdField_a_of_type_Bhpp != null)
          {
            paramMusicItemInfo = this.jdField_a_of_type_Bhpp;
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
      this.jdField_a_of_type_Bhiu.a(paramMusicItemInfo, this.jdField_a_of_type_Bhim);
      this.jdField_a_of_type_Befq.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_a_of_type_Befq, 6, paramMusicItemInfo);
      this.jdField_a_of_type_Befq.sendMessageDelayed(localMessage, 60000L);
      bhpu.a(paramMusicItemInfo).a();
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
    Object localObject = (QIMMusicConfigManager)bhfm.a(2);
    int k = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    int j;
    label113:
    bhqe localbhqe;
    if ((bhjl.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Int == 2))
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
      localbhqe = new bhqe();
      localbhqe.jdField_a_of_type_JavaLangString = ((bhhi)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString;
      if (((bhhi)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int != 999) {
        break label223;
      }
      this.i = j;
      localbhqe.jdField_a_of_type_Int = 2130843667;
    }
    for (localbhqe.jdField_b_of_type_Int = 2130843668;; localbhqe.jdField_b_of_type_Int = 0)
    {
      ((ArrayList)localObject).add(localbhqe);
      j += 1;
      break label113;
      ((QIMMusicConfigManager)localObject).a(false);
      break;
      label223:
      localbhqe.jdField_a_of_type_Int = 0;
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
    if (this.jdField_a_of_type_Bhiu != null) {
      this.jdField_a_of_type_Bhiu.a(this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    ((bhgs)bhfm.a(5)).a(this);
  }
  
  public void b(MusicItemInfo paramMusicItemInfo)
  {
    bafb localbafb = babr.a((Activity)getContext(), 2131632585);
    localbafb.setNegativeButton(2131625035, new bhpi(this));
    localbafb.setPositiveButton(2131629116, new bhpj(this, paramMusicItemInfo));
    localbafb.show();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (!paramBoolean)) {
      this.jdField_b_of_type_Boolean = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_Bhiu = ((bhiu)bhfm.a().c(8));
    } while (this.jdField_a_of_type_Bhiu == null);
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bhiu.a();
    this.jdField_a_of_type_Bhiu.a(localMusicItemInfo, true, this.jdField_g_of_type_Int);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bhiu == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhiu.c();
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
    ((bhgs)bhfm.a(5)).a(this);
    Object localObject;
    if (this.jdField_a_of_type_Bhiu != null)
    {
      this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_Bhip);
      localObject = this.jdField_a_of_type_Bhiu;
      if (this.jdField_g_of_type_Int != 0) {
        break label154;
      }
    }
    label154:
    for (int j = bhey.jdField_b_of_type_Int;; j = bhey.jdField_c_of_type_Int)
    {
      ((bhiu)localObject).d(j);
      if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bhiu != null) && (this.f) && (!this.jdField_h_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Bhiu.a();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.jdField_g_of_type_Boolean)) {
          this.jdField_a_of_type_Bhiu.c();
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
    if (bhfm.a().a(5)) {
      ((bhgs)bhfm.a().c(5)).b(this);
    }
    StringBuilder localStringBuilder;
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bhiu != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Bhiu.a();
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
      this.jdField_a_of_type_Bhiu.b(this.jdField_g_of_type_Int);
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bhiu == null) {
      this.jdField_a_of_type_Bhiu = ((bhiu)bhfm.a().c(8));
    }
    this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_Bhip);
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
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131641249), 0).a();
        j();
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (!paramMessage.isFileExist())
        {
          if (!paramMessage.isDownloading()) {
            break;
          }
          if (this.jdField_a_of_type_Bhiu != null) {
            this.jdField_a_of_type_Bhiu.a(paramMessage);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName, paramMessage.mMusicName))) {
            bbmy.a(BaseApplicationImpl.sApplication, ajjy.a(2131641250), 0).a();
          }
          j();
          return false;
        }
        bhpu.a(paramMessage).b();
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
      localObject = (bhhi)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    } while (paramInt >= ((bhhi)localObject).jdField_a_of_type_JavaUtilList.size());
    ((QIMMusicConfigManager)bhfm.a(2)).a = ((bhhi)localObject);
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)((bhhi)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = null;
    if (this.jdField_a_of_type_Bhiu != null) {
      localObject = this.jdField_a_of_type_Bhiu.a();
    }
    if ((jdField_a_of_type_Boolean) && (localObject != null) && (((MusicItemInfo)localObject).mItemId != localMusicItemInfo.mItemId) && (((MusicItemInfo)localObject).mType == 5))
    {
      a(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    ((bhlf)bhfm.a(14)).a(String.valueOf(localMusicItemInfo.mItemId), 2);
    if (localMusicItemInfo.mType == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramInt = a(this.jdField_h_of_type_Int);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { babp.a(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (vhg.a().b() == 22) {
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
      if (this.jdField_a_of_type_Bhiu != null) {
        paramAdapterView = this.jdField_a_of_type_Bhiu.b();
      }
      if ((localMusicItemInfo.mType != 5) || ((!localMusicItemInfo.equals(paramAdapterView)) && (localMusicItemInfo.isFileExist()))) {
        break;
      }
      c(localMusicItemInfo);
      return;
      if (localMusicItemInfo.isWsBanner())
      {
        vnd.a(this.jdField_a_of_type_AndroidContentContext, localMusicItemInfo);
        return;
      }
      if (localMusicItemInfo.mType == 3)
      {
        if (vhg.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 3, 2);
        }
      }
      else if ((localMusicItemInfo.mType == 1) && (vhg.a().b() == 22)) {
        LpReportInfo_pf00064.allReport(680, 3, 4);
      }
    }
    paramView.setSelected(true);
    if ((localMusicItemInfo.mType == 2) && (this.jdField_b_of_type_Int == 5) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;; this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      j();
      ((bhgs)bhfm.a(5)).a(this.jdField_g_of_type_Int, (Activity)this.jdField_a_of_type_AndroidContentContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicProviderView
 * JD-Core Version:    0.7.0.1
 */