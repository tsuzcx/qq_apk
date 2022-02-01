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
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakConstants;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
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
import mqq.app.AppRuntime;
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
  BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
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
    e = AIOUtils.b(1.0F, localResources);
    jdField_d_of_type_Int = (localResources.getDisplayMetrics().widthPixels - e * 8) / 3;
    f = AIOUtils.b(1.0F, localResources);
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
    URL localURL;
    if (paramHotPicData.getDataType() == 2) {
      localURL = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData);
    } else {
      localURL = HotPicDownLoader.a(paramHotPicData.url);
    }
    if (localURL == null) {
      return -1;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    if (paramHotPicData.getDataType() == 2) {
      localObject = HotVideoPreviewDownloader.a(paramHotPicData.md5);
    } else {
      localObject = HotPicDownLoader.a(paramHotPicData.url);
    }
    if ((localObject != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath()))) {
      return 0;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      localObject = HotPicDownLoader.a(paramHotPicData.url);
      if ((localObject != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath()))) {
        return -1;
      }
      URLDrawable.removeMemoryCacheByUrl(localURL.toString());
      paramHotPicData = a(paramHotPicData);
      if (paramHotPicData != null) {
        paramHotPicData.startDownload();
      }
      return 1;
    }
    localURLDrawable.startDownload();
    return 2;
  }
  
  static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    boolean bool;
    if (paramHotPicData.getDataType() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    localURLDrawableOptions.mPlayGifImage = bool;
    localURLDrawableOptions.mExtraInfo = paramHotPicData;
    if (paramHotPicData.getDataType() == 2) {
      paramHotPicData = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData);
    } else {
      paramHotPicData = HotPicDownLoader.a(paramHotPicData.url);
    }
    if (paramHotPicData == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public static Size a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt2 > 0) && (paramInt3 > 0) && (paramDouble != 0.0D) && (paramInt1 > 0))
    {
      double d1 = paramInt2 / paramInt3;
      Double.isNaN(d1);
      d1 -= paramDouble;
      if (d1 > 0.01D)
      {
        if (paramInt2 != paramInt1)
        {
          d1 = paramInt1 / paramInt2;
          paramDouble = paramInt3;
          Double.isNaN(paramDouble);
          Double.isNaN(d1);
        }
      }
      else {
        for (;;)
        {
          paramInt3 = (int)(paramDouble * d1);
          break label200;
          if (d1 < 0.01D)
          {
            if (paramInt2 == paramInt1) {
              break;
            }
            d1 = paramInt1;
            Double.isNaN(d1);
            paramDouble = d1 / paramDouble;
            d1 = paramInt3;
            Double.isNaN(d1);
            if (Math.abs(d1 - paramDouble) <= 0.01D) {
              break;
            }
            Double.isNaN(d1);
            d1 = paramDouble / d1;
            double d2 = paramInt2;
            Double.isNaN(d2);
            paramInt1 = (int)(d2 * d1);
            paramInt3 = (int)paramDouble;
            break label200;
          }
          if (paramInt2 == paramInt1) {
            break;
          }
          d1 = paramInt1 / paramInt2;
          paramDouble = paramInt3;
          Double.isNaN(paramDouble);
          Double.isNaN(d1);
        }
      }
      paramInt1 = paramInt2;
      label200:
      return new Size(paramInt1, paramInt3);
    }
    return null;
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
    boolean bool;
    if (jdField_c_of_type_Int <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay startAutoPlayTimer");
    }
    int m = NetworkUtil.getNetworkType(BaseApplication.getContext());
    int k = 1;
    if (m != 1) {
      k = 0;
    }
    if (!jdField_b_of_type_Boolean)
    {
      if (k == 0) {
        return;
      }
      h();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    try
    {
      HotPicData localHotPicData = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localHotPicData.getDataType() == 2) {
        return;
      }
      int k = localHotPicData.tag;
      localObject1 = HotPicDownLoader.a(localHotPicData.originalUrl);
      if ((localObject1 != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject1).getAbsolutePath())))
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("senHotPic, urlHotPicOringinal = ");
          ((StringBuilder)localObject2).append(localHotPicData.originalUrl);
          ((StringBuilder)localObject2).append(", paths = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject2).toString());
        }
        k = 1;
      }
      else
      {
        if (a(localHotPicData) == 0)
        {
          localObject1 = HotPicDownLoader.a(localHotPicData.url).getAbsolutePath();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("senHotPic, urlHotPic = ");
            ((StringBuilder)localObject2).append(localHotPicData.url);
            ((StringBuilder)localObject2).append(", paths = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = null;
        }
        k = 0;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localHotPicData.url);
      localStringBuilder.append("");
      a("0X8007EDE", (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener;
      if ((localObject2 != null) && (((HotPicPageView.OnHotPicItemClickListener)localObject2).a(paramView, (String)localObject1, localHotPicData))) {
        return;
      }
      if ((localObject1 == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1008))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131698963, 0).a();
        return;
      }
      paramView = new Intent();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b);
      paramView.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.e);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1A", "0X8007B1A", 0, 0, "", "", "", "");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1)
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
      if (this.jdField_a_of_type_Int == -20) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B18", "0X8007B18", 0, 0, "", "", "", "");
      }
      paramInt = localHotPicData.sourceType;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1F", "0X8007B1F", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B20", "0X8007B20", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B1E", "0X8007B1E", 0, 0, "", "", "", "");
      return;
    }
    catch (IndexOutOfBoundsException paramView)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("senHotPic, onItemClick IndexOutOfBoundsException ");
        ((StringBuilder)localObject1).append(paramView.getMessage());
        QLog.d("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(HotPicMainPanel paramHotPicMainPanel, HotPicTagInfo paramHotPicTagInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView = ((HotPicRecyclerView)findViewById(2131376308));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370360);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368307);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramHotPicMainPanel.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo = paramHotPicTagInfo;
    this.jdField_a_of_type_Int = paramHotPicTagInfo.tagId;
    this.jdField_b_of_type_Int = paramHotPicTagInfo.position;
    int k;
    if (paramHotPicTagInfo.tagType == 2) {
      k = 1;
    } else {
      k = 3;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(k, 1);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mExceptionListener = new HotPicPageView.1(this);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter = new HotPicPageView.HotPicAdapter(this, this.jdField_a_of_type_Int);
    paramHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter;
    paramHotPicTagInfo.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener = this;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter = new HotPicPageView.HotPicFooter(this, paramHotPicTagInfo);
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
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder)
  {
    if (paramMyVideoViewHolder == null) {
      return;
    }
    HotPicPageView.MyVideoViewHolder localMyVideoViewHolder = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if ((localMyVideoViewHolder != null) && (localMyVideoViewHolder != paramMyVideoViewHolder))
    {
      if (localMyVideoViewHolder.jdField_a_of_type_Int >= 1) {
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
    localObject = (HotVideoMongoliaRelativeLayout)((LayoutInflater)localObject).inflate(2131559223, null);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
    if (localObject != null)
    {
      if ((localObject instanceof PublicAccountHotPicPanel))
      {
        k = 3;
        break label59;
      }
      if ((localObject instanceof TribeHotPicPanel))
      {
        k = 4;
        break label59;
      }
      if (!(localObject instanceof HotPicMainPanel))
      {
        k = 5;
        break label59;
      }
    }
    int k = 1;
    label59:
    if (k == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
      if ((localObject != null) && (((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
        m = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int;
        if (m != 0)
        {
          if (m != 1)
          {
            if (m != 3000) {
              break label147;
            }
            m = 3;
            break label150;
          }
          m = 2;
          break label150;
        }
        m = 1;
        break label150;
      }
    }
    localObject = "";
    label147:
    int m = 0;
    label150:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localObject, paramString1, paramString1, k, m, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    boolean bool = false;
    if (localObject1 == null) {
      return false;
    }
    if (!HotVideoDPC.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.isBlurSwitch is false");
      }
      return false;
    }
    int k = HotVideoDPC.a();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" HotVideoDPC.getBlurMemory is ");
      ((StringBuilder)localObject1).append(k);
      QLog.i("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    localObject1 = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject2).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" mi.availMem is ");
      ((StringBuilder)localObject2).append(((ActivityManager.MemoryInfo)localObject1).availMem / 1024L);
      QLog.i("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject2).toString());
    }
    if (((ActivityManager.MemoryInfo)localObject1).availMem > k * 1024 * 1024) {
      bool = true;
    }
    return bool;
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
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) {
      return;
    }
    HotPicData localHotPicData = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localHotPicData.getDataType() == 2) {
      return;
    }
    paramInt = a(localHotPicData);
    if (paramInt != 2)
    {
      if (paramInt == -1) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(localHotPicData);
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B22", "0X8007B22", 0, 0, "", "", "", "");
    }
  }
  
  public void b(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    if (paramMyVideoViewHolder == null) {
      return;
    }
    int m = paramMyVideoViewHolder.jdField_a_of_type_Int;
    int k = 1;
    if ((m != 0) && (paramMyVideoViewHolder.jdField_a_of_type_Int != -11) && (paramMyVideoViewHolder.jdField_a_of_type_Int != 1)) {
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
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {
        k = 0;
      }
      if (k != 0)
      {
        a(paramMyVideoViewHolder, paramInt);
        paramMyVideoViewHolder = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a(paramMyVideoViewHolder, paramMyVideoViewHolder.getResources().getString(2131697738), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
        return;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext;
      DialogUtil.a((Context)localObject, 232, null, ((Context)localObject).getResources().getString(2131697735), new HotPicPageView.5(this, paramMyVideoViewHolder, paramInt), new HotPicPageView.6(this, paramMyVideoViewHolder)).show();
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
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b);
    ((Intent)localObject1).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.e);
    ((Intent)localObject1).putExtra("file_send_size", paramHotVideoData.oringinalSize);
    ((Intent)localObject1).putExtra("file_send_business_type", 6);
    ((Intent)localObject1).putExtra("file_shortvideo_md5", paramHotVideoData.originalMD5);
    ((Intent)localObject1).putExtra("file_uuid", paramHotVideoData.mVideoUUID);
    ((Intent)localObject1).putExtra("thumbfile_send_width", paramHotVideoData.width);
    ((Intent)localObject1).putExtra("thumbfile_send_height", paramHotVideoData.height);
    ((Intent)localObject1).putExtra("thumbfile_md5", paramHotVideoData.md5);
    ((Intent)localObject1).putExtra("file_thumb_Size", paramHotVideoData.fileSize);
    ((Intent)localObject1).putExtra("support_progressive", true);
    ((Intent)localObject1).putExtra("file_width", paramHotVideoData.originalWidth);
    ((Intent)localObject1).putExtra("file_height", paramHotVideoData.originalHeight);
    ((Intent)localObject1).putExtra("file_send_duration", (int)(paramHotVideoData.videoLength / 1000L));
    ((Intent)localObject1).putExtra("hot_video_icon", paramHotVideoData.iconUrl);
    ((Intent)localObject1).putExtra("hot_video_icon_sub", paramHotVideoData.mCertificatedIcon);
    ((Intent)localObject1).putExtra("hot_video_title", paramHotVideoData.videoSource);
    ((Intent)localObject1).putExtra("hot_video_url", paramHotVideoData.jumpUrl);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramHotVideoData.name);
    ((StringBuilder)localObject2).append(".mp4");
    ((Intent)localObject1).putExtra("hot_video_name", ((StringBuilder)localObject2).toString());
    ((Intent)localObject1).putExtra("special_video_type", 1);
    localObject2 = SVBusiUtil.a(0, 6);
    localObject1 = ShortVideoBusiManager.a(6, localObject1, (ShortVideoReq)localObject2);
    ((ShortVideoUploadInfo)localObject1).f = true;
    ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
    ShortVideoBusiManager.a((ShortVideoReq)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramHotVideoData.picIndex);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHotVideoData.originalMD5);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X8007EDE", "0X8007EDE", 0, 0, (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
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
      HotPicRecyclerView.a("onVideoItemClick");
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(paramInt);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoItemClick CheckItemIsNeedToScroll End isNeedScroll is ");
      ((StringBuilder)localObject).append(bool);
      HotPicRecyclerView.a(((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if ((localObject != null) && (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int == 3))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).d();
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
    if (localObject == null) {
      return;
    }
    localObject = ((HotPicPageView.MyVideoViewHolder)localObject).a();
    if (localObject == null) {
      return;
    }
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
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == 0) {
      return;
    }
    if (jdField_b_of_type_Boolean) {
      return;
    }
    int k = this.i;
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(k);
    if ((k >= 0) && (localObject != null) && ((localObject instanceof HotPicPageView.MyVideoViewHolder)))
    {
      localObject = (HotPicPageView.MyVideoViewHolder)localObject;
      if (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int == 0)
      {
        b((HotPicPageView.MyVideoViewHolder)localObject, k);
        return;
      }
      ((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Boolean = true;
    }
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
    if (jdField_b_of_type_Boolean) {
      return;
    }
    int k = this.h;
    int m = k + 1;
    if (m >= this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.getItemCount()) {
      return;
    }
    this.i = m;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(k, m);
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager;
    if (localObject != null) {
      HotVideoBlurTaskManager.b((HotVideoBlurTaskManager)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder;
    if (localObject != null)
    {
      if (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int > 2)
      {
        localObject = ((HotPicPageView.MyVideoViewHolder)localObject).a();
        if (localObject != null) {
          ((HotVideoMongoliaRelativeLayout)localObject).d();
        }
        return;
      }
      if (((HotPicPageView.MyVideoViewHolder)localObject).jdField_a_of_type_Int != -10) {
        ((HotPicPageView.MyVideoViewHolder)localObject).a(0);
      }
    }
  }
  
  public void k()
  {
    HotPicManager localHotPicManager = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int m = this.jdField_a_of_type_Int;
    int k = 2;
    if (m == -20)
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
    if (localHotPicManager.b(m))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.a(localHotPicManager.a(this.jdField_a_of_type_Int));
      if (!localHotPicManager.c(this.jdField_a_of_type_Int)) {
        k = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicFooter.a(k);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.notifyDataSetChanged();
      return;
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
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(localBroadcastReceiver);
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
    try
    {
      if ((!NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_JavaUtilSet.size() != this.jdField_b_of_type_JavaUtilSet.size()) || (this.j + 1 > this.jdField_a_of_type_JavaUtilSet.size())) {
        break label800;
      }
      k = 16;
      i3 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) || (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int))) {
        break label816;
      }
      k = 8;
      i1 = 1;
    }
    finally
    {
      for (;;)
      {
        int k;
        int i3;
        int i5;
        int i4;
        int m;
        int n;
        int i2;
        boolean bool;
        label782:
        for (;;)
        {
          label413:
          label800:
          throw localObject;
        }
        label816:
        int i1 = 2;
      }
    }
    i5 = (this.j / k + 1) * k - 1;
    i4 = k + i5;
    m = 0;
    k = 0;
    n = 0;
    if (this.jdField_a_of_type_JavaUtilSet.size() <= i5)
    {
      if (this.jdField_b_of_type_JavaUtilSet.size() <= i5)
      {
        i2 = this.jdField_b_of_type_JavaUtilSet.size();
        for (k = n;; k = m)
        {
          m = k;
          if (i2 > i5) {
            break;
          }
          m = k;
          if (i2 >= i3) {
            break;
          }
          bool = this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(i2));
          m = k;
          if (!bool)
          {
            n = k;
            try
            {
              URLDrawable localURLDrawable1 = a((HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(i2));
              if (localURLDrawable1 == null) {
                return;
              }
              n = k;
              m = localURLDrawable1.getStatus();
              if (m != 1)
              {
                m = k + 1;
                if (k < i1) {
                  try
                  {
                    this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a(i2, localURLDrawable1);
                    k = m;
                  }
                  catch (Exception localException1)
                  {
                    n = m;
                    break label413;
                  }
                }
              }
              else
              {
                n = k;
                this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i2));
              }
              n = k;
              this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(i2));
              n = k;
              m = k;
              if (QLog.isColorLevel())
              {
                n = k;
                StringBuilder localStringBuilder1 = new StringBuilder();
                n = k;
                localStringBuilder1.append("preDownload  ");
                n = k;
                localStringBuilder1.append(this.jdField_a_of_type_Int);
                n = k;
                localStringBuilder1.append(" ");
                n = k;
                localStringBuilder1.append(i2);
                n = k;
                QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder1.toString());
                m = k;
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              m = n;
              if (QLog.isColorLevel())
              {
                QLog.d("HotPicManagerHotPicPageView", 2, "preDownloadOnUi !mStartDownLoadIndex.contains(index) Exception ", localException2);
                m = n;
              }
            }
          }
          i2 += 1;
        }
      }
      k = m;
      if (m != 0) {
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilSet.size() > i5)
    {
      m = this.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.size() < i4) && (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(m))) {
        HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(m);
      }
      if (this.jdField_b_of_type_JavaUtilSet.size() <= i4)
      {
        i2 = this.jdField_b_of_type_JavaUtilSet.size();
        while ((i2 <= i4) && (i2 < i3))
        {
          bool = this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(i2));
          n = k;
          if (!bool)
          {
            m = k;
            try
            {
              URLDrawable localURLDrawable2 = a((HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.jdField_a_of_type_JavaUtilList.get(i2));
              if (localURLDrawable2 == null) {
                return;
              }
              m = k;
              n = localURLDrawable2.getStatus();
              if (n != 1)
              {
                m = k + 1;
                if (k < i1) {
                  try
                  {
                    this.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a(i2, localURLDrawable2);
                    k = m;
                  }
                  catch (Exception localException3)
                  {
                    break label782;
                  }
                }
              }
              else
              {
                m = k;
                this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i2));
              }
              m = k;
              this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(i2));
              m = k;
              n = k;
              if (QLog.isColorLevel())
              {
                m = k;
                StringBuilder localStringBuilder2 = new StringBuilder();
                m = k;
                localStringBuilder2.append("preDownload  ");
                m = k;
                localStringBuilder2.append(this.jdField_a_of_type_Int);
                m = k;
                localStringBuilder2.append(" ");
                m = k;
                localStringBuilder2.append(i2);
                m = k;
                QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder2.toString());
                n = k;
              }
            }
            catch (Exception localException4)
            {
              localException4.printStackTrace();
              n = m;
            }
          }
          i2 += 1;
          k = n;
        }
      }
    }
  }
  
  void o()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager;
    if (localObject1 == null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager = HotVideoBlurTaskManager.a(this.jdField_a_of_type_AndroidContentContext);
    } else {
      HotVideoBlurTaskManager.a((HotVideoBlurTaskManager)localObject1);
    }
    int k = 0;
    while (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
      {
        int m = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k);
        localObject1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(m);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(m);
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName);
        ((StringBuilder)localObject5).append("");
        localObject5 = ((StringBuilder)localObject5).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("");
        a("0X8007EDD", (String)localObject3, (String)localObject4, (String)localObject5, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.add(localObject2);
      }
      k += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo;
    if ((localHotPicTagInfo != null) && (localHotPicTagInfo.tagType == 2)) {
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Int))
    {
      if (paramMotionEvent.getAction() == 0) {
        jdField_b_of_type_Boolean = true;
      }
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_b_of_type_AndroidViewView;
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
        if (Build.VERSION.SDK_INT >= 16) {
          paramMotionEvent.setBackgroundColor(Color.parseColor("#7f000000"));
        } else {
          paramMotionEvent.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
        }
        localRelativeLayout.addView(paramMotionEvent, paramView);
      }
    }
    else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      paramView = localRelativeLayout.findViewWithTag("HotPicPopControlTag");
      if (paramView != null) {
        localRelativeLayout.removeView(paramView);
      }
      if (((View)localObject).getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.g();
      }
    }
    if (((View)localObject).getVisibility() == 0) {
      bool = true;
    }
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView
 * JD-Core Version:    0.7.0.1
 */