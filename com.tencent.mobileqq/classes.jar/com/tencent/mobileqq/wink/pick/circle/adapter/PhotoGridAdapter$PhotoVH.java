package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class PhotoGridAdapter$PhotoVH
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public ImageView b;
  public ImageView c;
  public NumberCheckBox d;
  public URLDrawable e;
  public TextView f;
  public View g;
  public TextView h;
  public PhotoGridAdapter.PhotoItemClickListener i;
  
  public PhotoGridAdapter$PhotoVH(PhotoGridAdapter paramPhotoGridAdapter, View paramView)
  {
    super(paramView);
    this.a = ((ImageView)paramView.findViewById(2131440193));
    this.b = ((ImageView)paramView.findViewById(2131436068));
    this.g = paramView.findViewById(2131440195);
    this.d = ((NumberCheckBox)paramView.findViewById(2131440196));
    this.f = ((TextView)paramView.findViewById(2131440200));
    this.c = ((ImageView)paramView.findViewById(2131440118));
    paramPhotoGridAdapter = this.c;
    if (paramPhotoGridAdapter != null) {
      paramPhotoGridAdapter.setVisibility(8);
    }
    paramPhotoGridAdapter = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.PhotoVH
 * JD-Core Version:    0.7.0.1
 */