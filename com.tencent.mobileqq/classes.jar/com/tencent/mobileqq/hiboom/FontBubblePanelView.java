package com.tencent.mobileqq.hiboom;

import actn;
import ajyc;
import akfw;
import akfz;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqwn;
import aqws;
import aqwt;
import aqwu;
import aqwv;
import aqww;
import aqwx;
import com.qq.taf.jce.JceStruct;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FontBubblePanelView<T extends JceStruct>
  extends RichTextPanelView
  implements View.OnClickListener
{
  private static boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[5];
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private akfz jdField_a_of_type_Akfz = new aqwu(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aqwn jdField_a_of_type_Aqwn;
  private aqwv<T> jdField_a_of_type_Aqwv;
  private FontBubblePanelView<T>.aqww jdField_a_of_type_Aqww;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private List<FontBubble> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public FontBubblePanelView(Context paramContext, BaseChatPie paramBaseChatPie, aqwv<T> paramaqwv)
  {
    super(paramContext);
    this.jdField_a_of_type_Aqwv = paramaqwv;
    this.jdField_a_of_type_Int = paramaqwv.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Aqwn = aqwn.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846234);
    c();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 3) {
      return "1";
    }
    return "2";
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 2130846240;
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      Resources localResources = getResources();
      Drawable localDrawable = localResources.getDrawable(paramInt);
      paramInt = localDrawable.getIntrinsicWidth();
      int i = localDrawable.getIntrinsicHeight();
      paramImageView.setImageDrawable(localDrawable);
      paramImageView = paramImageView.getLayoutParams();
      paramImageView.height = actn.a(10.0F, localResources);
      paramImageView.width = (paramImageView.height * paramInt / i);
      return;
      paramInt = 2130846025;
      continue;
      paramInt = 2130849645;
      continue;
      paramInt = 2130849364;
      continue;
      paramInt = 2130846530;
      continue;
      paramInt = 2130846529;
    }
  }
  
  private void a(T paramT)
  {
    new QueryTask(new aqws(this), new aqwt(this)).a(paramT);
  }
  
  public static void b()
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfBoolean.length)
    {
      jdField_a_of_type_ArrayOfBoolean[i] = false;
      i += 1;
    }
  }
  
  private void c()
  {
    Object localObject1 = new FontBubble();
    ((FontBubble)localObject1).viewType = 0;
    this.jdField_a_of_type_JavaUtilList.add(localObject1);
    Object localObject2 = getContext();
    localObject1 = ((Context)localObject2).getResources();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView((Context)localObject2);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    localObject2 = new GridLayoutManager((Context)localObject2, 4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
    this.jdField_a_of_type_Aqww = new aqww(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aqww);
    setClipToPadding(false);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = actn.a(8.0F, (Resources)localObject1);
    int j = actn.a(8.0F, (Resources)localObject1);
    int k = actn.a(3.0F, (Resources)localObject1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setPadding(j, i, k, 0);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, (ViewGroup.LayoutParams)localObject2);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 3) {
      return ajyc.a(2131704675);
    }
    return ajyc.a(2131704674);
  }
  
  public void a()
  {
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
  }
  
  public void a(FontBubblePanelView<T>.aqwx paramFontBubblePanelView, FontBubble paramFontBubble)
  {
    if (paramFontBubble.viewType == 1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramFontBubble.picUrl)) {
          break label207;
        }
        localObject1 = this.jdField_a_of_type_Aqwv.a(paramFontBubble);
        localObject1 = new URL("protocol_vas_extension_image", "FONT_BUBBLE", (String)localObject1);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          QLog.e("FontBubblePanelView", 1, "updateView: ", localException);
          localObject2 = null;
        }
      }
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject1);
      a(paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetImageView, paramFontBubble.feeType);
      i = actn.a(0.7F, getResources());
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, 0);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setText(paramFontBubble.name);
    }
    for (;;)
    {
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageScale(0.92F, 0.0F);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setTag(paramFontBubble);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(actn.a(5.0F, getResources()));
      return;
      label207:
      localObject1 = paramFontBubble.picUrl;
      break;
      Object localObject2;
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageResource(2130846241);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfz);
      if (jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
      {
        jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
        akfw localakfw = (akfw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        this.jdField_a_of_type_Aqwv.a(localakfw);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfz);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = (FontBubble)paramView.getTag();
    if (paramView.viewType == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
      {
        l = SystemClock.uptimeMillis();
        if (this.jdField_a_of_type_Long + 1000L < l) {
          this.jdField_a_of_type_Aqwn.a(paramView);
        }
        this.jdField_a_of_type_Long = l;
      }
      if (this.jdField_a_of_type_Int == 3) {}
      for (int i = paramView.fontId;; i = paramView.bubbleId)
      {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "Clickitem", "", 1, 0, 0, "", Integer.toString(i), a(this.jdField_a_of_type_Int));
        return;
      }
    }
    paramView = getContext();
    String str = this.jdField_a_of_type_Aqwv.a(paramView);
    if (this.jdField_a_of_type_Int == 3) {}
    for (long l = 4096L;; l = 64L)
    {
      VasWebviewUtil.openQQBrowserWithoutAD(paramView, str, l, null, false, -1);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView
 * JD-Core Version:    0.7.0.1
 */