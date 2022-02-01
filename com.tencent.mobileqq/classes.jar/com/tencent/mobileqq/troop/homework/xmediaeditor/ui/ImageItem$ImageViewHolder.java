package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

public class ImageItem$ImageViewHolder
  extends EditorViewHolderManager.EditViewHolderBase<EditItemInfoBase>
{
  public URLDrawable a;
  public RoundCornerImageView b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public MessageProgressView g;
  public View h;
  
  public ImageItem$ImageViewHolder(View paramView)
  {
    super(paramView);
    this.h = paramView.findViewById(2131435094);
    this.b = ((RoundCornerImageView)paramView.findViewById(2131435096));
    RoundCornerImageView localRoundCornerImageView = this.b;
    localRoundCornerImageView.d = 1;
    localRoundCornerImageView.setCorner(10);
    this.d = ((ImageView)paramView.findViewById(2131435099));
    this.e = ((ImageView)paramView.findViewById(2131435097));
    this.c = ((ImageView)paramView.findViewById(2131435095));
    this.g = ((MessageProgressView)paramView.findViewById(2131435098));
    this.g.setRadius(10.0F, false);
    this.g.setShowCorner(false);
    this.g.setDisplayInTextView(ViewUtils.dpToPx(17.0F), -1);
    this.g.setAnimRunnableListener(new ImageItem.ImageViewHolder.1(this));
  }
  
  protected void a()
  {
    this.g.setVisibility(4);
    this.d.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder
 * JD-Core Version:    0.7.0.1
 */