package com.tencent.thumbplayer.core.downloadproxy.net;

public class NetworkState
{
  private final boolean mConnected;
  private final boolean mIsPrivateDnsActive;
  private final String mNetworkIdentifier;
  private final String mPrivateDnsServerName;
  private final int mSubtype;
  private final int mType;
  
  public NetworkState(boolean paramBoolean1, int paramInt1, int paramInt2, String paramString1, boolean paramBoolean2, String paramString2)
  {
    this.mConnected = paramBoolean1;
    this.mType = paramInt1;
    this.mSubtype = paramInt2;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.mNetworkIdentifier = str;
    this.mIsPrivateDnsActive = paramBoolean2;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.mPrivateDnsServerName = paramString1;
  }
  
  @NetworkConstants.ConnectionType
  public static int convertToConnectionType(int paramInt1, int paramInt2)
  {
    int j = 5;
    int i = j;
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    default: 
      i = 0;
    case 6: 
      return i;
    case 9: 
      return 1;
    case 1: 
      return 2;
    case 7: 
      return 7;
    }
    i = j;
    switch (paramInt2)
    {
    case 13: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 3;
    }
    return 4;
  }
  
  @NetworkConstants.ConnectionSubType
  public int getConnectionSubtype()
  {
    int i = 0;
    if (!isConnected())
    {
      i = 1;
      return i;
    }
    switch (getNetworkType())
    {
    case 1: 
    case 6: 
    case 7: 
    case 9: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    default: 
      return 0;
    }
    switch (getNetworkSubType())
    {
    default: 
      return 0;
    case 1: 
      return 7;
    case 2: 
      return 8;
    case 4: 
      return 5;
    case 7: 
      return 6;
    case 11: 
      return 4;
    case 3: 
      return 9;
    case 5: 
      return 10;
    case 6: 
      return 11;
    case 8: 
      return 14;
    case 9: 
      return 15;
    case 10: 
      return 12;
    case 12: 
      return 13;
    case 14: 
      return 16;
    case 15: 
      return 17;
    }
    return 18;
  }
  
  @NetworkConstants.ConnectionType
  public int getConnectionType()
  {
    if (!isConnected()) {
      return 6;
    }
    return convertToConnectionType(getNetworkType(), getNetworkSubType());
  }
  
  public String getNetworkIdentifier()
  {
    return this.mNetworkIdentifier;
  }
  
  public int getNetworkSubType()
  {
    return this.mSubtype;
  }
  
  public int getNetworkType()
  {
    return this.mType;
  }
  
  public String getPrivateDnsServerName()
  {
    return this.mPrivateDnsServerName;
  }
  
  public boolean isConnected()
  {
    return this.mConnected;
  }
  
  public boolean isPrivateDnsActive()
  {
    return this.mIsPrivateDnsActive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkState
 * JD-Core Version:    0.7.0.1
 */