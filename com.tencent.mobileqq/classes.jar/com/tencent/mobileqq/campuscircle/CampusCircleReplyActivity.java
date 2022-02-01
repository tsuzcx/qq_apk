package com.tencent.mobileqq.campuscircle;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(12)
public class CampusCircleReplyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  public static LruCache<String, String> a;
  protected int a;
  protected long a;
  protected Handler a;
  protected Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected EditText a;
  protected FrameLayout a;
  protected ImageButton a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected SystemEmoticonPanel a;
  protected InputMethodRelativeLayout a;
  protected String a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  protected boolean c;
  protected int d;
  
  static
  {
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(3);
  }
  
  public CampusCircleReplyActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837969);
    if (paramInt != 2)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130849335);
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130848135);
  }
  
  public void a()
  {
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText).replace("\n", " ");
    Intent localIntent = new Intent();
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetCheckBox == null) || (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
          break label176;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label107;
        }
        QLog.e("CampusCircleReplyActivity", 2, localJSONException, new Object[] { "onSend, exception" });
      }
      ((JSONObject)localObject).put("anonymous", i);
      ((JSONObject)localObject).put("text", str);
      label107:
      localIntent.putExtra("result", ((JSONObject)localObject).toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSend, text=");
        ((StringBuilder)localObject).append(str);
        QLog.d("CampusCircleReplyActivity", 2, ((StringBuilder)localObject).toString());
      }
      setResult(-1, localIntent);
      this.jdField_c_of_type_Boolean = true;
      finish();
      return;
      label176:
      int i = 0;
      if (i != 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("minlen", 3);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("maxlen", 700);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("hint", "");
    boolean bool2 = true;
    boolean bool1;
    if (paramJSONObject.optInt("emoji", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (paramJSONObject.optInt("anonymous", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("from", "default");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("feedId", "");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a(0);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    this.d = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    int k = 0;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.length();
    }
    int m = this.jdField_b_of_type_Int;
    int j = k;
    if (m > 0)
    {
      j = k;
      if (i > m)
      {
        j = i - m;
        paramEditable.delete(this.jdField_c_of_type_Int - j, this.d);
        this.jdField_c_of_type_Int -= j;
        this.d -= j;
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_Int + j);
  }
  
  protected void b()
  {
    setContentView(2131561005);
    Object localObject = findViewById(2131376636);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131376818));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368596));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366318));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377197));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369784));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131362703));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362704));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    findViewById(2131379111).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageButton)localObject).setVisibility(i);
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new CampusCircleReplyActivity.1(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("comment")) {
        i = 2131701559;
      }
      for (;;)
      {
        localObject = HardCodeUtil.a(i);
        break;
        if (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("publish")) {
          i = 2131701550;
        } else {
          i = 2131701561;
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("anonymous str=");
        localStringBuilder.append((String)localObject);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166375));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = (String)jdField_a_of_type_AndroidUtilLruCache.get(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDraft, mFeedId=");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(", draft=");
        localStringBuilder.append((String)localObject);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void delete()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null) {
      com.tencent.mobileqq.text.TextUtils.backspace(localEditText);
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
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "bundle is null");
      }
      QQToast.a(this, 1, getString(2131696273, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("publish option: ");
        localStringBuilder.append(paramBundle);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
      paramBundle = new JSONObject(paramBundle);
      a(paramBundle);
      b();
      return true;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(this, 1, getString(2131696273, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.e("CampusCircleReplyActivity", 2, paramBundle, new Object[] { "onCreate parse json failed" });
      }
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((!this.jdField_c_of_type_Boolean) && (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        jdField_a_of_type_AndroidUtilLruCache.put(this.jdField_b_of_type_JavaLangString, localObject);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("save draft, text=");
        localStringBuilder.append((String)localObject);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject != null) {
      ((EditText)localObject).removeTextChangedListener(this);
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
    if (i != 2131368596)
    {
      if (i != 2131377197)
      {
        if (i == 2131379111)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CampusCircleReplyActivity", 2, "transparent_space click!");
          }
          finish();
        }
      }
      else {
        a();
      }
    }
    else if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      else
      {
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CampusCircleReplyActivity.2(this), 200L);
      }
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
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity
 * JD-Core Version:    0.7.0.1
 */