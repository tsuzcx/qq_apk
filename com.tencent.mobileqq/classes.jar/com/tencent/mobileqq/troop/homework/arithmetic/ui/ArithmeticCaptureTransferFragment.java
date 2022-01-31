package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.fragment.ArithmeticCameraCaptureFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo.ArithmeticImageInfo;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ArithmeticCaptureTransferFragment
  extends AbsHomeWorkFragment
{
  private ArithmeticInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString2);
    AbsHomeWorkFragment.a((Activity)paramContext, ArithmeticCaptureTransferFragment.class, localIntent, paramInt, paramString1);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new Bundle();
    paramLayoutInflater.putString("troop_uin", this.jdField_a_of_type_JavaLangString);
    CameraCaptureActivity.a(getActivity(), ArithmeticCameraCaptureFragment.class.getName(), paramLayoutInflater, 10001);
    getActivity().overridePendingTransition(2131034327, 2131034167);
  }
  
  protected void a(@Nullable String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo = new ArithmeticInfo(new JSONObject(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("ArithmeticCaptureTransferFragment", 2, "init data ,homework = " + paramString);
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2130969910;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        ArithmeticInfo.ArithmeticImageInfo localArithmeticImageInfo = new ArithmeticInfo.ArithmeticImageInfo();
        localArithmeticImageInfo.b = ((String)paramIntent.get(0));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo.a(localArithmeticImageInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ArithmeticCaptureTransferFragment", 2, "new picture ,path = " + localArithmeticImageInfo.b);
        }
        TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Finish", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo.a(1));
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getArguments().getString("troop_uin", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithmeticCaptureTransferFragment
 * JD-Core Version:    0.7.0.1
 */