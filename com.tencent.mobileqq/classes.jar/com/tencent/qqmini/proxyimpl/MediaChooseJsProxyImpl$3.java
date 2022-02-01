package com.tencent.qqmini.proxyimpl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class MediaChooseJsProxyImpl$3
  implements IActivityResultListener
{
  MediaChooseJsProxyImpl$3(MediaChooseJsProxyImpl paramMediaChooseJsProxyImpl, IActivityResultManager paramIActivityResultManager) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 10020) {
      return false;
    }
    if (paramInt2 != -1)
    {
      MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl), "chooseVideo", null);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    Object localObject = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        paramIntent = new JSONObject();
        String str = ((PublishParam)localObject).j;
        l1 = new File(str).length();
        long l2 = ((PublishParam)localObject).jdField_a_of_type_Long;
        paramInt1 = ((PublishParam)localObject).jdField_a_of_type_Int;
        paramInt2 = ((PublishParam)localObject).b;
        localObject = ((PublishParam)localObject).c;
        paramIntent.put("tempFilePath", ((IMiniAppFileManager)MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl).getManager(IMiniAppFileManager.class)).getWxFilePath(str));
        paramIntent.put("type", "video");
        paramIntent.put("size", l1);
        paramIntent.put("duration", l2);
        paramIntent.put("width", paramInt1);
        paramIntent.put("height", paramInt2);
        paramIntent.put("thumbTempFilePath", ((IMiniAppFileManager)MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl).getManager(IMiniAppFileManager.class)).getWxFilePath((String)localObject));
        localObject = new JSONArray();
        ((JSONArray)localObject).put(paramIntent);
        paramIntent = new JSONObject();
        paramIntent.put("tempFiles", localObject);
        MediaChooseJsProxyImpl.b(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl), "chooseVideo", paramIntent);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
        return true;
      }
      catch (Exception paramIntent)
      {
        QLog.e("MediaChooseJsProxyImpl", 1, "camera for video parse failed", paramIntent);
        MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl), "chooseVideo", null, "chooseMedia exception:" + paramIntent.getMessage());
        continue;
      }
      if (TextUtils.isEmpty(paramIntent)) {
        continue;
      }
      long l1 = new File(paramIntent).length();
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tempFilePath", ((IMiniAppFileManager)MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl).getManager(IMiniAppFileManager.class)).getWxFilePath(paramIntent));
        ((JSONObject)localObject).put("type", "image");
        ((JSONObject)localObject).put("size", l1);
        paramIntent = new JSONArray();
        paramIntent.put(localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tempFiles", paramIntent);
        MediaChooseJsProxyImpl.b(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl), "chooseVideo", (JSONObject)localObject);
        MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl), "chooseVideo", null, "chooseMedia fail.");
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.e("MediaChooseJsProxyImpl", 1, "camera for image parse failed", paramIntent);
          MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl, MediaChooseJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl), "chooseVideo", null, "chooseMedia exception:" + paramIntent.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */