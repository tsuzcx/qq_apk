package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

public class MsgItemLayoutWrapper$HighlightItem
  implements Comparable<HighlightItem>
{
  public int a;
  public boolean b;
  
  public MsgItemLayoutWrapper$HighlightItem(MsgItemLayoutWrapper paramMsgItemLayoutWrapper, int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  public int a(HighlightItem paramHighlightItem)
  {
    int i = this.a;
    int j = paramHighlightItem.a;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      return ((HighlightItem)paramObject).a == this.a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.MsgItemLayoutWrapper.HighlightItem
 * JD-Core Version:    0.7.0.1
 */