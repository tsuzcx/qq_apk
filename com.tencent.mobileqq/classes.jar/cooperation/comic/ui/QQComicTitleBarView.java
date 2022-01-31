package cooperation.comic.ui;

import amrw;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

public class QQComicTitleBarView
  extends SwiftIphoneTitleBarUI
{
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  
  public QQComicTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
    paramSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getIntent();
    int j = paramSwiftBrowserUIStyleHandler.getIntExtra("key_subtab", 0);
    paramSwiftBrowserUIStyleHandler.removeExtra("key_subtab");
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Int != j) {
      f(j);
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.e = true;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("txtclr"))
      {
        bool = true;
        this.g = bool;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("titleclr")) {
          break label562;
        }
        bool = true;
        label113:
        this.h = bool;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("bgclr")) {
          break label568;
        }
        bool = true;
        label137:
        this.i = bool;
      }
    }
    else
    {
      if (this.i)
      {
        int j = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
        int k = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
        int m = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
        int n = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(m, j, n, k);
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.n = true;
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.o = true;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d == null) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.y();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(-4210753);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g = true;
          }
        }
      }
      if ((!this.i) || (!this.h) || (!this.g)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject, true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d & 0x20) != 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        a("", this.c.getResources().getString(2131434953), "", false, 0, 0, null, null);
        this.c.setOnClickListener(new amrw(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d & 0x40) != 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(9);
        localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 15.0F);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.b != -1) {
        break label584;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d & 1L) <= 0L) {
        break label574;
      }
      b(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.b.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.c.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
      }
      return;
      bool = false;
      break;
      label562:
      bool = false;
      break label113;
      label568:
      bool = false;
      break label137;
      label574:
      b(255);
      continue;
      label584:
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.b);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      if (this.g) {
        e(-1);
      }
      if (this.h) {
        d(-1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130846434, 2130846438, 2130846442);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131494327);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      }
    }
    do
    {
      return;
      if (this.g) {
        e(-16777216);
      }
      if (this.h) {
        d(-16777216);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130846453, 2130846457, 2130846461);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131494329);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTitleBarView
 * JD-Core Version:    0.7.0.1
 */