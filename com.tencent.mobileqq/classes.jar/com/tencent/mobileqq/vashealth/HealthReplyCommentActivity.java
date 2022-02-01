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
  public static final HashMap<String, HealthReplyCommentActivity.PublishDataCacheEntity> a = new HashMap();
  public static Editable.Factory v = new HealthReplyCommentActivity.3();
  protected String b = null;
  protected String c = null;
  protected InputMethodRelativeLayout d = null;
  protected ImageButton e = null;
  protected Button f = null;
  protected FrameLayout g = null;
  protected ViewGroup h = null;
  protected EditText i = null;
  protected boolean j = false;
  protected int k = 0;
  protected int l = 0;
  protected String m = null;
  protected String n = null;
  protected String o = null;
  protected long p = 0L;
  protected int q;
  protected int r;
  protected String s = "";
  protected Boolean t = Boolean.valueOf(false);
  protected boolean u = false;
  
  public static IEmoticonMainPanel a(QBaseActivity paramQBaseActivity, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(v);
    paramEditText = ((IEmoticonMainPanelService)paramQBaseActivity.getAppRuntime().getRuntimeService(IEmoticonMainPanelService.class, "tool")).newBuilder(paramQBaseActivity, 1008).setCallBack(paramEmoticonCallback).setOnlySysAndEmoji(true).setToastOffset(paramQBaseActivity.getTitleBarHeight()).create();
    paramEditText.hideAllTabs();
    paramEditText.setOnlySysEmotionEnable(true);
    paramQBaseActivity = new RelativeLayout.LayoutParams(-1, (int)DisplayUtils.a(paramQBaseActivity, 250.0F));
    paramViewGroup.addView(paramEditText.getView(), paramQBaseActivity);
    return paramEditText;
  }
  
  public static void a(EditText paramEditText)
  {
    try
    {
      Editable localEditable = paramEditText.getText();
      int i2 = paramEditText.getSelectionStart();
      int i1 = 0;
      if (i2 > 1) {
        i1 = TextUtils.getOffsetBefore(paramEditText.getText(), i2);
      }
      if (i2 != i1)
      {
        localEditable.delete(Math.min(i2, i1), Math.max(i2, i1));
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
      this.g.setBackgroundResource(2130837993);
      InputMethodUtil.b(this.i);
      this.h.setVisibility(0);
      this.e.setSelected(true);
      return;
    }
    this.g.setBackgroundColor(0);
    this.h.setVisibility(8);
    this.e.setSelected(false);
  }
  
  public static String b(EditText paramEditText)
  {
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null)
      {
        int i2 = localQQTextBuilder.length();
        Object localObject1 = new char[i2];
        int i1 = 0;
        localQQTextBuilder.getChars(0, i2, (char[])localObject1, 0);
        paramEditText = new StringBuilder();
        paramEditText.append((char[])localObject1);
        localObject1 = (EmoticonSpan[])localQQTextBuilder.getSpans(0, i2, EmoticonSpan.class);
        if (((localQQTextBuilder instanceof Spanned)) && (Build.VERSION.SDK_INT >= 24)) {
          Arrays.sort((Object[])localObject1, new HealthReplyCommentActivity.2(localQQTextBuilder));
        }
        int i6 = localObject1.length;
        int i3;
        for (i2 = 0; i1 < i6; i2 = i3)
        {
          Object localObject2 = localObject1[i1];
          int i4;
          int i5;
          if (((EmoticonSpan)localObject2).emojiType == 1)
          {
            i4 = localQQTextBuilder.getSpanStart(localObject2);
            i5 = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject2).index & 0x7FFFFFFF);
            paramEditText.replace(i4 + i2, i5 + i2, (String)localObject2);
          }
          for (i3 = ((String)localObject2).length();; i3 = ((String)localObject2).length())
          {
            i3 = i2 + (i3 - (i5 - i4));
            break;
            i3 = i2;
            if (((EmoticonSpan)localObject2).emojiType != 2) {
              break;
            }
            i4 = localQQTextBuilder.getSpanStart(localObject2);
            i5 = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = ((EmoticonSpan)localObject2).getDescription();
            paramEditText.replace(i4 + i2, i5 + i2, (String)localObject2);
          }
          i1 += 1;
        }
        return paramEditText.toString();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public void a()
  {
    if (this.u)
    {
      String str = b(this.i).replace("\n", " ");
      this.j = true;
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
    this.c = paramJSONObject.optString("bid", "");
    this.b = paramJSONObject.optString("pid", "");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append(getAppRuntime().getCurrentAccountUin());
    paramJSONObject.append("-");
    paramJSONObject.append(this.c);
    paramJSONObject.append("-");
    paramJSONObject.append(this.b);
    this.o = paramJSONObject.toString();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a(false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.q = this.i.getSelectionStart();
    this.r = this.i.getSelectionEnd();
    String str = b(this.i);
    int i1;
    if (str == null) {
      i1 = 0;
    } else {
      i1 = str.length();
    }
    int i2 = this.l;
    if ((i2 > 0) && (i1 > i2))
    {
      i2 = i1 - i2;
      paramEditable.delete(this.q - i2, this.r);
      this.q -= i2;
      this.r -= i2;
      i1 = i2;
      if (!this.t.booleanValue())
      {
        QQToast.makeText(this, this.s, 0).show(getTitleBarHeight());
        this.t = Boolean.valueOf(true);
        i1 = i2;
      }
    }
    else
    {
      this.t = Boolean.valueOf(false);
      i1 = 0;
    }
    this.i.setSelection(this.q + i1);
  }
  
  protected void b()
  {
    try
    {
      setContentView(2131624024);
      hideTitleBar();
      this.d = ((InputMethodRelativeLayout)findViewById(2131445148));
      findViewById(2131447846).setOnClickListener(this);
      this.e = ((ImageButton)findViewById(2131435508));
      this.i = ((EditText)findViewById(2131432618));
      this.f = ((Button)findViewById(2131445580));
      this.g = ((FrameLayout)findViewById(2131436914));
      this.h = a(this, this.g, this.i, this).getView();
      this.d.setOnSizeChangedListenner(this);
      this.e.setOnClickListener(this);
      this.f.setSelected(true);
      this.f.setPressed(false);
      this.f.setOnClickListener(this);
      this.i.addTextChangedListener(this);
      if ((TextUtils.isEmpty(this.m)) || (this.k <= 0) || (this.l <= 0))
      {
        this.k = 3;
        this.l = 700;
        this.m = getString(2131894009, new Object[] { Integer.valueOf(this.k), Integer.valueOf(this.l) });
      }
      this.i.setHint(this.m);
      if (this.i.getText().length() <= 0)
      {
        EditText localEditText = this.i;
        String str;
        if (!TextUtils.isEmpty(this.n)) {
          str = this.n;
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
      ((StringBuilder)localObject).append(this.o);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.o)) {
      return;
    }
    Object localObject = new HealthReplyCommentActivity.PublishDataCacheEntity();
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).a = this.k;
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).b = this.l;
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).c = this.m;
    ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).d = this.i.getEditableText().toString();
    a.put(this.o, localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reply save key = ");
      localStringBuilder.append(this.o);
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
      ((StringBuilder)localObject).append(this.o);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.o)) {
      return;
    }
    Object localObject = (HealthReplyCommentActivity.PublishDataCacheEntity)a.get(this.o);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reply restore key = ");
      localStringBuilder.append(this.o);
      localStringBuilder.append(", replyData = ");
      localStringBuilder.append(localObject);
      QLog.d("IphoneTitleBarActivity", 2, localStringBuilder.toString());
    }
    a.clear();
    if (localObject == null) {
      return;
    }
    this.k = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).a;
    this.l = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).b;
    this.m = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).c;
    this.n = ((HealthReplyCommentActivity.PublishDataCacheEntity)localObject).d;
  }
  
  public void delete()
  {
    EditText localEditText = this.i;
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
      QQToast.makeText(this, 1, getString(2131894039, new Object[] { Integer.valueOf(990) }), 0).show(getTitleBarHeight());
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
      this.k = paramBundle.optInt("minContentLength", 3);
      this.l = paramBundle.optInt("maxContentLength", 700);
      this.m = paramBundle.optString("contentPlaceholder", this.m);
      this.o = paramBundle.optString("cacheKey");
      this.s = getString(2131894008, new Object[] { Integer.valueOf(this.l) });
      this.u = paramBundle.optBoolean("content_to_web", false);
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
    QQToast.makeText(this, 1, getString(2131894039, new Object[] { Integer.valueOf(999) }), 0).show(getTitleBarHeight());
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.j) {
      c();
    }
    Object localObject = this.i;
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
    EditText localEditText = this.i;
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
    if (i1 == 2131447846) {
      finish();
    } else if (i1 == 2131435508)
    {
      if (System.currentTimeMillis() - this.p >= 500L)
      {
        this.p = System.currentTimeMillis();
        if (this.h.getVisibility() == 0)
        {
          this.h.setVisibility(8);
          InputMethodUtil.a(this.i);
          this.e.setSelected(false);
        }
        else
        {
          InputMethodUtil.b(this.i);
          this.i.postDelayed(new HealthReplyCommentActivity.1(this), 200L);
        }
      }
    }
    else if (i1 == 2131445580) {
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
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.i != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(getAppRuntime(), this, this.i, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthReplyCommentActivity
 * JD-Core Version:    0.7.0.1
 */