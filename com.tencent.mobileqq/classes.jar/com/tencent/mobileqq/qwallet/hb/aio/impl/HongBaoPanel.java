package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IBaseChatPieProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi.ITroopUnclaimedHbList;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiRedpacketUserGuideDialog;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class HongBaoPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 4;
  protected Context a;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new HongBaoPanel.3(this);
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  IBaseChatPieProxy jdField_a_of_type_ComQwalletTempIBaseChatPieProxy;
  public BaseQQAppInterface a;
  BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  protected QBaseActivity a;
  private IQWalletHbApi.ITroopUnclaimedHbList jdField_a_of_type_ComTencentMobileqqQwalletHbIQWalletHbApi$ITroopUnclaimedHbList;
  ICustomizeStrategyFactory.OnCustomizeListener jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener = new HongBaoPanel.1(this);
  HongBaoPanel.HongBaoAdapter jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter;
  HongBaoPanel.OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener = new HongBaoPanel.5(this);
  IQWalletRedService jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private String jdField_a_of_type_JavaLangString;
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = ImmersiveUtils.dpToPx(14.0F);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String d;
  private String e = "#5B6175";
  private String f = "#27BEF6";
  private String g = "#000000";
  
  public HongBaoPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongBaoPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_JavaLangInteger == null) {
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(getResources().getColor(com.tencent.mobileqq.qqpay.ui.R.color.j));
    }
    return this.jdField_a_of_type_JavaLangInteger.intValue();
  }
  
  private RedPacketInfo a(int paramInt, String paramString, ImageView paramImageView)
  {
    RedPacketInfo localRedPacketInfo = new RedPacketInfo();
    localRedPacketInfo.type = 7;
    localRedPacketInfo.templateId = paramString;
    return ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localRedPacketInfo, new HongBaoPanel.4(this, paramString, paramImageView, paramInt));
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    int j;
    if (paramTextView != null) {
      j = paramInt1;
    }
    for (;;)
    {
      try
      {
        paramTextView.setText(paramString);
        i = paramInt1;
        j = paramInt1;
        if (a()) {
          if (paramInt2 != 0)
          {
            if (paramInt2 != 1)
            {
              if (paramInt2 != 2)
              {
                i = paramInt1;
              }
              else
              {
                j = paramInt1;
                paramInt1 = Color.parseColor("#737373");
                break label138;
              }
            }
            else
            {
              j = paramInt1;
              paramInt1 = Color.parseColor("#004080");
              break label138;
            }
          }
          else
          {
            j = paramInt1;
            paramInt1 = a();
            break label138;
          }
        }
        j = i;
        paramTextView.setTextColor(i);
        return;
      }
      catch (Throwable paramTextView)
      {
        paramTextView.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramTextView = new StringBuilder();
          paramTextView.append("maybe parseColor failed--------,color=");
          paramTextView.append(j);
          QLog.d("HongBaoPanel", 2, paramTextView.toString());
        }
      }
      return;
      label138:
      int i = paramInt1;
    }
  }
  
  private void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    try
    {
      switch (paramRedPacketInfo.skinType)
      {
      case 102: 
        if ((paramRedPacketInfo == null) || (paramRedPacketInfo.icon == null)) {
          break label271;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramRedPacketInfo.icon);
        return;
      }
    }
    catch (Throwable paramRedPacketInfo)
    {
      if (!QLog.isColorLevel()) {
        break label271;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePanelPictures exception =");
      ((StringBuilder)localObject).append(paramRedPacketInfo.toString());
      QLog.i("HongBaoPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(R.drawable.aj);
      return;
    }
    if ((paramRedPacketInfo != null) && (paramRedPacketInfo.icon != null))
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramRedPacketInfo.icon));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramRedPacketInfo.icon));
      return;
      if ((paramRedPacketInfo != null) && (!TextUtils.isEmpty(paramRedPacketInfo.resPath)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = QWalletPicHelper.getDrawableForAIO(paramRedPacketInfo.resPath, URLDrawableHelperConstants.a);
        ((URLDrawable)localObject).setURLDrawableListener(new HongBaoPanel.2(this, paramRedPacketInfo, (Drawable)localObject));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        setBackgroundColor(Color.parseColor("#000000"));
        this.jdField_c_of_type_Boolean = true;
        return;
      }
    }
    label271:
    return;
  }
  
  private void a(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService;
      if (localObject != null)
      {
        paramString = ((IQWalletRedService)localObject).getShowInfo(paramString);
        if (paramString != null)
        {
          localObject = this.jdField_b_of_type_AndroidWidgetImageView;
          int i;
          if (paramString.jdField_a_of_type_Boolean) {
            i = 0;
          } else {
            i = 8;
          }
          ((ImageView)localObject).setVisibility(i);
        }
      }
    }
  }
  
  private boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  private boolean a(IQWalletConfigService paramIQWalletConfigService, String paramString1, String paramString2)
  {
    if (paramIQWalletConfigService == null) {
      return false;
    }
    try
    {
      boolean bool = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isValidDate(paramString1, paramString2);
      return bool;
    }
    catch (Throwable paramIQWalletConfigService)
    {
      paramIQWalletConfigService.printStackTrace();
    }
    return false;
  }
  
  private void f()
  {
    Object localObject2 = (IQWalletConfigService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
    if (a((IQWalletConfigService)localObject2, ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "themeInfo", "begintime" }), ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "themeInfo", "endtime" })))
    {
      this.e = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#5B6175", new String[] { "themeInfo", "fontColorIcon" });
      this.g = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorAct" });
      this.f = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#27BEF6", new String[] { "themeInfo", "fontColorTab" });
      this.jdField_c_of_type_JavaLangString = ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "themeInfo", "panelPic" });
      this.jdField_b_of_type_JavaLangString = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#FFFFFF", new String[] { "themeInfo", "panelColor" });
    }
    if (QQTheme.a(VasUtil.a(), false))
    {
      this.f = "#27BEF6";
      this.e = "#5B6175";
      this.jdField_b_of_type_JavaLangString = "";
    }
    if (!StringUtil.a(this.jdField_b_of_type_JavaLangString)) {
      try
      {
        setBackgroundColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (!StringUtil.a(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = new RedPacketInfo();
      ((RedPacketInfo)localObject1).skinType = 100;
      ((RedPacketInfo)localObject1).templateId = this.jdField_c_of_type_JavaLangString;
      ((RedPacketInfo)localObject1).type = 7;
      localObject1 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (RedPacketInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
      if (localObject1 != null) {
        a((RedPacketInfo)localObject1);
      }
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_c_of_type_Boolean = true;
    }
    else
    {
      setBackgroundResource(R.drawable.ar);
    }
    Object localObject1 = ((IQWalletConfigService)localObject2).getObj("redPackPanel", new String[] { "panelAct" });
    if (localObject1 != null) {
      if (a((IQWalletConfigService)localObject2, ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "panelAct", "params", "begintime" }), ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "panelAct", "params", "endtime" })))
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("params");
        if (localObject2 != null) {
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("url");
        }
        if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          a(this.jdField_a_of_type_AndroidWidgetTextView, ((JSONObject)localObject1).optString("name"), Color.parseColor(this.g), 2);
          localObject2 = ((JSONObject)localObject1).optString("bubble_pic");
          RedPacketInfo localRedPacketInfo = new RedPacketInfo();
          localRedPacketInfo.skinType = 101;
          localRedPacketInfo.templateId = ((String)localObject2);
          localRedPacketInfo.type = 7;
          localObject2 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
          if (localObject2 != null) {
            a((RedPacketInfo)localObject2);
          }
          localObject2 = ((JSONObject)localObject1).optString("icon_pic");
          localRedPacketInfo = new RedPacketInfo();
          localRedPacketInfo.skinType = 102;
          localRedPacketInfo.templateId = ((String)localObject2);
          localRedPacketInfo.type = 7;
          localObject2 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
          if (localObject2 != null) {
            a((RedPacketInfo)localObject2);
          }
          this.d = ((JSONObject)localObject1).optString("id");
          a(this.d);
        }
      }
    }
  }
  
  private void g()
  {
    List localList = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getPanelTabList(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject2 = (PanelTabData)localList.get(i);
        if (i != 0)
        {
          localObject3 = new View(this.jdField_a_of_type_AndroidContentContext);
          localObject1 = new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(0.5F), ImmersiveUtils.dpToPx(15.0F));
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ImmersiveUtils.dpToPx(9.0F);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (a()) {
            localObject1 = "#737373";
          } else {
            localObject1 = "#DEDEDE";
          }
          ((View)localObject3).setBackgroundColor(Color.parseColor((String)localObject1));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        }
        Object localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((TextView)localObject1).setTag(localObject2);
        ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((TextView)localObject1).setTextSize(2, 12.0F);
        Object localObject3 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).gravity = 16;
        ((TextView)localObject1).setGravity(1);
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject3).leftMargin = ImmersiveUtils.dpToPx(10.0F);
        }
        if (StringUtil.a(this.f)) {
          this.f = "#27BEF6";
        }
        localObject2 = ((PanelTabData)localObject2).jdField_b_of_type_JavaLangString;
        int j;
        if ("#27BEF6".equals(this.f)) {
          j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(com.tencent.mobileqq.qqui.R.color.jdField_a_of_type_Int);
        } else {
          j = Color.parseColor(this.f);
        }
        a((TextView)localObject1, (String)localObject2, j, 1);
        i += 1;
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComQwalletTempIBaseChatPieProxy;
    if ((localObject != null) && (((IBaseChatPieProxy)localObject).a() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
      if (localObject != null) {
        try
        {
          localObject = ((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString;
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int;
          if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbIQWalletHbApi$ITroopUnclaimedHbList == null) {
            this.jdField_a_of_type_ComTencentMobileqqQwalletHbIQWalletHbApi$ITroopUnclaimedHbList = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getTroopUnclaimedHbList(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComQwalletTempIBaseChatPieProxy);
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbIQWalletHbApi$ITroopUnclaimedHbList.a((String)localObject, i);
          return;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("open troop red package fail: ");
          localStringBuilder.append(localThrowable);
          QLog.e("HongBaoPanel", 2, localStringBuilder.toString());
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("HongBaoPanel", 2, "open troop red package fail!!!");
    }
  }
  
  private void i()
  {
    try
    {
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHitRect(localRect);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i);
        if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)) && (localRect.height() == ((View)localObject).getHeight()))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a(i);
          if (localObject != null) {
            ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "aio.lucky.show", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, ((PanelData)localObject).jdField_b_of_type_JavaLangString);
          }
          localIterator.remove();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("HongBaoPanel", 1, localException, new Object[0]);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PanelData localPanelData = (PanelData)((Iterator)localObject).next();
        if ((localPanelData != null) && (localPanelData.jdField_a_of_type_Int == 8)) {
          PreloadStaticApi.a().getResPath(EmojiRedpacketUserGuideDialog.jdField_a_of_type_JavaLangString, null);
        }
      }
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, false, null);
    this.jdField_a_of_type_ComQwalletTempIBaseChatPieProxy = paramIBaseChatPieProxy;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramIBaseChatPieProxy.a();
    this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService = ((IQWalletRedService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQWalletRedService.class));
    this.jdField_a_of_type_AndroidViewViewGroup = paramIBaseChatPieProxy.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramIBaseChatPieProxy.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(R.id.ah));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(R.id.ag));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(R.id.aG));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(R.id.aH));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(R.id.ak));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(R.id.af));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(R.id.jdField_a_of_type_Int));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.cj));
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setChangeDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new HongBaoPanel.SpaceItemDecoration(this));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter = new HongBaoPanel.HongBaoAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener);
    f();
    g();
    paramBaseQQAppInterface = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getPanelList(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a(paramBaseQQAppInterface);
    b();
    a();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localArrayList.add(((PanelData)((List)localObject).get(i)).jdField_a_of_type_JavaLangString);
        i += 1;
      }
      localObject = ((IQWalletConfigService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "")).getObj("redPackPanel", new String[] { "panelAct" });
      if (localObject != null) {
        localArrayList.add(((JSONObject)localObject).optString("id"));
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService.doShowReport(localArrayList);
    }
  }
  
  public void c()
  {
    this.jdField_c_of_type_Int = 0;
    IQWalletHbApi.ITroopUnclaimedHbList localITroopUnclaimedHbList = this.jdField_a_of_type_ComTencentMobileqqQwalletHbIQWalletHbApi$ITroopUnclaimedHbList;
    if (localITroopUnclaimedHbList != null) {
      localITroopUnclaimedHbList.a();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failedImageReTryTimes=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(",failedPositionList=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilList.toString());
      QLog.d("HongBaoPanel", 2, ((StringBuilder)localObject).toString());
    }
    int i = this.jdField_c_of_type_Int + 1;
    this.jdField_c_of_type_Int = i;
    if (i > 3) {
      return;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter;
        if (localObject != null) {
          ((HongBaoPanel.HongBaoAdapter)localObject).notifyItemChanged(i);
        }
        i += 1;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  public void e()
  {
    try
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(i));
          i += 1;
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new HongBaoPanel.6(this), 300L);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new HongBaoPanel.7(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("HongBaoPanel", 1, localException, new Object[0]);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.af)
    {
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
        ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService;
      if (paramView != null) {
        paramView.doClick(this.d);
      }
      a(this.d);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 10008))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
          paramView = "entrance.click.group";
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
          paramView = "entrance.click.chatgroup";
        } else {
          paramView = "";
        }
      }
      else {
        paramView = "entrance.click.c2c";
      }
      int i = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getPanelFrom();
      Object localObject;
      if (i == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramView);
        ((StringBuilder)localObject).append(".plus");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramView;
        if (i == 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView);
          ((StringBuilder)localObject).append(".quick");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject, 0, 0, "10000", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel
 * JD-Core Version:    0.7.0.1
 */