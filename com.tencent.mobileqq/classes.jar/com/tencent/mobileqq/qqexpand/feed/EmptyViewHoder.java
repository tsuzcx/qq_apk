package com.tencent.mobileqq.qqexpand.feed;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import java.io.File;

public class EmptyViewHoder
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  URLImageView a;
  TextView b;
  RelativeLayout c;
  RecyclerView d;
  private final int e;
  private final SquareItemClickListener f;
  private final int g;
  
  public EmptyViewHoder(View paramView, RecyclerView paramRecyclerView, int paramInt1, SquareItemClickListener paramSquareItemClickListener, int paramInt2)
  {
    super(paramView);
    this.d = paramRecyclerView;
    this.g = paramInt2;
    this.c = ((RelativeLayout)paramView);
    this.a = ((URLImageView)paramView.findViewById(2131435219));
    this.b = ((TextView)paramView.findViewById(2131447062));
    this.e = paramInt1;
    this.f = paramSquareItemClickListener;
    paramView.setOnTouchListener(this);
  }
  
  public void a(EmptyViewHoder paramEmptyViewHoder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    paramStrangerInfo = paramEmptyViewHoder.c.getLayoutParams();
    int i = this.d.getHeight();
    int j = this.e;
    paramStrangerInfo.height = (i - j);
    if ((paramStrangerInfo instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramStrangerInfo).topMargin = j;
    }
    paramStrangerInfo = URLDrawable.URLDrawableOptions.obtain();
    paramStrangerInfo.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramStrangerInfo.mFailedDrawable = URLDrawableHelperConstants.a;
    paramStrangerInfo = ExpandResourceUtil.a("expand_square_blank.png");
    if (new File(paramStrangerInfo).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramStrangerInfo = ExpandResourceUtil.a(paramStrangerInfo, localOptions);
      paramEmptyViewHoder.a.setImageDrawable(new BitmapDrawable(paramStrangerInfo));
    }
    if (paramInt == 1)
    {
      if (this.g == 0) {
        paramInt = 2131896781;
      } else {
        paramInt = 2131896777;
      }
    }
    else if (this.g == 0) {
      paramInt = 2131896780;
    } else {
      paramInt = 2131896776;
    }
    this.b.setText(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.f != null) && (paramMotionEvent.getAction() == 0)) {
      this.f.g();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.EmptyViewHoder
 * JD-Core Version:    0.7.0.1
 */