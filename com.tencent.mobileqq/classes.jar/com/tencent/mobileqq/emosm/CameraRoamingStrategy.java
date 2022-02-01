package com.tencent.mobileqq.emosm;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.impl.CameraEmotionRoamingDBManagerServiceImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class CameraRoamingStrategy
  extends BaseEmosmStrategy
{
  protected List<CameraEmoticonInfo> h = new ArrayList();
  CameraEmoRoamingObserver i = new CameraRoamingStrategy.4(this);
  private ICameraEmotionRoamingDBManagerService j;
  private volatile boolean k = false;
  
  public CameraRoamingStrategy(BaseQQAppInterface paramBaseQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage)
  {
    super(paramBaseQQAppInterface, paramFavEmosmViewPage);
  }
  
  private List<? extends EmoticonInfo> p()
  {
    return this.h;
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof CameraEmoticonInfo))
    {
      String str = ((CameraEmoticonInfo)paramEmoticonInfo).contextKey;
      paramEmoticonInfo = str;
      if (TextUtils.isEmpty(str)) {
        paramEmoticonInfo = "";
      }
      return String.format(MobileQQ.getContext().getString(2131888854), new Object[] { paramEmoticonInfo });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.a.addObserver(this.i);
    this.b.b(2131888853);
    this.k = false;
    if (this.j == null) {
      this.j = ((ICameraEmotionRoamingDBManagerService)this.a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class));
    }
    l();
    m();
  }
  
  public void a(CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback)
  {
    n().asyncGetFavEmotionInfoShowedInPanel(new CameraRoamingStrategy.2(this, paramCustomEmotionDataInPanelCallback));
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo)
  {
    Object localObject = ((ICameraEmotionRoamingDBManagerService)this.a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getEmoticonDataList();
    if (localObject == null) {
      return;
    }
    int m = paramICustomEmotionInfo.getEmoId();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == m)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((CameraEmoticonInfo)paramICustomEmotionInfo).roamingType = "needUpload";
        if (this.b != null) {
          this.b.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void b(List<EmoticonInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (EmoticonInfo)paramList.next();
        if ((localObject instanceof CameraEmoticonInfo))
        {
          localObject = (CameraEmoticonInfo)localObject;
          ((CameraEmoticonInfo)localObject).isChecked = false;
          Iterator localIterator = this.h.iterator();
          while (localIterator.hasNext())
          {
            CameraEmoticonInfo localCameraEmoticonInfo = (CameraEmoticonInfo)localIterator.next();
            if (((CameraEmoticonInfo)localObject).emoId == localCameraEmoticonInfo.emoId) {
              ((CameraEmoticonInfo)localObject).isChecked = localCameraEmoticonInfo.isChecked;
            }
          }
          localArrayList.add(localObject);
        }
      }
      this.h = localArrayList;
      return;
    }
    this.h.clear();
  }
  
  public int g()
  {
    return 2131888855;
  }
  
  public void h()
  {
    super.h();
    this.a.removeObserver(this.i);
    this.k = false;
  }
  
  public void i()
  {
    ReportController.b(this.a, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void j()
  {
    ReportController.b(this.a, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraRoamingStrategy", 2, "doSyncEmotion");
    }
    if (this.a == null) {
      return;
    }
    ThreadManager.excute(new CameraRoamingStrategy.5(this), 128, null, false);
  }
  
  protected void l()
  {
    this.b.f.setVisibility(8);
    this.b.g.setVisibility(8);
  }
  
  protected void m()
  {
    a(new CameraRoamingStrategy.1(this));
  }
  
  public CustomEmotionRoamingDBManagerBase<CameraEmotionData> n()
  {
    if (this.j == null) {
      this.j = ((ICameraEmotionRoamingDBManagerService)this.a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class));
    }
    return (CameraEmotionRoamingDBManagerServiceImpl)this.j;
  }
  
  public void o()
  {
    if (this.k)
    {
      QLog.e("CameraRoamingStrategy", 1, "doDelEmotion,  camera data deleting");
      return;
    }
    this.k = true;
    ArrayList localArrayList = new ArrayList();
    List localList = n().getEmoticonDataList();
    Object localObject1 = p();
    if (localList != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (EmoticonInfo)((Iterator)localObject1).next();
        if ((localObject2 instanceof CameraEmoticonInfo))
        {
          localObject2 = (CameraEmoticonInfo)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((CameraEmoticonInfo)localObject2).emoId == localCameraEmotionData.emoId) && (((CameraEmoticonInfo)localObject2).isChecked))
            {
              ((CameraEmoticonInfo)localObject2).isChecked = false;
              localArrayList.add(localCameraEmotionData);
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new CameraRoamingStrategy.3(this, localArrayList), 5, null, false);
      return;
    }
    this.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy
 * JD-Core Version:    0.7.0.1
 */