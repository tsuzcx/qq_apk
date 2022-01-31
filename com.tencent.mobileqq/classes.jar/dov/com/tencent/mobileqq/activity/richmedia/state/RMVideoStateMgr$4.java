package dov.com.tencent.mobileqq.activity.richmedia.state;

import bnqj;

final class RMVideoStateMgr$4
  implements Runnable
{
  RMVideoStateMgr$4(String paramString) {}
  
  public void run()
  {
    String str = bnqj.a();
    if ((str != null) && (!"".equals(str)) && (str.contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      RMVideoStateMgr.a(str, this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.4
 * JD-Core Version:    0.7.0.1
 */