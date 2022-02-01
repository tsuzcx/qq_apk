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
  public int a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public HiBoomTextView a;
  public SectorProgressView a;
  public boolean a;
  public ImageView b;
  public ImageView c;
  
  public HiBoomPanelView$HiBoomViewHolder(HiBoomPanelView paramHiBoomPanelView, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)paramView.findViewById(2131368170));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setLoadingScale(0.6F);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368168));
      this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView = ((SectorProgressView)paramView.findViewById(2131368169));
      this.b = ((ImageView)paramView.findViewById(2131368165));
      this.c = ((ImageView)paramView.findViewById(2131368166));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368163));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368167));
      paramView.setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.getVisibility() == 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(0);
        i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(this.jdField_a_of_type_Int);
        HiBoomConstants.b.a(i);
      }
    }
    else
    {
      Object localObject2;
      Object localObject1;
      if (this.b.getVisibility() == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(this.jdField_a_of_type_Int) == -1)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin();
          if (this.c.getVisibility() == 0) {
            localObject1 = "0";
          } else {
            localObject1 = "1";
          }
          VasWebviewUtil.a((String)localObject2, "HighFont", "ClickPlus", "", 1, 0, 0, "", "", (String)localObject1);
          this.c.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getPreferences().edit().putBoolean("hiboom_red_dot_show", true).commit();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store"));
          ((StringBuilder)localObject1).append("&haibao=1");
          localObject1 = ((StringBuilder)localObject1).toString();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("enter hiboom mall url = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("HiBoomFont.HiBoomPanelView", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = VasWebviewUtil.a((String)localObject1, 39);
          VasWebviewUtil.b(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), (String)localObject1, 4096L, null, false, -1);
        }
      }
      else if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomPanelView", 2, "dirty filter ");
        }
      }
      else if (HiBoomConstants.a.compareAndSet(false, true))
      {
        localObject1 = (ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        localObject2 = ((IVasService)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getRuntimeService(IVasService.class, "")).getHiBoomManager();
        i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(this.jdField_a_of_type_Int);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClick hiboomid = ");
          localStringBuilder.append(i);
          QLog.d("HiBoomFont.HiBoomPanelView", 2, localStringBuilder.toString());
        }
        if (((IHiBoomManager)localObject2).getRecommandHiBoomList().contains(Integer.valueOf(i))) {
          ((ISVIPHandler)localObject1).a(i, true, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a());
        } else {
          ((ISVIPHandler)localObject1).a(i, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a(), 2);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "CliOper", "", "", "0X80094D7", "0X80094D7", 0, 0, "", "", "", "");
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick is sending");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomViewHolder
 * JD-Core Version:    0.7.0.1
 */