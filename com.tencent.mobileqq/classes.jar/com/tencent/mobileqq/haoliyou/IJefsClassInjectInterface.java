package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mobileqq.bigbrother.DownloadListener;
import com.tencent.mobileqq.bigbrother.JumpListener;
import java.util.List;

public abstract interface IJefsClassInjectInterface
{
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DownloadListener paramDownloadListener);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<ResolveInfo> paramList, String paramString6, JumpListener paramJumpListener);
  
  public abstract void a(String paramString, Intent paramIntent);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.IJefsClassInjectInterface
 * JD-Core Version:    0.7.0.1
 */