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
import avlx;
import avly;
import avlz;
import avmb;
import avmd;
import avmg;
import avva;
import avvo;
import azwg;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class FTSEntitySearchDetailFragment
  extends Fragment
  implements Handler.Callback, avva<avmb>
{
  private static List<FTSEntity> jdField_a_of_type_JavaUtilList;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avlx jdField_a_of_type_Avlx;
  avlz jdField_a_of_type_Avlz;
  private azwg jdField_a_of_type_Azwg;
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private List<FTSEntity> jdField_b_of_type_JavaUtilList;
  private List<avmb> c;
  
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
  
  private void b(List<avmb> paramList)
  {
    this.jdField_a_of_type_Avlx.a(paramList);
  }
  
  public void a(List<avmb> paramList) {}
  
  public void a(List<avmb> paramList, int paramInt)
  {
    this.c = paramList;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-1);
  }
  
  public void a(List<avmb> paramList, avvo paramavvo)
  {
    if (paramavvo.a(this.jdField_a_of_type_JavaLangString)) {
      a(paramList, paramavvo.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramavvo.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_a_of_type_JavaLangString });
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
    this.jdField_a_of_type_Avlz = avmd.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131493641, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131301817));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131303596));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    jdField_a_of_type_JavaUtilList = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      paramView = avmd.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.jdField_b_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app);
      this.jdField_a_of_type_Avlx = new avly(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Azwg, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Avlx);
      this.jdField_a_of_type_Avlz.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_Avlx.a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && (!avmg.a(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Avlz.a();
        paramView = avmd.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, (FTSEntity)this.jdField_b_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_Avlz.b(paramView, this);
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