package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.qphone.base.util.QLog;

public class CommentAvatarView
  extends ImageBase
{
  private static Drawable b = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842705));
  private ReadInJoyHeadImageView a;
  private Long c = null;
  
  public CommentAvatarView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new ReadInJoyHeadImageView(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void loadImage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadImage: path is ");
    localStringBuilder.append(paramString);
    QLog.d("", 2, localStringBuilder.toString());
    if ((paramString != null) && (!paramString.equals("-1"))) {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount")))
      {
        paramString = ImageCommon.getDrawableResourceId(paramString);
        if (paramString == null) {
          break label134;
        }
        QLog.d("", 2, "loadImage: cant find in offline dir, try to load from resources");
      }
    }
    label134:
    try
    {
      paramString = this.a.getResources().getDrawable(paramString.intValue());
      this.a.setImageDrawable(paramString);
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      label106:
      break label106;
    }
    QLog.d("", 2, "loadImage: cant find in resources dir, do nothing");
    return;
    this.a.setImagePlaceHolder(b);
    this.a.setImageSrc(paramString);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.onComLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.onComMeasure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    Long localLong = this.c;
    if (localLong != null) {
      this.a.setHeadImgByUin(localLong.longValue(), true);
    } else {
      loadImage(this.mSrc);
    }
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.a.setImageSrc(null);
    this.mSrc = null;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 1076)
    {
      if (paramInt != 1077) {
        return super.setAttribute(paramInt, paramString);
      }
      this.mSrc = paramString;
      return true;
    }
    try
    {
      this.c = Long.valueOf(Long.parseLong(paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("", 1, "", paramString);
    }
    return true;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.a.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentAvatarView
 * JD-Core Version:    0.7.0.1
 */