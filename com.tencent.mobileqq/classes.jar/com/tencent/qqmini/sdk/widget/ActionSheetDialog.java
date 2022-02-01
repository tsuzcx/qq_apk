package com.tencent.qqmini.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.color;
import com.tencent.qqmini.sdk.R.dimen;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;

public class ActionSheetDialog
  extends ReportDialog
  implements DialogInterface.OnCancelListener
{
  public static final int BUTTON_ADD_IMAGE = 2;
  public static final int BUTTON_DELETE = 1;
  public static final int BUTTON_NORMAL = 0;
  public static final int BUTTON_TITLE = 3;
  private TranslateAnimation animation;
  private RelativeLayout backgroundLayout;
  private int buttonCount = 0;
  private ArrayList<Button> buttonsList = new ArrayList();
  private View.OnClickListener cancelListener = null;
  private LinearLayout customButtonContainer;
  private Handler handler;
  private boolean mCancelButtonHasAdd = false;
  private LinearLayout mContainer;
  private Context mContext;
  private View.OnClickListener mDefaultDismissListener = new ActionSheetDialog.1(this);
  private boolean mDismissFinish = true;
  private LayoutInflater mInflater;
  private boolean mNeedInitContentView = true;
  
  public ActionSheetDialog(Context paramContext)
  {
    this(paramContext, R.style.mini_sdk_MenuDialogStyle);
  }
  
  public ActionSheetDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    setTransparentStatusBar();
    this.mInflater = LayoutInflater.from(paramContext);
    setContentView(R.layout.mini_sdk_action_sheet);
    init();
    bindEvents();
  }
  
  private void bindEvents()
  {
    this.handler = new Handler(Looper.getMainLooper());
  }
  
  private int getBackgroundId(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 == 1)) {
      return R.drawable.mini_sdk_actionsheet_single;
    }
    if ((paramInt2 == 0) && (paramInt1 > 1)) {
      return R.drawable.mini_sdk_actionsheet_top;
    }
    if ((paramInt2 == paramInt1 - 1) && (paramInt1 > 1)) {
      return R.drawable.mini_sdk_actionsheet_bottom;
    }
    return R.drawable.mini_sdk_actionsheet_middle;
  }
  
  private void init()
  {
    this.customButtonContainer = ((LinearLayout)findViewById(R.id.customButtonContainer));
    this.mContainer = ((LinearLayout)findViewById(R.id.mContainer));
    this.backgroundLayout = ((RelativeLayout)findViewById(R.id.background));
  }
  
  private void prepareContentViews()
  {
    if (!this.mNeedInitContentView) {
      return;
    }
    int k = this.buttonsList.size();
    int j = 0;
    Object localObject1;
    Object localObject2;
    if (j < k)
    {
      localObject1 = (Button)this.buttonsList.get(j);
      int i = ((Integer)((Button)localObject1).getTag()).intValue();
      int m = R.drawable.mini_sdk_actionsheet_single;
      m = getBackgroundId(k, j);
      switch (i)
      {
      default: 
        i = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_blue);
      }
      for (;;)
      {
        ((Button)localObject1).setBackgroundResource(m);
        ((Button)localObject1).setTextColor(i);
        j += 1;
        break;
        i = -16777216;
        ((Button)localObject1).setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS3));
        ((Button)localObject1).setClickable(false);
        ((Button)localObject1).setVisibility(8);
        addTitle(((Button)localObject1).getText().toString());
        continue;
        i = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_red);
        continue;
        DisplayUtil.dip2px(getContext(), 8.0F);
        i = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_blue);
        localObject2 = new SpannableString(((Button)localObject1).getText());
        Object localObject3 = this.mContext.getResources().getDrawable(R.drawable.mini_sdk_ys_huangzuan);
        ((Drawable)localObject3).setBounds(0, 0, ((Drawable)localObject3).getIntrinsicWidth(), ((Drawable)localObject3).getIntrinsicHeight());
        localObject3 = new ImageSpan((Drawable)localObject3, 1);
        if ((((SpannableString)localObject2).length() >= 1) && (((SpannableString)localObject2).charAt(((SpannableString)localObject2).length() - 1) == '@')) {
          ((SpannableString)localObject2).setSpan(localObject3, ((SpannableString)localObject2).length() - 1, ((SpannableString)localObject2).length(), 33);
        }
        ((Button)localObject1).setText((CharSequence)localObject2);
      }
    }
    if (!this.mCancelButtonHasAdd)
    {
      localObject1 = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_cancel_button, null);
      localObject2 = (Button)((View)localObject1).findViewById(R.id.action_sheet_btnCancel);
      ((Button)localObject2).setOnClickListener(this.mDefaultDismissListener);
      ((Button)localObject2).setText(R.string.mini_sdk_cancel);
      this.customButtonContainer.addView((View)localObject1);
      this.mCancelButtonHasAdd = true;
    }
    this.mNeedInitContentView = false;
  }
  
  private void setTransparentStatusBar()
  {
    if (DisplayUtil.isImmersiveSupported) {
      getWindow().addFlags(67108864);
    }
  }
  
  public Button addButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    paramOnClickListener = addButton(getContext().getResources().getString(paramInt2), paramInt3, paramInt4, paramOnClickListener);
    if (paramOnClickListener != null) {
      paramOnClickListener.setId(paramInt1);
    }
    return paramOnClickListener;
  }
  
  public Button addButton(int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    paramOnClickListener = addButton(paramInt2, paramInt3, paramOnClickListener);
    if (paramOnClickListener != null) {
      paramOnClickListener.setId(paramInt1);
    }
    return paramOnClickListener;
  }
  
  public Button addButton(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    return addButton(getContext().getResources().getString(paramInt1), paramInt2, paramOnClickListener);
  }
  
  public Button addButton(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if ((paramInt2 < 0) || (paramInt2 > this.buttonCount)) {
      return null;
    }
    try
    {
      Button localButton = new Button(this.mContext);
      this.customButtonContainer.addView(localButton, paramInt2);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = ((int)this.mContext.getResources().getDimension(R.dimen.mini_sdk_common_action_sheet_layout_height));
      localButton.setLayoutParams(localLayoutParams);
      localButton.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS2));
      localButton.setText(paramString);
      localButton.setOnClickListener(paramOnClickListener);
      this.buttonCount += 1;
      localButton.setTag(Integer.valueOf(paramInt1));
      if ((paramInt2 >= 0) && (paramInt2 <= this.buttonsList.size())) {
        this.buttonsList.add(paramInt2, localButton);
      }
      this.mNeedInitContentView = true;
      return localButton;
    }
    catch (Exception paramString)
    {
      QMLog.e("ActionSheetDialog", "e:" + paramString.toString());
    }
    return null;
  }
  
  public Button addButton(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    try
    {
      Button localButton = new Button(this.mContext);
      this.customButtonContainer.addView(localButton);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = ((int)this.mContext.getResources().getDimension(R.dimen.mini_sdk_common_action_sheet_layout_height));
      localLayoutParams.gravity = 17;
      localButton.setLayoutParams(localLayoutParams);
      localButton.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS2));
      localButton.setText(paramString);
      localButton.setOnClickListener(paramOnClickListener);
      this.buttonCount += 1;
      localButton.setTag(Integer.valueOf(paramInt));
      this.buttonsList.add(localButton);
      this.mNeedInitContentView = true;
      return localButton;
    }
    catch (Exception paramString)
    {
      QMLog.e("ActionSheetDialog", "e:" + paramString.toString());
    }
    return null;
  }
  
  public TextView addTitle(String paramString)
  {
    try
    {
      Button localButton = new Button(this.mContext);
      this.customButtonContainer.addView(localButton, 0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = ((int)this.mContext.getResources().getDimension(R.dimen.mini_sdk_common_action_sheet_layout_height));
      localLayoutParams.gravity = 17;
      localButton.setLayoutParams(localLayoutParams);
      localButton.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.mini_sdk_textSizeS3));
      localButton.setText(paramString);
      localButton.setTextColor(-16777216);
      localButton.setBackgroundResource(R.drawable.mini_sdk_actionsheet_top);
      localButton.setClickable(false);
      return localButton;
    }
    catch (Exception paramString)
    {
      QMLog.e("ActionSheetDialog", "e:" + paramString.toString());
    }
    return null;
  }
  
  public void clear()
  {
    if (this.customButtonContainer != null)
    {
      this.customButtonContainer.removeAllViews();
      this.mCancelButtonHasAdd = false;
    }
  }
  
  public void dismiss()
  {
    if (this.mDismissFinish)
    {
      this.mDismissFinish = false;
      this.handler.postDelayed(new ActionSheetDialog.3(this), 0L);
    }
  }
  
  public Button getButtonById(int paramInt)
  {
    View localView = this.customButtonContainer.findViewById(paramInt);
    if ((localView == null) || (!(localView instanceof Button))) {
      return null;
    }
    return (Button)localView;
  }
  
  public Button getButtonByIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.buttonsList.size())) {
      return (Button)this.buttonsList.get(paramInt);
    }
    return null;
  }
  
  public Button getButtonByTag(int paramInt)
  {
    int i = 0;
    while (i < this.buttonsList.size())
    {
      if (((Integer)((Button)this.buttonsList.get(i)).getTag()).intValue() == paramInt) {
        return (Button)this.buttonsList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public int getButtonCount()
  {
    return this.buttonCount;
  }
  
  public int getButtonIndexById(int paramInt)
  {
    int i = 0;
    while (i < this.buttonsList.size())
    {
      if (paramInt == ((Button)this.buttonsList.get(i)).getId()) {
        return i;
      }
      i += 1;
    }
    return this.buttonsList.size();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.cancelListener != null) {}
    try
    {
      this.cancelListener.onClick(null);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      dismiss();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setAddImageButtonText(Button paramButton)
  {
    if (paramButton != null)
    {
      int i = DisplayUtil.dip2px(getContext(), 8.0F);
      int j = this.mContext.getResources().getColor(R.color.mini_sdk_action_sheet_button_blue);
      SpannableString localSpannableString = new SpannableString(paramButton.getText());
      Drawable localDrawable = this.mContext.getResources().getDrawable(R.drawable.mini_sdk_ys_huangzuan);
      localDrawable.setBounds(i, 0, localDrawable.getIntrinsicWidth() + i, localDrawable.getIntrinsicHeight());
      localSpannableString.setSpan(new ImageSpan(localDrawable, 1), localSpannableString.length() - 1, localSpannableString.length(), 33);
      paramButton.setText(localSpannableString);
      paramButton.setTextColor(j);
    }
  }
  
  public void setDefaultDismissListener(View.OnClickListener paramOnClickListener)
  {
    this.mDefaultDismissListener = paramOnClickListener;
  }
  
  public void setNeedInitContentView(boolean paramBoolean)
  {
    this.mNeedInitContentView = paramBoolean;
  }
  
  public void show()
  {
    super.show();
    prepareContentViews();
    this.mContainer.setVisibility(4);
    this.backgroundLayout.setVisibility(4);
    this.mDismissFinish = true;
    this.handler.postDelayed(new ActionSheetDialog.2(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.ActionSheetDialog
 * JD-Core Version:    0.7.0.1
 */