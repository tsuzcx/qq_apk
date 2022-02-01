package com.tencent.mobileqq.search.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.searchengine.SearchRespData;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.List;

public abstract class BaseSearchFragment<M extends IModel>
  extends Fragment
  implements Handler.Callback, ISearchListener<M>
{
  private long a;
  protected Handler a;
  public View a;
  protected LinearLayout a;
  protected TextView a;
  protected QQAppInterface a;
  public IFaceDecoder a;
  protected BaseMvpAdapter a;
  public ISearchEngine a;
  protected ListView a;
  protected View b;
  protected TextView b;
  public boolean b;
  protected View c;
  protected TextView c;
  public volatile String c;
  public List<M> c;
  public boolean c;
  protected int d;
  protected View d;
  public List<M> d;
  public volatile boolean d;
  protected boolean e;
  public boolean f = false;
  
  public BaseSearchFragment()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_d_of_type_Int = 0;
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected abstract BaseMvpAdapter a();
  
  protected abstract ISearchEngine a();
  
  protected String a()
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(String paramString)
  {
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  protected void a(String paramString, int paramInt)
  {
    a(paramString, null, paramInt);
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "startSearch, key: " + paramString + getClass());
    }
    FragmentActivity localFragmentActivity = super.getActivity();
    boolean bool;
    if ((localFragmentActivity instanceof BaseSearchActivity))
    {
      bool = ((BaseSearchActivity)localFragmentActivity).jdField_b_of_type_Boolean;
      g_(false);
      if ((!TextUtils.isEmpty(paramString)) || (bool) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null)) {
        break label188;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      g_(false);
      h_(false);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter;
        this.jdField_c_of_type_JavaUtilList = null;
        paramArrayOfByte.a(null);
      }
      this.jdField_c_of_type_JavaLangString = paramString;
    }
    label188:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_c_of_type_JavaLangString = paramString;
      } while (this.jdField_a_of_type_ComTencentWidgetListView == null);
      switch (paramInt)
      {
      default: 
        a();
        b();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (!this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Int += 1;
    if ((localFragmentActivity instanceof BaseSearchActivity)) {}
    for (String str = ((BaseSearchActivity)localFragmentActivity).jdField_b_of_type_JavaLangString;; str = null)
    {
      if (str != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("search_restrict_mem", str);
        localBundle.putString("search_restrict_uin", ((BaseSearchActivity)localFragmentActivity).jdField_c_of_type_JavaLangString);
        localBundle.putBoolean("search_restrict_empty", bool);
        localBundle.putInt("search_restrict_uintype", ((BaseSearchActivity)localFragmentActivity).jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(new SearchRequest(paramString, paramArrayOfByte, localBundle), this);
        return;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
        break;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.c();
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(new SearchRequest(paramString, paramArrayOfByte), this);
      return;
    }
  }
  
  public void a(List<M> paramList)
  {
    this.jdField_c_of_type_JavaUtilList = paramList;
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long >= 300L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300L - (l - this.jdField_a_of_type_Long));
  }
  
  public void a(List<M> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    VADHelper.b("voice_search_als_cost");
    VADHelper.b("voice_search_all_cost");
    this.jdField_c_of_type_JavaUtilList = paramList;
    c(false);
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void a(List<M> paramList, SearchRespData paramSearchRespData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with respData:", paramSearchRespData.toString() });
    }
    if (paramSearchRespData.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void b(List<M> paramList)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  protected void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (a()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      h_(false);
      return;
    }
  }
  
  protected void c(List<M> paramList)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() <= 0) {
      if ((getActivity() instanceof PublicAcntSearchActivity)) {
        h_(false);
      }
    }
    for (;;)
    {
      VADHelper.a(getActivity());
      return;
      h_(true);
      continue;
      g_(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) && ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof GroupSearchEngine))) {
        ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).a(paramBoolean);
      }
    }
  }
  
  protected void d(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() <= 0)
    {
      c();
      h_(true);
    }
  }
  
  protected void g_(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  protected void h_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372337)).setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      g_(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      b(this.jdField_c_of_type_JavaUtilList);
      continue;
      c(this.jdField_c_of_type_JavaUtilList);
      continue;
      d(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)paramActivity).app;
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine = a();
    if ((this.e) && (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) && ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof GroupSearchEngine))) {
      ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).a(true);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561579, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup.findViewById(2131370452));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new BaseSearchFragment.1(this));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131368370);
    paramBundle = this.jdField_b_of_type_AndroidViewView;
    int i;
    if (a())
    {
      i = 0;
      paramBundle.setVisibility(i);
      ((TextView)paramViewGroup.findViewById(2131368336)).setText(a());
      this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131364522);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372338));
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372340);
      if (!(paramLayoutInflater.getContext() instanceof ContactSearchActivity)) {
        break label356;
      }
      paramBundle.setText(HardCodeUtil.a(2131701132));
    }
    for (;;)
    {
      paramBundle = paramLayoutInflater.inflate(2131561332, null, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131367337));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701133));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131372330));
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramBundle = paramLayoutInflater.inflate(2131560562, null, false);
      this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131367337);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramLayoutInflater = paramLayoutInflater.inflate(2131561332, null, false);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367337));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701138));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getActivity().getResources().getColor(2131167119));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramLayoutInflater);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
      i = 8;
      break;
      label356:
      if (((paramLayoutInflater.getContext() instanceof MessageSearchActivity)) || ((paramLayoutInflater.getContext() instanceof FTSEntitySearchActivity))) {
        paramBundle.setText(HardCodeUtil.a(2131701134));
      } else if ((paramLayoutInflater.getContext() instanceof FunctionSearchActivity)) {
        paramBundle.setText(a());
      } else if ((paramLayoutInflater.getContext() instanceof FileSearchActivity)) {
        paramBundle.setText(HardCodeUtil.a(2131701131));
      } else if ((paramLayoutInflater.getContext() instanceof FavoriteSearchActivity)) {
        paramBundle.setText(HardCodeUtil.a(2131701135));
      } else if ((paramLayoutInflater.getContext() instanceof PublicAcntSearchActivity)) {
        paramBundle.setText(HardCodeUtil.a(2131701136));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this instanceof GroupSearchFragment)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
    } while (!this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)super.getActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(super.getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
    c();
    if ((super.getActivity() instanceof BaseSearchActivity)) {}
    for (boolean bool = ((BaseSearchActivity)super.getActivity()).jdField_b_of_type_Boolean;; bool = false)
    {
      ThreadManager.postImmediately(new BaseSearchFragment.2(this, bool), null, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment
 * JD-Core Version:    0.7.0.1
 */