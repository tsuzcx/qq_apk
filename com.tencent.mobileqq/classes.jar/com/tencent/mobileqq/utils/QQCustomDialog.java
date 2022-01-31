package com.tencent.mobileqq.utils;

import akdw;
import akdx;
import akdy;
import akdz;
import akea;
import akeb;
import akec;
import aked;
import akee;
import akef;
import android.annotation.TargetApi;
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
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.ListView;
import java.util.List;

public class QQCustomDialog
  extends Dialog
{
  public static final int WHICH_NEGATIVE = 0;
  public static final int WHICH_POSITIVE = 1;
  private BaseAdapter adapter = new akdw(this);
  public LinearLayout bodyLayout;
  CheckBox checkBox;
  TextView checkTxt;
  protected TextView countText;
  TextView dummyFirstPreviewImage;
  TextView editPicTag;
  View framePreview;
  public ImageView framePreviewImage;
  public LayoutInflater inflater;
  public String[] items;
  public TextView lBtn;
  ListView list;
  private akef mBrandColorManager = new akef(null);
  FormSwitchItem mSwitch;
  private ImageView mVideoIcon;
  private TextView mVideoSize;
  private TextView mVideoTime;
  public DialogInterface.OnClickListener onArrayItemClick;
  ImageView operateImage;
  TextView previewImage;
  ProgressBar progressBar;
  public TextView rBtn;
  Object tag;
  public TextView text;
  public TextView title;
  
  @TargetApi(14)
  public QQCustomDialog(Context paramContext)
  {
    super(paramContext);
    super.getWindow().setWindowAnimations(2131624572);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  public QQCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131624572);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  public QQCustomDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    super.getWindow().setWindowAnimations(2131624572);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
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
    if (this.bodyLayout != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
      localLayoutParams.bottomMargin = ScreenUtil.a(paramFloat);
      this.bodyLayout.setLayoutParams(localLayoutParams);
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
  
  public void adjustTitle()
  {
    this.title.setGravity(3);
  }
  
  public int customWhichToCallBack(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 164	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 169	com/tencent/mfsdk/LeakInspector/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 169	com/tencent/mfsdk/LeakInspector/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 169	com/tencent/mfsdk/LeakInspector/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	QQCustomDialog
    //   9	1	1	localException	java.lang.Exception
    //   15	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.getText().add(getContext().getString(2131427460));
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
    if ((this.checkBox != null) && (this.checkBox.getVisibility() == 0)) {
      return this.checkBox.isChecked();
    }
    return false;
  }
  
  public int getDialogListItemLayout()
  {
    return 2130968846;
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
    return (TextView)findViewById(2131364061);
  }
  
  public boolean getSwitchState()
  {
    if ((this.mSwitch != null) && (this.mSwitch.getVisibility() == 0)) {
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
  
  public void setBodyLayoutNoMargin()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, localLayoutParams.topMargin, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
  
  public QQCustomDialog setCheckBox(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    findViewById(2131364053).setVisibility(0);
    this.checkTxt.setText(paramString);
    if (this.checkBox != null) {
      this.checkBox.setOnCheckedChangeListener(new akdy(this, paramOnClickListener));
    }
    setSeperatorState();
    return this;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131364034));
    this.text = ((TextView)findViewById(2131362776));
    this.countText = ((TextView)findViewById(2131364051));
    this.dummyFirstPreviewImage = ((TextView)findViewById(2131364047));
    this.previewImage = ((TextView)findViewById(2131364048));
    this.operateImage = ((ImageView)findViewById(2131364069));
    this.framePreviewImage = ((ImageView)findViewById(2131364050));
    this.framePreview = findViewById(2131364049);
    this.mVideoIcon = ((ImageView)findViewById(2131363544));
    this.mVideoSize = ((TextView)findViewById(2131364063));
    this.mVideoTime = ((TextView)findViewById(2131364064));
    this.lBtn = ((TextView)findViewById(2131364037));
    this.rBtn = ((TextView)findViewById(2131364038));
    this.editPicTag = ((TextView)findViewById(2131364062));
    this.progressBar = ((ProgressBar)findViewById(2131364060));
    this.lBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(2131363794));
    this.checkBox = ((CheckBox)findViewById(2131364065));
    this.mSwitch = ((FormSwitchItem)findViewById(2131364066));
    this.checkTxt = ((TextView)findViewById(2131364054));
    this.list = ((ListView)findViewById(2131364045));
    if ((this.list != null) && (Build.VERSION.SDK_INT >= 9)) {
      this.list.setOverScrollMode(2);
    }
    this.mBrandColorManager.a(findViewById(2131364033));
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
    if ((paramOnClickListener != null) && (this.framePreviewImage != null))
    {
      this.framePreviewImage.setOnClickListener(paramOnClickListener);
      this.editPicTag.setVisibility(0);
      this.countText.setVisibility(8);
    }
    return this;
  }
  
  public QQCustomDialog setItems(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = null;
    try
    {
      String[] arrayOfString = getContext().getResources().getStringArray(paramInt);
      localObject = arrayOfString;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        localNotFoundException.printStackTrace();
      }
    }
    return setItems(localObject, paramOnClickListener);
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
    if (this.text != null)
    {
      this.text.setMaxLines(paramInt);
      this.text.setEllipsize(TextUtils.TruncateAt.END);
    }
    return this;
  }
  
  public void setMessageTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getContext().getResources().getColorStateList(paramInt);
    if ((this.text != null) && (this.text.getVisibility() == 0)) {
      this.text.setTextColor(localColorStateList);
    }
  }
  
  public void setMessageTextSize(float paramFloat)
  {
    if ((this.text != null) && (this.text.getVisibility() == 0)) {
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
      this.text.setLinkTextColor(getContext().getResources().getColor(2131493045));
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
  
  public QQCustomDialog setMsgMaxLineWithEnd(String paramString, int paramInt)
  {
    if (this.text != null)
    {
      this.text.setMaxLines(paramInt);
      this.text.getViewTreeObserver().addOnGlobalLayoutListener(new akdx(this, paramInt, paramString));
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
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131427457));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new aked(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setContentDescription(paramString + getContext().getString(2131427457));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new akea(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setNegativeButtonContentDescription(String paramString)
  {
    this.lBtn.setContentDescription(paramString);
  }
  
  public QQCustomDialog setOperateImage(Drawable paramDrawable)
  {
    if (this.operateImage != null)
    {
      this.operateImage.setImageDrawable(paramDrawable);
      if (paramDrawable == null) {
        break label45;
      }
      this.operateImage.setVisibility(0);
      if (this.operateImage != null) {
        this.operateImage.setVisibility(8);
      }
    }
    label45:
    do
    {
      return this;
      this.operateImage.setVisibility(8);
    } while (this.operateImage == null);
    this.operateImage.setVisibility(0);
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
    this.rBtn.setOnClickListener(new akee(this, paramOnClickListener));
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
    this.rBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131427457));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new akec(this, paramOnClickListener, paramBoolean));
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
    this.rBtn.setContentDescription(paramString + getContext().getString(2131427457));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new akeb(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setPositiveButtonContentDescription(String paramString)
  {
    this.rBtn.setContentDescription(paramString);
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
      for (;;)
      {
        this.framePreviewImage.setImageDrawable(paramDrawable);
        if (paramInt >= 2) {
          break;
        }
        this.framePreview.setBackgroundDrawable(null);
        return this;
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.framePreviewImage.setLayoutParams(localLayoutParams);
      }
      if (paramInt == 2)
      {
        this.framePreview.setBackgroundResource(2130839090);
        return this;
      }
      this.framePreview.setBackgroundResource(2130839091);
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
    if (paramBoolean) {}
    for (ImageView.ScaleType localScaleType = ImageView.ScaleType.CENTER_INSIDE;; localScaleType = ImageView.ScaleType.CENTER_CROP)
    {
      localImageView.setScaleType(localScaleType);
      return this;
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (this.progressBar != null) {
      this.progressBar.setProgress(paramInt);
    }
  }
  
  public void setProgressBarVisibility(int paramInt)
  {
    if (this.progressBar != null) {
      this.progressBar.setVisibility(paramInt);
    }
  }
  
  public void setSeperatorState() {}
  
  public QQCustomDialog setSwitch(String paramString, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.mSwitch != null)
    {
      this.mSwitch.setVisibility(0);
      this.mSwitch.setText(paramString);
      this.mSwitch.setChecked(paramBoolean);
      if (paramOnClickListener != null) {
        this.mSwitch.setOnCheckedChangeListener(new akdz(this, paramOnClickListener));
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
      this.text.setContentDescription(paramString);
      this.title.setVisibility(0);
      if (this.items == null) {}
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public void setTitle(int paramInt)
  {
    this.title.setText(paramInt);
    this.text.setContentDescription(getContext().getString(paramInt));
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
      this.text.setContentDescription(paramCharSequence);
      this.title.setVisibility(0);
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setVideoFormat(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if ((paramBoolean1) && (this.mVideoIcon != null))
    {
      this.mVideoIcon.setVisibility(0);
      if ((!paramBoolean2) || (this.editPicTag == null)) {
        break label125;
      }
      this.editPicTag.setVisibility(0);
      label38:
      if ((TextUtils.isEmpty(paramString1)) || (this.mVideoSize == null)) {
        break label148;
      }
      this.mVideoSize.setVisibility(0);
      this.mVideoSize.setText(paramString1);
      label68:
      if ((TextUtils.isEmpty(paramString2)) || (this.mVideoTime == null)) {
        break label174;
      }
      this.mVideoTime.setVisibility(0);
      this.mVideoTime.setText(paramString2);
    }
    label125:
    while ((!TextUtils.isEmpty(paramString2)) || (this.mVideoTime == null))
    {
      return this;
      if ((paramBoolean1) || (this.mVideoIcon == null)) {
        break;
      }
      this.mVideoIcon.setVisibility(8);
      break;
      if ((paramBoolean2) || (this.editPicTag == null)) {
        break label38;
      }
      this.editPicTag.setVisibility(8);
      break label38;
      if ((!TextUtils.isEmpty(paramString1)) || (this.mVideoSize == null)) {
        break label68;
      }
      this.mVideoSize.setVisibility(8);
      break label68;
    }
    label148:
    label174:
    this.mVideoTime.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog
 * JD-Core Version:    0.7.0.1
 */