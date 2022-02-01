package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "qqgamepubaccount-api_release"}, k=1, mv={1, 1, 16})
public final class DnFlutterConfProcessor
  extends IQConfigProcessor<DnFlutterConfigBean>
{
  public static final DnFlutterConfProcessor.Companion a = new DnFlutterConfProcessor.Companion(null);
  
  @NotNull
  public DnFlutterConfigBean a(int paramInt)
  {
    return new DnFlutterConfigBean();
  }
  
  @Nullable
  public DnFlutterConfigBean a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "confFiles");
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_DnFlutterConfProcessor", 2, "GameCenterEnterConfProcessor onParsed ");
    }
    int i;
    if (paramArrayOfQConfItem.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i ^ 0x1) != 0) {
      return DnFlutterConfigBean.a.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(@Nullable DnFlutterConfigBean paramDnFlutterConfigBean) {}
  
  @NotNull
  public Class<DnFlutterConfigBean> clazz()
  {
    return DnFlutterConfigBean.class;
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
    return 753;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.DnFlutterConfProcessor
 * JD-Core Version:    0.7.0.1
 */