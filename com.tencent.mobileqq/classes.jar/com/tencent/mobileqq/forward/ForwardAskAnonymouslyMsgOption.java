package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/forward/ForwardAskAnonymouslyMsgOption;", "Lcom/tencent/mobileqq/forward/ForwardArkMsgOption;", "i", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "showQzone", "", "getShowQzone", "()Z", "setShowQzone", "(Z)V", "allowQZoneAbility", "buildForwardAbility", "", "forwardOnConfirm", "handleQZoneClick", "preloadData", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ForwardAskAnonymouslyMsgOption
  extends ForwardArkMsgOption
{
  public static final ForwardAskAnonymouslyMsgOption.Companion a = new ForwardAskAnonymouslyMsgOption.Companion(null);
  private boolean ad = true;
  
  public ForwardAskAnonymouslyMsgOption(@Nullable Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void b()
  {
    super.b();
    String str = SdkShareReporter.d(this.t.getInt("uintype"));
    if (str != null)
    {
      int i = str.hashCode();
      if (i != 49)
      {
        if ((i == 50) && (str.equals("2"))) {
          ReportController.b(null, "dc00898", "", "", "0X800B470", "0X800B470", 0, 0, "", "", "", "");
        }
      }
      else if (str.equals("1"))
      {
        ReportController.b(null, "dc00898", "", "", "0X800B46F", "0X800B46F", 0, 0, "", "", "", "");
        return;
      }
    }
    QLog.e("ForwardAskAnonymouslyMsgOption", 2, "forwardOnConfirm no friend or troop type");
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(ForwardAbility.ForwardAbilityType.e);
    }
    if (ah()) {
      this.C.add(ForwardAbility.ForwardAbilityType.d);
    }
    if (ai()) {
      this.C.add(ForwardAbility.ForwardAbilityType.c);
    }
    if (q()) {
      this.C.add(ForwardAbility.ForwardAbilityType.f);
    }
  }
  
  public boolean e()
  {
    boolean bool = super.e();
    this.ad = this.r.getBooleanExtra("k_qzone", true);
    return bool;
  }
  
  protected boolean q()
  {
    return this.ad;
  }
  
  public boolean r()
  {
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).shareInviteToQZone(this.s);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardAskAnonymouslyMsgOption
 * JD-Core Version:    0.7.0.1
 */