import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class oct
  implements quk
{
  private WeakReference<ReadInJoyArticleBottomVideoView> a;
  
  public oct(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView)
  {
    this.a = new WeakReference(paramReadInJoyArticleBottomVideoView);
  }
  
  public List<qul> a(int paramInt, boolean paramBoolean)
  {
    ReadInJoyArticleBottomVideoView localReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)this.a.get();
    ArrayList localArrayList = new ArrayList();
    if (localReadInJoyArticleBottomVideoView != null) {
      localArrayList.add(new qul(ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView).d, "", 5, (int)ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView).a));
    }
    return localArrayList;
  }
  
  public boolean a()
  {
    ReadInJoyArticleBottomVideoView localReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (localReadInJoyArticleBottomVideoView == null) {
      return false;
    }
    return bbev.h(ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oct
 * JD-Core Version:    0.7.0.1
 */