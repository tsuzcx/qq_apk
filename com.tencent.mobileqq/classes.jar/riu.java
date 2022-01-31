import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.image.AbstractGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class riu
  implements bfos
{
  public riu(FastWebActivity paramFastWebActivity) {}
  
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
    FastWebActivity.a(this.a, 0);
    if ((paramAbsListView.getChildAt(0).getTop() == 0) && (paramInt1 == 0))
    {
      QLog.d(FastWebActivity.a(this.a), 2, "on scroller top");
      FastWebActivity.a(this.a, 1);
    }
    if (paramInt2 + paramInt1 == paramInt3)
    {
      QLog.d(FastWebActivity.a(this.a), 2, "on scroller bottom");
      FastWebActivity.a(this.a, 2);
    }
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
      FastWebActivity.e(this.a);
      FastWebActivity.b(this.a, i);
      zzz.a().a(str, false);
      label70:
      boolean bool2 = FastWebActivity.b(this.a, FastWebActivity.a(this.a).getFirstVisiblePosition());
      rno.a(paramAbsListView, paramInt, FastWebActivity.a(this.a).innerUniqueID, FastWebActivity.a(this.a, paramAbsListView, paramInt), bool2);
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      }
      FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      FastWebActivity.f(this.a);
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
      }
      if (paramInt == 1) {
        FastWebActivity.e(this.a);
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
      zzz.a().a(str);
      break label70;
      label324:
      FastWebActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     riu
 * JD-Core Version:    0.7.0.1
 */