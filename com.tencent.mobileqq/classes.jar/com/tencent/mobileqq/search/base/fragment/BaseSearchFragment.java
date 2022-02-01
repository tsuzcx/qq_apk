package com.tencent.mobileqq.search.base.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchGroupEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class BaseSearchFragment<M extends IModel>
  extends QBaseFragment
  implements Handler.Callback, ISearchListener<M>
{
  private long a;
  protected Handler a;
  protected View a;
  protected LinearLayout a;
  protected TextView a;
  protected AppInterface a;
  protected IFaceDecoder a;
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
  protected volatile boolean d;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSearch, key: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(getClass());
      QLog.d("GroupSearchFragment", 2, ((StringBuilder)localObject).toString());
    }
    QBaseActivity localQBaseActivity = super.getQBaseActivity();
    boolean bool2 = localQBaseActivity instanceof BaseSearchActivity;
    boolean bool1;
    if (bool2) {
      bool1 = ((BaseSearchActivity)localQBaseActivity).jdField_b_of_type_Boolean;
    } else {
      bool1 = false;
    }
    c_(false);
    boolean bool3 = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if ((bool3) && (!bool1) && (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      c_(false);
      j_(false);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.b();
      a();
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter;
      if (paramArrayOfByte != null)
      {
        this.jdField_c_of_type_JavaUtilList = null;
        paramArrayOfByte.a(null);
      }
      this.jdField_c_of_type_JavaLangString = paramString;
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.c();
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.b();
    }
    a();
    b();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Int += 1;
      if (bool2) {
        localObject = ((BaseSearchActivity)localQBaseActivity).jdField_b_of_type_JavaLangString;
      }
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("search_restrict_mem", (String)localObject);
        localObject = (BaseSearchActivity)localQBaseActivity;
        localBundle.putString("search_restrict_uin", ((BaseSearchActivity)localObject).jdField_c_of_type_JavaLangString);
        localBundle.putBoolean("search_restrict_empty", bool1);
        localBundle.putInt("search_restrict_uintype", ((BaseSearchActivity)localObject).jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.a(new SearchRequest(paramString, paramArrayOfByte, localBundle), this);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.a(new SearchRequest(paramString, paramArrayOfByte), this);
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
    if (paramSearchRespData.a(this.jdField_c_of_type_JavaLangString))
    {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected String b()
  {
    return null;
  }
  
  protected void b()
  {
    BaseMvpAdapter localBaseMvpAdapter = this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter;
    if ((localBaseMvpAdapter == null) || (localBaseMvpAdapter.getCount() == 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void b(List<M> paramList)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  protected void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    int i;
    if (a()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    j_(false);
  }
  
  protected void c(List<M> paramList)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.getCount() <= 0) {
      j_(c());
    } else {
      c_(true);
    }
    VADHelper.a(getQBaseActivity());
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      ISearchEngine localISearchEngine = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine;
      if ((localISearchEngine != null) && ((localISearchEngine instanceof ISearchGroupEngine))) {
        ((ISearchGroupEngine)localISearchEngine).a(paramBoolean);
      }
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void c_(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  protected void d(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.getCount() <= 0)
    {
      c();
      j_(true);
    }
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4) {
          return true;
        }
        c(this.jdField_c_of_type_JavaUtilList);
        return true;
      }
      d(this.jdField_c_of_type_JavaUtilList);
      return true;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    b(this.jdField_c_of_type_JavaUtilList);
    return true;
  }
  
  protected void j_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371922)).setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      c_(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof QBaseActivity))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)((QBaseActivity)paramActivity).getAppRuntime());
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine = a();
    if (this.e)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine;
      if ((paramBundle != null) && ((paramBundle instanceof ISearchGroupEngine))) {
        ((ISearchGroupEngine)paramBundle).a(true);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561420, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup.findViewById(2131370110));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new BaseSearchFragment.1(this));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131368121);
    paramBundle = this.jdField_b_of_type_AndroidViewView;
    int i;
    if (a()) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    ((TextView)paramViewGroup.findViewById(2131368087)).setText(a());
    this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131364410);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131371923));
    paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371925);
    String str = b();
    if (!TextUtils.isEmpty(str)) {
      paramBundle.setText(str);
    }
    paramBundle = paramLayoutInflater.inflate(2131561171, null, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131367119));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701274));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131371915));
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
    paramBundle = paramLayoutInflater.inflate(2131560451, null, false);
    this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131367119);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561171, null, false);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367119));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701279));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getActivity().getResources().getColor(2131167144));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramLayoutInflater);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (d()) {
      return;
    }
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.e();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)getQBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter);
    c();
    boolean bool;
    if ((super.getQBaseActivity() instanceof BaseSearchActivity)) {
      bool = ((BaseSearchActivity)super.getQBaseActivity()).jdField_b_of_type_Boolean;
    } else {
      bool = false;
    }
    ThreadManager.postImmediately(new BaseSearchFragment.2(this, bool), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
 * JD-Core Version:    0.7.0.1
 */