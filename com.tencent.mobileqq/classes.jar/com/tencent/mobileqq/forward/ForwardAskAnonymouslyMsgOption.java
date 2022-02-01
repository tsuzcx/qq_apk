package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil.Companion;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/forward/ForwardAskAnonymouslyMsgOption;", "Lcom/tencent/mobileqq/forward/ForwardArkMsgOption;", "i", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "showQzone", "", "getShowQzone", "()Z", "setShowQzone", "(Z)V", "allowQZoneAbility", "buildForwardAbility", "", "forwardOnConfirm", "handleQZoneClick", "preloadData", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ForwardAskAnonymouslyMsgOption
  extends ForwardArkMsgOption
{
  public static final ForwardAskAnonymouslyMsgOption.Companion a;
  private boolean j = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqForwardForwardAskAnonymouslyMsgOption$Companion = new ForwardAskAnonymouslyMsgOption.Companion(null);
  }
  
  public ForwardAskAnonymouslyMsgOption(@Nullable Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    super.a();
    String str = ForwardUtils.b(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    if (str == null) {}
    do
    {
      do
      {
        for (;;)
        {
          QLog.e("ForwardAskAnonymouslyMsgOption", 2, "forwardOnConfirm no friend or troop type");
          return;
          switch (str.hashCode())
          {
          }
        }
      } while (!str.equals("1"));
      ReportController.b(null, "dc00898", "", "", "0X800B46F", "0X800B46F", 0, 0, "", "", "", "");
      return;
    } while (!str.equals("2"));
    ReportController.b(null, "dc00898", "", "", "0X800B470", "0X800B470", 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    this.j = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", true);
    return bool;
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(ForwardAbility.ForwardAbilityType.d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(ForwardAbility.ForwardAbilityType.c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(ForwardAbility.ForwardAbilityType.b);
    }
    if (e()) {
      this.jdField_a_of_type_JavaUtilSet.add(ForwardAbility.ForwardAbilityType.e);
    }
  }
  
  protected boolean e()
  {
    return this.j;
  }
  
  public boolean f()
  {
    AskAnonymouslyUtil.Companion.shareInviteToQZone(this.jdField_a_of_type_AndroidAppActivity);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardAskAnonymouslyMsgOption
 * JD-Core Version:    0.7.0.1
 */