package com.tencent.timi.game.component.chat.message;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "", "(Ljava/lang/String;I)V", "COPY", "DELETE", "REPORT", "REVOCATION", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public enum LongClickOperOption
{
  static
  {
    LongClickOperOption localLongClickOperOption1 = new LongClickOperOption("COPY", 0);
    COPY = localLongClickOperOption1;
    LongClickOperOption localLongClickOperOption2 = new LongClickOperOption("DELETE", 1);
    DELETE = localLongClickOperOption2;
    LongClickOperOption localLongClickOperOption3 = new LongClickOperOption("REPORT", 2);
    REPORT = localLongClickOperOption3;
    LongClickOperOption localLongClickOperOption4 = new LongClickOperOption("REVOCATION", 3);
    REVOCATION = localLongClickOperOption4;
    $VALUES = new LongClickOperOption[] { localLongClickOperOption1, localLongClickOperOption2, localLongClickOperOption3, localLongClickOperOption4 };
  }
  
  private LongClickOperOption() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.LongClickOperOption
 * JD-Core Version:    0.7.0.1
 */