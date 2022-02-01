package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneUploadPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private static final int CALL_UPLOAD_ERROR = 102;
  public static final String NAMESPACE = "QzoneUpload";
  private static final int PARSE_PARAMS_ERROR = 101;
  private static final int SAVE_TOLOCAL_ERROR = 103;
  private static final String TAG = "js-upload: QzoneUploadPlugin";
  private byte REQUEST_PICK_PHOTO = 115;
  private boolean inited = false;
  public int mFrom = 4;
  public int mSource = 0;
  private Map<String, Integer> pathMap = new HashMap();
  private Map<Integer, QzoneUploadPlugin.Task> taskMap = new HashMap();
  
  private void doUploadTask(QzoneUploadPlugin.Task paramTask)
  {
    if (TextUtils.isEmpty(paramTask.base64)) {
      return;
    }
    int i;
    if (TextUtils.isEmpty(paramTask.base64))
    {
      i = 101;
    }
    else
    {
      paramTask.localTmpPath = QzoneUploadInterface.toLocal(this.parentPlugin.mRuntime.a(), paramTask.base64);
      if ((!TextUtils.isEmpty(paramTask.localTmpPath)) && (new File(paramTask.localTmpPath).exists()))
      {
        this.pathMap.put(paramTask.localTmpPath, Integer.valueOf(paramTask.id));
        if (!QzoneUploadInterface.upload(paramTask.localTmpPath, paramTask.bid)) {
          i = 102;
        } else {
          i = 0;
        }
      }
      else
      {
        i = 103;
      }
    }
    if (i != 0)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call qzone upload ret:");
      ((StringBuilder)localObject).append(i);
      QLog.w("js-upload: QzoneUploadPlugin", 1, ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("status", 2);
        ((JSONObject)localObject).put("code", i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", paramTask.id);
        localJSONObject.put("url", "");
        ((JSONObject)localObject).put("data", localJSONObject);
        ((JSONObject)localObject).put("msg", "");
        this.parentPlugin.callJs(paramTask.jsCallback, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (Exception paramTask)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", paramTask);
        return;
      }
      catch (JSONException paramTask)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", paramTask);
      }
    }
  }
  
  private void init()
  {
    RemoteHandleManager.getInstance().addWebEventListener(this);
    this.inited = true;
  }
  
  private void notifyReceive(String... paramVarArgs)
  {
    QLog.i("js-upload: QzoneUploadPlugin", 1, "notify client receive upload task.");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", 1);
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callback invoke ... task.jsCallback:");
      localStringBuilder.append(paramVarArgs.getString("callback"));
      QLog.d("js-upload: QzoneUploadPlugin", 1, localStringBuilder.toString());
      this.parentPlugin.callJs(paramVarArgs.getString("callback"), new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", paramVarArgs);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", paramVarArgs);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO))
    {
      Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      paramString = (Intent)paramMap.get("data");
      Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      int i = this.REQUEST_PICK_PHOTO;
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("QzoneUpload")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (paramString3.equals("ups"))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          if (!this.inited) {
            init();
          }
          notifyReceive(paramVarArgs);
          handleUpload(paramVarArgs);
        }
        return true;
      }
    }
    return false;
  }
  
  protected void handleUpload(String... paramVarArgs)
  {
    QLog.i("js-upload: QzoneUploadPlugin", 1, "handle js upload request");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      paramVarArgs = new QzoneUploadPlugin.Task(this, localJSONObject.getInt("id"));
      try
      {
        paramVarArgs.base64 = localJSONObject.getString("base64");
        paramVarArgs.bid = localJSONObject.getString("bid");
        paramVarArgs.jsCallback = localJSONObject.getString("callback");
      }
      catch (Exception localException1) {}catch (JSONException localJSONException1) {}
      QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", localJSONException2);
    }
    catch (Exception localException2)
    {
      paramVarArgs = null;
      QLog.w("js-upload: QzoneUploadPlugin", 1, "handleUpload error !", localException2);
    }
    catch (JSONException localJSONException2)
    {
      paramVarArgs = null;
    }
    if (paramVarArgs != null)
    {
      this.taskMap.put(Integer.valueOf(paramVarArgs.id), paramVarArgs);
      doUploadTask(paramVarArgs);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    paramInt = this.REQUEST_PICK_PHOTO;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("js-upload: QzoneUploadPlugin", 1, "call js function, bundle is empty");
        return;
      }
      if ("cmd.qzoneUploadUps".equals(paramString))
      {
        int j = paramBundle.getInt("param.uploadStatus", -1);
        int i = paramBundle.getInt("param.uploadResult", -1);
        paramString = paramBundle.getString("param.tmpLocalFile");
        Object localObject1 = paramBundle.getString("param.uploadResultUrl");
        paramBundle = new StringBuilder();
        paramBundle.append("onWebEvent status:");
        paramBundle.append(j);
        paramBundle.append(" code:");
        paramBundle.append(i);
        paramBundle.append(" url:");
        paramBundle.append((String)localObject1);
        QLog.w("js-upload: QzoneUploadPlugin", 1, paramBundle.toString());
        if (TextUtils.isEmpty(paramString))
        {
          QLog.w("js-upload: QzoneUploadPlugin", 1, "localTmpPath == null !!");
          return;
        }
        paramBundle = (Integer)this.pathMap.get(paramString);
        if (paramBundle == null)
        {
          QLog.w("js-upload: QzoneUploadPlugin", 1, "ITaskId == null");
          return;
        }
        j = paramBundle.intValue();
        paramBundle = (QzoneUploadPlugin.Task)this.taskMap.get(Integer.valueOf(j));
        if (paramBundle == null)
        {
          paramString = new StringBuilder();
          paramString.append("task == null, id:");
          paramString.append(j);
          QLog.w("js-upload: QzoneUploadPlugin", 1, paramString.toString());
          return;
        }
        paramBundle.url = ((String)localObject1);
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("status", 4);
          ((JSONObject)localObject1).put("code", i);
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", paramBundle.id);
          ((JSONObject)localObject2).put("url", paramBundle.url);
          ((JSONObject)localObject1).put("data", localObject2);
          ((JSONObject)localObject1).put("msg", "");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("callback invoke ... task.jsCallback:");
          ((StringBuilder)localObject2).append(paramBundle.jsCallback);
          ((StringBuilder)localObject2).append(" result:");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.d("js-upload: QzoneUploadPlugin", 1, ((StringBuilder)localObject2).toString());
          this.parentPlugin.callJs(paramBundle.jsCallback, new String[] { ((JSONObject)localObject1).toString() });
        }
        catch (Exception localException)
        {
          QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", localException);
        }
        catch (JSONException localJSONException)
        {
          QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", localJSONException);
        }
        if (!TextUtils.isEmpty(paramString))
        {
          File localFile = new File(paramString);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        this.taskMap.remove(Integer.valueOf(j));
        this.pathMap.remove(paramString);
        paramBundle.localTmpPath = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUploadPlugin
 * JD-Core Version:    0.7.0.1
 */