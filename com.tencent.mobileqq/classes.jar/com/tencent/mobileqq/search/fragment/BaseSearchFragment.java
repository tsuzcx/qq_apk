package com.tencent.mobileqq.search.fragment;

import ahxm;
import ahxn;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.List;

public abstract class BaseSearchFragment
  extends Fragment
  implements Handler.Callback, ISearchListener
{
  public int a;
  private long a;
  public Handler a;
  protected View a;
  protected LinearLayout a;
  public TextView a;
  public QQAppInterface a;
  public BaseMvpAdapter a;
  public ISearchEngine a;
  public FaceDecoder a;
  public ListView a;
  public boolean a;
  public View b;
  public TextView b;
  public volatile String b;
  public List b;
  public boolean b;
  public View c;
  protected TextView c;
  public List c;
  public volatile boolean c;
  public View d;
  protected boolean d;
  
  public BaseSearchFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  public int a()
  {
    return 0;
  }
  
  public abstract BaseMvpAdapter a();
  
  public abstract ISearchEngine a();
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(String paramString)
  {
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  public void a(String paramString, int paramInt)
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
      bool = ((BaseSearchActivity)localFragmentActivity).b;
      b(false);
      if ((!TextUtils.isEmpty(paramString)) || (bool) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null)) {
        break label188;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      b(false);
      c(false);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter;
        this.jdField_b_of_type_JavaUtilList = null;
        paramArrayOfByte.a(null);
      }
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    label188:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_b_of_type_JavaLangString = paramString;
      } while (this.jdField_a_of_type_ComTencentWidgetListView == null);
      switch (paramInt)
      {
      default: 
        a();
        b();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Int += 1;
    if ((localFragmentActivity instanceof BaseSearchActivity)) {}
    for (String str = ((BaseSearchActivity)localFragmentActivity).jdField_c_of_type_JavaLangString;; str = null)
    {
      if (str != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("search_restrict_mem", str);
        localBundle.putString("search_restrict_uin", ((BaseSearchActivity)localFragmentActivity).d);
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
  
  public void a(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
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
  
  public void a(List paramList, int paramInt)
  {
    VADHelper.b("voice_search_als_cost");
    VADHelper.b("voice_search_all_cost");
    this.jdField_b_of_type_JavaUtilList = paramList;
    d(false);
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void b(List paramList)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(boolean paramBoolean)
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
  
  protected boolean b()
  {
    return true;
  }
  
  public void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (b()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      c(false);
      return;
    }
  }
  
  protected void c(List paramList)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() <= 0) {
      if ((getActivity() instanceof PublicAcntSearchActivity)) {
        c(false);
      }
    }
    for (;;)
    {
      VADHelper.a(getActivity());
      return;
      c(true);
      continue;
      b(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371262)).setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      b(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  protected void d(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() <= 0)
    {
      c();
      c(true);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) && ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof GroupSearchEngine))) {
        ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).a(paramBoolean);
      }
    }
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
      b(this.jdField_b_of_type_JavaUtilList);
      continue;
      c(this.jdField_b_of_type_JavaUtilList);
      continue;
      d(this.jdField_b_of_type_JavaUtilList);
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
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) && ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof GroupSearchEngine))) {
      ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).a(true);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2130970608, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup.findViewById(2131364070));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ahxm(this));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131367721);
    paramBundle = this.jdField_b_of_type_AndroidViewView;
    int i;
    boolean bool;
    if (b())
    {
      i = 0;
      paramBundle.setVisibility(i);
      paramBundle = (TextView)paramViewGroup.findViewById(2131365002);
      paramBundle.setText(a());
      View localView = paramViewGroup.findViewById(2131366815);
      bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      if (!bool) {
        break label432;
      }
      paramBundle.setTextColor(Color.parseColor("#425E88"));
      localView.setBackgroundColor(Color.parseColor("#040E1C"));
      paramBundle.setBackgroundColor(getResources().getColor(2131492948));
      label150:
      this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131371259);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131371260));
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371263);
      if (!(paramLayoutInflater.getContext() instanceof ContactSearchActivity)) {
        break label449;
      }
      paramBundle.setText("联系人");
    }
    for (;;)
    {
      paramBundle = paramLayoutInflater.inflate(2130970430, null, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131365012));
      this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载…");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131370457));
      if (bool)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#717D86"));
        paramViewGroup.setBackgroundColor(Color.parseColor("#051020"));
      }
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramBundle = paramLayoutInflater.inflate(2130969715, null, false);
      this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131365012);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramLayoutInflater = paramLayoutInflater.inflate(2130970430, null, false);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365012));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("网络异常，请重试");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getActivity().getResources().getColor(2131494275));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramLayoutInflater);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      return paramViewGroup;
      i = 8;
      break;
      label432:
      paramBundle.setBackgroundColor(getResources().getColor(2131492969));
      break label150;
      label449:
      if (((paramLayoutInflater.getContext() instanceof MessageSearchActivity)) || ((paramLayoutInflater.getContext() instanceof FTSEntitySearchActivity))) {
        paramBundle.setText("聊天记录");
      } else if ((paramLayoutInflater.getContext() instanceof FunctionSearchActivity)) {
        paramBundle.setText(a());
      } else if ((paramLayoutInflater.getContext() instanceof FileSearchActivity)) {
        paramBundle.setText("文件");
      } else if ((paramLayoutInflater.getContext() instanceof FavoriteSearchActivity)) {
        paramBundle.setText("收藏");
      } else if ((paramLayoutInflater.getContext() instanceof PublicAcntSearchActivity)) {
        paramBundle.setText("公众号");
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
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_a_of_type_Int), "", this.jdField_b_of_type_JavaLangString, "");
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
    c();
    if ((super.getActivity() instanceof BaseSearchActivity)) {}
    for (boolean bool = ((BaseSearchActivity)super.getActivity()).b;; bool = false)
    {
      ThreadManager.postImmediately(new ahxn(this, bool), null, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment
 * JD-Core Version:    0.7.0.1
 */