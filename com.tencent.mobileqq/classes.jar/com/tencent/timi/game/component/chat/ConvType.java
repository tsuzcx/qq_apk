package com.tencent.timi.game.component.chat;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/ConvType;", "", "number", "", "(Ljava/lang/String;II)V", "C2C", "Group", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public enum ConvType
{
  static
  {
    ConvType localConvType1 = new ConvType("C2C", 0, 1);
    C2C = localConvType1;
    ConvType localConvType2 = new ConvType("Group", 1, 2);
    Group = localConvType2;
    $VALUES = new ConvType[] { localConvType1, localConvType2 };
  }
  
  private ConvType(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.ConvType
 * JD-Core Version:    0.7.0.1
 */