import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.image.AbstractGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class ryp
  implements bhtv
{
  public ryp(FastWebActivity paramFastWebActivity) {}
  
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
    paramAbsListView = paramAbsListView.getChildAt(0);
    if ((paramAbsListView != null) && (FastWebActivity.c(this.a) != paramAbsListView.getTop()))
    {
      FastWebActivity.b(this.a, paramAbsListView.getTop());
      FastWebActivity.c(this.a, 0);
    }
    if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0) && (paramInt1 == 0))
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
    String str1;
    String str2;
    if (bool1)
    {
      str1 = "list_comment_kandian";
      str2 = str1;
      if (pwu.a().a())
      {
        str2 = str1;
        if (TextUtils.equals(str1, "list_kandian_native_web")) {
          str2 = "list_kandian_native_web_lite";
        }
      }
      if (paramInt != 0) {
        break label341;
      }
      AbstractGifImage.resumeAll();
      int i = FastWebActivity.a(this.a).getFirstVisiblePosition();
      FastWebActivity.e(this.a);
      FastWebActivity.a(this.a, i);
      abvl.a().a(str2, false);
      label101:
      boolean bool2 = FastWebActivity.b(this.a, FastWebActivity.a(this.a).getFirstVisiblePosition());
      sdn.a(paramAbsListView, paramInt, FastWebActivity.a(this.a).innerUniqueID, FastWebActivity.a(this.a, paramAbsListView, paramInt), bool2);
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
        break label355;
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
      str1 = "list_kandian_native_web";
      break;
      label341:
      AbstractGifImage.pauseAll();
      abvl.a().a(str2);
      break label101;
      label355:
      FastWebActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryp
 * JD-Core Version:    0.7.0.1
 */