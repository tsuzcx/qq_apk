package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.GeneralGroupNotifyParser;
import mqq.app.AppRuntime;

public class TroopNotificationGeneralGroupNotifyParserController
  extends TroopNotificationController
{
  public TroopNotificationGeneralGroupNotifyParserController(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public GeneralGroupNotifyParser a(int paramInt)
  {
    return TroopNotificationGeneralGroupNotifyParserController.GeneralGroupNotifyParserProvider.a().a(paramInt);
  }
  
  @Nullable
  protected String a()
  {
    return "TroopNotificationGeneralGroupNotifyParserController";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationGeneralGroupNotifyParserController
 * JD-Core Version:    0.7.0.1
 */