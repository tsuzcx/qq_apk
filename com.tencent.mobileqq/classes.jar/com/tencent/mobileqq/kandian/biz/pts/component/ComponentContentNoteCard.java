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
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  private ReadInJoyXListView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = null;
  private SoundCheckRunnable jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
  private ComponentNotIntrest jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest = null;
  private ScripCmsInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsScripCmsInfo;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private ImageView jdField_d_of_type_AndroidWidgetImageView = null;
  private TextView jdField_d_of_type_AndroidWidgetTextView = null;
  
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = ((ReadInJoyXListView)paramReadInJoyBaseAdapter.a());
    a(paramContext);
  }
  
  private SpannableStringBuilder a(JSONArray paramJSONArray)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = new JSONObject(paramJSONArray.get(i).toString());
      String str = ((JSONObject)localObject).optString("word", "    ");
      int j = Color.parseColor(((JSONObject)localObject).optString("color", "#C3C0D6"));
      int k = Integer.valueOf(((JSONObject)localObject).optString("size", "15")).intValue();
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(j), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(k, true), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
      i += 1;
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
      int i;
      label124:
      break label136;
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
      break label147;
    }
    try
    {
      f3 = Float.valueOf(a(paramJSONObject, "E")).floatValue();
      f1 = f3;
      i = DisplayUtil.a(getContext(), f2);
      f2 = i;
    }
    catch (Exception paramJSONObject)
    {
      break label124;
    }
    try
    {
      i = DisplayUtil.a(getContext(), f3);
      f1 = i;
      paramJSONObject = (JSONObject)localObject2;
    }
    catch (Exception paramJSONObject)
    {
      f1 = f3;
      paramJSONObject = (JSONObject)localObject2;
      break label151;
    }
    paramJSONObject = (JSONObject)localObject2;
    break label151;
    label130:
    paramJSONObject = "top";
    break label147;
    label136:
    paramJSONObject = "top";
    str = "left";
    localObject1 = localObject2;
    label147:
    f2 = 20.0F;
    label151:
    QLog.e("ComponentContentNoteCard", 1, "json error!");
    try
    {
      paramTextView.setText(a((JSONArray)localObject1));
    }
    catch (Exception localException)
    {
      label172:
      boolean bool;
      float f4;
      float f5;
      break label172;
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
        break label381;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      if (f1 <= 0.0F) {
        break label376;
      }
    }
    f5 = 0.0F;
    f4 = f1;
    f1 = f5;
    break label381;
    label376:
    f1 = -f1;
    label381:
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramTextView.setPadding((int)f2, (int)f4, (int)f3, (int)f1);
    paramTextView.setTextSize(paramFloat);
  }
  
  private void a(ScripCmsInfo paramScripCmsInfo)
  {
    try
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, new JSONObject(paramScripCmsInfo.jdField_a_of_type_JavaLangString), 18.0F);
      a(this.jdField_b_of_type_AndroidWidgetTextView, new JSONObject(paramScripCmsInfo.b), 15.0F);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("json error: ");
      ((StringBuilder)localObject).append(paramScripCmsInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramScripCmsInfo.b);
      QLog.e("ComponentContentNoteCard", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramScripCmsInfo.jdField_d_of_type_JavaLangString);
    Object localObject = ReadInJoyNoteCardUtil.c();
    Context localContext = getContext();
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (localContext != null) && (localContext.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (ReadInJoyNoteCardUtil.a() == 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getContext().getString(2131717979));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentContentNoteCard.1(this));
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramScripCmsInfo.e);
    a(this.jdField_b_of_type_AndroidWidgetImageView, paramScripCmsInfo.c);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ComponentContentNoteCard.2(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null) {
      ((LottieDrawable)localObject).stop();
    }
    if (!TextUtils.isEmpty(paramScripCmsInfo.f)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = ReadInJoyLottieDrawable.a(paramScripCmsInfo.f);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
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
    paramScripCmsInfo.g = paramScripCmsInfo.g.replace("#$%", ReadInJoyNoteCardUtil.a());
    Object localObject = getContext();
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (localObject != null) && (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (ReadInJoyNoteCardUtil.a() == 1))
    {
      localObject = paramScripCmsInfo.h.replace("#$%", getContext().getString(2131717978));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentContentNoteCard.3(this));
    }
    else
    {
      localObject = paramScripCmsInfo.h.replace("#$%", ReadInJoyNoteCardUtil.b());
    }
    try
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, new JSONObject(paramScripCmsInfo.g), 18.0F);
      a(this.jdField_b_of_type_AndroidWidgetTextView, new JSONObject((String)localObject), 15.0F);
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
    a(this.jdField_b_of_type_AndroidWidgetImageView, paramScripCmsInfo.i);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
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
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)DeviceInfoUtil.k());
      double d1 = DeviceInfoUtil.k();
      Double.isNaN(d1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)(d1 * 0.5625D));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void g()
  {
    SoundCheckRunnable localSoundCheckRunnable = this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
    if ((localSoundCheckRunnable == null) || (!localSoundCheckRunnable.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable = new SoundCheckRunnable();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable.a(this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable, 16, null, true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ComponentContentNoteCard.5(this), 60000L);
    }
  }
  
  private void h()
  {
    SoundCheckRunnable localSoundCheckRunnable = this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
    if (localSoundCheckRunnable != null)
    {
      localSoundCheckRunnable.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable.a(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560128, this, true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemResume");
    }
    int j = 1;
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null) {
      ((LottieDrawable)localObject).resumeAnimation();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizNotecardSoundCheckRunnable;
    if (localObject != null) {
      ((SoundCheckRunnable)localObject).a();
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int i;
    if ((this.jdField_a_of_type_Boolean) && (ReadInJoyNoteCardUtil.a() != 0))
    {
      i = ReadInJoyNoteCardUtil.b(getContext(), (String)localObject);
      int k = ReadInJoyNoteCardUtil.c(getContext(), (String)localObject);
      if ((i < ReadInJoyNoteCardUtil.b()) && (k < ReadInJoyNoteCardUtil.c()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsScripCmsInfo.jdField_a_of_type_Int = 2;
        ReadInJoyNoteCardUtil.a(getContext(), (String)localObject, i + 1);
        ReadInJoyNoteCardUtil.b(getContext(), (String)localObject, k + 1);
      }
    }
    a(this.jdField_a_of_type_JavaLangObject);
    if ((ReadInJoyNoteCardUtil.a() == 1) && (ReadInJoyNoteCardUtil.b(getContext(), (String)localObject) > 0))
    {
      localObject = getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if (i != 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ComponentContentNoteCard.4(this), 1000L);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371963));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370649));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378041));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371960));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369941));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369939));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376560));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370481));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371962));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371954));
    f();
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    ComponentNotIntrest localComponentNotIntrest = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a().scripCmsInfo;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsScripCmsInfo = paramObject;
      if (paramObject != null)
      {
        if ((paramObject.jdField_a_of_type_Int != 1) && ((!TextUtils.isEmpty(paramObject.g)) || (!TextUtils.isEmpty(paramObject.h))))
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
    this.jdField_b_of_type_Boolean = false;
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable != null) {
      localLottieDrawable.pauseAnimation();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.b(this);
    h();
  }
  
  public void c()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ReadInJoyNoteCardUtil.a(getContext(), str) < ScripCmsInfo.jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.c(7);
      return;
    }
    QQToast.a(getContext(), 0, getContext().getString(2131718069), 0).a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((paramAbsListView != null) && (paramAbsListView.isAnimating()) && (this.jdField_a_of_type_Int != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentNoteCard
 * JD-Core Version:    0.7.0.1
 */