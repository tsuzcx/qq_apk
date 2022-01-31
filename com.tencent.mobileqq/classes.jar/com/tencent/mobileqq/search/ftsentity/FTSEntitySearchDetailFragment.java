package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import awlq;
import awlr;
import awls;
import awlu;
import awlw;
import awlz;
import awut;
import awvh;
import baxk;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class FTSEntitySearchDetailFragment
  extends Fragment
  implements Handler.Callback, awut<awlu>
{
  private static List<FTSEntity> jdField_a_of_type_JavaUtilList;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awlq jdField_a_of_type_Awlq;
  awls jdField_a_of_type_Awls;
  private baxk jdField_a_of_type_Baxk;
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private List<FTSEntity> jdField_b_of_type_JavaUtilList;
  private List<awlu> c;
  
  public static FTSEntitySearchDetailFragment a(String paramString1, String paramString2, List<FTSEntity> paramList)
  {
    jdField_a_of_type_JavaUtilList = paramList;
    paramList = new FTSEntitySearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("original_keyword", paramString1);
    localBundle.putString("segment_keyword", paramString2);
    paramList.setArguments(localBundle);
    return paramList;
  }
  
  private void b(List<awlu> paramList)
  {
    this.jdField_a_of_type_Awlq.a(paramList);
  }
  
  public void a(List<awlu> paramList) {}
  
  public void a(List<awlu> paramList, int paramInt)
  {
    this.c = paramList;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-1);
  }
  
  public void a(List<awlu> paramList, awvh paramawvh)
  {
    if (paramawvh.a(this.jdField_a_of_type_JavaLangString)) {
      a(paramList, paramawvh.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramawvh.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_a_of_type_JavaLangString });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b(this.c);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
    jdField_a_of_type_JavaUtilList = null;
    paramBundle = getArguments();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("original_keyword");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("segment_keyword");
    this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity = ((FTSEntitySearchDetailActivity)getActivity());
    this.jdField_a_of_type_Awls = awlw.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559210, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367427));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131369266));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
    jdField_a_of_type_JavaUtilList = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      paramView = awlw.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.jdField_b_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app);
      this.jdField_a_of_type_Awlq = new awlr(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxk, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Awlq);
      this.jdField_a_of_type_Awls.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_Awlq.a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && (!awlz.a(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Awls.a();
        paramView = awlw.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, (FTSEntity)this.jdField_b_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_Awls.b(paramView, this);
      }
      return;
    }
    catch (NullPointerException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FTSEntitySearchDetailFragment", 2, "onViewCreated: ", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */