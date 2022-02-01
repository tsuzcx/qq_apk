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
  FavEmoRoamingObserver h = new FavRoamingStrategy.5(this);
  SyncListener<CustomEmotionData> i = new FavRoamingStrategy.6(this);
  private IFavroamingDBManagerService j;
  private Handler k;
  private List<String> l = new ArrayList();
  
  public FavRoamingStrategy(BaseQQAppInterface paramBaseQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage)
  {
    super(paramBaseQQAppInterface, paramFavEmosmViewPage);
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
  
  private void l()
  {
    a(new FavRoamingStrategy.1(this));
  }
  
  private void m()
  {
    if ((this.e) && (!this.d.isEmpty()))
    {
      Object localObject = this.b.m;
      int i1 = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      int m = 0;
      int n = 0;
      while (m < i1)
      {
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((List)localObject).get(m);
        if (((localEmoticonInfo instanceof ICustomEmotionInfo)) && (((ICustomEmotionInfo)localEmoticonInfo).isChecked()))
        {
          n += 1;
          localArrayList.add(localEmoticonInfo);
        }
        m += 1;
      }
      ThreadManager.post(new FavRoamingStrategy.3(this, localArrayList), 5, null, true);
      ReportController.b(this.a, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(n), "", "", "");
      this.e = false;
      localObject = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.a);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
      QQToast.makeText(this.a.getApp(), "趣图已添加至收藏面板", 0).show();
    }
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    if (paramEmoticonInfo == null) {
      return null;
    }
    return ((IFavroamingManagerService)this.a.getRuntimeService(IFavroamingManagerService.class)).getAccessibilityDescription(Integer.valueOf(paramEmoticonInfo.emoId));
  }
  
  public void a()
  {
    super.a();
    this.k = this.b.l();
    this.b.b(2131888877);
    this.a.addObserver(this.h);
    l();
    if (this.j == null) {
      this.j = ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class));
    }
    ((IFavroamingManagerService)this.a.getRuntimeService(IFavroamingManagerService.class)).addSyncListener(this.i);
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
    Object localObject = ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
    int m = paramICustomEmotionInfo.getEmoId();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == m)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!FavEmoSendControl.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((FavEmoRoamingHandler)this.a.getBusinessHandler(FavEmoRoamingHandler.a)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((EmoticonInfo)paramICustomEmotionInfo, "needUpload");
          if (this.b != null)
          {
            this.b.a(paramICustomEmotionInfo.getPath(), "needUpload");
            this.b.a(paramGridView, paramInt);
          }
          com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
          ThreadManager.excute(new FavEmoSingleSend(localCustomEmotionData, true), 64, null, false);
        }
      }
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra_key_from_web", false);
    this.e = bool;
    this.f = bool;
    if (this.e)
    {
      Object localObject = paramActivity.getIntent().getStringArrayListExtra("extra_key_pkgids");
      ArrayList localArrayList1 = paramActivity.getIntent().getStringArrayListExtra("extra_key_paths");
      ArrayList localArrayList2 = paramActivity.getIntent().getStringArrayListExtra("extra_key_md5s");
      int n = paramActivity.getIntent().getIntExtra("extra_key_faile_count", 0);
      if ((localObject != null) && (localArrayList1 != null) && (localArrayList2 != null))
      {
        int m = Math.min(((List)localObject).size(), localArrayList1.size());
        int i1 = Math.min(localArrayList2.size(), m);
        m = 0;
        while (m < i1)
        {
          FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
          localFavoriteEmoticonInfo.eId = ((String)((List)localObject).get(m));
          localFavoriteEmoticonInfo.path = ((String)localArrayList1.get(m));
          localFavoriteEmoticonInfo.action = ((String)localArrayList2.get(m));
          this.d.add(localFavoriteEmoticonInfo);
          m += 1;
        }
      }
      if (n > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(n);
        ((StringBuilder)localObject).append("个下载失败");
        QQToast.makeText(paramActivity, ((StringBuilder)localObject).toString(), 0).show();
      }
    }
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public int g()
  {
    return 2131888863;
  }
  
  public void h()
  {
    super.h();
    this.k = null;
    this.l.clear();
    if (this.f) {
      this.a.getApplication().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ((IFavroamingManagerService)this.a.getRuntimeService(IFavroamingManagerService.class)).removeSyncListener(this.i);
    if (this.h != null) {
      this.a.removeObserver(this.h);
    }
  }
  
  public void i()
  {
    ReportController.b(this.a, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void j()
  {
    ReportController.b(this.a, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavRoamingStrategy", 2, "fav doSyncEmotion");
    }
    if (this.a == null) {
      return;
    }
    ThreadManager.excute(new FavRoamingStrategy.7(this), 128, null, false);
  }
  
  public CustomEmotionRoamingDBManagerBase<CustomEmotionData> n()
  {
    if (this.j == null) {
      this.j = ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class));
    }
    return (CustomEmotionRoamingDBManagerBase)this.j;
  }
  
  public void o()
  {
    if (this.b != null)
    {
      if (this.b.m == null) {
        return;
      }
      Object localObject1 = this.b.m.iterator();
      int n;
      Object localObject2;
      do
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        n = 0;
        if (!bool) {
          break;
        }
        localObject2 = (EmoticonInfo)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof ICustomEmotionInfo)) || (!((ICustomEmotionInfo)localObject2).isChecked()));
      int m = 0;
      break label86;
      m = 1;
      label86:
      if (m != 0)
      {
        localObject1 = (FavEmoRoamingHandler)this.a.getBusinessHandler(FavEmoRoamingHandler.a);
        if (localObject1 != null)
        {
          ((FavEmoRoamingHandler)localObject1).a(this.l, false);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("-------start delfav---------delResid=");
            ((StringBuilder)localObject1).append(this.l.toString());
            QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.l.size());
          ((StringBuilder)localObject2).append("");
          ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
          ReportController.b(this.a, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.l.size()), "", "", "");
        }
      }
      if (this.c.get())
      {
        localObject1 = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.a);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        return;
      }
      m();
      localObject1 = (IVipComicMqqManagerService)this.a.getRuntimeService(IVipComicMqqManagerService.class);
      m = n;
      while (m < this.b.m.size())
      {
        localObject2 = this.b.getItem(m);
        if ((localObject2 != null) && ((localObject2 instanceof ICustomEmotionInfo)) && (((ICustomEmotionInfo)localObject2).isChecked()))
        {
          a((IVipComicMqqManagerService)localObject1, m, localObject2);
          return;
        }
        m += 1;
      }
      localObject1 = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.a);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy
 * JD-Core Version:    0.7.0.1
 */