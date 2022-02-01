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
  CameraEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingObserver = new CameraRoamingStrategy.4(this);
  private ICameraEmotionRoamingDBManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService;
  protected List<CameraEmoticonInfo> b = new ArrayList();
  private volatile boolean c = false;
  
  public CameraRoamingStrategy(BaseQQAppInterface paramBaseQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage)
  {
    super(paramBaseQQAppInterface, paramFavEmosmViewPage);
  }
  
  private List<? extends EmoticonInfo> a()
  {
    return this.b;
  }
  
  public int a()
  {
    return 2131691888;
  }
  
  public CustomEmotionRoamingDBManagerBase<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService = ((ICameraEmotionRoamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class));
    }
    return (CameraEmotionRoamingDBManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService;
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
      return String.format(MobileQQ.getContext().getString(2131691887), new Object[] { paramEmoticonInfo });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingObserver);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.b(2131691886);
    this.c = false;
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService = ((ICameraEmotionRoamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class));
    }
    h();
    i();
  }
  
  public void a(CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback)
  {
    a().asyncGetFavEmotionInfoShowedInPanel(new CameraRoamingStrategy.2(this, paramCustomEmotionDataInPanelCallback));
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo)
  {
    Object localObject = ((ICameraEmotionRoamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getEmoticonDataList();
    if (localObject == null) {
      return;
    }
    int i = paramICustomEmotionInfo.getEmoId();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((CameraEmoticonInfo)paramICustomEmotionInfo).roamingType = "needUpload";
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<EmoticonInfo> paramList)
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
          Iterator localIterator = this.b.iterator();
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
      this.b = localArrayList;
      return;
    }
    this.b.clear();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingObserver);
    this.c = false;
  }
  
  public void e()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraRoamingStrategy", 2, "doSyncEmotion");
    }
    if (this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new CameraRoamingStrategy.5(this), 128, null, false);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.d.setVisibility(8);
  }
  
  protected void i()
  {
    a(new CameraRoamingStrategy.1(this));
  }
  
  public void j()
  {
    if (this.c)
    {
      QLog.e("CameraRoamingStrategy", 1, "doDelEmotion,  camera data deleting");
      return;
    }
    this.c = true;
    ArrayList localArrayList = new ArrayList();
    List localList = a().getEmoticonDataList();
    Object localObject1 = a();
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
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy
 * JD-Core Version:    0.7.0.1
 */