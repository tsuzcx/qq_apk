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
import java.util.Collection;
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
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("buildSessionCommonExt() valid session and subsession!scene:");
      paramArrayOfByte1.append(this.mScene);
      QLog.d("QCircleReporterAgent", 2, paramArrayOfByte1.toString());
      return localStCommonExt;
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("buildSessionCommonExt() no session and subsession!scene:");
    paramArrayOfByte1.append(this.mScene);
    QLog.e("QCircleReporterAgent", 2, paramArrayOfByte1.toString());
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
    byte[] arrayOfByte2 = QCircleReportHelper.getInstance().getSession();
    byte[] arrayOfByte1;
    if (!paramBoolean) {
      arrayOfByte1 = QCircleReportHelper.getInstance().getSubSession(this.mScene);
    } else {
      arrayOfByte1 = null;
    }
    return buildSessionCommonExt(arrayOfByte2, arrayOfByte1);
  }
  
  public void removeExtraSessionEntry(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.mExtraSessionEntryList;
      if (localObject != null)
      {
        localObject = new ArrayList((Collection)localObject);
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)((List)localObject).get(i);
          if ((localBytesEntry != null) && (TextUtils.equals(localBytesEntry.key.get(), paramString)))
          {
            ((List)localObject).remove(i);
            this.mExtraSessionEntryList = ((List)localObject);
            return;
          }
          i -= 1;
        }
      }
    }
  }
  
  public void updateSubSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSubSession,scene:");
    localStringBuilder.append(this.mScene);
    QLog.d("QCircleReporterAgent", 1, localStringBuilder.toString());
    if ((paramStCommonExt != null) && (paramStCommonExt.has()) && (paramStCommonExt.mapBytesInfo.has()))
    {
      localStringBuilder = null;
      int j = 0;
      Iterator localIterator = paramStCommonExt.mapBytesInfo.get().iterator();
      do
      {
        paramStCommonExt = localStringBuilder;
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        paramStCommonExt = (FeedCloudCommon.BytesEntry)localIterator.next();
      } while ((paramStCommonExt == null) || (!"SubSessionID".equals(paramStCommonExt.key.get())));
      paramStCommonExt = paramStCommonExt.value.get().toByteArray();
      int i = 1;
      if (paramStCommonExt != null) {
        updateSubSession(paramStCommonExt);
      }
      if (i != 0)
      {
        QLog.d("QCircleReporterAgent", 1, "find subsession!");
        return;
      }
      QLog.e("QCircleReporterAgent", 1, "can't find subsession!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporterAgent
 * JD-Core Version:    0.7.0.1
 */