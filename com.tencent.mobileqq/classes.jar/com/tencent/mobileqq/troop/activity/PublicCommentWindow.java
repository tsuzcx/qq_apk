package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.app.BaseActivity;
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
  protected BaseActivity a;
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
  
  public PublicCommentWindow(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
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
    paramActivity = LayoutInflater.from(paramActivity).inflate(2131560035, null);
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
    if (QLog.isColorLevel()) {
      QLog.d("PublicCommentPopupWindow", 2, "PublicCommentWindow show time = " + (System.currentTimeMillis() - l));
    }
  }
  
  /* Error */
  protected void a(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 201
    //   3: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: ldc 209
    //   11: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: putfield 211	com/tencent/mobileqq/troop/activity/PublicCommentWindow:c	Ljava/lang/String;
    //   17: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 178
    //   25: iconst_2
    //   26: new 180	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   33: ldc 213
    //   35: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: new 215	org/json/JSONObject
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: putfield 38	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 38	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   65: ldc 220
    //   67: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 40	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 38	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   78: ldc 225
    //   80: invokevirtual 229	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: putfield 42	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 38	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   91: ldc 231
    //   93: invokevirtual 229	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   96: putfield 44	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_b_of_type_Int	I
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 38	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   104: ldc 233
    //   106: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: putfield 46	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: aload_0
    //   113: new 235	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 236	java/util/ArrayList:<init>	()V
    //   120: putfield 58	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: aload_0
    //   124: getfield 38	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   127: ldc 238
    //   129: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 244	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 58	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: aload_1
    //   141: invokevirtual 247	android/net/Uri:getHost	()Ljava/lang/String;
    //   144: invokevirtual 251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload_0
    //   149: new 253	com/tencent/mobileqq/troop/activity/PublicCommentWindow$JsEventReceiver
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 256	com/tencent/mobileqq/troop/activity/PublicCommentWindow$JsEventReceiver:<init>	(Lcom/tencent/mobileqq/troop/activity/PublicCommentWindow;)V
    //   157: putfield 56	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver	Lcom/tencent/mobileqq/troop/activity/PublicCommentWindow$JsEventReceiver;
    //   160: new 258	android/content/IntentFilter
    //   163: dup
    //   164: ldc_w 260
    //   167: invokespecial 261	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   175: aload_0
    //   176: getfield 56	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver	Lcom/tencent/mobileqq/troop/activity/PublicCommentWindow$JsEventReceiver;
    //   179: aload_1
    //   180: invokevirtual 267	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   183: pop
    //   184: return
    //   185: astore_1
    //   186: aload_0
    //   187: invokevirtual 270	com/tencent/mobileqq/troop/activity/PublicCommentWindow:dismiss	()V
    //   190: return
    //   191: astore_1
    //   192: aload_0
    //   193: invokevirtual 270	com/tencent/mobileqq/troop/activity/PublicCommentWindow:dismiss	()V
    //   196: return
    //   197: astore_1
    //   198: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq -53 -> 148
    //   204: ldc 178
    //   206: iconst_2
    //   207: aload_1
    //   208: invokestatic 274	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   211: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: goto -66 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	PublicCommentWindow
    //   0	217	1	paramBundle	Bundle
    //   6	48	2	str	String
    // Exception table:
    //   from	to	target	type
    //   48	60	185	org/json/JSONException
    //   48	60	191	java/lang/NullPointerException
    //   123	148	197	java/lang/NullPointerException
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131377356));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366225));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131369141));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377769));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131370106));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramView.findViewById(2131379780).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if ((!android.text.TextUtils.isEmpty(paramString1)) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof SwiftWebViewFragmentSupporter)))
    {
      localObject = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).getCurrentWebViewFragment();
      if (localObject != null)
      {
        localObject = ((WebViewFragment)localObject).getWebView();
        if (localObject != null)
        {
          if (!paramBoolean) {
            break label92;
          }
          ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramString2 + "}}" });
        }
      }
    }
    return;
    label92:
    ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":-1}" });
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        EventApiPlugin.a("qbrowserCommentOnCreate", null, this.jdField_a_of_type_JavaUtilArrayList, null);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848264);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696227));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 8) || (this.jdField_b_of_type_Boolean));
    dismiss();
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityPublicCommentWindow$JsEventReceiver);
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
      continue;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
          InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848264);
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696227));
        }
        else
        {
          this.jdField_b_of_type_Boolean = true;
          InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicCommentWindow.1(this), 200L);
          continue;
          send();
        }
      }
    }
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send()
  {
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!android.text.TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i = str.length();; i = 0)
    {
      if (i == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131696245, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i < this.jdField_b_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696243, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i > this.jdField_a_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696244, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (!HttpUtil.isConnect(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694430, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      a(str);
      return;
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.send(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow
 * JD-Core Version:    0.7.0.1
 */