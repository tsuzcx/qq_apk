package dov.com.qq.im.ae.biz.qcircle.adapter;

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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView;
import dov.com.qq.im.ae.biz.qcircle.widget.MultiTouchImageView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PhotoPreviewAdapter
  extends RecyclerView.Adapter<PhotoPreviewAdapter.PhotoPreviewVH>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  private AECirclePhotoListLogic jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic;
  public ArrayList<LocalMediaInfo> a;
  
  public PhotoPreviewAdapter(Context paramContext, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
  }
  
  private View a()
  {
    AECircleVideoPreviewItemView localAECircleVideoPreviewItemView = new AECircleVideoPreviewItemView(this.jdField_a_of_type_AndroidContentContext);
    localAECircleVideoPreviewItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localAECircleVideoPreviewItemView;
  }
  
  private URLDrawable.URLDrawableOptions a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = ImmersiveUtils.getScreenWidth();
    int j = (int)(i / paramLocalMediaInfo.mediaWidth * paramLocalMediaInfo.mediaHeight);
    paramLocalMediaInfo = URLDrawable.URLDrawableOptions.obtain();
    paramLocalMediaInfo.mRequestWidth = i;
    paramLocalMediaInfo.mRequestHeight = j;
    paramLocalMediaInfo.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramLocalMediaInfo.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    return paramLocalMediaInfo;
  }
  
  private URLDrawableDownListener a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawableDownListener == null) {
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = new PhotoPreviewAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  }
  
  private View b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558491, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  public PhotoPreviewAdapter.PhotoPreviewVH a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new PhotoPreviewAdapter.PhotoPreviewVH(b());
    }
    return new PhotoPreviewAdapter.PhotoPreviewVH(a());
  }
  
  public void a(int paramInt, PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH)
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramPhotoPreviewVH.jdField_a_of_type_DovComQqImAeBizQcircleWidgetMultiTouchImageView.setURLDrawableDownListener(a());
    paramPhotoPreviewVH.jdField_a_of_type_DovComQqImAeBizQcircleWidgetMultiTouchImageView.setImageDrawable(URLDrawable.getFileDrawable(localLocalMediaInfo.path, a(localLocalMediaInfo)));
  }
  
  public void a(PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramPhotoPreviewVH, paramInt, getItemId(paramInt));
      return;
      a(paramInt, paramPhotoPreviewVH);
      continue;
      b(paramInt, paramPhotoPreviewVH);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    ThreadManager.getUIHandler().post(new PhotoPreviewAdapter.2(this));
  }
  
  public void b(int paramInt, PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH)
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramPhotoPreviewVH.jdField_a_of_type_DovComQqImAeBizQcircleWidgetAECircleVideoPreviewItemView.a(localLocalMediaInfo);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */