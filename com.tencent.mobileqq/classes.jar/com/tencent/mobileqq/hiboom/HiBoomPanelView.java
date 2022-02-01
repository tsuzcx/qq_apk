package com.tencent.mobileqq.hiboom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomPanelView
  extends RichTextPanelView
  implements Handler.Callback
{
  public static final String a = HardCodeUtil.a(2131903460);
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  BaseChatPie f = null;
  HiBoomPanelView.HiBoomAdapter g = null;
  GridLayoutManager h;
  RichTextPanelRecyclerView i;
  RichTextPanelExtendHelper j;
  public Handler k = null;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = localResources.getDisplayMetrics().widthPixels / 4;
    b = c;
    d = AIOUtils.b(2.0F, localResources);
    e = AIOUtils.b(11.0F, localResources);
  }
  
  public HiBoomPanelView(Context arg1, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(???);
    this.f = paramBaseChatPie;
    this.k = new Handler(this);
    setClipToPadding(false);
    this.j = paramRichTextPanelExtendHelper;
    b();
    paramBaseChatPie = ((IVasService)this.f.d.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    synchronized (paramBaseChatPie.getHandlerLock())
    {
      paramBaseChatPie.setListUIHandler(this.k);
      return;
    }
  }
  
  HiBoomPanelView.HiBoomViewHolder a(int paramInt)
  {
    int n = this.h.findFirstVisibleItemPosition();
    int i1 = this.h.findLastVisibleItemPosition();
    int m = n;
    while (m <= i1)
    {
      Object localObject = this.h.getChildAt(m - n);
      if (localObject != null)
      {
        localObject = this.i.getChildViewHolder((View)localObject);
        if ((localObject instanceof HiBoomPanelView.HiBoomViewHolder))
        {
          localObject = (HiBoomPanelView.HiBoomViewHolder)localObject;
          if (this.g.a(((HiBoomPanelView.HiBoomViewHolder)localObject).h) == paramInt) {
            return localObject;
          }
        }
      }
      m += 1;
    }
    return null;
  }
  
  public void a()
  {
    IHiBoomManager localIHiBoomManager = ((IVasService)this.f.d.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    if (!localIHiBoomManager.isHiBoomListInit())
    {
      localIHiBoomManager.getHiBoomListFromServer();
      return;
    }
    this.g.a(localIHiBoomManager.getValidHiBoomList(), localIHiBoomManager.getInvalidHiBoomList(), localIHiBoomManager.getRecommandHiBoomList());
  }
  
  void a(HiBoomPanelView.HiBoomViewHolder paramHiBoomViewHolder, int paramInt)
  {
    if (!paramHiBoomViewHolder.i) {
      return;
    }
    if (paramInt == -1)
    {
      paramHiBoomViewHolder.itemView.setContentDescription(HardCodeUtil.a(2131903463));
      paramHiBoomViewHolder.g.setVisibility(8);
      paramHiBoomViewHolder.f.setVisibility(8);
      paramHiBoomViewHolder.c.setVisibility(8);
      paramHiBoomViewHolder.b.setVisibility(8);
      paramHiBoomViewHolder.a.setVisibility(8);
      paramHiBoomViewHolder.d.setVisibility(0);
      paramHiBoomViewHolder.d.setImageResource(2130849049);
      if (!this.f.d.getPreferences().getBoolean("hiboom_red_dot_show", false))
      {
        paramHiBoomViewHolder.e.setVisibility(0);
        return;
      }
      paramHiBoomViewHolder.e.setVisibility(8);
      return;
    }
    paramHiBoomViewHolder.d.setVisibility(8);
    paramHiBoomViewHolder.e.setVisibility(8);
    Object localObject1 = ((IVasService)this.f.d.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    if (HiBoomConstants.c.get())
    {
      paramHiBoomViewHolder.f.setVisibility(8);
      HiBoomItem localHiBoomItem = ((IHiBoomManager)localObject1).getHiBoomItemById(paramInt);
      if (((IHiBoomManager)localObject1).getInvalidHiBoomList().contains(Integer.valueOf(paramInt)))
      {
        paramHiBoomViewHolder.c.a = false;
        paramHiBoomViewHolder.g.setVisibility(0);
        paramHiBoomViewHolder.g.setBackgroundResource(2130849055);
        paramHiBoomViewHolder.g.setText(HardCodeUtil.a(2131903459));
      }
      else if (((IHiBoomManager)localObject1).getRecommandHiBoomList().contains(Integer.valueOf(paramInt)))
      {
        paramHiBoomViewHolder.c.a = false;
        paramHiBoomViewHolder.g.setVisibility(0);
        paramHiBoomViewHolder.g.setBackgroundResource(2130849054);
        paramHiBoomViewHolder.g.setText(HardCodeUtil.a(2131903461));
      }
      else
      {
        paramHiBoomViewHolder.c.a = true;
        paramHiBoomViewHolder.g.setVisibility(8);
      }
      if (localHiBoomItem.f)
      {
        localObject1 = paramHiBoomViewHolder.itemView;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localHiBoomItem.b);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131903458));
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        paramHiBoomViewHolder.c.setVisibility(8);
        paramHiBoomViewHolder.b.setVisibility(8);
        paramHiBoomViewHolder.a.setVisibility(0);
        paramHiBoomViewHolder.a.setHiBoom(localHiBoomItem.a, 0, HiBoomConstants.e);
        localObject2 = HiBoomConstants.a(this.f.Y.getText().toString());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localHiBoomItem.b;
        }
        paramHiBoomViewHolder.a.setText((CharSequence)localObject1);
        return;
      }
      paramHiBoomViewHolder.itemView.setContentDescription(HardCodeUtil.a(2131903462));
      paramHiBoomViewHolder.c.setVisibility(0);
      paramHiBoomViewHolder.b.setVisibility(0);
      paramHiBoomViewHolder.a.setVisibility(8);
      if (localHiBoomItem.g != null) {
        paramHiBoomViewHolder.b.setImageBitmap(localHiBoomItem.g);
      } else {
        paramHiBoomViewHolder.b.setImageResource(2130849050);
      }
      if (localHiBoomItem.k)
      {
        paramHiBoomViewHolder.c.a();
        paramHiBoomViewHolder.c.setProgress(localHiBoomItem.j);
        return;
      }
      paramHiBoomViewHolder.c.b();
      return;
    }
    paramHiBoomViewHolder.f.setVisibility(0);
    paramHiBoomViewHolder.c.setVisibility(8);
    paramHiBoomViewHolder.b.setVisibility(8);
    paramHiBoomViewHolder.a.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    IHiBoomManager localIHiBoomManager = ((IVasService)this.f.d.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel visible");
      }
      synchronized (localIHiBoomManager.getHandlerLock())
      {
        localIHiBoomManager.setListUIHandler(this.k);
        a();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "hiboom panel gone");
    }
    synchronized (localObject1.getHandlerLock())
    {
      localObject1.setListUIHandler(null);
      return;
    }
  }
  
  @TargetApi(9)
  public void b()
  {
    this.i = new RichTextPanelRecyclerView(getContext());
    this.i.setOverScrollMode(2);
    this.h = new GridLayoutManager(getContext(), 4);
    this.i.setLayoutManager(this.h);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.i, localLayoutParams);
    this.g = new HiBoomPanelView.HiBoomAdapter(this);
    this.i.setAdapter(this.g);
    this.i.setPanelExtendHelper(this.j);
  }
  
  public String getName()
  {
    return a;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m == 3)
        {
          m = paramMessage.arg1;
          paramMessage = a(m);
          if (paramMessage != null) {
            a(paramMessage, m);
          }
        }
      }
      else
      {
        HiBoomPanelView.HiBoomViewHolder localHiBoomViewHolder = a(paramMessage.arg1);
        if (localHiBoomViewHolder != null) {
          localHiBoomViewHolder.c.setProgress(paramMessage.arg2);
        }
      }
    }
    else {
      a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView
 * JD-Core Version:    0.7.0.1
 */