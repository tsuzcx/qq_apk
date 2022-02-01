package com.tencent.mobileqq.richstatus;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.text.ClickableImageSpan;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class EditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  public static boolean d;
  public static int h;
  public static int i;
  public long a;
  TextView b;
  Drawable c;
  boolean e = false;
  long f = 0L;
  View g;
  protected View.OnClickListener j = new EditActivity.3(this);
  protected String k = null;
  private RichStatusEditText l;
  private View m;
  private int n = 47;
  private StatusManager o;
  private RichStatus p;
  private ClickableImageSpan q;
  private Intent r;
  private int s;
  private LinearLayout t;
  private IActionListener u = new EditActivity.1(this);
  private boolean v = true;
  private TextWatcher w = new EditActivity.2(this);
  private RichStatusEditText.RichStatusEditListener x = new EditActivity.4(this);
  
  private Drawable a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tv.getWidth() = ");
      ((StringBuilder)localObject).append(paramView.getWidth());
      ((StringBuilder)localObject).append(",tv.getHeight()");
      ((StringBuilder)localObject).append(paramView.getHeight());
      QLog.d("EditActivity", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new Canvas(Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888));
      ((Canvas)localObject).translate(-paramView.getScrollX(), -paramView.getScrollY());
      paramView.draw((Canvas)localObject);
      paramView.setDrawingCacheEnabled(true);
      localObject = paramView.getDrawingCache();
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("EditActivity", 2, "cacheBm is null");
          return null;
        }
      }
      else
      {
        localObject = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
        paramView.destroyDrawingCache();
        paramView = new BitmapDrawable(getResources(), (Bitmap)localObject);
        paramView.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        return paramView;
      }
    }
    catch (OutOfMemoryError paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditActivity", 2, paramView.getMessage());
      }
      return null;
    }
    return null;
  }
  
  private Drawable a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(QQManagerFactory.SIGNATURE_MANAGER);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131625214, null);
    localView.setPadding(0, 0, 0, 0);
    ImageView localImageView = (ImageView)localView.findViewById(2131435474);
    TextView localTextView = (TextView)localView.findViewById(2131435475);
    Object localObject2 = this.p.actionText;
    Object localObject1 = localObject2;
    if (this.p.dataText != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(this.p.dataText);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 10)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 9));
      ((StringBuilder)localObject2).append("...");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localTextView.setText((CharSequence)localObject2);
    if (paramBoolean2) {
      localTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    } else if ((localSignatureManager.h != null) && (!TextUtils.isEmpty(localSignatureManager.h.j))) {
      localTextView.setTextColor(Color.parseColor(localSignatureManager.h.j));
    }
    localImageView.setImageBitmap(this.o.a(this.p.actionId, 200));
    localView.setBackgroundResource(2130851616);
    return a(localView);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.p.actionId == 0)
    {
      localObject1 = this.q;
      if (localObject1 != null) {
        this.l.a((ClickableImageSpan)localObject1, true, true);
      }
      return;
    }
    Object localObject1 = a(false, paramBoolean);
    Object localObject2 = a(true, paramBoolean);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return;
      }
      localObject1 = new ClickableImageSpan((Drawable)localObject1, (Drawable)localObject2);
      if (this.s != 1) {
        ((ClickableImageSpan)localObject1).setEnable(false);
      }
      localObject2 = this.q;
      if ((localObject2 != null) && (((ClickableImageSpan)localObject2).getDrawable() != null)) {
        ((ClickableImageSpan)localObject1).getDrawable().setState(this.q.getDrawable().getState());
      }
      localObject2 = this.l.getEditableText();
      if (localObject2 == null) {
        return;
      }
      if (((ImageSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), ClickableImageSpan.class)).length > 0)
      {
        this.l.a(this.q, (ClickableImageSpan)localObject1);
      }
      else
      {
        this.l.getText().insert(0, "[S]");
        this.l.setSpan((ImageSpan)localObject1, 0, 3);
      }
      this.q = ((ClickableImageSpan)localObject1);
    }
  }
  
  private void d()
  {
    Object localObject = (SignatureManager)this.app.getManager(QQManagerFactory.SIGNATURE_MANAGER);
    if (!this.v) {
      return;
    }
    if (this.q != null) {
      i1 = Math.max(this.l.getText().getSpanEnd(this.q), 0);
    } else {
      i1 = 0;
    }
    int i2 = this.l.getText().length();
    if ((this.p == null) || ((i2 == 0) && (this.s == 1)))
    {
      this.p = new RichStatus(null);
      this.p.plainText = new ArrayList();
      while (this.p.plainText.size() < 2) {
        this.p.plainText.add(null);
      }
    }
    if ((((SignatureManager)localObject).h == null) || (((SignatureManager)localObject).h.D == null)) {
      if (this.s == 1) {
        this.p.plainText.set(0, this.l.getText().subSequence(i1, i2).toString().trim());
      } else {
        this.p.plainText.set(0, this.l.getText().subSequence(i1, i2).toString());
      }
    }
    this.p.plainText.set(1, null);
    i2 = this.p.countLength();
    localObject = this.p;
    int i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (((RichStatus)localObject).actionText != null)
      {
        i1 = i2;
        if (this.p.actionId == 0) {
          i1 = i2 - 7;
        }
      }
    }
    localObject = Integer.toString(this.n - i1);
    if (i1 > this.n)
    {
      this.b.setTextColor(-65536);
      this.b.setText((CharSequence)localObject);
      return;
    }
    this.b.setTextColor(Color.parseColor("#777777"));
    this.b.setText((CharSequence)localObject);
  }
  
  protected void a()
  {
    if (this.s == 1)
    {
      if (this.p.countLength() > this.n)
      {
        a(2131915719);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.p.encode());
      setResult(-1, localIntent);
      super.finish();
    }
  }
  
  protected void a(int paramInt)
  {
    QQToast.makeText(getActivity(), paramInt, 0).show(getTitleBarHeight());
  }
  
  void b()
  {
    new Handler().postDelayed(new EditActivity.5(this), 500L);
  }
  
  void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 17))
    {
      Object localObject = this.r;
      if (localObject == null) {
        this.r = paramIntent;
      } else {
        ((Intent)localObject).putExtras(paramIntent);
      }
      this.p.actionId = ((int)this.r.getLongExtra("k_action_id", 0L));
      this.p.actionText = this.r.getStringExtra("k_action_text");
      if (TextUtils.isEmpty(this.p.actionText))
      {
        localObject = this.o.a(this.p.actionId);
        RichStatus localRichStatus = this.p;
        if (localObject != null) {
          localObject = ((ActionInfo)localObject).f;
        } else {
          localObject = " ";
        }
        localRichStatus.actionText = ((String)localObject);
      }
      this.p.dataId = ((int)paramIntent.getLongExtra("k_data_id", 0L));
      this.p.dataText = paramIntent.getStringExtra("k_data_text");
      a(false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.s = getIntent().getIntExtra("param_entry", 0);
    int i1 = getIntent().getIntExtra("max_word_count", -1);
    if (i1 != -1) {
      this.n = i1;
    }
    if (this.s == 1) {
      super.setContentView(2131629304);
    } else {
      super.setContentViewNoTitle(2131629304);
    }
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    h = paramBundle.heightPixels;
    i = paramBundle.widthPixels;
    this.o = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    paramBundle = this.o;
    if (paramBundle == null)
    {
      a(2131914072);
      super.finish();
      return false;
    }
    if (paramBundle.b())
    {
      a(2131915722);
      super.finish();
      return false;
    }
    this.c = new ColorDrawable(Color.parseColor("#dedede"));
    this.o.a(this.u);
    this.t = ((LinearLayout)super.findViewById(2131435838));
    this.g = super.findViewById(2131435832);
    if (this.s == 1)
    {
      LayoutInflater.from(this).inflate(2131629305, this.t, true);
      setTitle(HardCodeUtil.a(2131901725));
      this.leftView.setText(2131887440);
      this.g.setVisibility(4);
      this.b = ((TextView)super.findViewById(2131431446));
      this.b.setTextColor(getResources().getColor(2131168125));
      this.l = ((RichStatusEditText)super.findViewById(2131435829));
      this.l.setHint(HardCodeUtil.a(2131901722));
      this.l.setEditListener(this.x);
      paramBundle = getIntent().getByteArrayExtra("param_old_xuan_yan");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.p = RichStatus.parseStatus(paramBundle);
      } else {
        this.p = new RichStatus(null);
      }
      paramBundle = this.p;
      paramBundle.locationText = "";
      ArrayList localArrayList = paramBundle.plainText;
      paramBundle = localArrayList;
      if (localArrayList == null)
      {
        paramBundle = new ArrayList();
        this.p.plainText = paramBundle;
      }
      while (paramBundle.size() < 2) {
        paramBundle.add(null);
      }
      this.l.setText("");
      a(false);
      if (paramBundle.get(0) != null) {
        this.l.getText().append((CharSequence)paramBundle.get(0));
      }
      if (paramBundle.get(1) != null) {
        this.l.getText().append((CharSequence)paramBundle.get(1));
      }
      d();
      this.l.addTextChangedListener(this.w);
      this.m = super.findViewById(2131437695);
      this.m.setVisibility(8);
      this.leftView.setOnClickListener(this.j);
      ((RelativeLayout)super.findViewById(2131429276)).setVisibility(8);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    URLDrawable.resume();
    Object localObject = this.q;
    if (localObject != null) {
      ((ClickableImageSpan)localObject).setClickListener(null);
    }
    localObject = this.o;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.u);
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((RichStatusEditText)localObject).removeTextChangedListener(this.w);
      this.l.setEditListener(null);
    }
    c();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.e = false;
    c();
    super.doOnPause();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    this.v = false;
    super.doOnRestoreInstanceState(paramBundle);
    this.v = true;
  }
  
  protected void doOnResume()
  {
    this.e = true;
    if (this.s == 1) {
      b();
    }
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    RichStatus localRichStatus = this.p;
    if (localRichStatus != null) {
      paramBundle.putByteArray("param_rich_status", localRichStatus.encode());
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStart()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(QQManagerFactory.SIGNATURE_MANAGER);
    if ((localSignatureManager.h != null) && (localSignatureManager.h.D == null)) {
      this.l.setVisibility(0);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    RichStatusEditText localRichStatusEditText = this.l;
    if (localRichStatusEditText != null) {
      localRichStatusEditText.setVisibility(4);
    }
    super.doOnStop();
  }
  
  protected boolean isWrapContent()
  {
    return this.s == 1;
  }
  
  protected boolean onBackEvent()
  {
    this.a = System.currentTimeMillis();
    if (this.s == 1)
    {
      if (this.p.countLength() > this.n)
      {
        a(2131915719);
        return true;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.p.encode());
      setResult(-1, localIntent);
      super.finish();
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    paramView.getId();
    if (paramView.getId() != 2131435829) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity
 * JD-Core Version:    0.7.0.1
 */