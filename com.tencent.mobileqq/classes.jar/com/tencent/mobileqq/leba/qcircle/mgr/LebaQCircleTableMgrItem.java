package com.tencent.mobileqq.leba.qcircle.mgr;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.leba.business.ILebaTableMgrItemBiz;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import com.tencent.mobileqq.studymode.StudyModeManager;
import common.config.service.QzoneConfig;
import java.util.List;

public class LebaQCircleTableMgrItem
  implements ILebaTableMgrItemBiz
{
  public RecyclerView.ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 3)
    {
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131561306, paramViewGroup, false);
      paramViewGroup.setTag(2131370251, Integer.valueOf(paramInt));
      return new LebaQCircleTableMgrItem.SwitchBtnViewHolder(paramContext, paramViewGroup, paramBoolean);
    }
    return null;
  }
  
  public void a(Context paramContext, List<LebaMgrViewItem> paramList)
  {
    if (paramList == null) {}
    while ((!QzoneConfig.isQQCircleShowLebaEntrance(StudyModeManager.a())) || (!QzoneConfig.isQQCircleShowSwitchButton())) {
      return;
    }
    LebaMgrViewItem localLebaMgrViewItem = new LebaMgrViewItem();
    localLebaMgrViewItem.jdField_a_of_type_Int = 3;
    localLebaMgrViewItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131719715);
    localLebaMgrViewItem.b = 2130845617;
    paramList.add(localLebaMgrViewItem);
  }
  
  public boolean a(RecyclerView.ViewHolder paramViewHolder, LebaMgrViewItem paramLebaMgrViewItem, Context paramContext, boolean paramBoolean)
  {
    if ((paramViewHolder instanceof LebaQCircleTableMgrItem.SwitchBtnViewHolder))
    {
      ((LebaQCircleTableMgrItem.SwitchBtnViewHolder)paramViewHolder).a(paramLebaMgrViewItem, paramContext, paramBoolean);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem
 * JD-Core Version:    0.7.0.1
 */