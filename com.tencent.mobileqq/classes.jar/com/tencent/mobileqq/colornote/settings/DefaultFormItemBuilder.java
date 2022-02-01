package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultFormItemBuilder
  implements FormItemBuilder
{
  private int a(ColorNote paramColorNote)
  {
    switch (ColorNoteUtils.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      return 2130844531;
    case 16973824: 
      return 2130844473;
    case 17039360: 
      return 2130839353;
    case 16842752: 
      return 2130839354;
    case 16908288: 
      return 2130839355;
    }
    return 2130844262;
  }
  
  private Drawable a(Context paramContext, ColorNote paramColorNote)
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
          QLog.e("DefaultFormItemBuilder", 1, "service type: " + paramColorNote.getServiceType() + " url error.", localThrowable);
          return localDrawable;
        }
      }
      return paramContext;
    }
    catch (MalformedURLException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
      return paramContext;
      paramColorNote = URLDrawable.URLDrawableOptions.obtain();
      paramColorNote.mRequestWidth = AIOUtils.a(40.0F, paramContext);
      paramColorNote.mRequestHeight = AIOUtils.a(40.0F, paramContext);
      paramColorNote.mLoadingDrawable = paramContext.getDrawable(i);
      paramColorNote.mFailedDrawable = paramColorNote.mLoadingDrawable;
      paramColorNote = URLDrawable.getDrawable(localThrowable, paramColorNote);
      return paramColorNote;
    }
    catch (NullPointerException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
    }
  }
  
  public HistoryFormItem a(Context paramContext, ColorNote paramColorNote)
  {
    HistoryFormItem localHistoryFormItem = new HistoryFormItem(paramContext);
    localHistoryFormItem.setLeftText(paramColorNote.getMainTitle());
    localHistoryFormItem.setLeftIcon(a(paramContext, paramColorNote), paramContext.getResources().getDimensionPixelSize(2131298952), paramContext.getResources().getDimensionPixelSize(2131298951));
    return localHistoryFormItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.DefaultFormItemBuilder
 * JD-Core Version:    0.7.0.1
 */