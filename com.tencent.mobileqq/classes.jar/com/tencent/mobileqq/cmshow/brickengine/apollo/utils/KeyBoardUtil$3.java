package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

final class KeyBoardUtil$3
  implements Runnable
{
  public void run()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).toggleSoftInput(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.3
 * JD-Core Version:    0.7.0.1
 */