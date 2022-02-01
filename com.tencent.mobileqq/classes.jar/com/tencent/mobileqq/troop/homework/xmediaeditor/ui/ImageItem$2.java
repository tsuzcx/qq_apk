package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class ImageItem$2
  extends SimpleObserver<ImageInfo>
{
  ImageItem$2(ImageItem paramImageItem, ImageInfo paramImageInfo) {}
  
  public void a(ImageInfo paramImageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(paramImageInfo.c), ", old status=", Integer.valueOf(paramImageInfo.g), ", result=", paramImageInfo });
    }
    paramImageInfo.g = 3;
    paramImageInfo.e = 100;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_JavaUtilMap.remove(paramImageInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.c);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(paramImageInfo.hashCode()), ", result hash=", Integer.valueOf(paramImageInfo.hashCode()), ", info position=", Integer.valueOf(paramImageInfo.c), ", result position=", Integer.valueOf(paramImageInfo.c), ", vh position=", Integer.valueOf(((ImageItem.ImageViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramImageInfo.d.equals(((ImageItem.ImageViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((ImageItem.ImageViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((ImageItem.ImageViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((ImageItem.ImageViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramImageInfo.e, paramImageInfo.d);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    TroopTechReportUtils.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - paramImageInfo.a), "");
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.g) });
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.g = 2;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.c);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.d.equals(((ImageItem.ImageViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((ImageItem)((XMediaEditorAdapter)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((ImageItem.ImageViewHolder)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      TroopTechReportUtils.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.a), "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo.d.equals(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiImageItem.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.2
 * JD-Core Version:    0.7.0.1
 */