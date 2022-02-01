package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.widget.Toast;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class RMVideoStateMgr$1
  implements Runnable
{
  RMVideoStateMgr$1(RMVideoStateMgr paramRMVideoStateMgr, String paramString) {}
  
  public void run()
  {
    Toast.makeText(VideoEnvironment.getContext(), "" + this.a, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.1
 * JD-Core Version:    0.7.0.1
 */