package com.tencent.timi.game.api.live;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class BaseGameLiveAudienceView
  extends RelativeLayout
{
  protected BaseGameLiveAudienceView.LiveViewListener a;
  
  public BaseGameLiveAudienceView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseGameLiveAudienceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseGameLiveAudienceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a(long paramLong, @Nullable String paramString);
  
  public abstract void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(Context paramContext, long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo);
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void setActivityContext(Context paramContext) {}
  
  public void setLiveViewListener(BaseGameLiveAudienceView.LiveViewListener paramLiveViewListener)
  {
    this.a = paramLiveViewListener;
  }
  
  public abstract void setResumeIntent(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.live.BaseGameLiveAudienceView
 * JD-Core Version:    0.7.0.1
 */