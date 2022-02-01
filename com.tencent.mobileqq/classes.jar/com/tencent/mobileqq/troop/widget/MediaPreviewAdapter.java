package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MediaPreviewAdapter
  extends BaseAdapter
  implements URLDrawableDownListener, DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  public static final int[] a;
  protected Context a;
  protected Drawable a;
  protected SparseArray<WeakReference<URLDrawable>> a;
  protected LayoutInflater a;
  protected DynamicAvatarDownloadManager a;
  protected Gallery a;
  protected List<MediaPreviewInfo> a;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 480, 480 };
  }
  
  public MediaPreviewAdapter(Context paramContext, Gallery paramGallery)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentWidgetGallery = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetGallery = paramGallery;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838024);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = ((DynamicAvatarManager)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this);
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public MediaPreviewInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (MediaPreviewInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    a(true, -1);
    DynamicAvatarDownloadManager localDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
    if (localDynamicAvatarDownloadManager != null) {
      localDynamicAvatarDownloadManager.b(this);
    }
  }
  
  public void a(int paramInt, ImageView paramImageView, File paramFile, String paramString)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = FileUtils.a(str);
    paramFile = (File)localObject;
    if (localObject == null) {
      paramFile = jdField_a_of_type_ArrayOfInt;
    }
    localObject = new QQLiveDrawable.QQLiveDrawableParams();
    int i = paramFile[1];
    int j = paramFile[2];
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewWidth = i;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewHeight = j;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPlayType = 2;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceType = 3;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSource = str;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverUrl = paramString;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mMute = false;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverLoadingDrawable = PAVideoView.a;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopback = true;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopback = true;
    paramFile = URLDrawable.URLDrawableOptions.obtain();
    paramFile.mExtraInfo = localObject;
    paramFile.mLoadingDrawable = a(paramString);
    paramString = new StringBuilder("qqlive://msgId=");
    paramString.append(str);
    paramFile = URLDrawable.getDrawable(paramString.toString(), paramFile);
    paramImageView.setImageDrawable(paramFile);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramFile));
    paramImageView.postDelayed(new MediaPreviewAdapter.2(this), 100L);
    if (QLog.isColorLevel())
    {
      paramFile = new StringBuilder();
      paramFile.append("doShowVideoFile() drawable = ");
      paramFile.append(paramImageView.getDrawable());
      QLog.i("MediaPreviewAdapter", 2, paramFile.toString());
    }
  }
  
  protected void a(int paramInt, MediaPreviewInfo paramMediaPreviewInfo, MediaPreviewAdapter.ViewHolder paramViewHolder)
  {
    long l = System.currentTimeMillis();
    if (paramViewHolder != null)
    {
      if (paramMediaPreviewInfo == null) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadVideo() mediaInfo = ");
        ((StringBuilder)localObject).append(paramMediaPreviewInfo);
        QLog.i("MediaPreviewAdapter", 2, ((StringBuilder)localObject).toString());
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      boolean bool1;
      if (!TextUtils.isEmpty(paramMediaPreviewInfo.c))
      {
        localObject = new File(paramMediaPreviewInfo.c);
        bool2 = ((File)localObject).exists();
        if (bool2) {
          a(paramInt, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView, (File)localObject, paramMediaPreviewInfo.jdField_a_of_type_JavaLangString);
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadVideo() videoFileExsits = ");
          ((StringBuilder)localObject).append(bool2);
          ((StringBuilder)localObject).append(", videoLocalPath = ");
          ((StringBuilder)localObject).append(paramMediaPreviewInfo.c);
          QLog.e("MediaPreviewAdapter", 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.b))
        {
          bool1 = DynamicAvatarDownloadManager.b(paramMediaPreviewInfo.b);
          if (bool1)
          {
            localObject = DynamicAvatarDownloadManager.a(paramMediaPreviewInfo.b);
            a(paramInt, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView, (File)localObject, paramMediaPreviewInfo.jdField_a_of_type_JavaLangString);
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("loadVideo() videoFileExsits = ");
            ((StringBuilder)localObject).append(bool1);
            ((StringBuilder)localObject).append(", videoUrl = ");
            ((StringBuilder)localObject).append(paramMediaPreviewInfo.b);
            QLog.e("MediaPreviewAdapter", 2, ((StringBuilder)localObject).toString());
            bool2 = bool1;
          }
        }
      }
      if (!bool2) {
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.b))
        {
          paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a(paramMediaPreviewInfo.jdField_a_of_type_JavaLangString));
          if (!NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext))
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new MediaPreviewAdapter.1(this, paramViewHolder, paramMediaPreviewInfo));
          }
          else
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            b(paramMediaPreviewInfo, paramViewHolder);
          }
        }
        else
        {
          paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("loadVideo() error startDownloadDynamicAvatar: ");
            paramViewHolder.append(paramMediaPreviewInfo.b);
            QLog.e("MediaPreviewAdapter", 2, paramViewHolder.toString());
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("loadVideo() videoFileExsits = ");
        paramViewHolder.append(bool2);
        paramViewHolder.append(", videoUrl = ");
        paramViewHolder.append(paramMediaPreviewInfo.b);
        paramViewHolder.append(", costTime = ");
        paramViewHolder.append(System.currentTimeMillis() - l);
        QLog.e("MediaPreviewAdapter", 2, paramViewHolder.toString());
      }
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (((paramURLDrawable instanceof URLDrawable)) && (paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)paramURLDrawable.getCurrDrawable()).resume();
    }
  }
  
  protected void a(URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (((paramURLDrawable instanceof URLDrawable)) && (paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      paramURLDrawable = (QQLiveDrawable)paramURLDrawable.getCurrDrawable();
      paramURLDrawable.pause();
      if (paramBoolean)
      {
        paramURLDrawable.setOnStateListener(null);
        paramURLDrawable.setParams(null);
        paramURLDrawable.release();
      }
    }
  }
  
  public void a(MediaPreviewInfo paramMediaPreviewInfo, MediaPreviewAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (paramMediaPreviewInfo == null) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadBigImage() mediaInfo = ");
        ((StringBuilder)localObject).append(paramMediaPreviewInfo);
        QLog.i("MediaPreviewAdapter", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        paramMediaPreviewInfo = paramMediaPreviewInfo.jdField_a_of_type_JavaLangString;
        localObject = Uri.parse(paramMediaPreviewInfo).getScheme();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).equals("http")) || (((String)localObject).equals("https")))) {
          paramMediaPreviewInfo = new URL(paramMediaPreviewInfo);
        } else {
          paramMediaPreviewInfo = new File(paramMediaPreviewInfo).toURL();
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AppSetting.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AppSetting.b;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (this.jdField_a_of_type_Boolean) {
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        }
        a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramMediaPreviewInfo = URLDrawable.getDrawable(paramMediaPreviewInfo, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMediaPreviewInfo);
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramViewHolder);
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
        return;
      }
      catch (MalformedURLException paramMediaPreviewInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MediaPreviewAdapter", 2, paramMediaPreviewInfo.toString());
        }
      }
    }
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 4) {
      paramImageProgressCircle.setVisibility(4);
    }
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 0) {
      paramImageProgressCircle.setVisibility(0);
    }
    paramImageProgressCircle.setProgress(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((View)localObject).getTag();
    }
    MediaPreviewInfo localMediaPreviewInfo = a(this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition());
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.b)) && ((localObject instanceof MediaPreviewAdapter.ViewHolder)))
    {
      a(((MediaPreviewAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onDownloadUpdate progress: ");
        paramString.append(paramInt);
        QLog.i("MediaPreviewAdapter", 2, paramString.toString());
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDownloadFinish() isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", url = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("MediaPreviewAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((View)localObject1).getTag();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition();
    Object localObject2 = a(i);
    if ((localObject2 != null) && (paramString.equals(((MediaPreviewInfo)localObject2).b)) && ((localObject1 instanceof MediaPreviewAdapter.ViewHolder)))
    {
      localObject1 = (MediaPreviewAdapter.ViewHolder)localObject1;
      boolean bool = false;
      paramBoolean2 = bool;
      if (paramBoolean1)
      {
        paramBoolean2 = bool;
        if (DynamicAvatarDownloadManager.b(((MediaPreviewInfo)localObject2).b))
        {
          paramBoolean2 = true;
          File localFile = DynamicAvatarDownloadManager.a(((MediaPreviewInfo)localObject2).b);
          ((MediaPreviewAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.post(new MediaPreviewAdapter.3(this, (MediaPreviewAdapter.ViewHolder)localObject1, i, localFile, (MediaPreviewInfo)localObject2));
        }
      }
      if (!paramBoolean2)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onDownloadFinish() finalSuc = ");
          ((StringBuilder)localObject2).append(paramBoolean2);
          ((StringBuilder)localObject2).append(", url = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.e("MediaPreviewAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        ((MediaPreviewAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.post(new MediaPreviewAdapter.4(this, (MediaPreviewAdapter.ViewHolder)localObject1));
      }
    }
  }
  
  public void a(List<MediaPreviewInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pauseOtherVideos() release = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", specialPosition = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MediaPreviewAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < j)
    {
      int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      localObject = (URLDrawable)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).get();
      if (paramInt == k) {
        a((URLDrawable)localObject);
      } else {
        a((URLDrawable)localObject, paramBoolean);
      }
      i += 1;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
  }
  
  protected void b(MediaPreviewInfo paramMediaPreviewInfo, MediaPreviewAdapter.ViewHolder paramViewHolder)
  {
    long l = System.currentTimeMillis();
    DynamicAvatarDownloadManager localDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
    if (localDynamicAvatarDownloadManager != null) {
      localDynamicAvatarDownloadManager.a(paramMediaPreviewInfo.b);
    }
    a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
    if (QLog.isColorLevel())
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("startDownloadVideo: ");
      paramViewHolder.append(paramMediaPreviewInfo.b);
      paramViewHolder.append(", costTime = ");
      paramViewHolder.append(System.currentTimeMillis() - l);
      QLog.i("MediaPreviewAdapter", 2, paramViewHolder.toString());
    }
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559327, null);
      paramView = new MediaPreviewAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368461));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368560));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377831));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (MediaPreviewAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    Object localObject = (MediaPreviewInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((MediaPreviewInfo)localObject).jdField_a_of_type_Int == 1) {
      a((MediaPreviewInfo)localObject, paramView);
    } else if (((MediaPreviewInfo)localObject).jdField_a_of_type_Int == 2) {
      a(paramInt, (MediaPreviewInfo)localObject, paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    String str = "";
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    if (paramThrowable == null) {
      paramURLDrawable = str;
    } else {
      paramURLDrawable = paramThrowable.getMessage();
    }
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("onLoadFailed() urlStr = ");
      paramThrowable.append(paramView);
      paramThrowable.append(", errorMsg = ");
      paramThrowable.append(paramURLDrawable);
      QLog.i("MediaPreviewAdapter", 2, paramThrowable.toString());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    a(((MediaPreviewAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (MediaPreviewAdapter.ViewHolder)paramView.getTag();
    a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadSuccessed() urlStr = ");
      paramURLDrawable.append(paramView);
      QLog.i("MediaPreviewAdapter", 2, paramURLDrawable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MediaPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */