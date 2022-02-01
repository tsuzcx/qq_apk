package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.Gallery;

class TroopAvatarWallPreviewActivity$2$1
  implements Runnable
{
  TroopAvatarWallPreviewActivity$2$1(TroopAvatarWallPreviewActivity.2 param2, Setting paramSetting) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.b);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.e != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.e);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    TroopAvatarBigPhotoAdapter localTroopAvatarBigPhotoAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.a.getBoolean("from_photo_wall", false)) {}
    for (boolean bool = true;; bool = false)
    {
      localTroopAvatarBigPhotoAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.a.getBoolean("is_use_path", false));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.a.getInt("index", -1);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.getResources().getDimensionPixelSize(2131297168));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new TroopAvatarWallPreviewActivity.2.1.1(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new TroopAvatarWallPreviewActivity.2.1.2(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$2.this$0.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new TroopAvatarWallPreviewActivity.2.1.3(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2.1
 * JD-Core Version:    0.7.0.1
 */