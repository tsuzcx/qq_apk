package cooperation.qqreader.ui;

import aabm;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bcbv;
import bfnk;
import bguh;
import bgvo;
import bgvv;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import cooperation.qqreader.QRBridgeUtil;
import xmt;

public class ReaderContentPageFragment
  extends ReaderBaseFragment
  implements Handler.Callback
{
  private bfnk jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
  private bgvv jdField_a_of_type_Bgvv;
  private String jdField_a_of_type_JavaLangString;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    ReaderContentPageFragment localReaderContentPageFragment = new ReaderContentPageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localReaderContentPageFragment.setArguments(localBundle);
    return localReaderContentPageFragment;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Bcbv.c != null) {
      this.jdField_a_of_type_Bcbv.c.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.invalidate();
    }
  }
  
  public xmt a()
  {
    return this.jdField_a_of_type_Bgvv.a();
  }
  
  public void a(ImageView paramImageView, TextView paramTextView, String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      paramTextView.setTypeface(Typeface.DEFAULT_BOLD);
      paramTextView.bringToFront();
      paramImageView.setImageResource(0);
      paramImageView.setBackgroundColor(0);
      paramImageView.setVisibility(8);
    }
    int i;
    if (paramString3 != null)
    {
      i = j;
      if (paramString3.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(paramString3);
      paramImageView.setBackgroundColor(i);
      if (paramString1 != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
        return;
      }
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramTextView)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void a(ImageView paramImageView, TextView paramTextView, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (paramInt == 0) {
      a(paramImageView, paramTextView, paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramImageView.setVisibility(8);
      }
      return;
      paramTextView.setVisibility(8);
      paramImageView.setVisibility(0);
      switch (paramInt)
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      default: 
        paramImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          paramImageView.setContentDescription(paramString2);
        }
        if (paramString1 == null) {
          break label193;
        }
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
        break;
        paramImageView.setImageResource(2130843254);
        continue;
        paramImageView.setImageResource(2130843253);
        continue;
        paramImageView.setImageResource(2130839753);
        continue;
        paramImageView.setImageResource(2130846039);
        continue;
        paramImageView.setImageResource(2130846049);
        continue;
        paramImageView.setImageResource(2130838576);
      }
      label193:
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, aabm paramaabm)
  {
    if ((this.jdField_a_of_type_Bcbv != null) && (this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Bcbv.c != null)) {
      a(this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bcbv.c, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramOnClickListener);
    }
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return false;
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    paramBundle = getActivity();
    if ((paramBundle instanceof ReaderBaseWebActivity))
    {
      paramBundle = ((ReaderBaseWebActivity)paramBundle).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      if ((paramBundle != null) && (this.jdField_a_of_type_Bcbv.c != null)) {
        paramBundle.a(this.jdField_a_of_type_Bcbv.c);
      }
    }
    return i;
  }
  
  public void c()
  {
    if (QRBridgeUtil.getAppInterface() == null)
    {
      bgvo.d("ReaderContentPageFragment", "QRBridgeUtil.mApp is null");
      Toast.makeText(getActivity(), "阅读插件加载中，请稍后重试！", 0).show();
      return;
    }
    this.jdField_a_of_type_Bgvv.a();
  }
  
  public void e()
  {
    a(this.jdField_a_of_type_Bfnk);
    super.e();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("theme");
      if (localBundle != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(localBundle.getInt("readerBgColor", -1));
      }
    }
    if (this.jdField_a_of_type_Bgvv == null) {
      this.jdField_a_of_type_Bgvv = new bgvv(getActivity(), getActivity(), QRBridgeUtil.getAppInterface());
    }
  }
  
  public void f() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()))
      {
        j();
        return;
      }
    } while (g());
    super.getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_Bcbv.c))
    {
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
      }
      return;
    }
    if (paramView == this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView)
    {
      i();
      return;
    }
    super.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bfnk.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Bgvv != null) {
      this.jdField_a_of_type_Bgvv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageFragment
 * JD-Core Version:    0.7.0.1
 */