package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.OnTextOrFontChangeListener;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.topic.StateColorMovementMethod;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.RefreshListener;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

public class BaseSignViewHolder
  implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener, ETTextView.OnTextOrFontChangeListener, ISignViewHolder, ITopic.OnTopicClickListener
{
  static int[] jdField_a_of_type_ArrayOfInt;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ETTextView a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  BoxShadowLayout jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  SignatureTemplateInfo jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo;
  VasRes jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
  private VasResDrawable.RefreshListener jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$RefreshListener = new BaseSignViewHolder.1(this);
  VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseSignViewHolder.3(this);
  public Observer a;
  WeakReference<ISignViewHolder.OnClickListener> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  WeakReference<ITopic.OnTopicClickListener> jdField_b_of_type_MqqUtilWeakReference;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  public String c;
  boolean jdField_c_of_type_Boolean;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  public int f;
  int g;
  protected int h;
  protected int i;
  
  public BaseSignViewHolder(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    this.jdField_a_of_type_JavaUtilObserver = new BaseSignViewHolder.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout = ((BoxShadowLayout)paramView);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.h = AIOUtils.b(12.0F, paramContext.getResources());
    this.i = 2130846313;
    m();
    a();
    SignatureManagerForTool.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  private void m()
  {
    if (jdField_a_of_type_ArrayOfInt == null)
    {
      jdField_a_of_type_ArrayOfInt = new int[17];
      jdField_a_of_type_ArrayOfInt[0] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166493);
      jdField_a_of_type_ArrayOfInt[1] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166494);
      jdField_a_of_type_ArrayOfInt[2] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495);
      jdField_a_of_type_ArrayOfInt[3] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497);
      jdField_a_of_type_ArrayOfInt[4] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298532);
      jdField_a_of_type_ArrayOfInt[5] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298530);
      jdField_a_of_type_ArrayOfInt[6] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298531);
      jdField_a_of_type_ArrayOfInt[7] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298533);
      jdField_a_of_type_ArrayOfInt[8] = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[9] = AIOUtils.b(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[10] = AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[11] = AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[12] = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[13] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166496);
      jdField_a_of_type_ArrayOfInt[14] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166493);
      jdField_a_of_type_ArrayOfInt[15] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167408);
      jdField_a_of_type_ArrayOfInt[16] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394);
    }
  }
  
  private void n()
  {
    boolean bool4 = b();
    boolean bool5 = c();
    boolean bool6 = d();
    boolean bool7 = e();
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if (bool4)
    {
      localObject = TimeFormatterUtils.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time * 1000L);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
    int k;
    if (bool4) {
      k = 0;
    } else {
      k = 8;
    }
    ((SingleLineTextView)localObject).setVisibility(k);
    if (bool5)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText))
      {
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        bool1 = bool3;
      }
      else
      {
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
      }
    }
    else {
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if ((bool1) && (bool7)) {
      k = 0;
    } else {
      k = 8;
    }
    ((View)localObject).setVisibility(k);
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (bool6) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject).setVisibility(k);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (bool6) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject).setVisibility(k);
    j();
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    if (bool6) {
      k = jdField_a_of_type_ArrayOfInt[7];
    } else {
      k = 0;
    }
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = k;
    localObject = this.jdField_b_of_type_AndroidViewView;
    int j;
    if ((bool1 | bool6)) {
      bool1 = bool2;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
  }
  
  private void o()
  {
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject;
    if (j != 0) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.n;
    } else {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this, this.g);
    }
    if (!this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().equals(localObject)) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.n))) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.n;
      } else {
        localObject = "";
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(2);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add("");
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((CharSequence)localObject).toString());
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHint(2131699221);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166494));
    }
    else
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHint(null);
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText((CharSequence)localObject, 1, 20));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getViewTreeObserver().addOnPreDrawListener(this);
  }
  
  protected int a()
  {
    return -1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if (paramRichStatus == null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = a();
    paramRichStatus.signType = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.g;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if ((a()) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      b();
    } else {
      d();
    }
    c();
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  }
  
  protected SignatureTemplateInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return null;
    }
    return SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
  }
  
  protected CharSequence a(RichStatus paramRichStatus, ITopic.OnTopicClickListener paramOnTopicClickListener, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (!(localObject instanceof QQAppInterface)) {
      return "";
    }
    if (paramRichStatus == null) {
      return new SpannableString("");
    }
    StatusManager localStatusManager = (StatusManager)((AppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    SpannableString localSpannableString = new SpannableString(paramRichStatus.toSpannableStringWithoutAction(paramOnTopicClickListener));
    if ((paramRichStatus != null) && (localResources != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      localObject = paramRichStatus.actionText;
      paramOnTopicClickListener = (ITopic.OnTopicClickListener)localObject;
      if (!TextUtils.isEmpty(paramRichStatus.dataText))
      {
        paramOnTopicClickListener = new StringBuilder();
        paramOnTopicClickListener.append((String)localObject);
        paramOnTopicClickListener.append(paramRichStatus.dataText);
        paramOnTopicClickListener = paramOnTopicClickListener.toString();
      }
      Drawable localDrawable = localResources.getDrawable(2130849888);
      localObject = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (localStatusManager != null) {
        paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);
      } else {
        paramRichStatus = BitmapManager.a(localResources, 2130849881);
      }
      paramRichStatus = new StatableBitmapDrawable(localResources, paramRichStatus, false, false);
      paramRichStatus.setBounds(0, 0, paramInt, paramInt);
      int j = Color.parseColor("#ffa8a8a8");
      if ((Build.VERSION.SDK_INT >= 4) && (Build.VERSION.SDK_INT != 20)) {
        paramRichStatus = new SignatureActionSpan(paramRichStatus, 1, paramOnTopicClickListener, j, localDrawable, paramInt);
      } else {
        paramRichStatus = new SignatureActionSpan(paramRichStatus, 0, paramOnTopicClickListener, j, localDrawable, paramInt);
      }
      ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, 3, 17);
      return new QQText((CharSequence)localObject, 1);
    }
    return new QQText(localSpannableString, 1);
  }
  
  protected void a()
  {
    int j = b();
    int k = this.h;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    this.g = arrayOfInt[9];
    int m = arrayOfInt[11];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561489, null, false));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, j, k, jdField_a_of_type_ArrayOfInt[3]);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131376692);
    this.e = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131370238);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131370325);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131370326);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131365759);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131379924));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131379762));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369325));
    UIUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, m, m, m, m);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369557));
    UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, m, m, m, m);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131379883));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTextOrFontChangeListener(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMovementMethod(StateColorMovementMethod.a());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(ETTextView paramETTextView)
  {
    TopicUtil.a(paramETTextView, paramETTextView.getText(), 1);
  }
  
  public void a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    TopicUtil.a(paramETTextView, paramCharSequence, 0);
  }
  
  public void a(ISignViewHolder.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnClickListener);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(ITopic.OnTopicClickListener paramOnTopicClickListener)
  {
    if (paramOnTopicClickListener != null)
    {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramOnTopicClickListener);
      return;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    double d1 = Color.red(paramInt);
    Double.isNaN(d1);
    double d2 = Color.green(paramInt);
    Double.isNaN(d2);
    double d3 = Color.blue(paramInt);
    Double.isNaN(d3);
    return 1.0D - (d1 * 0.299D + d2 * 0.587D + d3 * 0.114D) / 255.0D >= 0.5D;
  }
  
  protected int b()
  {
    return jdField_a_of_type_ArrayOfInt[10];
  }
  
  public View b()
  {
    return this.e;
  }
  
  protected void b()
  {
    f();
    g();
    h();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    BoxShadowLayout localBoxShadowLayout = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
    if (localBoxShadowLayout != null) {
      localBoxShadowLayout.setScrolling(paramBoolean);
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() instanceof VasResDrawable))) {
      ((VasResDrawable)this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground()).a(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public View c()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void c()
  {
    o();
    n();
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void d()
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt[0];
    int k = arrayOfInt[1];
    int m = arrayOfInt[2];
    int n = arrayOfInt[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(n);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846313);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131377595, Integer.valueOf(-1));
    e();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(j);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(k);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(m);
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849995);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846310);
    a(true);
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt[4];
    int k = arrayOfInt[5];
    int m = arrayOfInt[6];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(m, j, m, k);
  }
  
  protected boolean e()
  {
    return false;
  }
  
  protected void f()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId;
    boolean bool = true;
    if (j == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(this.i);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      SignatureAdapter localSignatureAdapter = new SignatureAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.i);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(localSignatureAdapter);
      if (a() != -1) {
        bool = false;
      }
      localSignatureAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$RefreshListener);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(jdField_a_of_type_ArrayOfInt[8]);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131377595, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.f));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131377598, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId));
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    e();
  }
  
  protected void g()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId;
    int k = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType;
    if (j == 0)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(j, 0L);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes(this.jdField_a_of_type_ComTencentCommonAppAppInterface, j);
      localObject = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, this.jdField_a_of_type_ComTencentCommonAppAppInterface, k);
      ((SignatureFontAdapter)localObject).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.g, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction()) ^ true);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(a());
    }
    else
    {
      ((SignatureFontAdapter)((VasRes)localObject).a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.g, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction()) ^ true);
      ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(j, k);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131377596, Integer.valueOf(j));
  }
  
  protected void h()
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt[0];
    int k = arrayOfInt[1];
    int m = arrayOfInt[2];
    int n = arrayOfInt[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(n);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e)) {
      j = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e);
    }
    boolean bool = a(j);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(j);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(k);
    if (bool)
    {
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(m);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849995);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846310);
    }
    else
    {
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1711276033);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1711276033);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1711276033);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849996);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846311);
    }
    a(bool);
  }
  
  protected void i()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText)) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId != 0) {
        return;
      }
      int j = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount();
      int k = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getGravity();
      if ((j <= 1) && ((k & 0x3) == 3)) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(17);
      }
      for (;;)
      {
        bool = true;
        break label102;
        if ((j <= 1) || ((k & 0x3) == 3)) {
          break;
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(19);
      }
      boolean bool = false;
      label102:
      if (QLog.isColorLevel()) {
        QLog.i("BaseSignViewHolder", 2, String.format("resolveLineCountGravity line=%d set=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) }));
      }
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    boolean bool;
    if (this.f != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ImageView)localObject).setSelected(bool);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (this.f != 0) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131720342);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131720341);
      }
      localImageView.setContentDescription((CharSequence)localObject);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseSignViewHolder", 2, "destroy");
    }
    this.jdField_d_of_type_Boolean = true;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if ((localObject != null) && (((VasRes)localObject).a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a().b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
    if (localObject != null) {
      ((VasResDrawable)localObject).a();
    }
    SignatureManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void l()
  {
    if (QLog.isColorLevel())
    {
      RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (localRichStatus != null) {
        QLog.i("BaseSignViewHolder", 2, String.format("logRichStatus [tplId=%d fontId=%d fontType=%d] action[%d,%s] data[%d,%s] plainText=%s", new Object[] { Integer.valueOf(localRichStatus.tplId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText() }));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null) {
      localObject = (ISignViewHolder.OnClickListener)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    int j;
    switch (paramView.getId())
    {
    default: 
      j = 0;
      break;
    case 2131379883: 
      j = 2;
      break;
    case 2131377595: 
      j = 1;
      break;
    case 2131369557: 
      j = 4;
      break;
    case 2131369325: 
      j = 3;
    }
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick viewType=", Integer.valueOf(j) });
    if ((j > 0) && (localObject != null)) {
      ((ISignViewHolder.OnClickListener)localObject).a(paramView, j, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick topic=", paramITopic });
    Object localObject = this.jdField_b_of_type_MqqUtilWeakReference;
    if (localObject != null) {
      localObject = (ITopic.OnTopicClickListener)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((ITopic.OnTopicClickListener)localObject).onClick(paramITopic, paramView);
    }
  }
  
  public boolean onPreDraw()
  {
    i();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
 * JD-Core Version:    0.7.0.1
 */