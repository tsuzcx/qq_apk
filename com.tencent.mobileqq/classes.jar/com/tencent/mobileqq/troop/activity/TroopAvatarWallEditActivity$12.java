package com.tencent.mobileqq.troop.activity;

import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class TroopAvatarWallEditActivity$12
  extends AsyncTask<Void, Void, String>
{
  TroopAvatarWallEditActivity$12(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      String str2 = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (str2 != null)
      {
        ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, str2);
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131694913));
        paramVarArgs.append(" ");
        paramVarArgs.append(str2);
        String str1 = paramVarArgs.toString();
        paramVarArgs = str1;
        if (!QLog.isColorLevel()) {
          break label137;
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("savePhoto:");
        paramVarArgs.append(str2);
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, paramVarArgs.toString());
        return str1;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131694911);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      label137:
      break label127;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label117:
      label127:
      break label117;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131694911);
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131694911);
    return paramVarArgs;
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.12
 * JD-Core Version:    0.7.0.1
 */