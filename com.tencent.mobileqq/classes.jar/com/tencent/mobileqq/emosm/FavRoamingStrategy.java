package com.tencent.mobileqq.emosm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSendControl;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FavRoamingStrategy
  extends BaseEmosmStrategy
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  FavEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver = new FavRoamingStrategy.5(this);
  private IFavroamingDBManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService;
  SyncListener<CustomEmotionData> jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = new FavRoamingStrategy.6(this);
  private List<String> b;
  
  public FavRoamingStrategy(BaseQQAppInterface paramBaseQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage)
  {
    super(paramBaseQQAppInterface, paramFavEmosmViewPage);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(IVipComicMqqManagerService paramIVipComicMqqManagerService, int paramInt, Object paramObject)
  {
    ThreadManager.post(new FavRoamingStrategy.4(this, paramObject, paramIVipComicMqqManagerService, paramInt), 5, null, false);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo, String paramString)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
      return;
    }
    if ((paramEmoticonInfo instanceof PicEmoticonInfo)) {
      ((PicEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
    }
  }
  
  private void h()
  {
    a(new FavRoamingStrategy.1(this));
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_b_of_type_JavaUtilList;
      int k = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < k)
      {
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((List)localObject).get(i);
        if (((localEmoticonInfo instanceof ICustomEmotionInfo)) && (((ICustomEmotionInfo)localEmoticonInfo).isChecked()))
        {
          j += 1;
          localArrayList.add(localEmoticonInfo);
        }
        i += 1;
      }
      ThreadManager.post(new FavRoamingStrategy.3(this, localArrayList), 5, null, true);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(j), "", "", "");
      this.jdField_a_of_type_Boolean = false;
      localObject = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApp(), "趣图已添加至收藏面板", 0).a();
    }
  }
  
  public int a()
  {
    return 2131691896;
  }
  
  public CustomEmotionRoamingDBManagerBase<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService = ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class));
    }
    return (CustomEmotionRoamingDBManagerBase)this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService;
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    if (paramEmoticonInfo == null) {
      return null;
    }
    return ((IFavroamingManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).getAccessibilityDescription(Integer.valueOf(paramEmoticonInfo.emoId));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.b(2131691910);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService = ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class));
    }
    ((IFavroamingManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).addSyncListener(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    super.a(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new FavRoamingStrategy.2(this));
    }
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo)
  {
    Object localObject = ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
    int i = paramICustomEmotionInfo.getEmoId();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!FavEmoSendControl.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.a)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((EmoticonInfo)paramICustomEmotionInfo, "needUpload");
          if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a(paramICustomEmotionInfo.getPath(), "needUpload");
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a(paramGridView, paramInt);
          }
          com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.jdField_b_of_type_Boolean = false;
          ThreadManager.excute(new FavEmoSingleSend(localCustomEmotionData, true), 64, null, false);
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Activity paramActivity)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra_key_from_web", false);
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = paramActivity.getIntent().getStringArrayListExtra("extra_key_pkgids");
      ArrayList localArrayList1 = paramActivity.getIntent().getStringArrayListExtra("extra_key_paths");
      ArrayList localArrayList2 = paramActivity.getIntent().getStringArrayListExtra("extra_key_md5s");
      int j = paramActivity.getIntent().getIntExtra("extra_key_faile_count", 0);
      if ((localObject != null) && (localArrayList1 != null) && (localArrayList2 != null))
      {
        int i = Math.min(((List)localObject).size(), localArrayList1.size());
        int k = Math.min(localArrayList2.size(), i);
        i = 0;
        while (i < k)
        {
          FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
          localFavoriteEmoticonInfo.eId = ((String)((List)localObject).get(i));
          localFavoriteEmoticonInfo.path = ((String)localArrayList1.get(i));
          localFavoriteEmoticonInfo.action = ((String)localArrayList2.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localFavoriteEmoticonInfo);
          i += 1;
        }
      }
      if (j > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("个下载失败");
        QQToast.a(paramActivity, ((StringBuilder)localObject).toString(), 0).a();
      }
    }
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplication().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ((IFavroamingManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).removeSyncListener(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    }
  }
  
  public void e()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavRoamingStrategy", 2, "fav doSyncEmotion");
    }
    if (this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new FavRoamingStrategy.7(this), 128, null, false);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_b_of_type_JavaUtilList == null) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_b_of_type_JavaUtilList.iterator();
      int j;
      Object localObject2;
      do
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        j = 0;
        if (!bool) {
          break;
        }
        localObject2 = (EmoticonInfo)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof ICustomEmotionInfo)) || (!((ICustomEmotionInfo)localObject2).isChecked()));
      int i = 0;
      break label86;
      i = 1;
      label86:
      if (i != 0)
      {
        localObject1 = (FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.a);
        if (localObject1 != null)
        {
          ((FavEmoRoamingHandler)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("-------start delfav---------delResid=");
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilList.toString());
            QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilList.size());
          ((StringBuilder)localObject2).append("");
          ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilList.size()), "", "", "");
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localObject1 = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        return;
      }
      i();
      localObject1 = (IVipComicMqqManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
      i = j;
      while (i < this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.jdField_b_of_type_JavaUtilList.size())
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.getItem(i);
        if ((localObject2 != null) && ((localObject2 instanceof ICustomEmotionInfo)) && (((ICustomEmotionInfo)localObject2).isChecked()))
        {
          a((IVipComicMqqManagerService)localObject1, i, localObject2);
          return;
        }
        i += 1;
      }
      localObject1 = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy
 * JD-Core Version:    0.7.0.1
 */