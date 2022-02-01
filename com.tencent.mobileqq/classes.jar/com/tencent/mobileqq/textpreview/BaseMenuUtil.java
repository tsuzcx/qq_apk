package com.tencent.mobileqq.textpreview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class BaseMenuUtil
{
  public static void copy(String paramString1, String paramString2)
  {
    copy(paramString1, paramString2, true);
  }
  
  public static void copy(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)BaseApplication.getContext().getSystemService("clipboard");
      if (localClipboardManager != null)
      {
        localClipboardManager.setPrimaryClip(ClipData.newPlainText(paramString2, paramString1));
        if (paramBoolean) {
          QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131706563), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.textpreview.BaseMenuUtil
 * JD-Core Version:    0.7.0.1
 */