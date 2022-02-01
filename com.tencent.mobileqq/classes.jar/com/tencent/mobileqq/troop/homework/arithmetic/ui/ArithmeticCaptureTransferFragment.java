package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import bfej;
import bfek;
import bgjt;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class ArithmeticCaptureTransferFragment
  extends AbsHomeWorkFragment
{
  private bfej jdField_a_of_type_Bfej;
  private String jdField_a_of_type_JavaLangString;
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString2);
    AbsHomeWorkFragment.a((Activity)paramContext, ArithmeticCaptureTransferFragment.class, localIntent, paramInt, paramString1);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new Bundle();
    paramLayoutInflater.putString("troop_uin", this.jdField_a_of_type_JavaLangString);
    paramLayoutInflater.putBoolean("enable_local_video", false);
    paramLayoutInflater.putInt("edit_video_type", 10019);
    paramLayoutInflater.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    QIMCameraCaptureActivity.a(getActivity(), paramLayoutInflater, 10001);
    getActivity().overridePendingTransition(2130772242, 2130772039);
  }
  
  public void a(@Nullable String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bfej = new bfej(new JSONObject(paramString));
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
    return 2131560604;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        bfek localbfek = new bfek();
        localbfek.b = ((String)paramIntent.get(0));
        this.jdField_a_of_type_Bfej.a(localbfek);
        if (QLog.isColorLevel()) {
          QLog.d("ArithmeticCaptureTransferFragment", 2, "new picture ,path = " + localbfek.b);
        }
        bgjt.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Finish", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
      }
    }
    a(this.jdField_a_of_type_Bfej.a(1));
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