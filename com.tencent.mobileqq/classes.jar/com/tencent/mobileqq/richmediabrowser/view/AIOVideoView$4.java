package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import java.io.File;

class AIOVideoView$4
  implements ShareActionSheet.OnItemClickListener
{
  AIOVideoView$4(AIOVideoView paramAIOVideoView, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      int i = paramActionSheetItem.action;
      if (i != 2) {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 27)
            {
              if (i != 39)
              {
                if (i != 54)
                {
                  if (i != 64)
                  {
                    if ((i == 72) || (i == 73)) {
                      break label578;
                    }
                    if (i != 126)
                    {
                      if (i == 127)
                      {
                        ((IVideoDepend)QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.c, "", "", "", 2, ParamsManager.a().d(), ParamsManager.a().c());
                        AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, "0X800ACB8", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
                      }
                    }
                    else
                    {
                      ((IVideoDepend)QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.c, "", "", "", 1, ParamsManager.a().d(), ParamsManager.a().c());
                      AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, "0X800ACB7", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
                    }
                  }
                  else
                  {
                    AIOVideoView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
                    i = 7;
                    break label593;
                  }
                }
                else
                {
                  ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", ParamsManager.a().c(), 0, "", "", "", "");
                  paramShareActionSheet = ParamsManager.a().a();
                  paramActionSheetItem = paramShareActionSheet;
                  if (TextUtils.isEmpty(paramShareActionSheet)) {
                    paramActionSheetItem = ParamsManager.a().c();
                  }
                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false);
                  break label491;
                }
              }
              else {
                AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
              }
              i = 0;
              break label593;
            }
            else if ((AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView) != null) && (AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView).a()))
            {
              AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.a);
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext.getString(2131718241), 0).a();
            }
            label491:
            i = 6;
            break label593;
          }
          else
          {
            AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
            i = 3;
            break label593;
          }
        }
        else
        {
          ((IVideoDepend)QRoute.api(IVideoDepend.class)).sendToQZone((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, ParamsManager.a().d(), this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          ReportController.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          break label593;
        }
      }
      label578:
      AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, i, paramActionSheetItem);
      i = 1;
      label593:
      paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a.getSelectedItem();
      if ((paramActionSheetItem != null) && (paramActionSheetItem.baseData != null) && (AIOVideoData.class.isInstance(paramActionSheetItem.baseData)))
      {
        paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
        if (paramActionSheetItem.jdField_d_of_type_Int == 0)
        {
          ReportController.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
        }
        if (paramActionSheetItem.jdField_d_of_type_Int == 1) {
          ReportController.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.4
 * JD-Core Version:    0.7.0.1
 */