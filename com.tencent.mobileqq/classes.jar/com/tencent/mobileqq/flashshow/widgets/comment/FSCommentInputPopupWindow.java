package com.tencent.mobileqq.flashshow.widgets.comment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.CommentEditText;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.parser.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FSCommentInputPopupWindow
  extends FSBaseInputPopupWindow
{
  private View o;
  private SystemAndEmojiEmoticonPanel p;
  private LinearLayout q;
  private ImageButton r;
  private ImageButton s;
  private TextView t;
  private LinearLayout u;
  private LinearLayout v;
  private TextView w;
  private FSCommentInputPopupWindow.OnCommentPopupHeightChangeListener x;
  private boolean y = false;
  
  public FSCommentInputPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    k();
  }
  
  private int a(int paramInt)
  {
    Object localObject = getContext();
    if (localObject == null) {
      return -1;
    }
    localObject = ((Context)localObject).getResources();
    if (localObject == null) {
      return -1;
    }
    return ((Resources)localObject).getColor(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    FSCommentInputPopupWindow.OnCommentPopupHeightChangeListener localOnCommentPopupHeightChangeListener = this.x;
    if (localOnCommentPopupHeightChangeListener != null) {
      localOnCommentPopupHeightChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.p;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(8);
    }
    d(this.k);
    if (paramBoolean) {
      a(this.c, 0);
    }
  }
  
  private void o()
  {
    Object localObject = this.o;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null))
    {
      this.o.getLayoutParams().height = this.e;
      this.o.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("FSBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.p;
    if ((localObject != null) && (((SystemAndEmojiEmoticonPanel)localObject).getLayoutParams() != null))
    {
      this.p.getLayoutParams().height = this.e;
      this.p.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("FSBaseInputPopupWindow", 1, ((StringBuilder)localObject).toString());
    }
    p();
  }
  
  private void p()
  {
    if (this.a == null) {
      return;
    }
    View localView = this.a.findViewById(2131431083);
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new FSCommentInputPopupWindow.2(this, localView));
  }
  
  private void q()
  {
    if (this.h) {
      c(this.k);
    }
    this.y = true;
    Object localObject = this.o;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.p;
    if (localObject != null) {
      ((SystemAndEmojiEmoticonPanel)localObject).setVisibility(0);
    }
    b(this.c);
  }
  
  private void r()
  {
    this.c.setOnEditorActionListener(new FSCommentInputPopupWindow.5(this));
    this.c.addTextChangedListener(new FSCommentInputPopupWindow.6(this));
  }
  
  private void s()
  {
    this.u.setVisibility(8);
    Object localObject1 = this.c.getText().toString();
    Object localObject2 = Patterns.k.matcher((CharSequence)localObject1);
    int i = 0;
    while (((Matcher)localObject2).find()) {
      i += ((Matcher)localObject2).end() - ((Matcher)localObject2).start() - 2;
    }
    i = ((String)localObject1).length() - i;
    if (i >= 90)
    {
      this.u.setVisibility(0);
      localObject1 = this.t;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      if (i > 100) {
        this.t.setTextColor(getContext().getResources().getColor(2131166070));
      } else {
        this.t.setTextColor(getContext().getResources().getColor(2131166071));
      }
      localObject1 = this.w;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(100);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
  }
  
  private void t()
  {
    this.l = new SoftKeyboardStateHelper(this.a);
    this.l.a(new FSCommentInputPopupWindow.7(this));
    this.a.getViewTreeObserver();
  }
  
  public int a()
  {
    return 2131624782;
  }
  
  protected void a(View paramView) {}
  
  public void a(FSCommentInputPopupWindow.OnCommentPopupHeightChangeListener paramOnCommentPopupHeightChangeListener)
  {
    this.x = paramOnCommentPopupHeightChangeListener;
  }
  
  public void a(boolean paramBoolean)
  {
    show();
    t();
    if (paramBoolean)
    {
      h().post(new FSCommentInputPopupWindow.3(this));
      return;
    }
    h().post(new FSCommentInputPopupWindow.4(this));
  }
  
  protected void d()
  {
    this.q = ((LinearLayout)this.a.findViewById(2131431066));
    this.s = ((ImageButton)this.a.findViewById(2131429880));
    this.r = ((ImageButton)this.a.findViewById(2131429918));
    this.t = ((TextView)this.a.findViewById(2131448881));
    this.u = ((LinearLayout)this.a.findViewById(2131450239));
    this.w = ((TextView)this.a.findViewById(2131448882));
    super.d();
    o();
  }
  
  public void dismiss()
  {
    b(false);
    super.dismiss();
  }
  
  protected void e()
  {
    super.e();
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
    r();
  }
  
  protected void k()
  {
    FSCommentInputPopupWindow.1 local1 = new FSCommentInputPopupWindow.1(this);
    this.v = ((LinearLayout)this.a.findViewById(2131437601));
    this.o = HostEmotionUtil.getEmojiPanel(HostUIHelper.getInstance().getHostApplicationContext(), local1);
    this.o.setVisibility(0);
    this.o.setBackgroundColor(a(2131166087));
    this.v.addView(this.o, new LinearLayout.LayoutParams(-1, -1));
  }
  
  protected boolean l()
  {
    try
    {
      int i;
      if (this.t == null) {
        i = 0;
      } else {
        i = Integer.parseInt(this.t.getText().toString());
      }
      if (i > 100) {
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick:");
    localStringBuilder.append(paramView.getId());
    QLog.d("FSBaseInputPopupWindow", 1, localStringBuilder.toString());
    int i = paramView.getId();
    if (i == 2131429880)
    {
      QLog.d("FSBaseInputPopupWindow", 1, "btn_emotion");
      q();
      this.r.setVisibility(0);
      this.s.setVisibility(8);
    }
    else if (i == 2131433392)
    {
      QLog.d("FSBaseInputPopupWindow", 1, "text_input");
      b(true);
      this.r.setVisibility(8);
      this.s.setVisibility(0);
    }
    else if (i == 2131429958)
    {
      if ((!l()) && (this.j != null)) {
        this.j.a();
      }
    }
    else if (i == 2131429918)
    {
      QLog.d("FSBaseInputPopupWindow", 1, "btn_keyboard");
      b(true);
      this.r.setVisibility(8);
      this.s.setVisibility(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.s.setVisibility(8);
    this.r.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */