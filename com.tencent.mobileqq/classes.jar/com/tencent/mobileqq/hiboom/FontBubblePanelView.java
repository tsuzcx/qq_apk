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
  private static boolean[] a = new boolean[5];
  private int b;
  private long c;
  private List<FontBubble> d = new ArrayList();
  private FontBubblePanelView.Controller<T> e;
  private FontBubbleManager f;
  private BaseChatPie g;
  private RichTextPanelRecyclerView h;
  private FontBubblePanelView<T>.FontBubbleAdapter i;
  private Drawable j;
  private RichTextPanelExtendHelper k;
  private SVIPObserver l = new FontBubblePanelView.3(this);
  
  public FontBubblePanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper, FontBubblePanelView.Controller<T> paramController)
  {
    super(paramContext);
    this.e = paramController;
    this.b = paramController.a();
    this.g = paramBaseChatPie;
    this.f = FontBubbleManager.a(paramBaseChatPie.d);
    this.j = paramContext.getResources().getDrawable(2130849039);
    this.k = paramRichTextPanelExtendHelper;
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
              paramInt = 2130849048;
            } else {
              paramInt = 2130849344;
            }
          }
          else {
            paramInt = 2130849345;
          }
        }
        else {
          paramInt = 2130852711;
        }
      }
      else {
        paramInt = 2130853452;
      }
    }
    else {
      paramInt = 2130848712;
    }
    paramImageView.setVisibility(0);
    Resources localResources = getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    paramInt = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramImageView.setImageDrawable(localDrawable);
    paramImageView = paramImageView.getLayoutParams();
    paramImageView.height = AIOUtils.b(10.0F, localResources);
    paramImageView.width = (paramImageView.height * paramInt / m);
  }
  
  private void a(T paramT)
  {
    new QueryTask(new FontBubblePanelView.1(this), new FontBubblePanelView.2(this)).a(paramT);
  }
  
  public static void b()
  {
    int m = 0;
    for (;;)
    {
      boolean[] arrayOfBoolean = a;
      if (m >= arrayOfBoolean.length) {
        break;
      }
      arrayOfBoolean[m] = false;
      m += 1;
    }
  }
  
  private void d()
  {
    Object localObject1 = new FontBubble();
    ((FontBubble)localObject1).viewType = 0;
    this.d.add(localObject1);
    Object localObject2 = getContext();
    localObject1 = ((Context)localObject2).getResources();
    this.h = new RichTextPanelRecyclerView((Context)localObject2);
    this.h.setOverScrollMode(2);
    localObject2 = new GridLayoutManager((Context)localObject2, 4);
    this.h.setLayoutManager((RecyclerView.LayoutManager)localObject2);
    this.i = new FontBubblePanelView.FontBubbleAdapter(this);
    this.h.setAdapter(this.i);
    this.h.setPanelExtendHelper(this.k);
    setClipToPadding(false);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int m = AIOUtils.b(8.0F, (Resources)localObject1);
    int n = AIOUtils.b(8.0F, (Resources)localObject1);
    int i1 = AIOUtils.b(3.0F, (Resources)localObject1);
    this.h.setPadding(n, m, i1, 0);
    addView(this.h, (ViewGroup.LayoutParams)localObject2);
  }
  
  public void a()
  {
    VasWebviewUtil.a(this.g.d.getCurrentUin(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", a(this.b));
  }
  
  public void a(FontBubblePanelView<T>.FontBubbleHolder paramFontBubblePanelView, FontBubble paramFontBubble)
  {
    if (paramFontBubble.viewType == 1)
    {
      Drawable localDrawable1;
      try
      {
        if (TextUtils.isEmpty(paramFontBubble.picUrl)) {
          localObject = this.e.a(paramFontBubble);
        } else {
          localObject = paramFontBubble.picUrl;
        }
        Object localObject = new URL("protocol_vas_extension_image", "FONT_BUBBLE", (String)localObject);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable2 = this.j;
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
      paramFontBubblePanelView.a.setScaleType(ImageView.ScaleType.FIT_XY);
      paramFontBubblePanelView.a.setImageDrawable(localDrawable1);
      a(paramFontBubblePanelView.c, paramFontBubble.feeType);
      int m = AIOUtils.b(0.7F, getResources());
      paramFontBubblePanelView.b.setPadding(0, m, 0, 0);
      paramFontBubblePanelView.b.setText(paramFontBubble.name);
    }
    else
    {
      paramFontBubblePanelView.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramFontBubblePanelView.a.setImageResource(2130849049);
      paramFontBubblePanelView.c.setVisibility(8);
      paramFontBubblePanelView.b.setVisibility(8);
    }
    paramFontBubblePanelView.a.setImageScale(0.92F, 0.0F);
    paramFontBubblePanelView.a.setTag(paramFontBubble);
    paramFontBubblePanelView.a.setBackgroundDrawable(this.j);
    paramFontBubblePanelView.a.setOnClickListener(this);
    paramFontBubblePanelView.a.setRoundRect(AIOUtils.b(5.0F, getResources()));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g.d.addObserver(this.l);
      Object localObject = a;
      int m = this.b;
      if (localObject[m] == 0)
      {
        localObject[m] = 1;
        localObject = (ISVIPHandler)this.g.d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        this.e.a((ISVIPHandler)localObject);
      }
    }
    else
    {
      this.g.d.removeObserver(this.l);
    }
  }
  
  public String getName()
  {
    int m;
    if (this.b == 3) {
      m = 2131902679;
    } else {
      m = 2131902678;
    }
    return HardCodeUtil.a(m);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433564)
    {
      Object localObject = (FontBubble)paramView.getTag();
      long l1;
      if (((FontBubble)localObject).viewType == 1)
      {
        if (this.g.Y.getText().length() > 0)
        {
          l1 = SystemClock.uptimeMillis();
          if (this.c + 1000L < l1) {
            this.f.a((FontBubble)localObject);
          }
          this.c = l1;
        }
        int m;
        if (this.b == 3) {
          m = ((FontBubble)localObject).fontId;
        } else {
          m = ((FontBubble)localObject).bubbleId;
        }
        VasWebviewUtil.a(this.g.d.getCurrentUin(), "aio_iconA", "Clickitem", "", 1, 0, 0, "", Integer.toString(m), a(this.b));
      }
      else
      {
        localObject = getContext();
        String str = VasWebviewUtil.b(this.e.a((Context)localObject), 39);
        if (this.b == 3) {
          l1 = 4096L;
        } else {
          l1 = 64L;
        }
        VasWebviewUtil.b((Context)localObject, str, l1, null, false, -1);
        VasWebviewUtil.a(this.g.d.getCurrentUin(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", a(this.b));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView
 * JD-Core Version:    0.7.0.1
 */