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
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class CameraEmotionAdapter$1
  implements IEmoticonPanelLinearLayoutHelper.OnClickListener
{
  CameraEmotionAdapter$1(CameraEmotionAdapter paramCameraEmotionAdapter) {}
  
  public boolean shouldInterceptClickEvent(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if (paramEmoticonInfo != null)
    {
      if (paramView == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramEmoticonInfo.action))
      {
        Object localObject = (CameraEmoticonInfo)paramEmoticonInfo;
        if (!((CameraEmoticonInfo)localObject).roamingType.equals("needUpload"))
        {
          if (((CameraEmoticonInfo)localObject).roamingType.equals("needDel")) {
            return true;
          }
          if (((CameraEmoticonInfo)localObject).roamingType.equals("failed"))
          {
            paramView = ((CameraEmotionRoamingDBManagerServiceProxy)this.this$0.app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getEmoticonDataList();
            if (paramView != null)
            {
              paramView = paramView.iterator();
              while (paramView.hasNext())
              {
                paramEmoticonInfo = (CameraEmotionData)paramView.next();
                if (paramEmoticonInfo.emoId == ((CameraEmoticonInfo)localObject).emoId)
                {
                  QLog.d("CameraEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(paramEmoticonInfo.emoId) });
                  paramEmoticonInfo.RomaingType = "needUpload";
                  ((CameraEmoticonInfo)localObject).roamingType = "needUpload";
                  ((CameraEmoRoamingHandlerProxy)this.this$0.app.getBusinessHandler(CameraEmoRoamingHandler.a)).notifyUI(4, true, null);
                  com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.a = false;
                  ThreadManager.excute(new CameraEmoSingleSend(paramEmoticonInfo, true), 64, null, false);
                }
              }
            }
            return true;
          }
          localObject = (URLImageView)paramView.findViewById(2131446720);
          ImageView localImageView = (ImageView)paramView.findViewById(2131442557);
          if (!(((URLImageView)localObject).getBackground() instanceof URLDrawable)) {
            return false;
          }
          URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getBackground();
          if ((localURLDrawable.getStatus() != 3) && (localURLDrawable.getStatus() != 2))
          {
            if (localURLDrawable.getStatus() == 0)
            {
              if (QLog.isColorLevel())
              {
                paramView = new StringBuilder();
                paramView.append("now  cameraemo EmoticonInfo loading ");
                paramView.append(paramEmoticonInfo.toString());
                QLog.i("CameraEmotionAdapter", 2, paramView.toString());
              }
              return true;
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("now  cameraemo EmoticonInfo loading failed, restart download ");
              localStringBuilder.append(paramEmoticonInfo.toString());
              QLog.i("CameraEmotionAdapter", 2, localStringBuilder.toString());
            }
            ((URLImageView)localObject).setVisibility(8);
            localImageView.setVisibility(0);
            localURLDrawable.restartDownload();
            if (!(localImageView.getDrawable() instanceof Animatable)) {
              localImageView.setImageDrawable((Drawable)paramView.getContext().getResources().getDrawable(2130847934));
            }
            ((Animatable)localImageView.getDrawable()).start();
          }
        }
        else
        {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */