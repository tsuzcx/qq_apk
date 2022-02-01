package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class MediaChooseJsProxyImpl$1$1
  implements Runnable
{
  MediaChooseJsProxyImpl$1$1(MediaChooseJsProxyImpl.1 param1, Intent paramIntent) {}
  
  public void run()
  {
    for (;;)
    {
      int k;
      try
      {
        localObject3 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((this.jdField_a_of_type_AndroidContentIntent.getExtras() != null) && (this.jdField_a_of_type_AndroidContentIntent.getExtras().containsKey("PhotoConst.VIDEO_INFOS")))
        {
          Object localObject1 = (HashMap)this.jdField_a_of_type_AndroidContentIntent.getExtras().get("PhotoConst.VIDEO_INFOS");
          if ((localObject3 != null) && (((ArrayList)localObject3).size() != 0))
          {
            MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a, "正在获取媒体信息");
            localObject4 = this.jdField_a_of_type_AndroidContentIntent;
            i = 0;
            int j = ((Intent)localObject4).getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
            k = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
            localObject4 = new JSONArray();
            localObject3 = ((ArrayList)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              String str = (String)((Iterator)localObject3).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("tempFilePath", ((IMiniAppFileManager)MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a).getManager(IMiniAppFileManager.class)).getWxFilePath(str));
              localJSONObject.put("size", new File(str).length());
              if ((localObject1 != null) && (((HashMap)localObject1).containsKey(Integer.valueOf(i))))
              {
                localJSONObject.put("type", "video");
                LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((HashMap)localObject1).get(Integer.valueOf(i));
                localJSONObject.put("duration", localLocalMediaInfo.mDuration);
                localJSONObject.put("width", localLocalMediaInfo.mediaWidth);
                localJSONObject.put("height", localLocalMediaInfo.mediaHeight);
                MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a, str), localLocalMediaInfo);
                localJSONObject.put("thumbTempFilePath", localLocalMediaInfo.thumbnailPath);
              }
              else
              {
                localJSONObject.put("type", "image");
                if ((k != 0) || (j != 0)) {
                  break label609;
                }
                str = MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a, str);
                localJSONObject.put("tempFilePath", ((IMiniAppFileManager)MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a).getManager(IMiniAppFileManager.class)).getWxFilePath(str));
                localJSONObject.put("size", new File(str).length());
              }
              ((JSONArray)localObject4).put(localJSONObject);
              i += 1;
              continue;
            }
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("tempFiles", localObject4);
            MediaChooseJsProxyImpl.b(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a), "chooseVideo", (JSONObject)localObject1);
            MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a);
            return;
          }
          MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a), "chooseVideo", null);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MediaChooseJsProxyImpl", 1, "get media info failed", localException);
        Object localObject3 = this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a;
        int i = MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a);
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("chooseMedia exception:");
        ((StringBuilder)localObject4).append(localException.getMessage());
        MediaChooseJsProxyImpl.a((MediaChooseJsProxyImpl)localObject3, i, "chooseVideo", null, ((StringBuilder)localObject4).toString());
        MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl$1.a);
        return;
      }
      Object localObject2 = null;
      continue;
      label609:
      if (k != 2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */