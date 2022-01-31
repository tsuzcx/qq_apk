package mqq.app;

import android.widget.Toast;

class MainService$MyErrorHandler$2$1
  implements Runnable
{
  MainService$MyErrorHandler$2$1(MainService.MyErrorHandler.2 param2) {}
  
  public void run()
  {
    Toast.makeText(MainService.access$000(this.this$2.this$1.this$0), "[mqq]" + this.this$2.val$reason + "\n" + this.this$2.val$title + "\n" + this.this$2.val$msg, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler.2.1
 * JD-Core Version:    0.7.0.1
 */