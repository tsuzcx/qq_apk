package dov.com.qq.im.ae.play;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;

public class VideoListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  public ImageView hover;
  public ImageView hover_selected;
  public TextView index;
  public TextView index_selected;
  public RoundCorneredFrameLayout internFrameLayout;
  public FrameLayout outFrameLayout;
  public ImageView thumb;
  
  public VideoListAdapter$ViewHolder(VideoListAdapter paramVideoListAdapter, View paramView)
  {
    super(paramView);
    this.outFrameLayout = ((FrameLayout)paramView.findViewById(2131380610));
    this.internFrameLayout = ((RoundCorneredFrameLayout)paramView.findViewById(2131368890));
    this.thumb = ((ImageView)paramView.findViewById(2131368941));
    this.thumb.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.hover = ((ImageView)paramView.findViewById(2131368216));
    this.index = ((TextView)paramView.findViewById(2131368944));
    this.hover_selected = ((ImageView)paramView.findViewById(2131368217));
    this.index_selected = ((TextView)paramView.findViewById(2131368945));
  }
  
  public void autoClick()
  {
    this.itemView.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.VideoListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */