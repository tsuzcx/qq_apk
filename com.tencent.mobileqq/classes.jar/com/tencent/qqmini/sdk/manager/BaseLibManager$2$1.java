package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

class BaseLibManager$2$1
  implements AsyncResult
{
  BaseLibManager$2$1(BaseLibManager.2 param2, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      ThreadManager.executeOnDiskIOThreadPool(new BaseLibManager.2.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (BaseLibManager.access$300(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0.doDownloadBaselib((String)localObject, paramJSONObject, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.val$listener);
      }
    }
    do
    {
      do
      {
        return;
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
      } while (this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.val$listener == null);
      this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.val$listener.onUpdateResult(1);
      return;
      QMLog.e("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    } while (this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.val$listener == null);
    this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.val$listener.onUpdateResult(1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2.1
 * JD-Core Version:    0.7.0.1
 */