package com.tencent.tkd.comment.adapt;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.tkd.comment.util.CommonUtil;

public class PanelInputDialogFragment
  extends BaseBottomSheetDialogFragment
{
  protected static final int STATE_DEFAULT = 0;
  protected static final int STATE_INVALID = -1;
  protected static final int STATE_KEYBOARD = 1;
  protected static final int STATE_PANEL = 2;
  private KeyboardObserver keyboardObserver;
  private int state;
  private EditText vEdit;
  private PanelFrameLayout vPanel;
  private View vRoot;
  
  private void performChangeState(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        this.vPanel.setShowing(true);
        if (paramInt1 == 0)
        {
          this.vPanel.requestLayout();
          return;
        }
        CommonUtil.hideInputMethod(getActivity(), this.vEdit);
        return;
      }
      this.vPanel.setShowing(false);
      CommonUtil.showInputMethod(getActivity(), this.vEdit);
      return;
    }
    this.vPanel.setShowing(false);
    CommonUtil.hideInputMethod(getActivity(), this.vEdit);
  }
  
  protected void beforeStateChange(int paramInt1, int paramInt2) {}
  
  protected void changeState(int paramInt)
  {
    int i = this.state;
    this.state = paramInt;
    beforeStateChange(i, paramInt);
    if (i != paramInt) {
      performChangeState(i, paramInt);
    }
  }
  
  protected int getState()
  {
    return this.state;
  }
  
  protected void init(View paramView, PanelFrameLayout paramPanelFrameLayout, EditText paramEditText)
  {
    this.vRoot = paramView;
    this.vPanel = paramPanelFrameLayout;
    this.vEdit = paramEditText;
    this.state = 0;
    paramView = new PanelInputDialogFragment.MyOnClickListener(this, null);
    this.vRoot.setOnClickListener(paramView);
    this.vEdit.setOnClickListener(paramView);
    this.keyboardObserver = new KeyboardObserver();
    this.keyboardObserver.setTarget(this.vRoot, new PanelInputDialogFragment.1(this));
    this.vPanel.setPanelHeight(this.keyboardObserver.getDefaultPanelHeight());
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getDialog().getWindow();
    if (paramBundle != null)
    {
      paramBundle.setSoftInputMode(18);
      paramBundle.setGravity(48);
      paramBundle.setLayout(-1, -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    KeyboardObserver localKeyboardObserver = this.keyboardObserver;
    if (localKeyboardObserver != null) {
      localKeyboardObserver.setTarget(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.PanelInputDialogFragment
 * JD-Core Version:    0.7.0.1
 */