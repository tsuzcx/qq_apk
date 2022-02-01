package com.tencent.mobileqq.vashealth;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class HealthReplyCommentActivity
  extends QIphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  public static Editable.Factory a;
  public static final HashMap<String, HealthReplyCommentActivity.PublishDataCacheEntity> a;
  protected int a;
  protected long a;
  protected ViewGroup a;
  protected Button a;
  protected EditText a;
  protected FrameLayout a;
  protected ImageButton a;
  protected InputMethodRelativeLayout a;
  protected Boolean a;
  protected String a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected String e = null;
  protected String f = "";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_AndroidTextEditable$Factory = new HealthReplyCommentActivity.3();
  }
  
  public HealthReplyCommentActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static IEmoticonMainPanel a(QBaseActivity paramQBaseActivity, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    paramEditText = ((IEmoticonMainPanelService)paramQBaseActivity.getAppRuntime().getRuntimeService(IEmoticonMainPanelService.class, "tool")).newBuilder(paramQBaseActivity, 1008).setCallBack(paramEmoticonCallback).setOnlySysAndEmoji(true).setToastOffset(paramQBaseActivity.getTitleBarHeight()).create();
    paramEditText.hideAllTabs();
    paramEditText.setOnlySysEmotionEnable(true);
    paramQBaseActivity = new RelativeLayout.LayoutParams(-1, (int)DisplayUtils.a(paramQBaseActivity, 250.0F));
    paramViewGroup.addView(paramEditText.getView(), paramQBaseActivity);
    return paramEditText;
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null)
      {
        int j = localQQTextBuilder.length();
        Object localObject1 = new char[j];
        int i = 0;
        localQQTextBuilder.getChars(0, j, (char[])localObject1, 0);
        paramEditText = new StringBuilder();
        paramEditText.append((char[])localObject1);
        localObject1 = (EmoticonSpan[])localQQTextBuilder.getSpans(0, j, EmoticonSpan.class);
        if (((localQQTextBuilder instanceof Spanned)) && (Build.VERSION.SDK_INT >= 24)) {
          Arrays.sort((Object[])localObject1, new HealthReplyCommentActivity.2(localQQTextBuilder));
        }
        int i1 = localObject1.length;
        int k;
        for (j = 0; i < i1; j = k)
        {
          Object localObject2 = localObject1[i];
          int m;
          int n;
          if (((EmoticonSpan)localObject2).emojiType == 1)
          {
            m = localQQTextBuilder.getSpanStart(localObject2);
            n = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject2).index & 0x7FFFFFFF);
            paramEditText.replace(m + j, n + j, (String)localObject2);
          }
          for (k = ((String)localObject2).length();; k = ((String)localObject2).length())
          {
            k = j + (k - (n - m));
            break;
            k = j;
            if (((EmoticonSpan)localObject2).emojiType != 2) {
              break;
            }
            m = localQQTextBuilder.getSpanStart(localObject2);
            n = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = ((EmoticonSpan)localObject2).getDescription();
            paramEditText.replace(m + j, n + j, (String)localObject2);
          }
          i += 1;
        }
        return paramEditText.toString();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public static void a(EditText paramEditText)
  {
    try
    {
      Editable localEditable = paramEditText.getText();
      int j = paramEditText.getSelectionStart();
      int i = 0;
      if (j > 1) {
        i = TextUtils.getOffsetBefore(paramEditText.getText(), j);
      }
      if (j != i)
      {
        localEditable.delete(Math.min(j, i), Math.max(j, i));
        return;
      }
    }
    catch (Exception paramEditText)
    {
      paramEditText.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837969);
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      String str = a(this.jdField_a_of_type_AndroidWidgetEditText).replace("\n", " ");
      this.jdField_a_of_type_Boolean = true;
      Intent localIntent = new Intent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\"");
      localStringBuilder.append(str);
      localStringBuilder.append("\"");
      localIntent.putExtra("result", localStringBuilder.toString());
      setResult(-1, localIntent);
      finish();
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("bid", "");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pid", "");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append(getAppRuntime().getCurrentAccountUin());
    paramJSONObject.append("-");
    paramJSONObject.append(this.jdField_b_of_type_JavaLangString);
    paramJSONObject.append("-");
    paramJSONObject.append(this.jdField_a_of_type_JavaLangString);
    this.e = paramJSONObject.toString();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a(false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    String str = a(this.jdField_a_of_type_AndroidWidgetEditText);
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.length();
    }
    int j = this.jdField_b_of_type_Int;
    if ((j > 0) && (i > j))
    {
      j = i - j;
      paramEditable.delete(this.jdField_c_of_type_Int - j, this.jdField_d_of_type_Int);
      this.jdField_c_of_type_Int -= j;
      this.jdField_d_of_type_Int -= j;
      i = j;
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        QQToast.a(this, this.f, 0).b(getTitleBarHeight());
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        i = j;
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      i = 0;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_Int + i);
  }
  
  protected void b()
  {
    try
    {
      setContentView(2131558480);
      hideTitleBar();
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131376818));
      findViewById(2131379111).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368596));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366318));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377197));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369784));
      this.jdField_a_of_type_AndroidViewViewGroup = a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this).getView();
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0))
      {
        this.jdField_a_of_type_Int = 3;
        this.jdField_b_of_type_Int = 700;
        this.jdField_c_of_type_JavaLangString = getString(2131696243, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)
      {
        EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        String str;
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          str = this.jdField_d_of_type_JavaLangString;
        } else {
          str = null;
        }
        localEditText.setText(str);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      finish();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reply save key = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    Object localObject = new HealthReplyCommentActivity.PublishDataCacheEntity();
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    jdField_a_of_type_JavaUtilHashMap.put(this.e, localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reply save key = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", data = ");
      localStringBuilder.append(localObject);
      QLog.d("IphoneTitleBarActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("repky restore key = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    Object localObject = (HealthReplyCommentActivity.PublishDataCacheEntity)jdField_a_of_type_JavaUtilHashMap.get(this.e);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reply restore key = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", replyData = ");
      localStringBuilder.append(localObject);
      QLog.d("IphoneTitleBarActivity", 2, localStringBuilder.toString());
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_Int = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_b_of_type_Int;
    this.jdField_c_of_type_JavaLangString = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).jdField_b_of_type_JavaLangString;
  }
  
  public void delete()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null) {
      a(localEditText);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131696273, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("publish option: ");
      localStringBuilder.append(paramBundle);
      QLog.d("IphoneTitleBarActivity", 2, localStringBuilder.toString());
    }
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.jdField_a_of_type_Int = paramBundle.optInt("minContentLength", 3);
      this.jdField_b_of_type_Int = paramBundle.optInt("maxContentLength", 700);
      this.jdField_c_of_type_JavaLangString = paramBundle.optString("contentPlaceholder", this.jdField_c_of_type_JavaLangString);
      this.e = paramBundle.optString("cacheKey");
      this.f = getString(2131696242, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      this.jdField_b_of_type_Boolean = paramBundle.optBoolean("content_to_web", false);
      a(paramBundle);
      d();
      try
      {
        b();
        return true;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI Exception:");
        localStringBuilder.append(paramBundle.getClass().getSimpleName());
        localStringBuilder.append(" message:");
        localStringBuilder.append(paramBundle.getMessage());
        QLog.e("IphoneTitleBarActivity", 1, localStringBuilder.toString());
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      label295:
      break label295;
    }
    QQToast.a(this, 1, getString(2131696273, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject != null) {
      ((EditText)localObject).removeTextChangedListener(this);
    }
    try
    {
      localObject = Class.forName("android.widget.BubblePopupHelper").getDeclaredField("sHelper");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(null, null);
      if (QLog.isColorLevel())
      {
        QLog.e("IphoneTitleBarActivity", 2, "doOnDestroy: cut sHelper ref true");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy: ");
        localStringBuilder.append(QLog.getStackTraceString(localException));
        QLog.e("IphoneTitleBarActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void emoticonMall() {}
  
  public void finish()
  {
    super.finish();
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null) {
      InputMethodUtil.b(localEditText);
    }
    overridePendingTransition(0, 2130771992);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131379111) {
      finish();
    } else if (i == 2131368596)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        }
        else
        {
          InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new HealthReplyCommentActivity.1(this), 200L);
        }
      }
    }
    else if (i == 2131377197) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(getAppRuntime(), this, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthReplyCommentActivity
 * JD-Core Version:    0.7.0.1
 */