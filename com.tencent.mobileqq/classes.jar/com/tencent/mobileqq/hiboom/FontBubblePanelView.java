package com.tencent.mobileqq.hiboom;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
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
import anzj;
import aogu;
import aogx;
import avqr;
import avqw;
import avqx;
import avqy;
import avqz;
import avra;
import avrb;
import avse;
import com.qq.taf.jce.JceStruct;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private aogx jdField_a_of_type_Aogx = new avqy(this);
  private avqr jdField_a_of_type_Avqr;
  private avqz<T> jdField_a_of_type_Avqz;
  private FontBubblePanelView<T>.avra jdField_a_of_type_Avra;
  private avse jdField_a_of_type_Avse;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private List<FontBubble> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public FontBubblePanelView(Context paramContext, BaseChatPie paramBaseChatPie, avse paramavse, avqz<T> paramavqz)
  {
    super(paramContext);
    this.jdField_a_of_type_Avqz = paramavqz;
    this.jdField_a_of_type_Int = paramavqz.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Avqr = avqr.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130847157);
    this.jdField_a_of_type_Avse = paramavse;
    d();
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
      paramInt = 2130847163;
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
      paramImageView.height = agej.a(10.0F, localResources);
      paramImageView.width = (paramImageView.height * paramInt / i);
      return;
      paramInt = 2130846938;
      continue;
      paramInt = 2130850782;
      continue;
      paramInt = 2130850486;
      continue;
      paramInt = 2130847464;
      continue;
      paramInt = 2130847463;
    }
  }
  
  private void a(T paramT)
  {
    new QueryTask(new avqw(this), new avqx(this)).a(paramT);
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
  
  private void d()
  {
    Object localObject1 = new FontBubble();
    ((FontBubble)localObject1).viewType = 0;
    this.jdField_a_of_type_JavaUtilList.add(localObject1);
    Object localObject2 = getContext();
    localObject1 = ((Context)localObject2).getResources();
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView = new RichTextPanelRecyclerView((Context)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setOverScrollMode(2);
    localObject2 = new GridLayoutManager((Context)localObject2, 4);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
    this.jdField_a_of_type_Avra = new avra(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Avra);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Avse);
    setClipToPadding(false);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = agej.a(8.0F, (Resources)localObject1);
    int j = agej.a(8.0F, (Resources)localObject1);
    int k = agej.a(3.0F, (Resources)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPadding(j, i, k, 0);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, (ViewGroup.LayoutParams)localObject2);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 3) {
      return anzj.a(2131703573);
    }
    return anzj.a(2131703572);
  }
  
  public void a()
  {
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
  }
  
  public void a(FontBubblePanelView<T>.avrb paramFontBubblePanelView, FontBubble paramFontBubble)
  {
    if (paramFontBubble.viewType == 1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramFontBubble.picUrl)) {
          break label207;
        }
        localObject1 = this.jdField_a_of_type_Avqz.a(paramFontBubble);
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
      i = agej.a(0.7F, getResources());
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, 0);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setText(paramFontBubble.name);
    }
    for (;;)
    {
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageScale(0.92F, 0.0F);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setTag(paramFontBubble);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(agej.a(5.0F, getResources()));
      return;
      label207:
      localObject1 = paramFontBubble.picUrl;
      break;
      Object localObject2;
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageResource(2130847164);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogx);
      if (jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
      {
        jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
        aogu localaogu = (aogu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        this.jdField_a_of_type_Avqz.a(localaogu);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogx);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = (FontBubble)paramView.getTag();
    if (((FontBubble)localObject).viewType == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
      {
        l = SystemClock.uptimeMillis();
        if (this.jdField_a_of_type_Long + 1000L < l) {
          this.jdField_a_of_type_Avqr.a((FontBubble)localObject);
        }
        this.jdField_a_of_type_Long = l;
      }
      if (this.jdField_a_of_type_Int == 3) {}
      for (int i = ((FontBubble)localObject).fontId;; i = ((FontBubble)localObject).bubbleId)
      {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "Clickitem", "", 1, 0, 0, "", Integer.toString(i), a(this.jdField_a_of_type_Int));
        break;
      }
    }
    localObject = getContext();
    String str = this.jdField_a_of_type_Avqz.a((Context)localObject);
    if (this.jdField_a_of_type_Int == 3) {}
    for (long l = 4096L;; l = 64L)
    {
      VasWebviewUtil.openQQBrowserWithoutAD((Context)localObject, str, l, null, false, -1);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView
 * JD-Core Version:    0.7.0.1
 */