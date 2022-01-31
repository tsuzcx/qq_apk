package com.tencent.mobileqq.qcall;

import SecurityAccountServer.RespondQueryQQBindingStat;
import agzz;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class QCallStartBrigeActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean;
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.finish();
      return;
      String str = paramIntent.getStringExtra("roomId");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("qqPhoneUserList");
      paramInt1 = paramIntent.getIntExtra("from", 6);
      this.app.a().a().put(Long.valueOf(str), "CREATE_FROM_CALL");
      ChatActivityUtils.a(this.app, getActivity(), 3000, str, true, true, true, null, localArrayList, 4, paramInt1);
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 10, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 7, 0, "", "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2130846525);
    int i = Resources.getSystem().getIdentifier("title_container", "id", "android");
    paramBundle = (ViewGroup)getWindow().findViewById(i);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = getLayoutInflater().inflate(2130968796, null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramBundle.setContentDescription("common_footerview_blank");
    addContentView(paramBundle, localLayoutParams);
    paramBundle.setClickable(true);
    paramBundle.setOnClickListener(new agzz(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      return;
    }
    Object localObject = getIntent();
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("param_from_type", 0);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      PhoneContactSelectActivity.a(this, true, 101);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    PstnSessionInfo localPstnSessionInfo = new PstnSessionInfo();
    localPstnSessionInfo.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uinType", 0);
    localPstnSessionInfo.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("toUin");
    localPstnSessionInfo.d = ((Intent)localObject).getStringExtra("nickName");
    localPstnSessionInfo.b = ((Intent)localObject).getStringExtra("peerPhone");
    localObject = ((PhoneContactManager)this.app.getManager(10)).a();
    if (localObject != null) {
      localPstnSessionInfo.c = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
    }
    ChatActivityUtils.a(this.app, this, localPstnSessionInfo, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallStartBrigeActivity
 * JD-Core Version:    0.7.0.1
 */