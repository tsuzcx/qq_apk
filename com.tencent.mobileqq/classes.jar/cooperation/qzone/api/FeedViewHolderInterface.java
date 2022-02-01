package cooperation.qzone.api;

import android.content.Intent;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.qzone.contentbox.model.MQMsg;

public abstract interface FeedViewHolderInterface
  extends AbsListView.OnScrollListener
{
  public static final int MSG_WHAT_FEED_UPDATE = 46;
  
  public abstract boolean addFeedViewToGroup(ViewGroup paramViewGroup, MQMsg paramMQMsg);
  
  public abstract void clearCache();
  
  public abstract void doActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void setHandler(Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.api.FeedViewHolderInterface
 * JD-Core Version:    0.7.0.1
 */