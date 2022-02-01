package com.tencent.mobileqq.hiboom;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomPanelView$HiBoomViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public HiBoomTextView a;
  public ImageView b;
  public SectorProgressView c;
  public ImageView d;
  public ImageView e;
  public ProgressBar f;
  public TextView g;
  public int h;
  public boolean i;
  
  public HiBoomPanelView$HiBoomViewHolder(HiBoomPanelView paramHiBoomPanelView, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.i = paramBoolean;
    if (paramBoolean)
    {
      this.a = ((HiBoomTextView)paramView.findViewById(2131435031));
      this.a.setLoadingScale(0.6F);
      this.b = ((ImageView)paramView.findViewById(2131435029));
      this.c = ((SectorProgressView)paramView.findViewById(2131435030));
      this.d = ((ImageView)paramView.findViewById(2131435026));
      this.e = ((ImageView)paramView.findViewById(2131435027));
      this.f = ((ProgressBar)paramView.findViewById(2131435024));
      this.g = ((TextView)paramView.findViewById(2131435028));
      paramView.setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    int k;
    if (this.c.getVisibility() == 0)
    {
      if (!this.c.c())
      {
        this.c.a();
        this.c.setProgress(0);
        k = this.j.g.a(this.h);
        HiBoomConstants.e.a(k);
      }
    }
    else
    {
      Object localObject2;
      Object localObject1;
      if (this.d.getVisibility() == 0)
      {
        if (this.j.g.a(this.h) == -1)
        {
          localObject2 = this.j.f.d.getCurrentUin();
          if (this.e.getVisibility() == 0) {
            localObject1 = "0";
          } else {
            localObject1 = "1";
          }
          VasWebviewUtil.a((String)localObject2, "HighFont", "ClickPlus", "", 1, 0, 0, "", "", (String)localObject1);
          this.e.setVisibility(8);
          this.j.f.d.getPreferences().edit().putBoolean("hiboom_red_dot_show", true).commit();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(IndividuationUrlHelper.a(this.j.getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store"));
          ((StringBuilder)localObject1).append("&haibao=1");
          localObject1 = ((StringBuilder)localObject1).toString();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("enter hiboom mall url = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("HiBoomFont.HiBoomPanelView", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = VasWebviewUtil.b((String)localObject1, 39);
          VasWebviewUtil.b(this.j.getContext(), (String)localObject1, 4096L, null, false, -1);
        }
      }
      else if (this.f.getVisibility() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomPanelView", 2, "dirty filter ");
        }
      }
      else if (HiBoomConstants.b.compareAndSet(false, true))
      {
        localObject1 = (ISVIPHandler)this.j.f.d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        localObject2 = ((IVasService)this.j.f.d.getRuntimeService(IVasService.class, "")).getHiBoomManager();
        k = this.j.g.a(this.h);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClick hiboomid = ");
          localStringBuilder.append(k);
          QLog.d("HiBoomFont.HiBoomPanelView", 2, localStringBuilder.toString());
        }
        if (((IHiBoomManager)localObject2).getRecommandHiBoomList().contains(Integer.valueOf(k))) {
          ((ISVIPHandler)localObject1).a(k, true, this.a.getText());
        } else {
          ((ISVIPHandler)localObject1).a(k, this.a.getText(), 2);
        }
        ReportController.b(this.j.f.d, "CliOper", "", "", "0X80094D7", "0X80094D7", 0, 0, "", "", "", "");
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick is sending");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomViewHolder
 * JD-Core Version:    0.7.0.1
 */