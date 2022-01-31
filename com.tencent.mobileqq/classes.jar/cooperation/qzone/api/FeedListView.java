package cooperation.qzone.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import bjhk;
import bjhl;
import bjhm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;

public class FeedListView
  extends XListView
{
  private boolean a;
  
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(bjhm parambjhm) {}
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong) {}
  
  public boolean a(String paramString, bjhm parambjhm)
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void f() {}
  
  public boolean f()
  {
    return this.a;
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void l() {}
  
  public void m() {}
  
  public void q_() {}
  
  public void setExpandHead(bjhk parambjhk) {}
  
  public void setFeedUinChangedListener(bjhl parambjhl) {}
  
  public void setLongClickValid(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.api.FeedListView
 * JD-Core Version:    0.7.0.1
 */