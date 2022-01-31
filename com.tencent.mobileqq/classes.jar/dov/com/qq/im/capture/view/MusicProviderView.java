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
import anpa;
import anpb;
import anpc;
import anpd;
import anpe;
import anpf;
import anpg;
import anph;
import anpi;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.MusicProviderGridAdapter;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.DoodleMusicCategoryItem;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.MusicPlayerSceneListener;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.LoadMusicStepListener;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener
{
  public static boolean a;
  int jdField_a_of_type_Int = 0;
  public long a;
  public MusicItemInfo a;
  public QQViewPager a;
  public WeakReferenceHandler a;
  public MusicProviderPagerAdapter a;
  public CaptureConfigUpdateObserver a;
  MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new anpb(this);
  MusicPlayerSceneListener jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener = new anpc(this);
  QIMMusicConfigManager.LoadMusicStepListener jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$LoadMusicStepListener = new anpd(this);
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  List jdField_a_of_type_JavaUtilList;
  public int b;
  private MusicItemInfo b;
  public boolean b;
  public int c = -1;
  private boolean e;
  private boolean f;
  private int g = -1;
  
  public MusicProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new anpa(this);
  }
  
  private void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Activity)getContext(), 2131439208);
    localQQCustomDialog.setNegativeButton(2131433015, new anpf(this));
    localQQCustomDialog.setPositiveButton(2131433016, new anpg(this, paramAdapterView, paramView, paramInt, paramLong));
    localQQCustomDialog.show();
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject = (QIMMusicConfigManager)QIMManager.a(2);
    if ((RecognitionManager.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int == 2))
    {
      ((QIMMusicConfigManager)localObject).a(true);
      this.jdField_a_of_type_JavaUtilList = ((QIMMusicConfigManager)localObject).a();
      if (paramBundle == null) {
        break label295;
      }
    }
    label295:
    for (paramBundle = paramBundle.getBundle(MusicProviderView.class.getSimpleName());; paramBundle = null)
    {
      if ((paramBundle != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        localObject = (MusicItemInfo)paramBundle.getParcelable("select_music");
        paramBundle = (Bundle)localObject;
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MusicProviderView", 2, "restore music" + ((MusicItemInfo)localObject).jdField_a_of_type_JavaLangString);
          }
          int i = 0;
          for (;;)
          {
            paramBundle = (Bundle)localObject;
            if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label242;
            }
            DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i);
            if (localDoodleMusicCategoryItem.jdField_a_of_type_JavaLangString.equals(((MusicItemInfo)localObject).jdField_d_of_type_JavaLangString))
            {
              int j = 0;
              for (;;)
              {
                paramBundle = (Bundle)localObject;
                if (j >= localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size()) {
                  break;
                }
                if (((MusicItemInfo)localObject).a((MusicItemInfo)localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(j)))
                {
                  this.jdField_b_of_type_Int = i;
                  this.c = j;
                }
                j += 1;
              }
              ((QIMMusicConfigManager)localObject).a(false);
              break;
            }
            i += 1;
          }
        }
      }
      else
      {
        paramBundle = null;
      }
      label242:
      if (paramBundle == null)
      {
        paramBundle = new MusicItemInfo();
        paramBundle.jdField_d_of_type_Int = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
        if (this.jdField_f_of_type_Int != 0) {
          a(paramBundle);
        }
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    }
  }
  
  private void c(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(109, new Object[] { paramMusicItemInfo });
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.e();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(110, new Object[0]);
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
            ((MusicProviderGridAdapter)localGridView.a()).a(localView);
            j += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - l));
  }
  
  protected int a()
  {
    return 2130970126;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MusicProviderView", 2, "save music" + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_a_of_type_JavaLangString);
      }
      localBundle.putParcelable("select_music", this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    return localBundle;
  }
  
  public void a()
  {
    super.a();
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
    super.a(paramInt1, paramInt2, paramIntent);
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
          if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
            this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(104, Integer.valueOf(1001));
          }
          a((MusicItemInfo)paramIntent.getParcelableExtra("EXTRA_HUM_RECOGNITION_RESULT"));
        }
      } while ((paramInt2 != 0) || (this.jdField_f_of_type_Int != 0) || (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null));
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
      {
        this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_f_of_type_Int);
        return;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null);
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_f_of_type_Int);
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "category= " + paramInt + ",itemId=" + paramString);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (;;)
    {
      a().a(i);
      DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      try
      {
        paramInt = Integer.valueOf(paramString).intValue();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label189:
          paramInt = -1;
          paramString.printStackTrace();
          int j = paramInt;
          continue;
          paramInt += 1;
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicProviderView", 2, "itemID= " + paramInt);
        }
        j = paramInt;
        paramInt = 0;
        if (paramInt >= localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size()) {
          break label310;
        }
        paramString = (MusicItemInfo)localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramString.jdField_a_of_type_Int != j) {
          break label299;
        }
      }
      catch (Exception paramString)
      {
        break label289;
        paramInt = 0;
        paramString = null;
        break label189;
      }
      if ((paramString != null) && (QLog.isColorLevel())) {
        QLog.d("MusicProviderView", 2, "itemInfo= " + paramString.jdField_a_of_type_JavaLangString + ",index=" + i + ",pos=" + paramInt);
      }
      if (paramString != null)
      {
        postDelayed(new anpe(this, paramInt), 200L);
        a(paramString);
        i();
      }
      return;
      i += 1;
      break;
      label289:
      label299:
      label310:
      i = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131493442));
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2130970126, this, false));
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(new ArrayList());
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
      a(false);
      d();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
      paramBundle = (QIMMusicConfigManager)QIMManager.a(2);
      paramBundle.a(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$LoadMusicStepListener);
      paramBundle.e();
      paramBundle = (CaptureComboManager)QIMManager.a(5);
      if (paramBundle != null)
      {
        paramBundle.b(this);
        paramBundle.a(this);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
        this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
        paramBundle = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer;
        if (this.jdField_f_of_type_Int != 0) {
          break label272;
        }
      }
    }
    label272:
    for (int i = QQFilterRenderManagerHolder.jdField_b_of_type_Int;; i = QQFilterRenderManagerHolder.c)
    {
      paramBundle.d(i);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_AndroidViewView);
      break;
    }
  }
  
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
    label62:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) && (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(paramMusicItemInfo)))
        {
          if ((this.jdField_f_of_type_Int == 0) && (!paramBoolean)) {
            this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(paramMusicItemInfo, this.jdField_f_of_type_Int);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.jdField_f_of_type_Int);
            return;
            this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(paramMusicItemInfo);
            if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
            {
              paramMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener;
              if (paramBoolean) {
                break label135;
              }
            }
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramMusicItemInfo.e(paramBoolean);
            break label62;
            break;
          }
        }
      } while (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(paramMusicItemInfo, this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 6, paramMusicItemInfo);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, 60000L);
      QIMCommonLoadingProgress.a(paramMusicItemInfo).a();
    } while (!QLog.isColorLevel());
    label135:
    QLog.d("MusicProviderView", 2, "startMusic requestDownLoadMusicInfo" + this.jdField_f_of_type_Int);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      localObject = (DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    } while (paramInt >= ((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaUtilList.size());
    Object localObject = (MusicItemInfo)((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    if ((jdField_a_of_type_Boolean) && (localMusicItemInfo != null) && (localMusicItemInfo.jdField_a_of_type_Int != ((MusicItemInfo)localObject).jdField_a_of_type_Int) && (localMusicItemInfo.jdField_d_of_type_Int == 5))
    {
      b(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    ((QIMPredownManager)QIMManager.a(14)).a(String.valueOf(((MusicItemInfo)localObject).jdField_a_of_type_Int), 2);
    if (((MusicItemInfo)localObject).jdField_d_of_type_Int == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s", new Object[] { DeviceInfoUtil.a(), "" }));
      paramView.putExtra("finish_animation_up_down", true);
      paramAdapterView.startActivityForResult(paramView, 1001);
      paramAdapterView.overridePendingTransition(2131034123, 0);
      return;
    }
    if (((MusicItemInfo)localObject).jdField_d_of_type_Int == 6)
    {
      paramAdapterView = (Activity)getContext();
      paramAdapterView.startActivityForResult(new Intent(paramAdapterView, HummingActivity.class), 131);
      return;
    }
    if (((MusicItemInfo)localObject).jdField_d_of_type_Int == 8) {
      h();
    }
    while (!((MusicItemInfo)localObject).d())
    {
      paramAdapterView = null;
      if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
        paramAdapterView = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.c();
      }
      if ((((MusicItemInfo)localObject).jdField_d_of_type_Int != 5) || ((!((MusicItemInfo)localObject).a(paramAdapterView)) && (((MusicItemInfo)localObject).f()))) {
        break;
      }
      c((MusicItemInfo)localObject);
      return;
    }
    WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, localObject);
    return;
    paramView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((MusicItemInfo)localObject);
    a((MusicItemInfo)localObject);
    i();
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_f_of_type_Int, (Activity)this.jdField_a_of_type_AndroidContentContext);
    k();
  }
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.f();
    }
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.f();
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData) {}
  
  public void a(boolean paramBoolean)
  {
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "updateData MusicProviderView not init");
      }
      return;
    }
    Object localObject = (QIMMusicConfigManager)QIMManager.a(2);
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    int i;
    label86:
    QIMSlidingItemView.SlidingItemData localSlidingItemData;
    if ((RecognitionManager.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int == 2))
    {
      ((QIMMusicConfigManager)localObject).a(true);
      this.jdField_a_of_type_JavaUtilList = ((QIMMusicConfigManager)localObject).a(paramBoolean);
      localObject = new ArrayList();
      this.g = -1;
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label211;
      }
      localSlidingItemData = new QIMSlidingItemView.SlidingItemData();
      localSlidingItemData.jdField_a_of_type_JavaLangString = ((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      if (((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != 999) {
        break label196;
      }
      this.g = i;
      localSlidingItemData.jdField_a_of_type_Int = 2130841926;
    }
    for (localSlidingItemData.jdField_b_of_type_Int = 2130841927;; localSlidingItemData.jdField_b_of_type_Int = 0)
    {
      ((ArrayList)localObject).add(localSlidingItemData);
      i += 1;
      break label86;
      ((QIMMusicConfigManager)localObject).a(false);
      break;
      label196:
      localSlidingItemData.jdField_a_of_type_Int = 0;
    }
    label211:
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.b((ArrayList)localObject);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(j);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    paramBundle = (CaptureComboManager)QIMManager.a(5);
    if (paramBundle != null)
    {
      paramBundle.b(this);
      paramBundle.a(this);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
      paramBundle = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer;
      if (this.jdField_f_of_type_Int != 0) {
        break label83;
      }
    }
    label83:
    for (int i = QQFilterRenderManagerHolder.jdField_b_of_type_Int;; i = QQFilterRenderManagerHolder.c)
    {
      paramBundle.d(i);
      return;
    }
  }
  
  public void b(MusicItemInfo paramMusicItemInfo)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Activity)getContext(), 2131439208);
    localQQCustomDialog.setNegativeButton(2131433015, new anph(this));
    localQQCustomDialog.setPositiveButton(2131433016, new anpi(this, paramMusicItemInfo));
    localQQCustomDialog.show();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (!paramBoolean)) {
      this.jdField_b_of_type_Boolean = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
    } while (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null);
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(localMusicItemInfo, true, this.jdField_f_of_type_Int);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).b(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$LoadMusicStepListener);
    if ((this.jdField_f_of_type_Int == 0) && (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.e();
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = null;
    }
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.jdField_b_of_type_Int);
    }
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "random tab music onResume");
    }
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    if (localObject != null)
    {
      ((CaptureComboManager)localObject).b(this);
      ((CaptureComboManager)localObject).a(this);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerSceneListener);
      localObject = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer;
      if (this.jdField_f_of_type_Int != 0) {
        break label162;
      }
    }
    label162:
    for (int i = QQFilterRenderManagerHolder.jdField_b_of_type_Int;; i = QQFilterRenderManagerHolder.c)
    {
      ((QimMusicPlayer)localObject).d(i);
      if ((this.jdField_f_of_type_Int == 0) && (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) && (this.jdField_f_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
        if ((localObject != null) && (((MusicItemInfo)localObject).jdField_a_of_type_Float == -1.0F)) {
          this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.c();
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
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a().c(5)).b(this);
    }
    StringBuilder localStringBuilder;
    if ((this.jdField_f_of_type_Int == 0) && (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onStop  mSaveMusicInfo=");
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
          break label107;
        }
      }
    }
    label107:
    for (Object localObject = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;; localObject = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.d("MusicProviderView", 2, localObject);
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_f_of_type_Int);
      return;
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_f_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    jdField_a_of_type_Boolean = false;
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
          break label258;
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
        c((MusicItemInfo)paramMessage.obj);
        return false;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "网络出问题了，一会儿再试试。", 0).a();
        i();
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (!paramMessage.f())
        {
          if (!paramMessage.a()) {
            break;
          }
          if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
            this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(paramMessage);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_a_of_type_JavaLangString, paramMessage.jdField_a_of_type_JavaLangString))) {
            QQToast.a(BaseApplicationImpl.sApplication, "网络出问题了，一会儿再试试。", 0).a();
          }
          i();
          return false;
        }
        QIMCommonLoadingProgress.a(paramMessage).b();
        return false;
      }
      label258:
      bool = false;
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
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setPreSelectTagIndex(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicProviderView
 * JD-Core Version:    0.7.0.1
 */