package dov.com.qq.im.ae.camera.ui.poi;

import aeow;
import aeox;
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
import bngp;
import bngq;
import bngr;
import bngt;
import bnqm;
import bnrh;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class AESelectLocationFragment
  extends PublicBaseFragment
  implements aeox, TextWatcher, View.OnClickListener
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bngt jdField_a_of_type_Bngt;
  private String jdField_a_of_type_JavaLangString;
  private View b;
  
  public static void a(Context paramContext, int paramInt)
  {
    aeow.a(paramContext, new Intent(), PublicFragmentActivityForPeak.class, AESelectLocationFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377016));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363329);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131377191));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379862));
    this.b = paramView.findViewById(2131365345);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364676));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366164));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null)
    {
      bnrh.a("AESelectLocationFragment", "mRecycleView is null ");
      return;
    }
    paramView = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Bngt = new bngt(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bngt);
    this.jdField_a_of_type_Bngt.a(new bngq(this));
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable(getActivity()))
    {
      bnrh.b("AESelectLocationFragment", "requestPoiList---no network");
      ThreadManager.getUIHandler().post(new AESelectLocationFragment.3(this));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    LbsManagerService.startLocation(new bngr(this, "qzone_address_select", false, paramString));
  }
  
  private void b(String paramString)
  {
    bnrh.a("AESelectLocationFragment", "setSelectResult" + paramString);
    bnqm localbnqm = bnqm.a();
    if (paramString == null) {}
    for (Object localObject = "none";; localObject = paramString)
    {
      localbnqm.n((String)localObject);
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
    bnrh.a("AESelectLocationFragment", "onTextChanged :" + paramEditable);
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
      bnqm.a().ax();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558487, paramViewGroup, false);
    a(paramLayoutInflater);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new bngp(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    bnqm.a().aw();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment
 * JD-Core Version:    0.7.0.1
 */