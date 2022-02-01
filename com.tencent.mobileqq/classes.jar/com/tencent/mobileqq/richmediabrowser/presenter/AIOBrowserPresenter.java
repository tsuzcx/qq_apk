package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr.MsgRevokeListener;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.MiniCodePeakHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.comment.DanmuDataIPCClient;
import com.tencent.mobileqq.comment.DanmuDataIPCClient.DanmuCacheObserver;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.IDanmakuClearListener;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.comment.danmaku.IDanmakuControlListener;
import com.tencent.mobileqq.comment.danmaku.IPlayerTime;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.utils.DataUtils;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class AIOBrowserPresenter
  extends MainBrowserPresenter
  implements Handler.Callback, AIOGalleryMsgRevokeMgr.MsgRevokeListener, DanmuDataIPCClient.DanmuCacheObserver, IDanmakuControlListener, IPlayerTime
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private IDanmakuClearListener jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener;
  private CommentDanmakuManager jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
  private DCAIOPreview jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  private DCAIOPreviewProgressive jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  public AIOBrowserModel a;
  public AIOBrowserScene a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int b = 30000;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
    if (localObject == null) {
      return -1;
    }
    localObject = ((RichMediaBrowserInfo)localObject).baseData;
    int i;
    if (localObject != null) {
      if ((localObject instanceof AIOFilePictureData)) {
        i = 2;
      }
    }
    for (;;)
    {
      return i;
      if ((localObject instanceof AIOPictureData))
      {
        if (!((AIOPictureData)localObject).k) {
          i = 1;
        } else {
          i = 5;
        }
      }
      else
      {
        if ((localObject instanceof AIOVideoData))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).d == 0)
          {
            i = 4;
            continue;
          }
          if (((AIOVideoData)localObject).d == 1) {
            i = 3;
          }
        }
        else if ((localObject instanceof AIOFileVideoData))
        {
          i = 5;
          continue;
        }
        i = -1;
      }
    }
  }
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((RichMediaBrowserInfo)localObject).baseData;
    } while (localObject == null);
    int i;
    if ((localObject instanceof AIOVideoData))
    {
      localObject = (AIOVideoData)localObject;
      if (((AIOVideoData)localObject).d == 0) {
        if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString))) {
          i = 2;
        }
      }
    }
    for (;;)
    {
      return i;
      if ("0X8009AA6".equals(paramString))
      {
        i = 1;
        continue;
        if (((AIOVideoData)localObject).d == 1)
        {
          if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString)))
          {
            i = 1;
            continue;
          }
          if ("0X8009AA6".equals(paramString))
          {
            i = 1;
            continue;
            if ((!(localObject instanceof AIOFileVideoData)) || ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString)))) {
              break;
            }
            return 3;
          }
        }
      }
      i = -1;
    }
  }
  
  private void a(IDanmakuClearListener paramIDanmakuClearListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener = paramIDanmakuClearListener;
  }
  
  private int b()
  {
    switch (ParamsManager.a().a())
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private int b(String paramString)
  {
    switch (ParamsManager.a().c())
    {
    }
    do
    {
      return -1;
      return 1;
      return c(paramString);
      return d(paramString);
      if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
        return 6;
      }
    } while (!"0X8009EFD".equals(paramString));
    return 5;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  private int c(String paramString)
  {
    int i = -1;
    if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
      i = 4;
    }
    while (!"0X8009EFD".equals(paramString)) {
      return i;
    }
    return -1;
  }
  
  private int d(String paramString)
  {
    int i = -1;
    if (("0X8009EFC".equals(paramString)) || ("0X800A418".equals(paramString)) || ("0X800A419".equals(paramString)) || ("0X800A41A".equals(paramString)) || ("0X800A41B".equals(paramString)) || ("0X800A41C".equals(paramString)) || ("0X800A41D".equals(paramString)) || ("0X800A41E".equals(paramString))) {
      i = 5;
    }
    do
    {
      return i;
      if ("0X8009EFD".equals(paramString)) {
        return 4;
      }
    } while (!"0X800A882".equals(paramString));
    return 2;
  }
  
  private void o()
  {
    DanmuDataIPCClient.a();
    DanmuDataIPCClient.a().a(this);
    a(DanmuDataIPCClient.a());
    if (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a);
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a();
    }
  }
  
  private void p()
  {
    if ((b(getCurrentPosition())) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(getCurrentPosition()) != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) {}
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        DanmuDataIPCClient.a().a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, Long.valueOf(ParamsManager.a().a()).longValue(), localRichMediaBrowserInfo.baseData.getType());
        b(this.b);
        return;
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "getDanmakuList is exception = " + localException.getMessage());
        return;
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
    BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
    if ((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) {
      return ((AIOBrowserBasePresenter)localBrowserBasePresenter).a();
    }
    return 0L;
  }
  
  public IAIOImageProvider a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  }
  
  public CommentDanmakuManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager;
  }
  
  public DCAIOPreview a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  }
  
  public DCAIOPreviewProgressive a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
      }
    }
    else
    {
      return;
    }
    if ((ParamsManager.a().c()) && (ParamsManager.a().a() == paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) && (!bool)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramLong);
      }
      if (!bool)
      {
        BrowserBasePresenter localBrowserBasePresenter = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if ((localBrowserBasePresenter instanceof AIOBrowserBasePresenter))
        {
          int i = a(paramLong);
          if (i >= 0) {
            ((AIOBrowserBasePresenter)localBrowserBasePresenter).b(i);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))) {
        break;
      }
      localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity.runOnUiThread(new AIOBrowserPresenter.2(this, paramLong, (AIOBrowserBaseData)localObject, bool));
      return;
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 1) || (paramInt2 == 256) || (paramInt2 == 269484035)) {
      if ((paramInt2 != 18) && (paramInt2 != 20)) {
        break label114;
      }
    }
    label114:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong1);; i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong1, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) {
        ((AIOBrowserBasePresenter)localBrowserBasePresenter).a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((paramInt2 == 2) || (paramInt2 == 24) || (paramInt2 == 4) || (paramInt2 == 18) || (paramInt2 == 20) || (paramInt2 == 256) || (paramInt2 == 1) || (paramInt2 == 0) || (paramInt2 == 269484034)) {
      if ((paramInt2 != 18) && (paramInt2 != 20) && (paramInt2 != 269484034)) {
        break label127;
      }
    }
    label127:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong);; i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong, paramInt1))
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(i);
      if ((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) {
        ((AIOBrowserBasePresenter)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong, paramInt1));
    if ((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) {
      ((AIOBrowserBasePresenter)localBrowserBasePresenter).a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    ShortVideoUtils.reportVideoPlayEvent(null, b(), paramString, 2, a("0X8009AA6"), paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList)
  {
    if (paramInt > 0) {
      this.b = (paramInt * 1000);
    }
    if ((!this.jdField_a_of_type_Boolean) && ((paramList == null) || (paramList.isEmpty())))
    {
      paramString = getCurrentPresenter();
      if (((paramString instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
        ((AIOBrowserBasePresenter)paramString).c();
        this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(null);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter;
    if ((paramList != null) && (paramList.size() > 0) && (a(paramLong)))
    {
      localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null))
      {
        c();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
        {
          paramString = new ArrayList();
          switch (localRichMediaBrowserInfo.baseData.getType())
          {
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(paramString);
      return;
      paramString = BrowserDanmakuUtils.a(paramLong, paramList, a(), ((AIOBrowserBasePresenter)localBrowserBasePresenter).a);
      continue;
      paramString = BrowserDanmakuUtils.a(paramLong, paramList, a(), ((AIOBrowserBasePresenter)localBrowserBasePresenter).a, ((AIOBrowserBasePresenter)localBrowserBasePresenter).a());
    }
  }
  
  public void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean)
  {
    if ((NetworkUtil.a()) && (paramDanmuItemBean != null) && (a(paramLong)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(IAIOImageProvider paramIAIOImageProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
  }
  
  public void a(AIOBrowserModel paramAIOBrowserModel)
  {
    super.setGalleryModel(paramAIOBrowserModel);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel = paramAIOBrowserModel;
  }
  
  public void a(AIOBrowserScene paramAIOBrowserScene)
  {
    super.setGalleryScene(paramAIOBrowserScene);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene = paramAIOBrowserScene;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(paramBoolean);
    }
  }
  
  public void a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    if (paramArrayOfAIOBrowserBaseData != null) {}
    for (int i = paramArrayOfAIOBrowserBaseData.length;; i = 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + i + ", selected " + paramInt);
      if (this.browserScene != null) {
        this.browserScene.notifyImageModelDataChanged();
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(paramInt);
      bool1 = bool2;
      if (localRichMediaBrowserInfo != null)
      {
        bool1 = bool2;
        if (localRichMediaBrowserInfo.baseData != null) {
          if ((localRichMediaBrowserInfo.baseData.getType() != 100) && (localRichMediaBrowserInfo.baseData.getType() != 101) && (localRichMediaBrowserInfo.baseData.getType() != 102))
          {
            bool1 = bool2;
            if (localRichMediaBrowserInfo.baseData.getType() != 103) {}
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(getCurrentPosition());
      return (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) && (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
        ((AIOBrowserBasePresenter)localBrowserBasePresenter).c();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity instanceof PeakActivity))
    {
      AppRuntime localAppRuntime = ((PeakActivity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity).getAppRuntime();
      if ((localAppRuntime instanceof PeakAppInterface)) {
        ((MiniCodePeakHandler)((PeakAppInterface)localAppRuntime).getBusinessHandler(PeakAppInterface.c)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity);
      }
    }
    if (BrowserDanmakuUtils.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager = new CommentDanmakuManager();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
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
        AIORichMediaData localAIORichMediaData = (AIORichMediaData)paramIntent.getParcelable("extra.EXTRA_CURRENT_IMAGE");
        if (localAIORichMediaData != null)
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = DataUtils.a(localAIORichMediaData);
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
    AIOGalleryMsgRevokeMgr.a().a(this);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.e();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(true);
    }
  }
  
  public void e()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", a(), 0, "" + b(), "" + b("0X8009EFD"), "", "");
  }
  
  public void f()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void g()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A418", "0X800A418", a(), 0, "" + b(), "" + b("0X800A418"), "", "");
  }
  
  public void h()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A419", "0X800A419", a(), 0, "" + b(), "" + b("0X800A419"), "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      p();
    }
  }
  
  public void i()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A41A", "0X800A41A", a(), 0, "" + b(), "" + b("0X800A41A"), "", "");
  }
  
  public void j()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A41B", "0X800A41B", a(), 0, "" + b(), "" + b("0X800A41B"), "", "");
  }
  
  public void k()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A41C", "0X800A41C", a(), 0, "" + b(), "" + b("0X800A41C"), "", "");
  }
  
  public void l()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A41D", "0X800A41D", a(), 0, "" + b(), "" + b("0X800A41D"), "", "");
  }
  
  public void m()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", a(), 0, "" + b(), "" + b("0X8009EFC"), "", "");
  }
  
  public void n()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A882", "0X800A882", a(), 0, "" + b("0X800A882"), "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    DanmuDataIPCClient.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener.b();
      this.jdField_a_of_type_ComTencentMobileqqCommentIDanmakuClearListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.onDestroy();
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = null;
    }
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
      BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
      if (((localBrowserBasePresenter instanceof AIOBrowserBasePresenter)) && (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager != null))
      {
        ((AIOBrowserBasePresenter)localBrowserBasePresenter).b();
        this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuCommentDanmakuManager.a(this);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    b(0);
  }
  
  public void onScale()
  {
    super.onScale();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(false);
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
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedIndex());
    if (localRichMediaBrowserInfo != null) {
      a().c(localRichMediaBrowserInfo.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter
 * JD-Core Version:    0.7.0.1
 */