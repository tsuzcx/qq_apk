package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;

public class DesktopDittoImageArea
  extends DittoImageArea
{
  protected static final String IMAGE_URL = "img_url";
  public static final String TAG = "DesktopDittoImageArea";
  
  public DesktopDittoImageArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    processAttr();
  }
  
  private void processAttr()
  {
    if ((this.mLayoutAttr != null) && (this.mLayoutAttr.hasAttr("img_url")))
    {
      localObject = this.mLayoutAttr.getAttr("img_url", null);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        QLog.d("DesktopDittoImageArea", 1, "processAttr, url: " + (String)localObject);
      }
    }
    else
    {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mRequestWidth = getWidth();
    localURLDrawableOptions.mRequestHeight = getHeight();
    if (((String)localObject).endsWith(".gif")) {
      localURLDrawableOptions.mPlayGifImage = true;
    }
    Object localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    setImageDrawable((Drawable)localObject);
    if (((URLDrawable)localObject).getStatus() == 2) {
      ((URLDrawable)localObject).restartDownload();
    }
    for (;;)
    {
      ((URLDrawable)localObject).setCallback(new DesktopDittoImageArea.1(this));
      ((URLDrawable)localObject).setURLDrawableListener(new DesktopDittoImageArea.2(this));
      return;
      if (((URLDrawable)localObject).getStatus() == 1) {
        invalidate();
      }
    }
  }
  
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    super.setLayoutAttr(paramLayoutAttrSet);
    processAttr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoImageArea
 * JD-Core Version:    0.7.0.1
 */