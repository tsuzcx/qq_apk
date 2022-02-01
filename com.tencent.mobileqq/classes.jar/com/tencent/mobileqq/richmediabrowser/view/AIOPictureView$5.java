package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.io.File;

class AIOPictureView$5
  implements ShareActionSheet.OnItemClickListener
{
  AIOPictureView$5(AIOPictureView paramAIOPictureView, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (i != 72) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    if (i != 2) {
      if (i != 6)
      {
        if (i != 9)
        {
          if (i != 27)
          {
            if (i != 39)
            {
              if (i != 48) {
                if (i != 66) {
                  if ((i == 72) || (i == 73)) {
                    break label754;
                  }
                }
              }
              switch (i)
              {
              default: 
                break;
              case 56: 
                paramActionSheetItem = new Intent();
                ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_i_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.h, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 2, ParamsManager.a().d(), ParamsManager.a().c(), paramActionSheetItem);
                i = 10;
                break;
              case 55: 
                paramActionSheetItem = new Intent();
                ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_i_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.h, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 1, ParamsManager.a().d(), ParamsManager.a().c(), paramActionSheetItem);
                ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
                i = 9;
                break;
              case 54: 
                AIOPictureView.d(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
                i = 7;
                break;
              case 52: 
                if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                  ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
                }
                i = 8;
                break;
              case 51: 
                AIOPictureView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
                i = 5;
                break;
              case 50: 
                if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider != null) {
                  this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a("Pic_Forward_Qzone", 0);
                }
                if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).fowardToQzoneAlbum((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext, ParamsManager.a().d(), ParamsManager.a().b(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.c, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.baseData, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_Boolean, ParamsManager.a().a());
                }
                if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.b) {
                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
                }
                i = 4;
                break label769;
                AIOPictureView.e(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
                break;
                AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
                i = 12;
                break;
              }
            }
            else
            {
              AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
              i = 2;
              break label769;
            }
          }
          else
          {
            AIOPictureView.c(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
            i = 6;
            break label769;
          }
        }
        else
        {
          ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).sharePicToWXFromPeak(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.jdField_a_of_type_AndroidContentContext);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        }
        i = 0;
        break label769;
      }
      else
      {
        AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        i = 3;
        break label769;
      }
    }
    label754:
    AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, i, paramActionSheetItem, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
    i = 1;
    label769:
    ReportController.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.5
 * JD-Core Version:    0.7.0.1
 */