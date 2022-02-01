package com.tencent.qqmini.sdk.widget;

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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.color;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.List;

@MiniKeep
public class MiniCustomDialog
  extends ReportDialog
{
  public static final int WHICH_CANCEL = 2;
  public static final int WHICH_NEGATIVE = 0;
  public static final int WHICH_POSITIVE = 1;
  private BaseAdapter adapter = new MiniCustomDialog.1(this);
  protected LinearLayout bodyLayout;
  CheckBox checkBox;
  TextView checkTxt;
  protected TextView countText;
  protected EditText dialogEdit;
  protected ImageView dialogImage;
  TextView dummyFirstPreviewImage;
  TextView editPicTag;
  View framePreview;
  public ImageView framePreviewImage;
  LayoutInflater inflater;
  String[] items;
  protected TextView lBtn;
  ListView list;
  private MiniCustomDialog.BrandColorManager mBrandColorManager = new MiniCustomDialog.BrandColorManager(null);
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
  public MiniCustomDialog(Context paramContext)
  {
    super(paramContext);
    super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  public MiniCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  protected MiniCustomDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
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
    MiniCustomDialog.2 local2 = new MiniCustomDialog.2(paramActivity);
    showPermissionSettingDialog(paramActivity, paramString1, paramString2, local2, local2, null);
  }
  
  public static void showPermissionSettingDialog(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = "权限申请";
    }
    localMiniCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = "需要权限设置，请前往系统设置中开启权限。";
    }
    localMiniCustomDialog.setMessage(paramActivity);
    localMiniCustomDialog.setNegativeButton("取消", paramOnClickListener1);
    localMiniCustomDialog.setPositiveButton("去设置", paramOnClickListener2);
    localMiniCustomDialog.setOnCancelListener(paramOnCancelListener);
    localMiniCustomDialog.show();
  }
  
  public MiniCustomDialog addCenterView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
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
  
  public MiniCustomDialog addView(View paramView)
  {
    this.text.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.countText.setVisibility(8);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public MiniCustomDialog addView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
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
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.dip2px(getContext(), paramFloat);
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
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.dip2px(getContext(), paramFloat2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(getContext(), paramFloat1);
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
    //   1: invokespecial 275	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	MiniCustomDialog
    //   5	2	1	localObject	Object
    //   8	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.getText().add(getContext().getString(R.string.mini_sdk_content_desc_dialog_hint));
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
  
  public ImageView getDialogImage()
  {
    return this.dialogImage;
  }
  
  protected int getDialogListItemLayout()
  {
    return R.layout.mini_sdk_custom_dialog_list_item;
  }
  
  public String getEditString()
  {
    Object localObject = this.dialogEdit;
    String str = null;
    if (localObject == null) {
      return null;
    }
    localObject = ((EditText)localObject).getText();
    if (localObject != null) {
      str = localObject.toString();
    }
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
    return (TextView)findViewById(R.id.dialogText_plain_text);
  }
  
  public int getRootViewHeight()
  {
    ViewGroup localViewGroup = this.rootView;
    if (localViewGroup == null) {
      return -1;
    }
    return localViewGroup.getMeasuredHeight();
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
  
  public void setBodyLayoutNoMargin()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, localLayoutParams.topMargin, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
  
  public MiniCustomDialog setCheckBox(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    findViewById(R.id.layout_check).setVisibility(0);
    this.checkTxt.setText(paramString);
    paramString = this.checkBox;
    if (paramString != null) {
      paramString.setOnCheckedChangeListener(new MiniCustomDialog.3(this, paramOnClickListener));
    }
    setSeperatorState();
    return this;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(R.id.dialogTitle));
    this.text = ((TextView)findViewById(R.id.dialogText));
    this.dialogImage = ((ImageView)findViewById(R.id.dialogImage));
    this.dialogEdit = ((EditText)findViewById(R.id.dialogEdit));
    this.countText = ((TextView)findViewById(R.id.dialogCountText));
    this.dummyFirstPreviewImage = ((TextView)findViewById(R.id.dummyfirstpreviewImage));
    this.previewImage = ((TextView)findViewById(R.id.previewImage));
    this.framePreviewImage = ((ImageView)findViewById(R.id.frame_preview_image));
    this.framePreview = findViewById(R.id.frame_preview);
    this.mVideoIcon = ((ImageView)findViewById(R.id.video_icon));
    this.mVideoSize = ((TextView)findViewById(R.id.longvideo_size));
    this.mVideoTime = ((TextView)findViewById(R.id.longvideo_time));
    this.lBtn = ((TextView)findViewById(R.id.dialogLeftBtn));
    this.rBtn = ((TextView)findViewById(R.id.dialogRightBtn));
    this.editPicTag = ((TextView)findViewById(R.id.dialogEditPicTag));
    this.progressBar = ((ProgressBar)findViewById(R.id.dialog_progress_bar));
    this.lBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(R.id.bodyLayout));
    this.checkBox = ((CheckBox)findViewById(R.id.tos_check));
    this.checkTxt = ((TextView)findViewById(R.id.txt_check));
    this.list = ((ListView)findViewById(R.id.list));
    this.rootView = ((ViewGroup)findViewById(R.id.dialogRoot));
    if ((this.list != null) && (Build.VERSION.SDK_INT >= 9)) {
      this.list.setOverScrollMode(2);
    }
    this.mBrandColorManager.setDialogBrandColorView(findViewById(R.id.dialogBrandBorder));
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
  
  public MiniCustomDialog setFirstDummyPreviewImage(Drawable paramDrawable)
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
  
  public MiniCustomDialog setImageOnClickListener(View.OnClickListener paramOnClickListener)
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
  
  public MiniCustomDialog setItems(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public MiniCustomDialog setItems(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public MiniCustomDialog setMessage(int paramInt)
  {
    this.text.setText(paramInt);
    this.text.setContentDescription(getContext().getString(paramInt));
    this.text.setVisibility(0);
    return this;
  }
  
  public MiniCustomDialog setMessage(CharSequence paramCharSequence)
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
  
  public MiniCustomDialog setMessageCount(String paramString)
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
  
  public MiniCustomDialog setMessageMaxLine(int paramInt)
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
  
  public MiniCustomDialog setMessageWithUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.text.setAutoLinkMask(1);
      this.text.setMovementMethod(LinkMovementMethod.getInstance());
      this.text.setText(paramString);
      this.text.setContentDescription(paramString);
      this.text.setLinkTextColor(getContext().getResources().getColor(R.color.mini_sdk_login_error_url));
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public MiniCustomDialog setMessageWithoutAutoLink(CharSequence paramCharSequence)
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
  
  public MiniCustomDialog setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
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
    localStringBuilder.append(getContext().getString(R.string.mini_sdk_content_desc_button));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new MiniCustomDialog.7(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public MiniCustomDialog setNegativeButton(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setTextColor(paramInt);
    return setNegativeButton(paramString, paramOnClickListener);
  }
  
  public MiniCustomDialog setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
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
    localStringBuilder.append(getContext().getString(R.string.mini_sdk_content_desc_button));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new MiniCustomDialog.4(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setNegativeButtonContentDescription(String paramString)
  {
    this.lBtn.setContentDescription(paramString);
  }
  
  public MiniCustomDialog setOperateImage(Drawable paramDrawable)
  {
    ImageView localImageView = this.operateImage;
    if (localImageView != null)
    {
      localImageView.setImageDrawable(paramDrawable);
      if (paramDrawable != null)
      {
        this.operateImage.setVisibility(8);
        return this;
      }
      this.operateImage.setVisibility(0);
    }
    return this;
  }
  
  public MiniCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new MiniCustomDialog.8(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public MiniCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
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
    localStringBuilder.append(getContext().getString(R.string.mini_sdk_content_desc_button));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new MiniCustomDialog.6(this, paramOnClickListener, paramBoolean));
    setSeperatorState();
    return this;
  }
  
  public MiniCustomDialog setPositiveButton(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setTextColor(paramInt);
    return setPositiveButton(paramString, paramOnClickListener);
  }
  
  public MiniCustomDialog setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
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
    localStringBuilder.append(getContext().getString(R.string.mini_sdk_content_desc_button));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new MiniCustomDialog.5(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setPositiveButtonContentDescription(String paramString)
  {
    this.rBtn.setContentDescription(paramString);
  }
  
  public MiniCustomDialog setPreviewImage(Drawable paramDrawable)
  {
    return setPreviewImage(paramDrawable, false, 0);
  }
  
  public MiniCustomDialog setPreviewImage(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    return setPreviewImage(paramDrawable, paramBoolean, paramInt, false);
  }
  
  public MiniCustomDialog setPreviewImage(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
        this.framePreview.setBackgroundResource(R.drawable.mini_sdk_forward_frame2pics);
        return this;
      }
      this.framePreview.setBackgroundResource(R.drawable.mini_sdk_forward_frame3pics);
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
  
  public MiniCustomDialog setPreviewImageScaleType(boolean paramBoolean)
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
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public MiniCustomDialog setText(String paramString, int paramInt)
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
  
  public MiniCustomDialog setTitle(String paramString)
  {
    if (paramString != null)
    {
      this.title.setText(paramString);
      this.text.setContentDescription(paramString);
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
    this.text.setContentDescription(getContext().getString(paramInt));
    this.title.setVisibility(0);
  }
  
  public void setTitleMutiLine()
  {
    this.title.setSingleLine(false);
  }
  
  public MiniCustomDialog setTitleWithEmo(CharSequence paramCharSequence)
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
  
  public MiniCustomDialog setVideoFormat(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    Object localObject = this.mVideoIcon;
    if (localObject != null) {
      if (paramBoolean1) {
        ((ImageView)localObject).setVisibility(0);
      } else if (!paramBoolean1) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    localObject = this.editPicTag;
    if (localObject != null) {
      if (paramBoolean2) {
        ((TextView)localObject).setVisibility(0);
      } else if (!paramBoolean2) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    if (this.mVideoSize != null) {
      if (!TextUtils.isEmpty(paramString1))
      {
        this.mVideoSize.setVisibility(0);
        this.mVideoSize.setText(paramString1);
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        this.mVideoSize.setVisibility(8);
      }
    }
    if (this.mVideoTime != null)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.mVideoTime.setVisibility(0);
        this.mVideoTime.setText(paramString2);
        return this;
      }
      if (TextUtils.isEmpty(paramString2)) {
        this.mVideoTime.setVisibility(8);
      }
    }
    return this;
  }
  
  public MiniCustomDialog setView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog
 * JD-Core Version:    0.7.0.1
 */