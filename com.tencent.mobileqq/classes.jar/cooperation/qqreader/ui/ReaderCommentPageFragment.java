package cooperation.qqreader.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bgtw;
import bkvf;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;

public class ReaderCommentPageFragment
  extends ReaderBaseFragment
{
  private static String b = "";
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    ReaderCommentPageFragment localReaderCommentPageFragment = new ReaderCommentPageFragment();
    Bundle localBundle = new Bundle();
    paramIntent.putExtra("url", a(paramIntent));
    localBundle.putParcelable("intent", paramIntent);
    localReaderCommentPageFragment.setArguments(localBundle);
    return localReaderCommentPageFragment;
  }
  
  private static String a(int paramInt, String paramString, long paramLong)
  {
    String str1 = "";
    if (paramInt > 0) {
      str1 = "" + "&chapterId=" + paramInt;
    }
    String str2 = str1;
    if (!TextUtils.isEmpty(paramString)) {
      str2 = str1 + "&commentId=" + paramString;
    }
    return bkvf.a("qqreaderComment") + "&id=" + paramLong + str2;
  }
  
  private static String a(Intent paramIntent)
  {
    long l1 = 0L;
    boolean bool2 = false;
    String str = null;
    boolean bool1 = true;
    Bundle localBundle = paramIntent.getExtras();
    long l2;
    int i;
    if (localBundle != null)
    {
      l2 = localBundle.getLong("bookid");
      i = localBundle.getInt("chapterId", 0);
      paramIntent = localBundle.getString("commentId", "");
      bool2 = localBundle.getBoolean("night");
      bool1 = localBundle.getBoolean("comment");
      l1 = localBundle.getLong("recommend_bid");
    }
    for (;;)
    {
      str = bkvf.a("qqreaderReadover") + "&recommend_bid=" + l1;
      paramIntent = a(i, paramIntent, l2);
      if (bool2)
      {
        str = str + "&night=1";
        paramIntent = paramIntent + "&night=1";
      }
      for (;;)
      {
        return a(localBundle, bool1, str, paramIntent);
      }
      i = 0;
      l2 = 0L;
      paramIntent = str;
    }
  }
  
  private static String a(Bundle paramBundle, boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = 0;
    String str2 = null;
    if (paramBundle != null)
    {
      str2 = paramBundle.getString("from");
      i = paramBundle.getInt("CompleteState");
    }
    String str1 = "";
    if (!TextUtils.isEmpty(str2)) {
      str1 = "" + "&_from=" + str2;
    }
    paramBundle = str1;
    if (!TextUtils.isEmpty(str2))
    {
      paramBundle = str1;
      if (str2.equals("readover")) {
        if (i == 1) {
          break label164;
        }
      }
    }
    label164:
    for (paramBundle = str1 + "&noEnd=1";; paramBundle = str1 + "&noEnd=0")
    {
      paramString2 = paramString2 + paramBundle;
      paramBundle = paramString1 + paramBundle;
      b = paramBundle;
      if (!paramBoolean) {
        break;
      }
      return paramString2;
    }
    return paramBundle;
  }
  
  private void b()
  {
    if (b())
    {
      c();
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      getActivity().finish();
      return;
      getActivity().overridePendingTransition(0, 2130772255);
      continue;
      getActivity().overridePendingTransition(0, 2130772253);
    }
  }
  
  private boolean b()
  {
    String str;
    if ((this.webView != null) && (this.webView.canGoBack())) {
      str = this.webView.copyBackForwardList().getCurrentItem().getUrl();
    }
    return (!str.equals(b)) && (!str.contains("error.html"));
  }
  
  private void c()
  {
    if (this.webView != null)
    {
      this.webView.goBack();
      this.webView.invalidate();
    }
  }
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    super.initTitleBar(paramIntent, paramString);
    if ("readmenu".equals(this.jdField_a_of_type_JavaLangString))
    {
      this.mSwiftTitleUI.leftView.setVisibility(8);
      this.mSwiftTitleUI.rightViewText.setVisibility(0);
      this.mSwiftTitleUI.rightViewText.setText("关闭");
      this.mSwiftTitleUI.rightViewText.setTypeface(Typeface.DEFAULT_BOLD);
    }
    do
    {
      return;
      if (("readover".equals(this.jdField_a_of_type_JavaLangString)) || ("chaptercomment".equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.mSwiftTitleUI.leftView.setVisibility(0);
        this.mSwiftTitleUI.rightViewText.setText("");
        this.mSwiftTitleUI.rightViewText.setVisibility(8);
        return;
      }
    } while (!"chapterover".equals(this.jdField_a_of_type_JavaLangString));
    this.mSwiftTitleUI.leftView.setVisibility(0);
    this.mSwiftTitleUI.centerView.setText("章节评论");
    this.mSwiftTitleUI.rightViewText.setVisibility(0);
    this.mSwiftTitleUI.rightViewText.setText("书友交流");
    this.mSwiftTitleUI.rightViewText.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mSwiftTitleUI.leftView) {
      b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.mSwiftTitleUI.rightViewText)
      {
        if ("chapterover".equals(this.jdField_a_of_type_JavaLangString))
        {
          if (this.webView != null) {
            this.webView.loadUrl("jsbridge://JSTopRightButton/handleCommentPageRightButton/500/" + this.jdField_a_of_type_Long);
          }
        }
        else {
          b();
        }
      }
      else {
        super.onClick(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    paramBundle = this.intent.getExtras();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("style");
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("from");
      this.jdField_a_of_type_Long = paramBundle.getLong("bookid");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b = "";
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    if ("chapterover".equals(this.jdField_a_of_type_JavaLangString)) {
      this.mSwiftTitleUI.centerView.setText("章节评论");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderCommentPageFragment
 * JD-Core Version:    0.7.0.1
 */