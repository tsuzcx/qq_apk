package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.ac.ArticleCenter.GetUrlByVidResponse;
import tencent.im.oidb.ac.ArticleCenter.RetInfo;
import tencent.im.oidb.ac.ArticleCenter.VideoInfo;

public class VideoUrlInfo
  extends AbsVideoUrlInfo
{
  public int m = 0;
  public ArrayList<VideoUrlInfo> n = new ArrayList();
  
  public VideoUrlInfo() {}
  
  public VideoUrlInfo(String paramString)
  {
    this.b = paramString;
  }
  
  public static VideoUrlInfo a(String paramString, ArticleCenter.VideoInfo paramVideoInfo)
  {
    VideoUrlInfo localVideoUrlInfo = new VideoUrlInfo();
    if (paramVideoInfo != null)
    {
      localVideoUrlInfo.b = paramString;
      paramString = paramVideoInfo.url.get();
      String str = "";
      if (paramString != null) {
        paramString = paramVideoInfo.url.get().toStringUtf8();
      } else {
        paramString = "";
      }
      localVideoUrlInfo.a = paramString;
      int i = paramVideoInfo.encode_type.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localVideoUrlInfo.c = bool;
      paramString = str;
      if (paramVideoInfo.rate.get() != null) {
        paramString = paramVideoInfo.rate.get().toStringUtf8();
      }
      localVideoUrlInfo.e = paramString;
      localVideoUrlInfo.i = paramVideoInfo.width.get();
      localVideoUrlInfo.j = paramVideoInfo.height.get();
    }
    return localVideoUrlInfo;
  }
  
  private static String a(ArticleCenter.GetUrlByVidResponse paramGetUrlByVidResponse)
  {
    int j = paramGetUrlByVidResponse.encode_type.get();
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    ArticleCenter.VideoInfo localVideoInfo = null;
    ArticleCenter.GetUrlByVidResponse localGetUrlByVidResponse = null;
    if (i == 0) {
      return null;
    }
    Object localObject = localVideoInfo;
    try
    {
      if (paramGetUrlByVidResponse.rate.get() != null)
      {
        localObject = localVideoInfo;
        if (Long.valueOf(paramGetUrlByVidResponse.rate.get().toStringUtf8()).longValue() == 0L) {
          return null;
        }
        localObject = localVideoInfo;
        long l3 = Long.valueOf(paramGetUrlByVidResponse.rate.get().toStringUtf8()).longValue();
        long l1 = 9223372036854775807L;
        localObject = localVideoInfo;
        if (paramGetUrlByVidResponse.video_info.has())
        {
          localObject = localVideoInfo;
          if (paramGetUrlByVidResponse.video_info.get().size() > 0)
          {
            localObject = localVideoInfo;
            Iterator localIterator = paramGetUrlByVidResponse.video_info.get().iterator();
            paramGetUrlByVidResponse = localGetUrlByVidResponse;
            for (;;)
            {
              localGetUrlByVidResponse = paramGetUrlByVidResponse;
              localObject = localGetUrlByVidResponse;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = localGetUrlByVidResponse;
              localVideoInfo = (ArticleCenter.VideoInfo)localIterator.next();
              if (localVideoInfo == null)
              {
                paramGetUrlByVidResponse = localGetUrlByVidResponse;
              }
              else
              {
                paramGetUrlByVidResponse = localGetUrlByVidResponse;
                long l2;
                try
                {
                  if (localVideoInfo.encode_type.get() != 0) {
                    continue;
                  }
                  paramGetUrlByVidResponse = localGetUrlByVidResponse;
                  if (Long.valueOf(localVideoInfo.rate.get().toStringUtf8()).longValue() == 0L) {
                    continue;
                  }
                  paramGetUrlByVidResponse = localGetUrlByVidResponse;
                  if (TextUtils.isEmpty(localVideoInfo.url.get().toStringUtf8())) {
                    continue;
                  }
                  l2 = Math.abs(l3 - Long.valueOf(localVideoInfo.rate.get().toStringUtf8()).longValue());
                  paramGetUrlByVidResponse = localGetUrlByVidResponse;
                  if (l2 >= l1) {
                    continue;
                  }
                  try
                  {
                    paramGetUrlByVidResponse = localVideoInfo.url.get().toStringUtf8();
                    l1 = l2;
                  }
                  catch (Exception localException1) {}
                  paramGetUrlByVidResponse = localGetUrlByVidResponse;
                }
                catch (Exception localException2)
                {
                  l2 = l1;
                }
                l1 = l2;
                localObject = localGetUrlByVidResponse;
                if (QLog.isColorLevel())
                {
                  localObject = localGetUrlByVidResponse;
                  QLog.e("Q.readinjoy.video.VideoUrlInfo", 2, "innerChooseHWBackupUrlForHevc error 1:", localException2);
                  paramGetUrlByVidResponse = localGetUrlByVidResponse;
                  l1 = l2;
                }
              }
            }
            localObject = localGetUrlByVidResponse;
            PublicAccountReportUtils.a(null, null, "0X8009824", "0X8009824", 0, 0, "", "", "", "", false);
            return localGetUrlByVidResponse;
          }
        }
        localObject = localException2;
        PublicAccountReportUtils.a(null, null, "0X8009825", "0X8009825", 0, 0, "", "", "", "", false);
        return null;
      }
      return null;
    }
    catch (Exception paramGetUrlByVidResponse)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUrlInfo", 2, "innerChooseHWBackupUrlForHevc error 2:", paramGetUrlByVidResponse);
      }
    }
    return localObject;
  }
  
  static boolean a(ArticleCenter.GetUrlByVidResponse paramGetUrlByVidResponse, VideoUrlInfo paramVideoUrlInfo)
  {
    paramVideoUrlInfo.a = RIJPBFieldUtils.d(paramGetUrlByVidResponse.url);
    paramVideoUrlInfo.k = paramGetUrlByVidResponse.ret_info.ret_code.get();
    paramVideoUrlInfo.m = paramGetUrlByVidResponse.video_type.get();
    int i = paramGetUrlByVidResponse.encode_type.get();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramVideoUrlInfo.c = bool1;
    paramVideoUrlInfo.i = paramGetUrlByVidResponse.width.get();
    paramVideoUrlInfo.j = paramGetUrlByVidResponse.height.get();
    paramVideoUrlInfo.e = RIJPBFieldUtils.d(paramGetUrlByVidResponse.rate);
    paramVideoUrlInfo.f = paramGetUrlByVidResponse.file_size.get();
    if (paramVideoUrlInfo.c) {
      paramVideoUrlInfo.h = a(paramGetUrlByVidResponse);
    }
    Object localObject1 = RIJPBFieldUtils.d(paramGetUrlByVidResponse.json_video_detail);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      if (paramVideoUrlInfo.c) {
        paramVideoUrlInfo.d = ((JSONObject)localObject2).optBoolean("isH265HWCodec", true);
      }
      paramVideoUrlInfo.g = ((JSONObject)localObject2).optString("reportInfo", "");
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break label240;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive CMD_VIDEO_UUIDFORURL jsonVideoDetail = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Q.readinjoy.video.VideoUrlInfo", 2, ((StringBuilder)localObject2).toString());
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      label238:
      break label238;
    }
    bool1 = true;
    label240:
    paramGetUrlByVidResponse = paramGetUrlByVidResponse.video_info.get();
    if ((paramGetUrlByVidResponse != null) && (paramGetUrlByVidResponse.size() > 0))
    {
      paramGetUrlByVidResponse = paramGetUrlByVidResponse.iterator();
      while (paramGetUrlByVidResponse.hasNext())
      {
        localObject1 = (ArticleCenter.VideoInfo)paramGetUrlByVidResponse.next();
        localObject1 = a(paramVideoUrlInfo.b, (ArticleCenter.VideoInfo)localObject1);
        paramVideoUrlInfo.n.add(localObject1);
      }
    }
    return bool1;
  }
  
  public boolean a(long paramLong)
  {
    return (paramLong - this.l > 0L) && (paramLong - this.l < 7200L);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 - this.l > 0L) && (paramLong1 - this.l < paramLong2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidUrl {\n vid: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n url: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n errorCode: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n width: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n height: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n isH265: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n fileBitRate: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n isHWCodec: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n videoReportInfo:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n hwBackupURL:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo
 * JD-Core Version:    0.7.0.1
 */