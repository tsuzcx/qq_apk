import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController.QQStoryMainView;

public class nrz
  implements QQStoryMainController.QQStoryMainView
{
  public nrz(QQStoryMainActivity paramQQStoryMainActivity) {}
  
  public View a()
  {
    return QQStoryMainActivity.a(this.a);
  }
  
  public ImageView a()
  {
    return this.a.rightViewImg;
  }
  
  public TextView a()
  {
    return this.a.rightViewText;
  }
  
  public void a()
  {
    this.a.onBackEvent();
  }
  
  public void a(String paramString)
  {
    QQStoryMainActivity.a(this.a, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.startTitleProgress();
      return;
    }
    this.a.stopTitleProgress();
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQStoryMainActivity.a(this.a, "日迹", "轻触回顶部");
      return;
    }
    a("日迹");
  }
  
  public void c() {}
  
  public void d()
  {
    QQStoryMainActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrz
 * JD-Core Version:    0.7.0.1
 */