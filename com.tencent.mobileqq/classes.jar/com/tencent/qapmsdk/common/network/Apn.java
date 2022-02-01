package com.tencent.qapmsdk.common.network;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/network/Apn;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_INIT", "TYPE_UNKNOWN", "TYPE_NET", "TYPE_WAP", "TYPE_WIFI", "T_APN_CMWAP", "T_APN_3GWAP", "T_APN_UNIWAP", "T_APN_CTWAP", "T_APN_CTNET", "T_APN_UNINET", "T_APN_3GNET", "T_APN_CMNET", "T_APN_CTLTE", "T_APN_WONET", "T_APN_CMLTE", "T_APN_CM3G", "common_release"}, k=1, mv={1, 1, 15})
public enum Apn
{
  private final int value;
  
  static
  {
    Apn localApn1 = new Apn("TYPE_INIT", 0, -1);
    TYPE_INIT = localApn1;
    Apn localApn2 = new Apn("TYPE_UNKNOWN", 1, 0);
    TYPE_UNKNOWN = localApn2;
    Apn localApn3 = new Apn("TYPE_NET", 2, 1);
    TYPE_NET = localApn3;
    Apn localApn4 = new Apn("TYPE_WAP", 3, 2);
    TYPE_WAP = localApn4;
    Apn localApn5 = new Apn("TYPE_WIFI", 4, 4);
    TYPE_WIFI = localApn5;
    Apn localApn6 = new Apn("T_APN_CMWAP", 5, 8);
    T_APN_CMWAP = localApn6;
    Apn localApn7 = new Apn("T_APN_3GWAP", 6, 16);
    T_APN_3GWAP = localApn7;
    Apn localApn8 = new Apn("T_APN_UNIWAP", 7, 32);
    T_APN_UNIWAP = localApn8;
    Apn localApn9 = new Apn("T_APN_CTWAP", 8, 64);
    T_APN_CTWAP = localApn9;
    Apn localApn10 = new Apn("T_APN_CTNET", 9, 128);
    T_APN_CTNET = localApn10;
    Apn localApn11 = new Apn("T_APN_UNINET", 10, 256);
    T_APN_UNINET = localApn11;
    Apn localApn12 = new Apn("T_APN_3GNET", 11, 512);
    T_APN_3GNET = localApn12;
    Apn localApn13 = new Apn("T_APN_CMNET", 12, 1024);
    T_APN_CMNET = localApn13;
    Apn localApn14 = new Apn("T_APN_CTLTE", 13, 2048);
    T_APN_CTLTE = localApn14;
    Apn localApn15 = new Apn("T_APN_WONET", 14, 4096);
    T_APN_WONET = localApn15;
    Apn localApn16 = new Apn("T_APN_CMLTE", 15, 8192);
    T_APN_CMLTE = localApn16;
    Apn localApn17 = new Apn("T_APN_CM3G", 16, 16384);
    T_APN_CM3G = localApn17;
    $VALUES = new Apn[] { localApn1, localApn2, localApn3, localApn4, localApn5, localApn6, localApn7, localApn8, localApn9, localApn10, localApn11, localApn12, localApn13, localApn14, localApn15, localApn16, localApn17 };
  }
  
  private Apn(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.network.Apn
 * JD-Core Version:    0.7.0.1
 */