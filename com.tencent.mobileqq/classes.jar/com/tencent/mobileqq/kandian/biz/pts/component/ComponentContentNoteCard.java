package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyListItemLifeCycle;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.mobileqq.kandian.biz.notecard.SoundCheckRunnable;
import com.tencent.mobileqq.kandian.biz.notecard.SoundCheckRunnable.OnSoundActionListener;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentNoteCard
  extends RelativeLayout
  implements IReadInJoyListItemLifeCycle, SoundCheckRunnable.OnSoundActionListener, ComponentInheritView, AbsListView.OnScrollListener
{
  private RelativeLayout a = null;
  private TextView b = null;
  private TextView c = null;
  private TextView d = null;
  private ImageView e = null;
  private TextView f = null;
  private ImageView g = null;
  private ImageView h = null;
  private ImageView i = null;
  private ComponentNotIntrest j = null;
  private ReadInJoyXListView k = null;
  private ScripCmsInfo l;
  private LottieDrawable m = null;
  private Handler n = new Handler(Looper.getMainLooper());
  private SoundCheckRunnable o;
  private int p = 0;
  private boolean q = false;
  private Object r;
  private boolean s = false;
  
  public ComponentContentNoteCard(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentNoteCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentNoteCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ComponentContentNoteCard(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext);
    this.k = ((ReadInJoyXListView)paramReadInJoyBaseAdapter.d());
    b(paramContext);
  }
  
  private SpannableStringBuilder a(JSONArray paramJSONArray)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      Object localObject = new JSONObject(paramJSONArray.get(i1).toString());
      String str = ((JSONObject)localObject).optString("word", "    ");
      int i2 = Color.parseColor(((JSONObject)localObject).optString("color", "#C3C0D6"));
      int i3 = Integer.valueOf(((JSONObject)localObject).optString("size", "15")).intValue();
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(i2), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(i3, true), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
      i1 += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    return paramJSONObject.get(paramString).toString();
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    paramString = null;
    if (paramString != null) {
      paramImageView.setImageDrawable(paramString);
    }
  }
  
  private void a(TextView paramTextView, JSONObject paramJSONObject, float paramFloat)
  {
    if (paramTextView != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      localObject2 = new JSONArray();
      f1 = 20.0F;
    }
    try
    {
      localObject1 = paramJSONObject.getJSONArray("S");
      localObject2 = localObject1;
      str = a(paramJSONObject, "H");
    }
    catch (Exception paramJSONObject)
    {
      Object localObject1;
      String str;
      float f2;
      int i1;
      label124:
      break label137;
    }
    try
    {
      localObject2 = a(paramJSONObject, "V");
    }
    catch (Exception paramJSONObject)
    {
      break label130;
    }
    try
    {
      f2 = Float.valueOf(a(paramJSONObject, "O")).floatValue();
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject = (JSONObject)localObject2;
      break label150;
    }
    try
    {
      f3 = Float.valueOf(a(paramJSONObject, "E")).floatValue();
      f1 = f3;
      i1 = DisplayUtil.a(getContext(), f2);
      f2 = i1;
    }
    catch (Exception paramJSONObject)
    {
      break label124;
    }
    try
    {
      i1 = DisplayUtil.a(getContext(), f3);
      f1 = i1;
      paramJSONObject = (JSONObject)localObject2;
    }
    catch (Exception paramJSONObject)
    {
      f1 = f3;
      paramJSONObject = (JSONObject)localObject2;
      break label154;
    }
    paramJSONObject = (JSONObject)localObject2;
    break label154;
    label130:
    paramJSONObject = "top";
    break label150;
    label137:
    paramJSONObject = "top";
    str = "left";
    localObject1 = localObject2;
    label150:
    f2 = 20.0F;
    label154:
    QLog.e("ComponentContentNoteCard", 1, "json error!");
    try
    {
      paramTextView.setText(a((JSONArray)localObject1));
    }
    catch (Exception localException)
    {
      label177:
      boolean bool;
      float f4;
      float f5;
      break label177;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("text json array error: ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.e("ComponentContentNoteCard", 1, ((StringBuilder)localObject2).toString());
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    bool = str.equals("left");
    f4 = 0.0F;
    if (bool) {
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    } else if (str.equals("right")) {
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    }
    for (;;)
    {
      f5 = 0.0F;
      f3 = f2;
      f2 = f5;
      break;
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      if (f2 > 0.0F)
      {
        f3 = 0.0F;
        break;
      }
      f2 = -f2;
    }
    if (paramJSONObject.equals("top"))
    {
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    }
    else
    {
      if (paramJSONObject.equals("bottom"))
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        break label389;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      if (f1 <= 0.0F) {
        break label384;
      }
    }
    f5 = 0.0F;
    f4 = f1;
    f1 = f5;
    break label389;
    label384:
    f1 = -f1;
    label389:
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramTextView.setPadding((int)f2, (int)f4, (int)f3, (int)f1);
    paramTextView.setTextSize(paramFloat);
  }
  
  private void a(ScripCmsInfo paramScripCmsInfo)
  {
    try
    {
      a(this.b, new JSONObject(paramScripCmsInfo.a), 18.0F);
      a(this.c, new JSONObject(paramScripCmsInfo.b), 15.0F);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("json error: ");
      ((StringBuilder)localObject).append(paramScripCmsInfo.a);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramScripCmsInfo.b);
      QLog.e("ComponentContentNoteCard", 1, ((StringBuilder)localObject).toString());
    }
    this.e.setVisibility(0);
    this.d.setVisibility(0);
    this.f.setVisibility(0);
    this.d.setText(paramScripCmsInfo.d);
    Object localObject = ReadInJoyNoteCardUtil.d();
    Context localContext = getContext();
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (localContext != null) && (localContext.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 == 0) && (ReadInJoyNoteCardUtil.a() == 1))
    {
      this.f.setText(getContext().getString(2131915459));
      this.f.setOnClickListener(new ComponentContentNoteCard.1(this));
    }
    else
    {
      this.f.setText((CharSequence)localObject);
    }
    a(this.e, paramScripCmsInfo.e);
    a(this.g, paramScripCmsInfo.c);
    this.i.setOnClickListener(new ComponentContentNoteCard.2(this));
    this.h.setVisibility(0);
    localObject = this.m;
    if (localObject != null) {
      ((LottieDrawable)localObject).stop();
    }
    if (!TextUtils.isEmpty(paramScripCmsInfo.f)) {
      try
      {
        this.m = ReadInJoyLottieDrawable.a(paramScripCmsInfo.f);
        this.h.setImageDrawable(this.m);
        return;
      }
      catch (Exception paramScripCmsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ComponentContentNoteCard", 1, paramScripCmsInfo, new Object[0]);
        }
      }
    }
  }
  
  private void b(ScripCmsInfo paramScripCmsInfo)
  {
    paramScripCmsInfo.g = paramScripCmsInfo.g.replace("#$%", ReadInJoyNoteCardUtil.b());
    Object localObject = getContext();
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (localObject != null) && (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 == 0) && (ReadInJoyNoteCardUtil.a() == 1))
    {
      localObject = paramScripCmsInfo.h.replace("#$%", getContext().getString(2131915458));
      this.c.setOnClickListener(new ComponentContentNoteCard.3(this));
    }
    else
    {
      localObject = paramScripCmsInfo.h.replace("#$%", ReadInJoyNoteCardUtil.c());
    }
    try
    {
      a(this.b, new JSONObject(paramScripCmsInfo.g), 18.0F);
      a(this.c, new JSONObject((String)localObject), 15.0F);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("json error: ");
      localStringBuilder.append(paramScripCmsInfo.g);
      localStringBuilder.append("\n");
      localStringBuilder.append(paramScripCmsInfo.h);
      QLog.e("ComponentContentNoteCard", 1, localStringBuilder.toString());
    }
    a(this.g, paramScripCmsInfo.i);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private void e()
  {
    try
    {
      UITools.a((Activity)getContext());
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ComponentContentNoteCard", 1, localException, new Object[0]);
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)DeviceInfoUtil.F());
      double d1 = DeviceInfoUtil.F();
      Double.isNaN(d1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)(d1 * 0.5625D));
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void g()
  {
    SoundCheckRunnable localSoundCheckRunnable = this.o;
    if ((localSoundCheckRunnable == null) || (!localSoundCheckRunnable.b()))
    {
      this.o = new SoundCheckRunnable();
      this.o.a(this);
      ThreadManager.excute(this.o, 16, null, true);
      this.n.removeCallbacksAndMessages(null);
      this.n.postDelayed(new ComponentContentNoteCard.5(this), 60000L);
    }
  }
  
  private void h()
  {
    SoundCheckRunnable localSoundCheckRunnable = this.o;
    if (localSoundCheckRunnable != null)
    {
      localSoundCheckRunnable.a();
      this.o.a(null);
      this.o = null;
    }
    this.n.removeCallbacksAndMessages(null);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626175, this, true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemResume");
    }
    int i2 = 1;
    this.s = true;
    Object localObject = this.m;
    if (localObject != null) {
      ((LottieDrawable)localObject).resumeAnimation();
    }
    this.k.a(this);
    localObject = this.o;
    if (localObject != null) {
      ((SoundCheckRunnable)localObject).a();
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int i1;
    if ((this.q) && (ReadInJoyNoteCardUtil.a() != 0))
    {
      i1 = ReadInJoyNoteCardUtil.b(getContext(), (String)localObject);
      int i3 = ReadInJoyNoteCardUtil.c(getContext(), (String)localObject);
      if ((i1 < ReadInJoyNoteCardUtil.e()) && (i3 < ReadInJoyNoteCardUtil.f()))
      {
        this.l.j = 2;
        ReadInJoyNoteCardUtil.a(getContext(), (String)localObject, i1 + 1);
        ReadInJoyNoteCardUtil.b(getContext(), (String)localObject, i3 + 1);
      }
    }
    a(this.r);
    if ((ReadInJoyNoteCardUtil.a() == 1) && (ReadInJoyNoteCardUtil.b(getContext(), (String)localObject) > 0))
    {
      localObject = getContext();
      i1 = i2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i1 = i2;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
      }
      if (i1 != 0) {
        this.n.postDelayed(new ComponentContentNoteCard.4(this), 1000L);
      }
    }
    this.q = false;
  }
  
  public void a(View paramView)
  {
    this.a = ((RelativeLayout)paramView.findViewById(2131439408));
    this.b = ((TextView)paramView.findViewById(2131437925));
    this.c = ((TextView)paramView.findViewById(2131446541));
    this.g = ((ImageView)paramView.findViewById(2131439405));
    this.d = ((TextView)paramView.findViewById(2131437090));
    this.e = ((ImageView)paramView.findViewById(2131437088));
    this.f = ((TextView)paramView.findViewById(2131444811));
    this.h = ((ImageView)paramView.findViewById(2131437753));
    this.i = ((ImageView)paramView.findViewById(2131439407));
    this.j = ((ComponentNotIntrest)paramView.findViewById(2131439399));
    f();
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    ComponentNotIntrest localComponentNotIntrest = this.j;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    this.r = paramObject;
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).k().scripCmsInfo;
      this.l = paramObject;
      if (paramObject != null)
      {
        if ((paramObject.j != 1) && ((!TextUtils.isEmpty(paramObject.g)) || (!TextUtils.isEmpty(paramObject.h))))
        {
          b(paramObject);
          return;
        }
        a(paramObject);
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemPause");
    }
    this.s = false;
    LottieDrawable localLottieDrawable = this.m;
    if (localLottieDrawable != null) {
      localLottieDrawable.pauseAnimation();
    }
    this.k.b(this);
    h();
  }
  
  public void b(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void c()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ReadInJoyNoteCardUtil.a(getContext(), str) < ScripCmsInfo.o)
    {
      this.k.d(7);
      return;
    }
    QQToast.makeText(getContext(), 0, getContext().getString(2131915546), 0).show();
  }
  
  public void d()
  {
    this.q = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.m;
    if ((paramAbsListView != null) && (paramAbsListView.isAnimating()) && (this.p != 0)) {
      this.m.pauseAnimation();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.p = paramInt;
    paramAbsListView = this.m;
    if (paramAbsListView != null)
    {
      if (paramInt == 0)
      {
        paramAbsListView.resumeAnimation();
        return;
      }
      paramAbsListView.pauseAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentNoteCard
 * JD-Core Version:    0.7.0.1
 */