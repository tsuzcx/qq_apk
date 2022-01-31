package com.tencent.mobileqq.nearby.now.location;

import aefj;
import aefk;
import aefl;
import aefm;
import aefn;
import aefo;
import aefp;
import aefq;
import aefr;
import aefs;
import aeft;
import aefu;
import aefv;
import aefw;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.now.location.adapter.LocationListAdapter;
import com.tencent.mobileqq.nearby.now.location.adapter.SearchAdapter;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.widget.CommonLinearLayoutManager;
import com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView;
import com.tencent.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SelectLocationFragment
  extends PublicBaseFragment
  implements TextWatcher, LocationDataManager.UiUpdate
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new aefj(this);
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LocationDataManager jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager;
  private TLocationManager jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager;
  private LocationListAdapter jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter;
  private SearchAdapter jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter;
  private LocationInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  private CommonRecyclerView jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private LocationInfo jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  private View d;
  private View e;
  
  public SelectLocationFragment()
  {
    this.jdField_a_of_type_JavaLangRunnable = new aefp(this);
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    f();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365262));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aeft(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131365261));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new aefu(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aefv(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365263));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aefw(this));
    this.c = a(2131365260);
    this.c.setOnClickListener(new aefk(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131365264));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView = ((CommonRecyclerView)a(2131365265));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setLayoutManager(new CommonLinearLayoutManager(getActivity()));
    this.d = paramLayoutInflater.inflate(2130969128, this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView, false);
    this.e = a(2131365266);
    this.e.setOnClickListener(new aefl(this));
  }
  
  private void a(LocationInfo paramLocationInfo)
  {
    Intent localIntent = new Intent();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = paramLocationInfo;
    localIntent.putExtra("seleted", paramLocationInfo);
    paramLocationInfo = getActivity();
    if (paramLocationInfo != null)
    {
      paramLocationInfo.setResult(100, localIntent);
      paramLocationInfo.finish();
    }
  }
  
  private void a(List paramList)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter == null)
    {
      localObject2 = getActivity();
      if (paramList != null) {
        break label123;
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter = new SearchAdapter((Context)localObject2, 2130969129, (List)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter.a(new aefs(this));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setLayoutManager(new CommonLinearLayoutManager(getActivity()));
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter);
        if ((paramList == null) || (paramList.size() == 0))
        {
          LogUtil.d("SelectLocationFragment", "updateSearchList: emptyView");
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter.a();
          return;
          label123:
          localObject1 = paramList;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          LogUtil.e("SelectLocationFragment", "updateSearchList adapter can't set !");
        }
        LogUtil.d("SelectLocationFragment", "updateSearchList: setData");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (LocationInfo)localIterator.next();
          LogUtil.d("SelectLocationFragment", "updateSearchList: setData:" + ((LocationInfo)localObject2).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter.a = paramList;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSearchAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void c()
  {
    if (a() == null) {
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo == null) {
        this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = ((LocationInfo)a().getParcelableExtra("selected_location"));
      this.jdField_b_of_type_Int = a().getIntExtra("content_type", 1);
    } while (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo != null);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
  }
  
  private void d()
  {
    LogUtil.d("SelectLocationFragment", "getLocation: start");
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager.a(new aefq(this));
  }
  
  private void e()
  {
    LogUtil.d("SelectLocationFragment", "updateNearByList()");
    List localList = this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo, new LocationInfo(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo));
    LogUtil.d("SelectLocationFragment", "updateNearByList: size:" + localList.size());
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter = new LocationListAdapter(getActivity(), 2130969129, localList);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter.a(new aefr(this));
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.a() instanceof LocationListAdapter)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        LogUtil.e("SelectLocationFragment", "initList adapter can't set !");
        return;
      }
    }
    LogUtil.d("SelectLocationFragment", "updateNearByList: set new Adapter");
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setAdapter(null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter.b(localException1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterLocationListAdapter);
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      LogUtil.e("SelectLocationFragment", "initList adapter can't set !");
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131365256);
    a(2131365257).setOnClickListener(new aefm(this));
    a(2131365258).setOnClickListener(new aefn(this));
    a(2131365259).setOnClickListener(new aefo(this));
  }
  
  private void g()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.setResult(101);
      localFragmentActivity.finish();
    }
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = false;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    LogUtil.d("SelectLocationFragment", "resetSearchField()" + arrayOfStackTraceElement[(arrayOfStackTraceElement.length - 2)]);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.c.setVisibility(0);
    }
  }
  
  public Intent a()
  {
    if (getActivity() == null) {
      return null;
    }
    return getActivity().getIntent();
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public void a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.getVisibility() == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setVisibility(0);
      this.e.setVisibility(8);
    }
    LogUtil.d("SelectLocationFragment", "updateList: isSearch:" + paramBoolean1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (paramBoolean1)
    {
      a((List)localObject);
      return;
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    LogUtil.d("SelectLocationFragment", "networkError():" + paramBoolean);
    this.e.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.setVisibility(4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonRecyclerView.a();
    this.jdField_a_of_type_JavaLangString = paramEditable.toString().toLowerCase();
    LogUtil.d("SelectLocationFragment", "afterTextChanged: " + this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager.a("");
      LogUtil.d("SelectLocationFragment", "afterTextChanged: empty");
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 400L);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    LogUtil.d("SelectLocationFragment", "showSearchField()");
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(new ColorDrawable(-2044583390));
    this.c.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      h();
      return true;
    }
    return super.d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969125, null);
    c();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager = new LocationDataManager(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo, this, getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager = new TLocationManager(getActivity());
    a(paramLayoutInflater);
    d();
    new NowVideoReporter().h("video_public").i("exp_poi").d(SmallVideoCameraCaptureFragment.jdField_a_of_type_JavaLangString).a(this.jdField_b_of_type_Int).b(getActivity().app);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.SelectLocationFragment
 * JD-Core Version:    0.7.0.1
 */