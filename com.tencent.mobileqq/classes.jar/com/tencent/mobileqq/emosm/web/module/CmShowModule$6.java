package com.tencent.mobileqq.emosm.web.module;

import amme;
import android.os.Bundle;
import anfi;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$6
  implements anfi
{
  CmShowModule$6(CmShowModule paramCmShowModule, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("apollo_apolloVipFlag", this.val$apolloVipFlag);
      localBundle.putInt("apollo_apolloVipLevel", this.val$apolloVipLevel);
      localBundle.putInt("apollo_result", 0);
      localBundle.putInt("apollo_partnerRoleId", this.val$partnerRoleId);
      localBundle.putString("apollo_json", this.val$json);
      localBundle.putInt("apollo_previewAction", this.val$activeId);
      localBundle.putBoolean("apollo_previewOnFrame", this.val$previewOnFrame);
      localBundle.putString("apollo_id", this.val$apolloId);
      localBundle.putString("title", this.val$title);
      localBundle.putString("subTitle", this.val$subTitle);
      localBundle.putBoolean("apollo_is_super_yellow", amme.c());
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.a(this.val$reqbundle);
      return;
    }
    localBundle.putInt("apollo_result", 1);
    localBundle.putInt("apollo_audioId", paramInt);
    localBundle.putString("apollo_json", this.val$json);
    this.val$reqbundle.putBundle("response", localBundle);
    this.val$service.a(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.6
 * JD-Core Version:    0.7.0.1
 */