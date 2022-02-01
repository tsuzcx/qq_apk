package com.tencent.mobileqq.share.api.impl;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.share.api.IShareActionSheetApi;
import com.tencent.mobileqq.share.api.QCircleActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import java.util.ArrayList;
import java.util.List;

public class ShareActionSheetApiImpl
  implements IShareActionSheetApi
{
  private QCircleActionSheetClickListener mQCircleClickListener;
  private ShareActionSheet mShareActionSheet;
  private ShareActionSheetClickListener mShareActionSheetClickListener;
  
  private List<ShareActionSheetBuilder.ActionSheetItem> getOperationsLines(ShareConfig paramShareConfig)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramShareConfig == null) {}
    do
    {
      return localArrayList;
      if (paramShareConfig.isShowDelete) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
      }
      if (paramShareConfig.isShowSave) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
      }
      if (paramShareConfig.isShowBarrageOpen) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(142));
      }
      if (paramShareConfig.isShowBarrageClose) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(143));
      }
      if (paramShareConfig.isShowDisLike) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
      }
      if (paramShareConfig.isShowHideThisWork) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(141));
      }
      if (paramShareConfig.isShowReport) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      }
      if (paramShareConfig.isShowDeletePush) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(140));
      }
    } while (!paramShareConfig.isShowDebug);
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
    return localArrayList;
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> getPathsLines(ShareConfig paramShareConfig)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramShareConfig == null) {}
    do
    {
      return localArrayList;
      if (paramShareConfig.isShowShareToFriend) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      }
      if (paramShareConfig.isShowShareToQZone) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      }
      if (paramShareConfig.isShowShareToWechat) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      }
    } while (!paramShareConfig.isShowShareToWechatCircle);
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  private void handleClickMenuItem(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    boolean bool2 = true;
    boolean bool1;
    switch (i)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (((i == 3) || (i == 9) || (i == 10) || (i == 72) || (i == 73) || (i == 2)) && (this.mQCircleClickListener != null)) {
        this.mQCircleClickListener.dispatchEvent();
      }
      if (this.mShareActionSheet != null) {
        this.mShareActionSheet.dismiss();
      }
      if (this.mQCircleClickListener != null) {
        this.mQCircleClickListener.afterHandleClick(bool1);
      }
      return;
      bool1 = bool2;
      if (this.mShareActionSheetClickListener != null)
      {
        this.mShareActionSheetClickListener.jumpQcirclePrivateMessage();
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (this.mShareActionSheetClickListener != null)
        {
          this.mShareActionSheetClickListener.shareToQQ();
          bool1 = bool2;
          continue;
          bool1 = bool2;
          if (this.mShareActionSheetClickListener != null)
          {
            this.mShareActionSheetClickListener.shareToSpecifiedFriend(paramActionSheetItem.uin, paramActionSheetItem.uinType);
            bool1 = bool2;
            continue;
            bool1 = bool2;
            if (this.mShareActionSheetClickListener != null)
            {
              this.mShareActionSheetClickListener.shareToQZone();
              bool1 = bool2;
              continue;
              bool1 = bool2;
              if (this.mShareActionSheetClickListener != null)
              {
                this.mShareActionSheetClickListener.shareToWeChat();
                bool1 = bool2;
                continue;
                bool1 = bool2;
                if (this.mShareActionSheetClickListener != null)
                {
                  this.mShareActionSheetClickListener.shareToWeChatCircle();
                  bool1 = bool2;
                  continue;
                  bool1 = bool2;
                  if (this.mShareActionSheetClickListener != null)
                  {
                    this.mShareActionSheetClickListener.report();
                    bool1 = bool2;
                    continue;
                    bool1 = bool2;
                    if (this.mShareActionSheetClickListener != null)
                    {
                      this.mShareActionSheetClickListener.switchBarrageOpen();
                      bool1 = bool2;
                      continue;
                      bool1 = bool2;
                      if (this.mShareActionSheetClickListener != null)
                      {
                        this.mShareActionSheetClickListener.switchBarrageClose();
                        bool1 = bool2;
                        continue;
                        bool1 = bool2;
                        if (this.mShareActionSheetClickListener != null)
                        {
                          this.mShareActionSheetClickListener.delete();
                          bool1 = bool2;
                          continue;
                          if (this.mShareActionSheetClickListener != null) {
                            this.mShareActionSheetClickListener.showReportDisLike();
                          }
                          bool1 = false;
                          continue;
                          bool1 = bool2;
                          if (this.mShareActionSheetClickListener != null)
                          {
                            this.mShareActionSheetClickListener.hideThisWork();
                            bool1 = bool2;
                            continue;
                            bool1 = bool2;
                            if (this.mShareActionSheetClickListener != null)
                            {
                              this.mShareActionSheetClickListener.hideHim();
                              bool1 = bool2;
                              continue;
                              bool1 = bool2;
                              if (this.mShareActionSheetClickListener != null)
                              {
                                this.mShareActionSheetClickListener.deleteHasPush();
                                bool1 = bool2;
                                continue;
                                bool1 = bool2;
                                if (this.mShareActionSheetClickListener != null)
                                {
                                  this.mShareActionSheetClickListener.save();
                                  bool1 = bool2;
                                  continue;
                                  bool1 = bool2;
                                  if (this.mShareActionSheetClickListener != null)
                                  {
                                    this.mShareActionSheetClickListener.miniAppDebugOn();
                                    bool1 = bool2;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void dismiss()
  {
    if (this.mShareActionSheet != null) {
      this.mShareActionSheet.dismiss();
    }
  }
  
  public void init(Context paramContext)
  {
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = paramContext;
    this.mShareActionSheet = ShareActionSheetFactory.create(localParam);
    this.mShareActionSheet.setItemClickListenerV2(new ShareActionSheetApiImpl.1(this));
  }
  
  public boolean isShowing()
  {
    return (this.mShareActionSheet != null) && (this.mShareActionSheet.isShowing());
  }
  
  public void setActionSheetClickListener(ShareActionSheetClickListener paramShareActionSheetClickListener)
  {
    this.mShareActionSheetClickListener = paramShareActionSheetClickListener;
  }
  
  public void setActionSheetItems(ShareConfig paramShareConfig)
  {
    List localList = getPathsLines(paramShareConfig);
    paramShareConfig = getOperationsLines(paramShareConfig);
    this.mShareActionSheet.setActionSheetItems(localList, paramShareConfig);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mShareActionSheet.setCancelListener(paramOnCancelListener);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mShareActionSheet.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setQCircleActionSheetClickListener(QCircleActionSheetClickListener paramQCircleActionSheetClickListener)
  {
    this.mQCircleClickListener = paramQCircleActionSheetClickListener;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mShareActionSheet.setRowVisibility(paramInt1, paramInt2, paramInt3);
  }
  
  public void show()
  {
    this.mShareActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.impl.ShareActionSheetApiImpl
 * JD-Core Version:    0.7.0.1
 */