package com.tencent.qapmsdk.common.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/network/NetworkState;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NETWORK_NONE", "NETWORK_WIFI", "NETWORK_2G", "NETWORK_3G", "NETWORK_4G", "NETWORK_MOBILE", "common_release"}, k=1, mv={1, 1, 15})
public enum NetworkState
{
  @NotNull
  private final String value;
  
  static
  {
    NetworkState localNetworkState1 = new NetworkState("NETWORK_NONE", 0, "NONE");
    NETWORK_NONE = localNetworkState1;
    NetworkState localNetworkState2 = new NetworkState("NETWORK_WIFI", 1, "WIFI");
    NETWORK_WIFI = localNetworkState2;
    NetworkState localNetworkState3 = new NetworkState("NETWORK_2G", 2, "2G");
    NETWORK_2G = localNetworkState3;
    NetworkState localNetworkState4 = new NetworkState("NETWORK_3G", 3, "3G");
    NETWORK_3G = localNetworkState4;
    NetworkState localNetworkState5 = new NetworkState("NETWORK_4G", 4, "4G");
    NETWORK_4G = localNetworkState5;
    NetworkState localNetworkState6 = new NetworkState("NETWORK_MOBILE", 5, "MOBILE");
    NETWORK_MOBILE = localNetworkState6;
    $VALUES = new NetworkState[] { localNetworkState1, localNetworkState2, localNetworkState3, localNetworkState4, localNetworkState5, localNetworkState6 };
  }
  
  private NetworkState(String paramString)
  {
    this.value = paramString;
  }
  
  @NotNull
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.network.NetworkState
 * JD-Core Version:    0.7.0.1
 */