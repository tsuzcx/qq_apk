package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultFormItemBuilder
  implements FormItemBuilder
{
  private int a(ColorNote paramColorNote)
  {
    int i = ColorNoteUtils.a(paramColorNote.getServiceType()) & 0xFFFF0000;
    if (i != 16842752)
    {
      if (i != 16908288)
      {
        if (i != 16973824)
        {
          if (i != 17039360)
          {
            if (i != 17104896) {
              return 2130845755;
            }
            return 2130845485;
          }
          return 2130839382;
        }
        return 2130845696;
      }
      return 2130839384;
    }
    return 2130839383;
  }
  
  private Drawable b(Context paramContext, ColorNote paramColorNote)
  {
    paramContext = paramContext.getResources();
    int i = a(paramColorNote);
    try
    {
      Object localObject = new URL(paramColorNote.getPicUrl());
      boolean bool = "resdrawable".equals(((URL)localObject).getProtocol());
      if (bool) {
        try
        {
          localObject = paramContext.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          Drawable localDrawable = paramContext.getDrawable(i);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("service type: ");
          localStringBuilder.append(paramColorNote.getServiceType());
          localStringBuilder.append(" url error.");
          QLog.e("DefaultFormItemBuilder", 1, localStringBuilder.toString(), localThrowable);
          return localDrawable;
        }
      }
      paramColorNote = URLDrawable.URLDrawableOptions.obtain();
      paramColorNote.mRequestWidth = Utils.a(40.0F, paramContext);
      paramColorNote.mRequestHeight = Utils.a(40.0F, paramContext);
      paramColorNote.mLoadingDrawable = paramContext.getDrawable(i);
      paramColorNote.mFailedDrawable = paramColorNote.mLoadingDrawable;
      paramColorNote = URLDrawable.getDrawable(localThrowable, paramColorNote);
      return paramColorNote;
    }
    catch (NullPointerException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
      return paramContext;
    }
    catch (MalformedURLException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
    }
    return paramContext;
  }
  
  public HistoryFormItem a(Context paramContext, ColorNote paramColorNote)
  {
    HistoryFormItem localHistoryFormItem = new HistoryFormItem(paramContext);
    localHistoryFormItem.setLeftText(paramColorNote.getMainTitle());
    localHistoryFormItem.setLeftIcon(b(paramContext, paramColorNote), paramContext.getResources().getDimensionPixelSize(2131299683), paramContext.getResources().getDimensionPixelSize(2131299682));
    return localHistoryFormItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.DefaultFormItemBuilder
 * JD-Core Version:    0.7.0.1
 */