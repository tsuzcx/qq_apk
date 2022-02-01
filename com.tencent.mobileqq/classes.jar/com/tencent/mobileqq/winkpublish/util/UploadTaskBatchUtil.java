package com.tencent.mobileqq.winkpublish.util;

import android.text.TextUtils;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class UploadTaskBatchUtil
{
  public static final String a;
  public static HashMap<Long, UploadTaskBatchUtil.UploadInfo> b;
  
  static
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(UploadConstants.a);
    ((StringBuilder)localObject1).append("UploadTaskBatchUtil");
    a = ((StringBuilder)localObject1).toString();
    b = new HashMap();
    localObject1 = LocalConfig.d("key_upload_task_flag", "", LoginData.a().b());
    Object localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("values:");
    localStringBuilder.append((String)localObject1);
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    int j;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1 != null)
      {
        j = localObject1.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          if ((localObject2 == null) || (localObject2.length < 5)) {}
        }
      }
      try
      {
        b.put(Long.valueOf(Long.parseLong(localObject2[0])), new UploadTaskBatchUtil.UploadInfo(Integer.parseInt(localObject2[1]), Integer.parseInt(localObject2[2]), Integer.parseInt(localObject2[3]), Integer.parseInt(localObject2[4])));
        label195:
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label195;
      }
    }
  }
  
  public static long a(long paramLong)
  {
    return LocalConfig.b("upload_multi_pic_pref_cache", String.valueOf(paramLong), 0L);
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    LocalConfig.a("upload_multi_pic_pref_cache", String.valueOf(paramLong1), paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.UploadTaskBatchUtil
 * JD-Core Version:    0.7.0.1
 */