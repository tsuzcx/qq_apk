package com.tencent.mobileqq.flashshow.widgets.comment;

import android.widget.ImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

class FSStatusView$2
  implements Runnable
{
  FSStatusView$2(FSStatusView paramFSStatusView, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Option localOption = new Option();
    localOption.setUrl(this.a);
    QCircleFeedPicLoader.g().loadImage(localOption, new FSStatusView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSStatusView.2
 * JD-Core Version:    0.7.0.1
 */