package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class TeamWorkForceShare$2$1
  implements Runnable
{
  TeamWorkForceShare$2$1(TeamWorkForceShare.2 param2, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    TeamWorkForceShare.2.1.1 local1 = new TeamWorkForceShare.2.1.1(this);
    WXShareHelper.a().a(local1);
    TeamWorkForceShare.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkForceShare$2.this$0, String.valueOf(System.currentTimeMillis()));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, 280, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkForceShare$2.a ^ true, TeamWorkForceShare.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkForceShare$2.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1
 * JD-Core Version:    0.7.0.1
 */