package com.tencent.mobileqq.hotpic;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
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
  implements HotPicRecyclerView.ScrollStatusChengedListener, HotVideoMongoliaRelativeLayout.OnVidoeControlListener, OnHolderItemClickListener
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
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View jdField_a_of_type_AndroidViewView;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HotPicMainPanel jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  HotPicPageView.HotPicAdapter jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter;
  HotPicPageView.HotPicFooter jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter;
  public HotPicPageView.MyVideoViewHolder a;
  protected HotPicPageView.OnHotPicItemClickListener a;
  HotPicRecyclerView jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView;
  HotPicTagInfo jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo;
  public HotVideoBlurTaskManager a;
  HotpicDownloadDispatcher jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher;
  public ArrayList<HotVideoMongoliaRelativeLayout> a;
  Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  Set<Integer> jdField_b_of_type_JavaUtilSet = new HashSet();
  boolean c;
  boolean d;
  public int h = -1;
  public int i = -1;
  private int j = 0;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-855310);
    jdField_b_of_type_Boolean = true;
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    e = AIOUtils.a(1.0F, localResources);
    jdField_d_of_type_Int = (localResources.getDisplayMetrics().widthPixels - e * 8) / 3;
    f = AIOUtils.a(1.0F, localResources);
    g = localResources.getDisplayMetrics().widthPixels - e * 4;
    jdField_a_of_type_Double = 1.777777791023254D;
    jdField_c_of_type_Int = -1;
    jdField_a_of_type_Boolean = true;
  }
  
  public HotPicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static int a(HotPicData paramHotPicData)
  {
    if (paramHotPicData.getDataType() == 2) {}
    for (URL localURL = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData); localURL == null; localURL = HotPicDownLoader.a(paramHotPicData.url)) {
      return -1;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    if (paramHotPicData.getDataType() == 2) {}
    for (localObject = HotVideoPreviewDownloader.a(paramHotPicData.md5); (localObject != null) && (FileUtils.b(((File)localObject).getAbsolutePath())); localObject = HotPicDownLoader.a(paramHotPicData.url)) {
      return 0;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      localObject = HotPicDownLoader.a(paramHotPicData.url);
      if ((localObject == null) || (!FileUtils.b(((File)localObject).getAbsolutePath())))
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
  
  static URLDrawable a(HotPicData paramHotPicData)
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
    for (paramHotPicData = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData);; paramHotPicData = HotPicDownLoader.a(paramHotPicData.url))
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
  
  public static Size a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
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
      return new Size(k, m);
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
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
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
      localHotPicData = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    Object localObject1 = HotPicDownLoader.a(localHotPicData.originalUrl);
    Object localObject2;
    if ((localObject1 != null) && (FileUtils.b(((File)localObject1).getAbsolutePath())))
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
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener.a(paramView, (String)localObject1, localHotPicData))) {
        break;
      }
      if ((localObject1 == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131698884, 0).a();
        return;
        if (a(localHotPicData) == 0)
        {
          localObject2 = HotPicDownLoader.a(localHotPicData.url).getAbsolutePath();
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
        paramView.putExtra("HOT_PIC_SEND_PIC", true);
        if (k == 0)
        {
          paramView.putExtra("quick_send_original_md5", localHotPicData.originalMD5);
          paramView.putExtra("quick_send_original_size", localHotPicData.oringinalSize);
          paramView.putExtra("quick_send_thumb_md5", localHotPicData.md5);
        }
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
        ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, null), 8, null, false);
        HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHotPicData);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B17", "0X8007B17", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1A", "0X8007B1A", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Int == -20) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B18", "0X8007B18", 0, 0, "", "", "", "");
          }
          switch (localHotPicData.sourceType)
          {
          default: 
            return;
          case 1: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1E", "0X8007B1E", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1B", "0X8007B1B", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName.equals(AIOIceBreakConstants.jdField_a_of_type_JavaLangString)) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 2, 0, "", "", "", "");
              }
            }
            else
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B19", "0X8007B19", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName.equals(AIOIceBreakConstants.b)) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 1, 0, "", "", "", "");
              }
            }
            break;
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1F", "0X8007B1F", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B20", "0X8007B20", 0, 0, "", "", "", "");
        return;
      }
      localObject1 = null;
      k = 0;
    }
  }
  
  public void a(HotPicMainPanel paramHotPicMainPanel, HotPicTagInfo paramHotPicTagInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView = ((HotPicRecyclerView)findViewById(2131376816));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370723);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368564);
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
      this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mExceptionListener = new HotPicPageView.1(this);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter = new HotPicPageView.HotPicAdapter(this, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener = this;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter = new HotPicPageView.HotPicFooter(this, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter);
      if (this.jdField_a_of_type_Int == -20) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a = paramHotPicMainPanel;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher = new HotpicDownloadDispatcher(this);
      paramHotPicMainPanel = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramHotPicMainPanel.a(this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a(true);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager = HotVideoBlurTaskManager.a(this.jdField_a_of_type_AndroidContentContext);
        e();
      }
      if (paramHotPicMainPanel.a(this.jdField_a_of_type_Int))
      {
        jdField_b_of_type_Boolean = false;
        a(0, 3000L);
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new HotPicPageView.2(this);
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
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder)
  {
    if (paramMyVideoViewHolder == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder != paramMyVideoViewHolder))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.jdField_a_of_type_Int >= 1) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder = paramMyVideoViewHolder;
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    this.jdField_d_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new HotPicPageView.4(this, paramMyVideoViewHolder, paramInt));
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, HotVideoData paramHotVideoData)
  {
    RelativeLayout localRelativeLayout = paramMyVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
    paramMyVideoViewHolder.a();
    Size localSize = a(g, paramHotVideoData.originalWidth, paramHotVideoData.originalHeight, jdField_a_of_type_Double);
    if (localSize == null)
    {
      paramMyVideoViewHolder.a(0);
      return;
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(g, localSize.b());
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(14);
    paramMyVideoViewHolder.a(2);
    localObject = (HotVideoMongoliaRelativeLayout)((LayoutInflater)localObject).inflate(2131559348, null);
    ((HotVideoMongoliaRelativeLayout)localObject).setTag("HotVideoControlTag");
    ((HotVideoMongoliaRelativeLayout)localObject).setHotVideoData(paramHotVideoData);
    ((HotVideoMongoliaRelativeLayout)localObject).setVidoeControlListener(this);
    ((HotVideoMongoliaRelativeLayout)localObject).setControlStateListener(paramMyVideoViewHolder);
    localRelativeLayout.addView((View)localObject, 0, localLayoutParams);
    paramMyVideoViewHolder = paramHotVideoData.getVideoLengthString();
    ((HotVideoMongoliaRelativeLayout)localObject).a = new Size(g, localSize.b());
    paramMyVideoViewHolder = new HotVideoMongoliaRelativeLayout.VideoInfo(paramHotVideoData.name, paramMyVideoViewHolder, paramHotVideoData.originalUrl, paramHotVideoData.mVideoUUID, paramHotVideoData.iconUrl, paramHotVideoData.videoSource, paramHotVideoData.mCertificatedIcon, localSize.a(), localSize.b(), paramHotVideoData.oringinalSize);
    paramHotVideoData = new PresenceInterfaceImpl(this.jdField_a_of_type_AndroidContentContext);
    paramHotVideoData.a(this);
    ((HotVideoMongoliaRelativeLayout)localObject).a(paramHotVideoData, paramMyVideoViewHolder);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007ED9", "0X8007ED9", 0, 0, "", "", "", "");
    ((HotVideoMongoliaRelativeLayout)localObject).c();
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
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, paramString1, paramString1, k, m, paramString2, paramString3, paramString4, paramString5);
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
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    do
    {
      return false;
      if (HotVideoDPC.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.isBlurSwitch is false");
    return false;
    int k = HotVideoDPC.a();
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
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyDataSetChanged();
    this.jdField_c_of_type_Boolean = false;
  }
  
  void b(int paramInt)
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
        localHotPicData = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (localHotPicData.getDataType() == 2);
      paramInt = a(localHotPicData);
    } while ((paramInt == 2) || (paramInt == -1));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(localHotPicData);
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B22", "0X8007B22", 0, 0, "", "", "", "");
  }
  
  public void b(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    int k = 1;
    if (paramMyVideoViewHolder == null) {}
    while ((paramMyVideoViewHolder.jdField_a_of_type_Int != 0) && (paramMyVideoViewHolder.jdField_a_of_type_Int != -11) && (paramMyVideoViewHolder.jdField_a_of_type_Int != 1)) {
      return;
    }
    paramMyVideoViewHolder.a(1);
    if (this.jdField_d_of_type_Boolean)
    {
      paramMyVideoViewHolder.a(0);
      new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(HotVideoMongoliaRelativeLayout.c, 100, 0, 1);
      return;
    }
    HotVideoUtils.a();
    if (!HotVideoUtils.b())
    {
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
      while (k != 0)
      {
        a(paramMyVideoViewHolder, paramInt);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697732), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
        return;
        k = 0;
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697729), new HotPicPageView.5(this, paramMyVideoViewHolder, paramInt), new HotPicPageView.6(this, paramMyVideoViewHolder)).show();
      return;
    }
    Object localObject = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((HotPicData)localObject).getDataType() == 2)
    {
      localObject = (HotVideoData)localObject;
      ((HotVideoData)localObject).GetVideoURLAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "0", new HotPicPageView.7(this, (HotVideoData)localObject, paramMyVideoViewHolder));
      return;
    }
    paramMyVideoViewHolder.a(0);
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
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(0, 6);
    localObject = ShortVideoBusiManager.a(6, localObject, localShortVideoReq);
    ((ShortVideoUploadInfo)localObject).f = true;
    localShortVideoReq.a((ShortVideoUploadInfo)localObject);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDE", "0X8007EDE", 0, 0, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramHotVideoData.picIndex + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", paramHotVideoData.originalMD5 + "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDA", "0X8007EDA", 0, 0, "", "", paramHotVideoData.mVideoUUID, paramHotVideoData.originalMD5);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007ED4", "0X8007ED4", 0, 0, "", "", "", "");
  }
  
  public void c(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    jdField_b_of_type_Boolean = true;
    if (paramMyVideoViewHolder == null) {
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
    b(paramMyVideoViewHolder, paramInt);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.jdField_a_of_type_Int == 3))
    {
      HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a();
      if (localHotVideoMongoliaRelativeLayout != null) {
        localHotVideoMongoliaRelativeLayout.d();
      }
    }
  }
  
  void e()
  {
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setScrollStatusChengedListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new HotPicPageView.3(this);
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((HotPicPageView.MyVideoViewHolder)localObject).a();
    } while (localObject == null);
    ((HotVideoMongoliaRelativeLayout)localObject).a();
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if (localObject != null)
    {
      localObject = ((HotPicPageView.MyVideoViewHolder)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).b();
      }
    }
    int k;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
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
    } while ((k < 0) || (localObject == null) || (!(localObject instanceof HotPicPageView.MyVideoViewHolder)));
    localObject = (HotPicPageView.MyVideoViewHolder)localObject;
    if (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int == 0)
    {
      b((HotPicPageView.MyVideoViewHolder)localObject, k);
      return;
    }
    ((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Boolean = true;
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay tryScrollAndPlayNextVideo");
    }
    if (jdField_b_of_type_Boolean) {}
    int k;
    int m;
    do
    {
      return;
      k = this.h;
      m = k + 1;
    } while (m >= this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.getItemCount());
    this.i = m;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(k, m);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager != null) {
      HotVideoBlurTaskManager.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if (localObject != null)
    {
      if (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int <= 2) {
        break label45;
      }
      localObject = ((HotPicPageView.MyVideoViewHolder)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).d();
      }
    }
    label45:
    while (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int == -10) {
      return;
    }
    ((HotPicPageView.MyVideoViewHolder)localObject).a(0);
  }
  
  public void k()
  {
    int k = 2;
    HotPicManager localHotPicManager = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Int == -20)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(2);
      if (localHotPicManager.a().size() <= 0)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.a(localHotPicManager.a());
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyDataSetChanged();
      return;
    }
    if (localHotPicManager.b(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.a(localHotPicManager.a(this.jdField_a_of_type_Int));
      if (localHotPicManager.c(this.jdField_a_of_type_Int)) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(k);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyDataSetChanged();
        return;
        k = 1;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(8);
    localHotPicManager.a(this.jdField_a_of_type_Int);
  }
  
  void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a = null;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.b();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher = null;
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
        if ((NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)) && (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_b_of_type_JavaUtilSet.size()) && (this.j + 1 <= this.jdField_a_of_type_JavaUtilSet.size()))
        {
          i3 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.size();
          if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) || (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int))) {
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
            localURLDrawable1 = a((HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(i1));
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
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a(i1, localURLDrawable1);
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
            if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.size() < i4) && (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(m))) {
              HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(m);
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
                        localURLDrawable2 = a((HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(i1));
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
                        this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a(i1, localURLDrawable2);
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
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager = HotVideoBlurTaskManager.a(this.jdField_a_of_type_AndroidContentContext);
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
      HotVideoBlurTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagType == 2)) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int)) && (paramKeyEvent.getAction() == 0)) {
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
      if (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int)) {
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
  
  public void setCommonMuteStatus(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if ((localObject != null) && (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int >= 2))
    {
      localObject = ((HotPicPageView.MyVideoViewHolder)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).a(jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void setOnHotPicItemClickListener(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener = paramOnHotPicItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView
 * JD-Core Version:    0.7.0.1
 */