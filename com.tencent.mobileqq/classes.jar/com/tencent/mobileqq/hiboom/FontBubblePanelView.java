package com.tencent.mobileqq.hiboom;

import aekt;
import alpo;
import alxl;
import alxo;
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
import asnd;
import asni;
import asnj;
import asnk;
import asnl;
import asnm;
import asnn;
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
  private alxo jdField_a_of_type_Alxo = new asnk(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private asnd jdField_a_of_type_Asnd;
  private asnl<T> jdField_a_of_type_Asnl;
  private FontBubblePanelView<T>.asnm jdField_a_of_type_Asnm;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private List<FontBubble> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public FontBubblePanelView(Context paramContext, BaseChatPie paramBaseChatPie, asnl<T> paramasnl)
  {
    super(paramContext);
    this.jdField_a_of_type_Asnl = paramasnl;
    this.jdField_a_of_type_Int = paramasnl.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Asnd = asnd.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846619);
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
      paramInt = 2130846625;
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
      paramImageView.height = aekt.a(10.0F, localResources);
      paramImageView.width = (paramImageView.height * paramInt / i);
      return;
      paramInt = 2130846410;
      continue;
      paramInt = 2130850094;
      continue;
      paramInt = 2130849812;
      continue;
      paramInt = 2130846917;
      continue;
      paramInt = 2130846916;
    }
  }
  
  private void a(T paramT)
  {
    new QueryTask(new asni(this), new asnj(this)).a(paramT);
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
    this.jdField_a_of_type_Asnm = new asnm(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asnm);
    setClipToPadding(false);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = aekt.a(8.0F, (Resources)localObject1);
    int j = aekt.a(8.0F, (Resources)localObject1);
    int k = aekt.a(3.0F, (Resources)localObject1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setPadding(j, i, k, 0);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, (ViewGroup.LayoutParams)localObject2);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 3) {
      return alpo.a(2131705058);
    }
    return alpo.a(2131705057);
  }
  
  public void a()
  {
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
  }
  
  public void a(FontBubblePanelView<T>.asnn paramFontBubblePanelView, FontBubble paramFontBubble)
  {
    if (paramFontBubble.viewType == 1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramFontBubble.picUrl)) {
          break label207;
        }
        localObject1 = this.jdField_a_of_type_Asnl.a(paramFontBubble);
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
      i = aekt.a(0.7F, getResources());
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, 0);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setText(paramFontBubble.name);
    }
    for (;;)
    {
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageScale(0.92F, 0.0F);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setTag(paramFontBubble);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(aekt.a(5.0F, getResources()));
      return;
      label207:
      localObject1 = paramFontBubble.picUrl;
      break;
      Object localObject2;
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageResource(2130846626);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alxo);
      if (jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
      {
        jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
        alxl localalxl = (alxl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        this.jdField_a_of_type_Asnl.a(localalxl);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alxo);
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
          this.jdField_a_of_type_Asnd.a(paramView);
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
    String str = this.jdField_a_of_type_Asnl.a(paramView);
    if (this.jdField_a_of_type_Int == 3) {}
    for (long l = 4096L;; l = 64L)
    {
      VasWebviewUtil.openQQBrowserWithoutAD(paramView, str, l, null, false, -1);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView
 * JD-Core Version:    0.7.0.1
 */