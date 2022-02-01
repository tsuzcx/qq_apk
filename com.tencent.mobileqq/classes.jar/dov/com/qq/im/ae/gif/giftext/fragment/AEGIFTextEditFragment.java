package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.config.CameraPeakServiceHandler;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFTextColorAdapter;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import dov.com.qq.im.ae.gif.video.PngCreateResult.PngResultItem;
import dov.com.qq.im.ae.gif.video.PngsTextDrawer;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;

public class AEGIFTextEditFragment
  extends ReportFragment
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private AEStoryGIFPreviewActivity jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity;
  private AEGIFTextMvp jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp;
  private AEGIFTextColorAdapter jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter;
  private AEGIFTextEditFragment.TextValidCallback jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment$TextValidCallback;
  AEGIFTextEditViewModel jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.82F;
  private String jdField_c_of_type_JavaLangString = null;
  private float d = 0.16F;
  
  private int a(char paramChar)
  {
    if ((paramChar == '\n') || (paramChar == '\r')) {
      return 0;
    }
    if (paramChar < '') {
      return 1;
    }
    return 2;
  }
  
  public static AEGIFTextEditFragment a(String paramString1, boolean paramBoolean, View paramView, String paramString2)
  {
    paramString1 = a(paramString1, paramBoolean, paramString2);
    paramString1.a(paramView);
    return paramString1;
  }
  
  public static AEGIFTextEditFragment a(String paramString1, boolean paramBoolean, String paramString2)
  {
    AEGIFTextEditFragment localAEGIFTextEditFragment = new AEGIFTextEditFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString1);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("KEY_FONT_ID", paramString2);
    }
    localAEGIFTextEditFragment.setArguments(localBundle);
    return localAEGIFTextEditFragment;
  }
  
  private void a()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).toggleSoftInput(1, 2);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void a(AEGIFTextEditFragment.TextValidCallback paramTextValidCallback)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment$TextValidCallback = paramTextValidCallback;
  }
  
  private void a(String paramString1, String paramString2)
  {
    AEBaseReportParam.a().l(paramString1);
    AEBaseReportParam.a().m(paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramBoolean)
    {
      if (str.equals(""))
      {
        if (this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp != null) {
          this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp.d();
        }
        this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.a();
        a("none", this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a());
        getFragmentManager().popBackStack();
        return;
      }
      d();
      b(str);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h();
        Object localObject = (PngCreateResult.PngResultItem)this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.c().getValue();
        if ((localObject != null) && (((PngCreateResult.PngResultItem)localObject).jdField_a_of_type_JavaLangString != null)) {
          FileUtils.a(((PngCreateResult.PngResultItem)localObject).jdField_a_of_type_JavaLangString);
        }
        localObject = new PngsTextDrawer(this.jdField_c_of_type_JavaLangString);
        b();
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((PngsTextDrawer)localObject).a(str, 55, this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a(), this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.b(), DisplayUtil.a(getActivity(), 4.0F), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Float, this.d);
        ((PngsTextDrawer)localObject).a(new AEGIFTextEditFragment.3(this, str));
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.4(this));
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    e();
  }
  
  private void b()
  {
    if (((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372646) != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().indexOf('\n') > 0))
    {
      this.jdField_c_of_type_Float = 0.73F;
      this.d = 0.3F;
    }
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.a();
    CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.d);
    localAppInterface.addObserver(new AEGIFTextEditFragment.11(this, localAppInterface));
    localCameraPeakServiceHandler.c(paramString);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h();
        getFragmentManager().popBackStack();
        return;
      }
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.5(this));
      return;
    }
    e();
  }
  
  private void c()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 2131755842);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559329);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(HardCodeUtil.a(2131700061));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131700060), new AEGIFTextEditFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel = ((AEGIFTextEditViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity).get(AEGIFTextEditViewModel.class));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377180));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377275));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364175));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377422));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter = new AEGIFTextColorAdapter(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379151).setOnClickListener(new AEGIFTextEditFragment.7(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379152).setOnClickListener(new AEGIFTextEditFragment.8(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEGIFTextEditFragment.9(this));
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a();
    int i = this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a();
    String str3 = this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.b();
    if (this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp != null) {
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i));
    }
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.a(str1, i);
    a(str1, str2);
  }
  
  protected int a()
  {
    return 2131558617;
  }
  
  public void a(View paramView1, View paramView2, View paramView3)
  {
    paramView1.getViewTreeObserver().addOnGlobalLayoutListener(new AEGIFTextEditFragment.12(this, paramView1, paramView3, paramView2));
  }
  
  public void a(AEGIFTextMvp paramAEGIFTextMvp)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp = paramAEGIFTextMvp;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378272));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor(paramString));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
    if ((this.jdField_a_of_type_AndroidWidgetEditText.length() > 0) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new AEGIFTextEditFragment.LengthInputFilter(this) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new AEGIFTextEditFragment.13(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_JavaLangString = getArguments().getString("KEY_PNG_DIR_PATH");
    this.jdField_b_of_type_Boolean = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
    }
    this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity = ((AEStoryGIFPreviewActivity)getActivity());
    f();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    if (this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp.a();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp.a();
    }
    for (;;)
    {
      g();
      a(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFTextColorAdapter.a());
      a();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.b().getValue());
    }
  }
  
  public void onPause()
  {
    super.onPause();
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    if (this.jdField_b_of_type_Boolean) {}
    for (String str = "recommend";; str = "edit")
    {
      localAEBaseDataReporter.n(str);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new AEGIFTextEditFragment.1(this));
    a(new AEGIFTextEditFragment.2(this));
    a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.findViewById(2131377180), this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_b_of_type_AndroidWidgetRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment
 * JD-Core Version:    0.7.0.1
 */