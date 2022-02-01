package com.tencent.rmonitor.bigbitmap;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.rmonitor.bigbitmap.checker.IBitmapSizeChecker;
import com.tencent.rmonitor.bigbitmap.datainfo.DrawableInfo;
import com.tencent.rmonitor.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.rmonitor.bigbitmap.provider.AbstractDrawableSizeProvider;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.ClassUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BigBitmapDetector
{
  private final IBitmapSizeChecker a;
  private final Map<String, AbstractDrawableSizeProvider> b = new HashMap();
  
  public BigBitmapDetector(IBitmapSizeChecker paramIBitmapSizeChecker)
  {
    this.a = paramIBitmapSizeChecker;
  }
  
  private String a(View paramView)
  {
    String str3 = ClassUtil.a(paramView, null);
    String str2 = "NO_ID";
    String str1 = str2;
    try
    {
      if (paramView.getId() != -1) {
        str1 = paramView.getResources().getResourceName(paramView.getId());
      }
    }
    catch (Throwable paramView)
    {
      Logger.b.a("BigBitmapDetector", paramView);
      str1 = str2;
    }
    paramView = new StringBuilder();
    paramView.append(str3);
    paramView.append("(id/");
    paramView.append(str1);
    paramView.append(")");
    return paramView.toString();
  }
  
  private void a(List<ExceedBitmapInfo> paramList, String paramString1, String paramString2, View paramView, DrawableInfo paramDrawableInfo)
  {
    if ((paramDrawableInfo != null) && (this.a.a(paramDrawableInfo.b, paramDrawableInfo.c, paramView.getWidth(), paramView.getHeight()).booleanValue()))
    {
      paramString1 = new ExceedBitmapInfo(paramString1, a(paramView), paramString2, paramView.getWidth(), paramView.getHeight(), paramDrawableInfo.b, paramDrawableInfo.c, paramDrawableInfo.a, paramDrawableInfo.d, paramDrawableInfo.e, System.currentTimeMillis());
      if (!paramList.contains(paramString1)) {
        paramList.add(paramString1);
      }
    }
  }
  
  public void a(AbstractDrawableSizeProvider paramAbstractDrawableSizeProvider)
  {
    if (!this.b.containsKey(paramAbstractDrawableSizeProvider.a())) {
      this.b.put(paramAbstractDrawableSizeProvider.a(), paramAbstractDrawableSizeProvider);
    }
  }
  
  public void a(List<ExceedBitmapInfo> paramList, String paramString1, String paramString2, View paramView)
  {
    Drawable localDrawable2 = paramView.getBackground();
    Drawable localDrawable1;
    if ((paramView instanceof ImageView)) {
      localDrawable1 = ((ImageView)paramView).getDrawable();
    } else {
      localDrawable1 = null;
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      AbstractDrawableSizeProvider localAbstractDrawableSizeProvider = (AbstractDrawableSizeProvider)localIterator.next();
      a(paramList, paramString1, paramString2, paramView, localAbstractDrawableSizeProvider.a(localDrawable2));
      a(paramList, paramString1, paramString2, paramView, localAbstractDrawableSizeProvider.b(localDrawable1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.BigBitmapDetector
 * JD-Core Version:    0.7.0.1
 */