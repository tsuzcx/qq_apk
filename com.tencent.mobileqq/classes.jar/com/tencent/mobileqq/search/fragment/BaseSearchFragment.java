package com.tencent.mobileqq.search.fragment;

import ajjy;
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
import avkj;
import avli;
import avol;
import avuz;
import avva;
import avvn;
import avvo;
import awqx;
import azwg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.List;

public abstract class BaseSearchFragment<M extends avol>
  extends Fragment
  implements Handler.Callback, avva<M>
{
  private long a;
  public Handler a;
  protected View a;
  protected LinearLayout a;
  protected TextView a;
  public avkj a;
  public avuz a;
  public azwg a;
  protected QQAppInterface a;
  protected ListView a;
  protected View b;
  public TextView b;
  public boolean b;
  public View c;
  protected TextView c;
  public volatile String c;
  public List<M> c;
  public boolean c;
  protected int d;
  protected View d;
  public List<M> d;
  public volatile boolean d;
  protected boolean e;
  
  public BaseSearchFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected abstract avkj a();
  
  protected abstract avuz a();
  
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
      h_(false);
      if ((!TextUtils.isEmpty(paramString)) || (bool) || (this.jdField_a_of_type_Avkj == null)) {
        break label188;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      h_(false);
      i_(false);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Avuz.b();
      a();
      if (this.jdField_a_of_type_Avkj != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_Avkj;
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
        this.jdField_a_of_type_Avuz.a(new avvn(paramString, paramArrayOfByte, localBundle), this);
        return;
        this.jdField_a_of_type_Avuz.b();
        break;
        this.jdField_a_of_type_Avuz.c();
        break;
      }
      this.jdField_a_of_type_Avuz.a(new avvn(paramString, paramArrayOfByte), this);
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
  
  public void a(List<M> paramList, avvo paramavvo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with respData:", paramavvo.toString() });
    }
    if (paramavvo.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramavvo.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramavvo.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Avkj == null) || (this.jdField_a_of_type_Avkj.getCount() == 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void b(List<M> paramList)
  {
    c();
    this.jdField_a_of_type_Avkj.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (a()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      i_(false);
      return;
    }
  }
  
  protected void c(List<M> paramList)
  {
    c();
    this.jdField_a_of_type_Avkj.a(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_Avkj.getCount() <= 0) {
      if ((getActivity() instanceof PublicAcntSearchActivity)) {
        i_(false);
      }
    }
    for (;;)
    {
      VADHelper.a(getActivity());
      return;
      i_(true);
      continue;
      h_(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      if ((this.jdField_a_of_type_Avuz != null) && ((this.jdField_a_of_type_Avuz instanceof GroupSearchEngine))) {
        ((GroupSearchEngine)this.jdField_a_of_type_Avuz).a(paramBoolean);
      }
    }
  }
  
  protected void d(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.jdField_a_of_type_Avkj.getCount() <= 0)
    {
      c();
      i_(true);
    }
  }
  
  public void h_(boolean paramBoolean)
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
  
  protected void i_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305204)).setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      h_(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
    this.jdField_a_of_type_Avuz = a();
    if ((this.e) && (this.jdField_a_of_type_Avuz != null) && ((this.jdField_a_of_type_Avuz instanceof GroupSearchEngine))) {
      ((GroupSearchEngine)this.jdField_a_of_type_Avuz).a(true);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131495469, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup.findViewById(2131303596));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new avli(this));
    this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131301853);
    paramBundle = this.jdField_b_of_type_AndroidViewView;
    int i;
    if (a())
    {
      i = 0;
      paramBundle.setVisibility(i);
      ((TextView)paramViewGroup.findViewById(2131301817)).setText(a());
      this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131298447);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131305205));
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305207);
      if (!(paramLayoutInflater.getContext() instanceof ContactSearchActivity)) {
        break label351;
      }
      paramBundle.setText(ajjy.a(2131635261));
    }
    for (;;)
    {
      paramBundle = paramLayoutInflater.inflate(2131495260, null, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131300966));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635262));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131305197));
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramBundle = paramLayoutInflater.inflate(2131494566, null, false);
      this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131300966);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramLayoutInflater = paramLayoutInflater.inflate(2131495260, null, false);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131300966));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635267));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getActivity().getResources().getColor(2131101338));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramLayoutInflater);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      return paramViewGroup;
      i = 8;
      break;
      label351:
      if (((paramLayoutInflater.getContext() instanceof MessageSearchActivity)) || ((paramLayoutInflater.getContext() instanceof FTSEntitySearchActivity))) {
        paramBundle.setText(ajjy.a(2131635263));
      } else if ((paramLayoutInflater.getContext() instanceof FunctionSearchActivity)) {
        paramBundle.setText(a());
      } else if ((paramLayoutInflater.getContext() instanceof FileSearchActivity)) {
        paramBundle.setText(ajjy.a(2131635260));
      } else if ((paramLayoutInflater.getContext() instanceof FavoriteSearchActivity)) {
        paramBundle.setText(ajjy.a(2131635264));
      } else if ((paramLayoutInflater.getContext() instanceof PublicAcntSearchActivity)) {
        paramBundle.setText(ajjy.a(2131635265));
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
      if (this.jdField_a_of_type_Azwg != null) {
        this.jdField_a_of_type_Azwg.d();
      }
      awqx.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
    } while (!this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Avuz.e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_Azwg = new azwg(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Avkj = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Avkj);
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