package com.tencent.qapmsdk.bigbitmap;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qapmsdk.bigbitmap.checker.IBitmapSizeChecker;
import com.tencent.qapmsdk.bigbitmap.datainfo.DrawableInfo;
import com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.qapmsdk.bigbitmap.provider.AbstractDrawableSizeProvider;
import com.tencent.qapmsdk.common.util.ClassUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Detector
{
  private IBitmapSizeChecker bitmapSizeChecker;
  private Map<String, AbstractDrawableSizeProvider> viewSizeCheckers = new HashMap();
  
  Detector(IBitmapSizeChecker paramIBitmapSizeChecker)
  {
    this.bitmapSizeChecker = paramIBitmapSizeChecker;
  }
  
  private void addToExceedBitmapList(List<ExceedBitmapInfo> paramList, String paramString1, String paramString2, View paramView, DrawableInfo paramDrawableInfo)
  {
    if ((paramDrawableInfo != null) && (this.bitmapSizeChecker.check(paramDrawableInfo.width, paramDrawableInfo.height, paramView.getWidth(), paramView.getHeight()).booleanValue()))
    {
      paramString1 = new ExceedBitmapInfo(paramString1, ClassUtil.getClassName(paramView, null), paramString2, paramView.getWidth(), paramView.getHeight(), paramDrawableInfo.width, paramDrawableInfo.height, paramDrawableInfo.type, paramDrawableInfo.allocatedByteSize, paramDrawableInfo.url, System.currentTimeMillis());
      if (!paramList.contains(paramString1))
      {
        paramList.add(paramString1);
        return;
      }
    }
  }
  
  void addDrawableSizeProvider(AbstractDrawableSizeProvider paramAbstractDrawableSizeProvider)
  {
    if (!this.viewSizeCheckers.containsKey(paramAbstractDrawableSizeProvider.type())) {
      this.viewSizeCheckers.put(paramAbstractDrawableSizeProvider.type(), paramAbstractDrawableSizeProvider);
    }
  }
  
  void detect(List<ExceedBitmapInfo> paramList, String paramString1, String paramString2, View paramView)
  {
    Drawable localDrawable2 = paramView.getBackground();
    Drawable localDrawable1;
    if ((paramView instanceof ImageView)) {
      localDrawable1 = ((ImageView)paramView).getDrawable();
    } else {
      localDrawable1 = null;
    }
    Iterator localIterator = this.viewSizeCheckers.values().iterator();
    while (localIterator.hasNext())
    {
      AbstractDrawableSizeProvider localAbstractDrawableSizeProvider = (AbstractDrawableSizeProvider)localIterator.next();
      addToExceedBitmapList(paramList, paramString1, paramString2, paramView, localAbstractDrawableSizeProvider.checkBackground(localDrawable2));
      addToExceedBitmapList(paramList, paramString1, paramString2, paramView, localAbstractDrawableSizeProvider.checkSrc(localDrawable1));
    }
  }
  
  IBitmapSizeChecker getBitmapSizeChecker()
  {
    return this.bitmapSizeChecker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.Detector
 * JD-Core Version:    0.7.0.1
 */