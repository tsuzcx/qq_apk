package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.NowOnliveGallayCallback;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.OnGetPhotoWallListener;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PhotoWallView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, OnGetPhotoWallListener
{
  private static final int MAX_PHOTO_WALL_COUNT = 9;
  private static final int MSG_ADD_NOW_VIDEO_GALLERY = 4;
  private static final int MSG_LOAD_FROM_DATABASE = 1;
  private static final int MSG_LOAD_FROM_SERVER = 2;
  private static final int MSG_LOAD_PHOTO_WALL = 3;
  private static final int MSG_LOAD_PHOTO_WALL_FAILED = 5;
  private static final String TAG = "PhotoWallView";
  protected Activity mActivity;
  protected AppInterface mApp;
  protected View mContentView;
  protected ImageView mEmptyBgCell0;
  protected ImageView mEmptyBgCell1;
  protected ImageView mEmptyBgCell2;
  protected View mEmptyBgView;
  public TextView mEmptyInfo;
  public TextView mEmptyTitle;
  public Button mEmptyUploadBtn;
  protected View mEmptyView;
  protected int mFetchFlag;
  protected Handler mHandler;
  protected LayoutInflater mInflater;
  protected PhotoWallView.PhotoWallUpdaterListener mListener;
  protected View mLoadTipsLayout;
  protected View mMoreLayout;
  protected TextView mMoreText;
  private NowOnliveGallayCallback mNowOnliveGallayCallback = new PhotoWallView.CustomNowOnliveGallayCallback(this);
  protected ArrayList<ProfilePhotoWall> mNowVideoList = new ArrayList();
  protected LinkedList<ProfilePhotoWall> mPhotoList = new LinkedList();
  protected PhotoWallHandler mPhotoWallHandler;
  protected ProfileCardNewPhotoWallView mPhotoWallView;
  protected PhotoWallView.QZonePhotoCache mQZonePhotoCache;
  protected String mUin;
  
  public PhotoWallView(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    super(paramContext);
    this.mActivity = ((Activity)paramContext);
    this.mApp = paramAppInterface;
    this.mUin = paramString;
    onInit();
  }
  
  private void handlePhotoWallData(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.mPhotoList.clear();
      this.mPhotoList.addAll(paramMessage);
      if (this.mNowVideoList.size() != 0) {
        mergeListByTime(this.mPhotoList, this.mNowVideoList);
      }
      if (this.mPhotoList.size() > 9)
      {
        int i = this.mPhotoList.size() - 1;
        while (i >= 9)
        {
          this.mPhotoList.remove(i);
          i -= 1;
        }
      }
      paramMessage = this.mPhotoWallView;
      LinkedList localLinkedList = this.mPhotoList;
      paramMessage.genImg(localLinkedList, localLinkedList.size());
    }
  }
  
  public static void jumpToPhotoWall(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Object localObject = "https://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://ti.qq.com/photowall/index.html?_wv=1027");
      ((StringBuilder)localObject).append("&uin=");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new Intent();
    paramString.putExtra("hide_more_button", true);
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("url", (String)localObject);
    if (!paramBoolean)
    {
      RouteUtils.a(paramActivity, paramString, "/base/browser");
      return;
    }
    RouteUtils.a(paramActivity, paramString, "/base/browser", 100);
  }
  
  public static List<ProfilePhotoWall> mergeListByTime(List<ProfilePhotoWall> paramList1, List<ProfilePhotoWall> paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int k = 0;
    int i = 0;
    while (k < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(k);
      int j = i;
      for (;;)
      {
        i = j;
        if (j >= paramList1.size()) {
          break;
        }
        ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(j);
        if (localProfilePhotoWall1.time < localProfilePhotoWall2.time)
        {
          paramList1.add(j, localProfilePhotoWall1);
          i = j + 1;
          break;
        }
        j += 1;
      }
      k += 1;
    }
    return paramList1;
  }
  
  private void onInit()
  {
    this.mInflater = LayoutInflater.from(getContext());
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mPhotoWallHandler = ((PhotoWallHandler)this.mApp.getBusinessHandler(PhotoWallHandler.class.getName()));
    this.mInflater.inflate(getLayout(), this, true);
    this.mContentView = findViewById(2131372662);
    this.mPhotoWallView = ((ProfileCardNewPhotoWallView)this.mContentView.findViewById(2131372671));
    this.mLoadTipsLayout = this.mContentView.findViewById(2131372673);
    this.mMoreLayout = this.mContentView.findViewById(2131372674);
    this.mMoreText = ((TextView)this.mContentView.findViewById(2131372675));
    this.mEmptyView = findViewById(2131372663);
    this.mEmptyBgView = findViewById(2131372664);
    this.mEmptyBgCell0 = ((ImageView)findViewById(2131372665));
    this.mEmptyBgCell1 = ((ImageView)findViewById(2131372666));
    this.mEmptyBgCell2 = ((ImageView)findViewById(2131372667));
    this.mEmptyTitle = ((TextView)findViewById(2131372669));
    this.mEmptyInfo = ((TextView)findViewById(2131372668));
    this.mEmptyUploadBtn = ((Button)this.mEmptyView.findViewById(2131372670));
    this.mPhotoWallView.preparePhotoWall(this.mUin, this.mActivity, this.mApp);
    this.mMoreText.setOnClickListener(this);
    this.mEmptyBgView.setAlpha(0.15F);
    this.mEmptyUploadBtn.setOnClickListener(this);
    if (this.mApp.getCurrentAccountUin().equals(this.mUin)) {
      this.mMoreText.setText(2131695083);
    } else {
      this.mMoreText.setText(2131695082);
    }
    this.mMoreLayout.setVisibility(8);
    ThreadManager.post(new PhotoWallView.1(this), 5, null, true);
  }
  
  private void updateViewStatus()
  {
    boolean bool1 = this.mApp.getCurrentAccountUin().equals(this.mUin);
    boolean bool2 = this.mPhotoList.isEmpty();
    if (bool1)
    {
      if (bool2)
      {
        this.mContentView.setVisibility(8);
        this.mEmptyView.setVisibility(0);
        return;
      }
      this.mContentView.setVisibility(0);
      this.mEmptyView.setVisibility(8);
      return;
    }
    this.mEmptyView.setVisibility(8);
    if (bool2)
    {
      this.mContentView.setVisibility(8);
      return;
    }
    this.mContentView.setVisibility(0);
  }
  
  protected int getLayout()
  {
    return 2131561359;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FAILED");
            }
            this.mLoadTipsLayout.setVisibility(8);
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_ADD_NOW_VIDEO_GALLERY");
          }
          this.mFetchFlag |= 0x10;
          mergeListByTime(this.mPhotoList, this.mNowVideoList);
          paramMessage = this.mPhotoWallView;
          LinkedList localLinkedList = this.mPhotoList;
          paramMessage.genImg(localLinkedList, localLinkedList.size());
          paramMessage = this.mListener;
          if ((paramMessage != null) && (this.mFetchFlag == 17))
          {
            paramMessage.onUpdatePhotoWall(this.mPhotoList.size());
            updateViewStatus();
            return true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          this.mFetchFlag = 0;
          this.mPhotoWallHandler.getQzonePhotoWall(this.mUin, "");
          try
          {
            long l = Long.parseLong(this.mUin);
            this.mPhotoWallHandler.getNowOnliveGallary(l, this.mNowOnliveGallayCallback);
          }
          catch (Exception paramMessage)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL fail!", paramMessage);
            }
            this.mHandler.sendEmptyMessage(5);
          }
          this.mHandler.removeMessages(3);
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_FROM_SERVER");
        }
        this.mFetchFlag |= 0x1;
        handlePhotoWallData(paramMessage);
        paramMessage = this.mListener;
        if ((paramMessage != null) && (this.mFetchFlag == 17))
        {
          paramMessage.onUpdatePhotoWall(this.mPhotoList.size());
          updateViewStatus();
        }
        if (this.mQZonePhotoCache.hasMore != 1)
        {
          this.mLoadTipsLayout.setVisibility(8);
          return true;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_FROM_DATABASE");
      }
      handlePhotoWallData(paramMessage);
      if ((this.mListener != null) && (this.mPhotoList.size() > 0)) {
        this.mListener.onUpdatePhotoWall(this.mPhotoList.size());
      }
      updateViewStatus();
      paramMessage = Message.obtain();
      paramMessage.what = 3;
      handleMessage(paramMessage);
    }
    return true;
  }
  
  public boolean hasMore()
  {
    PhotoWallView.QZonePhotoCache localQZonePhotoCache = this.mQZonePhotoCache;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localQZonePhotoCache != null)
    {
      bool1 = bool2;
      if (localQZonePhotoCache.hasMore == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = this.mApp.getCurrentAccountUin().equals(this.mUin);
    int i = paramView.getId();
    if (i == 2131372675)
    {
      peformClickMoreText();
      if (bool) {
        ReportController.b(this.mApp, "dc00898", "", "", "0X8007EBE", "0X8007EBE", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.mApp, "dc00898", "", "", "0X8007EBF", "0X8007EBF", 0, 0, "", "", "", "");
      }
    }
    else if (i == 2131372670)
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X8007EC0", "0X8007EC0", 0, 0, "", "", "", "");
      jumpToPhotoWall(this.mActivity, this.mUin, bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onGetQZonePhotoWall(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (!paramBoolean)
    {
      this.mHandler.sendEmptyMessage(5);
      return;
    }
    if (parammobile_sub_get_photo_wall_rsp == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList.addAll(this.mPhotoList);
    }
    update(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, localArrayList);
    paramString = this.mHandler.obtainMessage(2);
    paramString.obj = localArrayList;
    this.mHandler.sendMessage(paramString);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    paramInt3 = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - getResources().getDimensionPixelSize(2131297593) * 2;
    paramInt1 = (int)(f * 2.0F + 0.5F);
    paramInt2 = paramInt3 - paramInt1;
    paramInt4 = paramInt2 * 2 / 3 + 0;
    this.mEmptyBgCell0.layout(0, 0, paramInt4, paramInt4 + paramInt1);
    paramInt2 /= 3;
    paramInt3 -= paramInt2;
    paramInt4 = paramInt3 + paramInt2;
    this.mEmptyBgCell1.layout(paramInt3, 0, paramInt4, paramInt2 + 0);
    paramInt1 += paramInt2;
    this.mEmptyBgCell2.layout(paramInt3, paramInt1, paramInt4, paramInt2 + paramInt1);
  }
  
  public void peformClickMoreText()
  {
    boolean bool = this.mApp.getCurrentAccountUin().equals(this.mUin);
    jumpToPhotoWall(this.mActivity, this.mUin, bool);
  }
  
  public void setPhotoWallUpdaterListener(PhotoWallView.PhotoWallUpdaterListener paramPhotoWallUpdaterListener)
  {
    this.mListener = paramPhotoWallUpdaterListener;
  }
  
  public void startFetchMore()
  {
    if ((this.mQZonePhotoCache.hasMore == 1) && (this.mQZonePhotoCache.curPicSize < 9))
    {
      this.mLoadTipsLayout.setVisibility(0);
      this.mPhotoWallHandler.getQzonePhotoWall(this.mUin, this.mQZonePhotoCache.attachInfo);
    }
  }
  
  protected void update(int paramInt1, int paramInt2, String paramString, ArrayList<PhotoWall> paramArrayList, List<ProfilePhotoWall> paramList)
  {
    if (this.mQZonePhotoCache == null) {
      this.mQZonePhotoCache = new PhotoWallView.QZonePhotoCache();
    }
    Object localObject = this.mQZonePhotoCache;
    ((PhotoWallView.QZonePhotoCache)localObject).totalPic = paramInt1;
    ((PhotoWallView.QZonePhotoCache)localObject).hasMore = paramInt2;
    ((PhotoWallView.QZonePhotoCache)localObject).attachInfo = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        localObject = new QZonePhotoInfo();
        ((QZonePhotoInfo)localObject).uin = this.mUin;
        ((QZonePhotoInfo)localObject).time = paramArrayList.ctime;
        ((QZonePhotoInfo)localObject).photoId = paramArrayList.photoId;
        ((QZonePhotoInfo)localObject).photoUrls = paramArrayList.photoUrls;
        paramList.add(localObject);
      }
      this.mQZonePhotoCache.curPicSize = paramList.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView
 * JD-Core Version:    0.7.0.1
 */