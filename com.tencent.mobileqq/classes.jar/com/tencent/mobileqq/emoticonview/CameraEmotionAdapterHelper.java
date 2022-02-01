package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.core.EmotionPanelParamsBuilder;
import com.tencent.mobileqq.core.QQEmotionPanelManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.adapter.ICameraEmotionAdapterHelper;
import com.tencent.mobileqq.emoticonview.api.ICameraEmotionService;
import com.tencent.mobileqq.emoticonview.api.IFavoriteEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CameraEmotionAdapterHelper
  implements IEmotionPanelDataCallback<EmotionPanelData>, ICameraEmotionAdapterHelper
{
  private static final String TAG = "CameraEmotionAdapterHelper";
  private BaseEmotionAdapter mAdapter;
  private IEmoticonMainPanelApp mApp;
  
  public CameraEmotionAdapterHelper(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    this.mApp = paramIEmoticonMainPanelApp;
  }
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshPanelData call back dataList = ");
      if (paramList != null) {
        break label67;
      }
    }
    label67:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.d("CameraEmotionAdapterHelper", 2, localObject);
      if ((paramList != null) && (this.mAdapter != null))
      {
        this.mAdapter.setData(paramList);
        this.mAdapter.notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void reUploadCameraEmotion(CameraEmoticonInfo paramCameraEmoticonInfo)
  {
    Object localObject = ((ICameraEmotionService)QRoute.api(ICameraEmotionService.class)).getEmoticonDataList(this.mApp);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (localCameraEmotionData.emoId == paramCameraEmoticonInfo.emoId)
        {
          QLog.d("CameraEmotionAdapterHelper", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
          localCameraEmotionData.RomaingType = "needUpload";
          paramCameraEmoticonInfo.roamingType = "needUpload";
          ((ICameraEmotionService)QRoute.api(ICameraEmotionService.class)).reUploadCameraEmotion(this.mApp, localCameraEmotionData);
        }
      }
    }
  }
  
  public void refreshPanelData(BaseEmotionAdapter paramBaseEmotionAdapter, int paramInt)
  {
    this.mAdapter = paramBaseEmotionAdapter;
    ((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).asyncGetEmotionPanelData(this.mApp, paramInt, null, -1, QQEmotionPanelManager.a().a().a, false, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapterHelper
 * JD-Core Version:    0.7.0.1
 */