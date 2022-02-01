package com.tencent.mobileqq.troop.widget;

import android.view.View;
import com.tencent.mobileqq.data.TroopFeedItem;

public abstract class TroopFeedViewFactory$ViewProvider
{
  public TroopFeedViewFactory$ViewProvider(TroopFeedViewFactory paramTroopFeedViewFactory) {}
  
  protected abstract View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean);
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    return a(null, paramTroopFeedItem, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider
 * JD-Core Version:    0.7.0.1
 */