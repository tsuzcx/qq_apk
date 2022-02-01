package com.tencent.mobileqq.qwallet.hb.aio.elem;

public abstract interface IRedPacket$OnGetSkinListener
{
  public static final int TYPE_AIO_REDPACKET = 1;
  public static final int TYPE_POP_ANIM = 4;
  public static final int TYPE_POP_REDPACKET = 2;
  public static final int TYPE_SPECAIL_ANIM = 3;
  
  public abstract void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener
 * JD-Core Version:    0.7.0.1
 */