package com.tencent.mobileqq.flashshow.widgets.comment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qcircleshadow.lib.QCircleHostTextBuilder;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils.QCircleResultData;
import com.tencent.mobileqq.flashshow.events.FSAtUpdateEvent;
import com.tencent.mobileqq.flashshow.utils.FSDisplayUtils;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.CommentEditText;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SafeDialog;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import cooperation.qqcircle.beans.Friend;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FSBaseInputPopupWindow
  extends SafeDialog
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  protected View a = LayoutInflater.from(getContext()).inflate(a(), null);
  protected SharedPreferences.Editor b;
  protected CommentEditText c;
  protected Button d;
  protected int e;
  public boolean f = false;
  protected int g = -1;
  protected boolean h = false;
  protected int i = 0;
  protected FSBaseInputPopupWindow.EventListener j;
  protected View k;
  protected SoftKeyboardStateHelper l;
  protected boolean m = false;
  private SharedPreferences o;
  private InputMethodManager p;
  private FSBaseInputPopupWindow.OnDismissListener q;
  private Handler r;
  private AlphaAnimation s;
  private List<Friend> t = new ArrayList();
  
  public FSBaseInputPopupWindow(Context paramContext)
  {
    super(paramContext, 2131952655);
    c();
    setCancelable(true);
    d();
    setContentView(this.a);
    a(this.a);
    e();
    setOnDismissListener(this);
    b();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = Pattern.compile(paramString1, 16).matcher(paramString2).replaceFirst(paramString3);
      return str;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return b(paramString2, paramString1, paramString3);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    paramSpannableStringBuilder.setSpan(new FSBaseInputPopupWindow.7(this, 0), paramInt1, paramInt2, 17);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Friend localFriend = new Friend();
      try
      {
        localFriend.mUin = Long.parseLong(paramString1);
        localFriend.mName = paramString2;
        if (this.t == null) {
          this.t = new ArrayList();
        }
        this.t.add(localFriend);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("addUsers error");
        paramString2.append(paramString1.getMessage());
        QLog.e("FSBaseInputPopupWindow", 1, paramString2.toString());
      }
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    int n = paramString1.indexOf(paramString2, 0);
    if (n == -1) {
      return paramString1;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.replace(n, paramString2.length() + n, paramString3);
    return paramString1.toString();
  }
  
  private String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject2 = this.t;
    Object localObject1 = paramString;
    if (localObject2 != null)
    {
      if (((List)localObject2).size() == 0) {
        return paramString;
      }
      localObject2 = this.t.iterator();
      for (;;)
      {
        localObject1 = paramString;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Friend localFriend = (Friend)((Iterator)localObject2).next();
        localObject1 = localFriend.mName;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localFriend.mUin);
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = ((String)localObject1).replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E");
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("@{uin:");
        ((StringBuilder)localObject3).append(localFriend.mUin);
        ((StringBuilder)localObject3).append(",nick:");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("}");
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("@");
        ((StringBuilder)localObject3).append(localFriend.mName);
        localObject3 = ((StringBuilder)localObject3).toString();
        if ((!TextUtils.isEmpty(localFriend.mName)) && (paramString.contains((CharSequence)localObject3))) {
          paramString = a((String)localObject3, paramString, (String)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  protected abstract int a();
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    CommentEditText localCommentEditText = this.c;
    if (localCommentEditText == null) {
      return;
    }
    localCommentEditText.setText(paramSpannableStringBuilder);
    this.c.setSelection(paramSpannableStringBuilder.length());
  }
  
  protected abstract void a(View paramView);
  
  public void a(View paramView, int paramInt)
  {
    paramView.requestFocus();
    paramView.postDelayed(new FSBaseInputPopupWindow.4(this, paramView), paramInt);
  }
  
  public void a(FSAtUpdateEvent paramFSAtUpdateEvent)
  {
    HostUIHelper.closeHostEnvironment();
    if ((paramFSAtUpdateEvent != null) && (paramFSAtUpdateEvent.mData != null) && (this.c != null))
    {
      if (paramFSAtUpdateEvent.mData.getExtras() != null)
      {
        int n = this.c.getSelectionStart();
        Object localObject1 = this.c.getEditableText();
        Object localObject2;
        if ((n > 0) && (n <= localObject1.toString().length()))
        {
          localObject2 = localObject1.toString();
          int i1 = n - 1;
          if (((String)localObject2).substring(i1, n).equals("@")) {
            ((Editable)localObject1).delete(i1, n);
          }
        }
        paramFSAtUpdateEvent = HostSelectMemberUtils.getResultList(paramFSAtUpdateEvent.mData);
        if (paramFSAtUpdateEvent != null)
        {
          localObject1 = paramFSAtUpdateEvent.iterator();
          paramFSAtUpdateEvent = "";
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (HostSelectMemberUtils.QCircleResultData)((Iterator)localObject1).next();
            localObject2 = new Friend();
            if (!TextUtils.isEmpty(((HostSelectMemberUtils.QCircleResultData)localObject3).name)) {
              ((Friend)localObject2).mName = ((HostSelectMemberUtils.QCircleResultData)localObject3).name;
            } else {
              ((Friend)localObject2).mName = ((HostSelectMemberUtils.QCircleResultData)localObject3).uin;
            }
            try
            {
              long l1 = Long.valueOf(((HostSelectMemberUtils.QCircleResultData)localObject3).uin).longValue();
              ((Friend)localObject2).mUin = l1;
              if ((((Friend)localObject2).mName != null) && (((Friend)localObject2).mUin != 0L))
              {
                if (this.t == null) {
                  this.t = new ArrayList();
                }
                this.t.add(localObject2);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("@");
                ((StringBuilder)localObject3).append(((Friend)localObject2).mName);
                ((StringBuilder)localObject3).append(" ");
                localObject2 = ((StringBuilder)localObject3).toString();
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(paramFSAtUpdateEvent);
                ((StringBuilder)localObject3).append((String)localObject2);
                paramFSAtUpdateEvent = ((StringBuilder)localObject3).toString();
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              label337:
              break label337;
            }
          }
          if (!TextUtils.isEmpty(paramFSAtUpdateEvent))
          {
            localObject1 = new SpannableString(paramFSAtUpdateEvent);
            ((SpannableString)localObject1).setSpan(new FSBaseInputPopupWindow.6(this, 0), 0, paramFSAtUpdateEvent.length(), 17);
            this.c.getEditableText().insert(this.c.getSelectionStart(), (CharSequence)localObject1);
          }
        }
      }
      a(this.c, 100);
      return;
    }
    a(this.c, 100);
  }
  
  public void a(FSBaseInputPopupWindow.EventListener paramEventListener)
  {
    this.j = paramEventListener;
  }
  
  public void a(FSBaseInputPopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.q = paramOnDismissListener;
  }
  
  public void a(String paramString)
  {
    CommentEditText localCommentEditText = this.c;
    if (localCommentEditText == null) {
      return;
    }
    localCommentEditText.setText(paramString);
    this.c.setSelection(paramString.length());
  }
  
  @TargetApi(19)
  public void b()
  {
    super.b();
    Object localObject = getWindow();
    if (localObject == null) {
      return;
    }
    localObject = ((Window)localObject).getDecorView();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      int n = 0;
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        int i1 = ((ViewGroup)localObject).getChildCount();
        while (n < i1)
        {
          View localView = ((ViewGroup)localObject).getChildAt(n);
          if (localView == null) {
            return;
          }
          if (localView.getId() == 16908290) {
            return;
          }
          if (!(localView instanceof ViewStub)) {
            localView.setAlpha(0.0F);
          }
          n += 1;
        }
      }
    }
  }
  
  public void b(View paramView)
  {
    paramView.post(new FSBaseInputPopupWindow.5(this, paramView));
  }
  
  public void b(String paramString)
  {
    CommentEditText localCommentEditText = this.c;
    if (localCommentEditText != null) {
      localCommentEditText.setHint(paramString);
    }
  }
  
  public SpannableStringBuilder c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new SpannableStringBuilder("");
    }
    paramString = new SpannableStringBuilder(paramString);
    Matcher localMatcher = RichTextAtParser.a.matcher(paramString);
    int n = 0;
    try
    {
      Object localObject1;
      while (localMatcher.find())
      {
        int i1 = localMatcher.start() - n;
        int i2 = localMatcher.end();
        localObject1 = localMatcher.group();
        int i3 = ((String)localObject1).indexOf("uin:");
        int i4 = ((String)localObject1).indexOf(",nick:");
        String str1 = ((String)localObject1).substring(i3 + 4, i4);
        String str2 = ((String)localObject1).substring(i4 + 6, ((String)localObject1).length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString.replace(i1, i2 - n, (CharSequence)localObject2);
        n += ((String)localObject1).length() - ((String)localObject2).length();
        a(paramString, i1, ((String)localObject2).length() + i1);
        a(str1, str2);
      }
      return paramString;
    }
    catch (Exception localException)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("restoreATContent error");
      ((StringBuilder)localObject1).append(localException.getMessage());
      QLog.e("FSBaseInputPopupWindow", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void c()
  {
    if ((getWindow() != null) && (getWindow().getAttributes() != null))
    {
      Window localWindow = getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setSoftInputMode(16);
    }
  }
  
  protected void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  @SuppressLint({"WrongConstant"})
  protected void d()
  {
    this.c = ((CommentEditText)this.a.findViewById(2131433392));
    this.c.setOnInputBackListener(new FSBaseInputPopupWindow.1(this));
    this.c.setPadding(ViewUtils.dip2px(24.0F), ViewUtils.dip2px(14.0F), ViewUtils.dip2px(44.0F), ViewUtils.dip2px(14.0F));
    this.c.setHintTextColor(FSTransUtils.f().getResources().getColor(2131166097));
    this.c.setEditableFactory(QCircleHostTextBuilder.getEmoctationFacory());
    this.d = ((Button)this.a.findViewById(2131429958));
    this.o = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.b = this.o.edit();
    this.e = this.o.getInt("GroupSoftKeyboardHeight", ViewUtils.dip2px(250.0F));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mEmojiPanel initView() step1 :");
    localStringBuilder.append(this.e);
    QLog.d("FSBaseInputPopupWindow", 1, localStringBuilder.toString());
    if (this.e == 0)
    {
      this.e = ViewUtils.dip2px(250.0F);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mEmojiPanel initView() step2 :");
      localStringBuilder.append(this.e);
      QLog.d("FSBaseInputPopupWindow", 1, localStringBuilder.toString());
    }
    this.k = this.a.findViewById(2131429582);
    this.k.setOnClickListener(new FSBaseInputPopupWindow.2(this));
    this.p = ((InputMethodManager)((Context)this.n.get()).getSystemService("input_method"));
    this.a.setVisibility(4);
  }
  
  protected void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void dismiss()
  {
    b(this.c);
    super.dismiss();
  }
  
  protected void e()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  protected void f()
  {
    if (this.a != null)
    {
      this.s = new AlphaAnimation(0.0F, 1.0F);
      this.s.setDuration(200L);
      this.s.setAnimationListener(new FSBaseInputPopupWindow.3(this));
      this.a.setAnimation(this.s);
      this.s.start();
    }
  }
  
  public String g()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return "";
    }
    localObject = d(HostEmotionUtil.splash2Emo(QCircleHostTextBuilder.toPlainText(((CommentEditText)localObject).getText()).replaceAll(FSHardCodeUtil.a(2131903750), FSHardCodeUtil.a(2131903752)).replaceAll(FSHardCodeUtil.a(2131903749), "/MM").replaceAll(FSHardCodeUtil.a(2131914654), "/chigua")));
    List localList = this.t;
    if (localList != null) {
      localList.clear();
    }
    return ((String)localObject).trim();
  }
  
  protected Handler h()
  {
    if (this.r == null) {
      this.r = new Handler(Looper.getMainLooper());
    }
    return this.r;
  }
  
  public int i()
  {
    if (this.n.get() == null) {
      return 0;
    }
    int i1 = FSDisplayUtils.a((Context)this.n.get()) - this.e - ViewUtils.dip2px(95.0F);
    int n = i1;
    if (FSDisplayUtils.b((Context)this.n.get()))
    {
      int i2 = FSDisplayUtils.c((Context)this.n.get());
      n = i1 - i2;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInputLayoutLocationYOnScreen  NavigationBarHeight : ");
      localStringBuilder.append(i2);
      QLog.i("FSBaseInputPopupWindow", 1, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getInputLayoutLocationYOnScreen  yOnScreen : ");
    localStringBuilder.append(n);
    QLog.i("FSBaseInputPopupWindow", 1, localStringBuilder.toString());
    return n;
  }
  
  public void j()
  {
    if (this.n != null) {
      Context localContext = (Context)this.n.get();
    }
    if (this.n.get() != null) {
      HostSelectMemberUtils.onAtClick(getContext(), true, 1, 10, 256);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.l;
    if (paramDialogInterface != null)
    {
      paramDialogInterface.a();
      this.l = null;
    }
    this.h = false;
    paramDialogInterface = this.q;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow
 * JD-Core Version:    0.7.0.1
 */