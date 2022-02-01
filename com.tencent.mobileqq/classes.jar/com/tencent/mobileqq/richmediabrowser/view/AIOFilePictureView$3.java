package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

class AIOFilePictureView$3
  implements ShareActionSheet.OnItemClickListener
{
  AIOFilePictureView$3(AIOFilePictureView paramAIOFilePictureView, AIOFilePictureData paramAIOFilePictureData, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      int i = paramActionSheetItem.action;
      boolean bool = false;
      if (i != 2)
      {
        if (i != 6)
        {
          if (i != 39)
          {
            if (i != 52)
            {
              if (i != 64)
              {
                if (i != 69)
                {
                  if (i != 121)
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
                            if (i != 73)
                            {
                              switch (i)
                              {
                              default: 
                                break;
                              case 56: 
                                AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, 2);
                                break;
                              case 55: 
                                AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, 1);
                                ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
                                break;
                              case 54: 
                                localObject = ParamsManager.a().a();
                                paramShareActionSheet = (ShareActionSheet)localObject;
                                if (TextUtils.isEmpty((CharSequence)localObject)) {
                                  paramShareActionSheet = ParamsManager.a().c();
                                }
                                ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().c(), paramShareActionSheet, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, false);
                                break;
                              }
                            }
                            else if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null))
                            {
                              paramShareActionSheet = AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
                              if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {
                                bool = true;
                              } else {
                                bool = false;
                              }
                              ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, paramShareActionSheet, bool, ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
                            }
                          }
                          else
                          {
                            i = paramActionSheetItem.uinType;
                            paramShareActionSheet = paramActionSheetItem.uin;
                            if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null))
                            {
                              localObject = AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
                              if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {
                                bool = true;
                              }
                              ((IFileDepend)QRoute.api(IFileDepend.class)).forwardToTargetFriend((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, (Intent)localObject, bool, paramShareActionSheet, i);
                            }
                          }
                        }
                        else if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null))
                        {
                          AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
                          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext.getString(2131718241), 0).a();
                        }
                      }
                      else if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null))
                      {
                        AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).c(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
                        ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
                        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext.getString(2131718240), 0).a();
                      }
                    }
                    else
                    {
                      QbSdk.clearDefaultBrowser(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getPath());
                      QQFileManagerUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getPath());
                    }
                  }
                  else if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null)) {
                    AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
                  }
                }
                else
                {
                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).sharePicToWXFromPeak(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext);
                  ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
                }
              }
              else {
                QQFileManagerUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getPath());
              }
            }
            else {
              ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.f);
            }
          }
          else {
            AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData);
          }
        }
        else if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null)) {
          AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).d(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
        }
      }
      else if ((AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView)) && (AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView) != null))
      {
        paramShareActionSheet = AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, paramShareActionSheet, bool, ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
      }
      ReportController.b(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, paramActionSheetItem.action), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.3
 * JD-Core Version:    0.7.0.1
 */