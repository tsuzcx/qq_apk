package cooperation.vip.ad;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class TianshuBigInsertPage
{
  private View a;
  private View b;
  private DragFrameLayout c;
  private ImageView d;
  private final Conversation e;
  private TianShuAccess.AdItem f;
  
  public TianshuBigInsertPage(Conversation paramConversation)
  {
    this.e = paramConversation;
    a();
  }
  
  private void a()
  {
    this.c = ((DragFrameLayout)this.e.P().findViewById(2131431325));
    this.a = this.e.P().getLayoutInflater().inflate(2131624140, this.c, false);
    this.b = this.a.findViewById(2131447331);
    this.a.findViewById(2131447326).setBackgroundColor(this.e.Q().getColor(2131165803));
    this.d = ((ImageView)this.a.findViewById(2131447327));
    this.a.setOnTouchListener(new TianshuBigInsertPage.1(this));
    ((ImageView)this.a.findViewById(2131447328)).setOnClickListener(new TianshuBigInsertPage.2(this));
  }
  
  private void b()
  {
    ViewUtils.removeViewFromParent(this.a);
  }
  
  private static void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null)
    {
      QLog.e("TianshuBigInsertPage", 2, "showLayer with null ");
      return;
    }
    this.f = paramAdItem;
    Object localObject = this.f.argList.get().iterator();
    String str = null;
    paramAdItem = null;
    while (((Iterator)localObject).hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
      if (localMapEntry.key.get().equals("image")) {
        str = localMapEntry.value.get();
      } else if (localMapEntry.key.get().equals("url")) {
        paramAdItem = localMapEntry.value.get();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showHongbaoLayer | imgUrl is: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" actionUrl: ");
      ((StringBuilder)localObject).append(paramAdItem);
      QLog.d("TianshuBigInsertPage", 2, ((StringBuilder)localObject).toString());
    }
    this.d.setOnClickListener(new TianshuBigInsertPage.3(this, paramAdItem));
    PreloadStaticApi.a().getResPath(str, new TianshuBigInsertPage.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage
 * JD-Core Version:    0.7.0.1
 */