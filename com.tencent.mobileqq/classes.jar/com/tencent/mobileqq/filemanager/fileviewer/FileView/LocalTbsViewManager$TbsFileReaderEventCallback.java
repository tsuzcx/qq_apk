package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class LocalTbsViewManager$TbsFileReaderEventCallback
  implements TbsReaderView.ReaderCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LocalTbsViewManager.LocalTbsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback;
  private String jdField_a_of_type_JavaLangString;
  
  public LocalTbsViewManager$TbsFileReaderEventCallback(LocalTbsViewManager paramLocalTbsViewManager, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback = paramLocalTbsViewManagerCallback;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Object paramObject, String paramString, int paramInt)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {
      return;
    }
    ((Bundle)paramObject).putInt(paramString, paramInt);
  }
  
  public void a(Object paramObject, String paramString, boolean paramBoolean)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {
      return;
    }
    ((Bundle)paramObject).putBoolean(paramString, paramBoolean);
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager.a(paramInteger.intValue(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback);
      if (paramInteger.intValue() == 6001) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager.a(this.jdField_a_of_type_AndroidAppActivity, paramObject1, paramObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager.a(paramObject1, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback);
      continue;
      a(paramObject2, "is_bar_animating", false);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager.a(paramObject1, this.jdField_a_of_type_JavaLangString);
      continue;
      a(paramObject2, "TitleHeight", (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131299166));
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback.a()) {}
        for (int i = 0;; i = 1)
        {
          a(paramObject2, "is_bar_show", i);
          break;
        }
        if ((paramObject1 != null) && ((paramObject1 instanceof Integer)))
        {
          LocalTbsViewManager localLocalTbsViewManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager;
          if (((Integer)paramObject1).intValue() == 0) {}
          for (;;)
          {
            LocalTbsViewManager.a(localLocalTbsViewManager, false, bool);
            break;
            bool = false;
          }
          LocalTbsViewManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager, false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.TbsFileReaderEventCallback
 * JD-Core Version:    0.7.0.1
 */