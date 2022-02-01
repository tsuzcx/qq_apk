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
  public static final int[] a = { 0, 480, 480 };
  protected Context b;
  protected LayoutInflater c;
  protected boolean d = true;
  protected List<MediaPreviewInfo> e = null;
  protected Drawable f = null;
  protected Gallery g = null;
  protected DynamicAvatarDownloadManager h = null;
  protected SparseArray<WeakReference<URLDrawable>> i = null;
  
  public MediaPreviewAdapter(Context paramContext, Gallery paramGallery)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.g = paramGallery;
    this.f = paramContext.getResources().getDrawable(2130838066);
    this.i = new SparseArray();
    this.h = ((DynamicAvatarManager)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).e();
    this.h.a(this);
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public MediaPreviewInfo a(int paramInt)
  {
    if ((this.e != null) && (paramInt < getCount())) {
      return (MediaPreviewInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    a(true, -1);
    DynamicAvatarDownloadManager localDynamicAvatarDownloadManager = this.h;
    if (localDynamicAvatarDownloadManager != null) {
      localDynamicAvatarDownloadManager.b(this);
    }
  }
  
  public void a(int paramInt, ImageView paramImageView, File paramFile, String paramString)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = FileUtils.o(str);
    paramFile = (File)localObject;
    if (localObject == null) {
      paramFile = a;
    }
    localObject = new QQLiveDrawable.QQLiveDrawableParams();
    int j = paramFile[1];
    int k = paramFile[2];
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewWidth = j;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewHeight = k;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPlayType = 2;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceType = 3;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSource = str;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverUrl = paramString;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mMute = false;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverLoadingDrawable = PAVideoView.V;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopback = true;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopback = true;
    paramFile = URLDrawable.URLDrawableOptions.obtain();
    paramFile.mExtraInfo = localObject;
    paramFile.mLoadingDrawable = a(paramString);
    paramString = new StringBuilder("qqlive://msgId=");
    paramString.append(str);
    paramFile = URLDrawable.getDrawable(paramString.toString(), paramFile);
    paramImageView.setImageDrawable(paramFile);
    this.i.put(paramInt, new WeakReference(paramFile));
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
      paramViewHolder.a.setVisibility(8);
      boolean bool1;
      if (!TextUtils.isEmpty(paramMediaPreviewInfo.d))
      {
        localObject = new File(paramMediaPreviewInfo.d);
        bool2 = ((File)localObject).exists();
        if (bool2) {
          a(paramInt, paramViewHolder.b, (File)localObject, paramMediaPreviewInfo.b);
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadVideo() videoFileExsits = ");
          ((StringBuilder)localObject).append(bool2);
          ((StringBuilder)localObject).append(", videoLocalPath = ");
          ((StringBuilder)localObject).append(paramMediaPreviewInfo.d);
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
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.c))
        {
          bool1 = DynamicAvatarDownloadManager.e(paramMediaPreviewInfo.c);
          if (bool1)
          {
            localObject = DynamicAvatarDownloadManager.d(paramMediaPreviewInfo.c);
            a(paramInt, paramViewHolder.b, (File)localObject, paramMediaPreviewInfo.b);
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("loadVideo() videoFileExsits = ");
            ((StringBuilder)localObject).append(bool1);
            ((StringBuilder)localObject).append(", videoUrl = ");
            ((StringBuilder)localObject).append(paramMediaPreviewInfo.c);
            QLog.e("MediaPreviewAdapter", 2, ((StringBuilder)localObject).toString());
            bool2 = bool1;
          }
        }
      }
      if (!bool2) {
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.c))
        {
          paramViewHolder.b.setImageDrawable(a(paramMediaPreviewInfo.b));
          if (!NetworkUtil.isWifiEnabled(this.b))
          {
            paramViewHolder.a.setVisibility(0);
            paramViewHolder.a.setOnClickListener(new MediaPreviewAdapter.1(this, paramViewHolder, paramMediaPreviewInfo));
          }
          else
          {
            paramViewHolder.a.setVisibility(8);
            b(paramMediaPreviewInfo, paramViewHolder);
          }
        }
        else
        {
          paramViewHolder.b.setImageDrawable(this.f);
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("loadVideo() error startDownloadDynamicAvatar: ");
            paramViewHolder.append(paramMediaPreviewInfo.c);
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
        paramViewHolder.append(paramMediaPreviewInfo.c);
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
        paramMediaPreviewInfo = paramMediaPreviewInfo.b;
        localObject = Uri.parse(paramMediaPreviewInfo).getScheme();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).equals("http")) || (((String)localObject).equals("https")))) {
          paramMediaPreviewInfo = new URL(paramMediaPreviewInfo);
        } else {
          paramMediaPreviewInfo = new File(paramMediaPreviewInfo).toURL();
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AppSetting.j;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AppSetting.k;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        if (this.d) {
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        }
        a(paramViewHolder.c);
        paramViewHolder.a.setVisibility(8);
        paramMediaPreviewInfo = URLDrawable.getDrawable(paramMediaPreviewInfo, (URLDrawable.URLDrawableOptions)localObject);
        paramViewHolder.b.setImageDrawable(paramMediaPreviewInfo);
        paramViewHolder.b.setTag(paramViewHolder);
        paramViewHolder.b.setURLDrawableDownListener(this);
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
    Object localObject = this.g.getSelectedView();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((View)localObject).getTag();
    }
    MediaPreviewInfo localMediaPreviewInfo = a(this.g.getSelectedItemPosition());
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.c)) && ((localObject instanceof MediaPreviewAdapter.ViewHolder)))
    {
      a(((MediaPreviewAdapter.ViewHolder)localObject).c, paramInt);
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
    Object localObject1 = this.g.getSelectedView();
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((View)localObject1).getTag();
    }
    int j = this.g.getSelectedItemPosition();
    Object localObject2 = a(j);
    if ((localObject2 != null) && (paramString.equals(((MediaPreviewInfo)localObject2).c)) && ((localObject1 instanceof MediaPreviewAdapter.ViewHolder)))
    {
      localObject1 = (MediaPreviewAdapter.ViewHolder)localObject1;
      boolean bool = false;
      paramBoolean2 = bool;
      if (paramBoolean1)
      {
        paramBoolean2 = bool;
        if (DynamicAvatarDownloadManager.e(((MediaPreviewInfo)localObject2).c))
        {
          paramBoolean2 = true;
          File localFile = DynamicAvatarDownloadManager.d(((MediaPreviewInfo)localObject2).c);
          ((MediaPreviewAdapter.ViewHolder)localObject1).b.post(new MediaPreviewAdapter.3(this, (MediaPreviewAdapter.ViewHolder)localObject1, j, localFile, (MediaPreviewInfo)localObject2));
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
        ((MediaPreviewAdapter.ViewHolder)localObject1).b.post(new MediaPreviewAdapter.4(this, (MediaPreviewAdapter.ViewHolder)localObject1));
      }
    }
  }
  
  public void a(List<MediaPreviewInfo> paramList)
  {
    this.e = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.i == null) {
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
    int k = this.i.size();
    int j = 0;
    while (j < k)
    {
      int m = this.i.keyAt(j);
      localObject = (URLDrawable)((WeakReference)this.i.get(m)).get();
      if (paramInt == m) {
        a((URLDrawable)localObject);
      } else {
        a((URLDrawable)localObject, paramBoolean);
      }
      j += 1;
    }
    if (paramBoolean) {
      this.i.clear();
    }
  }
  
  protected void b(MediaPreviewInfo paramMediaPreviewInfo, MediaPreviewAdapter.ViewHolder paramViewHolder)
  {
    long l = System.currentTimeMillis();
    DynamicAvatarDownloadManager localDynamicAvatarDownloadManager = this.h;
    if (localDynamicAvatarDownloadManager != null) {
      localDynamicAvatarDownloadManager.a(paramMediaPreviewInfo.c);
    }
    a(paramViewHolder.c, 0);
    if (QLog.isColorLevel())
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("startDownloadVideo: ");
      paramViewHolder.append(paramMediaPreviewInfo.c);
      paramViewHolder.append(", costTime = ");
      paramViewHolder.append(System.currentTimeMillis() - l);
      QLog.i("MediaPreviewAdapter", 2, paramViewHolder.toString());
    }
  }
  
  public int getCount()
  {
    List localList = this.e;
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
      localView = this.c.inflate(2131625292, null);
      paramView = new MediaPreviewAdapter.ViewHolder(this);
      paramView.b = ((URLImageView)localView.findViewById(2131435357));
      paramView.c = ((ImageProgressCircle)localView.findViewById(2131435466));
      paramView.a = ((ImageView)localView.findViewById(2131446301));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (MediaPreviewAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    a(paramView.c);
    Object localObject = (MediaPreviewInfo)this.e.get(paramInt);
    if (((MediaPreviewInfo)localObject).a == 1) {
      a((MediaPreviewInfo)localObject, paramView);
    } else if (((MediaPreviewInfo)localObject).a == 2) {
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
    a(((MediaPreviewAdapter.ViewHolder)paramView.getTag()).c, paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (MediaPreviewAdapter.ViewHolder)paramView.getTag();
    a(paramView.c);
    paramView.b.setImageDrawable(paramURLDrawable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MediaPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */