package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

public enum PullToRefreshBase$Mode
{
  public static Mode PULL_DOWN_TO_REFRESH;
  public static Mode PULL_UP_TO_REFRESH;
  private final int mIntValue;
  
  static
  {
    PULL_FROM_END = new Mode("PULL_FROM_END", 2, 2);
    BOTH = new Mode("BOTH", 3, 3);
    MANUAL_REFRESH_ONLY = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
    Mode localMode1 = DISABLED;
    Mode localMode2 = PULL_FROM_START;
    Mode localMode3 = PULL_FROM_END;
    $VALUES = new Mode[] { localMode1, localMode2, localMode3, BOTH, MANUAL_REFRESH_ONLY };
    PULL_DOWN_TO_REFRESH = localMode2;
    PULL_UP_TO_REFRESH = localMode3;
  }
  
  private PullToRefreshBase$Mode(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  static Mode getDefault()
  {
    return PULL_FROM_START;
  }
  
  static Mode mapIntToValue(int paramInt)
  {
    Mode[] arrayOfMode = values();
    int j = arrayOfMode.length;
    int i = 0;
    while (i < j)
    {
      Mode localMode = arrayOfMode[i];
      if (paramInt == localMode.getIntValue()) {
        return localMode;
      }
      i += 1;
    }
    return getDefault();
  }
  
  int getIntValue()
  {
    return this.mIntValue;
  }
  
  boolean permitsPullToRefresh()
  {
    return (this != DISABLED) && (this != MANUAL_REFRESH_ONLY);
  }
  
  public boolean showFooterLoadingLayout()
  {
    return (this == PULL_FROM_END) || (this == BOTH);
  }
  
  public boolean showHeaderLoadingLayout()
  {
    return (this == PULL_FROM_START) || (this == BOTH) || (this == MANUAL_REFRESH_ONLY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode
 * JD-Core Version:    0.7.0.1
 */