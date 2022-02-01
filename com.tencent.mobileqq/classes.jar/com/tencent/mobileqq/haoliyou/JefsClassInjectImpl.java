package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.bigbrother.DownloadListener;
import com.tencent.mobileqq.bigbrother.JumpListener;
import com.tencent.mobileqq.download.unite.core.InstallMonitor;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardManager;
import java.util.List;

public class JefsClassInjectImpl
  implements IJefsClassInjectInterface
{
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DownloadListener paramDownloadListener)
  {
    CheckForwardManager.a(paramContext, paramString1, paramString2, paramString3, paramString4, paramDownloadListener);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<ResolveInfo> paramList, String paramString6, JumpListener paramJumpListener)
  {
    CheckForwardManager.a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramList, paramString6, paramJumpListener);
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    InstallMonitor.a().a(paramString, paramIntent);
  }
  
  public boolean a()
  {
    return PrivacyPolicyHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClassInjectImpl
 * JD-Core Version:    0.7.0.1
 */