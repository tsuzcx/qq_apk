package com.tencent.mobileqq.vas.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.simpleui.SimpleUIObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;

final class ThemeFontAdapter$1
  extends SimpleUIObserver
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    paramInt = 0;
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = BaseApplicationImpl.getApplication().getApplicationContext();
      if (!SimpleUIUtil.a()) {
        break label48;
      }
      localObject2 = TextHook.getFontPath((Context)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ThemeFontAdapter.a((Context)localObject1, (String)localObject2);
        ThemeFontAdapter.a(false);
      }
    }
    label48:
    do
    {
      return;
      localObject1 = ThemeFontAdapter.a((Context)localObject1);
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    Object localObject2 = FileManagerUtil.a((String)localObject1).split("\\.");
    try
    {
      int i = Integer.parseInt(localObject2[0]);
      if (localObject2.length > 2) {
        paramInt = Integer.parseInt(localObject2[1]);
      }
      ThemeFontAdapter.b(i, paramInt);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("ThemeFontAdapter", 1, "switchFont  prePath:" + (String)localObject1, localNumberFormatException);
      localNumberFormatException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */