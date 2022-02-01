package dov.com.qq.im.ae.camera.core;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.util.AELocalMediaInfoUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AEEditorManagerForQzone
  implements AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener, AEEditorUIBroadcastReceiver.AEEditorUIListener
{
  private final String TAG = "AEEditorManagerForQzone";
  private AEEditorGenerateBroadcastReceiver mAEEditorGenerateBroadcastReceiver = new AEEditorGenerateBroadcastReceiver(this);
  private AEEditorUIBroadcastReceiver mAEEditorUIBroadcastReceiver = new AEEditorUIBroadcastReceiver(this);
  private List<AEEditorManagerForQzone.AEEditorGenerateResultListener> mListenerList = new CopyOnWriteArrayList();
  private Map<String, LocalMediaInfo> mMissionStatus = new ConcurrentHashMap();
  private List<AEEditorManagerForQzone.AEEditorUICallbackListener> mUICallBackListener = new CopyOnWriteArrayList();
  
  public static AEEditorManagerForQzone getInstance()
  {
    return AEEditorManagerForQzone.InstanceHolder.INSTANCE;
  }
  
  private void sendBroadCast(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AEQLog.d("AEEditorManagerForQzone", "[sendBroadCast] action or missionID is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_mission", paramString2);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void addListener(@Nullable AEEditorManagerForQzone.AEEditorGenerateResultListener paramAEEditorGenerateResultListener)
  {
    AEQLog.b("AEEditorManagerForQzone", "[addListener]");
    if ((paramAEEditorGenerateResultListener != null) && (!this.mListenerList.contains(paramAEEditorGenerateResultListener))) {
      this.mListenerList.add(paramAEEditorGenerateResultListener);
    }
  }
  
  public void addUICallbackListener(@Nullable AEEditorManagerForQzone.AEEditorUICallbackListener paramAEEditorUICallbackListener)
  {
    AEQLog.b("AEEditorManagerForQzone", "[addUICallbackListener]");
    if ((paramAEEditorUICallbackListener != null) && (!this.mUICallBackListener.contains(paramAEEditorUICallbackListener))) {
      this.mUICallBackListener.add(paramAEEditorUICallbackListener);
    }
  }
  
  public void cancelMission(@NonNull String paramString)
  {
    AEQLog.b("AEEditorManagerForQzone", "[cancel]");
    sendBroadCast("AEEDITOR_ORDER_CANCEL", paramString);
  }
  
  public void clean()
  {
    AEQLog.b("AEEditorManagerForQzone", "[clean]");
    this.mAEEditorGenerateBroadcastReceiver.unRegisterSelf(BaseApplicationImpl.getContext());
    this.mAEEditorUIBroadcastReceiver.unRegisterSelf(BaseApplicationImpl.getContext());
  }
  
  public void deteleMedia(int paramInt)
  {
    Iterator localIterator = this.mUICallBackListener.iterator();
    while (localIterator.hasNext()) {
      ((AEEditorManagerForQzone.AEEditorUICallbackListener)localIterator.next()).deleteMedia(paramInt);
    }
  }
  
  public LocalMediaInfo getMissionInfo(String paramString)
  {
    paramString = (LocalMediaInfo)this.mMissionStatus.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public void init()
  {
    AEQLog.b("AEEditorManagerForQzone", "[init]");
    this.mAEEditorGenerateBroadcastReceiver.registerSelf(BaseApplicationImpl.getContext());
    this.mAEEditorUIBroadcastReceiver.registerSelf(BaseApplicationImpl.getContext());
  }
  
  public void onAETavSessionExportCompleted(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (TextUtils.isEmpty(paramString6)) {
      AEQLog.d("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mission is null");
    }
    for (;;)
    {
      return;
      paramString1 = AELocalMediaInfoUtil.a(paramString6, paramString1, paramString7, paramString8);
      if (paramString1 == null)
      {
        onAETavSessionExportError(paramString6, -4);
        return;
      }
      paramString1.materialID = paramString2;
      paramString1.materialName = paramString3;
      paramString1.filterID = paramString4;
      paramString1.scheme = paramString5;
      paramString1.showCircleTakeSame = paramInt;
      paramString1.missionID = paramString6;
      paramString1.mKuolieId = paramString9;
      paramString1.mKuolieCenterX = paramFloat1;
      paramString1.mKuolieCenterY = paramFloat2;
      paramString1.mKuolieWidthScale = paramFloat3;
      paramString1.mKuolieHeightScale = paramFloat4;
      paramString1.mKuolieRotate = paramFloat5;
      AEBaseDataReporter.a().a(paramString1);
      this.mMissionStatus.put(paramString6, paramString1);
      paramString2 = this.mListenerList.iterator();
      while (paramString2.hasNext()) {
        ((AEEditorManagerForQzone.AEEditorGenerateResultListener)paramString2.next()).onAETavSessionExportCompleted(paramString6, paramString1);
      }
    }
  }
  
  public void onAETavSessionExportError(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEEditorManagerForQzone", "[onAETavSessionExportError] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.mMissionStatus.get(paramString);
    if (localObject == null)
    {
      localObject = AELocalMediaInfoUtil.a(null, "", 0, 0, null, null, paramString);
      this.mMissionStatus.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.mListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AEEditorManagerForQzone.AEEditorGenerateResultListener)((Iterator)localObject).next()).onAETavSessionExportError(paramString, paramInt);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEEditorManagerForQzone", "[onAETavSessionExporting] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.mMissionStatus.get(paramString);
    if (localObject == null)
    {
      localObject = AELocalMediaInfoUtil.a(null, "", 0, 0, null, null, paramString);
      this.mMissionStatus.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.mListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AEEditorManagerForQzone.AEEditorGenerateResultListener)((Iterator)localObject).next()).onAETavSessionExporting(paramString, paramFloat);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void removeAllListener()
  {
    AEQLog.b("AEEditorManagerForQzone", "[removeAllListener]");
    this.mListenerList.clear();
    this.mUICallBackListener.clear();
  }
  
  public void removeCallbackListener(@Nullable AEEditorManagerForQzone.AEEditorUICallbackListener paramAEEditorUICallbackListener)
  {
    AEQLog.b("AEEditorManagerForQzone", "[removeCallbackListener]");
    if ((paramAEEditorUICallbackListener != null) && (this.mUICallBackListener.contains(paramAEEditorUICallbackListener))) {
      this.mUICallBackListener.remove(paramAEEditorUICallbackListener);
    }
  }
  
  public void removeListener(@Nullable AEEditorManagerForQzone.AEEditorGenerateResultListener paramAEEditorGenerateResultListener)
  {
    AEQLog.b("AEEditorManagerForQzone", "[removeListener]");
    if ((paramAEEditorGenerateResultListener != null) && (this.mListenerList.contains(paramAEEditorGenerateResultListener))) {
      this.mListenerList.remove(paramAEEditorGenerateResultListener);
    }
  }
  
  public void retryMission(String paramString)
  {
    AEQLog.b("AEEditorManagerForQzone", "[retry]");
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), PeakService.class);
    localIntent.putExtra("ServiceAction", 4);
    localIntent.putExtra("generate_mission", paramString);
    BaseApplicationImpl.getApplication().startService(localIntent);
  }
  
  public void saveMission(String paramString)
  {
    AEQLog.b("AEEditorManagerForQzone", "[save]");
    sendBroadCast("AEEDITOR_ORDER_SAVE", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone
 * JD-Core Version:    0.7.0.1
 */