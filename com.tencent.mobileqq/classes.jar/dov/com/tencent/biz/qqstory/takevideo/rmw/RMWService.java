package dov.com.tencent.biz.qqstory.takevideo.rmw;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.support.annotation.Nullable;
import annf;
import anng;

public class RMWService
  extends Service
{
  private static RMWService jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwRMWService;
  private Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new annf(this));
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    RMWLog.b("RMWService", "ON-BIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    RMWLog.b("RMWService", "ON-CREATE : " + System.identityHashCode(this));
    jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwRMWService = this;
    new anng(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RMWLog.b("RMWService", "ON-DESTROY : " + System.identityHashCode(this));
    jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwRMWService = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    RMWLog.a("RMWService", "onStartCommand : " + paramIntent);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    RMWLog.b("RMWService", "ON-UNBIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.rmw.RMWService
 * JD-Core Version:    0.7.0.1
 */