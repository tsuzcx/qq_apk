package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.GeneralGroupNotifyParser;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.InviteJoinGroupSecFrontParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class TroopNotificationGeneralGroupNotifyParserController$GeneralGroupNotifyParserProvider
{
  private Map<Integer, GeneralGroupNotifyParser> a = new ConcurrentHashMap();
  
  public static GeneralGroupNotifyParserProvider a()
  {
    return TroopNotificationGeneralGroupNotifyParserController.GeneralGroupNotifyParserProvider.SingletonHolder.a();
  }
  
  private GeneralGroupNotifyParser b(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 91) {
        return null;
      }
      return new AllianceGeneralGroupNotifyParser();
    }
    return new InviteJoinGroupSecFrontParser();
  }
  
  public GeneralGroupNotifyParser a(int paramInt)
  {
    Object localObject = (GeneralGroupNotifyParser)this.a.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      try
      {
        GeneralGroupNotifyParser localGeneralGroupNotifyParser2 = (GeneralGroupNotifyParser)this.a.get(Integer.valueOf(paramInt));
        localObject = localGeneralGroupNotifyParser2;
        if (localGeneralGroupNotifyParser2 == null)
        {
          localGeneralGroupNotifyParser2 = b(paramInt);
          localObject = localGeneralGroupNotifyParser2;
          if (localGeneralGroupNotifyParser2 != null)
          {
            this.a.put(Integer.valueOf(paramInt), localGeneralGroupNotifyParser2);
            localObject = localGeneralGroupNotifyParser2;
          }
        }
        return localObject;
      }
      finally {}
    }
    return localGeneralGroupNotifyParser1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationGeneralGroupNotifyParserController.GeneralGroupNotifyParserProvider
 * JD-Core Version:    0.7.0.1
 */