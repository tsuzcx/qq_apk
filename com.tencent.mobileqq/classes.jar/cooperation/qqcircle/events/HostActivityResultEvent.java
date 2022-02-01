package cooperation.qqcircle.events;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class HostActivityResultEvent
  extends SimpleBaseEvent
{
  private final int mHostContextHashCode;
  private final Intent mIntent;
  private final int mRequestCode;
  private final int mResultCode;
  private final int mShadowTopContextHashCode;
  
  public HostActivityResultEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Intent paramIntent)
  {
    this.mHostContextHashCode = paramInt1;
    this.mShadowTopContextHashCode = paramInt2;
    this.mRequestCode = paramInt3;
    this.mResultCode = paramInt4;
    this.mIntent = paramIntent;
  }
  
  public int getHostContextHashCode()
  {
    return this.mHostContextHashCode;
  }
  
  public Intent getIntent()
  {
    return this.mIntent;
  }
  
  public int getRequestCode()
  {
    return this.mRequestCode;
  }
  
  public int getResultCode()
  {
    return this.mResultCode;
  }
  
  public int getShadowTopContextHashCode()
  {
    return this.mShadowTopContextHashCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.HostActivityResultEvent
 * JD-Core Version:    0.7.0.1
 */