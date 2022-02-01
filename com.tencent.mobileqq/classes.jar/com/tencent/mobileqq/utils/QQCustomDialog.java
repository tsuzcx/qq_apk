package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.simpleui.SimpleUIFixHelper;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import java.util.List;

public class QQCustomDialog
  extends ReportDialog
{
  public static final int WHICH_CANCEL = 2;
  public static final int WHICH_NEGATIVE = 0;
  public static final int WHICH_POSITIVE = 1;
  private BaseAdapter adapter = new QQCustomDialog.1(this);
  protected LinearLayout bodyLayout;
  CheckBox checkBox;
  TextView checkTxt;
  protected TextView countText;
  protected EditText dialogEdit;
  TextView dummyFirstPreviewImage;
  TextView editPicTag;
  View framePreview;
  public ImageView framePreviewImage;
  LayoutInflater inflater;
  String[] items;
  protected TextView lBtn;
  ListView list;
  private QQCustomDialog.BrandColorManager mBrandColorManager = new QQCustomDialog.BrandColorManager(null);
  FormSwitchItem mSwitch;
  private ImageView mVideoIcon;
  private TextView mVideoSize;
  private TextView mVideoTime;
  DialogInterface.OnClickListener onArrayItemClick;
  ImageView operateImage;
  TextView previewImage;
  ProgressBar progressBar;
  protected TextView rBtn;
  ViewGroup rootView;
  Object tag;
  protected TextView text;
  protected TextView title;
  
  @TargetApi(14)
  public QQCustomDialog(Context paramContext)
  {
    super(paramContext);
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  public QQCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  protected QQCustomDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  public static void showPermissionSettingDialog(Activity paramActivity, String paramString)
  {
    showPermissionSettingDialog(paramActivity, null, paramString);
  }
  
  public static void showPermissionSettingDialog(Activity paramActivity, String paramString1, String paramString2)
  {
    QQCustomDialog.10 local10 = new QQCustomDialog.10(paramActivity);
    showPermissionSettingDialog(paramActivity, paramString1, paramString2, local10, local10, null);
  }
  
  public static void showPermissionSettingDialog(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramActivity, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton(2131887648, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(2131892267, paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = QQUIDelegate.a(2131907863);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = QQUIDelegate.a(2131907856);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setNegativeButton(QQUIDelegate.a(2131898212), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(QQUIDelegate.a(2131907848), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
  }
  
  public QQCustomDialog addCenterView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.text.setVisibility(8);
    this.countText.setVisibility(8);
    this.bodyLayout.addView(paramView, paramLayoutParams);
    this.bodyLayout.setGravity(17);
    return this;
  }
  
  public void addPreviewView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = this.rootView;
    if (localObject == null) {
      return;
    }
    int i = 0;
    int j = ((ViewGroup)localObject).getChildCount();
    while (i < j)
    {
      localObject = this.rootView.getChildAt(i);
      if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
        ((View)localObject).setVisibility(4);
      }
      i += 1;
    }
    this.rootView.addView(paramView);
    paramView.setTag(Integer.valueOf(1001));
  }
  
  public QQCustomDialog addView(View paramView)
  {
    this.text.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.countText.setVisibility(8);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public QQCustomDialog addView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.text.setVisibility(8);
    this.countText.setVisibility(8);
    this.bodyLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public void adjustMessageBottomMargin(float paramFloat)
  {
    Object localObject = this.bodyLayout;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = QQUIDelegate.a(getContext(), paramFloat);
      this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void adjustMessageLayout(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.text.getLineCount() > 1)
      {
        this.text.setGravity(3);
        return;
      }
      this.text.setGravity(17);
      return;
    }
    this.text.setGravity(3);
  }
  
  public void adjustMessageTopBottomMargin(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.bodyLayout;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = QQUIDelegate.a(getContext(), paramFloat2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = QQUIDelegate.a(getContext(), paramFloat1);
      this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void adjustTitle()
  {
    this.title.setGravity(3);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 280	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 285	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 285	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	QQCustomDialog
    //   9	6	1	localObject	Object
    //   16	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
  }
  
  public void dismissMessage()
  {
    LinearLayout localLinearLayout = this.bodyLayout;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.getText().add(getContext().getString(2131888064));
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public TextView getBtnLeft()
  {
    return this.lBtn;
  }
  
  public TextView getBtnight()
  {
    return this.rBtn;
  }
  
  public boolean getCheckBoxState()
  {
    CheckBox localCheckBox = this.checkBox;
    if ((localCheckBox != null) && (localCheckBox.getVisibility() == 0)) {
      return this.checkBox.isChecked();
    }
    return false;
  }
  
  protected int getDialogListItemLayout()
  {
    return 2131624599;
  }
  
  public String getEditString()
  {
    Object localObject = this.dialogEdit;
    if (localObject == null) {
      return null;
    }
    String str = ((EditText)localObject).getText().toString();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.dialogEdit.getHint().toString();
    }
    return localObject;
  }
  
  public EditText getEditText()
  {
    return null;
  }
  
  public String getInputValue()
  {
    return null;
  }
  
  public TextView getMessageTextView()
  {
    return this.text;
  }
  
  public TextView getMessageTextView_Plain_Text()
  {
    return (TextView)findViewById(2131431878);
  }
  
  public ViewGroup getRootView()
  {
    return this.rootView;
  }
  
  public int getRootViewHeight()
  {
    ViewGroup localViewGroup = this.rootView;
    if (localViewGroup == null) {
      return -1;
    }
    return localViewGroup.getMeasuredHeight();
  }
  
  public boolean getSwitchState()
  {
    FormSwitchItem localFormSwitchItem = this.mSwitch;
    if ((localFormSwitchItem != null) && (localFormSwitchItem.getVisibility() == 0)) {
      return this.mSwitch.a();
    }
    return false;
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public TextView getTitleTextView()
  {
    return this.title;
  }
  
  public boolean hasPreViewInDialog()
  {
    Object localObject = this.rootView;
    if (localObject == null) {
      return false;
    }
    int i = ((ViewGroup)localObject).getChildCount() - 1;
    if (i < 0) {
      return false;
    }
    localObject = this.rootView.getChildAt(i);
    if (localObject == null) {
      return false;
    }
    return ((((View)localObject).getTag() instanceof Integer)) && (((Integer)((View)localObject).getTag()).intValue() == 1001);
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.dialogEdit != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.dialogEdit.getWindowToken(), 0);
    }
  }
  
  public void removePreviewView()
  {
    Object localObject = this.rootView;
    if (localObject == null) {
      return;
    }
    int i = ((ViewGroup)localObject).getChildCount() - 1;
    if (i >= 0) {
      this.rootView.removeViewAt(i);
    }
    i -= 1;
    while (i >= 0)
    {
      localObject = this.rootView.getChildAt(i);
      if (localObject != null)
      {
        if (((((View)localObject).getTag() instanceof Integer)) && (((Integer)((View)localObject).getTag()).intValue() == 1001))
        {
          ((View)localObject).setVisibility(0);
          return;
        }
        ((View)localObject).setVisibility(0);
      }
      i -= 1;
    }
  }
  
  public void setBackground(int paramInt)
  {
    ViewGroup localViewGroup = this.rootView;
    if (localViewGroup != null) {
      localViewGroup.setBackgroundResource(paramInt);
    }
  }
  
  public void setBodyLayoutNoMargin()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, localLayoutParams.topMargin, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
  
  public QQCustomDialog setCheckBox(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    return setCheckBox(paramString, true, paramOnClickListener);
  }
  
  public QQCustomDialog setCheckBox(String paramString, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    findViewById(2131436895).setVisibility(0);
    this.checkTxt.setText(paramString);
    paramString = this.checkBox;
    if (paramString != null)
    {
      paramString.setChecked(paramBoolean);
      this.checkBox.setOnCheckedChangeListener(new QQCustomDialog.3(this, paramOnClickListener));
    }
    setSeperatorState();
    return this;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131431880));
    this.text = ((TextView)findViewById(2131431876));
    this.dialogEdit = ((EditText)findViewById(2131431859));
    this.countText = ((TextView)findViewById(2131431852));
    this.dummyFirstPreviewImage = ((TextView)findViewById(2131432265));
    this.previewImage = ((TextView)findViewById(2131440611));
    this.operateImage = ((ImageView)findViewById(2131439615));
    this.framePreviewImage = ((ImageView)findViewById(2131433674));
    this.framePreview = findViewById(2131433673);
    this.mVideoIcon = ((ImageView)findViewById(2131449607));
    this.mVideoSize = ((TextView)findViewById(2131437750));
    this.mVideoTime = ((TextView)findViewById(2131437751));
    this.lBtn = ((TextView)findViewById(2131431864));
    this.rBtn = ((TextView)findViewById(2131431870));
    this.editPicTag = ((TextView)findViewById(2131431860));
    this.progressBar = ((ProgressBar)findViewById(2131431906));
    this.lBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(2131429603));
    this.checkBox = ((CheckBox)findViewById(2131447782));
    this.mSwitch = ((FormSwitchItem)findViewById(2131447784));
    this.checkTxt = ((TextView)findViewById(2131448922));
    this.list = ((ListView)findViewById(2131437272));
    this.rootView = ((ViewGroup)findViewById(2131431871));
    if ((this.list != null) && (Build.VERSION.SDK_INT >= 9)) {
      this.list.setOverScrollMode(2);
    }
    this.mBrandColorManager.a(findViewById(2131431835));
    SimpleUIFixHelper.a(this);
    SimpleUIFixHelper.b(this);
  }
  
  public void setEditLint(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.dialogEdit.getVisibility() != 0) {
        this.dialogEdit.setVisibility(0);
      }
      this.dialogEdit.setHint(paramString);
      return;
    }
    this.dialogEdit.setVisibility(8);
  }
  
  public QQCustomDialog setFirstDummyPreviewImage(Drawable paramDrawable)
  {
    this.dummyFirstPreviewImage.setPadding(0, 0, 0, 0);
    this.dummyFirstPreviewImage.setCompoundDrawablePadding(0);
    this.dummyFirstPreviewImage.setCompoundDrawables(null, null, null, paramDrawable);
    if (paramDrawable != null)
    {
      this.dummyFirstPreviewImage.setVisibility(0);
      return this;
    }
    this.dummyFirstPreviewImage.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setImageOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      ImageView localImageView = this.framePreviewImage;
      if (localImageView != null)
      {
        localImageView.setOnClickListener(paramOnClickListener);
        this.countText.setVisibility(8);
      }
    }
    return this;
  }
  
  public QQCustomDialog setItems(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    String[] arrayOfString2;
    try
    {
      String[] arrayOfString1 = getContext().getResources().getStringArray(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      localNotFoundException.printStackTrace();
      arrayOfString2 = null;
    }
    return setItems(arrayOfString2, paramOnClickListener);
  }
  
  public QQCustomDialog setItems(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.items = paramArrayOfString;
    this.text.setVisibility(8);
    this.countText.setVisibility(8);
    this.lBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout.setVisibility(8);
    this.onArrayItemClick = paramOnClickListener;
    this.list.setVisibility(0);
    this.list.setAdapter(this.adapter);
    this.list.setDivider(null);
    this.list.setDividerHeight(0);
    return this;
  }
  
  public QQCustomDialog setMessage(int paramInt)
  {
    this.text.setText(paramInt);
    this.text.setContentDescription(getContext().getString(paramInt));
    this.text.setVisibility(0);
    return this;
  }
  
  public QQCustomDialog setMessage(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.text.setText(paramCharSequence);
      this.text.setContentDescription(paramCharSequence);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setMessageCount(String paramString)
  {
    if (paramString != null)
    {
      this.countText.setText(paramString);
      this.countText.setContentDescription(paramString);
      this.countText.setVisibility(0);
      return this;
    }
    this.countText.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setMessageMaxLine(int paramInt)
  {
    TextView localTextView = this.text;
    if (localTextView != null)
    {
      localTextView.setMaxLines(paramInt);
      this.text.setEllipsize(TextUtils.TruncateAt.END);
    }
    return this;
  }
  
  public void setMessageTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getContext().getResources().getColorStateList(paramInt);
    TextView localTextView = this.text;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      this.text.setTextColor(localColorStateList);
    }
  }
  
  public void setMessageTextSize(float paramFloat)
  {
    TextView localTextView = this.text;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      this.text.setTextSize(paramFloat);
    }
  }
  
  public QQCustomDialog setMessageWithEmo(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.text.setText(new QQText(paramString, 3));
      this.text.setContentDescription(paramString);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setMessageWithUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.text.setAutoLinkMask(1);
      this.text.setMovementMethod(LinkMovementMethod.getInstance());
      this.text.setText(paramString);
      this.text.setContentDescription(paramString);
      this.text.setLinkTextColor(getContext().getResources().getColor(2131166411));
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setMessageWithoutAutoLink(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.text.setMovementMethod(LinkMovementMethod.getInstance());
      this.text.setText(paramCharSequence);
      this.text.setContentDescription(paramCharSequence);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setMsgMaxLineWithEnd(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView = this.text;
    if (localTextView != null)
    {
      localTextView.setMaxLines(paramInt);
      this.text.getViewTreeObserver().addOnGlobalLayoutListener(new QQCustomDialog.2(this, paramInt, paramString, paramBoolean1, paramBoolean2));
    }
    return this;
  }
  
  public QQCustomDialog setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialog.8(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setNegativeButton(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setTextColor(paramInt);
    return setNegativeButton(paramString, paramOnClickListener);
  }
  
  public QQCustomDialog setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialog.5(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setNegativeButtonContentDescription(String paramString)
  {
    this.lBtn.setContentDescription(paramString);
  }
  
  public QQCustomDialog setOperateImage(Drawable paramDrawable)
  {
    ImageView localImageView = this.operateImage;
    if (localImageView != null)
    {
      localImageView.setImageDrawable(paramDrawable);
      if (paramDrawable != null)
      {
        this.operateImage.setVisibility(0);
        paramDrawable = this.operateImage;
        if (paramDrawable != null)
        {
          paramDrawable.setVisibility(8);
          return this;
        }
      }
      else
      {
        this.operateImage.setVisibility(8);
        paramDrawable = this.operateImage;
        if (paramDrawable != null) {
          paramDrawable.setVisibility(0);
        }
      }
    }
    return this;
  }
  
  public QQCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialog.9(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    TextView localTextView = this.rBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialog.7(this, paramOnClickListener, paramBoolean));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPositiveButton(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setTextColor(paramInt);
    return setPositiveButton(paramString, paramOnClickListener);
  }
  
  public QQCustomDialog setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    TextView localTextView = this.rBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialog.6(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setPositiveButtonContentDescription(String paramString)
  {
    this.rBtn.setContentDescription(paramString);
  }
  
  public QQCustomDialog setPreviewFixDimension(int paramInt1, int paramInt2)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.framePreview.getLayoutParams();
    localMarginLayoutParams.width = paramInt1;
    localMarginLayoutParams.height = paramInt2;
    localMarginLayoutParams.topMargin = QQUIDelegate.a(getContext(), 12.0F);
    this.framePreviewImage.getLayoutParams().width = paramInt1;
    this.framePreviewImage.getLayoutParams().height = paramInt2;
    return this;
  }
  
  public QQCustomDialog setPreviewImage(Drawable paramDrawable)
  {
    return setPreviewImage(paramDrawable, false, 0);
  }
  
  public QQCustomDialog setPreviewImage(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    return setPreviewImage(paramDrawable, paramBoolean, paramInt, false);
  }
  
  public QQCustomDialog setPreviewImage(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramDrawable == null) {
      return this;
    }
    if (paramBoolean1)
    {
      this.framePreview.setVisibility(0);
      this.previewImage.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams;
      if (!paramBoolean2)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.framePreviewImage.setLayoutParams(localLayoutParams);
      }
      else
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.framePreviewImage.setLayoutParams(localLayoutParams);
      }
      this.framePreviewImage.setImageDrawable(paramDrawable);
      if (paramInt < 2)
      {
        this.framePreview.setBackgroundDrawable(null);
        return this;
      }
      if (paramInt == 2)
      {
        this.framePreview.setBackgroundResource(2130840455);
        return this;
      }
      this.framePreview.setBackgroundResource(2130840456);
      return this;
    }
    this.framePreview.setVisibility(8);
    this.previewImage.setVisibility(0);
    this.previewImage.setCompoundDrawablePadding(0);
    this.previewImage.setCompoundDrawables(paramDrawable, null, null, null);
    if (paramDrawable != null)
    {
      this.previewImage.setVisibility(0);
      return this;
    }
    this.previewImage.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setPreviewImageScaleType(boolean paramBoolean)
  {
    ImageView localImageView = this.framePreviewImage;
    ImageView.ScaleType localScaleType;
    if (paramBoolean) {
      localScaleType = ImageView.ScaleType.CENTER_INSIDE;
    } else {
      localScaleType = ImageView.ScaleType.CENTER_CROP;
    }
    localImageView.setScaleType(localScaleType);
    return this;
  }
  
  public void setProgress(int paramInt)
  {
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
  }
  
  public void setProgressBarVisibility(int paramInt)
  {
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(paramInt);
    }
  }
  
  protected void setSeperatorState() {}
  
  public QQCustomDialog setSwitch(String paramString, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    FormSwitchItem localFormSwitchItem = this.mSwitch;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setVisibility(0);
      this.mSwitch.setText(paramString);
      this.mSwitch.setChecked(paramBoolean);
      if (paramOnClickListener != null) {
        this.mSwitch.setOnCheckedChangeListener(new QQCustomDialog.4(this, paramOnClickListener));
      }
    }
    return this;
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public QQCustomDialog setText(String paramString, int paramInt)
  {
    if ((findViewById(paramInt) instanceof TextView))
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
    }
    return this;
  }
  
  public void setTextContentDescription(String paramString)
  {
    this.text.setContentDescription(paramString);
  }
  
  public QQCustomDialog setTitle(String paramString)
  {
    if (paramString != null)
    {
      this.title.setText(paramString);
      this.title.setContentDescription(paramString);
      this.title.setVisibility(0);
      paramString = this.items;
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public void setTitle(int paramInt)
  {
    this.title.setText(paramInt);
    this.title.setVisibility(0);
  }
  
  public void setTitleMutiLine()
  {
    this.title.setSingleLine(false);
  }
  
  public QQCustomDialog setTitleWithEmo(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.title.setText(paramCharSequence);
      this.title.setVisibility(0);
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setVideoFormat(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.mVideoIcon;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        break label46;
      }
    }
    if (!paramBoolean1)
    {
      localObject = this.mVideoIcon;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    label46:
    if (paramBoolean2)
    {
      localObject = this.editPicTag;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        break label92;
      }
    }
    if (!paramBoolean2)
    {
      localObject = this.editPicTag;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    label92:
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = this.mVideoSize;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        this.mVideoSize.setText(paramString1);
        break label149;
      }
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = this.mVideoSize;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
    }
    label149:
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = this.mVideoTime;
      if (paramString1 != null)
      {
        paramString1.setVisibility(0);
        this.mVideoTime.setText(paramString2);
        return this;
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = this.mVideoTime;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
    }
    return this;
  }
  
  public QQCustomDialog setView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog
 * JD-Core Version:    0.7.0.1
 */