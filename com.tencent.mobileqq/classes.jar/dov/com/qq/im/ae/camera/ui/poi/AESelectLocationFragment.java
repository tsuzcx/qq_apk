package dov.com.qq.im.ae.camera.ui.poi;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

public class AESelectLocationFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AESelectionLocationAdapter jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter;
  private String jdField_a_of_type_JavaLangString;
  private View b;
  
  public static void a(Context paramContext, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramContext, new Intent(), PublicFragmentActivityForPeak.class, AESelectLocationFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377426));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363408);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131377611));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380291));
    this.b = paramView.findViewById(2131365494);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364790));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366335));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null)
    {
      AEQLog.a("AESelectLocationFragment", "mRecycleView is null ");
      return;
    }
    paramView = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter = new AESelectionLocationAdapter(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter);
    this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter.a(new AESelectLocationFragment.2(this));
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtil.g(getActivity()))
    {
      AEQLog.b("AESelectLocationFragment", "requestPoiList---no network");
      ThreadManager.getUIHandler().post(new AESelectLocationFragment.3(this));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AESelectLocationFragment.4(this, "qzone_address_select", false, paramString));
  }
  
  private void b(String paramString)
  {
    AEQLog.a("AESelectLocationFragment", "setSelectResult" + paramString);
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    if (paramString == null) {}
    for (Object localObject = "none";; localObject = paramString)
    {
      localAEBaseDataReporter.q((String)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_select_poi", paramString);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      return;
    }
  }
  
  void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
      b();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    AEQLog.a("AESelectLocationFragment", "onTextChanged :" + paramEditable);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramEditable);
    this.jdField_a_of_type_JavaLangString = paramEditable.toString();
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaLangString);
      return;
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  @TargetApi(23)
  public void b()
  {
    getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEBaseDataReporter.a().av();
      getActivity().finish();
      continue;
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      continue;
      b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558488, paramViewGroup, false);
    a(paramLayoutInflater);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new AESelectLocationFragment.1(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseDataReporter.a().au();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment
 * JD-Core Version:    0.7.0.1
 */