package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.os.Bundle;
import bjde;
import bjdf;
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

public class MediaChooseJsProxyImpl$1$1
  implements Runnable
{
  public MediaChooseJsProxyImpl$1$1(bjdf parambjdf, Intent paramIntent) {}
  
  public void run()
  {
    for (;;)
    {
      int k;
      JSONArray localJSONArray;
      try
      {
        Object localObject = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((this.jdField_a_of_type_AndroidContentIntent.getExtras() == null) || (!this.jdField_a_of_type_AndroidContentIntent.getExtras().containsKey("PhotoConst.VIDEO_INFOS"))) {
          break label577;
        }
        HashMap localHashMap = (HashMap)this.jdField_a_of_type_AndroidContentIntent.getExtras().get("PhotoConst.VIDEO_INFOS");
        if ((localObject == null) || (((ArrayList)localObject).size() == 0))
        {
          bjde.a(this.jdField_a_of_type_Bjdf.a, bjde.a(this.jdField_a_of_type_Bjdf.a), "chooseVideo", null);
          return;
        }
        bjde.a(this.jdField_a_of_type_Bjdf.a, "正在获取媒体信息");
        int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        k = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
        localJSONArray = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("tempFilePath", ((IMiniAppFileManager)bjde.a(this.jdField_a_of_type_Bjdf.a).getManager(IMiniAppFileManager.class)).getWxFilePath(str));
          localJSONObject2.put("size", new File(str).length());
          if ((localHashMap != null) && (localHashMap.containsKey(Integer.valueOf(i))))
          {
            localJSONObject2.put("type", "video");
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localHashMap.get(Integer.valueOf(i));
            localJSONObject2.put("duration", localLocalMediaInfo.mDuration);
            localJSONObject2.put("width", localLocalMediaInfo.mediaWidth);
            localJSONObject2.put("height", localLocalMediaInfo.mediaHeight);
            bjde.a(this.jdField_a_of_type_Bjdf.a, bjde.a(this.jdField_a_of_type_Bjdf.a, str), localLocalMediaInfo);
            localJSONObject2.put("thumbTempFilePath", localLocalMediaInfo.thumbnailPath);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
          localJSONObject2.put("type", "image");
          if ((k != 0) || (j != 0)) {
            break label583;
          }
          str = bjde.a(this.jdField_a_of_type_Bjdf.a, str);
          localJSONObject2.put("tempFilePath", ((IMiniAppFileManager)bjde.a(this.jdField_a_of_type_Bjdf.a).getManager(IMiniAppFileManager.class)).getWxFilePath(str));
          localJSONObject2.put("size", new File(str).length());
          continue;
        }
        localJSONObject1 = new JSONObject();
      }
      catch (Exception localException)
      {
        QLog.e("MediaChooseJsProxyImpl", 1, "get media info failed", localException);
        bjde.a(this.jdField_a_of_type_Bjdf.a, bjde.a(this.jdField_a_of_type_Bjdf.a), "chooseVideo", null, "chooseMedia exception:" + localException.getMessage());
        bjde.a(this.jdField_a_of_type_Bjdf.a);
        return;
      }
      localJSONObject1.put("tempFiles", localJSONArray);
      bjde.b(this.jdField_a_of_type_Bjdf.a, bjde.a(this.jdField_a_of_type_Bjdf.a), "chooseVideo", localJSONObject1);
      bjde.a(this.jdField_a_of_type_Bjdf.a);
      return;
      label577:
      JSONObject localJSONObject1 = null;
      continue;
      label583:
      if (k != 2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */