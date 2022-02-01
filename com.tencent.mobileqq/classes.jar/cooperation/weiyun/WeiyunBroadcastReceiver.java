package cooperation.weiyun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import atcv;
import atcz;
import atvo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class WeiyunBroadcastReceiver
  extends BroadcastReceiver
{
  public void a(Context paramContext, WeiYunFileInfo paramWeiYunFileInfo, FileManagerEntity paramFileManagerEntity)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.d(paramFileManagerEntity.getCloudType());
    localForwardFileInfo.b(10001);
    localForwardFileInfo.b(paramFileManagerEntity.nSessionId);
    localForwardFileInfo.d(paramWeiYunFileInfo.c);
    localForwardFileInfo.c(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    localForwardFileInfo.c(2);
    localForwardFileInfo.d(paramWeiYunFileInfo.jdField_a_of_type_Long);
    localForwardFileInfo.a(paramWeiYunFileInfo);
    localForwardFileInfo.a(paramFileManagerEntity.getFilePath());
    localForwardFileInfo.c(paramFileManagerEntity.uniseq);
    localForwardFileInfo.b(paramFileManagerEntity.Uuid);
    paramWeiYunFileInfo = new Intent(paramContext, FileBrowserActivity.class);
    paramWeiYunFileInfo.addFlags(268435456);
    paramWeiYunFileInfo.putExtra("fileinfo", localForwardFileInfo);
    paramContext.startActivity(paramWeiYunFileInfo);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getExtras();
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramIntent != null)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayList("fileinfos");
        paramContext = null;
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          paramContext = atvo.a((WeiYunFileInfo)localIterator.next());
          paramContext.nOpType = 5;
          localQQAppInterface.a().a(paramContext);
          localQQAppInterface.a().b(paramContext);
        }
        if (localArrayList.size() == 1)
        {
          a(localQQAppInterface.getApp(), (WeiYunFileInfo)localArrayList.get(0), paramContext);
          return;
        }
        paramContext = new Intent(localQQAppInterface.getApp(), FMActivity.class);
        paramContext.putExtra("tab_tab_type", 7);
        paramContext.addFlags(268435456);
        new Bundle().putLong("category", 13L);
        paramContext.putExtra("bundle", paramIntent);
        localQQAppInterface.getApp().startActivity(paramContext);
        return;
      }
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.WeiyunBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */