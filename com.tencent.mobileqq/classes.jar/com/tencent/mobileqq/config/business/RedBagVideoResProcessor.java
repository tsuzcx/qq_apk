package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RedBagVideoResProcessor
  extends IQConfigProcessor<RedBagVideoResProcessor.RedBagVideoResConfigBean>
{
  @NonNull
  public RedBagVideoResProcessor.RedBagVideoResConfigBean a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = SharedPreUtils.n(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
    return new RedBagVideoResProcessor.RedBagVideoResConfigBean(SharedPreUtils.o(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin()), str);
  }
  
  @Nullable
  public RedBagVideoResProcessor.RedBagVideoResConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return null;
    }
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + paramArrayOfQConfItem);
    }
    try
    {
      paramArrayOfQConfItem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfQConfItem.getBytes("utf-8")));
      NodeList localNodeList = paramArrayOfQConfItem.getElementsByTagName("video_redbag_config");
      if ((localNodeList != null) && (localNodeList.getLength() > 0))
      {
        paramArrayOfQConfItem = new RedBagVideoResProcessor.RedBagVideoResConfigBean(paramArrayOfQConfItem.getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue(), paramArrayOfQConfItem.getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue());
        return paramArrayOfQConfItem;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(RedBagVideoResProcessor.RedBagVideoResConfigBean paramRedBagVideoResConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
    }
  }
  
  public Class<RedBagVideoResProcessor.RedBagVideoResConfigBean> clazz()
  {
    return RedBagVideoResProcessor.RedBagVideoResConfigBean.class;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return SharedPreUtils.ao(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onReqFailed");
    }
  }
  
  public int type()
  {
    return 252;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RedBagVideoResProcessor
 * JD-Core Version:    0.7.0.1
 */