package com.tencent.mobileqq.filemanager.guild;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.CheckResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VideoForGuild$2
  implements QQFileManagerUtil.CheckResult
{
  VideoForGuild$2(VideoForGuild paramVideoForGuild, FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback, long paramLong, boolean paramBoolean1, String paramString1, List paramList, String paramString2, short paramShort, boolean paramBoolean2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("shouq_bus_type", "bus_type_video_file");
      localObject2 = new TVK_PlayerVideoInfo();
      ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap((Map)localObject1);
      ((TVK_PlayerVideoInfo)localObject2).setPlayType(4);
      ((TVK_PlayerVideoInfo)localObject2).setConfigMap("RawVideoPlay", "true");
      ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
      this.a.a();
      return;
    }
    long l = this.b;
    if (l != -100001L)
    {
      if ((l == -25081L) || (l == -6101L) || (l == -7003L)) {
        break label381;
      }
      if (!this.c)
      {
        this.a.a((int)9045L, BaseApplication.getContext().getResources().getString(2131887903));
        return;
      }
    }
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((String)localObject1).length() != 0))
    {
      Object localObject3 = this.d;
      localObject1 = this.e;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = this.f;
        localObject2 = this.e;
      }
      else
      {
        localObject2 = null;
        localObject1 = "";
      }
      localObject2 = VideoForGuild.a(this.k, (String)localObject1, this.g, (List)localObject2, this.h);
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localObject2;
      }
      localObject2 = this.i;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("http://");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(String.valueOf(this.g));
      ((StringBuilder)localObject3).append(this.j);
      localObject1 = ((StringBuilder)localObject3).toString();
      this.a.a((String)localObject1, (String)localObject2);
      return;
    }
    l = 9360L;
    if (this.b == 0L) {
      l = 9048L;
    }
    this.a.a((int)l, BaseApplication.getContext().getResources().getString(2131887903));
    return;
    label381:
    this.k.a(true);
    this.a.a((int)this.b, BaseApplication.getContext().getResources().getString(2131889822));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.VideoForGuild.2
 * JD-Core Version:    0.7.0.1
 */