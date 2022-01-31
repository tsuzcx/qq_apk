package dov.com.tencent.biz.qqstory.takevideo;

import ajya;
import android.os.Build.VERSION;
import bcql;

class EditVideoActivity$2$1
  implements Runnable
{
  EditVideoActivity$2$1(EditVideoActivity.2 param2) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.a.this$0.isDestroyed())) || (this.a.this$0.isFinishing())) {
      return;
    }
    bcql.a(this.a.this$0, ajya.a(2131703765), 0).a();
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity.2.1
 * JD-Core Version:    0.7.0.1
 */