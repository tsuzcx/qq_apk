package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.adapter.ICameraEmotionAdapterHelper;
import com.tencent.qphone.base.util.QLog;

class CameraEmotionAdapter$1
  implements IEmoticonPanelLinearLayoutHelper.OnClickListener
{
  CameraEmotionAdapter$1(CameraEmotionAdapter paramCameraEmotionAdapter) {}
  
  public boolean shouldInterceptClickEvent(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramEmoticonInfo.action))
    {
      Object localObject = (CameraEmoticonInfo)paramEmoticonInfo;
      if ((((CameraEmoticonInfo)localObject).roamingType.equals("needUpload")) || (((CameraEmoticonInfo)localObject).roamingType.equals("needDel"))) {
        return true;
      }
      if (((CameraEmoticonInfo)localObject).roamingType.equals("failed"))
      {
        CameraEmotionAdapter.access$000(this.this$0).reUploadCameraEmotion((CameraEmoticonInfo)localObject);
        return true;
      }
      localObject = (URLImageView)paramView.findViewById(2131378813);
      ImageView localImageView = (ImageView)paramView.findViewById(2131374857);
      if (!(((URLImageView)localObject).getBackground() instanceof URLDrawable)) {
        return false;
      }
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getBackground();
      if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading failed, restart download " + paramEmoticonInfo.toString());
        }
        ((URLImageView)localObject).setVisibility(8);
        localImageView.setVisibility(0);
        localURLDrawable.restartDownload();
        if (!(localImageView.getDrawable() instanceof Animatable)) {
          localImageView.setImageDrawable((Drawable)paramView.getContext().getResources().getDrawable(2130846582));
        }
        ((Animatable)localImageView.getDrawable()).start();
        return true;
      }
      if (localURLDrawable.getStatus() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading " + paramEmoticonInfo.toString());
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */