package com.tencent.mobileqq.filemanager.fileview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class LocalTbsViewManager$TbsFileReaderEventCallback
  implements TbsReaderView.ReaderCallback
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final LocalTbsViewManager.LocalTbsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback;
  private final String jdField_a_of_type_JavaLangString;
  
  public LocalTbsViewManager$TbsFileReaderEventCallback(LocalTbsViewManager paramLocalTbsViewManager, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback = paramLocalTbsViewManagerCallback;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Object paramObject, String paramString, int paramInt)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Bundle)) {
        return;
      }
      ((Bundle)paramObject).putInt(paramString, paramInt);
    }
  }
  
  public void a(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Bundle)) {
        return;
      }
      ((Bundle)paramObject).putBoolean(paramString, paramBoolean);
    }
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    int i = paramInteger.intValue();
    if (i != 12)
    {
      boolean bool = true;
      Object localObject;
      if (i != 19)
      {
        if (i != 5000)
        {
          if (i != 5045)
          {
            if (i != 5011) {
              if (i != 5012)
              {
                if (i != 5024)
                {
                  if (i == 5025) {
                    LocalTbsViewManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager, false, false);
                  }
                }
                else
                {
                  localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback;
                  if (localObject != null) {
                    a(paramObject2, "is_bar_show", ((LocalTbsViewManager.LocalTbsViewManagerCallback)localObject).a() ^ true);
                  }
                }
              }
              else {
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager.a(paramObject1, this.jdField_a_of_type_JavaLangString);
              }
            }
          }
          else {
            a(paramObject2, "TitleHeight", (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131299168));
          }
        }
        else {
          a(paramObject2, "is_bar_animating", false);
        }
      }
      else if ((paramObject1 != null) && ((paramObject1 instanceof Integer)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager;
        if (((Integer)paramObject1).intValue() != 0) {
          bool = false;
        }
        LocalTbsViewManager.a((LocalTbsViewManager)localObject, false, bool);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager.a(paramObject1, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager.a(paramInteger.intValue(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback);
    if (paramInteger.intValue() == 6001) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager.a(this.jdField_a_of_type_AndroidAppActivity, paramObject1, paramObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.TbsFileReaderEventCallback
 * JD-Core Version:    0.7.0.1
 */