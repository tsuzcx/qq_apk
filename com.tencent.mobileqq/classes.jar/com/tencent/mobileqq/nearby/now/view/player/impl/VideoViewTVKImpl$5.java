package com.tencent.mobileqq.nearby.now.view.player.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnDownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class VideoViewTVKImpl$5
  implements TVK_IMediaPlayer.OnDownloadCallbackListener
{
  VideoViewTVKImpl$5(VideoViewTVKImpl paramVideoViewTVKImpl, String paramString1, String paramString2, String paramString3) {}
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.d.n != null) {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.getInt("callBackType");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnDownloadCallback callBackType=");
          localStringBuilder.append(i);
          QLog.d("VideoViewTVKImpl", 2, localStringBuilder.toString());
        }
        if (i == 7)
        {
          if (!TextUtils.isEmpty(this.a))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("OnDownloadCallback success , vid = ");
              paramString.append(this.b);
              QLog.d("VideoViewTVKImpl", 2, paramString.toString());
            }
            this.d.n.a(this.b, this.c, new File(this.a));
          }
        }
        else if ((i != 4) && (i != 5))
        {
          long l1;
          if (i == 2)
          {
            l1 = paramString.getLong("fileSize");
            long l2 = paramString.getLong("offset");
            this.d.n.a(this.b, this.c, l1, l2);
            return;
          }
          if (i == 1)
          {
            l1 = paramString.getLong("fileSize");
            this.d.n.a(this.b, this.c, l1);
          }
        }
        else
        {
          i = paramString.getInt("errorCode");
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("OnDownloadCallback errorCode=");
            paramString.append(i);
            QLog.d("VideoViewTVKImpl", 2, paramString.toString());
          }
          this.d.n.a(this.b, this.c, i);
          return;
        }
      }
      catch (JSONException paramString)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnDownloadCallback JSONException=");
          localStringBuilder.append(paramString.getMessage());
          QLog.d("VideoViewTVKImpl", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl.5
 * JD-Core Version:    0.7.0.1
 */