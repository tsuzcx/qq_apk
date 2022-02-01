package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import java.net.URL;

public class LocalMediaGridAdapter$VideoHolder
  extends LocalMediaGridAdapter.ImageHolder
{
  public TextView d = (TextView)getView(2131448418);
  public View e = getView(2131449074);
  
  public LocalMediaGridAdapter$VideoHolder(LocalMediaGridAdapter paramLocalMediaGridAdapter, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramLocalMediaGridAdapter, paramViewGroup, paramInt);
  }
  
  protected URL a(String paramString)
  {
    return AsyncImageView.a(paramString, this.a.getWidth(), this.a.getHeight(), false);
  }
  
  public void a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramInt, paramLocalMediaInfo);
    this.d.setText(ReadInJoyDisplayUtils.a((int)(paramLocalMediaInfo.j / 1000L)));
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter.VideoHolder
 * JD-Core Version:    0.7.0.1
 */