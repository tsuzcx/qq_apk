package com.tencent.mobileqq.profilecard.base.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class LongClickCopyAction
  implements View.OnClickListener, View.OnLongClickListener, BubblePopupWindow.OnDismissListener
{
  private static final String TAG = "LongClickCopyAction";
  private LongClickCopyAction.ICopyListener mCopyListener;
  private LongClickCopyData mData;
  private BackgroundColorSpan mSpan;
  private View mTarget;
  
  private LongClickCopyAction(View paramView, LongClickCopyData paramLongClickCopyData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("TextViewCopyAction target=%s copyData=%s", new Object[] { paramView, paramLongClickCopyData }));
    }
    this.mTarget = paramView;
    this.mData = paramLongClickCopyData;
  }
  
  public static LongClickCopyAction attachCopyAction(View paramView, LongClickCopyData paramLongClickCopyData)
  {
    LongClickCopyData localLongClickCopyData = null;
    if (paramView != null)
    {
      paramLongClickCopyData = new LongClickCopyAction(paramView, paramLongClickCopyData);
      paramView.setOnLongClickListener(paramLongClickCopyData);
      localLongClickCopyData = paramLongClickCopyData;
      if ((paramView instanceof TextView))
      {
        paramView = (TextView)paramView;
        paramView.setText(paramView.getText(), TextView.BufferType.SPANNABLE);
        localLongClickCopyData = paramLongClickCopyData;
      }
    }
    return localLongClickCopyData;
  }
  
  public static LongClickCopyAction attachCopyAction(View paramView, String paramString1, String paramString2)
  {
    LongClickCopyData localLongClickCopyData = new LongClickCopyData();
    localLongClickCopyData.addCopyItem(paramString1, paramString2);
    return attachCopyAction(paramView, localLongClickCopyData);
  }
  
  public static LongClickCopyAction attachCopyAction(TextView paramTextView)
  {
    String str1 = null;
    String str2;
    if (paramTextView != null)
    {
      str2 = paramTextView.getResources().getString(2131699043);
      str1 = paramTextView.getText().toString();
    }
    for (;;)
    {
      LongClickCopyData localLongClickCopyData = new LongClickCopyData();
      localLongClickCopyData.addCopyItem(str2, str1);
      return attachCopyAction(paramTextView, localLongClickCopyData);
      str2 = null;
    }
  }
  
  public static LongClickCopyAction attachCopyAction(TextView paramTextView, String paramString)
  {
    String str = null;
    if (paramTextView != null) {
      str = paramTextView.getText().toString();
    }
    LongClickCopyData localLongClickCopyData = new LongClickCopyData();
    localLongClickCopyData.addCopyItem(paramString, str);
    return attachCopyAction(paramTextView, localLongClickCopyData);
  }
  
  private void cleanCopyContent()
  {
    if ((this.mTarget != null) && ((this.mTarget instanceof TextView)))
    {
      localObject = (TextView)this.mTarget;
      if (!(((TextView)localObject).getText() instanceof Spannable)) {
        break label58;
      }
    }
    label58:
    for (Object localObject = (Spannable)((TextView)localObject).getText();; localObject = null)
    {
      if (localObject != null) {
        ((Spannable)localObject).removeSpan(this.mSpan);
      }
      return;
    }
  }
  
  private void copyContent(String paramString)
  {
    if (paramString != null) {}
    try
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl != null) {
        ((ClipboardManager)localBaseApplicationImpl.getSystemService("clipboard")).setText(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("LongClickCopyAction", 2, "copyContent fail.", paramString);
    }
  }
  
  private void markTextViewCopyContent()
  {
    int k;
    Spannable localSpannable;
    int i;
    if ((this.mTarget != null) && ((this.mTarget instanceof TextView)))
    {
      TextView localTextView = (TextView)this.mTarget;
      k = localTextView.getText().toString().length();
      localSpannable = null;
      if ((localTextView.getText() instanceof Spannable)) {
        localSpannable = (Spannable)localTextView.getText();
      }
      if (localSpannable != null) {
        if (this.mSpan == null) {
          i = 1714664933;
        }
      }
    }
    try
    {
      int j = Color.parseColor("#33000000");
      i = j;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    this.mSpan = new BackgroundColorSpan(i);
    localSpannable.setSpan(this.mSpan, 0, k, 17);
  }
  
  public void onClick(View paramView)
  {
    String str = null;
    if ((paramView instanceof TextView))
    {
      str = ((TextView)paramView).getText().toString();
      str = this.mData.getCopyContent(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("onClick view=%s copyResult=%s", new Object[] { paramView, str }));
    }
    if (!TextUtils.isEmpty(str))
    {
      copyContent(str);
      if (this.mCopyListener != null) {
        this.mCopyListener.onCopyContent(str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    if ((this.mTarget instanceof TextView)) {
      cleanCopyContent();
    }
    while (this.mTarget == null) {
      return;
    }
    this.mTarget.setSelected(false);
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu;
    if (this.mData != null)
    {
      localQQCustomMenu = new QQCustomMenu();
      this.mData.attachToMenu(localQQCustomMenu);
      if (!(this.mTarget instanceof TextView)) {
        break label63;
      }
      markTextViewCopyContent();
    }
    for (;;)
    {
      BubbleContextMenu.a(paramView, localQQCustomMenu, this, this);
      if (this.mCopyListener != null) {
        this.mCopyListener.onShowCopyMenu();
      }
      return true;
      label63:
      if (this.mTarget != null) {
        this.mTarget.setSelected(true);
      }
    }
  }
  
  public void setCopyListener(LongClickCopyAction.ICopyListener paramICopyListener)
  {
    this.mCopyListener = paramICopyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction
 * JD-Core Version:    0.7.0.1
 */