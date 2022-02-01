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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRespData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FTSEntitySearchDetailFragment
  extends Fragment
  implements Handler.Callback, ISearchListener<FTSEntitySearchResultDetailModel>
{
  private static List<FTSEntity> jdField_a_of_type_JavaUtilList;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private BaseMvpFTSEntityAdapter jdField_a_of_type_ComTencentMobileqqSearchFtsentityBaseMvpFTSEntityAdapter;
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  FTSEntitySearchEngine jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchEngine;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private List<FTSEntity> jdField_b_of_type_JavaUtilList;
  private List<FTSEntitySearchResultDetailModel> c;
  
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
  
  private void b(List<FTSEntitySearchResultDetailModel> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityBaseMvpFTSEntityAdapter.a(paramList);
  }
  
  public void a(List<FTSEntitySearchResultDetailModel> paramList) {}
  
  public void a(List<FTSEntitySearchResultDetailModel> paramList, int paramInt)
  {
    this.c = paramList;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-1);
  }
  
  public void a(List<FTSEntitySearchResultDetailModel> paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.jdField_a_of_type_JavaLangString)) {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_a_of_type_JavaLangString });
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
    this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchEngine = FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559457, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368336));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370452));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    jdField_a_of_type_JavaUtilList = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      paramView = FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.jdField_b_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app);
      this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityBaseMvpFTSEntityAdapter = new FTSEntitySearchDetailFragment.1(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityBaseMvpFTSEntityAdapter);
      this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchEngine.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityBaseMvpFTSEntityAdapter.a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && (!FTSMessageSearchEngine.a(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchEngine.a();
        paramView = FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, (FTSEntity)this.jdField_b_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchEngine.b(paramView, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */