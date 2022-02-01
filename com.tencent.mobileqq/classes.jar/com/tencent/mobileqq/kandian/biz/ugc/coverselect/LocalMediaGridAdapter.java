package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.pull2refresh.BaseAdapter;

public class LocalMediaGridAdapter
  extends BaseAdapter<AlbumUtils.LocalMediaInfo, LocalMediaGridAdapter.ImageHolder>
{
  private LocalMediaGridAdapter.OnItemListener a;
  private int b = -1;
  private ColorDrawable c = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131168413));
  
  public LocalMediaGridAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public LocalMediaGridAdapter.ImageHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new LocalMediaGridAdapter.ImageHolder(this, paramViewGroup, 2131626027);
    }
    return new LocalMediaGridAdapter.VideoHolder(this, paramViewGroup, 2131626028);
  }
  
  public void a(int paramInt)
  {
    Object localObject = (AlbumUtils.LocalMediaInfo)getItem(paramInt);
    LocalMediaGridAdapter.OnItemListener localOnItemListener = this.a;
    int i;
    if ((localOnItemListener != null) && (!localOnItemListener.a(paramInt, (AlbumUtils.LocalMediaInfo)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = this.b;
    if ((j != paramInt) && (i != 0))
    {
      this.b = paramInt;
      localObject = this.a;
      if (localObject != null) {
        ((LocalMediaGridAdapter.OnItemListener)localObject).a((AlbumUtils.LocalMediaInfo)getItem(this.b));
      }
      notifyItemChanged(j);
      notifyItemChanged(this.b);
    }
  }
  
  public void a(LocalMediaGridAdapter.ImageHolder paramImageHolder, int paramInt)
  {
    paramImageHolder.a(paramInt, (AlbumUtils.LocalMediaInfo)getItem(paramInt));
    paramImageHolder = this.a;
    if (paramImageHolder != null) {
      paramImageHolder.a(paramInt);
    }
  }
  
  public void a(LocalMediaGridAdapter.OnItemListener paramOnItemListener)
  {
    this.a = paramOnItemListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter
 * JD-Core Version:    0.7.0.1
 */