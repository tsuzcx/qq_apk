package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleReporterAgent
{
  private static final String TAG = "QCircleReporterAgent";
  private List<FeedCloudCommon.BytesEntry> mExtraSessionEntryList;
  private int mScene;
  
  private QCircleReporterAgent(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  private FeedCloudCommon.StCommonExt buildSessionCommonExt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte1 != null) {
      localArrayList.add(newEntry("SessionID", paramArrayOfByte1));
    }
    if (paramArrayOfByte2 != null) {
      localArrayList.add(newEntry("SubSessionID", paramArrayOfByte2));
    }
    paramArrayOfByte1 = this.mExtraSessionEntryList;
    if (paramArrayOfByte1 != null) {
      localArrayList.addAll(paramArrayOfByte1);
    }
    if (localArrayList.size() > 0)
    {
      localStCommonExt.mapBytesInfo.set(localArrayList);
      QLog.d("QCircleReporterAgent", 2, "buildSessionCommonExt() valid session and subsession!scene:" + this.mScene);
      return localStCommonExt;
    }
    QLog.e("QCircleReporterAgent", 2, "buildSessionCommonExt() no session and subsession!scene:" + this.mScene);
    return localStCommonExt;
  }
  
  private FeedCloudCommon.BytesEntry newEntry(String paramString, byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    localBytesEntry.key.set(paramString);
    localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return localBytesEntry;
  }
  
  public static QCircleReporterAgent obtain(int paramInt)
  {
    return new QCircleReporterAgent(paramInt);
  }
  
  private void updateSubSession(byte[] paramArrayOfByte)
  {
    QCircleReportHelper.getInstance().updateSubSession(this.mScene, paramArrayOfByte);
  }
  
  public void addExtraSessionEntry(FeedCloudCommon.BytesEntry paramBytesEntry)
  {
    if (paramBytesEntry != null)
    {
      if (this.mExtraSessionEntryList == null) {
        this.mExtraSessionEntryList = new ArrayList();
      }
      this.mExtraSessionEntryList.add(paramBytesEntry);
    }
  }
  
  public FeedCloudCommon.StCommonExt getSessionCommonExt(boolean paramBoolean)
  {
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = QCircleReportHelper.getInstance().getSession();
    if (!paramBoolean) {
      arrayOfByte1 = QCircleReportHelper.getInstance().getSubSession(this.mScene);
    }
    return buildSessionCommonExt(arrayOfByte2, arrayOfByte1);
  }
  
  public void removeExtraSessionEntry(String paramString)
  {
    ArrayList localArrayList;
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (this.mExtraSessionEntryList != null))
    {
      localArrayList = new ArrayList(this.mExtraSessionEntryList);
      i = localArrayList.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)localArrayList.get(i);
        if ((localBytesEntry != null) && (TextUtils.equals(localBytesEntry.key.get(), paramString)))
        {
          localArrayList.remove(i);
          this.mExtraSessionEntryList = localArrayList;
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  public void updateSubSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    QLog.d("QCircleReporterAgent", 1, "updateSubSession,scene:" + this.mScene);
    int i;
    if ((paramStCommonExt != null) && (paramStCommonExt.has()) && (paramStCommonExt.mapBytesInfo.has()))
    {
      paramStCommonExt = paramStCommonExt.mapBytesInfo.get().iterator();
      while (paramStCommonExt.hasNext())
      {
        FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)paramStCommonExt.next();
        if ((localBytesEntry != null) && ("SubSessionID".equals(localBytesEntry.key.get())))
        {
          paramStCommonExt = localBytesEntry.value.get().toByteArray();
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (paramStCommonExt != null) {
        updateSubSession(paramStCommonExt);
      }
      if (i != 0)
      {
        QLog.d("QCircleReporterAgent", 1, "find subsession!");
        return;
      }
      QLog.e("QCircleReporterAgent", 1, "can't find subsession!");
      return;
      i = 0;
      paramStCommonExt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporterAgent
 * JD-Core Version:    0.7.0.1
 */