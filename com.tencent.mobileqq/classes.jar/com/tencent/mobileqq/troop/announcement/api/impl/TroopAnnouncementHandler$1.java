package com.tencent.mobileqq.troop.announcement.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.HashMap;

class TroopAnnouncementHandler$1
  extends TroopObserver
{
  TroopAnnouncementHandler$1(TroopAnnouncementHandler paramTroopAnnouncementHandler, long paramLong1, String paramString1, int paramInt1, long paramLong2, long paramLong3, String paramString2, int paramInt2, short paramShort, boolean paramBoolean) {}
  
  public void onGetTroopAuth(boolean paramBoolean, long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_Long == paramLong) && (paramString.equals("SUBCMD_GET_TROOP_AUTH_FOR_ANNOUNCEMENT")))
    {
      if ((paramBoolean) && (paramArrayOfByte != null))
      {
        short s = (short)paramArrayOfByte.length;
        if ("OidbSvc.0x852_35".equals(this.jdField_a_of_type_JavaLangString)) {
          TroopAnnouncementHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiImplTroopAnnouncementHandler, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, s, paramArrayOfByte, this.c, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
        } else if ("OidbSvc.0x852_48".equals(this.jdField_a_of_type_JavaLangString)) {
          TroopAnnouncementHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiImplTroopAnnouncementHandler, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, s, paramArrayOfByte, this.jdField_a_of_type_Short, this.jdField_a_of_type_Boolean);
        }
      }
      else
      {
        TroopAnnouncementHandler.a().remove(this.jdField_b_of_type_JavaLangString);
      }
      TroopAnnouncementHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiImplTroopAnnouncementHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHandler.1
 * JD-Core Version:    0.7.0.1
 */