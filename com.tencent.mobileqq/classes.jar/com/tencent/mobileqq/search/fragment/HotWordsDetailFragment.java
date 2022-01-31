package com.tencent.mobileqq.search.fragment;

import ahxw;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.qphone.base.util.QLog;

public class HotWordsDetailFragment
  extends Fragment
{
  public static final String a;
  public QQAppInterface a;
  protected UniteSearchHandler a;
  protected UniteSearchObserver a;
  public HotWordSearchEntryModel a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HotWordsDetailFragment.class.toString();
  }
  
  public HotWordsDetailFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ahxw(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      paramLayoutInflater = getActivity().getAppRuntime();
      if ((paramLayoutInflater instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramLayoutInflater);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCreateView, app is null");
      }
      return new View(getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel = new HotWordSearchEntryModel(5);
    this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.a = false;
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.a();
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111));
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsDetailFragment
 * JD-Core Version:    0.7.0.1
 */