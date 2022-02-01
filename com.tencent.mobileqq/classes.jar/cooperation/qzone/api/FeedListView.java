package cooperation.qzone.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Map;

public class FeedListView
  extends XListView
{
  public static final String EXT_KEY_SEARCH_MODE = "search_mode";
  protected Map<String, String> extArgMap = Collections.emptyMap();
  private boolean isLongClickValid;
  
  public FeedListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FeedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FeedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void attach(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong) {}
  
  public void doActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public int getFeedCnt()
  {
    return 0;
  }
  
  public boolean isLongClickValid()
  {
    return this.isLongClickValid;
  }
  
  public void loadMore(FeedListView.LoadFeedCallback paramLoadFeedCallback) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void scrollToHeadView() {}
  
  public void scrollToTop() {}
  
  public void setExpandHead(FeedListView.ExpandHead paramExpandHead) {}
  
  public void setExtArgs(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      if (!this.extArgMap.isEmpty()) {
        this.extArgMap.clear();
      }
      return;
    }
    this.extArgMap = paramMap;
  }
  
  public void setFeedUinChangedListener(FeedListView.FeedUinChangedListener paramFeedUinChangedListener) {}
  
  public void setLongClickValid(boolean paramBoolean)
  {
    this.isLongClickValid = paramBoolean;
  }
  
  public boolean switchTag(String paramString, FeedListView.LoadFeedCallback paramLoadFeedCallback)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.FeedListView
 * JD-Core Version:    0.7.0.1
 */