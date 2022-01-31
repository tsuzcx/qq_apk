import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class tfw
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, vqp paramvqp, float paramFloat)
  {
    if (paramInt == ((Integer)paramvqp.a().getTag(2131307669)).intValue())
    {
      syk.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramvqp.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(vqr paramvqr, vqq paramvqq, FrameLayout paramFrameLayout, vqf paramvqf, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      urk.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    urk.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      urk.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramvqf.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramvqf.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramvqr, paramvqq, paramFrameLayout, paramvqf, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(vqr paramvqr, vqq paramvqq, vqf paramvqf, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      urk.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramvqf instanceof vqp)) {
      return;
    }
    b(paramvqr, paramvqq, paramvqf, paramStoryVideoItem);
  }
  
  public static void b(vqr paramvqr, vqq paramvqq, FrameLayout paramFrameLayout, vqf paramvqf, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    urk.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramvqr, paramvqq, paramFrameLayout, paramvqf, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(vqr paramvqr, vqq paramvqq, FrameLayout paramFrameLayout, vqf paramvqf, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    srp localsrp = paramStoryVideoItem.getInteractLayout();
    if (localsrp == null) {
      urk.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
    }
    View localView;
    int i;
    int j;
    int k;
    int m;
    float f1;
    float f2;
    float f3;
    do
    {
      return;
      urk.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramvqf.a();
      localView.setTag(2131307669, Integer.valueOf(paramInt));
      i = localsrp.b;
      j = localsrp.c;
      k = localsrp.d;
      m = localsrp.e;
      f1 = localsrp.f;
      f2 = localsrp.g;
      f3 = localsrp.h;
      String[] arrayOfString = localsrp.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        urk.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      urk.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramvqf.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramvqr, paramvqq, paramFrameLayout, paramvqf, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramvqf.a(localsrp.b, localsrp.c, paramInt, n, localsrp.d, localsrp.e, localsrp.f, localsrp.g, localsrp.h);
    paramvqf.a();
    a(paramvqr, paramvqq, paramvqf, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    urk.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    urk.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(vqr paramvqr, vqq paramvqq, vqf paramvqf, StoryVideoItem paramStoryVideoItem)
  {
    urk.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramvqf instanceof vqp)) {
      return;
    }
    paramvqf = (vqp)paramvqf;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramvqf.b(false);
      paramvqf.a(paramStoryVideoItem.mRateResult);
      paramvqf.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramvqf.a(true);
        paramvqf.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramvqf.a(paramvqq, true);
          return;
        }
        paramvqf.a(null, false);
        return;
      }
      paramvqf.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramvqf.b(false);
      paramvqf.a(0.0F);
      paramvqf.a(null);
      paramvqf.a(false);
      return;
    }
    paramvqf.b(true);
    paramvqf.a(0.0F);
    paramvqf.a(paramvqr);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramvqf.a(true);
      paramvqf.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramvqf.a(paramvqq, true);
      return;
    }
    paramvqf.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfw
 * JD-Core Version:    0.7.0.1
 */