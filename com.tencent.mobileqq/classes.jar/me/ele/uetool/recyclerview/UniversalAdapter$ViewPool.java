package me.ele.uetool.recyclerview;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public final class UniversalAdapter$ViewPool
  extends RecyclerView.ViewHolder
{
  private final SparseArray<View> views = new SparseArray();
  
  public UniversalAdapter$ViewPool(View paramView)
  {
    super(paramView);
  }
  
  public <T extends View> T getView(@IdRes int paramInt)
  {
    if (paramInt == -1) {
      throw new RuntimeException("id is invalid");
    }
    View localView2 = (View)this.views.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.views.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public ViewPool setBackgroundColor(@IdRes int paramInt1, @ColorInt int paramInt2)
  {
    getView(paramInt1).setBackgroundColor(paramInt2);
    return this;
  }
  
  public ViewPool setCompoundDrawableLeft(@IdRes int paramInt1, @DrawableRes int paramInt2)
  {
    ((TextView)getView(paramInt1)).setCompoundDrawablesWithIntrinsicBounds(paramInt2, 0, 0, 0);
    return this;
  }
  
  public ViewPool setImageResource(@IdRes int paramInt1, @DrawableRes int paramInt2)
  {
    ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
    return this;
  }
  
  public ViewPool setText(@IdRes int paramInt, String paramString)
  {
    ((TextView)getView(paramInt)).setText(paramString);
    return this;
  }
  
  public ViewPool setTextColor(@IdRes int paramInt1, @ColorInt int paramInt2)
  {
    ((TextView)getView(paramInt1)).setTextColor(paramInt2);
    return this;
  }
  
  public ViewPool setTextGravity(@IdRes int paramInt1, int paramInt2)
  {
    ((TextView)getView(paramInt1)).setGravity(paramInt2);
    return this;
  }
  
  public ViewPool setVisibility(@IdRes int paramInt1, int paramInt2)
  {
    getView(paramInt1).setVisibility(paramInt2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.recyclerview.UniversalAdapter.ViewPool
 * JD-Core Version:    0.7.0.1
 */