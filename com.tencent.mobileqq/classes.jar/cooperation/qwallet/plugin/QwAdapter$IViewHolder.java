package cooperation.qwallet.plugin;

import android.view.View;

public abstract interface QwAdapter$IViewHolder<V>
  extends Cloneable
{
  public abstract IViewHolder clone();
  
  public abstract View initView(int paramInt, View paramView);
  
  public abstract void setItemView(int paramInt, View paramView, V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.QwAdapter.IViewHolder
 * JD-Core Version:    0.7.0.1
 */