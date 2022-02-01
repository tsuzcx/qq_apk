package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class PTSImageView
  extends KandianUrlImageView
  implements IView
{
  private static final String TAG = "PTSImageView";
  private String mPath;
  private URL mPathUrl;
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  
  public PTSImageView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    this.mRoundedCorner.clipPath(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
    this.mRoundedCorner.drawBorder(paramCanvas);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ImageRequest localImageRequest = this.mController.b();
    if (((localImageRequest == null) || (localImageRequest.d)) && (!TextUtils.isEmpty(this.mPath))) {
      setImageSrc(this.mPath);
    }
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
  
  public void onFinishTemporaryDetach() {}
  
  public void setImageSrc(String paramString)
  {
    try
    {
      if ((this.mPath == null) || (!this.mPath.equalsIgnoreCase(paramString)) || (this.mPathUrl == null))
      {
        this.mPath = paramString;
        this.mPathUrl = new URL(this.mPath);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[setImageSrc], mPathUrl = ");
        paramString.append(this.mPathUrl);
        QLog.d("PTSImageView", 2, paramString.toString());
      }
      ReadInJoyDisplayUtils.a(this, this.mPathUrl, getContext());
      return;
    }
    catch (MalformedURLException paramString)
    {
      this.mPathUrl = null;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setImageSrc] ex = ");
      localStringBuilder.append(paramString);
      QLog.e("PTSImageView", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSImageView
 * JD-Core Version:    0.7.0.1
 */