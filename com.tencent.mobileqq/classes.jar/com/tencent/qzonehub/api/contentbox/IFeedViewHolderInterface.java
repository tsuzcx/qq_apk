package com.tencent.qzonehub.api.contentbox;

import android.content.Intent;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.widget.AbsListView.OnScrollListener;

public abstract interface IFeedViewHolderInterface
  extends AbsListView.OnScrollListener
{
  public static final int MSG_WHAT_FEED_UPDATE = 46;
  
  public abstract boolean addFeedViewToGroup(ViewGroup paramViewGroup, IMQMsg paramIMQMsg);
  
  public abstract void clearCache();
  
  public abstract void doActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void setHandler(Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface
 * JD-Core Version:    0.7.0.1
 */