package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.float_window.IFloatViewCreator;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class YoloRoomFloatViewUtil$1
  extends HashMap<Integer, IFloatViewCreator>
{
  YoloRoomFloatViewUtil$1()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(Integer.valueOf(1));
    ((List)localObject1).add(Integer.valueOf(3));
    ((List)localObject1).add(Integer.valueOf(4));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject1).next();
      Object localObject2 = YoloRoomFloatViewUtil.a(localInteger.intValue());
      if (localObject2 != null)
      {
        put(localInteger, localObject2);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ATTENTION: sFloatViewCreatorMap error - ");
        ((StringBuilder)localObject2).append(localInteger);
        Logger.c("YoloRoomUtil", ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil.1
 * JD-Core Version:    0.7.0.1
 */