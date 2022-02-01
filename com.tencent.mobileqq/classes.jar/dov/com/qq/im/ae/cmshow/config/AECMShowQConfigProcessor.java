package dov.com.qq.im.ae.cmshow.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import dov.com.qq.im.ae.util.AEQLog;

public class AECMShowQConfigProcessor
  extends IQConfigProcessor<AECMShowConfig>
{
  @NonNull
  public AECMShowConfig a(int paramInt)
  {
    AEQLog.a("AECMShowQConfigProcessor", "[migrateOldOrDefaultContent]");
    return new AECMShowConfig();
  }
  
  @Nullable
  public AECMShowConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      AEQLog.a("AECMShowQConfigProcessor", "[onParsed] content=" + paramArrayOfQConfItem[0].a);
      return AECMShowConfigManager.a(paramArrayOfQConfItem[0].a);
    }
    AEQLog.a("AECMShowQConfigProcessor", "[onParsed] config invalid");
    return null;
  }
  
  public void a(AECMShowConfig paramAECMShowConfig)
  {
    AEQLog.a("AECMShowQConfigProcessor", "[onUpdate]");
    AECMShowConfigManager.a().a(paramAECMShowConfig);
  }
  
  public Class<AECMShowConfig> clazz()
  {
    return AECMShowConfig.class;
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
    AEQLog.a("AECMShowQConfigProcessor", "[migrateOldVersion]");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    AEQLog.a("AECMShowQConfigProcessor", "[onReqFailed], failCode=" + paramInt);
  }
  
  public int onSend(int paramInt)
  {
    AEQLog.a("AECMShowQConfigProcessor", "[onSend], confVersion=" + paramInt);
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 700;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.config.AECMShowQConfigProcessor
 * JD-Core Version:    0.7.0.1
 */