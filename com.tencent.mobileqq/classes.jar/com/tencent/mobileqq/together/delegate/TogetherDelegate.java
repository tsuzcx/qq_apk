package com.tencent.mobileqq.together.delegate;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Map;
import javax.annotation.Nullable;

public abstract interface TogetherDelegate
{
  public abstract String a();
  
  public abstract void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle);
  
  public abstract void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt);
  
  public abstract void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void a(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle);
  
  public abstract QQCustomDialog b();
  
  public abstract boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle);
  
  public abstract int c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.delegate.TogetherDelegate
 * JD-Core Version:    0.7.0.1
 */