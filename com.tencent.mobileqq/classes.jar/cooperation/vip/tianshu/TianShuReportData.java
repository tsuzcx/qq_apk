package cooperation.vip.tianshu;

public class TianShuReportData
{
  public int mActionAttr = -1;
  public int mActionId = -1;
  public int mActionValue = -1;
  public String mAppId = "";
  public String mBusiInfo = "";
  public String mItemId = "";
  public String mItemType = "";
  public String mModuleId = "";
  public long mOperTime = -1L;
  public String mPageId = "";
  public String mPositionId = "";
  public int mRuleId = -1;
  public String mSubItemId = "";
  public String mSubModuleId = "";
  public int mTestId = -1;
  public String mToUid = "";
  public String mTraceDetail = "";
  public String mTraceId = "";
  public String mTraceIndex = "";
  public int mTraceNum = -1;
  public String mTriggerInfo = "";
  
  public TianShuReportData() {}
  
  public TianShuReportData(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4)
  {
    this.mTraceId = paramString1;
    this.mTraceNum = paramInt1;
    this.mActionId = paramInt2;
    this.mActionValue = paramInt3;
    this.mAppId = paramString2;
    this.mModuleId = paramString3;
    this.mItemId = paramString4;
    this.mSubItemId = paramString5;
    this.mOperTime = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuReportData
 * JD-Core Version:    0.7.0.1
 */