import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.image.AbstractGifImage;
import com.tencent.widget.AbsListView;

public class qwi
  implements begh
{
  public qwi(FastWebActivity paramFastWebActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FastWebActivity.a(this.a) != null)
    {
      FastWebActivity.a(this.a).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      FastWebActivity.a(this.a).a(this.a.app, paramAbsListView, paramInt1, paramInt2);
    }
    FastWebActivity.a(this.a).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).a(FastWebActivity.a(this.a), FastWebActivity.a(this.a).getFirstVisiblePosition(), paramInt2);
    }
    FastWebActivity.a(this.a, paramAbsListView, paramInt1 + paramInt2 - 1, false);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool1 = FastWebActivity.a(this.a, FastWebActivity.a(this.a).getLastVisiblePosition());
    String str;
    if (bool1)
    {
      str = "list_comment_kandian";
      if (paramInt != 0) {
        break label310;
      }
      AbstractGifImage.resumeAll();
      int i = FastWebActivity.a(this.a).getFirstVisiblePosition();
      FastWebActivity.d(this.a);
      FastWebActivity.b(this.a, i);
      zqk.a().a(str, false);
      label70:
      boolean bool2 = FastWebActivity.b(this.a, FastWebActivity.a(this.a).getFirstVisiblePosition());
      raz.a(paramAbsListView, paramInt, FastWebActivity.a(this.a).innerUniqueID, FastWebActivity.a(this.a, paramAbsListView, paramInt), bool2);
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      }
      FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      FastWebActivity.e(this.a);
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      }
      if (paramInt == 1) {
        FastWebActivity.d(this.a);
      }
      if (!bool1) {
        break label324;
      }
      FastWebActivity.a(this.a).a();
      if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).a() != null)) {
        FastWebActivity.a(this.a).a().a(FastWebActivity.a(this.a).getFirstVisiblePosition() - FastWebActivity.a(this.a).getCount(), FastWebActivity.a(this.a).getLastVisiblePosition() - FastWebActivity.a(this.a).getCount());
      }
    }
    for (;;)
    {
      this.a.a(paramAbsListView, paramInt);
      return;
      str = "list_kandian_native_web";
      break;
      label310:
      AbstractGifImage.pauseAll();
      zqk.a().a(str);
      break label70;
      label324:
      FastWebActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwi
 * JD-Core Version:    0.7.0.1
 */