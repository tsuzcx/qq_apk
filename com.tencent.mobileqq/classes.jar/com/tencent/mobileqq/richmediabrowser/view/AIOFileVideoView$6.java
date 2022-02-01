package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.smtt.sdk.QbSdk;

class AIOFileVideoView$6
  implements ShareActionSheet.OnItemClickListener
{
  AIOFileVideoView$6(AIOFileVideoView paramAIOFileVideoView, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      int i = paramActionSheetItem.action;
      boolean bool;
      if (i != 2) {
        if (i != 6)
        {
          if (i != 39)
          {
            if (i != 64)
            {
              if (i != 132)
              {
                if (i != 26)
                {
                  if (i != 27)
                  {
                    Object localObject;
                    if (i != 72)
                    {
                      if (i != 73) {
                        switch (i)
                        {
                        default: 
                          break;
                        case 56: 
                          AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData, 2);
                          ReportController.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
                          break;
                        case 55: 
                          AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData, 1);
                          ReportController.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
                          break;
                        case 54: 
                          localObject = ParamsManager.a().a();
                          paramShareActionSheet = (ShareActionSheet)localObject;
                          if (TextUtils.isEmpty((CharSequence)localObject)) {
                            paramShareActionSheet = ParamsManager.a().c();
                          }
                          ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().c(), paramShareActionSheet, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
                          break;
                        }
                      }
                    }
                    else
                    {
                      i = paramActionSheetItem.uinType;
                      paramShareActionSheet = paramActionSheetItem.uin;
                      if ((!AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) || (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView) == null)) {
                        break label812;
                      }
                      localObject = AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
                      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {
                        bool = true;
                      } else {
                        bool = false;
                      }
                      ((IFileDepend)QRoute.api(IFileDepend.class)).forwardToTargetFriend((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, (Intent)localObject, bool, paramShareActionSheet, i);
                      break label812;
                    }
                  }
                  else
                  {
                    if ((!AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) || (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView) == null)) {
                      break label812;
                    }
                    AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
                    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext.getString(2131718241), 0).a();
                    break label812;
                  }
                }
                else
                {
                  if ((!AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) || (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView) == null)) {
                    break label812;
                  }
                  AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView).c(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
                  ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
                  QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext.getString(2131718240), 0).a();
                  break label812;
                }
              }
              else
              {
                QbSdk.clearDefaultBrowser(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                QQFileManagerUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
                break label812;
              }
            }
            else
            {
              QQFileManagerUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
              break label812;
            }
          }
          else
          {
            AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData);
            break label812;
          }
        }
        else
        {
          if ((!AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) || (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView) == null)) {
            break label812;
          }
          AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView).d(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          break label812;
        }
      }
      if ((AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) && (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView) != null))
      {
        paramShareActionSheet = AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_AndroidContentContext, paramShareActionSheet, bool, ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
      }
      label812:
      ReportController.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", AIOFileVideoView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, paramActionSheetItem.action), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.6
 * JD-Core Version:    0.7.0.1
 */