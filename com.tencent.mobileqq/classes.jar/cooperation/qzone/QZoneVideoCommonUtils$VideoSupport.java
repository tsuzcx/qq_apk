package cooperation.qzone;

import com.tencent.mobileqq.app.HardCodeUtil;

public class QZoneVideoCommonUtils$VideoSupport
{
  public static final VideoSupport Available = new VideoSupport(true, HardCodeUtil.a(2131910053), false, false);
  public static final VideoSupport BlackListBanned;
  public static final VideoSupport CodecFeatureBanned = new VideoSupport(false, HardCodeUtil.a(2131910002), false, true);
  public static final VideoSupport ExternalSpaceBanned;
  public static final VideoSupport HardwareLimited;
  public static final VideoSupport LoadSoFail = new VideoSupport(false, HardCodeUtil.a(2131910085), true, true);
  public static final VideoSupport NoExternalBanned;
  public static final VideoSupport OSVersionBanned;
  public static final VideoSupport OrderSetBanned = new VideoSupport(false, "CPU指令集不支持", false, true);
  private boolean mAvailable;
  private boolean mGoLocal;
  private boolean mShowTip;
  private String mTip;
  
  static
  {
    BlackListBanned = new VideoSupport(false, HardCodeUtil.a(2131910038), false, true);
    HardwareLimited = new VideoSupport(false, HardCodeUtil.a(2131910016), false, true);
    OSVersionBanned = new VideoSupport(false, HardCodeUtil.a(2131910023), false, true);
    NoExternalBanned = new VideoSupport(false, HardCodeUtil.a(2131910027), true, true);
    ExternalSpaceBanned = new VideoSupport(false, HardCodeUtil.a(2131910037), true, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoCommonUtils.VideoSupport
 * JD-Core Version:    0.7.0.1
 */