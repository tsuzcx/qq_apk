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
  public static LruCache<String, String> s = new LruCache(3);
  protected InputMethodRelativeLayout a = null;
  protected ImageButton b = null;
  protected Button c = null;
  protected FrameLayout d = null;
  protected SystemEmoticonPanel e = null;
  protected EditText f = null;
  protected int g = 0;
  protected int h = 0;
  protected String i = null;
  protected String j = null;
  protected boolean k = true;
  protected long l = 0L;
  protected boolean m = false;
  protected String n;
  protected int o;
  protected int p;
  protected boolean q = false;
  protected Handler r = new Handler();
  private TextView t;
  private CheckBox u;
  
  private void a(int paramInt)
  {
    this.d.setBackgroundResource(2130837993);
    if (paramInt != 2)
    {
      this.d.setBackgroundColor(0);
      this.e.setVisibility(8);
      this.b.setImageResource(2130851019);
      return;
    }
    InputMethodUtil.b(this.f);
    this.e.setVisibility(0);
    this.b.setImageResource(2130849799);
  }
  
  public void a()
  {
    String str = TroopBarUtils.a(this.f).replace("\n", " ");
    Intent localIntent = new Intent();
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((!this.m) || (this.u == null) || (!this.u.isChecked())) {
          break label176;
        }
        i1 = 1;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label107;
        }
        QLog.e("CampusCircleReplyActivity", 2, localJSONException, new Object[] { "onSend, exception" });
      }
      ((JSONObject)localObject).put("anonymous", i1);
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
      this.q = true;
      finish();
      return;
      label176:
      int i1 = 0;
      if (i1 != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.g = paramJSONObject.optInt("minlen", 3);
    this.h = paramJSONObject.optInt("maxlen", 700);
    this.i = paramJSONObject.optString("hint", "");
    boolean bool2 = true;
    boolean bool1;
    if (paramJSONObject.optInt("emoji", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    if (paramJSONObject.optInt("anonymous", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.m = bool1;
    this.n = paramJSONObject.optString("from", "default");
    this.j = paramJSONObject.optString("feedId", "");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a(0);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.o = this.f.getSelectionStart();
    this.p = this.f.getSelectionEnd();
    String str = TroopBarUtils.a(this.f);
    int i3 = 0;
    int i1;
    if (str == null) {
      i1 = 0;
    } else {
      i1 = str.length();
    }
    int i4 = this.h;
    int i2 = i3;
    if (i4 > 0)
    {
      i2 = i3;
      if (i1 > i4)
      {
        i2 = i1 - i4;
        paramEditable.delete(this.o - i2, this.p);
        this.o -= i2;
        this.p -= i2;
      }
    }
    this.f.setSelection(this.o + i2);
  }
  
  protected void b()
  {
    setContentView(2131627346);
    Object localObject = findViewById(2131444897);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.a = ((InputMethodRelativeLayout)findViewById(2131445148));
    this.b = ((ImageButton)findViewById(2131435508));
    this.f = ((EditText)findViewById(2131432618));
    this.c = ((Button)findViewById(2131445580));
    this.d = ((FrameLayout)findViewById(2131436914));
    this.u = ((CheckBox)findViewById(2131428384));
    this.t = ((TextView)findViewById(2131428385));
    this.e = TroopBarPublishUtils.a(this, this.d, this.f, this);
    this.a.setOnSizeChangedListenner(this);
    findViewById(2131447846).setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setSelected(true);
    this.c.setPressed(false);
    this.c.setOnClickListener(this);
    this.f.addTextChangedListener(this);
    this.f.setHint(this.i);
    localObject = this.b;
    int i1;
    if (this.k) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ImageButton)localObject).setVisibility(i1);
    StringBuilder localStringBuilder;
    if (this.m)
    {
      this.u.setVisibility(0);
      this.u.setChecked(false);
      this.u.setOnCheckedChangeListener(new CampusCircleReplyActivity.1(this));
      this.t.setVisibility(0);
      if (this.n.equalsIgnoreCase("comment")) {
        i1 = 2131899581;
      }
      for (;;)
      {
        localObject = HardCodeUtil.a(i1);
        break;
        if (this.n.equalsIgnoreCase("publish")) {
          i1 = 2131899572;
        } else {
          i1 = 2131899583;
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("anonymous str=");
        localStringBuilder.append((String)localObject);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
      this.t.setText((CharSequence)localObject);
      this.t.setTextColor(getResources().getColorStateList(2131167210));
    }
    else
    {
      this.u.setVisibility(8);
      this.t.setVisibility(8);
    }
    if (!android.text.TextUtils.isEmpty(this.j))
    {
      localObject = (String)s.get(this.j);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDraft, mFeedId=");
        localStringBuilder.append(this.j);
        localStringBuilder.append(", draft=");
        localStringBuilder.append((String)localObject);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.f.setText((CharSequence)localObject);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void delete()
  {
    EditText localEditText = this.f;
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
      QQToast.makeText(this, 1, getString(2131894039, new Object[] { Integer.valueOf(990) }), 0).show(getTitleBarHeight());
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
      QQToast.makeText(this, 1, getString(2131894039, new Object[] { Integer.valueOf(999) }), 0).show(getTitleBarHeight());
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
    if ((!this.q) && (!android.text.TextUtils.isEmpty(this.j)))
    {
      localObject = this.f.getEditableText().toString();
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        s.put(this.j, localObject);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("save draft, text=");
        localStringBuilder.append((String)localObject);
        QLog.d("CampusCircleReplyActivity", 2, localStringBuilder.toString());
      }
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((EditText)localObject).removeTextChangedListener(this);
    }
  }
  
  public void emoticonMall() {}
  
  public void finish()
  {
    super.finish();
    EditText localEditText = this.f;
    if (localEditText != null) {
      InputMethodUtil.b(localEditText);
    }
    overridePendingTransition(0, 2130771995);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131435508)
    {
      if (i1 != 2131445580)
      {
        if (i1 == 2131447846)
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
    else if (System.currentTimeMillis() - this.l >= 500L)
    {
      this.l = System.currentTimeMillis();
      if (this.e.getVisibility() == 0)
      {
        this.e.setVisibility(8);
        InputMethodUtil.a(this.f);
      }
      else
      {
        InputMethodUtil.b(this.f);
        this.r.postDelayed(new CampusCircleReplyActivity.2(this), 200L);
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
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.f != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(this.app, this, this.f, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity
 * JD-Core Version:    0.7.0.1
 */