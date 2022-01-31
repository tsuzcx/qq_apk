package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import axez;
import bbsh;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class TeamWorkForceShare$2$1
  implements Runnable
{
  TeamWorkForceShare$2$1(TeamWorkForceShare.2 param2, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = new axez(this);
    WXShareHelper.a().a((bbsh)localObject);
    TeamWorkForceShare.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkForceShare$2.this$0, String.valueOf(System.currentTimeMillis()));
    localObject = WXShareHelper.a();
    String str = this.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkForceShare$2.a) {}
    for (int i = 0;; i = 1)
    {
      ((WXShareHelper)localObject).a(str, localBitmap, 280, i, TeamWorkForceShare.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkForceShare$2.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1
 * JD-Core Version:    0.7.0.1
 */