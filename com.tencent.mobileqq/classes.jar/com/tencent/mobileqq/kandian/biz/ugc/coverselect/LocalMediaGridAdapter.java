package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.pull2refresh.BaseAdapter;

public class LocalMediaGridAdapter
  extends BaseAdapter<AlbumUtils.LocalMediaInfo, LocalMediaGridAdapter.ImageHolder>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167360));
  private LocalMediaGridAdapter.OnItemListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter$OnItemListener;
  
  public LocalMediaGridAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocalMediaGridAdapter.ImageHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new LocalMediaGridAdapter.ImageHolder(this, paramViewGroup, 2131559984);
    }
    return new LocalMediaGridAdapter.VideoHolder(this, paramViewGroup, 2131559985);
  }
  
  public void a(int paramInt)
  {
    Object localObject = (AlbumUtils.LocalMediaInfo)getItem(paramInt);
    LocalMediaGridAdapter.OnItemListener localOnItemListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter$OnItemListener;
    int i;
    if ((localOnItemListener != null) && (!localOnItemListener.a(paramInt, (AlbumUtils.LocalMediaInfo)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = this.jdField_a_of_type_Int;
    if ((j != paramInt) && (i != 0))
    {
      this.jdField_a_of_type_Int = paramInt;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter$OnItemListener;
      if (localObject != null) {
        ((LocalMediaGridAdapter.OnItemListener)localObject).a((AlbumUtils.LocalMediaInfo)getItem(this.jdField_a_of_type_Int));
      }
      notifyItemChanged(j);
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(LocalMediaGridAdapter.ImageHolder paramImageHolder, int paramInt)
  {
    paramImageHolder.a(paramInt, (AlbumUtils.LocalMediaInfo)getItem(paramInt));
    paramImageHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter$OnItemListener;
    if (paramImageHolder != null) {
      paramImageHolder.a(paramInt);
    }
  }
  
  public void a(LocalMediaGridAdapter.OnItemListener paramOnItemListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter$OnItemListener = paramOnItemListener;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    AlbumUtils.LocalMediaInfo localLocalMediaInfo = (AlbumUtils.LocalMediaInfo)getItem(paramInt);
    if ((localLocalMediaInfo != null) && (localLocalMediaInfo.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter
 * JD-Core Version:    0.7.0.1
 */