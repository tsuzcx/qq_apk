package com.tencent.tkd.comment.publisher.qq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback;

public class TkdQQUrlImageView
  extends ImageView
  implements QQUrlImageBridge.Callback
{
  public QQUrlImageBridge urlImageBridge;
  
  public TkdQQUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TkdQQUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TkdQQUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onFail() {}
  
  public void onSuccess(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap);
  }
  
  public void setUrl(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = getMeasuredWidth();
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = getMeasuredHeight();
    }
    QQUrlImageBridge localQQUrlImageBridge = this.urlImageBridge;
    if (localQQUrlImageBridge != null) {
      localQQUrlImageBridge.loadUrlImage(paramString, i, paramInt1, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdQQUrlImageView
 * JD-Core Version:    0.7.0.1
 */