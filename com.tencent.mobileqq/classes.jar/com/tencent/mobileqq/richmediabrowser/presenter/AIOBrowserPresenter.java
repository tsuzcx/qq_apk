package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.comment.DanmuDataIPCClient;
import com.tencent.mobileqq.comment.DanmuDataIPCClient.DanmuCacheObserver;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.IDanmakuClearListener;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.comment.danmaku.IDanmakuControlListener;
import com.tencent.mobileqq.comment.danmaku.IPlayerTime;
import com.tencent.mobileqq.danmaku.QQDanmakuManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.IAIOBrowserProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AIOBrowserPresenter
  extends MainBrowserPresenter
  implements Handler.Callback, MsgRevokeListener, DanmuDataIPCClient.DanmuCacheObserver, IDanmakuControlListener, IPlayerTime
{
  public AIOBrowserScene a;
  public AIOBrowserModel b;
  private Handler c;
  private int d = 30000;
  private volatile boolean e = false;
  private String f;
  private AtomicBoolean g = new AtomicBoolean(false);
  private IDanmakuClearListener h;
  private CommentDanmakuManager i;
  
  private void a(IDanmakuClearListener paramIDanmakuClearListener)
  {
    this.h = paramIDanmakuClearListener;
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private int b(String paramString)
  {
    Object localObject = this.b.getSelectedItem();
    int k = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int j = k;
    if (localObject != null) {
      if ((localObject instanceof AIOVideoData))
      {
        localObject = (AIOVideoData)localObject;
        if (((AIOVideoData)localObject).m == 0)
        {
          if ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))
          {
            j = k;
            if (!"0X8009AA6".equals(paramString)) {
              return j;
            }
          }
          else
          {
            return 2;
          }
        }
        else
        {
          j = k;
          if (((AIOVideoData)localObject).m != 1) {
            return j;
          }
          if ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))
          {
            j = k;
            if (!"0X8009AA6".equals(paramString)) {
              return j;
            }
          }
        }
        return 1;
      }
      else
      {
        j = k;
        if ((localObject instanceof AIOFileVideoData)) {
          if (!"0X800A99B".equals(paramString))
          {
            j = k;
            if (!"0X800A9B5".equals(paramString)) {}
          }
          else
          {
            j = 3;
          }
        }
      }
    }
    return j;
  }
  
  private int c(String paramString)
  {
    int j = ParamsManager.a().o();
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 5) {}
          do
          {
            return -1;
            if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
              break;
            }
          } while (!"0X8009EFD".equals(paramString));
          return 5;
          return 6;
        }
        return d(paramString);
      }
      return e(paramString);
    }
    return 1;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1);
      this.c.sendMessageDelayed((Message)localObject, paramInt);
    }
  }
  
  private int d(String paramString)
  {
    if ((!"0X8009EFC".equals(paramString)) && (!"0X800A418".equals(paramString)) && (!"0X800A419".equals(paramString)) && (!"0X800A41A".equals(paramString)) && (!"0X800A41B".equals(paramString)) && (!"0X800A41C".equals(paramString)) && (!"0X800A41D".equals(paramString)) && (!"0X800A41E".equals(paramString)))
    {
      "0X8009EFD".equals(paramString);
      return -1;
    }
    return 4;
  }
  
  private int e(String paramString)
  {
    if ((!"0X8009EFC".equals(paramString)) && (!"0X800A418".equals(paramString)) && (!"0X800A419".equals(paramString)) && (!"0X800A41A".equals(paramString)) && (!"0X800A41B".equals(paramString)) && (!"0X800A41C".equals(paramString)) && (!"0X800A41D".equals(paramString)) && (!"0X800A41E".equals(paramString)))
    {
      if ("0X8009EFD".equals(paramString)) {
        return 4;
      }
      if ("0X800A882".equals(paramString)) {
        return 2;
      }
      return -1;
    }
    return 5;
  }
  
  private void q()
  {
    DanmuDataIPCClient.b();
    DanmuDataIPCClient.a().a(this);
    a(DanmuDataIPCClient.a());
    CommentDanmakuManager localCommentDanmakuManager = this.i;
    if (localCommentDanmakuManager != null)
    {
      localCommentDanmakuManager.a(this);
      this.i.a(this.a.mContext, this.a.a);
      this.i.b();
    }
  }
  
  private void r()
  {
    if (b(getCurrentPosition()))
    {
      Object localObject = this.b;
      if ((localObject != null) && (((AIOBrowserModel)localObject).getItem(getCurrentPosition()) != null))
      {
        localObject = this.b.getItem(getCurrentPosition());
        if (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) {
          return;
        }
        try
        {
          if (this.c != null) {
            this.c.removeMessages(1);
          }
          DanmuDataIPCClient.a().a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).e, Long.valueOf(ParamsManager.a().e()).longValue(), ((RichMediaBrowserInfo)localObject).baseData.getType());
          c(this.d);
          return;
        }
        catch (Exception localException)
        {
          IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDanmakuList is exception = ");
          localStringBuilder.append(localException.getMessage());
          localIBrowserLog.i("AIOGalleryPresenter", 2, localStringBuilder.toString());
          return;
        }
      }
    }
    BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "getDanmakuList return");
  }
  
  private int s()
  {
    Object localObject = this.b.getSelectedItem();
    int k = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int j = k;
    if (localObject != null)
    {
      if ((localObject instanceof AIOFilePictureData)) {
        return 2;
      }
      if ((localObject instanceof AIOPictureData))
      {
        if (!((AIOPictureData)localObject).A) {
          return 1;
        }
      }
      else
      {
        if ((localObject instanceof AIOVideoData))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).m == 0) {
            return 4;
          }
          j = k;
          if (((AIOVideoData)localObject).m != 1) {
            return j;
          }
          return 3;
        }
        j = k;
        if (!(localObject instanceof AIOFileVideoData)) {
          return j;
        }
      }
      j = 5;
    }
    return j;
  }
  
  private int t()
  {
    int k = ParamsManager.a().i();
    int j = 1;
    if (k != 0)
    {
      if (k != 1)
      {
        if ((k != 1008) && (k != 2016) && (k != 1010) && (k != 1011)) {
          switch (k)
          {
          default: 
            return 4;
          }
        }
        return 3;
      }
      j = 2;
    }
    return j;
  }
  
  public void a()
  {
    this.e = true;
  }
  
  public void a(long paramLong)
  {
    if (this.a != null)
    {
      Object localObject = this.b.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        boolean bool;
        if ((ParamsManager.a().g()) && (ParamsManager.a().h() == paramLong)) {
          bool = true;
        } else {
          bool = false;
        }
        if ((!bool) && ((getParamsBuilder().a() instanceof IAIOBrowserProvider))) {
          ((IAIOBrowserProvider)getParamsBuilder().a()).f(paramLong);
        }
        if (!bool)
        {
          IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
          if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter))
          {
            int j = c(paramLong);
            if (j >= 0) {
              ((AIOBrowserBasePresenter)localIDecoratorPresenter).b(j);
            }
          }
        }
        if (((this.a.mContext instanceof Activity)) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)))
        {
          localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
          ((Activity)this.a.mContext).runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
        }
      }
      else
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 1) || (paramInt2 == 256) || (paramInt2 == 269484035))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        int j;
        if ((paramInt2 != 18) && (paramInt2 != 20)) {
          j = ((AIOBrowserModel)localObject).a(paramLong1, paramInt1);
        } else {
          j = this.b.a(paramLong1);
        }
        localObject = getDecoratorPresenter(j);
        if ((localObject instanceof AIOBrowserBasePresenter)) {
          ((AIOBrowserBasePresenter)localObject).a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 256) || (paramInt2 == 1) || (paramInt2 == 0) || (paramInt2 == 269484034))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        int j;
        if ((paramInt2 != 18) && (paramInt2 != 20) && (paramInt2 != 269484034)) {
          j = ((AIOBrowserModel)localObject).a(paramLong, paramInt1);
        } else {
          j = this.b.a(paramLong);
        }
        localObject = getDecoratorPresenter(j);
        if ((localObject instanceof AIOBrowserBasePresenter)) {
          ((AIOBrowserBasePresenter)localObject).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = getDecoratorPresenter(((AIOBrowserModel)localObject).a(paramLong, paramInt1));
      if ((localObject instanceof AIOBrowserBasePresenter)) {
        ((AIOBrowserBasePresenter)localObject).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3, paramBundle);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).reportVideoPlayEvent(t(), paramString, 2, b("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.d = (paramInt * 1000);
    }
    if ((!this.e) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = getCurrentDecoratorPresenter();
      if (((paramString instanceof AIOBrowserBasePresenter)) && (this.i != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((AIOBrowserBasePresenter)paramString).f();
        this.i.a(null);
      }
    }
    if ((paramList != null) && (paramList.size() > 0) && (b(paramLong)))
    {
      Object localObject = getCurrentDecoratorPresenter();
      if (((localObject instanceof AIOBrowserBasePresenter)) && (this.i != null) && (this.b != null))
      {
        e();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
        {
          paramString = new ArrayList();
          switch (localRichMediaBrowserInfo.baseData.getType())
          {
          default: 
            break;
          case 101: 
          case 103: 
            paramString = d();
            localObject = (AIOBrowserBasePresenter)localObject;
            paramString = BrowserDanmakuUtils.a(paramLong, paramList, paramString, ((AIOBrowserBasePresenter)localObject).d, ((AIOBrowserBasePresenter)localObject).d());
            break;
          case 100: 
          case 102: 
            paramString = BrowserDanmakuUtils.a(paramLong, paramList, d(), ((AIOBrowserBasePresenter)localObject).d);
          }
          this.i.b(paramString);
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((NetworkUtil.isNetworkAvailable()) && (paramDanmuItemBean != null) && (b(paramLong)) && (this.i != null))
    {
      e();
      this.i.a(paramDanmuItemBean);
    }
  }
  
  public void a(AIOBrowserModel paramAIOBrowserModel)
  {
    super.setBrowserModel(paramAIOBrowserModel);
    this.b = paramAIOBrowserModel;
  }
  
  public void a(AIOBrowserScene paramAIOBrowserScene)
  {
    super.setBrowserScene(paramAIOBrowserScene);
    this.a = paramAIOBrowserScene;
  }
  
  public void a(boolean paramBoolean)
  {
    CommentDanmakuManager localCommentDanmakuManager = this.i;
    if ((localCommentDanmakuManager != null) && (localCommentDanmakuManager.e()) && (this.a != null))
    {
      this.i.f();
      this.a.a(paramBoolean);
    }
  }
  
  public void a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    int j;
    if (paramArrayOfAIOBrowserBaseData != null) {
      j = paramArrayOfAIOBrowserBaseData.length;
    } else {
      j = 0;
    }
    paramArrayOfAIOBrowserBaseData = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyImageListChanged list size ");
    localStringBuilder.append(j);
    localStringBuilder.append(", selected ");
    localStringBuilder.append(paramInt);
    paramArrayOfAIOBrowserBaseData.i("AIOGalleryPresenter", 2, localStringBuilder.toString());
    if (this.browserScene != null) {
      this.browserScene.notifyImageModelDataChanged();
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((AIOBrowserModel)localObject).getItem(paramInt);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((RichMediaBrowserInfo)localObject).baseData != null) {
          if ((((RichMediaBrowserInfo)localObject).baseData.getType() != 100) && (((RichMediaBrowserInfo)localObject).baseData.getType() != 101) && (((RichMediaBrowserInfo)localObject).baseData.getType() != 102))
          {
            bool1 = bool2;
            if (((RichMediaBrowserInfo)localObject).baseData.getType() != 103) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.e)
    {
      IDecoratorPresenter localIDecoratorPresenter = getCurrentDecoratorPresenter();
      if (((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) && (this.i != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((AIOBrowserBasePresenter)localIDecoratorPresenter).f();
        this.i.a(null);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (BrowserDanmakuUtils.a(this.b.getSelectedItem())) && (a(paramInt));
  }
  
  public boolean b(long paramLong)
  {
    Object localObject = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((AIOBrowserModel)localObject).getItem(getCurrentPosition());
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))
        {
          bool1 = bool2;
          if (paramLong == ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).e) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void buildComplete()
  {
    if (BrowserDanmakuUtils.a())
    {
      QQDanmakuManager.a();
      this.i = new CommentDanmakuManager();
      this.c = new Handler(Looper.getMainLooper(), this);
      this.f = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      q();
    }
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)paramIntent.getParcelable("extra.EXTRA_CURRENT_IMAGE");
        if (localAIOBrowserBaseData != null)
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = localAIOBrowserBaseData;
          if (this.b.b(localRichMediaBrowserInfo))
          {
            this.b.c(localRichMediaBrowserInfo);
            if (paramIntent.getBoolean("muate_play")) {
              this.b.d(localRichMediaBrowserInfo);
            }
            long l = paramIntent.getLong("click_video_bubble_time");
            if (l > 0L) {
              this.b.a(localRichMediaBrowserInfo, l);
            }
          }
          this.b.a(localRichMediaBrowserInfo);
          if (ParamsManager.a().n()) {
            this.b.a(true);
          }
        }
      }
    }
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
  }
  
  public void buildPresenter() {}
  
  public int c(long paramLong)
  {
    List localList = this.b.c();
    if (localList != null)
    {
      int k = localList.size();
      int j = 0;
      while (j < k)
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localList.get(j);
        if (((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).a == paramLong)) {
          return j;
        }
        j += 1;
      }
    }
    return -1;
  }
  
  public long c()
  {
    IDecoratorPresenter localIDecoratorPresenter = getCurrentDecoratorPresenter();
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      return ((AIOBrowserBasePresenter)localIDecoratorPresenter).d();
    }
    return 0L;
  }
  
  public CommentDanmakuManager d()
  {
    return this.i;
  }
  
  public void e()
  {
    if (this.g.compareAndSet(false, true)) {
      ThreadManagerV2.excute(new AIOBrowserPresenter.1(this), 128, null, true);
    }
  }
  
  public void f()
  {
    CommentDanmakuManager localCommentDanmakuManager = this.i;
    if ((localCommentDanmakuManager != null) && (!localCommentDanmakuManager.e()) && (this.a != null))
    {
      this.i.g();
      this.a.a(true);
    }
  }
  
  public void g()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X8009EFD"));
    ReportController.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void h()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X8009EFC"));
    ReportController.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    r();
    return true;
  }
  
  public void i()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A418"));
    ReportController.b(null, "dc00898", "", "", "0X800A418", "0X800A418", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void j()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A419"));
    ReportController.b(null, "dc00898", "", "", "0X800A419", "0X800A419", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void k()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A41A"));
    ReportController.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void l()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A41B"));
    ReportController.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void m()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A41C"));
    ReportController.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void n()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A41D"));
    ReportController.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void o()
  {
    int j = s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(t());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X8009EFC"));
    ReportController.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", j, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AIOBrowserScene localAIOBrowserScene = this.a;
    if (localAIOBrowserScene != null) {
      localAIOBrowserScene.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
  {
    Object localObject1 = this.c;
    if (localObject1 != null) {
      ((Handler)localObject1).removeCallbacksAndMessages(null);
    }
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).removeMsgRevokerListener(this);
    DanmuDataIPCClient.a().b(this);
    localObject1 = this.i;
    if (localObject1 != null)
    {
      ((CommentDanmakuManager)localObject1).c();
      this.i = null;
    }
    localObject1 = this.h;
    if (localObject1 != null)
    {
      ((IDanmakuClearListener)localObject1).c();
      this.h = null;
    }
    localObject1 = this.decoratorPresenterMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (IDecoratorPresenter)((Iterator)localObject1).next();
      if ((localObject2 instanceof AIOBrowserBasePresenter))
      {
        localObject2 = (AIOBrowserBasePresenter)localObject2;
        ((AIOBrowserBasePresenter)localObject2).onDestroy();
        if (((AIOBrowserBasePresenter)localObject2).b != null) {
          ((AIOBrowserBasePresenter)localObject2).b.c();
        }
      }
    }
    this.decoratorPresenterMap.clear();
    localObject1 = this.a;
    if (localObject1 != null) {
      ((AIOBrowserScene)localObject1).onDestroy();
    }
    super.onDestroy();
  }
  
  public void onDoubleTap()
  {
    super.onDoubleTap();
    i();
  }
  
  public void onItemSelect(int paramInt)
  {
    super.onItemSelect(paramInt);
    if ((this.a != null) && (b(paramInt)))
    {
      IDecoratorPresenter localIDecoratorPresenter = getCurrentDecoratorPresenter();
      if (((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) && (this.i != null))
      {
        ((AIOBrowserBasePresenter)localIDecoratorPresenter).e();
        this.i.a(this);
        this.e = false;
      }
    }
    c(0);
  }
  
  public void onPause()
  {
    super.onPause();
    if (b(getCurrentPosition())) {
      a(true);
    }
    IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(getCurrentType());
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      ((AIOBrowserBasePresenter)localIDecoratorPresenter).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (b(getCurrentPosition())) {
      f();
    }
    IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(getCurrentType());
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      ((AIOBrowserBasePresenter)localIDecoratorPresenter).onResume();
    }
  }
  
  public void onScale()
  {
    super.onScale();
    AIOBrowserScene localAIOBrowserScene = this.a;
    if (localAIOBrowserScene != null) {
      localAIOBrowserScene.a(false);
    }
    if (d() != null)
    {
      d().f();
      d().d();
    }
    j();
  }
  
  public void onScaleBegin()
  {
    super.onScaleBegin();
  }
  
  public void onStart()
  {
    super.onStart();
    IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(getCurrentType());
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      ((AIOBrowserBasePresenter)localIDecoratorPresenter).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(getCurrentType());
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      ((AIOBrowserBasePresenter)localIDecoratorPresenter).onStop();
    }
  }
  
  public void p()
  {
    int j = s();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(c("0X800A882"));
    ReportController.b(null, "dc00898", "", "", "0X800A882", "0X800A882", j, 0, localStringBuilder.toString(), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter
 * JD-Core Version:    0.7.0.1
 */