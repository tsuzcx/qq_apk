import android.os.AsyncTask;
import android.text.TextUtils;
import com.dataline.core.DirectForwarder;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.List;

public class cr
  extends AsyncTask
{
  public cr(DirectForwarder paramDirectForwarder, ArrayList paramArrayList, int paramInt) {}
  
  DataLineMsgRecord a(DataLineHandler paramDataLineHandler, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      switch (FileManagerUtil.a(paramString))
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msgtype = DataLineHandler.c(i);
      localDataLineMsgRecord.sessionid = paramDataLineHandler.a(0, this.jdField_a_of_type_Int).longValue();
      localDataLineMsgRecord.path = paramString;
      localDataLineMsgRecord.thumbPath = null;
      localDataLineMsgRecord.groupId = paramInt2;
      localDataLineMsgRecord.groupSize = paramInt3;
      localDataLineMsgRecord.groupIndex = paramInt4;
      return localDataLineMsgRecord;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  protected String a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    a(this.jdField_a_of_type_JavaUtilArrayList, i);
    return null;
  }
  
  void a(List paramList, int paramInt)
  {
    if (paramList == null) {}
    DataLineHandler localDataLineHandler;
    int j;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComDatalineCoreDirectForwarder.a.a(8);
      j = paramList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject = a(localDataLineHandler, (String)paramList.get(i), paramInt, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label117:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((j > 3) && (j < 50))
    {
      localObject = new ArrayList();
      int k = localDataLineHandler.a();
      i = 0;
      if (i < j)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramInt, k, j, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label408;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label259:
    label405:
    label408:
    for (;;)
    {
      i += 1;
      break label117;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      j = localDataLineHandler.a();
      i = 0;
      if (i < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramInt, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label405;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label259;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cr
 * JD-Core Version:    0.7.0.1
 */