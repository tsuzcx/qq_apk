package com.tencent.mobileqq.profilecard.base.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import mqq.app.MobileQQ;

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
    if (paramView != null)
    {
      LongClickCopyAction localLongClickCopyAction = new LongClickCopyAction(paramView, paramLongClickCopyData);
      paramView.setOnLongClickListener(localLongClickCopyAction);
      paramLongClickCopyData = localLongClickCopyAction;
      if ((paramView instanceof TextView))
      {
        paramView = (TextView)paramView;
        paramView.setText(paramView.getText(), TextView.BufferType.SPANNABLE);
        return localLongClickCopyAction;
      }
    }
    else
    {
      paramLongClickCopyData = null;
    }
    return paramLongClickCopyData;
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
      str1 = paramTextView.getResources().getString(2131699147);
      str2 = paramTextView.getText().toString();
    }
    else
    {
      str2 = null;
    }
    LongClickCopyData localLongClickCopyData = new LongClickCopyData();
    localLongClickCopyData.addCopyItem(str1, str2);
    return attachCopyAction(paramTextView, localLongClickCopyData);
  }
  
  public static LongClickCopyAction attachCopyAction(TextView paramTextView, String paramString)
  {
    String str;
    if (paramTextView != null) {
      str = paramTextView.getText().toString();
    } else {
      str = null;
    }
    LongClickCopyData localLongClickCopyData = new LongClickCopyData();
    localLongClickCopyData.addCopyItem(paramString, str);
    return attachCopyAction(paramTextView, localLongClickCopyData);
  }
  
  private void cleanCopyContent()
  {
    Object localObject = this.mTarget;
    if ((localObject != null) && ((localObject instanceof TextView)))
    {
      TextView localTextView = (TextView)localObject;
      localObject = null;
      if ((localTextView.getText() instanceof Spannable)) {
        localObject = (Spannable)localTextView.getText();
      }
      if (localObject != null) {
        ((Spannable)localObject).removeSpan(this.mSpan);
      }
    }
  }
  
  private void copyContent(String paramString)
  {
    if (paramString != null) {
      try
      {
        Object localObject = MobileQQ.sMobileQQ;
        if (localObject != null)
        {
          localObject = (ClipboardManager)((Context)localObject).getSystemService("clipboard");
          ClipboardMonitor.setText((ClipboardManager)localObject, paramString);
          ((ClipboardManager)localObject).setText(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("LongClickCopyAction", 2, "copyContent fail.", paramString);
      }
    }
  }
  
  private QQCustomMenuNoIconLayout createContent(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow, null);
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
  
  private void markTextViewCopyContent()
  {
    Object localObject = this.mTarget;
    int k;
    int i;
    if ((localObject != null) && ((localObject instanceof TextView)))
    {
      TextView localTextView = (TextView)localObject;
      k = localTextView.getText().toString().length();
      localObject = null;
      if ((localTextView.getText() instanceof Spannable)) {
        localObject = (Spannable)localTextView.getText();
      }
      if (localObject != null) {
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
    ((Spannable)localObject).setSpan(this.mSpan, 0, k, 17);
  }
  
  private BubblePopupWindow showAsDropDown(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(createContent(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.setOnDismissListener(paramOnDismissListener);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView);
    return localBubblePopupWindow;
  }
  
  public void onClick(View paramView)
  {
    String str;
    if ((paramView instanceof TextView))
    {
      str = ((TextView)paramView).getText().toString();
      str = this.mData.getCopyContent(str);
    }
    else
    {
      str = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LongClickCopyAction", 2, String.format("onClick view=%s copyResult=%s", new Object[] { paramView, str }));
    }
    if (!TextUtils.isEmpty(str))
    {
      copyContent(str);
      LongClickCopyAction.ICopyListener localICopyListener = this.mCopyListener;
      if (localICopyListener != null) {
        localICopyListener.onCopyContent(str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    View localView = this.mTarget;
    if ((localView instanceof TextView))
    {
      cleanCopyContent();
      return;
    }
    if (localView != null) {
      localView.setSelected(false);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.mData != null)
    {
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      this.mData.attachToMenu(localQQCustomMenu);
      View localView = this.mTarget;
      if ((localView instanceof TextView)) {
        markTextViewCopyContent();
      } else if (localView != null) {
        localView.setSelected(true);
      }
      showAsDropDown(paramView, localQQCustomMenu, this, this);
      paramView = this.mCopyListener;
      if (paramView != null) {
        paramView.onShowCopyMenu();
      }
    }
    return true;
  }
  
  public void setCopyListener(LongClickCopyAction.ICopyListener paramICopyListener)
  {
    this.mCopyListener = paramICopyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction
 * JD-Core Version:    0.7.0.1
 */