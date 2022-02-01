package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PicPreviewMoveAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = 9;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AECirclePhotoListLogic jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic;
  private PicPreviewMoveAdapter.PicOperationListener jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter$PicOperationListener;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public PicPreviewMoveAdapter(@NonNull Context paramContext, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size()));
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList != null))
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if ((localLocalMediaInfo != null) && (localLocalMediaInfo != null)) {
          localLocalMediaInfo.selectStatus = 2;
        }
        this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.remove(localLocalMediaInfo.path);
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
    } while (this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter$PicOperationListener == null);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter$PicOperationListener.a(paramInt);
  }
  
  public ArrayList<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    return new ArrayList();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    notifyItemRemoved(paramInt);
    notifyItemRangeChanged(paramInt, getItemCount() - paramInt, "payload");
  }
  
  public void a(PicPreviewMoveAdapter.PicOperationListener paramPicOperationListener)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter$PicOperationListener = paramPicOperationListener;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 101;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1;
    PicPreviewMoveAdapter.PicViewHolder localPicViewHolder;
    Object localObject2;
    int i;
    if (paramViewHolder.getItemViewType() == 101)
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localPicViewHolder = (PicPreviewMoveAdapter.PicViewHolder)paramViewHolder;
      localPicViewHolder.itemView.setVisibility(0);
      localPicViewHolder.a.setVisibility(8);
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList != null))
      {
        localObject2 = (LocalMediaInfo)this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if (localObject2 != null)
        {
          i = QAlbumUtil.getMediaType((LocalMediaInfo)localObject2);
          if (i != 0) {
            break label176;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.a(47.0F);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.a(47.0F);
          localObject1 = URLDrawable.getFileDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          PicPreviewMoveAdapter.PicViewHolder.a(localPicViewHolder).setImageDrawable((Drawable)localObject1);
        }
      }
    }
    label278:
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label176:
      if (i == 1)
      {
        if (((LocalMediaInfo)localObject2).isSystemMeidaStore) {}
        for (localObject1 = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject2, "VIDEO");; localObject1 = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject2, "APP_VIDEO"))
        {
          i = AlbumThumbDownloader.THUMB_WIDHT;
          ((LocalMediaInfo)localObject2).thumbHeight = i;
          ((LocalMediaInfo)localObject2).thumbWidth = i;
          localObject1 = URLDrawableHelper.getDrawable((URL)localObject1);
          PicPreviewMoveAdapter.PicViewHolder.a(localPicViewHolder).setImageDrawable((Drawable)localObject1);
          localObject1 = localPicViewHolder.a;
          if ((((LocalMediaInfo)localObject2).isSystemMeidaStore) || (((LocalMediaInfo)localObject2).mDuration > 0L)) {
            break label278;
          }
          ((TextView)localObject1).setVisibility(8);
          break;
        }
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(AbstractPhotoListActivity.formatTimeToString(((LocalMediaInfo)localObject2).mDuration));
      }
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramList.isEmpty()) {
      onBindViewHolder(paramViewHolder, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, paramList, getItemId(paramInt));
      return;
      if (paramViewHolder.getItemViewType() == 101) {
        ((PicPreviewMoveAdapter.PicViewHolder)paramViewHolder).itemView.setVisibility(0);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 101) {
      return new PicPreviewMoveAdapter.PicViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558528, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PicPreviewMoveAdapter
 * JD-Core Version:    0.7.0.1
 */