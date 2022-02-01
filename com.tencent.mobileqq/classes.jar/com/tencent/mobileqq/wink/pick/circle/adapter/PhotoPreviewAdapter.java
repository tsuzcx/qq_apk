package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.mobileqq.wink.pick.circle.widget.MultiTouchImageView;
import com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PhotoPreviewAdapter
  extends RecyclerView.Adapter<PhotoPreviewAdapter.PhotoPreviewVH>
{
  public ArrayList<LocalMediaInfo> a = new ArrayList();
  public ColorDrawable b = new ColorDrawable(570425344);
  private final Context c;
  private WinkCirclePhotoListLogic d;
  private URLDrawableDownListener e;
  
  public PhotoPreviewAdapter(Context paramContext, WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    this.c = paramContext;
    this.d = paramWinkCirclePhotoListLogic;
  }
  
  private View a()
  {
    WinkCircleVideoPreviewItemView localWinkCircleVideoPreviewItemView = new WinkCircleVideoPreviewItemView(this.c);
    localWinkCircleVideoPreviewItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localWinkCircleVideoPreviewItemView;
  }
  
  private View b()
  {
    View localView = LayoutInflater.from(this.c).inflate(2131629686, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  private URLDrawable.URLDrawableOptions c()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = this.b;
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    return localURLDrawableOptions;
  }
  
  private URLDrawableDownListener d()
  {
    if (this.e == null) {
      this.e = new PhotoPreviewAdapter.1(this);
    }
    return this.e;
  }
  
  public PhotoPreviewAdapter.PhotoPreviewVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return new PhotoPreviewAdapter.PhotoPreviewVH(a());
    }
    return new PhotoPreviewAdapter.PhotoPreviewVH(b());
  }
  
  public void a(int paramInt, PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH)
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.a.get(paramInt);
    paramPhotoPreviewVH.a.setURLDrawableDownListener(d());
    paramPhotoPreviewVH.a.setImageDrawable(URLDrawable.getFileDrawable(localLocalMediaInfo.path, c()));
  }
  
  public void a(PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH, int paramInt)
  {
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i == 1) {
        b(paramInt, paramPhotoPreviewVH);
      }
    }
    else {
      a(paramInt, paramPhotoPreviewVH);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramPhotoPreviewVH, paramInt, getItemId(paramInt));
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.a.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.a.addAll(paramList);
      ThreadManager.getUIHandler().post(new PhotoPreviewAdapter.2(this));
    }
  }
  
  public void b(int paramInt, PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH)
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.a.get(paramInt);
    paramPhotoPreviewVH.b.a(localLocalMediaInfo);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.a.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */