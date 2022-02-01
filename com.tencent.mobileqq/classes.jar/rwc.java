import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rwc
  implements ots
{
  rwc(rwa paramrwa) {}
  
  public void a()
  {
    if (rwa.a(this.a) != null) {
      rwa.a(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    rwa.a(this.a).e = paramInt;
    rwa.a(this.a).b(rwa.a(this.a));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      rwa.a(this.a).e();
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwc
 * JD-Core Version:    0.7.0.1
 */