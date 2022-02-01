package com.tencent.mobileqq.vashealth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VSHealthConfigProcessor
  extends IQConfigProcessor<VSHealthConfigBean>
{
  @NonNull
  public VSHealthConfigBean a(int paramInt)
  {
    return new VSHealthConfigBean();
  }
  
  @Nullable
  public VSHealthConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = str;
      if (paramArrayOfQConfItem.length > 0)
      {
        str = paramArrayOfQConfItem[0].a;
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = new VSHealthConfigBean();
        }
      }
    }
    try
    {
      localObject2 = new JSONObject(str);
      boolean bool = "1".equals(((JSONObject)localObject2).optString("is_redirect_aio_to_main_page"));
      localObject2 = ((JSONObject)localObject2).optString("main_page_url");
      ((VSHealthConfigBean)localObject1).a(bool);
      ((VSHealthConfigBean)localObject1).a((String)localObject2);
      a((VSHealthConfigBean)localObject1);
      QLog.e("VSHealthConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VSHealthConfigProcessor", 1, "[onParsed] parseConfig error! ", localJSONException);
      }
    }
  }
  
  public void a(VSHealthConfigBean paramVSHealthConfigBean)
  {
    QLog.i("VSHealthConfigProcessor", 2, "onUpdate ");
    if (paramVSHealthConfigBean != null)
    {
      QLog.d("VSHealthConfigProcessor", 2, "onUpdate " + paramVSHealthConfigBean.toString());
      VSConfigManager.a().a("is_redirect_aio_to_main_page", Boolean.valueOf(paramVSHealthConfigBean.a()));
      VSConfigManager.a().a("main_page_jump_url", paramVSHealthConfigBean.a());
    }
  }
  
  public Class<VSHealthConfigBean> clazz()
  {
    return VSHealthConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 671;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VSHealthConfigProcessor
 * JD-Core Version:    0.7.0.1
 */