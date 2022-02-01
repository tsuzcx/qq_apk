package com.tencent.mobileqq.hiboom;

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
import com.qq.taf.jce.JceStruct;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new FontBubblePanelView.3(this);
  private FontBubbleManager jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager;
  private FontBubblePanelView.Controller<T> jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$Controller;
  private FontBubblePanelView<T>.FontBubbleAdapter jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$FontBubbleAdapter;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  private RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private List<FontBubble> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public FontBubblePanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper, FontBubblePanelView.Controller<T> paramController)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$Controller = paramController;
    this.jdField_a_of_type_Int = paramController.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager = FontBubbleManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130847388);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
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
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 21)
          {
            if (paramInt != 22) {
              paramInt = 2130847394;
            } else {
              paramInt = 2130847684;
            }
          }
          else {
            paramInt = 2130847685;
          }
        }
        else {
          paramInt = 2130850860;
        }
      }
      else {
        paramInt = 2130851196;
      }
    }
    else {
      paramInt = 2130847160;
    }
    paramImageView.setVisibility(0);
    Resources localResources = getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    paramInt = localDrawable.getIntrinsicWidth();
    int i = localDrawable.getIntrinsicHeight();
    paramImageView.setImageDrawable(localDrawable);
    paramImageView = paramImageView.getLayoutParams();
    paramImageView.height = AIOUtils.b(10.0F, localResources);
    paramImageView.width = (paramImageView.height * paramInt / i);
  }
  
  private void a(T paramT)
  {
    new QueryTask(new FontBubblePanelView.1(this), new FontBubblePanelView.2(this)).a(paramT);
  }
  
  public static void b()
  {
    int i = 0;
    for (;;)
    {
      boolean[] arrayOfBoolean = jdField_a_of_type_ArrayOfBoolean;
      if (i >= arrayOfBoolean.length) {
        break;
      }
      arrayOfBoolean[i] = false;
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
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$FontBubbleAdapter = new FontBubblePanelView.FontBubbleAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$FontBubbleAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper);
    setClipToPadding(false);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = AIOUtils.b(8.0F, (Resources)localObject1);
    int j = AIOUtils.b(8.0F, (Resources)localObject1);
    int k = AIOUtils.b(3.0F, (Resources)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPadding(j, i, k, 0);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, (ViewGroup.LayoutParams)localObject2);
  }
  
  public String a()
  {
    int i;
    if (this.jdField_a_of_type_Int == 3) {
      i = 2131704778;
    } else {
      i = 2131704777;
    }
    return HardCodeUtil.a(i);
  }
  
  public void a()
  {
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
  }
  
  public void a(FontBubblePanelView<T>.FontBubbleHolder paramFontBubblePanelView, FontBubble paramFontBubble)
  {
    if (paramFontBubble.viewType == 1)
    {
      Drawable localDrawable1;
      try
      {
        if (TextUtils.isEmpty(paramFontBubble.picUrl)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$Controller.a(paramFontBubble);
        } else {
          localObject = paramFontBubble.picUrl;
        }
        Object localObject = new URL("protocol_vas_extension_image", "FONT_BUBBLE", (String)localObject);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable2;
        localURLDrawableOptions.mLoadingDrawable = localDrawable2;
        localURLDrawableOptions.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      }
      catch (Exception localException)
      {
        QLog.e("FontBubblePanelView", 1, "updateView: ", localException);
        localDrawable1 = null;
      }
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(localDrawable1);
      a(paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetImageView, paramFontBubble.feeType);
      int i = AIOUtils.b(0.7F, getResources());
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, 0);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setText(paramFontBubble.name);
    }
    else
    {
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageResource(2130847395);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramFontBubblePanelView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageScale(0.92F, 0.0F);
    paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setTag(paramFontBubble);
    paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    paramFontBubblePanelView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(AIOUtils.b(5.0F, getResources()));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      Object localObject = jdField_a_of_type_ArrayOfBoolean;
      int i = this.jdField_a_of_type_Int;
      if (localObject[i] == 0)
      {
        localObject[i] = 1;
        localObject = (ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$Controller.a((ISVIPHandler)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131367110)
    {
      Object localObject = (FontBubble)paramView.getTag();
      long l;
      if (((FontBubble)localObject).viewType == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
        {
          l = SystemClock.uptimeMillis();
          if (this.jdField_a_of_type_Long + 1000L < l) {
            this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager.a((FontBubble)localObject);
          }
          this.jdField_a_of_type_Long = l;
        }
        int i;
        if (this.jdField_a_of_type_Int == 3) {
          i = ((FontBubble)localObject).fontId;
        } else {
          i = ((FontBubble)localObject).bubbleId;
        }
        VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "aio_iconA", "Clickitem", "", 1, 0, 0, "", Integer.toString(i), a(this.jdField_a_of_type_Int));
      }
      else
      {
        localObject = getContext();
        String str = VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$Controller.a((Context)localObject), 39);
        if (this.jdField_a_of_type_Int == 3) {
          l = 4096L;
        } else {
          l = 64L;
        }
        VasWebviewUtil.b((Context)localObject, str, l, null, false, -1);
        VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", a(this.jdField_a_of_type_Int));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView
 * JD-Core Version:    0.7.0.1
 */