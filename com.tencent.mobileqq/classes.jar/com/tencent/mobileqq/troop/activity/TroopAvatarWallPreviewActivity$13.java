package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import java.io.File;
import java.io.IOException;

class TroopAvatarWallPreviewActivity$13
  extends AsyncTask<Void, Void, String>
{
  TroopAvatarWallPreviewActivity$13(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      str1 = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (str1 != null)
      {
        paramVarArgs = null;
        try
        {
          String str2 = MimeTypeMap.getFileExtensionFromUrl(str1);
          if (str2 != null) {
            paramVarArgs = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
          }
          if ((paramVarArgs != null) && (paramVarArgs.startsWith("image/"))) {
            ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, new File(str1));
          }
        }
        catch (IllegalArgumentException paramVarArgs)
        {
          for (;;)
          {
            QLog.e("TroopAvatarWallPreviewActivity", 2, new Object[] { "savePic2SystemMedia illegalArgumentException ex", paramVarArgs.getMessage() });
          }
        }
        ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, str1);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getIntent().getBooleanExtra("from_photo_wall", false)) {
          return HardCodeUtil.a(2131715071);
        }
      }
    }
    catch (IOException paramVarArgs)
    {
      String str1;
      return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131694921);
      return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131694923) + " " + str1;
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131694921);
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131694921);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */