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
    int i = 0;
    if (TextUtils.isEmpty(paramTask.base64)) {
      return;
    }
    if (TextUtils.isEmpty(paramTask.base64)) {
      i = 101;
    }
    while (i != 0)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "call qzone upload ret:" + i);
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("status", 2);
        localJSONObject1.put("code", i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", paramTask.id);
        localJSONObject2.put("url", "");
        localJSONObject1.put("data", localJSONObject2);
        localJSONObject1.put("msg", "");
        this.parentPlugin.callJs(paramTask.jsCallback, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramTask)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", paramTask);
        return;
        paramTask.localTmpPath = QzoneUploadInterface.toLocal(this.parentPlugin.mRuntime.a(), paramTask.base64);
        if ((!TextUtils.isEmpty(paramTask.localTmpPath)) && (new File(paramTask.localTmpPath).exists()))
        {
          this.pathMap.put(paramTask.localTmpPath, Integer.valueOf(paramTask.id));
          if (!QzoneUploadInterface.upload(paramTask.localTmpPath, paramTask.bid)) {
            i = 102;
          }
        }
        else
        {
          i = 103;
        }
      }
      catch (Exception paramTask)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", paramTask);
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
      QLog.d("js-upload: QzoneUploadPlugin", 1, "callback invoke ... task.jsCallback:" + paramVarArgs.getString("callback"));
      this.parentPlugin.callJs(paramVarArgs.getString("callback"), new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", paramVarArgs);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      paramString = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.REQUEST_PICK_PHOTO) && (j == -1)) {}
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("QzoneUpload")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!paramString3.equals("ups")) {
      return false;
    }
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
  
  /* Error */
  protected void handleUpload(String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 20
    //   2: iconst_1
    //   3: ldc_w 262
    //   6: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: new 92	org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: iconst_0
    //   15: aaload
    //   16: invokespecial 206	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: new 59	cooperation/qzone/webviewplugin/QzoneUploadPlugin$Task
    //   23: dup
    //   24: aload_0
    //   25: aload_2
    //   26: ldc 103
    //   28: invokevirtual 266	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   31: invokespecial 269	cooperation/qzone/webviewplugin/QzoneUploadPlugin$Task:<init>	(Lcooperation/qzone/webviewplugin/QzoneUploadPlugin;I)V
    //   34: astore_1
    //   35: aload_1
    //   36: aload_2
    //   37: ldc_w 270
    //   40: invokevirtual 214	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: putfield 62	cooperation/qzone/webviewplugin/QzoneUploadPlugin$Task:base64	Ljava/lang/String;
    //   46: aload_1
    //   47: aload_2
    //   48: ldc_w 271
    //   51: invokevirtual 214	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: putfield 179	cooperation/qzone/webviewplugin/QzoneUploadPlugin$Task:bid	Ljava/lang/String;
    //   57: aload_1
    //   58: aload_2
    //   59: ldc 210
    //   61: invokevirtual 214	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 123	cooperation/qzone/webviewplugin/QzoneUploadPlugin$Task:jsCallback	Ljava/lang/String;
    //   67: aload_1
    //   68: ifnull +26 -> 94
    //   71: aload_0
    //   72: getfield 50	cooperation/qzone/webviewplugin/QzoneUploadPlugin:taskMap	Ljava/util/Map;
    //   75: aload_1
    //   76: getfield 105	cooperation/qzone/webviewplugin/QzoneUploadPlugin$Task:id	I
    //   79: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aload_1
    //   83: invokeinterface 176 3 0
    //   88: pop
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 273	cooperation/qzone/webviewplugin/QzoneUploadPlugin:doUploadTask	(Lcooperation/qzone/webviewplugin/QzoneUploadPlugin$Task;)V
    //   94: return
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: ldc 20
    //   100: iconst_1
    //   101: ldc 134
    //   103: aload_2
    //   104: invokestatic 137	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -40 -> 67
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_1
    //   113: ldc 20
    //   115: iconst_1
    //   116: ldc_w 275
    //   119: aload_2
    //   120: invokestatic 137	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: goto -56 -> 67
    //   126: astore_2
    //   127: goto -14 -> 113
    //   130: astore_2
    //   131: goto -33 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	QzoneUploadPlugin
    //   0	134	1	paramVarArgs	String[]
    //   19	40	2	localJSONObject	JSONObject
    //   95	9	2	localJSONException1	JSONException
    //   110	10	2	localException1	Exception
    //   126	1	2	localException2	Exception
    //   130	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   9	35	95	org/json/JSONException
    //   9	35	110	java/lang/Exception
    //   35	67	126	java/lang/Exception
    //   35	67	130	org/json/JSONException
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == this.REQUEST_PICK_PHOTO) {}
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("js-upload: QzoneUploadPlugin", 1, "call js function, bundle is empty");
        return;
      }
    } while (!"cmd.qzoneUploadUps".equals(paramString));
    int j = paramBundle.getInt("param.uploadStatus", -1);
    int i = paramBundle.getInt("param.uploadResult", -1);
    paramString = paramBundle.getString("param.tmpLocalFile");
    Object localObject = paramBundle.getString("param.uploadResultUrl");
    QLog.w("js-upload: QzoneUploadPlugin", 1, "onWebEvent status:" + j + " code:" + i + " url:" + (String)localObject);
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
      QLog.w("js-upload: QzoneUploadPlugin", 1, "task == null, id:" + j);
      return;
    }
    paramBundle.url = ((String)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 4);
      ((JSONObject)localObject).put("code", i);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramBundle.id);
      localJSONObject.put("url", paramBundle.url);
      ((JSONObject)localObject).put("data", localJSONObject);
      ((JSONObject)localObject).put("msg", "");
      QLog.d("js-upload: QzoneUploadPlugin", 1, "callback invoke ... task.jsCallback:" + paramBundle.jsCallback + " result:" + ((JSONObject)localObject).toString());
      this.parentPlugin.callJs(paramBundle.jsCallback, new String[] { ((JSONObject)localObject).toString() });
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new File(paramString);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      this.taskMap.remove(Integer.valueOf(j));
      this.pathMap.remove(paramString);
      paramBundle.localTmpPath = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", localJSONException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUploadPlugin
 * JD-Core Version:    0.7.0.1
 */