package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.List;

public class LangSettingFragment
  extends IphoneTitleBarFragment
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(2052), Integer.valueOf(1033) });
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
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
    return LocaleManager.a(i);
  }
  
  private void a()
  {
    int j = LocaleManager.a();
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getActivity());
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(String.format(getResources().getString(2131693611), new Object[] { a(paramInt, true) }));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(String.format(getResources().getString(2131693610), new Object[] { a(paramInt, true) }));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(getResources().getString(2131693609));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new LangSettingFragment.1(this, paramInt));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_AndroidAppDialog = CustomDialogFactory.a(getActivity(), 2131692671, 2131692669, 2131692668, 2131692670, new LangSettingFragment.2(this), new LangSettingFragment.3(this, paramInt));
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
    setTitle(getResources().getString(2131719080));
    ((ListView)this.mContentView.findViewById(2131370042)).setAdapter(new LangSettingFragment.LocaleListAdapter(this));
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramLayoutInflater != null) {
      ReportController.b(paramLayoutInflater, "dc00898", "", "", "0X800A611", "0X800A5A7", 0, 0, "", "", "", "");
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561607;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment
 * JD-Core Version:    0.7.0.1
 */