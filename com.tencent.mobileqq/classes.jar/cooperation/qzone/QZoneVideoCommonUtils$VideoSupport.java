package cooperation.qzone;

import amtj;

public class QZoneVideoCommonUtils$VideoSupport
{
  public static final VideoSupport Available = new VideoSupport(true, amtj.a(2131711626), false, false);
  public static final VideoSupport BlackListBanned;
  public static final VideoSupport CodecFeatureBanned = new VideoSupport(false, amtj.a(2131711570), false, true);
  public static final VideoSupport ExternalSpaceBanned;
  public static final VideoSupport HardwareLimited;
  public static final VideoSupport LoadSoFail = new VideoSupport(false, amtj.a(2131711659), true, true);
  public static final VideoSupport NoExternalBanned;
  public static final VideoSupport OSVersionBanned;
  public static final VideoSupport OrderSetBanned = new VideoSupport(false, "CPU指令集不支持", false, true);
  private boolean mAvailable;
  private boolean mGoLocal;
  private boolean mShowTip;
  private String mTip;
  
  static
  {
    BlackListBanned = new VideoSupport(false, amtj.a(2131711610), false, true);
    HardwareLimited = new VideoSupport(false, amtj.a(2131711585), false, true);
    OSVersionBanned = new VideoSupport(false, amtj.a(2131711593), false, true);
    NoExternalBanned = new VideoSupport(false, amtj.a(2131711597), true, true);
    ExternalSpaceBanned = new VideoSupport(false, amtj.a(2131711609), true, true);
  }
  
  QZoneVideoCommonUtils$VideoSupport(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mAvailable = paramBoolean1;
    this.mTip = paramString;
    this.mShowTip = paramBoolean2;
    this.mGoLocal = paramBoolean3;
  }
  
  public String getTip()
  {
    return this.mTip;
  }
  
  public boolean isAvailable()
  {
    return this.mAvailable;
  }
  
  public boolean isGoLocal()
  {
    return this.mGoLocal;
  }
  
  public boolean isShowTip()
  {
    return this.mShowTip;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoCommonUtils.VideoSupport
 * JD-Core Version:    0.7.0.1
 */