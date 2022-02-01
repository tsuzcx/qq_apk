package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import benl;
import benm;
import bftc;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ArithmeticCaptureTransferFragment
  extends AbsHomeWorkFragment
{
  private benl jdField_a_of_type_Benl;
  private String jdField_a_of_type_JavaLangString;
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString2);
    AbsHomeWorkFragment.a((Activity)paramContext, ArithmeticCaptureTransferFragment.class, localIntent, paramInt, paramString1);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public void a(@Nullable String paramString)
  {
    try
    {
      this.jdField_a_of_type_Benl = new benl(new JSONObject(paramString));
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
  
  public int getContentLayoutId()
  {
    return 2131560629;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        benm localbenm = new benm();
        localbenm.b = ((String)paramIntent.get(0));
        this.jdField_a_of_type_Benl.a(localbenm);
        if (QLog.isColorLevel()) {
          QLog.d("ArithmeticCaptureTransferFragment", 2, "new picture ,path = " + localbenm.b);
        }
        bftc.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Finish", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
      }
    }
    a(this.jdField_a_of_type_Benl.a(1));
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getArguments().getString("troop_uin", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithmeticCaptureTransferFragment
 * JD-Core Version:    0.7.0.1
 */