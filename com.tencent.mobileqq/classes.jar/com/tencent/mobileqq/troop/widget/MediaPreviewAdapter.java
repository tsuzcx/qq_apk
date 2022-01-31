package com.tencent.mobileqq.troop.widget;

import ajzy;
import ajzz;
import akaa;
import akab;
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
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
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
  public Drawable a;
  protected SparseArray a;
  protected LayoutInflater a;
  protected DynamicAvatarDownloadManager a;
  public Gallery a;
  protected List a;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 480, 480 };
  }
  
  public MediaPreviewAdapter(Context paramContext, Gallery paramGallery)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetGallery = paramGallery;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837617);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    paramContext = (DynamicAvatarManager)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(179);
    if (paramContext == null) {}
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = paramContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this);
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.b(this);
    }
  }
  
  public void a(int paramInt, ImageView paramImageView, File paramFile, String paramString)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = VideoUtils.a(str);
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
    paramFile = URLDrawable.getDrawable("qqlive://msgId=" + str, paramFile);
    paramImageView.setImageDrawable(paramFile);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramFile));
    paramImageView.postDelayed(new ajzz(this), 100L);
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "doShowVideoFile() drawable = " + paramImageView.getDrawable());
    }
  }
  
  protected void a(int paramInt, MediaPreviewInfo paramMediaPreviewInfo, MediaPreviewAdapter.ViewHolder paramViewHolder)
  {
    long l = System.currentTimeMillis();
    if ((paramViewHolder == null) || (paramMediaPreviewInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "loadVideo() mediaInfo = " + paramMediaPreviewInfo);
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    File localFile;
    boolean bool2;
    if (!TextUtils.isEmpty(paramMediaPreviewInfo.c))
    {
      localFile = new File(paramMediaPreviewInfo.c);
      bool2 = localFile.exists();
      if (bool2) {
        a(paramInt, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localFile, paramMediaPreviewInfo.jdField_a_of_type_JavaLangString);
      }
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool2 + ", videoLocalPath = " + paramMediaPreviewInfo.c);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.b))
        {
          bool1 = DynamicAvatarDownloadManager.b(paramMediaPreviewInfo.b);
          if (bool1)
          {
            localFile = DynamicAvatarDownloadManager.a(paramMediaPreviewInfo.b);
            a(paramInt, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localFile, paramMediaPreviewInfo.jdField_a_of_type_JavaLangString);
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool1 + ", videoUrl = " + paramMediaPreviewInfo.b);
            bool2 = bool1;
          }
        }
      }
      if (!bool2)
      {
        if (TextUtils.isEmpty(paramMediaPreviewInfo.b)) {
          break label419;
        }
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a(paramMediaPreviewInfo.jdField_a_of_type_JavaLangString));
        if (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
          break label401;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ajzy(this, paramViewHolder, paramMediaPreviewInfo));
      }
      while (QLog.isColorLevel())
      {
        QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool2 + ", videoUrl = " + paramMediaPreviewInfo.b + ", costTime = " + (System.currentTimeMillis() - l));
        return;
        label401:
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        b(paramMediaPreviewInfo, paramViewHolder);
        continue;
        label419:
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (QLog.isColorLevel()) {
          QLog.e("MediaPreviewAdapter", 2, "loadVideo() error startDownloadDynamicAvatar: " + paramMediaPreviewInfo.b);
        }
      }
      break;
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
    if ((paramViewHolder == null) || (paramMediaPreviewInfo == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "loadBigImage() mediaInfo = " + paramMediaPreviewInfo);
      }
      try
      {
        paramMediaPreviewInfo = paramMediaPreviewInfo.jdField_a_of_type_JavaLangString;
        Object localObject = Uri.parse(paramMediaPreviewInfo).getScheme();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals("http")) && (!((String)localObject).equals("https")))) {}
        for (paramMediaPreviewInfo = new File(paramMediaPreviewInfo).toURL();; paramMediaPreviewInfo = new URL(paramMediaPreviewInfo))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AppSetting.b;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AppSetting.c;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
        if (!QLog.isColorLevel()) {}
      }
      catch (MalformedURLException paramMediaPreviewInfo) {}
    }
    QLog.i("MediaPreviewAdapter", 2, paramMediaPreviewInfo.toString());
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView().getTag();
    MediaPreviewInfo localMediaPreviewInfo = a(this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition());
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.b)) && ((localObject instanceof MediaPreviewAdapter.ViewHolder)))
    {
      a(((MediaPreviewAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "onDownloadUpdate progress: " + paramInt);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "onDownloadFinish() isSuccess = " + paramBoolean1 + ", url = " + paramString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView().getTag();
    int i = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition();
    MediaPreviewInfo localMediaPreviewInfo = a(i);
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.b)) && ((localObject instanceof MediaPreviewAdapter.ViewHolder)))
    {
      localObject = (MediaPreviewAdapter.ViewHolder)localObject;
      boolean bool = false;
      paramBoolean2 = bool;
      if (paramBoolean1)
      {
        paramBoolean2 = bool;
        if (DynamicAvatarDownloadManager.b(localMediaPreviewInfo.b))
        {
          File localFile = DynamicAvatarDownloadManager.a(localMediaPreviewInfo.b);
          ((MediaPreviewAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.post(new akaa(this, (MediaPreviewAdapter.ViewHolder)localObject, i, localFile, localMediaPreviewInfo));
          paramBoolean2 = true;
        }
      }
      if (!paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MediaPreviewAdapter", 2, "onDownloadFinish() finalSuc = " + paramBoolean2 + ", url = " + paramString);
        }
        ((MediaPreviewAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.post(new akab(this, (MediaPreviewAdapter.ViewHolder)localObject));
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "pauseOtherVideos() release = " + paramBoolean + ", specialPosition = " + paramInt);
      }
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      if (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        URLDrawable localURLDrawable = (URLDrawable)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).get();
        if (paramInt == k) {
          a(localURLDrawable);
        }
        for (;;)
        {
          i += 1;
          break;
          a(localURLDrawable, paramBoolean);
        }
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void b(MediaPreviewInfo paramMediaPreviewInfo, MediaPreviewAdapter.ViewHolder paramViewHolder)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(paramMediaPreviewInfo.b);
    }
    a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "startDownloadVideo: " + paramMediaPreviewInfo.b + ", costTime = " + (System.currentTimeMillis() - l));
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MediaPreviewInfo localMediaPreviewInfo;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969068, null);
      paramViewGroup = new MediaPreviewAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131361846));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131361845));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364990));
      paramView.setTag(paramViewGroup);
      a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      localMediaPreviewInfo = (MediaPreviewInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localMediaPreviewInfo.jdField_a_of_type_Int != 1) {
        break label124;
      }
      a(localMediaPreviewInfo, paramViewGroup);
    }
    label124:
    while (localMediaPreviewInfo.jdField_a_of_type_Int != 2)
    {
      return paramView;
      paramViewGroup = (MediaPreviewAdapter.ViewHolder)paramView.getTag();
      break;
    }
    a(paramInt, localMediaPreviewInfo, paramViewGroup);
    return paramView;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramView = paramURLDrawable.getURL().toString();; paramView = "")
    {
      if (paramThrowable == null) {}
      for (paramURLDrawable = "";; paramURLDrawable = paramThrowable.getMessage())
      {
        if (QLog.isColorLevel()) {
          QLog.i("MediaPreviewAdapter", 2, "onLoadFailed() urlStr = " + paramView + ", errorMsg = " + paramURLDrawable);
        }
        return;
      }
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
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "onLoadSuccessed() urlStr = " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MediaPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */