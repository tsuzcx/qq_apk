package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
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
      Object localObject1 = this.mLayoutAttr.getAttr("img_url", null);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processAttr, url: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("DesktopDittoImageArea", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = getHeight();
      if (((String)localObject1).endsWith(".gif")) {
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      }
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      setImageDrawable((Drawable)localObject1);
      if (((URLDrawable)localObject1).getStatus() == 2) {
        ((URLDrawable)localObject1).restartDownload();
      } else if (((URLDrawable)localObject1).getStatus() == 1) {
        invalidate();
      }
      ((URLDrawable)localObject1).setCallback(new DesktopDittoImageArea.1(this));
      ((URLDrawable)localObject1).setURLDrawableListener(new DesktopDittoImageArea.2(this));
    }
  }
  
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    super.setLayoutAttr(paramLayoutAttrSet);
    processAttr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoImageArea
 * JD-Core Version:    0.7.0.1
 */