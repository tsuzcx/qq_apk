package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CameraEmotionRoamingDBManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<ICameraEmotionRoamingDBManagerService>
{
  public static final String TAG = "CameraEmotionRoamingDBManagerServiceProxy";
  
  public CameraEmotionRoamingDBManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, ICameraEmotionRoamingDBManagerService.class);
  }
  
  public int getCatchDataCount()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManagerServiceProxy", 4, "do catchDataCount.");
      }
      return ((ICameraEmotionRoamingDBManagerService)this.manager).getCatchDataCount();
    }
    return 0;
  }
  
  public List<CameraEmotionData> getEmoticonDataList()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManagerServiceProxy", 4, "do emoticonDataList.");
      }
      return ((ICameraEmotionRoamingDBManagerService)this.manager).getEmoticonDataList();
    }
    return new ArrayList();
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManagerServiceProxy", 4, "do syncGetCustomEmotionInfoShowedInPanel.");
      }
      return ((ICameraEmotionRoamingDBManagerService)this.manager).syncGetCustomEmotionInfoShowedInPanel();
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */