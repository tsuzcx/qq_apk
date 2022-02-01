package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore.Images.Thumbnails;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.wink.pick.URLDrawableHelper;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PicPreviewMoveAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ArrayList<String> a;
  private LayoutInflater b;
  private Context c;
  private int d = 35;
  private PicPreviewMoveAdapter.PicOperationListener e;
  private WinkCirclePhotoListLogic f;
  private HashMap<String, LocalMediaInfo> g;
  
  public PicPreviewMoveAdapter(@NonNull Context paramContext, WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    this.c = paramContext;
    this.f = paramWinkCirclePhotoListLogic;
    this.b = LayoutInflater.from(paramContext);
    paramContext = this.f;
    if ((paramContext != null) && (paramContext.d != null) && (this.f.d.selectedPhotoList != null)) {
      this.g = this.f.e().selectedMediaInfoHashMap;
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > ((ArrayList)localObject).size()) {
        return;
      }
      localObject = this.g;
      if (localObject != null)
      {
        localObject = (LocalMediaInfo)((HashMap)localObject).get(this.a.get(paramInt));
        if ((localObject != null) && (localObject != null)) {
          ((LocalMediaInfo)localObject).selectStatus = 2;
        }
        if (localObject != null) {
          this.g.remove(((LocalMediaInfo)localObject).path);
        }
      }
      this.a.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
      localObject = this.e;
      if (localObject != null) {
        ((PicPreviewMoveAdapter.PicOperationListener)localObject).a(paramInt);
      }
    }
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > localArrayList.size()) {
        return;
      }
      this.a.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt, "payload");
    }
  }
  
  public void a(PicPreviewMoveAdapter.PicOperationListener paramPicOperationListener)
  {
    this.e = paramPicOperationListener;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.a = paramArrayList;
    if (this.a == null) {
      this.a = new ArrayList();
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 101;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getItemViewType() == 101)
    {
      Object localObject = (String)this.a.get(paramInt);
      PicPreviewMoveAdapter.PicViewHolder localPicViewHolder = (PicPreviewMoveAdapter.PicViewHolder)paramViewHolder;
      localPicViewHolder.itemView.setVisibility(0);
      localPicViewHolder.a.setVisibility(8);
      localObject = this.g;
      if (localObject != null)
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((HashMap)localObject).get(this.a.get(paramInt));
        if (localLocalMediaInfo != null)
        {
          int i = QAlbumUtil.getMediaType(localLocalMediaInfo);
          if (i == 0)
          {
            localObject = MediaStore.Images.Thumbnails.getThumbnail(this.c.getContentResolver(), localLocalMediaInfo._id, 3, null);
            PicPreviewMoveAdapter.PicViewHolder.a(localPicViewHolder).setImageBitmap((Bitmap)localObject);
          }
          else if (i == 1)
          {
            if (localLocalMediaInfo.isSystemMeidaStore) {
              localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
            } else {
              localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
            }
            i = AlbumThumbDownloader.THUMB_WIDHT;
            localLocalMediaInfo.thumbHeight = i;
            localLocalMediaInfo.thumbWidth = i;
            localObject = URLDrawableHelper.a((URL)localObject);
            PicPreviewMoveAdapter.PicViewHolder.a(localPicViewHolder).setImageDrawable((Drawable)localObject);
            localObject = localPicViewHolder.a;
            if ((!localLocalMediaInfo.isSystemMeidaStore) && (localLocalMediaInfo.mDuration <= 0L))
            {
              ((TextView)localObject).setVisibility(8);
            }
            else
            {
              ((TextView)localObject).setVisibility(0);
              ((TextView)localObject).setText(QAlbumUtil.formatTimeToString(localLocalMediaInfo.mDuration));
            }
          }
        }
        else
        {
          AEQLog.d("QCirclePicPreviewMoveAdapter", "localMediaInfo == null");
        }
      }
      else
      {
        AEQLog.d("QCirclePicPreviewMoveAdapter", "mMediaInfoHashMap == null");
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramList.isEmpty()) {
      onBindViewHolder(paramViewHolder, paramInt);
    } else if (paramViewHolder.getItemViewType() == 101) {
      ((PicPreviewMoveAdapter.PicViewHolder)paramViewHolder).itemView.setVisibility(0);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, paramList, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 101) {
      return new PicPreviewMoveAdapter.PicViewHolder(this, this.b.inflate(2131629698, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PicPreviewMoveAdapter
 * JD-Core Version:    0.7.0.1
 */