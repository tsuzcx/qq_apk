import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController.QQStoryMainView;

public class nyc
  implements QQStoryMainController.QQStoryMainView
{
  public nyc(QQStoryMainActivity paramQQStoryMainActivity) {}
  
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
      QQStoryMainActivity.a(this.a, "小视频", "轻触回顶部");
      return;
    }
    a("小视频");
  }
  
  public void c() {}
  
  public void d()
  {
    QQStoryMainActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyc
 * JD-Core Version:    0.7.0.1
 */