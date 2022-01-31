package com.tencent.mobileqq.fragment;

import ajlo;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import apob;
import apoc;
import apod;
import apoe;
import awqx;
import azvu;
import begr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Arrays;
import java.util.List;

public class LangSettingFragment
  extends IphoneTitleBarFragment
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(2052), Integer.valueOf(1033) });
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private begr jdField_a_of_type_Begr;
  
  private String a(int paramInt, boolean paramBoolean)
  {
    int j = ((Integer)jdField_a_of_type_JavaUtilList.get(0)).intValue();
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < jdField_a_of_type_JavaUtilList.size()) {
        i = ((Integer)jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      }
    }
    return ajlo.a(i);
  }
  
  private void a()
  {
    int j = ajlo.a();
    if (j == 0) {
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < jdField_a_of_type_JavaUtilList.size())
      {
        if (((Integer)jdField_a_of_type_JavaUtilList.get(i)).intValue() == j)
        {
          this.jdField_a_of_type_Int = i;
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Begr == null) {
      this.jdField_a_of_type_Begr = begr.a(getActivity());
    }
    this.jdField_a_of_type_Begr.a(String.format(getResources().getString(2131628075), new Object[] { a(paramInt, true) }));
    this.jdField_a_of_type_Begr.c(String.format(getResources().getString(2131628074), new Object[] { a(paramInt, true) }));
    this.jdField_a_of_type_Begr.d(getResources().getString(2131628073));
    this.jdField_a_of_type_Begr.a(new apob(this, paramInt));
    this.jdField_a_of_type_Begr.show();
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_AndroidAppDialog = azvu.a(getActivity(), 2131627096, 2131627094, 2131627093, 2131627095, new apoc(this), new apod(this, paramInt));
    if ((!getActivity().isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog != null)) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void c(int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new LangSettingFragment.5(this, paramInt, new LangSettingFragment.4(this)));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    setTitle(getResources().getString(2131653490));
    ((ListView)this.mContentView.findViewById(2131303218)).setAdapter(new apoe(this));
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramLayoutInflater != null) {
      awqx.b(paramLayoutInflater, "dc00898", "", "", "0X800A611", "0X800A5A7", 0, 0, "", "", "", "");
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131495493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment
 * JD-Core Version:    0.7.0.1
 */