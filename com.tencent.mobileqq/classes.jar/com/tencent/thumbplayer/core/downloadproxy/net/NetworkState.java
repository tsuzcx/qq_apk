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
    String str2 = "";
    String str1 = paramString1;
    if (paramString1 == null) {
      str1 = "";
    }
    this.mNetworkIdentifier = str1;
    this.mIsPrivateDnsActive = paramBoolean2;
    if (paramString2 == null) {
      paramString2 = str2;
    }
    this.mPrivateDnsServerName = paramString2;
  }
  
  @NetworkConstants.ConnectionType
  public static int convertToConnectionType(int paramInt1, int paramInt2)
  {
    int i = 5;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        paramInt2 = i;
        if (paramInt1 != 6)
        {
          paramInt2 = 7;
          if (paramInt1 != 7)
          {
            if (paramInt1 != 9) {
              return 0;
            }
            return 1;
          }
        }
        return paramInt2;
      }
      return 2;
    }
    switch (paramInt2)
    {
    default: 
      return 0;
    case 13: 
      return 5;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 4;
    }
    return 3;
  }
  
  @NetworkConstants.ConnectionSubType
  public int getConnectionSubtype()
  {
    if (!isConnected()) {
      return 1;
    }
    int i = getNetworkType();
    if (i != 0)
    {
      if ((i != 1) && (i != 6) && (i != 7) && (i != 9)) {}
      return 0;
    }
    switch (getNetworkSubType())
    {
    default: 
      return 0;
    case 15: 
      return 17;
    case 14: 
      return 16;
    case 13: 
      return 18;
    case 12: 
      return 13;
    case 11: 
      return 4;
    case 10: 
      return 12;
    case 9: 
      return 15;
    case 8: 
      return 14;
    case 7: 
      return 6;
    case 6: 
      return 11;
    case 5: 
      return 10;
    case 4: 
      return 5;
    case 3: 
      return 9;
    case 2: 
      return 8;
    }
    return 7;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.NetworkState
 * JD-Core Version:    0.7.0.1
 */