package com.tencent.tkd.topicsdk.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/NetWorkStatus;", "", "(Ljava/lang/String;I)V", "None", "Wifi", "Mobile", "Other", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public enum NetWorkStatus
{
  static
  {
    NetWorkStatus localNetWorkStatus1 = new NetWorkStatus("None", 0);
    None = localNetWorkStatus1;
    NetWorkStatus localNetWorkStatus2 = new NetWorkStatus("Wifi", 1);
    Wifi = localNetWorkStatus2;
    NetWorkStatus localNetWorkStatus3 = new NetWorkStatus("Mobile", 2);
    Mobile = localNetWorkStatus3;
    NetWorkStatus localNetWorkStatus4 = new NetWorkStatus("Other", 3);
    Other = localNetWorkStatus4;
    $VALUES = new NetWorkStatus[] { localNetWorkStatus1, localNetWorkStatus2, localNetWorkStatus3, localNetWorkStatus4 };
  }
  
  private NetWorkStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.NetWorkStatus
 * JD-Core Version:    0.7.0.1
 */