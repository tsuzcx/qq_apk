package com.tencent.mobileqq.utils;

import abty;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bkxz;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class QQCustomDialogWtihInputAndChoose
  extends QQCustomDialogWtihForwardAvatar
  implements View.OnClickListener
{
  public static final String KEY_FROM = "chooseFriendFrom";
  public static final Integer QQCUSTOM_DIALOG_FROM_NOT_RECOMMEND = Integer.valueOf(2);
  public static final Integer QQCUSTOM_DIALOG_FROM_RECOMMEND = Integer.valueOf(1);
  final float CHOOSE_LIST_ITEM_HEIGHT = 45.5F;
  final float CHOOSE_LIST_MAX_HEIGHT = 267.0F;
  final float CHOOSE_LIST_TITLE_HEIGHT = 39.0F;
  ArrayList<String> chooseList = new ArrayList();
  EditText inputView;
  boolean isFirstClick = true;
  protected View.OnClickListener listItemClickListener = new QQCustomDialogWtihInputAndChoose.2(this);
  MyLinearLayout mChooseLayout;
  Handler mHandler = new Handler();
  boolean mIsWindowAdded;
  RelativeLayout mRoot;
  boolean mSingleLine = false;
  ImageView mViewInputBtn;
  WindowManager mWindowManager;
  WindowManager.LayoutParams mWindowParams;
  SoftReference<Context> softRefContext;
  protected View viewSelected;
  
  public QQCustomDialogWtihInputAndChoose(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.softRefContext = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public EditText getEditText()
  {
    return this.inputView;
  }
  
  public String getInputValue()
  {
    return this.inputView.getText().toString();
  }
  
  public String getPalinText()
  {
    if (this.inputView == null) {
      return "";
    }
    Object localObject;
    if ((this.inputView.getText() instanceof QzoneTextBuilder))
    {
      localObject = (QzoneTextBuilder)this.inputView.getText();
      if (localObject != null) {
        return ((QzoneTextBuilder)localObject).toPlainText();
      }
    }
    else if ((this.inputView.getText() instanceof QQTextBuilder))
    {
      localObject = (QQTextBuilder)this.inputView.getText();
      if (localObject != null) {
        return ((QQTextBuilder)localObject).toPlainText();
      }
    }
    return this.inputView.getEditableText().toString();
  }
  
  int getScreenYin(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void hideChooseList()
  {
    if (this.mIsWindowAdded)
    {
      this.mWindowManager.removeView(this.mChooseLayout);
      this.mIsWindowAdded = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.inputView != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.inputView.getWindowToken(), 0);
    }
  }
  
  void initChooseList(Context paramContext)
  {
    this.mChooseLayout = ((MyLinearLayout)View.inflate(paramContext, 2131559061, null));
    this.mChooseLayout.findViewById(2131370186).setOnClickListener(this);
    this.mChooseLayout.setDispatchKeyEventListener(new QQCustomDialogWtihInputAndChoose.4(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368920) {
      if (this.mChooseLayout != null)
      {
        if (!this.mIsWindowAdded) {
          break label75;
        }
        hideChooseList();
        this.mViewInputBtn.setImageResource(2130847312);
        this.mViewInputBtn.setTag(Integer.valueOf(2130847312));
        this.mHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.5(this), 200L);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label75:
      Object localObject = this.mViewInputBtn.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130847908))
      {
        bkxz.a(this.inputView);
        this.mViewInputBtn.setImageResource(2130847312);
        this.mViewInputBtn.setTag(Integer.valueOf(2130847312));
        this.mIsWindowAdded = false;
      }
      else
      {
        bkxz.b(this.inputView);
        this.mViewInputBtn.setImageResource(2130847908);
        this.mViewInputBtn.setTag(Integer.valueOf(2130847908));
        this.mHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.6(this), 200L);
        continue;
        if (paramView.getId() == 2131370186)
        {
          hideChooseList();
        }
        else
        {
          hideChooseList();
          bkxz.b(this.inputView);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    hideChooseList();
    bkxz.b(this.inputView);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setChooseList(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    this.chooseList = paramArrayList;
    float f = getContext().getResources().getDisplayMetrics().density;
    LinearLayout localLinearLayout = (LinearLayout)this.mChooseLayout.findViewById(2131370183);
    localLinearLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      View localView = View.inflate(getContext(), 2131559062, null);
      localView.setTag(Integer.valueOf(i));
      localView.setClickable(true);
      localView.setOnClickListener(this.listItemClickListener);
      ((TextView)localView.findViewById(2131370182)).setText((CharSequence)paramArrayList.get(i));
      localLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, (int)(45.5F * f)));
      i += 1;
    }
    if (paramArrayList.size() >= 5) {}
    for (this.mWindowParams = new WindowManager.LayoutParams(-1, (int)(267.0F * f), 2, 32, -1);; this.mWindowParams = new WindowManager.LayoutParams(-1, (int)((39.0F + paramArrayList.size() * 45.5F + 2.0F) * f), 2, 32, -1))
    {
      this.mWindowParams.gravity = 81;
      return;
    }
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.mRoot = ((RelativeLayout)findViewById(2131365640));
    this.inputView = ((EditText)findViewById(2131368909));
    this.mViewInputBtn = ((ImageView)findViewById(2131368920));
    this.mViewInputBtn.setOnClickListener(this);
    findViewById(2131377139).setOnClickListener(this);
    this.inputView.setSingleLine(this.mSingleLine);
    this.inputView.setOnTouchListener(new QQCustomDialogWtihInputAndChoose.1(this));
    Context localContext = (Context)this.softRefContext.get();
    if (localContext == null) {
      return;
    }
    abty.a(localContext, this.inputView);
    initChooseList(localContext);
  }
  
  public void setEditLint(String paramString)
  {
    this.inputView.setHint(paramString);
  }
  
  public void setInputValue(String paramString)
  {
    if (paramString != null)
    {
      this.inputView.setText(paramString);
      this.inputView.setSelection(this.inputView.getText().length());
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    if (this.inputView != null)
    {
      this.inputView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.inputView.addTextChangedListener(new QQCustomDialogWtihInputAndChoose.3(this, paramInt));
    }
  }
  
  public QQCustomDialog setMessage(CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(2131365620);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localTextView.setText(paramCharSequence);
      localTextView.setContentDescription(paramCharSequence);
      localTextView.setVisibility(0);
      return this;
    }
    localTextView.setVisibility(8);
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
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691087));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogWtihInputAndChoose.7(this, paramOnClickListener));
    setSeperatorState();
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
    this.rBtn.setOnClickListener(new QQCustomDialogWtihInputAndChoose.8(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.mSingleLine = paramBoolean;
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose
 * JD-Core Version:    0.7.0.1
 */