package cooperation.qlink;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QlinkAgentActivity
  extends BaseActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (10 == paramInt2) {
      setResult(10, paramIntent);
    }
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4)) {
      this.app.getQQProxyForQlink().a(new QlAndQQInterface.DailogClickInfo(8));
    } else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.onCreate(paramBundle);
    setTitle(null);
    if (1 == getIntent().getIntExtra("what", 0))
    {
      long l = getIntent().getLongExtra("param.sessionid", 0L);
      if (0L != l)
      {
        if (this.app == null)
        {
          super.finish();
          return;
        }
        paramBundle = this.app.getFileManagerDataCenter();
        if (paramBundle == null)
        {
          super.finish();
          return;
        }
        Object localObject = paramBundle.a(l);
        if (localObject != null)
        {
          paramBundle = new ForwardFileInfo();
          paramBundle.d(((FileManagerEntity)localObject).getCloudType());
          paramBundle.b(10010);
          paramBundle.b(((FileManagerEntity)localObject).nSessionId);
          paramBundle.c(((FileManagerEntity)localObject).uniseq);
          paramBundle.d(((FileManagerEntity)localObject).fileName);
          paramBundle.d(((FileManagerEntity)localObject).fileSize);
          paramBundle.b(((FileManagerEntity)localObject).Uuid);
          paramBundle.a(((FileManagerEntity)localObject).getFilePath());
          localObject = new Intent(getApplicationContext(), FileBrowserActivity.class);
          ((Intent)localObject).putExtra("fileinfo", paramBundle);
          ((Intent)localObject).putExtra("from_qlink_enter_recent", true);
          startActivityForResult((Intent)localObject, 102);
          return;
        }
      }
    }
    super.finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkAgentActivity
 * JD-Core Version:    0.7.0.1
 */