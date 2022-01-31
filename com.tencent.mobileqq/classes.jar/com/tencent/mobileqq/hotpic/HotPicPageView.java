package com.tencent.mobileqq.hotpic;

import aepi;
import ajsu;
import amjq;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import astt;
import asub;
import asuf;
import asug;
import asuh;
import asui;
import asuk;
import asul;
import asum;
import asun;
import asup;
import asuq;
import asuu;
import asuy;
import asve;
import asvf;
import asvo;
import asvq;
import asvr;
import asvt;
import asvw;
import asvx;
import asvy;
import azdd;
import azdx;
import azen;
import azqs;
import bdgm;
import bdhb;
import bdin;
import bdjz;
import beuj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

@TargetApi(14)
public class HotPicPageView
  extends RelativeLayout
  implements asuy, asvo, asvx
{
  public static final double a;
  public static Drawable a;
  public static boolean a;
  public static boolean b;
  public static int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler;
  StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View jdField_a_of_type_AndroidViewView;
  public asun a;
  asup jdField_a_of_type_Asup;
  public asuq a;
  protected asuu a;
  public asve a;
  public asvw a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public BaseActivity a;
  public QQAppInterface a;
  public HotPicMainPanel a;
  public HotPicRecyclerView a;
  public HotPicTagInfo a;
  public ArrayList<HotVideoMongoliaRelativeLayout> a;
  public Set<Integer> a;
  public int b;
  View b;
  public Set<Integer> b;
  boolean c;
  public boolean d;
  public int h = -1;
  public int i = -1;
  private int j;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-855310);
    jdField_b_of_type_Boolean = true;
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    e = aepi.a(1.0F, localResources);
    jdField_d_of_type_Int = (localResources.getDisplayMetrics().widthPixels - e * 8) / 3;
    f = aepi.a(1.0F, localResources);
    g = localResources.getDisplayMetrics().widthPixels - e * 4;
    jdField_a_of_type_Double = 1.777777791023254D;
    jdField_c_of_type_Int = -1;
    jdField_a_of_type_Boolean = true;
  }
  
  public HotPicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static int a(HotPicData paramHotPicData)
  {
    if (paramHotPicData.getDataType() == 2) {}
    for (URL localURL = asvr.a((HotVideoData)paramHotPicData); localURL == null; localURL = astt.a(paramHotPicData.url)) {
      return -1;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    if (paramHotPicData.getDataType() == 2) {}
    for (localObject = asvr.a(paramHotPicData.md5); (localObject != null) && (bdhb.b(((File)localObject).getAbsolutePath())); localObject = astt.a(paramHotPicData.url)) {
      return 0;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      localObject = astt.a(paramHotPicData.url);
      if ((localObject == null) || (!bdhb.b(((File)localObject).getAbsolutePath())))
      {
        URLDrawable.removeMemoryCacheByUrl(localURL.toString());
        paramHotPicData = a(paramHotPicData);
        if (paramHotPicData != null) {
          paramHotPicData.startDownload();
        }
        return 1;
      }
      return -1;
    }
    localURLDrawable.startDownload();
    return 2;
  }
  
  public static ajsu a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt2 <= 0) || (paramInt3 <= 0) || (paramDouble == 0.0D) || (paramInt1 <= 0)) {
      return null;
    }
    double d1 = paramInt2 / paramInt3 - paramDouble;
    int k;
    int m;
    if (d1 > 0.01D)
    {
      k = paramInt2;
      m = paramInt3;
      if (paramInt2 != paramInt1)
      {
        m = (int)(paramInt1 / paramInt2 * paramInt3);
        k = paramInt1;
      }
    }
    for (;;)
    {
      return new ajsu(k, m);
      if (d1 < 0.01D)
      {
        k = paramInt2;
        m = paramInt3;
        if (paramInt2 != paramInt1)
        {
          paramDouble = paramInt1 / paramDouble;
          k = paramInt2;
          m = paramInt3;
          if (Math.abs(paramInt3 - paramDouble) > 0.01D)
          {
            k = (int)(paramDouble / paramInt3 * paramInt2);
            m = (int)paramDouble;
          }
        }
      }
      else
      {
        k = paramInt2;
        m = paramInt3;
        if (paramInt2 != paramInt1)
        {
          m = (int)(paramInt1 / paramInt2 * paramInt3);
          k = paramInt1;
        }
      }
    }
  }
  
  public static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      if (paramHotPicData.getDataType() != 2) {
        break label65;
      }
    }
    label65:
    for (paramHotPicData = asvr.a((HotVideoData)paramHotPicData);; paramHotPicData = astt.a(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label76;
      }
      return null;
      bool = false;
      break;
    }
    label76:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public static boolean b()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public static void c()
  {
    jdField_a_of_type_Boolean = true;
    jdField_c_of_type_Int = -1;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    k();
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (jdField_c_of_type_Int <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay startAutoPlayTimer");
    }
    if (bdin.b(BaseApplication.getContext()) == 1) {}
    while ((jdField_b_of_type_Boolean) || (k == 0))
    {
      return;
      k = 0;
    }
    h();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(View paramView, int paramInt)
  {
    HotPicData localHotPicData;
    try
    {
      localHotPicData = (HotPicData)this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localHotPicData.getDataType() == 2) {
        return;
      }
    }
    catch (IndexOutOfBoundsException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, onItemClick IndexOutOfBoundsException " + paramView.getMessage());
      return;
    }
    int k = localHotPicData.tag;
    int m = 0;
    Object localObject1 = astt.a(localHotPicData.originalUrl);
    Object localObject2;
    if ((localObject1 != null) && (bdhb.b(((File)localObject1).getAbsolutePath())))
    {
      localObject2 = ((File)localObject1).getAbsolutePath();
      k = 1;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label412;
      }
      QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, urlHotPicOringinal = " + localHotPicData.originalUrl + ", paths = " + (String)localObject2);
      localObject1 = localObject2;
      k = 1;
    }
    for (;;)
    {
      a("0X8007EDE", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", localHotPicData.url + "");
      if ((this.jdField_a_of_type_Asuu != null) && (this.jdField_a_of_type_Asuu.a(paramView, (String)localObject1, localHotPicData))) {
        break;
      }
      if ((localObject1 == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131699425, 0).a();
        return;
        if (a(localHotPicData) == 0)
        {
          localObject2 = astt.a(localHotPicData.url).getAbsolutePath();
          localObject1 = localObject2;
          k = m;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, urlHotPic = " + localHotPicData.url + ", paths = " + (String)localObject2);
            k = m;
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        label412:
        paramView = new Intent();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        paramView.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
        paramView.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        paramView.putExtra("send_in_background", true);
        paramView.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
        paramView.putExtra("PicContants.NEED_COMPRESS", false);
        if (k == 0)
        {
          paramView.putExtra("quick_send_original_md5", localHotPicData.originalMD5);
          paramView.putExtra("quick_send_original_size", localHotPicData.oringinalSize);
          paramView.putExtra("quick_send_thumb_md5", localHotPicData.md5);
          paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
          label601:
          ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, null), 8, null, false);
          asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHotPicData);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B17", "0X8007B17", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
            break label848;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1A", "0X8007B1A", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Int == -20) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B18", "0X8007B18", 0, 0, "", "", "", "");
          }
          switch (localHotPicData.sourceType)
          {
          default: 
            return;
          case 1: 
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1E", "0X8007B1E", 0, 0, "", "", "", "");
            return;
            paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
            break label601;
            label848:
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1B", "0X8007B1B", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName.equals(amjq.jdField_a_of_type_JavaLangString)) {
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 2, 0, "", "", "", "");
              }
            }
            else
            {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B19", "0X8007B19", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName.equals(amjq.b)) {
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 1, 0, "", "", "", "");
              }
            }
            break;
          }
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1F", "0X8007B1F", 0, 0, "", "", "", "");
        return;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B20", "0X8007B20", 0, 0, "", "", "", "");
        return;
      }
      localObject1 = null;
      k = 0;
    }
  }
  
  public void a(asuq paramasuq)
  {
    if (paramasuq == null) {
      return;
    }
    if ((this.jdField_a_of_type_Asuq != null) && (this.jdField_a_of_type_Asuq != paramasuq))
    {
      if (this.jdField_a_of_type_Asuq.jdField_a_of_type_Int >= 1) {
        this.jdField_a_of_type_Asuq.a(0);
      }
      this.jdField_a_of_type_Asuq = null;
    }
    this.jdField_a_of_type_Asuq = paramasuq;
  }
  
  public void a(asuq paramasuq, int paramInt)
  {
    this.jdField_d_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new asui(this, paramasuq, paramInt));
  }
  
  public void a(asuq paramasuq, HotVideoData paramHotVideoData)
  {
    RelativeLayout localRelativeLayout = paramasuq.jdField_a_of_type_AndroidWidgetRelativeLayout;
    paramasuq.a();
    ajsu localajsu = a(g, paramHotVideoData.originalWidth, paramHotVideoData.originalHeight, jdField_a_of_type_Double);
    if (localajsu == null)
    {
      paramasuq.a(0);
      return;
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(g, localajsu.b());
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(14);
    paramasuq.a(2);
    localObject = (HotVideoMongoliaRelativeLayout)((LayoutInflater)localObject).inflate(2131559180, null);
    ((HotVideoMongoliaRelativeLayout)localObject).setTag("HotVideoControlTag");
    ((HotVideoMongoliaRelativeLayout)localObject).setHotVideoData(paramHotVideoData);
    ((HotVideoMongoliaRelativeLayout)localObject).setVidoeControlListener(this);
    ((HotVideoMongoliaRelativeLayout)localObject).setControlStateListener(paramasuq);
    localRelativeLayout.addView((View)localObject, 0, localLayoutParams);
    paramasuq = paramHotVideoData.getVideoLengthString();
    ((HotVideoMongoliaRelativeLayout)localObject).a = new ajsu(g, localajsu.b());
    paramasuq = new asvq(paramHotVideoData.name, paramasuq, paramHotVideoData.originalUrl, paramHotVideoData.mVideoUUID, paramHotVideoData.iconUrl, paramHotVideoData.videoSource, paramHotVideoData.mCertificatedIcon, localajsu.a(), localajsu.b(), paramHotVideoData.oringinalSize);
    paramHotVideoData = new asvy(this.jdField_a_of_type_AndroidContentContext);
    paramHotVideoData.a(this);
    ((HotVideoMongoliaRelativeLayout)localObject).a(paramHotVideoData, paramasuq);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007ED9", "0X8007ED9", 0, 0, "", "", "", "");
    ((HotVideoMongoliaRelativeLayout)localObject).c();
  }
  
  public void a(HotPicMainPanel paramHotPicMainPanel, HotPicTagInfo paramHotPicTagInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView = ((HotPicRecyclerView)findViewById(2131375543));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369767);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367787);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramHotPicMainPanel.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo = paramHotPicTagInfo;
    this.jdField_a_of_type_Int = paramHotPicTagInfo.tagId;
    this.jdField_b_of_type_Int = paramHotPicTagInfo.position;
    if (paramHotPicTagInfo.tagType == 2) {}
    for (int k = 1;; k = 3)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(k, 1);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
      this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mExceptionListener = new asuf(this);
      this.jdField_a_of_type_Asun = new asun(this, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Asun.jdField_a_of_type_Asvx = this;
      this.jdField_a_of_type_Asup = new asup(this, this.jdField_a_of_type_Asun);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(this.jdField_a_of_type_Asup);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setAdapter(this.jdField_a_of_type_Asun);
      if (this.jdField_a_of_type_Int == -20) {
        this.jdField_a_of_type_Asup.a(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a = paramHotPicMainPanel;
      this.jdField_a_of_type_Asvw = new asvw(this);
      paramHotPicMainPanel = asub.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramHotPicMainPanel.a(this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Asvw.a(true);
        this.jdField_a_of_type_Asve = asve.a(this.jdField_a_of_type_AndroidContentContext);
        e();
      }
      if (paramHotPicMainPanel.a(this.jdField_a_of_type_Int))
      {
        jdField_b_of_type_Boolean = false;
        a(0, 3000L);
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new asug(this);
      paramHotPicMainPanel = new IntentFilter();
      paramHotPicMainPanel.addAction("android.intent.action.SCREEN_OFF");
      paramHotPicMainPanel.addAction("android.intent.action.SCREEN_ON");
      paramHotPicMainPanel.addAction("tencent.av.v2q.StartVideoChat");
      paramHotPicMainPanel.addAction("tencent.av.v2q.StopVideoChat");
      paramHotPicMainPanel.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramHotPicMainPanel);
      return;
    }
  }
  
  public void a(HotVideoData paramHotVideoData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay OnVideoPlayCompleted");
    }
    this.h = paramHotVideoData.picIndex;
    jdField_b_of_type_Boolean = false;
    a(1, 1500L);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int k = 1;
    int n = 0;
    String str2 = "";
    String str1;
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel instanceof PublicAccountHotPicPanel)) {
        k = 3;
      }
    }
    else
    {
      str1 = str2;
      m = n;
      if (k == 1)
      {
        str1 = str2;
        m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          str1 = str2;
          m = n;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)
          {
            str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
            {
            default: 
              m = n;
            }
          }
        }
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, paramString1, paramString1, k, m, paramString2, paramString3, paramString4, paramString5);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel instanceof TribeHotPicPanel))
      {
        k = 4;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel instanceof HotPicMainPanel))
      {
        k = 1;
        break;
      }
      k = 5;
      break;
      m = 1;
      continue;
      m = 2;
      continue;
      m = 3;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_Asuq;
    if ((localObject != null) && (((asuq)localObject).jdField_a_of_type_Int >= 2))
    {
      localObject = ((asuq)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).a(jdField_a_of_type_Boolean);
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    do
    {
      return false;
      if (asvf.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.isBlurSwitch is false");
    return false;
    int k = asvf.a();
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.getBlurMemory is " + k);
    }
    ActivityManager localActivityManager = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, " mi.availMem is " + localMemoryInfo.availMem / 1024L);
    }
    if (localMemoryInfo.availMem > k * 1024 * 1024) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Asun.a();
    this.jdField_a_of_type_Asun.notifyDataSetChanged();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) {}
    HotPicData localHotPicData;
    do
    {
      do
      {
        return;
        localHotPicData = (HotPicData)this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (localHotPicData.getDataType() == 2);
      paramInt = a(localHotPicData);
    } while ((paramInt == 2) || (paramInt == -1));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(localHotPicData);
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B22", "0X8007B22", 0, 0, "", "", "", "");
  }
  
  public void b(asuq paramasuq, int paramInt)
  {
    int k = 1;
    if (paramasuq == null) {}
    while ((paramasuq.jdField_a_of_type_Int != 0) && (paramasuq.jdField_a_of_type_Int != -11) && (paramasuq.jdField_a_of_type_Int != 1)) {
      return;
    }
    paramasuq.a(1);
    if (this.jdField_d_of_type_Boolean)
    {
      paramasuq.a(0);
      new beuj(this.jdField_a_of_type_AndroidContentContext).a(HotVideoMongoliaRelativeLayout.c, 100, 0, 1);
      return;
    }
    asvt.a();
    if (!asvt.b())
    {
      if (bdin.b(BaseApplication.getContext()) == 1) {}
      while (k != 0)
      {
        a(paramasuq, paramInt);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698160), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
        return;
        k = 0;
      }
      bdgm.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698157), new asuk(this, paramasuq, paramInt), new asul(this, paramasuq)).show();
      return;
    }
    Object localObject = (HotPicData)this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((HotPicData)localObject).getDataType() == 2)
    {
      localObject = (HotVideoData)localObject;
      ((HotVideoData)localObject).GetVideoURLAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "0", new asum(this, (HotVideoData)localObject, paramasuq));
      return;
    }
    paramasuq.a(0);
  }
  
  public void b(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    ((Intent)localObject).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    ((Intent)localObject).putExtra("file_send_size", paramHotVideoData.oringinalSize);
    ((Intent)localObject).putExtra("file_send_business_type", 6);
    ((Intent)localObject).putExtra("file_shortvideo_md5", paramHotVideoData.originalMD5);
    ((Intent)localObject).putExtra("file_uuid", paramHotVideoData.mVideoUUID);
    ((Intent)localObject).putExtra("thumbfile_send_width", paramHotVideoData.width);
    ((Intent)localObject).putExtra("thumbfile_send_height", paramHotVideoData.height);
    ((Intent)localObject).putExtra("thumbfile_md5", paramHotVideoData.md5);
    ((Intent)localObject).putExtra("file_thumb_Size", paramHotVideoData.fileSize);
    ((Intent)localObject).putExtra("support_progressive", true);
    ((Intent)localObject).putExtra("file_width", paramHotVideoData.originalWidth);
    ((Intent)localObject).putExtra("file_height", paramHotVideoData.originalHeight);
    ((Intent)localObject).putExtra("file_send_duration", (int)(paramHotVideoData.videoLength / 1000L));
    ((Intent)localObject).putExtra("hot_video_icon", paramHotVideoData.iconUrl);
    ((Intent)localObject).putExtra("hot_video_icon_sub", paramHotVideoData.mCertificatedIcon);
    ((Intent)localObject).putExtra("hot_video_title", paramHotVideoData.videoSource);
    ((Intent)localObject).putExtra("hot_video_url", paramHotVideoData.jumpUrl);
    ((Intent)localObject).putExtra("hot_video_name", paramHotVideoData.name + ".mp4");
    ((Intent)localObject).putExtra("special_video_type", 1);
    azdx localazdx = azdd.a(0, 6);
    localObject = azdd.a(6, localObject, localazdx);
    ((azen)localObject).e = true;
    localazdx.a((azen)localObject);
    azdd.a(localazdx, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDE", "0X8007EDE", 0, 0, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramHotVideoData.picIndex + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", paramHotVideoData.originalMD5 + "");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDA", "0X8007EDA", 0, 0, "", "", paramHotVideoData.mVideoUUID, paramHotVideoData.originalMD5);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007ED4", "0X8007ED4", 0, 0, "", "", "", "");
  }
  
  public void c(asuq paramasuq, int paramInt)
  {
    jdField_b_of_type_Boolean = true;
    if (paramasuq == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView != null)
    {
      HotPicRecyclerView localHotPicRecyclerView = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView;
      HotPicRecyclerView.a("onVideoItemClick");
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(paramInt);
      localHotPicRecyclerView = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView;
      HotPicRecyclerView.a("onVideoItemClick CheckItemIsNeedToScroll End isNeedScroll is " + bool);
      if (bool)
      {
        this.i = paramInt;
        jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(-1, paramInt);
        return;
      }
    }
    b(paramasuq, paramInt);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Asuq != null) && (this.jdField_a_of_type_Asuq.jdField_a_of_type_Int == 3))
    {
      HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = this.jdField_a_of_type_Asuq.a();
      if (localHotVideoMongoliaRelativeLayout != null) {
        localHotVideoMongoliaRelativeLayout.d();
      }
    }
  }
  
  void e()
  {
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setScrollStatusChengedListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new asuh(this);
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_Asuq;
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((asuq)localObject).a();
    } while (localObject == null);
    ((HotVideoMongoliaRelativeLayout)localObject).a();
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_Asuq;
    if (localObject != null)
    {
      localObject = ((asuq)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).b();
      }
    }
    int k;
    if (bdin.b(BaseApplication.getContext()) == 1)
    {
      k = 1;
      if (k != 0) {
        break label44;
      }
    }
    label44:
    do
    {
      do
      {
        return;
        k = 0;
        break;
      } while (jdField_b_of_type_Boolean);
      k = this.i;
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(k);
    } while ((k < 0) || (localObject == null) || (!(localObject instanceof asuq)));
    localObject = (asuq)localObject;
    if (((asuq)localObject).jdField_a_of_type_Int == 0)
    {
      b((asuq)localObject, k);
      return;
    }
    ((asuq)localObject).jdField_a_of_type_Boolean = true;
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay TryScrollAndPlayNextVideo");
    }
    if (jdField_b_of_type_Boolean) {}
    int k;
    int m;
    do
    {
      return;
      k = this.h;
      m = k + 1;
    } while (m >= this.jdField_a_of_type_Asun.getItemCount());
    this.i = m;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(k, m);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Asve != null) {
      asve.b(this.jdField_a_of_type_Asve);
    }
    Object localObject = this.jdField_a_of_type_Asuq;
    if (localObject != null)
    {
      if (((asuq)localObject).jdField_a_of_type_Int <= 2) {
        break label45;
      }
      localObject = ((asuq)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).d();
      }
    }
    label45:
    while (((asuq)localObject).jdField_a_of_type_Int == -10) {
      return;
    }
    ((asuq)localObject).a(0);
  }
  
  public void k()
  {
    int k = 2;
    asub localasub = asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Int == -20)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(8);
      this.jdField_a_of_type_Asup.a(2);
      if (localasub.a().size() <= 0)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Asun.a(localasub.a());
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
      this.jdField_a_of_type_Asun.notifyDataSetChanged();
      return;
    }
    if (localasub.b(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Asun.a(localasub.a(this.jdField_a_of_type_Int));
      if (localasub.c(this.jdField_a_of_type_Int)) {}
      for (;;)
      {
        this.jdField_a_of_type_Asup.a(k);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
        this.jdField_a_of_type_Asun.notifyDataSetChanged();
        return;
        k = 1;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(8);
    localasub.a(this.jdField_a_of_type_Int);
  }
  
  void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a = null;
    this.jdField_a_of_type_Asvw.b();
    this.jdField_a_of_type_Asvw = null;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = null;
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.j = 0;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public void m()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      n();
      return;
    }
    ThreadManager.getUIHandler().post(new HotPicPageView.8(this));
  }
  
  void n()
  {
    for (;;)
    {
      int i3;
      int n;
      int i5;
      int i4;
      int i1;
      boolean bool;
      try
      {
        if ((bdin.a(this.jdField_a_of_type_AndroidContentContext)) && (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_b_of_type_JavaUtilSet.size()) && (this.j + 1 <= this.jdField_a_of_type_JavaUtilSet.size()))
        {
          i3 = this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.size();
          if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) || (!asub.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int))) {
            break label722;
          }
          k = 8;
          n = 1;
          i5 = (this.j / k + 1) * k - 1;
          i4 = i5 + k;
          m = 0;
          k = 0;
          int i2 = 0;
          if (this.jdField_a_of_type_JavaUtilSet.size() > i5) {
            break label408;
          }
          if (this.jdField_b_of_type_JavaUtilSet.size() <= i5)
          {
            i1 = this.jdField_b_of_type_JavaUtilSet.size();
            k = i2;
            m = k;
            if (i1 <= i5)
            {
              m = k;
              if (i1 < i3)
              {
                bool = this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(i1));
                if (bool) {
                  break label719;
                }
              }
            }
          }
        }
        else
        {
          try
          {
            localURLDrawable1 = a((HotPicData)this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.get(i1));
            if (localURLDrawable1 == null) {
              return;
            }
            m = localURLDrawable1.getStatus();
            if (m != 1)
            {
              m = k + 1;
              if (k >= n) {
                continue;
              }
            }
          }
          catch (Exception localException1)
          {
            URLDrawable localURLDrawable1;
            m = k;
          }
        }
      }
      finally {}
      label653:
      try
      {
        this.jdField_a_of_type_Asvw.a(i1, localURLDrawable1);
      }
      catch (Exception localException5)
      {
        label408:
        continue;
      }
      try
      {
        this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(i1));
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicManagerHotPicPageView", 2, "preDownload  " + this.jdField_a_of_type_Int + " " + i1);
          k = m;
        }
        i1 += 1;
      }
      catch (Exception localException6)
      {
        continue;
        break label653;
      }
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i1));
      int m = k;
      continue;
      localException1.printStackTrace();
      int k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicManagerHotPicPageView", 2, "preDownloadOnUi !mStartDownLoadIndex.contains(index) Exception ", localException1);
        k = m;
        continue;
        if (m == 0)
        {
          k = m;
          if (this.jdField_a_of_type_JavaUtilSet.size() > i5)
          {
            m = this.jdField_a_of_type_Int;
            if ((this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.size() < i4) && (!asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(m))) {
              asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(m);
            }
            if (this.jdField_b_of_type_JavaUtilSet.size() <= i4)
            {
              i1 = this.jdField_b_of_type_JavaUtilSet.size();
              if ((i1 <= i4) && (i1 < i3))
              {
                bool = this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(i1));
                if (!bool) {
                  for (;;)
                  {
                    for (;;)
                    {
                      try
                      {
                        localURLDrawable2 = a((HotPicData)this.jdField_a_of_type_Asun.jdField_a_of_type_JavaUtilList.get(i1));
                        if (localURLDrawable2 == null) {
                          break;
                        }
                        m = localURLDrawable2.getStatus();
                        if (m != 1)
                        {
                          m = k + 1;
                          if (k >= n) {
                            break;
                          }
                        }
                      }
                      catch (Exception localException2)
                      {
                        URLDrawable localURLDrawable2;
                        localException2.printStackTrace();
                        continue;
                      }
                      try
                      {
                        this.jdField_a_of_type_Asvw.a(i1, localURLDrawable2);
                      }
                      catch (Exception localException3)
                      {
                        k = m;
                        continue;
                      }
                      try
                      {
                        this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(i1));
                        k = m;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("HotPicManagerHotPicPageView", 2, "preDownload  " + this.jdField_a_of_type_Int + " " + i1);
                          k = m;
                        }
                        i1 += 1;
                      }
                      catch (Exception localException4)
                      {
                        k = m;
                      }
                    }
                    this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i1));
                    m = k;
                  }
                }
                label719:
                continue;
                label722:
                n = 2;
                k = 16;
              }
            }
          }
        }
      }
    }
  }
  
  void o()
  {
    if (this.jdField_a_of_type_Asve == null) {
      this.jdField_a_of_type_Asve = asve.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      int k = 0;
      while (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
        {
          int m = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k);
          String str1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
          String str2 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "_" + m;
          a("0X8007EDD", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", m + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", str1 + "");
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.add(str2);
        }
        k += 1;
      }
      asve.a(this.jdField_a_of_type_Asve);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagType == 2)) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int)) && (paramKeyEvent.getAction() == 0)) {
      jdField_b_of_type_Boolean = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) {}
    do
    {
      return false;
      if (!asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int)) {
        break;
      }
    } while (paramMotionEvent.getAction() != 0);
    jdField_b_of_type_Boolean = true;
    return false;
    View localView = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_b_of_type_AndroidViewView;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = localRelativeLayout.findViewWithTag("HotPicControlTag");
      if (paramMotionEvent != null)
      {
        int k = ((ViewGroup.MarginLayoutParams)paramMotionEvent.getLayoutParams()).topMargin;
        paramView = new RelativeLayout.LayoutParams(paramView.getWidth(), paramView.getHeight());
        paramMotionEvent = new ImageView(localRelativeLayout.getContext());
        paramMotionEvent.setTag("HotPicPopControlTag");
        paramView.topMargin = k;
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramMotionEvent.setBackgroundColor(Color.parseColor("#7f000000"));
          localRelativeLayout.addView(paramMotionEvent, paramView);
        }
      }
      else
      {
        label151:
        if (localView.getVisibility() != 0) {
          break label238;
        }
      }
    }
    label238:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramMotionEvent.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
      break;
      if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
        break label151;
      }
      paramView = localRelativeLayout.findViewWithTag("HotPicPopControlTag");
      if (paramView != null) {
        localRelativeLayout.removeView(paramView);
      }
      if (localView.getVisibility() != 0) {
        break label151;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.g();
      break label151;
    }
  }
  
  public void setOnHotPicItemClickListener(asuu paramasuu)
  {
    this.jdField_a_of_type_Asuu = paramasuu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView
 * JD-Core Version:    0.7.0.1
 */