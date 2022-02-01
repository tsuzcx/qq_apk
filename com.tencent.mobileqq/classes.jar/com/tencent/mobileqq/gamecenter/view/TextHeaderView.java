package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class TextHeaderView
  extends RelativeLayout
  implements IHeaderView, HippyViewBase
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HippyMap jdField_a_of_type_ComTencentMttHippyCommonHippyMap;
  private String jdField_a_of_type_JavaLangString;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public TextHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.url;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(AIOUtils.b(355.0F, getResources()), -1);
      localLayoutParams1.addRule(14);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(293.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(46.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(283.0F, getResources()));
      localLayoutParams2.topMargin = AIOUtils.b(46.0F, getResources());
      ((RelativeLayout)localObject).setPadding(AIOUtils.b(20.0F, getResources()), 0, AIOUtils.b(20.0F, getResources()), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = AIOUtils.b(60.0F, getResources());
      localLayoutParams2.addRule(10);
      localLayoutParams2.addRule(14);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367467);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams2);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = AIOUtils.b(6.0F, getResources());
      localLayoutParams2.addRule(14);
      localLayoutParams2.addRule(3, 2131367467);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams2);
      this.c = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(3, 2131367467);
      localLayoutParams2.topMargin = AIOUtils.b(56.0F, getResources());
      this.c.setTextColor(-16777216);
      this.c.setTextSize(14.0F);
      ((RelativeLayout)localObject).addView(this.c, localLayoutParams2);
      this.d = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = AIOUtils.b(106.0F, getResources());
      localLayoutParams2.addRule(3, 2131367467);
      this.d.setTextSize(14.0F);
      this.d.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.d, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
      localObject = new RelativeLayout.LayoutParams(AIOUtils.b(188.0F, getResources()), AIOUtils.b(51.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(296.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131714662));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(AIOUtils.b(92.0F, getResources()), AIOUtils.b(92.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png");
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQGameMsgInfo.title);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQGameMsgInfo.dateTitle);
      this.c.setText(paramQQGameMsgInfo.contentText);
      this.d.setText(paramQQGameMsgInfo.limitText);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(GamePubAccountConstant.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new TextHeaderView.3(this, paramContext, paramQQGameMsgInfo, paramInt, paramString));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new TextHeaderView.4(this, paramContext, paramQQGameMsgInfo, paramInt, paramString));
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      paramContext = new StringBuilder();
      paramContext.append("textHeader parse error ");
      paramContext.append(paramQQGameMsgInfo.toString());
      QLog.e("TextHeaderView", 2, paramContext.toString());
    }
  }
  
  public void a(HippyArray paramHippyArray)
  {
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.coverUrl = paramHippyArray.getString(0);
    localQQGameMsgInfo.title = paramHippyArray.getString(1);
    localQQGameMsgInfo.url = paramHippyArray.getString(2);
    localQQGameMsgInfo.contentText = paramHippyArray.getString(3);
    localQQGameMsgInfo.limitText = paramHippyArray.getString(4);
    localQQGameMsgInfo.dateTitle = paramHippyArray.getString(5);
    localQQGameMsgInfo.paMsgid = paramHippyArray.getString(6);
    localQQGameMsgInfo.gameAppId = paramHippyArray.getString(7);
    localQQGameMsgInfo.frienduin = paramHippyArray.getString(8);
    localQQGameMsgInfo.uniseq = paramHippyArray.getLong(9);
    localQQGameMsgInfo.advId = paramHippyArray.getString(10);
    localQQGameMsgInfo.triggerInfo = paramHippyArray.getString(11);
    int i = paramHippyArray.getInt(12);
    a(localQQGameMsgInfo, BaseApplicationImpl.getContext(), i, GamePubAccountHelper.a());
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void e()
  {
    a(((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMsgInfoByHippyMap(this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap), BaseApplicationImpl.getContext(), ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMsgPosByHippyMap(this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap), GamePubAccountHelper.a());
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setSrc(HippyMap paramHippyMap)
  {
    this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap = paramHippyMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView
 * JD-Core Version:    0.7.0.1
 */