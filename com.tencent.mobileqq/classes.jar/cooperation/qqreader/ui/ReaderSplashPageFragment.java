package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bizo;
import bjbl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class ReaderSplashPageFragment
  extends WebViewFragment
{
  private bizo a;
  
  private ViewGroup a(Context paramContext)
  {
    paramContext = new FrameLayout(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static ReaderSplashPageFragment a(Intent paramIntent)
  {
    ReaderSplashPageFragment localReaderSplashPageFragment = new ReaderSplashPageFragment();
    paramIntent.putExtra("url", "https://im.qq.com");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localReaderSplashPageFragment.setArguments(localBundle);
    return localReaderSplashPageFragment;
  }
  
  public void f()
  {
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bjbl.e("ReaderSplashPageFragment", "onCreate");
    paramBundle = getActivity();
    this.a = new bizo(paramBundle);
    Intent localIntent = a();
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      this.a.a(localIntent.getExtras());
      this.a.a(a(paramBundle));
      this.a.a();
      return;
    }
    paramBundle.finish();
    bjbl.a("ReaderSplashPageFragment", "onCreate: intent 数据为空，退出splash");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.a != null) {
      paramLayoutInflater = this.a.a();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    bjbl.e("ReaderSplashPageFragment", "onDestroy");
    if (this.a != null) {
      this.a.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderSplashPageFragment
 * JD-Core Version:    0.7.0.1
 */