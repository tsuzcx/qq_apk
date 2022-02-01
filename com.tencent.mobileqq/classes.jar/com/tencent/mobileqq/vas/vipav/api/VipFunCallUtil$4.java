package com.tencent.mobileqq.vas.vipav.api;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class VipFunCallUtil$4
  implements MediaPlayer.OnErrorListener
{
  VipFunCallUtil$4(int paramInt, VipFunCallMediaListener paramVipFunCallMediaListener, VideoView paramVideoView, boolean paramBoolean) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("playing onError what=");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append(", extra=");
      paramMediaPlayer.append(paramInt2);
      paramMediaPlayer.append(", funcallid=");
      paramMediaPlayer.append(this.jdField_a_of_type_Int);
      QLog.d("VipFunCallConstants", 2, paramMediaPlayer.toString());
    }
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallMediaListener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(paramInt1, paramInt2, this.jdField_a_of_type_Int);
    }
    paramInt1 = this.jdField_a_of_type_Int;
    paramMediaPlayer = null;
    Object localObject = VipFunCallUtil.a(null, paramInt1, 7, null);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (new File((String)localObject).exists())
    {
      localObject = BitmapManager.a((String)localObject);
      if (localObject != null) {
        paramMediaPlayer = new BitmapDrawable((Bitmap)localObject);
      }
      if (paramMediaPlayer != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetVideoView;
        if (localObject != null)
        {
          if (this.jdField_a_of_type_Boolean == true)
          {
            ((VideoView)localObject).setBackgroundDrawable(paramMediaPlayer);
            return true;
          }
          ((VideoView)localObject).setVisibility(8);
          localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetVideoView.getParent();
          if (localObject != null) {
            ((RelativeLayout)localObject).setBackgroundDrawable(paramMediaPlayer);
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil.4
 * JD-Core Version:    0.7.0.1
 */