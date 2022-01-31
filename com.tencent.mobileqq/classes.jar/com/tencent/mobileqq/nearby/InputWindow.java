package com.tencent.mobileqq.nearby;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.dating.widget.InputBar.IIputBarCallback;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;

public abstract class InputWindow
  extends Dialog
  implements TextWatcher, View.OnClickListener, InputBar.IIputBarCallback, EmoticonCallback
{
  protected BaseActivity a;
  protected InputBar a;
  protected SystemAndEmojiEmoticonPanel a;
  protected XEditTextEx a;
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  public void show()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      super.show();
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.InputWindow
 * JD-Core Version:    0.7.0.1
 */