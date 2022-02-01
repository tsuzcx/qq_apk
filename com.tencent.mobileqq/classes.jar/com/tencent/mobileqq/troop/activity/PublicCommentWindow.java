package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicCommentWindow
  extends ReportDialog
  implements View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected int a;
  protected long a;
  protected Handler a;
  protected Button a;
  protected EditText a;
  protected FrameLayout a;
  protected ImageView a;
  protected QBaseActivity a;
  protected SystemAndEmojiEmoticonPanel a;
  protected PublicCommentWindow.JsEventReceiver a;
  protected InputMethodRelativeLayout a;
  protected String a;
  protected ArrayList<String> a;
  protected JSONObject a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  
  public PublicCommentWindow(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    a(paramBundle);
  }
  
  protected void a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!android.text.TextUtils.isEmpty(str)) {
      TroopBarUtils.c.put(this.jdField_a_of_type_JavaLangString, str);
    }
  }
  
  public void a(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2131559907, null);
    setContentView(paramActivity);
    a(paramActivity);
    a();
    super.show();
    paramActivity = getWindow().getAttributes();
    paramActivity.x = 0;
    paramActivity.y = 0;
    paramActivity.width = -1;
    paramActivity.windowAnimations = 16973824;
    paramActivity.gravity = 83;
    paramActivity.softInputMode = 21;
    getWindow().setBackgroundDrawable(new ColorDrawable());
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("PublicCommentWindow show time = ");
      paramActivity.append(System.currentTimeMillis() - l);
      QLog.d("PublicCommentPopupWindow", 2, paramActivity.toString());
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("options");
    this.c = paramBundle.getString("onclose");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Comment option: ");
      paramBundle.append(str);
      QLog.d("PublicCommentPopupWindow", 2, paramBundle.toString());
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("draftID");
      this.jdField_a_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("maxContentLength");
      this.jdField_b_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("minContentLength");
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("contentPlaceholder");
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      try
      {
        paramBundle = Uri.parse(this.jdField_a_of_type_OrgJsonJSONObject.optString("referer"));
        this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle.getHost());
      }
      catch (NullPointerException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramBundle));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver = new PublicCommentWindow.JsEventReceiver(this);
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver, paramBundle);
      return;
    }
    catch (JSONException paramBundle)
    {
      break label216;
    }
    catch (NullPointerException paramBundle)
    {
      label211:
      label216:
      break label211;
    }
    dismiss();
    return;
    dismiss();
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131376809));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366114));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131368874));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377197));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131369784));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramView.findViewById(2131379111).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
  }
  
  protected void a(String paramString)
  {
    try
    {
      EventApiPlugin.a("qbrowserCommentOnSend", new JSONObject(TroopBarPublishUtils.a(paramString, null, null)), this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if ((localObject instanceof SwiftWebViewFragmentSupporter))
      {
        localObject = ((SwiftWebViewFragmentSupporter)localObject).getCurrentWebViewFragment();
        if (localObject != null)
        {
          localObject = ((WebViewFragment)localObject).getWebView();
          if (localObject != null)
          {
            if (paramBoolean)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("{\"code\":0,\"data\":{\"retcode\":0,\"result\":");
              localStringBuilder.append(paramString2);
              localStringBuilder.append("}}");
              ((CustomWebView)localObject).callJs(paramString1, new String[] { localStringBuilder.toString() });
              return;
            }
            ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":-1}" });
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    SystemAndEmojiEmoticonPanel localSystemAndEmojiEmoticonPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
    if (localSystemAndEmojiEmoticonPanel == null) {
      return;
    }
    if (paramBoolean)
    {
      EventApiPlugin.a("qbrowserCommentOnCreate", null, this.jdField_a_of_type_JavaUtilArrayList, null);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848134);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696246));
      return;
    }
    if ((localSystemAndEmojiEmoticonPanel.getVisibility() == 8) && (!this.jdField_b_of_type_Boolean)) {
      dismiss();
    }
  }
  
  protected boolean a()
  {
    String str = (String)TroopBarUtils.c.get(this.jdField_a_of_type_JavaLangString);
    TroopBarUtils.c.clear();
    if (!android.text.TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      return true;
    }
    return false;
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void dismiss()
  {
    PublicCommentWindow.JsEventReceiver localJsEventReceiver = this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver;
    if (localJsEventReceiver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.unregisterReceiver(localJsEventReceiver);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    EventApiPlugin.a("qbrowserCommentOnClose", null, this.jdField_a_of_type_JavaUtilArrayList, null);
    super.dismiss();
  }
  
  public void emoticonMall() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131366114)
    {
      if (i != 2131377197)
      {
        if (i == 2131379111) {
          dismiss();
        }
      }
      else {
        send();
      }
    }
    else if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848134);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696246));
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicCommentWindow.1(this), 200L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send()
  {
    Object localObject = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    int i;
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).trim();
      i = ((String)localObject).length();
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131696264, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      return;
    }
    int j = this.jdField_b_of_type_Int;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      QQToast.a((Context)localObject, ((QBaseActivity)localObject).getString(2131696262, new Object[] { Integer.valueOf(j) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      return;
    }
    j = this.jdField_a_of_type_Int;
    if (i > j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      QQToast.a((Context)localObject, ((QBaseActivity)localObject).getString(2131696263, new Object[] { Integer.valueOf(j) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      return;
    }
    if (!HttpUtil.isConnect(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694395, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      return;
    }
    a((String)localObject);
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.send(null, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow
 * JD-Core Version:    0.7.0.1
 */