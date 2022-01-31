package cooperation.qqreader.ui;

import absf;
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
import bebk;
import bedf;
import beei;
import befb;
import bhow;
import bivx;
import bixj;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.List;
import zbj;

public class ReaderContentPageFragment
  extends ReaderBaseFragment
  implements Handler.Callback
{
  private bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    ReaderContentPageFragment localReaderContentPageFragment = new ReaderContentPageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localReaderContentPageFragment.setArguments(localBundle);
    return localReaderContentPageFragment;
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      if (!paramList.contains("menuItem:openWithQQBrowser")) {
        paramList.add("menuItem:openWithQQBrowser");
      }
      if (!paramList.contains("menuItem:openWithSafari")) {
        paramList.add("menuItem:openWithSafari");
      }
      if (!paramList.contains("menuItem:favorite")) {
        paramList.add("menuItem:favorite");
      }
      if (!paramList.contains("menuItem:screenLongShotShare")) {
        paramList.add("menuItem:screenLongShotShare");
      }
    } while (paramList.contains("menuItem:exposeArticle"));
    paramList.add("menuItem:exposeArticle");
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Bebk.c != null) {
      this.jdField_a_of_type_Bebk.c.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.invalidate();
    }
  }
  
  private void k()
  {
    zbj localzbj = b();
    localzbj.a(bixj.a(localzbj.a()));
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
        paramImageView.setImageResource(2130843439);
        continue;
        paramImageView.setImageResource(2130843438);
        continue;
        paramImageView.setImageResource(2130840101);
        continue;
        paramImageView.setImageResource(2130846424);
        continue;
        paramImageView.setImageResource(2130846434);
        continue;
        paramImageView.setImageResource(2130838647);
      }
      label193:
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, absf paramabsf)
  {
    if ((this.jdField_a_of_type_Bebk != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Bebk.c != null)) {
      a(this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bebk.c, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramOnClickListener);
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
      if ((paramBundle != null) && (this.jdField_a_of_type_Bebk.c != null)) {
        paramBundle.a(this.jdField_a_of_type_Bebk.c);
      }
    }
    return i;
  }
  
  public void c()
  {
    beei localbeei = (beei)this.jdField_a_of_type_Bedf.a(4);
    if (localbeei != null)
    {
      k();
      a(localbeei.a);
      localbeei.a(b(), this.jdField_a_of_type_Befb.a);
    }
  }
  
  public void e()
  {
    a(this.jdField_a_of_type_Bhow);
    super.e();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("theme");
      if (localBundle != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(localBundle.getInt("readerBgColor", -1));
      }
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
    if ((paramView == this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_Bebk.c))
    {
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
      }
      return;
    }
    if (paramView == this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView)
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
    this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageFragment
 * JD-Core Version:    0.7.0.1
 */