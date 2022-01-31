package com.tencent.mobileqq.troop.activity;

import aizr;
import aizs;
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
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicCommentWindow
  extends Dialog
  implements View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected int a;
  protected long a;
  protected aizs a;
  protected Handler a;
  public Button a;
  protected EditText a;
  protected FrameLayout a;
  public ImageView a;
  public BaseActivity a;
  public SystemAndEmojiEmoticonPanel a;
  protected InputMethodRelativeLayout a;
  protected String a;
  protected ArrayList a;
  protected JSONObject a;
  public boolean a;
  protected int b;
  protected String b;
  public boolean b;
  public String c;
  
  public PublicCommentWindow(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity);
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    a(paramBundle);
  }
  
  public void a()
  {
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!android.text.TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i = str.length();; i = 0)
    {
      if (i == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131430334, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i < this.jdField_b_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430335, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (i > this.jdField_a_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430336, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (!HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131433117, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      a(str);
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2130969463, null);
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
    //   1: ldc 212
    //   3: invokevirtual 217	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: ldc 219
    //   11: invokevirtual 217	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: putfield 221	com/tencent/mobileqq/troop/activity/PublicCommentWindow:c	Ljava/lang/String;
    //   17: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 187
    //   25: iconst_2
    //   26: new 189	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   33: ldc 223
    //   35: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: new 225	org/json/JSONObject
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 227	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: putfield 229	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 229	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   65: ldc 231
    //   67: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 236	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 229	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   78: ldc 238
    //   80: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: putfield 101	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 229	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   91: ldc 244
    //   93: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   96: putfield 83	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_b_of_type_Int	I
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 229	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   104: ldc 246
    //   106: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: putfield 248	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: aload_0
    //   113: new 250	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 251	java/util/ArrayList:<init>	()V
    //   120: putfield 253	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: aload_0
    //   124: getfield 229	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   127: ldc 255
    //   129: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 261	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 253	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: aload_1
    //   141: invokevirtual 264	android/net/Uri:getHost	()Ljava/lang/String;
    //   144: invokevirtual 268	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload_0
    //   149: new 270	aizs
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 273	aizs:<init>	(Lcom/tencent/mobileqq/troop/activity/PublicCommentWindow;)V
    //   157: putfield 275	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Aizs	Laizs;
    //   160: new 277	android/content/IntentFilter
    //   163: dup
    //   164: ldc_w 279
    //   167: invokespecial 280	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 39	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   175: aload_0
    //   176: getfield 275	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Aizs	Laizs;
    //   179: aload_1
    //   180: invokevirtual 284	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   183: pop
    //   184: return
    //   185: astore_1
    //   186: aload_0
    //   187: invokevirtual 287	com/tencent/mobileqq/troop/activity/PublicCommentWindow:dismiss	()V
    //   190: return
    //   191: astore_1
    //   192: aload_0
    //   193: invokevirtual 287	com/tencent/mobileqq/troop/activity/PublicCommentWindow:dismiss	()V
    //   196: return
    //   197: astore_1
    //   198: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq -53 -> 148
    //   204: ldc 187
    //   206: iconst_2
    //   207: aload_1
    //   208: invokestatic 291	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   211: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131362845));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364100));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131363516));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365532));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366605));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramView.findViewById(2131366606).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
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
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if ((!android.text.TextUtils.isEmpty(paramString1)) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof SwiftWebViewFragmentSupporter)))
    {
      localObject = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).b();
      if (localObject != null)
      {
        localObject = ((WebViewFragment)localObject).a();
        if (localObject != null)
        {
          if (!paramBoolean) {
            break label92;
          }
          ((CustomWebView)localObject).a(paramString1, new String[] { "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramString2 + "}}" });
        }
      }
    }
    return;
    label92:
    ((CustomWebView)localObject).a(paramString1, new String[] { "{\"code\":-1}" });
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844609);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430344));
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
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  protected void d()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!android.text.TextUtils.isEmpty(str)) {
      TroopBarUtils.c.put(this.jdField_a_of_type_JavaLangString, str);
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Aizs != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_Aizs);
      this.jdField_a_of_type_Aizs = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    EventApiPlugin.a("qbrowserCommentOnClose", null, this.jdField_a_of_type_JavaUtilArrayList, null);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131366606: 
    case 2131364100: 
      do
      {
        return;
        dismiss();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844609);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430344));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aizr(this), 200L);
      return;
    }
    a();
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow
 * JD-Core Version:    0.7.0.1
 */