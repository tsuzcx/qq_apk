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
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (paramBoolean1)
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getApplicationContext();
      paramBoolean1 = SimpleUIUtil.e();
      paramInt = 0;
      Object localObject2;
      if (paramBoolean1)
      {
        localObject2 = TextHook.getFontPath((Context)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ThemeFontAdapter.a((Context)localObject1, (String)localObject2);
          ThemeFontAdapter.a(false);
        }
      }
      else
      {
        localObject1 = ThemeFontAdapter.b((Context)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = FileManagerUtil.a((String)localObject1).split("\\.");
          try
          {
            int i = Integer.parseInt(localObject2[0]);
            if (localObject2.length > 2) {
              paramInt = Integer.parseInt(localObject2[1]);
            }
            ThemeFontAdapter.c(i, paramInt);
            return;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("switchFont  prePath:");
            localStringBuilder.append((String)localObject1);
            QLog.e("ThemeFontAdapter", 1, localStringBuilder.toString(), localNumberFormatException);
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */