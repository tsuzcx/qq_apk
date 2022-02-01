package cooperation.ilive.group;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;
import cooperation.ilive.share.IliveShareHelper;

public class IliveGroupTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private QQAppInterface a;
  private BaseActivity b;
  private View c;
  private String d;
  private QQBlurView e;
  private ThemeImageView f;
  private TextView g;
  private TextView h;
  private PatchedButton i;
  private boolean j = false;
  private int k;
  private URLDrawable l;
  private BaseChatPie m;
  private IliveGroupTipsEntity n;
  
  public IliveGroupTipsBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.m = paramBaseChatPie;
    this.a = paramQQAppInterface;
    this.b = paramBaseActivity;
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals((String)this.f.getTag())))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      int i1 = this.k;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      i1 = this.k;
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(i1, i1, 6));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.e);
      this.f.setImageDrawable((Drawable)localObject);
      this.f.setTag(paramString);
      paramString = this.l;
      if (paramString != null) {
        paramString.setDecodeHandler(null);
      }
      this.l = ((URLDrawable)localObject);
    }
  }
  
  private void c(String paramString)
  {
    this.g.setText(paramString);
    this.g.setContentDescription(paramString);
    this.c.setContentDescription(paramString);
  }
  
  private void d()
  {
    this.c.setBackgroundResource(2130837937);
    f();
    this.f = ((ThemeImageView)this.c.findViewById(2131447680));
    this.g = ((TextView)this.c.findViewById(2131447683));
    this.i = ((PatchedButton)this.c.findViewById(2131447681));
    this.h = ((TextView)this.c.findViewById(2131447682));
    this.f.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    this.i.setOnClickListener(this);
    this.k = AIOUtils.b(39.0F, this.c.getResources());
  }
  
  private void d(String paramString)
  {
    this.h.setText(paramString);
    this.h.setContentDescription(paramString);
  }
  
  @TargetApi(19)
  private void e()
  {
    if (this.j) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((QQBlurView)localObject).a(this.m.aZ);
      localObject = this.e;
      ((QQBlurView)localObject).b((View)localObject);
      this.e.b(0);
      this.e.a(8.0F);
      this.e.a(4);
      this.e.d();
      this.e.a();
      this.j = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.e)));
        QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void f()
  {
    this.e = ((QQBlurView)this.c.findViewById(2131439803));
    e();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.e)));
      QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c.findViewById(2131439721);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.c.getResources().getColor(2131167964));
      ((View)localObject).setVisibility(0);
      this.e.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.e)));
        QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
      }
      this.e = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.e.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.e)));
      QLog.d("IliveGroupTipsBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.c == null)
    {
      this.c = LayoutInflater.from(this.b).inflate(2131627274, null);
      this.c.setOnClickListener(this);
    }
    d();
    return this.c;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("bars onAIOEvent eventType = ");
    paramVarArgs.append(paramInt);
    QLog.i("IliveGroupTipsBar", 1, paramVarArgs.toString());
  }
  
  public void a(IliveGroupTipsEntity paramIliveGroupTipsEntity)
  {
    if (paramIliveGroupTipsEntity == null) {
      return;
    }
    this.n = paramIliveGroupTipsEntity;
    b(paramIliveGroupTipsEntity.c);
    c(paramIliveGroupTipsEntity.b);
    d(paramIliveGroupTipsEntity.d);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public int b()
  {
    return 29;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.n;
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((IliveGroupTipsEntity)localObject1).e;
    }
    Object localObject2;
    if ((this.b != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      IliveShareHelper.reportAction("qq_live", "live_group_page", "live_group", "group_bar", "4", 102, IliveShareHelper.getFollowInfo("", "", "", "", ""));
      if (URLUtil.isNetworkUrl((String)localObject1))
      {
        localObject2 = new Intent(this.b, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
        ((Intent)localObject2).addFlags(268435456);
        this.b.startActivity((Intent)localObject2);
      }
      else
      {
        localObject1 = JumpParser.a(this.a, this.b, (String)localObject1);
        if (localObject1 != null) {
          ((JumpAction)localObject1).a();
        } else if (QLog.isColorLevel()) {
          QLog.d("IliveGroupTipsBar", 2, "onEditorAction jumpUrl is illegal");
        }
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ilvie group bar click null , url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("IliveGroupTipsBar", 1, ((StringBuilder)localObject2).toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBar
 * JD-Core Version:    0.7.0.1
 */