import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ocq
  implements quh
{
  private WeakReference<ReadInJoyArticleBottomVideoView> a;
  
  public ocq(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView)
  {
    this.a = new WeakReference(paramReadInJoyArticleBottomVideoView);
  }
  
  public List<qui> a(int paramInt, boolean paramBoolean)
  {
    ReadInJoyArticleBottomVideoView localReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)this.a.get();
    ArrayList localArrayList = new ArrayList();
    if (localReadInJoyArticleBottomVideoView != null) {
      localArrayList.add(new qui(ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView).d, "", 5, (int)ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView).a));
    }
    return localArrayList;
  }
  
  public boolean a()
  {
    ReadInJoyArticleBottomVideoView localReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (localReadInJoyArticleBottomVideoView == null) {
      return false;
    }
    return bbfj.h(ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocq
 * JD-Core Version:    0.7.0.1
 */