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
    if (paramShareConfig == null) {
      return localArrayList;
    }
    if (paramShareConfig.isShowDelete) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
    }
    if (paramShareConfig.isShowSave) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    }
    if (paramShareConfig.isShowDeletePush) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(140));
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
    if (paramShareConfig.isShowDebug) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
    }
    return localArrayList;
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> getPathsLines(ShareConfig paramShareConfig)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramShareConfig == null) {
      return localArrayList;
    }
    if (paramShareConfig.isShowShareToFriend) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    }
    if (paramShareConfig.isShowShareToQZone) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    if (paramShareConfig.isShowShareToWechat) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    }
    if (paramShareConfig.isShowShareToWechatCircle) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    return localArrayList;
  }
  
  private void handleClickMenuItem(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 39)
        {
          if (i != 40)
          {
            if (i != 44)
            {
              if (i != 86)
              {
                if (i != 162)
                {
                  switch (i)
                  {
                  default: 
                    switch (i)
                    {
                    default: 
                      switch (i)
                      {
                      default: 
                        break;
                      case 143: 
                        paramActionSheetItem = this.mShareActionSheetClickListener;
                        if (paramActionSheetItem == null) {
                          break;
                        }
                        paramActionSheetItem.switchBarrageClose();
                        break;
                      case 142: 
                        paramActionSheetItem = this.mShareActionSheetClickListener;
                        if (paramActionSheetItem == null) {
                          break;
                        }
                        paramActionSheetItem.switchBarrageOpen();
                        break;
                      case 141: 
                        paramActionSheetItem = this.mShareActionSheetClickListener;
                        if (paramActionSheetItem == null) {
                          break;
                        }
                        paramActionSheetItem.hideThisWork();
                        break;
                      case 140: 
                        paramActionSheetItem = this.mShareActionSheetClickListener;
                        if (paramActionSheetItem == null) {
                          break;
                        }
                        paramActionSheetItem.deleteHasPush();
                      }
                      break;
                    case 74: 
                      paramActionSheetItem = this.mShareActionSheetClickListener;
                      if (paramActionSheetItem == null) {
                        break;
                      }
                      paramActionSheetItem.miniAppDebugOn();
                      break;
                    case 72: 
                      ShareActionSheetClickListener localShareActionSheetClickListener = this.mShareActionSheetClickListener;
                      if (localShareActionSheetClickListener == null) {
                        break;
                      }
                      localShareActionSheetClickListener.shareToSpecifiedFriend(paramActionSheetItem.uin, paramActionSheetItem.uinType);
                    }
                    break;
                  case 11: 
                    paramActionSheetItem = this.mShareActionSheetClickListener;
                    if (paramActionSheetItem == null) {
                      break;
                    }
                    paramActionSheetItem.report();
                    break;
                  case 10: 
                    paramActionSheetItem = this.mShareActionSheetClickListener;
                    if (paramActionSheetItem == null) {
                      break;
                    }
                    paramActionSheetItem.shareToWeChatCircle();
                    break;
                  case 9: 
                    paramActionSheetItem = this.mShareActionSheetClickListener;
                    if (paramActionSheetItem == null) {
                      break;
                    }
                    paramActionSheetItem.shareToWeChat();
                    break;
                  }
                }
                else
                {
                  paramActionSheetItem = this.mShareActionSheetClickListener;
                  if (paramActionSheetItem != null) {
                    paramActionSheetItem.jumpQcirclePrivateMessage();
                  }
                }
              }
              else
              {
                paramActionSheetItem = this.mShareActionSheetClickListener;
                if (paramActionSheetItem != null) {
                  paramActionSheetItem.hideHim();
                }
              }
            }
            else
            {
              paramActionSheetItem = this.mShareActionSheetClickListener;
              if (paramActionSheetItem != null) {
                paramActionSheetItem.showReportDisLike();
              }
              bool = false;
              break label435;
            }
          }
          else
          {
            paramActionSheetItem = this.mShareActionSheetClickListener;
            if (paramActionSheetItem != null) {
              paramActionSheetItem.delete();
            }
          }
        }
        else
        {
          paramActionSheetItem = this.mShareActionSheetClickListener;
          if (paramActionSheetItem != null) {
            paramActionSheetItem.save();
          }
        }
      }
      else
      {
        paramActionSheetItem = this.mShareActionSheetClickListener;
        if (paramActionSheetItem != null) {
          paramActionSheetItem.shareToQZone();
        }
      }
    }
    else
    {
      paramActionSheetItem = this.mShareActionSheetClickListener;
      if (paramActionSheetItem != null) {
        paramActionSheetItem.shareToQQ();
      }
    }
    boolean bool = true;
    label435:
    if ((i == 3) || (i == 9) || (i == 10) || (i == 72) || (i == 73) || (i == 2) || (i == 142) || (i == 143))
    {
      paramActionSheetItem = this.mQCircleClickListener;
      if (paramActionSheetItem != null) {
        paramActionSheetItem.dispatchEvent();
      }
    }
    paramActionSheetItem = this.mShareActionSheet;
    if (paramActionSheetItem != null) {
      paramActionSheetItem.dismiss();
    }
    paramActionSheetItem = this.mQCircleClickListener;
    if (paramActionSheetItem != null) {
      paramActionSheetItem.afterHandleClick(bool);
    }
  }
  
  public void dismiss()
  {
    ShareActionSheet localShareActionSheet = this.mShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.dismiss();
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
    ShareActionSheet localShareActionSheet = this.mShareActionSheet;
    return (localShareActionSheet != null) && (localShareActionSheet.isShowing());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.impl.ShareActionSheetApiImpl
 * JD-Core Version:    0.7.0.1
 */