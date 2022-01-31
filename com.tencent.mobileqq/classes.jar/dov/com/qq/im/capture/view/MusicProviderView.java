package dov.com.qq.im.capture.view;

import ajyc;
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
import bbct;
import bbcv;
import bbgg;
import bcpw;
import bfnk;
import bfpc;
import biho;
import bjae;
import bjal;
import bjbk;
import bjbn;
import bjbz;
import bjca;
import bjcc;
import bjcj;
import bjdc;
import bjde;
import bjdh;
import bjdk;
import bjdm;
import bjed;
import bjfx;
import bjju;
import bjjv;
import bjjw;
import bjjx;
import bjjy;
import bjjz;
import bjka;
import bjkb;
import bjkh;
import bjkm;
import bjkw;
import bjkz;
import bjlp;
import bkqp;
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
import vuc;
import vzz;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, bfpc, bjbn, bjkz
{
  public static boolean a;
  int jdField_a_of_type_Int = 0;
  public long a;
  public bfnk a;
  public bjdc a;
  bjde jdField_a_of_type_Bjde = new bjjv(this);
  bjdh jdField_a_of_type_Bjdh = new bjjw(this);
  bjdk jdField_a_of_type_Bjdk = new bjjx(this);
  private bjdm jdField_a_of_type_Bjdm;
  public MusicItemInfo a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  MusicProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter;
  List<bjca> jdField_a_of_type_JavaUtilList;
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
    this.jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bjdc = new bjju(this);
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
    ArrayList localArrayList = ((QIMMusicConfigManager)bjae.a(2)).a();
    if (localArrayList != null)
    {
      int j = 0;
      for (;;)
      {
        if (j >= localArrayList.size()) {
          break label129;
        }
        bjca localbjca = (bjca)localArrayList.get(j);
        if ((localbjca != null) && (localbjca.jdField_a_of_type_JavaUtilList != null))
        {
          int k = 0;
          for (;;)
          {
            if (k >= localbjca.jdField_a_of_type_JavaUtilList.size()) {
              break label122;
            }
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localbjca.jdField_a_of_type_JavaUtilList.get(k);
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
  
  private List<bjca> a(List<bjca> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bjca localbjca = (bjca)paramList.next();
      if (localbjca.jdField_b_of_type_Boolean)
      {
        localArrayList.add(localbjca);
        localStringBuilder.append(localbjca.jdField_a_of_type_JavaLangString).append(",");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "filterMusicList, ", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bbgg localbbgg = bbcv.a((Activity)getContext(), 2131698321);
    localbbgg.setNegativeButton(2131690596, new bjjy(this));
    localbbgg.setPositiveButton(2131694793, new bjjz(this, paramAdapterView, paramView, paramInt, paramLong));
    localbbgg.show();
  }
  
  private void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject = (QIMMusicConfigManager)bjae.a(2);
    if ((bjed.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Int == 2))
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
              bjca localbjca = (bjca)((List)localObject).get(j);
              if (localbjca.jdField_a_of_type_JavaLangString.equals(localMusicItemInfo.mTagName))
              {
                int k = 0;
                for (;;)
                {
                  paramBundle = localMusicItemInfo;
                  if (k >= localbjca.jdField_a_of_type_JavaUtilList.size()) {
                    break;
                  }
                  if (localMusicItemInfo.equals((MusicItemInfo)localbjca.jdField_a_of_type_JavaUtilList.get(k)))
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
    if (this.jdField_a_of_type_Bjkh != null) {
      this.jdField_a_of_type_Bjkh.a(109, new Object[] { paramMusicItemInfo });
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bjdm != null) {
      this.jdField_a_of_type_Bjdm.e();
    }
    if (this.jdField_a_of_type_Bjkh != null) {
      this.jdField_a_of_type_Bjkh.a(110, new Object[0]);
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
            ((bjal)localGridView.a()).a(localView);
            k += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - l));
  }
  
  protected int a()
  {
    return 2131560562;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Bjdm != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Bjdm.a();
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MusicProviderView", 2, "save music" + this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        }
        localBundle.putParcelable("select_music", this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
      boolean bool = this.jdField_a_of_type_Bjdm.b();
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bjdc);
    }
    ((QIMMusicConfigManager)bjae.a(2)).b(this.jdField_a_of_type_Bjdk);
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bjdm != null)) {
      this.jdField_a_of_type_Bjdm.e();
    }
    if (this.jdField_a_of_type_Bjdm != null)
    {
      this.jdField_a_of_type_Bjdm.b(this.jdField_a_of_type_Bjdh);
      this.jdField_a_of_type_Bjdm = null;
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
          if (this.jdField_a_of_type_Bjkh != null) {
            this.jdField_a_of_type_Bjkh.a(104, Integer.valueOf(1001));
          }
          a((MusicItemInfo)paramIntent.getParcelableExtra("EXTRA_HUM_RECOGNITION_RESULT"));
        }
      } while ((paramInt2 != 0) || (this.jdField_g_of_type_Int != 0) || (this.jdField_a_of_type_Bjdm == null));
      if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
      {
        this.jdField_a_of_type_Bjdm.a(this.jdField_g_of_type_Int);
        return;
      }
    } while (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null);
    if ((this.f) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_Bjdm.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_g_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Bjdm.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "selectCategoryAndItem category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramInt != -1) && (((bjca)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int == paramInt)) {
        paramInt = j;
      }
    }
    for (;;)
    {
      a().a(paramInt);
      bjca localbjca = (bjca)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
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
        if (j >= localbjca.jdField_a_of_type_JavaUtilList.size()) {
          break label386;
        }
        paramString1 = (MusicItemInfo)localbjca.jdField_a_of_type_JavaUtilList.get(j);
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
      if ((paramString1 != null) && (paramString1.equals(((bjca)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString)))
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
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131166155));
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131560562, this, false));
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      new bjlp(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      a(false);
      h();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bjdc);
      paramBundle = (QIMMusicConfigManager)bjae.a(2);
      paramBundle.a(this.jdField_a_of_type_Bjdk);
      paramBundle.e();
      ((bjbk)bjae.a(5)).a(this);
      if (this.jdField_a_of_type_Bjdm == null) {
        this.jdField_a_of_type_Bjdm = ((bjdm)bjae.a().c(8));
      }
      this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_Bjdh);
      paramBundle = this.jdField_a_of_type_Bjdm;
      if (this.jdField_g_of_type_Int != 0) {
        break label265;
      }
    }
    label265:
    for (int j = biho.jdField_b_of_type_Int;; j = biho.jdField_c_of_type_Int)
    {
      paramBundle.d(j);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView);
      break;
    }
  }
  
  public void a(bjbz parambjbz) {}
  
  public void a(bjbz parambjbz, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Bjdm != null)) {
      this.jdField_a_of_type_Bjdm.f();
    }
  }
  
  public void a(bjcc parambjcc, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjcj parambjcj, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bkqp parambkqp) {}
  
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
      if (this.jdField_a_of_type_Bjdm == null) {
        this.jdField_a_of_type_Bjdm = ((bjdm)bjae.a().c(8));
      }
      if (this.jdField_a_of_type_Bjdm.b(paramMusicItemInfo))
      {
        if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean)) {
          this.jdField_a_of_type_Bjdm.a(paramMusicItemInfo, this.jdField_g_of_type_Int);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.jdField_g_of_type_Int);
          return;
          this.jdField_a_of_type_Bjdm.a(paramMusicItemInfo);
          if (this.jdField_a_of_type_Bjkh != null)
          {
            paramMusicItemInfo = this.jdField_a_of_type_Bjkh;
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
      this.jdField_a_of_type_Bjdm.a(paramMusicItemInfo, this.jdField_a_of_type_Bjde);
      this.jdField_a_of_type_Bfnk.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_a_of_type_Bfnk, 6, paramMusicItemInfo);
      this.jdField_a_of_type_Bfnk.sendMessageDelayed(localMessage, 60000L);
      bjkm.a(paramMusicItemInfo).a();
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
    Object localObject = (QIMMusicConfigManager)bjae.a(2);
    int k = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    int j;
    label113:
    bjkw localbjkw;
    if ((bjed.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_Int == 2))
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
      localbjkw = new bjkw();
      localbjkw.jdField_a_of_type_JavaLangString = ((bjca)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString;
      if (((bjca)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int != 999) {
        break label223;
      }
      this.i = j;
      localbjkw.jdField_a_of_type_Int = 2130843748;
    }
    for (localbjkw.jdField_b_of_type_Int = 2130843749;; localbjkw.jdField_b_of_type_Int = 0)
    {
      ((ArrayList)localObject).add(localbjkw);
      j += 1;
      break label113;
      ((QIMMusicConfigManager)localObject).a(false);
      break;
      label223:
      localbjkw.jdField_a_of_type_Int = 0;
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
    if (this.jdField_a_of_type_Bjdm != null) {
      this.jdField_a_of_type_Bjdm.a(this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    ((bjbk)bjae.a(5)).a(this);
  }
  
  public void b(MusicItemInfo paramMusicItemInfo)
  {
    bbgg localbbgg = bbcv.a((Activity)getContext(), 2131698321);
    localbbgg.setNegativeButton(2131690596, new bjka(this));
    localbbgg.setPositiveButton(2131694793, new bjkb(this, paramMusicItemInfo));
    localbbgg.show();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (!paramBoolean)) {
      this.jdField_b_of_type_Boolean = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_Bjdm = ((bjdm)bjae.a().c(8));
    } while (this.jdField_a_of_type_Bjdm == null);
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bjdm.a();
    this.jdField_a_of_type_Bjdm.a(localMusicItemInfo, true, this.jdField_g_of_type_Int);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bjdm == null) {
      return false;
    }
    return this.jdField_a_of_type_Bjdm.c();
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
    ((bjbk)bjae.a(5)).a(this);
    Object localObject;
    if (this.jdField_a_of_type_Bjdm != null)
    {
      this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_Bjdh);
      localObject = this.jdField_a_of_type_Bjdm;
      if (this.jdField_g_of_type_Int != 0) {
        break label154;
      }
    }
    label154:
    for (int j = biho.jdField_b_of_type_Int;; j = biho.jdField_c_of_type_Int)
    {
      ((bjdm)localObject).d(j);
      if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bjdm != null) && (this.f) && (!this.jdField_h_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Bjdm.a();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.jdField_g_of_type_Boolean)) {
          this.jdField_a_of_type_Bjdm.c();
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
    if (bjae.a().a(5)) {
      ((bjbk)bjae.a().c(5)).b(this);
    }
    StringBuilder localStringBuilder;
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Bjdm != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_Bjdm.a();
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
      this.jdField_a_of_type_Bjdm.b(this.jdField_g_of_type_Int);
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bjdm == null) {
      this.jdField_a_of_type_Bjdm = ((bjdm)bjae.a().c(8));
    }
    this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_Bjdh);
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
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131707034), 0).a();
        j();
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (!paramMessage.isFileExist())
        {
          if (!paramMessage.isDownloading()) {
            break;
          }
          if (this.jdField_a_of_type_Bjdm != null) {
            this.jdField_a_of_type_Bjdm.a(paramMessage);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName, paramMessage.mMusicName))) {
            bcpw.a(BaseApplicationImpl.sApplication, ajyc.a(2131707035), 0).a();
          }
          j();
          return false;
        }
        bjkm.a(paramMessage).b();
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
      localObject = (bjca)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    } while (paramInt >= ((bjca)localObject).jdField_a_of_type_JavaUtilList.size());
    ((QIMMusicConfigManager)bjae.a(2)).a = ((bjca)localObject);
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)((bjca)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = null;
    if (this.jdField_a_of_type_Bjdm != null) {
      localObject = this.jdField_a_of_type_Bjdm.a();
    }
    if ((jdField_a_of_type_Boolean) && (localObject != null) && (((MusicItemInfo)localObject).mItemId != localMusicItemInfo.mItemId) && (((MusicItemInfo)localObject).mType == 5))
    {
      a(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    ((bjfx)bjae.a(14)).a(String.valueOf(localMusicItemInfo.mItemId), 2);
    if (localMusicItemInfo.mType == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramInt = a(this.jdField_h_of_type_Int);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { bbct.a(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (vuc.a().b() == 22) {
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
      if (this.jdField_a_of_type_Bjdm != null) {
        paramAdapterView = this.jdField_a_of_type_Bjdm.b();
      }
      if ((localMusicItemInfo.mType != 5) || ((!localMusicItemInfo.equals(paramAdapterView)) && (localMusicItemInfo.isFileExist()))) {
        break;
      }
      c(localMusicItemInfo);
      return;
      if (localMusicItemInfo.isWsBanner())
      {
        vzz.a(this.jdField_a_of_type_AndroidContentContext, localMusicItemInfo);
        return;
      }
      if (localMusicItemInfo.mType == 3)
      {
        if (vuc.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 3, 2);
        }
      }
      else if ((localMusicItemInfo.mType == 1) && (vuc.a().b() == 22)) {
        LpReportInfo_pf00064.allReport(680, 3, 4);
      }
    }
    paramView.setSelected(true);
    if ((localMusicItemInfo.mType == 2) && (this.jdField_b_of_type_Int == 5) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;; this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      j();
      ((bjbk)bjae.a(5)).a(this.jdField_g_of_type_Int, (Activity)this.jdField_a_of_type_AndroidContentContext);
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