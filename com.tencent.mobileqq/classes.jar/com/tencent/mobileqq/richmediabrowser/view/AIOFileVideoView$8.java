package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.utils.ForwardUtils;
import com.tencent.mobileqq.richmediabrowser.utils.GalleryJumpUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.presenter.IProvider;

class AIOFileVideoView$8
  implements ShareActionSheet.OnItemClickListener
{
  AIOFileVideoView$8(AIOFileVideoView paramAIOFileVideoView, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView))
      {
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, paramActionSheetItem, bool);
          i = j;
          break;
        }
        if (!AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (bool = true;; bool = false)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        i = paramActionSheetItem.uinType;
        paramActionSheetItem = paramActionSheetItem.uin;
        if (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView))
        {
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int != 1) {
            break label385;
          }
        }
        label385:
        for (bool = true;; bool = false)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
          i = -1;
          break;
        }
        if (!AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
        ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, 2, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext.getString(2131692688), 0).a();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView))
        {
          RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext.getString(2131692733), 0).a();
          i = j;
          continue;
          i = 2;
          AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData);
          continue;
          j = 3;
          i = j;
          if (AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView))
          {
            RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_a_of_type_Long);
            i = j;
            continue;
            paramShareActionSheet = ParamsManager.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = ParamsManager.a().c();
            }
            GalleryJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, ParamsManager.a().a(), ParamsManager.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            paramShareActionSheet = new Intent();
            if (MessageRecordInfo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = ParamsManager.a().d();; paramActionSheetItem = ParamsManager.a().c())
            {
              GalleryJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 1, ParamsManager.a().d(), ParamsManager.a().c(), paramShareActionSheet);
              ReportController.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 8;
              break;
            }
            paramShareActionSheet = new Intent();
            if (MessageRecordInfo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.f)) {}
            for (paramActionSheetItem = ParamsManager.a().d();; paramActionSheetItem = ParamsManager.a().c())
            {
              GalleryJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.h, 2, ParamsManager.a().d(), ParamsManager.a().c(), paramShareActionSheet);
              ReportController.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", AIOFileVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.e), 0, "", "", "", "");
              i = 9;
              break;
            }
            i = 7;
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData.c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.8
 * JD-Core Version:    0.7.0.1
 */