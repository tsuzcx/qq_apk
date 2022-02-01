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
  private int jdField_a_of_type_Int = 30000;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IDanmakuClearListener jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener;
  private CommentDanmakuManager jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
  public AIOBrowserModel a;
  public AIOBrowserScene a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
    int j = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int i = j;
    if (localObject != null)
    {
      if ((localObject instanceof AIOFilePictureData)) {
        return 2;
      }
      if ((localObject instanceof AIOPictureData))
      {
        if (!((AIOPictureData)localObject).i) {
          return 1;
        }
      }
      else
      {
        if ((localObject instanceof AIOVideoData))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).d == 0) {
            return 4;
          }
          i = j;
          if (((AIOVideoData)localObject).d != 1) {
            return i;
          }
          return 3;
        }
        i = j;
        if (!(localObject instanceof AIOFileVideoData)) {
          return i;
        }
      }
      i = 5;
    }
    return i;
  }
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
    int j = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int i = j;
    if (localObject != null) {
      if ((localObject instanceof AIOVideoData))
      {
        localObject = (AIOVideoData)localObject;
        if (((AIOVideoData)localObject).d == 0)
        {
          if ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))
          {
            i = j;
            if (!"0X8009AA6".equals(paramString)) {
              return i;
            }
          }
          else
          {
            return 2;
          }
        }
        else
        {
          i = j;
          if (((AIOVideoData)localObject).d != 1) {
            return i;
          }
          if ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))
          {
            i = j;
            if (!"0X8009AA6".equals(paramString)) {
              return i;
            }
          }
        }
        return 1;
      }
      else
      {
        i = j;
        if ((localObject instanceof AIOFileVideoData)) {
          if (!"0X800A99B".equals(paramString))
          {
            i = j;
            if (!"0X800A9B5".equals(paramString)) {}
          }
          else
          {
            i = 3;
          }
        }
      }
    }
    return i;
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramInt);
    }
  }
  
  private void a(IDanmakuClearListener paramIDanmakuClearListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener = paramIDanmakuClearListener;
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private int b()
  {
    int j = ParamsManager.a().a();
    int i = 1;
    if (j != 0)
    {
      if (j != 1)
      {
        if ((j != 1008) && (j != 2016) && (j != 1010) && (j != 1011)) {
          switch (j)
          {
          default: 
            return 4;
          }
        }
        return 3;
      }
      i = 2;
    }
    return i;
  }
  
  private int b(String paramString)
  {
    int i = ParamsManager.a().c();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5) {}
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
        return c(paramString);
      }
      return d(paramString);
    }
    return 1;
  }
  
  private int c(String paramString)
  {
    if ((!"0X8009EFC".equals(paramString)) && (!"0X800A418".equals(paramString)) && (!"0X800A419".equals(paramString)) && (!"0X800A41A".equals(paramString)) && (!"0X800A41B".equals(paramString)) && (!"0X800A41C".equals(paramString)) && (!"0X800A41D".equals(paramString)) && (!"0X800A41E".equals(paramString)))
    {
      "0X8009EFD".equals(paramString);
      return -1;
    }
    return 4;
  }
  
  private int d(String paramString)
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
  
  private void o()
  {
    DanmuDataIPCClient.a();
    DanmuDataIPCClient.a().a(this);
    a(DanmuDataIPCClient.a());
    CommentDanmakuManager localCommentDanmakuManager = this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
    if (localCommentDanmakuManager != null)
    {
      localCommentDanmakuManager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a);
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a();
    }
  }
  
  private void p()
  {
    if (b(getCurrentPosition()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
      if ((localObject != null) && (((AIOBrowserModel)localObject).getItem(getCurrentPosition()) != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(getCurrentPosition());
        if (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) {
          return;
        }
        try
        {
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
          DanmuDataIPCClient.a().a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, Long.valueOf(ParamsManager.a().a()).longValue(), ((RichMediaBrowserInfo)localObject).baseData.getType());
          a(this.jdField_a_of_type_Int);
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
  
  public int a(long paramLong)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a();
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localList.get(i);
        if (((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).a == paramLong)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public long a()
  {
    IDecoratorPresenter localIDecoratorPresenter = getCurrentDecoratorPresenter();
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      return ((AIOBrowserBasePresenter)localIDecoratorPresenter).a();
    }
    return 0L;
  }
  
  public CommentDanmakuManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        boolean bool;
        if ((ParamsManager.a().d()) && (ParamsManager.a().a() == paramLong)) {
          bool = true;
        } else {
          bool = false;
        }
        if ((!bool) && ((getParamsBuilder().a() instanceof IAIOBrowserProvider))) {
          ((IAIOBrowserProvider)getParamsBuilder().a()).e(paramLong);
        }
        if (!bool)
        {
          IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
          if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter))
          {
            int i = a(paramLong);
            if (i >= 0) {
              ((AIOBrowserBasePresenter)localIDecoratorPresenter).a(i);
            }
          }
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mContext instanceof Activity)) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)))
        {
          localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
          ((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mContext).runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
      if (localObject != null)
      {
        int i;
        if ((paramInt2 != 18) && (paramInt2 != 20)) {
          i = ((AIOBrowserModel)localObject).a(paramLong1, paramInt1);
        } else {
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong1);
        }
        localObject = getDecoratorPresenter(i);
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
      if (localObject != null)
      {
        int i;
        if ((paramInt2 != 18) && (paramInt2 != 20) && (paramInt2 != 269484034)) {
          i = ((AIOBrowserModel)localObject).a(paramLong, paramInt1);
        } else {
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong);
        }
        localObject = getDecoratorPresenter(i);
        if ((localObject instanceof AIOBrowserBasePresenter)) {
          ((AIOBrowserBasePresenter)localObject).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
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
    ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).reportVideoPlayEvent(b(), paramString, 2, a("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = (paramInt * 1000);
    }
    if ((!this.jdField_a_of_type_Boolean) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = getCurrentDecoratorPresenter();
      if (((paramString instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((AIOBrowserBasePresenter)paramString).c();
        this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(null);
      }
    }
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      Object localObject = getCurrentDecoratorPresenter();
      if (((localObject instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null))
      {
        c();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
        {
          paramString = new ArrayList();
          switch (localRichMediaBrowserInfo.baseData.getType())
          {
          default: 
            break;
          case 101: 
          case 103: 
            paramString = a();
            localObject = (AIOBrowserBasePresenter)localObject;
            paramString = BrowserDanmakuUtils.a(paramLong, paramList, paramString, ((AIOBrowserBasePresenter)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, ((AIOBrowserBasePresenter)localObject).a());
            break;
          case 100: 
          case 102: 
            paramString = BrowserDanmakuUtils.a(paramLong, paramList, a(), ((AIOBrowserBasePresenter)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
          }
          this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(paramString);
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((NetworkUtil.isNetworkAvailable()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(AIOBrowserModel paramAIOBrowserModel)
  {
    super.setBrowserModel(paramAIOBrowserModel);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel = paramAIOBrowserModel;
  }
  
  public void a(AIOBrowserScene paramAIOBrowserScene)
  {
    super.setBrowserScene(paramAIOBrowserScene);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene = paramAIOBrowserScene;
  }
  
  public void a(boolean paramBoolean)
  {
    CommentDanmakuManager localCommentDanmakuManager = this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
    if ((localCommentDanmakuManager != null) && (localCommentDanmakuManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(paramBoolean);
    }
  }
  
  public void a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    int i;
    if (paramArrayOfAIOBrowserBaseData != null) {
      i = paramArrayOfAIOBrowserBaseData.length;
    } else {
      i = 0;
    }
    paramArrayOfAIOBrowserBaseData = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyImageListChanged list size ");
    localStringBuilder.append(i);
    localStringBuilder.append(", selected ");
    localStringBuilder.append(paramInt);
    paramArrayOfAIOBrowserBaseData.i("AIOGalleryPresenter", 2, localStringBuilder.toString());
    if (this.browserScene != null) {
      this.browserScene.notifyImageModelDataChanged();
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
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
  
  public boolean a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
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
          if (paramLong == ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      IDecoratorPresenter localIDecoratorPresenter = getCurrentDecoratorPresenter();
      if (((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((AIOBrowserBasePresenter)localIDecoratorPresenter).c();
        this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(null);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (BrowserDanmakuUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem())) && (a(paramInt));
  }
  
  public void buildComplete()
  {
    if (BrowserDanmakuUtils.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager = new CommentDanmakuManager();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      o();
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
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(localRichMediaBrowserInfo))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.b(localRichMediaBrowserInfo);
            if (paramIntent.getBoolean("muate_play")) {
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.c(localRichMediaBrowserInfo);
            }
            long l = paramIntent.getLong("click_video_bubble_time");
            if (l > 0L) {
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(localRichMediaBrowserInfo, l);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(localRichMediaBrowserInfo);
          if (ParamsManager.a().f()) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(true);
          }
        }
      }
    }
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
  }
  
  public void buildPresenter() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManagerV2.excute(new AIOBrowserPresenter.1(this), 128, null, true);
    }
  }
  
  public void d()
  {
    CommentDanmakuManager localCommentDanmakuManager = this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
    if ((localCommentDanmakuManager != null) && (!localCommentDanmakuManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.e();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(true);
    }
  }
  
  public void e()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X8009EFD"));
    ReportController.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void f()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X8009EFC"));
    ReportController.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void g()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A418"));
    ReportController.b(null, "dc00898", "", "", "0X800A418", "0X800A418", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void h()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A419"));
    ReportController.b(null, "dc00898", "", "", "0X800A419", "0X800A419", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    p();
    return true;
  }
  
  public void i()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A41A"));
    ReportController.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void j()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A41B"));
    ReportController.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void k()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A41C"));
    ReportController.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void l()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A41D"));
    ReportController.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void m()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(b());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X8009EFC"));
    ReportController.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public void n()
  {
    int i = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b("0X800A882"));
    ReportController.b(null, "dc00898", "", "", "0X800A882", "0X800A882", i, 0, localStringBuilder.toString(), "", "", "");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AIOBrowserScene localAIOBrowserScene = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene;
    if (localAIOBrowserScene != null) {
      localAIOBrowserScene.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject1 != null) {
      ((Handler)localObject1).removeCallbacksAndMessages(null);
    }
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).removeMsgRevokerListener(this);
    DanmuDataIPCClient.a().b(this);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
    if (localObject1 != null)
    {
      ((CommentDanmakuManager)localObject1).b();
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener;
    if (localObject1 != null)
    {
      ((IDanmakuClearListener)localObject1).b();
      this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener = null;
    }
    localObject1 = this.decoratorPresenterMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (IDecoratorPresenter)((Iterator)localObject1).next();
      if ((localObject2 instanceof AIOBrowserBasePresenter))
      {
        localObject2 = (AIOBrowserBasePresenter)localObject2;
        ((AIOBrowserBasePresenter)localObject2).onDestroy();
        if (((AIOBrowserBasePresenter)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView != null) {
          ((AIOBrowserBasePresenter)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.b();
        }
      }
    }
    this.decoratorPresenterMap.clear();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene;
    if (localObject1 != null) {
      ((AIOBrowserScene)localObject1).onDestroy();
    }
    super.onDestroy();
  }
  
  public void onDoubleTap()
  {
    super.onDoubleTap();
    g();
  }
  
  public void onItemSelect(int paramInt)
  {
    super.onItemSelect(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null) && (b(paramInt)))
    {
      IDecoratorPresenter localIDecoratorPresenter = getCurrentDecoratorPresenter();
      if (((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
      {
        ((AIOBrowserBasePresenter)localIDecoratorPresenter).b();
        this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    a(0);
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
      d();
    }
    IDecoratorPresenter localIDecoratorPresenter = getDecoratorPresenter(getCurrentType());
    if ((localIDecoratorPresenter instanceof AIOBrowserBasePresenter)) {
      ((AIOBrowserBasePresenter)localIDecoratorPresenter).onResume();
    }
  }
  
  public void onScale()
  {
    super.onScale();
    AIOBrowserScene localAIOBrowserScene = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene;
    if (localAIOBrowserScene != null) {
      localAIOBrowserScene.a(false);
    }
    if (a() != null)
    {
      a().d();
      a().c();
    }
    h();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter
 * JD-Core Version:    0.7.0.1
 */