package cooperation.qzone.api;

import akab;
import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface QzoneFragmentImpl
{
  public abstract void attachQQContext(Activity paramActivity, QQAppInterface paramQQAppInterface);
  
  public abstract void clearCache();
  
  public abstract void forceRefresh();
  
  public abstract void onSwitchOutofQzone();
  
  public abstract void resetReportFlag();
  
  public abstract void setQzoneSwitchlistener(akab paramakab);
  
  public abstract void setRightButtonType(int paramInt);
  
  public abstract int setTitleAlphaAndGetLastValue(int paramInt);
  
  public abstract void setTitleView(ViewGroup paramViewGroup);
  
  public abstract void updatePublishBox(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.QzoneFragmentImpl
 * JD-Core Version:    0.7.0.1
 */