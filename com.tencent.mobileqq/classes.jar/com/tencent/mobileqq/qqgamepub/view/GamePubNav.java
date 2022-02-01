package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GamePubNav
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private LinearLayout f;
  private String g;
  private String h;
  private int i;
  private String j;
  
  public GamePubNav(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public GamePubNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public GamePubNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  private void a(String paramString)
  {
    if (this.i == 1)
    {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterGameCenter(paramString);
      return;
    }
    if (paramString.startsWith("mqqapi://miniapp/"))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), paramString, 2016, null);
      return;
    }
    Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    getContext().startActivity(localIntent);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.a.setText(paramString1);
    }
    this.f.setOnClickListener(new GamePubNav.1(this, paramString2, paramString3));
    ThreadManagerV2.getUIHandlerV2().post(new GamePubNav.2(this, paramString3));
  }
  
  private boolean a(String paramString, int paramInt)
  {
    int k = GamePubAccountHelper.h(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" currentExposeTime: ");
    localStringBuilder.append(k);
    localStringBuilder.append(" exposeTimes: ");
    localStringBuilder.append(paramInt);
    QLog.i("QQGamePub_GamePubNav", 1, localStringBuilder.toString());
    return k >= paramInt;
  }
  
  private void f()
  {
    LayoutInflater.from(getContext()).inflate(2131624899, this);
    this.a = ((TextView)findViewById(2131448487));
    this.b = ((TextView)findViewById(2131435469));
    this.c = ((ImageView)findViewById(2131435562));
    this.d = ((ImageView)findViewById(2131435598));
    this.e = ((ImageView)findViewById(2131435588));
    this.f = ((LinearLayout)findViewById(2131436925));
    this.f.setVisibility(8);
    e();
  }
  
  private void g() {}
  
  public void a(JSONObject paramJSONObject)
  {
    this.j = paramJSONObject.optString("expirement_id");
    String str1 = paramJSONObject.optString("seq");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("inner");
    String str2 = localJSONObject.optString("text");
    String str3 = localJSONObject.optString("jump_url");
    paramJSONObject = paramJSONObject.optString("notice_id");
    int k = localJSONObject.optInt("expose_times");
    a(true, localJSONObject.optString("icon"), paramJSONObject);
    if (a(str1, k))
    {
      QLog.i("QQGamePub_GamePubNav", 1, "<<<arrive expose times<<<");
      b();
      a(true, "", paramJSONObject);
      return;
    }
    a(str2, str3, paramJSONObject);
    GamePubAccountHelper.i(str1);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    int k = 0;
    try
    {
      if (!StringUtil.isEmpty(paramString1))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130847949);
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130847949);
        paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
        this.c.setImageDrawable(paramString1);
      }
      else
      {
        this.c.setImageDrawable(getResources().getDrawable(2130847949));
      }
      this.c.setVisibility(0);
      this.c.setOnClickListener(new GamePubNav.3(this, paramString2));
    }
    catch (Throwable paramString1)
    {
      QLog.e("QQGamePub_GamePubNav", 1, paramString1, new Object[0]);
    }
    paramString1 = this.b;
    if (!paramBoolean) {
      k = 4;
    }
    paramString1.setVisibility(k);
    if (!StringUtil.isEmpty(paramString2))
    {
      paramString2 = GamePubAccountHelper.d(GamePubAccountHelper.a()).h("770").i(this.j).d("77002").c("209089").a(2, paramString2);
      if (this.b.getVisibility() == 0) {
        paramString1 = "1";
      } else {
        paramString1 = "2";
      }
      paramString2.a(3, paramString1).a(4, "8").a(12, "160").a();
    }
  }
  
  public boolean a()
  {
    return this.f.getVisibility() == 0;
  }
  
  public void b()
  {
    this.f.setVisibility(8);
    g();
  }
  
  public void c()
  {
    g();
    this.f.animate().alpha(0.0F).setDuration(500L).setListener(new GamePubNav.4(this)).start();
  }
  
  public void d()
  {
    this.b.setVisibility(0);
  }
  
  public void e()
  {
    a(false, "", "");
  }
  
  public View getRightImg()
  {
    return this.c;
  }
  
  public void setBubbleJumpUrl(String paramString)
  {
    this.h = paramString;
  }
  
  public void setMoreClick(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setNoticeId(String paramString)
  {
    this.g = paramString;
  }
  
  public void setReturnClick(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void setUrlType(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GamePubNav
 * JD-Core Version:    0.7.0.1
 */