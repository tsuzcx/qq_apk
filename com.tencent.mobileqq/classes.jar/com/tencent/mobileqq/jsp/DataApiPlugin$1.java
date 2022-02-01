package com.tencent.mobileqq.jsp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

class DataApiPlugin$1
  extends OnRemoteRespObserver
{
  DataApiPlugin$1(DataApiPlugin paramDataApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject1;
    String str1;
    int i;
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.b.key))
    {
      localObject1 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      boolean bool = QLog.isColorLevel();
      i = 2;
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("response:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("DataApiPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 != null) && (!"getUserVipType".equals(localObject1))) {}
    }
    try
    {
      localObject1 = new JSONObject();
      i = paramBundle.getInt("type");
      ((JSONObject)localObject1).put("result", 0);
      ((JSONObject)localObject1).put("message", "ok");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", paramBundle.getString("uin"));
      ((JSONObject)localObject2).put("type", i);
      ((JSONObject)localObject1).put("data", localObject2);
      if (!TextUtils.isEmpty(str1))
      {
        paramBundle = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        ((StringBuilder)localObject2).append(");");
        paramBundle.callJs(((StringBuilder)localObject2).toString());
        return;
        if ("getFaceFilePath".equals(localObject1)) {
          try
          {
            localObject2 = new JSONObject();
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getString("faceFilePath");
              if (new File(paramBundle).exists()) {
                localObject1 = ImageUtil.a(new BitmapFactory.Options(), paramBundle, 200);
              }
            }
          }
          catch (Exception paramBundle)
          {
            int j;
            label375:
            String str2;
            label384:
            StringBuilder localStringBuilder;
            label512:
            if (!QLog.isColorLevel()) {}
          }
        }
      }
    }
    catch (JSONException paramBundle)
    {
      return;
    }
    try
    {
      paramBundle = BitmapFactory.decodeFile(paramBundle, (BitmapFactory.Options)localObject1);
      i = paramBundle.getWidth();
      j = paramBundle.getHeight();
      localObject1 = ImageUtil.a(paramBundle, i, i, j);
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        break label384;
      }
      paramBundle = (Bundle)localObject1;
      if (((Bitmap)localObject1).getWidth() <= 200) {
        break label384;
      }
      paramBundle = ImageUtil.a((Bitmap)localObject1, 200);
    }
    catch (OutOfMemoryError paramBundle)
    {
      break label375;
    }
    paramBundle = null;
    break label384;
    paramBundle = ImageUtil.k();
    if (paramBundle == null)
    {
      ((JSONObject)localObject2).put("result", 1002);
    }
    else
    {
      localObject1 = new ByteArrayOutputStream();
      paramBundle.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
      str2 = Base64Util.encodeToString(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      ((JSONObject)localObject2).put("result", 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("data:image/png;base64,");
      localStringBuilder.append(str2);
      ((JSONObject)localObject2).put("file", localStringBuilder.toString());
      ((JSONObject)localObject2).put("size", paramBundle.getWidth());
      ((ByteArrayOutputStream)localObject1).close();
      break label512;
      ((JSONObject)localObject2).put("result", 1002);
    }
    if (!TextUtils.isEmpty(str1))
    {
      paramBundle = this.a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
      ((StringBuilder)localObject1).append(");");
      paramBundle.callJs(((StringBuilder)localObject1).toString());
      return;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("response IPC_FUNC_CMD_GET_FACE_FILE_PATH error: ");
      ((StringBuilder)localObject1).append(paramBundle.getMessage());
      QLog.i("DataApiPlugin", 2, ((StringBuilder)localObject1).toString());
      return;
      if ("checkRelation".equals(localObject1))
      {
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("result", 0);
          localObject2 = new JSONObject();
          if (paramBundle.getBoolean("result", false)) {
            i = 1;
          }
          ((JSONObject)localObject2).put("relation", i);
          ((JSONObject)localObject1).put("data", localObject2);
          if (!TextUtils.isEmpty(str1))
          {
            this.a.callJs(str1, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */