package com.tencent.mobileqq.winkpublish.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostImagePreviewHelper;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.winkpublish.bean.QCirclePicPreviewBean;
import com.tencent.mobileqq.winkpublish.widget.PublishBaseWidgetView;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class QCirclePicPreviewImage
  extends PublishBaseWidgetView<QCirclePicPreviewBean>
{
  private QCircleMultiTouchImageView a;
  
  public QCirclePicPreviewImage(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private Option a(URLImageView paramURLImageView, QCirclePicPreviewBean paramQCirclePicPreviewBean)
  {
    Option localOption = new Option();
    localOption.setLoadingDrawable(getResources().getDrawable(2130853309));
    if ((paramQCirclePicPreviewBean != null) && (paramURLImageView != null))
    {
      if (paramQCirclePicPreviewBean.b() == null) {
        return localOption;
      }
      int i = paramQCirclePicPreviewBean.b().mediaHeight;
      int j = paramQCirclePicPreviewBean.b().mediaWidth;
      if (i > 0)
      {
        if (j <= 0) {
          return localOption;
        }
        paramURLImageView = QCircleHostImagePreviewHelper.getTargetSize(j, i);
        i = paramURLImageView[0];
        j = paramURLImageView[1];
        localOption.setRequestWidth(i);
        localOption.setRequestHeight(j);
      }
    }
    return localOption;
  }
  
  protected void a(QCirclePicPreviewBean paramQCirclePicPreviewBean, int paramInt)
  {
    if (this.a != null)
    {
      if (paramQCirclePicPreviewBean == null) {
        return;
      }
      String str = paramQCirclePicPreviewBean.a();
      if (!TextUtils.isEmpty(str))
      {
        paramQCirclePicPreviewBean = a(this.a, paramQCirclePicPreviewBean);
        paramQCirclePicPreviewBean = new Option().setTargetView(this.a).setRequestHeight(paramQCirclePicPreviewBean.getRequestHeight()).setRequestWidth(paramQCirclePicPreviewBean.getRequestHeight()).setUrl(str).setLoadingDrawable(getResources().getDrawable(2130853309)).setPredecode(true);
        QCircleFeedPicLoader.g().loadImage(paramQCirclePicPreviewBean, new QCirclePicPreviewImage.2(this, str));
        return;
      }
      paramQCirclePicPreviewBean = new StringBuilder();
      paramQCirclePicPreviewBean.append("same url, not need load oncemore! url:");
      paramQCirclePicPreviewBean.append(str);
      QLog.d("QCirclePicPreviewImage", 1, paramQCirclePicPreviewBean.toString());
    }
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new QCircleMultiTouchImageView(getContext());
    this.a.setBackgroundColor(-16777216);
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
    this.a.setOnScaleEndListener(new QCirclePicPreviewImage.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.QCirclePicPreviewImage
 * JD-Core Version:    0.7.0.1
 */